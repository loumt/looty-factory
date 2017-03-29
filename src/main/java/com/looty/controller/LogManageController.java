/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.IManageLogService;
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
 * @date 2017/3/29/029
 */
@Controller
@RequestMapping("/manage/log/manage")
public class LogManageController extends BaseController {

    @Autowired
    private IManageLogService manageLogService;

    @RequestMapping("/toIndex")
    public ModelAndView toIndex() {
        return backViewMV("/log/manage_log_list");
    }


    @RequestMapping(value = "/getManLogList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getManLogList() {
        ResultMsg resultMsg = manageLogService.getManLogList();
        return backDataMap(resultMsg);
    }

}
