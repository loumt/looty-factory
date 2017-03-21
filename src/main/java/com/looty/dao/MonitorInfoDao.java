package com.looty.dao;

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
public interface MonitorInfoDao {

    long saveInfo(MonitorInfo monitorInfo);

    List<MonitorInfo> getList();
}
