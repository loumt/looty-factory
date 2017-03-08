/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo;

import java.util.Date;

/**
 *  用户登录控制
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.pojo
 * @date 2017/3/7/007
 */
public class UserAuthCode {

    /**
     * 编号
     */
    private Long id;

    /**
     * 用户唯一Id
     */
    private String userId;

    /**
     * 最后登录Ip
     */
    private String lastOperationIp;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 失效时间
     */
    private Date inValidData;

    /**
     * 唯一识别码
     */
    private String authCode;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastOperationIp() {
        return lastOperationIp;
    }

    public void setLastOperationIp(String lastOperationIp) {
        this.lastOperationIp = lastOperationIp;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getInValidData() {
        return inValidData;
    }

    public void setInValidData(Date inValidData) {
        this.inValidData = inValidData;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
