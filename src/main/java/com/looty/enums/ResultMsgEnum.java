/**
 * Copyright (c) www.bugull.com
 */
package com.looty.enums;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.enums
 * @date 2017/2/24/024
 */
public enum ResultMsgEnum {

    SUCCESS("000000", "通用成功代码"),
    FAILUE("000001", "通用失败代码"),
    UNDEFINED_ERROR("000002", "未定义的，不可预知的其他异常"),
    INVALIDATE_PARAMETER("000003", "参数缺失或无效"),
    ALREADY_EXIST("000004", "已经存在");

    private String code;

    private String msg;

    ResultMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
