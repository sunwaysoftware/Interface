/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Andy.Gao
 *
 */

public class Pgt00331a implements Serializable {

	private static final long serialVersionUID = -3384085281703619975L;
	private String cd00302Fcid;
	private String cd00002Pssd;
	private String cd00053Qtxzid;
	private Double cd00053Qtxz;
	private Date upddate;
	private String cd00002Czr;
	private String qtxzNm;
	private String czr;
	private Integer czlx;

	public Pgt00331a() {}

	public Pgt00331a(String cd00302Fcid) {
		this.cd00302Fcid = cd00302Fcid;
	}
	
	public Pgt00331a(String cd00302Fcid, String cd00002Pssd,
			String cd00053Qtxzid, Double cd00053Qtxz, Date upddate,
			String cd00002Czr, String qtxzNm, String czr, Integer czlx) {
		this.cd00302Fcid = cd00302Fcid;
		this.cd00002Pssd = cd00002Pssd;
		this.cd00053Qtxzid = cd00053Qtxzid;
		this.cd00053Qtxz = cd00053Qtxz;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.qtxzNm = qtxzNm;
		this.czr = czr;
		this.czlx = czlx;
	}
	
	/**
	 * @return the cd00302Fcid
	 */
	public String getCd00302Fcid() {
		return cd00302Fcid;
	}
	/**
	 * @param cd00302Fcid the cd00302Fcid to set
	 */
	public void setCd00302Fcid(String cd00302Fcid) {
		this.cd00302Fcid = cd00302Fcid;
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
	 * @return the cd00053Qtxzid
	 */
	public String getCd00053Qtxzid() {
		return cd00053Qtxzid;
	}
	/**
	 * @param cd00053Qtxzid the cd00053Qtxzid to set
	 */
	public void setCd00053Qtxzid(String cd00053Qtxzid) {
		this.cd00053Qtxzid = cd00053Qtxzid;
	}
	/**
	 * @return the cd00053Qtxz
	 */
	public Double getCd00053Qtxz() {
		return cd00053Qtxz;
	}
	/**
	 * @param cd00053Qtxz the cd00053Qtxz to set
	 */
	public void setCd00053Qtxz(Double cd00053Qtxz) {
		this.cd00053Qtxz = cd00053Qtxz;
	}
	/**
	 * @return the upddate
	 */
	public Date getUpddate() {
		return upddate;
	}
	/**
	 * @param upddate the upddate to set
	 */
	public void setUpddate(Date upddate) {
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
	 * @return the qtxzNm
	 */
	public String getQtxzNm() {
		return qtxzNm;
	}
	/**
	 * @param qtxzNm the qtxzNm to set
	 */
	public void setQtxzNm(String qtxzNm) {
		this.qtxzNm = qtxzNm;
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
	 * @return the czlx
	 */
	public Integer getCzlx() {
		return czlx;
	}
	/**
	 * @param czlx the czlx to set
	 */
	public void setCzlx(Integer czlx) {
		this.czlx = czlx;
	}
	
}
