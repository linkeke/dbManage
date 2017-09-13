package com.demoba.manage.web.system.model;

public class AddAdminModel {
  private String userAccount;
  private String userName;
  private String roleCodes;
  private String password;
  private String confirmPassword;
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
public String getRoleCodes() {
	return roleCodes;
}
public void setRoleCodes(String roleCodes) {
	this.roleCodes = roleCodes;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}
@Override
public String toString() {
	return "AddAdminModel [userAccount=" + userAccount + ", userName="
			+ userName + ", roleCodes=" + roleCodes + ", password=" + password
			+ ", confirmPassword=" + confirmPassword + "]";
}
  
}
