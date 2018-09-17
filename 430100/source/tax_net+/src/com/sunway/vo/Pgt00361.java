package com.sunway.vo;

import java.io.Serializable;
import java.sql.Timestamp;



/**
 * 建筑成新修正系统维护
 * @author HuanWei
 *
 */
public class Pgt00361 implements Serializable {
	
	private static final long serialVersionUID = 680480541662139951L;
	private Integer id;
	private Integer synx_min;
	private Integer synx_max;
	private Double xzxs;
	private Timestamp upddate;
	private String cd_00002_czr;
	private String note;
	private Integer czlx;
	private String cd_00002_pssd;
	private String fwlx;
	private String cd_00001_fwlx;
	private String cd_00001_szqy;
	private String cd_00001_ssgx;
	private String ssgx;
	private String cd00352Xqdm;
	private String xqnm;
	
	public String getCd00352Xqdm() {
		return cd00352Xqdm;
	}
	public void setCd00352Xqdm(String cd00352Xqdm) {
		this.cd00352Xqdm = cd00352Xqdm;
	}
	public String getXqnm() {
		return xqnm;
	}
	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}
	private String chkDel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSynx_min() {
		return synx_min;
	}
	public void setSynx_min(Integer synxMin) {
		synx_min = synxMin;
	}
	public Integer getSynx_max() {
		return synx_max;
	}
	public void setSynx_max(Integer synxMax) {
		synx_max = synxMax;
	}

	public Double getXzxs() {
		return xzxs;
	}
	public void setXzxs(Double xzxs) {
		this.xzxs = xzxs;
	}
	public Timestamp getUpddate() {
		return upddate;
	}
	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}
	public String getCd_00002_czr() {
		return cd_00002_czr;
	}
	public void setCd_00002_czr(String cd_00002Czr) {
		cd_00002_czr = cd_00002Czr;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getCzlx() {
		return czlx;
	}
	public void setCzlx(Integer czlx) {
		this.czlx = czlx;
	}
	public String getCd_00002_pssd() {
		return cd_00002_pssd;
	}
	public void setCd_00002_pssd(String cd_00002Pssd) {
		cd_00002_pssd = cd_00002Pssd;
	}
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	public String getCd_00001_fwlx() {
		return cd_00001_fwlx;
	}
	public void setCd_00001_fwlx(String cd_00001Fwlx) {
		cd_00001_fwlx = cd_00001Fwlx;
	}
	/**
	 * @return the cd_00001_szqy
	 */
	public String getCd_00001_szqy() {
		return cd_00001_szqy;
	}
	/**
	 * @param cd_00001Szqy the cd_00001_szqy to set
	 */
	public void setCd_00001_szqy(String cd_00001Szqy) {
		cd_00001_szqy = cd_00001Szqy;
	}
	public String getCd_00001_ssgx() {
		return cd_00001_ssgx;
	}
	public void setCd_00001_ssgx(String cd_00001Ssgx) {
		cd_00001_ssgx = cd_00001Ssgx;
	}
	public String getSsgx() {
		return ssgx;
	}
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}
	public String getChkDel() {
		return chkDel;
	}
	public void setChkDel(String chkDel) {
		this.chkDel = chkDel;
	}
	
}
