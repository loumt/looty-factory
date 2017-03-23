/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.dao.UserDao;
import com.looty.enums.ResultMsgEnum;
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
    private UserDao userDao;

    public boolean checkLoginInfo(String username, String password) {
        if (StringUtil.isEmpty(username) || StringUtil.isEmpty(password)) {
            return false;
        }
        User user = userDao.getUserByName(username);
        return !(null == user || !user.getPassword().equals(password));
    }

    public synchronized ResultMsg register(User user) {
        ResultMsg resultMsg = null;
        if (this.checkUserExist(user)) {
            resultMsg = ResultMsg.isFail(ResultMsgEnum.ALREADY_EXIST);
        } else {
            //注册
            resultMsg = ResultMsg.isSuccess(ResultMsgEnum.SUCCESS, userDao.insertUser(user));
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

    private boolean checkUserExist(User user) {
        return false;
    }
}
