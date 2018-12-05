package com.eco.easycook.pojo;

public class Product {
    private Integer ecGid;

    private String ecGname;

    private Integer ecGtypeid;

    private String ecGprice;

    private Integer ecGmonthsales;

    private Integer ecGsales;

    private String ecGgrade;

    private String ecGdescs;

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

    public String getEcGprice() {
        return ecGprice;
    }

    public void setEcGprice(String ecGprice) {
        this.ecGprice = ecGprice == null ? null : ecGprice.trim();
    }

    public Integer getEcGmonthsales() {
        return ecGmonthsales;
    }

    public void setEcGmonthsales(Integer ecGmonthsales) {
        this.ecGmonthsales = ecGmonthsales;
    }

    public Integer getEcGsales() {
        return ecGsales;
    }

    public void setEcGsales(Integer ecGsales) {
        this.ecGsales = ecGsales;
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