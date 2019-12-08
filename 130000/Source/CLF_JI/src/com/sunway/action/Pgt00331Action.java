/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00331Service;
import com.sunway.service.IPgt00334Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00331;
import com.sunway.vo.Pgt00334;
import com.sunway.vo.Pgv00331;

/**
 * 
 * 市场法评税结果
 * @author Andy.Gao
 *
 */
public class Pgt00331Action extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 1764886415133561190L;
	private IPgt00331Service t00331Service;
	private IPgt00334Service t00334Service;
	private ArrayList<Pgt00334> pgslList;
	private ArrayList<Pgv00331> tabList;
	private Pgt00331 t00331Bean;
	private String txtFCID;
	private String txtSWID;
	private Integer pageIndex;
	private Integer pageSize;
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
		
		Pgt00331 bean = new Pgt00331();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCd00302Fcid(txtFCID);
			bean.setCd00002Pssdy(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t00331Bean = t00331Service.LoadByPrimaryKey(bean);
			// 讀取[市场法参与评税的实例库]
			pgslList = t00334Service.LoadAll(new Pgt00334(bean.getCd00302Fcid(), bean.getCd00002Pssdy()));
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
		
		Pgv00331 v00331 = new Pgv00331();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00331.setPageIndex(pageIndex);
			v00331.setPageSize(getPageSize());
			v00331.setCd00301Swid(Common.convertEncoding(txtSWID));
			v00331.setCd00002Pssdy(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			tabList = t00331Service.LoadBySwid(v00331);
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				rowCount = 0;
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
	
	/**************************** set and get *********************************/
	
	/**
	 * @return the t00331Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00331Service getT00331Service() {
		return t00331Service;
	}

	/**
	 * @param t00331Service the t00331Service to set
	 */
	public void setT00331Service(IPgt00331Service t00331Service) {
		this.t00331Service = t00331Service;
	}

	/**
	 * @return the t00334Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00334Service getT00334Service() {
		return t00334Service;
	}

	/**
	 * @param t00334Service the t00334Service to set
	 */
	public void setT00334Service(IPgt00334Service t00334Service) {
		this.t00334Service = t00334Service;
	}

	/**
	 * @return the pgslList
	 */
	public ArrayList<Pgt00334> getPgslList() {
		return pgslList;
	}

	/**
	 * @param pgslList the pgslList to set
	 */
	public void setPgslList(ArrayList<Pgt00334> pgslList) {
		this.pgslList = pgslList;
	}

	/**
	 * @return the t00331Bean
	 */
	public Pgt00331 getT00331Bean() {
		return t00331Bean;
	}

	/**
	 * @param t00331Bean the t00331Bean to set
	 */
	public void setT00331Bean(Pgt00331 t00331Bean) {
		this.t00331Bean = t00331Bean;
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

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv00331> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00331> tabList) {
		this.tabList = tabList;
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
