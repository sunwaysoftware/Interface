package com.sunway.function.impl;

import java.io.ByteArrayInputStream;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sunway.function.IBaseFunction;
import com.sunway.function.IBaseObject;
import com.sunway.vo.Functions;

public class BaseFunction implements IBaseFunction {

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
	public String combineXML(String funXML) {
		String strXML = "<?xml version='1.0' encoding='GBK'?>" + "<EAIRequest>"
				+ "<Requests>" + funXML + "</Requests>" + "</EAIRequest>";
		return strXML;
	}

}
