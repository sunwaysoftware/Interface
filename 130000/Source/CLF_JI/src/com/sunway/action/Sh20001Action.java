/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ISh20001Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 未审核操作[收益法]
 * @author Andy.Gao
 *
 */
public class Sh20001Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -8817204723940625006L;
	private ISh20001Service sh20001Service;
	private ArrayList<Pgv12001> tabList;
	private ArrayList<Pgv12004> mxList;
	private String flagSH;
	// VIEW
	private Integer pageIndex;
	private Integer pageCount;
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
			tabList = sh20001Service.LoadSh(v12001);
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
				pageIndex = 1;
			}
		} catch (Exception e) {
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
		
		Pgv12001 v12001 = new Pgv12001();
		Integer shCount = 0;
		Integer shTotal = 0;
		try {
			processMsg = "收益法数据审核";
			v12001.setShCzr(sessionCtrl.getUserId());
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12001.setSysPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			switch (Common.convertToInteger(hidFlag)) {
			case 1://選擇審核
				shTotal = chkSel.length;
				for(Integer i=0; i<chkSel.length; i++){
					try {
						v12001.setSwid(chkSel[i]);
						//執行審核
						if(sh20001Service.GetExecSH(v12001)){
							shCount++;
						}	
					} catch (Exception e2) {
						LOG.error("executeSH()", e2);
					}
					processCent = i*100/chkSel.length;
				}
				break;
			case 2://全部審核
				v12001.setSwid(Common.getSearchLike(txtSWIDFind));
				v12001.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
				tabList = sh20001Service.LoadShSwidList(v12001);
				shTotal = tabList.size();
				for(Integer i=0; i<tabList.size(); i++){
					try {
						v12001.setSwid(tabList.get(i).getSwid());
						//執行審核
						if(sh20001Service.GetExecSH(v12001)){
							shCount++;
						}	
					} catch (Exception e2) {
						LOG.error("executeSH()", e2);
					}
					processCent = i*100/tabList.size();
				}
				break;
			case 3://強制審核
				shTotal = chkSel.length;
				for(Integer i=0; i<chkSel.length; i++){
					try {
						v12001.setSwid(chkSel[i]);
						//執行強制審核
						if(sh20001Service.GetExecForceSH(v12001)){
							shCount++;
						}						
					} catch (Exception e2) {
						LOG.error("executeSH()", e2);
					}
					processCent = i*100/chkSel.length;
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
		this.addActionMessage("审核执行完毕[共"+ shTotal +"条数据，"+ shCount +"条参与审核]");
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

		Pgv12004 bean = new Pgv12004();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			txtSWIDFind = Common.convertEncoding(txtSWIDFind);
			bean.setCd12001Swid(txtSWIDFind);
			bean.setShFlag(Common.convertToInteger(flagSH));
			bean.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			mxList = sh20001Service.LoadShMxNgList(bean);		
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
	
	/*********************** set and get ******************************/
	
	/**
	 * @param sh20001Service the sh20001Service to set
	 */
	public void setSh20001Service(ISh20001Service sh20001Service) {
		this.sh20001Service = sh20001Service;
	}

	/**
	 * @return the sh20001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ISh20001Service getSh20001Service() {
		return sh20001Service;
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
	 * @return the mxList
	 */
	public ArrayList<Pgv12004> getMxList() {
		return mxList;
	}

	/**
	 * @param mxList the mxList to set
	 */
	public void setMxList(ArrayList<Pgv12004> mxList) {
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
	 * @return the flagSH
	 */
	public String getFlagSH() {
		return flagSH;
	}

	/**
	 * @param flagSH the flagSH to set
	 */
	public void setFlagSH(String flagSH) {
		this.flagSH = flagSH;
	}

	/**
	 * @param processCent the processCent to set
	 */
	public void setProcessCent(Integer processCent) {
		this.processCent = processCent;
	}

	/**
	 * @return the processCent
	 */
	public Integer getProcessCent() {
		return processCent;
	}

	/**
	 * @param processMsg the processMsg to set
	 */
	public void setProcessMsg(String processMsg) {
		this.processMsg = processMsg;
	}

	/**
	 * @return the processMsg
	 */
	public String getProcessMsg() {
		return processMsg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionCtrl.appSession = session;
	}
}
