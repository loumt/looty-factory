/**
 * Copyright (c) www.bugull.com
 */
package com.looty.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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
@WebFilter(filterName = "authFilter", urlPatterns = {"/*"}, dispatcherTypes = DispatcherType.REQUEST)
public class AuthFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("AuthFilter Init()");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AuthFilter doFilter()");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        System.out.println("AuthFilter destroy()");
    }
}
