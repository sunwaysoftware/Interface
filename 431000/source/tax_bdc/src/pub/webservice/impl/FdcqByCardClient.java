/**
 * 
 */
package pub.webservice.impl;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;

import pub.webservice.impl.FdcqServiceImplServiceStub.GetFdcqByCard;
import pub.webservice.impl.FdcqServiceImplServiceStub.GetFdcqByCardE;
import pub.webservice.impl.FdcqServiceImplServiceStub.GetFdcqByCardResponseE;

/**
 * 
 * 调用国土接口
 * @author amani
 *
 */
public class FdcqByCardClient {
	static Logger logger = Logger.getLogger(FdcqByCardClient.class);

	public String execBdcWs(String xml) {
		String strRtn = null;
		GetFdcqByCardResponseE fdcqByCardResponseE = null;
		FdcqServiceImplServiceStub bdcWsStub = null;
		
		logger.info("正在调用国土接口【GetFdcqByCard】获取信息...");
		GetFdcqByCardE fdcqByCardE = new GetFdcqByCardE();
		GetFdcqByCard fdcqByCard = new GetFdcqByCard();
		try {
			bdcWsStub = new FdcqServiceImplServiceStub();
			fdcqByCard.setArg0(xml);
			fdcqByCardE.setGetFdcqByCard(fdcqByCard);
			// 增加此句，屏蔽SOAP_ACTION
			bdcWsStub._getServiceClient().getOptions().setProperty(org.apache.axis2.Constants.Configuration.DISABLE_SOAP_ACTION, true);
			fdcqByCardResponseE = bdcWsStub.getFdcqByCard(fdcqByCardE);
			strRtn = fdcqByCardResponseE.getGetFdcqByCardResponse().get_return();
		} catch (AxisFault e) {
			logger.error("调用国土接口过程中报错\n", e);
		} catch (RemoteException e) {
			logger.error("调用国土接口过程中报错\n", e);
		} catch (pub.webservice.impl.Exception e) {
			logger.error("调用国土接口过程中报错\n", e);
		}
		return strRtn;
	}
	
}
