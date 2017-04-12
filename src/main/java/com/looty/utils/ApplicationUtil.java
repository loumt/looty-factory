/**
 * Copyright (c) www.bugull.com
 */
package com.looty.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.ServletContext;

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

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * @param sc ServletContext 全局的储存信息的空间，服务器开始，其就存在，服务器关闭
     * @return
     */
    public static ApplicationContext getApplicationContext(ServletContext sc) {
        if (sc != null) {
            return WebApplicationContextUtils.getWebApplicationContext(sc);
        } else {
            return null;
        }
    }

    public static Object getObject(String name) {
        return applicationContext.getBean(name);
    }
}
