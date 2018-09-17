package com.sunway.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;


/**
 * 面宽修正
 * @author HuanWei
 *
 */
public class Pgv02054 extends BaseVO {

	
	private String id;
	private String cd00001Szqy;
	private String cd00001Szqylx;
	private BigDecimal mkMin;
	private BigDecimal mkMax;
	private BigDecimal xzxs;
	private Timestamp upddate; 
	private String cd00002Czr;
	private String note;
	private String szqy;
	private String czr;
	private String cd00001Fwlx;
	private String cd00001Fwlxlx;
	private String fwlx;
	
	
	
	
	private String ssgx;
	private Integer outFlag;
	private ArrayList<Pgv02054> outList;
	private String impErrorMsg;
	private String cd02050Xqdm;
	private String xqnm;
	private String dmh;
	private String dmhId;
	private String xqdmhm;
	
	public String getXqdmhm() {
		return xqdmhm;
	}

	public void setXqdmhm(String xqdmhm) {
		this.xqdmhm = xqdmhm;
	}

	public String getXqnm() {
		return xqnm;
	}

	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}

	public String getCd02050Xqdm() {
		return cd02050Xqdm;
	}

	public void setCd02050Xqdm(String cd02050Xqdm) {
		this.cd02050Xqdm = cd02050Xqdm;
	}

	public Pgv02054() {}
	
	/**
	 * @param id
	 */
	public Pgv02054(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCd00001Szqy() {
		return cd00001Szqy;
	}
	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}
	public String getCd00001Szqylx() {
		return cd00001Szqylx;
	}
	public void setCd00001Szqylx(String cd00001Szqylx) {
		this.cd00001Szqylx = cd00001Szqylx;
	}
	
	
	
	public BigDecimal getMkMin() {
		return mkMin;
	}

	public void setMkMin(BigDecimal mkMin) {
		this.mkMin = mkMin;
	}

	public BigDecimal getMkMax() {
		return mkMax;
	}

	public void setMkMax(BigDecimal mkMax) {
		this.mkMax = mkMax;
	}

	public BigDecimal getXzxs() {
		return xzxs;
	}

	public void setXzxs(BigDecimal xzxs) {
		this.xzxs = xzxs;
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
	public String getSzqy() {
		return szqy;
	}
	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}
	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}
	public String getCd00001Fwlxlx() {
		return cd00001Fwlxlx;
	}
	public void setCd00001Fwlxlx(String cd00001Fwlxlx) {
		this.cd00001Fwlxlx = cd00001Fwlxlx;
	}
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	
	public String getSsgx() {
		return ssgx;
	}

	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}

	public Integer getOutFlag() {
		return outFlag;
	}

	public void setOutFlag(Integer outFlag) {
		this.outFlag = outFlag;
	}

	public ArrayList<Pgv02054> getOutList() {
		return outList;
	}

	public void setOutList(ArrayList<Pgv02054> outList) {
		this.outList = outList;
	}

	public String getImpErrorMsg() {
		return impErrorMsg;
	}

	public void setImpErrorMsg(String impErrorMsg) {
		this.impErrorMsg = impErrorMsg;
	}

	public String getDmh() {
		return dmh;
	}

	public void setDmh(String dmh) {
		this.dmh = dmh;
	}

	public String getDmhId() {
		return dmhId;
	}

	public void setDmhId(String dmhId) {
		this.dmhId = dmhId;
	}
	
	
	
}
