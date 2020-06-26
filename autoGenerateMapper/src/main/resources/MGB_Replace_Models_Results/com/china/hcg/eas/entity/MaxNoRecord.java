package com.china.hcg.eas.entity;

import java.util.Date;

public class MaxNoRecord {
    /**
     * id
     */
    private String id;

    /**
     * 当前未使用最大值（默认零）
     */
    private Integer maxNo;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date modifyTime;

    /**
     * 唯一标识符
     */
    private String identifier;

    /**
     * 保留的号（漏号）
     */
    private String retainNos;

    /**
     * id
     * @return ID id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 当前未使用最大值（默认零）
     * @return MAX_NO 当前未使用最大值（默认零）
     */
    public Integer getMaxNo() {
        return maxNo;
    }

    /**
     * 当前未使用最大值（默认零）
     * @param maxNo 当前未使用最大值（默认零）
     */
    public void setMaxNo(Integer maxNo) {
        this.maxNo = maxNo;
    }

    /**
     * 
     * @return CREATE_TIME 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return MODIFY_TIME 
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 
     * @param modifyTime 
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 唯一标识符
     * @return IDENTIFIER 唯一标识符
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * 唯一标识符
     * @param identifier 唯一标识符
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    /**
     * 保留的号（漏号）
     * @return RETAIN_NOS 保留的号（漏号）
     */
    public String getRetainNos() {
        return retainNos;
    }

    /**
     * 保留的号（漏号）
     * @param retainNos 保留的号（漏号）
     */
    public void setRetainNos(String retainNos) {
        this.retainNos = retainNos == null ? null : retainNos.trim();
    }
}