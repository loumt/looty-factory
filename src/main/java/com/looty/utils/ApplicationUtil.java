/**
 * Copyright (c) www.bugull.com
 */
package com.looty.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * USED TO:Get Object in Spring Container
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.utils
 * @date 2017/2/17/017
 */
@Component
public class ApplicationUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationUtil.applicationContext = applicationContext;
    }

    public static Object getObject(String name) {
        return applicationContext.getBean(name);
    }
}
