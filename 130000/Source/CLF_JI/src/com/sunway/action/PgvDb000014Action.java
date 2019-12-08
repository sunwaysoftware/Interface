package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvDb000014Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvDb000014;

/**
 * 现行税率行业对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */

public class PgvDb000014Action extends ActionSupport implements SessionAware  {

	private static final long serialVersionUID = 7018453096963896685L;
	// Service
	private IPgvDb000014Service db000014Service;
	// Bean数组
	private ArrayList<PgvDb000014> operList;
	private Double txtJSBLFind;
	private Double txtSLFind;
	private PgvDb000014 dbBean;
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
		PgvDb000014 db000014 = new PgvDb000014();
		dbBean = new PgvDb000014();
		operList = new ArrayList<PgvDb000014>();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			db000014.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			db000014.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			db000014.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			db000014.setJsbl(Common.convertToDouble(Constant.JSBL));
			db000014.setSl(Common.convertToDouble(Constant.SL));
			if (db000014Service.GetInsertCommand(db000014)) {
				dbBean = db000014Service.LoadAll(db000014);
				operList = dbBean.getDb000014List();
			} else {
				this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] {}));
			}
			txtJSBLFind = Common.convertToDouble(Constant.JSBL);
			txtSLFind = Common.convertToDouble(Constant.SL);
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

	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		PgvDb000014 db000014 = new PgvDb000014();
		dbBean = new PgvDb000014();
		operList = new ArrayList<PgvDb000014>();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			db000014.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			db000014.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			db000014.setJsbl(txtJSBLFind);
			db000014.setSl(txtSLFind);
			dbBean = db000014Service.LoadAll(db000014);
			operList = dbBean.getDb000014List();
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** setter and getter ******************************/

	/**
	 * @return the db000014Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvDb000014Service getDb000014Service() {
		return db000014Service;
	}
	/**
	 * @param db000014Service the db000014Service to set
	 */
	public void setDb000014Service(IPgvDb000014Service db000014Service) {
		this.db000014Service = db000014Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvDb000014> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvDb000014> operList) {
		this.operList = operList;
	}
	/**
	 * @return the txtJSBLFind
	 */
	public Double getTxtJSBLFind() {
		return txtJSBLFind;
	}
	/**
	 * @param txtJSBLFind the txtJSBLFind to set
	 */
	public void setTxtJSBLFind(Double txtJSBLFind) {
		this.txtJSBLFind = txtJSBLFind;
	}
	/**
	 * @return the txtSLFind
	 */
	public Double getTxtSLFind() {
		return txtSLFind;
	}
	/**
	 * @param txtSLFind the txtSLFind to set
	 */
	public void setTxtSLFind(Double txtSLFind) {
		this.txtSLFind = txtSLFind;
	}
	/**
	 * @return the dbBean
	 */
	public PgvDb000014 getDbBean() {
		return dbBean;
	}
	/**
	 * @param dbBean the dbBean to set
	 */
	public void setDbBean(PgvDb000014 dbBean) {
		this.dbBean = dbBean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
