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
public class OuterWorker implements Person {

    private Person person;

    public OuterWorker(Person person) {
        this.person = person;
    }

    @Override
    public void aweak() {
        System.out.println("天亮了....");
        person.aweak();
        System.out.println("准备出门了....");
    }

    @Override
    public void work() {
        System.out.println("准备下今天的工作....");
        person.work();
        System.out.println("工作结束了,总结一下....");
    }

    @Override
    public void sleep() {
        System.out.println("Before aweak:听了下音乐....");
        person.sleep();
        System.out.println("做梦ing...");
    }
}
