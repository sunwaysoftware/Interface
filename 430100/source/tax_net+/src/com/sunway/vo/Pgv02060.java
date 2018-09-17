package com.sunway.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class Pgv02060 extends BaseVO {

	private String fcid;
	private String cd00001Szqy;
	private String szqy;
	private String zcdzl;
	private String zh;
	private String dyh;
	private String cd02050Xqdm;
	private String cd00001Fwlx;
	private Integer sffs;
	private Integer cs;
	private String szcs;
	private String jcnf;
	private String cd00001Jzjg;
	private Double jzmj;
	private String xqnm;
	private String clh;
	private String fwlx;
	private String jzjg;
	private String zhxz;
	private String zhxzId;
	private Timestamp upddate;
	private String note;
	private Date hdrq;
	private Double dxsmj;
	private Double ckmj;
	private String xqdmh;
	private String xqdmhId;
	private String parentdm;
	private String parentnm;
	
	
    
    
    
    
    private String impErrorMsg;
    private Integer outFlag;
    private ArrayList<Pgv02060> outList;
    
    private String cd00002Czr;
    private String czr;
    private String cd00001Ssgx;
    private String ssgx;    
    
    private Date   jysj;
	
	private String fczh;
	
	private String tFczh;
	private String tZcdzl;
	
	private String chkDel;
	private Integer cwxx;
	
	private String expFileName;
	private Double exportS;
	private Double exportE;
	private Integer pgxx;
	private String cd02060aId;
	private BigDecimal pgdj;
	
	private Double mk;  //面宽
	private Double js ;  //进深
	private BigDecimal jyjg;
	private BigDecimal pgjg;//评估价格
	private String bwjfh;//房号
	public String getFcid() {
		return fcid;
	}
	public void setFcid(String fcid) {
		this.fcid = fcid;
	}
	public String getZcdzl() {
		return zcdzl;
	}
	public void setZcdzl(String zcdzl) {
		this.zcdzl = zcdzl;
	}
	public String getZh() {
		return zh;
	}
	public void setZh(String zh) {
		this.zh = zh;
	}
	public String getDyh() {
		return dyh;
	}
	public void setDyh(String dyh) {
		this.dyh = dyh;
	}
	
	public String getCd02050Xqdm() {
		return cd02050Xqdm;
	}
	public void setCd02050Xqdm(String cd02050Xqdm) {
		this.cd02050Xqdm = cd02050Xqdm;
	}
	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}
	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}
	public Integer getSffs() {
		return sffs;
	}
	public void setSffs(Integer sffs) {
		this.sffs = sffs;
	}
	
	public Integer getCs() {
		return cs;
	}
	public void setCs(Integer cs) {
		this.cs = cs;
	}
	public String getSzcs() {
		return szcs;
	}
	public void setSzcs(String szcs) {
		this.szcs = szcs;
	}
	public String getJcnf() {
		return jcnf;
	}
	public void setJcnf(String jcnf) {
		this.jcnf = jcnf;
	}
	public String getCd00001Jzjg() {
		return cd00001Jzjg;
	}
	public void setCd00001Jzjg(String cd00001Jzjg) {
		this.cd00001Jzjg = cd00001Jzjg;
	}
	
	public Double getJzmj() {
		return jzmj;
	}
	public void setJzmj(Double jzmj) {
		this.jzmj = jzmj;
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
	
	public Integer getOutFlag() {
		return outFlag;
	}
	public void setOutFlag(Integer outFlag) {
		this.outFlag = outFlag;
	}
	public ArrayList<Pgv02060> getOutList() {
		return outList;
	}
	public void setOutList(ArrayList<Pgv02060> outList) {
		this.outList = outList;
	}
	public String getSzqy() {
		return szqy;
	}
	public void setSzqy(String szqy) {
		this.szqy = szqy;
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
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}
	public String getSsgx() {
		return ssgx;
	}
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}
	public String getCd00001Szqy() {
		return cd00001Szqy;
	}
	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}
	public String getImpErrorMsg() {
		return impErrorMsg;
	}
	public void setImpErrorMsg(String impErrorMsg) {
		this.impErrorMsg = impErrorMsg;
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
	public String getZhxz() {
		return zhxz;
	}
	public void setZhxz(String zhxz) {
		this.zhxz = zhxz;
	}
	public String getZhxzId() {
		return zhxzId;
	}
	public void setZhxzId(String zhxzId) {
		this.zhxzId = zhxzId;
	}	
	public String getFczh() {
		return fczh;
	}
	public void setFczh(String fczh) {
		this.fczh = fczh;
	}
	public String getChkDel() {
		return chkDel;
	}
	public void setChkDel(String chkDel) {
		this.chkDel = chkDel;
	}

	public Timestamp getUpddate() {
		return upddate;
	}
	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getCwxx() {
		return cwxx;
	}
	public void setCwxx(Integer cwxx) {
		this.cwxx = cwxx;
	}
	public Date getHdrq() {
		return hdrq;
	}
	public void setHdrq(Date hdrq) {
		this.hdrq = hdrq;
	}
	public Double getDxsmj() {
		return dxsmj;
	}
	public void setDxsmj(Double dxsmj) {
		this.dxsmj = dxsmj;
	}
	public Double getCkmj() {
		return ckmj;
	}
	public void setCkmj(Double ckmj) {
		this.ckmj = ckmj;
	}
	public String getXqdmh() {
		return xqdmh;
	}
	public void setXqdmh(String xqdmh) {
		this.xqdmh = xqdmh;
	}
	public String getParentdm() {
		return parentdm;
	}
	public void setParentdm(String parentdm) {
		this.parentdm = parentdm;
	}
	public String getParentnm() {
		return parentnm;
	}
	public void setParentnm(String parentnm) {
		this.parentnm = parentnm;
	}
	public String getXqdmhId() {
		return xqdmhId;
	}
	public void setXqdmhId(String xqdmhId) {
		this.xqdmhId = xqdmhId;
	}

	public String gettFczh() {
		return tFczh;
	}
	public void settFczh(String tFczh) {
		this.tFczh = tFczh;
	}
	public String gettZcdzl() {
		return tZcdzl;
	}
	public void settZcdzl(String tZcdzl) {
		this.tZcdzl = tZcdzl;
	}

	public String getExpFileName() {
		return expFileName;
	}
	public void setExpFileName(String expFileName) {
		this.expFileName = expFileName;
	}
	public Double getExportS() {
		return exportS;
	}
	public void setExportS(Double exportS) {
		this.exportS = exportS;
	}
	public Double getExportE() {
		return exportE;
	}
	public void setExportE(Double exportE) {
		this.exportE = exportE;
	}	
	public Integer getPgxx() {
		return pgxx;
	}
	public void setPgxx(Integer pgxx) {
		this.pgxx = pgxx;
	}
	public String getCd02060aId() {
		return cd02060aId;
	}
	public void setCd02060aId(String cd02060aId) {
		this.cd02060aId = cd02060aId;
	}
	public BigDecimal getPgdj() {
		return pgdj;
	}
	public void setPgdj(BigDecimal pgdj) {
		this.pgdj = pgdj;
	}
	public Double getMk() {
		return mk;
	}
	public void setMk(Double mk) {
		this.mk = mk;
	}
	public Double getJs() {
		return js;
	}
	public void setJs(Double js) {
		this.js = js;
	}
	public String getBwjfh() {
		return bwjfh;
	}
	public void setBwjfh(String bwjfh) {
		this.bwjfh = bwjfh;
	}
	public BigDecimal getJyjg() {
		return jyjg;
	}
	public void setJyjg(BigDecimal jyjg) {
		this.jyjg = jyjg;
	}
	public String getClh() {
		return clh;
	}
	public void setClh(String clh) {
		this.clh = clh;
	}
	
	

}
