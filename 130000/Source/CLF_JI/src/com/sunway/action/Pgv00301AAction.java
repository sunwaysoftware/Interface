package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv00301AService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00301A;

/**
 * 住宅登记信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv00301AAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -9052991100108346567L;
	// Service
	private IPgv00301AService v00301AService;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv00301A> tabList;
	// 检索条件
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String CZH;
	// Detail
	private String SWID;
	private Pgv00301A v00301aBean;
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

		Pgv00301A v00301A = new Pgv00301A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00301A.setPageIndex(pageIndex);
			v00301A.setPageSize(getPageSize());
			v00301A.setSwid(Common.getSearchLike(txtSWIDFind));
			v00301A.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v00301A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			tabList = v00301AService.LoadAll(v00301A);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				rowCount = 0;
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
	 * 显示框架
	 * @return
	 * @throws Exception
	 */
	public String frame() throws Exception {
		return SUCCESS;
	}

	/**
	 * 住宅登记信息一览初始化
	 * @return
	 * @throws Exception
	 */
	public String listInit() throws Exception {
		return SUCCESS;
	}

	/**
	 * 住宅登记信息一览
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("list() ********** start **********");
		}

		Pgv00301A v00301A = new Pgv00301A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00301A.setPageIndex(pageIndex);
			v00301A.setPageSize(getPageSize());
			v00301A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00301A.setCzh(Common.trim(CZH));
			// 执行查询
			tabList = v00301AService.LoadAll(v00301A);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				rowCount = 0;
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
	 * 住宅登记信息详细
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00301A v00301A = new Pgv00301A();
		v00301aBean = new Pgv00301A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00301A.setPageIndex(Common.convertToInteger(Constant.PAGE_FIRST));
			v00301A.setPageSize(getPageSize());
			v00301A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00301A.setCzh(Common.trim(CZH));
			v00301A.setSwid(Common.convertEncoding(Common.trim(SWID)));
			// 执行查询
			tabList = v00301AService.LoadAll(v00301A);
			// 取得详细
			if (null != tabList && tabList.size() > 0) {
				v00301aBean = tabList.get(0);
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
	 * @return the v00301AService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgv00301AService getV00301AService() {
		return v00301AService;
	}
	/**
	 * @param v00301aService the v00301AService to set
	 */
	public void setV00301AService(IPgv00301AService v00301aService) {
		v00301AService = v00301aService;
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
	public ArrayList<Pgv00301A> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00301A> tabList) {
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
	 * @return the sWID
	 */
	public String getSWID() {
		return SWID;
	}
	/**
	 * @param sWID the sWID to set
	 */
	public void setSWID(String sWID) {
		SWID = sWID;
	}
	/**
	 * @return the v00301aBean
	 */
	public Pgv00301A getV00301aBean() {
		return v00301aBean;
	}
	/**
	 * @param v00301aBean the v00301aBean to set
	 */
	public void setV00301aBean(Pgv00301A v00301aBean) {
		this.v00301aBean = v00301aBean;
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
