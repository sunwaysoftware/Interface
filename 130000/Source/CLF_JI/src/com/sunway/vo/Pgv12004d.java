package com.sunway.vo;

import java.util.Date;

/**
 * Pgv12004dId entity. @author MyEclipse Persistence Tools
 */


public class Pgv12004d implements java.io.Serializable {

	private static final long serialVersionUID = -1403343288145690644L;
	private String cd12004Mxid;
	private String cd00001Fwsslx;
	private String cd00001Fwss;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String czr;
	private String fwss;

	// Constructors

	/** default constructor */
	public Pgv12004d() {
	}

	/** minimal constructor */
	public Pgv12004d(String cd12004Mxid, String cd00001Fwsslx,
			String cd00001Fwss, Date upddate, String cd00002Czr, String fwss) {
		this.cd12004Mxid = cd12004Mxid;
		this.cd00001Fwsslx = cd00001Fwsslx;
		this.cd00001Fwss = cd00001Fwss;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.fwss = fwss;
	}

	/** full constructor */
	public Pgv12004d(String cd12004Mxid, String cd00001Fwsslx,
			String cd00001Fwss, Date upddate, String cd00002Czr, String note,
			String czr, String fwss) {
		this.cd12004Mxid = cd12004Mxid;
		this.cd00001Fwsslx = cd00001Fwsslx;
		this.cd00001Fwss = cd00001Fwss;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.czr = czr;
		this.fwss = fwss;
	}

	// Property accessors

	public String getCd12004Mxid() {
		return this.cd12004Mxid;
	}

	public void setCd12004Mxid(String cd12004Mxid) {
		this.cd12004Mxid = cd12004Mxid;
	}

	public String getCd00001Fwsslx() {
		return this.cd00001Fwsslx;
	}

	public void setCd00001Fwsslx(String cd00001Fwsslx) {
		this.cd00001Fwsslx = cd00001Fwsslx;
	}

	public String getCd00001Fwss() {
		return this.cd00001Fwss;
	}

	public void setCd00001Fwss(String cd00001Fwss) {
		this.cd00001Fwss = cd00001Fwss;
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

	public String getCzr() {
		return this.czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public String getFwss() {
		return this.fwss;
	}

	public void setFwss(String fwss) {
		this.fwss = fwss;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Pgv12004d))
			return false;
		Pgv12004d castOther = (Pgv12004d) other;

		return ((this.getCd12004Mxid() == castOther.getCd12004Mxid()) || (this
				.getCd12004Mxid() != null
				&& castOther.getCd12004Mxid() != null && this.getCd12004Mxid()
				.equals(castOther.getCd12004Mxid())))
				&& ((this.getCd00001Fwsslx() == castOther.getCd00001Fwsslx()) || (this
						.getCd00001Fwsslx() != null
						&& castOther.getCd00001Fwsslx() != null && this
						.getCd00001Fwsslx()
						.equals(castOther.getCd00001Fwsslx())))
				&& ((this.getCd00001Fwss() == castOther.getCd00001Fwss()) || (this
						.getCd00001Fwss() != null
						&& castOther.getCd00001Fwss() != null && this
						.getCd00001Fwss().equals(castOther.getCd00001Fwss())))
				&& ((this.getUpddate() == castOther.getUpddate()) || (this
						.getUpddate() != null
						&& castOther.getUpddate() != null && this.getUpddate()
						.equals(castOther.getUpddate())))
				&& ((this.getCd00002Czr() == castOther.getCd00002Czr()) || (this
						.getCd00002Czr() != null
						&& castOther.getCd00002Czr() != null && this
						.getCd00002Czr().equals(castOther.getCd00002Czr())))
				&& ((this.getNote() == castOther.getNote()) || (this.getNote() != null
						&& castOther.getNote() != null && this.getNote()
						.equals(castOther.getNote())))
				&& ((this.getCzr() == castOther.getCzr()) || (this.getCzr() != null
						&& castOther.getCzr() != null && this.getCzr().equals(
						castOther.getCzr())))
				&& ((this.getFwss() == castOther.getFwss()) || (this.getFwss() != null
						&& castOther.getFwss() != null && this.getFwss()
						.equals(castOther.getFwss())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCd12004Mxid() == null ? 0 : this.getCd12004Mxid()
						.hashCode());
		result = 37
				* result
				+ (getCd00001Fwsslx() == null ? 0 : this.getCd00001Fwsslx()
						.hashCode());
		result = 37
				* result
				+ (getCd00001Fwss() == null ? 0 : this.getCd00001Fwss()
						.hashCode());
		result = 37 * result
				+ (getUpddate() == null ? 0 : this.getUpddate().hashCode());
		result = 37
				* result
				+ (getCd00002Czr() == null ? 0 : this.getCd00002Czr()
						.hashCode());
		result = 37 * result
				+ (getNote() == null ? 0 : this.getNote().hashCode());
		result = 37 * result
				+ (getCzr() == null ? 0 : this.getCzr().hashCode());
		result = 37 * result
				+ (getFwss() == null ? 0 : this.getFwss().hashCode());
		return result;
	}

}