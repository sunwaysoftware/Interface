package com.sunway.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Pgv12003_b entity.
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv12003_b implements java.io.Serializable {

	private static final long serialVersionUID = 7589371345892324179L;
	private String fcid;
	private String cd12002BDcid;
	private String cd12001BSwid;
	private String fdcmc;
	private String fwzldz;
	private String cd00001Qdfs;
	private String jcnf;
	private Integer fwzcs;
	private Integer ds;
	private Integer dx;
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
	private String cd00002Pssd;
	private String cd00001Ssgx;
	private String nsrmc;
	private String czr;
	private String qdfs;
	private Integer cbzt;
	private Integer syzt;
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
	private Double sumZjzmj;
	private Double sumFcyz;
	private Double sumFwzjje;
	private Double sumYsfcyz;
	private Double sumMsfcyz;
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
    private Integer recordCount;
    private Integer recordIndex;    
    private Integer pageIndex;
    private Integer pageSize;
    private ArrayList<Pgv12003_b> v12003_bList;

	/** default constructor */
	public Pgv12003_b() {
		this.v12003_bList = new ArrayList<Pgv12003_b>();
	}

	/**
	 * @return the fcid
	 */
	public String getFcid() {
		return fcid;
	}
	/**
	 * @param fcid the fcid to set
	 */
	public void setFcid(String fcid) {
		this.fcid = fcid;
	}
	/**
	 * @return the cd12002BDcid
	 */
	public String getCd12002BDcid() {
		return cd12002BDcid;
	}
	/**
	 * @param cd12002bDcid the cd12002BDcid to set
	 */
	public void setCd12002BDcid(String cd12002bDcid) {
		cd12002BDcid = cd12002bDcid;
	}
	/**
	 * @return the cd12001BSwid
	 */
	public String getCd12001BSwid() {
		return cd12001BSwid;
	}
	/**
	 * @param cd12001bSwid the cd12001BSwid to set
	 */
	public void setCd12001BSwid(String cd12001bSwid) {
		cd12001BSwid = cd12001bSwid;
	}
	/**
	 * @return the fdcmc
	 */
	public String getFdcmc() {
		return fdcmc;
	}
	/**
	 * @param fdcmc the fdcmc to set
	 */
	public void setFdcmc(String fdcmc) {
		this.fdcmc = fdcmc;
	}
	/**
	 * @return the fwzldz
	 */
	public String getFwzldz() {
		return fwzldz;
	}
	/**
	 * @param fwzldz the fwzldz to set
	 */
	public void setFwzldz(String fwzldz) {
		this.fwzldz = fwzldz;
	}
	/**
	 * @return the cd00001Qdfs
	 */
	public String getCd00001Qdfs() {
		return cd00001Qdfs;
	}
	/**
	 * @param cd00001Qdfs the cd00001Qdfs to set
	 */
	public void setCd00001Qdfs(String cd00001Qdfs) {
		this.cd00001Qdfs = cd00001Qdfs;
	}
	/**
	 * @return the jcnf
	 */
	public String getJcnf() {
		return jcnf;
	}
	/**
	 * @param jcnf the jcnf to set
	 */
	public void setJcnf(String jcnf) {
		this.jcnf = jcnf;
	}
	/**
	 * @return the fwzcs
	 */
	public Integer getFwzcs() {
		return fwzcs;
	}
	/**
	 * @param fwzcs the fwzcs to set
	 */
	public void setFwzcs(Integer fwzcs) {
		this.fwzcs = fwzcs;
	}
	/**
	 * @return the ds
	 */
	public Integer getDs() {
		return ds;
	}
	/**
	 * @param ds the ds to set
	 */
	public void setDs(Integer ds) {
		this.ds = ds;
	}
	/**
	 * @return the dx
	 */
	public Integer getDx() {
		return dx;
	}
	/**
	 * @param dx the dx to set
	 */
	public void setDx(Integer dx) {
		this.dx = dx;
	}
	/**
	 * @return the zjzmj
	 */
	public Double getZjzmj() {
		return zjzmj;
	}
	/**
	 * @param zjzmj the zjzmj to set
	 */
	public void setZjzmj(Double zjzmj) {
		this.zjzmj = zjzmj;
	}
	/**
	 * @return the fcyz
	 */
	public Double getFcyz() {
		return fcyz;
	}
	/**
	 * @param fcyz the fcyz to set
	 */
	public void setFcyz(Double fcyz) {
		this.fcyz = fcyz;
	}
	/**
	 * @return the fwzjje
	 */
	public Double getFwzjje() {
		return fwzjje;
	}
	/**
	 * @param fwzjje the fwzjje to set
	 */
	public void setFwzjje(Double fwzjje) {
		this.fwzjje = fwzjje;
	}
	/**
	 * @return the fczh
	 */
	public String getFczh() {
		return fczh;
	}
	/**
	 * @param fczh the fczh to set
	 */
	public void setFczh(String fczh) {
		this.fczh = fczh;
	}
	/**
	 * @return the ysfcyz
	 */
	public Double getYsfcyz() {
		return ysfcyz;
	}
	/**
	 * @param ysfcyz the ysfcyz to set
	 */
	public void setYsfcyz(Double ysfcyz) {
		this.ysfcyz = ysfcyz;
	}
	/**
	 * @return the msfcyz
	 */
	public Double getMsfcyz() {
		return msfcyz;
	}
	/**
	 * @param msfcyz the msfcyz to set
	 */
	public void setMsfcyz(Double msfcyz) {
		this.msfcyz = msfcyz;
	}
	/**
	 * @return the qdsj
	 */
	public Date getQdsj() {
		return qdsj;
	}
	/**
	 * @param qdsj the qdsj to set
	 */
	public void setQdsj(Date qdsj) {
		this.qdsj = qdsj;
	}
	/**
	 * @return the lrdate
	 */
	public Date getLrdate() {
		return lrdate;
	}
	/**
	 * @param lrdate the lrdate to set
	 */
	public void setLrdate(Date lrdate) {
		this.lrdate = lrdate;
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
	 * @return the cd00002Pssd
	 */
	public String getCd00002Pssd() {
		return cd00002Pssd;
	}
	/**
	 * @param cd00002Pssd the cd00002Pssd to set
	 */
	public void setCd00002Pssd(String cd00002Pssd) {
		this.cd00002Pssd = cd00002Pssd;
	}
	/**
	 * @return the cd00001Ssgx
	 */
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}
	/**
	 * @param cd00001Ssgx the cd00001Ssgx to set
	 */
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}
	/**
	 * @return the nsrmc
	 */
	public String getNsrmc() {
		return nsrmc;
	}
	/**
	 * @param nsrmc the nsrmc to set
	 */
	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
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
	 * @return the qdfs
	 */
	public String getQdfs() {
		return qdfs;
	}
	/**
	 * @param qdfs the qdfs to set
	 */
	public void setQdfs(String qdfs) {
		this.qdfs = qdfs;
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
	/**
	 * @return the zpCount
	 */
	public Integer getZpCount() {
		return zpCount;
	}
	/**
	 * @param zpCount the zpCount to set
	 */
	public void setZpCount(Integer zpCount) {
		this.zpCount = zpCount;
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
	 * @return the v12003_bList
	 */
	public ArrayList<Pgv12003_b> getV12003_bList() {
		return v12003_bList;
	}
	/**
	 * @param v12003BList the v12003_bList to set
	 */
	public void setV12003_bList(ArrayList<Pgv12003_b> v12003BList) {
		v12003_bList = v12003BList;
	}
}
