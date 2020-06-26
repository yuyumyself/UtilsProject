package com.china.hcg.eas.business.model;

import java.util.Date;

public class WrongImg {
    /**
     * ID
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 分类id
     */
    private String classifyId;

    /**
     * 创建者id
     */
    private String creatorId;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 绫诲瀷锛堣鏂囩被鍨嬮敊棰橈紝鏁板绫诲瀷閿欓绛夛級
     */
    private String type;

    /**
     * 标题
     */
    private String title;

    /**
     * 介绍
     */
    private String introduce;

    /**
     * ID
     * @return ID ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 创建时间
     * @return CREATE_TIME 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     * @return MODIFY_TIME 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 分类id
     * @return CLASSIFY_ID 分类id
     */
    public String getClassifyId() {
        return classifyId;
    }

    /**
     * 分类id
     * @param classifyId 分类id
     */
    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId == null ? null : classifyId.trim();
    }

    /**
     * 创建者id
     * @return CREATOR_ID 创建者id
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 创建者id
     * @param creatorId 创建者id
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * 图片地址
     * @return IMG_URL 图片地址
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 图片地址
     * @param imgUrl 图片地址
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 绫诲瀷锛堣鏂囩被鍨嬮敊棰橈紝鏁板绫诲瀷閿欓绛夛級
     * @return TYPE 绫诲瀷锛堣鏂囩被鍨嬮敊棰橈紝鏁板绫诲瀷閿欓绛夛級
     */
    public String getType() {
        return type;
    }

    /**
     * 绫诲瀷锛堣鏂囩被鍨嬮敊棰橈紝鏁板绫诲瀷閿欓绛夛級
     * @param type 绫诲瀷锛堣鏂囩被鍨嬮敊棰橈紝鏁板绫诲瀷閿欓绛夛級
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 标题
     * @return TITLE 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title 标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 介绍
     * @return INTRODUCE 介绍
     */
    public String getIntroduce() {
        return introduce;
    }

    /**
     * 介绍
     * @param introduce 介绍
     */
    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}