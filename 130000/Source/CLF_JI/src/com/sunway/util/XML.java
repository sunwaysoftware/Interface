package com.sunway.util;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunway.vo.Pgt00001;
import com.sunway.vo.Pgt00352xml;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00370;

public class XML implements Serializable {

	private static final long serialVersionUID = 5848948091169711224L;

	public void xml(String fcid) {

	}

	/**
	 * 组织请求报文XML
	 * 
	 * @param fcid
	 *            房产受理号
	 * @param fcbm
	 *            房产部门编码
	 * @return 报文XML
	 * @throws Exception
	 */
	public String getxml(String fcid, String fcbm) throws Exception {

		return String.format("<?xml version='1.0' encoding='UTF-8'?>"
				+ "<EAIRequest>" 
				+ "<Requests>" 
				+ "<Request Name='GetFCXX'>"
				+ "<FCXX FCSLH='%s' />" 
				+ "<FCXX FCBM='%s' />" 
				+ "</Request>"
				+ "</Requests>" 
				+ "</EAIRequest>", fcid, fcbm);
	}

	public String getHXxml(String fcslh, String fpid, String spid, String pgjg,
			String qsjg, String qtjg, String oinsid, String roomid,
			String ownroomid, String htzj, String pgdj, String dfspid, String strOther)	throws Exception {

		return String.format("<?xml version='1.0' encoding='GB2312'?>"
				+ "<EAIRequest>"
				+ "<Requests>"
				+ "<Request Name='WriFCXX'>"
				+ "<FCXX FCSLH='%s' />"
				+ "<FCXX FPID='%s' />"
				+ "<FCXX SPID='%s' />"
				+ "<FCXX PGJG='%s' />"
				+ "<FCXX QSJG='%s' />"
				+ "<FCXX QTJG='%s' />"
				+ "<FCXX OINSID='%s' />" 
				+ "<FCXX ROOMID='%s' />"
				+ "<FCXX OWNROOMID='%s' />" 
				+ "<FCXX HTZJ='%s' />"
				+ "<FCXX PGDJ='%s' />" 
				+ "<FCXX DFSPID='%s' />" 
				+ strOther
				+ "</Request>" 
				+ "</Requests>"
				+ "</EAIRequest>", fcslh, fpid, spid, pgjg, qsjg, qtjg, oinsid,
				roomid, ownroomid, htzj, pgdj, dfspid);
	}

