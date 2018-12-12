package com.eco.easycook.service;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.util.ResultBean;

public interface EcShopcarService {


    ResultBean selectShopcarById(int uid);

    ResultBean deleteGoodsBySid(int sid);
}
