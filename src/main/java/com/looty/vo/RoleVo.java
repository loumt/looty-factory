/**
 * Copyright (c) www.bugull.com
 */
package com.looty.vo;

import com.looty.pojo.Role;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.vo
 * @date 2017/3/17/017
 */
public class RoleVo extends Role {

    /**
     * 创建者
     */
    private String realName;

    private String username;


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
