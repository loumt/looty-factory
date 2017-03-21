/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao;

import com.looty.base.BaseDao;
import com.looty.pojo.MonitorInfo;
import com.looty.pojo.system.QueryPageModel;
import org.springframework.stereotype.Repository;

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
@Repository
public class MonitorInfoDaoImpl extends BaseDao implements MonitorInfoDao {


    private static final String SAVE_INFO = "insert into monitor_info(totalMemory,freeMemory,totalThread,availableProcessors,osName,hostAddress,userDomain,javaVersion,javaHome,javaVmName,createDate)values(:totalMemory,:freeMemory,:totalThread,:availableProcessors,:osName,:hostAddress,:userDomain,:javaVersion,:javaHome,:javaVmName,:createDate)";

    public long saveInfo(MonitorInfo monitorInfo) {
        return this.saveBean(SAVE_INFO, monitorInfo);
    }

    private static final String GET_LIST = "select * from monitor_info";

    public List<MonitorInfo> getList() {
        Integer pageNo = QueryPageModel.getPageNo() == null ? 1 : QueryPageModel.getPageNo();
        Integer pageSize = QueryPageModel.getPageSize();

        Integer pageOffset = (pageNo - 1) * pageSize;
        StringBuffer sb = new StringBuffer(GET_LIST);
        sb.append(" limit " + pageOffset + "," + pageSize);
        return super.queryForBeanList(sb.toString(), MonitorInfo.class);
    }
}
