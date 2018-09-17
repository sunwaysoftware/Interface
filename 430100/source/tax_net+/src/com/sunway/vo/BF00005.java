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
public class BF00005 implements Serializable {
	
	private static final long serialVersionUID = 1998717787943782912L;
	private Date jysjMin;
	private Date jysjMax;
	private Double pgzh;
	private Double gpgzh;
	private String ssgxId;
	
	/**
	 * @return the jysjMin
	 */
	public Date getJysjMin() {
		return jysjMin;
	}
	/**
	 * @param jysjMin the jysjMin to set
	 */
	public void setJysjMin(Date jysjMin) {
		this.jysjMin = jysjMin;
	}
	/**
	 * @return the jysjMax
	 */
	public Date getJysjMax() {
		return jysjMax;
	}
	/**
	 * @param jysjMax the jysjMax to set
	 */
	public void setJysjMax(Date jysjMax) {
		this.jysjMax = jysjMax;
	}
	/**
	 * @return the pgzh
	 */
	public Double getPgzh() {
		return pgzh;
	}
	/**
	 * @param pgzh the pgzh to set
	 */
	public void setPgzh(Double pgzh) {
		this.pgzh = pgzh;
	}
	/**
	 * @return the gpgzh
	 */
	public Double getGpgzh() {
		return gpgzh;
	}
	/**
	 * @param gpgzh the gpgzh to set
	 */
	public void setGpgzh(Double gpgzh) {
		this.gpgzh = gpgzh;
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
	
}
