package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv12002AService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12002A;

/**
 * 地产信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv12002AAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -5905373083188163086L;
	// Service
	private IPgv12002AService v12002AService;
	// 分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv12002A> operList;
	// 检索条件
	private String txtDCIDFind;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String CZH;
	// Detail
	private String DCID;
	private Pgv12002A v12002aBean;
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

		Pgv12002A v12002A = new Pgv12002A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12002A.setPageIndex(pageIndex);
			v12002A.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12002A.setDcid(Common.convertEncoding(Common.trim(txtDCIDFind)));
			v12002A.setCd12001aSwid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12002A.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12002A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			operList = v12002AService.LoadAll(v12002A);
			// 分页设置
			if (null != operList && operList.size() > 0) {
				rowCount = operList.get(0).getRecordCount();
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
	 * 地产览初始化
	 * @return
	 * @throws Exception
	 */
	public String listInit() throws Exception {
		return SUCCESS;
	}

	/**
	 * 地产一览
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("list() ********** start **********");
		}

		Pgv12002A v12002A = new Pgv12002A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12002A.setPageIndex(pageIndex);
			v12002A.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12002A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12002A.setCzh(Common.trim(CZH));
			// 执行查询
			operList = v12002AService.LoadAll(v12002A);
			// 分页设置
			if (null != operList && operList.size() > 0) {
				rowCount = operList.get(0).getRecordCount();
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
	 * 地产信息详细
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv12002A v12002A = new Pgv12002A();
		v12002aBean = new Pgv12002A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12002A.setPageIndex(Common.convertToInteger(Constant.PAGE_FIRST));
			v12002A.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12002A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12002A.setCzh(Common.trim(CZH));
			v12002A.setDcid(Common.convertEncoding(Common.trim(DCID)));
			// 执行查询
			operList = v12002AService.LoadAll(v12002A);
			// 取得详细
			if (null != operList && operList.size() > 0) {
				v12002aBean = operList.get(0);
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
	 * @return the v12002AService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgv12002AService getV12002AService() {
		return v12002AService;
	}
	/**
	 * @param v12002aService the v12002AService to set
	 */
	public void setV12002AService(IPgv12002AService v12002aService) {
		v12002AService = v12002aService;
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
	 * @return the operList
	 */
	public ArrayList<Pgv12002A> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<Pgv12002A> operList) {
		this.operList = operList;
	}
	/**
	 * @return the txtDCIDFind
	 */
	public String getTxtDCIDFind() {
		return txtDCIDFind;
	}
	/**
	 * @param txtDCIDFind the txtDCIDFind to set
	 */
	public void setTxtDCIDFind(String txtDCIDFind) {
		this.txtDCIDFind = txtDCIDFind;
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
	 * @return the v12002aBean
	 */
	public Pgv12002A getV12002aBean() {
		return v12002aBean;
	}
	/**
	 * @param v12002aBean the v12002aBean to set
	 */
	public void setV12002aBean(Pgv12002A v12002aBean) {
		this.v12002aBean = v12002aBean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}