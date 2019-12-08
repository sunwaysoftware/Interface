package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvDb000011Service;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvDb000011;

/**
 * 行业对比分析（DB000011）
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */

public class PgvDb000011Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 7388291336289347166L;
	// Service
	private IPgvDb000011Service db000011Service;
	// Bean数组
	private ArrayList<PgvDb000011> operList;
	private PgvDb000011 dbBean;
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
		PgvDb000011 db000011 = new PgvDb000011();
		dbBean = new PgvDb000011();
		operList = new ArrayList<PgvDb000011>();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			db000011.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			db000011.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			db000011.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			dbBean = db000011Service.LoadAll(db000011);
			operList = dbBean.getDb000011List();
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
	 * @return the db000011Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvDb000011Service getDb000011Service() {
		return db000011Service;
	}
	/**
	 * @param db000011Service the db000011Service to set
	 */
	public void setDb000011Service(IPgvDb000011Service db000011Service) {
		this.db000011Service = db000011Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvDb000011> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvDb000011> operList) {
		this.operList = operList;
	}
	/**
	 * @return the dbBean
	 */
	public PgvDb000011 getDbBean() {
		return dbBean;
	}
	/**
	 * @param dbBean the dbBean to set
	 */
	public void setDbBean(PgvDb000011 dbBean) {
		this.dbBean = dbBean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
