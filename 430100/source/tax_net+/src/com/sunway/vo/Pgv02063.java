package com.sunway.vo;

import java.sql.Timestamp;
import java.util.ArrayList;



/**
 * 评估方法权重比维护
 * @author LeiJia
 *
 */
public class Pgv02063 extends BaseVO {

	private String cd00001Szqylx;
	private String cd00001Szqy;
	private String szqy;
	private String cd00001Fwlxlx;
	private String cd00001Fwlx;
	private String fwlx;
	private Double scqzb;
	private Double syqzb;
	private Timestamp upddate;
	private String cd00002Czr;
	private String note;
	private String czr;
	
	
	
	
	private String cd00001Ssgx;
    private Integer outFlag;
    private String impErrorMsg;
	private ArrayList<Pgv02063> outList;
	
	public String getSzqy() {
		return szqy;
	}
	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}	
	
	public Timestamp getUpddate() {
		return upddate;
	}
	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
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
	public String getCd00001Szqy() {
		return cd00001Szqy;
	}
	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}
	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}
	public String getCd00002Czr() {
		return cd00002Czr;
	}
	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}
	public Double getScqzb() {
		return scqzb;
	}
	public void setScqzb(Double scqzb) {
		this.scqzb = scqzb;
	}
	public Double getSyqzb() {
		return syqzb;
	}
	public void setSyqzb(Double syqzb) {
		this.syqzb = syqzb;
	}
	public String getCd00001Szqylx() {
		return cd00001Szqylx;
	}
	public void setCd00001Szqylx(String cd00001Szqylx) {
		this.cd00001Szqylx = cd00001Szqylx;
	}
	public String getCd00001Fwlxlx() {
		return cd00001Fwlxlx;
	}
	public void setCd00001Fwlxlx(String cd00001Fwlxlx) {
		this.cd00001Fwlxlx = cd00001Fwlxlx;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getOutFlag() {
		return outFlag;
	}
	public void setOutFlag(Integer outFlag) {
		this.outFlag = outFlag;
	}
	public ArrayList<Pgv02063> getOutList() {
		return outList;
	}
	public void setOutList(ArrayList<Pgv02063> outList) {
		this.outList = outList;
	}
	public String getImpErrorMsg() {
		return impErrorMsg;
	}
	public void setImpErrorMsg(String impErrorMsg) {
		this.impErrorMsg = impErrorMsg;
	}
	
	
}
