package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv12001_bService;
import com.sunway.service.IPgvBb00007_bService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00009;
import com.sunway.vo.PgvBb00007_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 报表7（Bb00007_b）
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */

public class PgvBb00007_bAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 8870696225193372964L;
	// Service
	private IPgvBb00007_bService bb00007_bService;
	private IPgv12001_bService v12001_bService;
	// Bean数组
	private ArrayList<PgvBb00007_b> operList;
	private Double txtJSBLFind;
	private Double txtSLFind;
	private ArrayList<Pgv00009> ssgxList;
	private ArrayList<PgvCzPssd> pssdList;
	private String defSSGX;
	private String defPSSD;
	private String ddlPSSDFind;
	private String ddlSSGXFind;
	private Boolean chkSFSSGX;
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
			txtJSBLFind = Common.convertToDouble(Constant.JSBL);
			txtSLFind = Common.convertToDouble(Constant.SL);
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
		PgvBb00007_b bb00007_b = new PgvBb00007_b();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00007_b.setCd00002Pssd(Common.convertEncoding(Common.trim(ddlPSSDFind)));
			bb00007_b.setCd00001Ssgx(Common.convertEncoding(Common.trim(ddlSSGXFind)));
			bb00007_b.setSfssgx(Common.checkNull(chkSFSSGX));
			bb00007_b.setSl(txtSLFind);
			bb00007_b.setJsbl(txtJSBLFind);
			bb00007_b.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			operList = bb00007_bService.LoadAll(bb00007_b);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** setter and getter ******************************/

	/**
	 * @return the bb00007_bService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvBb00007_bService getBb00007_bService() {
		return bb00007_bService;
	}
	/**
	 * @param bb00007_bService the bb00007_bService to set
	 */
	public void setBb00007_bService(IPgvBb00007_bService bb00007_bService) {
		this.bb00007_bService = bb00007_bService;
	}
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
	 * @return the operList
	 */
	public ArrayList<PgvBb00007_b> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvBb00007_b> operList) {
		this.operList = operList;
	}
	/**
	 * @return the txtJSBLFind
	 */
	public Double getTxtJSBLFind() {
		return txtJSBLFind;
	}
	/**
	 * @param txtJSBLFind the txtJSBLFind to set
	 */
	public void setTxtJSBLFind(Double txtJSBLFind) {
		this.txtJSBLFind = txtJSBLFind;
	}
	/**
	 * @return the txtSLFind
	 */
	public Double getTxtSLFind() {
		return txtSLFind;
	}
	/**
	 * @param txtSLFind the txtSLFind to set
	 */
	public void setTxtSLFind(Double txtSLFind) {
		this.txtSLFind = txtSLFind;
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
	 * @return the ddlPSSDFind
	 */
	public String getDdlPSSDFind() {
		return ddlPSSDFind;
	}
	/**
	 * @param ddlPSSDFind the ddlPSSDFind to set
	 */
	public void setDdlPSSDFind(String ddlPSSDFind) {
		this.ddlPSSDFind = ddlPSSDFind;
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
	 * @return the chkSFSSGX
	 */
	public Boolean getChkSFSSGX() {
		return chkSFSSGX;
	}
	/**
	 * @param chkSFSSGX the chkSFSSGX to set
	 */
	public void setChkSFSSGX(Boolean chkSFSSGX) {
		this.chkSFSSGX = chkSFSSGX;
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
