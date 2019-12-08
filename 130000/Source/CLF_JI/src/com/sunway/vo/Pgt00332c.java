/**
 *
 */
package com.sunway.vo;

import java.io.Serializable;

/**
 * @author Andy.Gao
 *
 */

public class Pgt00332c implements Serializable {

	private static final long serialVersionUID = -8398598786622633592L;
	private String cd00302Fcid;
	private String cd00001Rootid;
	private String rootnm;
	private String infonm;
	private Integer xzxs;
	private Integer czlx;

	public Pgt00332c() {
	}

	/**
	 * @param cd00302Fcid
	 */
	public Pgt00332c(String cd00302Fcid) {
		this.cd00302Fcid = cd00302Fcid;
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
	 * @return the cd00001Rootid
	 */
	public String getCd00001Rootid() {
		return cd00001Rootid;
	}
	/**
	 * @param cd00001Rootid the cd00001Rootid to set
	 */
	public void setCd00001Rootid(String cd00001Rootid) {
		this.cd00001Rootid = cd00001Rootid;
	}
	/**
	 * @return the rootnm
	 */
	public String getRootnm() {
		return rootnm;
	}
	/**
	 * @param rootnm the rootnm to set
	 */
	public void setRootnm(String rootnm) {
		this.rootnm = rootnm;
	}
	/**
	 * @return the infonm
	 */
	public String getInfonm() {
		return infonm;
	}
	/**
	 * @param infonm the infonm to set
	 */
	public void setInfonm(String infonm) {
		this.infonm = infonm;
	}
	/**
	 * @return the xzxs
	 */
	public Integer getXzxs() {
		return xzxs;
	}
	/**
	 * @param xzxs the xzxs to set
	 */
	public void setXzxs(Integer xzxs) {
		this.xzxs = xzxs;
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
