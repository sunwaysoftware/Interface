package com.sunway.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Pgv12001 entity. @author MyEclipse Persistence Tools
 */


public class Pgv12001 implements java.io.Serializable {

	private static final long serialVersionUID = -4978315532365171241L;
	private String swid;
	private String nsrmc;
	private String cd00001Ssgx;
	private String lxdh;
	private String zgy;
	private String cd00001Hy;
	private String cd00001Jjlx;
	private Double zyywsr;
	private Double lrze;
	private Double fcse;
	private Double tdse;
	private String cd00001Mssz;
	private String bh;
	private String cd00001Xz;
	private Date lrdate;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String ssgx;
	private String hy;
	private String jjlx;
	private String mssz;
	private String xz;
	private String czr;
    private Integer recordCount;
    private Integer recordIndex;    
    private Integer pageIndex;
    private Integer pageSize; 
	private String sysPssd;
	private String sysSsgx;
	private Double sumZyywsr;
	private Double sumLrze;
	private Double sumFcse;
	private Double sumTdse;
	private ArrayList<Pgv12001> v12001List;
    private String shCzr;
    private String pgCzr;
    private String ssCzr;
	private Boolean isInfo;
	private Double pgjgFc;
	private Double pgjgDc;
	private Double pgjg;
	private Double pgjgFcGb;
	private Double pgjgDcGb;
	private Double pgjgGb;
	private Date sysPssdYMD;
	private String cd12002Dcid;
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
	public Pgv12001() {
		this.v12001List = new ArrayList<Pgv12001>();
	}

	/**
	 * @param swid
	 */
	public Pgv12001(String swid) {
		this.swid = swid;
	}
	
