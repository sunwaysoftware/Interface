package com.sunway.webservice;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebXml {
	static Logger logger = LogManager.getLogger(WebXml.class);
	
	// 使用RPC方式调用WebService
	public String web(String xml, String wsURL) throws AxisFault {

		// 使用RPC方式调用WebService
		RPCServiceClient serviceClient = null;
		try {
			serviceClient = new RPCServiceClient();
		} catch (AxisFault e) {
			logger.error(e);
			throw new AxisFault("创建RPC Service Client对象失败", e);
		}
		Options options = serviceClient.getOptions();
		// 指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference(wsURL);
		options.setAction("urn:PgProcess");
		options.setTo(targetEPR);

		// 指定getGreeting方法的参数值
		Object[] opAddEntryArgs = new Object[] { xml };
		// 指定getGreeting方法返回值的数据类型的Class对象
		Class[] classes = new Class[] { String.class };
		// 指定要调用的getGreeting方法及WSDL文件的命名空间
		QName opAddEntry = new QName("http://webService.sunway.com", "PgProcess");
		// 调用getGreeting方法并输出该方法的返回值
		try {
			xml = (String) (serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classes)[0]);
		} catch (AxisFault e) {
			logger.error(e);
			xml = "";
			throw e;
		} finally {
			targetEPR = null;
			opAddEntryArgs = null;
			classes = null;
		}
		return xml;
	}
}
