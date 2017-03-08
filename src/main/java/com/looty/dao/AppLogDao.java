package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.AppLog;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/3/8/008
 */
public interface AppLogDao {

    long insertOneAppLog(AppLog appLog) throws DaoException;

    long getAllCount() throws DaoException;
}