	/** minimal constructor */
	public Pgv12001(String swid, String nsrmc, String cd00001Ssgx,
			String cd00001Hy, String cd00001Jjlx, Double zyywsr, Double lrze,
			Double fcse, Double tdse, String cd00001Mssz, String bh,
			String cd00001Xz, Date lrdate, Date upddate, String cd00002Czr) {
		this.swid = swid;
		this.nsrmc = nsrmc;
		this.cd00001Ssgx = cd00001Ssgx;
		this.cd00001Hy = cd00001Hy;
		this.cd00001Jjlx = cd00001Jjlx;
		this.zyywsr = zyywsr;
		this.lrze = lrze;
		this.fcse = fcse;
		this.tdse = tdse;
		this.cd00001Mssz = cd00001Mssz;
		this.bh = bh;
		this.cd00001Xz = cd00001Xz;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgv12001(String swid, String nsrmc, String cd00001Ssgx,
			String lxdh, String zgy, String cd00001Hy, String cd00001Jjlx,
			Double zyywsr, Double lrze, Double fcse, Double tdse,
			String cd00001Mssz, String bh, String cd00001Xz,
			Date lrdate, Date upddate, String cd00002Czr,
			String note, String ssgx, String hy, String jjlx, String mssz,
			String xz, String czr) {
		this.swid = swid;
		this.nsrmc = nsrmc;
		this.cd00001Ssgx = cd00001Ssgx;
		this.lxdh = lxdh;
		this.zgy = zgy;
		this.cd00001Hy = cd00001Hy;
		this.cd00001Jjlx = cd00001Jjlx;
		this.zyywsr = zyywsr;
		this.lrze = lrze;
		this.fcse = fcse;
		this.tdse = tdse;
		this.cd00001Mssz = cd00001Mssz;
		this.bh = bh;
		this.cd00001Xz = cd00001Xz;
		this.lrdate = lrdate;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
		this.ssgx = ssgx;
		this.hy = hy;
		this.jjlx = jjlx;
		this.mssz = mssz;
		this.xz = xz;
		this.czr = czr;
	}

	// Property accessors

	public String getSwid() {
		return this.swid;
	}

	public void setSwid(String swid) {
		this.swid = swid;
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

	public String getLxdh() {
		return this.lxdh;
	}

	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}

	public String getZgy() {
		return this.zgy;
	}

	public void setZgy(String zgy) {
		this.zgy = zgy;
	}

	public String getCd00001Hy() {
		return this.cd00001Hy;
	}

	public void setCd00001Hy(String cd00001Hy) {
		this.cd00001Hy = cd00001Hy;
	}

	public String getCd00001Jjlx() {
		return this.cd00001Jjlx;
	}

	public void setCd00001Jjlx(String cd00001Jjlx) {
		this.cd00001Jjlx = cd00001Jjlx;
	}

	public Double getZyywsr() {
		return this.zyywsr;
	}

	public void setZyywsr(Double zyywsr) {
		this.zyywsr = zyywsr;
	}

	public Double getLrze() {
		return this.lrze;
	}

	public void setLrze(Double lrze) {
		this.lrze = lrze;
	}

	public Double getFcse() {
		return this.fcse;
	}

	public void setFcse(Double fcse) {
		this.fcse = fcse;
	}

	public Double getTdse() {
		return this.tdse;
	}

	public void setTdse(Double tdse) {
		this.tdse = tdse;
	}

	public String getCd00001Mssz() {
		return this.cd00001Mssz;
	}

	public void setCd00001Mssz(String cd00001Mssz) {
		this.cd00001Mssz = cd00001Mssz;
	}

	public String getBh() {
		return this.bh;
	}

	public void setBh(String bh) {
		this.bh = bh;
	}

	public String getCd00001Xz() {
		return this.cd00001Xz;
	}

	public void setCd00001Xz(String cd00001Xz) {
		this.cd00001Xz = cd00001Xz;
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

	public String getSsgx() {
		return this.ssgx;
	}

	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}

	public String getHy() {
		return this.hy;
	}

	public void setHy(String hy) {
		this.hy = hy;
	}

	public String getJjlx() {
		return this.jjlx;
	}

	public void setJjlx(String jjlx) {
		this.jjlx = jjlx;
	}

	public String getMssz() {
		return this.mssz;
	}

	public void setMssz(String mssz) {
		this.mssz = mssz;
	}

	public String getXz() {
		return this.xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}

	public String getCzr() {
		return this.czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
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
	 * @param v12001List the v12001List to set
	 */
	public void setV12001List(ArrayList<Pgv12001> v12001List) {
		this.v12001List = v12001List;
	}

	/**
	 * @return the v12001List
	 */
	public ArrayList<Pgv12001> getV12001List() {
		return v12001List;
	}

	/**
	 * @return the sumZyywsr
	 */
	public Double getSumZyywsr() {
		return sumZyywsr;
	}

	/**
	 * @param sumZyywsr the sumZyywsr to set
	 */
	public void setSumZyywsr(Double sumZyywsr) {
		this.sumZyywsr = sumZyywsr;
	}

	/**
	 * @return the sumLrze
	 */
	public Double getSumLrze() {
		return sumLrze;
	}

	/**
	 * @param sumLrze the sumLrze to set
	 */
	public void setSumLrze(Double sumLrze) {
		this.sumLrze = sumLrze;
	}

	/**
	 * @return the sumFcse
	 */
	public Double getSumFcse() {
		return sumFcse;
	}

	/**
	 * @param sumFcse the sumFcse to set
	 */
	public void setSumFcse(Double sumFcse) {
		this.sumFcse = sumFcse;
	}

	/**
	 * @return the sumTdse
	 */
	public Double getSumTdse() {
		return sumTdse;
	}

	/**
	 * @param sumTdse the sumTdse to set
	 */
	public void setSumTdse(Double sumTdse) {
		this.sumTdse = sumTdse;
	}

	/**
	 * @param isInfo the isInfo to set
	 */
	public void setIsInfo(Boolean isInfo) {
		this.isInfo = isInfo;
	}

	/**
	 * @return the isInfo
	 */
	public Boolean getIsInfo() {
		return isInfo;
	}

	/**
	 * @param shCzr the shCzr to set
	 */
	public void setShCzr(String shCzr) {
		this.shCzr = shCzr;
	}

	/**
	 * @return the shCzr
	 */
	public String getShCzr() {
		return shCzr;
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
	 * @return the pgjgFc
	 */
	public Double getPgjgFc() {
		return pgjgFc;
	}

	/**
	 * @param pgjgFc the pgjgFc to set
	 */
	public void setPgjgFc(Double pgjgFc) {
		this.pgjgFc = pgjgFc;
	}

	/**
	 * @return the pgjgDc
	 */
	public Double getPgjgDc() {
		return pgjgDc;
	}

	/**
	 * @param pgjgDc the pgjgDc to set
	 */
	public void setPgjgDc(Double pgjgDc) {
		this.pgjgDc = pgjgDc;
	}

	/**
	 * @return the pgjg
	 */
	public Double getPgjg() {
		return pgjg;
	}

	/**
	 * @param pgjg the pgjg to set
	 */
	public void setPgjg(Double pgjg) {
		this.pgjg = pgjg;
	}

	/**
	 * @return the pgjgFcGb
	 */
	public Double getPgjgFcGb() {
		return pgjgFcGb;
	}

	/**
	 * @param pgjgFcGb the pgjgFcGb to set
	 */
	public void setPgjgFcGb(Double pgjgFcGb) {
		this.pgjgFcGb = pgjgFcGb;
	}

	/**
	 * @return the pgjgDcGb
	 */
	public Double getPgjgDcGb() {
		return pgjgDcGb;
	}

	/**
	 * @param pgjgDcGb the pgjgDcGb to set
	 */
	public void setPgjgDcGb(Double pgjgDcGb) {
		this.pgjgDcGb = pgjgDcGb;
	}

	/**
	 * @return the pgjgGb
	 */
	public Double getPgjgGb() {
		return pgjgGb;
	}

	/**
	 * @param pgjgGb the pgjgGb to set
	 */
	public void setPgjgGb(Double pgjgGb) {
		this.pgjgGb = pgjgGb;
	}

	/**
	 * @param sysPssdYMD the sysPssdYMD to set
	 */
	public void setSysPssdYMD(Date sysPssdYMD) {
		this.sysPssdYMD = sysPssdYMD;
	}

	/**
	 * @return the sysPssdYMD
	 */
	public Date getSysPssdYMD() {
		return sysPssdYMD;
	}

	/**
	 * @param ssCzr the ssCzr to set
	 */
	public void setSsCzr(String ssCzr) {
		this.ssCzr = ssCzr;
	}

	/**
	 * @return the ssCzr
	 */
	public String getSsCzr() {
		return ssCzr;
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