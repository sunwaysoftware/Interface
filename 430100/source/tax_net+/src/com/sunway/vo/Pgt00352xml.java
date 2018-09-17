package com.sunway.vo;


import java.util.ArrayList;
import java.util.Date;

public class Pgt00352xml extends BaseVO {

	private ArrayList<Pgt00352xml> Pgt00352xmllist;
	private String cd00053Qtxzid;
	private String FCSLH;
	private String YFCZH;
	private String ZRFSFLX;
	private String ZRFSFID;
	private String ZRFMC;
	private String CSFSFLX;
	private String CSFSFID;
	private String CSFMC;
	private String CLH;
	private String SJYT;
	private String LFDZ;
	private String DYFH;
	private String SZLC;
	private String ZLC;
	private String JZJG;
	private String FWLX;
	private String JYLX;
	private Double JZMJ;
	private Double HTZJ;
	private Date JYSJ;
	private Date FZRQ;
	private String DF;
	private String CX;
	private String CG;
	private String OINSID;
	private Double YJG;
	private Double PGJG;
	private Integer lx;
	private String ROOMID;
	
	
	private String fcid;
	private String id;
	private Integer czzt;
	
	
	//private Date jysj;
	//private Date djrq;
	private String szqy;
	private String xqdm;
	private String note;
	//private Double jyjg;
	private Double tdsyqmj;
	private Double rjl;
	private String fdcdat;
	private String czr;
	private String qdh;
	private String cb;
	private String jcsj;
	private String shr;
	private String ywdt;
	private String lxdh;
	private String zcdzl;
	private String zcdzbm;
	private String ssgx;
	private String xqzt;
	private String parentdm;
	private String xqnm;
	private String ywjkc;
	private String hxjg;
	private String psSign;
	private String zhxz;
	private String wsSign;
//	private Double yjgView;
//	private Double pgjgView;
	//private Double scpgjg;
	private String ownRoomid;
	private Integer sfsyfc;
	private String sfsyfcmc;
	private String cd00001fwlx;
	private String cd00001jylx;
	private String cd00001jzjg;
	private String cd00001zrfsflx;
	private String cd00001csfsflx;
	private String cd00001sjyt;
	private String errorSign;
	private String errorMessage;
	private String infoMsg;
	private Double wsjs;
	private Date wsrq;
	private String zrfTel;
	private String csfTel;
	private String cd00001Mfgjdm;	
	private String cd00001Gmfgjdm;	
	private String mfgjdm;
	private String gmfgjdm;
	
