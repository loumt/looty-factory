/**
 * Copyright (c) www.bugull.com
 */

import com.looty.pojo.Admin;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Date;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package PACKAGE_NAME
 * @date 2017/2/12/012
 */
public class LogTest {
    private static Logger logger = LogManager.getLogger(LogTest.class);

    public static void main(String[] args) {
        logger.debug("你好啊");

        try {
            Admin admin = Admin.class.newInstance();
            admin.setId(1L);
            admin.setCreateTime(new Date());
            admin.setPassword("password");
            admin.setUsername("username");
            admin.setRole("system");
            admin.setRealName("真实姓名");
            admin.setAuthTop(0);
            admin.setLastOperationTime(new Date());
            System.out.println(admin);


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Assert.hasLength("hasLength");
        Assert.notEmpty(new ArrayList<Object>());

        System.out.println("11111");
    }
}
