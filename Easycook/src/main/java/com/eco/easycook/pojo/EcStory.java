package com.eco.easycook.pojo;


import java.util.List;

public class EcStory {
    private Integer ecSid;

    private Integer ecUid;

    private String ecScontent;

    private String ecTime;

    private Integer ecFlag;

    private List<String> img;

    private EcStoryimg imgs;

    private Integer ecVoteCount;

    private EcUser user;

    private String EcTitle;

    private Integer ecCommentCount;

    private Integer seeCount;

    public EcStoryimg getImgs() {
        return imgs;
    }

    public void setImgs(EcStoryimg imgs) {
        this.imgs = imgs;
    }

    public Integer getSeeCount() {
        return seeCount;
    }

    public void setSeeCount(Integer seeCount) {
        this.seeCount = seeCount;
    }

    public Integer getEcCommentCount() {
        return ecCommentCount;
    }

    public void setEcCommentCount(Integer ecCommentCount) {
        this.ecCommentCount = ecCommentCount;
    }

    public String getEcTitle() {
        return EcTitle;
    }

    public void setEcTitle(String ecTitle) {
        EcTitle = ecTitle;
    }

    public EcUser getUser() {
        return user;
    }

    public void setUser(EcUser user) {
        this.user = user;
    }

    public Integer getEcVoteCount() {
        return ecVoteCount;
    }

    public void setEcVoteCount(Integer ecVoteCount) {
        this.ecVoteCount = ecVoteCount;
    }

    public List<String> getImg() {
        return img;
    }

    public void setImg(List<String> img) {
        this.img = img;
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

    @Override
    public String toString() {
        return "EcStory{" +
                "ecSid=" + ecSid +
                ", ecUid=" + ecUid +
                ", ecScontent='" + ecScontent + '\'' +
                ", ecTime='" + ecTime + '\'' +
                ", ecFlag=" + ecFlag +
                ", img=" + img +
                ", imgs=" + imgs +
                ", ecVoteCount=" + ecVoteCount +
                ", user=" + user +
                ", EcTitle='" + EcTitle + '\'' +
                ", ecCommentCount=" + ecCommentCount +
                ", seeCount=" + seeCount +
                '}';
    }
}