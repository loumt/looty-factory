package com.looty.enums;

/**
 * USED TO:模块枚举类
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.enums
 * @date 2017/2/17/017
 */
public enum ModuleEnum {

    ADMIN_MODULE(100, "管理模块"),
    LOG_MODULE(101, "日志模块"),
    SYSTEM_MODULE(102, "系统模块"),
    ARTICLE_MODULE(103, "文章模块");


    private int moduleCode;
    private String moduleName;

    ModuleEnum(int moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }

    public int getCode() {
        return moduleCode;
    }

    public String getName() {
        return moduleName;
    }


}
