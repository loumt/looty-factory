/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao;

import com.looty.base.BaseDao;
import com.looty.exception.DaoException;
import com.looty.pojo.SystemStatusLog;
import org.springframework.stereotype.Repository;

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
@Repository
public class SystemLogDaoImpl extends BaseDao implements ISystemLogDao {

    private static final String GET_COUNT = "select count(*) from system_status_log";

    public Long getCount() throws DaoException {
        return this.totalCount(GET_COUNT);
    }

    private static final String GET_SYS_LOG_PAGE_LIST = "select * from system_status_log order by operationTime desc";

    public List<SystemStatusLog> getSysLogPageList() throws DaoException {
        return this.queryForPageBeanList(GET_SYS_LOG_PAGE_LIST, SystemStatusLog.class);
    }
}
