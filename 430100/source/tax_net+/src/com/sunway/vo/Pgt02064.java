package com.sunway.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 商业法纳税指导系数维护
 * @author LeiJia
 *
 */
public class Pgt02064 extends BaseVO {
	
	private String cd00001Szqy;		//所在区域
	private BigDecimal xzxs;		//建筑面积修正
	private BigDecimal pgxzxs;		//建筑面积修正
	private Timestamp upddate;			//更改时间
	private String cd00002Czr;		//操作人字段
	private String note;			//备注信息
	private String szqy;
	private String czr;
	
	
	
	
	private String cd00001Ssgx;
	private String xqnm;
	
	public Pgt02064() {
		// Auto-generated constructor stub
	}

	public String getCd00001Szqy() {
		return cd00001Szqy;
	}

	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}

	public BigDecimal getXzxs() {
		return xzxs;
	}

	public void setXzxs(BigDecimal xzxs) {
		this.xzxs = xzxs;
	}

	public BigDecimal getPgxzxs() {
		return pgxzxs;
	}

	public void setPgxzxs(BigDecimal pgxzxs) {
		this.pgxzxs = pgxzxs;
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

	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}

	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}	

	public String getXqnm() {
		return xqnm;
	}

	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}

	

	
}
