package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgtRole entity. 
 * @author Lee
 */


public class Pgt00003 implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = -1555393161598739686L;
	private String roleid;
	private String rolenm;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String ssgx;
	private String userids;
	private String rightids;
	private String szqy;
	private String cd00001Ssgx;

	// Constructors

	/** default constructor */
	public Pgt00003() {
	}

	/** minimal constructor */
	public Pgt00003(String roleid, Timestamp upddate, String cd00002Czr) {
		this.roleid = roleid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgt00003(String roleid, String rolenm, Timestamp upddate,
			String cd00002Czr, String note) {
		this.roleid = roleid;
		this.rolenm = rolenm;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	// Property accessors

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
	 * @return the roleid
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * @param roleid the roleid to set
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	/**
	 * @return the rolenm
	 */
	public String getRolenm() {
		return rolenm;
	}

	/**
	 * @param rolenm the rolenm to set
	 */
	public void setRolenm(String rolenm) {
		this.rolenm = rolenm;
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
	 * @return the userids
	 */
	public String getUserids() {
		return userids;
	}

	/**
	 * @param userids the userids to set
	 */
	public void setUserids(String userids) {
		this.userids = userids;
	}

	/**
	 * @return the rightids
	 */
	public String getRightids() {
		return rightids;
	}

	/**
	 * @param rightids the rightids to set
	 */
	public void setRightids(String rightids) {
		this.rightids = rightids;
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
	 * @return the szqy
	 */
	public String getSzqy() {
		return szqy;
	}

	/**
	 * @param szqy the szqy to set
	 */
	public void setSzqy(String szqy) {
		this.szqy = szqy;
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