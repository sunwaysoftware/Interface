/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02031Service;
import com.sunway.service.IPgt02031aService;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02031;
import com.sunway.vo.Pgt02031a;
import com.sunway.vo.Pgv02031;

/**
 * 
 * 收益法评税结果
 * @author Andy.Gao
 *
 */
public class Pgt02031Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1880316493776584411L;
	private IPgt02031Service t02031Service;
	private IPgt02031aService t02031aService;
	private ArrayList<Pgt02031a> qtxzList;
	private ArrayList<Pgv02031> tabList;
	private Pgt02031 t02031Bean;
	private String txtMXID;
	private String ACT;
	private String txtSWID;
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		
		Pgt02031 bean = new Pgt02031();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCd12004Mxid(txtMXID);
			bean.setCd00002Pssdy(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t02031Bean = t02031Service.LoadByPrimaryKey(bean);
			// 讀取[成本法评税其它修正参数表]
			qtxzList = t02031aService.LoadAll(new Pgt02031a(bean.getCd00002Pssdy(), bean.getCd12004Mxid()));
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			LOG.error("execute()", e);
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

	public String show() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 根據納稅人編碼讀取評估結果列表
	 * @return
	 * @throws Exception
	 */
	public String queryBySwid() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryBySwid() ********** start **********");
		}
		
		Pgv02031 v02031 = new Pgv02031();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v02031.setPageIndex(pageIndex);
			v02031.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v02031.setCd12001Swid(Common.convertEncoding(txtSWID));
			v02031.setCd00002Pssdy(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			tabList = t02031Service.LoadBySwid(v02031);
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error("queryBySwid()", e);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryBySwid() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t02031Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02031Service getT02031Service() {
		return t02031Service;
	}

	/**
	 * @param t02031Service the t02031Service to set
	 */
	public void setT02031Service(IPgt02031Service t02031Service) {
		this.t02031Service = t02031Service;
	}

	/**
	 * @return the t02031aService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02031aService getT02031aService() {
		return t02031aService;
	}

	/**
	 * @param t02031aService the t02031aService to set
	 */
	public void setT02031aService(IPgt02031aService t02031aService) {
		this.t02031aService = t02031aService;
	}

	/**
	 * @return the qtxzList
	 */
	public ArrayList<Pgt02031a> getQtxzList() {
		return qtxzList;
	}

	/**
	 * @param qtxzList the qtxzList to set
	 */
	public void setQtxzList(ArrayList<Pgt02031a> qtxzList) {
		this.qtxzList = qtxzList;
	}

	/**
	 * @return the t02031Bean
	 */
	public Pgt02031 getT02031Bean() {
		return t02031Bean;
	}

	/**
	 * @param t02031Bean the t02031Bean to set
	 */
	public void setT02031Bean(Pgt02031 t02031Bean) {
		this.t02031Bean = t02031Bean;
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

	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the txtSWID
	 */
	public String getTxtSWID() {
		return txtSWID;
	}

	/**
	 * @param txtSWID the txtSWID to set
	 */
	public void setTxtSWID(String txtSWID) {
		this.txtSWID = txtSWID;
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
	public ArrayList<Pgv02031> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv02031> tabList) {
		this.tabList = tabList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
