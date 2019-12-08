package com.sunway.vo;

import java.util.Date;

/**
 * Pgt10033 entity. @author MyEclipse Persistence Tools
 */


public class Pgt10033 implements java.io.Serializable {

	private static final long serialVersionUID = 6244760680336894497L;
	// Fields
	private String qtxzid;
	private String cd12004Mxid;
	private String cd00002Pssd;
	private String qtxznm;
	private Integer xzlx;
	private Double xzxs;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String sysSsgx;
	private String xzmc;
	
	// Constructors

	/** default constructor */
	public Pgt10033() {
	}
	
	/**
	 * full constructor
	 * @param qtxzid
	 * @param cd12004Mxid
	 * @param cd00002Pssd
	 * @param qtxznm
	 * @param xzlx
	 * @param xzxs
	 * @param upddate
	 * @param cd00002Czr
	 * @param note
	 */
	public Pgt10033(String qtxzid, String cd12004Mxid, String cd00002Pssd,
			String qtxznm, Integer xzlx, Double xzxs, Date upddate,
			String cd00002Czr, String note, String xzmc) {
		this.qtxzid = qtxzid;
		this.cd12004Mxid = cd12004Mxid;
		this.cd00002Pssd = cd00002Pssd;
		this.qtxznm = qtxznm;
		this.xzlx = xzlx;
		this.xzxs = xzxs;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.xzmc = xzmc;
	}

	/**
	 * minimal constructor
	 * @param cd12004Mxid
	 * @param cd00002Pssd
	 */
	public Pgt10033(String cd12004Mxid, String cd00002Pssd) {
		this.cd12004Mxid = cd12004Mxid;
		this.cd00002Pssd = cd00002Pssd;
	}

	// Property accessors
	
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
	 * @return the xzlx
	 */
	public Integer getXzlx() {
		return xzlx;
	}

	/**
	 * @param xzlx the xzlx to set
	 */
	public void setXzlx(Integer xzlx) {
		this.xzlx = xzlx;
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
	 * @param xzmc the xzmc to set
	 */
	public void setXzmc(String xzmc) {
		this.xzmc = xzmc;
	}

	/**
	 * @return the xzmc
	 */
	public String getXzmc() {
		return xzmc;
	}
}