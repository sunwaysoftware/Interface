package com.sunway.vo;

import java.util.Date;

/**
 * Pgv00351e entity.
 * @author Lee
 */

public class Pgv00351e implements java.io.Serializable {

	private static final long serialVersionUID = -356907742135419693L;
	private String cd00351Slid;
	private String cd00053Qtxzid;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String qtxznm;
	private Byte xzlx;
	private Double xzxs;
	private String czr;
	private String rootid;
	private String parentId;
	private Boolean isDir;
	private Boolean isId;
	private String cd00001Szqy;
	private String cd00001Fwlx;
	
	/** default constructor */
	public Pgv00351e() {
	}

	/** minimal constructor */
	public Pgv00351e(String cd00351Slid, String cd00053Qtxzid, Date upddate,
			String cd00002Czr, String qtxznm, Byte xzlx, Double xzxs) {
		this.cd00351Slid = cd00351Slid;
		this.cd00053Qtxzid = cd00053Qtxzid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.qtxznm = qtxznm;
		this.xzlx = xzlx;
		this.xzxs = xzxs;
	}

	/** full constructor */
	public Pgv00351e(String cd00351Slid, String cd00053Qtxzid, Date upddate,
			String cd00002Czr, String note, String qtxznm, Byte xzlx,
			Double xzxs, String czr) {
		this.cd00351Slid = cd00351Slid;
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
	 * @return the cd00351Slid
	 */
	public String getCd00351Slid() {
		return cd00351Slid;
	}
	/**
	 * @param cd00351Slid the cd00351Slid to set
	 */
	public void setCd00351Slid(String cd00351Slid) {
		this.cd00351Slid = cd00351Slid;
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

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Boolean getIsDir() {
		return isDir;
	}

	public void setIsDir(Boolean isDir) {
		this.isDir = isDir;
	}

	public Boolean getIsId() {
		return isId;
	}

	public void setIsId(Boolean isId) {
		this.isId = isId;
	}

	public String getCd00001Szqy() {
		return cd00001Szqy;
	}

	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}

	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}

	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}
}
