package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv12001_bService;
import com.sunway.service.IPgv12004_bService;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00009;
import com.sunway.vo.Pgv12004_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 明细信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv12004_bAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -5364075749441300271L;
	// Service
	private IPgv12001_bService v12001_bService;
	private IPgv12004_bService v12004_bService;
	// 分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv12004_b> tabList;
	private ArrayList<Pgv00009> ssgxList;
	private String defSSGX;
	private String defPSSD;
	private ArrayList<PgvCzPssd> pssdList;
	// 检索条件
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtMXIDFind;
	private String txtPSSDFind;
	private String ddlSSGXFind;
	private Integer ddlCBZTFind;
	private Integer ddlSYZTFind;
	// Detail
	private String MXID;
	private String PSSD;
	private Pgv12004_b v12004_bBean;
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
		pssdList = new ArrayList<PgvCzPssd>();
		ssgxList = new ArrayList<Pgv00009>();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			pssdList = v12001_bService.LoadPssd();
			ssgxList = (ArrayList<Pgv00009>) sessionCtrl.GetList(SessionCtrl.SESSION_LIST_SSGX);
			defSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			defPSSD = sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD);
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

		Pgv12004_b v12004_b = new Pgv12004_b();
		v12004_bBean = new Pgv12004_b();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12004_b.setPageIndex(pageIndex);
			v12004_b.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12004_b.setMxid(Common.convertEncoding(Common.trim(txtMXIDFind)));
			v12004_b.setCd12001BSwid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12004_b.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12004_b.setCd00001Ssgx(Common.convertEncoding(Common.trim(ddlSSGXFind)));
			v12004_b.setCd00002Pssd(Common.convertEncoding(Common.trim(txtPSSDFind)));
			v12004_b.setCbzt(ddlCBZTFind);
			v12004_b.setSyzt(ddlSYZTFind);
			// 执行查询
			v12004_bBean = v12004_bService.LoadAll(v12004_b);
			tabList = v12004_bBean.getV12004_bList();
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
	 * 房产明细信息详细
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv12004_b v12004_b = new Pgv12004_b();
		v12004_bBean = new Pgv12004_b();
		try {
			// 准备查询条件
			v12004_b.setMxid(Common.convertEncoding(Common.trim(MXID)));
			v12004_b.setCd00002Pssd(Common.convertEncoding(Common.trim(PSSD)));
			// 执行查询
			v12004_bBean = v12004_bService.LoadDetail(v12004_b);
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
	 * @return the v12001_bService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgv12001_bService getV12001_bService() {
		return v12001_bService;
	}
	/**
	 * @param v12001BService the v12001_bService to set
	 */
	public void setV12001_bService(IPgv12001_bService v12001BService) {
		v12001_bService = v12001BService;
	}
	/**
	 * @return the v12004_bService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgv12004_bService getV12004_bService() {
		return v12004_bService;
	}
	/**
	 * @param v12004BService the v12004_bService to set
	 */
	public void setV12004_bService(IPgv12004_bService v12004BService) {
		v12004_bService = v12004BService;
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
	public ArrayList<Pgv12004_b> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12004_b> tabList) {
		this.tabList = tabList;
	}
	/**
	 * @return the ssgxList
	 */
	public ArrayList<Pgv00009> getSsgxList() {
		return ssgxList;
	}
	/**
	 * @param ssgxList the ssgxList to set
	 */
	public void setSsgxList(ArrayList<Pgv00009> ssgxList) {
		this.ssgxList = ssgxList;
	}
	/**
	 * @return the defSSGX
	 */
	public String getDefSSGX() {
		return defSSGX;
	}
	/**
	 * @param defSSGX the defSSGX to set
	 */
	public void setDefSSGX(String defSSGX) {
		this.defSSGX = defSSGX;
	}
	/**
	 * @return the pssdList
	 */
	public ArrayList<PgvCzPssd> getPssdList() {
		return pssdList;
	}
	/**
	 * @param pssdList the pssdList to set
	 */
	public void setPssdList(ArrayList<PgvCzPssd> pssdList) {
		this.pssdList = pssdList;
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
	 * @return the txtPSSDFind
	 */
	public String getTxtPSSDFind() {
		return txtPSSDFind;
	}
	/**
	 * @param txtPSSDFind the txtPSSDFind to set
	 */
	public void setTxtPSSDFind(String txtPSSDFind) {
		this.txtPSSDFind = txtPSSDFind;
	}
	/**
	 * @return the ddlSSGXFind
	 */
	public String getDdlSSGXFind() {
		return ddlSSGXFind;
	}
	/**
	 * @param ddlSSGXFind the ddlSSGXFind to set
	 */
	public void setDdlSSGXFind(String ddlSSGXFind) {
		this.ddlSSGXFind = ddlSSGXFind;
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
	 * @return the pSSD
	 */
	public String getPSSD() {
		return PSSD;
	}
	/**
	 * @param pSSD the pSSD to set
	 */
	public void setPSSD(String pSSD) {
		PSSD = pSSD;
	}
	/**
	 * @return the v12004_bBean
	 */
	public Pgv12004_b getV12004_bBean() {
		return v12004_bBean;
	}
	/**
	 * @param v12004BBean the v12004_bBean to set
	 */
	public void setV12004_bBean(Pgv12004_b v12004BBean) {
		v12004_bBean = v12004BBean;
	}

	/**
	 * @param defPSSD the defPSSD to set
	 */
	public void setDefPSSD(String defPSSD) {
		this.defPSSD = defPSSD;
	}

	/**
	 * @return the defPSSD
	 */
	public String getDefPSSD() {
		return defPSSD;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
