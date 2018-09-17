package com.sunway.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Ss00000 entity. 
 * @author Lee
 */

public class Ss00000 implements java.io.Serializable {

	private static final long serialVersionUID = -8010631860910744666L;
	private String cd12301Swid;
	private String nsrmc;
	private Double sumPgjg;
	private Double avgJsjz;
	private Double avgSl;
	private Double sumYnze;
	private Short bm;
	private String dcid;
	private String tdzl;
	private Double syqmj;
	private Short dcCount;
	private Double zmj;
	private Double dcpg;
	private Double fcpg;
	private Double pgjg;
	private String pssd;
	private String skssq;
	private Date taxDate;
	private Date sysDate;
	private String cd00001Czr;
	private String cd00001Ssgx;
	private ArrayList<Ss00000> ss00000List;
	private String ssgx;
	private String note;
	private String cd00002Pssd;

	/** default constructor */
	public Ss00000() {
		this.ss00000List = new ArrayList<Ss00000>();
	}

	/** minimal constructor */
	public Ss00000(Short bm, String dcid, String tdzl, Double syqmj,
			Short dcCount, Double zmj, Double dcpg, Double fcpg, Double pgjg) {
		this.bm = bm;
		this.dcid = dcid;
		this.tdzl = tdzl;
		this.syqmj = syqmj;
		this.dcCount = dcCount;
		this.zmj = zmj;
		this.dcpg = dcpg;
		this.fcpg = fcpg;
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
	 * @return the dcid
	 */
	public String getDcid() {
		return dcid;
	}
	/**
	 * @param dcid the dcid to set
	 */
	public void setDcid(String dcid) {
		this.dcid = dcid;
	}
	/**
	 * @return the tdzl
	 */
	public String getTdzl() {
		return tdzl;
	}
	/**
	 * @param tdzl the tdzl to set
	 */
	public void setTdzl(String tdzl) {
		this.tdzl = tdzl;
	}
	/**
	 * @return the syqmj
	 */
	public Double getSyqmj() {
		return syqmj;
	}
	/**
	 * @param syqmj the syqmj to set
	 */
	public void setSyqmj(Double syqmj) {
		this.syqmj = syqmj;
	}
	/**
	 * @return the dcCount
	 */
	public Short getDcCount() {
		return dcCount;
	}
	/**
	 * @param dcCount the dcCount to set
	 */
	public void setDcCount(Short dcCount) {
		this.dcCount = dcCount;
	}
	/**
	 * @return the zmj
	 */
	public Double getZmj() {
		return zmj;
	}
	/**
	 * @param zmj the zmj to set
	 */
	public void setZmj(Double zmj) {
		this.zmj = zmj;
	}
	/**
	 * @return the dcpg
	 */
	public Double getDcpg() {
		return dcpg;
	}
	/**
	 * @param dcpg the dcpg to set
	 */
	public void setDcpg(Double dcpg) {
		this.dcpg = dcpg;
	}
	/**
	 * @return the fcpg
	 */
	public Double getFcpg() {
		return fcpg;
	}
	/**
	 * @param fcpg the fcpg to set
	 */
	public void setFcpg(Double fcpg) {
		this.fcpg = fcpg;
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
	 * @return the ss00000List
	 */
	public ArrayList<Ss00000> getSs00000List() {
		return ss00000List;
	}
	/**
	 * @param ss00000List the ss00000List to set
	 */
	public void setSs00000List(ArrayList<Ss00000> ss00000List) {
		this.ss00000List = ss00000List;
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
	 * @return the cd00002Pssd
	 */
	public String getCd00002Pssd() {
		return cd00002Pssd;
	}
	/**
	 * @param cd00002Pssd the cd00002Pssd to set
	 */
	public void setCd00002Pssd(String cd00002Pssd) {
		this.cd00002Pssd = cd00002Pssd;
	}
}
