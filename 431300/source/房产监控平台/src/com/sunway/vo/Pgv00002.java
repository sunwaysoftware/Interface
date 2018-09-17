package com.sunway.vo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * PgvUser entity. 
 * @author Lee
 */

@SuppressWarnings("serial")
public class Pgv00002 implements java.io.Serializable {

	// Fields
	private String userid;
	private String usernm;
	private String userpwd;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String czr;
	private String userip;
	private Date lastlogindate;
	private String phone;
	private Boolean islockedout;
	private Timestamp lastlockedoutdate;
	private Short failedpwdattemptcount;
	private Integer recordCount;
    private Integer recordIndex;    
    private Integer pageIndex;
    private Integer pageSize; 
	private String roleids;
	private String rightids;
	private Boolean isuser;
	private String cd00001Ssgx;
	private String cd00001Ssgxlx;
	private String ssgx;
	private Integer isAdmin;
	private Integer pagecount;
	private Date pssd;
	private String szqyList;
	private Integer  qxid;
	
	// Constructors

	/** default constructor */
	public Pgv00002() {
	}

	public Integer getQxid() {
		return qxid;
	}

	public void setQxid(Integer qxid) {
		this.qxid = qxid;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * @return the usernm
	 */
	public String getUsernm() {
		return usernm;
	}

	/**
	 * @param usernm the usernm to set
	 */
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}

	/**
	 * @return the userpwd
	 */
	public String getUserpwd() {
		return userpwd;
	}

	/**
	 * @param userpwd the userpwd to set
	 */
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
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
	 * @return the userip
	 */
	public String getUserip() {
		return userip;
	}

	/**
	 * @param userip the userip to set
	 */
	public void setUserip(String userip) {
		this.userip = userip;
	}

	/**
	 * @return the lastlogindate
	 */
	public Date getLastlogindate() {
		return lastlogindate;
	}

	/**
	 * @param lastlogindate the lastlogindate to set
	 */
	public void setLastlogindate(Date lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the islockedout
	 */
	public Boolean getIslockedout() {
		return islockedout;
	}

	/**
	 * @param islockedout the islockedout to set
	 */
	public void setIslockedout(Boolean islockedout) {
		this.islockedout = islockedout;
	}

	/**
	 * @return the lastlockedoutdate
	 */
	public Timestamp getLastlockedoutdate() {
		return lastlockedoutdate;
	}

	/**
	 * @param lastlockedoutdate the lastlockedoutdate to set
	 */
	public void setLastlockedoutdate(Timestamp lastlockedoutdate) {
		this.lastlockedoutdate = lastlockedoutdate;
	}

	/**
	 * @return the failedpwdattemptcount
	 */
	public Short getFailedpwdattemptcount() {
		return failedpwdattemptcount;
	}

	/**
	 * @param failedpwdattemptcount the failedpwdattemptcount to set
	 */
	public void setFailedpwdattemptcount(Short failedpwdattemptcount) {
		this.failedpwdattemptcount = failedpwdattemptcount;
	}

	/**
	 * @return the recordCount
	 */
	public Integer getRecordCount() {
		return recordCount;
	}

	/**
	 * @param recordCount the recordCount to set
	 */
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}

	/**
	 * @return the recordIndex
	 */
	public Integer getRecordIndex() {
		return recordIndex;
	}

	/**
	 * @param recordIndex the recordIndex to set
	 */
	public void setRecordIndex(Integer recordIndex) {
		this.recordIndex = recordIndex;
	}

	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the roleids
	 */
	public String getRoleids() {
		return roleids;
	}

	/**
	 * @param roleids the roleids to set
	 */
	public void setRoleids(String roleids) {
		this.roleids = roleids;
	}

	/**
	 * @return the rightids
	 */
	public String getRightids() {
		return rightids;
	}

	/**
	 * @param rightids the rightids to set
	 */
	public void setRightids(String rightids) {
		this.rightids = rightids;
	}

	/**
	 * @return the isuser
	 */
	public Boolean getIsuser() {
		return isuser;
	}

	/**
	 * @param isuser the isuser to set
	 */
	public void setIsuser(Boolean isuser) {
		this.isuser = isuser;
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
	 * @return the pagecount
	 */
	public Integer getPagecount() {
		return pagecount;
	}

	/**
	 * @param pagecount the pagecount to set
	 */
	public void setPagecount(Integer pagecount) {
		this.pagecount = pagecount;
	}

	/**
	 * @return the cd00001Ssgxlx
	 */
	public String getCd00001Ssgxlx() {
		return cd00001Ssgxlx;
	}

	/**
	 * @param cd00001Ssgxlx the cd00001Ssgxlx to set
	 */
	public void setCd00001Ssgxlx(String cd00001Ssgxlx) {
		this.cd00001Ssgxlx = cd00001Ssgxlx;
	}

	/**
	 * @return the ssgx
	 */
	public String getSsgx() {
		return ssgx;
	}

	/**
	 * @param ssgx the ssgx to set
	 */
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
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
	 * @return the isAdmin
	 */
	public Integer getIsAdmin() {
		return isAdmin;
	}

	/**
	 * @param isAdmin the isAdmin to set
	 */
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getSzqyList() {
		return szqyList;
	}

	public void setSzqyList(String szqyList) {
		this.szqyList = szqyList;
	}


}