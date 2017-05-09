package com.looty.utils;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 实现ApplicationContextAware，在Spring初始化时将ApplicationContext自动注入进来，通过实现方法{@link #setApplicationContext}赋值变量
 * 实现DisposableBean.在Spring容器关闭时调用{@link #destroy}实现释放资源
 * 实现InitializingBean,在Spring容器开始时调用,这里并不需要
 */
public class SpringContextUtils implements ApplicationContextAware, DisposableBean {

    private SpringContextUtils() {
    }

    private static ApplicationContext applicationContext = null;

    /**
     * 取得存储在静态变量中的ApplicationContext.
     */
    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }

    @Override
    public void destroy() throws Exception {
        SpringContextUtils.clearHolder();
    }

    /**
     * 根据类型名称取得bean
     *
     * @param name 类型名称
     * @return T bean
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     *
     * @param requiredType 类型
     * @return T bean
     */
    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        if (SpringContextUtils.applicationContext == null) {
            SpringContextUtils.applicationContext = applicationContext;
        }
    }

    /**
     * 清除SpringContextHolder中的ApplicationContext为Null.
     */
    public static void clearHolder() {
        applicationContext = null;
    }

    /**
     * 检查ApplicationContext不为空.
     */
    private static void assertContextInjected() {
        Validate.validState(applicationContext != null, "applicaitonContext属性未注入, 请在spring*.xml中定义 SpringContextHolder.");
    }

}
