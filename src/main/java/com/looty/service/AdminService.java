package com.looty.service;

import com.looty.exception.ServiceException;
import com.looty.pojo.Admin;

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
    /**
     * @return
     */
    List<Admin> getOneAdmin() throws ServiceException;

    long insertOneAdmin(Admin admin) throws ServiceException;

    int getAdminCount();
}
