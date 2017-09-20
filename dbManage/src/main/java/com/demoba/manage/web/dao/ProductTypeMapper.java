package com.demoba.manage.web.dao;

import com.demoba.manage.web.entity.ProductType;

public interface ProductTypeMapper {
    int deleteByPrimaryKey(Long nProductTypeId);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    ProductType selectByPrimaryKey(Long nProductTypeId);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);
}