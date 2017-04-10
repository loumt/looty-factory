/**
 * Copyright (c) www.bugull.com
 */
package com.looty.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * USED TO:Json解析类
 * 基于 com.alibaba.fastjson
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.utils
 * @date 2017/4/10/010
 */
public class JsonUtil {

    /**
     * Object - > jsonString
     *
     * @param object
     * @return
     */
    public static String getJsonString(Object object) {
        return JSONObject.toJSONString(object);
    }

    /**
     * Object - > JSONObject
     *
     * @param object
     * @return
     */
    public static JSONObject getJSONObject(Object object) {
        return JSONObject.parseObject(getJsonString(object));
    }


    /**
     * get Val form JsonString
     *
     * @param jsonString
     * @param key
     * @return
     */
    public static Object getValue(String jsonString, Object key) {
        return JSONObject.parseObject(jsonString).get(key);
    }

    /**
     * JSON_String - > T t
     *
     * @param jsonString
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T parseJsonString(String jsonString, Class<T> cls) {
        return JSONObject.parseObject(jsonString, cls);
    }

}
