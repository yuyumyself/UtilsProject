package com.rongji.egov.doc.business.dao;

import com.rongji.egov.doc.business.model.PrintRecoder;

public interface PrintRecoderMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(PrintRecoder record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(PrintRecoder record);

    /**
     *
     * @mbggenerated
     */
    PrintRecoder selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PrintRecoder record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PrintRecoder record);
}