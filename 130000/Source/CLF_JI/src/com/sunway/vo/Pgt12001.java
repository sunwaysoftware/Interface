package com.sunway.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Pgt12001 entity. @author MyEclipse Persistence Tools
 */


public class Pgt12001 implements java.io.Serializable {

	private static final long serialVersionUID = 2300697136131483820L;
	private String swid;
	private String nsrmc;
	private String cd00001Ssgx;
	private String lxdh;
	private String zgy;
	private String cd00001Hy;
	private String cd00001Jjlx;
	private Double zyywsr;
	private Double lrze;
	private BigDecimal fcse;
	private BigDecimal tdse;
	private String cd00001Mssz;
	private String bh;
	private String cd00001Xz;
	private Date lrdate;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String sysPssd;
	private String ssgx;
	private String hy;
	private String jjlx;
	private String mssz;
	private String xz;
    private Integer countDC;
    private Integer countFC;
    private Integer countMX;
	private Date bgsj;
    private String swidOld;
    private Integer bglx; 
    
	// Constructors

	/** default constructor */
	public Pgt12001() {
	}

	public Pgt12001(String swid) {
		this.swid = swid;
	}
	
	/** minimal constructor */
	public Pgt12001(String swid, String nsrmc, String cd00001Ssgx,
			String cd00001Hy, String cd00001Jjlx, Double zyywsr, Double lrze,
			BigDecimal fcse, BigDecimal tdse, String cd00001Mssz, String bh,
			String cd00001Xz, Date lrdate, Date upddate, String cd00002Czr) {
		this.swid = swid;
		this.nsrmc = nsrmc;
		this.cd00001Ssgx = cd00001Ssgx;
		this.cd00001Hy = cd00001Hy;
		this.cd00001Jjlx = cd00001Jjlx;
		this.zyywsr = zyywsr;
		this.lrze = lrze;
		this.fcse = fcse;
		this.tdse = tdse;
		this.cd00001Mssz = cd00001Mssz;
		this.bh = bh;
		this.cd00001Xz = cd00001Xz;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgt12001(String swid, String nsrmc, String cd00001Ssgx, String lxdh,
			String zgy, String cd00001Hy, String cd00001Jjlx, Double zyywsr,
			Double lrze, BigDecimal fcse, BigDecimal tdse, String cd00001Mssz,
			String bh, String cd00001Xz, Date lrdate,
			Date upddate, String cd00002Czr, String note) {
		this.swid = swid;
		this.nsrmc = nsrmc;
		this.cd00001Ssgx = cd00001Ssgx;
		this.lxdh = lxdh;
		this.zgy = zgy;
		this.cd00001Hy = cd00001Hy;
		this.cd00001Jjlx = cd00001Jjlx;
		this.zyywsr = zyywsr;
		this.lrze = lrze;
		this.fcse = fcse;
		this.tdse = tdse;
		this.cd00001Mssz = cd00001Mssz;
		this.bh = bh;
		this.cd00001Xz = cd00001Xz;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	// Property accessors

	public String getSwid() {
		return this.swid;
	}

	public void setSwid(String swid) {
		this.swid = swid;
	}

	public String getNsrmc() {
		return this.nsrmc;
	}

	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}

	public String getCd00001Ssgx() {
		return this.cd00001Ssgx;
	}

	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}

	public String getLxdh() {
		return this.lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getZgy() {
		return this.zgy;
	}

	public void setZgy(String zgy) {
		this.zgy = zgy;
	}

	public String getCd00001Hy() {
		return this.cd00001Hy;
	}

	public void setCd00001Hy(String cd00001Hy) {
		this.cd00001Hy = cd00001Hy;
	}

	public String getCd00001Jjlx() {
		return this.cd00001Jjlx;
	}

	public void setCd00001Jjlx(String cd00001Jjlx) {
		this.cd00001Jjlx = cd00001Jjlx;
	}

	public Double getZyywsr() {
		return this.zyywsr;
	}

	public void setZyywsr(Double zyywsr) {
		this.zyywsr = zyywsr;
	}

	public Double getLrze() {
		return this.lrze;
	}

	public void setLrze(Double lrze) {
		this.lrze = lrze;
	}

	public BigDecimal getFcse() {
		return this.fcse;
	}

	public void setFcse(BigDecimal fcse) {
		this.fcse = fcse;
	}

	public BigDecimal getTdse() {
		return this.tdse;
	}

	public void setTdse(BigDecimal tdse) {
		this.tdse = tdse;
	}

	public String getCd00001Mssz() {
		return this.cd00001Mssz;
	}

	public void setCd00001Mssz(String cd00001Mssz) {
		this.cd00001Mssz = cd00001Mssz;
	}

	public String getBh() {
		return this.bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	public String getCd00001Xz() {
		return this.cd00001Xz;
	}

	public void setCd00001Xz(String cd00001Xz) {
		this.cd00001Xz = cd00001Xz;
	}

	public Date getLrdate() {
		return this.lrdate;
	}

	public void setLrdate(Date lrdate) {
		this.lrdate = lrdate;
	}

	public Date getUpddate() {
		return this.upddate;
	}

	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}

	public String getCd00002Czr() {
		return this.cd00002Czr;
	}

	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @param sysPssd the sysPssd to set
	 */
	public void setSysPssd(String sysPssd) {
		this.sysPssd = sysPssd;
	}

	/**
	 * @return the sysPssd
	 */
	public String getSysPssd() {
		return sysPssd;
	}

	/**
	 * @return the ssgx
	 */
	public String getSsgx() {
		return ssgx;
	}

	/**
	 * @param ssgx the ssgx to set
	 */
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}

	/**
	 * @return the hy
	 */
	public String getHy() {
		return hy;
	}

	/**
	 * @param hy the hy to set
	 */
	public void setHy(String hy) {
		this.hy = hy;
	}

	/**
	 * @return the jjlx
	 */
	public String getJjlx() {
		return jjlx;
	}

	/**
	 * @param jjlx the jjlx to set
	 */
	public void setJjlx(String jjlx) {
		this.jjlx = jjlx;
	}

	/**
	 * @return the mssz
	 */
	public String getMssz() {
		return mssz;
	}

	/**
	 * @param mssz the mssz to set
	 */
	public void setMssz(String mssz) {
		this.mssz = mssz;
	}

	/**
	 * @return the xz
	 */
	public String getXz() {
		return xz;
	}

	/**
	 * @param xz the xz to set
	 */
	public void setXz(String xz) {
		this.xz = xz;
	}

	/**
	 * @return the countDC
	 */
	public Integer getCountDC() {
		return countDC;
	}

	/**
	 * @param countDC the countDC to set
	 */
	public void setCountDC(Integer countDC) {
		this.countDC = countDC;
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
	 * @return the countMX
	 */
	public Integer getCountMX() {
		return countMX;
	}

	/**
	 * @param countMX the countMX to set
	 */
	public void setCountMX(Integer countMX) {
		this.countMX = countMX;
	}

	/**
	 * @param bgsj the bgsj to set
	 */
	public void setBgsj(Date bgsj) {
		this.bgsj = bgsj;
	}

	/**
	 * @return the bgsj
	 */
	public Date getBgsj() {
		return bgsj;
	}

	/**
	 * @param swidOld the swidOld to set
	 */
	public void setSwidOld(String swidOld) {
		this.swidOld = swidOld;
	}

	/**
	 * @return the swidOld
	 */
	public String getSwidOld() {
		return swidOld;
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

}