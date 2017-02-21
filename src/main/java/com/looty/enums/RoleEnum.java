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

    DEFAULT(0L, "无授权者"),
    ADMIN(1L, "系统管理员"),
    P_MANAGER(2L, "项目经理"),
    OPERATOR(3L, "运营管理员"),
    CUSTOMER(4L, "客服管理员"),
    MANAGER(5L, "维护管理员"),
    SALES(6L, "售后管理员");

    private Long roleCode;
    private String roleName;

    RoleEnum(Long roleCode, String roleName) {
        this.roleCode = roleCode;
        this.roleName = roleName;
    }

    public Long getRoleCode() {
        return roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public static Long getRoleCode(String roleName) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.roleName.equals(roleName)) {
                return roleEnum.roleCode;
            }
        }
        return RoleEnum.DEFAULT.roleCode;
    }


}
