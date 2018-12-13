package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.util.ResultBean;

public interface EcGoodsService {


    //查询所有商品
    ResultBean selectAllGoods();

    //根据类型id查询商品
    ResultBean selectGoodsByType(int typeid);

    //根据商品id查询商品及商品图片
    ResultBean selectGoodsById(int gid);
}
