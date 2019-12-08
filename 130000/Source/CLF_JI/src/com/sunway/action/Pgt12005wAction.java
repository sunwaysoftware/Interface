package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12005wService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12001;

/**
 * 成本、收益法数据操作状态(没有添加到操作列表的数据)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt12005wAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 5052655431945644543L;
	//Service
	private IPgt12005wService t12005wService;
	//View
	private ArrayList<Pgv12001> wList;
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//查询条件
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String hidFlag;
	private String[] chkSel;
	// Detail
	private String SWID;
	private Pgv12001 v12001Bean;
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
		Pgv12001 v12001 = new Pgv12001();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12001.setSwid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12001.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setPageIndex(pageIndex);
			v12001.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12001.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			wList = t12005wService.LoadAll(v12001);
			// 分页设置
			if (null != wList && wList.size() > 0) {
				rowCount = wList.get(0).getRecordCount();
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
	 * 添加处理
	 * @return
	 * @throws Exception
	 */
	public String executeTJ() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeTJ() ********** start **********");
		}
		String strSwid = Constant.STRING_EMPTY;
		Pgv12001 v12001 = new Pgv12001();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			switch (Common.convertToInteger(hidFlag)) {
			case 1:// 选择添加
				for (Integer i = 0; i < chkSel.length; i++) {
					Pgv12001 e = new Pgv12001();
					e.setSwid(chkSel[i]);
					v12001.getV12001List().add(e);
					strSwid = strSwid + chkSel[i] + Constant.STRING_COMMA;
				}
				// 执行添加
				if (t12005wService.GetExecTJ(v12001)) {
					this.addActionMessage(getText(Constant.MSG_ADD_EXEC_OK, new String[] { Common.removeComma(strSwid) }));
				} else {
					this.addActionError(getText(Constant.MSG_ADD_EXEC_NG));
				}
				break;
			case 2:// 全部添加
				v12001.setSwid(Common.getSearchLike(txtSWIDFind));
				v12001.setNsrmc(Common.getSearchLike(txtNSRMCFind));
				// 执行全部添加
				if (t12005wService.GetExecTJAll(v12001)) {
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
	 * 未添加数据[成本、收益法]的详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}

		Pgv12001 v12001 = new Pgv12001();
		v12001Bean = new Pgv12001();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12001.setSwid(Common.trim(SWID));
			v12001.setPageIndex(Common.convertToInteger(Constant.PAGE_FIRST));
			v12001.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12001.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			// 执行查询
			wList = t12005wService.LoadAll(v12001);
			if (null != wList && wList.size() > 0) {
				v12001Bean = wList.get(0);
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
	 * @return the t12005wService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12005wService getT12005wService() {
		return t12005wService;
	}
	/**
	 * @param t12005wService the t12005wService to set
	 */
	public void setT12005wService(IPgt12005wService t12005wService) {
		this.t12005wService = t12005wService;
	}
	/**
	 * @return the wList
	 */
	public ArrayList<Pgv12001> getwList() {
		return wList;
	}
	/**
	 * @param wList the wList to set
	 */
	public void setwList(ArrayList<Pgv12001> wList) {
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
	 * @return the v12001Bean
	 */
	public Pgv12001 getV12001Bean() {
		return v12001Bean;
	}
	/**
	 * @param v12001Bean the v12001Bean to set
	 */
	public void setV12001Bean(Pgv12001 v12001Bean) {
		this.v12001Bean = v12001Bean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
