package com.sunway.entity.tax;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="TAX_TSXX")
public class TaxTsxx implements Serializable {
    @Id
    @GenericGenerator(name = "appID", strategy = "uuid")
    @GeneratedValue(generator = "appID")
    private String id;
    private String ywh;
    private Double tsje;
    private String swjg;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date tssj;
    private String nsrmc;
    private String nsrsbh;
    private String tsyy;
    private String jbr;

    public TaxTsxx(){}
    public TaxTsxx(String id){ this.id = id; }

    //--------------------------- setter and getter ---------------------------------
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

    public Double getTsje() {
        return tsje;
    }

    public void setTsje(Double tsje) {
        this.tsje = tsje;
    }

    public String getSwjg() {
        return swjg;
    }

    public void setSwjg(String swjg) {
        this.swjg = swjg;
    }

    public Date getTssj() {
        return tssj;
    }

    public void setTssj(Date tssj) {
        this.tssj = tssj;
    }

    public String getNsrmc() {
        return nsrmc;
    }

    public void setNsrmc(String nsrmc) {
        this.nsrmc = nsrmc;
    }

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public String getTsyy() {
        return tsyy;
    }

    public void setTsyy(String tsyy) {
        this.tsyy = tsyy;
    }

    public String getJbr() {
        return jbr;
    }

    public void setJbr(String jbr) {
        this.jbr = jbr;
    }
}
