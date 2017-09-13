package com.demoba.manage.web.user.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoba.manage.web.dao.UserMapper;
import com.demoba.manage.web.entity.User;
import com.demoba.manage.web.user.dto.UserListDto;
import com.demoba.manage.web.user.model.UserListModel;
import com.demoba.manage.web.user.service.UserService;
import com.owl.common.content.Status;
import com.owl.common.util.Help;
import com.owl.common.util.Paginator;
import com.owl.common.util.Result;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private static final Logger log= LoggerFactory.getLogger(UserServiceImpl.class);
  @Autowired
  private UserMapper userMapper;
  public void test(){
	  List<User> list = userMapper.findAll();
	  System.out.println(list);
  }
  
@Override
public Result userList(UserListModel userListModel) {
	// TODO Auto-generated method stub
	Result result = new Result();
	if(Help.isNull(userListModel)){
		log.debug("参数错误！！");
		result.setStatus(Status.param_error_status);
		result.setInfo(Status.param_error_info);
		return result;
	}
	Integer page = userListModel.getPage();
	Integer pageSize = userListModel.getPageSize();
	Integer userType = userListModel.getUserType();
	String beginDate = userListModel.getBeginDate();
	String endDate = userListModel.getEndDate();
	String keyword = userListModel.getKeyword();
	Map<String, Object> param=new HashMap<String,Object>();
	param.put("userType", userType);
	param.put("beginDate", beginDate);
	param.put("endDate", endDate);
	param.put("keywords", keyword);
	
	int count =userMapper.countUserList(param);
	
	
	int pageCount=1;
	if(Help.isNotNull(page)&&Help.isNotNull(pageSize)){
	/**** 分页判断begin *****/
	Paginator paginator = new Paginator(0, pageSize);
	paginator.gotoPage(page);
	pageCount = paginator.calcPageCount(count); // 总页数
	
	/**** 分页判断end *****/
	param.put("startRow", paginator.getStartRow());
	param.put("pageSize", paginator.getPageSize());
	}
	List<User> userList = userMapper.findUserList(param);
	
	List<UserListDto> userListDtos=new ArrayList<UserListDto>();
	if(Help.isNotNull(userList)){
		for(User user:userList){
			UserListDto userListDto = new UserListDto();
			userListDto.setUserId(user.getnUserId());
			userListDto.setUserAccount(user.getcUserAccount());
			userListDto.setUserRealName(user.getcUserRealname());
			userListDto.setUserType(user.getnUserType());
			userListDto.setUserPortrait(user.getcUserPortrait());			
			userListDto.setUserMobilePhone(user.getcMobilePhone());
			userListDto.setCreateTime(user.gettCreateTime());
			userListDtos.add(userListDto);
		}
	}
	log.debug("查询用户列表成功==");
	log.debug("组装接口所需数据完成==");
	result.setStatus(Status.success_status);
	result.setInfo(Status.success_info);
	Map<String, Object> data = new HashMap<String, Object>();
	data.put("page", page);
	data.put("pageSize", pageSize);
	data.put("pageCount", pageCount);
	data.put("dataList", userListDtos);
	data.put("total", count);
	result.setData(data);
	return result;
}

@Override
public Result userVerify(Long userId, Integer status) {
	// TODO Auto-generated method stub
	log.debug("开始更新用户审核状态");
	Result result = new Result();
	User user = new User();
	user.setnUserId(userId);
//	user.setnAuthStatus(status);
	
	userMapper.updateByPrimaryKeySelective(user);
	log.debug("更新状态结束");
	result.setStatus(Status.success_status);
	result.setInfo(Status.success_info);
	return result;
}

}
