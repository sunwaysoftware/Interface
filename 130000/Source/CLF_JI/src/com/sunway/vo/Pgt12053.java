package com.sunway.vo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Pgt12053 entity. 
 * @author Lee
 */

public class Pgt12053 implements java.io.Serializable {

	private static final long serialVersionUID = -4334904794249662823L;
	private String ddid;
	private String parentid;
	private String ddnm;
	private String cd00001Szqylx;
	private String cd00001Szqy;
	private Short vieworder;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private Boolean isdir;
	private String szqy;
	private String noddid;
	private String ssgx;
	private String level;

	/** default constructor */
	public Pgt12053() {
	}

	/** full constructor */
	public Pgt12053(String ddid, String parentid, String ddnm,
			String cd00001Szqylx, String cd00001Szqy, Short vieworder,
			Timestamp upddate, String cd00002Czr, String note, Boolean isdir) {
		this.ddid = ddid;
		this.parentid = parentid;
		this.ddnm = ddnm;
		this.cd00001Szqylx = cd00001Szqylx;
		this.cd00001Szqy = cd00001Szqy;
		this.vieworder = vieworder;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.isdir = isdir;
	}

	/**
	 * 初始化除parentid,cd00001Szqy之外的屬性
	 */
	public void clear() {
		this.ddid = null;
		this.ddnm = null;
		this.cd00001Szqylx = null;
		this.vieworder = null;
		this.upddate = null;
		this.cd00002Czr = null;
		this.note = null;
		this.isdir = null;
		this.szqy = null;
		this.noddid = null;
		this.ssgx = null;
		this.level = null;
	}

	/**
	 * @return the ddid
	 */
	public String getDdid() {
		return ddid;
	}
	/**
	 * @param ddid the ddid to set
	 */
	public void setDdid(String ddid) {
		this.ddid = ddid;
	}
	/**
	 * @return the parentid
	 */
	public String getParentid() {
		return parentid;
	}
	/**
	 * @param parentid the parentid to set
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	/**
	 * @return the ddnm
	 */
	public String getDdnm() {
		return ddnm;
	}
	/**
	 * @param ddnm the ddnm to set
	 */
	public void setDdnm(String ddnm) {
		this.ddnm = ddnm;
	}
	/**
	 * @return the cd00001Szqylx
	 */
	public String getCd00001Szqylx() {
		return cd00001Szqylx;
	}
	/**
	 * @param cd00001Szqylx the cd00001Szqylx to set
	 */
	public void setCd00001Szqylx(String cd00001Szqylx) {
		this.cd00001Szqylx = cd00001Szqylx;
	}
	/**
	 * @return the cd00001Szqy
	 */
	public String getCd00001Szqy() {
		return cd00001Szqy;
	}
	/**
	 * @param cd00001Szqy the cd00001Szqy to set
	 */
	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}
	/**
	 * @return the vieworder
	 */
	public Short getVieworder() {
		return vieworder;
	}
	/**
	 * @param vieworder the vieworder to set
	 */
	public void setVieworder(Short vieworder) {
		this.vieworder = vieworder;
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
	 * @return the isdir
	 */
	public Boolean getIsdir() {
		return isdir;
	}
	/**
	 * @param isdir the isdir to set
	 */
	public void setIsdir(Boolean isdir) {
		this.isdir = isdir;
	}
	/**
	 * @return the szqy
	 */
	public String getSzqy() {
		return szqy;
	}
	/**
	 * @param szqy the szqy to set
	 */
	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}
	/**
	 * @return the noddid
	 */
	public String getNoddid() {
		return noddid;
	}
	/**
	 * @param noddid the noddid to set
	 */
	public void setNoddid(String noddid) {
		this.noddid = noddid;
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
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
}
