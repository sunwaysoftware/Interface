/**
 *
 */
package com.sunway.vo;

/**
 * @author Andy.Gao
 *
 */

public class Pgt02034c implements java.io.Serializable {

	private static final long serialVersionUID = 7054805927379444090L;
	private String cd02002Fcid;
	private String cdSlid;
	private String cd00001Rootid;
	private String rootnm;
	private String infonm;
	private Double xzxs;
	private Integer czlx;

	public Pgt02034c() {}	

	public Pgt02034c(String cd02002Fcid, String cdSlid) {
		this.cd02002Fcid = cd02002Fcid;
		this.cdSlid = cdSlid;
	}
	
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
	 * @return the cdSlid
	 */
	public String getCdSlid() {
		return cdSlid;
	}
	/**
	 * @param cdSlid the cdSlid to set
	 */
	public void setCdSlid(String cdSlid) {
		this.cdSlid = cdSlid;
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
	public Double getXzxs() {
		return xzxs;
	}
	/**
	 * @param xzxs the xzxs to set
	 */
	public void setXzxs(Double xzxs) {
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
