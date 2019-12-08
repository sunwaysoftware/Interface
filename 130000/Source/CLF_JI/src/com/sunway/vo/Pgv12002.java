package com.sunway.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Pgv12002Id entity. @author MyEclipse Persistence Tools
 */


public class Pgv12002 implements java.io.Serializable {

	private static final long serialVersionUID = -566280273259322800L;
	private String dcid;
	private String cd12001Swid;
	private String tdsyqbm;
	private String cd00001Tdyt;
	private String cd00001Syqlx;
	private Double syqmj;
	private String cd00001Tdsyqlx;
	private String cd00001Tddj;
	private String cd00001Szqy;
	private String tdzl;
	private Double gbrjl;
	private Double ysmj;
	private Double msmj;
	private Double tdpfmse;
	private Double x;
	private Double y;
	private Date lrdate;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private Date sykssj;
	private Date syjssj;
	private String cd00001Ssgx;
	private String nsrmc;
	private String tdsyqlx;
	private String tdyt;
	private String syqlx;
	private String tddj;
	private String szqy;
	private String czr;
    private Integer recordCount;
    private Integer recordIndex;    
    private Integer pageIndex;
    private Integer pageSize; 
    private Double sumSyqmj;
    private Double sumYsmj;
    private Double sumMsmj;  
    private Double avgGbrjl;
    private Double avgTdpfmse;
    private ArrayList<Pgv12002> v12002List;
	private String sysPssd;
	private String sysSsgx;
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
	public Pgv12002() {
		this.v12002List = new ArrayList<Pgv12002>();
	}
	
	/** minimal constructor */
	public Pgv12002(String dcid, String cd12001Swid, String cd00001Tdyt,
			String cd00001Syqlx, Double syqmj, String cd00001Tdsyqlx,
			String cd00001Tddj, String cd00001Szqy, Double gbrjl, Double ysmj,
			Double msmj, Double tdpfmse, Double x, Double y, Date lrdate,
			Date upddate, String cd00002Czr, String cd00001Ssgx, String nsrmc) {
		this.dcid = dcid;
		this.cd12001Swid = cd12001Swid;
		this.cd00001Tdyt = cd00001Tdyt;
		this.cd00001Syqlx = cd00001Syqlx;
		this.syqmj = syqmj;
		this.cd00001Tdsyqlx = cd00001Tdsyqlx;
		this.cd00001Tddj = cd00001Tddj;
		this.cd00001Szqy = cd00001Szqy;
		this.gbrjl = gbrjl;
		this.ysmj = ysmj;
		this.msmj = msmj;
		this.tdpfmse = tdpfmse;
		this.x = x;
		this.y = y;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.cd00001Ssgx = cd00001Ssgx;
		this.nsrmc = nsrmc;
	}

	/** full constructor */
	public Pgv12002(String dcid, String cd12001Swid, String tdsyqbm,
			String cd00001Tdyt, String cd00001Syqlx, Double syqmj,
			String cd00001Tdsyqlx, String cd00001Tddj, String cd00001Szqy,
			String tdzl, Double gbrjl, Double ysmj, Double msmj,
			Double tdpfmse, Double x, Double y, Date lrdate, Date upddate,
			String cd00002Czr, String note, Date sykssj, Date syjssj,
			String cd00001Ssgx, String nsrmc, String tdsyqlx, String tdyt,
			String syqlx, String tddj, String szqy, String czr) {
		this.dcid = dcid;
		this.cd12001Swid = cd12001Swid;
		this.tdsyqbm = tdsyqbm;
		this.cd00001Tdyt = cd00001Tdyt;
		this.cd00001Syqlx = cd00001Syqlx;
		this.syqmj = syqmj;
		this.cd00001Tdsyqlx = cd00001Tdsyqlx;
		this.cd00001Tddj = cd00001Tddj;
		this.cd00001Szqy = cd00001Szqy;
		this.tdzl = tdzl;
		this.gbrjl = gbrjl;
		this.ysmj = ysmj;
		this.msmj = msmj;
		this.tdpfmse = tdpfmse;
		this.x = x;
		this.y = y;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.sykssj = sykssj;
		this.syjssj = syjssj;
		this.cd00001Ssgx = cd00001Ssgx;
		this.nsrmc = nsrmc;
		this.tdsyqlx = tdsyqlx;
		this.tdyt = tdyt;
		this.syqlx = syqlx;
		this.tddj = tddj;
		this.szqy = szqy;
		this.czr = czr;
	}

