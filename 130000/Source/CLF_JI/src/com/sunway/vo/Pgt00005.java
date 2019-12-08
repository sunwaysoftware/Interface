package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgtRoleRight entity. 
 * @author Lee
 */


public class Pgt00005 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -6023617854261242212L;
	private String cd00003Roleid;
	private String cd00004Rightid;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String cd00001Ssgx;

	// Constructors

	/** default constructor */
	public Pgt00005() {
	}

	

	/** full constructor */
	public Pgt00005(String cd00003Roleid, String cd00004Rightid,
			Timestamp upddate, String cd00002Userid, String note) {
		super();
		this.cd00003Roleid = cd00003Roleid;
		this.cd00004Rightid = cd00004Rightid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Userid;
		this.note = note;
	}


	/**
	 * @return the cd00003Roleid
	 */
	public String getCd00003Roleid() {
		return cd00003Roleid;
	}



	/**
	 * @param cd00003Roleid the cd00003Roleid to set
	 */
	public void setCd00003Roleid(String cd00003Roleid) {
		this.cd00003Roleid = cd00003Roleid;
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