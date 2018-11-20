package com.sunway.webService;

import java.io.Serializable;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.sunway.function.impl.BaseFunction;
import com.sunway.function.impl.QueryBdcInfo;
import com.sunway.util.JaxbUtil;
import com.sunway.vo.BdcInterface;
import com.sunway.vo.BdcInterface.FdcqInfo;
import com.sunway.vo.BdcUnique;
import com.sunway.vo.BdcUnique.BdcInfo;

import pub.webservice.impl.FdcqByCardClient;

public class Process implements Serializable {

	private static final long serialVersionUID = -4196580060697805087L;
	static Logger logger = Logger.getLogger(Process.class);

	/**
	 * 执行PgProcess方法
	 * 
	 * @param info
	 * @return
	 */
	public String PgProcess(String info) {
		BaseFunction bf = new BaseFunction();
		return bf.combineXML(bf.parseFunction(bf.parseXML(info)));
	}

	/**
	 * 查询唯一住房
	 * 
	 * @param xml
	 * @return
	 */
	public String queryBdcInfo(String qStr) {
		BdcInterface bdcInterface = new BdcInterface();
		String xmlReq = null;
		String xmlResp = null;
		String qCzr = null;
		// JSON to javabean
		Gson gson = new Gson();
		logger.info("解析国土接口【GetFdcqByCard】查询条件...");
		try {
			BdcUnique reqBdc = gson.fromJson(qStr, BdcUnique.class);
			bdcInterface.setFZJHM(reqBdc.getpCode());
			bdcInterface.setFSQRMC(reqBdc.getpName());
			qCzr = reqBdc.getCzr();
			xmlReq = JaxbUtil.convertToXml(bdcInterface, null);
			logger.info(xmlReq);
		} catch (Exception e) {
			logger.error("解析查询条件报错", e);
			return null;
		}
		
		// 调用接口，返回XML字符串
		try {
			FdcqByCardClient fdcqClient = new FdcqByCardClient();
			xmlResp = fdcqClient.execBdcWs(xmlReq);
		} catch (Exception e) {
			logger.error("调用国土接口过程中报错\n", e);
			return null;
		}
		
		// Insert Log Data
		logger.info("记录调用国土接口【GetFdcqByCard】日志信息...");
		QueryBdcInfo bdcInfo = new QueryBdcInfo();
		try {
			bdcInfo.insertLogData(xmlReq, xmlResp, qCzr);
		} catch (Exception e) {
			logger.error("记录调用国土接口【GetFdcqByCard】日志信息过程中报错", e);
			return null;
		}

		// BDC XML to BDC Bean
		bdcInterface = new BdcInterface();
		bdcInterface = (BdcInterface) JaxbUtil.convertToJavaBean(xmlResp, bdcInterface);
		// BDC Bean convert PG Bean
		BdcUnique pgBean = convertBean(bdcInterface);
		// PG Bean to JSON
		return gson.toJson(pgBean);
	}

	/**
	 * BDC Bean convert PG Bean
	 * 
	 * @param a
	 * @param b
	 */
	private BdcUnique convertBean(BdcInterface bdc) {
		BdcUnique bdcRtn = new BdcUnique();
		bdcRtn.setpCode(bdc.getFZJHM());
		bdcRtn.setpName(bdc.getFSQRMC());
		for (FdcqInfo fdc : bdc.getFdcqList()) {
			BdcInfo bdcInfo = new BdcInfo();
			bdcInfo.setDYH(fdc.getFBDCDYH());
			bdcInfo.setZLDZ(fdc.getFFDZL());
			bdcRtn.getBdcList().add(bdcInfo);
			bdcInfo = null;
		}
		return bdcRtn;
	}
	
//	// Test XML
//	private String testResponse() {
//
//		StringBuilder strXml = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//		strXml.append("<INFO>");
//		strXml.append("	<RESULT_FLAG>1</RESULT_FLAG>");
//		strXml.append("	<RESULT_MESSAGE>查询成功!</RESULT_MESSAGE>");
//		strXml.append("	<FSQRMC>陈湘金</FSQRMC>");
//		strXml.append("	<FZJHM>43283119590920261X</FZJHM>");
//		strXml.append("	<FDCQINFO>");
//		strXml.append("		<FDCQ>");
//		strXml.append("			<FBDCDYH>431003002070GB00010F00410055</FBDCDYH>");
//		strXml.append("			<FFDZL>郴州香雪大道中珠·爱莲湖畔3#栋1502房</FFDZL>");
//		strXml.append("		</FDCQ>");
//		strXml.append("		<FDCQ>");
//		strXml.append("			<FBDCDYH>431002001100GB00348F00010001</FBDCDYH>");
//		strXml.append("			<FFDZL>开发区五岭大道东面怡松园小区A-38、A-42101房（复式）</FFDZL>");
//		strXml.append("		</FDCQ>");
//		strXml.append("		<FDCQ>");
//		strXml.append("			<FBDCDYH>431002001093GB00018F00490005</FBDCDYH>");
//		strXml.append("			<FFDZL>五岭大道五岭花园7栋104</FFDZL>");
//		strXml.append("		</FDCQ>");
//		strXml.append("	</FDCQINFO>");
//		strXml.append("</INFO>");
//		return strXml.toString();
//	}

}
