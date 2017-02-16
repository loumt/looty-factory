/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service;

import com.looty.base.BaseService;
import com.looty.dao.AdminDao;
import com.looty.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/2/12/012
 */
@Service
public class AdminServiceImpl extends BaseService implements AdminService {

    @Autowired
    private AdminDao adminDao;

    public Admin getOneAdmin() {
        return adminDao.getAdmin();
    }
}
