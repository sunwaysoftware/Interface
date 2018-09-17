package com.sunway.vo;

import java.util.Date;

/**
 * Pgv02002e entity.
 * @author Lee
 */

public class Pgv02002c implements java.io.Serializable {

	private static final long serialVersionUID = -111802514475248180L;
	private String cd02002Fcid;
	private String cd00053Qtxzid;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String qtxznm;
	private Byte xzlx;
	private Double xzxs;
	private String czr;
	private String parentId;
	private String rootid;
	private Boolean isDir;
	private Boolean isId;
	private Boolean isMr;
	private String cd00001Szqy;
	private String cd00001Fwlx;
	
	/** default constructor */
	public Pgv02002c() {
	}

	/** minimal constructor */
	public Pgv02002c(String cd02002Fcid, String cd00053Qtxzid, Date upddate,
			String cd00002Czr, String qtxznm, Byte xzlx, Double xzxs) {
		this.cd02002Fcid = cd02002Fcid;
		this.cd00053Qtxzid = cd00053Qtxzid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.qtxznm = qtxznm;
		this.xzlx = xzlx;
		this.xzxs = xzxs;
	}

	/** full constructor */
	public Pgv02002c(String cd02002Fcid, String cd00053Qtxzid, Date upddate,
			String cd00002Czr, String note, String qtxznm, Byte xzlx,
			Double xzxs, String czr) {
		this.cd02002Fcid = cd02002Fcid;
		this.cd00053Qtxzid = cd00053Qtxzid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.qtxznm = qtxznm;
		this.xzlx = xzlx;
		this.xzxs = xzxs;
		this.czr = czr;
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
	public Byte getXzlx() {
		return xzlx;
	}
	/**
	 * @param xzlx the xzlx to set
	 */
	public void setXzlx(Byte xzlx) {
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

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the rootid
	 */
	public String getRootid() {
		return rootid;
	}

	/**
	 * @param rootid the rootid to set
	 */
	public void setRootid(String rootid) {
		this.rootid = rootid;
	}

	public void setIsDir(Boolean isDir) {
		this.isDir = isDir;
	}

	public Boolean getIsDir() {
		return isDir;
	}

	public void setIsId(Boolean isId) {
		this.isId = isId;
	}

	public Boolean getIsId() {
		return isId;
	}

	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}

	public String getCd00001Szqy() {
		return cd00001Szqy;
	}

	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}

	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}

	/**
	 * @return the isMr
	 */
	public Boolean getIsMr() {
		return isMr;
	}

	/**
	 * @param isMr the isMr to set
	 */
	public void setIsMr(Boolean isMr) {
		this.isMr = isMr;
	}
}
