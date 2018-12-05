package com.eco.easycook.pojo;

public class Img {
    private Integer ecGimgid;

    private String ecImgurl;

    private Integer gid;

    public Integer getEcGimgid() {
        return ecGimgid;
    }

    public void setEcGimgid(Integer ecGimgid) {
        this.ecGimgid = ecGimgid;
    }

    public String getEcImgurl() {
        return ecImgurl;
    }

    public void setEcImgurl(String ecImgurl) {
        this.ecImgurl = ecImgurl == null ? null : ecImgurl.trim();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }
}