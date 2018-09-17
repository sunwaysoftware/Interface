package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgvUserRole entity. 
 * @author Lee
 */


public class Pgv00010 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = -8599167230779471979L;
	private String cd00002Userid;
	private String cd00003Roleid;
	private Timestamp upddate;
	private String cd00002Userid1;
	private String note;
	private String usernm;
	private String czr;
	private String rolenm;
	
	 
    private String ssgx;

	// Constructors

	/** default constructor */
	public Pgv00010() {
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
	 * @return the cd00002Userid1
	 */
	public String getCd00002Userid1() {
		return cd00002Userid1;
	}

	/**
	 * @param cd00002Userid1 the cd00002Userid1 to set
	 */
	public void setCd00002Userid1(String cd00002Userid1) {
		this.cd00002Userid1 = cd00002Userid1;
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
}