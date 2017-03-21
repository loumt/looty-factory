/**
 * Copyright (c) www.bugull.com
 */

import com.looty.utils.DateUtil;
import org.junit.Test;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package PACKAGE_NAME
 * @date 2017/3/2/002
 */

public class TestExample {
    @Test
    public void test1() {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> resuleMap = Collections.synchronizedMap(map);

    }

    @Test
    public void test2() {
        Map<String, String> map = new HashMap<String, String>(5);

        for (int i = 0; i < 50; i++) {
            long s = System.currentTimeMillis();

            map.put("one" + i, "teo" + i);

            long e = System.currentTimeMillis();

            System.out.println("Map PUT " + i + " COUNT,TIME:" + (e - s));
        }
    }
}
