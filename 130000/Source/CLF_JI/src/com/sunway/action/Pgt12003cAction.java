/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12003cService;
import com.sunway.util.Common;
import com.sunway.vo.Pgv12003c;

/**
 * 
 * 房產当前承租人历史表
 * @author Andy.Gao
 *
 */
public class Pgt12003cAction extends ActionSupport {

	private static final long serialVersionUID = 6059777551075732640L;
	private IPgt12003cService t12003cService;
	private ArrayList<Pgv12003c> tabList;
	private String txtFCID;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		Pgv12003c v12003c = new Pgv12003c();
		try {
			v12003c.setCd12003Fcid(Common.convertEncoding(txtFCID));
			tabList = t12003cService.LoadAll(v12003c);
		} catch (Exception e) {
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
	
	/*********************** set and get ******************************/
	
	/**
	 * @param t12003cService the t12003cService to set
	 */
	public void setT12003cService(IPgt12003cService t12003cService) {
		this.t12003cService = t12003cService;
	}
	
	/**
	 * @return the t12003cService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12003cService getT12003cService() {
		return t12003cService;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12003c> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv12003c> getTabList() {
		return tabList;
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
}
