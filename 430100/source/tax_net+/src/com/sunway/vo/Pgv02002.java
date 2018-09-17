package com.sunway.vo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Pgv00302 entity.
 * @author Lee
 */

public class Pgv02002 extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = -8225776511983372373L;
	
	
	
	
	private Double exportS;
	private Double exportE;
	private String expFileName;
	private String fcid;
	private String cd00001Fwlx;
	private String cd00001Jylx;
	private String cd00001Jzjg;
	private String cd00001Ghyt;
	private Double jzmj;
	private String cd00001Fwcx;
	private String cd00001Cgzk;
	private String szlc;
	private String szlcmc;
	private String bwjfh;
	private Double jyjg;
	private Double dtgj;
	private Double tdsyqmj;
	private Double rjl;
	private Date jysj;
	private String fdcdat;
	private Date upddate;
	private String cd00002Czr;
	private String note;
	private String nsrmc;
	private String cd00001Ssgx;
	private String cd02050Xqdm;
	private String cd00001Szqy;
	private String ywdt;
	private String zlc;
	private String fwtdzl;
	private String xqnm;
	private String xqbm;
	private String szqy;
	private String fwlx;
	private String jylx;
	private String jzjg;
	private String ghyt;
	private String fwcx;
	private String cgzk;
	private String czr;
	private String ssgx;
	private String sysPssd;
	private Double sumJzmj;
	private Double sumJyjg;
	private Double sumDtgj;
	private Double sumTdsyqmj;
	private Double avgRjl;
    private Double pgjg;
    private Double gbpgjg;
    private Double jsze;
	private Double ynze;
	private Double sumPgjg;
	private Double sumGbpgjg;
	private Double sumJsze;
	private Double sumYnze;
	private Integer syzt;
    private String shCzr;
	private Boolean isInfo;
    private Date sysPssdYMD;
    private String pgCzr;
    private String ssCzr;
	private ArrayList<Pgv02002> v02002List;
	private String zcdzs;
	private String zcdzd;
	private String zcdzl;
	private String zcdzm;
	private String jtzk;
	private String wyzk;
	private String zxzk;
	private String zcdzbm;
	private String lh;
	private String fczh;
	private Double jzmj_min;
	private Double jzmj_max;
	private Double jyjg_min;
	private Double jyjg_max;
	private Date jysj_min;
	private Date jysj_max;
	private Date rdsj_min;
	private Date rdsj_max;
	private Date djrq;
	private String parentdm;
	private String zjlx;
	private String cd00001Zjlx;
	private String lxdh;
	private String zjhm;
	private Double sypgjg;
	private Double sumScpgjg;
	private String zhxz;
	private String clh;
	private Boolean ywjkc;
	private String cd00001csfzjlx;
	private String sbh_zr;
	private String sbh_cs;
	private String csfnsrmc;
	private String csfzjhm;
	private String fcslh;
	private String csfZjlx;
	private Double yjg;
	private Double sbpgjg;
	private String szxx;
	private String df;
	private String cg;
	private String cx;
	private Integer sfsyfc;
	private String ROOMID;
	private String ownRoomid;
	private String OINSID;
	private String fclsh;
	private String xqdmhm;
	private String djz_channel_pwd;
	private String djz_channel_acc;
	private String djz_channel_code;
	private String djz_wbmbm;
	private String id;
	private String cd02020Fcid;
	private Short lx;
	private String oldData;
	private String newData;
	private Short isbg;
	private String htbh;
	
	private Date upddateS;
	private Date upddateE;
	
	private Date upddateSRD;
	private Date upddateERD;
	
	private String fpid;
	private String spid;
	private String dfspid;
	private String csflxdh;
	private String dyh;
	private Integer pgCount;
	private Integer pgwCount;
	private Integer bResult;
	private String jcsj;
	private Date wsrq;
	private Double wsjs;
	private Integer nsrLx_zr;
	private Integer nsrLx_cs;
	private Double mk;
	private Double js;
	private String cd00001Csfzjlx;
	private String sqlData;
	private String order;
	private String sort;
	
	
	/** default constructor */
	public Pgv02002() {
		this.v02002List = new ArrayList<Pgv02002>();
	}

	/**
	 * @param swid
	 */
	public Pgv02002(String fcid) {
		this.fcid = fcid;
	}

	
	/**
	 * @return the fcid
	 */
	public String getFcid() {
		return fcid;
	}
	/**
	 * @param fcid the fcid to set
	 */
	public void setFcid(String fcid) {
		this.fcid = fcid;
	}	
	
	/**
	 * @return the cd00001Fwlx
	 */
	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}
	/**
	 * @param cd00001Fwlx the cd00001Fwlx to set
	 */
	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}
	/**
	 * @return the cd00001Jylx
	 */
	public String getCd00001Jylx() {
		return cd00001Jylx;
	}
	/**
	 * @param cd00001Jylx the cd00001Jylx to set
	 */
	public void setCd00001Jylx(String cd00001Jylx) {
		this.cd00001Jylx = cd00001Jylx;
	}
	/**
	 * @return the cd00001Jzjg
	 */
	public String getCd00001Jzjg() {
		return cd00001Jzjg;
	}
	/**
	 * @param cd00001Jzjg the cd00001Jzjg to set
	 */
	public void setCd00001Jzjg(String cd00001Jzjg) {
		this.cd00001Jzjg = cd00001Jzjg;
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
	 * @return the szlc
	 */
	public String getSzlc() {
		return szlc;
	}
	/**
	 * @param szlc the szlc to set
	 */
	public void setSzlc(String szlc) {
		this.szlc = szlc;
	}
	/**
	 * @return the bwjfh
	 */
	public String getBwjfh() {
		return bwjfh;
	}
	/**
	 * @param bwjfh the bwjfh to set
	 */
	public void setBwjfh(String bwjfh) {
		this.bwjfh = bwjfh;
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
	 * @return the dtgj
	 */
	public Double getDtgj() {
		return dtgj;
	}
	/**
	 * @param dtgj the dtgj to set
	 */
	public void setDtgj(Double dtgj) {
		this.dtgj = dtgj;
	}
	/**
	 * @return the tdsyqmj
	 */
	public Double getTdsyqmj() {
		return tdsyqmj;
	}
	/**
	 * @param tdsyqmj the tdsyqmj to set
	 */
	public void setTdsyqmj(Double tdsyqmj) {
		this.tdsyqmj = tdsyqmj;
	}
	/**
	 * @return the rjl
	 */
	public Double getRjl() {
		return rjl;
	}
	/**
	 * @param rjl the rjl to set
	 */
	public void setRjl(Double rjl) {
		this.rjl = rjl;
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
	 * @return the fdcdat
	 */
	public String getFdcdat() {
		return fdcdat;
	}
	/**
	 * @param fdcdat the fdcdat to set
	 */
	public void setFdcdat(String fdcdat) {
		this.fdcdat = fdcdat;
	}
	/**
	 * @return the upddate
	 */
	public Date getUpddate() {
		return upddate;
	}
	/**
	 * @param upddate the upddate to set
	 */
	public void setUpddate(Date upddate) {
		this.upddate = upddate;
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
	 * @return the nsrmc
	 */
	public String getNsrmc() {
		return nsrmc;
	}
	/**
	 * @param nsrmc the nsrmc to set
	 */
	public void setNsrmc(String nsrmc) {
		this.nsrmc = nsrmc;
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
	 * @return the cd02050Xqdm
	 */
	public String getCd02050Xqdm() {
		return cd02050Xqdm;
	}
	/**
	 * @param cd02050Xqdm the cd02050Xqdm to set
	 */
	public void setCd02050Xqdm(String cd02050Xqdm) {
		this.cd02050Xqdm = cd02050Xqdm;
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
	 * @return the ywdt
	 */
	public String getYwdt() {
		return ywdt;
	}
	/**
	 * @param ywdt the ywdt to set
	 */
	public void setYwdt(String ywdt) {
		this.ywdt = ywdt;
	}
	/**
	 * @return the zlc
	 */
	public String getZlc() {
		return zlc;
	}
	/**
	 * @param zlc the zlc to set
	 */
	public void setZlc(String zlc) {
		this.zlc = zlc;
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
	 * @return the xqbm
	 */
	public String getXqbm() {
		return xqbm;
	}
	/**
	 * @param xqbm the xqbm to set
	 */
	public void setXqbm(String xqbm) {
		this.xqbm = xqbm;
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
	 * @param sysPssd the sysPssd to set
	 */
	public void setSysPssd(String sysPssd) {
		this.sysPssd = sysPssd;
	}
	/**
	 * @return the sysPssd
	 */
	public String getSysPssd() {
		return sysPssd;
	}
	/**
	 * @return the sumJzmj
	 */
	public Double getSumJzmj() {
		return sumJzmj;
	}
	/**
	 * @param sumJzmj the sumJzmj to set
	 */
	public void setSumJzmj(Double sumJzmj) {
		this.sumJzmj = sumJzmj;
	}
	/**
	 * @return the sumJyjg
	 */
	public Double getSumJyjg() {
		return sumJyjg;
	}
	/**
	 * @param sumJyjg the sumJyjg to set
	 */
	public void setSumJyjg(Double sumJyjg) {
		this.sumJyjg = sumJyjg;
	}
	/**
	 * @return the sumDtgj
	 */
	public Double getSumDtgj() {
		return sumDtgj;
	}
	/**
	 * @param sumDtgj the sumDtgj to set
	 */
	public void setSumDtgj(Double sumDtgj) {
		this.sumDtgj = sumDtgj;
	}
	/**
	 * @return the sumTdsyqmj
	 */
	public Double getSumTdsyqmj() {
		return sumTdsyqmj;
	}
	/**
	 * @param sumTdsyqmj the sumTdsyqmj to set
	 */
	public void setSumTdsyqmj(Double sumTdsyqmj) {
		this.sumTdsyqmj = sumTdsyqmj;
	}
	/**
	 * @return the avgRjl
	 */
	public Double getAvgRjl() {
		return avgRjl;
	}
	/**
	 * @param avgRjl the avgRjl to set
	 */
	public void setAvgRjl(Double avgRjl) {
		this.avgRjl = avgRjl;
	}
	/**
	 * @return the pgjg
	 */
	public Double getPgjg() {
		return pgjg;
	}
	/**
	 * @param pgjg the pgjg to set
	 */
	public void setPgjg(Double pgjg) {
		this.pgjg = pgjg;
	}
	/**
	 * @return the gbpgjg
	 */
	public Double getGbpgjg() {
		return gbpgjg;
	}
	/**
	 * @param gbpgjg the gbpgjg to set
	 */
	public void setGbpgjg(Double gbpgjg) {
		this.gbpgjg = gbpgjg;
	}
	/**
	 * @return the jsze
	 */
	public Double getJsze() {
		return jsze;
	}
	/**
	 * @param jsze the jsze to set
	 */
	public void setJsze(Double jsze) {
		this.jsze = jsze;
	}
	/**
	 * @return the ynze
	 */
	public Double getYnze() {
		return ynze;
	}
	/**
	 * @param ynze the ynze to set
	 */
	public void setYnze(Double ynze) {
		this.ynze = ynze;
	}
	/**
	 * @return the sumPgjg
	 */
	public Double getSumPgjg() {
		return sumPgjg;
	}
	/**
	 * @param sumPgjg the sumPgjg to set
	 */
	public void setSumPgjg(Double sumPgjg) {
		this.sumPgjg = sumPgjg;
	}
	/**
	 * @return the sumGbpgjg
	 */
	public Double getSumGbpgjg() {
		return sumGbpgjg;
	}

	/**
	 * @param sumGbpgjg the sumGbpgjg to set
	 */
	public void setSumGbpgjg(Double sumGbpgjg) {
		this.sumGbpgjg = sumGbpgjg;
	}
	/**
	 * @return the sumJsze
	 */
	public Double getSumJsze() {
		return sumJsze;
	}
	/**
	 * @param sumJsze the sumJsze to set
	 */
	public void setSumJsze(Double sumJsze) {
		this.sumJsze = sumJsze;
	}
	/**
	 * @return the sumYnze
	 */
	public Double getSumYnze() {
		return sumYnze;
	}
	/**
	 * @param sumYnze the sumYnze to set
	 */
	public void setSumYnze(Double sumYnze) {
		this.sumYnze = sumYnze;
	}	
	/**
	 * @return the shCzr
	 */
	public String getShCzr() {
		return shCzr;
	}
	/**
	 * @param shCzr the shCzr to set
	 */
	public void setShCzr(String shCzr) {
		this.shCzr = shCzr;
	}
	/**
	 * @return the isInfo
	 */
	public Boolean getIsInfo() {
		return isInfo;
	}
	/**
	 * @param isInfo the isInfo to set
	 */
	public void setIsInfo(Boolean isInfo) {
		this.isInfo = isInfo;
	}
	/**
	 * @return the sysPssdYMD
	 */
	public Date getSysPssdYMD() {
		return sysPssdYMD;
	}
	/**
	 * @param sysPssdYMD the sysPssdYMD to set
	 */
	public void setSysPssdYMD(Date sysPssdYMD) {
		this.sysPssdYMD = sysPssdYMD;
	}
	/**
	 * @return the pgCzr
	 */
	public String getPgCzr() {
		return pgCzr;
	}
	/**
	 * @param pgCzr the pgCzr to set
	 */
	public void setPgCzr(String pgCzr) {
		this.pgCzr = pgCzr;
	}
	/**
	 * @return the ssCzr
	 */
	public String getSsCzr() {
		return ssCzr;
	}
	/**
	 * @param ssCzr the ssCzr to set
	 */
	public void setSsCzr(String ssCzr) {
		this.ssCzr = ssCzr;
	}
	/**
	 * @return the v02002List
	 */
	public ArrayList<Pgv02002> getV02002List() {
		return v02002List;
	}
	/**
	 * @param v02002List the v00302List to set
	 */
	public void setV02002List(ArrayList<Pgv02002> v02002List) {
		this.v02002List = v02002List;
	}

	/**
	 * @return the zcdzs
	 */
	public String getZcdzs() {
		return zcdzs;
	}

	/**
	 * @param zcdzs the zcdzs to set
	 */
	public void setZcdzs(String zcdzs) {
		this.zcdzs = zcdzs;
	}

	/**
	 * @return the zcdzd
	 */
	public String getZcdzd() {
		return zcdzd;
	}

	/**
	 * @param zcdzd the zcdzd to set
	 */
	public void setZcdzd(String zcdzd) {
		this.zcdzd = zcdzd;
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
	 * @return the zcdzm
	 */
	public String getZcdzm() {
		return zcdzm;
	}

	/**
	 * @param zcdzm the zcdzm to set
	 */
	public void setZcdzm(String zcdzm) {
		this.zcdzm = zcdzm;
	}
	
	/**
	 * @return the jtzk
	 */
	public String getJtzk() {
		return jtzk;
	}

	/**
	 * @param jtzk the jtzk to set
	 */
	public void setJtzk(String jtzk) {
		this.jtzk = jtzk;
	}

	/**
	 * @return the wyzk
	 */
	public String getWyzk() {
		return wyzk;
	}

	/**
	 * @param wyzk the wyzk to set
	 */
	public void setWyzk(String wyzk) {
		this.wyzk = wyzk;
	}

	/**
	 * @return the zxzk
	 */
	public String getZxzk() {
		return zxzk;
	}

	/**
	 * @param zxzk the zxzk to set
	 */
	public void setZxzk(String zxzk) {
		this.zxzk = zxzk;
	}

	/**
	 * @return the zcdzbm
	 */
	public String getZcdzbm() {
		return zcdzbm;
	}

	/**
	 * @param zcdzbm the zcdzbm to set
	 */
	public void setZcdzbm(String zcdzbm) {
		this.zcdzbm = zcdzbm;
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

	/**
	 * @return the fczh
	 */
	public String getFczh() {
		return fczh;
	}

	/**
	 * @param fczh the fczh to set
	 */
	public void setFczh(String fczh) {
		this.fczh = fczh;
	}

	/**
	 * @return the jzmj_min
	 */
	public Double getJzmj_min() {
		return jzmj_min;
	}

	/**
	 * @param jzmjMin the jzmj_min to set
	 */
	public void setJzmj_min(Double jzmjMin) {
		jzmj_min = jzmjMin;
	}

	/**
	 * @return the jzmj_max
	 */
	public Double getJzmj_max() {
		return jzmj_max;
	}

	/**
	 * @param jzmjMax the jzmj_max to set
	 */
	public void setJzmj_max(Double jzmjMax) {
		jzmj_max = jzmjMax;
	}

	/**
	 * @return the jyjg_min
	 */
	public Double getJyjg_min() {
		return jyjg_min;
	}

	/**
	 * @param jyjgMin the jyjg_min to set
	 */
	public void setJyjg_min(Double jyjgMin) {
		jyjg_min = jyjgMin;
	}

	/**
	 * @return the jyjg_max
	 */
	public Double getJyjg_max() {
		return jyjg_max;
	}

	/**
	 * @param jyjgMax the jyjg_max to set
	 */
	public void setJyjg_max(Double jyjgMax) {
		jyjg_max = jyjgMax;
	}

	/**
	 * @return the jysj_min
	 */
	public Date getJysj_min() {
		return jysj_min;
	}

	/**
	 * @param jysjMin the jysj_min to set
	 */
	public void setJysj_min(Date jysjMin) {
		jysj_min = jysjMin;
	}

	/**
	 * @return the jysj_max
	 */
	public Date getJysj_max() {
		return jysj_max;
	}

	/**
	 * @param jysjMax the jysj_max to set
	 */
	public void setJysj_max(Date jysjMax) {
		jysj_max = jysjMax;
	}

	/**
	 * @return the djrq
	 */
	public Date getDjrq() {
		return djrq;
	}

	/**
	 * @param djrq the djrq to set
	 */
	public void setDjrq(Date djrq) {
		this.djrq = djrq;
	}

	/**
	 * @return the parentdm
	 */
	public String getParentdm() {
		return parentdm;
	}

	/**
	 * @param parentdm the parentdm to set
	 */
	public void setParentdm(String parentdm) {
		this.parentdm = parentdm;
	}

	/**
	 * @return the zjlx
	 */
	public String getZjlx() {
		return zjlx;
	}

	/**
	 * @param zjlx the zjlx to set
	 */
	public void setZjlx(String zjlx) {
		this.zjlx = zjlx;
	}

	/**
	 * @return the cd00001Zjlx
	 */
	public String getCd00001Zjlx() {
		return cd00001Zjlx;
	}

	/**
	 * @param cd00001Zjlx the cd00001Zjlx to set
	 */
	public void setCd00001Zjlx(String cd00001Zjlx) {
		this.cd00001Zjlx = cd00001Zjlx;
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
	 * @return the scpgjg
	 */
	public Double getSypgjg() {
		return sypgjg;
	}

	/**
	 * @param scpgjg the scpgjg to set
	 */
	public void setSypgjg(Double sypgjg) {
		this.sypgjg = sypgjg;
	}

	/**
	 * @return the sumScpgjg
	 */
	public Double getSumScpgjg() {
		return sumScpgjg;
	}

	/**
	 * @param sumScpgjg the sumScpgjg to set
	 */
	public void setSumScpgjg(Double sumScpgjg) {
		this.sumScpgjg = sumScpgjg;
	}

	/**
	 * @return the zhxz
	 */
	public String getZhxz() {
		return zhxz;
	}

	/**
	 * @param zhxz the zhxz to set
	 */
	public void setZhxz(String zhxz) {
		this.zhxz = zhxz;
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

	public Boolean getYwjkc() {
		return ywjkc;
	}

	public void setYwjkc(Boolean ywjkc) {
		this.ywjkc = ywjkc;
	}

	/**
	 * @return the cd00001Ghyt
	 */
	public String getCd00001Ghyt() {
		return cd00001Ghyt;
	}

	/**
	 * @param cd00001Ghyt the cd00001Ghyt to set
	 */
	public void setCd00001Ghyt(String cd00001Ghyt) {
		this.cd00001Ghyt = cd00001Ghyt;
	}

	/**
	 * @return the ghyt
	 */
	public String getGhyt() {
		return ghyt;
	}

	/**
	 * @param ghyt the ghyt to set
	 */
	public void setGhyt(String ghyt) {
		this.ghyt = ghyt;
	}

	

	/**
	 * @return the csfnsrmc
	 */
	public String getCsfnsrmc() {
		return csfnsrmc;
	}

	/**
	 * @param csfnsrmc the csfnsrmc to set
	 */
	public void setCsfnsrmc(String csfnsrmc) {
		this.csfnsrmc = csfnsrmc;
	}

	

	/**
	 * @return the fcslh
	 */
	public String getFcslh() {
		return fcslh;
	}

	/**
	 * @param fcslh the fcslh to set
	 */
	public void setFcslh(String fcslh) {
		this.fcslh = fcslh;
	}

	

	/**
	 * @return the csfzjhm
	 */
	public String getCsfzjhm() {
		return csfzjhm;
	}

	/**
	 * @param csfzjhm the csfzjhm to set
	 */
	public void setCsfzjhm(String csfzjhm) {
		this.csfzjhm = csfzjhm;
	}

	/**
	 * @return the csfZjlx
	 */
	public String getCsfZjlx() {
		return csfZjlx;
	}

	/**
	 * @param csfZjlx the csfZjlx to set
	 */
	public void setCsfZjlx(String csfZjlx) {
		this.csfZjlx = csfZjlx;
	}

	/**
	 * @return the cd00001csfzjlx
	 */
	public String getCd00001csfzjlx() {
		return cd00001csfzjlx;
	}

	/**
	 * @param cd00001csfzjlx the cd00001csfzjlx to set
	 */
	public void setCd00001csfzjlx(String cd00001csfzjlx) {
		this.cd00001csfzjlx = cd00001csfzjlx;
	}

	public Double getYjg() {
		return yjg;
	}

	public void setYjg(Double yjg) {
		this.yjg = yjg;
	}

	public Double getSbpgjg() {
		return sbpgjg;
	}

	public void setSbpgjg(Double sbpgjg) {
		this.sbpgjg = sbpgjg;
	}

	public String getSzxx() {
		return szxx;
	}

	public void setSzxx(String szxx) {
		this.szxx = szxx;
	}

	public String getDf() {
		return df;
	}

	public void setDf(String df) {
		this.df = df;
	}

	public String getCg() {
		return cg;
	}

	public void setCg(String cg) {
		this.cg = cg;
	}

	public String getCx() {
		return cx;
	}

	public void setCx(String cx) {
		this.cx = cx;
	}

	public Integer getSfsyfc() {
		return sfsyfc;
	}

	public void setSfsyfc(Integer sfsyfc) {
		this.sfsyfc = sfsyfc;
	}

	public void setSzlcmc(String szlcmc) {
		this.szlcmc = szlcmc;
	}

	public String getSzlcmc() {
		return szlcmc;
	}

	public String getROOMID() {
		return ROOMID;
	}

	public void setROOMID(String rOOMID) {
		ROOMID = rOOMID;
	}

	public String getOwnRoomid() {
		return ownRoomid;
	}

	public void setOwnRoomid(String ownRoomid) {
		this.ownRoomid = ownRoomid;
	}

	public String getOINSID() {
		return OINSID;
	}

	public void setOINSID(String oINSID) {
		OINSID = oINSID;
	}

	public String getFclsh() {
		return fclsh;
	}

	public void setFclsh(String fclsh) {
		this.fclsh = fclsh;
	}

	public String getDjz_channel_pwd() {
		return djz_channel_pwd;
	}

	public void setDjz_channel_pwd(String djzChannelPwd) {
		djz_channel_pwd = djzChannelPwd;
	}

	public String getDjz_channel_acc() {
		return djz_channel_acc;
	}

	public void setDjz_channel_acc(String djzChannelAcc) {
		djz_channel_acc = djzChannelAcc;
	}

	public String getDjz_channel_code() {
		return djz_channel_code;
	}

	public void setDjz_channel_code(String djzChannelCode) {
		djz_channel_code = djzChannelCode;
	}

	public String getDjz_wbmbm() {
		return djz_wbmbm;
	}

	public void setDjz_wbmbm(String djzWbmbm) {
		djz_wbmbm = djzWbmbm;
	}

	public Date getUpddateS() {
		return upddateS;
	}

	public void setUpddateS(Date upddateS) {
		this.upddateS = upddateS;
	}

	public Date getUpddateE() {
		return upddateE;
	}

	public void setUpddateE(Date upddateE) {
		this.upddateE = upddateE;
	}

	/**
	 * @return the fpid
	 */
	public String getFpid() {
		return fpid;
	}

	/**
	 * @param fpid the fpid to set
	 */
	public void setFpid(String fpid) {
		this.fpid = fpid;
	}

	/**
	 * @return the spid
	 */
	public String getSpid() {
		return spid;
	}

	/**
	 * @param spid the spid to set
	 */
	public void setSpid(String spid) {
		this.spid = spid;
	}

	/**
	 * @return the dfspid
	 */
	public String getDfspid() {
		return dfspid;
	}

	/**
	 * @param dfspid the dfspid to set
	 */
	public void setDfspid(String dfspid) {
		this.dfspid = dfspid;
	}

	public String getCsflxdh() {
		return csflxdh;
	}

	public void setCsflxdh(String csflxdh) {
		this.csflxdh = csflxdh;
	}

	/**
	 * @return the dyh
	 */
	public String getDyh() {
		return dyh;
	}
	
	/**
	 * @param dyh the dyh to set
	 */
	public void setDyh(String dyh) {
		this.dyh = dyh;
	}

	public Date getUpddateSRD() {
		return upddateSRD;
	}	

	public void setUpddateSRD(Date upddateSRD) {
		this.upddateSRD = upddateSRD;
	}

	public Date getUpddateERD() {
		return upddateERD;
	}

	public void setUpddateERD(Date upddateERD) {
		this.upddateERD = upddateERD;
	}

	public Integer getPgCount() {
		return pgCount;
	}

	public void setPgCount(Integer pgCount) {
		this.pgCount = pgCount;
	}

	public Integer getPgwCount() {
		return pgwCount;
	}

	public void setPgwCount(Integer pgwCount) {
		this.pgwCount = pgwCount;
	}

	public Integer getbResult() {
		return bResult;
	}

	public void setbResult(Integer bResult) {
		this.bResult = bResult;
	}

	public String getJcsj() {
		return jcsj;
	}

	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}

	/**
	 * @return the wsrq
	 */
	public Date getWsrq() {
		return wsrq;
	}

	/**
	 * @param wsrq the wsrq to set
	 */
	public void setWsrq(Date wsrq) {
		this.wsrq = wsrq;
	}

	/**
	 * @return the wsjs
	 */
	public Double getWsjs() {
		return wsjs;
	}

	/**
	 * @param wsjs the wsjs to set
	 */
	public void setWsjs(Double wsjs) {
		this.wsjs = wsjs;
	}

	/**
	 * @return the sbh_zr
	 */
	public String getSbh_zr() {
		return sbh_zr;
	}

	/**
	 * @param sbh_zr the sbh_zr to set
	 */
	public void setSbh_zr(String sbh_zr) {
		this.sbh_zr = sbh_zr;
	}

	/**
	 * @return the sbh_cs
	 */
	public String getSbh_cs() {
		return sbh_cs;
	}

	/**
	 * @param sbh_cs the sbh_cs to set
	 */
	public void setSbh_cs(String sbh_cs) {
		this.sbh_cs = sbh_cs;
	}

	/**
	 * @return the cd00001Csfzjlx
	 */
	public String getCd00001Csfzjlx() {
		return cd00001Csfzjlx;
	}

	/**
	 * @param cd00001Csfzjlx the cd00001Csfzjlx to set
	 */
	public void setCd00001Csfzjlx(String cd00001Csfzjlx) {
		this.cd00001Csfzjlx = cd00001Csfzjlx;
	}

	public Integer getNsrLx_zr() {
		return nsrLx_zr;
	}

	public void setNsrLx_zr(Integer nsrLx_zr) {
		this.nsrLx_zr = nsrLx_zr;
	}

	public Integer getNsrLx_cs() {
		return nsrLx_cs;
	}

	public void setNsrLx_cs(Integer nsrLx_cs) {
		this.nsrLx_cs = nsrLx_cs;
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

	public String getXqdmhm() {
		return xqdmhm;
	}

	public void setXqdmhm(String xqdmhm) {
		this.xqdmhm = xqdmhm;
	}

	public Date getRdsj_min() {
		return rdsj_min;
	}

	public void setRdsj_min(Date rdsj_min) {
		this.rdsj_min = rdsj_min;
	}

	public Date getRdsj_max() {
		return rdsj_max;
	}

	public void setRdsj_max(Date rdsj_max) {
		this.rdsj_max = rdsj_max;
	}

	public Integer getSyzt() {
		return syzt;
	}

	public void setSyzt(Integer syzt) {
		this.syzt = syzt;
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

	public String getExpFileName() {
		return expFileName;
	}

	public void setExpFileName(String expFileName) {
		this.expFileName = expFileName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCd02020Fcid() {
		return cd02020Fcid;
	}

	public void setCd02020Fcid(String cd02020Fcid) {
		this.cd02020Fcid = cd02020Fcid;
	}

	public Short getLx() {
		return lx;
	}

	public void setLx(Short lx) {
		this.lx = lx;
	}

	public String getOldData() {
		return oldData;
	}

	public void setOldData(String oldData) {
		this.oldData = oldData;
	}

	public String getNewData() {
		return newData;
	}

	public void setNewData(String newData) {
		this.newData = newData;
	}

	public Short getIsbg() {
		return isbg;
	}

	public void setIsbg(Short isbg) {
		this.isbg = isbg;
	}

	/**
	 * @return the htbh
	 */
	public String getHtbh() {
		return htbh;
	}

	/**
	 * @param htbh the htbh to set
	 */
	public void setHtbh(String htbh) {
		this.htbh = htbh;
	}






}
