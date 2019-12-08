package com.sunway.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Pgt12003 entity. @author MyEclipse Persistence Tools
 */


public class Pgt12003 implements java.io.Serializable {

	private static final long serialVersionUID = 452210346976602268L;
	private String fcid;
	private String cd12002Dcid;
	private String cd12001Swid;
	private String nsrmc;
	private String fdcmc;
	private String fwzldz;
	private String cd00001Qdfs;
	private String jcnf;
	private Short fwzcs;
	private Short ds;
	private Short dx;
	private Double zjzmj;
	private BigDecimal fcyz;
	private Double fwzjje;
	private String fczh;
	private BigDecimal ysfcyz;
	private BigDecimal msfcyz;
	private Date qdsj;
	private Date lrdate;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String sysSsgx;
	private String qdfs;
	private String cd00001Szqy;
	//地产承租人
	private String cd12006Czrzjh;
	private String czrmc;
	private Boolean sfnsr;
	private Date czkssj;
	private Date czjssj;
	private String czNote;
	private Integer countMX;
	private Date bgsj;
	private Integer bglx;
	
	// Constructors

	/** default constructor */
	public Pgt12003() {
	}

	public Pgt12003(String fcid) {
		this.fcid = fcid;
	}
	
	public Pgt12003(String fcid, String fczh) {
		this.fcid = fcid;
		this.fczh = fczh;
	}
	
