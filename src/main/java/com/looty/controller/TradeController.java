/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import com.looty.client.TradeMsgClient;
import com.looty.factory.TradeMsgFactory;
import com.looty.pojo.TradeMsg;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.TradeMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * USED TO: 测试消息缓冲队列
 * 相关类：TradeMsgClient
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.controller
 * @date 2017/4/12/012
 */
@Controller
@RequestMapping("/manage/trade")
public class TradeController extends BaseController {

    @Autowired
    private TradeMsgService tradeMsgService;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/toIndex")
    public ModelAndView toIndex() {
        return backViewMV("/trade/trade_index");
    }

    @RequestMapping(value = "/toSave", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> toSave(@RequestParam() int count) {
        List<TradeMsg> tradeList = TradeMsgFactory.getTradeList(count);
        for (TradeMsg tradeMsg : tradeList) {
            TradeMsgClient.getInstance().addTrade(tradeMsgService, tradeMsg);
        }
        return backDataMap(ResultMsg.isCommonSuccess());
    }

}
