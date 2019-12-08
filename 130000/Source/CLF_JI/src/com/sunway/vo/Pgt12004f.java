package com.sunway.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Pgt12004f entity. @author MyEclipse Persistence Tools
 */


public class Pgt12004f implements java.io.Serializable {

	private static final long serialVersionUID = -2569893220921350763L;
	private BigDecimal zpid;
	private String cd12004Mxid;
	private Integer zplx;
	private String zplj;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String sysSsgx;
	private String zpljMin;
	
	// Constructors

	/** default constructor */
	public Pgt12004f() {
	}

	/** minimal constructor */
	public Pgt12004f(BigDecimal zpid, Date upddate, String cd00002Czr) {
		this.zpid = zpid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgt12004f(BigDecimal zpid, String zplj, Date upddate, String cd00002Czr, String note) {
		this.zpid = zpid;
		this.zplj = zplj;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	// Property accessors

	public BigDecimal getZpid() {
		return this.zpid;
	}

	public void setZpid(BigDecimal zpid) {
		this.zpid = zpid;
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
	 * @return the sysSsgx
	 */
	public String getSysSsgx() {
		return sysSsgx;
	}

	/**
	 * @param sysSsgx the sysSsgx to set
	 */
	public void setSysSsgx(String sysSsgx) {
		this.sysSsgx = sysSsgx;
	}

	/**
	 * @param zplx the zplx to set
	 */
	public void setZplx(Integer zplx) {
		this.zplx = zplx;
	}

	/**
	 * @return the zplx
	 */
	public Integer getZplx() {
		return zplx;
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

}