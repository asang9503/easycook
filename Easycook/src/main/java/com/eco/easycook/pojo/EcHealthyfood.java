package com.eco.easycook.pojo;

public class EcHealthyfood {
    private Integer ecHid;

    private String ecHfname;

    public Integer getEcHid() {
        return ecHid;
    }

    public void setEcHid(Integer ecHid) {
        this.ecHid = ecHid;
    }

    public String getEcHfname() {
        return ecHfname;
    }

    public void setEcHfname(String ecHfname) {
        this.ecHfname = ecHfname == null ? null : ecHfname.trim();
    }
}