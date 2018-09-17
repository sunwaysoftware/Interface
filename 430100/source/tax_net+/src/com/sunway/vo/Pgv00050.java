

/**
 * @author sunxdd
 * 请把文件里的例如:cd00002czr这样的名称修改为cd00002Czr
 */

package com.sunway.vo;

import java.io.Serializable;
import java.sql.Date;

public class Pgv00050 extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 0;
	public static final String TOTAL = "TOTAL";
	public static final String RID = "RID";
	public static final String CD_00001_SSGX = "CD_00001_SSGX";
	public static final String SSGX = "SSGX";
	public static final String ID = "ID";
	public static final String PGGSMC = "PGGSMC";
	public static final String UPDDATE = "UPDDATE";
	public static final String CD_00002_CZR = "CD_00002_CZR";
	public static final String CZR = "CZR";
	
	//===================== properties =======================
	
	
	private String id;
	private String pggsmc;
	private Date upddate;
	private String cd00002Czr;
	private String czr;
	private String ssgx;
	private String cd00001Ssgx;

	private String errMsg;
	private Integer rid;
	private Integer total;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}

	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}

	public String getPggsmc() {
		return pggsmc;
	}

	public void setPggsmc(String pggsmc) {
		this.pggsmc = pggsmc;
	}

	public String getSsgx() {
		return ssgx;
	}

	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}
	
	
	
}
