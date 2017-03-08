package com.looty.service;

import com.looty.pojo.ResultMsg;
import com.looty.pojo.User;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/8/008
 */
public interface UserService {
    boolean checkLoginInfo(String username, String password);

    ResultMsg register(User user);
}
