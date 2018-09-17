/**
 * 
 */
package com.troyka;

import java.rmi.RemoteException;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;

import com.troyka.FC_SHW_WebServiceStub.GetFCXXResponse;
import com.troyka.FC_SHW_WebServiceStub.SetSKXX;
import com.troyka.FC_SHW_WebServiceStub.SetSKXXResponse;

/**
 * @author Administrator
 *
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FC_SHW_WebServiceStub fcWebService = null;
		GetFCXXResponse fcxxResponse = null;
			try {
				fcWebService = new FC_SHW_WebServiceStub();
			} catch (AxisFault e) {
				e.getMessage();
			}
			com.troyka.FC_SHW_WebServiceStub.GetFCXX getFcxx = new com.troyka.FC_SHW_WebServiceStub.GetFCXX();
			getFcxx.setFCSLH("<?xml version='1.0' encoding='UTF-8'?><FCPG Name='GetFCXX'><DATA><FCSLH>20131133108</FCSLH></DATA></FCPG>");
			try {
				fcxxResponse = fcWebService.getFCXX(getFcxx);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			OMElement fcElement = fcxxResponse.getGetFCXXResult().getExtraElement();
			System.out.println(fcElement);
			//----------------------------------------------------------
			FC_SHW_WebServiceStub fc = null;
			SetSKXXResponse skxxResponse = null;
			try {
				fc = new FC_SHW_WebServiceStub();
			} catch (AxisFault e) {
				e.getMessage();
			}
			SetSKXX skxx = new SetSKXX();
			StringBuffer strXml = new StringBuffer();
			strXml.append("<?xml version='1.0' encoding='UTF-8'?>");
			strXml.append("<FCPG Name='SetSKXX'>");
			strXml.append(" <ROW>");
			strXml.append("  <FCSLH>20091041640</FCSLH>");
			strXml.append("  <FCID>200000844640</FCID>");
			strXml.append("  <DJZ_QS>111</DJZ_QS>");
			strXml.append("  <DJZ_YYS>222</DJZ_YYS>");
			strXml.append("  <DJZ_CJS>333</DJZ_CJS>");
			strXml.append("  <DJZ_DFJYS>444</DJZ_DFJYS>");
			strXml.append("  <DJZ_GRSDS>555</DJZ_GRSDS>");
			strXml.append("  <DJZ_YHS>666</DJZ_YHS>");
			strXml.append("  <DJZ_TDZZS>777</DJZ_TDZZS>");
//			strXml.append("  <FPHM>8888</FPHM>");
//			strXml.append("  <QSSPHM>9999</QSSPHM>");
//			strXml.append("  <DFGSSPHM>1243245325</DFGSSPHM>");
			strXml.append("  <UPDATETIME>2012-04-02</UPDATETIME>");
			strXml.append("  <PGJG>500000</PGJG>");
			strXml.append("  <BZ>契税缴纳时间为：2007年10月12日，契税完税证号：（2004）湘农税电字NO0333634</BZ>");			
			strXml.append(" </ROW>");
			strXml.append("</FCPG>");
			skxx.setReqxml(strXml.toString());			
			try {
				skxxResponse = fc.setSKXX(skxx);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			System.out.println(skxxResponse.getSetSKXXResult().getExtraElement());	
	}

}
