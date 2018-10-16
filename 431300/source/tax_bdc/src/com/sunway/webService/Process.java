package com.sunway.webService;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import com.sunway.function.impl.BaseFunction;


public class Process {

	static Logger logger = Logger.getLogger(Process.class);
	
	/**
	 * 执行PgProcess方法
	 * @param info
	 * @return
	 */
	public String PgProcess(String info){
		String strReturn = null;
		BaseFunction bf = new BaseFunction();	
		logger.info("Request XML content: " + info);
		try {
			DocumentHelper.parseText(info);
		} catch (DocumentException e) {
			logger.error("Request XML format error： ", e);
		}
		strReturn = bf.combineXML(bf.parseFunction(bf.parseXML(info)));
		logger.info("Response XML content: " + strReturn);
		return strReturn;
	}

}