	public String getCd00001fwlx() {
		return cd00001fwlx;
	}
	public void setCd00001fwlx(String cd00001fwlx) {
		this.cd00001fwlx = cd00001fwlx;
	}
	public String getCd00001jylx() {
		return cd00001jylx;
	}
	public void setCd00001jylx(String cd00001jylx) {
		this.cd00001jylx = cd00001jylx;
	}
	public String getCd00001jzjg() {
		return cd00001jzjg;
	}
	public void setCd00001jzjg(String cd00001jzjg) {
		this.cd00001jzjg = cd00001jzjg;
	}
	public String getCd00001zrfsflx() {
		return cd00001zrfsflx;
	}
	public void setCd00001zrfsflx(String cd00001zrfsflx) {
		this.cd00001zrfsflx = cd00001zrfsflx;
	}
	public String getCd00001csfsflx() {
		return cd00001csfsflx;
	}
	public void setCd00001csfsflx(String cd00001csfsflx) {
		this.cd00001csfsflx = cd00001csfsflx;
	}
	public String getCd00001sjyt() {
		return cd00001sjyt;
	}
	public void setCd00001sjyt(String cd00001sjyt) {
		this.cd00001sjyt = cd00001sjyt;
	}
	/** default constructor */
	public Pgt00352xml() {
		this.Pgt00352xmllist = new ArrayList<Pgt00352xml>();
	}
	/** full constructor */
	public Pgt00352xml(	
						String fcid, String FCSLH,String YFCZH,String ZRFSFLX,
						String ZRFSFID,String ZRFMC,String CSFSFLX,String CSFSFID,
						String CSFMC,String CLH,String SJYT,String LFDZ,String DYFH,
						String SZLC,String ZLC,String JZJG,String FWLX,String JYLX,
						Double JZMJ,Double HTZJ,Date JYSJ,Date FZRQ,String DF,
						String CX,String CG) {
							this.fcid = fcid;
							this.FCSLH=FCSLH;
							this.YFCZH=YFCZH;
							this.ZRFSFLX=ZRFSFLX;
							this.ZRFSFID=ZRFSFID;
							this.ZRFMC=ZRFMC;
							this.CSFSFLX=CSFSFLX;
							this.CSFSFID=CSFSFID;
							this.SZLC=SZLC;
							this.ZLC=ZLC;
							this.JZJG=JZJG;
							this.FWLX=FWLX;
							this.JYLX=JYLX;
							this.JZMJ=JZMJ;
							this.HTZJ=HTZJ;
							this.JYSJ=JYSJ;
							this.FZRQ=FZRQ;
							this.DF=DF;
							this.CX=CX;
							this.CG=CG;
	}
	/**
	 * @return the fCSLH
	 */
	public String getFCSLH() {
		return FCSLH;
	}
	/**
	 * @param fCSLH the fCSLH to set
	 */
	public void setFCSLH(String fCSLH) {
		FCSLH = fCSLH;
	}
	/**
	 * @return the yFCZH
	 */
	public String getYFCZH() {
		return YFCZH;
	}
	/**
	 * @param yFCZH the yFCZH to set
	 */
	public void setYFCZH(String yFCZH) {
		YFCZH = yFCZH;
	}
	/**
	 * @return the zRFSFLX
	 */
	public String getZRFSFLX() {
		return ZRFSFLX;
	}
	/**
	 * @param zRFSFLX the zRFSFLX to set
	 */
	public void setZRFSFLX(String zRFSFLX) {
		ZRFSFLX = zRFSFLX;
	}
	/**
	 * @return the zRFSFID
	 */
	public String getZRFSFID() {
		return ZRFSFID;
	}
	/**
	 * @param zRFSFID the zRFSFID to set
	 */
	public void setZRFSFID(String zRFSFID) {
		ZRFSFID = zRFSFID;
	}
	/**
	 * @return the zRFMC
	 */
	public String getZRFMC() {
		return ZRFMC;
	}
	/**
	 * @param zRFMC the zRFMC to set
	 */
	public void setZRFMC(String zRFMC) {
		ZRFMC = zRFMC;
	}
	/**
	 * @return the cSFSFLX
	 */
	public String getCSFSFLX() {
		return CSFSFLX;
	}
	/**
	 * @param cSFSFLX the cSFSFLX to set
	 */
	public void setCSFSFLX(String cSFSFLX) {
		CSFSFLX = cSFSFLX;
	}
	/**
	 * @return the cSFSFID
	 */
	public String getCSFSFID() {
		return CSFSFID;
	}
	/**
	 * @param cSFSFID the cSFSFID to set
	 */
	public void setCSFSFID(String cSFSFID) {
		CSFSFID = cSFSFID;
	}
	/**
	 * @return the cSFMC
	 */
	public String getCSFMC() {
		return CSFMC;
	}
	/**
	 * @param cSFMC the cSFMC to set
	 */
	public void setCSFMC(String cSFMC) {
		CSFMC = cSFMC;
	}
	/**
	 * @return the cLH
	 */
	public String getCLH() {
		return CLH;
	}
	/**
	 * @param cLH the cLH to set
	 */
	public void setCLH(String cLH) {
		CLH = cLH;
	}
	/**
	 * @return the sJYT
	 */
	public String getSJYT() {
		return SJYT;
	}
	/**
	 * @param sJYT the sJYT to set
	 */
	public void setSJYT(String sJYT) {
		SJYT = sJYT;
	}
	/**
	 * @return the lFDZ
	 */
	public String getLFDZ() {
		return LFDZ;
	}
	/**
	 * @param lFDZ the lFDZ to set
	 */
	public void setLFDZ(String lFDZ) {
		LFDZ = lFDZ;
	}
	/**
	 * @return the dYFH
	 */
	public String getDYFH() {
		return DYFH;
	}
	/**
	 * @param dYFH the dYFH to set
	 */
	public void setDYFH(String dYFH) {
		DYFH = dYFH;
	}
	/**
	 * @return the sZLC
	 */
	public String getSZLC() {
		return SZLC;
	}
	/**
	 * @param sZLC the sZLC to set
	 */
	public void setSZLC(String sZLC) {
		SZLC = sZLC;
	}
	/**
	 * @return the zLC
	 */
	public String getZLC() {
		return ZLC;
	}
	/**
	 * @param zLC the zLC to set
	 */
	public void setZLC(String zLC) {
		ZLC = zLC;
	}
	/**
	 * @return the jZJG
	 */
	public String getJZJG() {
		return JZJG;
	}
	/**
	 * @param jZJG the jZJG to set
	 */
	public void setJZJG(String jZJG) {
		JZJG = jZJG;
	}
	/**
	 * @return the fWLX
	 */
	public String getFWLX() {
		return FWLX;
	}
	/**
	 * @param fWLX the fWLX to set
	 */
	public void setFWLX(String fWLX) {
		FWLX = fWLX;
	}
	/**
	 * @return the jYLX
	 */
	public String getJYLX() {
		return JYLX;
	}
	/**
	 * @param jYLX the jYLX to set
	 */
	public void setJYLX(String jYLX) {
		JYLX = jYLX;
	}
	/**
	 * @return the jZMJ
	 */
	public Double getJZMJ() {
		return JZMJ;
	}
	/**
	 * @param jZMJ the jZMJ to set
	 */
	public void setJZMJ(Double jZMJ) {
		JZMJ = jZMJ;
	}
	/**
	 * @return the hTZJ
	 */
	public Double getHTZJ() {
		return HTZJ;
	}
	/**
	 * @param hTZJ the hTZJ to set
	 */
	public void setHTZJ(Double hTZJ) {
		HTZJ = hTZJ;
	}
	/**
	 * @return the jYSJ
	 */
	public Date getJYSJ() {
		return JYSJ;
	}
	/**
	 * @param jYSJ the jYSJ to set
	 */
	public void setJYSJ(Date jYSJ) {
		JYSJ = jYSJ;
	}
	/**
	 * @return the fZRQ
	 */
	public Date getFZRQ() {
		return FZRQ;
	}
	/**
	 * @param fZRQ the fZRQ to set
	 */
	public void setFZRQ(Date fZRQ) {
		FZRQ = fZRQ;
	}
	/**
	 * @return the dF
	 */
	public String getDF() {
		return DF;
	}
	/**
	 * @param dF the dF to set
	 */
	public void setDF(String dF) {
		DF = dF;
	}
	/**
	 * @return the cX
	 */
	public String getCX() {
		return CX;
	}
	/**
	 * @param cX the cX to set
	 */
	public void setCX(String cX) {
		CX = cX;
	}
	/**
	 * @return the cG
	 */
	public String getCG() {
		return CG;
	}
	/**
	 * @param cG the cG to set
	 */
	public void setCG(String cG) {
		CG = cG;
	}
	
