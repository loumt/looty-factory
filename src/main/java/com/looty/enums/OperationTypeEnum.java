package com.looty.enums;

/**
 * USED TO:操作类型枚举类
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty
 * @date 2017/2/17/017
 */
public enum OperationTypeEnum {
    DEFAULT(500, "系统操作"),
    ADD(501, "增加"), DELETE(502, "删除"), UPDATE(503, "更新"), SEARCH(504, "查找");


    private int operationTypeCode;
    private String operationTypeName;

    OperationTypeEnum(int operationTypeCode, String operationTypeName) {
        this.operationTypeName = operationTypeName;
        this.operationTypeCode = operationTypeCode;
    }

    public int getCode() {
        return operationTypeCode;
    }

    public String getName() {
        return operationTypeName;
    }

    /**
     * 比对操作是否一致
     *
     * @param code
     * @param obj
     * @return
     */
    public Boolean checkOperationType(int code, OperationTypeEnum obj) {
        return code == obj.operationTypeCode;
    }


}
