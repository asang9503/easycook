package com.eco.easycook.pojo;

import java.util.List;

public class EcGoods {
    private Integer ecGid;

    private String ecGname;

    private Integer ecGtypeid;

    private Integer ecGprice;

    private String ecGphoto;

    private String ecGgrade;

    private String ecGdescs;

    private String ecTname;

    private List<EcGoodsimg> ecGoodsimg;

    private EcShopcar ecShopcar;

    public EcShopcar getEcShopcar() {
        return ecShopcar;
    }

    public void setEcShopcar(EcShopcar ecShopcar) {
        this.ecShopcar = ecShopcar;
    }

    public List<EcGoodsimg> getEcGoodsimg() {
        return ecGoodsimg;
    }

    public void setEcGoodsimg(List<EcGoodsimg> ecGoodsimg) {
        this.ecGoodsimg = ecGoodsimg;
    }

    public String getEcTname() {
        return ecTname;
    }

    public void setEcTname(String ecTname) {
        this.ecTname = ecTname;
    }

    public Integer getEcGid() {
        return ecGid;
    }

    public void setEcGid(Integer ecGid) {
        this.ecGid = ecGid;
    }

    public String getEcGname() {
        return ecGname;
    }

    public void setEcGname(String ecGname) {
        this.ecGname = ecGname == null ? null : ecGname.trim();
    }

    public Integer getEcGtypeid() {
        return ecGtypeid;
    }

    public void setEcGtypeid(Integer ecGtypeid) {
        this.ecGtypeid = ecGtypeid;
    }

    public Integer getEcGprice() {
        return ecGprice;
    }

    public void setEcGprice(Integer ecGprice) {
        this.ecGprice = ecGprice;
    }

    public String getEcGphoto() {
        return ecGphoto;
    }

    public void setEcGphoto(String ecGphoto) {
        this.ecGphoto = ecGphoto == null ? null : ecGphoto.trim();
    }

    public String getEcGgrade() {
        return ecGgrade;
    }

    public void setEcGgrade(String ecGgrade) {
        this.ecGgrade = ecGgrade == null ? null : ecGgrade.trim();
    }

    public String getEcGdescs() {
        return ecGdescs;
    }

    public void setEcGdescs(String ecGdescs) {
        this.ecGdescs = ecGdescs == null ? null : ecGdescs.trim();
    }
}