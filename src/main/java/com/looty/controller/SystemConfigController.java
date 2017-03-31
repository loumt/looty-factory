/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * USED TO:系统配置页
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.controller
 * @date 2017/3/29/029
 */
@Controller
@RequestMapping("/manage/system/config")
public class SystemConfigController extends BaseController {

    /**
     * 系统配置
     *
     * @return
     */
    @RequestMapping("/toIndex")
    public ModelAndView toIndex() {
        return backViewMV("/system/system_config");
    }


}
