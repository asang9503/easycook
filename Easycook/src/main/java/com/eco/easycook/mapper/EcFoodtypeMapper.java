package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcFoodtype;

public interface EcFoodtypeMapper {
    int deleteByPrimaryKey(Integer ecId);

    int insert(EcFoodtype record);

    int insertSelective(EcFoodtype record);

    EcFoodtype selectByPrimaryKey(Integer ecId);

    int updateByPrimaryKeySelective(EcFoodtype record);

    int updateByPrimaryKey(EcFoodtype record);
}