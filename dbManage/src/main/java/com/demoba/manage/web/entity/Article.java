package com.demoba.manage.web.entity;

import java.util.Date;

public class Article {
    private Long nArticleId;

    private String cArticleTitle;

    private String cArticleTag;

    private String cArticleImgs;

    private Date tCreateTime;

    private Date tUpdateTime;

    private Long nCreateId;

    private Integer nArticleType;

    private Integer nTop;

    private Integer nStatus;
    
    private String cArticleContent;

    private String cContentHtml;

    public String getcArticleContent() {
        return cArticleContent;
    }

    public void setcArticleContent(String cArticleContent) {
        this.cArticleContent = cArticleContent == null ? null : cArticleContent.trim();
    }

    public String getcContentHtml() {
        return cContentHtml;
    }

    public void setcContentHtml(String cContentHtml) {
        this.cContentHtml = cContentHtml == null ? null : cContentHtml.trim();
    }
    

    public Long getnArticleId() {
        return nArticleId;
    }

    public void setnArticleId(Long nArticleId) {
        this.nArticleId = nArticleId;
    }

    public String getcArticleTitle() {
        return cArticleTitle;
    }

    public void setcArticleTitle(String cArticleTitle) {
        this.cArticleTitle = cArticleTitle == null ? null : cArticleTitle.trim();
    }

    public String getcArticleTag() {
        return cArticleTag;
    }

    public void setcArticleTag(String cArticleTag) {
        this.cArticleTag = cArticleTag == null ? null : cArticleTag.trim();
    }

    public String getcArticleImgs() {
        return cArticleImgs;
    }

    public void setcArticleImgs(String cArticleImgs) {
        this.cArticleImgs = cArticleImgs == null ? null : cArticleImgs.trim();
    }

    public Date gettCreateTime() {
        return tCreateTime;
    }

    public void settCreateTime(Date tCreateTime) {
        this.tCreateTime = tCreateTime;
    }

    public Date gettUpdateTime() {
        return tUpdateTime;
    }

    public void settUpdateTime(Date tUpdateTime) {
        this.tUpdateTime = tUpdateTime;
    }

    public Long getnCreateId() {
        return nCreateId;
    }

    public void setnCreateId(Long nCreateId) {
        this.nCreateId = nCreateId;
    }

    public Integer getnArticleType() {
        return nArticleType;
    }

    public void setnArticleType(Integer nArticleType) {
        this.nArticleType = nArticleType;
    }

    public Integer getnTop() {
        return nTop;
    }

    public void setnTop(Integer nTop) {
        this.nTop = nTop;
    }

    public Integer getnStatus() {
        return nStatus;
    }

    public void setnStatus(Integer nStatus) {
        this.nStatus = nStatus;
    }
}