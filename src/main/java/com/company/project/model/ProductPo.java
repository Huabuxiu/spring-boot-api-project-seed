package com.company.project.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class ProductPo {
    @Id
    private Integer pid;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "type_name")
    private String typeName;

    private String url;

    @Column(name = "product_time")
    private Date productTime;


    public Date getProductTime() {
        return productTime;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }

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


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    @Override
    public String toString() {
        return "{ \"productName=\":\"" + productName + "\"" +
                ",\" typeName=\":\"" + typeName +"\"" +
                ", \"url\":\"" + url + "\"" +
                '}';
    }
}