package com.demoba.manage.web.entity;

import java.util.Date;

public class User {
    private Long nUserId;

    private String cUserAccount;

    private String cUserPassword;

    private String cUserRealname;

    private String cUserPortrait;

    private String cUserIntroduce;

    private String cMobilePhone;

    private Integer nSex;

    private Integer nUserType;

    private Date tCreateTime;

    private Date tUpdateTime;

    public Long getnUserId() {
        return nUserId;
    }

    public void setnUserId(Long nUserId) {
        this.nUserId = nUserId;
    }

    public String getcUserAccount() {
        return cUserAccount;
    }

    public void setcUserAccount(String cUserAccount) {
        this.cUserAccount = cUserAccount == null ? null : cUserAccount.trim();
    }

    public String getcUserPassword() {
        return cUserPassword;
    }

    public void setcUserPassword(String cUserPassword) {
        this.cUserPassword = cUserPassword == null ? null : cUserPassword.trim();
    }

    public String getcUserRealname() {
        return cUserRealname;
    }

    public void setcUserRealname(String cUserRealname) {
        this.cUserRealname = cUserRealname == null ? null : cUserRealname.trim();
    }

    public String getcUserPortrait() {
        return cUserPortrait;
    }

    public void setcUserPortrait(String cUserPortrait) {
        this.cUserPortrait = cUserPortrait == null ? null : cUserPortrait.trim();
    }

    public String getcUserIntroduce() {
        return cUserIntroduce;
    }

    public void setcUserIntroduce(String cUserIntroduce) {
        this.cUserIntroduce = cUserIntroduce == null ? null : cUserIntroduce.trim();
    }

    public String getcMobilePhone() {
        return cMobilePhone;
    }

    public void setcMobilePhone(String cMobilePhone) {
        this.cMobilePhone = cMobilePhone == null ? null : cMobilePhone.trim();
    }

    public Integer getnSex() {
        return nSex;
    }

    public void setnSex(Integer nSex) {
        this.nSex = nSex;
    }

    public Integer getnUserType() {
        return nUserType;
    }

    public void setnUserType(Integer nUserType) {
        this.nUserType = nUserType;
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