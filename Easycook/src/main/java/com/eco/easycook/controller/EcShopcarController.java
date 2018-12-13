package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.pojo.EcShopcar;
import com.eco.easycook.service.EcShopcarService;
import com.eco.easycook.util.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value = "购物车接口", tags = {"购物车接口"})
public class EcShopcarController {

    @Autowired
    private EcShopcarService ecShopcarService;


    @GetMapping("/selectShopcarById")
    @ApiOperation(value = "根据用户id查询购物车信息",httpMethod = "GET",notes = "根据用户id查询购物车信息" )
    public ResultBean selectShopcarById(int uid) {

        return ecShopcarService.selectShopcarById(uid);
    }


    @GetMapping("/deleteGoodsBySid")
    @ApiOperation(value = "根据购物车id删除某件商品",httpMethod = "GET",notes = "根据购物车id删除某件商品" )
    public ResultBean deleteGoodsBySid(int sid) {

        return ecShopcarService.deleteGoodsBySid(sid);
    }

    @GetMapping("/insertGoods")
    @ApiOperation(value = "添加新的购物车",httpMethod = "GET",notes = "添加新的购物车" )
    public ResultBean insertGoods(EcShopcar ecShopcar) {

        return ecShopcarService.insertGoods(ecShopcar);
    }

    @GetMapping("/updateNum")
    @ApiOperation(value = "修改商品的数量",httpMethod = "GET",notes = "修改商品的数量" )
    public ResultBean updateNum(int goodsNum, int shopcarId) {

        return ecShopcarService.updateNum(goodsNum, shopcarId);
    }
}
