/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao;

import com.looty.base.BaseDao;
import com.looty.exception.DaoException;
import com.looty.pojo.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/2/12/012
 */
@Repository
public class AdminDaoImpl extends BaseDao implements AdminDao {

    private static final String GET_ADMIN = "SELECT * FROM admin";

    public List<Admin> getAdmins() throws DaoException {
        return this.queryForBeanList(GET_ADMIN, Admin.class);
    }

    private static final String INSERT_ONE_ADMIN = "insert into admin(userId,role,username,password,realName,createTime,lastOperationTime,authTop)values(:userId,:role,:username,:password,:realName,:createTime,:lastOperationTime,:authTop)";

    public long insertOneAdmin(Admin admin) throws DaoException {
        return this.saveBean(INSERT_ONE_ADMIN, admin);
    }


    private static final String GET_ADMIN_COUNT = "select count(*) from admin";

    public int getAdminCount() {
        return this.queryForInteger(GET_ADMIN_COUNT);
    }


    private static final String GET_ADMIN_BY_USER_ID = "select * from admin where userId = ?";

    public Admin getAdminByUserId(String userId) {
        Object[] args = {userId};
        return this.queryForObject(GET_ADMIN_BY_USER_ID, Admin.class, args);
    }

    private static final String GET_ADMIN_BY_NAME = "select * from admin where username = ?";

    public Admin getAdminByName(String username) {
        return this.queryForBean(GET_ADMIN_BY_NAME, Admin.class);
    }

}
