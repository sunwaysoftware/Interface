package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00012Service;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00012;
import com.sunway.vo.Pgv00012;

/**
 * 系统常规配置(Pgt00012)
 * @author Lee
 * @version 1.0
 */

public class Pgt00012Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 7888119774912542521L;

	private IPgt00012Service t00012Service;
	//view
	
	private ArrayList<Pgv00012> configList;
	private Pgt00012 t00012Bean;
	
	//edit
	
	private String ACT;
	//表单提交数据
	private Boolean rdoISLOGADD;
	private Boolean rdoISLOGUPD;
	private Boolean rdoISLOGDEL;
	private Boolean rdoISLOGPG;
	private Boolean rdoISLOGSH;
	private Boolean rdoISLOGGPG;
	private Boolean rdoISLOGSS;
	private Boolean rdoISLOGDY;
	private Boolean rdoISLOGIMP;
	private Boolean rdoISLOGEXP;
	private Boolean rdoISLOGBACKUP;
	private Boolean rdoISLOGBZFCS;
	private Boolean rdoISLOGNSRD;
	private String txtUPDATE;
	private String txtNOTE;
	private String SSGXId;
	private String SSGXNm;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String userRole;
	private String txtFCJKDZ;
	private String txtCHANNEL_PWD;
	private String txtCHANNEL_ACC;
	private String txtCHANNEL_CODE;
	private String txtWBMBM;
	private String txtFCBM;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		
		t00012Bean = new Pgt00012();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00012Bean.setCd00001Ssgxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SSGX));
			if(Common.isNullOrEmpty(SSGXId)){
			t00012Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				t00012Bean.setCd00001Ssgx(SSGXId);
			}
			t00012Bean = t00012Service.LoadByPrimaryKey(t00012Bean);
			SSGXId = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			SSGXNm = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGXNM);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt00012Action -- execute()", e);
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t00012Bean = new Pgt00012();
		this.clearErrorsAndMessages();
		//为PK赋值
		t00012Bean.setCd00001Ssgxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SSGX));
		if(Common.isNullOrEmpty(SSGXId)){
			t00012Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}else{
		t00012Bean.setCd00001Ssgx(SSGXId);
		}
		//根据PK取得信息，并为BEAN赋值
		t00012Bean = t00012Service.LoadByPrimaryKey(t00012Bean);
		//判读数据是否已经被其他用户修改
//		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00012Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
//			this.addActionError(getText("app.msg.error.pktime"));
//		}else{
		//为数据BEAN 赋值
			t00012Bean.setLogadd(rdoISLOGADD?1:0);
			t00012Bean.setLogupd(rdoISLOGUPD?1:0);
			t00012Bean.setLogdel(rdoISLOGDEL?1:0);
			t00012Bean.setLoggpg(rdoISLOGGPG?1:0);
			t00012Bean.setLogdy(rdoISLOGDY?1:0);
			t00012Bean.setLogpg(rdoISLOGPG?1:0);
			t00012Bean.setLogsh(rdoISLOGSH?1:0);
			t00012Bean.setLogss(rdoISLOGSS?1:0);
			t00012Bean.setNote(txtNOTE);
			t00012Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00012Bean.setFcjkdz(Common.trim(txtFCJKDZ));
			t00012Bean.setChannel_Pwd(Common.trim(txtCHANNEL_PWD));
			t00012Bean.setChannel_Acc(Common.trim(txtCHANNEL_ACC));
			t00012Bean.setChannel_Code(Common.trim(txtCHANNEL_CODE));
			t00012Bean.setWbmbm(Common.trim(txtWBMBM));
			t00012Bean.setFcbmbm(Common.trim(txtFCBM));
