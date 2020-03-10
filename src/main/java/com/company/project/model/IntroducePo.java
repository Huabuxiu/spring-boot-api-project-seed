package com.company.project.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class IntroducePo {
    @Id
    private Integer iid;

    @Column(name = "management_model")
    private String managementModel;

    @Column(name = "company_introduce")
    private String companyIntroduce;

    private String logo;


    @Column(name = "company_name")
    private String companyName;

    private String contacts;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
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
     * @return management_model
     */
    public String getManagementModel() {
        return managementModel;
    }

    /**
     * @param managementModel
     */
    public void setManagementModel(String managementModel) {
        this.managementModel = managementModel;
    }

    /**
     * @return company_introduce
     */
    public String getCompanyIntroduce() {
        return companyIntroduce;
    }

    /**
     * @param companyIntroduce
     */
    public void setCompanyIntroduce(String companyIntroduce) {
        this.companyIntroduce = companyIntroduce;
    }

    /**
     * @return logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }
}