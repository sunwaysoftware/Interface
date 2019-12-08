package com.sunway.vo;

import java.util.Date;

/**
 * Pgt10032 entity. @author MyEclipse Persistence Tools
 */


public class Pgt10032 implements java.io.Serializable {

	private static final long serialVersionUID = 4477962006735926354L;
	private String cd12004Mxid;
	private String cd00002Pssd;
	private Double gbfcpgjg;
	private Double gbdcpgjg;
	private Double gbpgjg;
	private Double gbfcxzxs;
	private Double gbdcxzxs;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private Double fcpgjg;
	private Double dcpgjg;
	
	// Constructors

	/** default constructor */
	public Pgt10032() {
	}

	/**
	 * @param cd12004Mxid
	 * @param cd00002Pssd
	 */
	public Pgt10032(String cd12004Mxid, String cd00002Pssd) {
		this.cd12004Mxid = cd12004Mxid;
		this.cd00002Pssd = cd00002Pssd;
	}
	
	/**
	 * @param cd12004Mxid
	 * @param cd00002Pssd
	 * @param gbfcpgjg
	 * @param gbdcpgjg
	 * @param gbpgjg
	 * @param gbfcxzxs
	 * @param gbdcxzxs
	 * @param upddate
	 * @param cd00002Czr
	 * @param note
	 */
	public Pgt10032(String cd12004Mxid, String cd00002Pssd, Double gbfcpgjg,
			Double gbdcpgjg, Double gbpgjg, Double gbfcxzxs, Double gbdcxzxs,
			Date upddate, String cd00002Czr, String note, Double fcpgjg, Double dcpgjg) {
		this.cd12004Mxid = cd12004Mxid;
		this.cd00002Pssd = cd00002Pssd;
		this.gbfcpgjg = gbfcpgjg;
		this.gbdcpgjg = gbdcpgjg;
		this.gbpgjg = gbpgjg;
		this.gbfcxzxs = gbfcxzxs;
		this.gbdcxzxs = gbdcxzxs;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.fcpgjg = fcpgjg;
		this.dcpgjg = dcpgjg;
	}

	/**
	 * @return the cd12004Mxid
	 */
	public String getCd12004Mxid() {
		return cd12004Mxid;
	}

	/**
	 * @param cd12004Mxid the cd12004Mxid to set
	 */
	public void setCd12004Mxid(String cd12004Mxid) {
		this.cd12004Mxid = cd12004Mxid;
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

	/**
	 * @return the gbfcpgjg
	 */
	public Double getGbfcpgjg() {
		return gbfcpgjg;
	}

	/**
	 * @param gbfcpgjg the gbfcpgjg to set
	 */
	public void setGbfcpgjg(Double gbfcpgjg) {
		this.gbfcpgjg = gbfcpgjg;
	}

	/**
	 * @return the gbdcpgjg
	 */
	public Double getGbdcpgjg() {
		return gbdcpgjg;
	}

	/**
	 * @param gbdcpgjg the gbdcpgjg to set
	 */
	public void setGbdcpgjg(Double gbdcpgjg) {
		this.gbdcpgjg = gbdcpgjg;
	}

	/**
	 * @return the gbpgjg
	 */
	public Double getGbpgjg() {
		return gbpgjg;
	}

	/**
	 * @param gbpgjg the gbpgjg to set
	 */
	public void setGbpgjg(Double gbpgjg) {
		this.gbpgjg = gbpgjg;
	}

	/**
	 * @return the gbfcxzxs
	 */
	public Double getGbfcxzxs() {
		return gbfcxzxs;
	}

	/**
	 * @param gbfcxzxs the gbfcxzxs to set
	 */
	public void setGbfcxzxs(Double gbfcxzxs) {
		this.gbfcxzxs = gbfcxzxs;
	}

	/**
	 * @return the gbdcxzxs
	 */
	public Double getGbdcxzxs() {
		return gbdcxzxs;
	}

	/**
	 * @param gbdcxzxs the gbdcxzxs to set
	 */
	public void setGbdcxzxs(Double gbdcxzxs) {
		this.gbdcxzxs = gbdcxzxs;
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
	 * @return the fcpgjg
	 */
	public Double getFcpgjg() {
		return fcpgjg;
	}

	/**
	 * @param fcpgjg the fcpgjg to set
	 */
	public void setFcpgjg(Double fcpgjg) {
		this.fcpgjg = fcpgjg;
	}

	/**
	 * @return the dcpgjg
	 */
	public Double getDcpgjg() {
		return dcpgjg;
	}

	/**
	 * @param dcpgjg the dcpgjg to set
	 */
	public void setDcpgjg(Double dcpgjg) {
		this.dcpgjg = dcpgjg;
	}

}