/**
 * 
 */
package cn.gov.chinatax.www.spec;

/**
 * 
 * 金三个税WebService接口
 * @author Amani
 *
 */
public class GT3Port {

	
	public String web(String xml, String ws_url)  {
		String sResultXml = null;
//		Gt3AipWebServiceStub gt3Service = null;
//		
//		try {
//			gt3Service = new Gt3AipWebServiceStub(ws_url);
//			Service ser = new Service();
//			ser.setService(xml);
//			sResultXml = gt3Service.sendBaseXMLEsbWebService(ser).getService();
//		} catch (AxisFault e) {
//			throw e;
//		} catch (RemoteException e) {
//			sResultXml = "";
//			throw e;
//		}
		return sResultXml;
	}
	
}
