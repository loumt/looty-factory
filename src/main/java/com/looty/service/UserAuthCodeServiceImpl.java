/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service;


import com.looty.config.SystemConfig;
import com.looty.dao.UserAuthCodeDao;
import com.looty.dao.UserDao;
import com.looty.enums.ResultMsgEnum;
import com.looty.pojo.User;
import com.looty.pojo.system.ResultMsg;
import com.looty.pojo.UserAuthCode;
import com.looty.utils.DateUtil;
import com.looty.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/7/007
 */
@Service
public class UserAuthCodeServiceImpl implements UserAuthCodeService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserAuthCodeDao userAuthCodeDao;


    public ResultMsg getAuthCode(String ip, String username) {
        User user = userDao.getUserByName(username);
        String userId = user.getUserId();

        UserAuthCode authCode = userAuthCodeDao.getAuthCodeByUsername(userId);
        //创建一个授权码
        if (authCode == null) {
            userAuthCodeDao.saveAuthCode(createNewAuthCode(ip, userId));
        }
        return ResultMsg.isSuccess(ResultMsgEnum.SUCCESS, authCode.getAuthCode());
    }

    private UserAuthCode createNewAuthCode(String ip, String userId) {
        String code = UUIDGenerator.getAuthCode(SystemConfig.MAX_AUTH_CODE_INVALID_DIGIT);
        Date now = new Date();
        UserAuthCode userAuthCode = new UserAuthCode();
        userAuthCode.setLastOperationIp(ip);
        userAuthCode.setCreateDate(now);
        userAuthCode.setUserId(userId);
        userAuthCode.setInValidData(DateUtil.dateTime(now, SystemConfig.MAX_AUTH_CODE_INVALID_DAYS));
        userAuthCode.setAuthCode(code);
        return userAuthCode;
    }

    public boolean checkAuthCode(String authCode) {
        UserAuthCode userAuthCode = userAuthCodeDao.getUserAuthCode(authCode);
        return userAuthCode != null;
    }
}
