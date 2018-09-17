/**
 * 
 */
package com.sunway.webService;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.log4j.Logger;

import com.sunway.function.impl.ReadSKXX;
import com.sunway.vo.PgtFCXX_W;

/**
 * @author Administrator
 *
 */
public class ReadSkxxWS implements Serializable {

	private static final long serialVersionUID = -8609886621447491027L;
	static Logger logger = Logger.getLogger(ReadSkxxWS.class);
	
	/**
	 * 返回交易完税信息（为房产局提供查询使用）
	 * @param info
	 * @return
	 */
	public OMElement returnPsData(String strXML) {
		logger.info("【房产读取完税信息】"+strXML);
		PgtFCXX_W fc = new PgtFCXX_W();
		OMElement element = null;
		OMElement omReturn = null;
		try {
			element = new StAXOMBuilder(new ByteArrayInputStream(strXML.getBytes("UTF-8"))).getDocumentElement();
			Iterator<?> desc = element.getFirstChildWithName(new QName("DATA")).getChildElements();
			while (desc.hasNext()) {
				OMElement element1 = (OMElement) desc.next();
				if (element1.getLocalName().equals("FCSLH"))
					fc.setFcslh(element1.getText());
				if (element1.getLocalName().equals("FCID"))
					fc.setSsqy(element1.getText());
			}
			ReadSKXX skxx = new ReadSKXX();
			String strReturn = skxx.executeFunction(fc);
			logger.info("【返回完税信息】"+strReturn);
			omReturn = new StAXOMBuilder(new ByteArrayInputStream(strReturn.getBytes("UTF-8"))).getDocumentElement();
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		} catch (XMLStreamException e) {
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return omReturn;
	}
	
}
