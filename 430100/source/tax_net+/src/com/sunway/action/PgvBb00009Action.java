package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvBb00009Service;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvBb00009;

/**
 * 报表9（BB00009）
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */

public class PgvBb00009Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 2429471318332232286L;
	// Service
	private IPgvBb00009Service bb00009Service;
	// Bean数组
	private ArrayList<PgvBb00009> operList;
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
		PgvBb00009 bb00009 = new PgvBb00009();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00009.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bb00009.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bb00009.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			operList = bb00009Service.LoadAll(bb00009);
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
	 * @return the bb00009Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvBb00009Service getBb00009Service() {
		return bb00009Service;
	}
	/**
	 * @param bb00009Service the bb00009Service to set
	 */
	public void setBb00009Service(IPgvBb00009Service bb00009Service) {
		this.bb00009Service = bb00009Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvBb00009> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvBb00009> operList) {
		this.operList = operList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
