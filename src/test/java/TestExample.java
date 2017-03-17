/**
 * Copyright (c) www.bugull.com
 */

import com.looty.utils.DateUtil;
import org.junit.Test;

import java.util.Date;

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
        String date = DateUtil.date(new Date());
        System.out.println(date);
    }

    @Test
    public void test2() {
    }
}
