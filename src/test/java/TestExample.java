/**
 * Copyright (c) www.bugull.com
 */

import com.looty.utils.EncryptUtils;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.Base64;
import java.util.Collections;
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

    @Test
    public void test3() {
        String s = EncryptUtils.bytesToHexString("你好".getBytes());
        System.out.println(s);
    }


    @Test
    public void test4() {
        Integer[][] operate = {{0, 2}, {1, 3}};
        System.out.println(operate[0][0]);
    }
}
