package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvDb000013Service;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvDb000013;

/**
 * 免税设置对比分析（DB000013）
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */

public class PgvDb000013Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1803656313110202632L;
	// Service
	private IPgvDb000013Service db000013Service;
	// Bean数组
	private ArrayList<PgvDb000013> operList;
	private PgvDb000013 dbBean;
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
		PgvDb000013 db000013 = new PgvDb000013();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			db000013.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			db000013.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			db000013.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			dbBean = db000013Service.LoadAll(db000013);
			operList = dbBean.getDb000013List();
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
	 * @return the db000013Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvDb000013Service getDb000013Service() {
		return db000013Service;
	}
	/**
	 * @param db000013Service the db000013Service to set
	 */
	public void setDb000013Service(IPgvDb000013Service db000013Service) {
		this.db000013Service = db000013Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvDb000013> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvDb000013> operList) {
		this.operList = operList;
	}
	/**
	 * @return the dbBean
	 */
	public PgvDb000013 getDbBean() {
		return dbBean;
	}
	/**
	 * @param dbBean the dbBean to set
	 */
	public void setDbBean(PgvDb000013 dbBean) {
		this.dbBean = dbBean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
