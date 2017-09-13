package com.demoba.manage.web.entity;

import java.util.Date;

public class SystemUser {
    private Long nUserId;

    private String cUserName;

    private String cUserPwd;

    private Long nCreateId;

    private Date tCreateTime;

    private Long nUpdateId;

    private Date tUpdateTime;

    private Integer nStatus;
    private String cRealName;

    public String getcRealName() {
		return cRealName;
	}

	public void setcRealName(String cRealName) {
		this.cRealName = cRealName;
	}

	public Long getnUserId() {
        return nUserId;
    }

    public void setnUserId(Long nUserId) {
        this.nUserId = nUserId;
    }

    public String getcUserName() {
        return cUserName;
    }

    public void setcUserName(String cUserName) {
        this.cUserName = cUserName == null ? null : cUserName.trim();
    }

    public String getcUserPwd() {
        return cUserPwd;
    }

    public void setcUserPwd(String cUserPwd) {
        this.cUserPwd = cUserPwd == null ? null : cUserPwd.trim();
    }

    public Long getnCreateId() {
        return nCreateId;
    }

    public void setnCreateId(Long nCreateId) {
        this.nCreateId = nCreateId;
    }

    public Date gettCreateTime() {
        return tCreateTime;
    }

    public void settCreateTime(Date tCreateTime) {
        this.tCreateTime = tCreateTime;
    }

    public Long getnUpdateId() {
        return nUpdateId;
    }

    public void setnUpdateId(Long nUpdateId) {
        this.nUpdateId = nUpdateId;
    }

    public Date gettUpdateTime() {
        return tUpdateTime;
    }

    public void settUpdateTime(Date tUpdateTime) {
        this.tUpdateTime = tUpdateTime;
    }

    public Integer getnStatus() {
        return nStatus;
    }

    public void setnStatus(Integer nStatus) {
        this.nStatus = nStatus;
    }
}