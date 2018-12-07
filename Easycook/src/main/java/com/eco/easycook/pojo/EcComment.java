package com.eco.easycook.pojo;

public class EcComment {
    private Integer ecCid;

    private Integer storyId;

    private Integer ecVid;

    private String ecConnent;

    private String uIconUrl;

    private String userName;

    private Integer uId;

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getuIconUrl() {
        return uIconUrl;
    }

    public void setuIconUrl(String uIconUrl) {
        this.uIconUrl = uIconUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getEcCid() {
        return ecCid;
    }

    public void setEcCid(Integer ecCid) {
        this.ecCid = ecCid;
    }

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
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