package com.sunway.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;



/**
 * 全面评估市场法国土信息
 * @author Light
 *
 */
public class Pgv00320 extends BaseVO implements Serializable {

	private static final long serialVersionUID = 1136794412937705563L;
	private String fcid;				//国土编码
	private String fczh;				//国土证号
	private String clh;					//测量号
	private String zcdzl;				//房屋坐落
	private Double jzmj;				//建筑面积
	private Double hdjg;				//核定价格
	private String cd00352Xqdm;			//小区代码
	private Integer zlc;				//总楼层
	private Integer szlc;				//所在楼层
	private String cd00001Fwlx;			//房屋类型
	private String cd00001Jzjg;			//建筑结构
	private String cd00001Ghyt;			//规划用途
	private String cd00001jylx;			//交易类型
	private String cd00001Ssgx;			//税收管辖
	private Timestamp upddate;			//更新时间
	private String cd00002Czr;			//操作人
	private String note;				//备注
	private String nsrmc;				//纳税人民称
	private String cd00001Zjlx;			//证件类型
	private String zjhm;				//证件号码
	private String lxdh;				//联系电话
	private String jcnf;				//建成年份

	
	private String xqnm;
	private String fwlx;
	private String jzjg;
	private String ghyt;
	private String jylx;
	private String zjlx;
	private String ssgx;
	private String czr;
	
	
	
	
	
	
	
	private String cd00001Szqy;
	private String szqy;
	private String zhxz;
	private String zhxzId;
	private String impErrorMsg;
	private ArrayList<Pgv00320> outList;
	private Integer outFlag;
	private String pssd;
    private Date PssdYMD;
	private Date jysj;
	private BigDecimal pgjg;
	private String cd00306Id;
	private String dyh;
	private String zh;
	private String fh;
	private Boolean ISEXISTQMPG;
	private Integer isPgjg;	
	private Integer cwxx;
	private String nsrNm;
	private Date fzrq;
	private Double jyjg;
	private String chkDel;

