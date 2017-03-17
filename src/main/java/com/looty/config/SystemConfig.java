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
     * AuthCode有效天数
     */
    public static Integer MAX_AUTH_CODE_INVALID_DAYS = 3;
    /**
     * AuthCode有效位数
     */
    public static Integer MAX_AUTH_CODE_INVALID_DIGIT = 20;

}
