

/**
 * @author sunxdd
 * 请把文件里的例如:cd00002czr这样的名称修改为cd00002Czr
 */

package com.sunway.vo;

import java.io.Serializable;
import java.util.Date;

public class Pgv02010 extends BaseVO implements Serializable {
	
	private static final long serialVersionUID = 0;
	public static final String TOTAL = "TOTAL";
	public static final String RID = "RID";
	
	public static final String CD_02002_FCID = "CD_02002_FCID";
	public static final String SBR = "SBR";
	public static final String CD_00001_ZJLX = "CD_00001_ZJLX";
	public static final String ZJHM = "ZJHM";
	public static final String LXDH = "LXDH";
	public static final String YYLY = "YYLY";
	public static final String SBDATE = "SBDATE";
	public static final String CD_00002_SBCZR = "CD_00002_SBCZR";
	public static final String SBZT = "SBZT";
	public static final String SLYJ = "SLYJ";
	public static final String SLDATE = "SLDATE";
	public static final String CD_00002_SLCZR = "CD_00002_SLCZR";
	public static final String SLZT = "SLZT";
	public static final String DCYJ = "DCYJ";
	public static final String DCDATE = "DCDATE";
	public static final String CD_00002_DCCZR = "CD_00002_DCCZR";
	public static final String DCZT = "DCZT";
	public static final String CLJD = "CLJD";
	public static final String CLDATE = "CLDATE";
	public static final String CD_00002_CLCZR = "CD_00002_CLCZR";
	public static final String CLZT = "CLZT";
	public static final String SLSY = "SLSY";
	public static final String DCJG = "DCJG";
	public static final String DCDSFJG = "DCDSFJG";
	public static final String DCSFCX = "DCSFCX";
	public static final String DCBCXYY = "DCBCXYY";
	public static final String FWTDZL = "ZCDZL";
	public static final String LH = "ZH";
	public static final String DYH = "DYH";
	public static final String BWJFH = "BWJFH";
	public static final String JZMJ = "JZMJ";
	public static final String JYJG = "SBJG";
	public static final String CD_00001_SSGX = "CD_00001_SSGX";
	public static final String SBCZR = "SBCZR";
	public static final String SLCZR = "SLCZR";
	public static final String DCCZR = "DCCZR";
	public static final String CLCZR = "CLCZR";
	public static final String SZQY = "SZQY";
	public static final String XQNM = "XQNM";
	public static final String PGJG = "PGJG";
	public static final String ZT = "ZT";
	public static final String ZJLX = "ZJLX";
	public static final String SSGX = "SSGX";
	public static final String SLBSLLY = "SLBSLLY";
	public static final String ZLQD = "ZLQD";
	public static final String JYSJ = "JYSJ";
	public static final String JSJG = "JSJG";
	public static final String ZZJG = "ZZJG";
	public static final String GAJG = "GAJG";
	public static final String PGGSMC = "PGGSMC";
	public static final String SBHZR = "SBH_ZR";
	//===================== properties =======================
	private Date jysj;
	private String zlqd;
	private String cd02002Fcid;
	private String sbr;
	private String cd00001Zjlx;
	private String zjhm;
	private String lxdh;
	private String yyly;
	private Date sbdate;
	private String cd00002Sbczr;
	private Short sbzt;
	private String slyj;
	private Date sldate;
	private String cd00002Slczr;
	private Short slzt;
	private Short dcyj;
	private Date dcdate;
	private String cd00002Dcczr;
	private Short dczt;
	private String cljd;
	private Date cldate;
	private String cd00002Clczr;
	private Short clzt;
	private String slsy;
	private Double dcjg;
	private Double dcdsfjg;
	private Short dcsfcx;
	private String dcbcxyy;
	private String fwtdzl;
	private String lh;
	private String dyh;
	private String bwjfh;
	private Double jzmj;
	private Double gajg;
	private Double jyjg;
	private String cd00001Ssgx;
	private String sbczr;
	private String slczr;
	private String dcczr;
	private String clczr;
	private String szqy;
	private String xqnm;
	private Double pgjg;
	private String zjlx;
	private String ssgx;
	private String dm;
	private String mc;
	private String slbslly;
	private Double jsjg;
	private Double zzjg;
	private String pggsmc;
	private String sbhZr;

	private String errMsg;
	private Integer rid;
	private Integer total;
	
	
	private String sqlData;
	private String order;
	private String sort;
	private Integer zt;
	
	
	/**
	 * @return the sbr
	 */
	public String getSbr() {
		return sbr;
	}
	
	/**
	 * @param sbr the sbr to set
	 */
	public void setSbr(String sbr) {
		this.sbr = sbr;
	}
	
	
	/**
	 * @return the zjhm
	 */
	public String getZjhm() {
		return zjhm;
	}
	
	/**
	 * @param zjhm the zjhm to set
	 */
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	
	/**
	 * @return the lxdh
	 */
	public String getLxdh() {
		return lxdh;
	}
	
