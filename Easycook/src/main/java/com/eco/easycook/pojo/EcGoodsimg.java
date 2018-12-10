package com.eco.easycook.pojo;

//商品图片类
public class EcGoodsimg {
    private Integer ecGimgid;

    private String ecImgurl;

    private Integer ecGid;

    private EcGoods ecGoods;

    public EcGoods getEcGoods() {
        return ecGoods;
    }

    public void setEcGoods(EcGoods ecGoods) {
        this.ecGoods = ecGoods;
    }

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

    public Integer getEcGid() {
        return ecGid;
    }

    public void setEcGid(Integer ecGid) {
        this.ecGid = ecGid;
    }
}