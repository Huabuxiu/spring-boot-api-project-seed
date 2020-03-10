package com.company.project.model;

import javax.persistence.*;

@Table(name = "contact_cm")
public class ContactCm {
    @Id
    private Integer cid;

    private Integer cmid;

    public ContactCm(Integer cid, Integer cmid) {
        this.cid = cid;
        this.cmid = cmid;
    }

    /**
     * @return cid
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * @param cid
     */
    public void setCid(Integer cid) {
        this.cid = cid;
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