	// Property accessors

	public String getDcid() {
		return this.dcid;
	}

	public void setDcid(String dcid) {
		this.dcid = dcid;
	}

	public String getCd12001Swid() {
		return this.cd12001Swid;
	}

	public void setCd12001Swid(String cd12001Swid) {
		this.cd12001Swid = cd12001Swid;
	}

	public String getTdsyqbm() {
		return this.tdsyqbm;
	}

	public void setTdsyqbm(String tdsyqbm) {
		this.tdsyqbm = tdsyqbm;
	}

	public String getCd00001Tdyt() {
		return this.cd00001Tdyt;
	}

	public void setCd00001Tdyt(String cd00001Tdyt) {
		this.cd00001Tdyt = cd00001Tdyt;
	}

	public String getCd00001Syqlx() {
		return this.cd00001Syqlx;
	}

	public void setCd00001Syqlx(String cd00001Syqlx) {
		this.cd00001Syqlx = cd00001Syqlx;
	}

	public Double getSyqmj() {
		return this.syqmj;
	}

	public void setSyqmj(Double syqmj) {
		this.syqmj = syqmj;
	}

	public String getCd00001Tdsyqlx() {
		return this.cd00001Tdsyqlx;
	}

	public void setCd00001Tdsyqlx(String cd00001Tdsyqlx) {
		this.cd00001Tdsyqlx = cd00001Tdsyqlx;
	}

	public String getCd00001Tddj() {
		return this.cd00001Tddj;
	}

	public void setCd00001Tddj(String cd00001Tddj) {
		this.cd00001Tddj = cd00001Tddj;
	}

