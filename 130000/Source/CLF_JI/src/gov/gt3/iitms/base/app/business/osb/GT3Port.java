/**
 * 
 */
package gov.gt3.iitms.base.app.business.osb;

import java.rmi.RemoteException;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gov.gt3.iitms.base.app.business.osb.GsWebserviceStub;
import gov.gt3.iitms.base.app.business.osb.GsWebserviceStub.Service;

/**
 * 
 * 金三个税WebService接口
 * 
 * @author Amani
 *
 */
public class GT3Port {

//	private static Logger logger = Logger.getLogger(GT3Port.class);  
	private static Logger logger = LogManager.getLogger(GT3Port.class.getName());
	public String web(String xml, String ws_url) throws RemoteException {
		String sResultXml="";
		GsWebserviceStub gt3Service = null;

		try {
			logger.info("个税请求报文："+xml);
			gt3Service = new GsWebserviceStub(ws_url);
			Service ser = new Service();
			ser.setIn0(xml);
			sResultXml = gt3Service.service(ser).getOut();
		} catch (AxisFault e) {
			e.printStackTrace();
			logger.error("【报错】"+e.getMessage());
			throw e;
		} catch (RemoteException e) {
			e.printStackTrace();
			logger.error("【报错】"+e.getMessage());
			throw e;
		}
		logger.info("个税返回报文："+sResultXml);
		return sResultXml;
	}

	/**
	 * 【测试方法】
	 * 用ducument方式应用现对繁琐而灵活。现在用的比较多。因为真正摆脱了我们不想要的耦合
	 * @param xml
	 * @param ws_url
	 * @return
	 * @throws Exception
	 */
	public String web22(String xml, String ws_url) throws Exception {
		try {
			Options options = new Options();
			// 指定调用WebService的URL
			EndpointReference targetEPR = new EndpointReference(ws_url);
			options.setTo(targetEPR);
			// options.setAction("urn:getPrice");
			ServiceClient sender = new ServiceClient();
			sender.setOptions(options);
			OMFactory fac = OMAbstractFactory.getOMFactory();
			String tns = "http://osb.business.app.base.iitms.gt3.gov";
			// 命名空间，有时命名空间不增加没事，不过最好加上，因为有时有事，你懂的
			OMNamespace omNs = fac.createOMNamespace(tns, "");
			OMElement method = fac.createOMElement("service", omNs);
			OMElement symbol = fac.createOMElement("symbol", omNs);
			// symbol.setText("1");
			symbol.addChild(fac.createOMText(symbol, "Axis2 Echo String "));
			method.addChild(symbol);
			method.build();
			OMElement result = sender.sendReceive(method);
			System.out.println(result);
		} catch (AxisFault e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
