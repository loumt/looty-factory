/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.dao.UserDao;
import com.looty.enums.ResultMsgEnum;
import com.looty.pojo.system.ResultMsg;
import com.looty.pojo.User;
import com.looty.service.UserService;
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
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public boolean checkLoginInfo(String username, String password) {
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            return false;
        }
        User user = userDao.getUserByName(username);
        if (null == user || !user.getPassword().equals(password)) {
            return false;
        }
        return true;
    }

    public synchronized ResultMsg register(User user) {
        ResultMsg resultMsg = null;
        if (this.checkUserExist(user)) {
            resultMsg = ResultMsg.isFail(ResultMsgEnum.ALREADY_EXIST);
        } else {
            //注册
            resultMsg = ResultMsg.isSuccess(ResultMsgEnum.SUCCESS, userDao.saveUser(user));
        }
        return resultMsg;
    }

    public int count() {
        return userDao.count();
    }

    public ResultMsg getUserList() {
        List<User> users = userDao.getList();
        return ResultMsg.isSuccess(users);
    }

    private boolean checkUserExist(User user) {
        return false;
    }
}
