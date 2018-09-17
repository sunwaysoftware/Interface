/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 
 * 商业：税额种类
 * @author Andy
 *
 */
public class Pgt02002f implements Serializable {
	private static final long serialVersionUID = 8364714989654512439L;

	private String cd02002Fcid;
	private String cd00001Szlx;
	private String cd00001Sz;
	private String cd00002Czr;
	private String infoid;
	private String sz;
	private String note;
	private Double yse;
	private Double mse;
	private Timestamp upddate;
	private String szVals;
	private String cd00001Ssgx;
	
	/**
	 * @return the cd02002Fcid
	 */
	public String getCd02002Fcid() {
		return cd02002Fcid;
	}
	/**
	 * @param cd02002Fcid the cd02002Fcid to set
	 */
	public void setCd02002Fcid(String cd02002Fcid) {
		this.cd02002Fcid = cd02002Fcid;
	}
	/**
	 * @return the cd00001Szlx
	 */
	public String getCd00001Szlx() {
		return cd00001Szlx;
	}
	/**
	 * @param cd00001Szlx the cd00001Szlx to set
	 */
	public void setCd00001Szlx(String cd00001Szlx) {
		this.cd00001Szlx = cd00001Szlx;
	}
	/**
	 * @return the cd00001Sz
	 */
	public String getCd00001Sz() {
		return cd00001Sz;
	}
	/**
	 * @param cd00001Sz the cd00001Sz to set
	 */
	public void setCd00001Sz(String cd00001Sz) {
		this.cd00001Sz = cd00001Sz;
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
	 * @return the infoid
	 */
	public String getInfoid() {
		return infoid;
	}
	/**
	 * @param infoid the infoid to set
	 */
	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}
	/**
	 * @return the sz
	 */
	public String getSz() {
		return sz;
	}
	/**
	 * @param sz the sz to set
	 */
	public void setSz(String sz) {
		this.sz = sz;
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
	 * @return the yse
	 */
	public Double getYse() {
		return yse;
	}
	/**
	 * @param yse the yse to set
	 */
	public void setYse(Double yse) {
		this.yse = yse;
	}
	/**
	 * @return the mse
	 */
	public Double getMse() {
		return mse;
	}
	/**
	 * @param mse the mse to set
	 */
	public void setMse(Double mse) {
		this.mse = mse;
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
	 * @return the szVals
	 */
	public String getSzVals() {
		return szVals;
	}
	/**
	 * @param szVals the szVals to set
	 */
	public void setSzVals(String szVals) {
		this.szVals = szVals;
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
}
