/**
 * Copyright (c) www.bugull.com
 */
package com.looty.pojo;

import java.util.Date;

public class LinkTypeData {

    private Long id;
    /**
     * 资源类型
     */
    private int type;
    /**
     * 链接的地址
     */
    private String linkHref;
    /**
     * 链接的标题
     */
    private String linkText;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 内容
     */
    private String content;

    /**
     * 排名
     */
    private Integer ranking;
    /**
     * 搜索指数
     */
    private String exponent;

    /**
     * 创建时间
     */
    private Date createDate;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkHref() {
        return linkHref;
    }

    public void setLinkHref(String linkHref) {
        this.linkHref = linkHref;
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "LinkTypeData{" +
                "id=" + id +
                ", type=" + type +
                ", linkHref='" + linkHref + '\'' +
                ", linkText='" + linkText + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", ranking=" + ranking +
                ", exponent='" + exponent + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}