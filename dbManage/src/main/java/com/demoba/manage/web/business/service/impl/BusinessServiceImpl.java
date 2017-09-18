package com.demoba.manage.web.business.service.impl;

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

import com.demoba.manage.web.business.dto.BusinessDto;
import com.demoba.manage.web.business.model.BusinessModel;
import com.demoba.manage.web.business.service.BusinessService;
import com.demoba.manage.web.dao.ArticleMapper;
import com.demoba.manage.web.dao.BusinessMapper;
import com.demoba.manage.web.dao.UserMapper;
import com.demoba.manage.web.entity.Business;
import com.owl.common.content.Status;
import com.owl.common.util.MUtil;
import com.owl.common.util.Paginator;
import com.owl.common.util.Result;

@Service
@Transactional
public class BusinessServiceImpl implements BusinessService {

	private static final Logger log= LoggerFactory.getLogger(BusinessServiceImpl.class);
	  @Autowired
	  private ArticleMapper articleMapper;
	  
	  @Autowired
	  private UserMapper userMapper;
	
	  @Autowired
	  private BusinessMapper businessMapper;
	  
	  
	  public Result saveBusiness(BusinessModel businessModel) {
			Result result = new Result();
			
			log.info("开始校验参数===");	
			
			String email = businessModel.getEmail();
			if(MUtil.isEmpty(email)){
				log.info("邮箱未填！！");
				result.setStatus(Status.email_empty_error_status);
				result.setInfo(Status.email_empty_error_info);
				return result;
			}
			if(!MUtil.toJudgeInput(email, 3)){
				log.info("邮箱格式错误");
				result.setStatus(Status.email_fmt_error_status);
				result.setInfo(Status.email_fmt_error_info);
				return result;
			}
			
			String mobile = businessModel.getMobile();
			if(MUtil.isEmpty(mobile)){
				log.info("手机号未填！！");
				result.setStatus(Status.phone_empty_error_status);
				result.setInfo(Status.phone_empty_error_info);
				return result;
			}
			if(!MUtil.toJudgeInput(mobile, 2)){
				log.info("手机号格式错误");
				result.setStatus(Status.phone_fmt_error_status);
				result.setInfo(Status.phone_fmt_error_info);
				return result;
			}
			
			String businessDemand = businessModel.getBusinessDemand();
			if(MUtil.isEmpty(businessDemand)){
				log.info("需求详细说明未填！！");
				result.setStatus(Status.demand_empty_error_status);
				result.setInfo(Status.demand_empty_error_info);
				return result;
			}
			
			Business business = new Business(); 
			
			business.setcName(businessModel.getContactName());
			business.setcEmail(businessModel.getEmail());
			business.setcContact(businessModel.getContact());
			business.setcMobile(businessModel.getMobile());
			business.setcCompanyName(businessModel.getCompanyName());
			business.setcBusinessDemand(businessModel.getBusinessDemand());
			business.setcCompanyAddr(businessModel.getCompanyWebsite());
			business.settCreateTime(new Date());
			business.settUpdateTime(new Date());
			
			log.debug("保存业务咨询数据中。。。");
			businessMapper.insert(business);
			log.debug("保存业务咨询数据成功！");
			result.setInfo(Status.success_info);
			result.setStatus(Status.success_status);
			return result;
		}

		public Result businessList(Integer page, Integer pageSize) {
			// TODO Auto-generated method stub
			Result result = new Result();
			log.debug("查询业务咨询列表开始。。。");
			
			Map<String,Object> param = new 	HashMap<String,Object>();
			Paginator paginator = new Paginator(0, pageSize);
			paginator.gotoPage(page);
			int countByParam = businessMapper.countByParam(param);
			int pageCount = paginator.calcPageCount(countByParam); // 总页数
			param.put("startRow", paginator.getStartRow());
			param.put("pageSize", paginator.getPageSize());
			List<Business> findByParam = businessMapper.findByParam(param);
			
			ArrayList<BusinessDto> arrayList = new ArrayList<BusinessDto>();
			for(int i=0;i<findByParam.size();i++){
				Business business = findByParam.get(i);
				
				BusinessDto businessDto = new BusinessDto();
				businessDto.setBusinessId(business.getnBusinessId());
				businessDto.setBusinessDemand(business.getcBusinessDemand());
				businessDto.setCompanyName(business.getcCompanyName());
				businessDto.setCompanyWebsite(business.getcCompanyAddr());
				businessDto.setContact(business.getcContact());
				businessDto.setContactName(business.getcName());
				businessDto.setEmail(business.getcEmail());
				businessDto.setMobile(business.getcMobile());
				businessDto.setCreateTime(business.gettCreateTime());
				
				arrayList.add(businessDto);
			}
			
			log.debug("业务咨询列表结束。。。");
			
			Map<String,Object> data = new HashMap<String,Object>();
			data.put("dataList", arrayList);
			data.put("page", page);
			data.put("pageSize", pageSize);
			data.put("pageCount", pageCount);
			result.setStatus(Status.success_status);
			result.setInfo(Status.success_info);
			result.setData(data);
			return result;
		}


}
