package com.sunway.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * 建筑结构修正
 * @author HuanWei
 *
 */
public class Pgv00362 extends BaseVO implements Serializable {

	private static final long serialVersionUID = -6876090616949834614L;
	private Integer id;
	private String cd_00002_pssd;
	private String cd_00001_jzjglx;
	private String cd_00001_jzjg;
	private Double xzxs;
	private Integer czlx;
	private Timestamp upddate;
	private String cd_00002_czr;
	private String note;
	private Integer ywdt;
	private String jzjg;
	private String czr;
	
	
	
	
	private String cd_00001_fwlxlx;
	private String cd_00001_fwlx;
	public String getXqdmhm() {
		return xqdmhm;
	}
	public void setXqdmhm(String xqdmhm) {
		this.xqdmhm = xqdmhm;
	}
	private String fwlx;
	private String ssgx;
	private String cd_00001_szqylx;
	private String cd_00001_szqy;
	private String szqy;
	private Integer outFlag;
	private ArrayList<Pgv00362> outList;
	private String impErrorMsg;
	private String cd00352Xqdm;
	private String xqnm;
	private String dmh;
	private String dmhId;
	private String xqdmhm;
	
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCd_00002_pssd() {
		return cd_00002_pssd;
	}
	public void setCd_00002_pssd(String cd_00002Pssd) {
		cd_00002_pssd = cd_00002Pssd;
	}
	public String getCd_00001_jzjglx() {
		return cd_00001_jzjglx;
	}
	public void setCd_00001_jzjglx(String cd_00001Jzjglx) {
		cd_00001_jzjglx = cd_00001Jzjglx;
	}
	public String getCd_00001_jzjg() {
		return cd_00001_jzjg;
	}
	public void setCd_00001_jzjg(String cd_00001Jzjg) {
		cd_00001_jzjg = cd_00001Jzjg;
	}
	public Double getXzxs() {
		return xzxs;
	}
	public void setXzxs(Double xzxs) {
		this.xzxs = xzxs;
	}
	public Integer getCzlx() {
		return czlx;
	}
	public void setCzlx(Integer czlx) {
		this.czlx = czlx;
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
	public Integer getYwdt() {
		return ywdt;
	}
	public void setYwdt(Integer ywdt) {
		this.ywdt = ywdt;
	}
	
	public String getJzjg() {
		return jzjg;
	}
	public void setJzjg(String jzjg) {
		this.jzjg = jzjg;
	}
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	public String getCd_00001_fwlxlx() {
		return cd_00001_fwlxlx;
	}
	public void setCd_00001_fwlxlx(String cd_00001Fwlxlx) {
		cd_00001_fwlxlx = cd_00001Fwlxlx;
	}
	public String getCd_00001_fwlx() {
		return cd_00001_fwlx;
	}
	public void setCd_00001_fwlx(String cd_00001Fwlx) {
		cd_00001_fwlx = cd_00001Fwlx;
	}
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	public String getSsgx() {
		return ssgx;
	}
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
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
	public String getCd_00001_szqylx() {
		return cd_00001_szqylx;
	}
	public void setCd_00001_szqylx(String cd_00001Szqylx) {
		cd_00001_szqylx = cd_00001Szqylx;
	}
	public String getSzqy() {
		return szqy;
	}
	public void setSzqy(String szqy) {
		this.szqy = szqy;
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
	public ArrayList<Pgv00362> getOutList() {
		return outList;
	}
	/**
	 * @param outList the outList to set
	 */
	public void setOutList(ArrayList<Pgv00362> outList) {
		this.outList = outList;
	}
	public String getImpErrorMsg() {
		return impErrorMsg;
	}
	public void setImpErrorMsg(String impErrorMsg) {
		this.impErrorMsg = impErrorMsg;
	}
	public String getDmh() {
		return dmh;
	}
	public void setDmh(String dmh) {
		this.dmh = dmh;
	}
	public String getDmhId() {
		return dmhId;
	}
	public void setDmhId(String dmhId) {
		this.dmhId = dmhId;
	}

}
