/**
 * Copyright (c) www.bugull.com
 */
package com.looty.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * USED TO:二房东---扮演代理类
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.proxy
 * @date 2017/2/17/017
 */
public class DynamicProxy implements InvocationHandler {

    //这个是我们要代理的真实对象，即房东
    private Object subject;


    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    /**
     * @param proxy  指代我们所代理的哪个真实对象
     * @param method 指代的是我们所要调用真实对象的某个方法的Method对象
     * @param args   指代的是调用真实对象某个方法时接受的参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //在代理真实对象前我们可以添加一些自己的操作，中介收取中介费
        System.out.println("Before " + method.getName() + "House");

        System.out.println("Method: " + method.getName());

        //如果方法是charge,则中介收取100元中介费
        if (method.getName().equals("charge")) {
            method.invoke(subject, args);
            System.out.println("I will get 100 RMB ProxyCharge.");

        } else {

            //当代理对象调用真实对象的方法是，其会自动的跳转到代理对象关联的Handler对象的invoke方法来进行调用
            method.invoke(subject, args);
        }

        //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("After " + method.getName() + " house");

        return null;
    }
}
