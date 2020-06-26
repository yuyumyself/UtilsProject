package com.china.hcg.eas.dao;

import com.china.hcg.eas.entity.WrongImg;

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