/**
 * Exception.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.7.8  Built on : May 19, 2018 (07:06:11 BST)
 */
package pub.webservice.impl;

public class Exception extends java.lang.Exception {
	private static final long serialVersionUID = 1542591729393L;
	private pub.webservice.impl.FdcqServiceImplServiceStub.ExceptionE faultMessage;

	public Exception() {
		super("Exception");
	}

	public Exception(java.lang.String s) {
		super(s);
	}

	public Exception(java.lang.String s, java.lang.Throwable ex) {
		super(s, ex);
	}

	public Exception(java.lang.Throwable cause) {
		super(cause);
	}

	public void setFaultMessage(pub.webservice.impl.FdcqServiceImplServiceStub.ExceptionE msg) {
		faultMessage = msg;
	}

	public pub.webservice.impl.FdcqServiceImplServiceStub.ExceptionE getFaultMessage() {
		return faultMessage;
	}
}
