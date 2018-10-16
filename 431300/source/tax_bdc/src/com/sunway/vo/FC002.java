/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 完税信息
 * @author amani
 */
public class FC002 implements Serializable {
	private static final long serialVersionUID = 6448331736430962066L;
	
	private String lsh;
	private BigDecimal djz_qs;
	private BigDecimal djz_yys;
	private BigDecimal djz_cjs;
	private BigDecimal djz_dfjys;
	private BigDecimal djz_grsds;
	private BigDecimal djz_yhs;
	private BigDecimal djz_tdzzs;
	private String fphm;
	private String qssphm;
	private String dfgssphm;
	private Date updatetime;
	private String pgid;
	private BigDecimal pgjg;
	private Integer ms_sign;
	private String ms_zcyj;
	private String ywh;
	private String fcjlsh;
	private String bdcdyh;
	private String ybdcqzh;
	private String wqhth;
	private String dznspzh;
	private String wspzh;
	private String wszh;
	private BigDecimal jsje;
	private BigDecimal wsje;
	private Date wssj;
	private String qqlsh;
	
	//====================== Constructor ====================
	
	public FC002() {}

	public FC002(String lsh) {
		this.lsh = lsh;
	}

	//=============== setter and getter =====================
	/**
	 * @return the lsh
	 */
	public String getLsh() {
		return lsh;
	}

	/**
	 * @param lsh the lsh to set
	 */
	public void setLsh(String lsh) {
		this.lsh = lsh;
	}

	/**
	 * @return the fphm
	 */
	public String getFphm() {
		return fphm;
	}

	/**
	 * @param fphm the fphm to set
	 */
	public void setFphm(String fphm) {
		this.fphm = fphm;
	}

	/**
	 * @return the qssphm
	 */
	public String getQssphm() {
		return qssphm;
	}

	/**
	 * @param qssphm the qssphm to set
	 */
	public void setQssphm(String qssphm) {
		this.qssphm = qssphm;
	}

	/**
	 * @return the dfgssphm
	 */
	public String getDfgssphm() {
		return dfgssphm;
	}

	/**
	 * @param dfgssphm the dfgssphm to set
	 */
	public void setDfgssphm(String dfgssphm) {
		this.dfgssphm = dfgssphm;
	}

	/**
	 * @return the updatetime
	 */
	public Date getUpdatetime() {
		return updatetime;
	}

	/**
	 * @param updatetime the updatetime to set
	 */
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	/**
	 * @return the pgid
	 */
	public String getPgid() {
		return pgid;
	}

	/**
	 * @param pgid the pgid to set
	 */
	public void setPgid(String pgid) {
		this.pgid = pgid;
	}

	/**
	 * @return the pgjg
	 */
	public BigDecimal getPgjg() {
		return pgjg;
	}

	/**
	 * @param pgjg the pgjg to set
	 */
	public void setPgjg(BigDecimal pgjg) {
		this.pgjg = pgjg;
	}

	/**
	 * @return the ywh
	 */
	public String getYwh() {
		return ywh;
	}

	/**
	 * @param ywh the ywh to set
	 */
	public void setYwh(String ywh) {
		this.ywh = ywh;
	}

	/**
	 * @return the fcjlsh
	 */
	public String getFcjlsh() {
		return fcjlsh;
	}

	/**
	 * @param fcjlsh the fcjlsh to set
	 */
	public void setFcjlsh(String fcjlsh) {
		this.fcjlsh = fcjlsh;
	}

	/**
	 * @return the bdcdyh
	 */
	public String getBdcdyh() {
		return bdcdyh;
	}

	/**
	 * @param bdcdyh the bdcdyh to set
	 */
	public void setBdcdyh(String bdcdyh) {
		this.bdcdyh = bdcdyh;
	}

	/**
	 * @return the ybdcqzh
	 */
	public String getYbdcqzh() {
		return ybdcqzh;
	}

	/**
	 * @param ybdcqzh the ybdcqzh to set
	 */
	public void setYbdcqzh(String ybdcqzh) {
		this.ybdcqzh = ybdcqzh;
	}

	/**
	 * @return the wqhth
	 */
	public String getWqhth() {
		return wqhth;
	}

	/**
	 * @param wqhth the wqhth to set
	 */
	public void setWqhth(String wqhth) {
		this.wqhth = wqhth;
	}

	/**
	 * @return the dznspzh
	 */
	public String getDznspzh() {
		return dznspzh;
	}

