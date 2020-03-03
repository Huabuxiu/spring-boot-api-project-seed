package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class News {
    @Id
    private Integer nid;

    @Column(name = "news_title")
    private String newsTitle;

    private String url;

    @Column(name = "type_time")
    private Date typeTime;

    /**
     * @return nid
     */
    public Integer getNid() {
        return nid;
    }

    /**
     * @param nid
     */
    public void setNid(Integer nid) {
        this.nid = nid;
    }

    /**
     * @return news_title
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * @param newsTitle
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return type_time
     */
    public Date getTypeTime() {
        return typeTime;
    }

    /**
     * @param typeTime
     */
    public void setTypeTime(Date typeTime) {
        this.typeTime = typeTime;
    }
}