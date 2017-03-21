/**
 * Copyright (c) www.bugull.com
 */
package com.looty.property;

/**
 * USED TO:读取System.properties文件
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.property
 * @date 2017/3/20/020
 */
public class SystemPropertyConfig extends PropertyConfig {

    private static final String configFileName = "system.properties";
    private volatile static SystemPropertyConfig instance = null;

    protected SystemPropertyConfig(String configFileName) {
        super(configFileName);
    }

    public static SystemPropertyConfig getInstance() {
        if (instance == null) {
            synchronized (SystemPropertyConfig.class) {
                if (instance == null) {
                    instance = new SystemPropertyConfig(configFileName);
                }
            }
        }
        return instance;
    }
}
