package com.looty.enums;

/**
 * USED TO:角色枚举
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.enums
 * @date 2017/2/20/020
 */
public enum RoleEnum {

    DEFAULT(1, "无授权者"),
    ADMIN(2, "系统管理员"),
    P_MANAGER(3, "项目经理"),
    OPERATOR(4, "运营管理员"),
    CUSTOMER(5, "客服管理员"),
    MANAGER(6, "维护管理员"),
    SALES(7, "售后管理员");

    private int roleCode;
    private String roleName;

    RoleEnum(int roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public int getRoleCode() {
        return roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public static int getRoleCode(String roleName) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.roleName.equals(roleName)) {
                return roleEnum.roleCode;
            }
        }
        return RoleEnum.DEFAULT.roleCode;
    }


}
