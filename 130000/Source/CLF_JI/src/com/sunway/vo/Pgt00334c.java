/**
 *
 */
package com.sunway.vo;

/**
 * @author Andy.Gao
 *
 */

public class Pgt00334c implements java.io.Serializable {

	private static final long serialVersionUID = 7054805927379444090L;
	private String cd00302Fcid;
	private String cdSlid;
	private String cd00001Rootid;
	private String rootnm;
	private String infonm;
	private Double xzxs;
	private Integer czlx;

	public Pgt00334c() {}	

	public Pgt00334c(String cd00302Fcid, String cdSlid) {
		this.cd00302Fcid = cd00302Fcid;
		this.cdSlid = cdSlid;
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
