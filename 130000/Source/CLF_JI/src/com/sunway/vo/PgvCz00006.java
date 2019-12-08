/**
 * 
 */
package com.sunway.vo;

/**
 * 
 * 返回变更类型
 * @author Andy.Gao
 *
 */

public class PgvCz00006 implements java.io.Serializable {

	private static final long serialVersionUID = -7892258478191183606L;
	private Integer bglx;
	private String bgmc;
	
	public PgvCz00006() {
	}

	/**
	 * @param bglx
	 * @param bgmc
	 */
	public PgvCz00006(Integer bglx, String bgmc) {
		super();
		this.bglx = bglx;
		this.bgmc = bgmc;
	}

	/**
	 * @return the bglx
	 */
	public Integer getBglx() {
		return bglx;
	}

	/**
	 * @param bglx the bglx to set
	 */
	public void setBglx(Integer bglx) {
		this.bglx = bglx;
	}

	/**
	 * @return the bgmc
	 */
	public String getBgmc() {
		return bgmc;
	}

	/**
	 * @param bgmc the bgmc to set
	 */
	public void setBgmc(String bgmc) {
		this.bgmc = bgmc;
	}
}
