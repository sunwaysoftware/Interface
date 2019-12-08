package com.sunway.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Pgv12003Id entity. @author MyEclipse Persistence Tools
 */


public class Pgv12003 implements java.io.Serializable {

	private static final long serialVersionUID = 2064511301875859211L;
	private String fcid;
	private String cd12002Dcid;
	private String cd12001Swid;
	private String fdcmc;
	private String fwzldz;
	private String cd00001Qdfs;
	private String jcnf;
	private Short fwzcs;
	private Short ds;
	private Short dx;
	private Double zjzmj;
	private Double fcyz;
	private Double fwzjje;
	private String fczh;
	private Double ysfcyz;
	private Double msfcyz;
	private Date qdsj;
	private Date lrdate;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String cd00001Ssgx;
	private String nsrmc;
	private String czr;
	private String qdfs;
    private Integer recordCount;
    private Integer recordIndex;    
    private Integer pageIndex;
    private Integer pageSize; 
    private ArrayList<Pgv12003> v12003List;
    private Double sumZjzmj;
    private Double sumFcyz;
    private Double sumFwzjje;
    private Double sumYsfcyz;
    private Double sumMsfcyz;
	private String sysPssd;
	private String sysSsgx;
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
	public Pgv12003() {
		v12003List = new ArrayList<Pgv12003>();
	}

	/** minimal constructor */
	public Pgv12003(String fcid, String cd12002Dcid, String cd12001Swid,
			String fdcmc, String fwzldz, String cd00001Qdfs,
			String jcnf, Short fwzcs, Short ds, Short dx,
			Double zjzmj, Double fcyz, Double fwzjje, Double ysfcyz,
			Double msfcyz, Date lrdate, Date upddate, String cd00002Czr,
			String cd00001Ssgx, String nsrmc) {
		this.fcid = fcid;
		this.cd12002Dcid = cd12002Dcid;
		this.cd12001Swid = cd12001Swid;
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
		this.cd00001Ssgx = cd00001Ssgx;
		this.nsrmc = nsrmc;
	}

	/** full constructor */
	public Pgv12003(String fcid, String cd12002Dcid, String cd12001Swid,
			String fdcmc, String fwzldz, String cd00001Qdfs,
			String jcnf, Short fwzcs, Short ds, Short dx,
			Double zjzmj, Double fcyz, Double fwzjje, String fczh,
			Double ysfcyz, Double msfcyz, Date qdsj, Date lrdate, Date upddate,
			String cd00002Czr, String note, String cd00001Ssgx, String nsrmc,
			String czr, String qdfs) {
		this.fcid = fcid;
		this.cd12002Dcid = cd12002Dcid;
		this.cd12001Swid = cd12001Swid;
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
		this.cd00001Ssgx = cd00001Ssgx;
		this.nsrmc = nsrmc;
		this.czr = czr;
		this.qdfs = qdfs;
	}

	// Property accessors

	public String getFcid() {
		return this.fcid;
	}

	public void setFcid(String fcid) {
		this.fcid = fcid;
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

	public Double getFcyz() {
		return this.fcyz;
	}

	public void setFcyz(Double fcyz) {
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

	public Double getYsfcyz() {
		return this.ysfcyz;
	}

	public void setYsfcyz(Double ysfcyz) {
		this.ysfcyz = ysfcyz;
	}

	public Double getMsfcyz() {
		return this.msfcyz;
	}

	public void setMsfcyz(Double msfcyz) {
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

	public String getCd00001Ssgx() {
		return this.cd00001Ssgx;
	}

	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}

	public String getNsrmc() {
		return this.nsrmc;
	}

	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}

	public String getCzr() {
		return this.czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public String getQdfs() {
		return this.qdfs;
	}

	public void setQdfs(String qdfs) {
		this.qdfs = qdfs;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFcid() == null ? 0 : this.getFcid().hashCode());
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
				+ (getFwzldz() == null ? 0 : this.getFwzldz().hashCode());
		result = 37
				* result
				+ (getCd00001Qdfs() == null ? 0 : this.getCd00001Qdfs()
						.hashCode());
		result = 37 * result
				+ (getJcnf() == null ? 0 : this.getJcnf().hashCode());
		result = 37 * result
				+ (getFwzcs() == null ? 0 : this.getFwzcs().hashCode());
		result = 37 * result + (getDs() == null ? 0 : this.getDs().hashCode());
		result = 37 * result + (getDx() == null ? 0 : this.getDx().hashCode());
		result = 37 * result
				+ (getZjzmj() == null ? 0 : this.getZjzmj().hashCode());
		result = 37 * result
				+ (getFcyz() == null ? 0 : this.getFcyz().hashCode());
		result = 37 * result
				+ (getFwzjje() == null ? 0 : this.getFwzjje().hashCode());
		result = 37 * result
				+ (getFczh() == null ? 0 : this.getFczh().hashCode());
		result = 37 * result
				+ (getYsfcyz() == null ? 0 : this.getYsfcyz().hashCode());
		result = 37 * result
				+ (getMsfcyz() == null ? 0 : this.getMsfcyz().hashCode());
		result = 37 * result
				+ (getQdsj() == null ? 0 : this.getQdsj().hashCode());
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
		result = 37
				* result
				+ (getCd00001Ssgx() == null ? 0 : this.getCd00001Ssgx()
						.hashCode());
		result = 37 * result
				+ (getNsrmc() == null ? 0 : this.getNsrmc().hashCode());
		result = 37 * result
				+ (getCzr() == null ? 0 : this.getCzr().hashCode());
		result = 37 * result
				+ (getQdfs() == null ? 0 : this.getQdfs().hashCode());
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
	 * @param v12003List the v12003List to set
	 */
	public void setV12003List(ArrayList<Pgv12003> v12003List) {
		this.v12003List = v12003List;
	}

	/**
	 * @return the v12003List
	 */
	public ArrayList<Pgv12003> getV12003List() {
		return v12003List;
	}

	/**
	 * @return the sumZjzmj
	 */
	public Double getSumZjzmj() {
		return sumZjzmj;
	}

	/**
	 * @param sumZjzmj the sumZjzmj to set
	 */
	public void setSumZjzmj(Double sumZjzmj) {
		this.sumZjzmj = sumZjzmj;
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
	 * @return the sumFwzjje
	 */
	public Double getSumFwzjje() {
		return sumFwzjje;
	}

	/**
	 * @param sumFwzjje the sumFwzjje to set
	 */
	public void setSumFwzjje(Double sumFwzjje) {
		this.sumFwzjje = sumFwzjje;
	}

	/**
	 * @return the sumYsfcyz
	 */
	public Double getSumYsfcyz() {
		return sumYsfcyz;
	}

	/**
	 * @param sumYsfcyz the sumYsfcyz to set
	 */
	public void setSumYsfcyz(Double sumYsfcyz) {
		this.sumYsfcyz = sumYsfcyz;
	}

	/**
	 * @return the sumMsfcyz
	 */
	public Double getSumMsfcyz() {
		return sumMsfcyz;
	}

	/**
	 * @param sumMsfcyz the sumMsfcyz to set
	 */
	public void setSumMsfcyz(Double sumMsfcyz) {
		this.sumMsfcyz = sumMsfcyz;
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