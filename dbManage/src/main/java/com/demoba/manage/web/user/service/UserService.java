package com.demoba.manage.web.user.service;

import com.demoba.manage.web.user.model.UserListModel;
import com.owl.common.util.Result;

public interface UserService {
	 public void test();
	 
	 public Result userList(UserListModel userListModel);
	 
	 public Result userVerify(Long userId,Integer status);
	 
	 
}
