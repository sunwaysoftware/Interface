package com.sunway.vo;

import java.util.Date;

/**
 * Pgt02031a entity. @author MyEclipse Persistence Tools
 */


public class Pgt02031a implements java.io.Serializable {

	private static final long serialVersionUID = -1586774880722974958L;
	private String qtxzid;
	private String cd00002Pssd;
	private String cd12004Mxid;	
	private Double xzxs;
	private Date upddate;
	private String cd00002Czr;
	private String note;

	// Constructors

	/** default constructor */
	public Pgt02031a() {
	}

	/**
	 * @param qtxzid
	 * @param cd00002Pssd
	 * @param cd12004Mxid
	 * @param xzxs
	 * @param upddate
	 * @param cd00002Czr
	 * @param note
	 */
	public Pgt02031a(String qtxzid, String cd00002Pssd, String cd12004Mxid,
			Double xzxs, Date upddate, String cd00002Czr, String note) {
		this.qtxzid = qtxzid;
		this.cd00002Pssd = cd00002Pssd;
		this.cd12004Mxid = cd12004Mxid;
		this.xzxs = xzxs;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	/**
	 * @param cd00002Pssd
	 * @param cd12004Mxid
	 */
	public Pgt02031a(String cd00002Pssd, String cd12004Mxid) {
		this.cd00002Pssd = cd00002Pssd;
		this.cd12004Mxid = cd12004Mxid;
	}

	/**
	 * @return the qtxzid
	 */
	public String getQtxzid() {
		return qtxzid;
	}

	/**
	 * @param qtxzid the qtxzid to set
	 */
	public void setQtxzid(String qtxzid) {
		this.qtxzid = qtxzid;
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
	 * @return the xzxs
	 */
	public Double getXzxs() {
		return xzxs;
	}

	/**
	 * @param xzxs the xzxs to set
	 */
	public void setXzxs(Double xzxs) {
		this.xzxs = xzxs;
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
}