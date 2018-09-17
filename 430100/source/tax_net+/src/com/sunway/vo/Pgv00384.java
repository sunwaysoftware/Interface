package com.sunway.vo;

import java.util.Date;

/**
 * Pgv003841Id entity. @author MyEclipse Persistence Tools
 */


public class Pgv00384 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = -1967062085643223559L;
	// Fields
	
	
	
	
	private String cd00302Fcid;
	private String cd00320Fcid;
	private Integer shlx;
	private String shyy;
	private Date upddate;
	private Boolean bxsh;
	private String cd00002Pssd;
	private String note;
	private String openWinUrl;
	private String shmc;
	private String cd00001Szqy;
	private String cd00001Ssgx;
	
	// Constructors

	/** default constructor */
	public Pgv00384() {
	}

	/** minimal constructor */
	public Pgv00384(String cd00302Fcid, Integer shlx, Date upddate,
			Boolean bxsh, String cd00002Pssd) {
		this.cd00302Fcid = cd00302Fcid;
		this.shlx = shlx;
		this.upddate = upddate;
		this.bxsh = bxsh;
		this.cd00002Pssd = cd00002Pssd;
	}

	/** full constructor */
	public Pgv00384(String cd00302Fcid, Integer shlx, String shyy,
			Date upddate, Boolean bxsh, String cd00002Pssd, String note) {
		this.cd00302Fcid = cd00302Fcid;
		this.shlx = shlx;
		this.shyy = shyy;
		this.upddate = upddate;
		this.bxsh = bxsh;
		this.cd00002Pssd = cd00002Pssd;
		this.note = note;
	}

	// Property accessors

	public String getCd00302Fcid() {
		return this.cd00302Fcid;
	}

	public void setCd00302Fcid(String cd00302Fcid) {
		this.cd00302Fcid = cd00302Fcid;
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

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Pgv00384))
			return false;
		Pgv00384 castOther = (Pgv00384) other;

		return ((this.getCd00302Fcid() == castOther.getCd00302Fcid()) || (this
				.getCd00302Fcid() != null
				&& castOther.getCd00302Fcid() != null && this.getCd00302Fcid()
				.equals(castOther.getCd00302Fcid())))
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
						.getCd00002Pssd().equals(castOther.getCd00002Pssd())))
				&& ((this.getNote() == castOther.getNote()) || (this.getNote() != null
						&& castOther.getNote() != null && this.getNote()
						.equals(castOther.getNote())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCd00302Fcid() == null ? 0 : this.getCd00302Fcid()
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
		result = 37 * result
				+ (getNote() == null ? 0 : this.getNote().hashCode());
		return result;
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

	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}

	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}

	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}

	public String getCd00001Szqy() {
		return cd00001Szqy;
	}	

	public String getCd00320Fcid() {
		return cd00320Fcid;
	}

	public void setCd00320Fcid(String cd00320Fcid) {
		this.cd00320Fcid = cd00320Fcid;
	}

}