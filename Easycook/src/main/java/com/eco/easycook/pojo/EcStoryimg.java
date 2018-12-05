package com.eco.easycook.pojo;

public class EcStoryimg {
    private Integer ecSimgid;

    private String ecSimgurl;

    private Integer storyid;

    public Integer getEcSimgid() {
        return ecSimgid;
    }

    public void setEcSimgid(Integer ecSimgid) {
        this.ecSimgid = ecSimgid;
    }

    public String getEcSimgurl() {
        return ecSimgurl;
    }

    public void setEcSimgurl(String ecSimgurl) {
        this.ecSimgurl = ecSimgurl == null ? null : ecSimgurl.trim();
    }

    public Integer getStoryid() {
        return storyid;
    }

    public void setStoryid(Integer storyid) {
        this.storyid = storyid;
    }
}