package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12004Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12004;

/**
 * 房产明细查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv120045Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 791048539625041890L;
	// Service
	private IPgt12004Service t12004Service;
	// VIEW
	private Pgv12004 v12004Bean;
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	private ArrayList<Pgv12004> tabList;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtMXIDFind;
	private String DCID;
	private Integer ddlCBZTFind;
	private Integer ddlSYZTFind;
	private SessionCtrl sessionCtrl = new SessionCtrl();

	/*
	 * (non-Javadoc)
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

		Pgv12004 v12004 = new Pgv12004();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v12004.setPageIndex(pageIndex);
			v12004.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12004.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12004.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if (Common.isNullOrEmpty(DCID)) {
				v12004.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
				v12004.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
				v12004.setMxid(Common.convertEncoding(Common.trim(txtMXIDFind)));
				v12004.setCbzt(ddlCBZTFind);
				v12004.setSyzt(ddlSYZTFind);
			} else {
				v12004.setCd12002Dcid(Common.convertEncoding(Common.trim(DCID)));
				v12004.setCbzt(Common.convertToInteger(Constant.ZT_DEFAULT));
				v12004.setSyzt(Common.convertToInteger(Constant.ZT_DEFAULT));
			}
			//执行查询
			v12004Bean = t12004Service.LoadPgv120045(v12004);
			tabList = v12004Bean.getV12004List();
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

	/*********************** setter and getter ******************************/

	/**
	 * @return the t12004Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt12004Service getT12004Service() {
		return t12004Service;
	}
	/**
	 * @param t12004Service the t12004Service to set
	 */
	public void setT12004Service(IPgt12004Service t12004Service) {
		this.t12004Service = t12004Service;
	}
	/**
	 * @return the v12004Bean
	 */
	public Pgv12004 getV12004Bean() {
		return v12004Bean;
	}
	/**
	 * @param v12004Bean the v12004Bean to set
	 */
	public void setV12004Bean(Pgv12004 v12004Bean) {
		this.v12004Bean = v12004Bean;
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
	public ArrayList<Pgv12004> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12004> tabList) {
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
	/**
	 * @return the dCID
	 */
	public String getDCID() {
		return DCID;
	}
	/**
	 * @param dCID the dCID to set
	 */
	public void setDCID(String dCID) {
		DCID = dCID;
	}
	/**
	 * @return the ddlCBZTFind
	 */
	public Integer getDdlCBZTFind() {
		return ddlCBZTFind;
	}
	/**
	 * @param ddlCBZTFind the ddlCBZTFind to set
	 */
	public void setDdlCBZTFind(Integer ddlCBZTFind) {
		this.ddlCBZTFind = ddlCBZTFind;
	}
	/**
	 * @return the ddlSYZTFind
	 */
	public Integer getDdlSYZTFind() {
		return ddlSYZTFind;
	}
	/**
	 * @param ddlSYZTFind the ddlSYZTFind to set
	 */
	public void setDdlSYZTFind(Integer ddlSYZTFind) {
		this.ddlSYZTFind = ddlSYZTFind;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
