package com.sunway.vo;

import java.math.BigDecimal;

/**
 * 年度湘潭市存量房交易纳税评估已开票完税统计表
 * @author Light
 *
 */
public class BF00007 implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5612177697452090166L;
	private String cd00002Pssd;
	private String cd00001Ssgx;
	private String ssgx;
	private String cd00002Czr;
	private String pssdMin;
	private String pssdMax;
	private String fwlx;
	private String cd00001Fwlx;
	private BigDecimal kpzzs;					//开票总宗数
	private Double kpzmj;						//开票总面积
	private Double htsbzj;						//合同申报总价
	private Double htsbjj;						//合同申报均价
	private Double xtpgzj;						//系统评估总价
	private Double xtpgjj;						//系统评估均价
	private Double xtpgzjl;						//系统评估增减率
	private Double qssb;						//契税申报计税
	private Double qspg;						//契税评估计税
	private Double yyssb;						//营业税申报计税
	private Double yyspg;						//营业税评估计税
	private Double cswhjsssb;					//城市维护建设税申报计税
	private Double cswhjsspg;					//城市维护建设税评估计税
	private Double jyffjsb;						//教育费附加申报计税
	private Double jyffjpg;						//教育费附加评估计税
	private Double grsdssb;						//个人所得税申报计税
	private Double grsdspg;						//个人所得税评估计税
	private Double yhssb;						//印花税申报计税
	private Double yhspg;						//印花税评估计税
	private Double tdzzssb;						//土地增值税申报计税
	private Double tdzzspg;						//土地增值税评估计税
	private Double sehjsb;						//税额合计申报计税
	private Double sehjpg;						//税额合计评估计税
	private Double sehjzjl;						//税额合计增减率
	
	
	public String getCd00002Pssd() {
		return cd00002Pssd;
	}
	public void setCd00002Pssd(String cd00002Pssd) {
		this.cd00002Pssd = cd00002Pssd;
	}
	public String getCd00001Ssgx() {
		return cd00001Ssgx;
	}
	public void setCd00001Ssgx(String cd00001Ssgx) {
		this.cd00001Ssgx = cd00001Ssgx;
	}
	public String getCd00002Czr() {
		return cd00002Czr;
	}
	public void setCd00002Czr(String cd00002Czr) {
		this.cd00002Czr = cd00002Czr;
	}
	/**
	 * 获取交易时间下限
	 * @return
	 */
	public String getPssdMin() {
		return pssdMin;
	}
	
	/**
	 * 设置交易时间下限
	 * @param pssdMin
	 */
	public void setPssdMin(String pssdMin) {
		this.pssdMin = pssdMin;
	}
	/**
	 * 获取交易时间上限
	 * @return
	 */
	public String getPssdMax() {
		return pssdMax;
	}
	/**
	 * 设置交易时间上限
	 * @param pssdMax
	 */
	public void setPssdMax(String pssdMax) {
		this.pssdMax = pssdMax;
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
	/**
	 * 获取开票总宗数
	 * @return
	 */
	public BigDecimal getKpzzs() {
		return kpzzs;
	}
	/**
	 * 设置开票总宗数
	 * @param kpzzs
	 */
	public void setKpzzs(BigDecimal kpzzs) {
		this.kpzzs = kpzzs;
	}
	/**
	 * 获取开票总面积
	 * @return
	 */
	public Double getKpzmj() {
		return kpzmj;
	}
	/**
	 * 设置开票总面积
	 * @param kpzmj
	 */
	public void setKpzmj(Double kpzmj) {
		this.kpzmj = kpzmj;
	}
	/**
	 * 获取合同申报总价
	 * @return
	 */
	public Double getHtsbzj() {
		return htsbzj;
	}
	/**
	 * 设置合同申报总价
	 * @param htsbzj
	 */
	public void setHtsbzj(Double htsbzj) {
		this.htsbzj = htsbzj;
	}
	/**
	 * 获取合同申报均价
	 * @return
	 */
	public Double getHtsbjj() {
		return htsbjj;
	}
	/**
	 * 设置合同申报均价
	 * @param htsbjj
	 */
	public void setHtsbjj(Double htsbjj) {
		this.htsbjj = htsbjj;
	}
	/**
	 * 获取系统评估总价
	 * @return
	 */
	public Double getXtpgzj() {
		return xtpgzj;
	}
	/**
	 * 设置系统评估总价
	 * @param xtpgzj
	 */
	public void setXtpgzj(Double xtpgzj) {
		this.xtpgzj = xtpgzj;
	}
	/**
	 * 获取系统评估均价
	 * @return
	 */
	public Double getXtpgjj() {
		return xtpgjj;
	}
	/**
	 * 设置系统评估均价
	 * @param xtpgjj
	 */
	public void setXtpgjj(Double xtpgjj) {
		this.xtpgjj = xtpgjj;
	}
	/**
	 * 获取系统评估增减率
	 * @return
	 */
	public Double getXtpgzjl() {
		return xtpgzjl;
	}
	/**
	 * 设置系统评估增减率
	 * @param xtpgzjl
	 */
	public void setXtpgzjl(Double xtpgzjl) {
		this.xtpgzjl = xtpgzjl;
	}
	/**
	 * 获取契税申报
	 * @return
	 */
	public Double getQssb() {
		return qssb;
	}
	/**
	 * 设置契税申报
	 * @param qssb
	 */
	public void setQssb(Double qssb) {
		this.qssb = qssb;
	}
	/**
	 * 获取契税评估
	 * @return
	 */
	public Double getQspg() {
		return qspg;
	}
	/**
	 * 设置契税评估
	 * @param qspg
	 */
	public void setQspg(Double qspg) {
		this.qspg = qspg;
	}
	/**
	 * 获取营业税申报
	 * @return
	 */
	public Double getYyssb() {
		return yyssb;
	}
	/**
	 * 设置营业税申报
	 * @param yyssb
	 */
	public void setYyssb(Double yyssb) {
		this.yyssb = yyssb;
	}
	/**
	 * 获取营业税评估
	 * @return
	 */
	public Double getYyspg() {
		return yyspg;
	}
	/**
	 * 设置营业税评估
	 * @param yyspg
	 */
	public void setYyspg(Double yyspg) {
		this.yyspg = yyspg;
	}
	/**
	 * 获取城市维护建设税申报
	 * @return
	 */
	public Double getCswhjsssb() {
		return cswhjsssb;
	}
	/**
	 * 设置城市维护建设税申报
	 * @param cswhjsssb
	 */
	public void setCswhjsssb(Double cswhjsssb) {
		this.cswhjsssb = cswhjsssb;
	}
	/**
	 * 获取城市维护建设税评估
	 * @return
	 */
	public Double getCswhjsspg() {
		return cswhjsspg;
	}
	/**
	 * 设置城市维护建设税评估
	 * @param cswhjsspg
	 */
	public void setCswhjsspg(Double cswhjsspg) {
		this.cswhjsspg = cswhjsspg;
	}
	/**
	 * 获取教育费附加申报
	 * @return
	 */
	public Double getJyffjsb() {
		return jyffjsb;
	}
	/**
	 * 设置教育费附加申报
	 * @param jyffjsb
	 */
	public void setJyffjsb(Double jyffjsb) {
		this.jyffjsb = jyffjsb;
	}
	/**
	 * 获取教育费附加评估
	 * @return
	 */
	public Double getJyffjpg() {
		return jyffjpg;
	}
	/**
	 * 设置教育费附加评估
	 * @param jyffjpg
	 */
	public void setJyffjpg(Double jyffjpg) {
		this.jyffjpg = jyffjpg;
	}
	/**
	 * 获取个人所得税申报
	 * @return
	 */
	public Double getGrsdssb() {
		return grsdssb;
	}
	/**
	 * 设置个人所得税申报
	 * @param grsdssb
	 */
	public void setGrsdssb(Double grsdssb) {
		this.grsdssb = grsdssb;
	}
	/**
	 * 获取个人所得税评估
	 * @return
	 */
	public Double getGrsdspg() {
		return grsdspg;
	}
	/**
	 * 设置个人所得税评估
	 * @param grsdspg
	 */
	public void setGrsdspg(Double grsdspg) {
		this.grsdspg = grsdspg;
	}
	/**
	 * 获取印花税申报
	 * @return
	 */
	public Double getYhssb() {
		return yhssb;
	}
	/**
	 * 设置印花税申报
	 * @param yhssb
	 */
	public void setYhssb(Double yhssb) {
		this.yhssb = yhssb;
	}
	/**
	 * 获取印花税评估
	 * @return
	 */
	public Double getYhspg() {
		return yhspg;
	}
	/**
	 * 设置印花税评估
	 * @param yhspg
	 */
	public void setYhspg(Double yhspg) {
		this.yhspg = yhspg;
	}
	/**
	 * 获取土地增值税申报
	 * @return
	 */
	public Double getTdzzssb() {
		return tdzzssb;
	}
	/**
	 * 设置土地增值税申报
	 * @param tdzzssb
	 */
	public void setTdzzssb(Double tdzzssb) {
		this.tdzzssb = tdzzssb;
	}
	/**
	 * 获取土地增值税评估
	 * @return
	 */
	public Double getTdzzspg() {
		return tdzzspg;
	}
	/**
	 * 设置土地增值税评估
	 * @param tdzzspg
	 */
	public void setTdzzspg(Double tdzzspg) {
		this.tdzzspg = tdzzspg;
	}
	/**
	 * 获取税额合计申报
	 * @return
	 */
	public Double getSehjsb() {
		return sehjsb;
	}
	/**
	 * 设置税额合计申报
	 * @param sehjsb
	 */
	public void setSehjsb(Double sehjsb) {
		this.sehjsb = sehjsb;
	}
	/**
	 * 获取税额合计评估
	 * @return
	 */
	public Double getSehjpg() {
		return sehjpg;
	}
	/**
	 * 设置税额合计评估
	 * @param sehjpg
	 */
	public void setSehjpg(Double sehjpg) {
		this.sehjpg = sehjpg;
	}
	/**
	 * 获取税额合计增减率
	 * @return
	 */
	public Double getSehjzjl() {
		return sehjzjl;
	}
	/**
	 * 设置税额合计增减率
	 * @param sehjzjl
	 */
	public void setSehjzjl(Double sehjzjl) {
		this.sehjzjl = sehjzjl;
	}
	public String getSsgx() {
		return ssgx;
	}
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}
	
	
	
	
}
