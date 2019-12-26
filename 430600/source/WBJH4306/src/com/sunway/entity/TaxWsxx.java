package com.sunway.entity;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="TAX_SWXX")
public class TaxWsxx implements Serializable {
	private static final long serialVersionUID = -4170917501304579891L;
	@Id
    @GenericGenerator(name = "appID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "appID")
    private String id;
    private String ywh;
    private String ypzh;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date sksssq;
    private Double jsjg;
    private Double seZzs;
    private Double seCjs;
    private Double seDfjys;
    private Double seTdzzs;
    private Double seGrsds;
    private Double seQs;
    private Double seYhs;
    private String fphm;
    private String csfsphm;
    private String zrfsphm;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date wsrq;
    private String ssjm;
    private String pgid;
    private Double pgjg;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date insTime;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updTime;

    //-------------------------------------------------------
    public TaxWsxx(){}
    public TaxWsxx(String id){
        this.id = id;
    }
    //-------------------------------------------------------
    public String getYwh() {
        return ywh;
    }

    public void setYwh(String ywh) {
        this.ywh = ywh;
    }

    public String getYpzh() {
        return ypzh;
    }

    public void setYpzh(String ypzh) {
        this.ypzh = ypzh;
    }

    public Date getSksssq() {
        return sksssq;
    }

    public void setSksssq(Date sksssq) {
        this.sksssq = sksssq;
    }

    public Double getJsjg() {
        return jsjg;
    }

    public void setJsjg(Double jsjg) {
        this.jsjg = jsjg;
    }

    public Double getSeZzs() {
        return seZzs;
    }

    public void setSeZzs(Double seZzs) {
        this.seZzs = seZzs;
    }

    public Double getSeCjs() {
        return seCjs;
    }

    public void setSeCjs(Double seCjs) {
        this.seCjs = seCjs;
    }

    public Double getSeDfjys() {
        return seDfjys;
    }

    public void setSeDfjys(Double seDfjys) {
        this.seDfjys = seDfjys;
    }

    public Double getSeTdzzs() {
        return seTdzzs;
    }

    public void setSeTdzzs(Double seTdzzs) {
        this.seTdzzs = seTdzzs;
    }

    public Double getSeGrsds() {
        return seGrsds;
    }

    public void setSeGrsds(Double seGrsds) {
        this.seGrsds = seGrsds;
    }

    public Double getSeQs() {
        return seQs;
    }

    public void setSeQs(Double seQs) {
        this.seQs = seQs;
    }

    public Double getSeYhs() {
        return seYhs;
    }

    public void setSeYhs(Double seYhs) {
        this.seYhs = seYhs;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public String getCsfsphm() {
        return csfsphm;
    }

    public void setCsfsphm(String csfsphm) {
        this.csfsphm = csfsphm;
    }

    public String getZrfsphm() {
        return zrfsphm;
    }

    public void setZrfsphm(String zrfsphm) {
        this.zrfsphm = zrfsphm;
    }

    public Date getWsrq() {
        return wsrq;
    }

    public void setWsrq(Date wsrq) {
        this.wsrq = wsrq;
    }

    public String getSsjm() {
        return ssjm;
    }

    public void setSsjm(String ssjm) {
        this.ssjm = ssjm;
    }

    public String getPgid() {
        return pgid;
    }

    public void setPgid(String pgid) {
        this.pgid = pgid;
    }

    public Double getPgjg() {
        return pgjg;
    }

    public void setPgjg(Double pgjg) {
        this.pgjg = pgjg;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Date getInsTime() {
        return insTime;
    }

    public void setInsTime(Date insTime) {
        this.insTime = insTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}