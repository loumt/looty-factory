/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao;

import com.looty.base.BaseDao;
import com.looty.pojo.Admin;
import org.springframework.stereotype.Repository;

import java.util.Map;

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

    public Admin getAdmin() {
        Admin admin = super.queryForBean("SELECT * FROM admin", Admin.class);
        return admin;
    }
}
