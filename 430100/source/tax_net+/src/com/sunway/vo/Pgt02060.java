package com.sunway.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Pgt02060 entity.
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */
@SuppressWarnings("serial")
public class Pgt02060 implements java.io.Serializable {
	private String slid;
	private String cd00001Fwlx;
	private String cd00001Jylx;
	private String cd00001Jzjg;
	private String cd00001Szqy;
	private BigDecimal jzmj=BigDecimal.valueOf(0.0);
	
	private String cd00001Cgzk;
	private String szcs;	
	private BigDecimal pgjg;
	private Timestamp jysj;
	private String fdcdat;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String cd00053Qtxzid;
	private String cd02050Xqdm;
	private String xqnm;
	private String cd00001Jzjg1;
	private Integer ywdt;
	private Integer cs;
	private String fwtdzl;
	private String note1;
	private String ssgx;
	private String nsrmc;
	private String fwlxsc;
	private String jylxsc;
	private String jzjg;
	
	private String cgzksc;
	private String jtzk;
	private String wyzk;
	private String zxzk;
	private String zcdzs;
	private String zcdzd;
	private String zcdzl;
	private String zcdzm;
	private String zcdzbm;
	private String fczh;
	
	private String cb;
	private String ghyt;
	private String hxjg;
	private String jcsj;
	private String zhxz;
	
	private String qdh;
	private String bwjfh;
	private String zh;
	private Double mk;  //面宽
	private Double js ;  //进深
	private Integer sfsc; 
	
	private String chkDel;

	

	/** default constructor */
	public Pgt02060() {
	}

