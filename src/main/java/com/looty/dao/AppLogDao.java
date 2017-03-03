package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.AppLog;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/2/17/017
 */
public interface AppLogDao {

    long insertOneAppLog(AppLog appLog) throws DaoException;

    long getAllCount();
}
