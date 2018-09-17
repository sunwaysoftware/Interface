package com.sunway.vo;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * PgvSClcxz entity. 
 * @author Lee
 */

@SuppressWarnings("serial")
public class Pgv02052 extends BaseVO implements java.io.Serializable {

	// Fields
	private String id;
	private String lc;
	private String zcs;
	private String cd00001Szqylx;
	private String cd00001Szqy;
	private Double xzxs;
	private String cd00002Czr;
	private String note;
	private String dmh;
	private String dmhId;

	private String szqy;
	private String czr;
	private Timestamp upddate;
	private String cd00001Ssgx;
	
        
    
    
    private Integer czlx;
    private String cd00001Fwlxlx;
	private String cd00001Fwlx;
	private String fwlx;
	private String cd02050Xqdm;
	private ArrayList<Pgv02052> OutList;
	private Integer OutFlag;
	private String xqnm;
	private String xqdmhm;
	


	private String impErrorMsg;
	// Constructors

	public String getCd02050Xqdm() {
		return cd02050Xqdm;
	}

	public void setCd02050Xqdm(String cd02050Xqdm) {
		this.cd02050Xqdm = cd02050Xqdm;
	}

	/** default constructor */
	public Pgv02052() {
	}


//	public String getLc() {
//		return lc;
//	}
//
//	public void setLc(String lc) {
//		this.lc = lc;
//	}

	public String getZcs() {
		return zcs;
	}

	public void setZcs(String zcs) {
		this.zcs = zcs;
	}

	/**
	 * @return the cd00001Szqylx
	 */
	public String getCd00001Szqylx() {
		return cd00001Szqylx;
	}

	/**
	 * @param cd00001Szqylx the cd00001Szqylx to set
	 */
	public void setCd00001Szqylx(String cd00001Szqylx) {
		this.cd00001Szqylx = cd00001Szqylx;
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
	 * @return the xzxs
	 */
	public Double getXzxs() {
		return xzxs;
	}

	/**
	 * @param xzxs the xzxs to set
	 */
	public void setXzxs(Double xzxs) {
		this.xzxs = xzxs;
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
	 * @param czlx the czlx to set
	 */
	public void setCzlx(Integer czlx) {
		this.czlx = czlx;
	}

	/**
	 * @return the czlx
	 */
	public Integer getCzlx() {
		return czlx;
	}

	/**
	 * @return the cd00001Fwlxlx
	 */
	public String getCd00001Fwlxlx() {
		return cd00001Fwlxlx;
	}

	/**
	 * @param cd00001Fwlxlx the cd00001Fwlxlx to set
	 */
	public void setCd00001Fwlxlx(String cd00001Fwlxlx) {
		this.cd00001Fwlxlx = cd00001Fwlxlx;
	}

	/**
	 * @return the cd00001Fwlx
	 */
	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}

	/**
	 * @param cd00001Fwlx the cd00001Fwlx to set
	 */
	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}

	/**
	 * @return the fwlx
	 */
	public String getFwlx() {
		return fwlx;
	}

	/**
	 * @param fwlx the fwlx to set
	 */
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}



	public ArrayList<Pgv02052> getOutList() {
		return OutList;
	}

	public void setOutList(ArrayList<Pgv02052> outList) {
		OutList = outList;
	}

	public Integer getOutFlag() {
		return OutFlag;
	}

	public void setOutFlag(Integer outFlag) {
		OutFlag = outFlag;
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
	
	public String getXqdmhm() {
		return xqdmhm;
	}

	public void setXqdmhm(String xqdmhm) {
		this.xqdmhm = xqdmhm;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	
	public String getLc() {
		return lc;
	}

	public void setLc(String lc) {
		this.lc = lc;
	}
	
}