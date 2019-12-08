package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00052Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00052;
import com.sunway.vo.Pgv00052;

/**
 * 税收管辖与所在区域对应关系（PGT00052）
 * @author Lee
 * @version 1.0
 */

public class Pgt00052Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -5494842184120128032L;
	// Service
	private IPgt00052Service t00052Service;
	//Bean数组
	private ArrayList<Pgv00052> szqyList;
	//edit页面所需Bean
	private Pgt00052 t00052Bean;
	private String hidSZQY;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String SSGXId;
	private String SSGXNm;
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
	 * 根据登陆用户税收管辖取得所在区域对应关系
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}

		Pgv00052 v00052 = new Pgv00052();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 在Session中取得登陆用户的税收管辖信息
			v00052.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 根据税收管辖取得所在区域对应关系
			szqyList= t00052Service.LoadAll(v00052);
			setSSGXId(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			setSSGXNm(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGXNM));
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 根据登陆用户税收管辖取得所在区域对应关系
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}

		Pgv00052 v00052 = new Pgv00052();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 在Session中取得登陆用户的税收管辖信息
			v00052.setCd00001Ssgx(SSGXId);
			// 根据税收管辖取得所在区域对应关系
			szqyList= t00052Service.LoadAll(v00052);
			
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String update()throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t00052Bean = new Pgt00052();
		// 为BEAN 赋值
		t00052Bean.setCd00001Ssgx(SSGXId);
		t00052Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
		t00052Bean.setSzqy(Common.removeComma(hidSZQY));
		try {
			if (t00052Service.GetUpdateCommand(t00052Bean)) {
				//刷新所在区域
				sessionCtrl.Add(SessionCtrl.SESSION_LIST_SZQY, t00052Service.LoadSzqyBySsgx(t00052Bean.getCd00001Ssgx()));
				this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t00052Bean.getSzqy() }));
			} else {
				this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { t00052Bean.getSzqy() }));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			String[] msgs=e.getMessage().split("\n");
			this.addActionError(msgs[0]);

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}
	
	public String getHidSZQY() {
		return hidSZQY;
	}

	public void setHidSZQY(String hidSZQY) {
		this.hidSZQY = hidSZQY;
	}

	/*********************** set and get ******************************/
	/**
	 * @return the t00052Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00052Service getT00052Service() {
		return t00052Service;
	}

	/**
	 * @param t00052Service the t00052Service to set
	 */
	public void setT00052Service(IPgt00052Service t00052Service) {
		this.t00052Service = t00052Service;
	}

	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	/**
	 * @return the t00052Bean
	 */
	public Pgt00052 getT00052Bean() {
		return t00052Bean;
	}

	/**
	 * @param t00052Bean the t00052Bean to set
	 */
	public void setT00052Bean(Pgt00052 t00052Bean) {
		this.t00052Bean = t00052Bean;
	}

	/**
	 * @return the sSGXId
	 */
	public String getSSGXId() {
		return SSGXId;
	}

	/**
	 * @param sSGXId the sSGXId to set
	 */
	public void setSSGXId(String sSGXId) {
		SSGXId = sSGXId;
	}

	/**
	 * @return the sSGXNm
	 */
	public String getSSGXNm() {
		return SSGXNm;
	}

	/**
	 * @param sSGXNm the sSGXNm to set
	 */
	public void setSSGXNm(String sSGXNm) {
		SSGXNm = sSGXNm;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
