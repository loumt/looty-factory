/**
 * Copyright (c) www.bugull.com
 */
package com.looty.controller;

import com.looty.base.BaseController;
import com.looty.enums.ResultMsgEnum;
import com.looty.pojo.ResultMsg;
import com.looty.service.UserAuthCodeService;
import com.looty.service.UserService;
import com.looty.utils.CookieUtil;
import com.looty.utils.DateUtil;
import com.looty.utils.IpUtil;
import com.looty.utils.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Map;

/**
 *  登录
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.controller
 * @date 2017/3/7/007
 */
@Controller
@RequestMapping("/manage/login")
public class LoginController extends BaseController {

    Logger log = Logger.getLogger(this.getClass());


    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthCodeService userAuthCodeService;

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "/toIndex")
    public ModelAndView toIndex(HttpServletRequest request) {
        String ip = IpUtil.getIpAddress(request);
        log.debug(">>" + DateUtil.dateTime(new Date()) + "--" + ip + ":Ready to Login.....");
        return backViewMV("/login/login");
    }

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/toLogin", method = RequestMethod.POST)
    public Map<String, Object> toLogin(HttpServletRequest request, HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password) {
        ResultMsg resultMsg;
        //用户名密码检查
        if (StringUtil.isEmpty(username.trim()) || StringUtil.isEmpty(password.trim())) {
            return backDataMap(ResultMsg.isFail(ResultMsgEnum.INVALIDATE_PARAMETER));
        }
        //检验
        if (userService.checkLoginInfo(username, password)) {
            //生成唯一识别码
            String ip = IpUtil.getIpAddress(request);

            //检验AuthCode
            resultMsg = userAuthCodeService.getAuthCode(ip, username);

        } else {
            resultMsg = ResultMsg.isFail(ResultMsgEnum.USER_INFO_ERROR);
        }

        /**
         * 成功登录,将AuthCode写入Cookie
         */
        if (resultMsg.getSuccess()) {
            String authCode = String.valueOf(resultMsg.getData());
            CookieUtil.setValue(response, "code", authCode);
        }

        return backDataMap(resultMsg);
    }


    /**
     * 主页
     *
     * @return
     */
    @RequestMapping(value = "/toHomePage", method = RequestMethod.GET)
    public String toHomePage(HttpServletRequest request) {
        String authCode = CookieUtil.getValue(request, "code");

        if (StringUtil.isEmpty(authCode) || !userAuthCodeService.checkAuthCode(authCode)) {
            return "/login/login";
        } else {
            return "/login/homePage";
        }
    }


}
