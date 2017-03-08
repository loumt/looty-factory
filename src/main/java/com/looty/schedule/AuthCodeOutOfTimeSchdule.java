/**
 * Copyright (c) www.bugull.com
 */
package com.looty.schedule;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.schedule
 * @date 2017/3/8/008
 */
public class AuthCodeOutOfTimeSchdule {

    private Logger logger = Logger.getLogger(AppLogSchedule.class);


    @Scheduled(cron = "0 0 0/1  * * ?")
    public void addAppLog() {


    }

}
