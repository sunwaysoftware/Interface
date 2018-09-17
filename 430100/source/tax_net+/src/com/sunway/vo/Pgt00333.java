package com.sunway.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Pgt00333 entity. @author MyEclipse Persistence Tools
 */


public class Pgt00333 implements java.io.Serializable {

	private static final long serialVersionUID = 2231366752785065843L;
	private String qtxzid;
	private String cd00302Fcid;
	private String cd00002Pssd;
	private String qtxznm;
	private Integer xzlx;
	private BigDecimal xzxs;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String sysSsgx;
	private Integer czlx;

	// Constructors

	/** default constructor */
	public Pgt00333() {
	}

	/**
	 * @param cd00302Fcid
	 * @param cd00002Pssd
	 */
	public Pgt00333(String cd00302Fcid, String cd00002Pssd) {
		this.cd00302Fcid = cd00302Fcid;
		this.cd00002Pssd = cd00002Pssd;
	}

	/**
	 * @param qtxzid
	 * @param cd00302Fcid
	 * @param cd00002Pssd
	 * @param qtxznm
	 * @param xzlx
	 * @param xzxs
	 * @param upddate
	 * @param cd00002Czr
	 * @param note
	 */
	public Pgt00333(String qtxzid, String cd00302Fcid, String cd00002Pssd,
			String qtxznm, Integer xzlx, BigDecimal xzxs, Date upddate,
			String cd00002Czr, String note, Integer czlx) {
		this.qtxzid = qtxzid;
		this.cd00302Fcid = cd00302Fcid;
		this.cd00002Pssd = cd00002Pssd;
		this.qtxznm = qtxznm;
		this.xzlx = xzlx;
		this.xzxs = xzxs;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.czlx = czlx;
	}

	/**
	 * @return the qtxzid
	 */
	public String getQtxzid() {
		return qtxzid;
	}

	/**
	 * @param qtxzid the qtxzid to set
	 */
	public void setQtxzid(String qtxzid) {
		this.qtxzid = qtxzid;
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
	 * @return the qtxznm
	 */
	public String getQtxznm() {
		return qtxznm;
	}

	/**
	 * @param qtxznm the qtxznm to set
	 */
	public void setQtxznm(String qtxznm) {
		this.qtxznm = qtxznm;
	}

	/**
	 * @return the xzlx
	 */
	public Integer getXzlx() {
		return xzlx;
	}

	/**
	 * @param xzlx the xzlx to set
	 */
	public void setXzlx(Integer xzlx) {
		this.xzlx = xzlx;
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
	 * @param sysSsgx the sysSsgx to set
	 */
	public void setSysSsgx(String sysSsgx) {
		this.sysSsgx = sysSsgx;
	}

	/**
	 * @return the sysSsgx
	 */
	public String getSysSsgx() {
		return sysSsgx;
	}

	/**
	 * @param cd00302Fcid the cd00302Fcid to set
	 */
	public void setCd00302Fcid(String cd00302Fcid) {
		this.cd00302Fcid = cd00302Fcid;
	}

	/**
	 * @return the cd00302Fcid
	 */
	public String getCd00302Fcid() {
		return cd00302Fcid;
	}

	/**
	 * @param czlx the czlx to set
	 */
	public void setCzlx(Integer czlx) {
		this.czlx = czlx;
	}

	/**
	 * @return the czlx
	 */
	public Integer getCzlx() {
		return czlx;
	}

	/**
	 * @return the xzxs
	 */
	public BigDecimal getXzxs() {
		return xzxs;
	}

	/**
	 * @param xzxs the xzxs to set
	 */
	public void setXzxs(BigDecimal xzxs) {
		this.xzxs = xzxs;
	}

}