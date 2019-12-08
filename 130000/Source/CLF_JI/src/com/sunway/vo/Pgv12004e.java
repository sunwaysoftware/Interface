package com.sunway.vo;

import java.util.Date;

/**
 * Pgv12004eId entity. @author MyEclipse Persistence Tools
 */


public class Pgv12004e implements java.io.Serializable {

	private static final long serialVersionUID = 4348765759940536309L;
	private String cd12004Mxid;
	private String cd00053Qtxzid;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String qtxznm;
	private Integer xzlx;
	private Double xzxs;
	private String czr;

	// Constructors

	/** default constructor */
	public Pgv12004e() {
	}

	/** minimal constructor */
	public Pgv12004e(String cd12004Mxid, String cd00053Qtxzid, Date upddate,
			String cd00002Czr, Integer xzlx, Double xzxs) {
		this.cd12004Mxid = cd12004Mxid;
		this.cd00053Qtxzid = cd00053Qtxzid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.xzlx = xzlx;
		this.xzxs = xzxs;
	}

	/** full constructor */
	public Pgv12004e(String cd12004Mxid, String cd00053Qtxzid, Date upddate,
			String cd00002Czr, String note, Integer xzlx, Double xzxs) {
		this.cd12004Mxid = cd12004Mxid;
		this.cd00053Qtxzid = cd00053Qtxzid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.xzlx = xzlx;
		this.xzxs = xzxs;
	}

	// Property accessors

	public String getCd12004Mxid() {
		return this.cd12004Mxid;
	}

	public void setCd12004Mxid(String cd12004Mxid) {
		this.cd12004Mxid = cd12004Mxid;
	}

	public String getCd00053Qtxzid() {
		return this.cd00053Qtxzid;
	}

	public void setCd00053Qtxzid(String cd00053Qtxzid) {
		this.cd00053Qtxzid = cd00053Qtxzid;
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

	public Integer getXzlx() {
		return this.xzlx;
	}

	public void setXzlx(Integer xzlx) {
		this.xzlx = xzlx;
	}

	public Double getXzxs() {
		return this.xzxs;
	}

	public void setXzxs(Double xzxs) {
		this.xzxs = xzxs;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Pgv12004e))
			return false;
		Pgv12004e castOther = (Pgv12004e) other;

		return ((this.getCd12004Mxid() == castOther.getCd12004Mxid()) || (this
				.getCd12004Mxid() != null
				&& castOther.getCd12004Mxid() != null && this.getCd12004Mxid()
				.equals(castOther.getCd12004Mxid())))
				&& ((this.getCd00053Qtxzid() == castOther.getCd00053Qtxzid()) || (this
						.getCd00053Qtxzid() != null
						&& castOther.getCd00053Qtxzid() != null && this
						.getCd00053Qtxzid()
						.equals(castOther.getCd00053Qtxzid())))
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
				&& ((this.getXzlx() == castOther.getXzlx()) || (this.getXzlx() != null
						&& castOther.getXzlx() != null && this.getXzlx()
						.equals(castOther.getXzlx())))
				&& ((this.getXzxs() == castOther.getXzxs()) || (this.getXzxs() != null
						&& castOther.getXzxs() != null && this.getXzxs()
						.equals(castOther.getXzxs())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCd12004Mxid() == null ? 0 : this.getCd12004Mxid()
						.hashCode());
		result = 37
				* result
				+ (getCd00053Qtxzid() == null ? 0 : this.getCd00053Qtxzid()
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
				+ (getXzlx() == null ? 0 : this.getXzlx().hashCode());
		result = 37 * result
				+ (getXzxs() == null ? 0 : this.getXzxs().hashCode());
		return result;
	}

	/**
	 * @return the qtxznm
	 */
	public String getQtxznm() {
		return qtxznm;
	}

	/**
	 * @param qtxznm the qtxznm to set
	 */
	public void setQtxznm(String qtxznm) {
		this.qtxznm = qtxznm;
	}

	/**
	 * @return the czr
	 */
	public String getCzr() {
		return czr;
	}

	/**
	 * @param czr the czr to set
	 */
	public void setCzr(String czr) {
		this.czr = czr;
	}

}