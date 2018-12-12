package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.service.EcShopcarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EcShopcarController {

    @Autowired
    private EcShopcarService ecShopcarService;

    /**
     * 根据用户id查询购物车信息
     * @param uid
     * @return
     */
    @RequestMapping("/selectShopcarById")
    public Vo selectShopcarById(int uid) {

        return ecShopcarService.selectShopcarById(uid);
    }


    /**
     * 根据购物车id删除某件商品
     * @param sid
     * @return
     */
    @RequestMapping("/deleteGoodsBySid")
    public Boolean deleteGoodsBySid(int sid) {

        return ecShopcarService.deleteGoodsBySid(sid);
    }
}