	/**
	 * @param lxdh the lxdh to set
	 */
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	
	/**
	 * @return the yyly
	 */
	public String getYyly() {
		return yyly;
	}
	
	/**
	 * @param yyly the yyly to set
	 */
	public void setYyly(String yyly) {
		this.yyly = yyly;
	}
	
	/**
	 * @return the sbdate
	 */
	public Date getSbdate() {
		return sbdate;
	}
	
	/**
	 * @param sbdate the sbdate to set
	 */
	public void setSbdate(Date sbdate) {
		this.sbdate = sbdate;
	}
	
	
	
	/**
	 * @return the sbzt
	 */
	public Short getSbzt() {
		return sbzt;
	}
	
	/**
	 * @param sbzt the sbzt to set
	 */
	public void setSbzt(Short sbzt) {
		this.sbzt = sbzt;
	}
	
	/**
	 * @return the slyj
	 */
	public String getSlyj() {
		return slyj;
	}
	
	/**
	 * @param slyj the slyj to set
	 */
	public void setSlyj(String slyj) {
		this.slyj = slyj;
	}
	
	/**
	 * @return the sldate
	 */
	public Date getSldate() {
		return sldate;
	}
	
	/**
	 * @param sldate the sldate to set
	 */
	public void setSldate(Date sldate) {
		this.sldate = sldate;
	}
		
	
	/**
	 * @return the slzt
	 */
	public Short getSlzt() {
		return slzt;
	}
	
	/**
	 * @param slzt the slzt to set
	 */
	public void setSlzt(Short slzt) {
		this.slzt = slzt;
	}
	
	/**
	 * @return the dcyj
	 */
	public Short getDcyj() {
		return dcyj;
	}
	
	/**
	 * @param dcyj the dcyj to set
	 */
	public void setDcyj(Short dcyj) {
		this.dcyj = dcyj;
	}
	
	/**
	 * @return the dcdate
	 */
	public Date getDcdate() {
		return dcdate;
	}
	
	/**
	 * @param dcdate the dcdate to set
	 */
	public void setDcdate(Date dcdate) {
		this.dcdate = dcdate;
	}
	
	
	/**
	 * @return the dczt
	 */
	public Short getDczt() {
		return dczt;
	}
	
	/**
	 * @param dczt the dczt to set
	 */
	public void setDczt(Short dczt) {
		this.dczt = dczt;
	}
	
	/**
	 * @return the cljd
	 */
	public String getCljd() {
		return cljd;
	}
	
	/**
	 * @param cljd the cljd to set
	 */
	public void setCljd(String cljd) {
		this.cljd = cljd;
	}
	
	/**
	 * @return the cldate
	 */
	public Date getCldate() {
		return cldate;
	}
	
	/**
	 * @param cldate the cldate to set
	 */
	public void setCldate(Date cldate) {
		this.cldate = cldate;
	}		
	
	/**
	 * @return the clzt
	 */
	public Short getClzt() {
		return clzt;
	}
	
	/**
	 * @param clzt the clzt to set
	 */
	public void setClzt(Short clzt) {
		this.clzt = clzt;
	}
	
	/**
	 * @return the slsy
	 */
	public String getSlsy() {
		return slsy;
	}
	
	/**
	 * @param slsy the slsy to set
	 */
	public void setSlsy(String slsy) {
		this.slsy = slsy;
	}
	
	/**
	 * @return the dcjg
	 */
	public Double getDcjg() {
		return dcjg;
	}
	
	/**
	 * @param dcjg the dcjg to set
	 */
	public void setDcjg(Double dcjg) {
		this.dcjg = dcjg;
	}
	
	/**
	 * @return the dcdsfjg
	 */
	public Double getDcdsfjg() {
		return dcdsfjg;
	}
	
	/**
	 * @param dcdsfjg the dcdsfjg to set
	 */
	public void setDcdsfjg(Double dcdsfjg) {
		this.dcdsfjg = dcdsfjg;
	}
	
	/**
	 * @return the dcsfcx
	 */
	public Short getDcsfcx() {
		return dcsfcx;
	}
	
	/**
	 * @param dcsfcx the dcsfcx to set
	 */
	public void setDcsfcx(Short dcsfcx) {
		this.dcsfcx = dcsfcx;
	}
	
	/**
	 * @return the dcbcxyy
	 */
	public String getDcbcxyy() {
		return dcbcxyy;
	}
	
