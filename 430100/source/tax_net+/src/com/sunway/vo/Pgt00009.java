package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgtUserSsgx entity. 
 * @author Lee
 */


public class Pgt00009 implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 57086361387757045L;
	private String cd00002Userid;
	private String cd00001Ssgx;
	private String cd00001Ssgx1;
	private String cd00001Ssgxlx;
	private String ssgx;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String roleids;
	private String rightids;
	
	// Constructors

	/** default constructor */
	public Pgt00009() {
	}

	/** full constructor */

	/**
	 * @param cd00002Userid
	 * @param cd00001Ssgx
	 * @param cd00001Ssgxlx
	 * @param upddate
	 * @param cd00002Userid1
	 * @param note
	 */
	public Pgt00009(String cd00002Userid, String cd00001Ssgx,
			String cd00001Ssgxlx, Timestamp upddate, String cd00002Userid1,
			String note) {
		super();
		this.cd00002Userid = cd00002Userid;
		this.cd00001Ssgx = cd00001Ssgx;
		this.cd00001Ssgxlx = cd00001Ssgxlx;
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
	 * @return the cd00001Ssgxlx
	 */
	public String getCd00001Ssgxlx() {
		return cd00001Ssgxlx;
	}

	/**
	 * @param cd00001Ssgxlx the cd00001Ssgxlx to set
	 */
	public void setCd00001Ssgxlx(String cd00001Ssgxlx) {
		this.cd00001Ssgxlx = cd00001Ssgxlx;
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
	 * @return the cd00001Ssgx1
	 */
	public String getCd00001Ssgx1() {
		return cd00001Ssgx1;
	}

	/**
	 * @param cd00001Ssgx1 the cd00001Ssgx1 to set
	 */
	public void setCd00001Ssgx1(String cd00001Ssgx1) {
		this.cd00001Ssgx1 = cd00001Ssgx1;
	}

	/**
	 * @return the roleids
	 */
	public String getRoleids() {
		return roleids;
	}

	/**
	 * @param roleids the roleids to set
	 */
	public void setRoleids(String roleids) {
		this.roleids = roleids;
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

	// Property accessors

}