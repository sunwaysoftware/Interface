package com.sunway.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Pgt12003f entity. @author MyEclipse Persistence Tools
 */


public class Pgt12003f implements java.io.Serializable {

	private static final long serialVersionUID = -4829654274501308724L;
	private BigDecimal zpid;
	private String cd12003Fcid;
	private Integer zplx;
	private String zplj;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String zpljMin;

	// Constructors

	/** default constructor */
	public Pgt12003f() {
	}

	/** minimal constructor */
	public Pgt12003f(BigDecimal zpid, Integer zplx,	Date upddate, String cd00002Czr) {
		this.zpid = zpid;
		this.zplx = zplx;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgt12003f(BigDecimal zpid, Integer zplx,	String zplj, Date upddate, String cd00002Czr, String note) {
		this.zpid = zpid;
		this.zplx = zplx;
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

	/**
	 * @param cd12003Fcid the cd12003Fcid to set
	 */
	public void setCd12003Fcid(String cd12003Fcid) {
		this.cd12003Fcid = cd12003Fcid;
	}

	/**
	 * @return the cd12003Fcid
	 */
	public String getCd12003Fcid() {
		return cd12003Fcid;
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