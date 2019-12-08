/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12004cService;
import com.sunway.util.Common;
import com.sunway.vo.Pgv12004c;

/**
 * 
 * 房產明細当前承租人历史表
 * @author Andy.Gao
 *
 */
public class Pgt12004cAction extends ActionSupport {

	private static final long serialVersionUID = -8862095794501907820L;
	private IPgt12004cService t12004cService;
	private ArrayList<Pgv12004c> tabList;
	private String txtMXID;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		Pgv12004c v12004c = new Pgv12004c();
		try {
			v12004c.setCd12004Mxid(Common.convertEncoding(txtMXID));
			setTabList(t12004cService.LoadAll(v12004c));
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
	 * @return the t12004cService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12004cService getT12004cService() {
		return t12004cService;
	}

	/**
	 * @param t12004cService the t12004cService to set
	 */
	public void setT12004cService(IPgt12004cService t12004cService) {
		this.t12004cService = t12004cService;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12004c> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv12004c> getTabList() {
		return tabList;
	}

	/**
	 * @return the txtMXID
	 */
	public String getTxtMXID() {
		return txtMXID;
	}

	/**
	 * @param txtMXID the txtMXID to set
	 */
	public void setTxtMXID(String txtMXID) {
		this.txtMXID = txtMXID;
	}
}
