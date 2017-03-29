package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.MonitorInfo;
import com.looty.pojo.system.ResultMsg;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/17/017
 */
public interface IMonitorInfoDao {

    long saveInfo(MonitorInfo monitorInfo) throws DaoException;

    List<MonitorInfo> getList() throws DaoException;

    Long getCount() throws DaoException;

    List<MonitorInfo> getInfoPageList() throws DaoException;
}
