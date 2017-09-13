package com.demoba.manage.web.dao;

import com.demoba.manage.web.entity.Advice;

public interface AdviceMapper {
    int deleteByPrimaryKey(Long nAdviceId);

    int insert(Advice record);

    int insertSelective(Advice record);

    Advice selectByPrimaryKey(Long nAdviceId);

    int updateByPrimaryKeySelective(Advice record);

    int updateByPrimaryKey(Advice record);
}