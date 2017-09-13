package com.demoba.manage.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.demoba.manage.web.entity.SystemUser;

public interface SystemUserMapper {
    int deleteByPrimaryKey(Long nUserId);

    int insert(SystemUser record);

    int insertSelective(SystemUser record);

    SystemUser selectByPrimaryKey(Long nUserId);

    int updateByPrimaryKeySelective(SystemUser record);

    int updateByPrimaryKey(SystemUser record);
    
    SystemUser login(@Param("userName")String userName,@Param("userPwd")String userPwd);
    List<SystemUser> findByParam(Map<String,Object> param);
    int countByParam(Map<String,Object> param);

	SystemUser findByUserName(@Param("userName")String userName);
}