package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgvOperaRecord entity. 
 * @author Lee
 */


public class Pgv00013 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 986267338229784182L;
	private Long logid;
	private Integer logtype;
	private String tablename;
	private String tablekey;
	private Timestamp upddate;
	private String cd00002Czr;
	private String logtypename;
	private String note;
	private String czr;
	
        
    
    
    private String cd00001Ssgx;
	// Constructors

	/** default constructor */
	public Pgv00013() {
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
	 * @return the logtypename
	 */
	public String getLogtypename() {
		return logtypename;
	}

	/**
	 * @param logtypename the logtypename to set
	 */
	public void setLogtypename(String logtypename) {
		this.logtypename = logtypename;
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

	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}

	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}


}