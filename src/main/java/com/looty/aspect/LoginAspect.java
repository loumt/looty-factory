/**
 * Copyright (c) www.bugull.com
 */
package com.looty.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.aspect
 * @date 2017/3/10/010
 */
@Aspect
@Component
public class LoginAspect {

    @Pointcut("execution(* com.looty.service.impl.AopServiceImpl.*(..))")
    private void anyMethod() {
    }

    @Before("anyMethod()")
    public void before() {
        System.out.println("before.....");
    }


    @After("anyMethod()")
    public void after() {
        System.out.println("after.....");
    }

    @AfterReturning("anyMethod()")
    public void afterRunning() {
        System.out.println("afterRunning.....");
    }

    @AfterThrowing("anyMethod()")
    public void afterThrowing() {
        System.out.println("afterThrowing.....");
    }

    @Around("anyMethod()")
    public void around() {
        System.out.println("around.....");
    }

}
