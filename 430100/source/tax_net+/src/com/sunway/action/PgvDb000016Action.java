package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvDb000016Service;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.PgvDb000016;

/**
 * 现行税率免税设置对比分析
 * @category 数据对比分析
 * @author Lee
 * @version 1.0
 */

public class PgvDb000016Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3948283753803160653L;
	// Service
	private IPgvDb000016Service db000016Service;
	// Bean数组
	private ArrayList<PgvDb000016> operList;
	private Double txtJSBLFind;
	private Double txtSLFind;
	private PgvDb000016 dbBean;
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
		PgvDb000016 db000016 = new PgvDb000016();
		dbBean = new PgvDb000016();
		operList = new ArrayList<PgvDb000016>();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			db000016.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			db000016.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			db000016.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			db000016.setJsbl(ConvertUtil.toDouble(Constant.JSBL));
			db000016.setSl(ConvertUtil.toDouble(Constant.SL));
			if (db000016Service.GetInsertCommand(db000016)) {
				dbBean = db000016Service.LoadAll(db000016);
				operList = dbBean.getDb000016List();
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
		PgvDb000016 db000016 = new PgvDb000016();
		dbBean = new PgvDb000016();
		operList = new ArrayList<PgvDb000016>();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			db000016.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			db000016.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			db000016.setJsbl(txtJSBLFind);
			db000016.setSl(txtSLFind);
			dbBean = db000016Service.LoadAll(db000016);
			operList = dbBean.getDb000016List();
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
	 * @return the db000016Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgvDb000016Service getDb000016Service() {
		return db000016Service;
	}
	/**
	 * @param db000016Service the db000016Service to set
	 */
	public void setDb000016Service(IPgvDb000016Service db000016Service) {
		this.db000016Service = db000016Service;
	}
	/**
	 * @return the operList
	 */
	public ArrayList<PgvDb000016> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<PgvDb000016> operList) {
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
	public PgvDb000016 getDbBean() {
		return dbBean;
	}
	/**
	 * @param dbBean the dbBean to set
	 */
	public void setDbBean(PgvDb000016 dbBean) {
		this.dbBean = dbBean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
