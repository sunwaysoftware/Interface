package com.sunway.vo;

import java.util.Date;

/**
 * Pgt02034a entity. @author MyEclipse Persistence Tools
 */


public class Pgt02034a implements java.io.Serializable {

	private static final long serialVersionUID = -7630857146674412228L;
	private String cd02002Fcid;
	private String cdSlid;
	private String cd00002Pssd;
	private String cd00053Qtxzid;
	private Double cd00053Qtxz;
	private Double cd00053Slqtxz;
	private Date upddate;
	private String cd00002Czr;
	private String qtxzNm;
	private String czr;
	private Integer czlx;
	
	// Constructors

	/** default constructor */
	public Pgt02034a() {
	}

	/**
	 * @param cd02002Fcid
	 * @param cdSlid
	 * @param cd00002Pssd
	 */
	public Pgt02034a(String cd02002Fcid, String cdSlid, String cd00002Pssd) {
		this.cd02002Fcid = cd02002Fcid;
		this.cdSlid = cdSlid;
		this.cd00002Pssd = cd00002Pssd;
	}

	/**
	 * @param cd02002Fcid
	 * @param cdSlid
	 * @param cd00002Pssd
	 * @param cd00053Qtxzid
	 * @param cd00053Qtxz
	 * @param cd00053Slqtxz
	 * @param upddate
	 * @param cd00002Czr
	 * @param note
	 * @param czr
	 */
	public Pgt02034a(String cd02002Fcid, String cdSlid, String cd00002Pssd,
			String cd00053Qtxzid, Double cd00053Qtxz, Double cd00053Slqtxz,
			Date upddate, String cd00002Czr, String qtxzNm, String czr, Integer czlx) {
		this.cd02002Fcid = cd02002Fcid;
		this.cdSlid = cdSlid;
		this.cd00002Pssd = cd00002Pssd;
		this.cd00053Qtxzid = cd00053Qtxzid;
		this.cd00053Qtxz = cd00053Qtxz;
		this.cd00053Slqtxz = cd00053Slqtxz;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.qtxzNm = qtxzNm;
		this.czr = czr;
		this.czlx = czlx;
	}
	
	/**
	 * @return the cd02002Fcid
	 */
	public String getCd02002Fcid() {
		return cd02002Fcid;
	}

	/**
	 * @param cd02002Fcid the cd02002Fcid to set
	 */
	public void setCd02002Fcid(String cd02002Fcid) {
		this.cd02002Fcid = cd02002Fcid;
	}

	/**
	 * @return the cdSlid
	 */
	public String getCdSlid() {
		return cdSlid;
	}

	/**
	 * @param cdSlid the cdSlid to set
	 */
	public void setCdSlid(String cdSlid) {
		this.cdSlid = cdSlid;
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
	 * @return the cd00053Qtxzid
	 */
	public String getCd00053Qtxzid() {
		return cd00053Qtxzid;
	}

	/**
	 * @param cd00053Qtxzid the cd00053Qtxzid to set
	 */
	public void setCd00053Qtxzid(String cd00053Qtxzid) {
		this.cd00053Qtxzid = cd00053Qtxzid;
	}

	/**
	 * @return the cd00053Qtxz
	 */
	public Double getCd00053Qtxz() {
		return cd00053Qtxz;
	}

	/**
	 * @param cd00053Qtxz the cd00053Qtxz to set
	 */
	public void setCd00053Qtxz(Double cd00053Qtxz) {
		this.cd00053Qtxz = cd00053Qtxz;
	}

	/**
	 * @return the cd00053Slqtxz
	 */
	public Double getCd00053Slqtxz() {
		return cd00053Slqtxz;
	}

	/**
	 * @param cd00053Slqtxz the cd00053Slqtxz to set
	 */
	public void setCd00053Slqtxz(Double cd00053Slqtxz) {
		this.cd00053Slqtxz = cd00053Slqtxz;
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
	 * @param czr the czr to set
	 */
	public void setCzr(String czr) {
		this.czr = czr;
	}

	/**
	 * @return the czr
	 */
	public String getCzr() {
		return czr;
	}

	/**
	 * @param qtxzNm the qtxzNm to set
	 */
	public void setQtxzNm(String qtxzNm) {
		this.qtxzNm = qtxzNm;
	}

	/**
	 * @return the qtxzNm
	 */
	public String getQtxzNm() {
		return qtxzNm;
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
}