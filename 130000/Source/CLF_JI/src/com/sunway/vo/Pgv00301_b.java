package com.sunway.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Pgv00301_b entity.
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv00301_b implements java.io.Serializable {

	private static final long serialVersionUID = 7770995098723825721L;
	private String swid;
	private String nsrmc;
	private String cd00001Zjlx;
	private String zz;
	private String lxdh;
	private String yddh;
	private String cd00001Ssgx;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String cd00002Pssd;
	private String zjlx;
	private String ssgx;
	private String czr;
	private Integer sczt;
    private Double pgjg;
    private Double gbpgjg;
    private Double jsze;
	private Double ynze;
	private Double sumPgjg;
	private Double sumGbpgjg;
	private Double sumJsze;
	private Double sumYnze;
	private Integer recordCount;
	private Integer recordIndex;
	private Integer pageIndex;
	private Integer pageSize;
	private ArrayList<Pgv00301_b> v00301_bList;

	/** default constructor */
	public Pgv00301_b() {
		this.v00301_bList = new ArrayList<Pgv00301_b>();
	}

	/**
	 * @return the swid
	 */
	public String getSwid() {
		return swid;
	}
	/**
	 * @param swid the swid to set
	 */
	public void setSwid(String swid) {
		this.swid = swid;
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
	 * @return the cd00001Zjlx
	 */
	public String getCd00001Zjlx() {
		return cd00001Zjlx;
	}
	/**
	 * @param cd00001Zjlx the cd00001Zjlx to set
	 */
	public void setCd00001Zjlx(String cd00001Zjlx) {
		this.cd00001Zjlx = cd00001Zjlx;
	}
	/**
	 * @return the zz
	 */
	public String getZz() {
		return zz;
	}
	/**
	 * @param zz the zz to set
	 */
	public void setZz(String zz) {
		this.zz = zz;
	}
	/**
	 * @return the lxdh
	 */
	public String getLxdh() {
		return lxdh;
	}
	/**
	 * @param lxdh the lxdh to set
	 */
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	/**
	 * @return the yddh
	 */
	public String getYddh() {
		return yddh;
	}
	/**
	 * @param yddh the yddh to set
	 */
	public void setYddh(String yddh) {
		this.yddh = yddh;
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
	 * @return the zjlx
	 */
	public String getZjlx() {
		return zjlx;
	}
	/**
	 * @param zjlx the zjlx to set
	 */
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}
	/**
	 * @return the ssgx
	 */
	public String getSsgx() {
		return ssgx;
	}
	/**
	 * @param ssgx the ssgx to set
	 */
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
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
	 * @return the sczt
	 */
	public Integer getSczt() {
		return sczt;
	}
	/**
	 * @param sczt the sczt to set
	 */
	public void setSczt(Integer sczt) {
		this.sczt = sczt;
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
	 * @return the gbpgjg
	 */
	public Double getGbpgjg() {
		return gbpgjg;
	}
	/**
	 * @param gbpgjg the gbpgjg to set
	 */
	public void setGbpgjg(Double gbpgjg) {
		this.gbpgjg = gbpgjg;
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
	 * @return the sumPgjg
	 */
	public Double getSumPgjg() {
		return sumPgjg;
	}
	/**
	 * @param sumPgjg the sumPgjg to set
	 */
	public void setSumPgjg(Double sumPgjg) {
		this.sumPgjg = sumPgjg;
	}
	/**
	 * @return the sumGbpgjg
	 */
	public Double getSumGbpgjg() {
		return sumGbpgjg;
	}
	/**
	 * @param sumGbpgjg the sumGbpgjg to set
	 */
	public void setSumGbpgjg(Double sumGbpgjg) {
		this.sumGbpgjg = sumGbpgjg;
	}
	/**
	 * @return the sumJsze
	 */
	public Double getSumJsze() {
		return sumJsze;
	}
	/**
	 * @param sumJsze the sumJsze to set
	 */
	public void setSumJsze(Double sumJsze) {
		this.sumJsze = sumJsze;
	}
	/**
	 * @return the sumYnze
	 */
	public Double getSumYnze() {
		return sumYnze;
	}
	/**
	 * @param sumYnze the sumYnze to set
	 */
	public void setSumYnze(Double sumYnze) {
		this.sumYnze = sumYnze;
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
	 * @return the v00301_bList
	 */
	public ArrayList<Pgv00301_b> getV00301_bList() {
		return v00301_bList;
	}
	/**
	 * @param v00301BList the v00301_bList to set
	 */
	public void setV00301_bList(ArrayList<Pgv00301_b> v00301BList) {
		v00301_bList = v00301BList;
	}
}
