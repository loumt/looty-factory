/**
 * Copyright (c) www.bugull.com
 */
package com.looty.service.impl;

import com.looty.base.BaseService;
import com.looty.dao.TradeMsgDao;
import com.looty.exception.ServiceException;
import com.looty.pojo.TradeMsg;
import com.looty.service.TradeMsgService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.queueExample.msgBuffer.service
 * @date 2017/4/12/012
 */
@Service
public class TradeMsgServiceImpl extends BaseService implements TradeMsgService {

    private static Logger logger = Logger.getLogger(TradeMsgServiceImpl.class.getName());

    @Autowired
    private TradeMsgDao tradeMsgDao;


    @Override
    public long insertMsg(TradeMsg tradeMsg) throws ServiceException {
        logger.debug("Insert into TradeMsg,TradeId = " + tradeMsg.getId());
        return tradeMsgDao.insert(tradeMsg);
    }

    @Override
    public long[] insertMsgList(List<TradeMsg> tradeMsgs) throws ServiceException {
        long[] ids = new long[tradeMsgs.size()];

        for (int i = 0; i < tradeMsgs.size() - 1; i++) {
            long l = tradeMsgDao.insert(tradeMsgs.get(i));
            ids[i] = l;
        }
        return ids;
    }
}
