package com.demoba.manage.web.dao;

import com.demoba.manage.web.entity.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Long nProductId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long nProductId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}