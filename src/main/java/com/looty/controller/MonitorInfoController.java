/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.IMonitorInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.controller
 * @date 2017/3/17/017
 */
@Controller
@RequestMapping("/manage/system/monitorInfo")
public class MonitorInfoController extends BaseController {

    @Autowired
    private IMonitorInfoService monitorInfoService;

    /**
     * 主页
     *
     * @return
     */
    @RequestMapping("/toIndex")
    public ModelAndView toIndex() {
        return super.backViewMV("/system/system_status");
    }

    /**
     * Info列表
     *
     * @return
     */
    @RequestMapping(value = "/getInfoList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getInfoList() {
        ResultMsg resultMsg = monitorInfoService.getInfoList();
        return super.backDataMap(resultMsg);
    }

}
