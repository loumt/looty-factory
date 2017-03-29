/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.base.BaseService;
import com.looty.dao.IManageLogDao;
import com.looty.exception.ServiceException;
import com.looty.pojo.ManageLog;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.IManageLogService;
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
 * @date 2017/2/17/017
 */
@Service
public class ManageLogServiceImpl extends BaseService implements IManageLogService {

    @Autowired
    private IManageLogDao manageLogDao;

    public long insertLog(ManageLog bean) throws ServiceException {
        return manageLogDao.insert(bean);
    }

    public void deleteById(Long manLogId) {

    }

    public long getCount() {
        return manageLogDao.count();
    }

    public ResultMsg getManLogList() {
        List<ManageLog> logs = manageLogDao.list();
        long count = manageLogDao.count();
        return ResultMsg.isSuccess(logs, count);
    }
}
