package com.sunway.vo;

import java.util.Date;

/**
 * PgvPsjgjyCB
 * @author Lee
 */


public class Pgv100314 implements java.io.Serializable {

	private static final long serialVersionUID = 6525100154599627071L;
	// Fields
	private String cd12004Mxid;
	private Double fcpgjg;
	private Double dcpgjg;
	private Double pgjg;
	private String cd00002Pssdy;
	private String cd00002Pssd;
	private Double cxl;
	private Double czl;
	private Long ysynx;
	private Long jjnynx;
	private Double jazj;
	private Double jjbbl;
	private Double jzmj;
	private Double rjlxs;
	private Double psss;
	private Double dj;
	private Double gyttdmj;
	private Double cqf;
	private String tdyt;
	private Double gbrjl;
	private String szqy;
	private String tddj;
	private String fwyt;
	private String xjbz;
	private String jzjg;
	private Date upddate;
	private String czr;
	private String note;
	private Double dcqtxz;
	private Double fcqtxz;
	private Double gbfcpgjg;
	private Double gbdcpgjg;
	private Double gbpgjg;
	private Double gbfcxzxs;
	private Double gbdcxzxs;
	private String cd12001Swid;
	private String nsrmc;
	private Integer recordCount;
    private Integer recordIndex;    
    private Integer pageIndex;
    private Integer pageSize; 
    private String cbpgczr;
    private String cd00001Ssgx;
    private Double cbpgjg;
    private Double cbfcpgjg;
    private Double cbdcpgjg;
    private String jcnfbgn;
    private String jcnfend;
    private String cd00001Tdyt;
    private String cd00001Fwyt;
    private String cd00001Jzjg;
    
	// Constructors

	/** default constructor */
	public Pgv100314() {
	}

	public Pgv100314(String cd12001Swid, String cd00002Pssdy) {
		this.cd12001Swid = cd12001Swid;
		this.cd00002Pssdy = cd00002Pssdy;
	}
	
