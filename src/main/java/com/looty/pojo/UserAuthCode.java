/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo;

import com.looty.base.BaseObject;

import java.io.Serializable;
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
public class UserAuthCode extends BaseObject {

    private static final long serialVersionUID = 7412687591476922183L;
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
    private Date inValidDate;

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

    public Date getInValidDate() {
        return inValidDate;
    }

    public void setInValidDate(Date inValidDate) {
        this.inValidDate = inValidDate;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
}
