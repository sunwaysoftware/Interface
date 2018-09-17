package com.sunway.webService;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.sunway.function.impl.BaseFunction;

public class Process implements Serializable {

	private static final long serialVersionUID = -4196580060697805087L;
	static Logger logger = Logger.getLogger(Process.class);
	
	/**
	 * 执行PgProcess方法
	 * @param info
	 * @return
	 */
	public String PgProcess(String info){
		BaseFunction bf = new BaseFunction();		
		logger.info("【请求报文】"+info);
		return bf.combineXML(bf.parseFunction(bf.parseXML(info)));
	}

}
