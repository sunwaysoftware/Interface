package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv12001_bService;
import com.sunway.service.IPgvBb00010_bService;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00009;
import com.sunway.vo.PgvBb00010_b;
import com.sunway.vo.PgvCzPssd;

/**
 * 报表10（Bb00010_b）
 * @category 备份数据
 * @author Lee
 * @version 1.0
 */

public class PgvBb00010_bAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -2842175390854490191L;
	// Service
	private IPgvBb00010_bService bb00010_bService;
	private IPgv12001_bService v12001_bService;
	// Bean数组
	private ArrayList<PgvBb00010_b> operList;
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
		PgvBb00010_b bb00010_b = new PgvBb00010_b();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00010_b.setCd00002Pssd(Common.convertEncoding(Common.trim(ddlPSSDFind)));
			bb00010_b.setCd00001Ssgx(Common.convertEncoding(Common.trim(ddlSSGXFind)));
			bb00010_b.setSfssgx(Common.checkNull(chkSFSSGX));
			bb00010_b.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			operList = bb00010_bService.LoadAll(bb00010_b);
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
	 * @return the bb00010_bService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvBb00010_bService getBb00010_bService() {
		return bb00010_bService;
	}
	/**
	 * @param bb00010_bService the bb00010_bService to set
	 */
	public void setBb00010_bService(IPgvBb00010_bService bb00010_bService) {
		this.bb00010_bService = bb00010_bService;
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
	public ArrayList<PgvBb00010_b> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvBb00010_b> operList) {
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
