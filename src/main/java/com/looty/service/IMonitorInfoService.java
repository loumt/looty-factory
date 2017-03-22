package com.looty.service;

import com.looty.exception.ServiceException;
import com.looty.pojo.MonitorInfo;
import com.looty.pojo.system.ResultMsg;

import java.net.UnknownHostException;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.service
 * @date 2017/3/17/017
 */
public interface IMonitorInfoService {

    /**
     * 获取系统参数
     *
     * @return
     * @throws ServiceException
     */
    MonitorInfo getMonitorInfo() throws ServiceException, UnknownHostException;


    /**
     * 保存记录
     *
     * @param monitorInfo
     * @return
     * @throws ServiceException
     */
    long saveInfo(MonitorInfo monitorInfo) throws ServiceException;

    /**
     * 获取系统列表
     *
     * @return
     */
    ResultMsg getInfoList() throws ServiceException;
}
