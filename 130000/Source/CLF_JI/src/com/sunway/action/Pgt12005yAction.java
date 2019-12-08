package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12005yService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12005;

/**
 * 成本，收益法数据操作状态
 * @author Lee
 * @version 1.0
 */

public class Pgt12005yAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 6637712576254600730L;
	// Service
	private IPgt12005yService t12005yService;
	// View
	private ArrayList<Pgv12005> yList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	// 查询条件
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String hidFlag;
	private String[] chkSel;
	// Detail
	private String SWID;
	private Pgv12005 v12005Bean;
	private Integer ddlCBZTFind;
	private Integer ddlSYZTFind;
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
		Pgv12005 v12005 = new Pgv12005();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12005.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12005.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12005.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12005.setPageIndex(pageIndex);
			v12005.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12005.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12005.setCbzt(ddlCBZTFind);
			v12005.setSyzt(ddlSYZTFind);
			// 执行查询
			yList = t12005yService.LoadAll(v12005);
			// 分页设置
			if (null != yList && yList.size() > 0) {
				rowCount = yList.get(0).getRecordCount();
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
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
		String strSwid = Constant.STRING_EMPTY;
		Pgv12005 v12005 = new Pgv12005();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v12005.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12005.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12005.setCbzt(ddlCBZTFind);
			v12005.setSyzt(ddlSYZTFind);
			switch (Common.convertToInteger(hidFlag)) {
			case 1:// 选择重新添加
				for (Integer i = 0; i < chkSel.length; i++) {
					Pgv12005 e = new Pgv12005();
					e.setCd12001Swid(chkSel[i]);
					v12005.getV12005List().add(e);
					strSwid = strSwid + chkSel[i] + Constant.STRING_COMMA;
				}
				// 执行重新添加
				if (t12005yService.GetExecRTJ(v12005)) {
					this.addActionMessage(getText(Constant.MSG_ADD_EXECR_OK, new String[] { Common.removeComma(strSwid) }));
				} else {
					this.addActionError(getText(Constant.MSG_ADD_EXECR_NG));
				}
				break;
			case 2:// 全部重新添加
				v12005.setCd12001Swid(Common.getSearchLike(txtSWIDFind));
				v12005.setNsrmc(Common.getSearchLike(txtNSRMCFind));
				// 执行全部重新添加
				if (t12005yService.GetExecRTJAll(v12005)) {
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
	 * 已添加数据[成本、收益法]的详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		v12005Bean = new Pgv12005();
		try {
			// 准备查询条件
			v12005Bean.setSwid(Common.convertEncoding(SWID));
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
	 * 已添加数据[成本、收益法]的状态信息
	 * @return
	 * @throws Exception
	 */
	public String ztdetail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("ztdetail() ********** start **********");
		}
		Pgv12005 v12005 = new Pgv12005();
		v12005Bean = new Pgv12005();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12005.setCd12001Swid(Common.convertEncoding(SWID));
			v12005.setPageIndex(Common.convertToInteger(Constant.PAGE_FIRST));
			v12005.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12005.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12005.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12005.setCbzt(Common.convertToInteger(Constant.ZT_DEFAULT));
			v12005.setSyzt(Common.convertToInteger(Constant.ZT_DEFAULT));
			// 执行查询
			yList = t12005yService.LoadAll(v12005);
			if (null != yList && yList.size() > 0) {
				v12005Bean = yList.get(0);
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
		Pgv12005 v12005 = new Pgv12005();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v12005.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12005.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12005.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			v12005.setCd12001Swid(Common.convertEncoding(Common.trim(SWID)));
			// 执行备份
			if (t12005yService.GetBackup(v12005)) {
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
	 * @return the t12005yService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12005yService getT12005yService() {
		return t12005yService;
	}

	/**
	 * @param t12005yService the t12005yService to set
	 */
	public void setT12005yService(IPgt12005yService t12005yService) {
		this.t12005yService = t12005yService;
	}

	/**
	 * @return the yList
	 */
	public ArrayList<Pgv12005> getyList() {
		return yList;
	}

	/**
	 * @param yList the yList to set
	 */
	public void setyList(ArrayList<Pgv12005> yList) {
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
	 * @return the pageCount
	 */
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
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
	 * @return the sWID
	 */
	public String getSWID() {
		return SWID;
	}
	/**
	 * @param sWID the sWID to set
	 */
	public void setSWID(String sWID) {
		SWID = sWID;
	}
	/**
	 * @return the v12005Bean
	 */
	public Pgv12005 getV12005Bean() {
		return v12005Bean;
	}
	/**
	 * @param v12005Bean the v12005Bean to set
	 */
	public void setV12005Bean(Pgv12005 v12005Bean) {
		this.v12005Bean = v12005Bean;
	}
	/**
	 * @return the ddlCBZTFind
	 */
	public Integer getDdlCBZTFind() {
		return ddlCBZTFind;
	}
	/**
	 * @param ddlCBZTFind the ddlCBZTFind to set
	 */
	public void setDdlCBZTFind(Integer ddlCBZTFind) {
		this.ddlCBZTFind = ddlCBZTFind;
	}
	/**
	 * @return the ddlSYZTFind
	 */
	public Integer getDdlSYZTFind() {
		return ddlSYZTFind;
	}
	/**
	 * @param ddlSYZTFind the ddlSYZTFind to set
	 */
	public void setDdlSYZTFind(Integer ddlSYZTFind) {
		this.ddlSYZTFind = ddlSYZTFind;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
