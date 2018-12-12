package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.Vo;

public interface EcGoodsService {


    //查询所有商品
    Vo selectAllGoods();

    //根据类型id查询商品
    Vo selectGoodsByType(int typeid);

    //根据商品id查询商品及商品图片
    Vo selectGoodsById(int gid);
}
