package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcCollect;

public interface EcCollectMapper {
    int deleteByPrimaryKey(Integer ecId);

    int insert(EcCollect record);

    int insertSelective(EcCollect record);

    EcCollect selectByPrimaryKey(Integer ecId);

    int updateByPrimaryKeySelective(EcCollect record);

    int updateByPrimaryKey(EcCollect record);
}