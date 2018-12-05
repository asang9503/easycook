package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcHealthyfood;

public interface EcHealthyfoodMapper {
    int deleteByPrimaryKey(Integer ecHid);

    int insert(EcHealthyfood record);

    int insertSelective(EcHealthyfood record);

    EcHealthyfood selectByPrimaryKey(Integer ecHid);

    int updateByPrimaryKeySelective(EcHealthyfood record);

    int updateByPrimaryKey(EcHealthyfood record);
}