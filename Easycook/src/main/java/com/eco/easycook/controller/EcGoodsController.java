package com.eco.easycook.controller;

import com.eco.easycook.ResponseVo.Vo;
import com.eco.easycook.service.EcGoodsService;
import com.eco.easycook.util.ResultBean;
import com.eco.easycook.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EcGoodsController {

    @Autowired
    private EcGoodsService ecGoodsService;

    /**
     * 查询所有商品信息
      * @return
     */
    @GetMapping("/selectAllGoods")
    public Vo selectAllGoods() {

        return ecGoodsService.selectAllGoods();
    }

    /**
     * 根据商品类型查询商品信息
     * @param typeid
     * @return
     */
    @GetMapping("/selectGoodsByType")
    public Vo selectGoodsByType(int typeid) {
        return ecGoodsService.selectGoodsByType(typeid);
    }


    /**
     * 根据商品id查询商品详情信息
     * @param gid
     * @return
     */
    @GetMapping("/selectGoodsById")
    public Vo selectGoodsById(int gid) {
        return ecGoodsService.selectGoodsById(gid);
    }
}
