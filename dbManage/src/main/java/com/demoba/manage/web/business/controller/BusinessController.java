package com.demoba.manage.web.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demoba.manage.web.business.model.BusinessModel;
import com.demoba.manage.web.business.service.BusinessService;
import com.owl.common.log.BKLogger;
import com.owl.common.util.Result;

@Controller
public class BusinessController {
	BKLogger logger = BKLogger.getLogger(BusinessController.class);
	private static final Logger log= LoggerFactory.getLogger(BusinessController.class);
	
	@Autowired
	private BusinessService businessService;
	
	@RequestMapping("/businessPage")	 
	public String businessPage(HttpServletRequest request,Model model){		 
		 return "business/business-list";	 
	}
	
	@RequestMapping("/saveBusiness")
	@ResponseBody
	public Object saveBusiness(HttpServletRequest request,Model model,BusinessModel businessModel){
		 Result result = null;
		 try{
			 result = businessService.saveBusiness(businessModel);
		 }catch(Exception ex){
			 log.error("保存业务咨询失败", ex);
			 result = new Result ();
		 }
		 return logger.infobk("保存业务咨询", result);		 
	 }
	 
	 @RequestMapping("/businessList")
	 @ResponseBody
	 public Object businessList(HttpServletRequest request,Model model,Integer page,Integer pageSize){
		 Result result = null;
		 try{
			 result = businessService.businessList(page, pageSize);
		 }catch(Exception ex){
			 log.error("业务咨询列表查询失败", ex);
			 result = new Result ();
		 }
		 return logger.infobk("业务咨询列表查询", result);		
	 }
	
}
