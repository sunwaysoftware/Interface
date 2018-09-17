package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv00301_bService;
import com.sunway.service.IPgv00302_bService;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00009;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00302_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 住宅国土信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv00302_bAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 2554976037301856513L;
	// Service
	private IPgv00301_bService v00301_bService;
	private IPgv00302_bService v00302_bService;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	// Bean数组
	private ArrayList<PgvCzPssd> pssdList;
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv00302_b> rows;
	private ArrayList<Pgv00009> ssgxList;
	private String defSSGX;
	// 检索条件
	private String txtFCIDFind;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFDCDATFind;
	private String txtXQFind;
	private String txtFWTDZLFind;
	private String ddlSZQYFind;
	private String txtPSSDFind;
	private String ddlSSGXFind;
	private Integer ddlSCZTFind;
	// Detail
	private String FCID;
	private String PSSD;
	private Pgv00302_b v00302_bBean;
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
			pssdList = v00301_bService.LoadPssd();
			ssgxList = (ArrayList<Pgv00009>) sessionCtrl.GetList(SessionCtrl.SESSION_LIST_SSGX);
			defSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
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

		Pgv00302_b v00302_b = new Pgv00302_b();
		v00302_bBean = new Pgv00302_b();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00302_b.setPageIndex(pageIndex);
			v00302_b.setPageSize(getPageSize());
			v00302_b.setCd00001Ssgx(CheckUtil.chkTrim(ddlSSGXFind));
			v00302_b.setCd00002Pssd(CheckUtil.chkTrim(txtPSSDFind));
			v00302_b.setFcid(CheckUtil.chkTrim(txtFCIDFind));
			v00302_b.setCd00301BSwid(FormatUtil.toSearchLike(txtSWIDFind));
			v00302_b.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v00302_b.setFdcdat(FormatUtil.toSearchLike(txtFDCDATFind));
			v00302_b.setCd00001Szqy(ddlSZQYFind);
			v00302_b.setXqnm(FormatUtil.toSearchLike(txtXQFind));
			v00302_b.setFwtdzl(FormatUtil.toSearchLike(txtFWTDZLFind));
			v00302_b.setSczt(ddlSCZTFind);
			// 执行查询
			v00302_bBean = v00302_bService.LoadAll(v00302_b);
			rows = v00302_bBean.getV00302_bList();
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				total = 0;
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
	 * 住宅国土信息详细
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00302_b v00302_b = new Pgv00302_b();
		v00302_bBean = new Pgv00302_b();
		try {
			// 准备查询条件
			v00302_b.setFcid(ConvertUtil.encoding(CheckUtil.chkTrim(FCID)));
			v00302_b.setCd00002Pssd(ConvertUtil.encoding(CheckUtil.chkTrim(PSSD)));
			// 执行查询
			v00302_bBean = v00302_bService.LoadDetail(v00302_b);
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
	 * @return the v00301_bService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgv00301_bService getV00301_bService() {
		return v00301_bService;
	}
	/**
	 * @param v00301BService the v00301_bService to set
	 */
	public void setV00301_bService(IPgv00301_bService v00301BService) {
		v00301_bService = v00301BService;
	}
	/**
	 * @return the v00302_bService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgv00302_bService getV00302_bService() {
		return v00302_bService;
	}
	/**
	 * @param v00302BService the v00302_bService to set
	 */
	public void setV00302_bService(IPgv00302_bService v00302BService) {
		v00302_bService = v00302BService;
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
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
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
	 * @return the rows
	 */
	public ArrayList<Pgv00302_b> getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00302_b> rows) {
		this.rows = rows;
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
	 * @return the ddlSSGXFind
	 */
	public String getDdlSSGXFind() {
		return ddlSSGXFind;
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
	 * @param ddlSSGXFind the ddlSSGXFind to set
	 */
	public void setDdlSSGXFind(String ddlSSGXFind) {
		this.ddlSSGXFind = ddlSSGXFind;
	}
	/**
	 * @return the ddlSCZTFind
	 */
	public Integer getDdlSCZTFind() {
		return ddlSCZTFind;
	}
	/**
	 * @param ddlSCZTFind the ddlSCZTFind to set
	 */
	public void setDdlSCZTFind(Integer ddlSCZTFind) {
		this.ddlSCZTFind = ddlSCZTFind;
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
	 * @return the v00302_bBean
	 */
	public Pgv00302_b getV00302_bBean() {
		return v00302_bBean;
	}
	/**
	 * @param v00302BBean the v00302_bBean to set
	 */
	public void setV00302_bBean(Pgv00302_b v00302BBean) {
		v00302_bBean = v00302BBean;
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