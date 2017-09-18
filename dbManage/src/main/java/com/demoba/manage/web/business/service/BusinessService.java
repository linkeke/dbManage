package com.demoba.manage.web.business.service;

import java.util.List;

import com.demoba.manage.web.business.model.BusinessModel;
import com.owl.common.util.Result;

public interface BusinessService {
	 
	   public Result saveBusiness(BusinessModel businessModel);
	   public Result businessList(Integer page, Integer pageSize);
	 
	 
}
