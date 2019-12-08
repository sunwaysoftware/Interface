/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12084Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12084;

/**
 * 
 * 成本，收益审核和评税未过原因说明
 * @author Andy.Gao
 *
 */
public class Pgt12084Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -3285741838567512721L;
	private IPgt12084Service t12084Service;
	private ArrayList<Pgv12084> tabList;
	private String mxId;
	private String type;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		
		Pgv12084 bean = new Pgv12084();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCd12004Mxid(mxId);
			bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bean.setShlx(Common.convertToInteger(type));
			tabList = t12084Service.LoadAll(bean);
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

	/*********************** set and get ******************************/
	
	/**
	 * @param t12084Service the t12084Service to set
	 */
	public void setT12084Service(IPgt12084Service t12084Service) {
		this.t12084Service = t12084Service;
	}

	/**
	 * @return the t12084Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12084Service getT12084Service() {
		return t12084Service;
	}


	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12084> tabList) {
		this.tabList = tabList;
	}


	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv12084> getTabList() {
		return tabList;
	}


	/**
	 * @param mxId the mxId to set
	 */
	public void setMxId(String mxId) {
		this.mxId = mxId;
	}


	/**
	 * @return the mxId
	 */
	public String getMxId() {
		return mxId;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
