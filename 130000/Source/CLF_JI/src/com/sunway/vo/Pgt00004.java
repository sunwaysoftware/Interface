package com.sunway.vo;

import java.sql.Timestamp;
/**
 * PgtRight entity. 
 * @author Lee
 */


public class Pgt00004 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -6346232122574079976L;
	private String rightid;
	private String rightnm;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String cd00001Ssgx;
	private String userids;
	private String roleids;

	// Constructors

	/** default constructor */
	public Pgt00004() {
	}

	/** minimal constructor */
	public Pgt00004(String rightid, Timestamp upddate, String cd00002Czr) {
		this.rightid = rightid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgt00004(String rightid, String rightnm, Timestamp upddate,
			String cd00002Czr, String note) {
		this.rightid = rightid;
		this.rightnm = rightnm;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	// Property accessors

	public String getRightid() {
		return this.rightid;
	}

	public void setRightid(String rightid) {
		this.rightid = rightid;
	}

	public String getRightnm() {
		return this.rightnm;
	}

	public void setRightnm(String rightnm) {
		this.rightnm = rightnm;
	}

	public Timestamp getUpddate() {
		return this.upddate;
	}

	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}

	public String getNote() {
		return this.note;
	}

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