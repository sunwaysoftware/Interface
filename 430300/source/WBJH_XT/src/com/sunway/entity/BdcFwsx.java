package com.sunway.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BDC_FWSX")
public class BdcFwsx implements Serializable {
    @Id
    @GenericGenerator(name = "appID", strategy = "uuid")
    @GeneratedValue(generator = "appID")
    private String id;
    private String ywh;
    private String houseid;
    private String roomnum;
    private String bsit;
    private Double barea;
    @ManyToOne(targetEntity = BdcGhytDict.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "buse")
    private BdcGhytDict dictGhty;  // 规划用途
    @ManyToOne(targetEntity = BdcFwlxDict.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "fwlx")
    private BdcFwlxDict dictFwlx;  // 房屋类型
    private Integer curflr;
    private Integer ttlflrs;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fnshdate;
    @ManyToOne(targetEntity = BdcJzjgDict.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "bstruct")
    private BdcJzjgDict dictJzjg;     // 建筑结构
    private String bdcdyh;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date cssj;
    private Double tnmj;
    private String cg;
    private String cx;
    private String df;
    private String jg;
    private String zxqk;
    private String sfsyfc;
    @ManyToOne(targetEntity = BdcJylxDict.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "jylx")
    private BdcJylxDict dictJylx;        // 交易类型
    private Double htzj;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date fzrq;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date jysj;
    private String bdcqzh;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date qswsrq;
    private Double qswsjs;

    @OneToMany(targetEntity = BdcQlr.class, mappedBy = "fwsx", fetch = FetchType.EAGER)    //一对多，让一方维护外键
    private Set<BdcQlr> qlrList = new HashSet<BdcQlr>();

    public BdcFwsx() {
    }

    public BdcFwsx(String id) {
        this.id = id;
    }

    public BdcFwsx(String id, String ywh, String bsit, Double barea, String bdcdyh, String bdcqzh) {
        this.id = id;
        this.ywh = ywh;
        this.bsit = bsit;
        this.barea = barea;
        this.bdcdyh = bdcdyh;
        this.bdcqzh = bdcqzh;
    }

    //------------------------------ setter and getter ---------------------------------------
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

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public String getBsit() {
        return bsit;
    }

    public void setBsit(String bsit) {
        this.bsit = bsit;
    }

    public Double getBarea() {
        return barea;
    }

    public void setBarea(Double barea) {
        this.barea = barea;
    }

    public BdcFwlxDict getDictFwlx() {
        return dictFwlx;
    }

    public void setDictFwlx(BdcFwlxDict dictFwlx) {
        this.dictFwlx = dictFwlx;
    }

    public Integer getCurflr() {
        return curflr;
    }

    public void setCurflr(Integer curflr) {
        this.curflr = curflr;
    }

    public Integer getTtlflrs() {
        return ttlflrs;
    }

    public void setTtlflrs(Integer ttlflrs) {
        this.ttlflrs = ttlflrs;
    }

    public Date getFnshdate() {
        return fnshdate;
    }

    public void setFnshdate(Date fnshdate) {
        this.fnshdate = fnshdate;
    }

    public String getBzcdyh() {
        return bdcdyh;
    }

    public void setBzcdyh(String bdcdyh) {
        this.bdcdyh = bdcdyh;
    }

    public Date getCssj() {
        return cssj;
    }

    public void setCssj(Date cssj) {
        this.cssj = cssj;
    }

    public Double getTnmj() {
        return tnmj;
    }

    public void setTnmj(Double tnmj) {
        this.tnmj = tnmj;
    }

    public String getCg() {
        return cg;
    }

    public void setCg(String cg) {
        this.cg = cg;
    }

    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }

    public String getDf() {
        return df;
    }

    public void setDf(String df) {
        this.df = df;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getZxqk() {
        return zxqk;
    }

    public void setZxqk(String zxqk) {
        this.zxqk = zxqk;
    }

    public String getSfsyfc() {
        return sfsyfc;
    }

    public void setSfsyfc(String sfsyfc) {
        this.sfsyfc = sfsyfc;
    }

    public Double getHtzj() {
        return htzj;
    }

    public void setHtzj(Double htzj) {
        this.htzj = htzj;
    }

    public Date getFzrq() {
        return fzrq;
    }

    public void setFzrq(Date fzrq) {
        this.fzrq = fzrq;
    }

    public Date getJysj() {
        return jysj;
    }

    public void setJysj(Date jysj) {
        this.jysj = jysj;
    }

    public String getBdczh() {
        return bdcqzh;
    }

    public void setBdczh(String bdcqzh) {
        this.bdcqzh = bdcqzh;
    }

    public Date getQswsrq() {
        return qswsrq;
    }

    public void setQswsrq(Date qswsrq) {
        this.qswsrq = qswsrq;
    }

    public Double getQswsjs() {
        return qswsjs;
    }

    public void setQswsjs(Double qswsjs) {
        this.qswsjs = qswsjs;
    }

    public Set<BdcQlr> getQlrList() {
        return qlrList;
    }

    public void setQlrList(Set<BdcQlr> qlrList) {
        this.qlrList = qlrList;
    }

    public BdcGhytDict getDictGhty() {
        return dictGhty;
    }

    public void setDictGhty(BdcGhytDict dictGhty) {
        this.dictGhty = dictGhty;
    }

    public BdcJzjgDict getDictJzjg() {
        return dictJzjg;
    }

    public void setDictJzjg(BdcJzjgDict dictJzjg) {
        this.dictJzjg = dictJzjg;
    }

    public BdcJylxDict getDictJylx() {
        return dictJylx;
    }

    public void setDictJylx(BdcJylxDict dictJylx) {
        this.dictJylx = dictJylx;
    }
}