	/** minimal constructor */
	public Pgt12003(String fcid, String fdcmc, String fwzldz, String cd00001Qdfs,
			String jcnf, Short fwzcs, Short ds, Short dx,
			Double zjzmj, BigDecimal fcyz, Double fwzjje, BigDecimal ysfcyz,
			BigDecimal msfcyz, Date lrdate, Date upddate, String cd00002Czr) {
		this.fcid = fcid;
		this.fdcmc = fdcmc;
		this.fwzldz = fwzldz;
		this.cd00001Qdfs = cd00001Qdfs;
		this.jcnf = jcnf;
		this.fwzcs = fwzcs;
		this.ds = ds;
		this.dx = dx;
		this.zjzmj = zjzmj;
		this.fcyz = fcyz;
		this.fwzjje = fwzjje;
		this.ysfcyz = ysfcyz;
		this.msfcyz = msfcyz;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgt12003(String fcid, String fdcmc, String fwzldz, String cd00001Qdfs,
			String jcnf, Short fwzcs, Short ds, Short dx,
			Double zjzmj, BigDecimal fcyz, Double fwzjje, String fczh,
			BigDecimal ysfcyz, BigDecimal msfcyz, Date qdsj, Date lrdate, Date upddate,
			String cd00002Czr, String note) {
		this.fcid = fcid;
		this.fdcmc = fdcmc;
		this.fwzldz = fwzldz;
		this.cd00001Qdfs = cd00001Qdfs;
		this.jcnf = jcnf;
		this.fwzcs = fwzcs;
		this.ds = ds;
		this.dx = dx;
		this.zjzmj = zjzmj;
		this.fcyz = fcyz;
		this.fwzjje = fwzjje;
		this.fczh = fczh;
		this.ysfcyz = ysfcyz;
		this.msfcyz = msfcyz;
		this.qdsj = qdsj;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	// Property accessors

	public String getFcid() {
		return this.fcid;
	}

	public void setFcid(String fcid) {
		this.fcid = fcid;
	}

	public String getFdcmc() {
		return this.fdcmc;
	}

	public void setFdcmc(String fdcmc) {
		this.fdcmc = fdcmc;
	}

	public String getFwzldz() {
		return this.fwzldz;
	}

	public void setFwzldz(String fwzldz) {
		this.fwzldz = fwzldz;
	}

	public String getCd00001Qdfs() {
		return this.cd00001Qdfs;
	}

	public void setCd00001Qdfs(String cd00001Qdfs) {
		this.cd00001Qdfs = cd00001Qdfs;
	}

	public String getJcnf() {
		return this.jcnf;
	}

	public void setJcnf(String jcnf) {
		this.jcnf = jcnf;
	}

	public Short getFwzcs() {
		return this.fwzcs;
	}

	public void setFwzcs(Short fwzcs) {
		this.fwzcs = fwzcs;
	}

	public Short getDs() {
		return this.ds;
	}

	public void setDs(Short ds) {
		this.ds = ds;
	}

	public Short getDx() {
		return this.dx;
	}

	public void setDx(Short dx) {
		this.dx = dx;
	}

	public Double getZjzmj() {
		return this.zjzmj;
	}

	public void setZjzmj(Double zjzmj) {
		this.zjzmj = zjzmj;
	}

	public BigDecimal getFcyz() {
		return this.fcyz;
	}

	public void setFcyz(BigDecimal fcyz) {
		this.fcyz = fcyz;
	}

	public Double getFwzjje() {
		return this.fwzjje;
	}

	public void setFwzjje(Double fwzjje) {
		this.fwzjje = fwzjje;
	}

	public String getFczh() {
		return this.fczh;
	}

	public void setFczh(String fczh) {
		this.fczh = fczh;
	}

	public BigDecimal getYsfcyz() {
		return this.ysfcyz;
	}

	public void setYsfcyz(BigDecimal ysfcyz) {
		this.ysfcyz = ysfcyz;
	}

	public BigDecimal getMsfcyz() {
		return this.msfcyz;
	}

	public void setMsfcyz(BigDecimal msfcyz) {
		this.msfcyz = msfcyz;
	}

	public Date getQdsj() {
		return this.qdsj;
	}

	public void setQdsj(Date qdsj) {
		this.qdsj = qdsj;
	}

	public Date getLrdate() {
		return this.lrdate;
	}

	public void setLrdate(Date lrdate) {
		this.lrdate = lrdate;
	}

	public Date getUpddate() {
		return this.upddate;
	}

	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}

	public String getCd00002Czr() {
		return this.cd00002Czr;
	}

	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the cd12002Dcid
	 */
	public String getCd12002Dcid() {
		return cd12002Dcid;
	}

	/**
	 * @param cd12002Dcid the cd12002Dcid to set
	 */
	public void setCd12002Dcid(String cd12002Dcid) {
		this.cd12002Dcid = cd12002Dcid;
	}

	/**
	 * @return the cd12001Swid
	 */
	public String getCd12001Swid() {
		return cd12001Swid;
	}

	/**
	 * @param cd12001Swid the cd12001Swid to set
	 */
	public void setCd12001Swid(String cd12001Swid) {
		this.cd12001Swid = cd12001Swid;
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
	 * @return the cd12006Czrzjh
	 */
	public String getCd12006Czrzjh() {
		return cd12006Czrzjh;
	}

	/**
	 * @param cd12006Czrzjh the cd12006Czrzjh to set
	 */
	public void setCd12006Czrzjh(String cd12006Czrzjh) {
		this.cd12006Czrzjh = cd12006Czrzjh;
	}

	/**
	 * @return the czrmc
	 */
	public String getCzrmc() {
		return czrmc;
	}

	/**
	 * @param czrmc the czrmc to set
	 */
	public void setCzrmc(String czrmc) {
		this.czrmc = czrmc;
	}

	/**
	 * @return the sfnsr
	 */
	public Boolean getSfnsr() {
		return sfnsr;
	}

	/**
	 * @param sfnsr the sfnsr to set
	 */
	public void setSfnsr(Boolean sfnsr) {
		this.sfnsr = sfnsr;
	}

	/**
	 * @return the czkssj
	 */
	public Date getCzkssj() {
		return czkssj;
	}

	/**
	 * @param czkssj the czkssj to set
	 */
	public void setCzkssj(Date czkssj) {
		this.czkssj = czkssj;
	}

	/**
	 * @return the czjssj
	 */
	public Date getCzjssj() {
		return czjssj;
	}

	/**
	 * @param czjssj the czjssj to set
	 */
	public void setCzjssj(Date czjssj) {
		this.czjssj = czjssj;
	}

	/**
	 * @return the czNote
	 */
	public String getCzNote() {
		return czNote;
	}

	/**
	 * @param czNote the czNote to set
	 */
	public void setCzNote(String czNote) {
		this.czNote = czNote;
	}

	/**
	 * @param qdfs the qdfs to set
	 */
	public void setQdfs(String qdfs) {
		this.qdfs = qdfs;
	}

	/**
	 * @return the qdfs
	 */
	public String getQdfs() {
		return qdfs;
	}

	/**
	 * @param nsrmc the nsrmc to set
	 */
	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}

	/**
	 * @return the nsrmc
	 */
	public String getNsrmc() {
		return nsrmc;
	}

	/**
	 * 初始化除FCID,DCID,SWID,NSRMC之外的屬性
	 */
	public void clear() {
		this.fdcmc = null;
		this.fwzldz = null;
		this.cd00001Qdfs = null;
		this.jcnf = null;
		this.fwzcs = null;
		this.ds = null;
		this.dx = null;
		this.zjzmj = null;
		this.fcyz = null;
		this.fwzjje = null;
		this.fczh = null;
		this.ysfcyz = null;
		this.msfcyz = null;
		this.qdsj = null;
		this.lrdate = null;
		this.upddate = null;
		this.cd00002Czr = null;
		this.note = null;
		this.sysSsgx = null;
		this.qdfs = null;
		this.cd12006Czrzjh = null;
		this.czrmc = null;
		this.sfnsr = null;
		this.czkssj = null;
		this.czjssj = null;
		this.czNote = null;
	}

	/**
	 * @param cd00001Szqy the cd00001Szqy to set
	 */
	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}

	/**
	 * @return the cd00001Szqy
	 */
	public String getCd00001Szqy() {
		return cd00001Szqy;
	}

	/**
	 * @param countMX the countMX to set
	 */
	public void setCountMX(Integer countMX) {
		this.countMX = countMX;
	}

	/**
	 * @return the countMX
	 */
	public Integer getCountMX() {
		return countMX;
	}

	/**
	 * @param bgsj the bgsj to set
	 */
	public void setBgsj(Date bgsj) {
		this.bgsj = bgsj;
	}

	/**
	 * @return the bgsj
	 */
	public Date getBgsj() {
		return bgsj;
	}

	/**
	 * @param bglx the bglx to set
	 */
	public void setBglx(Integer bglx) {
		this.bglx = bglx;
	}

	/**
	 * @return the bglx
	 */
	public Integer getBglx() {
		return bglx;
	}
}