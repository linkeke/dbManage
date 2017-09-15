package com.demoba.manage.web.article.service;

import java.util.List;

import com.demoba.manage.web.article.dto.ArticleListDto;
import com.demoba.manage.web.article.model.ArticleModel;
import com.owl.common.util.Result;

public interface ArticleService {
	 
	   public Result articleList(Integer page, Integer pageSize);
	   public Result addArticle(ArticleModel articleModel);
	   public Result updateArticle(ArticleModel articleModel);
	   public Result articleDetail(Long articleId);
	   public List<ArticleListDto> webArticleList();
	   public Result delArticle(Long articleId);
	 
	 
}
