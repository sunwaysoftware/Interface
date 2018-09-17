package com.sunway.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * PgvSCwjzs entity. 
 * @author Lee
 */


public class Pgv00356 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = -136391775862819936L;
	private String cd00001Szqylx;
	private String cd00001Szqy;
	private String cd00002Pssd;
	private Date pssd;
	private Double xzxs;
	private String cd00002Czr;
	private String note;
	private String szqy;
	private String czr;
	private Timestamp upddate;
	private String cd00001Ssgx;
	
        
    
    
    private String sysSsgx;
    private Integer outFlag;
    private ArrayList<Pgv00356> outList;
    private String szqyId;
    private String cwxx;
	// Constructors

	/** default constructor */
	public Pgv00356() {
		this.outList=new ArrayList<Pgv00356>();
	}

	/**
	 * @return the cd00001Szqylx
	 */
	public String getCd00001Szqylx() {
		return cd00001Szqylx;
	}

	/**
	 * @param cd00001Szqylx the cd00001Szqylx to set
	 */
	public void setCd00001Szqylx(String cd00001Szqylx) {
		this.cd00001Szqylx = cd00001Szqylx;
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
	 * @return the cd00002Pssd
	 */
	public String getCd00002Pssd() {
		return cd00002Pssd;
	}

	/**
	 * @param cd00002Pssd the cd00002Pssd to set
	 */
	public void setCd00002Pssd(String cd00002Pssd) {
		this.cd00002Pssd = cd00002Pssd;
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
	 * @return the szqy
	 */
	public String getSzqy() {
		return szqy;
	}

	/**
	 * @param szqy the szqy to set
	 */
	public void setSzqy(String szqy) {
		this.szqy = szqy;
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
	 * @return the pssd
	 */
	public Date getPssd() {
		return pssd;
	}

	/**
	 * @param pssd the pssd to set
	 */
	public void setPssd(Date pssd) {
		this.pssd = pssd;
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
	 * @return the outFlag
	 */
	public Integer getOutFlag() {
		return outFlag;
	}

	/**
	 * @param outFlag the outFlag to set
	 */
	public void setOutFlag(Integer outFlag) {
		this.outFlag = outFlag;
	}

	/**
	 * @return the outList
	 */
	public ArrayList<Pgv00356> getOutList() {
		return outList;
	}

	/**
	 * @param outList the outList to set
	 */
	public void setOutList(ArrayList<Pgv00356> outList) {
		this.outList = outList;
	}

	/**
	 * @return the szqyId
	 */
	public String getSzqyId() {
		return szqyId;
	}

	/**
	 * @param szqyId the szqyId to set
	 */
	public void setSzqyId(String szqyId) {
		this.szqyId = szqyId;
	}

	/**
	 * @return the cwxx
	 */
	public String getCwxx() {
		return cwxx;
	}

	/**
	 * @param cwxx the cwxx to set
	 */
	public void setCwxx(String cwxx) {
		this.cwxx = cwxx;
	}

}