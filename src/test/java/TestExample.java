/**
 * Copyright (c) www.bugull.com
 */

import com.looty.utils.EncryptUtils;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.*;

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

    @Test
    public void test5() {
        List<Long> ids = new ArrayList<Long>() {{
            add(5L);
            add(12L);
            add(52L);
            add(51L);
            add(15L);
            add(35L);
            add(45L);
            add(32L);
            add(52L);
            add(85L);
        }};
        Iterator<Long> iterator = ids.iterator();

        StringBuffer sb = new StringBuffer();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(",");
            }
        }

        System.out.println(sb.toString());

    }

    @Test
    public void mapTest() {
        //-128--127之间
        Integer i1 = new Integer(100);
        Integer i2 = 100;

        if (i1 == i2) {
            System.out.println("i1 == i2");
        } else {
            System.out.println("i1 != i2 ");
        }

        //大于127
        Integer i3 = 200;
        Integer i4 = 200;

        if (i3 == i4) {
            System.out.println("i3 == i4");
        } else {
            System.out.println("i3 != i4 ");
        }
    }
}
