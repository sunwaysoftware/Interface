/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;

/**
 * @author Andy.Gao
 *
 */
public class BF00004 implements Serializable {

	private static final long serialVersionUID = -6218889471930801410L;
	//条件
	private Double jyjgMin;
	private Double jyjgMax;
	//结果
	private Integer bm;
	private String ssgxId;
	private String ssgxNm;
	private String pssd; 
	private Integer hs;
	private String czr;
	
	/**
	 * @return the bm
	 */
	public Integer getBm() {
		return bm;
	}
	/**
	 * @param bm the bm to set
	 */
	public void setBm(Integer bm) {
		this.bm = bm;
	}
	/**
	 * @return the ssgxId
	 */
	public String getSsgxId() {
		return ssgxId;
	}
	/**
	 * @param ssgxId the ssgxId to set
	 */
	public void setSsgxId(String ssgxId) {
		this.ssgxId = ssgxId;
	}
	/**
	 * @return the ssgxNm
	 */
	public String getSsgxNm() {
		return ssgxNm;
	}
	/**
	 * @param ssgxNm the ssgxNm to set
	 */
	public void setSsgxNm(String ssgxNm) {
		this.ssgxNm = ssgxNm;
	}
	/**
	 * @return the pssd
	 */
	public String getPssd() {
		return pssd;
	}
	/**
	 * @param pssd the pssd to set
	 */
	public void setPssd(String pssd) {
		this.pssd = pssd;
	}
	/**
	 * @return the hs
	 */
	public Integer getHs() {
		return hs;
	}
	/**
	 * @param hs the hs to set
	 */
	public void setHs(Integer hs) {
		this.hs = hs;
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
	 * @return the jyjgMin
	 */
	public Double getJyjgMin() {
		return jyjgMin;
	}
	/**
	 * @param jyjgMin the jyjgMin to set
	 */
	public void setJyjgMin(Double jyjgMin) {
		this.jyjgMin = jyjgMin;
	}
	/**
	 * @return the jyjgMax
	 */
	public Double getJyjgMax() {
		return jyjgMax;
	}
	/**
	 * @param jyjgMax the jyjgMax to set
	 */
	public void setJyjgMax(Double jyjgMax) {
		this.jyjgMax = jyjgMax;
	}
}
