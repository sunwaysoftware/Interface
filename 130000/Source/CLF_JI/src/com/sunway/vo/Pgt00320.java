package com.sunway.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 全面评估市场法房产信息
 * @author Light
 *
 */
public class Pgt00320 implements Serializable {

	private static final long serialVersionUID = 287326167523625092L;
	private String fcid;				//房产编码
	private String fczh;				//房产证号
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
	
	private String cd00001Szqy;			//所在区域
	
	
	
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
	public String getCd00001Szqy() {
		return cd00001Szqy;
	}
	public void setCd00001Szqy(String cd00001Szqy) {
		this.cd00001Szqy = cd00001Szqy;
	}
	
	
}
