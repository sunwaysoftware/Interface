package com.sunway.vo;

import java.io.Serializable;

public class Pssd implements Serializable {
	
	private static final long serialVersionUID = -3028861759956302650L;
	private String pssds;
	private String url;
	private String szqy;
	private String currentPssd;
	private String rootId;
	
	/**
	 * 
	 */
	public Pssd() {
	}

	/**
	 * @return the pssds
	 */
	public String getPssds() {
		return pssds;
	}

	/**
	 * @param pssd the pssds to set
	 */
	public void setPssds(String pssds) {
		this.pssds = pssds;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the szqy
	 */
	public String getSzqy() {
		return szqy;
	}

	/**
	 * @param szqy the szqy to set
	 */
	public void setSzqy(String szqy) {
		this.szqy = szqy;
	}

	/**
	 * @return the currentPssd
	 */
	public String getCurrentPssd() {
		return currentPssd;
	}

	/**
	 * @param currentPssd the currentPssd to set
	 */
	public void setCurrentPssd(String currentPssd) {
		this.currentPssd = currentPssd;
	}

	/**
	 * @param rootId the rootId to set
	 */
	public void setRootId(String rootId) {
		this.rootId = rootId;
	}

	/**
	 * @return the rootId
	 */
	public String getRootId() {
		return rootId;
	}
	
}
