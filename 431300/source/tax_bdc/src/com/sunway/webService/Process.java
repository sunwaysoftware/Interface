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
		BaseFunction bf = new BaseFunction();	
		logger.info("Request content: "+info);
		try {
			DocumentHelper.parseText(info);
		} catch (DocumentException e) {
			logger.error("XML format error: "+ e.getMessage());
		}
		return bf.combineXML(bf.parseFunction(bf.parseXML(info)));
	}

}
