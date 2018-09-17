package com.sunway.vo;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Pgv00303 entity.
 * @author Lee
 */

public class Pgv00303 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 39262551449446356L;
	private String lfid;
	private String cd00352Xqdm;
	private String cd00001Jzjg;
	private Boolean ywdt;
	private Short zlc;
	private String fwtdzl;
	private Timestamp upddate;
	private Timestamp jysj;
	private String cd00002Czr;
	private String note;
	private String ssgx;
	
	
	
	
	private String xqnm;
	private String xqbm;
	private String szqy;
	private String cd00001Szqy;
	private String jzjg;
	private String czr;
	private String zcdzl;
	private String zcdzbm;
	private Integer zcdzType;
	private String csfzjlx;
	
	//private Integer ywlf;
	private Integer outFlag;
    private ArrayList<Pgv00303> outList;
    private String clh;
	private Integer ywjkc;
	private String lh;
	private String dyh;
	private String fh;
    public Pgv00303 (){
    	outList = new ArrayList<Pgv00303>();
    }
	/**
	 * @return the lfid
	 */
	public String getLfid() {
		return lfid;
	}
	/**
	 * @param lfid the lfid to set
	 */
	public void setLfid(String lfid) {
		this.lfid = lfid;
	}
	/**
	 * @return the cd00352Xqdm
	 */
	public String getCd00352Xqdm() {
		return cd00352Xqdm;
	}
	/**
	 * @param cd00352Xqdm the cd00352Xqdm to set
	 */
	public void setCd00352Xqdm(String cd00352Xqdm) {
		this.cd00352Xqdm = cd00352Xqdm;
	}
	/**
	 * @return the cd00001Jzjg
	 */
	public String getCd00001Jzjg() {
		return cd00001Jzjg;
	}
	/**
	 * @param cd00001Jzjg the cd00001Jzjg to set
	 */
	public void setCd00001Jzjg(String cd00001Jzjg) {
		this.cd00001Jzjg = cd00001Jzjg;
	}
	/**
	 * @return the ywdt
	 */
	public Boolean getYwdt() {
		return ywdt;
	}
	/**
	 * @param ywdt the ywdt to set
	 */
	public void setYwdt(Boolean ywdt) {
		this.ywdt = ywdt;
	}
	/**
	 * @return the zlc
	 */
	public Short getZlc() {
		return zlc;
	}
	/**
	 * @param zlc the zlc to set
	 */
	public void setZlc(Short zlc) {
		this.zlc = zlc;
	}
	/**
	 * @return the fwtdzl
	 */
	public String getFwtdzl() {
		return fwtdzl;
	}
	/**
	 * @param fwtdzl the fwtdzl to set
	 */
	public void setFwtdzl(String fwtdzl) {
		this.fwtdzl = fwtdzl;
	}
	/**
	 * @return the upddate
	 */
	public Timestamp getUpddate() {
		return upddate;
	}
	/**
	 * @param upddate the upddate to set
	 */
	public void setUpddate(Timestamp upddate) {
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
	 * @return the xqnm
	 */
	public String getXqnm() {
		return xqnm;
	}
	/**
	 * @param xqnm the xqnm to set
	 */
	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}
	/**
	 * @return the xqbm
	 */
	public String getXqbm() {
		return xqbm;
	}
	/**
	 * @param xqbm the xqbm to set
	 */
	public void setXqbm(String xqbm) {
		this.xqbm = xqbm;
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
	 * @return the jzjg
	 */
	public String getJzjg() {
		return jzjg;
	}
	/**
	 * @param jzjg the jzjg to set
	 */
	public void setJzjg(String jzjg) {
		this.jzjg = jzjg;
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
	 * @return the zcdzl
	 */
	public String getZcdzl() {
		return zcdzl;
	}
	/**
	 * @param zcdzl the zcdzl to set
	 */
	public void setZcdzl(String zcdzl) {
		this.zcdzl = zcdzl;
	}
	/**
	 * @return the zcdzbm
	 */
	public String getZcdzbm() {
		return zcdzbm;
	}
	/**
	 * @param zcdzbm the zcdzbm to set
	 */
	public void setZcdzbm(String zcdzbm) {
		this.zcdzbm = zcdzbm;
	}
	/**
	 * @param zcdzType the zcdzType to set
	 */
	public void setZcdzType(Integer zcdzType) {
		this.zcdzType = zcdzType;
	}
	/**
	 * @return the zcdzType
	 */
	public Integer getZcdzType() {
		return zcdzType;
	}
	
	/**
	 * @return the outFlag
	 */
	public Integer getOutFlag() {
		return outFlag;
	}
	/**
	 * @param outFlag the outFlag to set
	 */
	public void setOutFlag(Integer outFlag) {
		this.outFlag = outFlag;
	}
	/**
	 * @return the outList
	 */
	public ArrayList<Pgv00303> getOutList() {
		return outList;
	}
	/**
	 * @param outList the outList to set
	 */
	public void setOutList(ArrayList<Pgv00303> outList) {
		this.outList = outList;
	}
	/**
	 * @return the clh
	 */
	public String getClh() {
		return clh;
	}
	/**
	 * @param clh the clh to set
	 */
	public void setClh(String clh) {
		this.clh = clh;
	}
	public Integer getYwjkc() {
		return ywjkc;
	}
	public void setYwjkc(Integer ywjkc) {
		this.ywjkc = ywjkc;
	}
	/**
	 * @return the csfzjlx
	 */
	public String getCsfzjlx() {
		return csfzjlx;
	}
	/**
	 * @param csfzjlx the csfzjlx to set
	 */
	public void setCsfzjlx(String csfzjlx) {
		this.csfzjlx = csfzjlx;
	}
	/**
	 * @return the jysj
	 */
	public Timestamp getJysj() {
		return jysj;
	}
	/**
	 * @param jysj the jysj to set
	 */
	public void setJysj(Timestamp jysj) {
		this.jysj = jysj;
	}
	/**
	 * @return the lh
	 */
	public String getLh() {
		return lh;
	}
	/**
	 * @param lh the lh to set
	 */
	public void setLh(String lh) {
		this.lh = lh;
	}
	/**
	 * @return the dyh
	 */
	public String getDyh() {
		return dyh;
	}
	/**
	 * @param dyh the dyh to set
	 */
	public void setDyh(String dyh) {
		this.dyh = dyh;
	}
	/**
	 * @return the fh
	 */
	public String getFh() {
		return fh;
	}
	/**
	 * @param fh the fh to set
	 */
	public void setFh(String fh) {
		this.fh = fh;
	}
}
