package com.demoba.manage.web.entity;

public class ProductType {
    private Long nProductTypeId;

    private String cTypeName;

    private Integer nIndex;

    public Long getnProductTypeId() {
        return nProductTypeId;
    }

    public void setnProductTypeId(Long nProductTypeId) {
        this.nProductTypeId = nProductTypeId;
    }

    public String getcTypeName() {
        return cTypeName;
    }

    public void setcTypeName(String cTypeName) {
        this.cTypeName = cTypeName == null ? null : cTypeName.trim();
    }

    public Integer getnIndex() {
        return nIndex;
    }

    public void setnIndex(Integer nIndex) {
        this.nIndex = nIndex;
    }
}