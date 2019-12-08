package com.sunway.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Pgv12004Id entity. @author MyEclipse Persistence Tools
 */


public class Pgv12004 implements java.io.Serializable {

	private static final long serialVersionUID = -7106731168404707659L;
	private String mxid;
	private String cd12003Fcid;
	private String cd12002Dcid;
	private String cd12001Swid;
	private String fdcmc;
	private String szcc;
	private String bwjfh;
	private String cd00001Jzjg;
	private String cd00001Fwyt;
	private Double ytjzmj;
	private Double fcyz;
	private String cd00001Xjbz;
	private String cd00001Fwcx;
	private String cd00001Mssz;
	private Date lrdate;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String nsrmc;
	private String cd00001Ssgx;
	private String czr;
	private String jzjg;
	private String xjbz;
	private String fwcx;
	private String mssz;
	private String fwyt;
	private String cd12053Ddid;
	private String ddnm;
	private Double gytzj;
    private Integer recordCount;
    private Integer recordIndex;    
    private Integer pageIndex;
    private Integer pageSize; 
    private Double sumYtjzmj;
    private Double sumFcyz;
    private Double sumGytzj;
    private ArrayList<Pgv12004> v12004List;
	private String sysPssd;
	private String sysSsgx;
	private Integer shFlag;
	private String pgCzr;
	private String fwzldz;
    private String cd00001Szqy;
    private Integer zpCount;
	private Double fcpgjg;
	private Double dcpgjg;
	private Double cbpgjg;
	private Double gbfcpgjg;
	private Double gbdcpgjg;
	private Double cbgbpgjg;
	private Double sypgjg;
	private Double sygbpgjg;
	private Double cbjsze;
	private Double cbynze;
	private Double syjsze;
	private Double syynze;
	private Double sumFcpgjg;
	private Double sumDcpgjg;
	private Double sumCbpgjg;
	private Double sumGbfcpgjg;
	private Double sumGbdcpgjg;
	private Double sumCbgbpgjg;
	private Double sumSypgjg;
	private Double sumSygbpgjg;
	private Double sumCbjsze;
	private Double sumCbynze;
	private Double sumSyjsze;
	private Double sumSyynze;
	private Integer cbzt;
	private Integer syzt;

	// Constructors

	/** default constructor */
	public Pgv12004() {
		v12004List = new ArrayList<Pgv12004>();
	}

	/** minimal constructor */
	public Pgv12004(String mxid, String cd12003Fcid, String cd12002Dcid,
			String cd12001Swid, String fdcmc, String szcc, String cd00001Jzjg,
			String cd00001Fwyt, Double ytjzmj, Double fcyz, String cd00001Mssz,
			Date lrdate, Date upddate, String cd00002Czr, String nsrmc,
			String cd00001Ssgx) {
		this.mxid = mxid;
		this.cd12003Fcid = cd12003Fcid;
		this.cd12002Dcid = cd12002Dcid;
		this.cd12001Swid = cd12001Swid;
		this.fdcmc = fdcmc;
		this.szcc = szcc;
		this.cd00001Jzjg = cd00001Jzjg;
		this.cd00001Fwyt = cd00001Fwyt;
		this.ytjzmj = ytjzmj;
		this.fcyz = fcyz;
		this.cd00001Mssz = cd00001Mssz;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.nsrmc = nsrmc;
		this.cd00001Ssgx = cd00001Ssgx;
	}

	/** full constructor */
	public Pgv12004(String mxid, String cd12003Fcid, String cd12002Dcid,
			String cd12001Swid, String fdcmc, String szcc, String bwjfh,
			String cd00001Jzjg, String cd00001Fwyt, Double ytjzmj, Double fcyz,
			String cd00001Xjbz, String cd00001Fwcx, String cd00001Mssz,
			Date lrdate, Date upddate, String cd00002Czr, String note,
			String nsrmc, String cd00001Ssgx, String czr, String jzjg,
			String xjbz, String fwcx, String mssz, String fwyt) {
		this.mxid = mxid;
		this.cd12003Fcid = cd12003Fcid;
		this.cd12002Dcid = cd12002Dcid;
		this.cd12001Swid = cd12001Swid;
		this.fdcmc = fdcmc;
		this.szcc = szcc;
		this.bwjfh = bwjfh;
		this.cd00001Jzjg = cd00001Jzjg;
		this.cd00001Fwyt = cd00001Fwyt;
		this.ytjzmj = ytjzmj;
		this.fcyz = fcyz;
		this.cd00001Xjbz = cd00001Xjbz;
		this.cd00001Fwcx = cd00001Fwcx;
		this.cd00001Mssz = cd00001Mssz;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.nsrmc = nsrmc;
		this.cd00001Ssgx = cd00001Ssgx;
		this.czr = czr;
		this.jzjg = jzjg;
		this.xjbz = xjbz;
		this.fwcx = fwcx;
		this.mssz = mssz;
		this.fwyt = fwyt;
	}

