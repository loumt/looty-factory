/**
 * Copyright (c) www.bugull.com
 */

import com.looty.pojo.Admin;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

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

    @Test
    public void test1() {
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
//        Assert.notEmpty(new ArrayList<Object>());

        System.out.println("======================");


        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list1.add("g");
        list1.add("s");
        list1.add("a");
        list1.add("f");

        list2.add("g");
        list2.add("c");
        list2.add("b");
        list2.add("a");
        list1.retainAll(list2);
        System.out.print(list1);
        System.out.println("======================");

        System.out.println(UUID.randomUUID());

    }


    @Test
    public void dateTest() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        try {
            Date date = format.parse("20170101 12:15:12");

            System.out.println("Result：" + new Date().after(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
