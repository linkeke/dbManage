package com.demoba.manage.web.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Long nProductId;

    private String cProductName;

    private Long nProductTypeId;

    private BigDecimal nPrice;

    private BigDecimal nMarketPrice;

    private String cProductDesc;

    private Integer nAttentionRate;

    private Integer nNewType;

    private Date tCreateTime;

    private Date tUpdateTime;

    private Long nCreateBy;

    private Long nUpdateBy;

    private Boolean nStatus;

    public Long getnProductId() {
        return nProductId;
    }

    public void setnProductId(Long nProductId) {
        this.nProductId = nProductId;
    }

    public String getcProductName() {
        return cProductName;
    }

    public void setcProductName(String cProductName) {
        this.cProductName = cProductName == null ? null : cProductName.trim();
    }

    public Long getnProductTypeId() {
        return nProductTypeId;
    }

    public void setnProductTypeId(Long nProductTypeId) {
        this.nProductTypeId = nProductTypeId;
    }

    public BigDecimal getnPrice() {
        return nPrice;
    }

    public void setnPrice(BigDecimal nPrice) {
        this.nPrice = nPrice;
    }

    public BigDecimal getnMarketPrice() {
        return nMarketPrice;
    }

    public void setnMarketPrice(BigDecimal nMarketPrice) {
        this.nMarketPrice = nMarketPrice;
    }

    public String getcProductDesc() {
        return cProductDesc;
    }

    public void setcProductDesc(String cProductDesc) {
        this.cProductDesc = cProductDesc == null ? null : cProductDesc.trim();
    }

    public Integer getnAttentionRate() {
        return nAttentionRate;
    }

    public void setnAttentionRate(Integer nAttentionRate) {
        this.nAttentionRate = nAttentionRate;
    }

    public Integer getnNewType() {
        return nNewType;
    }

    public void setnNewType(Integer nNewType) {
        this.nNewType = nNewType;
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

    public Long getnCreateBy() {
        return nCreateBy;
    }

    public void setnCreateBy(Long nCreateBy) {
        this.nCreateBy = nCreateBy;
    }

    public Long getnUpdateBy() {
        return nUpdateBy;
    }

    public void setnUpdateBy(Long nUpdateBy) {
        this.nUpdateBy = nUpdateBy;
    }

    public Boolean getnStatus() {
        return nStatus;
    }

    public void setnStatus(Boolean nStatus) {
        this.nStatus = nStatus;
    }
}