/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ISs30000Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00302;

/**
 * 
 * 市場法算稅處理[未算稅]
 * @author Andy.Gao
 *
 */
public class Ss30001Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -4318745343540774443L;
	private ISs30000Service ss30000Service;
	private Integer hidFlag;
	private String[] chkSel;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private Integer processCent;	
	private String processMsg;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	private ArrayList<Pgv00302> operList;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 算税前的验证
	 */
	public void validateExecuteSS(){
		this.clearErrorsAndMessages();
		if(1==hidFlag && (null==chkSel || chkSel.length<1)){
				this.addActionError("请选择要参与算税的数据");	
		}
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
		Pgv00302 v00302 = new Pgv00302();
		Integer ssCount = 0;
		Integer ssTotal = 0;
		try {
			processMsg = "数据算税";
			v00302.setSsCzr(sessionCtrl.getUserId());
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00302.setSysPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			switch (hidFlag) {
			case 1:// 選擇算稅
				ssTotal = chkSel.length;
				for (Integer i = 0; i < chkSel.length; i++) {
					try {
						v00302.setFcid(chkSel[i]);
						// 執行算稅
						if (ss30000Service.GetSsCommand(v00302)) {
							ssCount++;
						}
					} catch (Exception e2) {
						LOG.error("executeSS()", e2);
						throw e2;
					}
					processCent = i * 100 / chkSel.length;
				}
				break;
			case 2:// 全部算稅
				v00302.setCd00301Swid(Common.getSearchLike(txtSWIDFind));
				v00302.setNsrmc(Common.getSearchLike(txtNSRMCFind));
				operList = ss30000Service.LoadSsList(v00302);
				ssTotal = operList.size();
				for (Integer i = 0; i < operList.size(); i++) {
					try {
						v00302.setFcid(operList.get(i).getFcid());
						// 執行算稅
						if (ss30000Service.GetSsCommand(v00302)) {
							ssCount++;
						}
					} catch (Exception e2) {
						LOG.error("executeSS()", e2);
						throw e2;
					}
					processCent = i * 100 / operList.size();
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			LOG.error("executeSS()", e);
			String[] msgList = e.getMessage().split("\n");
			for (String msg : msgList) {
				this.addActionError(msg);
			}
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeSS() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeSS() ********** end **********");
		}
		
		if(!this.hasActionErrors())
			this.addActionMessage("算税执行完毕[共" + ssTotal + "条数据，" + ssCount + "条参与算税]");
		return SUCCESS;
	}

	/************************ SET AND GET *****************************/

	/**
	 * @param ss30000Service the ss30000Service to set
	 */
	public void setSs30000Service(ISs30000Service ss30000Service) {
		this.ss30000Service = ss30000Service;
	}

	/**
	 * @return the ss30000Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ISs30000Service getSs30000Service() {
		return ss30000Service;
	}

	/**
	 * @return the hidFlag
	 */
	public Integer getHidFlag() {
		return hidFlag;
	}

	/**
	 * @param hidFlag the hidFlag to set
	 */
	public void setHidFlag(Integer hidFlag) {
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
}
