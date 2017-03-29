/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao.impl;

import com.looty.base.BaseDao;
import com.looty.dao.ISystemStatusLogDao;
import com.looty.enums.SystemStatusEnum;
import com.looty.exception.DaoException;
import com.looty.pojo.SystemStatusLog;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/3/003
 */
@Repository
public class SystemStatusLogDaoImpl extends BaseDao implements ISystemStatusLogDao {


    private static final String SAVE_ONE_SYSTEM_STATUS_LOG = "insert into system_status_log(statusAction,operationTime,serverInfo,contextName) values(:statusAction,:operationTime,:serverInfo,:contextName)";

    public long saveOneSystemStatusLog(SystemStatusLog systemStatusLog) throws DaoException {
        return this.saveBean(SAVE_ONE_SYSTEM_STATUS_LOG, systemStatusLog);
    }

    public List<SystemStatusLog> getLogList() throws DaoException {
        return null;
    }

    public long getLogListCount() throws DaoException {
        return 0;
    }

    public List<SystemStatusLog> getLogList(Date sTime, Date eTime) throws DaoException {
        return null;
    }

    public long getLogListCount(Date sTime, Date eTime) throws DaoException {
        return 0;
    }

    public List<SystemStatusLog> getLogList(SystemStatusEnum statusEnum) throws DaoException {
        return null;
    }

    public long getLogListCount(SystemStatusEnum statusEnum) throws DaoException {
        return 0;
    }
}
