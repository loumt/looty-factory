/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.dao.ISystemLogDao;
import com.looty.exception.ServiceException;
import com.looty.pojo.SystemStatusLog;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service.impl
 * @date 2017/3/21/021
 */
@Service
public class SystemLogServiceImpl implements ISystemLogService {
    @Autowired
    private ISystemLogDao systemLogDao;

    public ResultMsg getSysLogList() throws ServiceException {
        List<SystemStatusLog> systemStatuseLogs = systemLogDao.getSysLogPageList();
        Long count = systemLogDao.getCount();
        return ResultMsg.isSuccess(systemStatuseLogs, count);
    }
}
