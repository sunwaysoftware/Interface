package com.sunway.vo;

import java.util.ArrayList;
import java.sql.Date;

/**
 * 
 * 通用数据导入模版Bean
 * @author Sunway-Lee
 * 
 */

public class ExcelBean implements java.io.Serializable{

	private static final long serialVersionUID = -7211381351291912735L;
	//A. 所在区域
	private String szqyNm;
	private String szqyId;	
	//B. 大区名称	
	private String parentXQNm;
	private String parentXQId;
	//C. 小区名称
	private String xqNm;
	private String xqId;	
	//D. 小区地址
	private String xqdz;	
	//E. 小区地址别名
	private String xqdzbm;	
	//F. 楼名
	private String lfmc;
	private String lfmcId;
	//G. 楼别名
	private String lfmcbm;	
	//H. 总楼层
	private Short zlc;	
	private Short lc;
	//I. 有无电梯
	private Short ywdt;	
	//J. 建筑结构
	private String jzjgNm;
	private String jzjgId;
	//K. 房屋朝向
	private String fwcxNm;
	private String fwcxId;
	//L. 房屋类别	
	private String fwlxNm;
	private String fwlxId;
	//M. 采光状况
	private String cgzkNm;
	private String cgzkId;
	//N. 所在楼层	
	private Short szlc;
	//O. 交易类型
	private String jylxNm;
	private String jylxId;
	//P. 景观
	private String qtxzNms;
	private String qtxzIds;
	//Q. 交易时间	
	private Date jysj;
	//R. 基准价值(元/平方米)
	private Double jzjg;
	private String cd00002Czr;
	private String ssgx;
	private String lfid;
	
	private String clh;
	private Integer ywjkc;
	//导入结果
	private Integer exportOutCome;
	//导入List
	private ArrayList<ExcelBean> outExcelList;
	
	private String zhxz;
	private String zhxzIds;
	private Double xzxs;
	private String yslx;
	private Date update;
	private String pssd;
	private String cd0001Szqylx;
	private String cwxx;
	private String zcdzl;
	private String zcdzlId;
	private String pqdmh;
	private String xqdmh;
	private String xqdmhid;
	private String jcnf;
	private double pfmjg;
	private String cd00001Jzjg1;
	private String note1;
	private String zcdzbm;
	private String cd00053Qtxzid;
	private String note;
	/**
	 * 默认构造器,产生outExcelList
	 */
	public ExcelBean(){
		outExcelList = new ArrayList<ExcelBean>();
	}

	/*********************************getter and setter***********************************/
	
	/**
	 * @return the szqyNm
	 */
	public String getSzqyNm() {
		return szqyNm;
	}

