package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgvRight entity. 
 * @author Lee
 */


public class Pgv00004 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = -5534171481654662243L;
	private String rightid;
	private String rightnm;
	private Timestamp upddate;
	private String cd00002Userid;
	private String note;
	private String czr;
	
        
    
    
    private Boolean isright;
    private String cd00001Ssgx;
	// Constructors

	/** default constructor */
	public Pgv00004() {
	}

	/**
	 * @return the rightid
	 */
	public String getRightid() {
		return rightid;
	}

	/**
	 * @param rightid the rightid to set
	 */
	public void setRightid(String rightid) {
		this.rightid = rightid;
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

	/**
	 * @return the isright
	 */
	public Boolean getIsright() {
		return isright;
	}

	/**
	 * @param isright the isright to set
	 */
	public void setIsright(Boolean isright) {
		this.isright = isright;
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