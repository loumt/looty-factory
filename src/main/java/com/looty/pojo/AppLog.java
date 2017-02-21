/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * USED TO:日志记录
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.pojo
 * @date 2017/2/17/017
 */
public class AppLog implements Serializable {

    private static final long serialVersionUID = 2403059193845920236L;


    private Long id;

    /**
     * 模块名
     */
    private String moduleName;


    /**
     * 操作类型
     */
    private Integer operationType;

    /**
     * 管理员Id
     */
    private String adminId;

    /**
     * 操作时间
     */
    private Date operationTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}