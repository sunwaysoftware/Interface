/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00384Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00384;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00384Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1197509168773300853L;

	private IPgt00384Service t00384Service;
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv00384> tabList;
	private String fcId;
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	private String type;
	private String ddlSZQY;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		
		Pgv00384 bean = new Pgv00384();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCd00302Fcid(fcId);
			bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bean.setShlx(Common.convertToInteger(type));
			tabList = getT00384Service().LoadAll(bean);		
			
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

	/**
	 * 转向待办原因
	 * @return
	 * @throws Exception
	 */
	public String executeYY() throws Exception {
		ReadInfo();
		return SUCCESS;
	}
	
	/**
	 * 读取待办原因
	 * @return
	 * @throws Exception
	 */
	public String loadYY() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("loadYY() ********** start **********");
		}
		
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			Pgv00384 bean = new Pgv00384();
			bean.setCd00001Szqy(ddlSZQY);
			bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			tabList = getT00384Service().LoadYY(bean);			
		} catch (Exception e) {
			LOG.error("loadYY()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("loadYY() ********** end **********");
			}			
			return INPUT;
		}		

		if (LOG.isDebugEnabled()) {
			LOG.debug("loadYY() ********** end **********");
		}
		return SUCCESS;		
	}
	/**
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	
	/**
	 * 全面评估估价待办
	 * @return
	 * @throws Exception
	 */
	public String executeT00320()throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeT00320() ********** start **********");
		}
		
		Pgv00384 bean = new Pgv00384();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCd00302Fcid(fcId);
			bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bean.setShlx(Common.convertToInteger(type));
			tabList = getT00384Service().LoadQMPG(bean);		
			
		} catch (Exception e) {
			LOG.error("execute()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeT00320() ********** end **********");
			}			
			return INPUT;
		}		

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeT00320() ********** end **********");
		}
		return SUCCESS;
	}
	/*********************** set and get ******************************/
	
	/**
	 * @param t00384Service the t00384Service to set
	 */
	public void setT00384Service(IPgt00384Service t00384Service) {
		this.t00384Service = t00384Service;
	}

	/**
	 * @return the t00384Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00384Service getT00384Service() {
		return t00384Service;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv00384> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00384> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the fcId
	 */
	public String getFcId() {
		return fcId;
	}

	/**
	 * @param fcId the fcId to set
	 */
	public void setFcId(String fcId) {
		this.fcId = fcId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}

	public String getDdlSZQY() {
		return ddlSZQY;
	}

	/**
	 * @return the sessionCtrl
	 */
	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	/**
	 * @param sessionCtrl the sessionCtrl to set
	 */
	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getRowCount() {
		return rowCount;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
	
}
