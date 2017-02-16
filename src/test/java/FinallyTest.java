/**
 * Copyright (c) www.bugull.com
 */

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package PACKAGE_NAME
 * @date 2017/2/12/012
 */
public class FinallyTest {

    /**
     * try {}里有一个return语句,那么紧跟在这个try后的finally {}里的
     * code会不会被执行,什么时候被执行,在return前还是后?
     *
     * @return
     */
    public String Test1() {
        String str = "真的在";
        try {
            str = str + "return前输出？";
            return str;
        } finally {
            str = "finally在return前输出";
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        FinallyTest t = new FinallyTest();
        System.out.println(t.Test1());

    }

}
