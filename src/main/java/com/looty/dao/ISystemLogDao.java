package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.SystemStatusLog;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/21/021
 */
public interface ISystemLogDao {

    Long getCount() throws DaoException;

    List<SystemStatusLog> getSysLogPageList() throws DaoException;
}
