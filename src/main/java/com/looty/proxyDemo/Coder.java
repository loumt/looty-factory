/**
 * Copyright (c) www.bugull.com
 */
package com.looty.proxyDemo;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.proxyDemo
 * @date 2017/4/1/001
 */
public class Coder implements Person {
    @Override
    public void aweak() {
        System.out.println("Coder醒来了");
    }

    @Override
    public void work() {
        System.out.println("Coder开始工作了");
    }

    @Override
    public void sleep() {
        System.out.println("Coder睡觉了");
    }
}
