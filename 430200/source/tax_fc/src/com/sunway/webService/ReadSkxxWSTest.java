/**
 * 
 */
package com.sunway.webService;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Administrator
 *
 */
public class ReadSkxxWSTest {

	/**
	 * Test method for {@link com.sunway.webService.ReadSkxxWS#returnPsData(java.lang.String)}.
	 */
	@Test
	public final void testReturnPsData() {
		
		ReadSkxxWS ws = new ReadSkxxWS();
		
		StringBuffer strXML = new StringBuffer();
		strXML.append("<?xml version='1.0' encoding='UTF-8'?>");
		strXML.append("<FCPG Name='GetSKXX'>");
		strXML.append(" <DATA>");
		//strXML.append("  <FCSLH>000001</FCSLH>");
		//strXML.append("  <FCID>00001</FCID>");
		strXML.append(" </DATA>");
		strXML.append("</FCPG>");
		ws.returnPsData(strXML.toString());
		
		fail("Not yet implemented"); // TODO
	}

}
