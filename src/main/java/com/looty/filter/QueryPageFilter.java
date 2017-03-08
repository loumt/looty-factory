/**
 * Copyright (c) www.bugull.com
 */
package com.looty.filter;

import com.looty.pojo.QueryPageModel;
import com.looty.utils.StringUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 *  分页过滤器
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.filter
 * @date 2017/3/8/008
 */
@WebFilter(description = "Page Filter", filterName = "QueryPageFilter", urlPatterns = {"/*"}, dispatcherTypes = DispatcherType.REQUEST)
public class QueryPageFilter implements Filter {
    private static Integer DEFAULT_PAGE_NO = 1;
    private static Integer DEFAULT_PAGE_SIZE = 10;


    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("Through QueryPageFilter.....");

        Integer pageNo = DEFAULT_PAGE_NO;
        Integer pageSize = DEFAULT_PAGE_SIZE;

        String _pageNo = request.getParameter("pageNo");
        String _pageSize = request.getParameter("pageSize");
        String order = request.getParameter("order");
        String sort = request.getParameter("sort");

        if (!StringUtil.isEmpty(_pageNo)) {
            pageNo = Integer.valueOf(_pageNo);
        }
        if (!StringUtil.isEmpty(_pageSize)) {
            pageSize = Integer.valueOf(_pageSize);
        }

        try {
            QueryPageModel.setPageNo(pageNo);
            QueryPageModel.setPageSize(pageSize);
            QueryPageModel.setOrder(order);
            QueryPageModel.setSort(sort);
            chain.doFilter(request, response);
        } finally {
            QueryPageModel.removePageNo();
            QueryPageModel.removeOrder();
            QueryPageModel.removePageSize();
            QueryPageModel.removeSort();
        }

    }

    public void destroy() {

    }
}
