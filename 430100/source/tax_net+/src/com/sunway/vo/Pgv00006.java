package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgvUserRight entity. 
 * @author Lee
 */


public class Pgv00006 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 539762091979293970L;
	private String cd00002Userid;
	private String cd00004Rightid;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String usernm;
	private String rightnm;
	private String czr;
	
        
    
    
    
	// Constructors

	/** default constructor */
	public Pgv00006() {
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
	 * @return the usernm
	 */
	public String getUsernm() {
		return usernm;
	}

	/**
	 * @param usernm the usernm to set
	 */
	public void setUsernm(String usernm) {
		this.usernm = usernm;
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