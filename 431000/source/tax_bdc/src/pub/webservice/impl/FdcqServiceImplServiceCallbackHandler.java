/**
 * FdcqServiceImplServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.8  Built on : May 19, 2018 (07:06:11 BST)
 */
package pub.webservice.impl;

/**
 * FdcqServiceImplServiceCallbackHandler Callback class, Users can extend this
 * class and implement their own receiveResult and receiveError methods.
 */
public abstract class FdcqServiceImplServiceCallbackHandler {
	protected Object clientData;

	/**
	 * User can pass in any object that needs to be accessed once the NonBlocking
	 * Web service call is finished and appropriate method of this CallBack is
	 * called.
	 * 
	 * @param clientData Object mechanism by which the user can pass in user data
	 *                   that will be avilable at the time this callback is called.
	 */
	public FdcqServiceImplServiceCallbackHandler(Object clientData) {
		this.clientData = clientData;
	}

	/**
	 * Please use this constructor if you don't want to set any clientData
	 */
	public FdcqServiceImplServiceCallbackHandler() {
		this.clientData = null;
	}

	/**
	 * Get the client data
	 */
	public Object getClientData() {
		return clientData;
	}

	/**
	 * auto generated Axis2 call back method for getFdcqByCard method override this
	 * method for handling normal response from getFdcqByCard operation
	 */
	public void receiveResultgetFdcqByCard(
			pub.webservice.impl.FdcqServiceImplServiceStub.GetFdcqByCardResponseE result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling error
	 * response from getFdcqByCard operation
	 */
	public void receiveErrorgetFdcqByCard(java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for returnWsxx method override this
	 * method for handling normal response from returnWsxx operation
	 */
	public void receiveResultreturnWsxx(pub.webservice.impl.FdcqServiceImplServiceStub.ReturnWsxxResponseE result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling error
	 * response from returnWsxx operation
	 */
	public void receiveErrorreturnWsxx(java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for getFdcqByYwh method override this
	 * method for handling normal response from getFdcqByYwh operation
	 */
	public void receiveResultgetFdcqByYwh(pub.webservice.impl.FdcqServiceImplServiceStub.GetFdcqByYwhResponseE result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling error
	 * response from getFdcqByYwh operation
	 */
	public void receiveErrorgetFdcqByYwh(java.lang.Exception e) {
	}
}
