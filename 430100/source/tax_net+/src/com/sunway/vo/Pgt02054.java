/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author Andy
 *
 */
@SuppressWarnings("serial")
public class Pgt02054 extends BaseVO implements Serializable {

	private String id;				//流水号
	private String cd00001Szqy;		//所在区域
	private BigDecimal mkMin;		//面宽下限
	private BigDecimal mkMax;		//面宽上限
	private BigDecimal xzxs;		//修正系数
	private Timestamp upddate;		//更改时间
	private String cd00002Czr;		//操作人字段
	private String note;			//备注信息
	private String szqy;
	private String czr;
	
	
	
	
	private String cd00001Fwlx;
	private String cd00001Fwlxlx;
	private String fwlx;
	private String cd00001Ssgx;
	private String ssgx;
	private String cd02050Xqdm;
	private String xqnm;
	public String getCd02050Xqdm() {
		return cd02050Xqdm;
	}

	public void setCd02050Xqdm(String cd02050Xqdm) {
		this.cd02050Xqdm = cd02050Xqdm;
	}

	public String getXqnm() {
		return xqnm;
	}

	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}

	private String chkDel;
	public Pgt02054() {}
	
	/**
	 * @param id
	 */
	public Pgt02054(String id) {
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
	 * @return the mkMin
	 */
	public BigDecimal getMkMin() {
		return mkMin;
	}
	/**
	 * @param mkMin the mkMin to set
	 */
	public void setMkMin(BigDecimal mkMin) {
		this.mkMin = mkMin;
	}
	/**
	 * @return the mkMax
	 */
	public BigDecimal getMkMax() {
		return mkMax;
	}
	/**
	 * @param mkMax the mkMax to set
	 */
	public void setMkMax(BigDecimal mkMax) {
		this.mkMax = mkMax;
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
	 * 
	 * @return the cd00001Fwlx 
	 */
	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}
	/**
	 * 
	 * @param cd00001Fwlx the cd00001Fwlx to set
	 */
	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}
	/**
	 * 
	 * @return the cd00001Fwlxlx
	 */
	public String getCd00001Fwlxlx() {
		return cd00001Fwlxlx;
	}
	/**
	 * 
	 * @param cd00001Fwlxlx the cd00001Fwlxlx to set
	 */
	public void setCd00001Fwlxlx(String cd00001Fwlxlx) {
		this.cd00001Fwlxlx = cd00001Fwlxlx;
	}

	public String getFwlx() {
		return fwlx;
	}

	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
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

	public String getChkDel() {
		return chkDel;
	}

	public void setChkDel(String chkDel) {
		this.chkDel = chkDel;
	}

}
