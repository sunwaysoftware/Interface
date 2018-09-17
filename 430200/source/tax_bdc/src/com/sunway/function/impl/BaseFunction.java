package com.sunway.function.impl;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import oracle.jdbc.rowset.OracleCachedRowSet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunway.function.IBaseFunction;
import com.sunway.function.IBaseObject;
import com.sunway.jdbc.ConnectionFactory;
import com.sunway.vo.Functions;

public class BaseFunction implements IBaseFunction {

	@Override
	public Connection getConnection() throws Exception {
		return ConnectionFactory.getConnection();
	}

	@Override
	public Functions parseXML(String XML) {
		Functions funs = new Functions();
		SAXReader saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read(new ByteArrayInputStream(XML.getBytes()));
			Element rootElement = document.getRootElement();
			Iterator<Element> rootIterator = rootElement.elementIterator();
			if (rootIterator.hasNext()) {
				Element childElement = rootIterator.next();
				funs.setFunctions(childElement.elements());
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return funs;
	}

	@Override
	public String parseFunction(Functions funs) {
		StringBuffer strBuffer = new StringBuffer();
		Element element = null;
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			for (int i = 0; i < funs.getFunctions().size(); i++) {
				element = funs.getFunctions().get(i);
				Class<?> obj = Class.forName("com.sunway.function.impl." + element.attributeValue("Name"));
				strBuffer.append(((IBaseObject) obj.newInstance()).executeFunction(element, conn));
			}
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (null != conn)
					conn.close();
			} catch (Exception e) {
				
			}

		}
		return strBuffer.toString();
	}

	@Override
	public CachedRowSet queryFunction(String sql, Connection conn) {
		PreparedStatement state = null;
		ResultSet rs = null;
		OracleCachedRowSet ocrs = null;
		try {
			state = conn.prepareStatement(sql);
			rs = state.executeQuery();
			ocrs = new OracleCachedRowSet();
			ocrs.populate(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != state)
					state.close();
			} catch (SQLException e) {
			}
		}
		return ocrs;
	}

	@Override
	public boolean executeFunction(String sql, Connection conn)	throws Exception {
		boolean result = false;
		PreparedStatement state = null;
		try {
			state = conn.prepareStatement(sql);
			state.execute();
			result = true;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	@Override
	public String combineXML(String funXML) {
		String strXML = "<?xml version='1.0' encoding='GBK'?>" + "<EAIRequest>"
				+ "<Requests>" + funXML + "</Requests>" + "</EAIRequest>";
		return strXML;
	}

	@Override
	public Integer paginationData(List<?> list, Integer pageIndex,
			Integer pageDataBase, String name) {
		if ("total".equals(name)) {
			return list.size();
		} else if ("dataStart".equals(name)) {
			return ((pageIndex - 1) * pageDataBase);
		} else if ("dataEnd".equals(name)) {
			if ((list.size() - (pageIndex * pageDataBase)) >= pageDataBase) {
				return pageIndex * pageDataBase;
			} else if ((list.size() - (pageIndex * pageDataBase)) < pageDataBase) {
				return (list.size() - ((pageIndex - 1) * pageDataBase));
			} else if (pageDataBase == -1) {
				return list.size();
			}
		}
		return null;

	}

	@Override
	public void getFreeORS(CachedRowSet ocrs) {
		try {
			if (null != ocrs)
				ocrs.close();
		} catch (Exception e) {
		}

	}

	@Override
	public Element getElementByAttr(Element fatherElement, String elementName) throws Exception {
		Element resElement = null;
		if (null != fatherElement) {
			for (int i = 0; i < fatherElement.elements().size(); i++) {
				if (elementName.equals(((Element)fatherElement.elements().get(i)).getName())) {
					resElement = (Element) fatherElement.elements().get(i);
					break;
				}
			}
		}
		return resElement;
	}

	@Override
	public String getAttributeValue(Element element, String attributeName) throws Exception {
		String resAttr = null;
		if (null != element) {
			for (int j = 0; j < element.elements().size(); j++) {
				for (int i = 0; i < ((Element)element.elements().get(j)).attributeCount(); i++) {
					if (attributeName.equals(((Element)((Element)element.elements().get(j)).attributes().get(i)).getName())) {
						resAttr = ((Element)element.elements().get(j)).attributeValue(attributeName);
					}
				}
			}

		}
		return resAttr;
	}

	@Override
	public Element getElementByEle(Element fatherElement, String elementName)
			throws Exception {
		Element resElement = null;
		if (null != fatherElement) {
			for (int i = 0; i < fatherElement.elements().size(); i++) {
				if (elementName.equals(((Element)fatherElement.elements().get(i)).getName())) {
					resElement = (Element)fatherElement.elements().get(i);
					break;
				}
			}
		}
		return resElement;
	}

	@Override
	public Boolean cancelHangCommand(String key, Connection conn)
			throws Exception {
		boolean result = false;
		PreparedStatement state = null;
		String sql = String
				.format("UPDATE XTFCDATA.I_OTRANS T SET T.OSTATE = XTFCDATA.DF_XOR(XTFCDATA.DF_OR(T.OSTATE,768),768),t.remark='征税完毕' WHERE OINSID in (select oinsid from xtfcdata.i_optinst where oinsid= '%s' OR prloinsid = '%s' or oinsid in (select prloinsid from xtfcdata.i_optinst where oinsid= '%s'))",
						key, key, key);
		try {
			state = conn.prepareStatement(sql);
			state.execute();
			result = true;
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

}
