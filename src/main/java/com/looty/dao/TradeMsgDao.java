package com.looty.dao;

import com.looty.exception.DaoException;
import com.looty.pojo.TradeMsg;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.queueExample.msgBuffer.dao
 * @date 2017/4/12/012
 */
public interface TradeMsgDao {

    /**
     * 插入订单
     *
     * @param tradeMsg
     * @return
     * @throws DaoException
     */
    long insert(TradeMsg tradeMsg) throws DaoException;

}