	/** full constructor */
	public Pgt02060(String slid, String cd00301Swid, String cd00303Lfid,
			String cd00001Fwlx, String cd00001Jylx, String cd00001Jzjg,
			BigDecimal jzmj, String cd00001Fwcx, String cd00001Cgzk, String szlc,
			String bwjfh, BigDecimal pgjg, Timestamp jysj, String fdcdat, Date upddate,
			String cd00002Czr, String note) {
		this.slid = slid;
		this.cd00001Fwlx = cd00001Fwlx;
		this.cd00001Jylx = cd00001Jylx;
		this.cd00001Jzjg = cd00001Jzjg;
		this.jzmj = jzmj;
		this.cd00001Cgzk = cd00001Cgzk;
		this.bwjfh = bwjfh;
		this.pgjg = pgjg;
		this.jysj = jysj;
		this.fdcdat = fdcdat;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	public String getSlid() {
		return slid;
	}

	public void setSlid(String slid) {
		this.slid = slid;
	}
	
	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}

	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}

	public String getCd00001Jylx() {
		return cd00001Jylx;
	}

	public void setCd00001Jylx(String cd00001Jylx) {
		this.cd00001Jylx = cd00001Jylx;
	}

	public String getCd00001Jzjg() {
		return cd00001Jzjg;
	}

	public void setCd00001Jzjg(String cd00001Jzjg) {
		this.cd00001Jzjg = cd00001Jzjg;
	}

	public BigDecimal getJzmj() {
		return jzmj;
	}

	public void setJzmj(BigDecimal jzmj) {
		this.jzmj = jzmj;
	}

	public String getCd00001Cgzk() {
		return cd00001Cgzk;
	}

	public void setCd00001Cgzk(String cd00001Cgzk) {
		this.cd00001Cgzk = cd00001Cgzk;
	}

	public String getSzcs() {
		return szcs;
	}

	public void setSzcs(String szcs) {
		this.szcs = szcs;
	}

	public BigDecimal getPgjg() {
		return pgjg;
	}

	public void setPgjg(BigDecimal pgjg) {
		this.pgjg = pgjg;
	}

	public Timestamp getJysj() {
		return jysj;
	}

	public void setJysj(Timestamp jysj) {
		this.jysj = jysj;
	}

	public String getFdcdat() {
		return fdcdat;
	}

	public void setFdcdat(String fdcdat) {
		this.fdcdat = fdcdat;
	}

	public Date getUpddate() {
		return upddate;
	}

	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}

	public String getCd00002Czr() {
		return cd00002Czr;
	}

	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCd00053Qtxzid() {
		return cd00053Qtxzid;
	}

	public void setCd00053Qtxzid(String cd00053Qtxzid) {
		this.cd00053Qtxzid = cd00053Qtxzid;
	}

	public String getCd02050Xqdm() {
		return cd02050Xqdm;
	}

	public void setCd02050Xqdm(String cd02050Xqdm) {
		this.cd02050Xqdm = cd02050Xqdm;
	}

	public String getCd00001Jzjg1() {
		return cd00001Jzjg1;
	}

	public void setCd00001Jzjg1(String cd00001Jzjg1) {
		this.cd00001Jzjg1 = cd00001Jzjg1;
	}

	public Integer getYwdt() {
		return ywdt;
	}

	public void setYwdt(Integer ywdt) {
		this.ywdt = ywdt;
	}

	public Integer getCs() {
		return cs;
	}

	public void setCs(Integer cs) {
		this.cs = cs;
	}

	public String getFwtdzl() {
		return fwtdzl;
	}

	public void setFwtdzl(String fwtdzl) {
		this.fwtdzl = fwtdzl;
	}

	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public String getSsgx() {
		return ssgx;
	}

	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}

	public String getNsrmc() {
		return nsrmc;
	}

	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}

	public String getFwlxsc() {
		return fwlxsc;
	}

	public void setFwlxsc(String fwlxsc) {
		this.fwlxsc = fwlxsc;
	}

	public String getJylxsc() {
		return jylxsc;
	}

	public void setJylxsc(String jylxsc) {
		this.jylxsc = jylxsc;
	}

	public String getJzjg() {
		return jzjg;
	}

	public void setJzjg(String jzjg) {
		this.jzjg = jzjg;
	}

	public String getCgzksc() {
		return cgzksc;
	}

	public void setCgzksc(String cgzksc) {
		this.cgzksc = cgzksc;
	}

	public String getJtzk() {
		return jtzk;
	}

	public void setJtzk(String jtzk) {
		this.jtzk = jtzk;
	}

	public String getWyzk() {
		return wyzk;
	}

	public void setWyzk(String wyzk) {
		this.wyzk = wyzk;
	}

	public String getZxzk() {
		return zxzk;
	}

	public void setZxzk(String zxzk) {
		this.zxzk = zxzk;
	}

	public String getZcdzs() {
		return zcdzs;
	}

	public void setZcdzs(String zcdzs) {
		this.zcdzs = zcdzs;
	}

	public String getZcdzd() {
		return zcdzd;
	}

	public void setZcdzd(String zcdzd) {
		this.zcdzd = zcdzd;
	}

	public String getZcdzl() {
		return zcdzl;
	}

	public void setZcdzl(String zcdzl) {
		this.zcdzl = zcdzl;
	}

	public String getZcdzm() {
		return zcdzm;
	}

	public void setZcdzm(String zcdzm) {
		this.zcdzm = zcdzm;
	}

	public String getZcdzbm() {
		return zcdzbm;
	}

	public void setZcdzbm(String zcdzbm) {
		this.zcdzbm = zcdzbm;
	}

	public String getFczh() {
		return fczh;
	}

	public void setFczh(String fczh) {
		this.fczh = fczh;
	}

	public String getCb() {
		return cb;
	}

	public void setCb(String cb) {
		this.cb = cb;
	}

	public String getGhyt() {
		return ghyt;
	}

	public void setGhyt(String ghyt) {
		this.ghyt = ghyt;
	}

	public String getHxjg() {
		return hxjg;
	}

	public void setHxjg(String hxjg) {
		this.hxjg = hxjg;
	}

	public String getJcsj() {
		return jcsj;
	}

	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}

	public String getZhxz() {
		return zhxz;
	}

	public void setZhxz(String zhxz) {
		this.zhxz = zhxz;
	}

	public String getQdh() {
		return qdh;
	}

	public void setQdh(String qdh) {
		this.qdh = qdh;
	}

	public String getBwjfh() {
		return bwjfh;
	}

	public void setBwjfh(String bwjfh) {
		this.bwjfh = bwjfh;
	}

	public String getZh() {
		return zh;
	}

	public void setZh(String zh) {
		this.zh = zh;
	}	

	public String getChkDel() {
		return chkDel;
	}

	public void setChkDel(String chkDel) {
		this.chkDel = chkDel;
	}

	public Double getMk() {
		return mk;
	}

	public void setMk(Double mk) {
		this.mk = mk;
	}

	public Double getJs() {
		return js;
	}

	public void setJs(Double js) {
		this.js = js;
	}

	public Integer getSfsc() {
		return sfsc;
	}

	public void setSfsc(Integer sfsc) {
		this.sfsc = sfsc;
	}

	public String getCd00001Szqy() {
		return cd00001Szqy;
	}

	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}

	public String getXqnm() {
		return xqnm;
	}

	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}

}
