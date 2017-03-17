/**
 * Copyright (c) www.bugull.com
 */

import com.looty.schedule.AppLogSchedule;
import com.looty.service.AppLogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package PACKAGE_NAME
 * @date 2017/3/13/013
 */
public class DbTest extends AbstractTest {

    @Autowired
    private AppLogService appLogService;

    @Test
    public void mapList() {
        Map<String, String> hashMap = new HashMap<String, String>() {
            {
                put("name", "哈哈");
                put("name1", "哈哈1");
                put("name2", "哈哈2");
                put("name3", "哈哈3");
                put("name4", "哈哈4");
            }
        };

        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + hashMap.get(key));
        }
    }

    @Test
    public void mapTest() {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> cMap = new ConcurrentHashMap<String, String>();
        System.out.println(3 << 2);
    }

    @Test
    public void test2() {
        if (appLogService == null) {
            System.out.println(1);
        } else {
            System.out.println("COUNT:" + appLogService.getAllCount());
        }
    }
}
