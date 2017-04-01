/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.concurrent.locks.Lock;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.controller
 * @date 2017/3/21/021
 */
@Controller
@RequestMapping("/manage/log/system")
public class LogSystemController extends BaseController {

    @Autowired
    private ISystemLogService systemLogService;

    @RequestMapping("/toIndex")
    public ModelAndView toIndex() {
        return super.backViewMV("/log/system_log_list");
    }

    /**
     * AuthCode列表
     *
     * @return
     */
    @RequestMapping(value = "/getSysLogList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAuthList() {
        ResultMsg resultMsg = systemLogService.getSysLogList();
        return super.backDataMap(resultMsg);
    }

}
