package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvBb00001Service;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvBb00001;

/**
 * 报表1（BB00001）
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */

public class PgvBb00001Action extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -5808601009107995352L;
	// Service
	private IPgvBb00001Service bb00001Service;
	// Bean数组
	private ArrayList<PgvBb00001> operList;
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
		PgvBb00001 bb00001 = new PgvBb00001();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00001.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bb00001.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			operList = bb00001Service.LoadAll(bb00001);
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
	 * @return the bb00001Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvBb00001Service getBb00001Service() {
		return bb00001Service;
	}
	/**
	 * @param bb00001Service the bb00001Service to set
	 */
	public void setBb00001Service(IPgvBb00001Service bb00001Service) {
		this.bb00001Service = bb00001Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvBb00001> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvBb00001> operList) {
		this.operList = operList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
