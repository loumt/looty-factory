package com.looty.service;

import com.looty.exception.ServiceException;
import com.looty.pojo.TradeMsg;

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
public interface TradeMsgService {

    /**
     * 插入一条交易消息记录
     *
     * @param tradeMsg
     * @return
     * @throws ServiceException
     */
    long insertMsg(TradeMsg tradeMsg) throws ServiceException;

    /**
     * 插入一条交易消息记录
     *
     * @param tradeMsgs
     * @return
     * @throws ServiceException
     */
    long[] insertMsgList(List<TradeMsg> tradeMsgs) throws ServiceException;

}
