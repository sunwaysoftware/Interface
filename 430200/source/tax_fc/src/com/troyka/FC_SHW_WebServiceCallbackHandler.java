/**
 * FC_SHW_WebServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package com.troyka;

/**
 * FC_SHW_WebServiceCallbackHandler Callback class, Users can extend this class
 * and implement their own receiveResult and receiveError methods.
 */
public abstract class FC_SHW_WebServiceCallbackHandler {

	protected Object clientData;

	/**
	 * User can pass in any object that needs to be accessed once the
	 * NonBlocking Web service call is finished and appropriate method of this
	 * CallBack is called.
	 * 
	 * @param clientData
	 *            Object mechanism by which the user can pass in user data that
	 *            will be avilable at the time this callback is called.
	 */
	public FC_SHW_WebServiceCallbackHandler(Object clientData) {
		this.clientData = clientData;
	}

	/**
	 * Please use this constructor if you don't want to set any clientData
	 */
	public FC_SHW_WebServiceCallbackHandler() {
		this.clientData = null;
	}

	/**
	 * Get the client data
	 */

	public Object getClientData() {
		return clientData;
	}

	/**
	 * auto generated Axis2 call back method for helloWorld method override this
	 * method for handling normal response from helloWorld operation
	 */
	public void receiveResulthelloWorld(
			com.troyka.FC_SHW_WebServiceStub.HelloWorldResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling
	 * error response from helloWorld operation
	 */
	public void receiveErrorhelloWorld(java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for setSKXX method override this
	 * method for handling normal response from setSKXX operation
	 */
	public void receiveResultsetSKXX(
			com.troyka.FC_SHW_WebServiceStub.SetSKXXResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling
	 * error response from setSKXX operation
	 */
	public void receiveErrorsetSKXX(java.lang.Exception e) {
	}

	/**
	 * auto generated Axis2 call back method for getFCXX method override this
	 * method for handling normal response from getFCXX operation
	 */
	public void receiveResultgetFCXX(
			com.troyka.FC_SHW_WebServiceStub.GetFCXXResponse result) {
	}

	/**
	 * auto generated Axis2 Error handler override this method for handling
	 * error response from getFCXX operation
	 */
	public void receiveErrorgetFCXX(java.lang.Exception e) {
	}

}
