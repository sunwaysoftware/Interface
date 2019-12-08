/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ITj00001Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.BFV00006;

/**
 * 
 * 统计：征收单位
 * @author Amani
 *
 */
public class Tj00001Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 5342944235439232837L;
	private ITj00001Service tj00001Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private ArrayList<BFV00006> tabList;
	private String txtRdsjBgn;
	private String txtRdsjEnd;
	
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionCtrl.appSession = session;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		txtRdsjBgn = Common.getCurrentDate();
		txtRdsjEnd = txtRdsjBgn;
		return SUCCESS;
	}

	/**
	 * 查询统计
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		BFV00006 bean = new BFV00006();
		bean.setRdsjBgn(Common.convertToDate(txtRdsjBgn));
		bean.setRdsjEnd(Common.convertToDate(txtRdsjEnd));
		bean.setCd00002Czr(sessionCtrl.getUserId());
		bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		try {
			tabList = tj00001Service.LoadAll(bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 导出数据
	 * @return
	 * @throws Exception
	 */
	public String ExportData() throws Exception {
		BFV00006 bean = new BFV00006();
		bean.setCd00002Czr(sessionCtrl.getUserId());
		bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		try {
			tabList = tj00001Service.ExportData(bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}
	
	//----------------------- set and get --------------------------------------
	
	/**
	 * @return the tj00001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ITj00001Service getTj00001Service() {
		return tj00001Service;
	}

	/**
	 * @param tj00001Service the tj00001Service to set
	 */
	public void setTj00001Service(ITj00001Service tj00001Service) {
		this.tj00001Service = tj00001Service;
	}

	/**
	 * @return the txtRdsjBgn
	 */
	public String getTxtRdsjBgn() {
		return txtRdsjBgn;
	}

	/**
	 * @param txtRdsjBgn the txtRdsjBgn to set
	 */
	public void setTxtRdsjBgn(String txtRdsjBgn) {
		this.txtRdsjBgn = txtRdsjBgn;
	}

	/**
	 * @return the txtRdsjEnd
	 */
	public String getTxtRdsjEnd() {
		return txtRdsjEnd;
	}

	/**
	 * @param txtRdsjEnd the txtRdsjEnd to set
	 */
	public void setTxtRdsjEnd(String txtRdsjEnd) {
		this.txtRdsjEnd = txtRdsjEnd;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<BFV00006> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<BFV00006> tabList) {
		this.tabList = tabList;
	}

}
