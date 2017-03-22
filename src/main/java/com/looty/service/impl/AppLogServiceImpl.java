/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.base.BaseService;
import com.looty.dao.AppLogDao;
import com.looty.exception.ServiceException;
import com.looty.pojo.AppLog;
import com.looty.service.IAppLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/2/17/017
 */
@Service
public class AppLogServiceImpl extends BaseService implements IAppLogService {

    @Autowired
    private AppLogDao appLogDao;

    public long insertOneAppLog(AppLog bean) throws ServiceException {
        return appLogDao.insertOneAppLog(bean);
    }

    public void deleteOneAppLog(Long appLogId) {

    }

    public long getAllCount() {
        return appLogDao.getAllCount();
    }
}
