package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvDb000015Service;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvDb000015;

/**
 * 现行税率经济类型对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */

public class PgvDb000015Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -2905275231143650744L;
	// Service
	private IPgvDb000015Service db000015Service;
	// Bean数组
	private ArrayList<PgvDb000015> operList;
	private Double txtJSBLFind;
	private Double txtSLFind;
	private PgvDb000015 dbBean;
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
		PgvDb000015 db000015 = new PgvDb000015();
		dbBean = new PgvDb000015();
		operList = new ArrayList<PgvDb000015>();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			db000015.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			db000015.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			db000015.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			db000015.setJsbl(ConvertUtil.toDouble(Constant.JSBL));
			db000015.setSl(ConvertUtil.toDouble(Constant.SL));
			if (db000015Service.GetInsertCommand(db000015)) {
				dbBean = db000015Service.LoadAll(db000015);
				operList = dbBean.getDb000015List();
			} else {
				this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] {}));
			}
			txtJSBLFind = ConvertUtil.toDouble(Constant.JSBL);
			txtSLFind = ConvertUtil.toDouble(Constant.SL);
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
		PgvDb000015 db000015 = new PgvDb000015();
		dbBean = new PgvDb000015();
		operList = new ArrayList<PgvDb000015>();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			db000015.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			db000015.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			db000015.setJsbl(txtJSBLFind);
			db000015.setSl(txtSLFind);
			dbBean = db000015Service.LoadAll(db000015);
			operList = dbBean.getDb000015List();
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
	 * @return the db000015Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvDb000015Service getDb000015Service() {
		return db000015Service;
	}
	/**
	 * @param db000015Service the db000015Service to set
	 */
	public void setDb000015Service(IPgvDb000015Service db000015Service) {
		this.db000015Service = db000015Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvDb000015> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvDb000015> operList) {
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
	public PgvDb000015 getDbBean() {
		return dbBean;
	}
	/**
	 * @param dbBean the dbBean to set
	 */
	public void setDbBean(PgvDb000015 dbBean) {
		this.dbBean = dbBean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
