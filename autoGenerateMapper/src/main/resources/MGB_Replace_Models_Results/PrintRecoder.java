package com.rongji.egov.doc.business.model;

import java.util.Date;

public class PrintRecoder {
    /**
     * 
     */
    private String id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 公文id
     */
    private String docId;

    /**
     * 公文模块标识
     */
    private String docModule;

    /**
     * 送件人
     */
    private String sendUserName;

    /**
     * 送件人编号
     */
    private String sendUserNo;

    /**
     * 部门
     */
    private String sendOrg;

    /**
     * 送件时间
     */
    private Date sendTime;

    /**
     * 取件人
     */
    private String pickupUserName;

    /**
     * 取件人编号
     */
    private String pickupUserNo;

    /**
     * 取件时间
     */
    private Date pickupTime;

    /**
     * 印刷份数
     */
    private Integer printNum;

    /**
     * 加装封皮数
     */
    private Integer printCoverNum;

    /**
     * 印件名称
     */
    private String printSubject;

    /**
     * 印刷页数
     */
    private Integer printPageNum;

    /**
     * 印刷人员
     */
    private String printUserName;

    /**
     * 印刷人员编号
     */
    private String printUserNo;

    /**
     * 编排人员
     */
    private String layoutUserName;

    /**
     * 编排人员编号
     */
    private String layoutUserNo;

    /**
     * 装订人员
     */
    private String bookbindUserName;

    /**
     * 装订人员编号
     */
    private String bookbindUserNo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 
     */
    private Date noticePickupTime;

    /**
     * 
     */
    private String systemNo;

    /**
     * 
     */
    private String createUser;

    /**
     * 
     */
    private String createUserNo;

    /**
     * 
     * @return ID 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
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
     * 公文id
     * @return DOC_ID 公文id
     */
    public String getDocId() {
        return docId;
    }

    /**
     * 公文id
     * @param docId 公文id
     */
    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    /**
     * 公文模块标识
     * @return DOC_MODULE 公文模块标识
     */
    public String getDocModule() {
        return docModule;
    }

    /**
     * 公文模块标识
     * @param docModule 公文模块标识
     */
    public void setDocModule(String docModule) {
        this.docModule = docModule == null ? null : docModule.trim();
    }

    /**
     * 送件人
     * @return SEND_USER_NAME 送件人
     */
    public String getSendUserName() {
        return sendUserName;
    }

