/**
 * Copyright (c) www.bugull.com
 */
package com.looty.schedule;

import com.looty.exception.ServiceException;
import com.looty.pojo.UserAuthCode;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.IUserAuthCodeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.repository.cdi.CdiBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.schedule
 * @date 2017/3/29/029
 */
@Component
public class AuthCodeSchdule {

    Logger logger = Logger.getLogger(AuthCodeSchdule.class);

    @Autowired
    private IUserAuthCodeService userAuthCodeService;

    @Scheduled(cron = "0 0/2 * * * *")
    public void removeAuthCode() {
        ResultMsg resultMsg = userAuthCodeService.getCodeInValid(new Date());

        if (resultMsg.getSuccess()) {
            long count = resultMsg.getCount();
            if (count != 0L) {
                List<UserAuthCode> codes = (List<UserAuthCode>) resultMsg.getData();
                for (UserAuthCode code : codes) {
                    userAuthCodeService.removeCode(code.getAuthCode());
                    logger.info("remove auth code :" + code.getAuthCode());
                }
            }
        } else {
            logger.error("IUserAuthCodeService getCodeInValid ERROR!");
        }

    }

}
