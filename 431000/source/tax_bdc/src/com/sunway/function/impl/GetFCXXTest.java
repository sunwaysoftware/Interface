/**
 * 
 */
package com.sunway.function.impl;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author amani
 *
 */
public class GetFCXXTest {
	private static final String sign = "、"; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String strZRFMC = null;
		String strZRFSFLX = null;
		String strZRFSFID = null;
		String strZRFTEL = null;
		String strCSFMC = null;
		String strCSFSFID = null;
		String strCSFSFLX = null;
		String strCSFTEL = null;
		// TODO Auto-generated method stub

		StringBuffer strXML = new StringBuffer();
		strXML.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strXML.append("<INFO>");
		strXML.append("	<RESULT_FLAG>1</RESULT_FLAG>");
		strXML.append("	<RESULT_MESSAGE>数据查询成功</RESULT_MESSAGE>");
		strXML.append("	<FDCQINFO>");
		strXML.append("		<FDCQ>");
		strXML.append("			<JID>201810150095</JID>");
		strXML.append("			<FBDCDYH>430000000000000000000000000000</FBDCDYH>");
		strXML.append("			<FFDZL>郴州拉拉手动阀手动阀</FFDZL>");
		strXML.append("			<FJJZMJ>117.09</FJJZMJ>");
		strXML.append("			<FZYJZMJ>94.73</FZYJZMJ>");
		strXML.append("			<FFTJZMJ>22.36</FFTJZMJ>");
		strXML.append("			<FGYFS>单独所有</FGYFS>");
		strXML.append("			<FQLLX>国有建设用地使用权</FQLLX>");
		strXML.append("			<FQLXZ>出让</FQLXZ>");
		strXML.append("			<FGHYT>住宅</FGHYT>");
		strXML.append("			<FFWXZ>市场化商品房</FFWXZ>");
		strXML.append("			<FHH></FHH>");
		strXML.append("			<FSZC>19</FSZC>");
		strXML.append("			<FZCS>32</FZCS>");
		strXML.append("		</FDCQ>");
		strXML.append("	</FDCQINFO>");
		strXML.append("	<SQRINFO>");
		strXML.append("		<SQR>");
		strXML.append("			<FSQRLX>房地产权利人</FSQRLX>");
		strXML.append("			<FSQRMC>张芬芬</FSQRMC>");
		strXML.append("			<FXB>女性</FXB>");
		strXML.append("			<FZJZL>身份证</FZJZL>");
		strXML.append("			<FZJHM>43333333333333333333</FZJHM>");
		strXML.append("			<FLXR></FLXR>");
		strXML.append("			<FLXDH>43234234</FLXDH>");
		strXML.append("			<FDWXZ>个人</FDWXZ>");
		strXML.append("			<FGYQK>共同共有</FGYQK>");
		strXML.append("			<FDLRDH></FDLRDH>");
		strXML.append("			<FDLRMC></FDLRMC>");
		strXML.append("		</SQR>");
		strXML.append("		<SQR>");
		strXML.append("			<FSQRLX>房地产权利人</FSQRLX>");
		strXML.append("			<FSQRMC>张贵</FSQRMC>");
		strXML.append("			<FXB>男性</FXB>");
		strXML.append("			<FZJZL>身份证</FZJZL>");
		strXML.append("			<FZJHM>88888888888888</FZJHM>");
		strXML.append("			<FLXR></FLXR>");
		strXML.append("			<FLXDH>0000000000</FLXDH>");
		strXML.append("			<FDWXZ>个人</FDWXZ>");
		strXML.append("			<FGYQK>共同共有</FGYQK>");
		strXML.append("			<FDLRDH></FDLRDH>");
		strXML.append("			<FDLRMC></FDLRMC>");
		strXML.append("		</SQR>		");
		strXML.append("		<SQR>");
		strXML.append("			<FSQRLX>权利转让人</FSQRLX>");
		strXML.append("			<FSQRMC>姚系穷</FSQRMC>");
		strXML.append("			<FXB></FXB>");
		strXML.append("			<FZJZL>身份证</FZJZL>");
		strXML.append("			<FZJHM>111111111111111</FZJHM>");
		strXML.append("			<FLXR>姚德昌</FLXR>");
		strXML.append("			<FLXDH>22222222222</FLXDH>");
		strXML.append("			<FDWXZ>个人</FDWXZ>");
		strXML.append("			<FGYQK>单独所有</FGYQK>");
		strXML.append("			<FDLRDH>130999999</FDLRDH>");
		strXML.append("			<FDLRMC>姚德昌</FDLRMC>");
		strXML.append("		</SQR>");
		strXML.append("	</SQRINFO>");
		strXML.append("</INFO>");
		SAXReader saxReader = new SAXReader();
		Document document;
		try {
			document = saxReader.read(new ByteArrayInputStream(strXML.toString().getBytes("utf-8")));
			Element rootElement = document.getRootElement();

			Iterator<Element> sqr = rootElement.element("SQRINFO").elementIterator();

			while (sqr.hasNext()){
				Element rowElement = sqr.next();
				System.out.println(rowElement.asXML());
				if("权利转让人".equals(rowElement.elementTextTrim("FSQRLX"))){
					strZRFMC = strZRFMC + rowElement.elementTextTrim("FSQRMC")+sign;
					strZRFSFID = strZRFSFID + rowElement.elementTextTrim("FZJHM")+sign;
					strZRFSFLX = strZRFSFLX + rowElement.elementTextTrim("FZJZL")+sign;
					strZRFTEL = strZRFTEL + rowElement.elementTextTrim("FLXDH")+sign;			
				}
				if("房地产权利人".equals(rowElement.elementTextTrim("FSQRLX"))){
					strCSFMC = strCSFMC + rowElement.elementTextTrim("FSQRMC")+sign;
					strCSFSFID = strCSFSFID + rowElement.elementTextTrim("FZJHM")+sign;
					strCSFSFLX = strCSFSFLX + rowElement.elementTextTrim("FZJZL")+sign;
					strCSFTEL = strCSFTEL + rowElement.elementTextTrim("FLXDH")+sign;		
				}				
			}
			
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String aa= null;
		aa = aa + "bbbbbbbbb";
		
		System.out.println(aa);
		
	}

}
