package com.demoba.manage.web.product.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demoba.manage.web.product.model.ProductModel;
import com.demoba.manage.web.product.service.ProductService;
import com.owl.common.log.BKLogger;
import com.owl.common.util.Result;

@Controller
public class ProductController {
	BKLogger logger = BKLogger.getLogger(ProductController.class);
	private static final Logger log= LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/productPage")	 
	public String productPage(HttpServletRequest request,Model model){		 
		 return "product/product-list";	 
	}
	
	@RequestMapping("/saveProduct")
	@ResponseBody
	public Object saveProduct(HttpServletRequest request,Model model,ProductModel productModel){
		 Result result = null;
		 try{
			 result = productService.saveProduct(productModel);
		 }catch(Exception ex){
			 log.error("保存业务咨询失败", ex);
			 result = new Result ();
		 }
		 return logger.infobk("保存业务咨询", result);		 
	 }
	 
	 @RequestMapping("/productList")
	 @ResponseBody
	 public Object productList(HttpServletRequest request,Model model,Integer page,Integer pageSize){
		 Result result = null;
		 try{
			 result = productService.productList(page, pageSize);
		 }catch(Exception ex){
			 log.error("业务咨询列表查询失败", ex);
			 result = new Result ();
		 }
		 return logger.infobk("业务咨询列表查询", result);		
	 }
	
}
