package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcGoodsimg;


public interface EcGoodsimgMapper {
    int deleteByPrimaryKey(Integer ecGimgid);

    int insert(EcGoodsimg record);

    int insertSelective(EcGoodsimg record);

    EcGoodsimg selectByPrimaryKey(Integer ecGimgid);

    int updateByPrimaryKeySelective(EcGoodsimg record);

    int updateByPrimaryKey(EcGoodsimg record);
}