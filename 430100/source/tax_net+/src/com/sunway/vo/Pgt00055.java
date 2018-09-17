package com.sunway.vo;

import java.sql.Timestamp;

/**
 * Pgt00055 entity. 
 * @author lee
 * 
 */

public class Pgt00055 implements java.io.Serializable {

	private static final long serialVersionUID = 7668978663132939373L;
	private String cd00001Zjlxlx;
	private String cd00001Zjlx;
	private String zjlx;
	private Byte yxws;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String cd00001Ssgx;
	
	// Constructors

	/** default constructor */
	public Pgt00055() {
	}

	// Property accessors

	public Byte getYxws() {
		return this.yxws;
	}

	public void setYxws(Byte yxws) {
		this.yxws = yxws;
	}

	public Timestamp getUpddate() {
		return this.upddate;
	}

	public void setUpddate(Timestamp upddate) {
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
	 * @return the cd00001Zjlxlx
	 */
	public String getCd00001Zjlxlx() {
		return cd00001Zjlxlx;
	}

	/**
	 * @param cd00001Zjlxlx the cd00001Zjlxlx to set
	 */
	public void setCd00001Zjlxlx(String cd00001Zjlxlx) {
		this.cd00001Zjlxlx = cd00001Zjlxlx;
	}

	/**
	 * @return the cd00001Zjlx
	 */
	public String getCd00001Zjlx() {
		return cd00001Zjlx;
	}

	/**
	 * @param cd00001Zjlx the cd00001Zjlx to set
	 */
	public void setCd00001Zjlx(String cd00001Zjlx) {
		this.cd00001Zjlx = cd00001Zjlx;
	}

	/**
	 * @return the cd00001Ssgx
	 */
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}

	/**
	 * @param cd00001Ssgx the cd00001Ssgx to set
	 */
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}

	/**
	 * @return the zjlx
	 */
	public String getZjlx() {
		return zjlx;
	}

	/**
	 * @param zjlx the zjlx to set
	 */
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}


}