    /**
     * 送件人
     * @param sendUserName 送件人
     */
    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName == null ? null : sendUserName.trim();
    }

    /**
     * 送件人编号
     * @return SEND_USER_NO 送件人编号
     */
    public String getSendUserNo() {
        return sendUserNo;
    }

    /**
     * 送件人编号
     * @param sendUserNo 送件人编号
     */
    public void setSendUserNo(String sendUserNo) {
        this.sendUserNo = sendUserNo == null ? null : sendUserNo.trim();
    }

    /**
     * 部门
     * @return SEND_ORG 部门
     */
    public String getSendOrg() {
        return sendOrg;
    }

    /**
     * 部门
     * @param sendOrg 部门
     */
    public void setSendOrg(String sendOrg) {
        this.sendOrg = sendOrg == null ? null : sendOrg.trim();
    }

    /**
     * 送件时间
     * @return SEND_TIME 送件时间
     */
    public Date getSendTime() {
        return sendTime;
    }

    /**
     * 送件时间
     * @param sendTime 送件时间
     */
    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 取件人
     * @return PICKUP_USER_NAME 取件人
     */
    public String getPickupUserName() {
        return pickupUserName;
    }

    /**
     * 取件人
     * @param pickupUserName 取件人
     */
    public void setPickupUserName(String pickupUserName) {
        this.pickupUserName = pickupUserName == null ? null : pickupUserName.trim();
    }

    /**
     * 取件人编号
     * @return PICKUP_USER_NO 取件人编号
     */
    public String getPickupUserNo() {
        return pickupUserNo;
    }

    /**
     * 取件人编号
     * @param pickupUserNo 取件人编号
     */
    public void setPickupUserNo(String pickupUserNo) {
        this.pickupUserNo = pickupUserNo == null ? null : pickupUserNo.trim();
    }

    /**
     * 取件时间
     * @return PICKUP_TIME 取件时间
     */
    public Date getPickupTime() {
        return pickupTime;
    }

    /**
     * 取件时间
     * @param pickupTime 取件时间
     */
    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }

    /**
     * 印刷份数
     * @return PRINT_NUM 印刷份数
     */
    public Integer getPrintNum() {
        return printNum;
    }

    /**
     * 印刷份数
     * @param printNum 印刷份数
     */
    public void setPrintNum(Integer printNum) {
        this.printNum = printNum;
    }

    /**
     * 加装封皮数
     * @return PRINT_COVER_NUM 加装封皮数
     */
    public Integer getPrintCoverNum() {
        return printCoverNum;
    }

    /**
     * 加装封皮数
     * @param printCoverNum 加装封皮数
     */
    public void setPrintCoverNum(Integer printCoverNum) {
        this.printCoverNum = printCoverNum;
    }

    /**
     * 印件名称
     * @return PRINT_SUBJECT 印件名称
     */
    public String getPrintSubject() {
        return printSubject;
    }

    /**
     * 印件名称
     * @param printSubject 印件名称
     */
    public void setPrintSubject(String printSubject) {
        this.printSubject = printSubject == null ? null : printSubject.trim();
    }

    /**
     * 印刷页数
     * @return PRINT_PAGE_NUM 印刷页数
     */
    public Integer getPrintPageNum() {
        return printPageNum;
    }

    /**
     * 印刷页数
     * @param printPageNum 印刷页数
     */
    public void setPrintPageNum(Integer printPageNum) {
        this.printPageNum = printPageNum;
    }

    /**
     * 印刷人员
     * @return PRINT_USER_NAME 印刷人员
     */
    public String getPrintUserName() {
        return printUserName;
    }

    /**
     * 印刷人员
     * @param printUserName 印刷人员
     */
    public void setPrintUserName(String printUserName) {
        this.printUserName = printUserName == null ? null : printUserName.trim();
    }

    /**
     * 印刷人员编号
     * @return PRINT_USER_NO 印刷人员编号
     */
    public String getPrintUserNo() {
        return printUserNo;
    }

    /**
     * 印刷人员编号
     * @param printUserNo 印刷人员编号
     */
    public void setPrintUserNo(String printUserNo) {
        this.printUserNo = printUserNo == null ? null : printUserNo.trim();
    }

    /**
     * 编排人员
     * @return LAYOUT_USER_NAME 编排人员
     */
    public String getLayoutUserName() {
        return layoutUserName;
    }

    /**
     * 编排人员
     * @param layoutUserName 编排人员
     */
    public void setLayoutUserName(String layoutUserName) {
        this.layoutUserName = layoutUserName == null ? null : layoutUserName.trim();
    }

    /**
     * 编排人员编号
     * @return LAYOUT_USER_NO 编排人员编号
     */
    public String getLayoutUserNo() {
        return layoutUserNo;
    }

    /**
     * 编排人员编号
     * @param layoutUserNo 编排人员编号
     */
    public void setLayoutUserNo(String layoutUserNo) {
        this.layoutUserNo = layoutUserNo == null ? null : layoutUserNo.trim();
    }

    /**
     * 装订人员
     * @return BOOKBIND_USER_NAME 装订人员
     */
    public String getBookbindUserName() {
        return bookbindUserName;
    }

    /**
     * 装订人员
     * @param bookbindUserName 装订人员
     */
    public void setBookbindUserName(String bookbindUserName) {
        this.bookbindUserName = bookbindUserName == null ? null : bookbindUserName.trim();
    }

    /**
     * 装订人员编号
     * @return BOOKBIND_USER_NO 装订人员编号
     */
    public String getBookbindUserNo() {
        return bookbindUserNo;
    }

    /**
     * 装订人员编号
     * @param bookbindUserNo 装订人员编号
     */
    public void setBookbindUserNo(String bookbindUserNo) {
        this.bookbindUserNo = bookbindUserNo == null ? null : bookbindUserNo.trim();
    }

    /**
     * 备注
     * @return REMARK 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 
     * @return NOTICE_PICKUP_TIME 
     */
    public Date getNoticePickupTime() {
        return noticePickupTime;
    }

    /**
     * 
     * @param noticePickupTime 
     */
    public void setNoticePickupTime(Date noticePickupTime) {
        this.noticePickupTime = noticePickupTime;
    }

    /**
     * 
     * @return SYSTEM_NO 
     */
    public String getSystemNo() {
        return systemNo;
    }

    /**
     * 
     * @param systemNo 
     */
    public void setSystemNo(String systemNo) {
        this.systemNo = systemNo == null ? null : systemNo.trim();
    }

    /**
     * 
     * @return CREATE_USER 
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 
     * @param createUser 
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * 
     * @return CREATE_USER_NO 
     */
    public String getCreateUserNo() {
        return createUserNo;
    }

    /**
     * 
     * @param createUserNo 
     */
    public void setCreateUserNo(String createUserNo) {
        this.createUserNo = createUserNo == null ? null : createUserNo.trim();
    }
}