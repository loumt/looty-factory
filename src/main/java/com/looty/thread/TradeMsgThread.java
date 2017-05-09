/**
 * Copyright (c) www.bugull.com
 */
package com.looty.thread;

import com.looty.pojo.TradeMsg;
import com.looty.service.TradeMsgService;
import com.looty.service.impl.TradeMsgServiceImpl;
import com.looty.utils.ApplicationUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty
 * @date 2017/4/12/012
 */
public class TradeMsgThread implements Runnable {

    private static Logger logger = Logger.getLogger(TradeMsgThread.class.getName());

    private TradeMsg tradeMsg;

    private TradeMsgService tradeMsgService;


    public TradeMsgThread() {
    }

    public TradeMsgThread(TradeMsg tradeMsg) {
        this.tradeMsg = tradeMsg;
    }

    public TradeMsgThread(TradeMsgService tradeMsgService, TradeMsg tradeMsg) {
        this.tradeMsgService = tradeMsgService;
        this.tradeMsg = tradeMsg;
    }

    public void setTradeMsg(TradeMsg tradeMsg) {
        this.tradeMsg = tradeMsg;
    }

    public TradeMsg getTradeMsg() {
        return tradeMsg;
    }


    @Override
    public void run() {
        System.out.println(tradeMsg.getUserId() + " Trade Thread run !!!");
        tradeMsgService.insertMsg(tradeMsg);
    }
}
