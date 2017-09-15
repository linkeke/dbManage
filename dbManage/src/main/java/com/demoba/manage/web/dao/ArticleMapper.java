package com.demoba.manage.web.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.demoba.manage.web.entity.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long nArticleId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long nArticleId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    List<Article> findByParam(Map<String,Object> param);
    int countByParam(Map<String,Object> param);
    
    List<Article> findArticleList(Map<String,Object> param);
    int countArticleList(Map<String,Object> param);
}