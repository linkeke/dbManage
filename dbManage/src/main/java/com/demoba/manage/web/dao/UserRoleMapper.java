package com.demoba.manage.web.dao;

import org.apache.ibatis.annotations.Param;

import com.demoba.manage.web.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(Long nUserRoleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long nUserRoleId);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

	void deleteByRoleCode(@Param("roleCode")Long roleCode);

	void deleteByUserId(@Param("userId")Long userId);
	
	UserRole selectRoleId(Long userId);
}