//		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String update() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try{
			if(t00012Service.GetUpdateCommand(getT00012Bean())){
				this.addActionMessage("保存设置成功");
			}else
				this.addActionError("保存设置失败");
			execute();
		}catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt00012Action -- update()", e);
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		
		t00012Bean = new Pgt00012();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00012Bean.setCd00001Ssgxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SSGX));
			t00012Bean.setCd00001Ssgx(SSGXId);
			t00012Bean = t00012Service.LoadByPrimaryKey(t00012Bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt00012Action -- query()", e);
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}
	/*********************** set and get ******************************/
	
	/**
	 * @return the t00012Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00012Service getT00012Service() {
		return t00012Service;
	}

	/**
	 * @param t00012Service the t00012Service to set
	 */
	public void setT00012Service(IPgt00012Service t00012Service) {
		this.t00012Service = t00012Service;
	}

	/**
	 * @return the configList
	 */
	public ArrayList<Pgv00012> getConfigList() {
		return configList;
	}

	/**
	 * @param configList the configList to set
	 */
	public void setConfigList(ArrayList<Pgv00012> configList) {
		this.configList = configList;
	}

	/**
	 * @return the rdoISLOGADD
	 */
	public Boolean getRdoISLOGADD() {
		return rdoISLOGADD;
	}


	/**
	 * @param rdoISLOGADD the rdoISLOGADD to set
	 */
	public void setRdoISLOGADD(Boolean rdoISLOGADD) {
		this.rdoISLOGADD = rdoISLOGADD;
	}


	/**
	 * @return the rdoISLOGUPD
	 */
	public Boolean getRdoISLOGUPD() {
		return rdoISLOGUPD;
	}


	/**
	 * @param rdoISLOGUPD the rdoISLOGUPD to set
	 */
	public void setRdoISLOGUPD(Boolean rdoISLOGUPD) {
		this.rdoISLOGUPD = rdoISLOGUPD;
	}


	/**
	 * @return the rdoISLOGDEL
	 */
	public Boolean getRdoISLOGDEL() {
		return rdoISLOGDEL;
	}


	/**
	 * @param rdoISLOGDEL the rdoISLOGDEL to set
	 */
	public void setRdoISLOGDEL(Boolean rdoISLOGDEL) {
		this.rdoISLOGDEL = rdoISLOGDEL;
	}


	/**
	 * @return the rdoISLOGPG
	 */
	public Boolean getRdoISLOGPG() {
		return rdoISLOGPG;
	}


	/**
	 * @param rdoISLOGPG the rdoISLOGPG to set
	 */
	public void setRdoISLOGPG(Boolean rdoISLOGPG) {
		this.rdoISLOGPG = rdoISLOGPG;
	}


	/**
	 * @return the rdoISLOGSH
	 */
	public Boolean getRdoISLOGSH() {
		return rdoISLOGSH;
	}


	/**
	 * @param rdoISLOGSH the rdoISLOGSH to set
	 */
	public void setRdoISLOGSH(Boolean rdoISLOGSH) {
		this.rdoISLOGSH = rdoISLOGSH;
	}


	/**
	 * @return the rdoISLOGGPG
	 */
	public Boolean getRdoISLOGGPG() {
		return rdoISLOGGPG;
	}


	/**
	 * @param rdoISLOGGPG the rdoISLOGGPG to set
	 */
	public void setRdoISLOGGPG(Boolean rdoISLOGGPG) {
		this.rdoISLOGGPG = rdoISLOGGPG;
	}


	/**
	 * @return the rdoISLOGSS
	 */
	public Boolean getRdoISLOGSS() {
		return rdoISLOGSS;
	}


	/**
	 * @param rdoISLOGSS the rdoISLOGSS to set
	 */
	public void setRdoISLOGSS(Boolean rdoISLOGSS) {
		this.rdoISLOGSS = rdoISLOGSS;
	}


	/**
	 * @return the rdoISLOGDY
	 */
	public Boolean getRdoISLOGDY() {
		return rdoISLOGDY;
	}


	/**
	 * @param rdoISLOGDY the rdoISLOGDY to set
	 */
	public void setRdoISLOGDY(Boolean rdoISLOGDY) {
		this.rdoISLOGDY = rdoISLOGDY;
	}


	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}


	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the t00012Bean
	 */
	public Pgt00012 getT00012Bean() {
		return t00012Bean;
	}

	/**
	 * @param t00012Bean the t00012Bean to set
	 */
	public void setT00012Bean(Pgt00012 t00012Bean) {
		this.t00012Bean = t00012Bean;
	}

	/**
	 * @return the txtUPDATE
	 */
	public String getTxtUPDATE() {
		return txtUPDATE;
	}

	/**
	 * @param txtUPDATE the txtUPDATE to set
	 */
	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
	}

	/**
	 * @return the txtNOTE
	 */
	public String getTxtNOTE() {
		return txtNOTE;
	}

	/**
	 * @param txtNOTE the txtNOTE to set
	 */
	public void setTxtNOTE(String txtNOTE) {
		this.txtNOTE = txtNOTE;
	}
	/**
	 * 
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * 
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the sSGXId
	 */
	public String getSSGXId() {
		return SSGXId;
	}

	/**
	 * @param sSGXId the sSGXId to set
	 */
	public void setSSGXId(String sSGXId) {
		SSGXId = sSGXId;
	}

	/**
	 * @return the sSGXNm
	 */
	public String getSSGXNm() {
		return SSGXNm;
	}

	/**
	 * @param sSGXNm the sSGXNm to set
	 */
	public void setSSGXNm(String sSGXNm) {
		SSGXNm = sSGXNm;
	}

	public Boolean getRdoISLOGIMP() {
		return rdoISLOGIMP;
	}

	public void setRdoISLOGIMP(Boolean rdoISLOGIMP) {
		this.rdoISLOGIMP = rdoISLOGIMP;
	}

	public Boolean getRdoISLOGEXP() {
		return rdoISLOGEXP;
	}

	public void setRdoISLOGEXP(Boolean rdoISLOGEXP) {
		this.rdoISLOGEXP = rdoISLOGEXP;
	}

	public Boolean getRdoISLOGBACKUP() {
		return rdoISLOGBACKUP;
	}

	public void setRdoISLOGBACKUP(Boolean rdoISLOGBACKUP) {
		this.rdoISLOGBACKUP = rdoISLOGBACKUP;
	}

	public Boolean getRdoISLOGBZFCS() {
		return rdoISLOGBZFCS;
	}

	public void setRdoISLOGBZFCS(Boolean rdoISLOGBZFCS) {
		this.rdoISLOGBZFCS = rdoISLOGBZFCS;
	}

	public Boolean getRdoISLOGNSRD() {
		return rdoISLOGNSRD;
	}

	public void setRdoISLOGNSRD(Boolean rdoISLOGNSRD) {
		this.rdoISLOGNSRD = rdoISLOGNSRD;
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

	/**
	 * @return the txtFCJKDZ
	 */
	public String getTxtFCJKDZ() {
		return txtFCJKDZ;
	}

	/**
	 * @param txtFCJKDZ the txtFCJKDZ to set
	 */
	public void setTxtFCJKDZ(String txtFCJKDZ) {
		this.txtFCJKDZ = txtFCJKDZ;
	}

	/**
	 * @return the txtCHANNEL_PWD
	 */
	public String getTxtCHANNEL_PWD() {
		return txtCHANNEL_PWD;
	}

	/**
	 * @param txtCHANNELPWD the txtCHANNEL_PWD to set
	 */
	public void setTxtCHANNEL_PWD(String txtCHANNELPWD) {
		txtCHANNEL_PWD = txtCHANNELPWD;
	}

	/**
	 * @return the txtCHANNEL_ACC
	 */
	public String getTxtCHANNEL_ACC() {
		return txtCHANNEL_ACC;
	}

	/**
	 * @param txtCHANNELACC the txtCHANNEL_ACC to set
	 */
	public void setTxtCHANNEL_ACC(String txtCHANNELACC) {
		txtCHANNEL_ACC = txtCHANNELACC;
	}

	/**
	 * @return the txtCHANNEL_CODE
	 */
	public String getTxtCHANNEL_CODE() {
		return txtCHANNEL_CODE;
	}

	/**
	 * @param txtCHANNELCODE the txtCHANNEL_CODE to set
	 */
	public void setTxtCHANNEL_CODE(String txtCHANNELCODE) {
		txtCHANNEL_CODE = txtCHANNELCODE;
	}

	/**
	 * @return the txtWBMBM
	 */
	public String getTxtWBMBM() {
		return txtWBMBM;
	}

	/**
	 * @param txtWBMBM the txtWBMBM to set
	 */
	public void setTxtWBMBM(String txtWBMBM) {
		this.txtWBMBM = txtWBMBM;
	}

	/**
	 * @return the txtFCBM
	 */
	public String getTxtFCBM() {
		return txtFCBM;
	}

	/**
	 * @param txtFCBM the txtFCBM to set
	 */
	public void setTxtFCBM(String txtFCBM) {
		this.txtFCBM = txtFCBM;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
