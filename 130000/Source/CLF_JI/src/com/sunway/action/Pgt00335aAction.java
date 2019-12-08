/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00335aService;
import com.sunway.vo.Pgt00335a;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00335aAction extends ActionSupport {
	private static final long serialVersionUID = 2287752367147323153L;

	private IPgt00335aService t00335aService;
	private ArrayList<Pgt00335a> tabList;
	private String txtFCID;
	private String txtSLID;
	private String txtPSSD;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		
		try {
			tabList = t00335aService.LoadAll(new Pgt00335a(txtFCID, txtSLID, txtPSSD));
		} catch (Exception e) {
			LOG.error("execute()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}
	
	/************************** set and get *****************************/
	
	/**
	 * @return the t00335aService
	 */
	public IPgt00335aService getT00335aService() {
		return t00335aService;
	}
	/**
	 * @param t00335aService the t00335aService to set
	 */
	public void setT00335aService(IPgt00335aService t00335aService) {
		this.t00335aService = t00335aService;
	}
	/**
	 * @return the tabList
	 */
	public ArrayList<Pgt00335a> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgt00335a> tabList) {
		this.tabList = tabList;
	}
	/**
	 * @return the txtFCID
	 */
	public String getTxtFCID() {
		return txtFCID;
	}
	/**
	 * @param txtFCID the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}
	/**
	 * @return the txtSLID
	 */
	public String getTxtSLID() {
		return txtSLID;
	}
	/**
	 * @param txtSLID the txtSLID to set
	 */
	public void setTxtSLID(String txtSLID) {
		this.txtSLID = txtSLID;
	}
	/**
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}
	/**
	 * @param txtPSSD the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}	
	
}
