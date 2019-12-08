package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvBb00004Service;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvBb00004;

/**
 * 报表4（BB00004）
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */

public class PgvBb00004Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -8817845760987561847L;
	// Service
	private IPgvBb00004Service bb00004Service;
	// Bean数组
	private ArrayList<PgvBb00004> operList;
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
		PgvBb00004 bb00004 = new PgvBb00004();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00004.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bb00004.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bb00004.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			operList = bb00004Service.LoadAll(bb00004);
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
	 * @return the bb00004Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvBb00004Service getBb00004Service() {
		return bb00004Service;
	}
	/**
	 * @param bb00004Service the bb00004Service to set
	 */
	public void setBb00004Service(IPgvBb00004Service bb00004Service) {
		this.bb00004Service = bb00004Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvBb00004> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvBb00004> operList) {
		this.operList = operList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
