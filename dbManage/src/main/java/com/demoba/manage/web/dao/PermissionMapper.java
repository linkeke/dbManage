package com.demoba.manage.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demoba.manage.web.entity.Permission;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long nPermissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Long nPermissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    List<String> findPermissionsByUserId(@Param("userId") Long userId);
}