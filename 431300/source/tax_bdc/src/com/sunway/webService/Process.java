package com.sunway.webService;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

//import org.dom4j.Document;
//import org.dom4j.DocumentException;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.dom4j.QName;
//
import com.sunway.function.impl.BaseFunction;
//import com.sunway.function.impl.WbjhDAO;
//import com.sunway.vo.PgtFCXX;

public class Process {

	static Logger logger = Logger.getLogger(Process.class);
	
	/**
	 * 执行PgProcess方法
	 * @param info
	 * @return
	 */
	public String PgProcess(String info){
		BaseFunction bf = new BaseFunction();	
		logger.info("Request content: "+info);
		try {
			DocumentHelper.parseText(info);
		} catch (DocumentException e) {
			logger.error("XML format error: "+ e.getMessage());
		}
		return bf.combineXML(bf.parseFunction(bf.parseXML(info)));
	}
	
//	/**
//	 * 为外部系统提供【存量房写入】接口服务
//	 * @param info 报文
//	 * @return 应答报文
//	 */
//	public String insFcxx(String info){
//		WbjhDAO wbjh = new WbjhDAO();
//		PgtFCXX fcxx = new PgtFCXX();
//		Document document = null;
//		try {
//			document = DocumentHelper.parseText(info);
//		} catch (DocumentException e) {
//			logger.error(e.getMessage());
//			return "报文格式错误："+e.getMessage();
//		} 
//		Element rowElement = document.getRootElement().element(new QName("ROW"));
//		fcxx.setFcslh(chkElement(rowElement.element(new QName("FCSLH"))));
//		fcxx.setSsgx(chkElement(rowElement.element(new QName("FCID"))));
//		fcxx.setXqdm(chkElement(rowElement.element(new QName("XQDM"))));
//		fcxx.setYfczh(chkElement(rowElement.element(new QName("YFCZH"))));
//		fcxx.setZrfsflx(chkElement(rowElement.element(new QName("ZRFSFLX"))));
//		fcxx.setZrfmc(chkElement(rowElement.element(new QName("ZRFMC"))));
//		fcxx.setZrfsfid(chkElement(rowElement.element(new QName("ZRFSFID"))));
//		fcxx.setZrfTel(chkElement(rowElement.element(new QName("ZRFTEL"))));
//		fcxx.setCsfsflx(chkElement(rowElement.element(new QName("CSFSFLX"))));
//		fcxx.setCsfmc(chkElement(rowElement.element(new QName("CSFMC"))));
//		fcxx.setCsfsfid(chkElement(rowElement.element(new QName("CSFSFID"))));
//		fcxx.setCsfTel(chkElement(rowElement.element(new QName("CSFTEL"))));
//		fcxx.setClh(chkElement(rowElement.element(new QName("CLH"))));
//		fcxx.setSjyt(chkElement(rowElement.element(new QName("SJYT"))));
//		fcxx.setLfdz(chkElement(rowElement.element(new QName("LFDZ"))));
//		fcxx.setDyfh(chkElement(rowElement.element(new QName("DYFH"))));
//		fcxx.setZlc(chkElement(rowElement.element(new QName("ZLC"))));
//		fcxx.setSzlc(chkElement(rowElement.element(new QName("SZLC"))));
//		fcxx.setJzjg(chkElement(rowElement.element(new QName("JZJG"))));
//		fcxx.setFwlx(chkElement(rowElement.element(new QName("FWLX"))));
//		fcxx.setJylx(chkElement(rowElement.element(new QName("JYLX"))));
//		fcxx.setJzmj(chkElement(rowElement.element(new QName("JZMJ"))));
//		fcxx.setHtzj(chkElement(rowElement.element(new QName("HTZJ"))));
//		fcxx.setFzrq(chkElement(rowElement.element(new QName("FZRQ"))));
//		fcxx.setJcnf(chkElement(rowElement.element(new QName("JCNF"))));
//		fcxx.setJysj(chkElement(rowElement.element(new QName("JYSJ"))));
//		fcxx.setDf(chkElement(rowElement.element(new QName("DF"))));
//		fcxx.setCx(chkElement(rowElement.element(new QName("CX"))));
//		fcxx.setCg(chkElement(rowElement.element(new QName("CG"))));
//		fcxx.setQswsrq(chkElement(rowElement.element(new QName("WSRQ"))));
//		fcxx.setQswsjs(chkElement(rowElement.element(new QName("WSJS"))));
//		
//		return wbjh.execInsData(fcxx);
//	}
//
//	/**
//	 * 为外部系统提供【存量房完税信息】读取接口服务
//	 * @param info 报文
//	 * @return 应答报文
//	 */
//	public String readWsxx(String info){
//		return info;
//	}
//	
//	private String chkElement(Element e) {
//		if(null!=e)
//			return e.getTextTrim();
//		else
//			return "";
//	}

}
