/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo.system;

import com.looty.base.BaseObject;
import com.looty.enums.ResultMsgEnum;

import java.io.Serializable;
import java.util.List;

/**
 * USED TO:结果集对象
 * Log File:
 *
 * @author loumt(loumt@hadlinks.com)
 * @project looty-factory
 * @package com.looty.pojo
 * @date 2017/2/23/023
 */
public class ResultMsg extends BaseObject {

    private static final long serialVersionUID = 4282376782413938930L;
    /**
     * 返回结果码
     */
    private String code;

    /**
     * 返回结果信息
     */
    private String msg;

    /**
     * 返回成功与否
     */
    private Boolean success;

    /**
     * 返回结果集
     */
    private Object data;

    /**
     * 数据量
     */
    private Long count;


    public static ResultMsg isFail(ResultMsgEnum resultMsgEnum) {
        ResultMsg resultMsg = new ResultMsg(resultMsgEnum);
        resultMsg.setSuccess(Boolean.FALSE);
        return resultMsg;
    }

    public static ResultMsg isCommonSuccess() {
        return isSuccess(ResultMsgEnum.SUCCESS);
    }

    public static ResultMsg isSuccess(ResultMsgEnum resultMsgEnum) {
        ResultMsg resultMsg = new ResultMsg(resultMsgEnum);
        resultMsg.setSuccess(Boolean.TRUE);
        return resultMsg;
    }

    public static ResultMsg isSuccess(List list, Long count) {
        ResultMsg resultMsg = new ResultMsg(ResultMsgEnum.SUCCESS);
        resultMsg.setSuccess(Boolean.TRUE);
        resultMsg.setData(list);
        resultMsg.setCount(count);
        return resultMsg;
    }

    public static ResultMsg isSuccess(ResultMsgEnum resultMsgEnum, Object obj) {
        ResultMsg resultMsg = new ResultMsg(resultMsgEnum);
        resultMsg.setSuccess(Boolean.TRUE);
        resultMsg.setData(obj);
        return resultMsg;
    }

    private ResultMsg(ResultMsgEnum resultMsgEnum) {
        this.code = resultMsgEnum.getCode();
        this.msg = resultMsgEnum.getMsg();
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }


}
