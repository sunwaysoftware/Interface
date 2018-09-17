package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgtUserRight entity. 
 * @author Lee
 */


public class Pgt00006 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 6667446186775268793L;
	private String cd00002Userid;
	private String cd00004Rightid;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String cd00001Ssgx;

	// Constructors

	/** default constructor */
	public Pgt00006() {
	}


	/** full constructor */
	/**
	 * @param cd00002Userid
	 * @param cd00004Rightid
	 * @param upddate
	 * @param cd00002Userid1
	 * @param note
	 */
	public Pgt00006(String cd00002Userid, String cd00004Rightid,
			Timestamp upddate, String cd00002Userid1, String note) {
		super();
		this.cd00002Userid = cd00002Userid;
		this.cd00004Rightid = cd00004Rightid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Userid1;
		this.note = note;
	}


	/**
	 * @return the cd00002Userid
	 */
	public String getCd00002Userid() {
		return cd00002Userid;
	}


	/**
	 * @param cd00002Userid the cd00002Userid to set
	 */
	public void setCd00002Userid(String cd00002Userid) {
		this.cd00002Userid = cd00002Userid;
	}


	/**
	 * @return the cd00004Rightid
	 */
	public String getCd00004Rightid() {
		return cd00004Rightid;
	}


	/**
	 * @param cd00004Rightid the cd00004Rightid to set
	 */
	public void setCd00004Rightid(String cd00004Rightid) {
		this.cd00004Rightid = cd00004Rightid;
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

}