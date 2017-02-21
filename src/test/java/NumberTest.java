/**
 * Copyright (c) www.bugull.com
 */

import org.junit.Test;

import java.util.Random;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package PACKAGE_NAME
 * @date 2017/2/20/020
 */
public class NumberTest {


    @Test
    public void numberT() {
        for (int i = 0; i < 20; i++) {
            System.out.println(new Random().nextInt(2));
        }
    }
}
