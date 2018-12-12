package com.eco.easycook.pojo;

public class EcCookbook {
    private Integer ecId;

    private Integer ecUid;

    private String ecCname;

    private String collect;

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    private Integer typeid;

    private String ecCoverimg;

    private String ecMaterial;

    private String ecContent;

    private Integer ecCreatetime;

    private Integer ecFlag;

    public Integer getEcId() {
        return ecId;
    }

    public void setEcId(Integer ecId) {
        this.ecId = ecId;
    }

    public Integer getEcUid() {
        return ecUid;
    }

    public void setEcUid(Integer ecUid) {
        this.ecUid = ecUid;
    }

    public String getEcCname() {
        return ecCname;
    }

    public void setEcCname(String ecCname) {
        this.ecCname = ecCname == null ? null : ecCname.trim();
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getEcCoverimg() {
        return ecCoverimg;
    }

    public void setEcCoverimg(String ecCoverimg) {
        this.ecCoverimg = ecCoverimg == null ? null : ecCoverimg.trim();
    }

    public String getEcMaterial() {
        return ecMaterial;
    }

    public void setEcMaterial(String ecMaterial) {
        this.ecMaterial = ecMaterial == null ? null : ecMaterial.trim();
    }

    public String getEcContent() {
        return ecContent;
    }

    public void setEcContent(String ecContent) {
        this.ecContent = ecContent == null ? null : ecContent.trim();
    }

    public Integer getEcCreatetime() {
        return ecCreatetime;
    }

    public void setEcCreatetime(Integer ecCreatetime) {
        this.ecCreatetime = ecCreatetime;
    }

    public Integer getEcFlag() {
        return ecFlag;
    }

    public void setEcFlag(Integer ecFlag) {
        this.ecFlag = ecFlag;
    }
}