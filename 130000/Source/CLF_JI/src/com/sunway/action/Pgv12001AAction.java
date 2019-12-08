package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv12001AService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12001A;

/**
 * 登记信息变更查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv12001AAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -2435094813265927543L;
	// Service
	private IPgv12001AService v12001AService;
	// 分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv12001A> operList;
	// 检索条件
	private String txtSwidFind;
	private String txtNsrmcFind;
	private String CZH;
	// Detail
	private String SWID;
	private Pgv12001A v12001aBean;
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

		Pgv12001A v12001A = new Pgv12001A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12001A.setPageIndex(pageIndex);
			v12001A.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12001A.setSwid(Common.getSearchLike(Common.convertEncoding(txtSwidFind)));
			v12001A.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNsrmcFind)));
			v12001A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			operList = v12001AService.LoadAll(v12001A);
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
	 * 显示框架
	 * @return
	 * @throws Exception
	 */
	public String frame() throws Exception {
		return SUCCESS;
	}

	/**
	 * 纳税人一览初始化
	 * @return
	 * @throws Exception
	 */
	public String listInit() throws Exception {
		return SUCCESS;
	}

	/**
	 * 纳税人一览
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("list() ********** start **********");
		}
		Pgv12001A v12001A = new Pgv12001A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12001A.setPageIndex(pageIndex);
			v12001A.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12001A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12001A.setCzh(Common.trim(CZH));
			// 执行查询
			operList = v12001AService.LoadAll(v12001A);
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
	 * 纳税人详细
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv12001A v12001A = new Pgv12001A();
		v12001aBean = new Pgv12001A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12001A.setPageIndex(Common.convertToInteger(Constant.PAGE_FIRST));
			v12001A.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12001A.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12001A.setCzh(Common.trim(CZH));
			v12001A.setSwid(Common.convertEncoding(Common.trim(SWID)));
			// 执行查询
			operList = v12001AService.LoadAll(v12001A);
			// 取得详细
			if (null != operList && operList.size() > 0) {
				v12001aBean = operList.get(0);
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
	 * @return the v12001AService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgv12001AService getV12001AService() {
		return v12001AService;
	}
	/**
	 * @param v12001aService the v12001AService to set
	 */
	public void setV12001AService(IPgv12001AService v12001aService) {
		v12001AService = v12001aService;
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
	public ArrayList<Pgv12001A> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<Pgv12001A> operList) {
		this.operList = operList;
	}
	/**
	 * @return the txtSwidFind
	 */
	public String getTxtSwidFind() {
		return txtSwidFind;
	}
	/**
	 * @param txtSwidFind the txtSwidFind to set
	 */
	public void setTxtSwidFind(String txtSwidFind) {
		this.txtSwidFind = txtSwidFind;
	}
	/**
	 * @return the txtNsrmcFind
	 */
	public String getTxtNsrmcFind() {
		return txtNsrmcFind;
	}
	/**
	 * @param txtNsrmcFind the txtNsrmcFind to set
	 */
	public void setTxtNsrmcFind(String txtNsrmcFind) {
		this.txtNsrmcFind = txtNsrmcFind;
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
	 * @return the v12001aBean
	 */
	public Pgv12001A getV12001aBean() {
		return v12001aBean;
	}
	/**
	 * @param v12001aBean the v12001aBean to set
	 */
	public void setV12001aBean(Pgv12001A v12001aBean) {
		this.v12001aBean = v12001aBean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
