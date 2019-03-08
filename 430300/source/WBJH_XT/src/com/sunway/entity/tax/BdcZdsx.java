package com.sunway.entity.tax;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "BDC_ZDSX", schema = "wbjh_tax")
public class BdcZdsx implements Serializable {
    @Id
    @GenericGenerator(name = "appID", strategy = "uuid")
    @GeneratedValue(generator = "appID")
    private String id;
    private String ywh;
    private String zddm;
    private String bdcdyh;
    private Double zdmj;
    private Double syqmj;
    private Double ftmj;
    private Double dlmj;
    private String syqx;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date syqqssj;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date syqjssj;
    private Double qdjg;
    private Double jsydmj;
    private String qszt;
    private String tfh;
    @ManyToOne(targetEntity = BdcTdytDict.class)
    @JoinColumn(name = "tdyt")
    private BdcTdytDict bdcTdyt;
    @ManyToOne(targetEntity = BdcTddjDict.class)
    @JoinColumn(name = "tddj")
    private BdcTddjDict dictTddj;
    @ManyToOne(targetEntity = BdcQllxDict.class)
    @JoinColumn(name = "qllx")
    private BdcQllxDict dictQllx;
    @ManyToOne(targetEntity = BdcQlxzDict.class)
    @JoinColumn(name = "qlxz")
    private BdcQlxzDict dictQlxz;
    private String tdzl;
    private String zdh;
    private String djh;
    private String dz;
    private String xz;
    private String nz;
    private String bz;
    private Double jzrjl;
    private Double jzmd;
    private Double tdjg;

    //---------------- 查询使用，不映射 ----------------------------------------
    @Transient
    private String qlr;

    //-----------------------------------------------------------
    public BdcZdsx(){}
    public BdcZdsx(String id) {
        this.id = id;
    }
    public BdcZdsx(String id, String ywh, String zddm, Double zdmj, String zdh, String djh) {
        this.id = id;
        this.ywh = ywh;
        this.zddm = zddm;
        this.zdmj = zdmj;
        this.zdh = zdh;
        this.djh = djh;
    }

    //---------------------- setter and getter -------------------
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

    public String getZddm() {
        return zddm;
    }

    public void setZddm(String zddm) {
        this.zddm = zddm;
    }

    public String getBdcdyh() {
        return bdcdyh;
    }

    public void setBdcdyh(String bdcdyh) {
        this.bdcdyh = bdcdyh;
    }

    public Double getZdmj() {
        return zdmj;
    }

    public void setZdmj(Double zdmj) {
        this.zdmj = zdmj;
    }

    public Double getSyqmj() {
        return syqmj;
    }

    public void setSyqmj(Double syqmj) {
        this.syqmj = syqmj;
    }

    public Double getFtmj() {
        return ftmj;
    }

    public void setFtmj(Double ftmj) {
        this.ftmj = ftmj;
    }

    public Double getDlmj() {
        return dlmj;
    }

    public void setDlmj(Double dlmj) {
        this.dlmj = dlmj;
    }

    public String getSyqx() {
        return syqx;
    }

    public void setSyqx(String syqx) {
        this.syqx = syqx;
    }

    public Date getSyqqssj() {
        return syqqssj;
    }

    public void setSyqqssj(Date syqqssj) {
        this.syqqssj = syqqssj;
    }

    public Date getSyqjssj() {
        return syqjssj;
    }

    public void setSyqjssj(Date syqjssj) {
        this.syqjssj = syqjssj;
    }

    public Double getQdjg() {
        return qdjg;
    }

    public void setQdjg(Double qdjg) {
        this.qdjg = qdjg;
    }

    public Double getJsydmj() {
        return jsydmj;
    }

    public void setJsydmj(Double jsydmj) {
        this.jsydmj = jsydmj;
    }

    public String getQszt() {
        return qszt;
    }

    public void setQszt(String qszt) {
        this.qszt = qszt;
    }

    public String getTfh() {
        return tfh;
    }

    public void setTfh(String tfh) {
        this.tfh = tfh;
    }

    public BdcTdytDict getBdcTdyt() {
        return bdcTdyt;
    }

    public void setBdcTdyt(BdcTdytDict bdcTdyt) {
        this.bdcTdyt = bdcTdyt;
    }

    public BdcTddjDict getDictTddj() {
        return dictTddj;
    }

    public void setDictTddj(BdcTddjDict dictTddj) {
        this.dictTddj = dictTddj;
    }

    public Double getTdjg() {
        return tdjg;
    }

    public void setTdjg(Double tdjg) {
        this.tdjg = tdjg;
    }

    public BdcQllxDict getDictQllx() {
        return dictQllx;
    }

    public void setDictQllx(BdcQllxDict dictQllx) {
        this.dictQllx = dictQllx;
    }

    public BdcQlxzDict getDictQlxz() {
        return dictQlxz;
    }

    public void setDictQlxz(BdcQlxzDict dictQlxz) {
        this.dictQlxz = dictQlxz;
    }

    public String getTdzl() {
        return tdzl;
    }

    public void setTdzl(String tdzl) {
        this.tdzl = tdzl;
    }

    public String getZdh() {
        return zdh;
    }

    public void setZdh(String zdh) {
        this.zdh = zdh;
    }

    public String getDjh() {
        return djh;
    }

    public void setDjh(String djh) {
        this.djh = djh;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz;
    }

    public String getNz() {
        return nz;
    }

    public void setNz(String nz) {
        this.nz = nz;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Double getJzrjl() {
        return jzrjl;
    }

    public void setJzrjl(Double jzrjl) {
        this.jzrjl = jzrjl;
    }

    public Double getJzmd() {
        return jzmd;
    }

    public void setJzmd(Double jzmd) {
        this.jzmd = jzmd;
    }

    public String getQlr() {
        return qlr;
    }

    public void setQlr(String qlr) {
        this.qlr = qlr;
    }
}