	private String lh;
	public String getFcid() {
		return fcid;
	}
	public void setFcid(String fcid) {
		this.fcid = fcid;
	}
	public String getFczh() {
		return fczh;
	}
	public void setFczh(String fczh) {
		this.fczh = fczh;
	}
	public String getClh() {
		return clh;
	}
	public void setClh(String clh) {
		this.clh = clh;
	}
	public String getZcdzl() {
		return zcdzl;
	}
	public void setZcdzl(String zcdzl) {
		this.zcdzl = zcdzl;
	}
	public Double getJzmj() {
		return jzmj;
	}
	public void setJzmj(Double jzmj) {
		this.jzmj = jzmj;
	}
	public Double getHdjg() {
		return hdjg;
	}
	public void setHdjg(Double hdjg) {
		this.hdjg = hdjg;
	}
	public String getCd00352Xqdm() {
		return cd00352Xqdm;
	}
	public void setCd00352Xqdm(String cd00352Xqdm) {
		this.cd00352Xqdm = cd00352Xqdm;
	}
	public Integer getZlc() {
		return zlc;
	}
	public void setZlc(Integer zlc) {
		this.zlc = zlc;
	}
	public Integer getSzlc() {
		return szlc;
	}
	public void setSzlc(Integer szlc) {
		this.szlc = szlc;
	}
	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}
	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}
	public String getCd00001Jzjg() {
		return cd00001Jzjg;
	}
	public void setCd00001Jzjg(String cd00001Jzjg) {
		this.cd00001Jzjg = cd00001Jzjg;
	}
	public String getCd00001Ghyt() {
		return cd00001Ghyt;
	}
	public void setCd00001Ghyt(String cd00001Ghyt) {
		this.cd00001Ghyt = cd00001Ghyt;
	}
	public String getCd00001jylx() {
		return cd00001jylx;
	}
	public void setCd00001jylx(String cd00001jylx) {
		this.cd00001jylx = cd00001jylx;
	}
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}
	public Timestamp getUpddate() {
		return upddate;
	}
	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}
	public String getCd00002Czr() {
		return cd00002Czr;
	}
	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getXqnm() {
		return xqnm;
	}
	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	public String getJzjg() {
		return jzjg;
	}
	public void setJzjg(String jzjg) {
		this.jzjg = jzjg;
	}
	public String getGhyt() {
		return ghyt;
	}
	public void setGhyt(String ghyt) {
		this.ghyt = ghyt;
	}
	public String getJylx() {
		return jylx;
	}
	public void setJylx(String jylx) {
		this.jylx = jylx;
	}
	public String getSsgx() {
		return ssgx;
	}
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	
	public String getCd00001Szqy() {
		return cd00001Szqy;
	}
	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}
	public String getSzqy() {
		return szqy;
	}
	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}
	public String getZhxzId() {
		return zhxzId;
	}
	public void setZhxzId(String zhxzId) {
		this.zhxzId = zhxzId;
	}
	public String getImpErrorMsg() {
		return impErrorMsg;
	}
	public void setImpErrorMsg(String impErrorMsg) {
		this.impErrorMsg = impErrorMsg;
	}
	public ArrayList<Pgv00320> getOutList() {
		return outList;
	}
	public void setOutList(ArrayList<Pgv00320> outList) {
		this.outList = outList;
	}
	public Integer getOutFlag() {
		return outFlag;
	}
	public void setOutFlag(Integer outFlag) {
		this.outFlag = outFlag;
	}
	public String getPssd() {
		return pssd;
	}
	public void setPssd(String pssd) {
		this.pssd = pssd;
	}
	public Date getJysj() {
		return jysj;
	}
	public void setJysj(Date jysj) {
		this.jysj = jysj;
	}
	public BigDecimal getPgjg() {
		return pgjg;
	}
	public void setPgjg(BigDecimal pgjg) {
		this.pgjg = pgjg;
	}
	public String getCd00306Id() {
		return cd00306Id;
	}
	public void setCd00306Id(String cd00306Id) {
		this.cd00306Id = cd00306Id;
	}
	public Date getPssdYMD() {
		return PssdYMD;
	}
	public void setPssdYMD(Date pssdYMD) {
		PssdYMD = pssdYMD;
	}
	public String getZhxz() {
		return zhxz;
	}
	public void setZhxz(String zhxz) {
		this.zhxz = zhxz;
	}
	public String getDyh() {
		return dyh;
	}
	public void setDyh(String dyh) {
		this.dyh = dyh;
	}

	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	/**
	 * @return the fh
	 */
	public String getFh() {
		return fh;
	}
	/**
	 * @param fh the fh to set
	 */
	public void setFh(String fh) {
		this.fh = fh;
	}
	/**
	 * @return the iSEXISTQMPG
	 */
	public Boolean getISEXISTQMPG() {
		return ISEXISTQMPG;
	}
	/**
	 * @param iSEXISTQMPG the iSEXISTQMPG to set
	 */
	public void setISEXISTQMPG(Boolean iSEXISTQMPG) {
		ISEXISTQMPG = iSEXISTQMPG;
	}

	public Integer getIsPgjg() {
		return isPgjg;
	}
	public void setIsPgjg(Integer isPgjg) {
		this.isPgjg = isPgjg;
	}
	public Integer getCwxx() {
		return cwxx;
	}
	public void setCwxx(Integer cwxx) {
		this.cwxx = cwxx;
	}

	public String getNsrmc() {
		return nsrmc;
	}
	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
	}
	public String getCd00001Zjlx() {
		return cd00001Zjlx;
	}
	public void setCd00001Zjlx(String cd00001Zjlx) {
		this.cd00001Zjlx = cd00001Zjlx;
	}
	public String getZjhm() {
		return zjhm;
	}
	public void setZjhm(String zjhm) {
		this.zjhm = zjhm;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getJcnf() {
		return jcnf;
	}
	public void setJcnf(String jcnf) {
		this.jcnf = jcnf;
	}
	public String getZjlx() {
		return zjlx;
	}
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	/**
	 * @return the nsrNm
	 */
	public String getNsrNm() {
		return nsrNm;
	}
	/**
	 * @param nsrNm the nsrNm to set
	 */
	public void setNsrNm(String nsrNm) {
		this.nsrNm = nsrNm;
	}

	/**
	 * @return the fzrq
	 */
	public Date getFzrq() {
		return fzrq;
	}
	/**
	 * @param fzrq the fzrq to set
	 */
	public void setFzrq(Date fzrq) {
		this.fzrq = fzrq;
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
	public String getChkDel() {
		return chkDel;
	}
	public void setChkDel(String chkDel) {
		this.chkDel = chkDel;
	}
	/**
	 * @return the lh
	 */
	public String getLh() {
		return lh;
	}
	/**
	 * @param lh the lh to set
	 */
	public void setLh(String lh) {
		this.lh = lh;
	}
	

	
	
}
