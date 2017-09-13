package com.demoba.manage.web.article.model;

public class ArticleModel {
	private Long articleId;
	private String title;
	private String contents;
	private String articleImgs;
	private String contentHtml;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
		
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getArticleImgs() {
		return articleImgs;
	}
	public void setArticleImgs(String articleImgs) {
		this.articleImgs = articleImgs;
	}
	public String getContentHtml() {
		return contentHtml;
	}
	public void setContentHtml(String contentHtml) {
		this.contentHtml = contentHtml;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	
	
}
