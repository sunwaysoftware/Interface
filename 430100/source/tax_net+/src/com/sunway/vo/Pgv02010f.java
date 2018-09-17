

/**
 * @author sunxdd
 * 请把文件里的例如:cd00002czr这样的名称修改为cd00002Czr
 */

package com.sunway.vo;

import java.io.Serializable;
import java.util.Date;

public class Pgv02010f extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 0;
	public static final String TOTAL = "TOTAL";
	public static final String RID = "RID";
	public static final String CD_00001_SSGX = "CD_00001_SSGX";
	
	public static final String ID = "ID";
	public static final String CD_02002_FCID = "CD_02002_FCID";
	public static final String ZTLX = "ZTLX";
	public static final String ZLFJM = "ZLFJM";
	public static final String BCLJM = "BCLJM";
	public static final String UPDDATE = "UPDDATE";
	public static final String CD_00002_CZR = "CD_00002_CZR";
	public static final String CZR = "CZR";
	
	//===================== properties =======================
	
	private String cd02002Fcid;
	private String id;
	private Short ztlx;
	private String zlfjm;
	private String bcljm;
	private Date upddate;
	private String cd00002Czr;
	private String czr;
	private String cd00001Ssgx;

	private String errMsg;
	private Integer rid;
	private Integer total;
	
	
	
	private Integer zt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Short getZtlx() {
		return ztlx;
	}

	public void setZtlx(Short ztlx) {
		this.ztlx = ztlx;
	}

	public String getZlfjm() {
		return zlfjm;
	}

	public void setZlfjm(String zlfjm) {
		this.zlfjm = zlfjm;
	}

	public String getBcljm() {
		return bcljm;
	}

	public void setBcljm(String bcljm) {
		this.bcljm = bcljm;
	}

	public Date getUpddate() {
		return upddate;
	}

	public void setUpddate(Date upddate) {
		this.upddate = upddate;
	}

	public String getCd00002Czr() {
		return cd00002Czr;
	}

	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}

	public String getCzr() {
		return czr;
	}

	public void setCzr(String czr) {
		this.czr = czr;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}	

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getCd02002Fcid() {
		return cd02002Fcid;
	}

	public void setCd02002Fcid(String cd02002Fcid) {
		this.cd02002Fcid = cd02002Fcid;
	}

	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}

	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}
	
	
	
}
