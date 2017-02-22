/**
 * Copyright (c) www.bugull.com
 */
package com.looty.base;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.base
 * @date 2017/2/12/012
 */

import org.apache.log4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 返回对象的封装类
 *
 * @author lenovo
 */
public class BaseController {

    protected Logger logger = Logger.getLogger(this.getClass());

    /**
     * 返回forward页面跳转
     * <p/>
     * path 页面视图
     * obj 返回多个消息消息值
     */
    protected ModelAndView backRequestAttribute(String path, Object... obj) {
        ModelAndView view = new ModelAndView();
        view.setViewName(path);
        for (int i = 0; i < obj.length; i++) {
            view.addObject("rows" + (i + 1), obj[i]);
        }
        return view;
    }

    /**
     * 返回forward页面跳转
     * <p/>
     * path 页面视图
     * map 返回多个消息键值map
     */
    @SuppressWarnings("unchecked")
    protected ModelAndView backRequestAttribute(String path, Map<String, Object> map) {
        ModelAndView view = new ModelAndView();
        view.setViewName(path);
        if (map != null && !map.isEmpty()) {
            for (Iterator iter = map.entrySet().iterator(); iter.hasNext(); ) {
                Map.Entry<String, Object> me = (Map.Entry<String, Object>) iter.next();
                view.addObject(me.getKey(), me.getValue());
            }
        }
        return view;
    }

    /**
     * 返回forward页面跳转
     * <p/>
     * path 页面视图
     * name 返回消息键
     * obj 返回消息值
     */
    protected ModelAndView backRequestAttribute(String path, String name, Object obj) {
        ModelAndView view = new ModelAndView();
        view.setViewName(path);
        if (name == null || "".equals(name.trim())) {
            name = "msg";
        }
        view.addObject(name, obj);
        return view;
    }

    /**
     * 返回forward页面跳转
     * <p/>
     * path 页面视图
     * obj 返回消息值
     */
    protected ModelAndView backRequestAttribute(String path, Object obj) {
        return this.backRequestAttribute(path, null, obj);
    }

    /**
     * 返回json分页数据
     * <p/>
     * list 数组集合
     * total 总记录数
     * <p/>
     * msg 消息信息
     */
    protected ModelMap backJsonList(List<?> list, int total, String msg) {
        ModelMap modelMap = new ModelMap();
        if (null == list) {
            msg = "该查询暂无任何记录！";
            modelMap.addAttribute("total", 0);
            modelMap.addAttribute("rows", new ArrayList<Object>());
        } else {
            modelMap.addAttribute("total", total);
            modelMap.addAttribute("rows", list);
        }
        modelMap.addAttribute("success", Boolean.TRUE);
        if (msg != null)
            modelMap.addAttribute("msg", msg);
        return modelMap;
    }

    /**
     * 返回json分页数据
     * <p/>
     * list 数组集合
     * total 总记录数
     * <p/>
     * msg 消息信息
     */
    protected ModelMap backJsonList(List<?> list, int total) {
        return backJsonList(list, total, null);
    }

    /**
     * 返回json对象
     * <p/>
     * object json对象
     * <p/>
     * msg 消息信息
     */
    protected ModelMap backJsonObject(Object obj, Boolean success, String msg) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("rows", obj);
        modelMap.addAttribute("success", success);
        if (obj == null)
            msg = "该查询暂无任何记录！";
        if (msg != null)
            modelMap.addAttribute("msg", msg);
        return modelMap;
    }

    /**
     * 返回json对象
     * <p/>
     * object json对象
     * <p/>
     * msg 消息信息
     */
    protected ModelMap backJsonObject(Object obj, String msg) {
        return this.backJsonObject(obj, Boolean.TRUE, msg);
    }

    /**
     * 返回json对象
     * <p/>
     * object json对象
     */
    protected ModelMap backJsonObject(Object obj) {
        return this.backJsonObject(obj, null);
    }

    /**
     * 返回json消息
     * <p/>
     * status 消息状态: true false
     * <p/>
     * msg 消息信息
     */
    protected ModelMap backJsonMsg(Boolean status, String msg) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("success", status);
        if (msg != null)
            modelMap.addAttribute("msg", msg);
        return modelMap;
    }

    /**
     * 返回成功json消息
     * <p/>
     * msg 消息信息
     */
    protected ModelMap backJsonSuccessMsg(String msg) {
        return this.backJsonMsg(Boolean.TRUE, msg);
    }

    /**
     * 返回错误json消息
     * <p/>
     * msg 消息信息
     */
    protected ModelMap backJsonFailureMsg(String msg) {
        return this.backJsonMsg(Boolean.FALSE, msg);
    }
}
