package com.eco.easycook.pojo;

public class EcComment {
    private Integer ecCid;

    private Integer ecUid;

    private Integer ecVid;

    private String ecConnent;

    public Integer getEcCid() {
        return ecCid;
    }

    public void setEcCid(Integer ecCid) {
        this.ecCid = ecCid;
    }

    public Integer getEcUid() {
        return ecUid;
    }

    public void setEcUid(Integer ecUid) {
        this.ecUid = ecUid;
    }

    public Integer getEcVid() {
        return ecVid;
    }

    public void setEcVid(Integer ecVid) {
        this.ecVid = ecVid;
    }

    public String getEcConnent() {
        return ecConnent;
    }

    public void setEcConnent(String ecConnent) {
        this.ecConnent = ecConnent == null ? null : ecConnent.trim();
    }
}