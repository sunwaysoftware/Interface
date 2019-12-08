/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00041Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00041;

/**
 * 
 * 应纳税款计算表
 * @author Andy.Gao
 *
 */
public class Pgt00041Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5140404924776547639L;
	private IPgt00041Service t00041Service;
	private ArrayList<Pgv00041> tabList;
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFCSLHFind;
	private Integer SSLX;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00041 v00041 = new Pgv00041();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00041.setCd12301Swid(Common.getSearchLike(txtSWIDFind));
			v00041.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v00041.setFcslh(txtFCSLHFind);
			v00041.setPageIndex(pageIndex);
			v00041.setPageSize(getPageSize());
			v00041.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00041.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			switch (SSLX) {
			case 1://成本
				tabList = t00041Service.LoadAllCB(v00041);
				break;
			case 2://收益
				tabList = t00041Service.LoadAllSY(v00041);
				break;
			case 3://市場
				tabList = t00041Service.LoadAllSC(v00041);
				break;
			default:
				break;
			}
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				rowCount = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error("query()", e);
			LOG.error(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}	
	
	/****************************** set and get ************************************/
	
	/**
	 * @param t00041Service the t00041Service to set
	 */
	public void setT00041Service(IPgt00041Service t00041Service) {
		this.t00041Service = t00041Service;
	}

	/**
	 * @return the t00041Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00041Service getT00041Service() {
		return t00041Service;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00041> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv00041> getTabList() {
		return tabList;
	}

	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}	

	/**
	 * @return the rowCount
	 */
	public Integer getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the txtSWIDFind
	 */
	public String getTxtSWIDFind() {
		return txtSWIDFind;
	}

	/**
	 * @param txtSWIDFind the txtSWIDFind to set
	 */
	public void setTxtSWIDFind(String txtSWIDFind) {
		this.txtSWIDFind = txtSWIDFind;
	}

	/**
	 * @return the txtNSRMCFind
	 */
	public String getTxtNSRMCFind() {
		return txtNSRMCFind;
	}

	/**
	 * @param txtNSRMCFind the txtNSRMCFind to set
	 */
	public void setTxtNSRMCFind(String txtNSRMCFind) {
		this.txtNSRMCFind = txtNSRMCFind;
	}

	/**
	 * @param sSLX the sSLX to set
	 */
	public void setSSLX(Integer sSLX) {
		SSLX = sSLX;
	}

	/**
	 * @return the sSLX
	 */
	public Integer getSSLX() {
		return SSLX;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	public String getTxtFCSLHFind() {
		return txtFCSLHFind;
	}

	public void setTxtFCSLHFind(String txtFCSLHFind) {
		this.txtFCSLHFind = txtFCSLHFind;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
