/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;


import com.looty.config.SystemConfig;
import com.looty.dao.IUserAuthCodeDao;
import com.looty.dao.IUserDao;
import com.looty.enums.ResultMsgEnum;
import com.looty.exception.ServiceException;
import com.looty.pojo.User;
import com.looty.pojo.UserAuthCode;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.IUserAuthCodeService;
import com.looty.utils.DateUtil;
import com.looty.utils.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
public class UserAuthCodeServiceImpl implements IUserAuthCodeService {


    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserAuthCodeDao userAuthCodeDao;


    public ResultMsg getAuthCode(String ip, String username) throws ServiceException {
        User user = userDao.getUserByName(username);
        String userId = user.getUserId();

        UserAuthCode authCode = userAuthCodeDao.getAuthCodeByUsername(userId);
        //创建一个授权码
        if (authCode == null) {
            authCode = createNewAuthCode(ip, userId);
            userAuthCodeDao.saveAuthCode(authCode);
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
        userAuthCode.setInValidDate(DateUtil.minute(now, SystemConfig.MAX_AUTH_CODE_INVALID_DAYS));
        userAuthCode.setAuthCode(code);
        return userAuthCode;
    }

    public boolean checkAuthCode(String authCode) {
        UserAuthCode userAuthCode = userAuthCodeDao.getUserAuthCode(authCode);
        return userAuthCode != null;
    }

    public ResultMsg getAuthList() {
        List<UserAuthCode> users = userAuthCodeDao.getAuthPageList();
        Long count = userAuthCodeDao.getCount();
        return ResultMsg.isSuccess(users, count);
    }

    public ResultMsg removeCode(String code) throws ServiceException {
        userAuthCodeDao.remove(code);
        return ResultMsg.isCommonSuccess();
    }

    public ResultMsg getCodeInValid(Date date) {
        List<UserAuthCode> codes = userAuthCodeDao.inValidCode(date);
        return ResultMsg.isSuccess(codes, (long) codes.size());
    }
}
