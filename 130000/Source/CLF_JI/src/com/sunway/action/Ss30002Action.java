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
import com.sunway.service.ISs30000Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00041;
import com.sunway.vo.Ss00000;
import com.sunway.vo.Ss30000;

/**
 * 
 * 市場法算稅處理[已算稅]
 * @author Andy.Gao
 *
 */
public class Ss30002Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -5034952438450714567L;
	private ISs30000Service ss30000Service;
	private Integer hidFlag;
	private String chkSel;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	// Print
	private ArrayList<Ss30000> noticeList;
	private Ss30000 ss30000Bean;
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
	 * 重新算稅前的验证
	 */
	public void validateExecuteSsAgain(){
		this.clearErrorsAndMessages();
		if(1==hidFlag && Common.isNullOrEmpty(chkSel) )
			this.addActionError("请选择要参与重新算稅的数据");
	}
	
	/**
	 * 重新算稅
	 * @return
	 * @throws Exception
	 */
	public String executeSsAgain() throws Exception {
		Pgv00041 v00041 = new Pgv00041();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00041.setSsCzr(sessionCtrl.getUserId());
			v00041.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00041.setSysPssdYMD(Common.convertToDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v00041.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));		
			switch (hidFlag) {
			case 1://選擇重新評估
				v00041.setCd123Id(chkSel);
				//執行重新評估
				if(ss30000Service.GetSsAgainCommand(v00041))
					this.addActionMessage(getText(Constant.MSG_SS_EXECR_OK, new String[]{chkSel}));
				else
					this.addActionError(getText(Constant.MSG_SS_EXECR_NG));
				break;
			case 2://全部重新評估
				//執行重新評估
				v00041.setCd12301Swid(Common.getSearchLike(txtSWIDFind));
				v00041.setNsrmc(Common.getSearchLike(txtNSRMCFind));
				if(ss30000Service.GetSsAgainAllCommand(v00041))
					this.addActionMessage(getText(Constant.MSG_SS_EXECR_OK, new String[]{Constant.STRING_EMPTY}));
				else
					this.addActionError(getText(Constant.MSG_SS_EXECR_NG));
				break;
			default:
				break;
			}		
		} catch (Exception e) {
			this.addActionError(e.getMessage());		
			return INPUT;
		}
		return SUCCESS;
	}

	/**
	 * 房地产纳税通知单【市场法】页面初始化
	 * @return
	 * @throws Exception
	 */
	public String executeNsNotice() throws Exception {
		return SUCCESS;
	}

	/**
	 * 房地产纳税通知单【市场法】选择打印处理
	 * @return
	 * @throws Exception
	 */
	public String printNsNotice() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("printNsNotice() ********** start **********");
		}
		noticeList = new ArrayList<Ss30000>();
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
					ss30000Bean = new Ss30000();
					Ss30000 ss30000 = new Ss30000();
					ss30000.setCd12301Swid(swidList[i].trim());
					String pssd = sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD);
					ss30000.setPssd(pssd);
					ss30000.setCd00001Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
					ss30000.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
					ss30000Bean = ss30000Service.LoadNotice(ss30000);
					ss30000Bean.setPssd(pssd);
					ss30000Bean.setSkssq(pssd + "/01/01 -- " + pssd + "/12/31");
					ss30000Bean.setTaxDate(taxDate);
					ss30000Bean.setSysDate(sysDate);
					noticeList.add(ss30000Bean);
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
	 * 市场法打印通知单
	 * @return
	 * @throws Exception
	 */
	public String printcz() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("printcz() ********** start **********");
		}
		Ss00000 ss00000 = new Ss00000();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if (!Common.isNullOrEmpty(chkSel)) {
				ss00000.setCd12301Swid(chkSel);
				ss00000.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				ss00000.setCd00001Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
				ss00000.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
				ss30000Service.printcz(ss00000);
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

	/******************************** SET AND GET **************************************/
	
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
	public ArrayList<Ss30000> getNoticeList() {
		return noticeList;
	}

	/**
	 * @param noticeList the noticeList to set
	 */
	public void setNoticeList(ArrayList<Ss30000> noticeList) {
		this.noticeList = noticeList;
	}

	/**
	 * @return the ss30000Bean
	 */
	public Ss30000 getSs30000Bean() {
		return ss30000Bean;
	}

	/**
	 * @param ss30000Bean the ss30000Bean to set
	 */
	public void setSs30000Bean(Ss30000 ss30000Bean) {
		this.ss30000Bean = ss30000Bean;
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
