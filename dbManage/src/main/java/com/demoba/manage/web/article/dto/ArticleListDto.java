package com.demoba.manage.web.article.dto;

import java.util.Date;
import java.util.List;

public class ArticleListDto {
	  private Long userId;
	  private String headImg;
	  private String userName;
	  private Long articleId;
	  private String articleTitle;
	  private List<String> imgs;
	  private String shortContent;
	  private Date publisTime;
	  private String tagName;
	  private String articleImg;
	public String getArticleTitle() {
		return articleTitle;
	}
	public Long getUserId() {
		return userId;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public List<String> getImgs() {
		return imgs;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}
	public String getShortContent() {
		return shortContent;
	}
	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}
	public Date getPublisTime() {
		return publisTime;
	}
	public void setPublisTime(Date publisTime) {
		this.publisTime = publisTime;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getArticleImg() {
		return articleImg;
	}
	public void setArticleImg(String articleImg) {
		this.articleImg = articleImg;
	}
	  
}
