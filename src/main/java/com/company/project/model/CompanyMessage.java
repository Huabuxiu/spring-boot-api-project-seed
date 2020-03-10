package com.company.project.model;

import javax.persistence.*;

@Table(name = "company_message")
public class CompanyMessage {
    @Id
    private Integer cmid;

    @Column(name = "company_name")
    private String companyName;

    private String contacts;

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

    /**
     * @return company_name
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return contacts
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * @param contacts
     */
    public void setContacts(String contacts) {
        this.contacts = contacts;
    }
}