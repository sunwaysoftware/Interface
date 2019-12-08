/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Lee
 *
 */
public class Pg30000 implements Serializable {

	private static final long serialVersionUID = 6659972114627981647L;
	private Integer recordCount;
	private Integer recordIndex;
	private Integer pageIndex;
	private Integer pageSize;
	private String fcid;
	private String cd00301Swid;
	private String cd00303Lfid;
	private String cd00001Fwlx;
	private String cd00001Jylx;
	private String cd00001Jzjg;
	private Double jzmj;
	private String cd00001Fwcx;
	private String cd00001Cgzk;
	private Short szlc;
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
	private String cd00352Xqdm;
	private String cd00001Szqy;
	private Short ywdt;
	private Short zlc;
	private String fwtdzl;
	private String xqnm;
	private String xqbm;
	private String szqy;
	private String fwlx;
	private String jylx;
	private String jzjg;
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
	private Integer sczt;
	private ArrayList<Pgv00302> v00302List;
	private String cd00002Scpgczr;
	private String scpgczr;
	private Date pssd;
	private String cd00001Zjlx;
	private String zz;
	
	
	public Pg30000(String fcid){
		this.fcid = fcid;
	}
	
	/** default constructor */
	public Pg30000() {
		this.v00302List = new ArrayList<Pgv00302>();
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
	 * @return the cd00301Swid
	 */
	public String getCd00301Swid() {
		return cd00301Swid;
	}
	/**
	 * @param cd00301Swid the cd00301Swid to set
	 */
	public void setCd00301Swid(String cd00301Swid) {
		this.cd00301Swid = cd00301Swid;
	}
	/**
	 * @return the cd00303Lfid
	 */
	public String getCd00303Lfid() {
		return cd00303Lfid;
	}
	/**
	 * @param cd00303Lfid the cd00303Lfid to set
	 */
	public void setCd00303Lfid(String cd00303Lfid) {
		this.cd00303Lfid = cd00303Lfid;
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
	 * @return the cd00352Xqdm
	 */
	public String getCd00352Xqdm() {
		return cd00352Xqdm;
	}
	/**
	 * @param cd00352Xqdm the cd00352Xqdm to set
	 */
	public void setCd00352Xqdm(String cd00352Xqdm) {
		this.cd00352Xqdm = cd00352Xqdm;
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
	 * @return the sczt
	 */
	public Integer getSczt() {
		return sczt;
	}
	/**
	 * @param sczt the sczt to set
	 */
	public void setSczt(Integer sczt) {
		this.sczt = sczt;
	}
	/**
	 * @return the v00302List
	 */
	public ArrayList<Pgv00302> getV00302List() {
		return v00302List;
	}
	/**
	 * @param v00302List the v00302List to set
	 */
	public void setV00302List(ArrayList<Pgv00302> v00302List) {
		this.v00302List = v00302List;
	}

	/**
	 * @return the cd00002Scpgczr
	 */
	public String getCd00002Scpgczr() {
		return cd00002Scpgczr;
	}

	/**
	 * @param cd00002Scpgczr the cd00002Scpgczr to set
	 */
	public void setCd00002Scpgczr(String cd00002Scpgczr) {
		this.cd00002Scpgczr = cd00002Scpgczr;
	}

	/**
	 * @return the scpgczr
	 */
	public String getScpgczr() {
		return scpgczr;
	}

	/**
	 * @param scpgczr the scpgczr to set
	 */
	public void setScpgczr(String scpgczr) {
		this.scpgczr = scpgczr;
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
	 * @return the zz
	 */
	public String getZz() {
		return zz;
	}

	/**
	 * @param zz the zz to set
	 */
	public void setZz(String zz) {
		this.zz = zz;
	}
}
