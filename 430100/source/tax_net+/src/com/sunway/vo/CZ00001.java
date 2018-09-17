/**
 * 
 */
package com.sunway.vo;

/**
 * @author Andy.Gao
 *
 */

public class CZ00001 implements java.io.Serializable {

	private static final long serialVersionUID = 6142135439438895011L;
	private String logType;
	private String logTypeName;

	/**
	 * @param logType
	 * @param logTypeName
	 */
	public CZ00001(String logType, String logTypeName) {
		this.logType = logType;
		this.logTypeName = logTypeName;
	}

	/**
	 * @return the logType
	 */
	public String getLogType() {
		return logType;
	}
	
	/**
	 * @param logType the logType to set
	 */
	public void setLogType(String logType) {
		this.logType = logType;
	}
	
	/**
	 * @return the logTypeName
	 */
	public String getLogTypeName() {
		return logTypeName;
	}
	
	/**
	 * @param logTypeName the logTypeName to set
	 */
	public void setLogTypeName(String logTypeName) {
		this.logTypeName = logTypeName;
	}
	
}
