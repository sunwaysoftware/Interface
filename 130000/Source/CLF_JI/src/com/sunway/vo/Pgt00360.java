/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @author Andy
 *
 */

public class Pgt00360 implements Serializable {

	private static final long serialVersionUID = -7820371517606485560L;
	private String id;				//流水号
	private String cd00002Pssd;		//评税时点
	private String cd00001Szqy;		//所在区域
	private String cd00001Fwlx;		//房屋类型
	private BigDecimal jzmjMin;		//面积下限
	private BigDecimal jzmjMax;		//面积上限
	private BigDecimal xzxs;		//建筑面积修正
	private Timestamp upddate;			//更改时间
	private String cd00002Czr;		//操作人字段
	private String note;			//备注信息
	private String szqy;
	private String fwlx;
	private String czr;
	private Integer recordCount;
	private Integer recordIndex;
	private Integer pageIndex;
	private Integer pageSize;
	private String spssd;
	private String tpssd;
	private String cd00001Ssgx;
	private String ssgx;
	private ArrayList<Pgt00360> selfList;
	private Boolean outFlag;
	private String impErrorMsg;
	
	public Pgt00360() {}
	
	/**
	 * @param id
	 */
	public Pgt00360(String id) {
		this.id = id;
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
	 * @return the jzmjMin
	 */
	public BigDecimal getJzmjMin() {
		return jzmjMin;
	}
	/**
	 * @param jzmjMin the jzmjMin to set
	 */
	public void setJzmjMin(BigDecimal jzmjMin) {
		this.jzmjMin = jzmjMin;
	}
	/**
	 * @return the jzmjMax
	 */
	public BigDecimal getJzmjMax() {
		return jzmjMax;
	}
	/**
	 * @param jzmjMax the jzmjMax to set
	 */
	public void setJzmjMax(BigDecimal jzmjMax) {
		this.jzmjMax = jzmjMax;
	}
	/**
	 * @return the xzxs
	 */
	public BigDecimal getXzxs() {
		return xzxs;
	}
	/**
	 * @param xzxs the xzxs to set
	 */
	public void setXzxs(BigDecimal xzxs) {
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
	 * @param upddate the upddate to set
	 */
	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}

	/**
	 * @return the upddate
	 */
	public Timestamp getUpddate() {
		return upddate;
	}

	/**
	 * @return the spssd
	 */
	public String getSpssd() {
		return spssd;
	}

	/**
	 * @param spssd the spssd to set
	 */
	public void setSpssd(String spssd) {
		this.spssd = spssd;
	}

	/**
	 * @return the tpssd
	 */
	public String getTpssd() {
		return tpssd;
	}

	/**
	 * @param tpssd the tpssd to set
	 */
	public void setTpssd(String tpssd) {
		this.tpssd = tpssd;
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
	 * @return the selfList
	 */
	public ArrayList<Pgt00360> getSelfList() {
		return selfList;
	}

	/**
	 * @param selfList the selfList to set
	 */
	public void setSelfList(ArrayList<Pgt00360> selfList) {
		this.selfList = selfList;
	}

	/**
	 * @return the outFlag
	 */
	public Boolean getOutFlag() {
		return outFlag;
	}

	/**
	 * @param outFlag the outFlag to set
	 */
	public void setOutFlag(Boolean outFlag) {
		this.outFlag = outFlag;
	}

	/**
	 * @return the impErrorMsg
	 */
	public String getImpErrorMsg() {
		return impErrorMsg;
	}

	/**
	 * @param impErrorMsg the impErrorMsg to set
	 */
	public void setImpErrorMsg(String impErrorMsg) {
		this.impErrorMsg = impErrorMsg;
	}
}
