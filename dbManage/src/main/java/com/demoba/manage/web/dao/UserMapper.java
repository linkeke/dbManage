package com.demoba.manage.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.demoba.manage.web.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long nUserId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long nUserId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User login(@Param("account")String account,@Param("password")String password);
    
    User findByAccount(@Param("account")String account);

	List<User> findAll();
	
	List<User> findUserList(Map<String,Object> param);
    int countUserList(Map<String,Object> param);
	
}