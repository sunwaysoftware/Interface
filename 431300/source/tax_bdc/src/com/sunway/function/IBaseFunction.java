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
	 * @param funEleList
	 * @return 
	 */
	public String parseFunction(Functions funs);
	
	/**
	 * 执行插入方法
	 * @param sql
	 * @param conn
	 * @return
	 */
	public boolean executeFunction(String sql, Connection conn) throws Exception;
	
	/**
	 * 重组XML
	 * @param funXML
	 * @return
	 */
	public String combineXML(String funXML);
	
	/**
	 * 分页处理
	 * @param list
	 * @return
	 */
	public Integer paginationData(List<?> list,Integer pageIndex,Integer pageDataBase,String name);
	
	
	/**
	 * 施放离线结果集
	 * @param ocrs
	 */
	public void getFreeORS(CachedRowSet ocrs);
	
	/**
	 * 根据属性名称查找元素对应节点
	 * @param fatherElement
	 * @param elementName
	 * @return
	 * @throws Exception
	 */
	public Element getElementByAttr(Element fatherElement,String elementName)throws Exception;
	
	/**
	 * 根据节点名称查找元素对应节点
	 * @param fatherElement
	 * @param elementName
	 * @return
	 * @throws Exception
	 */
	public Element getElementByEle(Element fatherElement,String elementName)throws Exception;
	
	/**
	 * 查找元素对应属性
	 */
	public String getAttributeValue(Element element,String attributeName)throws Exception;
	
	/**
	 * 取消挂起函数
	 */
	public Boolean cancelHangCommand(String key,Connection conn)throws Exception;
	
	
}
