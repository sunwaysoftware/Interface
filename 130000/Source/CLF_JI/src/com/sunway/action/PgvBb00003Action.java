package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvBb00003Service;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvBb00003;

/**
 * 报表3（BB00003）
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */

public class PgvBb00003Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 4184568264962321700L;
	// Service
	private IPgvBb00003Service bb00003Service;
	// Bean数组
	private ArrayList<PgvBb00003> operList;
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
		PgvBb00003 bb00003 = new PgvBb00003();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00003.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bb00003.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bb00003.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			operList = bb00003Service.LoadAll(bb00003);
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
	 * @return the bb00003Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvBb00003Service getBb00003Service() {
		return bb00003Service;
	}
	/**
	 * @param bb00003Service the bb00003Service to set
	 */
	public void setBb00003Service(IPgvBb00003Service bb00003Service) {
		this.bb00003Service = bb00003Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvBb00003> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvBb00003> operList) {
		this.operList = operList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
