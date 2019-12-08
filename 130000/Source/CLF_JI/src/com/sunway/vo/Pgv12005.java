package com.sunway.vo;

import java.util.ArrayList;

/**
 * PgvCBSYsjczzt entity. 
 * @author Lee
 */


public class Pgv12005 implements java.io.Serializable {

	private static final long serialVersionUID = -161220498524518988L;
	// Fields
	private String swid;
	private String nsrmc;
	private String cd12001Swid;
	private String cd00002Pssd;
	private String cd00001Ssgx;
	private Integer cbshzt;
	private Integer cbpgzt;
	private Integer cbskzt;
	private Short cbdycs;
	private Integer syshzt;
	private Integer sypgzt;
	private Integer syskzt;
	private Short sydycs;
	private String cd00002Cbshczr;
	private String cd00002Cbpgczr;
	private String cd00002Cbskczr;
	private String cd00002Cbdyczr;
	private String cd00002Syshczr;
	private String cd00002Sypgczr;
	private String cd00002Syskczr;
	private String cd00002Sydyczr;
	private String cbshczr;
	private String cbpgczr;
	private String cbskczr;
	private String cbdyczr;
	private String syshczr;
	private String sypgczr;
	private String syskczr;
	private String sydyczr;
	private Integer recordCount;
	private Integer recordIndex;
	private Integer pageIndex;
	private Integer pageSize;
	private Integer cbzt;
	private Integer syzt;
	private String cd00002Czr;
	private ArrayList<Pgv12005> v12005List;
	private Double cbpgjg;
	private Double sypgjg;
	private Double cbskjg;
	private Double syskjg;
	
	// Constructors
	/** default constructor */
	public Pgv12005() {
		this.v12005List = new ArrayList<Pgv12005>();
	}

	/** minimal constructor */
	public Pgv12005(String cd12001Swid, String cd00002Pssd, Integer cbshzt,
			Integer cbpgzt, Integer cbskzt, Short cbdycs, Integer syshzt,
			Integer sypgzt, Integer syskzt, Short sydycs,
			String cd00002Cbshczr, String cd00002Cbpgczr,
			String cd00002Cbskczr, String cd00002Cbdyczr,
			String cd00002Syshczr, String cd00002Sypgczr,
			String cd00002Syskczr, String cd00002Sydyczr) {
		this.cd12001Swid = cd12001Swid;
		this.cd00002Pssd = cd00002Pssd;
		this.cbshzt = cbshzt;
		this.cbpgzt = cbpgzt;
		this.cbskzt = cbskzt;
		this.cbdycs = cbdycs;
		this.syshzt = syshzt;
		this.sypgzt = sypgzt;
		this.syskzt = syskzt;
		this.sydycs = sydycs;
		this.cd00002Cbshczr = cd00002Cbshczr;
		this.cd00002Cbpgczr = cd00002Cbpgczr;
		this.cd00002Cbskczr = cd00002Cbskczr;
		this.cd00002Cbdyczr = cd00002Cbdyczr;
		this.cd00002Syshczr = cd00002Syshczr;
		this.cd00002Sypgczr = cd00002Sypgczr;
		this.cd00002Syskczr = cd00002Syskczr;
		this.cd00002Sydyczr = cd00002Sydyczr;
	}

	/** full constructor */
	public Pgv12005(String cd12001Swid, String cd00002Pssd, Integer cbshzt,
			Integer cbpgzt, Integer cbskzt, Short cbdycs, Integer syshzt,
			Integer sypgzt, Integer syskzt, Short sydycs,
			String cd00002Cbshczr, String cd00002Cbpgczr,
			String cd00002Cbskczr, String cd00002Cbdyczr,
			String cd00002Syshczr, String cd00002Sypgczr,
			String cd00002Syskczr, String cd00002Sydyczr, String cbshczr,
			String cbpgczr, String cbskczr, String cbdyczr, String syshczr,
			String sypgczr, String syskczr, String sydyczr) {
		this.cd12001Swid = cd12001Swid;
		this.cd00002Pssd = cd00002Pssd;
		this.cbshzt = cbshzt;
		this.cbpgzt = cbpgzt;
		this.cbskzt = cbskzt;
		this.cbdycs = cbdycs;
		this.syshzt = syshzt;
		this.sypgzt = sypgzt;
		this.syskzt = syskzt;
		this.sydycs = sydycs;
		this.cd00002Cbshczr = cd00002Cbshczr;
		this.cd00002Cbpgczr = cd00002Cbpgczr;
		this.cd00002Cbskczr = cd00002Cbskczr;
		this.cd00002Cbdyczr = cd00002Cbdyczr;
		this.cd00002Syshczr = cd00002Syshczr;
		this.cd00002Sypgczr = cd00002Sypgczr;
		this.cd00002Syskczr = cd00002Syskczr;
		this.cd00002Sydyczr = cd00002Sydyczr;
		this.cbshczr = cbshczr;
		this.cbpgczr = cbpgczr;
		this.cbskczr = cbskczr;
		this.cbdyczr = cbdyczr;
		this.syshczr = syshczr;
		this.sypgczr = sypgczr;
		this.syskczr = syskczr;
		this.sydyczr = sydyczr;
	}

	// Property accessors

	public String getCd12001Swid() {
		return this.cd12001Swid;
	}

	public void setCd12001Swid(String cd12001Swid) {
		this.cd12001Swid = cd12001Swid;
	}

	public String getCd00002Pssd() {
		return this.cd00002Pssd;
	}

