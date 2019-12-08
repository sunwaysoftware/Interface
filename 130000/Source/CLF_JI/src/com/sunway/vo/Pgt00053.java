package com.sunway.vo;

import java.sql.Timestamp;

/**
 * Pgt00053 entity.
 * @author Lee
 */

public class Pgt00053 implements java.io.Serializable {

	private static final long serialVersionUID = 8526634628221446745L;
	private String qtxzid;
	private String cd00001Szqylx;
	private String cd00001Szqy;
	private String parentid;
	private String qtxznm;
	private Short xzlx;
	private Double xzxs;
	private Short vieworder;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private Boolean isdir;
	private String xzmc;
	private String szqy;
	private String ssgx;
	private String level;
	private String noqtxzid;
	private Integer czlx;
	private Integer jglx;

	/** default constructor */
	public Pgt00053() {
	}


	/** full constructor */
	public Pgt00053(String qtxzid, String cd00001Szqy, String parentid,
			String qtxznm, Short xzlx, Short vieworder, Timestamp upddate,
			String note, Boolean isdir) {
		this.qtxzid = qtxzid;
		this.cd00001Szqy = cd00001Szqy;
		this.parentid = parentid;
		this.qtxznm = qtxznm;
		this.xzlx = xzlx;
		this.vieworder = vieworder;
		this.upddate = upddate;
		this.note = note;
		this.isdir = isdir;
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
	public Short getXzlx() {
		return xzlx;
	}

	/**
	 * @param xzlx the xzlx to set
	 */
	public void setXzlx(Short xzlx) {
		this.xzlx = xzlx;
	}

	/**
	 * @return the xzxs
	 */
	public Double getXzxs() {
		return xzxs;
	}

	/**
	 * @param xzxs the xzxs to set
	 */
	public void setXzxs(Double xzxs) {
		this.xzxs = xzxs;
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
	 * @return the xzmc
	 */
	public String getXzmc() {
		return xzmc;
	}

	/**
	 * @param xzmc the xzmc to set
	 */
	public void setXzmc(String xzmc) {
		this.xzmc = xzmc;
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

	/**
	 * @return the noqtxzid
	 */
	public String getNoqtxzid() {
		return noqtxzid;
	}

	/**
	 * @param noqtxzid the noqtxzid to set
	 */
	public void setNoqtxzid(String noqtxzid) {
		this.noqtxzid = noqtxzid;
	}


	/**
	 * @return the czlx
	 */
	public Integer getCzlx() {
		return czlx;
	}


	/**
	 * @param czlx the czlx to set
	 */
	public void setCzlx(Integer czlx) {
		this.czlx = czlx;
	}


	/**
	 * @return the jglx
	 */
	public Integer getJglx() {
		return jglx;
	}


	/**
	 * @param jglx the jglx to set
	 */
	public void setJglx(Integer jglx) {
		this.jglx = jglx;
	}
}
