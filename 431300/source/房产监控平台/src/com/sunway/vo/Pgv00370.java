package com.sunway.vo;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 通知公告视图
 * @author Light
 *
 */
public class Pgv00370 {

	private String id;					//流水号
	private String gzgg;				//通知公告
	private Timestamp gqdate;			//过期时间
	private Timestamp upddate;			//更新时间
	private String cd00002Czr;			//操作人代码
	private String cd00001SsgxLx;		//税收管辖类型
	private String cd00001Ssgx;			//税收管辖
	private String czr;					//操作人
	private String ssgx;				//税收管辖
	private BigDecimal wpgCount;	    //未评估个数
	private BigDecimal wdyCount;		//评估未打印个数
	private BigDecimal wrdCount;	    //打印未认定个数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer recordCount;
	private Integer recordIndex;
	private String szqy;				//所在区域
	private String xqnm;				//小区名称
	private String fwlx;				//房屋类型
	private Double dypfmjg;				//单元平方米价格
	
	/**
	 * 获取流水号
	 * @return
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置流水号
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取通知公告 
	 * @return
	 */
	public String getGzgg() {
		return gzgg;
	}
	/**
	 * 设置通知公告
	 * @param gzgg
	 */
	public void setGzgg(String gzgg) {
		this.gzgg = gzgg;
	}
	/**
	 * 获取过期时间
	 * @return
	 */
	public Timestamp getGqdate() {
		return gqdate;
	}
	/**
	 * 设置过期时间
	 * @param gqdate
	 */
	public void setGqdate(Timestamp gqdate) {
		this.gqdate = gqdate;
	}
	/**
	 * 获取更新时间
	 * @return
	 */
	public Timestamp getUpddate() {
		return upddate;
	}
	/**
	 * 设置更新时间
	 * @param upddate
	 */
	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}
	/**
	 * 获取操作人
	 * @return
	 */
	public String getCd00002Czr() {
		return cd00002Czr;
	}
	/**
	 * 设置操作人
	 * @param cd00002Czr
	 */
	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}
	/**
	 * 获取税收管辖类型
	 * @return
	 */
	public String getCd00001SsgxLx() {
		return cd00001SsgxLx;
	}
	/**
	 * 设置税收管辖类型
	 * @param cd00001SsgxLx
	 */
	public void setCd00001SsgxLx(String cd00001SsgxLx) {
		this.cd00001SsgxLx = cd00001SsgxLx;
	}
	/**
	 * 获取税收管辖
	 * @return
	 */
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}
	/**
	 * 设置税收管辖
	 * @param cd00001Ssgx
	 */
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}
	/**
	 * 获取操作人
	 * @return
	 */
	public String getCzr() {
		return czr;
	}
	/**
	 * 设置操作人
	 * @param czr
	 */
	public void setCzr(String czr) {
		this.czr = czr;
	}
	/**
	 * 获取税收管辖
	 * @return
	 */
	public String getSsgx() {
		return ssgx;
	}
	/**
	 * 设置税收管辖
	 * @param ssgx
	 */
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Integer recordCount) {
		this.recordCount = recordCount;
	}
	public Integer getRecordIndex() {
		return recordIndex;
	}
	public void setRecordIndex(Integer recordIndex) {
		this.recordIndex = recordIndex;
	}
	public BigDecimal getWpgCount() {
		return wpgCount;
	}
	public void setWpgCount(BigDecimal wpgCount) {
		this.wpgCount = wpgCount;
	}
	public BigDecimal getWdyCount() {
		return wdyCount;
	}
	public void setWdyCount(BigDecimal wdyCount) {
		this.wdyCount = wdyCount;
	}
	public BigDecimal getWrdCount() {
		return wrdCount;
	}
	public void setWrdCount(BigDecimal wrdCount) {
		this.wrdCount = wrdCount;
	}
	public String getSzqy() {
		return szqy;
	}
	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}
	public String getXqnm() {
		return xqnm;
	}
	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}
	public String getFwlx() {
		return fwlx;
	}
	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	public Double getDypfmjg() {
		return dypfmjg;
	}
	public void setDypfmjg(Double dypfmjg) {
		this.dypfmjg = dypfmjg;
	}
	
}
