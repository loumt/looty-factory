/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import com.looty.pojo.system.ResultMsg;
import com.looty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.controller
 * @date 2017/3/8/008
 */
@Controller
@RequestMapping("/manage/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toIndex")
    public ModelAndView toIndex() {
        return super.backViewMV("/user/userList");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list() {
        ResultMsg resultMsg = userService.getUserList();
        return super.backDataMap(resultMsg);
    }


}
