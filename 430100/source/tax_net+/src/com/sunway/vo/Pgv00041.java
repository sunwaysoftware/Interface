package com.sunway.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Pgv00041Id entity. @author MyEclipse Persistence Tools
 */


public class Pgv00041 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 481629133725630484L;
	private String cd123Id;
	private Double pgjg;
	private Double jsjz;
	private Double sl;
	private String cd00002Pssd;
	private Date upddate;
	private String czr;
	private Integer pglx;
	private String cd12301Swid;
	private String nsrmc;
	private String cd00001Ssgx;
	private Double jsze;
	private Double ynze;
    
    
	
     
    private String sysPssd;
    private String sysSsgx;
	private ArrayList<Pgv00041> v00041List; 
    private String ssCzr;
	private Date sysPssdYMD;
	private String fcslh;
    
	// Constructors

	/** default constructor */
	public Pgv00041() {
	}

	/**
	 * @param cd12301Swid
	 */
	public Pgv00041(String cd12301Swid) {
		this.cd12301Swid = cd12301Swid;
	}
	
	/**
	 * @param cd00002Pssd
	 * @param pglx
	 * @param cd12301Swid
	 * @param nsrmc
	 * @param pageIndex
	 * @param pageSize
	 */
	public Pgv00041(String cd00002Pssd, Integer pglx, String cd12301Swid,
			String nsrmc, Integer pageIndex, Integer pageSize) {
		this.cd00002Pssd = cd00002Pssd;
		this.pglx = pglx;
		this.cd12301Swid = cd12301Swid;
		this.nsrmc = nsrmc;
		this.setPageIndex(pageIndex);
		this.setPageSize(pageSize);
	}

	/**
	 * @param cd123Id
	 * @param pgjg
	 * @param jsjz
	 * @param sl
	 * @param cd00002Pssd
	 * @param upddate
	 * @param czr
	 * @param pglx
	 * @param cd12301Swid
	 * @param nsrmc
	 * @param cd00001Ssgx
	 * @param jsze
	 * @param ynze
	 * @param recordCount
	 * @param recordIndex
	 */
	public Pgv00041(String cd123Id, Double pgjg, Double jsjz, Double sl,
			String cd00002Pssd, Date upddate, String czr, Integer pglx,
			String cd12301Swid, String nsrmc, String cd00001Ssgx, Double jsze,
			Double ynze, Integer recordCount, Integer recordIndex) {
		this.cd123Id = cd123Id;
		this.pgjg = pgjg;
		this.jsjz = jsjz;
		this.sl = sl;
		this.cd00002Pssd = cd00002Pssd;
		this.upddate = upddate;
		this.czr = czr;
		this.pglx = pglx;
		this.cd12301Swid = cd12301Swid;
		this.nsrmc = nsrmc;
		this.cd00001Ssgx = cd00001Ssgx;
		this.jsze = jsze;
		this.ynze = ynze;
		this.setRecordCount(recordCount);
	}

	/**
	 * @return the cd123Id
	 */
	public String getCd123Id() {
		return cd123Id;
	}

	/**
	 * @param cd123Id the cd123Id to set
	 */
	public void setCd123Id(String cd123Id) {
		this.cd123Id = cd123Id;
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
	 * @return the jsjz
	 */
	public Double getJsjz() {
		return jsjz;
	}

	/**
	 * @param jsjz the jsjz to set
	 */
	public void setJsjz(Double jsjz) {
		this.jsjz = jsjz;
	}

	/**
	 * @return the sl
	 */
	public Double getSl() {
		return sl;
	}

	/**
	 * @param sl the sl to set
	 */
	public void setSl(Double sl) {
		this.sl = sl;
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
	 * @return the pglx
	 */
	public Integer getPglx() {
		return pglx;
	}

	/**
	 * @param pglx the pglx to set
	 */
	public void setPglx(Integer pglx) {
		this.pglx = pglx;
	}

	/**
	 * @return the cd12301Swid
	 */
	public String getCd12301Swid() {
		return cd12301Swid;
	}

	/**
	 * @param cd12301Swid the cd12301Swid to set
	 */
	public void setCd12301Swid(String cd12301Swid) {
		this.cd12301Swid = cd12301Swid;
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
	 * @return the jsze
	 */
	public Double getJsze() {
		return jsze;
	}

	/**
	 * @param jsze the jsze to set
	 */
	public void setJsze(Double jsze) {
		this.jsze = jsze;
	}

	/**
	 * @return the ynze
	 */
	public Double getYnze() {
		return ynze;
	}

	/**
	 * @param ynze the ynze to set
	 */
	public void setYnze(Double ynze) {
		this.ynze = ynze;
	}	

	/**
	 * @param sysPssd the sysPssd to set
	 */
	public void setSysPssd(String sysPssd) {
		this.sysPssd = sysPssd;
	}

	/**
	 * @return the sysPssd
	 */
	public String getSysPssd() {
		return sysPssd;
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
	 * @param v00041List the v00041List to set
	 */
	public void setV00041List(ArrayList<Pgv00041> v00041List) {
		this.v00041List = v00041List;
	}

	/**
	 * @return the v00041List
	 */
	public ArrayList<Pgv00041> getV00041List() {
		return v00041List;
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

	public String getFcslh() {
		return fcslh;
	}

	public void setFcslh(String fcslh) {
		this.fcslh = fcslh;
	}
}