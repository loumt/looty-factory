/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao.impl;

import com.looty.base.BaseDao;
import com.looty.dao.IUserDao;
import com.looty.exception.DaoException;
import com.looty.pojo.User;
import org.springframework.stereotype.Repository;

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
@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {

    private static final String GET_USER_BY_NAME = "select * from user where username = ?";

    public User getUserByName(String username) throws DaoException {
        Object[] args = {username};
        return this.queryForBean(GET_USER_BY_NAME, User.class, args);
    }

    private static final String SAVE_USER = "insert into user(userId,username,password,createTime,lastOperationTime,roleCode,realName,authTop)values(:userId,:username,:password,:createTime,:lastOperationTime,:roleCode,:realName,:authTop)";

    public long insertUser(User user) throws DaoException {
        return this.saveBean(SAVE_USER, user);
    }

    private static final String COUNT = "select count(*) from user";

    public Long getCount() throws DaoException {
        return this.totalCount(COUNT);
    }

    private static final String GET_USER_LIST = "select * from user";

    public List<User> getUserList() throws DaoException {
        return super.queryForBeanList(GET_USER_LIST, User.class);
    }

    private static final String GET_USER_PAGE_LIST = "select * from user order by createTime desc";

    public List<User> getUserPageList() throws DaoException {
        return super.queryForPageBeanList(GET_USER_PAGE_LIST, User.class);
    }

    private static final String GET_USER_BY_USER_ID = "select * from user where userId = ?";

    public User getUserByUid(String userId) {
        Object[] args = {userId};
        return this.queryForBean(GET_USER_BY_USER_ID, User.class, args);
    }

    private static final String GET_USERS_BY_ROLE_CODE = "select * from user where roleCode = ?";
    public User getUserByRoleCode(String roleCode) {
        Object[] args = {roleCode};
        return this.queryForBean(GET_USERS_BY_ROLE_CODE, User.class, args);
    }

}
