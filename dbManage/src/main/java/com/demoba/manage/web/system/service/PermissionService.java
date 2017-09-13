package com.demoba.manage.web.system.service;

import java.util.Map;

public interface PermissionService {
	/**
	 * 用户授权
	 * */
   public Map<String,Object> authorization(Long userId);
   
}
