/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ISh20002Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 收益法全部重新审核
 * @author Andy.Gao
 * @category 數據審核[收益法]
 *
 */
public class Sh20002Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1717869355587367661L;
	private ISh20002Service sh20002Service;
	private ArrayList<Pgv12001> tabList;
	private String shFlag;
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

		Pgv12001 v12001 = new Pgv12001();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v12001.setSwid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12001.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12001.setPageIndex(pageIndex);
			v12001.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = sh20002Service.LoadShOK(v12001);
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
	 * 重新审核前的验证
	 */
	public void validateExecuteShAgain(){
		this.clearErrorsAndMessages();
		if("1".equals(hidFlag) && Common.isNullOrEmpty(chkSel) )
			this.addActionError("请选择要参与重审核的数据");
	}
	
	/**
	 * 重新審核
	 * @return
	 * @throws Exception
	 */
	public String executeShAgain() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeShAgain() ********** start **********");
		}
		
		Pgv12001 v12001 = new Pgv12001();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v12001.setShCzr(sessionCtrl.getUserId());
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12001.setSysPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			switch (Common.convertToInteger(hidFlag)) {
			case 1://選擇重新審核
				v12001.setSwid(chkSel);
				//執行重新審核
				if(sh20002Service.GetExecShAgain(v12001))
					this.addActionMessage(getText(Constant.MSG_AUDIT_EXECR_OK, new String[]{chkSel}));
				else
					this.addActionError(getText(Constant.MSG_AUDIT_EXECR_NG));
				break;
			case 2://全部重新審核
				//執行重新審核
				v12001.setSwid(Common.getSearchLike(txtSWIDFind));
				v12001.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
				if(sh20002Service.GetExecShAgainAll(v12001))
					this.addActionMessage(getText(Constant.MSG_AUDIT_EXECR_OK, new String[]{Constant.STRING_EMPTY}));
				else
					this.addActionError(getText(Constant.MSG_AUDIT_EXECR_NG));
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
	 * @return the sh20002Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ISh20002Service getSh20002Service() {
		return sh20002Service;
	}

	/**
	 * @param sh20002Service the sh20002Service to set
	 */
	public void setSh20002Service(ISh20002Service sh20002Service) {
		this.sh20002Service = sh20002Service;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv12001> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12001> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the shFlag
	 */
	public String getShFlag() {
		return shFlag;
	}

	/**
	 * @param shFlag the shFlag to set
	 */
	public void setShFlag(String shFlag) {
		this.shFlag = shFlag;
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
