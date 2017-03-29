/**
 * Copyright (c) www.bugull.com
 */
package com.looty.filter;

import org.apache.log4j.Logger;

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

    Logger logger = Logger.getLogger(AuthFilter.class);

    private HttpServletRequest request;
    private HttpServletResponse response;

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("AuthFilter Init()");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        this.request = (HttpServletRequest) servletRequest;
        this.response = (HttpServletResponse) servletResponse;
        logger.info("AuthFilter doFilter():{Uri:" + request.getRequestURI() + "}");
        chain.doFilter(request, response);
    }

    public void destroy() {
        logger.info("AuthFilter destroy()");
    }
}
