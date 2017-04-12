/**
 * Copyright (c) www.bugull.com
 */
package com.looty.factory;

import com.looty.pojo.TradeMsg;
import com.looty.utils.RandomUtil;
import com.looty.utils.UUIDGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.factory
 * @date 2017/4/12/012
 */
public class TradeMsgFactory {

    public static List<TradeMsg> getTradeList(int size) {
        List<TradeMsg> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TradeMsg bean = new TradeMsg();
            bean.setCreateDate(new Date());
            bean.setId(Long.parseLong(System.currentTimeMillis() + RandomUtil.number(5)));
            bean.setItemId(System.currentTimeMillis());
            bean.setTradeId(System.currentTimeMillis());
            bean.setUserId(System.currentTimeMillis());
            list.add(bean);
        }
        return list;
    }

    public static TradeMsg getTradeMsg() {
        TradeMsg bean = new TradeMsg();
        bean.setCreateDate(new Date());
        bean.setId(Long.parseLong(System.currentTimeMillis() + RandomUtil.number(5)));
        bean.setItemId(System.currentTimeMillis());
        bean.setTradeId(System.currentTimeMillis());
        bean.setUserId(System.currentTimeMillis());
        return bean;
    }
}
