package com.china.hcg.eas.dao;

import com.china.hcg.eas.entity.MaxNoRecord;

public interface MaxNoRecordMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int insert(MaxNoRecord record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(MaxNoRecord record);

    /**
     *
     * @mbggenerated
     */
    MaxNoRecord selectByPrimaryKey(String id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MaxNoRecord record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MaxNoRecord record);
}