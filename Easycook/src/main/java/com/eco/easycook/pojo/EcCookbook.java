package com.eco.easycook.pojo;

public class EcCookbook {
    private Integer ecCid;

    private Integer ecUid;

    private String ecCname;

    private Integer typeid;

    private String ecMaterial;

    private String ecCreatetime;

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

    public String getEcMaterial() {
        return ecMaterial;
    }

    public void setEcMaterial(String ecMaterial) {
        this.ecMaterial = ecMaterial == null ? null : ecMaterial.trim();
    }

    public String getEcCreatetime() {
        return ecCreatetime;
    }

    public void setEcCreatetime(String ecCreatetime) {
        this.ecCreatetime = ecCreatetime == null ? null : ecCreatetime.trim();
    }
}