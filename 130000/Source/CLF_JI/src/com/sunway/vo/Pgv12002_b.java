package com.sunway.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Pgv12002_b entity.
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv12002_b implements java.io.Serializable {

	private static final long serialVersionUID = 5963645553765703924L;
	private String dcid;
	private String cd12001BSwid;
	private String tdsyqbm;
	private String cd00001Tdyt;
	private String cd00001Syqlx;
	private Double syqmj;
	private String cd00001Tdsyqlx;
	private String cd12054Tddjid;
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
	private String cd00002Pssd;
	private String cd00001Ssgx;
	private String nsrmc;
	private String tdsyqlx;
	private String tdyt;
	private String syqlx;
	private String tddj;
	private String szqy;
	private String czr;
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
	private Double sumSyqmj;
	private Double avgGbrjl;
	private Double sumYsmj;
	private Double sumMsmj;
	private Double avgTdpfmse;
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
    private ArrayList<Pgv12002_b> v12002_bList;

	/** default constructor */
	public Pgv12002_b() {
		this.v12002_bList = new ArrayList<Pgv12002_b>();
	}

	/**
	 * @return the dcid
	 */
	public String getDcid() {
		return dcid;
	}
	/**
	 * @param dcid the dcid to set
	 */
	public void setDcid(String dcid) {
		this.dcid = dcid;
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
	 * @return the tdsyqbm
	 */
	public String getTdsyqbm() {
		return tdsyqbm;
	}
	/**
	 * @param tdsyqbm the tdsyqbm to set
	 */
	public void setTdsyqbm(String tdsyqbm) {
		this.tdsyqbm = tdsyqbm;
	}
	/**
	 * @return the cd00001Tdyt
	 */
	public String getCd00001Tdyt() {
		return cd00001Tdyt;
	}
	/**
	 * @param cd00001Tdyt the cd00001Tdyt to set
	 */
	public void setCd00001Tdyt(String cd00001Tdyt) {
		this.cd00001Tdyt = cd00001Tdyt;
	}
	/**
	 * @return the cd00001Syqlx
	 */
	public String getCd00001Syqlx() {
		return cd00001Syqlx;
	}
	/**
	 * @param cd00001Syqlx the cd00001Syqlx to set
	 */
	public void setCd00001Syqlx(String cd00001Syqlx) {
		this.cd00001Syqlx = cd00001Syqlx;
	}
	/**
	 * @return the syqmj
	 */
	public Double getSyqmj() {
		return syqmj;
	}
	/**
	 * @param syqmj the syqmj to set
	 */
	public void setSyqmj(Double syqmj) {
		this.syqmj = syqmj;
	}
	/**
	 * @return the cd00001Tdsyqlx
	 */
	public String getCd00001Tdsyqlx() {
		return cd00001Tdsyqlx;
	}
	/**
	 * @param cd00001Tdsyqlx the cd00001Tdsyqlx to set
	 */
	public void setCd00001Tdsyqlx(String cd00001Tdsyqlx) {
		this.cd00001Tdsyqlx = cd00001Tdsyqlx;
	}
	/**
	 * @return the cd12054Tddjid
	 */
	public String getCd12054Tddjid() {
		return cd12054Tddjid;
	}
	/**
	 * @param cd12054Tddjid the cd12054Tddjid to set
	 */
	public void setCd12054Tddjid(String cd12054Tddjid) {
		this.cd12054Tddjid = cd12054Tddjid;
	}
	/**
	 * @return the cd00001Szqy
	 */
	public String getCd00001Szqy() {
		return cd00001Szqy;
	}
	/**
	 * @param cd00001Szqy the cd00001Szqy to set
	 */
	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}
	/**
	 * @return the tdzl
	 */
	public String getTdzl() {
		return tdzl;
	}
	/**
	 * @param tdzl the tdzl to set
	 */
	public void setTdzl(String tdzl) {
		this.tdzl = tdzl;
	}
	/**
	 * @return the gbrjl
	 */
	public Double getGbrjl() {
		return gbrjl;
	}
	/**
	 * @param gbrjl the gbrjl to set
	 */
	public void setGbrjl(Double gbrjl) {
		this.gbrjl = gbrjl;
	}
	/**
	 * @return the ysmj
	 */
	public Double getYsmj() {
		return ysmj;
	}
	/**
	 * @param ysmj the ysmj to set
	 */
	public void setYsmj(Double ysmj) {
		this.ysmj = ysmj;
	}
	/**
	 * @return the msmj
	 */
	public Double getMsmj() {
		return msmj;
	}
	/**
	 * @param msmj the msmj to set
	 */
	public void setMsmj(Double msmj) {
		this.msmj = msmj;
	}
	/**
	 * @return the tdpfmse
	 */
	public Double getTdpfmse() {
		return tdpfmse;
	}
	/**
	 * @param tdpfmse the tdpfmse to set
	 */
	public void setTdpfmse(Double tdpfmse) {
		this.tdpfmse = tdpfmse;
	}
	/**
	 * @return the x
	 */
	public Double getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(Double x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public Double getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(Double y) {
		this.y = y;
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
	 * @return the sykssj
	 */
	public Date getSykssj() {
		return sykssj;
	}
	/**
	 * @param sykssj the sykssj to set
	 */
	public void setSykssj(Date sykssj) {
		this.sykssj = sykssj;
	}
	/**
	 * @return the syjssj
	 */
	public Date getSyjssj() {
		return syjssj;
	}
	/**
	 * @param syjssj the syjssj to set
	 */
	public void setSyjssj(Date syjssj) {
		this.syjssj = syjssj;
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
	 * @return the tdsyqlx
	 */
	public String getTdsyqlx() {
		return tdsyqlx;
	}
	/**
	 * @param tdsyqlx the tdsyqlx to set
	 */
	public void setTdsyqlx(String tdsyqlx) {
		this.tdsyqlx = tdsyqlx;
	}
	/**
	 * @return the tdyt
	 */
	public String getTdyt() {
		return tdyt;
	}
	/**
	 * @param tdyt the tdyt to set
	 */
	public void setTdyt(String tdyt) {
		this.tdyt = tdyt;
	}
	/**
	 * @return the syqlx
	 */
	public String getSyqlx() {
		return syqlx;
	}
	/**
	 * @param syqlx the syqlx to set
	 */
	public void setSyqlx(String syqlx) {
		this.syqlx = syqlx;
	}
	/**
	 * @return the tddj
	 */
	public String getTddj() {
		return tddj;
	}
	/**
	 * @param tddj the tddj to set
	 */
	public void setTddj(String tddj) {
		this.tddj = tddj;
	}
	/**
	 * @return the szqy
	 */
	public String getSzqy() {
		return szqy;
	}
	/**
	 * @param szqy the szqy to set
	 */
	public void setSzqy(String szqy) {
		this.szqy = szqy;
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
	 * @return the v12002_bList
	 */
	public ArrayList<Pgv12002_b> getV12002_bList() {
		return v12002_bList;
	}
	/**
	 * @param v12002BList the v12002_bList to set
	 */
	public void setV12002_bList(ArrayList<Pgv12002_b> v12002BList) {
		v12002_bList = v12002BList;
	}
}
