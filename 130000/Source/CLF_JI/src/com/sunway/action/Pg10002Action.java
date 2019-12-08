/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPg10002Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv10031;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 已評估[成本法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg10002Action extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = -5178492082501522751L;
	private IPg10002Service pg10002Service;
	private ArrayList<Pgv10031> tabList;
	// VIEW
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String hidFlag;
	private String chkSel;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public void validateQuery() {
		this.clearErrorsAndMessages();
	}
	
	/**
	 * 查询处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv10031 v10031 = new Pgv10031();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v10031.setCd12001Swid(Common.getSearchLike(txtSWIDFind));
			v10031.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v10031.setPageIndex(pageIndex);
			v10031.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v10031.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v10031.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = pg10002Service.LoadPgOK(v10031);
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error("query()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;	
	}	
	
	/**
	 * 重新評估
	 * @return
	 * @throws Exception
	 */
	public String executePgAgain() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeShAgain() ********** start **********");
		}
		
		Pgv12001 v12001 = new Pgv12001();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v12001.setPgCzr(sessionCtrl.getUserId());
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setSysPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v12001.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));		
			switch (Common.convertToInteger(hidFlag)) {
			case 1://選擇重新評估
				v12001.setSwid(chkSel);
				//執行重新評估
				if(pg10002Service.GetExecPgAgain(v12001))
					this.addActionMessage(getText(Constant.MSG_PG_EXECR_OK, new String[]{chkSel}));
				else
					this.addActionError(getText(Constant.MSG_PG_EXECR_NG));
				break;
			case 2://全部重新評估
				//執行重新評估
				v12001.setSwid(Common.getSearchLike(txtSWIDFind));
				v12001.setNsrmc(Common.getSearchLike(txtNSRMCFind));
				if(pg10002Service.GetExecPgAgainAll(v12001))
					this.addActionMessage(getText(Constant.MSG_PG_EXECR_OK, new String[]{Constant.STRING_EMPTY}));
				else
					this.addActionError(getText(Constant.MSG_PG_EXECR_NG));
				break;
			default:
				break;
			}		
		} catch (Exception e) {
			LOG.error("executeShAgain()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeShAgain() ********** end **********");
			}			
			return INPUT;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeShAgain() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @param pg10002Service the pg10002Service to set
	 */
	public void setPg10002Service(IPg10002Service pg10002Service) {
		this.pg10002Service = pg10002Service;
	}
	/**
	 * @return the pg10002Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPg10002Service getPg10002Service() {
		return pg10002Service;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv10031> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv10031> tabList) {
		this.tabList = tabList;
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
	public String getChkSel() {
		return chkSel;
	}

	/**
	 * @param chkSel the chkSel to set
	 */
	public void setChkSel(String chkSel) {
		this.chkSel = chkSel;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
