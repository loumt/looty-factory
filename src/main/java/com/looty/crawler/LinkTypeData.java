/**
 * Copyright (c) www.bugull.com
 */
package com.looty.crawler;

import java.util.Date;

public class LinkTypeData {

    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
                "createDate=" + createDate +
                ", exponent='" + exponent + '\'' +
                ", ranking=" + ranking +
                ", content='" + content + '\'' +
                ", summary='" + summary + '\'' +
                ", linkText='" + linkText + '\'' +
                ", linkHref='" + linkHref + '\'' +
                ", id=" + id +
                '}';
    }
}