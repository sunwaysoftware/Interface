/**
 * 
 */
package com.sunway.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 完税信息
 * @author amani
 */
public class FC002 implements Serializable {
	private static final long serialVersionUID = 6448331736430962066L;

	private String lsh;
	private Double djz_qs;
	private Double djz_yys;
	private Double djz_cjs;
	private Double djz_dfjys;
	private Double djz_grsds;
	private Double djz_yhs;
	private Double djz_tdzzs;
	private String fphm;
	private String qssphm;
	private String dfgssphm;
	private Date updatetime;
	private String pgid;
	private Double pgjg;
	private Integer msSign;
	private String msZcyj;
	private String kzzd;
	private String zlbm;
	private String ywh;
	private String fcjlsh;
	private String bdcdyh;
	private String ybdcqzh;
	private String wqhth;
	private String dznspzh;
	private String wspzh;
	private String wszh;
	private Double jsje;
	private Double wsje;
	private Date wssj;
	
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
	 * @return the djz_qs
	 */
	public Double getDjz_qs() {
		return djz_qs;
	}

	/**
	 * @param djz_qs the djz_qs to set
	 */
	public void setDjz_qs(Double djz_qs) {
		this.djz_qs = djz_qs;
	}

	/**
	 * @return the djz_yys
	 */
	public Double getDjz_yys() {
		return djz_yys;
	}

	/**
	 * @param djz_yys the djz_yys to set
	 */
	public void setDjz_yys(Double djz_yys) {
		this.djz_yys = djz_yys;
	}

	/**
	 * @return the djz_cjs
	 */
	public Double getDjz_cjs() {
		return djz_cjs;
	}

	/**
	 * @param djz_cjs the djz_cjs to set
	 */
	public void setDjz_cjs(Double djz_cjs) {
		this.djz_cjs = djz_cjs;
	}

	/**
	 * @return the djz_dfjys
	 */
	public Double getDjz_dfjys() {
		return djz_dfjys;
	}

	/**
	 * @param djz_dfjys the djz_dfjys to set
	 */
	public void setDjz_dfjys(Double djz_dfjys) {
		this.djz_dfjys = djz_dfjys;
	}

	/**
	 * @return the djz_grsds
	 */
	public Double getDjz_grsds() {
		return djz_grsds;
	}

	/**
	 * @param djz_grsds the djz_grsds to set
	 */
	public void setDjz_grsds(Double djz_grsds) {
		this.djz_grsds = djz_grsds;
	}

	/**
	 * @return the djz_yhs
	 */
	public Double getDjz_yhs() {
		return djz_yhs;
	}

	/**
	 * @param djz_yhs the djz_yhs to set
	 */
	public void setDjz_yhs(Double djz_yhs) {
		this.djz_yhs = djz_yhs;
	}

	/**
	 * @return the djz_tdzzs
	 */
	public Double getDjz_tdzzs() {
		return djz_tdzzs;
	}

	/**
	 * @param djz_tdzzs the djz_tdzzs to set
	 */
	public void setDjz_tdzzs(Double djz_tdzzs) {
		this.djz_tdzzs = djz_tdzzs;
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
	public Double getPgjg() {
		return pgjg;
	}

	/**
	 * @param pgjg the pgjg to set
	 */
	public void setPgjg(Double pgjg) {
		this.pgjg = pgjg;
	}

	/**
	 * @return the msSign
	 */
	public Integer getMsSign() {
		return msSign;
	}

	/**
	 * @param msSign the msSign to set
	 */
	public void setMsSign(Integer msSign) {
		this.msSign = msSign;
	}

	/**
	 * @return the msZcyj
	 */
	public String getMsZcyj() {
		return msZcyj;
	}

	/**
	 * @param msZcyj the msZcyj to set
	 */
	public void setMsZcyj(String msZcyj) {
		this.msZcyj = msZcyj;
	}

	/**
	 * @return the kzzd
	 */
	public String getKzzd() {
		return kzzd;
	}

	/**
	 * @param kzzd the kzzd to set
	 */
	public void setKzzd(String kzzd) {
		this.kzzd = kzzd;
	}

	/**
	 * @return the zlbm
	 */
	public String getZlbm() {
		return zlbm;
	}

	/**
	 * @param zlbm the zlbm to set
	 */
	public void setZlbm(String zlbm) {
		this.zlbm = zlbm;
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
	 * @return the jsje
	 */
	public Double getJsje() {
		return jsje;
	}

	/**
	 * @param jsje the jsje to set
	 */
	public void setJsje(Double jsje) {
		this.jsje = jsje;
	}

	/**
	 * @return the wsje
	 */
	public Double getWsje() {
		return wsje;
	}

	/**
	 * @param wsje the wsje to set
	 */
	public void setWsje(Double wsje) {
		this.wsje = wsje;
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

}
