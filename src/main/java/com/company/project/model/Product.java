package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Product {
    @Id
    private Integer pid;

    @Column(name = "product_name")
    private String productName;

    private String url;

    @Column(name = "product_time")
    private Date productTime;

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
     * @return product_time
     */
    public Date getProductTime() {
        return productTime;
    }

    /**
     * @param productTime
     */
    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }
}