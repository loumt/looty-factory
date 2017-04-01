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
public class ProxyClient {

    public static void main(String[] args) {
        Person coder = new Coder();
        Person manager = new Manager();
        execute(new OuterWorker(coder));
//        execute(new OuterWorker(manager));
    }

    private static void execute(OuterWorker outerWorker) {
        outerWorker.aweak();
        outerWorker.work();
        outerWorker.sleep();
    }

    ;
}
