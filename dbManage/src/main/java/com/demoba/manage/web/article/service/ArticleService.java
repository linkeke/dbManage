package com.demoba.manage.web.article.service;

import java.util.List;

import com.demoba.manage.web.article.dto.ArticleListDto;
import com.demoba.manage.web.article.model.ArticleModel;
import com.owl.common.util.Result;

public interface ArticleService {
	 
	 /**
	    * 新闻列表
	    * */
	   public Result articleList(Integer page, Integer pageSize);
	   
	   /**
	    * 添加新闻
	    * */
	   public Result addArticle(ArticleModel articleModel);
	   
	   /**
	    * 修改新闻
	    * */
	   public Result updateArticle(ArticleModel articleModel);
	   
	   /**
	    * 文章详情
	    * */
	   public Result articleDetail(Long articleId);
	   
	   /**
	    * 网页上新闻列表显示
	    * */
	   public List<ArticleListDto> webArticleList();
	 
	 
}
