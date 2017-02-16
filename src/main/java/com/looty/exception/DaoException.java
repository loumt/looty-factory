/**
 * Copyright (c) www.bugull.com
 */
package com.looty.exception;

import org.apache.log4j.Logger;

/**
 * USED TO:DAO层Exception简单封装,用于异常信息向Service抛出
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty
 * @date 2017/2/12/012
 */
public class DaoException extends RuntimeException {
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
    public DaoException(String message) {
        super(message);
        logger.error(message);
    }

    /**
     * @param message   异常信息
     * @param throwable 异常对象
     */
    public DaoException(String message, Throwable throwable) {
        super(message);
        logger.error(message + " :Throwable[" + throwable.getMessage() + "]");
    }
}
