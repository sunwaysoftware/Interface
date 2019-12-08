package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgtOperaRecord entity. 
 * @author Lee
 */


public class Pgt00013 implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 189805984255067922L;
	private Long logid;
	private Integer logtype;
	private String tablename;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String tablekey;
	private Timestamp startdate;
	private Timestamp enddate;
	private String cd00001Ssgx;
	
	// Constructors

	/** default constructor */
	public Pgt00013() {
	}

	/** full constructor */
	public Pgt00013(Long logid, Integer logtype, String tablename,
			Timestamp upddate, String cd00002Userid, String note, String tablekey) {
		this.logid = logid;
		this.logtype = logtype;
		this.tablename = tablename;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Userid;
		this.note = note;
		this.tablekey = tablekey;
	}

	/**
	 * @return the logid
	 */
	public Long getLogid() {
		return logid;
	}

	/**
	 * @param logid the logid to set
	 */
	public void setLogid(Long logid) {
		this.logid = logid;
	}

	/**
	 * @return the logtype
	 */
	public Integer getLogtype() {
		return logtype;
	}

	/**
	 * @param logtype the logtype to set
	 */
	public void setLogtype(Integer logtype) {
		this.logtype = logtype;
	}

	/**
	 * @return the tablename
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * @param tablename the tablename to set
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
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
	 * @return the tablekey
	 */
	public String getTablekey() {
		return tablekey;
	}

	/**
	 * @param tablekey the tablekey to set
	 */
	public void setTablekey(String tablekey) {
		this.tablekey = tablekey;
	}

	/**
	 * @return the startdate
	 */
	public Timestamp getStartdate() {
		return startdate;
	}

	/**
	 * @param startdate the startdate to set
	 */
	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	/**
	 * @return the enddate
	 */
	public Timestamp getEnddate() {
		return enddate;
	}

	/**
	 * @param enddate the enddate to set
	 */
	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
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