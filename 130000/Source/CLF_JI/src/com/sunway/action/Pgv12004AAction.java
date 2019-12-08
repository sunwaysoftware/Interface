package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv12004AService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12004A;

/**
 * 明细信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv12004AAction extends ActionSupport implements SessionAware  {

	private static final long serialVersionUID = -4256193606695854361L;
	// Service
	private IPgv12004AService v12004AService;
	// 分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv12004A> tabList;
	// 检索条件
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtMXIDFind;
	private String CZH;
	// Detail
	private String MXID;
	private Pgv12004A v12004aBean;
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

		Pgv12004A v12004A = new Pgv12004A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12004A.setPageIndex(pageIndex);
			v12004A.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12004A.setMxid(Common.convertEncoding(Common.trim(txtMXIDFind)));
			v12004A.setCd12001aSwid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12004A.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12004A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			tabList = v12004AService.LoadAll(v12004A);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
				pageIndex = 1;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 房产明细一览初始化
	 * @return
	 * @throws Exception
	 */
	public String listInit() throws Exception {
		return SUCCESS;
	}

	/**
	 * 房产明细一览
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("list() ********** start **********");
		}

		Pgv12004A v12004A = new Pgv12004A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12004A.setPageIndex(pageIndex);
			v12004A.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12004A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12004A.setCzh(Common.trim(CZH));
			// 执行查询
			tabList = v12004AService.LoadAll(v12004A);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
				pageIndex = 1;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("list() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 房产明细信息详细
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv12004A v12004A = new Pgv12004A();
		v12004aBean = new Pgv12004A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12004A.setPageIndex(Common.convertToInteger(Constant.PAGE_FIRST));
			v12004A.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12004A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12004A.setCzh(Common.trim(CZH));
			v12004A.setMxid(Common.convertEncoding(Common.trim(MXID)));
			// 执行查询
			tabList = v12004AService.LoadAll(v12004A);
			// 取得详细
			if (null != tabList && tabList.size() > 0) {
				v12004aBean = tabList.get(0);
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** setter and getter ******************************/

	/**
	 * @return the v12004AService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgv12004AService getV12004AService() {
		return v12004AService;
	}
	/**
	 * @param v12004aService the v12004AService to set
	 */
	public void setV12004AService(IPgv12004AService v12004aService) {
		v12004AService = v12004aService;
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
	public ArrayList<Pgv12004A> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12004A> tabList) {
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
	 * @return the cZH
	 */
	public String getCZH() {
		return CZH;
	}
	/**
	 * @param cZH the cZH to set
	 */
	public void setCZH(String cZH) {
		CZH = cZH;
	}
	/**
	 * @return the mXID
	 */
	public String getMXID() {
		return MXID;
	}
	/**
	 * @param mXID the mXID to set
	 */
	public void setMXID(String mXID) {
		MXID = mXID;
	}
	/**
	 * @return the v12004aBean
	 */
	public Pgv12004A getV12004aBean() {
		return v12004aBean;
	}
	/**
	 * @param v12004aBean the v12004aBean to set
	 */
	public void setV12004aBean(Pgv12004A v12004aBean) {
		this.v12004aBean = v12004aBean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}