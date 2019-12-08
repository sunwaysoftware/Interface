package com.sunway.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Pgt12004 entity. @author MyEclipse Persistence Tools
 */


public class Pgt12004 implements java.io.Serializable {

	private static final long serialVersionUID = -4937940001151487478L;
	private String mxid;
	private String cd12001Swid;
	private String nsrmc;
	private String cd12003Fcid;
	private String cd12002Dcid;
	private String fdcmc;
	private String szcc;
	private String bwjfh;
	private String cd00001Jzjg;
	private String cd00001Fwyt;
	private Double ytjzmj;
	private BigDecimal fcyz;
	private String cd00001Xjbz;
	private String cd00001Fwcx;
	private Date lrdate;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String cd12053Ddid;
	private BigDecimal gytzj;
	private String sysSsgx;
	private String jzjg;
	private String xjbz;
	private String fwcx;
	private String fwyt;
	private String cd00001Szqy;
	private String fwzldz;
	private String cd00001Mssz;
	private String mssz;
	//private Integer sfms;
	//房产明细当前承租人表
	private String cd12006Czrzjh;
	private String czrmc;
	private Boolean sfnsr;
	private Date czkssj;
	private Date czjssj;
	private String czNote;
	//其他修正
	private String qtxzCb;
	private String qtxzSy;
	private String cd00001Fwss;
	private String ddnm;
	private Date bgsj;
	private Integer bglx;
	
	// Constructors

	/** default constructor */
	public Pgt12004() {
	}

	/** minimal constructor */
	public Pgt12004(String mxid, String fdcmc, String szcc, String cd00001Jzjg,
			String cd00001Fwyt, Double ytjzmj, BigDecimal fcyz, Date lrdate,
			Date upddate, String cd00002Czr, BigDecimal gytzj) {
		this.mxid = mxid;
		this.fdcmc = fdcmc;
		this.szcc = szcc;
		this.cd00001Jzjg = cd00001Jzjg;
		this.cd00001Fwyt = cd00001Fwyt;
		this.ytjzmj = ytjzmj;
		this.fcyz = fcyz;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.gytzj = gytzj;
	}

	/** full constructor */
	public Pgt12004(String mxid, String fdcmc, String szcc, String bwjfh,
			String cd00001Jzjg, String cd00001Fwyt, Double ytjzmj, BigDecimal fcyz,
			String cd00001Xjbz, String cd00001Fwcx, Date lrdate, Date upddate,
			String cd00002Czr, String note, String cd12053Ddid, BigDecimal gytzj) {
		this.mxid = mxid;
		this.fdcmc = fdcmc;
		this.szcc = szcc;
		this.bwjfh = bwjfh;
		this.cd00001Jzjg = cd00001Jzjg;
		this.cd00001Fwyt = cd00001Fwyt;
		this.ytjzmj = ytjzmj;
		this.fcyz = fcyz;
		this.cd00001Xjbz = cd00001Xjbz;
		this.cd00001Fwcx = cd00001Fwcx;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.cd12053Ddid = cd12053Ddid;
		this.gytzj = gytzj;
	}

	/**
	 * 初始化除MXID,FCID,DCID,SWID,NSRMC之外的屬性
	 */
	public void clear(){
		this.fdcmc = null;
		this.szcc = null;
		this.bwjfh = null;
		this.cd00001Jzjg = null;
		this.cd00001Fwyt = null;
		this.ytjzmj = null;
		this.fcyz = null;
		this.cd00001Xjbz = null;
		this.cd00001Fwcx = null;
		this.lrdate = null;
		this.upddate = null;
		this.cd00002Czr = null;
		this.note = null;
		this.cd12053Ddid = null;
		this.gytzj = null;
		this.sysSsgx = null;
		this.jzjg = null;
		this.xjbz = null;
		this.fwcx = null;
		this.fwyt = null;
		this.cd00001Szqy = null;
		this.fwzldz = null;
		this.cd00001Mssz = null;
		this.mssz = null;
		this.cd12006Czrzjh = null;
		this.czrmc = null;
		this.sfnsr = null;
		this.czkssj = null;
		this.czjssj = null;
		this.czNote = null;
		this.qtxzCb = null;
		this.qtxzSy = null;
		this.cd00001Fwss = null;
		this.ddnm = null;
		this.bgsj = null;
		this.bglx = null;		
	}
	
	// Property accessors

	public String getMxid() {
		return this.mxid;
	}

	public void setMxid(String mxid) {
		this.mxid = mxid;
	}

	public String getFdcmc() {
		return this.fdcmc;
	}

	public void setFdcmc(String fdcmc) {
		this.fdcmc = fdcmc;
	}

	public String getSzcc() {
		return this.szcc;
	}

	public void setSzcc(String szcc) {
		this.szcc = szcc;
	}

	public String getBwjfh() {
		return this.bwjfh;
	}

	public void setBwjfh(String bwjfh) {
		this.bwjfh = bwjfh;
	}

	public String getCd00001Jzjg() {
		return this.cd00001Jzjg;
	}