	/**
	 * full constructor
	 */
	public Pgv100314(String cd12004Mxid, Double fcpgjg, Double dcpgjg,
			Double pgjg, String cd00002Pssdy,Double cxl,
			Double czl, Long ysynx, Long jjnynx, Double jazj, Double jjbbl,
			Double jzmj, Double rjlxs, Double psss, Double dj, Double gyttdmj,
			Double cqf, String tdyt, Double gbrjl, String szqy, String tddj,
			String fwyt, String xjbz, String jzjg, Date upddate, String czr,
			String note, Double dcqtxz, Double fcqtxz, Double gbfcpgjg,
			Double gbdcpgjg, Double gbpgjg, Double gbfcxzxs, Double gbdcxzxs,
			String cd12001Swid, String nsrmc, Integer recordCount,
			Integer recordIndex, Integer pageIndex, Integer pageSize
			) {
		this.cd12004Mxid = cd12004Mxid;
		this.fcpgjg = fcpgjg;
		this.dcpgjg = dcpgjg;
		this.pgjg = pgjg;
		this.cd00002Pssdy = cd00002Pssdy;
		this.cxl = cxl;
		this.czl = czl;
		this.ysynx = ysynx;
		this.jjnynx = jjnynx;
		this.jazj = jazj;
		this.jjbbl = jjbbl;
		this.jzmj = jzmj;
		this.rjlxs = rjlxs;
		this.psss = psss;
		this.dj = dj;
		this.gyttdmj = gyttdmj;
		this.cqf = cqf;
		this.tdyt = tdyt;
		this.gbrjl = gbrjl;
		this.szqy = szqy;
		this.tddj = tddj;
		this.fwyt = fwyt;
		this.xjbz = xjbz;
		this.jzjg = jzjg;
		this.upddate = upddate;
		this.czr = czr;
		this.note = note;
		this.dcqtxz = dcqtxz;
		this.fcqtxz = fcqtxz;
		this.gbfcpgjg = gbfcpgjg;
		this.gbdcpgjg = gbdcpgjg;
		this.gbpgjg = gbpgjg;
		this.gbfcxzxs = gbfcxzxs;
		this.gbdcxzxs = gbdcxzxs;
		this.cd12001Swid = cd12001Swid;
		this.nsrmc = nsrmc;
		this.recordCount = recordCount;
		this.recordIndex = recordIndex;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	/**
	 * minimal constructor
	 * @param cd12001Swid
	 * @param nsrmc
	 * @param pageIndex
	 * @param pageSize
	 * @param sysPssd
	 * @param sysSsgx
	 */
	public Pgv100314(String cd12001Swid, String nsrmc, Integer pageIndex,
			Integer pageSize) {
		this.cd12001Swid = cd12001Swid;
		this.nsrmc = nsrmc;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
	}

	/**
	 * @param fcpgjg
	 * @param dcpgjg
	 * @param pgjg
	 * @param gbfcpgjg
	 * @param gbdcpgjg
	 * @param gbpgjg
	 * @param cd12001Swid
	 * @param nsrmc
	 * @param recordCount
	 * @param recordIndex
	 */
	public Pgv100314(Double fcpgjg, Double dcpgjg, Double pgjg, Double gbfcpgjg,
			Double gbdcpgjg, Double gbpgjg, String cd12001Swid, String nsrmc, String cbpgczr,
			Integer recordCount, Integer recordIndex) {
		this.fcpgjg = fcpgjg;
		this.dcpgjg = dcpgjg;
		this.pgjg = pgjg;
		this.gbfcpgjg = gbfcpgjg;
		this.gbdcpgjg = gbdcpgjg;
		this.gbpgjg = gbpgjg;
		this.cd12001Swid = cd12001Swid;
		this.nsrmc = nsrmc;
		this.cbpgczr = cbpgczr;
		this.recordCount = recordCount;
		this.recordIndex = recordIndex;
	}

	// Property accessors
	
	/**
	 * @return the cd12004Mxid
	 */
	public String getCd12004Mxid() {
		return cd12004Mxid;
	}

	/**
	 * @param cd12004Mxid the cd12004Mxid to set
	 */
	public void setCd12004Mxid(String cd12004Mxid) {
		this.cd12004Mxid = cd12004Mxid;
	}

	/**
	 * @return the fcpgjg
	 */
	public Double getFcpgjg() {
		return fcpgjg;
	}

	/**
	 * @param fcpgjg the fcpgjg to set
	 */
	public void setFcpgjg(Double fcpgjg) {
		this.fcpgjg = fcpgjg;
	}

	/**
	 * @return the dcpgjg
	 */
	public Double getDcpgjg() {
		return dcpgjg;
	}

	/**
	 * @param dcpgjg the dcpgjg to set
	 */
	public void setDcpgjg(Double dcpgjg) {
		this.dcpgjg = dcpgjg;
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
	 * @return the cd00002Pssdy
	 */
	public String getCd00002Pssdy() {
		return cd00002Pssdy;
	}

	/**
	 * @param cd00002Pssdy the cd00002Pssdy to set
	 */
	public void setCd00002Pssdy(String cd00002Pssdy) {
		this.cd00002Pssdy = cd00002Pssdy;
	}

	/**
	 * @return the cxl
	 */
	public Double getCxl() {
		return cxl;
	}

	/**
	 * @param cxl the cxl to set
	 */
	public void setCxl(Double cxl) {
		this.cxl = cxl;
	}

	/**
	 * @return the czl
	 */
	public Double getCzl() {
		return czl;
	}

	/**
	 * @param czl the czl to set
	 */
	public void setCzl(Double czl) {
		this.czl = czl;
	}

	/**
	 * @return the ysynx
	 */
	public Long getYsynx() {
		return ysynx;
	}

	/**
	 * @param ysynx the ysynx to set
	 */
	public void setYsynx(Long ysynx) {
		this.ysynx = ysynx;
	}

	/**
	 * @return the jjnynx
	 */
	public Long getJjnynx() {
		return jjnynx;
	}

	/**
	 * @param jjnynx the jjnynx to set
	 */
	public void setJjnynx(Long jjnynx) {
		this.jjnynx = jjnynx;
	}

	/**
	 * @return the jazj
	 */
	public Double getJazj() {
		return jazj;
	}

	/**
	 * @param jazj the jazj to set
	 */
	public void setJazj(Double jazj) {
		this.jazj = jazj;
	}

	/**
	 * @return the jjbbl
	 */
	public Double getJjbbl() {
		return jjbbl;
	}

	/**
	 * @param jjbbl the jjbbl to set
	 */
	public void setJjbbl(Double jjbbl) {
		this.jjbbl = jjbbl;
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
	 * @return the rjlxs
	 */
	public Double getRjlxs() {
		return rjlxs;
	}

	/**
	 * @param rjlxs the rjlxs to set
	 */
	public void setRjlxs(Double rjlxs) {
		this.rjlxs = rjlxs;
	}

	/**
	 * @return the psss
	 */
	public Double getPsss() {
		return psss;
	}

	/**
	 * @param psss the psss to set
	 */
	public void setPsss(Double psss) {
		this.psss = psss;
	}

	/**
	 * @return the dj
	 */
	public Double getDj() {
		return dj;
	}

	/**
	 * @param dj the dj to set
	 */
	public void setDj(Double dj) {
		this.dj = dj;
	}

	/**
	 * @return the gyttdmj
	 */
	public Double getGyttdmj() {
		return gyttdmj;
	}

	/**
	 * @param gyttdmj the gyttdmj to set
	 */
	public void setGyttdmj(Double gyttdmj) {
		this.gyttdmj = gyttdmj;
	}

	/**
	 * @return the cqf
	 */
	public Double getCqf() {
		return cqf;
	}

	/**
	 * @param cqf the cqf to set
	 */
	public void setCqf(Double cqf) {
		this.cqf = cqf;
	}

	/**
	 * @return the tdyt
	 */
	public String getTdyt() {
		return tdyt;
	}

	/**
	 * @param tdyt the tdyt to set
	 */
	public void setTdyt(String tdyt) {
		this.tdyt = tdyt;
	}

	/**
	 * @return the gbrjl
	 */
	public Double getGbrjl() {
		return gbrjl;
	}

	/**
	 * @param gbrjl the gbrjl to set
	 */
	public void setGbrjl(Double gbrjl) {
		this.gbrjl = gbrjl;
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
	 * @return the tddj
	 */
	public String getTddj() {
		return tddj;
	}

	/**
	 * @param tddj the tddj to set
	 */
	public void setTddj(String tddj) {
		this.tddj = tddj;
	}

	/**
	 * @return the fwyt
	 */
	public String getFwyt() {
		return fwyt;
	}

	/**
	 * @param fwyt the fwyt to set
	 */
	public void setFwyt(String fwyt) {
		this.fwyt = fwyt;
	}

	/**
	 * @return the xjbz
	 */
	public String getXjbz() {
		return xjbz;
	}

	/**
	 * @param xjbz the xjbz to set
	 */
	public void setXjbz(String xjbz) {
		this.xjbz = xjbz;
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
	 * @return the dcqtxz
	 */
	public Double getDcqtxz() {
		return dcqtxz;
	}

	/**
	 * @param dcqtxz the dcqtxz to set
	 */
	public void setDcqtxz(Double dcqtxz) {
		this.dcqtxz = dcqtxz;
	}

	/**
	 * @return the fcqtxz
	 */
	public Double getFcqtxz() {
		return fcqtxz;
	}

	/**
	 * @param fcqtxz the fcqtxz to set
	 */
	public void setFcqtxz(Double fcqtxz) {
		this.fcqtxz = fcqtxz;
	}

	/**
	 * @return the gbfcpgjg
	 */
	public Double getGbfcpgjg() {
		return gbfcpgjg;
	}

	/**
	 * @param gbfcpgjg the gbfcpgjg to set
	 */
	public void setGbfcpgjg(Double gbfcpgjg) {
		this.gbfcpgjg = gbfcpgjg;
	}

	/**
	 * @return the gbdcpgjg
	 */
	public Double getGbdcpgjg() {
		return gbdcpgjg;
	}

	/**
	 * @param gbdcpgjg the gbdcpgjg to set
	 */
	public void setGbdcpgjg(Double gbdcpgjg) {
		this.gbdcpgjg = gbdcpgjg;
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
	 * @return the gbfcxzxs
	 */
	public Double getGbfcxzxs() {
		return gbfcxzxs;
	}

	/**
	 * @param gbfcxzxs the gbfcxzxs to set
	 */
	public void setGbfcxzxs(Double gbfcxzxs) {
		this.gbfcxzxs = gbfcxzxs;
	}

	/**
	 * @return the gbdcxzxs
	 */
	public Double getGbdcxzxs() {
		return gbdcxzxs;
	}

	/**
	 * @param gbdcxzxs the gbdcxzxs to set
	 */
	public void setGbdcxzxs(Double gbdcxzxs) {
		this.gbdcxzxs = gbdcxzxs;
	}

	/**
	 * @return the cd12001Swid
	 */
	public String getCd12001Swid() {
		return cd12001Swid;
	}

	/**
	 * @param cd12001Swid the cd12001Swid to set
	 */
	public void setCd12001Swid(String cd12001Swid) {
		this.cd12001Swid = cd12001Swid;
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
	 * @param cbpgczr the cbpgczr to set
	 */
	public void setCbpgczr(String cbpgczr) {
		this.cbpgczr = cbpgczr;
	}

	/**
	 * @return the cbpgczr
	 */
	public String getCbpgczr() {
		return cbpgczr;
	}

	/**
	 * @param cd00001Ssgx the cd00001Ssgx to set
	 */
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}

	/**
	 * @return the cd00001Ssgx
	 */
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}

	/**
	 * @return the cbpgjg
	 */
	public Double getCbpgjg() {
		return cbpgjg;
	}

	/**
	 * @param cbpgjg the cbpgjg to set
	 */
	public void setCbpgjg(Double cbpgjg) {
		this.cbpgjg = cbpgjg;
	}

	/**
	 * @return the cbfcpgjg
	 */
	public Double getCbfcpgjg() {
		return cbfcpgjg;
	}

	/**
	 * @param cbfcpgjg the cbfcpgjg to set
	 */
	public void setCbfcpgjg(Double cbfcpgjg) {
		this.cbfcpgjg = cbfcpgjg;
	}

	/**
	 * @return the cbdcpgjg
	 */
	public Double getCbdcpgjg() {
		return cbdcpgjg;
	}

	/**
	 * @param cbdcpgjg the cbdcpgjg to set
	 */
	public void setCbdcpgjg(Double cbdcpgjg) {
		this.cbdcpgjg = cbdcpgjg;
	}

	/**
	 * @return the jcnfbgn
	 */
	public String getJcnfbgn() {
		return jcnfbgn;
	}

	/**
	 * @param jcnfbgn the jcnfbgn to set
	 */
	public void setJcnfbgn(String jcnfbgn) {
		this.jcnfbgn = jcnfbgn;
	}

	/**
	 * @return the jcnfend
	 */
	public String getJcnfend() {
		return jcnfend;
	}

	/**
	 * @param jcnfend the jcnfend to set
	 */
	public void setJcnfend(String jcnfend) {
		this.jcnfend = jcnfend;
	}

	/**
	 * @return the cd00001Tdyt
	 */
	public String getCd00001Tdyt() {
		return cd00001Tdyt;
	}

	/**
	 * @param cd00001Tdyt the cd00001Tdyt to set
	 */
	public void setCd00001Tdyt(String cd00001Tdyt) {
		this.cd00001Tdyt = cd00001Tdyt;
	}

	/**
	 * @return the cd00001Fwyt
	 */
	public String getCd00001Fwyt() {
		return cd00001Fwyt;
	}

	/**
	 * @param cd00001Fwyt the cd00001Fwyt to set
	 */
	public void setCd00001Fwyt(String cd00001Fwyt) {
		this.cd00001Fwyt = cd00001Fwyt;
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
}