package com.sunway.function.impl;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunway.function.IBaseFunction;
import com.sunway.function.IBaseObject;
import com.sunway.vo.Functions;

public class BaseFunction implements IBaseFunction {

	/**
	 * 请求流水号生成
	 * 
	 * @return S + YYYYMMDD + HIMISS + XXXXX
	 */
	protected String generateID() {
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyyMMddHHmmss");
		return "S" + fmtDate.format(new Date()) + (int)((Math.random()*9+1)*10000);
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
		try {
			for (int i = 0; i < funs.getFunctions().size(); i++) {
				element = funs.getFunctions().get(i);
				Class<?> obj = Class.forName("com.sunway.function.impl." + element.attributeValue("Name"));
				strBuffer.append(((IBaseObject) obj.newInstance()).executeFunction(element));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return strBuffer.toString();
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
	public Element getElementByAttr(Element fatherElement, String elementName)
			throws Exception {
		Element resElement = null;
		if (null != fatherElement && !"".equals(fatherElement.asXML())) {
			for (int i = 0; i < fatherElement.elements().size(); i++) {
				if (elementName.equals(fatherElement.elements().get(i)
						.getName())) {
					resElement = fatherElement.elements().get(i);
					break;
				}
			}
		}
		return resElement;
	}

	@Override
	public String getAttributeValue(Element element, String attributeName)
			throws Exception {
		String resAttr = null;
		if (null != element && !"".equals(element.asXML())) {
			for (int j = 0; j < element.elements().size(); j++) {
				for (int i = 0; i < element.elements().get(j).attributeCount(); i++) {
					if (attributeName.equals(element.elements().get(j)
							.attributes().get(i).getName())) {
						resAttr = element.elements().get(j)
								.attributeValue(attributeName);
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
		if (null != fatherElement && !"".equals(fatherElement.asXML())) {
			for (int i = 0; i < fatherElement.elements().size(); i++) {
				if (elementName.equals(fatherElement.elements().get(i)
						.getName())) {
					resElement = fatherElement.elements().get(i);
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