	public void setCd00001Jzjg(String cd00001Jzjg) {
		this.cd00001Jzjg = cd00001Jzjg;
	}

	public String getCd00001Fwyt() {
		return this.cd00001Fwyt;
	}

	public void setCd00001Fwyt(String cd00001Fwyt) {
		this.cd00001Fwyt = cd00001Fwyt;
	}

	public Double getYtjzmj() {
		return this.ytjzmj;
	}

	public void setYtjzmj(Double ytjzmj) {
		this.ytjzmj = ytjzmj;
	}

	public BigDecimal getFcyz() {
		return this.fcyz;
	}

	public void setFcyz(BigDecimal fcyz) {
		this.fcyz = fcyz;
	}

	public String getCd00001Xjbz() {
		return this.cd00001Xjbz;
	}

	public void setCd00001Xjbz(String cd00001Xjbz) {
		this.cd00001Xjbz = cd00001Xjbz;
	}

	public String getCd00001Fwcx() {
		return this.cd00001Fwcx;
	}

	public void setCd00001Fwcx(String cd00001Fwcx) {
		this.cd00001Fwcx = cd00001Fwcx;
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

	public String getCd12053Ddid() {
		return this.cd12053Ddid;
	}

	public void setCd12053Ddid(String cd12053Ddid) {
		this.cd12053Ddid = cd12053Ddid;
	}

	public BigDecimal getGytzj() {
		return this.gytzj;
	}

	public void setGytzj(BigDecimal gytzj) {
		this.gytzj = gytzj;
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
	 * @return the cd12003Fcid
	 */
	public String getCd12003Fcid() {
		return cd12003Fcid;
	}

	/**
	 * @param cd12003Fcid the cd12003Fcid to set
	 */
	public void setCd12003Fcid(String cd12003Fcid) {
		this.cd12003Fcid = cd12003Fcid;
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
	 * @return the qtxzCb
	 */
	public String getQtxzCb() {
		return qtxzCb;
	}

	/**
	 * @param qtxzCb the qtxzCb to set
	 */
	public void setQtxzCb(String qtxzCb) {
		this.qtxzCb = qtxzCb;
	}

	/**
	 * @return the qtxzSy
	 */
	public String getQtxzSy() {
		return qtxzSy;
	}

	/**
	 * @param qtxzSy the qtxzSy to set
	 */
	public void setQtxzSy(String qtxzSy) {
		this.qtxzSy = qtxzSy;
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
	 * @param cd00001Fwss the cd00001Fwss to set
	 */
	public void setCd00001Fwss(String cd00001Fwss) {
		this.cd00001Fwss = cd00001Fwss;
	}

	/**
	 * @return the cd00001Fwss
	 */
	public String getCd00001Fwss() {
		return cd00001Fwss;
	}

	/**
	 * @return the jzjg
	 */
	public String getJzjg() {
		return jzjg;
	}

	/**
	 * @param jzjg the jzjg to set
	 */
	public void setJzjg(String jzjg) {
		this.jzjg = jzjg;
	}

	/**
	 * @return the xjbz
	 */
	public String getXjbz() {
		return xjbz;
	}

	/**
	 * @param xjbz the xjbz to set
	 */
	public void setXjbz(String xjbz) {
		this.xjbz = xjbz;
	}

	/**
	 * @return the fwcx
	 */
	public String getFwcx() {
		return fwcx;
	}

	/**
	 * @param fwcx the fwcx to set
	 */
	public void setFwcx(String fwcx) {
		this.fwcx = fwcx;
	}

	/**
	 * @return the fwyt
	 */
	public String getFwyt() {
		return fwyt;
	}

	/**
	 * @param fwyt the fwyt to set
	 */
	public void setFwyt(String fwyt) {
		this.fwyt = fwyt;
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
	 * @param fwzldz the fwzldz to set
	 */
	public void setFwzldz(String fwzldz) {
		this.fwzldz = fwzldz;
	}

	/**
	 * @return the fwzldz
	 */
	public String getFwzldz() {
		return fwzldz;
	}

	/**
	 * @param ddnm the ddnm to set
	 */
	public void setDdnm(String ddnm) {
		this.ddnm = ddnm;
	}

	/**
	 * @return the ddnm
	 */
	public String getDdnm() {
		return ddnm;
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

	/**
	 * @param cd00001Mssz the cd00001Mssz to set
	 */
	public void setCd00001Mssz(String cd00001Mssz) {
		this.cd00001Mssz = cd00001Mssz;
	}

	/**
	 * @return the cd00001Mssz
	 */
	public String getCd00001Mssz() {
		return cd00001Mssz;
	}

	/**
	 * @param mssz the mssz to set
	 */
	public void setMssz(String mssz) {
		this.mssz = mssz;
	}

	/**
	 * @return the mssz
	 */
	public String getMssz() {
		return mssz;
	}

//	/**
//	 * @param sfms the sfms to set
//	 */
//	public void setSfms(Integer sfms) {
//		this.sfms = sfms;
//	}

//	/**
//	 * @return the sfms
//	 */
//	public Integer getSfms() {
//		return sfms;
//	}

}