	public String getCd00001Szqy() {
		return this.cd00001Szqy;
	}

	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}

	public String getTdzl() {
		return this.tdzl;
	}

	public void setTdzl(String tdzl) {
		this.tdzl = tdzl;
	}

	public Double getGbrjl() {
		return this.gbrjl;
	}

	public void setGbrjl(Double gbrjl) {
		this.gbrjl = gbrjl;
	}

	public Double getYsmj() {
		return this.ysmj;
	}

	public void setYsmj(Double ysmj) {
		this.ysmj = ysmj;
	}

	public Double getMsmj() {
		return this.msmj;
	}

	public void setMsmj(Double msmj) {
		this.msmj = msmj;
	}

	public Double getTdpfmse() {
		return this.tdpfmse;
	}

	public void setTdpfmse(Double tdpfmse) {
		this.tdpfmse = tdpfmse;
	}

	public Double getX() {
		return this.x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return this.y;
	}

	public void setY(Double y) {
		this.y = y;
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

	public Date getSykssj() {
		return this.sykssj;
	}

	public void setSykssj(Date sykssj) {
		this.sykssj = sykssj;
	}

	public Date getSyjssj() {
		return this.syjssj;
	}

	public void setSyjssj(Date syjssj) {
		this.syjssj = syjssj;
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

	public String getTdsyqlx() {
		return this.tdsyqlx;
	}

	public void setTdsyqlx(String tdsyqlx) {
		this.tdsyqlx = tdsyqlx;
	}

	public String getTdyt() {
		return this.tdyt;
	}

	public void setTdyt(String tdyt) {
		this.tdyt = tdyt;
	}

	public String getSyqlx() {
		return this.syqlx;
	}

	public void setSyqlx(String syqlx) {
		this.syqlx = syqlx;
	}

	public String getTddj() {
		return this.tddj;
	}

	public void setTddj(String tddj) {
		this.tddj = tddj;
	}

	public String getSzqy() {
		return this.szqy;
	}

	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}

	public String getCzr() {
		return this.czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDcid() == null ? 0 : this.getDcid().hashCode());
		result = 37
				* result
				+ (getCd12001Swid() == null ? 0 : this.getCd12001Swid()
						.hashCode());
		result = 37 * result
				+ (getTdsyqbm() == null ? 0 : this.getTdsyqbm().hashCode());
		result = 37
				* result
				+ (getCd00001Tdyt() == null ? 0 : this.getCd00001Tdyt()
						.hashCode());
		result = 37
				* result
				+ (getCd00001Syqlx() == null ? 0 : this.getCd00001Syqlx()
						.hashCode());
		result = 37 * result
				+ (getSyqmj() == null ? 0 : this.getSyqmj().hashCode());
		result = 37
				* result
				+ (getCd00001Tdsyqlx() == null ? 0 : this.getCd00001Tdsyqlx()
						.hashCode());
		result = 37
				* result
				+ (getCd00001Tddj() == null ? 0 : this.getCd00001Tddj()
						.hashCode());
		result = 37
				* result
				+ (getCd00001Szqy() == null ? 0 : this.getCd00001Szqy()
						.hashCode());
		result = 37 * result
				+ (getTdzl() == null ? 0 : this.getTdzl().hashCode());
		result = 37 * result
				+ (getGbrjl() == null ? 0 : this.getGbrjl().hashCode());
		result = 37 * result
				+ (getYsmj() == null ? 0 : this.getYsmj().hashCode());
		result = 37 * result
				+ (getMsmj() == null ? 0 : this.getMsmj().hashCode());
		result = 37 * result
				+ (getTdpfmse() == null ? 0 : this.getTdpfmse().hashCode());
		result = 37 * result + (getX() == null ? 0 : this.getX().hashCode());
		result = 37 * result + (getY() == null ? 0 : this.getY().hashCode());
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
				+ (getSykssj() == null ? 0 : this.getSykssj().hashCode());
		result = 37 * result
				+ (getSyjssj() == null ? 0 : this.getSyjssj().hashCode());
		result = 37
				* result
				+ (getCd00001Ssgx() == null ? 0 : this.getCd00001Ssgx()
						.hashCode());
		result = 37 * result
				+ (getNsrmc() == null ? 0 : this.getNsrmc().hashCode());
		result = 37 * result
				+ (getTdsyqlx() == null ? 0 : this.getTdsyqlx().hashCode());
		result = 37 * result
				+ (getTdyt() == null ? 0 : this.getTdyt().hashCode());
		result = 37 * result
				+ (getSyqlx() == null ? 0 : this.getSyqlx().hashCode());
		result = 37 * result
				+ (getTddj() == null ? 0 : this.getTddj().hashCode());
		result = 37 * result
				+ (getSzqy() == null ? 0 : this.getSzqy().hashCode());
		result = 37 * result
				+ (getCzr() == null ? 0 : this.getCzr().hashCode());
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
	 * @return the sumSyqmj
	 */
	public Double getSumSyqmj() {
		return sumSyqmj;
	}

	/**
	 * @param sumSyqmj the sumSyqmj to set
	 */
	public void setSumSyqmj(Double sumSyqmj) {
		this.sumSyqmj = sumSyqmj;
	}

	/**
	 * @return the sumYsmj
	 */
	public Double getSumYsmj() {
		return sumYsmj;
	}

	/**
	 * @param sumYsmj the sumYsmj to set
	 */
	public void setSumYsmj(Double sumYsmj) {
		this.sumYsmj = sumYsmj;
	}

	/**
	 * @return the sumMsmj
	 */
	public Double getSumMsmj() {
		return sumMsmj;
	}

	/**
	 * @param sumMsmj the sumMsmj to set
	 */
	public void setSumMsmj(Double sumMsmj) {
		this.sumMsmj = sumMsmj;
	}

	/**
	 * @return the avgGbrjl
	 */
	public Double getAvgGbrjl() {
		return avgGbrjl;
	}

	/**
	 * @param avgGbrjl the avgGbrjl to set
	 */
	public void setAvgGbrjl(Double avgGbrjl) {
		this.avgGbrjl = avgGbrjl;
	}

	/**
	 * @return the avgTdpfmse
	 */
	public Double getAvgTdpfmse() {
		return avgTdpfmse;
	}

	/**
	 * @param avgTdpfmse the avgTdpfmse to set
	 */
	public void setAvgTdpfmse(Double avgTdpfmse) {
		this.avgTdpfmse = avgTdpfmse;
	}

	/**
	 * @return the v12002List
	 */
	public ArrayList<Pgv12002> getV12002List() {
		return v12002List;
	}

	/**
	 * @param v12002List the v12002List to set
	 */
	public void setV12002List(ArrayList<Pgv12002> v12002List) {
		this.v12002List = v12002List;
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