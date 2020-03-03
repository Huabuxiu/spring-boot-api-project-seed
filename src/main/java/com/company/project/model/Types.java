package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

public class Types {
    @Id
    private Integer tid;

    @Column(name = "type_name")
    private String typeName;

    private String describe;

    @Column(name = "type_time")
    private Date typeTime;

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
     * @return type_name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * @return describe
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * @param describe
     */
    public void setDescribe(String describe) {
        this.describe = describe;
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