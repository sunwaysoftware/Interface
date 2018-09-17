package com.sunway.vo;

import java.util.Date;

/**
 * Pgt00332 entity. @author MyEclipse Persistence Tools
 */


public class Pgt00332 implements java.io.Serializable {

	private static final long serialVersionUID = 5214499920282803904L;
	private String cd00302Fcid;
	private String cd00002Pssd;
	private Double gbpgjg;
	private Double gbxzxs;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private Double pgjg;

	// Constructors

	/** default constructor */
	public Pgt00332() {
	}

	/**
	 * @param cd00302Fcid
	 * @param cd00002Pssd
	 */
	public Pgt00332(String cd00302Fcid, String cd00002Pssd) {
		this.cd00302Fcid = cd00302Fcid;
		this.cd00002Pssd = cd00002Pssd;
	}

	/**
	 * @param cd00302Fcid
	 * @param cd00002Pssd
	 * @param gbpgjg
	 * @param gbxzxs
	 * @param upddate
	 * @param cd00002Czr
	 * @param note
	 * @param pgjg
	 */
	public Pgt00332(String cd00302Fcid, String cd00002Pssd, Double gbpgjg,
			Double gbxzxs, Date upddate, String cd00002Czr, String note,
			Double pgjg) {
		this.cd00302Fcid = cd00302Fcid;
		this.cd00002Pssd = cd00002Pssd;
		this.gbpgjg = gbpgjg;
		this.gbxzxs = gbxzxs;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.pgjg = pgjg;
	}

	/**
	 * @return the cd00302Fcid
	 */
	public String getCd00302Fcid() {
		return cd00302Fcid;
	}

	/**
	 * @param cd00302Fcid the cd00302Fcid to set
	 */
	public void setCd00302Fcid(String cd00302Fcid) {
		this.cd00302Fcid = cd00302Fcid;
	}

	/**
	 * @return the cd00002Pssd
	 */
	public String getCd00002Pssd() {
		return cd00002Pssd;
	}

	/**
	 * @param cd00002Pssd the cd00002Pssd to set
	 */
	public void setCd00002Pssd(String cd00002Pssd) {
		this.cd00002Pssd = cd00002Pssd;
	}

	/**
	 * @return the gbpgjg
	 */
	public Double getGbpgjg() {
		return gbpgjg;
	}

	/**
	 * @param gbpgjg the gbpgjg to set
	 */
	public void setGbpgjg(Double gbpgjg) {
		this.gbpgjg = gbpgjg;
	}

	/**
	 * @return the gbxzxs
	 */
	public Double getGbxzxs() {
		return gbxzxs;
	}

	/**
	 * @param gbxzxs the gbxzxs to set
	 */
	public void setGbxzxs(Double gbxzxs) {
		this.gbxzxs = gbxzxs;
	}

	/**
	 * @return the upddate
	 */
	public Date getUpddate() {
		return upddate;
	}

	/**
	 * @param upddate the upddate to set
	 */
	public void setUpddate(Date upddate) {
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
	 * @return the pgjg
	 */
	public Double getPgjg() {
		return pgjg;
	}

	/**
	 * @param pgjg the pgjg to set
	 */
	public void setPgjg(Double pgjg) {
		this.pgjg = pgjg;
	}

}