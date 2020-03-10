package com.company.project.model;

import javax.persistence.*;

@Table(name = "introduce_cm")
public class IntroduceCm {
    @Id
    private Integer iid;

    private Integer cmid;


    public IntroduceCm(Integer iid, Integer cmid) {
        this.iid = iid;
        this.cmid = cmid;
    }

    /**
     * @return iid
     */
    public Integer getIid() {
        return iid;
    }

    /**
     * @param iid
     */
    public void setIid(Integer iid) {
        this.iid = iid;
    }

    /**
     * @return cmid
     */
    public Integer getCmid() {
        return cmid;
    }

    /**
     * @param cmid
     */
    public void setCmid(Integer cmid) {
        this.cmid = cmid;
    }
}