package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv00302AService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00302A;

/**
 * 住宅房产信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv00302AAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 5005053053609150032L;
	// Service
	private IPgv00302AService v00302AService;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv00302A> tabList;
	// 检索条件
	private String txtFCIDFind;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFDCDATFind;
	private String txtXQFind;
	private String txtFWTDZLFind;
	private String ddlSZQYFind;
	private String CZH;
	// Detail
	private String FCID;
	private Pgv00302A v00302aBean;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		try {
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
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

		Pgv00302A v00302A = new Pgv00302A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00302A.setPageIndex(pageIndex);
			v00302A.setPageSize(getPageSize());
			v00302A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00302A.setFcid(Common.convertEncoding(Common.trim(txtFCIDFind)));
			v00302A.setCd00301aSwid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v00302A.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v00302A.setFdcdat(Common.getSearchLike(Common.convertEncoding(txtFDCDATFind)));
			v00302A.setCd00001Szqy(ddlSZQYFind);
			v00302A.setCd00352Xqdm(Common.convertEncoding(Common.trim(txtXQFind)));
			v00302A.setFwtdzl(Common.getSearchLike(Common.convertEncoding(txtFWTDZLFind)));
			// 执行查询
			tabList = v00302AService.LoadAll(v00302A);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				
			} else {
				
				pageIndex = 1;rowCount = 0;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
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
	 * 住宅房产信息一览初始化
	 * @return
	 * @throws Exception
	 */
	public String listInit() throws Exception {
		return SUCCESS;
	}

	/**
	 * 住宅房产信息一览
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("list() ********** start **********");
		}

		Pgv00302A v00302A = new Pgv00302A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00302A.setPageIndex(pageIndex);
			v00302A.setPageSize(getPageSize());
			v00302A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00302A.setCzh(Common.trim(CZH));
			// 执行查询
			tabList = v00302AService.LoadAll(v00302A);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				
			} else {
				
				pageIndex = 1;rowCount = 0;
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
	 * 住宅房产信息详细
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00302A v00302A = new Pgv00302A();
		v00302aBean = new Pgv00302A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00302A.setPageIndex(Common.convertToInteger(Constant.PAGE_FIRST));
			v00302A.setPageSize(getPageSize());
			v00302A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00302A.setCzh(Common.trim(CZH));
			v00302A.setFcid(Common.convertEncoding(Common.trim(FCID)));
			// 执行查询
			tabList = v00302AService.LoadAll(v00302A);
			// 取得详细
			if (null != tabList && tabList.size() > 0) {
				v00302aBean = tabList.get(0);
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

	/**
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	
	private void ReadInfo() throws Exception {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}

	/*********************** setter and getter ******************************/

	/**
	 * @return the v00302AService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgv00302AService getV00302AService() {
		return v00302AService;
	}
	/**
	 * @param v00302aService the v00302AService to set
	 */
	public void setV00302AService(IPgv00302AService v00302aService) {
		v00302AService = v00302aService;
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
	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv00302A> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00302A> tabList) {
		this.tabList = tabList;
	}
	/**
	 * @return the txtFCIDFind
	 */
	public String getTxtFCIDFind() {
		return txtFCIDFind;
	}
	/**
	 * @param txtFCIDFind the txtFCIDFind to set
	 */
	public void setTxtFCIDFind(String txtFCIDFind) {
		this.txtFCIDFind = txtFCIDFind;
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
	 * @return the txtFDCDATFind
	 */
	public String getTxtFDCDATFind() {
		return txtFDCDATFind;
	}
	/**
	 * @param txtFDCDATFind the txtFDCDATFind to set
	 */
	public void setTxtFDCDATFind(String txtFDCDATFind) {
		this.txtFDCDATFind = txtFDCDATFind;
	}
	/**
	 * @return the txtXQFind
	 */
	public String getTxtXQFind() {
		return txtXQFind;
	}
	/**
	 * @param txtXQFind the txtXQFind to set
	 */
	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}
	/**
	 * @return the txtFWTDZLFind
	 */
	public String getTxtFWTDZLFind() {
		return txtFWTDZLFind;
	}
	/**
	 * @param txtFWTDZLFind the txtFWTDZLFind to set
	 */
	public void setTxtFWTDZLFind(String txtFWTDZLFind) {
		this.txtFWTDZLFind = txtFWTDZLFind;
	}
	/**
	 * @return the ddlSZQYFind
	 */
	public String getDdlSZQYFind() {
		return ddlSZQYFind;
	}
	/**
	 * @param ddlSZQYFind the ddlSZQYFind to set
	 */
	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
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
	 * @return the fCID
	 */
	public String getFCID() {
		return FCID;
	}
	/**
	 * @param fCID the fCID to set
	 */
	public void setFCID(String fCID) {
		FCID = fCID;
	}
	/**
	 * @return the v00302aBean
	 */
	public Pgv00302A getV00302aBean() {
		return v00302aBean;
	}
	/**
	 * @param v00302aBean the v00302aBean to set
	 */
	public void setV00302aBean(Pgv00302A v00302aBean) {
		this.v00302aBean = v00302aBean;
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
