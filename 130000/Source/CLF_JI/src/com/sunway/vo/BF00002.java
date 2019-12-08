package com.sunway.vo;

import java.math.BigDecimal;

/**
 * BF00002 entity. 
 * @author Lee
 */

public class BF00002 implements java.io.Serializable {

	private static final long serialVersionUID = 6428870794300292839L;
	private String cd00001Ssgx;
	private String cd00002Pssd;
	private String cd00002Czr;
	private String cd00001Ssgx1;
	private Integer hs;
	private BigDecimal sbjg;
	private BigDecimal pgjg;
	private BigDecimal hdjg;
	private String fwlxids;
	private Integer bm;
	private String ssgx;
	// Constructors

	/** default constructor */
	public BF00002() {
	}


	// Property accessors

	public Integer getHs() {
		return this.hs;
	}

	public void setHs(Integer hs) {
		this.hs = hs;
	}

	public BigDecimal getSbjg() {
		return this.sbjg;
	}

	public void setSbjg(BigDecimal sbjg) {
		this.sbjg = sbjg;
	}

	public BigDecimal getPgjg() {
		return this.pgjg;
	}

	public void setPgjg(BigDecimal pgjg) {
		this.pgjg = pgjg;
	}

	public BigDecimal getHdjg() {
		return this.hdjg;
	}

	public void setHdjg(BigDecimal hdjg) {
		this.hdjg = hdjg;
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
	 * @return the cd00001Ssgx1
	 */
	public String getCd00001Ssgx1() {
		return cd00001Ssgx1;
	}


	/**
	 * @param cd00001Ssgx1 the cd00001Ssgx1 to set
	 */
	public void setCd00001Ssgx1(String cd00001Ssgx1) {
		this.cd00001Ssgx1 = cd00001Ssgx1;
	}


	/**
	 * @return the fwlxids
	 */
	public String getFwlxids() {
		return fwlxids;
	}


	/**
	 * @param fwlxids the fwlxids to set
	 */
	public void setFwlxids(String fwlxids) {
		this.fwlxids = fwlxids;
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
	 * @return the bm
	 */
	public Integer getBm() {
		return bm;
	}


	/**
	 * @param bm the bm to set
	 */
	public void setBm(Integer bm) {
		this.bm = bm;
	}

}