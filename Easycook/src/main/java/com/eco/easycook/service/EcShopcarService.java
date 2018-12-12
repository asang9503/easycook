package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.Vo;

public interface EcShopcarService {


    Vo selectShopcarById(int uid);

    Boolean deleteGoodsBySid(int sid);
}