	/**
	 * @param dcbcxyy the dcbcxyy to set
	 */
	public void setDcbcxyy(String dcbcxyy) {
		this.dcbcxyy = dcbcxyy;
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
	 * @return the jzmj
	 */
	public Double getJzmj() {
		return jzmj;
	}
	
	/**
	 * @param jzmj the jzmj to set
	 */
	public void setJzmj(Double jzmj) {
		this.jzmj = jzmj;
	}
	
	/**
	 * @return the jyjg
	 */
	public Double getJyjg() {
		return jyjg;
	}
	
	/**
	 * @param jyjg the jyjg to set
	 */
	public void setJyjg(Double jyjg) {
		this.jyjg = jyjg;
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
	 * @return the sbczr
	 */
	public String getSbczr() {
		return sbczr;
	}
	
	/**
	 * @param sbczr the sbczr to set
	 */
	public void setSbczr(String sbczr) {
		this.sbczr = sbczr;
	}
	
	/**
	 * @return the slczr
	 */
	public String getSlczr() {
		return slczr;
	}
	
	/**
	 * @param slczr the slczr to set
	 */
	public void setSlczr(String slczr) {
		this.slczr = slczr;
	}
	
	/**
	 * @return the dcczr
	 */
	public String getDcczr() {
		return dcczr;
	}
	
	/**
	 * @param dcczr the dcczr to set
	 */
	public void setDcczr(String dcczr) {
		this.dcczr = dcczr;
	}
	
	/**
	 * @return the clczr
	 */
	public String getClczr() {
		return clczr;
	}
	
	/**
	 * @param clczr the clczr to set
	 */
	public void setClczr(String clczr) {
		this.clczr = clczr;
	}
	
	
	/**
	 * @return the rid
	 */
	public Integer getRid() {
		return rid;
	}
	/**
	 * @param rid the rid to set
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	/**
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}
	/**
	 * @param errMsg the errMsg to set
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getCd02002Fcid() {
		return cd02002Fcid;
	}

	public void setCd02002Fcid(String cd02002Fcid) {
		this.cd02002Fcid = cd02002Fcid;
	}

	public String getCd00001Zjlx() {
		return cd00001Zjlx;
	}

	public void setCd00001Zjlx(String cd00001Zjlx) {
		this.cd00001Zjlx = cd00001Zjlx;
	}

	public String getCd00002Sbczr() {
		return cd00002Sbczr;
	}

	public void setCd00002Sbczr(String cd00002Sbczr) {
		this.cd00002Sbczr = cd00002Sbczr;
	}

	public String getCd00002Slczr() {
		return cd00002Slczr;
	}

	public void setCd00002Slczr(String cd00002Slczr) {
		this.cd00002Slczr = cd00002Slczr;
	}

	public String getCd00002Dcczr() {
		return cd00002Dcczr;
	}

	public void setCd00002Dcczr(String cd00002Dcczr) {
		this.cd00002Dcczr = cd00002Dcczr;
	}

	public String getCd00002Clczr() {
		return cd00002Clczr;
	}

	public void setCd00002Clczr(String cd00002Clczr) {
		this.cd00002Clczr = cd00002Clczr;
	}	

	public Integer getZt() {
		return zt;
	}

	public void setZt(Integer zt) {
		this.zt = zt;
	}

	public String getSzqy() {
		return szqy;
	}

	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}

	public String getXqnm() {
		return xqnm;
	}

	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}

	public Double getPgjg() {
		return pgjg;
	}

	public void setPgjg(Double pgjg) {
		this.pgjg = pgjg;
	}

	public String getZjlx() {
		return zjlx;
	}

	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getSsgx() {
		return ssgx;
	}

	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}

	public String getSlbslly() {
		return slbslly;
	}

	public void setSlbslly(String slbslly) {
		this.slbslly = slbslly;
	}

	public String getZlqd() {
		return zlqd;
	}

	public void setZlqd(String zlqd) {
		this.zlqd = zlqd;
	}

	public Date getJysj() {
		return jysj;
	}

	public void setJysj(Date jysj) {
		this.jysj = jysj;
	}

	public Double getJsjg() {
		return jsjg;
	}

	public void setJsjg(Double jsjg) {
		this.jsjg = jsjg;
	}

	public Double getZzjg() {
		return zzjg;
	}

	public void setZzjg(Double zzjg) {
		this.zzjg = zzjg;
	}

	public String getLh() {
		return lh;
	}

	public void setLh(String lh) {
		this.lh = lh;
	}

	public String getDyh() {
		return dyh;
	}

	public void setDyh(String dyh) {
		this.dyh = dyh;
	}

	public String getBwjfh() {
		return bwjfh;
	}

	public void setBwjfh(String bwjfh) {
		this.bwjfh = bwjfh;
	}

	public Double getGajg() {
		return gajg;
	}

	public void setGajg(Double gajg) {
		this.gajg = gajg;
	}

	public String getPggsmc() {
		return pggsmc;
	}

	public void setPggsmc(String pggsmc) {
		this.pggsmc = pggsmc;
	}

	public String getSbhZr() {
		return sbhZr;
	}

	public void setSbhZr(String sbhZr) {
		this.sbhZr = sbhZr;
	}

	public String getSqlData() {
		return sqlData;
	}

	public void setSqlData(String sqlData) {
		this.sqlData = sqlData;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
