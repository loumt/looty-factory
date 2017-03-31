/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo.system;

import com.looty.base.BaseObject;

/**
 * USED TO:HttpClient封装类
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.pojo
 * @date 2017/2/22/022
 */
public class HttpResult extends BaseObject {

    private static final long serialVersionUID = 4411094035877488170L;
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 返回数据
     */
    private String data;

    public HttpResult() {
    }

    public HttpResult(Integer status, String data) {
        this.status = status;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "HttpResult{" +
                "data='" + data + '\'' +
                ", status=" + status +
                '}';
    }
}
