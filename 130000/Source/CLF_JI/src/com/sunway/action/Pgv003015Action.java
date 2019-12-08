package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00301Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00301;

/**
 * 住宅登记信息查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv003015Action extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -2351258213399712412L;
	// Service
	private IPgt00301Service t00301Service;
	// VIEW
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	private ArrayList<Pgv00301> tabList;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private Pgv00301 v00301Bean;
	private Integer ddlSCZTFind;
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
		Pgv00301 v00301 = new Pgv00301();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00301.setSwid(Common.getSearchLike(txtSWIDFind));
			v00301.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v00301.setSczt(ddlSCZTFind);
			v00301.setPageIndex(pageIndex);
			v00301.setPageSize(getPageSize());
			v00301.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00301.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			//执行查询
			v00301Bean = t00301Service.LoadPgv003015(v00301);
			tabList = v00301Bean.getV00301List();
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				rowCount = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/******************************** set and get **************************************/

	/**
	 * @return the t00301Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00301Service getT00301Service() {
		return t00301Service;
	}
	/**
	 * @param t00301Service the t00301Service to set
	 */
	public void setT00301Service(IPgt00301Service t00301Service) {
		this.t00301Service = t00301Service;
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
	 * @return the tabList
	 */
	public ArrayList<Pgv00301> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00301> tabList) {
		this.tabList = tabList;
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
	 * @return the v00301Bean
	 */
	public Pgv00301 getV00301Bean() {
		return v00301Bean;
	}
	/**
	 * @param v00301Bean the v00301Bean to set
	 */
	public void setV00301Bean(Pgv00301 v00301Bean) {
		this.v00301Bean = v00301Bean;
	}
	/**
	 * @return the ddlSCZTFind
	 */
	public Integer getDdlSCZTFind() {
		return ddlSCZTFind;
	}
	/**
	 * @param ddlSCZTFind the ddlSCZTFind to set
	 */
	public void setDdlSCZTFind(Integer ddlSCZTFind) {
		this.ddlSCZTFind = ddlSCZTFind;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
