package com.sunway.vo;

import java.util.Date;

/**
 * Pgt12002 entity. @author MyEclipse Persistence Tools
 */


public class Pgt12002 implements java.io.Serializable {

	private static final long serialVersionUID = -1197383325581460934L;
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
	private String sysSsgx;
	private String tdsyqlx;
	private String tdyt;
	private String syqlx;
	private String tddj;
	private String szqy;
	//地产承租人
	private String cd12006Czrzjh;
	private String czrmc;
	private Boolean sfnsr;
	private Date czkssj;
	private Date czjssj;
	private String czNote;
	//地产其他修正
	private String cd00053QtxzId;
	private String nsrmc;
	private Integer countFC;
	private Date bgsj;
	private Integer bglx;
	
	// Constructors

	/** default constructor */
	public Pgt12002() {
	}

	public Pgt12002(String dcid) {
		this.dcid = dcid;
	}
	
	public Pgt12002(String dcid, String tdsyqbm) {
		this.dcid = dcid;
		this.tdsyqbm = tdsyqbm;
	}
	
	/** minimal constructor */
	public Pgt12002(String dcid, String cd12001Swid, String cd00001Tdyt,
			String cd00001Syqlx, Double syqmj, String cd00001Tdsyqlx,
			String cd00001Tddj, String cd00001Szqy, Double gbrjl, Double ysmj,
			Double msmj, Double tdpfmse, Double x, Double y, Date lrdate,
			Date upddate, String cd00002Czr) {
		this.dcid = dcid;
		this.setCd12001Swid(cd12001Swid);
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
	}

	/** full constructor */
	public Pgt12002(String dcid, String cd12001Swid, String tdsyqbm,
			String cd00001Tdyt, String cd00001Syqlx, Double syqmj,
			String cd00001Tdsyqlx, String cd00001Tddj, String cd00001Szqy,
			String tdzl, Double gbrjl, Double ysmj, Double msmj,
			Double tdpfmse, Double x, Double y, Date lrdate, Date upddate,
			String cd00002Czr, String note, Date sykssj, Date syjssj) {
		this.dcid = dcid;
		this.setCd12001Swid(cd12001Swid);
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
	}

	// Property accessors

	public String getDcid() {
		return this.dcid;
	}

	public void setDcid(String dcid) {
		this.dcid = dcid;
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

	/**
	 * @param cd12001Swid the cd12001Swid to set
	 */
	public void setCd12001Swid(String cd12001Swid) {
		this.cd12001Swid = cd12001Swid;
	}

	/**
	 * @return the cd12001Swid
	 */
	public String getCd12001Swid() {
		return cd12001Swid;
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
	 * @param czNote the czNote to set
	 */
	public void setCzNote(String czNote) {
		this.czNote = czNote;
	}

	/**
	 * @return the czNote
	 */
	public String getCzNote() {
		return czNote;
	}

	/**
	 * @param cd00053QtxzId the cd00053QtxzId to set
	 */
	public void setCd00053QtxzId(String cd00053QtxzId) {
		this.cd00053QtxzId = cd00053QtxzId;
	}

	/**
	 * @return the cd00053QtxzId
	 */
	public String getCd00053QtxzId() {
		return cd00053QtxzId;
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
	 * 初始化除DCID,SWID,NSRMC之外的屬性
	 */
	public void clear() {
		this.tdsyqbm = null;
		this.cd00001Tdyt = null;
		this.cd00001Syqlx = null;
		this.syqmj = null;
		this.cd00001Tdsyqlx = null;
		this.cd00001Tddj = null;
		this.cd00001Szqy = null;
		this.tdzl = null;
		this.gbrjl = null;
		this.ysmj = null;
		this.msmj = null;
		this.tdpfmse = null;
		this.x = null;
		this.y = null;
		this.lrdate = null;
		this.upddate = null;
		this.cd00002Czr = null;
		this.note = null;
		this.sykssj = null;
		this.syjssj = null;
		this.sysSsgx = null;
		this.tdsyqlx = null;
		this.tdyt = null;
		this.syqlx = null;
		this.tddj = null;
		this.szqy = null;
		this.cd12006Czrzjh = null;
		this.czrmc = null;
		this.sfnsr = null;
		this.czkssj = null;
		this.czjssj = null;
		this.czNote = null;
		this.cd00053QtxzId = null;
	}

	/**
	 * @param countFC the countFC to set
	 */
	public void setCountFC(Integer countFC) {
		this.countFC = countFC;
	}

	/**
	 * @return the countFC
	 */
	public Integer getCountFC() {
		return countFC;
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
}