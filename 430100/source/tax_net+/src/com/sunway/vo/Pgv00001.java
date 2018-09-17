package com.sunway.vo;

import java.sql.Timestamp;

/**
 * PgvInfoId entity. 
 * @author Lee
 */

public class Pgv00001 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 672723776368374325L;
	private String rootid;
	private String parentid;
	private String parentnm;
	private String infoid;
	private String infonm;
	private Timestamp upddate;
	private Long vieworder;
	private Boolean sysfield;
	private String rootnm;
    private String cd00002Czr;    
    
        
    
        
    private String note;
    private String czr;
    private Boolean isdir;
    private String cd00001Ssgx;

	// Constructors

	/** default constructor */
	public Pgv00001() {
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
	 * @return the parentid
	 */
	public String getParentid() {
		return parentid;
	}

	/**
	 * @param parentid the parentid to set
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
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
	 * @return the upddate
	 */
	public Timestamp getUpddate() {
		return upddate;
	}

	/**
	 * @param upddate the upddate to set
	 */
	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}

	/**
	 * @return the vieworder
	 */
	public Long getVieworder() {
		return vieworder;
	}

	/**
	 * @param vieworder the vieworder to set
	 */
	public void setVieworder(Long vieworder) {
		this.vieworder = vieworder;
	}

	/**
	 * @return the sysfield
	 */
	public Boolean getSysfield() {
		return sysfield;
	}

	/**
	 * @param sysfield the sysfield to set
	 */
	public void setSysfield(Boolean sysfield) {
		this.sysfield = sysfield;
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
}