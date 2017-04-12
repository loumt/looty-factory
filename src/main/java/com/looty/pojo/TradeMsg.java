/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * USED TO:交易消息
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.queueExample.msgBuffer.bean
 * @date 2017/4/12/012
 */
public class TradeMsg implements Serializable {
    private static final long serialVersionUID = -1613390382219596784L;
    /**
     * 编号
     */
    private long id;
    /**
     * 交易流水号
     */
    private long tradeId;
    /**
     * 用户Id
     */
    private long userId;
    /**
     * 商品Id
     */
    private long itemId;
    /**
     * 创建时间
     */
    private Date createDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTradeId() {
        return tradeId;
    }

    public void setTradeId(long tradeId) {
        this.tradeId = tradeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
