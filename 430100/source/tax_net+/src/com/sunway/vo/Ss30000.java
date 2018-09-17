package com.sunway.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Ss30000 entity. 
 * @author Lee
 */

public class Ss30000 implements java.io.Serializable {
	
	private static final long serialVersionUID = 355788091477710405L;
	private String cd12301Swid;
	private String nsrmc;
	private Double sumPgjg;
	private Double avgJsjz;
	private Double avgSl;
	private Double sumYnze;
	private Short bm;
	private String fcid;
	private String fwtdzl;
	private Double jzmj;
	private Double pgjg;
	private String pssd;
	private String skssq;
	private Date taxDate;
	private Date sysDate;
	private String cd00001Czr;
	private String cd00001Ssgx;
	private ArrayList<Ss30000> ss30000List;
	private String ssgx;
	private String note;
	private String yymm;

	/** default constructor */
	public Ss30000() {
		this.ss30000List = new ArrayList<Ss30000>();
	}

	/** minimal constructor */
	public Ss30000(Short bm, String fcid, String fwtdzl, Double jzmj,
			Double pgjg) {
		this.bm = bm;
		this.fcid = fcid;
		this.fwtdzl = fwtdzl;
		this.jzmj = jzmj;
		this.pgjg = pgjg;
	}

	/**
	 * @return the cd12301Swid
	 */
	public String getCd12301Swid() {
		return cd12301Swid;
	}
	/**
	 * @param cd12301Swid the cd12301Swid to set
	 */
	public void setCd12301Swid(String cd12301Swid) {
		this.cd12301Swid = cd12301Swid;
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
	 * @return the sumPgjg
	 */
	public Double getSumPgjg() {
		return sumPgjg;
	}
	/**
	 * @param sumPgjg the sumPgjg to set
	 */
	public void setSumPgjg(Double sumPgjg) {
		this.sumPgjg = sumPgjg;
	}
	/**
	 * @return the avgJsjz
	 */
	public Double getAvgJsjz() {
		return avgJsjz;
	}
	/**
	 * @param avgJsjz the avgJsjz to set
	 */
	public void setAvgJsjz(Double avgJsjz) {
		this.avgJsjz = avgJsjz;
	}
	/**
	 * @return the avgSl
	 */
	public Double getAvgSl() {
		return avgSl;
	}
	/**
	 * @param avgSl the avgSl to set
	 */
	public void setAvgSl(Double avgSl) {
		this.avgSl = avgSl;
	}
	/**
	 * @return the sumYnze
	 */
	public Double getSumYnze() {
		return sumYnze;
	}
	/**
	 * @param sumYnze the sumYnze to set
	 */
	public void setSumYnze(Double sumYnze) {
		this.sumYnze = sumYnze;
	}
	/**
	 * @return the bm
	 */
	public Short getBm() {
		return bm;
	}
	/**
	 * @param bm the bm to set
	 */
	public void setBm(Short bm) {
		this.bm = bm;
	}
	/**
	 * @return the fcid
	 */
	public String getFcid() {
		return fcid;
	}
	/**
	 * @param fcid the fcid to set
	 */
	public void setFcid(String fcid) {
		this.fcid = fcid;
	}
	/**
	 * @return the fwtdzl
	 */
	public String getFwtdzl() {
		return fwtdzl;
	}
	/**
	 * @param fwtdzl the fwtdzl to set
	 */
	public void setFwtdzl(String fwtdzl) {
		this.fwtdzl = fwtdzl;
	}
	/**
	 * @return the jzmj
	 */
	public Double getJzmj() {
		return jzmj;
	}
	/**
	 * @param jzmj the jzmj to set
	 */
	public void setJzmj(Double jzmj) {
		this.jzmj = jzmj;
	}
	/**
	 * @return the pgjg
	 */
	public Double getPgjg() {
		return pgjg;
	}
	/**
	 * @param pgjg the pgjg to set
	 */
	public void setPgjg(Double pgjg) {
		this.pgjg = pgjg;
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
	 * @return the skssq
	 */
	public String getSkssq() {
		return skssq;
	}
	/**
	 * @param skssq the skssq to set
	 */
	public void setSkssq(String skssq) {
		this.skssq = skssq;
	}
	/**
	 * @return the taxDate
	 */
	public Date getTaxDate() {
		return taxDate;
	}
	/**
	 * @param taxDate the taxDate to set
	 */
	public void setTaxDate(Date taxDate) {
		this.taxDate = taxDate;
	}
	/**
	 * @return the sysDate
	 */
	public Date getSysDate() {
		return sysDate;
	}
	/**
	 * @param sysDate the sysDate to set
	 */
	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}
	/**
	 * @return the cd00001Czr
	 */
	public String getCd00001Czr() {
		return cd00001Czr;
	}
	/**
	 * @param cd00001Czr the cd00001Czr to set
	 */
	public void setCd00001Czr(String cd00001Czr) {
		this.cd00001Czr = cd00001Czr;
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
	 * @return the ss30000List
	 */
	public ArrayList<Ss30000> getSs30000List() {
		return ss30000List;
	}
	/**
	 * @param ss30000List the ss30000List to set
	 */
	public void setSs30000List(ArrayList<Ss30000> ss30000List) {
		this.ss30000List = ss30000List;
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
	 * @param yymm the yymm to set
	 */
	public void setYymm(String yymm) {
		this.yymm = yymm;
	}

	/**
	 * @return the yymm
	 */
	public String getYymm() {
		return yymm;
	}
}
