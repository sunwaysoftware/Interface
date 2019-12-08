package com.sunway.vo;

import java.math.BigDecimal;

/**
 * 交易纳税评估数量统计表
 * @author Light
 *
 */
public class BF00006 implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3746567337359785196L;
	private String cd00001Ssgx;
	private String cd00002Pssd;
	private String cd00002Czr;
	private String cd00001Fwlx;
	private String pssdMin;
	private String pssdMax;
	private String fwlx;
	private String ssgx;
	
	private BigDecimal pgzzs;							//评估总宗数
	private Double pgzsbl;								//评估宗数比率
	private Double pgzmj;								//评估总面积
	private BigDecimal xtpgzs;							//系统评估宗数
	private Double xtpgzsbl;							//系统评估宗数比率
	private BigDecimal gapgzs;							//个案评估宗数
	private Double gapgzsbl;							//个案评估宗数比率
	private BigDecimal ywszs;							//已完税宗数
	private Double ywszsbl;								//已完税宗数比率
	private BigDecimal wwszs;							//未完税宗数
	private Double wwszsbl;								//未完税宗数比率
	
	
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}
	public String getCd00002Pssd() {
		return cd00002Pssd;
	}
	public void setCd00002Pssd(String cd00002Pssd) {
		this.cd00002Pssd = cd00002Pssd;
	}
	public String getCd00002Czr() {
		return cd00002Czr;
	}
	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}
	public String getCd00001Fwlx() {
		return cd00001Fwlx;
	}
	public void setCd00001Fwlx(String cd00001Fwlx) {
		this.cd00001Fwlx = cd00001Fwlx;
	}
	/**
	 * 获取评估总宗数
	 * @return
	 */
	public BigDecimal getPgzzs() {
		return pgzzs;
	}
	/**
	 * 设置评估总宗数
	 * @param pgzzs
	 */
	public void setPgzzs(BigDecimal pgzzs) {
		this.pgzzs = pgzzs;
	}
	/**
	 * 获取评估宗数比率
	 * @return
	 */
	public Double getPgzsbl() {
		return pgzsbl;
	}
	
	/**
	 * 设置评估宗数比率
	 * @param pgzsbl
	 */
	public void setPgzsbl(Double pgzsbl) {
		this.pgzsbl = pgzsbl;
	}
	/**
	 * 获取评估总面积
	 * @return
	 */
	public Double getPgzmj() {
		return pgzmj;
	}
	/**
	 * 设置评估总面积
	 * @param pgzmj
	 */
	public void setPgzmj(Double pgzmj) {
		this.pgzmj = pgzmj;
	}
	/**
	 * 获取系统评估宗数
	 * @return
	 */
	public BigDecimal getXtpgzs() {
		return xtpgzs;
	}
	/**
	 * 设置系统评估宗数
	 * @param xtpgzs
	 */
	public void setXtpgzs(BigDecimal xtpgzs) {
		this.xtpgzs = xtpgzs;
	}
	/**
	 * 获取系统评估宗数比率
	 * @return
	 */
	public Double getXtpgzsbl() {
		return xtpgzsbl;
	}
	/**
	 * 设置系统评估宗数比率
	 * @param xtpgzsbl
	 */
	public void setXtpgzsbl(Double xtpgzsbl) {
		this.xtpgzsbl = xtpgzsbl;
	}
	/**
	 * 获取个案评估宗数
	 * @return
	 */
	public BigDecimal getGapgzs() {
		return gapgzs;
	}
	/**
	 * 设置个案评估宗数
	 * @param gapgzs
	 */
	public void setGapgzs(BigDecimal gapgzs) {
		this.gapgzs = gapgzs;
	}
	/**
	 * 获取个案评估宗数比率
	 * @return
	 */
	public Double getGapgzsbl() {
		return gapgzsbl;
	}
	/**
	 * 设置个案评估宗数比率
	 * @param gapgzsbl
	 */
	public void setGapgzsbl(Double gapgzsbl) {
		this.gapgzsbl = gapgzsbl;
	}
	/**
	 * 获取已完税宗数
	 * @return
	 */
	public BigDecimal getYwszs() {
		return ywszs;
	}
	/**
	 * 设置已完税宗数
	 * @param ywszs
	 */
	public void setYwszs(BigDecimal ywszs) {
		this.ywszs = ywszs;
	}
	/**
	 * 获取已完税宗数比率
	 * @return
	 */
	public Double getYwszsbl() {
		return ywszsbl;
	}
	/**
	 * 设置已完税宗数比率
	 * @param ywszsbl
	 */
	public void setYwszsbl(Double ywszsbl) {
		this.ywszsbl = ywszsbl;
	}
	/**
	 * 获取未完税宗数
	 * @return
	 */
	public BigDecimal getWwszs() {
		return wwszs;
	}
	/**
	 * 设置未完税宗数
	 * @param wwszs
	 */
	public void setWwszs(BigDecimal wwszs) {
		this.wwszs = wwszs;
	}
	/**
	 * 获取未完税宗数比率
	 * @return
	 */
	public Double getWwszsbl() {
		return wwszsbl;
	}
	/**
	 * 设置未完税宗数比率
	 * @param wwszsbl
	 */
	public void setWwszsbl(Double wwszsbl) {
		this.wwszsbl = wwszsbl;
	}
	public String getPssdMin() {
		return pssdMin;
	}
	public void setPssdMin(String pssdMin) {
		this.pssdMin = pssdMin;
	}
	public String getPssdMax() {
		return pssdMax;
	}
	public void setPssdMax(String pssdMax) {
		this.pssdMax = pssdMax;
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
	
	
	
	
}
	