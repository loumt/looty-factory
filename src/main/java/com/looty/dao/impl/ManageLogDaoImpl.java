/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao.impl;

import com.looty.base.BaseDao;
import com.looty.dao.IManageLogDao;
import com.looty.exception.DaoException;
import com.looty.pojo.ManageLog;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public class ManageLogDaoImpl extends BaseDao implements IManageLogDao {


    private static final String MAN_LOG_INSERT = "insert into manage_log(moduleName,operationType,adminId,operationTime) values(:moduleName,:operationType,:adminId,:operationTime)";

    public long insert(ManageLog manageLog) throws DaoException {
        return this.saveBean(MAN_LOG_INSERT, manageLog);
    }


    private static final String GET_ALL_COUNT = "select count(*) from manage_log";

    public long count() {
        return this.queryForInteger(GET_ALL_COUNT);
    }


    private static final String LIST = "select * from manage_log order by operationTime desc";

    public List<ManageLog> list() throws DaoException {
        return this.queryForPageBeanList(LIST, ManageLog.class);
    }
}
