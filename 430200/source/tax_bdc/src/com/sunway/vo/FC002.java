/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 完税信息
 * @author amani
 */
public class FC002 implements Serializable {
	private static final long serialVersionUID = 6448331736430962066L;

	private FC001_PK id;

	private Double seQs;
	private Double seYys;
	private Double seCjs;
	private Double seDfjys;
	private Double seGrsds;
	private Double seYhs;
	private Double seTdzzs;
	private String fphm;
	private String qssphm;
	private String dfgssphm;
	private Date updatetime;
	private String pgid;
	private Double pgjg;
	private String note;
	
	//=============== setter and getter =====================
	
	/**
	 * @return the id
	 */
	public FC001_PK getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(FC001_PK id) {
		this.id = id;
	}
	/**
	 * @return the seQs
	 */
	public Double getSeQs() {
		return seQs;
	}
	/**
	 * @param seQs the seQs to set
	 */
	public void setSeQs(Double seQs) {
		this.seQs = seQs;
	}
	/**
	 * @return the seYys
	 */
	public Double getSeYys() {
		return seYys;
	}
	/**
	 * @param seYys the seYys to set
	 */
	public void setSeYys(Double seYys) {
		this.seYys = seYys;
	}
	/**
	 * @return the seCjs
	 */
	public Double getSeCjs() {
		return seCjs;
	}
	/**
	 * @param seCjs the seCjs to set
	 */
	public void setSeCjs(Double seCjs) {
		this.seCjs = seCjs;
	}
	/**
	 * @return the seDfjys
	 */
	public Double getSeDfjys() {
		return seDfjys;
	}
	/**
	 * @param seDfjys the seDfjys to set
	 */
	public void setSeDfjys(Double seDfjys) {
		this.seDfjys = seDfjys;
	}
	/**
	 * @return the seGrsds
	 */
	public Double getSeGrsds() {
		return seGrsds;
	}
	/**
	 * @param seGrsds the seGrsds to set
	 */
	public void setSeGrsds(Double seGrsds) {
		this.seGrsds = seGrsds;
	}
	/**
	 * @return the seYhs
	 */
	public Double getSeYhs() {
		return seYhs;
	}
	/**
	 * @param seYhs the seYhs to set
	 */
	public void setSeYhs(Double seYhs) {
		this.seYhs = seYhs;
	}
	/**
	 * @return the seTdzzs
	 */
	public Double getSeTdzzs() {
		return seTdzzs;
	}
	/**
	 * @param seTdzzs the seTdzzs to set
	 */
	public void setSeTdzzs(Double seTdzzs) {
		this.seTdzzs = seTdzzs;
	}
	/**
	 * @return the fphm
	 */
	public String getFphm() {
		return fphm;
	}
	/**
	 * @param fphm the fphm to set
	 */
	public void setFphm(String fphm) {
		this.fphm = fphm;
	}
	/**
	 * @return the qssphm
	 */
	public String getQssphm() {
		return qssphm;
	}
	/**
	 * @param qssphm the qssphm to set
	 */
	public void setQssphm(String qssphm) {
		this.qssphm = qssphm;
	}
	/**
	 * @return the dfgssphm
	 */
	public String getDfgssphm() {
		return dfgssphm;
	}
	/**
	 * @param dfgssphm the dfgssphm to set
	 */
	public void setDfgssphm(String dfgssphm) {
		this.dfgssphm = dfgssphm;
	}
	/**
	 * @return the updatetime
	 */
	public Date getUpdatetime() {
		return updatetime;
	}
	/**
	 * @param updatetime the updatetime to set
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	/**
	 * @return the pgid
	 */
	public String getPgid() {
		return pgid;
	}
	/**
	 * @param pgid the pgid to set
	 */
	public void setPgid(String pgid) {
		this.pgid = pgid;
	}
	/**
	 * @return the pgjg
	 */
	public Double getPgjg() {
		return pgjg;
	}
	/**
	 * @param pgjg the pgjg to set
	 */
	public void setPgjg(Double pgjg) {
		this.pgjg = pgjg;
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
	
}
