/**
 * Copyright (c) www.bugull.com
 */
package com.looty.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
@Aspect("arg")
@Component
public class LoginAspect {

    //    @Before(value = "execution(* com.looty.service.impl.UserAuthCodeServiceImpl.checkAuthCode(String))",argNames = "arg")
    public void before(String returnValue) {
        System.out.println("LoginAspect before： reqValue=" + returnValue);
    }

    //    @After(value = "execution(* com.looty.service.impl.UserAuthCodeServiceImpl.checkAuthCode(..))")
    public void after(String returnValue) {
        System.out.println("LoginAspect after： returnValue=" + returnValue);
    }

    //    @AfterReturning(value = "execution(* com.looty.service.impl.UserAuthCodeServiceImpl.checkAuthCode(..))",argNames = "reqValue",returning = "returnValue",pointcut = )
    public void afterRunning() {
        System.out.println("afterRunning.....");
    }

    public void afterThrowing() {
        System.out.println("afterThrowing.....");
    }

    public void around() {
        System.out.println("around.....");
    }
}
