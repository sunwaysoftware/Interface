/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ISh10001Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12001;
import com.sunway.vo.Pgv12004;

/**
 * 
 * 审核操作[成本法]
 * @author Andy.Gao
 *
 */
public class Sh10001Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1877498372707395240L;
	private ISh10001Service sh10001Service;
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
			tabList = sh10001Service.LoadSh(v12001);
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
			LOG.debug("executeSH() ********** start **********"+Common.getCurrentTime());
		}

		Pgv12001 v12001 = new Pgv12001();
		Integer shCount = 0;
		Integer shTotal = 0;
		try {
			processMsg = "成本法数据审核";
			v12001.setShCzr(sessionCtrl.getUserId());
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setSysPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v12001.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			switch (Common.convertToInteger(hidFlag)) {
			case 1://選擇審核
				shTotal = chkSel.length;
				for(Integer i=0; i<chkSel.length; i++){
					try {
						v12001.setSwid(chkSel[i]);
						//執行審核
						if(sh10001Service.GetExecSH(v12001)){
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
				tabList = sh10001Service.LoadShSwidList(v12001);
				shTotal = tabList.size();
				for(Integer i=0; i<tabList.size(); i++){
					try {
						v12001.setSwid(tabList.get(i).getSwid());
						//執行審核
						if(sh10001Service.GetExecSH(v12001)){
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
						if(sh10001Service.GetExecForceSH(v12001)){
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
			LOG.debug("executeSH() ********** end **********"+ Common.getCurrentTime() );
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
			mxList = sh10001Service.LoadShMxNgList(bean);		
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
	public String init1200112() throws Exception {
		return SUCCESS;
	}

	/**
	 * 未录入全数据查询处理
	 * @return
	 * @throws Exception
	 */
	public String query1200112() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query1200112() ********** start **********");
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
			tabList = sh10001Service.LoadSh1200112(v12001);
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
			LOG.debug("query1200112() ********** end **********");
		}
		return SUCCESS;	
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @param sh10001Service the sh10001Service to set
	 */
	public void setSh10001Service(ISh10001Service sh10001Service) {
		this.sh10001Service = sh10001Service;
	}

	/**
	 * @return the sh10001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ISh10001Service getSh10001Service() {
		return sh10001Service;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12001> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv12001> getTabList() {
		return tabList;
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
	 * @param hidFlag the hidFlag to set
	 */
	public void setHidFlag(String hidFlag) {
		this.hidFlag = hidFlag;
	}

	/**
	 * @return the hidFlag
	 */
	public String getHidFlag() {
		return hidFlag;
	}

	/**
	 * @param chkSel the chkSel to set
	 */
	public void setChkSel(String[] chkSel) {
		this.chkSel = chkSel;
	}

	/**
	 * @return the chkSel
	 */
	public String[] getChkSel() {
		return chkSel;
	}

	/**
	 * @param mxList the mxList to set
	 */
	public void setMxList(ArrayList<Pgv12004> mxList) {
		this.mxList = mxList;
	}

	/**
	 * @return the mxList
	 */
	public ArrayList<Pgv12004> getMxList() {
		return mxList;
	}

	/**
	 * @param flagSH the flagSH to set
	 */
	public void setFlagSH(String flagSH) {
		this.flagSH = flagSH;
	}

	/**
	 * @return the flagSH
	 */
	public String getFlagSH() {
		return flagSH;
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
