/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo;

import com.looty.base.BaseObject;

import java.io.Serializable;
import java.util.Date;

/**
 * USED TO:服务器状态
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.pojo
 * @date 2017/3/17/017
 */
public class MonitorInfo extends BaseObject {
    private static final long serialVersionUID = -2693480668858936864L;


    private Long id;
    /**
     * JVM可以使用可使用内存.
     */
    private long totalMemory;
    /**
     * JVM可以使用剩余内存.
     */
    private long freeMemory;
    /**
     * 操作系统.
     */
    private String osName;
    /**
     * 线程总数.
     */
    private int totalThread;
    /**
     * JVM可以使用的处理器个数
     */
    private int availableProcessors;
    /**
     * IP
     */
    private String hostAddress;
    /**
     * 计算机域名
     */
    private String userDomain;
    /**
     * Java的运行环境版本
     */
    private String javaVersion;
    /**
     * Java安装路径
     */
    private String javaHome;
    /**
     * Java虚拟机实现名字
     */
    private String javaVmName;
    /**
     * 创建时间
     */
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public int getTotalThread() {
        return totalThread;
    }

    public void setTotalThread(int totalThread) {
        this.totalThread = totalThread;
    }

    public int getAvailableProcessors() {
        return availableProcessors;
    }

    public void setAvailableProcessors(int availableProcessors) {
        this.availableProcessors = availableProcessors;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public String getUserDomain() {
        return userDomain;
    }

    public void setUserDomain(String userDomain) {
        this.userDomain = userDomain;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getJavaHome() {
        return javaHome;
    }

    public void setJavaHome(String javaHome) {
        this.javaHome = javaHome;
    }

    public String getJavaVmName() {
        return javaVmName;
    }

    public void setJavaVmName(String javaVmName) {
        this.javaVmName = javaVmName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
