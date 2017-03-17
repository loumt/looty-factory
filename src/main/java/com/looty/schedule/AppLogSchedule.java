/**
 * Copyright (c) www.bugull.com
 */
package com.looty.schedule;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.schedule
 * @date 2017/2/17/017
 */
@Component
public class AppLogSchedule {

    private Logger logger = Logger.getLogger(AppLogSchedule.class);

    //    @Scheduled(cron = "0 0/10 *  * * ?")
    public void addAppLog() {
        System.out.println(111);
    }

}
