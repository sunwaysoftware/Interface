package com.sunway.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * 楼房相关信息
 * @author Light
 *
 */
public class Pgv00306 extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1152329967452104984L;
	private String id;								//流水号
	private String cd00352Xqdm;						//小区代码
	private String lh;								//楼号
	private Integer zlc;							//总楼层
	private Integer dygs;							//单元数
	private String cd00002Czr;						//操作人代码
	private Timestamp upddate;						//更新时间
	
	
	
	
	
	
	private Integer outFlag;
	private ArrayList<Pgv00306> outList;
	private String impErrorMsg;
	private String xqnm;
	private String xqdmh;
	private String cd00001Ssgx;
	private String ssgx;
	private String cd00001Szqy;
	private String szqy;
	private String note;
	private String xqbm;
	private String parentdm;
	private String czr;
	private String xqdmhm;
	private String dmh;
	private String dmhId;
	private String clh;//測量號
	private String zcdzl;
	
	public String getDmhId() {
		return dmhId;
	}
	public void setDmhId(String dmhId) {
		this.dmhId = dmhId;
	}
	public String getDmh() {
		return dmh;
	}
	public void setDmh(String dmh) {
		this.dmh = dmh;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCd00352Xqdm() {
		return cd00352Xqdm;
	}
	public void setCd00352Xqdm(String cd00352Xqdm) {
		this.cd00352Xqdm = cd00352Xqdm;
	}
	public String getLh() {
		return lh;
	}
	public void setLh(String lh) {
		this.lh = lh;
	}
	public Integer getZlc() {
		return zlc;
	}
	public void setZlc(Integer zlc) {
		this.zlc = zlc;
	}

	public Integer getDygs() {
		return dygs;
	}
	public void setDygs(Integer dygs) {
		this.dygs = dygs;
	}
	public String getCd00002Czr() {
		return cd00002Czr;
	}
	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}
	public Timestamp getUpddate() {
		return upddate;
	}
	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}
	
	public Integer getOutFlag() {
		return outFlag;
	}
	public void setOutFlag(Integer outFlag) {
		this.outFlag = outFlag;
	}
	public ArrayList<Pgv00306> getOutList() {
		return outList;
	}
	public void setOutList(ArrayList<Pgv00306> outList) {
		this.outList = outList;
	}
	public String getImpErrorMsg() {
		return impErrorMsg;
	}
	public void setImpErrorMsg(String impErrorMsg) {
		this.impErrorMsg = impErrorMsg;
	}
	public String getXqnm() {
		return xqnm;
	}
	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}
	public String getXqdmh() {
		return xqdmh;
	}
	public void setXqdmh(String xqdmh) {
		this.xqdmh = xqdmh;
	}
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}
	public String getSsgx() {
		return ssgx;
	}
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}
	public String getCd00001Szqy() {
		return cd00001Szqy;
	}
	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}
	public String getSzqy() {
		return szqy;
	}
	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getXqbm() {
		return xqbm;
	}
	public void setXqbm(String xqbm) {
		this.xqbm = xqbm;
	}
	public String getParentdm() {
		return parentdm;
	}
	public void setParentdm(String parentdm) {
		this.parentdm = parentdm;
	}
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	
	public String getXqdmhm() {
		return xqdmhm;
	}
	public void setXqdmhm(String xqdmhm) {
		this.xqdmhm = xqdmhm;
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
	
	
}
