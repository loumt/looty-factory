/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * USED TO:
 * Log File:
 *
 * @author loumt(loumt@sanlogic.com)
 * @project looty-factory
 * @package com.looty.pojo
 * @date 2017/3/30/030
 */
public class Resource implements Serializable {

    private static final long serialVersionUID = -4790459699745270246L;


    private Long id;
    /**
     * 标题
     */
    private String title;

    /**
     * 简述
     */
    private String des;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 所属类目
     */
    private int category;

    /**
     * 创建时间
     */
    private Date createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", url='" + url + '\'' +
                ", category=" + category +
                ", createDate=" + createDate +
                '}';
    }
}
