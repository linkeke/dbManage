package com.demoba.manage.web.entity;

import java.util.Date;


public class Business {
    private Long nBusinessId;

    private String cName;

    private String cEmail;

    private String cContact;

    private String cMobile;

    private String cCompanyName;

    private String cCompanyAddr;

    private String cBusinessDemand;
    
    private Date tCreateTime;

    private Date tUpdateTime;

    public Long getnBusinessId() {
        return nBusinessId;
    }

    public void setnBusinessId(Long nBusinessId) {
        this.nBusinessId = nBusinessId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }

    public String getcContact() {
        return cContact;
    }

    public void setcContact(String cContact) {
        this.cContact = cContact == null ? null : cContact.trim();
    }

    public String getcMobile() {
        return cMobile;
    }

    public void setcMobile(String cMobile) {
        this.cMobile = cMobile == null ? null : cMobile.trim();
    }

    public String getcCompanyName() {
        return cCompanyName;
    }

    public void setcCompanyName(String cCompanyName) {
        this.cCompanyName = cCompanyName == null ? null : cCompanyName.trim();
    }

    public String getcCompanyAddr() {
        return cCompanyAddr;
    }

    public void setcCompanyAddr(String cCompanyAddr) {
        this.cCompanyAddr = cCompanyAddr == null ? null : cCompanyAddr.trim();
    }

    public String getcBusinessDemand() {
        return cBusinessDemand;
    }

    public void setcBusinessDemand(String cBusinessDemand) {
        this.cBusinessDemand = cBusinessDemand == null ? null : cBusinessDemand.trim();
    }

	public Date gettCreateTime() {
		return tCreateTime;
	}

	public void settCreateTime(Date tCreateTime) {
		this.tCreateTime = tCreateTime;
	}

	public Date gettUpdateTime() {
		return tUpdateTime;
	}

	public void settUpdateTime(Date tUpdateTime) {
		this.tUpdateTime = tUpdateTime;
	}
    
    
    
}