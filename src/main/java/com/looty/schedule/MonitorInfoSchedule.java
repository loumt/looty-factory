/**
 * Copyright (c) www.bugull.com
 */
package com.looty.schedule;

import com.looty.exception.ScheduleException;
import com.looty.pojo.MonitorInfo;
import com.looty.service.IMonitorInfoService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

/**
 * USED TO:监控系统Info
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.schedule
 * @date 2017/3/17/017
 */
@Component
public class MonitorInfoSchedule {

    private Logger logger = LogManager.getLogger(MonitorInfoSchedule.class);

    @Autowired
    IMonitorInfoService monitorInfoService;

    @Scheduled(cron = "0 0/5 * * * ?")
    public void getMoinitorInfo() {

        try {
            MonitorInfo monitorInfo = monitorInfoService.getMonitorInfo();
            long info_id = monitorInfoService.saveInfo(monitorInfo);

        } catch (UnknownHostException e) {
            logger.error("MonitorInfoSchedule[getMoinitorInfo] MonitorInfo create error!");
            throw new ScheduleException("MonitorInfo create error!", e);
        }

    }
}
