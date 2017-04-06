package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.User;

import java.util.Date;
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
public interface IUserDao {

    User getUserByName(String username) throws DaoException;

    long insertUser(User user) throws DaoException;

    Long getCount() throws DaoException;

    List<User> getUserList() throws DaoException;

    List<User> getUserPageList() throws DaoException;

    User getUserByUid(String userId) throws DaoException;

    User getUserByRoleCode(String roleCode) throws DaoException;

}
