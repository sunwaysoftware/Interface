package com.sunway.vo;

import java.util.Date;

/**
 * Pgt12002b entity. @author MyEclipse Persistence Tools
 */


public class Pgt12002b implements java.io.Serializable {

	private static final long serialVersionUID = -2657712347001648311L;
	private String cd12002Dcid;
	private String cd12006Czrzjh;
	private Boolean sfnsr;
	private Date czkssj;
	private Date czjssj;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String czrmc;
	private String sysSsgx;

	// Constructors

	/** default constructor */
	public Pgt12002b() {
	}

	/** minimal constructor */
	public Pgt12002b(String cd12002Dcid, Pgt12002 pgt12002, Boolean sfnsr,
			Date upddate, String cd00002Czr) {
		this.cd12002Dcid = cd12002Dcid;
		this.sfnsr = sfnsr;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgt12002b(String cd12002Dcid, Boolean sfnsr, Date czkssj, Date czjssj, Date upddate,
			String cd00002Czr, String note) {
		this.cd12002Dcid = cd12002Dcid;
		this.sfnsr = sfnsr;
		this.czkssj = czkssj;
		this.czjssj = czjssj;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	// Property accessors

	public String getCd12002Dcid() {
		return this.cd12002Dcid;
	}

	public void setCd12002Dcid(String cd12002Dcid) {
		this.cd12002Dcid = cd12002Dcid;
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

	/**
	 * @param cd12006Czrzjh the cd12006Czrzjh to set
	 */
	public void setCd12006Czrzjh(String cd12006Czrzjh) {
		this.cd12006Czrzjh = cd12006Czrzjh;
	}

	/**
	 * @return the cd12006Czrzjh
	 */
	public String getCd12006Czrzjh() {
		return cd12006Czrzjh;
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

}