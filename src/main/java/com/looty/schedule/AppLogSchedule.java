/**
 * Copyright (c) www.bugull.com
 */
package com.looty.schedule;

import com.looty.enums.ModuleEnum;
import com.looty.enums.OperationTypeEnum;
import com.looty.exception.DaoException;
import com.looty.pojo.Admin;
import com.looty.pojo.AppLog;
import com.looty.service.AdminService;
import com.looty.service.AppLogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
    @Autowired
    private AppLogService appLogService;

    @Autowired
    private AdminService adminService;

    @Scheduled(cron = "0 0/1 *  * * ?")
    public void addAppLog() {
        int adminCount = adminService.getAdminCount();
        if (adminCount == 0) {
            System.out.println("管理员数量:" + adminCount + " 个,不可执行日志");
            logger.debug("管理员数量:" + adminCount + " 个,不可执行日志");
            return;
        }

        List<Admin> list = adminService.getAllAdmins();

        Admin defauleAdmin = list.get(new Random().nextInt(list.size()));
        System.out.println("日志管理员是:" + defauleAdmin);

        AppLog log = new AppLog();
        log.setAdminId(defauleAdmin.getUserId());

        String moduleName = ModuleEnum.ADMIN_MODULE.getName();
        switch (new Random().nextInt(4)) {
            case 0:
                moduleName = ModuleEnum.ADMIN_MODULE.getName();
                break;
            case 1:
                moduleName = ModuleEnum.LOG_MODULE.getName();
                break;
            case 2:
                moduleName = ModuleEnum.SYSTEM_MODULE.getName();
                break;
            case 3:
                moduleName = ModuleEnum.SYSTEM_MODULE.getName();
                break;
        }
        log.setModuleName(moduleName);
        log.setOperationTime(new Date());

        Integer code = OperationTypeEnum.DEFAULT.getCode();
        switch (new Random().nextInt(4)) {
            case 0:
                code = OperationTypeEnum.ADD.getCode();
                break;
            case 1:
                code = OperationTypeEnum.DELETE.getCode();
                break;
            case 2:
                code = OperationTypeEnum.UPDATE.getCode();
                break;
            case 3:
                code = OperationTypeEnum.SEARCH.getCode();
                break;
        }
        log.setOperationType(code);

        try {

            long i = appLogService.insertOneAppLog(log);

            System.out.println("插入数据库ID第 " + i + " 条记录日志");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
