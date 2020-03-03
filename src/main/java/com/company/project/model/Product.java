package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Product {
    @Id
    private Integer pid;

    @Column(name = "product_name")
    private String productName;

    private Integer tid;

    private String url;

    @Column(name = "type_time")
    private Date typeTime;

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return product_name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return tid
     */
    public Integer getTid() {
        return tid;
    }

    /**
     * @param tid
     */
    public void setTid(Integer tid) {
        this.tid = tid;
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