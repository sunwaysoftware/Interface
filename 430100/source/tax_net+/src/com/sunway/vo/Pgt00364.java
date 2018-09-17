package com.sunway.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Pgt00364 extends BaseVO implements Serializable {

	private static final long serialVersionUID = -2217920807551640131L;
	private String cd00001Szqy;		//所在区域
	private BigDecimal xzxs;		//建筑面积修正
	private BigDecimal pgxzxs;		//建筑面积修正
	private Timestamp upddate;			//更改时间
	private String cd00002Czr;		//操作人字段
	private String note;			//备注信息
	private String szqy;
	private String czr;
	
	
	
	
	private String cd00001Ssgx;
	private String cd00352Xqdm;
	private String xqnm;
	public String getXqnm() {
		return xqnm;
	}

	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}



	public String getCd00352Xqdm() {
		return cd00352Xqdm;
	}

	public void setCd00352Xqdm(String cd00352Xqdm) {
		this.cd00352Xqdm = cd00352Xqdm;
	}

	public Pgt00364() {}
	
	public Pgt00364(String cd00352Xqdm) {		
		this.cd00352Xqdm = cd00352Xqdm;
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

	public BigDecimal getPgxzxs() {
		return pgxzxs;
	}

	public void setPgxzxs(BigDecimal pgxzxs) {
		this.pgxzxs = pgxzxs;
	}
	


}
