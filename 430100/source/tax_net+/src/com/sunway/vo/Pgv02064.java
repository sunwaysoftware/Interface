package com.sunway.vo;

import java.sql.Timestamp;


/**
 * 商业法纳税指数修正
 * @author LeiJia
 *
 */
public class Pgv02064 extends BaseVO {
	private Integer id;
	private String szqy;
	private String cd00001Szqy;
	private String nszdxs;
	private Timestamp upddate;
	private String cd00002Czr;
	private String czr;
	
	
	
	
	private String cd00001Ssgx;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSzqy() {
		return szqy;
	}
	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}
	public String getNszdxs() {
		return nszdxs;
	}
	public void setNszdxs(String nszdxs) {
		this.nszdxs = nszdxs;
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
	public String getCd00002Czr() {
		return cd00002Czr;
	}
	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}
	
	
}
