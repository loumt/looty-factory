/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import com.looty.pojo.Admin;
import com.looty.pojo.ResultMsg;
import com.looty.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @RequestMapping(value = "/toIndex")
    public String toIndex() {
        return "/admin/index";
    }

    /**
     * 注册
     *
     * @param admin
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register(Admin admin) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        ResultMsg result = adminService.existAdmin(admin.getUsername());
        if (!result.getSuccess()) {
            result = adminService.addAdmin(admin);
        }
        resultMap.put("result", result);
        return resultMap;
    }


    /**
     * 根据UserId获取一个Admin
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAdmin", method = RequestMethod.GET)
    public Map<String, Object> getAdmin(String userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Admin admin = adminService.getAdminByUserId(userId);
        resultMap.put("admin", admin);
        return resultMap;
    }


}
