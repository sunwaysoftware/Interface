package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvBb00002Service;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvBb00002;

/**
 * 报表2（BB00002）
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */

public class PgvBb00002Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 6810335287378886825L;
	// Service
	private IPgvBb00002Service bb00002Service;
	// Bean数组
	private ArrayList<PgvBb00002> operList;
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
		PgvBb00002 bb00002 = new PgvBb00002();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bb00002.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bb00002.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			operList = bb00002Service.LoadAll(bb00002);
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

	/*********************** setter and getter ******************************/

	/**
	 * @return the bb00002Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvBb00002Service getBb00002Service() {
		return bb00002Service;
	}
	/**
	 * @param bb00002Service the bb00002Service to set
	 */
	public void setBb00002Service(IPgvBb00002Service bb00002Service) {
		this.bb00002Service = bb00002Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvBb00002> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvBb00002> operList) {
		this.operList = operList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
