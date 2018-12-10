package com.eco.easycook.pojo;

//商品类型
public class EcGoodstype {
    private Integer ecTid;

    private String ecTname;

    public Integer getEcTid() {
        return ecTid;
    }

    public void setEcTid(Integer ecTid) {
        this.ecTid = ecTid;
    }

    public String getEcTname() {
        return ecTname;
    }

    public void setEcTname(String ecTname) {
        this.ecTname = ecTname == null ? null : ecTname.trim();
    }
}