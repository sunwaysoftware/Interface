/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.impl.Pg10001gService;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv10031;

/**
 * 
 * 个案评税[成本法]
 * @author Andy.Gao
 * @category 个案评税
 *
 */
public class Pg10001gAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -5903121730897785189L;
	private Pg10001gService g10001Service;
	
	// VIEW
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	private ArrayList<Pgv10031> tabList;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtMXIDFind;
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

		Pgv10031 v10031 = new Pgv10031();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v10031.setCd12001Swid(Common.getSearchLike(txtSWIDFind));
			v10031.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v10031.setCd12004Mxid(Common.trim(txtMXIDFind));
			v10031.setPageIndex(pageIndex);
			v10031.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v10031.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v10031.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = g10001Service.LoadPgMx(v10031);
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
				pageIndex = 1;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
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
	
	/*********************** set and get ******************************/
	
	/**
	 * @param g10001Service the g10001Service to set
	 */
	public void setG10001Service(Pg10001gService g10001Service) {
		this.g10001Service = g10001Service;
	}
	
	/**
	 * @return the g10001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public Pg10001gService getG10001Service() {
		return g10001Service;
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
	 * @return the pageCount
	 */
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
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
	public ArrayList<Pgv10031> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv10031> tabList) {
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
	 * @return the txtMXIDFind
	 */
	public String getTxtMXIDFind() {
		return txtMXIDFind;
	}

	/**
	 * @param txtMXIDFind the txtMXIDFind to set
	 */
	public void setTxtMXIDFind(String txtMXIDFind) {
		this.txtMXIDFind = txtMXIDFind;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
}
