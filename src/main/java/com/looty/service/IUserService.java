package com.looty.service;

import com.looty.pojo.system.ResultMsg;
import com.looty.pojo.User;

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
public interface IUserService {
    boolean checkLoginInfo(String username, String password);

    ResultMsg register(User user);

    Long getUserCount();

    ResultMsg getUserList();
}
