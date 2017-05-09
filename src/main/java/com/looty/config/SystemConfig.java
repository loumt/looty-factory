/**
 * Copyright (c) www.bugull.com
 */
package com.looty.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *  系统配置参数
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.config
 * @date 2017/3/10/010
 */
public class SystemConfig {
    /**
     * AuthCode有效分钟
     */
    public static Integer MAX_AUTH_CODE_INVALID_DAYS = 120;
    /**
     * AuthCode有效位数
     */
    public static Integer MAX_AUTH_CODE_INVALID_DIGIT = 20;

    //=======TradeMsgClient=======
    /**
     * 核心线程数
     */
    public static Integer TRADE_MSG_CLIENT_CORE_POOL_SIZE = 10;
    /**
     * 最大线程数
     */
    public static Integer TRADE_MSG_CLIENT_MAX_POOL_SIZE = 15;
    /**
     * 超时时间
     */
    public static Integer TRADE_MSG_CLIENT_KEEP_ACTIVE_TIME = 0;
    /**
     * Queue Size
     */
    public static Integer TRADE_MSG_CLIENT_WORK_QUEUE_SIZE = 20;


}
