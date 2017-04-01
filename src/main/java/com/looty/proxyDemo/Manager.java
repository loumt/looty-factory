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
public class Manager implements Person {


    @Override
    public void aweak() {
        System.out.println("Manager醒来了");
    }

    @Override
    public void work() {
        System.out.println("Manager在工作...");
    }

    @Override
    public void sleep() {
        System.out.println("Manager睡觉了");
    }
}
