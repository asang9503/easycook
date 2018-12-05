package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcStep;

public interface EcStepMapper {
    int deleteByPrimaryKey(Integer ecId);

    int insert(EcStep record);

    int insertSelective(EcStep record);

    EcStep selectByPrimaryKey(Integer ecId);

    int updateByPrimaryKeySelective(EcStep record);

    int updateByPrimaryKey(EcStep record);
}