package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcGoods;

import java.util.List;

public interface EcGoodsMapper {
    int deleteByPrimaryKey(Integer ecGid);

    int insert(EcGoods record);

    int insertSelective(EcGoods record);

    EcGoods selectByPrimaryKey(Integer ecGid);

    int updateByPrimaryKeySelective(EcGoods record);

    int updateByPrimaryKey(EcGoods record);

    //查询所有商品
    List<EcGoods> selectAllGoods();

    //根据类型id查询商品
    List<EcGoods> selectGoodsByType(int typeid);

    //根据商品id查询商品及商品图片
    EcGoods selectGoodsById(int gid);
}