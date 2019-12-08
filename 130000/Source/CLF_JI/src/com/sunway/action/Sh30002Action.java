/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ISh30002Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00302;

/**
 * 
 * 审核操作[市場法]
 * @author Andy.Gao
 *
 */
public class Sh30002Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 8234416650898003215L;
	private ISh30002Service sh30002Service;
	private ArrayList<Pgv00302> operList;
	// VIEW
	private Integer pageIndex;
	private Integer pageSize;
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

		Pgv00302 v00302 = new Pgv00302();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00302.setCd00301Swid(Common.getSearchLike(txtSWIDFind));
			v00302.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v00302.setPageIndex(pageIndex);
			v00302.setPageSize(getPageSize());
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			operList = sh30002Service.LoadShOK(v00302);
			//分页设置
			if(null!=operList && operList.size()>0){
				rowCount = operList.get(0).getRecordCount();
			} else {
				rowCount = 0;
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
		
		Pgv00302 v00302 = new Pgv00302();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00302.setShCzr(sessionCtrl.getUserId());
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00302.setSysPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			switch (Common.convertToInteger(hidFlag)) {
			case 1://選擇重新審核
				v00302.setFcid(chkSel);
				//執行重新審核
				if(sh30002Service.GetExecShAgain(v00302))
					this.addActionMessage(getText(Constant.MSG_AUDIT_EXECR_OK, new String[]{chkSel}));
				else
					this.addActionError(getText(Constant.MSG_AUDIT_EXECR_NG));
				break;
			case 2://全部重新審核
				//執行重新審核
				v00302.setCd00301Swid(Common.getSearchLike(txtSWIDFind));
				v00302.setNsrmc(Common.getSearchLike(txtNSRMCFind));
				if(sh30002Service.GetExecShAgainAll(v00302))
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
	 * @param sh30002Service the sh30002Service to set
	 */
	public void setSh30002Service(ISh30002Service sh30002Service) {
		this.sh30002Service = sh30002Service;
	}

	/**
	 * @return the sh30002Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ISh30002Service getSh30002Service() {
		return sh30002Service;
	}

	/**
	 * @return the operList
	 */
	public ArrayList<Pgv00302> getOperList() {
		return operList;
	}

	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<Pgv00302> operList) {
		this.operList = operList;
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
	public String getChkSel() {
		return chkSel;
	}

	/**
	 * @param chkSel the chkSel to set
	 */
	public void setChkSel(String chkSel) {
		this.chkSel = chkSel;
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
