package com.hcg.mbg.entity;

import java.util.Date;

public class User {
    /**
     * id主键
     */
    private String id;

    /**
     * 
     */
    private Date createdate;

    /**
     * 
     */
    private Date createtime;

    /**
     * 
     */
    private Date modifydate;

    /**
     * 
     */
    private Date modifytime;

    /**
     * 
     */
    private Boolean active;

    /**
     * 
     */
    private String alias;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String entityids;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private String verticlecode;

    /**
     * 职务
     */
    private String duty;

    /**
     * id主键
     * @return id id主键
     */
    public String getId() {
        return id;
    }

    /**
     * id主键
     * @param id id主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 
     * @return createDate 
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 
     * @param createdate 
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 
     * @return createTime 
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 
     * @param createtime 
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 
     * @return modifyDate 
     */
    public Date getModifydate() {
        return modifydate;
    }

    /**
     * 
     * @param modifydate 
     */
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    /**
     * 
     * @return modifyTime 
     */
    public Date getModifytime() {
        return modifytime;
    }

    /**
     * 
     * @param modifytime 
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    /**
     * 
     * @return active 
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * 
     * @param active 
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * 
     * @return alias 
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 
     * @param alias 
     */
    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    /**
     * 
     * @return email 
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 
     * @return entityIds 
     */
    public String getEntityids() {
        return entityids;
    }

    /**
     * 
     * @param entityids 
     */
    public void setEntityids(String entityids) {
        this.entityids = entityids == null ? null : entityids.trim();
    }

    /**
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 
     * @return verticleCode 
     */
    public String getVerticlecode() {
        return verticlecode;
    }

    /**
     * 
     * @param verticlecode 
     */
    public void setVerticlecode(String verticlecode) {
        this.verticlecode = verticlecode == null ? null : verticlecode.trim();
    }

    /**
     * 职务
     * @return duty 职务
     */
    public String getDuty() {
        return duty;
    }

    /**
     * 职务
     * @param duty 职务
     */
    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }
}