package com.looty.dao;

import com.looty.enums.SystemStatusEnum;
import com.looty.exception.DaoException;
import com.looty.pojo.SystemStatusLog;

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
public interface SystemStatusLogDao {

    long saveOneSystemStatusLog(SystemStatusLog systemStatusLog) throws DaoException;

    List<SystemStatusLog> getLogList() throws DaoException;

    long getLogListCount() throws DaoException;

    List<SystemStatusLog> getLogList(Date sTime, Date eTime) throws DaoException;

    long getLogListCount(Date sTime, Date eTime) throws DaoException;

    List<SystemStatusLog> getLogList(SystemStatusEnum statusEnum) throws DaoException;

    long getLogListCount(SystemStatusEnum statusEnum) throws DaoException;
}
