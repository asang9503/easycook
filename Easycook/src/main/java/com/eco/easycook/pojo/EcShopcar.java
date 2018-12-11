package com.eco.easycook.pojo;

import java.util.List;

//购物车类
public class EcShopcar {
    private Integer shopcarId;

    private Integer userId;

    private Integer goodsId;

    private Integer goodsNum;

    private List<EcGoods> ecGoods;

    public List<EcGoods> getEcGoods() {
        return ecGoods;
    }

    public void setEcGoods(List<EcGoods> ecGoods) {
        this.ecGoods = ecGoods;
    }

    public Integer getShopcarId() {
        return shopcarId;
    }

    public void setShopcarId(Integer shopcarId) {
        this.shopcarId = shopcarId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }
}