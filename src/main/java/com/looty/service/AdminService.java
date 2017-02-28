package com.looty.service;

import com.looty.exception.ServiceException;
import com.looty.pojo.Admin;
import com.looty.pojo.ResultMsg;

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
public interface AdminService {

    Admin getAdminByName(String username) throws ServiceException;

    long insertOneAdmin(Admin admin) throws ServiceException;

    int getAdminCount();

    Admin getAdminByUserId(String userId) throws ServiceException;

    ResultMsg addAdmin(Admin admin);

    List<Admin> getAllAdmins();

    ResultMsg existAdmin(String username);
}
