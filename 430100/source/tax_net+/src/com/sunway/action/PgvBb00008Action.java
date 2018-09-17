package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvBb00008Service;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvBb00008;

/**
 * 报表8（BB00008）
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */

public class PgvBb00008Action extends ActionSupport implements SessionAware  {

	private static final long serialVersionUID = -1503658059334050446L;
	// Service
	private IPgvBb00008Service bb00008Service;
	// Bean数组
	private ArrayList<PgvBb00008> operList;
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
		PgvBb00008 bb00008 = new PgvBb00008();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00008.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bb00008.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bb00008.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			operList = bb00008Service.LoadAll(bb00008);
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
	 * @return the bb00008Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvBb00008Service getBb00008Service() {
		return bb00008Service;
	}
	/**
	 * @param bb00008Service the bb00008Service to set
	 */
	public void setBb00008Service(IPgvBb00008Service bb00008Service) {
		this.bb00008Service = bb00008Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvBb00008> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvBb00008> operList) {
		this.operList = operList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
