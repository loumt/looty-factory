/**
 * Copyright (c) www.bugull.com
 */
package com.looty.exception;

import org.apache.log4j.Logger;

/**
 * USED TO:Service层Exception简单封装,用于异常信息向Controller抛出
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.exception
 * @date 2017/2/12/012
 */
public class ServiceException extends RuntimeException {
    /**
     * 序列化编号
     */
    private static final long serialVersionUID = 3517241863691434831L;

    /**
     * 日志对象
     */
    protected final Logger log = Logger.getLogger(getClass());

    /**
     * @param message 异常信息
     */
    public ServiceException(String message) {
        super(message);
        log.error(message);
    }

    /**
     * @param message   异常信息
     * @param throwable 异常对象
     */
    public ServiceException(String message, Throwable throwable) {
        super(message, throwable);
        log.error(message + " :Throwable[" + throwable.getMessage() + "]");
    }
}
