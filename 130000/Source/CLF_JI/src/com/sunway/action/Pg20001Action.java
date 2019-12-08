/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPg20001Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 未評估[收益法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg20001Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1176247363406914151L;
	private IPg20001Service pg20001Service;
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
			v12001.setSwid(Common.getSearchLike(txtSWIDFind));
			v12001.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v12001.setPageIndex(pageIndex);
			v12001.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = pg20001Service.LoadPg(v12001);
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount,sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
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
	 * 選擇審核
	 * @return
	 * @throws Exception
	 */
	public String executePG() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeSH() ********** start **********");
		}
		Pgv12001 v12001 = new Pgv12001();
		Integer pgCount = 0;
		Integer pgTotal = 0;
		try {
			processMsg = "收益法数据评税";
			v12001.setSwid(Common.getSearchLike(txtSWIDFind));
			v12001.setNsrmc(Common.getSearchLike(txtNSRMCFind));
			v12001.setPgCzr(sessionCtrl.getUserId());
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setSysPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v12001.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			switch (Common.convertToInteger(hidFlag)) {
			case 1://選擇審核
				pgTotal = chkSel.length;
				for(Integer i=0; i<chkSel.length; i++){
					try {
						v12001.setSwid(chkSel[i]);
						// 執行評估
						if(pg20001Service.GetExecPG(v12001)){
							pgCount++;
						}	
					} catch (Exception e2) {
						LOG.error("executeSH()", e2);
					}
					processCent = i*100/chkSel.length;
				}
				break;
			case 2://全部審核
				tabList = pg20001Service.LoadPgSwidList(v12001);
				pgTotal = tabList.size();
				for(Integer i=0; i<tabList.size(); i++){
					try {
						v12001.setSwid(tabList.get(i).getSwid());
						// 執行評估
						if(pg20001Service.GetExecPG(v12001)){
							pgCount++;
						}	
					} catch (Exception e2) {
						LOG.error("executeSH()", e2);
					}
					processCent = i*100/tabList.size();
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
		this.addActionMessage("评税执行完毕[共"+ pgTotal +"条数据，"+ pgCount +"条参与评税]");
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
			mxList = pg20001Service.LoadPgMxNgList(bean);		
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
	 * @param pg20001Service the pg20001Service to set
	 */
	public void setPg20001Service(IPg20001Service pg20001Service) {
		this.pg20001Service = pg20001Service;
	}
	
	/**
	 * @return the pg20001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPg20001Service getPg20001Service() {
		return pg20001Service;
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
}
