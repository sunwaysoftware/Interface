package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgvRoleRight entity. 
 * @author Lee
 */


public class Pgv00005 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = -942711328716420990L;
	private String cd00003Roleid;
	private String cd00004Rightid;
	private Timestamp upddate;
	private String cd00002Userid;
	private String note;
	private String rolenm;
	private String rightnm;
	private String czr;
	
        
    
    

	// Constructors

	/** default constructor */
	public Pgv00005() {
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
	 * @return the rightnm
	 */
	public String getRightnm() {
		return rightnm;
	}

	/**
	 * @param rightnm the rightnm to set
	 */
	public void setRightnm(String rightnm) {
		this.rightnm = rightnm;
	}

	/**
	 * @return the czr
	 */
	public String getCzr() {
		return czr;
	}

	/**
	 * @param czr the czr to set
	 */
	public void setCzr(String czr) {
		this.czr = czr;
	}	

}