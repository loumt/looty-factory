/**
 * Copyright (c) www.bugull.com
 */
package com.looty.exception;

import org.apache.log4j.Logger;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.exception
 * @date 2017/3/17/017
 */
public class ScheduleException extends RuntimeException {
    private static final long serialVersionUID = 6479999614622098856L;

    /**
     * 序列化ID
     */
    private static final long servialVersionUID = 1006823391281782460L;
    /**
     * 日志对象
     */
    protected final Logger logger = Logger.getLogger(getClass());

    /**
     * @param message 异常信息
     */
    public ScheduleException(String message) {
        super(message);
        logger.error(message);
    }

    /**
     * @param message   异常信息
     * @param throwable 异常对象
     */
    public ScheduleException(String message, Throwable throwable) {
        super(message);
        logger.error(message + " :Throwable[" + throwable.getMessage() + "]");
    }

}
