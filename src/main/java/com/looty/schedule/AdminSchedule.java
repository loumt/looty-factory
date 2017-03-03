/**
 * Copyright (c) www.bugull.com
 */
package com.looty.schedule;

import com.looty.enums.RoleEnum;
import com.looty.pojo.Admin;
import com.looty.service.AdminService;
import com.looty.utils.UUIDGenerator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.schedule
 * @date 2017/2/20/020
 */
@Component
public class AdminSchedule {

    private Logger logger = Logger.getLogger(AdminSchedule.class);

    private static final int ADMIN_MAX_AMOUNT = 25;

    @Autowired
    private AdminService adminService;

    @Scheduled(cron = "0 0/10 9-18 * * ?")
    public void inserAdmin() {
        int adminCount = adminService.getAdminCount();
        if (adminCount >= ADMIN_MAX_AMOUNT) {
            System.out.println("管理员数量:" + adminCount + " 个,容量上限");
            logger.debug("管理员数量:" + adminCount + " 个,容量上限");
            return;
        }
        System.out.println("管理员数量:" + adminCount + " 个,正在创建" + (adminCount + 1) + " 个");

        Admin admin = new Admin();
        //遇到一个假的管理员
        admin.setUserId(UUIDGenerator.getUUID());
        admin.setAuthTop(new Random().nextInt(2));
        admin.setLastOperationTime(new Date());
        admin.setRealName("管理" + String.valueOf(System.currentTimeMillis()).substring(0, 6));

        RoleEnum roleEnum = RoleEnum.DEFAULT;
        switch (new Random().nextInt(7)) {
            case 1:
                roleEnum = RoleEnum.ADMIN;
                break;
            case 2:
                roleEnum = RoleEnum.P_MANAGER;
                break;
            case 3:
                roleEnum = RoleEnum.CUSTOMER;
                break;
            case 4:
                roleEnum = RoleEnum.OPERATOR;
                break;
            case 5:
                roleEnum = RoleEnum.MANAGER;
                break;
            case 6:
                roleEnum = RoleEnum.SALES;
                break;
        }
        admin.setRole(roleEnum.getRoleName());

        admin.setCreateTime(new Date());
        admin.setPassword("admin" + String.valueOf(System.currentTimeMillis()).substring(0, 6));
        admin.setUsername("12345" + String.valueOf(System.currentTimeMillis()).substring(0, 6));

        try {
            long l = adminService.insertOneAdmin(admin);

            logger.debug("第" + l + " 个Admin创建");
        } catch (Exception ex) {


            System.out.println(ex.getMessage());
        }


    }

}
