package com.sunway.function;

import java.util.List;

import org.dom4j.Element;

public interface IBaseObject {

	/**
	 * 执行节点方法
	 * @param element
	 * @return
	 */
	public String executeFunction(Element element);
	
	/**
	 * 组合方法XML
	 * @param list
	 * @return
	 */
	public String combineFunctionXML(List<?> list);
}
