package com.eco.easycook.pojo;

public class EcGoodstype {
    private Integer ecTid;

    private String ecTname;

    private String ecTdesc;

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

    public String getEcTdesc() {
        return ecTdesc;
    }

    public void setEcTdesc(String ecTdesc) {
        this.ecTdesc = ecTdesc == null ? null : ecTdesc.trim();
    }
}