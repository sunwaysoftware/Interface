package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv12001_bService;
import com.sunway.service.IPgv12003_bService;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00009;
import com.sunway.vo.Pgv12003_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 房产信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv12003_bAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -5969926545968547054L;
	// Service
	private IPgv12001_bService v12001_bService;
	private IPgv12003_bService v12003_bService;
	// 分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv12003_b> tabList;
	private ArrayList<Pgv00009> ssgxList;
	private String defSSGX;
	private String defPSSD;
	private ArrayList<PgvCzPssd> pssdList;
	// 检索条件
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFCIDFind;
	private String txtPSSDFind;
	private String ddlSSGXFind;
	private Integer ddlCBZTFind;
	private Integer ddlSYZTFind;
	// Detail
	private String FCID;
	private String PSSD;
	private Pgv12003_b v12003_bBean;
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

		Pgv12003_b v12003_b = new Pgv12003_b();
		v12003_bBean = new Pgv12003_b();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12003_b.setPageIndex(pageIndex);
			v12003_b.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12003_b.setFcid(Common.convertEncoding(Common.trim(txtFCIDFind)));
			v12003_b.setCd12001BSwid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12003_b.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12003_b.setCd00001Ssgx(Common.convertEncoding(Common.trim(ddlSSGXFind)));
			v12003_b.setCd00002Pssd(Common.convertEncoding(Common.trim(txtPSSDFind)));
			v12003_b.setCbzt(ddlCBZTFind);
			v12003_b.setSyzt(ddlSYZTFind);
			// 执行查询
			v12003_bBean = v12003_bService.LoadAll(v12003_b);
			tabList = v12003_bBean.getV12003_bList();
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
	 * 房产信息详细
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv12003_b v12003_b = new Pgv12003_b();
		v12003_bBean = new Pgv12003_b();
		try {
			// 准备查询条件
			v12003_b.setFcid(Common.convertEncoding(Common.trim(FCID)));
			v12003_b.setCd00002Pssd(Common.convertEncoding(Common.trim(PSSD)));
			// 执行查询
			v12003_bBean = v12003_bService.LoadDetail(v12003_b);
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
	 * @return the v12003_bService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgv12003_bService getV12003_bService() {
		return v12003_bService;
	}
	/**
	 * @param v12003BService the v12003_bService to set
	 */
	public void setV12003_bService(IPgv12003_bService v12003BService) {
		v12003_bService = v12003BService;
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
	public ArrayList<Pgv12003_b> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12003_b> tabList) {
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
	 * @return the v12003_bBean
	 */
	public Pgv12003_b getV12003_bBean() {
		return v12003_bBean;
	}
	/**
	 * @param v12003BBean the v12003_bBean to set
	 */
	public void setV12003_bBean(Pgv12003_b v12003BBean) {
		v12003_bBean = v12003BBean;
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
