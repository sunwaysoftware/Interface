package com.sunway.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ICz00042Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Cz00042;

/**
 * 税率测算（CZ00042）
 * 
 * @author Lee
 * @version 1.0
 */
public class Cz00042Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -3018403119798625985L;
	// Service
	private ICz00042Service cz00042Service;
	// Bean数组
	private Cz00042 cz00042Bean;
	// 检索条件
	private String txtQDFSFind;
	private String txtSYQLXFind;
	private String txtMSSZFind;
	private Double txtJSBL;
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
		try {
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
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		Cz00042 cz00042 = new Cz00042();
		cz00042Bean = new Cz00042();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			cz00042.setQdfs(CheckUtil.chkTrim(txtQDFSFind));
			cz00042.setSyqlx(CheckUtil.chkTrim(txtSYQLXFind));
			cz00042.setMssz(CheckUtil.chkTrim(txtMSSZFind));
			cz00042.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			cz00042.setPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			// 执行查询
			cz00042Bean = cz00042Service.LoadAll(cz00042);
			cz00042Bean.setFctdhj(cz00042Bean.getFcse() + cz00042Bean.getTdse());
			Double sl = (cz00042Bean.getFctdhj() / (txtJSBL / 100) / cz00042Bean
					.getPgjg()) * 100;
			cz00042Bean.setSl(sl);
			cz00042Bean.setJsbl(txtJSBL);
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
	 * @return the cz00042Service
	 */
	@JSON(deserialize = false, serialize = false)
	public ICz00042Service getCz00042Service() {
		return cz00042Service;
	}
	/**
	 * @param cz00042Service the cz00042Service to set
	 */
	public void setCz00042Service(ICz00042Service cz00042Service) {
		this.cz00042Service = cz00042Service;
	}
	/**
	 * @return the cz00042Bean
	 */
	public Cz00042 getCz00042Bean() {
		return cz00042Bean;
	}
	/**
	 * @param cz00042Bean the cz00042Bean to set
	 */
	public void setCz00042Bean(Cz00042 cz00042Bean) {
		this.cz00042Bean = cz00042Bean;
	}
	/**
	 * @return the txtQDFSFind
	 */
	public String getTxtQDFSFind() {
		return txtQDFSFind;
	}
	/**
	 * @param txtQDFSFind the txtQDFSFind to set
	 */
	public void setTxtQDFSFind(String txtQDFSFind) {
		this.txtQDFSFind = txtQDFSFind;
	}
	/**
	 * @return the txtSYQLXFind
	 */
	public String getTxtSYQLXFind() {
		return txtSYQLXFind;
	}
	/**
	 * @param txtSYQLXFind the txtSYQLXFind to set
	 */
	public void setTxtSYQLXFind(String txtSYQLXFind) {
		this.txtSYQLXFind = txtSYQLXFind;
	}
	/**
	 * @return the txtMSSZFind
	 */
	public String getTxtMSSZFind() {
		return txtMSSZFind;
	}
	/**
	 * @param txtMSSZFind the txtMSSZFind to set
	 */
	public void setTxtMSSZFind(String txtMSSZFind) {
		this.txtMSSZFind = txtMSSZFind;
	}
	/**
	 * @return the txtJSBL
	 */
	public Double getTxtJSBL() {
		return txtJSBL;
	}
	/**
	 * @param txtJSBL the txtJSBL to set
	 */
	public void setTxtJSBL(Double txtJSBL) {
		this.txtJSBL = txtJSBL;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}
}