	/**
	 * @param szqyNm the szqyNm to set
	 */
	public void setSzqyNm(String szqyNm) {
		this.szqyNm = szqyNm;
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
	 * @return the parentXQNm
	 */
	public String getParentXQNm() {
		return parentXQNm;
	}

	/**
	 * @param parentXQNm the parentXQNm to set
	 */
	public void setParentXQNm(String parentXQNm) {
		this.parentXQNm = parentXQNm;
	}

	/**
	 * @return the parentXQId
	 */
	public String getParentXQId() {
		return parentXQId;
	}

	/**
	 * @param parentXQId the parentXQId to set
	 */
	public void setParentXQId(String parentXQId) {
		this.parentXQId = parentXQId;
	}

	/**
	 * @return the xqNm
	 */
	public String getXqNm() {
		return xqNm;
	}

	/**
	 * @param xqNm the xqNm to set
	 */
	public void setXqNm(String xqNm) {
		this.xqNm = xqNm;
	}

	/**
	 * @return the xqId
	 */
	public String getXqId() {
		return xqId;
	}

	/**
	 * @param xqId the xqId to set
	 */
	public void setXqId(String xqId) {
		this.xqId = xqId;
	}

	/**
	 * @return the xqdz
	 */
	public String getXqdz() {
		return xqdz;
	}

	/**
	 * @param xqdz the xqdz to set
	 */
	public void setXqdz(String xqdz) {
		this.xqdz = xqdz;
	}

	/**
	 * @return the xqdzbm
	 */
	public String getXqdzbm() {
		return xqdzbm;
	}

	/**
	 * @param xqdzbm the xqdzbm to set
	 */
	public void setXqdzbm(String xqdzbm) {
		this.xqdzbm = xqdzbm;
	}

	/**
	 * @return the lfmc
	 */
	public String getLfmc() {
		return lfmc;
	}

	/**
	 * @param lfmc the lfmc to set
	 */
	public void setLfmc(String lfmc) {
		this.lfmc = lfmc;
	}

	/**
	 * @return the lfmcbm
	 */
	public String getLfmcbm() {
		return lfmcbm;
	}

	/**
	 * @param lfmcbm the lfmcbm to set
	 */
	public void setLfmcbm(String lfmcbm) {
		this.lfmcbm = lfmcbm;
	}

	/**
	 * @return the zlc
	 */
	public Short getZlc() {
		return zlc;
	}

	/**
	 * @param zlc the zlc to set
	 */
	public void setZlc(Short zlc) {
		this.zlc = zlc;
	}

	/**
	 * @return the ywdt
	 */
	public Short getYwdt() {
		return ywdt;
	}

	/**
	 * @param ywdt the ywdt to set
	 */
	public void setYwdt(Short ywdt) {
		this.ywdt = ywdt;
	}

	/**
	 * @return the jzjgNm
	 */
	public String getJzjgNm() {
		return jzjgNm;
	}

	/**
	 * @param jzjgNm the jzjgNm to set
	 */
	public void setJzjgNm(String jzjgNm) {
		this.jzjgNm = jzjgNm;
	}

	/**
	 * @return the jzjgId
	 */
	public String getJzjgId() {
		return jzjgId;
	}

	/**
	 * @param jzjgId the jzjgId to set
	 */
	public void setJzjgId(String jzjgId) {
		this.jzjgId = jzjgId;
	}

	/**
	 * @return the fwcxNm
	 */
	public String getFwcxNm() {
		return fwcxNm;
	}

	/**
	 * @param fwcxNm the fwcxNm to set
	 */
	public void setFwcxNm(String fwcxNm) {
		this.fwcxNm = fwcxNm;
	}

	/**
	 * @return the fwcxId
	 */
	public String getFwcxId() {
		return fwcxId;
	}

	/**
	 * @param fwcxId the fwcxId to set
	 */
	public void setFwcxId(String fwcxId) {
		this.fwcxId = fwcxId;
	}

	/**
	 * @return the fwlxNm
	 */
	public String getFwlxNm() {
		return fwlxNm;
	}

	/**
	 * @param fwlxNm the fwlxNm to set
	 */
	public void setFwlxNm(String fwlxNm) {
		this.fwlxNm = fwlxNm;
	}

	/**
	 * @return the fwlxId
	 */
	public String getFwlxId() {
		return fwlxId;
	}

	/**
	 * @param fwlxId the fwlxId to set
	 */
	public void setFwlxId(String fwlxId) {
		this.fwlxId = fwlxId;
	}

	/**
	 * @return the cgzkNm
	 */
	public String getCgzkNm() {
		return cgzkNm;
	}

	/**
	 * @param cgzkNm the cgzkNm to set
	 */
	public void setCgzkNm(String cgzkNm) {
		this.cgzkNm = cgzkNm;
	}

	/**
	 * @return the cgzkId
	 */
	public String getCgzkId() {
		return cgzkId;
	}

	/**
	 * @param cgzkId the cgzkId to set
	 */
	public void setCgzkId(String cgzkId) {
		this.cgzkId = cgzkId;
	}

	/**
	 * @return the szlc
	 */
	public Short getSzlc() {
		return szlc;
	}

	/**
	 * @param szlc the szlc to set
	 */
	public void setSzlc(Short szlc) {
		this.szlc = szlc;
	}

	/**
	 * @return the jylxNm
	 */
	public String getJylxNm() {
		return jylxNm;
	}

	/**
	 * @param jylxNm the jylxNm to set
	 */
	public void setJylxNm(String jylxNm) {
		this.jylxNm = jylxNm;
	}

	/**
	 * @return the jylxId
	 */
	public String getJylxId() {
		return jylxId;
	}

	/**
	 * @param jylxId the jylxId to set
	 */
	public void setJylxId(String jylxId) {
		this.jylxId = jylxId;
	}

	/**
	 * @return the qtxzNms
	 */
	public String getQtxzNms() {
		return qtxzNms;
	}

	/**
	 * @param qtxzNms the qtxzNms to set
	 */
	public void setQtxzNms(String qtxzNms) {
		this.qtxzNms = qtxzNms;
	}

	/**
	 * @return the qtxzIds
	 */
	public String getQtxzIds() {
		return qtxzIds;
	}

	/**
	 * @param qtxzIds the qtxzIds to set
	 */
	public void setQtxzIds(String qtxzIds) {
		this.qtxzIds = qtxzIds;
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
	 * @return the jzjg
	 */
	public Double getJzjg() {
		return jzjg;
	}

	/**
	 * @param jzjg the jzjg to set
	 */
	public void setJzjg(Double jzjg) {
		this.jzjg = jzjg;
	}

	/**
	 * @return the exportOutCome
	 */
	public Integer getExportOutCome() {
		return exportOutCome;
	}

	/**
	 * @param exportOutCome the exportOutCome to set
	 */
	public void setExportOutCome(Integer exportOutCome) {
		this.exportOutCome = exportOutCome;
	}

	/**
	 * @return the outExcelList
	 */
	public ArrayList<ExcelBean> getOutExcelList() {
		return outExcelList;
	}

	/**
	 * @param outExcelList the outExcelList to set
	 */
	public void setOutExcelList(ArrayList<ExcelBean> outExcelList) {
		this.outExcelList = outExcelList;
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
	 * @return the lfid
	 */
	public String getLfid() {
		return lfid;
	}

	/**
	 * @param lfid the lfid to set
	 */
	public void setLfid(String lfid) {
		this.lfid = lfid;
	}

	

	/**
	 * @return the lfmcId
	 */
	public String getLfmcId() {
		return lfmcId;
	}

	/**
	 * @param lfmcId the lfmcId to set
	 */
	public void setLfmcId(String lfmcId) {
		this.lfmcId = lfmcId;
	}

	/**
	 * @param zhxz the zhxz to set
	 */
	public void setZhxz(String zhxz) {
		this.zhxz = zhxz;
	}

	/**
	 * @return the zhxz
	 */
	public String getZhxz() {
		return zhxz;
	}

	/**
	 * @return the clh
	 */
	public String getClh() {
		return clh;
	}

	/**
	 * @param clh the clh to set
	 */
	public void setClh(String clh) {
		this.clh = clh;
	}

	public Integer getYwjkc() {
		return ywjkc;
	}

	public void setYwjkc(Integer ywjkc) {
		this.ywjkc = ywjkc;
	}

	/**
	 * @return the lc
	 */
	public Short getLc() {
		return lc;
	}

	/**
	 * @param lc the lc to set
	 */
	public void setLc(Short lc) {
		this.lc = lc;
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
	 * @return the yslx
	 */
	public String getYslx() {
		return yslx;
	}

	/**
	 * @param yslx the yslx to set
	 */
	public void setYslx(String yslx) {
		this.yslx = yslx;
	}

	/**
	 * @return the update
	 */
	public Date getUpdate() {
		return update;
	}

	/**
	 * @param update the update to set
	 */
	public void setUpdate(Date update) {
		this.update = update;
	}

	/**
	 * @return the pssd
	 */
	public String getPssd() {
		return pssd;
	}

	/**
	 * @param pssd the pssd to set
	 */
	public void setPssd(String pssd) {
		this.pssd = pssd;
	}

	/**
	 * @return the cd0001Szqylx
	 */
	public String getCd0001Szqylx() {
		return cd0001Szqylx;
	}

	/**
	 * @param cd0001Szqylx the cd0001Szqylx to set
	 */
	public void setCd0001Szqylx(String cd0001Szqylx) {
		this.cd0001Szqylx = cd0001Szqylx;
	}

	public void setZhxzIds(String zhxzIds) {
		this.zhxzIds = zhxzIds;
	}

	public String getZhxzIds() {
		return zhxzIds;
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

	/**
	 * @return the zcdzl
	 */
	public String getZcdzl() {
		return zcdzl;
	}

	/**
	 * @param zcdzl the zcdzl to set
	 */
	public void setZcdzl(String zcdzl) {
		this.zcdzl = zcdzl;
	}

	/**
	 * @return the zcdzlId
	 */
	public String getZcdzlId() {
		return zcdzlId;
	}

	/**
	 * @param zcdzlId the zcdzlId to set
	 */
	public void setZcdzlId(String zcdzlId) {
		this.zcdzlId = zcdzlId;
	}

	public String getPqdmh() {
		return pqdmh;
	}

	public void setPqdmh(String pqdmh) {
		this.pqdmh = pqdmh;
	}

	public String getXqdmh() {
		return xqdmh;
	}

	public void setXqdmh(String xqdmh) {
		this.xqdmh = xqdmh;
	}

	public String getJcnf() {
		return jcnf;
	}

	public void setJcnf(String jcnf) {
		this.jcnf = jcnf;
	}

	public String getXqdmhid() {
		return xqdmhid;
	}

	public void setXqdmhid(String xqdmhid) {
		this.xqdmhid = xqdmhid;
	}

	public double getPfmjg() {
		return pfmjg;
	}

	public void setPfmjg(double pfmjg) {
		this.pfmjg = pfmjg;
	}

	public String getCd00001Jzjg1() {
		return cd00001Jzjg1;
	}

	public void setCd00001Jzjg1(String cd00001Jzjg1) {
		this.cd00001Jzjg1 = cd00001Jzjg1;
	}

	public String getNote1() {
		return note1;
	}

	public void setNote1(String note1) {
		this.note1 = note1;
	}

	public String getZcdzbm() {
		return zcdzbm;
	}

	public void setZcdzbm(String zcdzbm) {
		this.zcdzbm = zcdzbm;
	}

	public String getCd00053Qtxzid() {
		return cd00053Qtxzid;
	}

	public void setCd00053Qtxzid(String cd00053Qtxzid) {
		this.cd00053Qtxzid = cd00053Qtxzid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}



	
}