	// Property accessors

	public String getMxid() {
		return this.mxid;
	}

	public void setMxid(String mxid) {
		this.mxid = mxid;
	}

	public String getCd12003Fcid() {
		return this.cd12003Fcid;
	}

	public void setCd12003Fcid(String cd12003Fcid) {
		this.cd12003Fcid = cd12003Fcid;
	}

	public String getCd12002Dcid() {
		return this.cd12002Dcid;
	}

	public void setCd12002Dcid(String cd12002Dcid) {
		this.cd12002Dcid = cd12002Dcid;
	}

	public String getCd12001Swid() {
		return this.cd12001Swid;
	}

	public void setCd12001Swid(String cd12001Swid) {
		this.cd12001Swid = cd12001Swid;
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

	public Double getFcyz() {
		return this.fcyz;
	}

	public void setFcyz(Double fcyz) {
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

	public String getCd00001Mssz() {
		return this.cd00001Mssz;
	}

	public void setCd00001Mssz(String cd00001Mssz) {
		this.cd00001Mssz = cd00001Mssz;
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

	public String getNsrmc() {
		return this.nsrmc;
	}

	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}

	public String getCd00001Ssgx() {
		return this.cd00001Ssgx;
	}

	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}

	public String getCzr() {
		return this.czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public String getJzjg() {
		return this.jzjg;
	}

	public void setJzjg(String jzjg) {
		this.jzjg = jzjg;
	}

	public String getXjbz() {
		return this.xjbz;
	}

	public void setXjbz(String xjbz) {
		this.xjbz = xjbz;
	}

	public String getFwcx() {
		return this.fwcx;
	}

	public void setFwcx(String fwcx) {
		this.fwcx = fwcx;
	}

	public String getMssz() {
		return this.mssz;
	}

	public void setMssz(String mssz) {
		this.mssz = mssz;
	}

	public String getFwyt() {
		return this.fwyt;
	}

	public void setFwyt(String fwyt) {
		this.fwyt = fwyt;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMxid() == null ? 0 : this.getMxid().hashCode());
		result = 37
				* result
				+ (getCd12003Fcid() == null ? 0 : this.getCd12003Fcid()
						.hashCode());
		result = 37
				* result
				+ (getCd12002Dcid() == null ? 0 : this.getCd12002Dcid()
						.hashCode());
		result = 37
				* result
				+ (getCd12001Swid() == null ? 0 : this.getCd12001Swid()
						.hashCode());
		result = 37 * result
				+ (getFdcmc() == null ? 0 : this.getFdcmc().hashCode());
		result = 37 * result
				+ (getSzcc() == null ? 0 : this.getSzcc().hashCode());
		result = 37 * result
				+ (getBwjfh() == null ? 0 : this.getBwjfh().hashCode());
		result = 37
				* result
				+ (getCd00001Jzjg() == null ? 0 : this.getCd00001Jzjg()
						.hashCode());
		result = 37
				* result
				+ (getCd00001Fwyt() == null ? 0 : this.getCd00001Fwyt()
						.hashCode());
		result = 37 * result
				+ (getYtjzmj() == null ? 0 : this.getYtjzmj().hashCode());
		result = 37 * result
				+ (getFcyz() == null ? 0 : this.getFcyz().hashCode());
		result = 37
				* result
				+ (getCd00001Xjbz() == null ? 0 : this.getCd00001Xjbz()
						.hashCode());
		result = 37
				* result
				+ (getCd00001Fwcx() == null ? 0 : this.getCd00001Fwcx()
						.hashCode());
		result = 37
				* result
				+ (getCd00001Mssz() == null ? 0 : this.getCd00001Mssz()
						.hashCode());
		result = 37 * result
				+ (getLrdate() == null ? 0 : this.getLrdate().hashCode());
		result = 37 * result
				+ (getUpddate() == null ? 0 : this.getUpddate().hashCode());
		result = 37
				* result
				+ (getCd00002Czr() == null ? 0 : this.getCd00002Czr()
						.hashCode());
		result = 37 * result
				+ (getNote() == null ? 0 : this.getNote().hashCode());
		result = 37 * result
				+ (getNsrmc() == null ? 0 : this.getNsrmc().hashCode());
		result = 37
				* result
				+ (getCd00001Ssgx() == null ? 0 : this.getCd00001Ssgx()
						.hashCode());
		result = 37 * result
				+ (getCzr() == null ? 0 : this.getCzr().hashCode());
		result = 37 * result
				+ (getJzjg() == null ? 0 : this.getJzjg().hashCode());
		result = 37 * result
				+ (getXjbz() == null ? 0 : this.getXjbz().hashCode());
		result = 37 * result
				+ (getFwcx() == null ? 0 : this.getFwcx().hashCode());
		result = 37 * result
				+ (getMssz() == null ? 0 : this.getMssz().hashCode());
		result = 37 * result
				+ (getFwyt() == null ? 0 : this.getFwyt().hashCode());
		return result;
	}

	/**
	 * @return the recordCount
	 */
	public Integer getRecordCount() {
		return recordCount;
	}

	/**
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * @return the recordIndex
	 */
	public Integer getRecordIndex() {
		return recordIndex;
	}

	/**
	 * @param recordIndex the recordIndex to set
	 */
	public void setRecordIndex(Integer recordIndex) {
		this.recordIndex = recordIndex;
	}

	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the sumYtjzmj
	 */
	public Double getSumYtjzmj() {
		return sumYtjzmj;
	}

	/**
	 * @param sumYtjzmj the sumYtjzmj to set
	 */
	public void setSumYtjzmj(Double sumYtjzmj) {
		this.sumYtjzmj = sumYtjzmj;
	}

	/**
	 * @return the sumFcyz
	 */
	public Double getSumFcyz() {
		return sumFcyz;
	}

	/**
	 * @param sumFcyz the sumFcyz to set
	 */
	public void setSumFcyz(Double sumFcyz) {
		this.sumFcyz = sumFcyz;
	}

	/**
	 * @return the sumGytzj
	 */
	public Double getSumGytzj() {
		return sumGytzj;
	}

	/**
	 * @param sumGytzj the sumGytzj to set
	 */
	public void setSumGytzj(Double sumGytzj) {
		this.sumGytzj = sumGytzj;
	}

	/**
	 * @return the v12004List
	 */
	public ArrayList<Pgv12004> getV12004List() {
		return v12004List;
	}

	/**
	 * @param v12004List the v12004List to set
	 */
	public void setV12004List(ArrayList<Pgv12004> v12004List) {
		this.v12004List = v12004List;
	}

	/**
	 * @return the sysPssd
	 */
	public String getSysPssd() {
		return sysPssd;
	}

	/**
	 * @param sysPssd the sysPssd to set
	 */
	public void setSysPssd(String sysPssd) {
		this.sysPssd = sysPssd;
	}

	/**
	 * @return the sysSsgx
	 */
	public String getSysSsgx() {
		return sysSsgx;
	}

	/**
	 * @param sysSsgx the sysSsgx to set
	 */
	public void setSysSsgx(String sysSsgx) {
		this.sysSsgx = sysSsgx;
	}

	/**
	 * @return the cd12053Ddid
	 */
	public String getCd12053Ddid() {
		return cd12053Ddid;
	}

	/**
	 * @param cd12053Ddid the cd12053Ddid to set
	 */
	public void setCd12053Ddid(String cd12053Ddid) {
		this.cd12053Ddid = cd12053Ddid;
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
	 * @return the gytzj
	 */
	public Double getGytzj() {
		return gytzj;
	}

	/**
	 * @param gytzj the gytzj to set
	 */
	public void setGytzj(Double gytzj) {
		this.gytzj = gytzj;
	}

	/**
	 * @param shFlag the shFlag to set
	 */
	public void setShFlag(Integer shFlag) {
		this.shFlag = shFlag;
	}

	/**
	 * @return the shFlag
	 */
	public Integer getShFlag() {
		return shFlag;
	}

	/**
	 * @param pgCzr the pgCzr to set
	 */
	public void setPgCzr(String pgCzr) {
		this.pgCzr = pgCzr;
	}

	/**
	 * @return the pgCzr
	 */
	public String getPgCzr() {
		return pgCzr;
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
	 * @param zpCount the zpCount to set
	 */
	public void setZpCount(Integer zpCount) {
		this.zpCount = zpCount;
	}

	/**
	 * @return the zpCount
	 */
	public Integer getZpCount() {
		return zpCount;
	}

	/**
	 * @return the fcpgjg
	 */
	public Double getFcpgjg() {
		return fcpgjg;
	}

	/**
	 * @param fcpgjg the fcpgjg to set
	 */
	public void setFcpgjg(Double fcpgjg) {
		this.fcpgjg = fcpgjg;
	}

	/**
	 * @return the dcpgjg
	 */
	public Double getDcpgjg() {
		return dcpgjg;
	}

	/**
	 * @param dcpgjg the dcpgjg to set
	 */
	public void setDcpgjg(Double dcpgjg) {
		this.dcpgjg = dcpgjg;
	}

	/**
	 * @return the cbpgjg
	 */
	public Double getCbpgjg() {
		return cbpgjg;
	}

	/**
	 * @param cbpgjg the cbpgjg to set
	 */
	public void setCbpgjg(Double cbpgjg) {
		this.cbpgjg = cbpgjg;
	}

	/**
	 * @return the gbfcpgjg
	 */
	public Double getGbfcpgjg() {
		return gbfcpgjg;
	}

	/**
	 * @param gbfcpgjg the gbfcpgjg to set
	 */
	public void setGbfcpgjg(Double gbfcpgjg) {
		this.gbfcpgjg = gbfcpgjg;
	}

	/**
	 * @return the gbdcpgjg
	 */
	public Double getGbdcpgjg() {
		return gbdcpgjg;
	}

	/**
	 * @param gbdcpgjg the gbdcpgjg to set
	 */
	public void setGbdcpgjg(Double gbdcpgjg) {
		this.gbdcpgjg = gbdcpgjg;
	}

	/**
	 * @return the cbgbpgjg
	 */
	public Double getCbgbpgjg() {
		return cbgbpgjg;
	}

	/**
	 * @param cbgbpgjg the cbgbpgjg to set
	 */
	public void setCbgbpgjg(Double cbgbpgjg) {
		this.cbgbpgjg = cbgbpgjg;
	}

	/**
	 * @return the sypgjg
	 */
	public Double getSypgjg() {
		return sypgjg;
	}

	/**
	 * @param sypgjg the sypgjg to set
	 */
	public void setSypgjg(Double sypgjg) {
		this.sypgjg = sypgjg;
	}

	/**
	 * @return the sygbpgjg
	 */
	public Double getSygbpgjg() {
		return sygbpgjg;
	}

	/**
	 * @param sygbpgjg the sygbpgjg to set
	 */
	public void setSygbpgjg(Double sygbpgjg) {
		this.sygbpgjg = sygbpgjg;
	}

	/**
	 * @return the cbjsze
	 */
	public Double getCbjsze() {
		return cbjsze;
	}

	/**
	 * @param cbjsze the cbjsze to set
	 */
	public void setCbjsze(Double cbjsze) {
		this.cbjsze = cbjsze;
	}

	/**
	 * @return the cbynze
	 */
	public Double getCbynze() {
		return cbynze;
	}

	/**
	 * @param cbynze the cbynze to set
	 */
	public void setCbynze(Double cbynze) {
		this.cbynze = cbynze;
	}

	/**
	 * @return the syjsze
	 */
	public Double getSyjsze() {
		return syjsze;
	}

	/**
	 * @param syjsze the syjsze to set
	 */
	public void setSyjsze(Double syjsze) {
		this.syjsze = syjsze;
	}

	/**
	 * @return the syynze
	 */
	public Double getSyynze() {
		return syynze;
	}

	/**
	 * @param syynze the syynze to set
	 */
	public void setSyynze(Double syynze) {
		this.syynze = syynze;
	}

	/**
	 * @return the sumFcpgjg
	 */
	public Double getSumFcpgjg() {
		return sumFcpgjg;
	}

	/**
	 * @param sumFcpgjg the sumFcpgjg to set
	 */
	public void setSumFcpgjg(Double sumFcpgjg) {
		this.sumFcpgjg = sumFcpgjg;
	}

	/**
	 * @return the sumDcpgjg
	 */
	public Double getSumDcpgjg() {
		return sumDcpgjg;
	}

	/**
	 * @param sumDcpgjg the sumDcpgjg to set
	 */
	public void setSumDcpgjg(Double sumDcpgjg) {
		this.sumDcpgjg = sumDcpgjg;
	}

	/**
	 * @return the sumCbpgjg
	 */
	public Double getSumCbpgjg() {
		return sumCbpgjg;
	}

	/**
	 * @param sumCbpgjg the sumCbpgjg to set
	 */
	public void setSumCbpgjg(Double sumCbpgjg) {
		this.sumCbpgjg = sumCbpgjg;
	}

	/**
	 * @return the sumGbfcpgjg
	 */
	public Double getSumGbfcpgjg() {
		return sumGbfcpgjg;
	}

	/**
	 * @param sumGbfcpgjg the sumGbfcpgjg to set
	 */
	public void setSumGbfcpgjg(Double sumGbfcpgjg) {
		this.sumGbfcpgjg = sumGbfcpgjg;
	}

	/**
	 * @return the sumGbdcpgjg
	 */
	public Double getSumGbdcpgjg() {
		return sumGbdcpgjg;
	}

	/**
	 * @param sumGbdcpgjg the sumGbdcpgjg to set
	 */
	public void setSumGbdcpgjg(Double sumGbdcpgjg) {
		this.sumGbdcpgjg = sumGbdcpgjg;
	}

	/**
	 * @return the sumCbgbpgjg
	 */
	public Double getSumCbgbpgjg() {
		return sumCbgbpgjg;
	}

	/**
	 * @param sumCbgbpgjg the sumCbgbpgjg to set
	 */
	public void setSumCbgbpgjg(Double sumCbgbpgjg) {
		this.sumCbgbpgjg = sumCbgbpgjg;
	}

	/**
	 * @return the sumSypgjg
	 */
	public Double getSumSypgjg() {
		return sumSypgjg;
	}

	/**
	 * @param sumSypgjg the sumSypgjg to set
	 */
	public void setSumSypgjg(Double sumSypgjg) {
		this.sumSypgjg = sumSypgjg;
	}

	/**
	 * @return the sumSygbpgjg
	 */
	public Double getSumSygbpgjg() {
		return sumSygbpgjg;
	}

	/**
	 * @param sumSygbpgjg the sumSygbpgjg to set
	 */
	public void setSumSygbpgjg(Double sumSygbpgjg) {
		this.sumSygbpgjg = sumSygbpgjg;
	}

	/**
	 * @return the sumCbjsze
	 */
	public Double getSumCbjsze() {
		return sumCbjsze;
	}

	/**
	 * @param sumCbjsze the sumCbjsze to set
	 */
	public void setSumCbjsze(Double sumCbjsze) {
		this.sumCbjsze = sumCbjsze;
	}

	/**
	 * @return the sumCbynze
	 */
	public Double getSumCbynze() {
		return sumCbynze;
	}

	/**
	 * @param sumCbynze the sumCbynze to set
	 */
	public void setSumCbynze(Double sumCbynze) {
		this.sumCbynze = sumCbynze;
	}

	/**
	 * @return the sumSyjsze
	 */
	public Double getSumSyjsze() {
		return sumSyjsze;
	}

	/**
	 * @param sumSyjsze the sumSyjsze to set
	 */
	public void setSumSyjsze(Double sumSyjsze) {
		this.sumSyjsze = sumSyjsze;
	}

	/**
	 * @return the sumSyynze
	 */
	public Double getSumSyynze() {
		return sumSyynze;
	}

	/**
	 * @param sumSyynze the sumSyynze to set
	 */
	public void setSumSyynze(Double sumSyynze) {
		this.sumSyynze = sumSyynze;
	}

	/**
	 * @return the cbzt
	 */
	public Integer getCbzt() {
		return cbzt;
	}

	/**
	 * @param cbzt the cbzt to set
	 */
	public void setCbzt(Integer cbzt) {
		this.cbzt = cbzt;
	}

	/**
	 * @return the syzt
	 */
	public Integer getSyzt() {
		return syzt;
	}

	/**
	 * @param syzt the syzt to set
	 */
	public void setSyzt(Integer syzt) {
		this.syzt = syzt;
	}
}