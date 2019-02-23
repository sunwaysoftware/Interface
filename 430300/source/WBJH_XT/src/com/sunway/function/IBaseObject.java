package com.sunway.function;

import java.sql.Connection;
import java.util.ArrayList;

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
	public String combineFunctionXML(ArrayList<?> list);
}
