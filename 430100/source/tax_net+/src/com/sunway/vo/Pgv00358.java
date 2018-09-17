package com.sunway.vo;

import java.util.Date;

/**
 * Pgv00358Id entity. @author MyEclipse Persistence Tools
 */


public class Pgv00358 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = -5425247373914154989L;
	private String cd00302Fcid;
	private String cdSlid;
	private String cd00002Pssd;
	private Integer yxj;
	private Integer zyxj;
	private String xqnm;
	private String jylx;
	private String jzjg;
	private String fwlx;
	private String fwcx;
	private String cgzk;
	private Integer ywdt;
	private Integer zlc;
	private Integer szlc;
	private Double pfmjg;
	private String cd00001Fwcx;
	private String cd00001Cgzk;
	private String fwtdzl;
	private Date jysj;
	
	
	private Integer total;
	private Integer rid;
	private Integer pssdToJyjg;
	private Date sysPssd;
	
	// Constructors

	/** default constructor */
	public Pgv00358() {
	}

	/**
	 * @param cd00302Fcid
	 * @param pageIndex
	 * @param pageSize
	 */
	public Pgv00358(String cd00302Fcid, Integer pageIndex, Integer pageSize) {
		this.cd00302Fcid = cd00302Fcid;
	}

	/**
	 * @param cd00302Fcid
	 * @param cdSlid
	 * @param cd00002Pssd
	 * @param yxj
	 * @param zyxj
	 * @param xqnm
	 * @param jylx
	 * @param jzjg
	 * @param fwlx
	 * @param fwcx
	 * @param cgzk
	 * @param ywdt
	 * @param zlc
	 * @param szlc
	 * @param pfmjg
	 * @param cd00001Fwcx
	 * @param cd00001Cgzk
	 * @param fwtdzl
	 * @param jysj
	 * @param total
	 * @param rid
	 */
	public Pgv00358(String cd00302Fcid, String cdSlid, String cd00002Pssd,
			Integer yxj, Integer zyxj, String xqnm, String jylx, String jzjg,
			String fwlx, Integer ywdt, Integer zlc,
			Integer szlc, Double pfmjg,
			String fwtdzl, Date jysj, Integer total, Integer rid) {
		this.cd00302Fcid = cd00302Fcid;
		this.cdSlid = cdSlid;
		this.cd00002Pssd = cd00002Pssd;
		this.yxj = yxj;
		this.zyxj = zyxj;
		this.xqnm = xqnm;
		this.jylx = jylx;
		this.jzjg = jzjg;
		this.fwlx = fwlx;
		this.ywdt = ywdt;
		this.zlc = zlc;
		this.szlc = szlc;
		this.pfmjg = pfmjg;
		this.fwtdzl = fwtdzl;
		this.jysj = jysj;
		this.total = total;
		this.rid = rid;
	}

	/**
	 * @return the cd00302Fcid
	 */
	public String getCd00302Fcid() {
		return cd00302Fcid;
	}

	/**
	 * @param cd00302Fcid the cd00302Fcid to set
	 */
	public void setCd00302Fcid(String cd00302Fcid) {
		this.cd00302Fcid = cd00302Fcid;
	}

	/**
	 * @return the cdSlid
	 */
	public String getCdSlid() {
		return cdSlid;
	}

	/**
	 * @param cdSlid the cdSlid to set
	 */
	public void setCdSlid(String cdSlid) {
		this.cdSlid = cdSlid;
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
	 * @return the yxj
	 */
	public Integer getYxj() {
		return yxj;
	}

	/**
	 * @param yxj the yxj to set
	 */
	public void setYxj(Integer yxj) {
		this.yxj = yxj;
	}

	/**
	 * @return the zyxj
	 */
	public Integer getZyxj() {
		return zyxj;
	}

	/**
	 * @param zyxj the zyxj to set
	 */
	public void setZyxj(Integer zyxj) {
		this.zyxj = zyxj;
	}

	/**
	 * @return the xqnm
	 */
	public String getXqnm() {
		return xqnm;
	}

	/**
	 * @param xqnm the xqnm to set
	 */
	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}

	/**
	 * @return the jylx
	 */
	public String getJylx() {
		return jylx;
	}

	/**
	 * @param jylx the jylx to set
	 */
	public void setJylx(String jylx) {
		this.jylx = jylx;
	}

	/**
	 * @return the jzjg
	 */
	public String getJzjg() {
		return jzjg;
	}

	/**
	 * @param jzjg the jzjg to set
	 */
	public void setJzjg(String jzjg) {
		this.jzjg = jzjg;
	}

	/**
	 * @return the fwlx
	 */
	public String getFwlx() {
		return fwlx;
	}

	/**
	 * @param fwlx the fwlx to set
	 */
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}

	/**
	 * @return the fwcx
	 */
	public String getFwcx() {
		return fwcx;
	}

	/**
	 * @param fwcx the fwcx to set
	 */
	public void setFwcx(String fwcx) {
		this.fwcx = fwcx;
	}

	/**
	 * @return the cgzk
	 */
	public String getCgzk() {
		return cgzk;
	}

	/**
	 * @param cgzk the cgzk to set
	 */
	public void setCgzk(String cgzk) {
		this.cgzk = cgzk;
	}

	/**
	 * @return the ywdt
	 */
	public Integer getYwdt() {
		return ywdt;
	}

	/**
	 * @param ywdt the ywdt to set
	 */
	public void setYwdt(Integer ywdt) {
		this.ywdt = ywdt;
	}

	/**
	 * @return the zlc
	 */
	public Integer getZlc() {
		return zlc;
	}

	/**
	 * @param zlc the zlc to set
	 */
	public void setZlc(Integer zlc) {
		this.zlc = zlc;
	}

	/**
	 * @return the szlc
	 */
	public Integer getSzlc() {
		return szlc;
	}

	/**
	 * @param szlc the szlc to set
	 */
	public void setSzlc(Integer szlc) {
		this.szlc = szlc;
	}

	/**
	 * @return the pfmjg
	 */
	public Double getPfmjg() {
		return pfmjg;
	}

	/**
	 * @param pfmjg the pfmjg to set
	 */
	public void setPfmjg(Double pfmjg) {
		this.pfmjg = pfmjg;
	}

	/**
	 * @return the cd00001Fwcx
	 */
	public String getCd00001Fwcx() {
		return cd00001Fwcx;
	}

	/**
	 * @param cd00001Fwcx the cd00001Fwcx to set
	 */
	public void setCd00001Fwcx(String cd00001Fwcx) {
		this.cd00001Fwcx = cd00001Fwcx;
	}

	/**
	 * @return the cd00001Cgzk
	 */
	public String getCd00001Cgzk() {
		return cd00001Cgzk;
	}

	/**
	 * @param cd00001Cgzk the cd00001Cgzk to set
	 */
	public void setCd00001Cgzk(String cd00001Cgzk) {
		this.cd00001Cgzk = cd00001Cgzk;
	}

	/**
	 * @return the fwtdzl
	 */
	public String getFwtdzl() {
		return fwtdzl;
	}

	/**
	 * @param fwtdzl the fwtdzl to set
	 */
	public void setFwtdzl(String fwtdzl) {
		this.fwtdzl = fwtdzl;
	}

	/**
	 * @return the jysj
	 */
	public Date getJysj() {
		return jysj;
	}

	/**
	 * @param jysj the jysj to set
	 */
	public void setJysj(Date jysj) {
		this.jysj = jysj;
	}
	

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param rid the rid to set
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * @return the rid
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * @param pssdToJyjg the pssdToJyjg to set
	 */
	public void setPssdToJyjg(Integer pssdToJyjg) {
		this.pssdToJyjg = pssdToJyjg;
	}

	/**
	 * @return the pssdToJyjg
	 */
	public Integer getPssdToJyjg() {
		return pssdToJyjg;
	}

	/**
	 * @param sysPssd the sysPssd to set
	 */
	public void setSysPssd(Date sysPssd) {
		this.sysPssd = sysPssd;
	}

	/**
	 * @return the sysPssd
	 */
	public Date getSysPssd() {
		return sysPssd;
	}
}