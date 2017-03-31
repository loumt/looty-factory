/**
 * Copyright (c) www.bugull.com
 */
package com.looty.base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * USED TO:基础实体类
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.base
 * @date 2017/3/17/017
 */
public class BaseObject implements Serializable {
    private static final long serialVersionUID = 3817619178065324186L;

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String toString(ToStringStyle stringStyle) {
        return ToStringBuilder.reflectionToString(this, stringStyle);
    }
}
