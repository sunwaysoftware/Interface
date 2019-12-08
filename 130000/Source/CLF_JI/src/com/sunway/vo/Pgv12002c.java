package com.sunway.vo;

import java.util.Date;

/**
 * Pgv12002cId entity. @author MyEclipse Persistence Tools
 */


public class Pgv12002c implements java.io.Serializable {

	private static final long serialVersionUID = 322216625350848043L;
	private String id;
	private String cd12002Dcid;
	private String cd12006Czrzjh;
	private Boolean sfnsr;
	private Date czkssj;
	private Date czjssj;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String czr;
	private String czrmc;

	// Constructors

	/** default constructor */
	public Pgv12002c() {
	}

	/** minimal constructor */
	public Pgv12002c(String id, String cd12002Dcid, Boolean sfnsr,
			Date upddate, String cd00002Czr) {
		this.id = id;
		this.cd12002Dcid = cd12002Dcid;
		this.sfnsr = sfnsr;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgv12002c(String id, String cd12002Dcid, String cd12006Czrzjh,
			Boolean sfnsr, Date czkssj, Date czjssj, Date upddate,
			String cd00002Czr, String note, String czr) {
		this.id = id;
		this.cd12002Dcid = cd12002Dcid;
		this.cd12006Czrzjh = cd12006Czrzjh;
		this.sfnsr = sfnsr;
		this.czkssj = czkssj;
		this.czjssj = czjssj;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.czr = czr;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCd12002Dcid() {
		return this.cd12002Dcid;
	}

	public void setCd12002Dcid(String cd12002Dcid) {
		this.cd12002Dcid = cd12002Dcid;
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

	public String getCzr() {
		return this.czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	/**
	 * @param czrmc the czrmc to set
	 */
	public void setCzrmc(String czrmc) {
		this.czrmc = czrmc;
	}

	/**
	 * @return the czrmc
	 */
	public String getCzrmc() {
		return czrmc;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Pgv12002c))
			return false;
		Pgv12002c castOther = (Pgv12002c) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getCd12002Dcid() == castOther.getCd12002Dcid()) || (this
						.getCd12002Dcid() != null
						&& castOther.getCd12002Dcid() != null && this
						.getCd12002Dcid().equals(castOther.getCd12002Dcid())))
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
				&& ((this.getCzrmc() == castOther.getCzrmc()) || (this.getCzrmc() != null
						&& castOther.getCzrmc() != null && this.getCzrmc()
						.equals(castOther.getCzrmc())))
				&& ((this.getCzr() == castOther.getCzr()) || (this.getCzr() != null
						&& castOther.getCzr() != null && this.getCzr().equals(
						castOther.getCzr())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37
				* result
				+ (getCd12002Dcid() == null ? 0 : this.getCd12002Dcid()
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
		result = 37 * result
				+ (getCzr() == null ? 0 : this.getCzr().hashCode());
		return result;
	}

}