/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ISs10000Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00041;
import com.sunway.vo.Ss00000;

/**
 * 
 * 成本法算稅處理[已算稅]
 * @author Andy.Gao
 *
 */
public class Ss10002Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1531829887460379205L;
	private ISs10000Service ss10000Service;
	private Integer hidFlag;
	private String chkSel;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	// Print
	private ArrayList<Ss00000> noticeList;
	private Ss00000 ss00000Bean;
	private Integer T;
	private Date taxDate;
	private Date sysDate;
	private SessionCtrl sessionCtrl = new SessionCtrl();

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 重新算稅
	 * @return
	 * @throws Exception
	 */
	public String executeSsAgain() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeSsAgain() ********** start **********");
		}

		Pgv00041 v00041 = new Pgv00041();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00041.setSsCzr(sessionCtrl.getUserId());
			v00041.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00041.setSysPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v00041.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));		
			switch (hidFlag) {
			case 1://選擇重新評估
				v00041.setCd12301Swid(chkSel);
				//執行重新評估
				if(ss10000Service.GetSsAgainCommand(v00041))
					this.addActionMessage(getText(Constant.MSG_SS_EXECR_OK, new String[]{chkSel}));
				else
					this.addActionError(getText(Constant.MSG_SS_EXECR_NG));
				break;
			case 2://全部重新評估
				//執行重新評估
				v00041.setCd12301Swid(Common.getSearchLike(txtSWIDFind));
				v00041.setNsrmc(Common.getSearchLike(txtNSRMCFind));
				if(ss10000Service.GetSsAgainAllCommand(v00041))
					this.addActionMessage(getText(Constant.MSG_SS_EXECR_OK, new String[]{Constant.STRING_EMPTY}));
				else
					this.addActionError(getText(Constant.MSG_SS_EXECR_NG));
				break;
			default:
				break;
			}		
		} catch (Exception e) {
			LOG.error("executeSsAgain()", e);
			this.addActionError(e.getMessage());		
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeSsAgain() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeSsAgain() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 房地产纳税通知单【成本法】页面初始化
	 * @return
	 * @throws Exception
	 */
	public String executeNsNotice() throws Exception {
		return SUCCESS;
	}

	/**
	 * 房地产纳税通知单【成本法】选择打印处理
	 * @return
	 * @throws Exception
	 */
	public String printNsNotice() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("printNsNotice() ********** start **********");
		}
		noticeList = new ArrayList<Ss00000>();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if (!Common.isNullOrEmpty(chkSel)) {
				String[] swidList = chkSel.split(",");
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.DATE, T);
				taxDate = cal.getTime();
				sysDate = new Date();
				for (int i = 0; i <= swidList.length - 1; i++) {
					ss00000Bean = new Ss00000();
					Ss00000 ss00000 = new Ss00000();
					ss00000.setCd12301Swid(swidList[i].trim());
					String pssd = sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD);
					ss00000.setPssd(pssd);
					ss00000.setCd00001Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
					ss00000.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
					ss00000Bean = ss10000Service.LoadNotice(ss00000);
					ss00000Bean.setPssd(pssd);
					ss00000Bean.setSkssq(pssd + "/01/01 -- " + pssd + "/12/31");
					ss00000Bean.setTaxDate(taxDate);
					ss00000Bean.setSysDate(sysDate);
					noticeList.add(ss00000Bean);
				}
			}
		} catch (Exception e) {
			LOG.error("printNsNotice()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("printNsNotice() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("printNsNotice() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 成本法打印通知单
	 * @return
	 * @throws Exception
	 */
	public String printcz() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("printcz() ********** start **********");
		}
		Ss00000 ss00000 = new Ss00000();
		try {
			if (!Common.isNullOrEmpty(chkSel)) {
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				ss00000.setCd12301Swid(chkSel);
				ss00000.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				ss00000.setCd00001Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
				ss00000.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
				ss10000Service.printcz(ss00000);
			}
		} catch (Exception e) {
			LOG.error("printcz()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("printcz() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("printcz() ********** end **********");
		}
		return SUCCESS;
	}

	/***************************** set and get **********************************/
	
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
	 * @return the noticeList
	 */
	public ArrayList<Ss00000> getNoticeList() {
		return noticeList;
	}

	/**
	 * @param noticeList the noticeList to set
	 */
	public void setNoticeList(ArrayList<Ss00000> noticeList) {
		this.noticeList = noticeList;
	}

	/**
	 * @return the ss00000Bean
	 */
	public Ss00000 getSs00000Bean() {
		return ss00000Bean;
	}

	/**
	 * @param ss00000Bean the ss00000Bean to set
	 */
	public void setSs00000Bean(Ss00000 ss00000Bean) {
		this.ss00000Bean = ss00000Bean;
	}

	/**
	 * @return the t
	 */
	public Integer getT() {
		return T;
	}

	/**
	 * @param t the t to set
	 */
	public void setT(Integer t) {
		T = t;
	}
	/**
	 * @return the taxDate
	 */
	public Date getTaxDate() {
		return taxDate;
	}

	/**
	 * @param taxDate the taxDate to set
	 */
	public void setTaxDate(Date taxDate) {
		this.taxDate = taxDate;
	}

	/**
	 * @return the sysDate
	 */
	public Date getSysDate() {
		return sysDate;
	}

	/**
	 * @param sysDate the sysDate to set
	 */
	public void setSysDate(Date sysDate) {
		this.sysDate = sysDate;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
