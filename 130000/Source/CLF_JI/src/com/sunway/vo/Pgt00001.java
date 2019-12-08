package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgtInfo entity. @author MyEclipse Persistence Tools
 */

public class Pgt00001 implements java.io.Serializable {

	private static final long serialVersionUID = -1019264161095465166L;
	private String rootid;
	private String infoid;
	private String noinfoid;
	private String parentid;
	private String infonm;
	private Timestamp upddate;
	private Long vieworder;
	private Boolean sysfield;
    private String cd00002Czr;
    private String note;
    private Boolean isdir;
    private String cd00001Ssgx;
    private String level;
    private String cd00001Szqy;
    private String parentnm;
    private String cd00001Fwlx;
	// Constructors
	
	/** default constructor */
	public Pgt00001() {
	}

	/** full constructor */
	public Pgt00001(String rootid, String infoid, String parentid, String infonm,
			Timestamp upddate, Long vieworder, Boolean sysfield, String cd00002Czr) {
		this.rootid = rootid;
		this.infoid = infoid;
		this.parentid = parentid;
		this.infonm = infonm;
		this.upddate = upddate;
		this.vieworder = vieworder;
		this.sysfield = sysfield;
		this.cd00002Czr = cd00002Czr;
	}

	// Property accessors
	
	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getInfonm() {
		return this.infonm;
	}

	public void setInfonm(String infonm) {
		this.infonm = infonm;
	}

	public Timestamp getUpddate() {
		return this.upddate;
	}

	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}

	public Long getVieworder() {
		return this.vieworder;
	}

	public void setVieworder(Long vieworder) {
		this.vieworder = vieworder;
	}

	public Boolean getSysfield() {
		return this.sysfield;
	}

	public void setSysfield(Boolean sysfield) {
		this.sysfield = sysfield;
	}

	/**
	 * @return the rootid
	 */
	public String getRootid() {
		return rootid;
	}

	/**
	 * @param rootid the rootid to set
	 */
	public void setRootid(String rootid) {
		this.rootid = rootid;
	}

	/**
	 * @return the infoid
	 */
	public String getInfoid() {
		return infoid;
	}

	/**
	 * @param infoid the infoid to set
	 */
	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the noinfoid
	 */
	public String getNoinfoid() {
		return noinfoid;
	}

	/**
	 * @param noinfoid the noinfoid to set
	 */
	public void setNoinfoid(String noinfoid) {
		this.noinfoid = noinfoid;
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
	 * @return the cd00001Ssgx
	 */
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}

	/**
	 * @param cd00001Ssgx the cd00001Ssgx to set
	 */
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}

	/**
	 * @return the isdir
	 */
	public Boolean getIsdir() {
		return isdir;
	}

	/**
	 * @param isdir the isdir to set
	 */
	public void setIsdir(Boolean isdir) {
		this.isdir = isdir;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
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
	 * @return the parentnm
	 */
	public String getParentnm() {
		return parentnm;
	}

	/**
	 * @param parentnm the parentnm to set
	 */
	public void setParentnm(String parentnm) {
		this.parentnm = parentnm;
	}

	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}

	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}

}