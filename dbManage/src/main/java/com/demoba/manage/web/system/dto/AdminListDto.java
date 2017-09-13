package com.demoba.manage.web.system.dto;

import java.util.List;

public class AdminListDto {
 private Long userId;
 private String userAccount;
 private String userName;
 private List<GroupListDto> groupList;
 private String lastLoginTime;
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public String getUserAccount() {
	return userAccount;
}
public void setUserAccount(String userAccount) {
	this.userAccount = userAccount;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getLastLoginTime() {
	return lastLoginTime;
}
public List<GroupListDto> getGroupList() {
	return groupList;
}
public void setGroupList(List<GroupListDto> groupList) {
	this.groupList = groupList;
}
public void setLastLoginTime(String lastLoginTime) {
	this.lastLoginTime = lastLoginTime;
}
 
 
}
