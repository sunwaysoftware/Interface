package com.sunway.vo;

import java.util.Date;

/**
 * Pgv12002eId entity. @author MyEclipse Persistence Tools
 */


public class Pgv12002e implements java.io.Serializable {

	private static final long serialVersionUID = 1919023036814810128L;
	private String cd12002Dcid;
	private String cd00053Qtxzid;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String qtxznm;
	private Byte xzlx;
	private Double xzxs;
	private String czr;

	// Constructors

	/** default constructor */
	public Pgv12002e() {
	}

	/** minimal constructor */
	public Pgv12002e(String cd12002Dcid, String cd00053Qtxzid, Date upddate,
			String cd00002Czr, String qtxznm, Byte xzlx, Double xzxs) {
		this.cd12002Dcid = cd12002Dcid;
		this.cd00053Qtxzid = cd00053Qtxzid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.qtxznm = qtxznm;
		this.xzlx = xzlx;
		this.xzxs = xzxs;
	}

	/** full constructor */
	public Pgv12002e(String cd12002Dcid, String cd00053Qtxzid, Date upddate,
			String cd00002Czr, String note, String qtxznm, Byte xzlx,
			Double xzxs, String czr) {
		this.cd12002Dcid = cd12002Dcid;
		this.cd00053Qtxzid = cd00053Qtxzid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.qtxznm = qtxznm;
		this.xzlx = xzlx;
		this.xzxs = xzxs;
		this.czr = czr;
	}

	// Property accessors

	public String getCd12002Dcid() {
		return this.cd12002Dcid;
	}

	public void setCd12002Dcid(String cd12002Dcid) {
		this.cd12002Dcid = cd12002Dcid;
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

	public String getQtxznm() {
		return this.qtxznm;
	}

	public void setQtxznm(String qtxznm) {
		this.qtxznm = qtxznm;
	}

	public Byte getXzlx() {
		return this.xzlx;
	}

	public void setXzlx(Byte xzlx) {
		this.xzlx = xzlx;
	}

	public Double getXzxs() {
		return this.xzxs;
	}

	public void setXzxs(Double xzxs) {
		this.xzxs = xzxs;
	}

	public String getCzr() {
		return this.czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Pgv12002e))
			return false;
		Pgv12002e castOther = (Pgv12002e) other;

		return ((this.getCd12002Dcid() == castOther.getCd12002Dcid()) || (this
				.getCd12002Dcid() != null
				&& castOther.getCd12002Dcid() != null && this.getCd12002Dcid()
				.equals(castOther.getCd12002Dcid())))
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
				&& ((this.getQtxznm() == castOther.getQtxznm()) || (this
						.getQtxznm() != null
						&& castOther.getQtxznm() != null && this.getQtxznm()
						.equals(castOther.getQtxznm())))
				&& ((this.getXzlx() == castOther.getXzlx()) || (this.getXzlx() != null
						&& castOther.getXzlx() != null && this.getXzlx()
						.equals(castOther.getXzlx())))
				&& ((this.getXzxs() == castOther.getXzxs()) || (this.getXzxs() != null
						&& castOther.getXzxs() != null && this.getXzxs()
						.equals(castOther.getXzxs())))
				&& ((this.getCzr() == castOther.getCzr()) || (this.getCzr() != null
						&& castOther.getCzr() != null && this.getCzr().equals(
						castOther.getCzr())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCd12002Dcid() == null ? 0 : this.getCd12002Dcid()
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
				+ (getQtxznm() == null ? 0 : this.getQtxznm().hashCode());
		result = 37 * result
				+ (getXzlx() == null ? 0 : this.getXzlx().hashCode());
		result = 37 * result
				+ (getXzxs() == null ? 0 : this.getXzxs().hashCode());
		result = 37 * result
				+ (getCzr() == null ? 0 : this.getCzr().hashCode());
		return result;
	}

}