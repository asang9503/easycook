package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcAttention;

public interface EcAttentionMapper {
    int deleteByPrimaryKey(Integer ecAid);

    int insert(EcAttention record);

    int insertSelective(EcAttention record);

    EcAttention selectByPrimaryKey(Integer ecAid);

    int updateByPrimaryKeySelective(EcAttention record);

    int updateByPrimaryKey(EcAttention record);
}