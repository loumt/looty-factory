/**
 * Copyright (c) www.bugull.com
 */
package com.looty.enums;

/**
 * USED TO:系统状态
 * <p/>
 * Log DB :system_status_log
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.enums
 * @date 2017/3/3/003
 */
public enum SystemStatusEnum {

    START(1, "开启"),
    CLOSE(2, "关闭");

    private int code;

    private String statusAction;

    SystemStatusEnum(int code, String statusAction) {
        this.code = code;
        this.statusAction = statusAction;
    }

    public int getCode() {
        return code;
    }

    public String getStatusAction() {
        return statusAction;
    }
}
