package com.sunway.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="TAX_SPFJ")
public class TaxSpfj implements Serializable {
    @Id
    @GenericGenerator(name = "appID", strategy = "uuid")
    @GeneratedValue(generator = "appID")
    private String id;
    private String ywh;
    private String splx;
    private String ljdz;
    private String bz;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date sprq;

    //----------------------- Constructor -------------------------
    public TaxSpfj() {}
    public TaxSpfj(String id){this.id = id;}

    //----------------------- setter and getter -------------------
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

    public String getSplx() {
        return splx;
    }

    public void setSplx(String splx) {
        this.splx = splx;
    }

    public String getLjdz() {
        return ljdz;
    }

    public void setLjdz(String ljdz) {
        this.ljdz = ljdz;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public Date getSprq() {
        return sprq;
    }

    public void setSprq(Date sprq) {
        this.sprq = sprq;
    }
}