	public String getDJZxml(Pgv00302 v00302) throws Exception {
		String dyfhBuffer = v00302.getBwjfh();
		String fh = "";
		String dy = "";
		if (!Common.isNullOrEmpty(dyfhBuffer)) {
			if (dyfhBuffer.length() > 5) {
				fh = dyfhBuffer.substring((dyfhBuffer.length() - 3),
						dyfhBuffer.length());
				dy = dyfhBuffer.substring((dyfhBuffer.length() - 5),
						(dyfhBuffer.length() - 3));
			}
		}

		String strXML = String.format("<?xml version='1.0' encoding='UTF-8'?>"
				+ "<R>" + "<H>" + "<F n='CHANNEL_PWD'>%s</F>"
				+ "<F n='VOUCH_FLOW_NO'>%s</F>" + "<F n='CHANNEL_ACC'>%s</F>"
				+ "<F n='BUSI_CODE'>I_FC_FCJYXXJS</F>"
				+ "<F n='CHANNEL_CODE'>%s</F>" + "<F n='ACTIVITY_CODE'>0</F>"
				+ "</H>" + "<B>" + "<S>" + "<F n='FCJYID'>%s</F>"
				+ "<F n='WBMBM'>%s</F>" + "<F n='FCSLID'>%s</F>"
				+ "<F n='OLD_ID'>%s</F>" + "<F n='CLH'>%s</F>"
				+ "<F n='YT'>%s</F>" + "<F n='H_ADDR'>%s</F>"
				+ "<F n='XQMC'>%s</F>" + "<F n='DYH'>%s</F>"
				+ "<F n='FH'>%s</F>" + "<F n='SZLC'>%s</F>"
				+ "<F n='ZLC'>%s</F>" + "<F n='JZJG'>%s</F>"
				+ "<F n='FWLB'>%s</F>" + "<F n='JX_TYPE'>%s</F>"
				+ "<F n='JZMJ'>%s</F>" + "<F n='HTZJ'>%s</F>"
				+ "<F n='JYSJ'>%s</F>" + "<F n='FZRQ'>%s</F>"
//				+ "<F n='WSRQ'>%s</F>" + "<F n='WSJS'>%s</F>" // 契税完税信息
				+ "<F n='DF'>%s</F>" + "<F n='CX'>%s</F>" + "<F n='CG'>%s</F>"
				+ "<F n='S_JG'>%s</F>" + "<F n='FZZPGJG'>%s</F>"
				+ "<F n='SYFC'>%s</F>" + "</S>" + "<M>" + "<L>"
				+ "<F n='FLAG'>S</F>" + "<F n='ZZLX'>%s</F>"
				+ "<F n='ZZHM'>%s</F>" + "<F n='MC'>%s</F>" + "</L>" + "<L>"
				+ "<F n='FLAG'>B</F>" + "<F n='ZZLX'>%s</F>"
				+ "<F n='ZZHM'>%s</F>" + "<F n='MC'>%s</F>" + "</L>" + "</M>"
				+ "</B>" + "</R>", v00302.getDjz_channel_pwd(),
				Common.checkNull(v00302.getFclsh()),
				v00302.getDjz_channel_acc(), v00302.getDjz_channel_code(),
				v00302.getFcid(), v00302.getDjz_wbmbm(),
				Common.checkNull(v00302.getFcslh()),
				Common.checkNull(v00302.getFczh()),
				Common.checkNull(v00302.getClh()),
				Common.checkNull(v00302.getGhyt()),
				Common.checkNull(v00302.getFwtdzl()),
				Common.checkNull(v00302.getXqnm()), dy, fh, v00302.getSzlc(),
				v00302.getZlc(), v00302.getJzjg(),
				Common.checkNull(v00302.getFwlx()),
				Common.checkNull(v00302.getJylx()), v00302.getJzmj(),
				v00302.getJyjg(),
				Common.formatToYYYYMMDDSimple(v00302.getJysj()),
				Common.formatToYYYYMMDDSimple(v00302.getDjrq()),
//				Common.formatToYYYYMMDDSimple(v00302.getWsrq()), v00302.getWsjs(),// 契税完税信息
				v00302.getDf(), v00302.getCx(), v00302.getCg(),
				v00302.getYjg(), v00302.getSbpgjg(), v00302.getSfsyfc(),
				Common.checkNull(v00302.getZjlx()), subZJHM(v00302.getZjhm()),
				subCSF(v00302.getNsrmc()),
				Common.checkNull(v00302.getCsfZjlx()),
				subZJHM(v00302.getCsfzjhm()), subCSF(v00302.getCsfnsrmc()));
		// System.out.println(strXML);
		return strXML;
	}

	public String getDJZSeXML(Pgv00302 v00302) {
		String srtXML = String.format("<?xml version='1.0' encoding='UTF-8'?>"
				+ "<R>" + "<H>" + " <F n='CHANNEL_PWD'>%s</F>"
				+ " <F n='VOUCH_FLOW_NO'>%s</F>" + " <F n='CHANNEL_ACC'>%s</F>"
				+ " <F n='BUSI_CODE'>I_FC_FCJYZSXXTQ</F>"
				+ " <F n='CHANNEL_CODE'>%s</F>" + " <F n='ACTIVITY_CODE'>0</F>"
				+ "</H>" + "<B>" + "<S>" + " <F n='FCJYID'>%s</F>"
				+ " <F n='WBMBM'>%s</F>" + "</S>" + "<M/>" + "</B>" + "</R>",
				v00302.getDjz_channel_pwd(), v00302.getFclsh(),
				v00302.getDjz_channel_acc(), v00302.getDjz_channel_code(),
				v00302.getFcid(), v00302.getDjz_wbmbm());
		// System.out.println(srtXML);
		return srtXML;
	}

