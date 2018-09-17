package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00305yService;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00305;

/**
 * 成本，收益法数据操作状态
 * @author Lee
 * @version 1.0
 */

public class Pgt00305yAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 534677655993402384L;
	//Service
	private IPgt00305yService t00305yService;
	//View
	private ArrayList<Pgv00305> yList;
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	//Bean数组
	//查询条件
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String hidFlag;
	private String[] chkSel;
	// Detail
	private String FCID;
	private Pgv00305 v00305Bean;
	private Integer ddlSCZTFind;
	private SessionCtrl sessionCtrl = new SessionCtrl();

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
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

		Pgv00305 v00305 = new Pgv00305();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00305.setCd00301Swid(FormatUtil.toSearchLike(txtSWIDFind));
			v00305.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v00305.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00305.setPageIndex(pageIndex);
			v00305.setPageSize(getPageSize());
			v00305.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00305.setSczt(ddlSCZTFind);
			//执行查询
			yList = t00305yService.LoadAll(v00305);

			//分页设置
			if(null!=yList && yList.size()>0){
				total = yList.get(0).getRecordCount();
			}else{
				total = 0;
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
	 * 重新添加处理
	 * @return
	 * @throws Exception
	 */
	public String executeRTJ() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeRTJ() ********** start **********");
		}
		String strFcid = Constant.STRING_EMPTY;
		Pgv00305 v00305 = new Pgv00305();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00305.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00305.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00305.setSczt(ddlSCZTFind);
			switch (ConvertUtil.toInteger(hidFlag)) {
			case 1:// 选择重新添加
				for (Integer i = 0; i < chkSel.length; i++) {
					Pgv00305 e = new Pgv00305();
					e.setCd00302Fcid(chkSel[i]);
					v00305.getV00305List().add(e);
					strFcid = strFcid + chkSel[i] + Constant.STRING_COMMA;
				}
				// 执行重新添加
				if (t00305yService.GetExecRTJ(v00305)) {
					this.addActionMessage(getText(Constant.MSG_ADD_EXECR_OK, new String[] { Common.removeComma(strFcid) }));
				} else {
					this.addActionError(getText(Constant.MSG_ADD_EXECR_NG));
				}
				break;
			case 2:// 全部重新添加
				v00305.setCd00301Swid(FormatUtil.toSearchLike(txtSWIDFind));
				v00305.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
				// 执行全部重新添加
				if (t00305yService.GetExecRTJAll(v00305)) {
					this.addActionMessage(getText(Constant.MSG_ADD_EXECR_OK, new String[] { Constant.STRING_EMPTY }));
				} else {
					this.addActionError(getText(Constant.MSG_ADD_EXECR_NG));
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			LOG.error("executeRTJ()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeRTJ() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeRTJ() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 已添加数据[市场]的详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		v00305Bean = new Pgv00305();
		try {
			// 准备查询条件
			v00305Bean.setCd00302Fcid(ConvertUtil.encoding(FCID));
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 已添加数据[市场]的状态信息
	 * @return
	 * @throws Exception
	 */
	public String ztdetail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("ztdetail() ********** start **********");
		}
		Pgv00305 v00305 = new Pgv00305();
		v00305Bean = new Pgv00305();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00305.setCd00302Fcid(ConvertUtil.encoding(FCID));
			v00305.setPageIndex(ConvertUtil.toInteger(Constant.PAGE_FIRST));
			v00305.setPageSize(getPageSize());
			v00305.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00305.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00305.setSczt(ConvertUtil.toInteger(Constant.ZT_DEFAULT));
			// 执行查询
			yList = t00305yService.LoadAll(v00305);
			if (null != yList && yList.size() > 0) {
				v00305Bean = yList.get(0);
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("ztdetail() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 备份处理
	 * @return
	 * @throws Exception
	 */
	public String backup() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("backup() ********** start **********");
		}
		Pgv00305 v00305 = new Pgv00305();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00305.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00305.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00305.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			v00305.setCd00302Fcid(ConvertUtil.encoding(CheckUtil.chkTrim(FCID)));
			// 执行备份
			if (t00305yService.GetBackup(v00305)) {
				this.addActionMessage(getText(Constant.MSG_BACKUP_EXEC_OK, new String[] {}));
			} else {
				this.addActionError(getText(Constant.MSG_BACKUP_EXEC_NG));
			}
		} catch (Exception e) {
			LOG.error("backup()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("backup() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("backup() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** set and get ******************************/

	/**
	 * @return the t00305yService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00305yService getT00305yService() {
		return t00305yService;
	}
	/**
	 * @param t00305yService the t00305yService to set
	 */
	public void setT00305yService(IPgt00305yService t00305yService) {
		this.t00305yService = t00305yService;
	}
	/**
	 * @return the yList
	 */
	public ArrayList<Pgv00305> getyList() {
		return yList;
	}
	/**
	 * @param yList the yList to set
	 */
	public void setyList(ArrayList<Pgv00305> yList) {
		this.yList = yList;
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
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
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
	 * @return the v00305Bean
	 */
	public Pgv00305 getV00305Bean() {
		return v00305Bean;
	}
	/**
	 * @param v00305Bean the v00305Bean to set
	 */
	public void setV00305Bean(Pgv00305 v00305Bean) {
		this.v00305Bean = v00305Bean;
	}
	/**
	 * @return the ddlSCZTFind
	 */
	public Integer getDdlSCZTFind() {
		return ddlSCZTFind;
	}
	/**
	 * @param ddlSCZTFind the ddlSCZTFind to set
	 */
	public void setDdlSCZTFind(Integer ddlSCZTFind) {
		this.ddlSCZTFind = ddlSCZTFind;
	}
	/**
	 * @return the sessionCtrl
	 */
	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}
	/**
	 * @param sessionCtrl the sessionCtrl to set
	 */
	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
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
