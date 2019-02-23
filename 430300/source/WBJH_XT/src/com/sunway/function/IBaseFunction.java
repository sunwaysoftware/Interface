package com.sunway.function;

import java.sql.Connection;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import org.dom4j.Element;

import com.sunway.vo.Functions;

public interface IBaseFunction {

	/**
	 * 解析客户端传来的XML
	 * @param XML
	 * @return
	 */
	public Functions parseXML(String XML);

	/**
	 * 解析方法XML节点
	 * @param funs
	 * @return 
	 */
	public String parseFunction(Functions funs);

	/**
	 * 重组XML
	 * @param funXML
	 * @return
	 */
	public String combineXML(String funXML);
	
}
