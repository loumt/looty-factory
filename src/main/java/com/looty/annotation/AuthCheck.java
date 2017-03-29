package com.looty.annotation;

import com.looty.enums.ModuleEnum;

import java.lang.annotation.*;

/**
 * USED TO:权限注解
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.annotation
 * @date 2017/3/28/028
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface AuthCheck {

    /**
     * 模块名称
     *
     * @return
     */
    ModuleEnum[] modules() default {};


}
