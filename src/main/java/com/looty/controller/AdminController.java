/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import com.looty.pojo.Admin;
import com.looty.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * USED TO:管理员控制层
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.controller
 * @date 2017/2/12/012
 */
@Controller
@RequestMapping("/manage/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping(value = "/getAdmin", method = RequestMethod.GET)
    public Map<String, Object> getAdmin() {
        final Admin admin = adminService.getOneAdmin();

        Map<String, Object> returnMap = new HashMap<String, Object>() {
            {
                put("admin", admin);
            }
        };

        return returnMap;
    }
}
