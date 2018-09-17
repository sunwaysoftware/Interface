package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv00301_bService;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00009;
import com.sunway.vo.Pgv00301_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 住宅登记信息备份数据查询
 * @category 备份数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv00301_bAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -4418216641042002133L;
	// Service
	private IPgv00301_bService v00301_bService;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	// Bean数组
	private ArrayList<Pgv00301_b> rows;
	private ArrayList<Pgv00009> ssgxList;
	private ArrayList<PgvCzPssd> pssdList;
	private String defSSGX;
	// 检索条件
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtPSSDFind;
	private String ddlSSGXFind;
	private Integer ddlSCZTFind;
	// Detail
	private String SWID;
	private String PSSD;
	private Pgv00301_b v00301_bBean;
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

		Pgv00301_b v00301_b = new Pgv00301_b();
		v00301_bBean = new Pgv00301_b();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00301_b.setPageIndex(pageIndex);
			v00301_b.setPageSize(getPageSize());
			v00301_b.setSwid(FormatUtil.toSearchLike(txtSWIDFind));
			v00301_b.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v00301_b.setCd00001Ssgx(CheckUtil.chkTrim(ddlSSGXFind));
			v00301_b.setCd00002Pssd(CheckUtil.chkTrim(txtPSSDFind));
			v00301_b.setSczt(ddlSCZTFind);
			// 执行查询
			v00301_bBean = v00301_bService.LoadAll(v00301_b);
			rows = v00301_bBean.getV00301_bList();
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
	 * 住宅登记信息详细
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00301_b v00301_b = new Pgv00301_b();
		v00301_bBean = new Pgv00301_b();
		try {
			// 准备查询条件
			v00301_b.setSwid(ConvertUtil.encoding(CheckUtil.chkTrim(SWID)));
			v00301_b.setCd00002Pssd(ConvertUtil.encoding(CheckUtil.chkTrim(PSSD)));
			// 执行查询
			v00301_bBean = v00301_bService.LoadDetail(v00301_b);
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
	 * @return the rows
	 */
	public ArrayList<Pgv00301_b> getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00301_b> rows) {
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
	 * @return the v00301_bBean
	 */
	public Pgv00301_b getV00301_bBean() {
		return v00301_bBean;
	}
	/**
	 * @param v00301BBean the v00301_bBean to set
	 */
	public void setV00301_bBean(Pgv00301_b v00301BBean) {
		v00301_bBean = v00301BBean;
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
