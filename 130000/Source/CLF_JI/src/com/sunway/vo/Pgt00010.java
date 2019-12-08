package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgtUserRole entity. 
 * @author Lee
 */


public class Pgt00010 implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 4016191672347446302L;
	private String cd00002Userid;
	private String cd00003Roleid;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String ssgx;
	private String userIds;

	// Constructors

	/** default constructor */
	public Pgt00010() {
	}

	/**
	 * @param cd00002Userid
	 * @param cd00003Roleid
	 * @param upddate
	 * @param cd00002Userid1
	 * @param note
	 */
	public Pgt00010(String cd00002Userid, String cd00003Roleid,
			Timestamp upddate, String cd00002Czr, String note) {
		super();
		this.cd00002Userid = cd00002Userid;
		this.cd00003Roleid = cd00003Roleid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
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
	 * @return the ssgx
	 */
	public String getSsgx() {
		return ssgx;
	}

	/**
	 * @param ssgx the ssgx to set
	 */
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}

	/**
	 * @return the userIds
	 */
	public String getUserIds() {
		return userIds;
	}

	/**
	 * @param userIds the userIds to set
	 */
	public void setUserIds(String userIds) {
		this.userIds = userIds;
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

	

}