	public String getDJZPgjgXML(Pgv00302 v00302) throws Exception {

		String strXML = String.format("<?xml version='1.0' encoding='UTF-8'?>"
				+ "<R>" + "<H>" + "<F n='CHANNEL_PWD'>%s</F>"
				+ "<F n='VOUCH_FLOW_NO'>%s</F>" + "<F n='CHANNEL_ACC'>%s</F>"
				+ "<F n='BUSI_CODE'>I_FC_FCJYPGJGJS</F>"
				+ "<F n='CHANNEL_CODE'>%s</F>" + "<F n='ACTIVITY_CODE'>0</F>"
				+ "</H>" + "<B>" + "<S>" + "<F n='FCJYID'>%s</F>"
				+ "<F n='WBMBM'>%s</F>" + "<F n='HDJG'>%s</F>" + "</S>"
				+ "<M />" + "</B>" + "</R>", v00302.getDjz_channel_pwd(),
				v00302.getFclsh(), v00302.getDjz_channel_acc(),
				v00302.getDjz_channel_code(), v00302.getFcid(),
				v00302.getDjz_wbmbm(), v00302.getScpgjg().toString());
		return strXML;
	}

	public String getCancelHangXML(String OINSID) throws Exception {
		String strXML = String.format("<?xml version='1.0' encoding='GBK'?>"
				+ "<EAIRequest>" + "<Requests>" + "<Request Name='CancelHang'>"
				+ "<CancelHang OINSID='%s' />" + "</Request>" + "</Requests>"
				+ "</EAIRequest>", OINSID);
		return strXML;
	}

	public Pgt00352xml jxxml(String xml, String userId, String ssgx) throws Exception {
		Pgt00352xml listResult = new Pgt00352xml();
		SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(new ByteArrayInputStream(xml.getBytes()));
		Element root = doc.getRootElement();
		Element ROWS = root.element("Requests").element("Request").element("Results").element("Result").element("ROWS");
		List<?> ROW = ROWS.elements("ROW");
		for (int i = 0; i < ROW.size(); i++) {
			listResult.getPgt00352xmllist().add(SetVParameters((Element)ROW.get(i), i, userId, ssgx));
		}
		return listResult;
	}

	public String jxHXxml(String xml) throws Exception {
		String result = null;
		SAXReader saxReader = new SAXReader();
		Document doc = null;
		doc = saxReader.read(new ByteArrayInputStream(xml.getBytes()));
		Element root = doc.getRootElement();
		Element ROWS = root.element("Requests").element("Request").element("Results").element("Result").element("Rows");
		List<?> ROW = ROWS.elements("Row");
		if ("OK".equals(((Element)ROW.get(0)).attributeValue("RESULT"))) {
			result = "true";
		} else {
			result = ((Element)ROW.get(0)).attributeValue("errorMessage");
		}
		return result;
	}

	/**
	 * 封装税种税额
	 */
	protected ArrayList<Pgv00370> packSzSe(ArrayList<Pgt00001> szList) {
		ArrayList<Pgv00370> tempList = new ArrayList<Pgv00370>();
		/*
		 * String[] bufferNm =
		 * {"契税","营业税","城市维护建设税","教育费附加、地方教育附加","个人所得税","印花税","土地增值税"}; String[]
		 * bufferId = {"01","02","03","04","05","06","07"};
		 */
		for (int i = 0; i < szList.size(); i++) {
			Pgv00370 tempBean = new Pgv00370();
			Pgt00001 bean = szList.get(i);
			if ("0".equals(bean.getParentid())) {
				continue;
			} else {
				tempBean.setCd_00001_sz(bean.getInfoid());
				tempBean.setSz(bean.getInfonm());
				tempBean.setSe(0.0);
				tempList.add(tempBean);
			}
		}
		return tempList;
	}

