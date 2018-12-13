package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.ResponseVo;
import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.service.EcGoodsService;
import com.eco.easycook.util.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "商品展示接口", tags = {"商品接口"})
public class EcGoodsController {

    @Autowired
    private EcGoodsService ecGoodsService;


    @GetMapping("/selectAllGoods")
    @ApiOperation(value = "查询所有的商品信息",httpMethod = "GET",notes = "展示所有商品信息" )
    public ResultBean selectAllGoods() {

        return ecGoodsService.selectAllGoods();
    }


    @GetMapping("/selectGoodsByType")
    @ApiOperation(value = "根据商品类型查询商品信息",httpMethod = "GET",notes = "根据商品类型查询商品信息" )
    public ResultBean selectGoodsByType(int typeid) {
        return ecGoodsService.selectGoodsByType(typeid);
    }



    @GetMapping("/selectGoodsById")
    @ApiOperation(value = "根据商品id查询商品详情信息",httpMethod = "GET",notes = "根据商品id查询商品详情信息" )
    public ResultBean selectGoodsById(int gid) {

        return ecGoodsService.selectGoodsById(gid);
    }
}
