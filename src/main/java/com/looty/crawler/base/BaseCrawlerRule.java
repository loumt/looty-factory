/**
 * Copyright (c) www.bugull.com
 */
package com.looty.crawler.base;

import java.io.Serializable;

/**
 * USED TO:网络爬虫基类
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.crawler.base
 * @date 2017/4/10/010
 */
public class BaseCrawlerRule implements Serializable {

    private static final long serialVersionUID = -6035975231423211627L;
    /**
     * 链接
     */
    protected String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
