package com.sunway.vo;

import java.util.Date;

/**
 * Pgv12003bId entity. @author MyEclipse Persistence Tools
 */


public class Pgv12003b implements java.io.Serializable {

	private static final long serialVersionUID = 1492898458871168305L;
	private String cd12003Fcid;
	private String cd12006Czrzjh;
	private Boolean sfnsr;
	private Date czkssj;
	private Date czjssj;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String czrmc;

	// Constructors

	/** default constructor */
	public Pgv12003b() {
	}

	/** minimal constructor */
	public Pgv12003b(String cd12003Fcid, Boolean sfnsr, Date upddate,
			String cd00002Czr) {
		this.cd12003Fcid = cd12003Fcid;
		this.sfnsr = sfnsr;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgv12003b(String cd12003Fcid, String cd12006Czrzjh, Boolean sfnsr,
			Date czkssj, Date czjssj, Date upddate, String cd00002Czr,
			String note, String czrmc) {
		this.cd12003Fcid = cd12003Fcid;
		this.cd12006Czrzjh = cd12006Czrzjh;
		this.sfnsr = sfnsr;
		this.czkssj = czkssj;
		this.czjssj = czjssj;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.czrmc = czrmc;
	}

	// Property accessors

	public String getCd12003Fcid() {
		return this.cd12003Fcid;
	}

	public void setCd12003Fcid(String cd12003Fcid) {
		this.cd12003Fcid = cd12003Fcid;
	}

	public String getCd12006Czrzjh() {
		return this.cd12006Czrzjh;
	}

	public void setCd12006Czrzjh(String cd12006Czrzjh) {
		this.cd12006Czrzjh = cd12006Czrzjh;
	}

	public Boolean getSfnsr() {
		return this.sfnsr;
	}

	public void setSfnsr(Boolean sfnsr) {
		this.sfnsr = sfnsr;
	}

	public Date getCzkssj() {
		return this.czkssj;
	}

	public void setCzkssj(Date czkssj) {
		this.czkssj = czkssj;
	}

	public Date getCzjssj() {
		return this.czjssj;
	}

	public void setCzjssj(Date czjssj) {
		this.czjssj = czjssj;
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

	public String getCzrmc() {
		return this.czrmc;
	}

	public void setCzrmc(String czrmc) {
		this.czrmc = czrmc;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Pgv12003b))
			return false;
		Pgv12003b castOther = (Pgv12003b) other;

		return ((this.getCd12003Fcid() == castOther.getCd12003Fcid()) || (this
				.getCd12003Fcid() != null
				&& castOther.getCd12003Fcid() != null && this.getCd12003Fcid()
				.equals(castOther.getCd12003Fcid())))
				&& ((this.getCd12006Czrzjh() == castOther.getCd12006Czrzjh()) || (this
						.getCd12006Czrzjh() != null
						&& castOther.getCd12006Czrzjh() != null && this
						.getCd12006Czrzjh()
						.equals(castOther.getCd12006Czrzjh())))
				&& ((this.getSfnsr() == castOther.getSfnsr()) || (this
						.getSfnsr() != null
						&& castOther.getSfnsr() != null && this.getSfnsr()
						.equals(castOther.getSfnsr())))
				&& ((this.getCzkssj() == castOther.getCzkssj()) || (this
						.getCzkssj() != null
						&& castOther.getCzkssj() != null && this.getCzkssj()
						.equals(castOther.getCzkssj())))
				&& ((this.getCzjssj() == castOther.getCzjssj()) || (this
						.getCzjssj() != null
						&& castOther.getCzjssj() != null && this.getCzjssj()
						.equals(castOther.getCzjssj())))
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
				&& ((this.getCzrmc() == castOther.getCzrmc()) || (this
						.getCzrmc() != null
						&& castOther.getCzrmc() != null && this.getCzrmc()
						.equals(castOther.getCzrmc())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCd12003Fcid() == null ? 0 : this.getCd12003Fcid()
						.hashCode());
		result = 37
				* result
				+ (getCd12006Czrzjh() == null ? 0 : this.getCd12006Czrzjh()
						.hashCode());
		result = 37 * result
				+ (getSfnsr() == null ? 0 : this.getSfnsr().hashCode());
		result = 37 * result
				+ (getCzkssj() == null ? 0 : this.getCzkssj().hashCode());
		result = 37 * result
				+ (getCzjssj() == null ? 0 : this.getCzjssj().hashCode());
		result = 37 * result
				+ (getUpddate() == null ? 0 : this.getUpddate().hashCode());
		result = 37
				* result
				+ (getCd00002Czr() == null ? 0 : this.getCd00002Czr()
						.hashCode());
		result = 37 * result
				+ (getNote() == null ? 0 : this.getNote().hashCode());
		result = 37 * result
				+ (getCzrmc() == null ? 0 : this.getCzrmc().hashCode());
		return result;
	}

}