package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcGoodstype;

public interface EcGoodstypeMapper {
    int deleteByPrimaryKey(Integer ecTid);

    int insert(EcGoodstype record);

    int insertSelective(EcGoodstype record);

    EcGoodstype selectByPrimaryKey(Integer ecTid);

    int updateByPrimaryKeySelective(EcGoodstype record);

    int updateByPrimaryKey(EcGoodstype record);
}