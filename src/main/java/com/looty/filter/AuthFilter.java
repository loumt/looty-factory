/**
 * Copyright (c) www.bugull.com
 */
package com.looty.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.filter
 * @date 2017/3/3/003
 */
@WebFilter(filterName = "authFilter", urlPatterns = {"/manage/*"}, dispatcherTypes = DispatcherType.REQUEST)
public class AuthFilter implements Filter {
    private HttpServletRequest request;
    private HttpServletResponse response;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuthFilter Init()");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        this.request = (HttpServletRequest) servletRequest;
        this.response = (HttpServletResponse) servletResponse;
        System.out.println("AuthFilter doFilter():{Uri:" + request.getRequestURI() + "}");
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("AuthFilter destroy()");
    }
}
