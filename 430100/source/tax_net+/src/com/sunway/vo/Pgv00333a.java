package com.sunway.vo;

import java.util.Date;

/**
 * Pgv00333aId entity. @author MyEclipse Persistence Tools
 */


public class Pgv00333a implements java.io.Serializable {

	private static final long serialVersionUID = 3130090711969915871L;
	private String qtxzid;
	private String cd00302Fcid;
	private String cd00002Pssd;
	private String qtxznm;
	private Integer xzlx;
	private Double xzxs;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String czr;
	private String sysSsgx;
	private Integer czlx;

	// Constructors

	/** default constructor */
	public Pgv00333a() {
	}

	/** minimal constructor */
	public Pgv00333a(String cd00302Fcid, String cd00002Pssd) {
		this.cd00302Fcid = cd00302Fcid;
		this.cd00002Pssd = cd00002Pssd;
	}

	/** full constructor */
	public Pgv00333a(String qtxzid, String cd00302Fcid, String cd00002Pssd,
			String qtxznm, Integer xzlx, Double xzxs, Date upddate,
			String cd00002Czr, String note, String czr) {
		this.qtxzid = qtxzid;
		this.cd00302Fcid = cd00302Fcid;
		this.cd00002Pssd = cd00002Pssd;
		this.qtxznm = qtxznm;
		this.setXzlx(xzlx);
		this.xzxs = xzxs;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.czr = czr;
	}

	// Property accessors

	public String getQtxzid() {
		return this.qtxzid;
	}

	public void setQtxzid(String qtxzid) {
		this.qtxzid = qtxzid;
	}

	public String getCd00302Fcid() {
		return this.cd00302Fcid;
	}

	public void setCd00302Fcid(String cd00302Fcid) {
		this.cd00302Fcid = cd00302Fcid;
	}

	public String getCd00002Pssd() {
		return this.cd00002Pssd;
	}

	public void setCd00002Pssd(String cd00002Pssd) {
		this.cd00002Pssd = cd00002Pssd;
	}

	public String getQtxznm() {
		return this.qtxznm;
	}

	public void setQtxznm(String qtxznm) {
		this.qtxznm = qtxznm;
	}

	public Double getXzxs() {
		return this.xzxs;
	}

	public void setXzxs(Double xzxs) {
		this.xzxs = xzxs;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Pgv00333a))
			return false;
		Pgv00333a castOther = (Pgv00333a) other;

		return ((this.getQtxzid() == castOther.getQtxzid()) || (this
				.getQtxzid() != null
				&& castOther.getQtxzid() != null && this.getQtxzid().equals(
				castOther.getQtxzid())))
				&& ((this.getCd00302Fcid() == castOther.getCd00302Fcid()) || (this
						.getCd00302Fcid() != null
						&& castOther.getCd00302Fcid() != null && this
						.getCd00302Fcid().equals(castOther.getCd00302Fcid())))
				&& ((this.getCd00002Pssd() == castOther.getCd00002Pssd()) || (this
						.getCd00002Pssd() != null
						&& castOther.getCd00002Pssd() != null && this
						.getCd00002Pssd().equals(castOther.getCd00002Pssd())))
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
						castOther.getCzr())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getQtxzid() == null ? 0 : this.getQtxzid().hashCode());
		result = 37
				* result
				+ (getCd00302Fcid() == null ? 0 : this.getCd00302Fcid()
						.hashCode());
		result = 37
				* result
				+ (getCd00002Pssd() == null ? 0 : this.getCd00002Pssd()
						.hashCode());
		result = 37 * result
				+ (getQtxznm() == null ? 0 : this.getQtxznm().hashCode());
		result = 37 * result
				+ (getXzlx() == null ? 0 : this.getXzlx().hashCode());
		result = 37 * result
				+ (getXzxs() == null ? 0 : this.getXzxs().hashCode());
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
		return result;
	}

	/**
	 * @param xzlx the xzlx to set
	 */
	public void setXzlx(Integer xzlx) {
		this.xzlx = xzlx;
	}

	/**
	 * @return the xzlx
	 */
	public Integer getXzlx() {
		return xzlx;
	}

	/**
	 * @param sysSsgx the sysSsgx to set
	 */
	public void setSysSsgx(String sysSsgx) {
		this.sysSsgx = sysSsgx;
	}

	/**
	 * @return the sysSsgx
	 */
	public String getSysSsgx() {
		return sysSsgx;
	}

	/**
	 * @param czlx the czlx to set
	 */
	public void setCzlx(Integer czlx) {
		this.czlx = czlx;
	}

	/**
	 * @return the czlx
	 */
	public Integer getCzlx() {
		return czlx;
	}

}