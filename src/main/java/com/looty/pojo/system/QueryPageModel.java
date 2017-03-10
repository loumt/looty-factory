/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo.system;

/**
 * 
 * Desc:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.pojo
 * @date 2017/3/8/008
 */
public class QueryPageModel {

    private static ThreadLocal<Integer> pageNo = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();
    private static ThreadLocal<String> order = new ThreadLocal<String>();
    private static ThreadLocal<String> sort = new ThreadLocal<String>();

    public static void setPageNo(Integer _pageNo) {
        pageNo.set(_pageNo);
    }

    public static Integer getPageNo() {
        return pageNo.get();
    }

    public static void removePageNo() {
        pageNo.remove();
    }

    public static void setPageSize(Integer _pageSize) {
        pageSize.set(_pageSize);
    }

    public static Integer getPageSize() {
        return pageSize.get();
    }

    public static void removePageSize() {
        pageSize.remove();
    }

    public static void setOrder(String _order) {
        order.set(_order);
    }

    public static String getOrder() {
        return order.get();
    }

    public static void removeOrder() {
        order.remove();
    }

    public static void removeSort() {
        sort.remove();
    }

    public static void setSort(String _sort) {
        sort.set(_sort);
    }

    public static String getSort() {
        return sort.get();
    }

}
