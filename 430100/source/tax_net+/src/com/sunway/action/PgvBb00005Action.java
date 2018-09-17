package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvBb00005Service;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvBb00005;

/**
 * 报表5（BB00005）
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */

public class PgvBb00005Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3972843529337821558L;
	// Service
	private IPgvBb00005Service bb00005Service;
	// Bean数组
	private ArrayList<PgvBb00005> operList;
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
		PgvBb00005 bb00005 = new PgvBb00005();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00005.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bb00005.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bb00005.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			operList = bb00005Service.LoadAll(bb00005);
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
	 * @return the bb00005Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvBb00005Service getBb00005Service() {
		return bb00005Service;
	}
	/**
	 * @param bb00005Service the bb00005Service to set
	 */
	public void setBb00005Service(IPgvBb00005Service bb00005Service) {
		this.bb00005Service = bb00005Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvBb00005> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvBb00005> operList) {
		this.operList = operList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
