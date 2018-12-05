package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcFoodtype;

public interface EcFoodtypeMapper {
    int deleteByPrimaryKey(Integer ecFid);

    int insert(EcFoodtype record);

    int insertSelective(EcFoodtype record);

    EcFoodtype selectByPrimaryKey(Integer ecFid);

    int updateByPrimaryKeySelective(EcFoodtype record);

    int updateByPrimaryKey(EcFoodtype record);
}