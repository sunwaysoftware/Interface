package com.sunway.vo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;





/**
 * 税种
 * @author HuanWei
 *
 */
public class Pgt00370 implements Serializable {

	private static final long serialVersionUID = -5012370562319536894L;
	private String fcid;
	private String cd_00001_szlx;
	private String cd_00001_sz;
	private Double se;
	private Timestamp upddate;
	private String cd_00002_czr;
	private String note;
	private String ssgx;
	private Double qsjg;
	private Double qtjg;
	private String isMS;
	private String isZS;
	private Double pgjg;
	private String fcslh;
	private String roomid;
	private String yjg;
	private String htjg;
	
	
	//获取大集中返回税额中返回状态
	private String busi_return_code;
	private String busi_retrun_info;
	private String result_code;
	private String result_info;
	private String xh_djz;
	private String sz_djz;
	private String se_djz;
	private String fphm_djz;
	private String qssphm_djz;
	private String dfgssphm_djz;
	private ArrayList<Pgv00370> szxxList;
	private String resultSign_djz;
	
	public String getFcid() {
		return fcid;
	}
	public void setFcid(String fcid) {
		this.fcid = fcid;
	}
	public String getCd_00001_szlx() {
		return cd_00001_szlx;
	}
	public void setCd_00001_szlx(String cd_00001Szlx) {
		cd_00001_szlx = cd_00001Szlx;
	}
	public String getCd_00001_sz() {
		return cd_00001_sz;
	}
	public void setCd_00001_sz(String cd_00001Sz) {
		cd_00001_sz = cd_00001Sz;
	}
	public Double getSe() {
		return se;
	}
	public void setSe(Double se) {
		this.se = se;
	}

	public Timestamp getUpddate() {
		return upddate;
	}
	public void setUpddate(Timestamp upddate) {
		this.upddate = upddate;
	}
	public String getCd_00002_czr() {
		return cd_00002_czr;
	}
	public void setCd_00002_czr(String cd_00002Czr) {
		cd_00002_czr = cd_00002Czr;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getSsgx() {
		return ssgx;
	}
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}
	public Double getQsjg() {
		return qsjg;
	}
	public void setQsjg(Double qsjg) {
		this.qsjg = qsjg;
	}
	public Double getQtjg() {
		return qtjg;
	}
	public void setQtjg(Double qtjg) {
		this.qtjg = qtjg;
	}
	public String getIsMS() {
		return isMS;
	}
	public void setIsMS(String isMS) {
		this.isMS = isMS;
	}
	public String getIsZS() {
		return isZS;
	}
	public void setIsZS(String isZS) {
		this.isZS = isZS;
	}
	public Double getPgjg() {
		return pgjg;
	}
	public void setPgjg(Double pgjg) {
		this.pgjg = pgjg;
	}	
	public String getFcslh() {
		return fcslh;
	}
	public void setFcslh(String fcslh) {
		this.fcslh = fcslh;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getYjg() {
		return yjg;
	}
	public void setYjg(String yjg) {
		this.yjg = yjg;
	}
	public String getHtjg() {
		return htjg;
	}
	public void setHtjg(String htjg) {
		this.htjg = htjg;
	}
	public String getBusi_return_code() {
		return busi_return_code;
	}
	public void setBusi_return_code(String busiReturnCode) {
		busi_return_code = busiReturnCode;
	}
	public String getBusi_retrun_info() {
		return busi_retrun_info;
	}
	public void setBusi_retrun_info(String busiRetrunInfo) {
		busi_retrun_info = busiRetrunInfo;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String resultCode) {
		result_code = resultCode;
	}
	public String getResult_info() {
		return result_info;
	}
	public void setResult_info(String resultInfo) {
		result_info = resultInfo;
	}
	public String getXh_djz() {
		return xh_djz;
	}
	public void setXh_djz(String xhDjz) {
		xh_djz = xhDjz;
	}
	public String getSz_djz() {
		return sz_djz;
	}
	public void setSz_djz(String szDjz) {
		sz_djz = szDjz;
	}
	public String getSe_djz() {
		return se_djz;
	}
	public void setSe_djz(String seDjz) {
		se_djz = seDjz;
	}
	public String getFphm_djz() {
		return fphm_djz;
	}
	public void setFphm_djz(String fphmDjz) {
		fphm_djz = fphmDjz;
	}
	public String getQssphm_djz() {
		return qssphm_djz;
	}
	public void setQssphm_djz(String qssphmDjz) {
		qssphm_djz = qssphmDjz;
	}
	public String getDfgssphm_djz() {
		return dfgssphm_djz;
	}
	public void setDfgssphm_djz(String dfgssphmDjz) {
		dfgssphm_djz = dfgssphmDjz;
	}

	public ArrayList<Pgv00370> getSzxxList() {
		return szxxList;
	}
	public void setSzxxList(ArrayList<Pgv00370> szxxList) {
		this.szxxList = szxxList;
	}
	public String getResultSign_djz() {
		return resultSign_djz;
	}
	public void setResultSign_djz(String resultSignDjz) {
		resultSign_djz = resultSignDjz;
	}
	
	
}
