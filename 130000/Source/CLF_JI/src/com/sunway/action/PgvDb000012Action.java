package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvDb000012Service;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvDb000012;

/**
 * 经济类型对比分析（DB000012）
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */

public class PgvDb000012Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 6241994664848491200L;
	// Service
	private IPgvDb000012Service db000012Service;
	// Bean数组
	private ArrayList<PgvDb000012> operList;
	private PgvDb000012 dbBean;
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
		PgvDb000012 db000012 = new PgvDb000012();
		dbBean = new PgvDb000012();
		operList = new ArrayList<PgvDb000012>();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			db000012.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			db000012.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			db000012.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			dbBean = db000012Service.LoadAll(db000012);
			operList = dbBean.getDb000012List();
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
	 * @return the db000012Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvDb000012Service getDb000012Service() {
		return db000012Service;
	}
	/**
	 * @param db000012Service the db000012Service to set
	 */
	public void setDb000012Service(IPgvDb000012Service db000012Service) {
		this.db000012Service = db000012Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvDb000012> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvDb000012> operList) {
		this.operList = operList;
	}
	/**
	 * @return the dbBean
	 */
	public PgvDb000012 getDbBean() {
		return dbBean;
	}
	/**
	 * @param dbBean the dbBean to set
	 */
	public void setDbBean(PgvDb000012 dbBean) {
		this.dbBean = dbBean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
