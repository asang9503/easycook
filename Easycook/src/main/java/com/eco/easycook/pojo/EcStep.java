package com.eco.easycook.pojo;

public class EcStep {
    private Integer ecId;

    private Integer ecCid;

    private Integer ecContent;

    private String imgurl;

    public Integer getEcId() {
        return ecId;
    }

    public void setEcId(Integer ecId) {
        this.ecId = ecId;
    }

    public Integer getEcCid() {
        return ecCid;
    }

    public void setEcCid(Integer ecCid) {
        this.ecCid = ecCid;
    }

    public Integer getEcContent() {
        return ecContent;
    }

    public void setEcContent(Integer ecContent) {
        this.ecContent = ecContent;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }
}