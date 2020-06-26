package com.china.hcg.eas.business.dao;

import com.china.hcg.eas.business.model.WrongImg;

public interface WrongImgMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(WrongImg record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(WrongImg record);

    /**
     *
     * @mbggenerated
     */
    WrongImg selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WrongImg record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(WrongImg record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WrongImg record);
}