	/**
	 * @return the pgt00352xmllist
	 */
	public ArrayList<Pgt00352xml> getPgt00352xmllist() {
		return Pgt00352xmllist;
	}
	/**
	 * @param pgt00352xmllist the pgt00352xmllist to set
	 */
	public void setPgt00352xmllist(ArrayList<Pgt00352xml> pgt00352xmllist) {
		Pgt00352xmllist = pgt00352xmllist;
	}
	/**
	 * @return the fcid
	 */
	public String getFcid() {
		return fcid;
	}
	/**
	 * @param fcid the fcid to set
	 */
	public void setFcid(String fcid) {
		this.fcid = fcid;
	}
	/**
	 * @return the czzt
	 */
	public Integer getCzzt() {
		return czzt;
	}
	/**
	 * @param czzt the czzt to set
	 */
	public void setCzzt(Integer czzt) {
		this.czzt = czzt;
	}
	
//	public void setJysj(Date jysj) {
//		this.jysj = jysj;
//	}
//	public Date getJysj() {
//		return jysj;
//	}
	/**
	 * @return the djrq
	 */
//	public Date getDjrq() {
//		return djrq;
//	}
//	/**
//	 * @param djrq the djrq to set
//	 */
//	public void setDjrq(Date djrq) {
//		this.djrq = djrq;
//	}
	public String getSzqy() {
		return szqy;
	}
	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}
	public String getXqdm() {
		return xqdm;
	}
	public void setXqdm(String xqdm) {
		this.xqdm = xqdm;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
//	public Double getJyjg() {
//		return jyjg;
//	}
//	public void setJyjg(Double jyjg) {
//		this.jyjg = jyjg;
//	}
	public Double getTdsyqmj() {
		return tdsyqmj;
	}
	public void setTdsyqmj(Double tdsyqmj) {
		this.tdsyqmj = tdsyqmj;
	}
	public Double getRjl() {
		return rjl;
	}
	public void setRjl(Double rjl) {
		this.rjl = rjl;
	}
	public String getFdcdat() {
		return fdcdat;
	}
	public void setFdcdat(String fdcdat) {
		this.fdcdat = fdcdat;
	}
	public String getCzr() {
		return czr;
	}
	public void setCzr(String czr) {
		this.czr = czr;
	}
	public String getQdh() {
		return qdh;
	}
	public void setQdh(String qdh) {
		this.qdh = qdh;
	}
	public String getCb() {
		return cb;
	}
	public void setCb(String cb) {
		this.cb = cb;
	}
	public String getJcsj() {
		return jcsj;
	}
	public void setJcsj(String jcsj) {
		this.jcsj = jcsj;
	}
	public String getShr() {
		return shr;
	}
	public void setShr(String shr) {
		this.shr = shr;
	}
	public String getYwdt() {
		return ywdt;
	}
	public void setYwdt(String ywdt) {
		this.ywdt = ywdt;
	}
	public String getZcdzl() {
		return zcdzl;
	}
	public void setZcdzl(String zcdzl) {
		this.zcdzl = zcdzl;
	}
	public String getZcdzbm() {
		return zcdzbm;
	}
	public void setZcdzbm(String zcdzbm) {
		this.zcdzbm = zcdzbm;
	}
	public String getSsgx() {
		return ssgx;
	}
	public void setSsgx(String ssgx) {
		this.ssgx = ssgx;
	}
	public String getXqzt() {
		return xqzt;
	}
	public void setXqzt(String xqzt) {
		this.xqzt = xqzt;
	}
	public String getParentdm() {
		return parentdm;
	}
	public void setParentdm(String parentdm) {
		this.parentdm = parentdm;
	}
	public String getXqnm() {
		return xqnm;
	}
	public void setXqnm(String xqnm) {
		this.xqnm = xqnm;
	}
	public String getYwjkc() {
		return ywjkc;
	}
	public void setYwjkc(String ywjkc) {
		this.ywjkc = ywjkc;
	}
	public String getHxjg() {
		return hxjg;
	}
	public void setHxjg(String hxjg) {
		this.hxjg = hxjg;
	}
	public String getPsSign() {
		return psSign;
	}
	public void setPsSign(String psSign) {
		this.psSign = psSign;
	}
	public void setZhxz(String zhxz) {
		this.zhxz = zhxz;
	}
	public String getZhxz() {
		return zhxz;
	}
	public String getOINSID() {
		return OINSID;
	}
	public void setOINSID(String oINSID) {
		OINSID = oINSID;
	}
	public String getWsSign() {
		return wsSign;
	}
	public void setWsSign(String wsSign) {
		this.wsSign = wsSign;
	}
	public Double getYJG() {
		return YJG;
	}
	public void setYJG(Double yJG) {
		YJG = yJG;
	}
	public Double getPGJG() {
		return PGJG;
	}
	public void setPGJG(Double pGJG) {
		PGJG = pGJG;
	}
	public String getROOMID() {
		return ROOMID;
	}
	public void setROOMID(String rOOMID) {
		ROOMID = rOOMID;
	}
//	public Double getYjgView() {
//		return yjgView;
//	}
//	public void setYjgView(Double yjgView) {
//		this.yjgView = yjgView;
//	}
//	public Double getPgjgView() {
//		return pgjgView;
//	}
//	public void setPgjgView(Double pgjgView) {
//		this.pgjgView = pgjgView;
//	}
	public void setCd00053Qtxzid(String cd00053Qtxzid) {
		this.cd00053Qtxzid = cd00053Qtxzid;
	}
	public String getCd00053Qtxzid() {
		return cd00053Qtxzid;
	}
//	public void setScpgjg(Double scpgjg) {
//		this.scpgjg = scpgjg;
//	}
//	public Double getScpgjg() {
//		return scpgjg;
//	}
	public String getOwnRoomid() {
		return ownRoomid;
	}
	public void setOwnRoomid(String ownRoomid) {
		this.ownRoomid = ownRoomid;
	}
	public Integer getSfsyfc() {
		return sfsyfc;
	}
	public void setSfsyfc(Integer sfsyfc) {
		this.sfsyfc = sfsyfc;
	}
	public String getSfsyfcmc() {
		return sfsyfcmc;
	}
	public void setSfsyfcmc(String sfsyfcmc) {
		this.sfsyfcmc = sfsyfcmc;
	}
	public String getErrorSign() {
		return errorSign;
	}
	public void setErrorSign(String errorSign) {
		this.errorSign = errorSign;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getInfoMsg() {
		return infoMsg;
	}
	public void setInfoMsg(String infoMsg) {
		this.infoMsg = infoMsg;
	}
	/**
	 * @return the wsjs
	 */
	public Double getWsjs() {
		return wsjs;
	}
	/**
	 * @param wsjs the wsjs to set
	 */
	public void setWsjs(Double wsjs) {
		this.wsjs = wsjs;
	}
	/**
	 * @return the wsrq
	 */
	public Date getWsrq() {
		return wsrq;
	}
	/**
	 * @param wsrq the wsrq to set
	 */
	public void setWsrq(Date wsrq) {
		this.wsrq = wsrq;
	}
	public String getCd00001Mfgjdm() {
		return cd00001Mfgjdm;
	}
	public void setCd00001Mfgjdm(String cd00001Mfgjdm) {
		this.cd00001Mfgjdm = cd00001Mfgjdm;
	}
	public String getCd00001Gmfgjdm() {
		return cd00001Gmfgjdm;
	}
	public void setCd00001Gmfgjdm(String cd00001Gmfgjdm) {
		this.cd00001Gmfgjdm = cd00001Gmfgjdm;
	}
	public String getMfgjdm() {
		return mfgjdm;
	}
	public void setMfgjdm(String mfgjdm) {
		this.mfgjdm = mfgjdm;
	}
	public String getGmfgjdm() {
		return gmfgjdm;
	}
	public void setGmfgjdm(String gmfgjdm) {
		this.gmfgjdm = gmfgjdm;
	}
	/**
	 * @return the zrfTel
	 */
	public String getZrfTel() {
		return zrfTel;
	}
	/**
	 * @param zrfTel the zrfTel to set
	 */
	public void setZrfTel(String zrfTel) {
		this.zrfTel = zrfTel;
	}
	/**
	 * @return the csfTel
	 */
	public String getCsfTel() {
		return csfTel;
	}
	/**
	 * @param csfTel the csfTel to set
	 */
	public void setCsfTel(String csfTel) {
		this.csfTel = csfTel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getLx() {
		return lx;
	}
	public void setLx(Integer lx) {
		this.lx = lx;
	}

}