	protected ArrayList<Pgv00370> valDJZSzSe(String sz_djz, Double se_djz,
			ArrayList<Pgv00370> pack) {
		for (int i = 0; i < pack.size(); i++) {
			Pgv00370 tempBean = pack.get(i);
			if (tempBean.getSz().equals(sz_djz)) {
				tempBean.setSe(se_djz);
			}
		}

		return pack;
	}

	/**
	 * View数据转存
	 * 
	 * @param rs数据集
	 * @return 数据实体
	 * @throws Exception
	 */
	protected Pgt00352xml SetVParameters(Element ROW, int i, String userId, String ssgx) throws Exception {
		Pgt00352xml e = new Pgt00352xml();
		e.setFCSLH(valParamEmpty(ROW.attributeValue("FCSLH")) ? ROW.attributeValue("FCSLH") : "");
		e.setYFCZH(valParamEmpty(ROW.attributeValue("YFCZH")) ? ROW.attributeValue("YFCZH") : "");
		e.setZRFSFLX(valParamEmpty(ROW.attributeValue("ZRFSFLX")) ? ROW.attributeValue("ZRFSFLX") : "");
		e.setZRFSFID(valParamEmpty(ROW.attributeValue("ZRFSFID")) ? ROW.attributeValue("ZRFSFID") : "");
		e.setZRFMC(valParamEmpty(ROW.attributeValue("ZRFMC")) ? ROW.attributeValue("ZRFMC") : "");
		e.setCSFSFLX(valParamEmpty(ROW.attributeValue("CSFSFLX")) ? ROW.attributeValue("CSFSFLX") : "");
		e.setCSFSFID(valParamEmpty(ROW.attributeValue("CSFSFID")) ? ROW.attributeValue("CSFSFID") : "");
		e.setCSFMC(valParamEmpty(ROW.attributeValue("CSFMC")) ? ROW.attributeValue("CSFMC") : "");
		e.setCLH(valParamEmpty(ROW.attributeValue("CLH")) ? ROW.attributeValue("CLH") : "");
		e.setSJYT(valParamEmpty(ROW.attributeValue("SJYT")) ? ROW.attributeValue("SJYT") : "");
		e.setLFDZ(valParamEmpty(ROW.attributeValue("LFDZ")) ? ROW.attributeValue("LFDZ") : "");
		e.setDYFH(valParamEmpty(ROW.attributeValue("DYFH")) ? ROW.attributeValue("DYFH") : "");
		String szlc = valParamEmpty(ROW.attributeValue("SZLC")) ? ROW.attributeValue("SZLC") : "0";
		if (szlc.length() >= 3 && szlc.length() < 5) {
			e.setSZLC(szlc.substring(0, 1));
		} else if (szlc.length() >= 5) {
			e.setSZLC(szlc.substring(0, 2));
		} else {
			e.setSZLC(szlc);
		}
		e.setZLC(valParamEmpty(ROW.attributeValue("ZLC")) ? ROW.attributeValue("ZLC") : "0");
		e.setJZJG(valParamEmpty(ROW.attributeValue("JZJG")) ? ROW.attributeValue("JZJG") : "");
		e.setFWLX(valParamEmpty(ROW.attributeValue("FWLX")) ? ROW.attributeValue("FWLX") : "");
		e.setJYLX(valParamEmpty(ROW.attributeValue("JYLX")) ? ROW.attributeValue("JYLX") : "");
		e.setJZMJ(Common.convertToDouble(valParamEmpty(ROW.attributeValue("JZMJ")) ? ROW.attributeValue("JZMJ") : "0.0"));
		e.setHTZJ(Common.convertToDouble(valParamEmpty(ROW.attributeValue("HTZJ")) ? ROW.attributeValue("HTZJ") : "0.0"));
		e.setJYSJ(Common.convertToSqlDate(valParamEmpty(ROW.attributeValue("JYSJ")) ? ROW.attributeValue("JYSJ") : ""));
		e.setFZRQ(Common.convertToSqlDate(valParamEmpty(ROW.attributeValue("FZRQ")) ? ROW.attributeValue("FZRQ") : ""));
		e.setDF(valParamEmpty(ROW.attributeValue("DF")) ? ROW.attributeValue("DF") : "");
		e.setCX(valParamEmpty(ROW.attributeValue("CX")) ? ROW.attributeValue("CX") : "");
		e.setCG(valParamEmpty(ROW.attributeValue("CG")) ? ROW.attributeValue("CG") : "");
		e.setOINSID(valParamEmpty(ROW.attributeValue("OINSID")) ? ROW.attributeValue("OINSID") : "");
		e.setYJG(Common.convertToDouble(valParamEmpty(ROW.attributeValue("YJG")) ? ROW.attributeValue("YJG") : "0.0"));
		e.setPGJG(Common.convertToDouble(valParamEmpty(ROW.attributeValue("PGJG")) ? ROW.attributeValue("PGJG") : "0.0"));
		e.setROOMID(valParamEmpty(ROW.attributeValue("ROOMID")) ? ROW.attributeValue("ROOMID") : "");
		e.setOwnRoomid(valParamEmpty(ROW.attributeValue("OWNROOMID")) ? ROW.attributeValue("OWNROOMID") : "");
		e.setSfsyfcmc(valParamEmpty(ROW.attributeValue("SFSYFC")) ? ROW.attributeValue("SFSYFC") : "");
		e.setErrorSign(ROW.attributeValue("ERRORSIGN"));
		e.setErrorMessage(ROW.attributeValue("ERRORMESSAGE"));
		e.setCzr(userId);
		e.setSsgx(ssgx);
		e.setXqdm(valParamEmpty(ROW.attributeValue("XQDM")) ? ROW.attributeValue("XQDM") : "");
		e.setJcsj(valParamEmpty(ROW.attributeValue("JCNF")) ? ROW.attributeValue("JCNF") : "");
		e.setWsrq(Common.convertToSqlDate(valParamEmpty(ROW.attributeValue("WSRQ")) ? ROW.attributeValue("WSRQ") : ""));
		e.setWsjs(Common.convertToDouble(valParamEmpty(ROW.attributeValue("WSJS")) ? ROW.attributeValue("WSJS") : "0.0"));	
		e.setZrfTel(valParamEmpty(ROW.attributeValue("ZRFTEL"))?ROW.attributeValue("ZRFTEL"):"");
		e.setCsfTel(valParamEmpty(ROW.attributeValue("CSFTEL"))?ROW.attributeValue("CSFTEL"):"");
		return e;
	}

	/**
	 * 判断证件号码个数
	 * 
	 * @param zjhm
	 * @return
	 * @throws Exception
	 */
	protected String subZJHM(String zjhm) throws Exception {
		if (zjhm.contains("、")) {
			String[] temp = zjhm.split("、");
			return temp[0];
		} else {
			return zjhm;
		}

	}

	/**
	 * 判断产权人个数
	 * 
	 * @param csf
	 * @return
	 * @throws Exception
	 */
	protected String subCSF(String csf) throws Exception {
		if (csf.contains(" ")) {
			String[] temp = csf.split(" ");
			return temp[0];
		} else {
			return csf;
		}
	}

	/**
	 * 判断数值是否为空
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	protected boolean valParamEmpty(String param) throws Exception {
		if ("null".equals(param) || "".equals(param) || null == param)
			return false;
		else
			return true;

	}

}
