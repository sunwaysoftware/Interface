/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt10031Service;
import com.sunway.service.IPgt10031aService;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt10031;
import com.sunway.vo.Pgv10031;
import com.sunway.vo.Pgv10031a1;

/**
 * 
 * 成本法评税结果
 * @author Andy.Gao
 *
 */
public class Pgt10031Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -2050075540496032099L;
	private IPgt10031Service t10031Service;
	private IPgt10031aService t10031aService;
	private ArrayList<Pgv10031a1> dcQtxzList;
	private ArrayList<Pgv10031a1> fcQtxzList;
	private ArrayList<Pgv10031> tabList;
	private Pgt10031 t10031Bean;
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
		
		Pgt10031 bean = new Pgt10031();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCd12004Mxid(txtMXID);
			bean.setCd00002Pssdy(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t10031Bean = t10031Service.LoadByPrimaryKey(bean);
			// 讀取[成本法评税其它修正参数表]
			dcQtxzList = t10031aService.LoadQtxzDC(new Pgv10031a1(bean.getCd12004Mxid(), bean.getCd00002Pssdy()));
			fcQtxzList = t10031aService.LoadQtxzFC(new Pgv10031a1(bean.getCd12004Mxid(), bean.getCd00002Pssdy()));
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
		txtSWID = Common.convertEncoding(txtSWID);
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
		
		Pgv10031 v10031 = new Pgv10031();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v10031.setPageIndex(pageIndex);
			v10031.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v10031.setCd12001Swid(Common.convertEncoding(txtSWID));
			v10031.setCd00002Pssdy(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			tabList = t10031Service.LoadBySwid(v10031);
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
	 * @param t10031Service the t10031Service to set
	 */
	public void setT10031Service(IPgt10031Service t10031Service) {
		this.t10031Service = t10031Service;
	}

	/**
	 * @return the t10031Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt10031Service getT10031Service() {
		return t10031Service;
	}

	/**
	 * @param t10031aService the t10031aService to set
	 */
	public void setT10031aService(IPgt10031aService t10031aService) {
		this.t10031aService = t10031aService;
	}

	/**
	 * @return the t10031aService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt10031aService getT10031aService() {
		return t10031aService;
	}
	
	/**
	 * @param t10031Bean the t10031Bean to set
	 */
	public void setT10031Bean(Pgt10031 t10031Bean) {
		this.t10031Bean = t10031Bean;
	}

	/**
	 * @return the t10031Bean
	 */
	public Pgt10031 getT10031Bean() {
		return t10031Bean;
	}

	/**
	 * @param txtMXID the txtMXID to set
	 */
	public void setTxtMXID(String txtMXID) {
		this.txtMXID = txtMXID;
	}

	/**
	 * @return the txtMXID
	 */
	public String getTxtMXID() {
		return txtMXID;
	}

	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @return the dcQtxzList
	 */
	public ArrayList<Pgv10031a1> getDcQtxzList() {
		return dcQtxzList;
	}

	/**
	 * @param dcQtxzList the dcQtxzList to set
	 */
	public void setDcQtxzList(ArrayList<Pgv10031a1> dcQtxzList) {
		this.dcQtxzList = dcQtxzList;
	}

	/**
	 * @return the fcQtxzList
	 */
	public ArrayList<Pgv10031a1> getFcQtxzList() {
		return fcQtxzList;
	}

	/**
	 * @param fcQtxzList the fcQtxzList to set
	 */
	public void setFcQtxzList(ArrayList<Pgv10031a1> fcQtxzList) {
		this.fcQtxzList = fcQtxzList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv10031> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv10031> getTabList() {
		return tabList;
	}

	/**
	 * @param txtSWID the txtSWID to set
	 */
	public void setTxtSWID(String txtSWID) {
		this.txtSWID = txtSWID;
	}

	/**
	 * @return the txtSWID
	 */
	public String getTxtSWID() {
		return txtSWID;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
