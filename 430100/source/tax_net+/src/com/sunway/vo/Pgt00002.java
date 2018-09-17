package com.sunway.vo;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sunway.util.CurrencyAdapter;


/**
 * PgtUser entity. 
 * @author Lee
 */


public class Pgt00002 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 2760376064103439513L;
	private String userid;
	private String usernm;
	private String userpwd;
	private String olduserpwd;
	private String newuserpwd;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String userip;
	private Date lastlogindate;
	private String phone;
	private Boolean islockedout;
	private Timestamp lastlockedoutdate;
	private Short failedpwdattemptcount;
	private String roleids;
	private String rightids;
	private String ssgx;
	private String ssgxs;
	private Integer pageSize;
	private Date pssd;
	private String pssdymd;
	private Integer loginState; 
	private String loginMessage;
	private String szqy;
	private String cd00001Ssgx;
	private Boolean isadmin;
	private String usergh;
	// Constructors

	/** default constructor */
	public Pgt00002() {
	}

	/** full constructor */
	public Pgt00002(String userid, String usernm, String userpwd, Timestamp upddate,
			String cd00002Czr, String note) {
		this.userid = userid;
		this.usernm = usernm;
		this.userpwd = userpwd;
		this.upddate = upddate;
		this.cd00002Czr = cd00002Czr;
		this.note = note;
	}

	// Property accessors


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
	@XmlJavaTypeAdapter(CurrencyAdapter.class)
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
	@XmlJavaTypeAdapter(CurrencyAdapter.class)
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
	 * @return the pagecount
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pagecount the pagecount to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
	 * @param loginMessage the loginMessage to set
	 */
	public void setLoginMessage(String loginMessage) {
		this.loginMessage = loginMessage;
	}

	/**
	 * @return the loginMessage
	 */
	public String getLoginMessage() {
		return loginMessage;
	}

	/**
	 * @param loginState the loginState to set
	 */
	public void setLoginState(Integer loginState) {
		this.loginState = loginState;
	}

	/**
	 * @return the loginState
	 */
	public Integer getLoginState() {
		return loginState;
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
	 * @return the isadmin
	 */
	public Boolean getIsadmin() {
		return isadmin;
	}

	/**
	 * @param isadmin the isadmin to set
	 */
	public void setIsadmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}

	/**
	 * @return the ssgxs
	 */
	public String getSsgxs() {
		return ssgxs;
	}

	/**
	 * @param ssgxs the ssgxs to set
	 */
	public void setSsgxs(String ssgxs) {
		this.ssgxs = ssgxs;
	}

	/**
	 * @return the olduserpwd
	 */
	public String getOlduserpwd() {
		return olduserpwd;
	}

	/**
	 * @param olduserpwd the olduserpwd to set
	 */
	public void setOlduserpwd(String olduserpwd) {
		this.olduserpwd = olduserpwd;
	}

	/**
	 * @return the newuserpwd
	 */
	public String getNewuserpwd() {
		return newuserpwd;
	}

	/**
	 * @param newuserpwd the newuserpwd to set
	 */
	public void setNewuserpwd(String newuserpwd) {
		this.newuserpwd = newuserpwd;
	}

	/**
	 * @return the pssdymd
	 */
	public String getPssdymd() {
		return pssdymd;
	}

	/**
	 * @param pssdymd the pssdymd to set
	 */
	public void setPssdymd(String pssdymd) {
		this.pssdymd = pssdymd;
	}

	public void setUsergh(String usergh) {
		this.usergh = usergh;
	}

	public String getUsergh() {
		return usergh;
	}

}