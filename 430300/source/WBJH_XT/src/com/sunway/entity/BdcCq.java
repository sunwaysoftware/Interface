package com.sunway.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "BDC_CQ", schema = "wbjh_tax")
public class BdcCq implements Serializable {
    @Id
    @GenericGenerator(name = "appID", strategy = "uuid")
    @GeneratedValue(generator = "appID")
    private String id;
    private String ywh;
    private String bdcdyh;
    private String bdcqzh;
    private Double jyjg;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date jysj;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date htqdsj;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fzrq;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date cssj;
    @ManyToOne(targetEntity = BdcFwxzDict.class)
    @JoinColumn(name = "fwxz")
    private BdcFwxzDict dictFwxz;
    @ManyToOne(targetEntity = BdcCqlyDict.class)
    @JoinColumn(name = "cqly")
    private BdcCqlyDict dictCqly;
    @ManyToOne(targetEntity = BdcYwztDict.class)
    @JoinColumn(name = "ywzt")
    private BdcYwztDict dictYwzt;

    //---------------- 查询使用，不映射 ----------------------------------------
    @Transient
    private String qlr;

    //-------------------------------------------------------------------------
    public BdcCq() {}
    public BdcCq(String id) {this.id = id;}
    public BdcCq(String id, String ywh, String bdcdyh, String bdcqzh, Double jyjg, Date fzrq) {
        this.id = id;
        this.ywh = ywh;
        this.bdcdyh = bdcdyh;
        this.bdcqzh = bdcqzh;
        this.jyjg = jyjg;
        this.fzrq = fzrq;
    }

    //--------------------------- setter and getter ----------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYwh() {
        return ywh;
    }

    public void setYwh(String ywh) {
        this.ywh = ywh;
    }

    public String getBdcdyh() {
        return bdcdyh;
    }

    public void setBdcdyh(String bdcdyh) {
        this.bdcdyh = bdcdyh;
    }

    public String getBdcqzh() {
        return bdcqzh;
    }

    public void setBdcqzh(String bdcqzh) {
        this.bdcqzh = bdcqzh;
    }

    public Double getJyjg() {
        return jyjg;
    }

    public void setJyjg(Double jyjg) {
        this.jyjg = jyjg;
    }

    public Date getJysj() {
        return jysj;
    }

    public void setJysj(Date jysj) {
        this.jysj = jysj;
    }

    public Date getHtqdsj() {
        return htqdsj;
    }

    public void setHtqdsj(Date htqdsj) {
        this.htqdsj = htqdsj;
    }

    public Date getFzrq() {
        return fzrq;
    }

    public void setFzrq(Date fzrq) {
        this.fzrq = fzrq;
    }

    public Date getCssj() {
        return cssj;
    }

    public void setCssj(Date cssj) {
        this.cssj = cssj;
    }

    public BdcFwxzDict getDictFwxz() {
        return dictFwxz;
    }

    public void setDictFwxz(BdcFwxzDict dictFwxz) {
        this.dictFwxz = dictFwxz;
    }

    public BdcCqlyDict getDictCqly() {
        return dictCqly;
    }

    public void setDictCqly(BdcCqlyDict dictCqly) {
        this.dictCqly = dictCqly;
    }

    public BdcYwztDict getDictYwzt() {
        return dictYwzt;
    }

    public void setDictYwzt(BdcYwztDict dictYwzt) {
        this.dictYwzt = dictYwzt;
    }

    public String getQlr() {
        return qlr;
    }

    public void setQlr(String qlr) {
        this.qlr = qlr;
    }
}
