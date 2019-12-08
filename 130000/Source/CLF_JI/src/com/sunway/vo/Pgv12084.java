package com.sunway.vo;

import java.util.Date;

/**
 * Pgv12084Id entity. @author MyEclipse Persistence Tools
 */


public class Pgv12084 implements java.io.Serializable {

	private static final long serialVersionUID = -7539031402168965747L;
	private String cd12004Mxid;
	private Integer shlx;
	private String shyy;
	private Date upddate;
	private Boolean bxsh;
	private String cd00002Pssd;
	private String note;
	private String openWinUrl;
	private String shmc;
	
	// Constructors

	/** default constructor */
	public Pgv12084() {
	}

	/** minimal constructor */
	public Pgv12084(String cd12004Mxid, Integer shlx, Date upddate, Boolean bxsh, String cd00002Pssd) {
		this.cd12004Mxid = cd12004Mxid;
		this.shlx = shlx;
		this.upddate = upddate;
		this.bxsh = bxsh;
		this.cd00002Pssd = cd00002Pssd;
	}

	/** full constructor */
	public Pgv12084(String cd12004Mxid, Integer shlx, String shyy, Date upddate,
			Boolean bxsh, String cd00002Pssd, String cd12001Swid) {
		this.cd12004Mxid = cd12004Mxid;
		this.shlx = shlx;
		this.shyy = shyy;
		this.upddate = upddate;
		this.bxsh = bxsh;
		this.cd00002Pssd = cd00002Pssd;
	}

	// Property accessors

	public String getCd12004Mxid() {
		return this.cd12004Mxid;
	}

	public void setCd12004Mxid(String cd12004Mxid) {
		this.cd12004Mxid = cd12004Mxid;
	}

	public Integer getShlx() {
		return this.shlx;
	}

	public void setShlx(Integer shlx) {
		this.shlx = shlx;
	}

	public String getShyy() {
		return this.shyy;
	}

	public void setShyy(String shyy) {
		this.shyy = shyy;
	}

	public Date getUpddate() {
		return this.upddate;
	}

	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}

	public Boolean getBxsh() {
		return this.bxsh;
	}

	public void setBxsh(Boolean bxsh) {
		this.bxsh = bxsh;
	}

	public String getCd00002Pssd() {
		return this.cd00002Pssd;
	}

	public void setCd00002Pssd(String cd00002Pssd) {
		this.cd00002Pssd = cd00002Pssd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Pgv12084))
			return false;
		Pgv12084 castOther = (Pgv12084) other;

		return ((this.getCd12004Mxid() == castOther.getCd12004Mxid()) || (this
				.getCd12004Mxid() != null
				&& castOther.getCd12004Mxid() != null && this.getCd12004Mxid()
				.equals(castOther.getCd12004Mxid())))
				&& ((this.getShlx() == castOther.getShlx()) || (this.getShlx() != null
						&& castOther.getShlx() != null && this.getShlx()
						.equals(castOther.getShlx())))
				&& ((this.getShyy() == castOther.getShyy()) || (this.getShyy() != null
						&& castOther.getShyy() != null && this.getShyy()
						.equals(castOther.getShyy())))
				&& ((this.getUpddate() == castOther.getUpddate()) || (this
						.getUpddate() != null
						&& castOther.getUpddate() != null && this.getUpddate()
						.equals(castOther.getUpddate())))
				&& ((this.getBxsh() == castOther.getBxsh()) || (this.getBxsh() != null
						&& castOther.getBxsh() != null && this.getBxsh()
						.equals(castOther.getBxsh())))
				&& ((this.getCd00002Pssd() == castOther.getCd00002Pssd()) || (this
						.getCd00002Pssd() != null
						&& castOther.getCd00002Pssd() != null && this
						.getCd00002Pssd().equals(castOther.getCd00002Pssd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCd12004Mxid() == null ? 0 : this.getCd12004Mxid()
						.hashCode());
		result = 37 * result
				+ (getShlx() == null ? 0 : this.getShlx().hashCode());
		result = 37 * result
				+ (getShyy() == null ? 0 : this.getShyy().hashCode());
		result = 37 * result
				+ (getUpddate() == null ? 0 : this.getUpddate().hashCode());
		result = 37 * result
				+ (getBxsh() == null ? 0 : this.getBxsh().hashCode());
		result = 37
				* result
				+ (getCd00002Pssd() == null ? 0 : this.getCd00002Pssd()
						.hashCode());
		return result;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param openWinUrl the openWinUrl to set
	 */
	public void setOpenWinUrl(String openWinUrl) {
		this.openWinUrl = openWinUrl;
	}

	/**
	 * @return the openWinUrl
	 */
	public String getOpenWinUrl() {
		return openWinUrl;
	}

	/**
	 * @param shmc the shmc to set
	 */
	public void setShmc(String shmc) {
		this.shmc = shmc;
	}

	/**
	 * @return the shmc
	 */
	public String getShmc() {
		return shmc;
	}

}