/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;

/**
 * 
 * 实体：收益法商品房房屋信息综合修正
 * @author Andy
 *
 */
public class Pgt02002c implements Serializable {
	private static final long serialVersionUID = -73783341949989051L;
	
	private String cd02002Fcid;
	private String cd00001Root;
	private String cd00001InfoId;
	private String cd00001Szqy;
	private String cd00001Fwlx;
	private String cd02050Xqdm;
	
	private boolean isDir;
	private boolean isId;
	private boolean isMr;
	private String parentId;
	private String cd00053Qtxzid;
	private String qtxznm;
	
	public Pgt02002c() {};
	
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
	 * @return the cd00001Root
	 */
	public String getCd00001Root() {
		return cd00001Root;
	}
	/**
	 * @param cd00001Root the cd00001Root to set
	 */
	public void setCd00001Root(String cd00001Root) {
		this.cd00001Root = cd00001Root;
	}
	/**
	 * @return the cd00001InfoId
	 */
	public String getCd00001InfoId() {
		return cd00001InfoId;
	}
	/**
	 * @param cd00001InfoId the cd00001InfoId to set
	 */
	public void setCd00001InfoId(String cd00001InfoId) {
		this.cd00001InfoId = cd00001InfoId;
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
	 * @return the cd00001Fwlx
	 */
	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}

	/**
	 * @param cd00001Fwlx the cd00001Fwlx to set
	 */
	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}

	/**
	 * @return the cd02050Xqdm
	 */
	public String getCd02050Xqdm() {
		return cd02050Xqdm;
	}

	/**
	 * @param cd02050Xqdm the cd02050Xqdm to set
	 */
	public void setCd02050Xqdm(String cd02050Xqdm) {
		this.cd02050Xqdm = cd02050Xqdm;
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
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
	 * @return the isDir
	 */
	public boolean getIsDir() {
		return isDir;
	}

	/**
	 * @param isDir the isDir to set
	 */
	public void setIsDir(boolean isDir) {
		this.isDir = isDir;
	}

	/**
	 * @return the isId
	 */
	public boolean getIsId() {
		return isId;
	}

	/**
	 * @param isId the isId to set
	 */
	public void setIsId(boolean isId) {
		this.isId = isId;
	}

	public String getQtxznm() {
		return qtxznm;
	}

	public void setQtxznm(String qtxznm) {
		this.qtxznm = qtxznm;
	}

	public boolean getIsMr() {
		return isMr;
	}

	public void setIsMr(boolean isMr) {
		this.isMr = isMr;
	}
	

}
