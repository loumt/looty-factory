/**
 * Copyright (c) www.bugull.com
 */
package com.looty.redis.exception;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.redis
 * @date 2017/3/1/001
 */
public class RedisException extends Exception {

    public RedisException(String message, Throwable cause) {
        super(message, cause);
    }
}
