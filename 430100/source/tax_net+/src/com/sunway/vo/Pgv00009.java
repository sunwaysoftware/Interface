package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgvUserSsgx entity. 
 * @author Lee
 */


public class Pgv00009 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 9081144817409572934L;
	private String cd00002Userid;
	private String cd00001Ssgxlx;
	private String cd00001Ssgx;
	private String ssgx;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String usernm;
	private String czr;
	
        
    
    
    private Integer isdefault;
    
	// Constructors

	/** default constructor */
	public Pgv00009() {
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
	 * @return the isdefault
	 */
	public Integer getIsdefault() {
		return isdefault;
	}

	/**
	 * @param isdefault the isdefault to set
	 */
	public void setIsdefault(Integer isdefault) {
		this.isdefault = isdefault;
	}

}