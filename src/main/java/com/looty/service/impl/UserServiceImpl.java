/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.dao.IUserDao;
import com.looty.enums.ResultMsgEnum;
import com.looty.exception.ServiceException;
import com.looty.pojo.User;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.IUserService;
import com.looty.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/8/008
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    public boolean checkLoginInfo(String username, String password) {
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            return false;
        }
        User user = userDao.getUserByName(username);
        return !(null == user || !user.getPassword().equals(password));
    }

    public ResultMsg register(User user) {
        ResultMsg resultMsg;
        if (user == null || StringUtil.isEmpty(user.getUsername()) || StringUtil.isEmpty(user.getPassword())) {
            return ResultMsg.isFail(ResultMsgEnum.INVALIDATE_PARAMETER);
        }
        synchronized (this) {
            User dbU = userDao.getUserByName(user.getUsername());
            if (dbU != null) {
                resultMsg = ResultMsg.isFail(ResultMsgEnum.ALREADY_EXIST);
            } else {
                long lid = userDao.insertUser(user);
                resultMsg = ResultMsg.isSuccess(ResultMsgEnum.SUCCESS, lid);
            }
        }
        return resultMsg;
    }

    public Long getUserCount() {
        return userDao.getCount();
    }

    public ResultMsg getUserList() {
        List<User> users = userDao.getUserPageList();
        Long count = userDao.getCount();
        return ResultMsg.isSuccess(users, count);
    }
}
