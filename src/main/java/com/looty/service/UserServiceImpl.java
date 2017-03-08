/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service;

import com.looty.dao.UserDao;
import com.looty.enums.ResultMsgEnum;
import com.looty.pojo.ResultMsg;
import com.looty.pojo.User;
import com.looty.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            long id = userDao.saveUser(user);
        }
        return null;
    }

    private boolean checkUserExist(User user) {
        return false;
    }
}
