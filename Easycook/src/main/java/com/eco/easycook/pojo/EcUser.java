package com.eco.easycook.pojo;

import java.io.Serializable;

public class EcUser implements Serializable {
    private Integer ecUid;

    private String ecUsername;

    private String ecPassword;

    private Integer ecRid;

    private Integer ecFlag;

    private Integer ecSex;

    private String ecAddress;

    private Integer ecFavorite;

    private String ecCreatname;

    private Integer ecVip;

    public Integer getEcUid() {
        return ecUid;
    }

    public void setEcUid(Integer ecUid) {
        this.ecUid = ecUid;
    }

    public String getEcUsername() {
        return ecUsername;
    }

    public void setEcUsername(String ecUsername) {
        this.ecUsername = ecUsername == null ? null : ecUsername.trim();
    }

    public String getEcPassword() {
        return ecPassword;
    }

    public void setEcPassword(String ecPassword) {
        this.ecPassword = ecPassword == null ? null : ecPassword.trim();
    }

    public Integer getEcRid() {
        return ecRid;
    }

    public void setEcRid(Integer ecRid) {
        this.ecRid = ecRid;
    }

    public Integer getEcFlag() {
        return ecFlag;
    }

    public void setEcFlag(Integer ecFlag) {
        this.ecFlag = ecFlag;
    }

    public Integer getEcSex() {
        return ecSex;
    }

    public void setEcSex(Integer ecSex) {
        this.ecSex = ecSex;
    }

    public String getEcAddress() {
        return ecAddress;
    }

    public void setEcAddress(String ecAddress) {
        this.ecAddress = ecAddress == null ? null : ecAddress.trim();
    }

    public Integer getEcFavorite() {
        return ecFavorite;
    }

    public void setEcFavorite(Integer ecFavorite) {
        this.ecFavorite = ecFavorite;
    }

    public String getEcCreatname() {
        return ecCreatname;
    }

    public void setEcCreatname(String ecCreatname) {
        this.ecCreatname = ecCreatname == null ? null : ecCreatname.trim();
    }

    public Integer getEcVip() {
        return ecVip;
    }

    public void setEcVip(Integer ecVip) {
        this.ecVip = ecVip;
    }
    
    @Override
    public String toString() {
        return "EcUser{" +
                "ecUid=" + ecUid +
                ", ecUsername='" + ecUsername + '\'' +
                ", ecPassword='" + ecPassword + '\'' +
                ", ecRid=" + ecRid +
                ", ecFlag=" + ecFlag +
                ", ecSex=" + ecSex +
                ", ecAddress='" + ecAddress + '\'' +
                ", ecFavorite=" + ecFavorite +
                ", ecCreatname='" + ecCreatname + '\'' +
                ", ecVip=" + ecVip +
                '}';
    }
}