/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service;

import com.looty.base.BaseService;
import com.looty.dao.AdminDao;
import com.looty.enums.ResultMsgEnum;
import com.looty.exception.ServiceException;
import com.looty.pojo.Admin;
import com.looty.pojo.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Admin getAdminByName(String username) throws ServiceException {
        return adminDao.getAdminByName(username);
    }

    public long insertOneAdmin(Admin admin) throws ServiceException {
        return adminDao.insertOneAdmin(admin);
    }

    public int getAdminCount() {
        return adminDao.getAdminCount();
    }

    public Admin getAdminByUserId(String userId) throws ServiceException {
        return adminDao.getAdminByUserId(userId);
    }

    public ResultMsg addAdmin(Admin admin) {
        long returnId = adminDao.insertOneAdmin(admin);
        return ResultMsg.isSuccess(ResultMsgEnum.SUCCESS, returnId);
    }

    public List<Admin> getAllAdmins() {
        return adminDao.getAdmins();
    }

    public ResultMsg existAdmin(String username) {
        Admin admin = getAdminByName(username);
        if (null == admin) {
            return ResultMsg.isSuccess(ResultMsgEnum.SUCCESS, admin);
        } else {
            return ResultMsg.isFail(ResultMsgEnum.ALREADY_EXIST);
        }
    }
}
