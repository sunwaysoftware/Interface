package com.sunway.vo;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Pgv00352 entity.
 * @author Lee
 *
 */

public class Pgv00352 implements java.io.Serializable {

	private static final long serialVersionUID = -1872144664673957344L;
	private String xqdm;
	private String cd00001Szqylx;
	private String cd00001Szqy;
	private String parentdm;
	private String xqnm;
	private String xqbm;
	private Short vieworder;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private Boolean isdir;
	private String szqy;
	private String czr;
	private String ssgx;
	private Integer recordCount;
	private Integer recordIndex;
	private Integer pageIndex;
	private Integer pageSize;
	private String parentnm;
	private Integer outFlag;
    private ArrayList<Pgv00352> outList;
    private Byte xqzt;
    private String xqdmh;
    
    public Pgv00352(){
    	outList = new ArrayList<Pgv00352>();
    }
	/**
	 * @return the xqdm
	 */
	public String getXqdm() {
		return xqdm;
	}
	/**
	 * @param xqdm the xqdm to set
	 */
	public void setXqdm(String xqdm) {
		this.xqdm = xqdm;
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
	 * @return the parentdm
	 */
	public String getParentdm() {
		return parentdm;
	}
	/**
	 * @param parentdm the parentdm to set
	 */
	public void setParentdm(String parentdm) {
		this.parentdm = parentdm;
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
	 * @return the vieworder
	 */
	public Short getVieworder() {
		return vieworder;
	}
	/**
	 * @param vieworder the vieworder to set
	 */
	public void setVieworder(Short vieworder) {
		this.vieworder = vieworder;
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
	 * @return the isdir
	 */
	public Boolean getIsdir() {
		return isdir;
	}
	/**
	 * @param isdir the isdir to set
	 */
	public void setIsdir(Boolean isdir) {
		this.isdir = isdir;
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
	 * @return the parentnm
	 */
	public String getParentnm() {
		return parentnm;
	}
	/**
	 * @param parentnm the parentnm to set
	 */
	public void setParentnm(String parentnm) {
		this.parentnm = parentnm;
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
	public ArrayList<Pgv00352> getOutList() {
		return outList;
	}
	/**
	 * @param outList the outList to set
	 */
	public void setOutList(ArrayList<Pgv00352> outList) {
		this.outList = outList;
	}
	/**
	 * @return the xqzt
	 */
	public Byte getXqzt() {
		return xqzt;
	}
	/**
	 * @param xqzt the xqzt to set
	 */
	public void setXqzt(Byte xqzt) {
		this.xqzt = xqzt;
	}
	public String getXqdmh() {
		return xqdmh;
	}
	public void setXqdmh(String xqdmh) {
		this.xqdmh = xqdmh;
	}

	
}
