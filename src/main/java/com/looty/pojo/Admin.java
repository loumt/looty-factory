/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo;

import java.util.Date;

/**
 * USED TO:管理员
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.pojo
 * @date 2017/2/12/012
 */
public class Admin {
    /**
     * 编号
     */
    private Long id;
    /**
     * 帐户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 最后操作时间
     */
    private Date lastOperationTime;
    /**
     * 角色
     */
    private String role;
    /**
     * 真实名字
     */
    private String realName;
    /**
     * 是否为超级管理员0.不是 1.是
     */
    private Integer authTop;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastOperationTime() {
        return lastOperationTime;
    }

    public void setLastOperationTime(Date lastOperationTime) {
        this.lastOperationTime = lastOperationTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAuthTop() {
        return authTop;
    }

    public void setAuthTop(Integer authTop) {
        this.authTop = authTop;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", lastOperationTime=" + lastOperationTime +
                ", role='" + role + '\'' +
                ", realName='" + realName + '\'' +
                ", authTop=" + authTop +
                '}';
    }
}
