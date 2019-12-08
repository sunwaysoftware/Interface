/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12002cService;
import com.sunway.util.Common;
import com.sunway.vo.Pgv12002c;

/**
 * 
 * 土地当前承租人历史表
 * @author Andy.Gao
 *
 */
public class Pgt12002cAction extends ActionSupport {

	private static final long serialVersionUID = 8662730778162153002L;
	private IPgt12002cService t12002cService;
	private ArrayList<Pgv12002c> tabList;
	private String txtDCID;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		Pgv12002c v12002c = new Pgv12002c();
		try {
			v12002c.setCd12002Dcid(Common.convertEncoding(txtDCID));
			tabList = t12002cService.LoadAll(v12002c);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** set and get ******************************/
	
	/**
	 * @param t12002cService the t12002cService to set
	 */
	public void setT12002cService(IPgt12002cService t12002cService) {
		this.t12002cService = t12002cService;
	}

	/**
	 * @return the t12002cService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12002cService getT12002cService() {
		return t12002cService;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12002c> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv12002c> getTabList() {
		return tabList;
	}

	/**
	 * @return the txtDCID
	 */
	public String getTxtDCID() {
		return txtDCID;
	}

	/**
	 * @param txtDCID the txtDCID to set
	 */
	public void setTxtDCID(String txtDCID) {
		this.txtDCID = txtDCID;
	}
}