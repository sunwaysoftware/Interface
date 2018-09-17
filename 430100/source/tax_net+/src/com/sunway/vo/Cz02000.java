/**
 * 
 */
package com.sunway.vo;

import java.util.ArrayList;

/**
 * @author Andy.Gao
 *
 */

public class Cz02000 implements java.io.Serializable {

	private static final long serialVersionUID = 38483570183934209L;
	private Double ypfmjg;
	private ArrayList<Pgt02034a> xzList;
	private ArrayList<Pgt02034a> qtxzList;
	private Double pfmjg;
	private Double wjxz;
	
	/**
	 * @return the ypfmjg
	 */
	public Double getYpfmjg() {
		return ypfmjg;
	}
	
	/**
	 * @param ypfmjg the ypfmjg to set
	 */
	public void setYpfmjg(Double ypfmjg) {
		this.ypfmjg = ypfmjg;
	}
	
	/**
	 * @return the xzList
	 */
	public ArrayList<Pgt02034a> getXzList() {
		return xzList;
	}
	
	/**
	 * @param xzList the xzList to set
	 */
	public void setXzList(ArrayList<Pgt02034a> xzList) {
		this.xzList = xzList;
	}
	
	/**
	 * @return the qtxzList
	 */
	public ArrayList<Pgt02034a> getQtxzList() {
		return qtxzList;
	}
	
	/**
	 * @param qtxzList the qtxzList to set
	 */
	public void setQtxzList(ArrayList<Pgt02034a> qtxzList) {
		this.qtxzList = qtxzList;
	}

	/**
	 * @param pfmjg the pfmjg to set
	 */
	public void setPfmjg(Double pfmjg) {
		this.pfmjg = pfmjg;
	}

	/**
	 * @return the pfmjg
	 */
	public Double getPfmjg() {
		return pfmjg;
	}

	/**
	 * @param wjxz the wjxz to set
	 */
	public void setWjxz(Double wjxz) {
		this.wjxz = wjxz;
	}

	/**
	 * @return the wjxz
	 */
	public Double getWjxz() {
		return wjxz;
	}
	
}
