package com.sunway.vo;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 国土过滤的数据表（临时表）
 * @author Light
 *
 */
public class Pgv00372 implements Serializable {

	private static final long serialVersionUID = 6495818304577011500L;
	private String fcid;				//国土编码
	private String fcslh;				//国土受理号
	private String yfczh;				//原国土证号
	private String zrfsflx;				//转让方身份类型
	private String zrfsfid;				//转让方身份号码
	private String zrfmc;				//转让方名称
	private String csfsflx;				//承受方身份类型
	private String csfsfid;				//承受方身份号码
	private String csfmc;				//承受方名称
	private String clh;					//测量号
	private String sjyt;				//设计用途
	private String lfdz;				//楼房地址
	private String dyfh;				//单元及房号
	private String szlc;				//所在楼层
	private String zlc;					//总楼层
	private String jzjg;				//建筑结构
	private String fwlx;				//房屋类型
	private String jylx;				//交易类型
	private Double jzmj;				//建筑面积
	private Double htzj;				//合同总价
	private Timestamp jysj;				//交易时间
	private Timestamp fzrq;				//发证日期
	private String df;					//端房
	private String cx;					//朝向
	private String cg;					//层高
	private Integer oinsid;				//国土主键
	private Double yjg;					//原价格
	private Double pgjg;				//非住宅的评估价格
	private String roomid;				//国土主键
	private String ownRoomid;			//房屋主键
	private String sfsyfc;				//产权类别
	private String ssqy;				//所属区域
	private Timestamp upddate;			//更新时间
	private String cd00002Czr;			//操作人代码
	private String note;				//备注
	
	
	public String getFcid() {
		return fcid;
	}
	public void setFcid(String fcid) {
		this.fcid = fcid;
	}
	public String getFcslh() {
		return fcslh;
	}
	public void setFcslh(String fcslh) {
		this.fcslh = fcslh;
	}
	public String getYfczh() {
		return yfczh;
	}
	public void setYfczh(String yfczh) {
		this.yfczh = yfczh;
	}
	public String getZrfsflx() {
		return zrfsflx;
	}
	public void setZrfsflx(String zrfsflx) {
		this.zrfsflx = zrfsflx;
	}
	public String getZrfsfid() {
		return zrfsfid;
	}
	public void setZrfsfid(String zrfsfid) {
		this.zrfsfid = zrfsfid;
	}
	public String getZrfmc() {
		return zrfmc;
	}
	public void setZrfmc(String zrfmc) {
		this.zrfmc = zrfmc;
	}
	public String getCsfsflx() {
		return csfsflx;
	}
	public void setCsfsflx(String csfsflx) {
		this.csfsflx = csfsflx;
	}
	public String getCsfsfid() {
		return csfsfid;
	}
	public void setCsfsfid(String csfsfid) {
		this.csfsfid = csfsfid;
	}
	public String getCsfmc() {
		return csfmc;
	}
	public void setCsfmc(String csfmc) {
		this.csfmc = csfmc;
	}
	public String getClh() {
		return clh;
	}
	public void setClh(String clh) {
		this.clh = clh;
	}
	public String getSjyt() {
		return sjyt;
	}
	public void setSjyt(String sjyt) {
		this.sjyt = sjyt;
	}
	public String getLfdz() {
		return lfdz;
	}
	public void setLfdz(String lfdz) {
		this.lfdz = lfdz;
	}
	public String getDyfh() {
		return dyfh;
	}
	public void setDyfh(String dyfh) {
		this.dyfh = dyfh;
	}
	public String getSzlc() {
		return szlc;
	}
	public void setSzlc(String szlc) {
		this.szlc = szlc;
	}
	public String getZlc() {
		return zlc;
	}
	public void setZlc(String zlc) {
		this.zlc = zlc;
	}
	public String getJzjg() {
		return jzjg;
	}
	public void setJzjg(String jzjg) {
		this.jzjg = jzjg;
	}
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	public String getJylx() {
		return jylx;
	}
	public void setJylx(String jylx) {
		this.jylx = jylx;
	}
	public Double getJzmj() {
		return jzmj;
	}
	public void setJzmj(Double jzmj) {
		this.jzmj = jzmj;
	}
	public Double getHtzj() {
		return htzj;
	}
	public void setHtzj(Double htzj) {
		this.htzj = htzj;
	}
	public Timestamp getJysj() {
		return jysj;
	}
	public void setJysj(Timestamp jysj) {
		this.jysj = jysj;
	}
	public Timestamp getFzrq() {
		return fzrq;
	}
	public void setFzrq(Timestamp fzrq) {
		this.fzrq = fzrq;
	}
	public String getDf() {
		return df;
	}
	public void setDf(String df) {
		this.df = df;
	}
	public String getCx() {
		return cx;
	}
	public void setCx(String cx) {
		this.cx = cx;
	}
	public String getCg() {
		return cg;
	}
	public void setCg(String cg) {
		this.cg = cg;
	}
	public Integer getOinsid() {
		return oinsid;
	}
	public void setOinsid(Integer oinsid) {
		this.oinsid = oinsid;
	}
	public Double getYjg() {
		return yjg;
	}
	public void setYjg(Double yjg) {
		this.yjg = yjg;
	}
	public Double getPgjg() {
		return pgjg;
	}
	public void setPgjg(Double pgjg) {
		this.pgjg = pgjg;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getOwnRoomid() {
		return ownRoomid;
	}
	public void setOwnRoomid(String ownRoomid) {
		this.ownRoomid = ownRoomid;
	}
	public String getSfsyfc() {
		return sfsyfc;
	}
	public void setSfsyfc(String sfsyfc) {
		this.sfsyfc = sfsyfc;
	}
	public String getSsqy() {
		return ssqy;
	}
	public void setSsqy(String ssqy) {
		this.ssqy = ssqy;
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
	
	
	
	
}