	/**
	 * @param dznspzh the dznspzh to set
	 */
	public void setDznspzh(String dznspzh) {
		this.dznspzh = dznspzh;
	}

	/**
	 * @return the wspzh
	 */
	public String getWspzh() {
		return wspzh;
	}

	/**
	 * @param wspzh the wspzh to set
	 */
	public void setWspzh(String wspzh) {
		this.wspzh = wspzh;
	}

	/**
	 * @return the wszh
	 */
	public String getWszh() {
		return wszh;
	}

	/**
	 * @param wszh the wszh to set
	 */
	public void setWszh(String wszh) {
		this.wszh = wszh;
	}

	/**
	 * @return the wssj
	 */
	public Date getWssj() {
		return wssj;
	}

	/**
	 * @param wssj the wssj to set
	 */
	public void setWssj(Date wssj) {
		this.wssj = wssj;
	}

	/**
	 * @return the djz_qs
	 */
	public BigDecimal getDjz_qs() {
		return djz_qs;
	}

	/**
	 * @param djz_qs the djz_qs to set
	 */
	public void setDjz_qs(BigDecimal djz_qs) {
		this.djz_qs = djz_qs;
	}

	/**
	 * @return the djz_yys
	 */
	public BigDecimal getDjz_yys() {
		return djz_yys;
	}

	/**
	 * @param djz_yys the djz_yys to set
	 */
	public void setDjz_yys(BigDecimal djz_yys) {
		this.djz_yys = djz_yys;
	}

	/**
	 * @return the djz_cjs
	 */
	public BigDecimal getDjz_cjs() {
		return djz_cjs;
	}

	/**
	 * @param djz_cjs the djz_cjs to set
	 */
	public void setDjz_cjs(BigDecimal djz_cjs) {
		this.djz_cjs = djz_cjs;
	}

	/**
	 * @return the djz_dfjys
	 */
	public BigDecimal getDjz_dfjys() {
		return djz_dfjys;
	}

	/**
	 * @param djz_dfjys the djz_dfjys to set
	 */
	public void setDjz_dfjys(BigDecimal djz_dfjys) {
		this.djz_dfjys = djz_dfjys;
	}

	/**
	 * @return the djz_grsds
	 */
	public BigDecimal getDjz_grsds() {
		return djz_grsds;
	}

	/**
	 * @param djz_grsds the djz_grsds to set
	 */
	public void setDjz_grsds(BigDecimal djz_grsds) {
		this.djz_grsds = djz_grsds;
	}

	/**
	 * @return the djz_yhs
	 */
	public BigDecimal getDjz_yhs() {
		return djz_yhs;
	}

	/**
	 * @param djz_yhs the djz_yhs to set
	 */
	public void setDjz_yhs(BigDecimal djz_yhs) {
		this.djz_yhs = djz_yhs;
	}

	/**
	 * @return the djz_tdzzs
	 */
	public BigDecimal getDjz_tdzzs() {
		return djz_tdzzs;
	}

	/**
	 * @param djz_tdzzs the djz_tdzzs to set
	 */
	public void setDjz_tdzzs(BigDecimal djz_tdzzs) {
		this.djz_tdzzs = djz_tdzzs;
	}

	/**
	 * @return the jsje
	 */
	public BigDecimal getJsje() {
		return jsje;
	}

	/**
	 * @param jsje the jsje to set
	 */
	public void setJsje(BigDecimal jsje) {
		this.jsje = jsje;
	}

	/**
	 * @return the wsje
	 */
	public BigDecimal getWsje() {
		return wsje;
	}

	/**
	 * @param wsje the wsje to set
	 */
	public void setWsje(BigDecimal wsje) {
		this.wsje = wsje;
	}

	/**
	 * @return the qqlsh
	 */
	public String getQqlsh() {
		return qqlsh;
	}

	/**
	 * @param qqlsh the qqlsh to set
	 */
	public void setQqlsh(String qqlsh) {
		this.qqlsh = qqlsh;
	}

	/**
	 * @return the ms_sign
	 */
	public Integer getMs_sign() {
		return ms_sign;
	}

	/**
	 * @param ms_sign the ms_sign to set
	 */
	public void setMs_sign(Integer ms_sign) {
		this.ms_sign = ms_sign;
	}

	/**
	 * @return the ms_zcyj
	 */
	public String getMs_zcyj() {
		return ms_zcyj;
	}

	/**
	 * @param ms_zcyj the ms_zcyj to set
	 */
	public void setMs_zcyj(String ms_zcyj) {
		this.ms_zcyj = ms_zcyj;
	}

}
