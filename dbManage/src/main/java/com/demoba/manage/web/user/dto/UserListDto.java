package com.demoba.manage.web.user.dto;

import java.util.Date;

public class UserListDto {
	private Long userId;
	private Integer userType;
	private String userAccount;
	private String userRealName;
	private String userPortrait;
	private String userMobilePhone;
	private String schoolName;
	private String major;
	private Integer userAuthStatus;
	private String userCode;
	private String grade;
	private Date createTime;
	
	private String userAuthImg;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserPortrait() {
		return userPortrait;
	}
	public void setUserPortrait(String userPortrait) {
		this.userPortrait = userPortrait;
	}
	public String getUserMobilePhone() {
		return userMobilePhone;
	}
	public void setUserMobilePhone(String userMobilePhone) {
		this.userMobilePhone = userMobilePhone;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Integer getUserAuthStatus() {
		return userAuthStatus;
	}
	public void setUserAuthStatus(Integer userAuthStatus) {
		this.userAuthStatus = userAuthStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getUserAuthImg() {
		return userAuthImg;
	}
	public void setUserAuthImg(String userAuthImg) {
		this.userAuthImg = userAuthImg;
	}
	
	
	
	
	
	
}
