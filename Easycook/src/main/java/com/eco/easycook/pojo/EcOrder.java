package com.eco.easycook.pojo;

import java.util.Date;

//订单类
public class EcOrder {
    private Integer ecOid;

    private Integer userId;

    private Integer ecOallprice;

    private Date ecTime;

    private String address;

    private Integer goodsNum;

    private Date payTime;

    private Integer ecState;

    public Integer getEcOid() {
        return ecOid;
    }

    public void setEcOid(Integer ecOid) {
        this.ecOid = ecOid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getEcOallprice() {
        return ecOallprice;
    }

    public void setEcOallprice(Integer ecOallprice) {
        this.ecOallprice = ecOallprice;
    }

    public Date getEcTime() {
        return ecTime;
    }

    public void setEcTime(Date ecTime) {
        this.ecTime = ecTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getEcState() {
        return ecState;
    }

    public void setEcState(Integer ecState) {
        this.ecState = ecState;
    }
}