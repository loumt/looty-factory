/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao;

import com.looty.base.BaseDao;
import com.looty.exception.DaoException;
import com.looty.pojo.AppLog;
import org.springframework.stereotype.Repository;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.dao
 * @date 2017/2/17/017
 */
@Repository
public class AppLogDaoImpl extends BaseDao implements AppLogDao {


    private static final String APP_LOG_INSERT = "insert into app_log(moduleName,operationType,adminId,operationTime) values(:moduleName,:operationType,:adminId,:operationTime)";

    public long insertOneAppLog(AppLog appLog) throws DaoException {
        return this.saveBean(APP_LOG_INSERT, appLog);
    }
}
