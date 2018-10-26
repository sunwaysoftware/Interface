/**
 * 
 */
package com.sunway.test;

import com.sunway.webService.Process;

/**
 * @author amani
 *
 */
public class MyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Process pro = new Process();
		
		// Read tax info
		String strXML = String.format("<?xml version='1.0' encoding='UTF-8'?>"
				+ "<EAIRequest>" 
				+ "<Requests>" 
				+ "<Request Name='GetFCXX'>"
				+ "<FCXX FCSLH='%s' />" 
				+ "<FCXX FCBM='%s' />" 
				+ "</Request>"
				+ "</Requests>" 
				+ "</EAIRequest>", "FC11", "");		
		pro.PgProcess(strXML);
		
//		String strXml = "<?xml version='1.0' encoding='GB2312'?>"
//				+ "<EAIRequest>"
//				+ "<Requests>"
//				+ "<Request Name='WriFCXX'>"
//				+ "<FCXX FCSLH='20181015001' />"
//				+ "<FCXX FPID='' />"
//				+ "<FCXX SPID='' />"
//				+ "<FCXX PGJG='500600.08' />"
//				+ "<FCXX QSJG='' />"
//				+ "<FCXX QTJG='' />"
//				+ "<FCXX OINSID='' />" 
//				+ "<FCXX ROOMID='G2018100815170756752' />"
//				+ "<FCXX OWNROOMID='ES-1-1538378840085-85' />" 
//				+ "<FCXX HTZJ='' />"
//				+ "<FCXX PGDJ='' />" 
//				+ "<FCXX DFSPID='' />" 
//				+ "<FCXX SSQY='' />" 
//				+ "<FCXX QS='77.77'/>"
//				+ "<FCXX YYS='66.66'/>"
//				+ "<FCXX CJS='55.55'/>"
//				+ "<FCXX DFJYS='44.44'/>"
//				+ "<FCXX GRSDS='33.33'/>"
//				+ "<FCXX YHS='22.22'/>"
//				+ "<FCXX TDZZS='11.11'/>"
//				+ "<FCXX PGID='PG123123123123123'/>"
//				+ "<FCXX BZXX=''/>"
//				+ "</Request>" 
//				+ "</Requests>"
//				+ "</EAIRequest>";		
//		
//		pro.PgProcess(strXml);
		
	}
	
	
}
