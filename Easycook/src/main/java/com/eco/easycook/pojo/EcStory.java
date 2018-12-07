package com.eco.easycook.pojo;

public class EcStory {
    private Integer ecSid;

    private Integer ecUid;

    private String ecScontent;

    private String ecTime;

    private Integer ecFlag;

    private Object img;

    private EcVote vote;

    private Object comment;


    public Object getImg() {
        return img;
    }

    public void setImg(Object img) {
        this.img = img;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public EcVote getVote() {
        return vote;
    }

    public void setVote(EcVote vote) {
        this.vote = vote;
    }

    public Integer getEcSid() {
        return ecSid;
    }

    public void setEcSid(Integer ecSid) {
        this.ecSid = ecSid;
    }

    public Integer getEcUid() {
        return ecUid;
    }

    public void setEcUid(Integer ecUid) {
        this.ecUid = ecUid;
    }

    public String getEcScontent() {
        return ecScontent;
    }

    public void setEcScontent(String ecScontent) {
        this.ecScontent = ecScontent == null ? null : ecScontent.trim();
    }

    public String getEcTime() {
        return ecTime;
    }

    public void setEcTime(String ecTime) {
        this.ecTime = ecTime == null ? null : ecTime.trim();
    }

    public Integer getEcFlag() {
        return ecFlag;
    }

    public void setEcFlag(Integer ecFlag) {
        this.ecFlag = ecFlag;
    }
}