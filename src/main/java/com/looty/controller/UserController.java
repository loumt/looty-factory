/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import com.looty.pojo.system.ResultMsg;
import com.looty.pojo.User;
import com.looty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register(User user) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        ResultMsg result = userService.register(user);
        resultMap.put("result", result);
        return resultMap;
    }

}
