package com.looty.dao;

import com.looty.pojo.User;

import java.util.List;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/8/008
 */
public interface UserDao {
    User getUserByName(String username);

    long saveUser(User user);

    int count();

    List<User> getList();
}
