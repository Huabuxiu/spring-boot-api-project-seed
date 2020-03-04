package com.company.project.model;

import javax.persistence.*;

@Table(name = "product_types")
public class ProductTypes {
    @Id
    private Integer pid;

    private Integer tid;

    public ProductTypes(Integer pid, Integer tid) {
        this.pid = pid;
        this.tid = tid;
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
}