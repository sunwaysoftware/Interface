package com.sunway.vo;

import java.util.Date;

/**
 * Pgv00352fId entity. @author MyEclipse Persistence Tools
 */


public class Pgv00352f implements java.io.Serializable {

	private static final long serialVersionUID = 6277881223711920904L;

	private String zpid;

	private Integer zplx;
	private String zplj;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String zplxmc;
	private String czr;
	private String zpljMin;
	private String cd00352xqdm;
	private String xqnm;
	private String qdh;
	private String zpLjdownLoad;
	private String t00306Id;
	// Constructors

	/** default constructor */
	public Pgv00352f() {
	}

	/** minimal constructor */
	public Pgv00352f(String zpid, String cd00352xqdm, Integer zplx,
			Date upddate, String cd00002Czr) {
		this.zpid = zpid;
		this.cd00352xqdm = cd00352xqdm;
		this.zplx = zplx;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgv00352f(String zpid, String cd00352xqdm, Integer zplx,
			String zplj, Date upddate, String cd00002Czr, String note,
			String zplxmc, String czr) {
		this.zpid = zpid;
		this.cd00352xqdm = cd00352xqdm;
		this.zplx = zplx;
		this.zplj = zplj;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.zplxmc = zplxmc;
		this.czr = czr;
	}

	// Property accessors

	public String getZpid() {
		return this.zpid;
	}

	public void setZpid(String zpid) {
		this.zpid = zpid;
	}


	public Integer getZplx() {
		return this.zplx;
	}

	public void setZplx(Integer zplx) {
		this.zplx = zplx;
	}

	public String getZplj() {
		return this.zplj;
	}

	public void setZplj(String zplj) {
		this.zplj = zplj;
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

	public String getZplxmc() {
		return this.zplxmc;
	}

	public void setZplxmc(String zplxmc) {
		this.zplxmc = zplxmc;
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
		if (!(other instanceof Pgv00352f))
			return false;
		Pgv00352f castOther = (Pgv00352f) other;

		return ((this.getZpid() == castOther.getZpid()) || (this.getZpid() != null
				&& castOther.getZpid() != null && this.getZpid().equals(
				castOther.getZpid())))
				&& ((this.getCd00352xqdm() == castOther.getCd00352xqdm()) || (this
						.getCd00352xqdm() != null
						&& castOther.getCd00352xqdm() != null && this
						.getCd00352xqdm().equals(castOther.getCd00352xqdm())))
				&& ((this.getZplx() == castOther.getZplx()) || (this.getZplx() != null
						&& castOther.getZplx() != null && this.getZplx()
						.equals(castOther.getZplx())))
				&& ((this.getZplj() == castOther.getZplj()) || (this.getZplj() != null
						&& castOther.getZplj() != null && this.getZplj()
						.equals(castOther.getZplj())))
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
				&& ((this.getZplxmc() == castOther.getZplxmc()) || (this
						.getZplxmc() != null
						&& castOther.getZplxmc() != null && this.getZplxmc()
						.equals(castOther.getZplxmc())))
				&& ((this.getCzr() == castOther.getCzr()) || (this.getCzr() != null
						&& castOther.getCzr() != null && this.getCzr().equals(
						castOther.getCzr())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getZpid() == null ? 0 : this.getZpid().hashCode());
		result = 37
				* result
				+ (getCd00352xqdm() == null ? 0 : this.getCd00352xqdm()
						.hashCode());
		result = 37 * result
				+ (getZplx() == null ? 0 : this.getZplx().hashCode());
		result = 37 * result
				+ (getZplj() == null ? 0 : this.getZplj().hashCode());
		result = 37 * result
				+ (getUpddate() == null ? 0 : this.getUpddate().hashCode());
		result = 37
				* result
				+ (getCd00002Czr() == null ? 0 : this.getCd00002Czr()
						.hashCode());
		result = 37 * result
				+ (getNote() == null ? 0 : this.getNote().hashCode());
		result = 37 * result
				+ (getZplxmc() == null ? 0 : this.getZplxmc().hashCode());
		result = 37 * result
				+ (getCzr() == null ? 0 : this.getCzr().hashCode());
		return result;
	}

	/**
	 * @param zpljMin the zpljMin to set
	 */
	public void setZpljMin(String zpljMin) {
		this.zpljMin = zpljMin;
	}

	/**
	 * @return the zpljMin
	 */
	public String getZpljMin() {
		return zpljMin;
	}

	public String getCd00352xqdm() {
		return cd00352xqdm;
	}

	public void setCd00352xqdm(String cd00352xqdm) {
		this.cd00352xqdm = cd00352xqdm;
	}

	public String getXqnm() {
		return xqnm;
	}

	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}

	public String getQdh() {
		return qdh;
	}

	public void setQdh(String qdh) {
		this.qdh = qdh;
	}

	public void setZpLjdownLoad(String zpLjdownLoad) {
		this.zpLjdownLoad = zpLjdownLoad;
	}

	public String getZpLjdownLoad() {
		return zpLjdownLoad;
	}

	public String getT00306Id() {
		return t00306Id;
	}

	public void setT00306Id(String t00306Id) {
		this.t00306Id = t00306Id;
	}

}