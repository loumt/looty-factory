/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.dao.ISystemStatusLogDao;
import com.looty.exception.ServiceException;
import com.looty.pojo.SystemStatusLog;
import com.looty.service.ISystemStatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/3/003
 */
@Service
public class SystemStatusLogServiceImpl implements ISystemStatusLogService {

    @Autowired
    private ISystemStatusLogDao systemStatusLogDao;

    public long insertOneSystemStatusLog(SystemStatusLog systemStatusLog) throws ServiceException {
        return systemStatusLogDao.saveOneSystemStatusLog(systemStatusLog);
    }
}
