package com.sunway.vo;

import java.util.Date;

/**
 * Pgt00352f entity. @author MyEclipse Persistence Tools
 */


public class Pgt00352f implements java.io.Serializable {

	private static final long serialVersionUID = 707104123932782046L;

	private String zpid;

	private Integer zplx;
	private String zplj;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String sysSsgx;
	private String zpljMin;
	private String cd00352Xqdm;
	private String zpLjdownLoad;
	private String srcPhotoPath;
	private String srcPhotoName;
	private String fileSavePath;
	private String shortFileName;
	private String viewFileName;
	private String photoXQDM;
	private String shortFilePath;
	private String srcShortFilePath;
	private String viewFilePath;
	private String srcViewFilePath;
	private String srcFilePath;
	private Integer zplxSign;
	/**
	 * 用于将复制文件与源文件对应，便于删除源文件
	 */
	private String isFilePath;	       
	
	// Constructors

	/** default constructor */
	public Pgt00352f() {
	}

	/** minimal constructor */
	public Pgt00352f(String zpid, Integer zplx,	Date upddate, String cd00002Czr) {
		this.zpid = zpid;
		this.zplx = zplx;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
	}

	/** full constructor */
	public Pgt00352f(String zpid, Integer zplx, String zplj, Date upddate, String cd00002Czr, String note) {
		this.zpid = zpid;
		this.zplx = zplx;
		this.zplj = zplj;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	// Property accessors

	public String getZpid() {
		return this.zpid;
	}

	public void setZpid(String zpid) {
		this.zpid = zpid;
	}

	public Integer getZplx() {
		return this.zplx;
	}

	public void setZplx(Integer zplx) {
		this.zplx = zplx;
	}

	public String getZplj() {
		return this.zplj;
	}

	public void setZplj(String zplj) {
		this.zplj = zplj;
	}

	public Date getUpddate() {
		return this.upddate;
	}

	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}

	public String getCd00002Czr() {
		return this.cd00002Czr;
	}

	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	

	/**
	 * @param sysSsgx the sysSsgx to set
	 */
	public void setSysSsgx(String sysSsgx) {
		this.sysSsgx = sysSsgx;
	}

	/**
	 * @return the sysSsgx
	 */
	public String getSysSsgx() {
		return sysSsgx;
	}

	/**
	 * @param zpljMin the zpljMin to set
	 */
	public void setZpljMin(String zpljMin) {
		this.zpljMin = zpljMin;
	}

	/**
	 * @return the zpljMin
	 */
	public String getZpljMin() {
		return zpljMin;
	}

	public String getCd00352Xqdm() {
		return cd00352Xqdm;
	}

	public void setCd00352Xqdm(String cd00352Xqdm) {
		this.cd00352Xqdm = cd00352Xqdm;
	}

	public String getZpLjdownLoad() {
		return zpLjdownLoad;
	}

	public void setZpLjdownLoad(String zpLjDownLoad) {
		zpLjdownLoad = zpLjDownLoad;
	}

	

	public String getSrcPhotoPath() {
		return srcPhotoPath;
	}

	public void setSrcPhotoPath(String srcPhotoPath) {
		this.srcPhotoPath = srcPhotoPath;
	}

	public String getSrcPhotoName() {
		return srcPhotoName;
	}

	public void setSrcPhotoName(String srcPhotoName) {
		this.srcPhotoName = srcPhotoName;
	}

	public String getFileSavePath() {
		return fileSavePath;
	}

	public void setFileSavePath(String fileSavePath) {
		this.fileSavePath = fileSavePath;
	}

	public String getShortFileName() {
		return shortFileName;
	}

	public void setShortFileName(String shortFileName) {
		this.shortFileName = shortFileName;
	}

	public String getViewFileName() {
		return viewFileName;
	}

	public void setViewFileName(String viewFileName) {
		this.viewFileName = viewFileName;
	}

	public String getPhotoXQDM() {
		return photoXQDM;
	}

	public void setPhotoXQDM(String photoXQDM) {
		this.photoXQDM = photoXQDM;
	}

	public String getViewFilePath() {
		return viewFilePath;
	}

	public void setViewFilePath(String viewFilePath) {
		this.viewFilePath = viewFilePath;
	}

	public String getShortFilePath() {
		return shortFilePath;
	}

	public void setShortFilePath(String shortFilePath) {
		this.shortFilePath = shortFilePath;
	}

	public String getSrcShortFilePath() {
		return srcShortFilePath;
	}

	public void setSrcShortFilePath(String srcShortFilePath) {
		this.srcShortFilePath = srcShortFilePath;
	}

	public String getSrcViewFilePath() {
		return srcViewFilePath;
	}

	public void setSrcViewFilePath(String srcViewFilePath) {
		this.srcViewFilePath = srcViewFilePath;
	}

	public String getSrcFilePath() {
		return srcFilePath;
	}

	public void setSrcFilePath(String srcFilePath) {
		this.srcFilePath = srcFilePath;
	}

	public Integer getZplxSign() {
		return zplxSign;
	}

	public void setZplxSign(Integer zplxSign) {
		this.zplxSign = zplxSign;
	}

	public String getIsFilePath() {
		return isFilePath;
	}

	public void setIsFilePath(String isFilePath) {
		this.isFilePath = isFilePath;
	}





}