	public void setCd00002Pssd(String cd00002Pssd) {
		this.cd00002Pssd = cd00002Pssd;
	}

	public Integer getCbshzt() {
		return this.cbshzt;
	}

	public void setCbshzt(Integer cbshzt) {
		this.cbshzt = cbshzt;
	}

	public Integer getCbpgzt() {
		return this.cbpgzt;
	}

	public void setCbpgzt(Integer cbpgzt) {
		this.cbpgzt = cbpgzt;
	}

	public Integer getCbskzt() {
		return this.cbskzt;
	}

	public void setCbskzt(Integer cbskzt) {
		this.cbskzt = cbskzt;
	}

	public Short getCbdycs() {
		return this.cbdycs;
	}

	public void setCbdycs(Short cbdycs) {
		this.cbdycs = cbdycs;
	}

	public Integer getSyshzt() {
		return this.syshzt;
	}

	public void setSyshzt(Integer syshzt) {
		this.syshzt = syshzt;
	}

	public Integer getSypgzt() {
		return this.sypgzt;
	}

	public void setSypgzt(Integer sypgzt) {
		this.sypgzt = sypgzt;
	}

	public Integer getSyskzt() {
		return this.syskzt;
	}

	public void setSyskzt(Integer syskzt) {
		this.syskzt = syskzt;
	}

	public Short getSydycs() {
		return this.sydycs;
	}

	public void setSydycs(Short sydycs) {
		this.sydycs = sydycs;
	}

	public String getCd00002Cbshczr() {
		return this.cd00002Cbshczr;
	}

	public void setCd00002Cbshczr(String cd00002Cbshczr) {
		this.cd00002Cbshczr = cd00002Cbshczr;
	}

	public String getCd00002Cbpgczr() {
		return this.cd00002Cbpgczr;
	}

	public void setCd00002Cbpgczr(String cd00002Cbpgczr) {
		this.cd00002Cbpgczr = cd00002Cbpgczr;
	}

	public String getCd00002Cbskczr() {
		return this.cd00002Cbskczr;
	}

	public void setCd00002Cbskczr(String cd00002Cbskczr) {
		this.cd00002Cbskczr = cd00002Cbskczr;
	}

	public String getCd00002Cbdyczr() {
		return this.cd00002Cbdyczr;
	}

	public void setCd00002Cbdyczr(String cd00002Cbdyczr) {
		this.cd00002Cbdyczr = cd00002Cbdyczr;
	}

	public String getCd00002Syshczr() {
		return this.cd00002Syshczr;
	}

	public void setCd00002Syshczr(String cd00002Syshczr) {
		this.cd00002Syshczr = cd00002Syshczr;
	}

	public String getCd00002Sypgczr() {
		return this.cd00002Sypgczr;
	}

	public void setCd00002Sypgczr(String cd00002Sypgczr) {
		this.cd00002Sypgczr = cd00002Sypgczr;
	}

	public String getCd00002Syskczr() {
		return this.cd00002Syskczr;
	}

	public void setCd00002Syskczr(String cd00002Syskczr) {
		this.cd00002Syskczr = cd00002Syskczr;
	}

	public String getCd00002Sydyczr() {
		return this.cd00002Sydyczr;
	}

	public void setCd00002Sydyczr(String cd00002Sydyczr) {
		this.cd00002Sydyczr = cd00002Sydyczr;
	}

	public String getCbshczr() {
		return this.cbshczr;
	}

	public void setCbshczr(String cbshczr) {
		this.cbshczr = cbshczr;
	}

	public String getCbpgczr() {
		return this.cbpgczr;
	}

	public void setCbpgczr(String cbpgczr) {
		this.cbpgczr = cbpgczr;
	}

	public String getCbskczr() {
		return this.cbskczr;
	}

	public void setCbskczr(String cbskczr) {
		this.cbskczr = cbskczr;
	}

	public String getCbdyczr() {
		return this.cbdyczr;
	}

	public void setCbdyczr(String cbdyczr) {
		this.cbdyczr = cbdyczr;
	}

	public String getSyshczr() {
		return this.syshczr;
	}

	public void setSyshczr(String syshczr) {
		this.syshczr = syshczr;
	}

	public String getSypgczr() {
		return this.sypgczr;
	}

	public void setSypgczr(String sypgczr) {
		this.sypgczr = sypgczr;
	}

	public String getSyskczr() {
		return this.syskczr;
	}

	public void setSyskczr(String syskczr) {
		this.syskczr = syskczr;
	}

	public String getSydyczr() {
		return this.sydyczr;
	}

	public void setSydyczr(String sydyczr) {
		this.sydyczr = sydyczr;
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
	 * @return the v12005List
	 */
	public ArrayList<Pgv12005> getV12005List() {
		return v12005List;
	}
	/**
	 * @param v12005List the v12005List to set
	 */
	public void setV12005List(ArrayList<Pgv12005> v12005List) {
		this.v12005List = v12005List;
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
	 * @return the cbskjg
	 */
	public Double getCbskjg() {
		return cbskjg;
	}

	/**
	 * @param cbskjg the cbskjg to set
	 */
	public void setCbskjg(Double cbskjg) {
		this.cbskjg = cbskjg;
	}

	/**
	 * @return the syskjg
	 */
	public Double getSyskjg() {
		return syskjg;
	}

	/**
	 * @param syskjg the syskjg to set
	 */
	public void setSyskjg(Double syskjg) {
		this.syskjg = syskjg;
	}
}