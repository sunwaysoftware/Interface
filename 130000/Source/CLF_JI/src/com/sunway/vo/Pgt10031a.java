package com.sunway.vo;

import java.util.Date;

/**
 * Pgt10031a entity. @author MyEclipse Persistence Tools
 */


public class Pgt10031a implements java.io.Serializable {

	private static final long serialVersionUID = 1685020925862190254L;
	// Fields
	private String cd00002Czr;
	private String cd00002Pssd;
	private String cd12004Mxid;
	private String note;
	private String qtxzid;
	private Date upddate;
	private Double xzxs;

	// Constructors

	/** default constructor */
	public Pgt10031a() {
	}

	/**
	 * mini constructor
	 * @param cd00002Pssd
	 * @param cd12004Mxid
	 */
	public Pgt10031a(String cd00002Pssd, String cd12004Mxid) {
		this.cd00002Pssd = cd00002Pssd;
		this.cd12004Mxid = cd12004Mxid;
	}

	/**
	 * full constructor
	 * @param cd00002Czr
	 * @param cd00002Pssd
	 * @param cd12004Mxid
	 * @param note
	 * @param qtxzid
	 * @param upddate
	 * @param xzxs
	 */
	public Pgt10031a(String cd00002Czr, String cd00002Pssd,
			String cd12004Mxid, String note, String qtxzid, Date upddate,
			Double xzxs) {
		this.cd00002Czr = cd00002Czr;
		this.cd00002Pssd = cd00002Pssd;
		this.cd12004Mxid = cd12004Mxid;
		this.note = note;
		this.qtxzid = qtxzid;
		this.upddate = upddate;
		this.xzxs = xzxs;
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
	 * @return the cd00002Pssd
	 */
	public String getcd00002Pssd() {
		return cd00002Pssd;
	}

	/**
	 * @param cd00002Pssd the cd00002Pssd to set
	 */
	public void setcd00002Pssd(String cd00002Pssd) {
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
}