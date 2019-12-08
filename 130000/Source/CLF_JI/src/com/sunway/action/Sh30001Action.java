/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ISh30001Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00301;
import com.sunway.vo.Pgv00302;

/**
 * 
 * 未审核操作[市場法]
 * @author Andy.Gao
 *
 */
public class Sh30001Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -5205361418327953770L;

	private ISh30001Service sh30001Service;
	private ArrayList<Pgv00301> tabList;
	private ArrayList<Pgv00302> operList;
	private ArrayList<Pgv00302> mxList;
	// VIEW
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String hidFlag;
	private String[] chkSel;
	private Integer processCent;	
	private String processMsg;
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
			operList = getSh30001Service().LoadSh(v00302);
			//分页设置
			if(null!=operList && operList.size()>0){
				rowCount = operList.get(0).getRecordCount();
			} else {
				rowCount = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;	
	}
	
	/**
	 * 审核前的验证
	 */
	public void validateExecuteSH(){
		this.clearErrorsAndMessages();
		if("1".equals(hidFlag) && (null==chkSel || chkSel.length<1))
			this.addActionError("请选择要参与审核的数据");
	}
	
	/**
	 * 選擇審核
	 * @return
	 * @throws Exception
	 */
	public String executeSH() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeSH() ********** start **********");
		}
		Pgv00302 v00302 = new Pgv00302();
		Integer shwCount = 0;
		Integer shCount = 0;
		Integer shTotal = 0;
		try {
			processMsg = "数据审核";
			v00302.setShCzr(sessionCtrl.getUserId());
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00302.setSysPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			switch (Common.convertToInteger(hidFlag)) {
			case 1://選擇審核
				shTotal = chkSel.length;
				for(Integer i=0; i<chkSel.length; i++){
					try {
						v00302.setFcid(chkSel[i]);
						//執行審核
						if(sh30001Service.GetExecSH(v00302))
							shCount++;
						else
							shwCount++;
					} catch (Exception e2) {
						LOG.error("executeSH()", e2);
					}
					processCent = i*100/chkSel.length;
				}				
				break;
			case 2://全部審核
				v00302.setCd00301Swid(Common.getSearchLike(txtSWIDFind));
				v00302.setNsrmc(Common.getSearchLike(txtNSRMCFind));
				operList = getSh30001Service().LoadShList(v00302);
				shTotal = operList.size();
				for(Integer i=0; i<operList.size(); i++){
					try {
						v00302.setFcid(operList.get(i).getFcid());
						//執行審核
						if(sh30001Service.GetExecSH(v00302))
							shCount++;
						else
							shwCount++;
					} catch (Exception e2) {
						LOG.error("executeSH()", e2);
					}
					processCent = i*100/operList.size();
				}				
				break;
			default:
				break;
			}
		} catch (Exception e) {
			LOG.error("executeSH()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeSH() ********** end **********");
			}
			return INPUT;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeSH() ********** end **********");
		}
		this.addActionMessage("审核执行完毕[共"+ shTotal +"条数据，"+ shCount +"条参与审核，其中"+shwCount+"条未通过]");
		return SUCCESS;
	}
	
	/**
	 * 通过企业ID得到审核未通过的明细列表
	 * @return
	 * @throws Exception
	 */
	public String queryNgMxList() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryNgMxList() ********** start **********");
		}

		Pgv00302 bean = new Pgv00302();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			txtSWIDFind = Common.convertEncoding(txtSWIDFind);
			bean.setCd00301Swid(txtSWIDFind);
			bean.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			mxList = getSh30001Service().LoadShMxNgList(bean);		
		} catch (Exception e) {
			LOG.error("queryNgMxList()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("queryNgMxList() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryNgMxList() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 未录入全数据页面初始化
	 * @return
	 * @throws Exception
	 */
	public String init0030112() throws Exception {
		return SUCCESS;
	}

	/**
	 * 未录入全数据查询处理
	 * @return
	 * @throws Exception
	 */
	public String query0030112() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query0030112() ********** start **********");
		}

		Pgv00301 v00301 = new Pgv00301();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00301.setSwid(Common.getSearchLike(txtSWIDFind));
			v00301.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v00301.setPageIndex(pageIndex);
			v00301.setPageSize(getPageSize());
			v00301.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00301.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = getSh30001Service().LoadSh0030112(v00301);
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				rowCount = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query0030112() ********** end **********");
		}
		return SUCCESS;	
	}

	/*********************** set and get ******************************/
	
	/**
	 * @param sh30001Service the sh30001Service to set
	 */
	public void setSh30001Service(ISh30001Service sh30001Service) {
		this.sh30001Service = sh30001Service;
	}

	/**
	 * @return the sh30001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ISh30001Service getSh30001Service() {
		return sh30001Service;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv00301> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00301> tabList) {
		this.tabList = tabList;
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
	 * @return the mxList
	 */
	public ArrayList<Pgv00302> getMxList() {
		return mxList;
	}

	/**
	 * @param mxList the mxList to set
	 */
	public void setMxList(ArrayList<Pgv00302> mxList) {
		this.mxList = mxList;
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
	 * @return the processCent
	 */
	public Integer getProcessCent() {
		return processCent;
	}

	/**
	 * @param processCent the processCent to set
	 */
	public void setProcessCent(Integer processCent) {
		this.processCent = processCent;
	}

	/**
	 * @return the processMsg
	 */
	public String getProcessMsg() {
		return processMsg;
	}

	/**
	 * @param processMsg the processMsg to set
	 */
	public void setProcessMsg(String processMsg) {
		this.processMsg = processMsg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionCtrl.appSession = session;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}
	
}
