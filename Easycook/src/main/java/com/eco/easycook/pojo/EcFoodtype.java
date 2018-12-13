package com.eco.easycook.pojo;

public class EcFoodtype {
    private Integer ecId;

    private String ecTypename;

    private Integer ecPid;

    public Integer getEcId() {
        return ecId;
    }

    public void setEcId(Integer ecId) {
        this.ecId = ecId;
    }

    public String getEcTypename() {
        return ecTypename;
    }

    public void setEcTypename(String ecTypename) {
        this.ecTypename = ecTypename == null ? null : ecTypename.trim();
    }

    public Integer getEcPid() {
        return ecPid;
    }

    public void setEcPid(Integer ecPid) {
        this.ecPid = ecPid;
    }
}