package com.eco.easycook.mapper;

import com.eco.easycook.pojo.EcShopcar;

import java.util.List;

public interface EcShopcarMapper {
    int deleteByPrimaryKey(Integer shopcarId);

    int insert(EcShopcar record);

    int insertSelective(EcShopcar record);

    EcShopcar selectByPrimaryKey(Integer shopcarId);

    int updateByPrimaryKeySelective(EcShopcar record);

    int updateByPrimaryKey(EcShopcar record);

    //根据用户id查询购物车信息
    List<EcShopcar> selectShopcarById(int uid);

}