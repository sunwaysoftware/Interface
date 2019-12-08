/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ISs10000Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 成本法算稅處理[未算稅]
 * @author Andy.Gao
 *
 */
public class Ss10001Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -105081373619344939L;
	private ISs10000Service ss10000Service;
	private ArrayList<Pgv12001> tabList;
	private Integer hidFlag;
	private String[] chkSel;
	private String txtSWIDFind;
	private String txtNSRMCFind;
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

	/**
	 * 算稅處理
	 * @return
	 * @throws Exception
	 */
	public String executeSS() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeSS() ********** start **********");
		}
		
		Pgv12001 v12001 = new Pgv12001();
		Integer ssCount = 0;
		Integer ssTotal = 0;
		try {
			processMsg = "成本法数据算税";
			v12001.setSsCzr(sessionCtrl.getUserId());
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setSysPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v12001.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			switch (hidFlag) {
			case 1://選擇算稅
				ssTotal = chkSel.length;
				for(Integer i=0; i<chkSel.length; i++){
					try {
						v12001.setSwid(chkSel[i]);
						//執行算稅
						if(ss10000Service.GetSsCommand(v12001)){
							ssCount++;
						}	
					} catch (Exception e2) {
						LOG.error("executeSH()", e2);
					}
					processCent = i*100/chkSel.length;
				}
				break;
			case 2://全部算稅
				v12001.setSwid(Common.getSearchLike(txtSWIDFind));
				v12001.setNsrmc(Common.getSearchLike(txtNSRMCFind));
				tabList = ss10000Service.LoadShSwidList(v12001);
				ssTotal = tabList.size();
				for(Integer i=0; i<tabList.size(); i++){
					try {
						v12001.setSwid(tabList.get(i).getSwid());
						//執行算稅
						if(ss10000Service.GetSsCommand(v12001)){
							ssCount++;
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
			LOG.error("executeSS()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeSS() ********** end **********");
			}
			return INPUT;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeSS() ********** end **********");
		}
		this.addActionMessage("算税执行完毕[共"+ ssTotal +"条数据，"+ ssCount +"条参与算税]");
		return SUCCESS;
	}

	/************************** set and get ******************************/
	
	/**
	 * @param ss10000Service the ss10000Service to set
	 */
	public void setSs10000Service(ISs10000Service ss10000Service) {
		this.ss10000Service = ss10000Service;
	}

	/**
	 * @return the ss10000Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ISs10000Service getSs10000Service() {
		return ss10000Service;
	}

	/**
	 * @param hidFlag the hidFlag to set
	 */
	public void setHidFlag(Integer hidFlag) {
		this.hidFlag = hidFlag;
	}

	/**
	 * @return the hidFlag
	 */
	public Integer getHidFlag() {
		return hidFlag;
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
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}
	
}
