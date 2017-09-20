package com.demoba.manage.web.product.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoba.manage.web.product.dto.ProductDto;
import com.demoba.manage.web.product.model.ProductModel;
import com.demoba.manage.web.dao.ArticleMapper;
import com.demoba.manage.web.dao.ProductMapper;
import com.demoba.manage.web.dao.UserMapper;
import com.demoba.manage.web.entity.Product;
import com.demoba.manage.web.product.service.ProductService;
import com.owl.common.content.Status;
import com.owl.common.util.MUtil;
import com.owl.common.util.Paginator;
import com.owl.common.util.Result;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private static final Logger log= LoggerFactory.getLogger(ProductServiceImpl.class);
	  @Autowired
	  private ArticleMapper articleMapper;
	  
	  @Autowired
	  private UserMapper userMapper;
	
	  @Autowired
	  private ProductMapper productMapper;
	  
	  
	  public Result saveProduct(ProductModel productModel) {
			Result result = new Result();
			
//			log.info("开始校验参数===");	
//			
//			String email = productModel.getEmail();
//			if(MUtil.isEmpty(email)){
//				log.info("邮箱未填！！");
//				result.setStatus(Status.email_empty_error_status);
//				result.setInfo(Status.email_empty_error_info);
//				return result;
//			}
//			if(!MUtil.toJudgeInput(email, 3)){
//				log.info("邮箱格式错误");
//				result.setStatus(Status.email_fmt_error_status);
//				result.setInfo(Status.email_fmt_error_info);
//				return result;
//			}
//			
//			String mobile = productModel.getMobile();
//			if(MUtil.isEmpty(mobile)){
//				log.info("手机号未填！！");
//				result.setStatus(Status.phone_empty_error_status);
//				result.setInfo(Status.phone_empty_error_info);
//				return result;
//			}
//			if(!MUtil.toJudgeInput(mobile, 2)){
//				log.info("手机号格式错误");
//				result.setStatus(Status.phone_fmt_error_status);
//				result.setInfo(Status.phone_fmt_error_info);
//				return result;
//			}
//			
//			String productDemand = productModel.getProductDemand();
//			if(MUtil.isEmpty(productDemand)){
//				log.info("需求详细说明未填！！");
//				result.setStatus(Status.demand_empty_error_status);
//				result.setInfo(Status.demand_empty_error_info);
//				return result;
//			}
//			
//			Product product = new Product(); 
//			
//			product.setcName(productModel.getContactName());
//			product.setcEmail(productModel.getEmail());
//			product.setcContact(productModel.getContact());
//			product.setcMobile(productModel.getMobile());
//			product.setcCompanyName(productModel.getCompanyName());
//			product.setcProductDemand(productModel.getProductDemand());
//			product.setcCompanyAddr(productModel.getCompanyWebsite());
//			product.settCreateTime(new Date());
//			product.settUpdateTime(new Date());
//			
//			log.debug("保存业务咨询数据中。。。");
//			productMapper.insert(product);
//			log.debug("保存业务咨询数据成功！");
//			result.setInfo(Status.success_info);
//			result.setStatus(Status.success_status);
			return result;
		}

		public Result productList(Integer page, Integer pageSize) {
			// TODO Auto-generated method stub
			Result result = new Result();
		/*log.debug("查询业务咨询列表开始。。。");
			
			Map<String,Object> param = new 	HashMap<String,Object>();
			Paginator paginator = new Paginator(0, pageSize);
			paginator.gotoPage(page);
			int countByParam = productMapper.countByParam(param);
			int pageCount = paginator.calcPageCount(countByParam); // 总页数
			param.put("startRow", paginator.getStartRow());
			param.put("pageSize", paginator.getPageSize());
			List<Product> findByParam = productMapper.findByParam(param);
			
			ArrayList<ProductDto> arrayList = new ArrayList<ProductDto>();
			for(int i=0;i<findByParam.size();i++){
				Product product = findByParam.get(i);
				
				ProductDto productDto = new ProductDto();
				productDto.setProductId(product.getnProductId());
				productDto.setProductDemand(product.getcProductDemand());
				productDto.setCompanyName(product.getcCompanyName());
				productDto.setCompanyWebsite(product.getcCompanyAddr());
				productDto.setContact(product.getcContact());
				productDto.setContactName(product.getcName());
				productDto.setEmail(product.getcEmail());
				productDto.setMobile(product.getcMobile());
				productDto.setCreateTime(product.gettCreateTime());
				
				arrayList.add(productDto);
			}
			
			log.debug("业务咨询列表结束。。。");
			
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("dataList", arrayList);
			data.put("page", page);
			data.put("pageSize", pageSize);
			data.put("pageCount", pageCount);
			result.setStatus(Status.success_status);
			result.setInfo(Status.success_info);
			result.setData(data);*/
			return result;
		}


}
