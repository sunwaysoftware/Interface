package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvBb00010Service;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvBb00010;

/**
 * 报表10（BB00010）
 * @category 统计报表
 * @author Lee
 * @version 1.0
 */

public class PgvBb00010Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -4340489565269140672L;
	// Service
	private IPgvBb00010Service bb00010Service;
	// Bean数组
	private ArrayList<PgvBb00010> operList;
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
		PgvBb00010 bb00010 = new PgvBb00010();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			bb00010.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bb00010.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bb00010.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			operList = bb00010Service.LoadAll(bb00010);
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
	 * @return the bb00010Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvBb00010Service getBb00010Service() {
		return bb00010Service;
	}
	/**
	 * @param bb00010Service the bb00010Service to set
	 */
	public void setBb00010Service(IPgvBb00010Service bb00010Service) {
		this.bb00010Service = bb00010Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvBb00010> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvBb00010> operList) {
		this.operList = operList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
