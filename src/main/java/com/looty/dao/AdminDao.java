package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.Admin;

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
public interface AdminDao {
    List<Admin> getAdmin() throws DaoException;

    long insertOneAdmin(Admin admin) throws DaoException;

    int getAdminCount();
}
