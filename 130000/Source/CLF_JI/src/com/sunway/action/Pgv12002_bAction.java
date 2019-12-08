package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv12001_bService;
import com.sunway.service.IPgv12002_bService;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00009;
import com.sunway.vo.Pgv12002_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 地产信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv12002_bAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 144161395644726794L;
	// Service
	private IPgv12001_bService v12001_bService;
	private IPgv12002_bService v12002_bService;
	// 分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	// Bean数组
	private Pgv12002_b v12002_bBean;
	private ArrayList<Pgv12002_b> operList;
	private ArrayList<Pgv00009> ssgxList;
	private String defSSGX;
	private String defPSSD;
	private ArrayList<PgvCzPssd> pssdList;
	// 检索条件
	private String txtDCIDFind;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtPSSDFind;
	private String ddlSSGXFind;
	private Integer ddlCBZTFind;
	private Integer ddlSYZTFind;
	// Detail
	private String DCID;
	private String PSSD;
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

		Pgv12002_b v12002_b = new Pgv12002_b();
		v12002_bBean = new Pgv12002_b();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12002_b.setPageIndex(pageIndex);
			v12002_b.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12002_b.setDcid(Common.convertEncoding(Common.trim(txtDCIDFind)));
			v12002_b.setCd12001BSwid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12002_b.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12002_b.setCd00001Ssgx(Common.convertEncoding(Common.trim(ddlSSGXFind)));
			v12002_b.setCd00002Pssd(Common.convertEncoding(Common.trim(txtPSSDFind)));
			v12002_b.setCbzt(ddlCBZTFind);
			v12002_b.setSyzt(ddlSYZTFind);
			// 执行查询
			v12002_bBean = v12002_bService.LoadAll(v12002_b);
			operList = v12002_bBean.getV12002_bList();
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
	 * 地产信息详细
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv12002_b v12002_b = new Pgv12002_b();
		v12002_bBean = new Pgv12002_b();
		try {
			// 准备查询条件
			v12002_b.setDcid(Common.convertEncoding(Common.trim(DCID)));
			v12002_b.setCd00002Pssd(Common.convertEncoding(Common.trim(PSSD)));
			// 执行查询
			v12002_bBean = v12002_bService.LoadDetail(v12002_b);
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
	 * @return the v12002_bService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgv12002_bService getV12002_bService() {
		return v12002_bService;
	}
	/**
	 * @param v12002BService the v12002_bService to set
	 */
	public void setV12002_bService(IPgv12002_bService v12002BService) {
		v12002_bService = v12002BService;
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
	 * @return the v12002_bBean
	 */
	public Pgv12002_b getV12002_bBean() {
		return v12002_bBean;
	}
	/**
	 * @param v12002BBean the v12002_bBean to set
	 */
	public void setV12002_bBean(Pgv12002_b v12002BBean) {
		v12002_bBean = v12002BBean;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<Pgv12002_b> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<Pgv12002_b> operList) {
		this.operList = operList;
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
