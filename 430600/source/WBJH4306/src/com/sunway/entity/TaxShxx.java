package com.sunway.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TAX_SWSH_TS")
public class TaxShxx implements Serializable {
	private static final long serialVersionUID = -8712173041203403464L;
	@Id
    @GenericGenerator(name = "appID", strategy = "uuid")
    @GeneratedValue(generator = "appID")
    private String id;
    private String ywh;
    private String shr;
    private String shyj;
    @ManyToOne(targetEntity = TaxShjgDict.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "shjg")
    private TaxShjgDict dictShjg;
    private String jbr;
    private String jsdw;
    private Double jsfje;
    private String swjg;
    private String sfws;
    private String sphm;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date wssj;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date shsj;

    //----------------------- Constructor -------------------------
    public TaxShxx() {}
    public TaxShxx(String id){
        this.id = id;
    }

    //------------------ Setter and Getter ------------------------
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

    public String getShr() {
        return shr;
    }

    public void setShr(String shr) {
        this.shr = shr;
    }

    public String getShyj() {
        return shyj;
    }

    public void setShyj(String shyj) {
        this.shyj = shyj;
    }

    public TaxShjgDict getDictShjg() {
        return dictShjg;
    }

    public void setDictShjg(TaxShjgDict dictShjg) {
        this.dictShjg = dictShjg;
    }

    public String getJbr() {
        return jbr;
    }

    public void setJbr(String jbr) {
        this.jbr = jbr;
    }

    public String getJsdw() {
        return jsdw;
    }

    public void setJsdw(String jsdw) {
        this.jsdw = jsdw;
    }

    public Double getJsfje() {
        return jsfje;
    }

    public void setJsfje(Double jsfje) {
        this.jsfje = jsfje;
    }

    public String getSwjg() {
        return swjg;
    }

    public void setSwjg(String swjg) {
        this.swjg = swjg;
    }

    public String getSfws() {
        return sfws;
    }

    public void setSfws(String sfws) {
        this.sfws = sfws;
    }

    public String getSphm() {
        return sphm;
    }

    public void setSphm(String sphm) {
        this.sphm = sphm;
    }

    public Date getWssj() {
        return wssj;
    }

    public void setWssj(Date wssj) {
        this.wssj = wssj;
    }

    public Date getShsj() {
        return shsj;
    }

    public void setShsj(Date shsj) {
        this.shsj = shsj;
    }
}
