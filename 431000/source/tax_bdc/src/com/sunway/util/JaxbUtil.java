/**
 * 
 */
package com.sunway.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * 
 * 
 * @author amani
 *
 */
public class JaxbUtil {

    /**
     * Convert JavaBean to XML
     * @param obj JavaBean class
     * @param encoding XML Encoding(default UTF-8)
     * @return
     */
    public static String convertToXml(Object obj, String encoding) {
        String strReturn = null;
        String strEncoding = "UTF-8";
        if(null!=encoding && !"".equals(encoding)){
            strEncoding = encoding;
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            //格式化输出，即按标签自动换行，否则就是一行输出
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // when debug, set true
            //设置编码（默认编码就是utf-8）
            marshaller.setProperty(Marshaller.JAXB_ENCODING, strEncoding);
            //是否省略xml头信息，默认不省略（false）
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            strReturn = writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return strReturn;
    }

    /**
     * Convert XML String to JavaBean
     * @param strXML XML string
     * @param obj
     * @return
     */
    public static Object convertToJavaBean(String strXML, Object obj) {
    	Object t = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            t = unmarshaller.unmarshal(new StringReader(strXML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return t;
    }
	
	
	
	
}
