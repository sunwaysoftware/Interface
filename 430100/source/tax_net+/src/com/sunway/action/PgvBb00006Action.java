package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvBb00006Service;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvBb00006;

/**
 * 报表6（BB00006）
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */

public class PgvBb00006Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 4460174835897608588L;
	// Service
	private IPgvBb00006Service bb00006Service;
	// Bean数组
	private ArrayList<PgvBb00006> operList;
	private Double txtJSBLFind;
	private Double txtSLFind;
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
		PgvBb00006 bb00006 = new PgvBb00006();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00006.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bb00006.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bb00006.setSl(ConvertUtil.toDouble(Constant.SL));
			bb00006.setJsbl(ConvertUtil.toDouble(Constant.JSBL));
			bb00006.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			operList = bb00006Service.LoadAll(bb00006);
			txtJSBLFind = ConvertUtil.toDouble(Constant.JSBL);
			txtSLFind = ConvertUtil.toDouble(Constant.SL);
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
		PgvBb00006 bb00006 = new PgvBb00006();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00006.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bb00006.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bb00006.setSl(txtSLFind);
			bb00006.setJsbl(txtJSBLFind);
			bb00006.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			operList = bb00006Service.LoadAll(bb00006);
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
	 * @return the bb00006Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvBb00006Service getBb00006Service() {
		return bb00006Service;
	}
	/**
	 * @param bb00006Service the bb00006Service to set
	 */
	public void setBb00006Service(IPgvBb00006Service bb00006Service) {
		this.bb00006Service = bb00006Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvBb00006> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvBb00006> operList) {
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
