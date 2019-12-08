package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00305wService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00302;

/**
 * 市场法数据操作状态(没有添加到操作列表的数据)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt00305wAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 5781253783041249508L;
	//Service
	private IPgt00305wService t00305wService;
	//View
	private ArrayList<Pgv00302> wList;
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	//查询条件
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String hidFlag;
	private String[] chkSel;
	// Detail
	private String FCID;
	private Pgv00302 v00302Bean;
	private SessionCtrl sessionCtrl = new SessionCtrl();

	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 查询状态处理(没有添加到操作列表的数据)
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		Pgv00302 v00302 = new Pgv00302();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00302.setCd00301Swid(Common.getSearchLike(txtSWIDFind));
			v00302.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00302.setPageIndex(pageIndex);
			v00302.setPageSize(getPageSize());
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			wList = t00305wService.LoadAll(v00302);
			// 分页设置
			if (null != wList && wList.size() > 0) {
				rowCount = wList.get(0).getRecordCount();
			} else {
				rowCount = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 添加处理
	 * @return
	 * @throws Exception
	 */
	public String executeTJ() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeTJ() ********** start **********");
		}
		String strFcid = Constant.STRING_EMPTY;
		Pgv00302 v00302 = new Pgv00302();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			switch (Common.convertToInteger(hidFlag)) {
			case 1:// 选择添加
				for (Integer i = 0; i < chkSel.length; i++) {
					Pgv00302 e = new Pgv00302();
					e.setFcid(chkSel[i]);
					v00302.getV00302List().add(e);
					strFcid = strFcid + chkSel[i] + Constant.STRING_COMMA;
				}
				// 执行添加
				if (t00305wService.GetExecTJ(v00302)) {
					this.addActionMessage(getText(Constant.MSG_ADD_EXEC_OK, new String[] { Common.removeComma(strFcid) }));
				} else {
					this.addActionError(getText(Constant.MSG_ADD_EXEC_NG));
				}
				break;
			case 2:// 全部添加
				v00302.setCd00301Swid(Common.getSearchLike(txtSWIDFind));
				v00302.setNsrmc(Common.getSearchLike(txtNSRMCFind));
				// 执行全部添加
				if (t00305wService.GetExecTJAll(v00302)) {
					this.addActionMessage(getText(Constant.MSG_ADD_EXEC_OK, new String[] { Constant.STRING_EMPTY }));
				} else {
					this.addActionError(getText(Constant.MSG_ADD_EXEC_NG));
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			LOG.error("executeTJ()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeTJ() ********** end **********");
			}
			return INPUT;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeTJ() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 已添加数据[成本、收益法]的详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00302 v00302 = new Pgv00302();
		v00302Bean = new Pgv00302();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00302.setFcid(Common.trim(FCID));
			v00302.setPageIndex(Common.convertToInteger(Constant.PAGE_FIRST));
			v00302.setPageSize(getPageSize());
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			// 执行查询
			wList = t00305wService.LoadAll(v00302);
			if (null != wList && wList.size() > 0) {
				v00302Bean = wList.get(0);
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** set and get ******************************/

	/**
	 * @return the t00305wService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00305wService getT00305wService() {
		return t00305wService;
	}
	/**
	 * @param t00305wService the t00305wService to set
	 */
	public void setT00305wService(IPgt00305wService t00305wService) {
		this.t00305wService = t00305wService;
	}
	/**
	 * @return the wList
	 */
	public ArrayList<Pgv00302> getwList() {
		return wList;
	}
	/**
	 * @param wList the wList to set
	 */
	public void setwList(ArrayList<Pgv00302> wList) {
		this.wList = wList;
	}
	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}
	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	/**
	 * @return the rowCount
	 */
	public Integer getRowCount() {
		return rowCount;
	}
	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	/**
	 * @return the txtSWIDFind
	 */
	public String getTxtSWIDFind() {
		return txtSWIDFind;
	}
	/**
	 * @param txtSWIDFind the txtSWIDFind to set
	 */
	public void setTxtSWIDFind(String txtSWIDFind) {
		this.txtSWIDFind = txtSWIDFind;
	}
	/**
	 * @return the txtNSRMCFind
	 */
	public String getTxtNSRMCFind() {
		return txtNSRMCFind;
	}
	/**
	 * @param txtNSRMCFind the txtNSRMCFind to set
	 */
	public void setTxtNSRMCFind(String txtNSRMCFind) {
		this.txtNSRMCFind = txtNSRMCFind;
	}
	/**
	 * @return the hidFlag
	 */
	public String getHidFlag() {
		return hidFlag;
	}
	/**
	 * @param hidFlag the hidFlag to set
	 */
	public void setHidFlag(String hidFlag) {
		this.hidFlag = hidFlag;
	}
	/**
	 * @return the chkSel
	 */
	public String[] getChkSel() {
		return chkSel;
	}
	/**
	 * @param chkSel the chkSel to set
	 */
	public void setChkSel(String[] chkSel) {
		this.chkSel = chkSel;
	}
	/**
	 * @return the fCID
	 */
	public String getFCID() {
		return FCID;
	}
	/**
	 * @param fCID the fCID to set
	 */
	public void setFCID(String fCID) {
		FCID = fCID;
	}
	/**
	 * @return the v00302Bean
	 */
	public Pgv00302 getV00302Bean() {
		return v00302Bean;
	}
	/**
	 * @param v00302Bean the v00302Bean to set
	 */
	public void setV00302Bean(Pgv00302 v00302Bean) {
		this.v00302Bean = v00302Bean;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
