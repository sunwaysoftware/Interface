package com.sunway.vo;

import java.io.Serializable;
import java.sql.Timestamp;



/**
 * 楼房相关信息
 * @author Light
 *
 */
public class Pgt00306 implements Serializable {

	private static final long serialVersionUID = -8090384497889268510L;
	private String id;								//流水号
	private String cd00352Xqdm;						//小区代码
	private Integer lh;								//楼号
	private Integer zlc;							//总楼层
	private Integer dygs;							//单元数
	private String cd00002Czr;						//操作人代码
	private Timestamp upddate;						//更新时间
	private String note;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCd00352Xqdm() {
		return cd00352Xqdm;
	}
	public void setCd00352Xqdm(String cd00352Xqdm) {
		this.cd00352Xqdm = cd00352Xqdm;
	}
	public Integer getLh() {
		return lh;
	}
	public void setLh(Integer lh) {
		this.lh = lh;
	}
	public Integer getZlc() {
		return zlc;
	}
	public void setZlc(Integer zlc) {
		this.zlc = zlc;
	}
	
	public Integer getDygs() {
		return dygs;
	}
	public void setDygs(Integer dygs) {
		this.dygs = dygs;
	}
	public String getCd00002Czr() {
		return cd00002Czr;
	}
	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
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
	
	
}
