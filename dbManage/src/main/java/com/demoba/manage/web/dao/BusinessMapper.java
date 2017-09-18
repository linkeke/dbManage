package com.demoba.manage.web.dao;

import java.util.List;
import java.util.Map;

import com.demoba.manage.web.entity.Business;

public interface BusinessMapper {
    int deleteByPrimaryKey(Long nBusinessId);

    int insert(Business record);

    int insertSelective(Business record);

    Business selectByPrimaryKey(Long nBusinessId);

    int updateByPrimaryKeySelective(Business record);

    int updateByPrimaryKey(Business record);
    
    List<Business> findByParam(Map<String, Object> param);
	
	int countByParam(Map<String, Object> param);
    
}