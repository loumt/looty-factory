/**
 * Copyright (c) www.bugull.com
 */
package com.looty.interceptor;

import com.looty.annotation.AuthCheck;
import com.looty.enums.ModuleEnum;
import com.looty.service.IRoleService;
import com.looty.service.IUserAuthCodeService;
import com.looty.service.IUserService;
import com.looty.utils.CookieUtil;
import com.looty.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.filter
 * @date 2017/3/28/028
 */
public class PermissionInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleServicel;
    @Autowired
    private IUserAuthCodeService authCodeService;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String indexPage = "/manage/login/toIndex";

        String code = CookieUtil.getValue(request, "code");
        if (StringUtil.isEmpty(code) || !authCodeService.checkAuthCode(code)) {
            response.sendRedirect(indexPage);
        }

        if (handler instanceof HandlerMethod) {
            //权限验证
            HandlerMethod method = (HandlerMethod) handler;
            AuthCheck check = method.getMethodAnnotation(AuthCheck.class);
            if (check != null) {
                ModuleEnum[] modules = check.modules();
                String authCode = CookieUtil.getValue(request, "code");
                if (StringUtil.isEmpty(authCode)) {
                    response.sendRedirect(indexPage);
                } else {
                    //验证其权限
                    System.out.println("AuthCode:" + authCode);
                }
            }
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("SpringInterceptor postHandle");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("SpringInterceptor afterCompletion");
    }
}
