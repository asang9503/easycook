package com.eco.easycook.pojo;

public class EcFoodtype {
    private Integer ecFid;

    private String ecFtypename;

    public Integer getEcFid() {
        return ecFid;
    }

    public void setEcFid(Integer ecFid) {
        this.ecFid = ecFid;
    }

    public String getEcFtypename() {
        return ecFtypename;
    }

    public void setEcFtypename(String ecFtypename) {
        this.ecFtypename = ecFtypename == null ? null : ecFtypename.trim();
    }
}