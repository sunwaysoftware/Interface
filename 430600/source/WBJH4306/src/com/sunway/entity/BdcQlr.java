package com.sunway.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="BDC_QLR")
public class BdcQlr implements Serializable {
	private static final long serialVersionUID = -5523306939153909550L;
	@Id
    @GenericGenerator(name = "appID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "appID")
    private String id;
    private String sname;
    private String scnum;
    @ManyToOne(targetEntity = BdcZjlxDict.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "sctype")
    private BdcZjlxDict dictZjlx;      // 证件类型
    @ManyToOne(targetEntity = BdcQlrxzDict.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "qlrxz")
    private BdcQlrxzDict dictQlrxz;       // 权利人性质
    @ManyToOne(targetEntity = BdcGyfsDict.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "gyqk")
    private BdcGyfsDict dictGyfs;        // 共有方式
    @ManyToOne(targetEntity = BdcQlrlbDict.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "qlrlb")
    private BdcQlrlbDict dictQlrlb;       // 权利人类别
    private String zyfe;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date cssj;
    private String ywh;
    private String jyfbs;       // 交易方标识(0 转让方,1 承受方)

    //----------------------------------------------------------------------------------
    public BdcQlr(){}
    public BdcQlr(String ywh){ this.ywh = ywh; }
    //------------------------- setter and getter ------------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getScnum() {
        return scnum;
    }

    public void setScnum(String scnum) {
        this.scnum = scnum;
    }

    public String getZyfe() {
        return zyfe;
    }

    public void setZyfe(String zyfe) {
        this.zyfe = zyfe;
    }

    public Date getCssj() {
        return cssj;
    }

    public void setCssj(Date cssj) {
        this.cssj = cssj;
    }

    public String getYwh() {
        return ywh;
    }

    public void setYwh(String ywh) {
        this.ywh = ywh;
    }

    public String getJyfbs() {
        return jyfbs;
    }

    public void setJyfbs(String jyfbs) {
        this.jyfbs = jyfbs;
    }

    public BdcZjlxDict getDictZjlx() {
        return dictZjlx;
    }

    public void setDictZjlx(BdcZjlxDict dictZjlx) {
        this.dictZjlx = dictZjlx;
    }

    public BdcQlrxzDict getDictQlrxz() {
        return dictQlrxz;
    }

    public void setDictQlrxz(BdcQlrxzDict dictQlrxz) {
        this.dictQlrxz = dictQlrxz;
    }

    public BdcGyfsDict getDictGyfs() {
        return dictGyfs;
    }

    public void setDictGyfs(BdcGyfsDict dictGyfs) {
        this.dictGyfs = dictGyfs;
    }

    public BdcQlrlbDict getDictQlrlb() {
        return dictQlrlb;
    }

    public void setDictQlrlb(BdcQlrlbDict dictQlrlb) {
        this.dictQlrlb = dictQlrlb;
    }
}
