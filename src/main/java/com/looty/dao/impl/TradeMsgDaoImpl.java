/**
 * Copyright (c) www.bugull.com
 */
package com.looty.dao.impl;

import com.looty.base.BaseDao;
import com.looty.dao.TradeMsgDao;
import com.looty.exception.DaoException;
import com.looty.pojo.TradeMsg;
import org.springframework.stereotype.Repository;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.queueExample.msgBuffer.dao
 * @date 2017/4/12/012
 */
@Repository
public class TradeMsgDaoImpl extends BaseDao implements TradeMsgDao {
    private static final String INSERT = "insert into trade_msg(tradeId,userId,itemId,createDate)values(:tradeId,:userId,:itemId,:createDate)";

    @Override
    public long insert(TradeMsg tradeMsg) throws DaoException {
        return this.saveBean(INSERT, tradeMsg);
    }
}
