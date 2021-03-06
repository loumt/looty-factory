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

import com.looty.pojo.system.ResultMsg;
import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回对象的封装类,给Controller提供事务
 * Map,ModelAndView和ModelMap
 *
 * @author lenovo
 */
@Transactional
public class BaseController {

    protected Logger logger = Logger.getLogger(this.getClass());

    private static final String IS_SUCCESS = "isSuccess";
    private static final String CODE = "code";
    private static final String DATA = "data";
    private static final String MSG = "msg";
    private static final String COUNT = "count";


    /**
     * 返回 ModelAndView
     *
     * @param path
     * @return
     */
    protected ModelAndView backViewMV(String path) {
        return new ModelAndView(path);
    }

    /**
     * 返回ModelAndView
     *
     * @param path
     * @param resultMsg
     * @return
     */
    protected ModelAndView backViewDataMV(String path, ResultMsg resultMsg) {
        ModelAndView modelAndView = new ModelAndView(path, backDataMap(resultMsg));
        return modelAndView;
    }


    protected Map<String, Object> backDataMap(ResultMsg resultMsg) {
        Map<String, Object> m = new HashMap<String, Object>();
        if (isNotNull(resultMsg.getSuccess())) m.put(IS_SUCCESS, resultMsg.getSuccess());
        if (isNotNull(resultMsg.getCode())) m.put(CODE, resultMsg.getCode());
        if (isNotNull(resultMsg.getData())) m.put(DATA, resultMsg.getData());
        if (isNotNull(resultMsg.getMsg())) m.put(MSG, resultMsg.getMsg());
        if (isNotNull(resultMsg.getCount())) m.put(COUNT, resultMsg.getCount());
        return m;
    }


    private Boolean isNotNull(Object o) {
        return o != null;
    }


}
