package com.sunway.vo;

import java.util.Date;

/**
 * Pgv02061e entity.
 * @author Lee
 */
@SuppressWarnings("serial")
public class Pgv02061e implements java.io.Serializable {

	private String cd02061Slid;
	private String cd00053Qtxzid;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String qtxznm;
	private Byte xzlx;
	private Double xzxs;
	private String czr;
	private String rootid;
	
	/** default constructor */
	public Pgv02061e() {
	}

	/** minimal constructor */
	public Pgv02061e(String cd02061Slid, String cd00053Qtxzid, Date upddate,
			String cd00002Czr, String qtxznm, Byte xzlx, Double xzxs) {
		this.cd02061Slid = cd02061Slid;
		this.cd00053Qtxzid = cd00053Qtxzid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.qtxznm = qtxznm;
		this.xzlx = xzlx;
		this.xzxs = xzxs;
	}

	/** full constructor */
	public Pgv02061e(String cd02061Slid, String cd00053Qtxzid, Date upddate,
			String cd00002Czr, String note, String qtxznm, Byte xzlx,
			Double xzxs, String czr) {
		this.cd02061Slid = cd02061Slid;
		this.cd00053Qtxzid = cd00053Qtxzid;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.qtxznm = qtxznm;
		this.xzlx = xzlx;
		this.xzxs = xzxs;
		this.czr = czr;
	}

	public String getCd02061Slid() {
		return cd02061Slid;
	}

	public void setCd02061Slid(String cd02061Slid) {
		this.cd02061Slid = cd02061Slid;
	}

	public String getCd00053Qtxzid() {
		return cd00053Qtxzid;
	}

	public void setCd00053Qtxzid(String cd00053Qtxzid) {
		this.cd00053Qtxzid = cd00053Qtxzid;
	}

	public Date getUpddate() {
		return upddate;
	}

	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}

	public String getCd00002Czr() {
		return cd00002Czr;
	}

	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getQtxznm() {
		return qtxznm;
	}

	public void setQtxznm(String qtxznm) {
		this.qtxznm = qtxznm;
	}

	public Byte getXzlx() {
		return xzlx;
	}

	public void setXzlx(Byte xzlx) {
		this.xzlx = xzlx;
	}

	public Double getXzxs() {
		return xzxs;
	}

	public void setXzxs(Double xzxs) {
		this.xzxs = xzxs;
	}

	public String getCzr() {
		return czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public String getRootid() {
		return rootid;
	}

	public void setRootid(String rootid) {
		this.rootid = rootid;
	}
	
}
