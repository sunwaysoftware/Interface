package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgtSHpfmdj entity. 
 * @author Lee
 */


public class Pgt12081 implements java.io.Serializable {

	private static final long serialVersionUID = -6401970934043010639L;
	private String cd00001Jzjglx;
	private String cd00001Jzjg;
	private Double minvalue;
	private Double maxvalue;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String cd00001Szqylx;
	private String cd00001Szqy;
	private String cd00001Ssgx;
	
	// Constructors

	/** default constructor */
	public Pgt12081() {
	}

	/** minimal constructor */
	public Pgt12081(Double minvalue, Double maxvalue,
			Timestamp upddate, String cd00002Czr) {
		this.minvalue = minvalue;
		this.maxvalue = maxvalue;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgt12081(Double minvalue, Double maxvalue,
			Timestamp upddate, String cd00002Czr, String note) {
		this.minvalue = minvalue;
		this.maxvalue = maxvalue;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	/**
	 * @return the cd00001Jzjglx
	 */
	public String getCd00001Jzjglx() {
		return cd00001Jzjglx;
	}

	/**
	 * @param cd00001Jzjglx the cd00001Jzjglx to set
	 */
	public void setCd00001Jzjglx(String cd00001Jzjglx) {
		this.cd00001Jzjglx = cd00001Jzjglx;
	}

	/**
	 * @return the cd00001Jzjg
	 */
	public String getCd00001Jzjg() {
		return cd00001Jzjg;
	}

	/**
	 * @param cd00001Jzjg the cd00001Jzjg to set
	 */
	public void setCd00001Jzjg(String cd00001Jzjg) {
		this.cd00001Jzjg = cd00001Jzjg;
	}

	/**
	 * @return the minvalue
	 */
	public Double getMinvalue() {
		return minvalue;
	}

	/**
	 * @param minvalue the minvalue to set
	 */
	public void setMinvalue(Double minvalue) {
		this.minvalue = minvalue;
	}

	/**
	 * @return the maxvalue
	 */
	public Double getMaxvalue() {
		return maxvalue;
	}

	/**
	 * @param maxvalue the maxvalue to set
	 */
	public void setMaxvalue(Double maxvalue) {
		this.maxvalue = maxvalue;
	}

	/**
	 * @return the upddate
	 */
	public Timestamp getUpddate() {
		return upddate;
	}

	/**
	 * @param upddate the upddate to set
	 */
	public void setUpddate(Timestamp upddate) {
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
	 * @return the cd00001Szqylx
	 */
	public String getCd00001Szqylx() {
		return cd00001Szqylx;
	}

	/**
	 * @param cd00001Szqylx the cd00001Szqylx to set
	 */
	public void setCd00001Szqylx(String cd00001Szqylx) {
		this.cd00001Szqylx = cd00001Szqylx;
	}

	/**
	 * @return the cd00001Szqy
	 */
	public String getCd00001Szqy() {
		return cd00001Szqy;
	}

	/**
	 * @param cd00001Szqy the cd00001Szqy to set
	 */
	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
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

	// Property accessors

	

}