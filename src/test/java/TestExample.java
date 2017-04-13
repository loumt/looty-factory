/**
 * Copyright (c) www.bugull.com
 */

import com.looty.enums.HttpMethodEnum;
import com.looty.pojo.WeiBoResource;
import com.looty.property.SystemPropertyConfig;
import com.looty.utils.EncryptUtils;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.math.IEEE754rUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

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

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, 5000L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5));

    }

    @Test
    public void test6() {
        try {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread start");
                }
            };
            TimeUnit.SECONDS.timedJoin(thread, 2L);

            TimeUnit.SECONDS.sleep(4L);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test7() {
        System.out.println(IEEE754rUtils.max(0.154d, 0.45783d, 5.183d, 0.0054d));
    }


    final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("11");
        }
    };
    final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(100);
    final ScheduledFuture future = schedule.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.SECONDS);


    enum Color {
        RED, GREEN, BLUE;

        private int count;

        public void increment() {
            count++;
        }

        public void print() {
            System.out.println("The count of " + name() + " is " + count);
        }
    }

    @Test
    public void test8() {

        Color.RED.print();
        Color.GREEN.print();
        Color.BLUE.print();
        System.out.println("=================");
        Color.RED.increment();
        Color.RED.print();
        Color.GREEN.print();
        Color.BLUE.print();
        System.out.println("=================");
        Color.BLUE.increment();
        Color.RED.print();
        Color.GREEN.print();
        Color.BLUE.print();
        System.out.println("=================");
        Color.GREEN.increment();
        Color.RED.print();
        Color.GREEN.print();
        Color.BLUE.print();

    }

}
