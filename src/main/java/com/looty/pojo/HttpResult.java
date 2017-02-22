/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo;

import org.apache.http.client.config.RequestConfig;

/**
 * USED TO:HttpClient封装类
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.pojo
 * @date 2017/2/22/022
 */
public class HttpResult {

    /**
     * Http请求返回Code
     */
    private Integer responseCode;

    /**
     * Http请求返回结果
     */
    private String responseResult;


    public HttpResult(Integer responseCode, String responseResult) {
        this.responseCode = responseCode;
        this.responseResult = responseResult;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(String responseResult) {
        this.responseResult = responseResult;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "responseResult='" + responseResult + '\'' +
                ", responseCode=" + responseCode +
                '}';
    }

}
