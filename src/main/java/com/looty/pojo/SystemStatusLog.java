/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.pojo
 * @date 2017/3/3/003
 */
public class SystemStatusLog implements Serializable {

    private long id;
    /**
     * 行为:开启关闭
     */
    private String statusAction;

    /**
     * 容器名字
     */
    private String contextName;
    /**
     * 服务器信息
     */
    private String serverInfo;

    /**
     * 开启/关闭 时间
     */
    private Date operationTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContextName() {
        return contextName;
    }

    public void setContextName(String contextName) {
        this.contextName = contextName;
    }

    public String getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(String serverInfo) {
        this.serverInfo = serverInfo;
    }

    public String getStatusAction() {
        return statusAction;
    }

    public void setStatusAction(String statusAction) {
        this.statusAction = statusAction;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}
