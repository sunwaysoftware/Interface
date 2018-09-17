package com.sunway.vo;

import java.util.Date;

/**
 * Pgt00301 entity. @author MyEclipse Persistence Tools
 */


public class Pgt00301 implements java.io.Serializable {

	private static final long serialVersionUID = 4067785506654750605L;
	// Fields
	private String swid;
	private String nsrmc;
	private String cd00001Zjlx;
	private String zz;
	private String lxdh;
	private String yddh;
	private String cd00001Ssgx;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String pssd;
	private String zjlx;
	private Integer countFC;
	private String swidOld;
	private Date bgsj;
	private Integer bglx;
	private String zjhm;
	// Constructors
	/** default constructor */
	public Pgt00301() {
	}

	public Pgt00301(String swid) {
		this.swid = swid;
	}

	/** minimal constructor */
	public Pgt00301(String swid, String nsrmc, String cd00001Zjlx, String zz,
			Date upddate, String cd00002Czr) {
		this.swid = swid;
		this.nsrmc = nsrmc;
		this.cd00001Zjlx = cd00001Zjlx;
		this.zz = zz;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgt00301(String swid, String nsrmc, String cd00001Zjlx, String zz,
			String lxdh, String yddh, String cd00001Ssjc, String cd00001Ssgx,
			Date upddate, String cd00002Czr, String note) {
		this.swid = swid;
		this.nsrmc = nsrmc;
		this.cd00001Zjlx = cd00001Zjlx;
		this.zz = zz;
		this.lxdh = lxdh;
		this.yddh = yddh;
		this.cd00001Ssgx = cd00001Ssgx;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	// Property accessors

	/**
	 * @return the swid
	 */
	public String getSwid() {
		return swid;
	}
	/**
	 * @param swid the swid to set
	 */
	public void setSwid(String swid) {
		this.swid = swid;
	}
	/**
	 * @return the nsrmc
	 */
	public String getNsrmc() {
		return nsrmc;
	}
	/**
	 * @param nsrmc the nsrmc to set
	 */
	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}
	/**
	 * @return the cd00001Zjlx
	 */
	public String getCd00001Zjlx() {
		return cd00001Zjlx;
	}
	/**
	 * @param cd00001Zjlx the cd00001Zjlx to set
	 */
	public void setCd00001Zjlx(String cd00001Zjlx) {
		this.cd00001Zjlx = cd00001Zjlx;
	}
	/**
	 * @return the zz
	 */
	public String getZz() {
		return zz;
	}
	/**
	 * @param zz the zz to set
	 */
	public void setZz(String zz) {
		this.zz = zz;
	}
	/**
	 * @return the lxdh
	 */
	public String getLxdh() {
		return lxdh;
	}
	/**
	 * @param lxdh the lxdh to set
	 */
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	/**
	 * @return the yddh
	 */
	public String getYddh() {
		return yddh;
	}
	/**
	 * @param yddh the yddh to set
	 */
	public void setYddh(String yddh) {
		this.yddh = yddh;
	}
	/**
	 * @return the cd00001Ssgx
	 */
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}
	/**
	 * @param cd00001Ssgx the cd00001Ssgx to set
	 */
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}
	/**
	 * @return the upddate
	 */
	public Date getUpddate() {
		return upddate;
	}
	/**
	 * @param upddate the upddate to set
	 */
	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}
	/**
	 * @return the cd00002Czr
	 */
	public String getCd00002Czr() {
		return cd00002Czr;
	}
	/**
	 * @param cd00002Czr the cd00002Czr to set
	 */
	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the pssd
	 */
	public String getPssd() {
		return pssd;
	}
	/**
	 * @param pssd the pssd to set
	 */
	public void setPssd(String pssd) {
		this.pssd = pssd;
	}
	/**
	 * @return the zjlx
	 */
	public String getZjlx() {
		return zjlx;
	}
	/**
	 * @param zjlx the zjlx to set
	 */
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	/**
	 * @return the countFC
	 */
	public Integer getCountFC() {
		return countFC;
	}
	/**
	 * @param countFC the countFC to set
	 */
	public void setCountFC(Integer countFC) {
		this.countFC = countFC;
	}

	/**
	 * 初始化除SWID,NSRMC之外的屬性
	 */
	public void clear() {
		this.cd00001Zjlx = null;
		this.zz = null;
		this.lxdh = null;
		this.yddh = null;
		this.cd00001Ssgx = null;
		this.upddate = null;
		this.cd00002Czr = null;
		this.note = null;
		this.pssd = null;
		this.zjlx = null;
		this.countFC = null;
	}

	/**
	 * @return the swidOld
	 */
	public String getSwidOld() {
		return swidOld;
	}

	/**
	 * @param swidOld the swidOld to set
	 */
	public void setSwidOld(String swidOld) {
		this.swidOld = swidOld;
	}

	/**
	 * @return the bgsj
	 */
	public Date getBgsj() {
		return bgsj;
	}

	/**
	 * @param bgsj the bgsj to set
	 */
	public void setBgsj(Date bgsj) {
		this.bgsj = bgsj;
	}

	/**
	 * @param bglx the bglx to set
	 */
	public void setBglx(Integer bglx) {
		this.bglx = bglx;
	}

	/**
	 * @return the bglx
	 */
	public Integer getBglx() {
		return bglx;
	}

	/**
	 * @return the zjhm
	 */
	public String getZjhm() {
		return zjhm;
	}

	/**
	 * @param zjhm the zjhm to set
	 */
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
}