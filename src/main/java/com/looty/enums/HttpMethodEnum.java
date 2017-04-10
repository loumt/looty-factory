package com.looty.enums;

/**
 * USED TO:Http请求方法
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.enums
 * @date 2017/4/6/006
 */
public enum HttpMethodEnum {
    GET(1, "get"),
    DELETE(2, "delete"),
    PUT(3, "put"),
    POST(4, "post");

    private int type;

    private String name;

    HttpMethodEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }


}
