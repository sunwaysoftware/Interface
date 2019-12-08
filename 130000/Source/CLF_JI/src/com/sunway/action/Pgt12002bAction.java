/**
 * 
 */
package com.sunway.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12002bService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12002b;

/**
 * 
 * 土地当前承租人表
 * @author Andy.Gao
 *
 */
public class Pgt12002bAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -3331882829725971382L;
	private IPgt12002bService t12002bService;
	private Pgt12002b t12002bBean; 
	private String ACT;
	private String txtDCID;
	private String txtCZRZJH;
	private String chkSFNSR;
	private String txtCZKSSJ;
	private String txtCZJSSJ;
	private String txtCZNOTE;
	private String txtUPDATE;
	private String txtCZRMC;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 信息讀取處理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		Pgt12002b t12002b = new Pgt12002b();
		try {
			//读取地产承租人信息
			t12002b.setCd12002Dcid(txtDCID);
			t12002bBean = t12002bService.LoadByPrimaryKey(t12002b);
			if(null==t12002bBean){
				t12002bBean = t12002b;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 更新信息檢驗
	 * @throws Exception 
	 */
	public void validateUpdate() throws Exception {
		this.clearErrorsAndMessages();
		t12002bBean = new Pgt12002b(); 
		
		t12002bBean.setCd12002Dcid(txtDCID);
		//根據PK取得信息，並為數據BEAN賦值
		if(!Constant.MOD_DELETE.equals(ACT)){
			t12002bBean = t12002bService.LoadByPrimaryKey(t12002bBean);
			if(null==t12002bBean) t12002bBean = new Pgt12002b(); 
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(ACT))&&(!Common.isNullOrEmpty(t12002bBean.getCd12002Dcid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.sjcj.t12002b.dcid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(ACT))&& null!=t12002bBean.getUpddate()&&(!t12002bBean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t12002bBean.setCzrmc(txtCZRMC);
			t12002bBean.setCd00002Czr(sessionCtrl.getUserId());
			t12002bBean.setCd12002Dcid(txtDCID);
			t12002bBean.setCd12006Czrzjh(txtCZRZJH);
			t12002bBean.setCzjssj(Common.convertToDate(txtCZJSSJ));
			t12002bBean.setCzkssj(Common.convertToDate(txtCZKSSJ));
			t12002bBean.setNote(txtCZNOTE);
			t12002bBean.setSfnsr(Common.convertToBoolean(chkSFNSR));
			t12002bBean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}		
	}
	
	/**
	 * 信息更新處理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			if (Constant.MOD_UPDATE.equals(ACT)) {			// Update
				if(t12002bService.GetUpdateCommand(t12002bBean)){
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{t12002bBean.getCd12002Dcid()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{t12002bBean.getCd12002Dcid()}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t12002bService.GetDeleteCommand(t12002bBean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t12002bBean.getCd12002Dcid()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t12002bBean.getCd12002Dcid()}));
			}
			ACT = Constant.MOD_UPDATE;
			t12002bBean = t12002bService.LoadByPrimaryKey(t12002bBean);
			if (t12002bBean == null) {
				t12002bBean = new Pgt12002b();
				t12002bBean.setCd12002Dcid(txtDCID);
			}
		} catch (Exception e) {
			LOG.error("update()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return INPUT;
		} finally {
			//t12002bBean = t12002bService.LoadByPrimaryKey(t12002bBean);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @param t12002bService the t12002bService to set
	 */
	public void setT12002bService(IPgt12002bService t12002bService) {
		this.t12002bService = t12002bService;
	}

	/**
	 * @return the t12002bService
	 */
	public IPgt12002bService getT12002bService() {
		return t12002bService;
	}

	/**
	 * @param txtDCID the txtDCID to set
	 */
	public void setTxtDCID(String txtDCID) {
		this.txtDCID = txtDCID;
	}

	/**
	 * @return the txtDCID
	 */
	public String getTxtDCID() {
		return txtDCID;
	}

	/**
	 * @param t12002bBean the t12002bBean to set
	 */
	public void setT12002bBean(Pgt12002b t12002bBean) {
		this.t12002bBean = t12002bBean;
	}

	/**
	 * @return the t12002bBean
	 */
	public Pgt12002b getT12002bBean() {
		return t12002bBean;
	}

	/**
	 * @return the txtCZRZJH
	 */
	public String getTxtCZRZJH() {
		return txtCZRZJH;
	}

	/**
	 * @param txtCZRZJH the txtCZRZJH to set
	 */
	public void setTxtCZRZJH(String txtCZRZJH) {
		this.txtCZRZJH = txtCZRZJH;
	}

	/**
	 * @return the chkSFNSR
	 */
	public String getChkSFNSR() {
		return chkSFNSR;
	}

	/**
	 * @param chkSFNSR the chkSFNSR to set
	 */
	public void setChkSFNSR(String chkSFNSR) {
		this.chkSFNSR = chkSFNSR;
	}

	/**
	 * @return the txtCZKSSJ
	 */
	public String getTxtCZKSSJ() {
		return txtCZKSSJ;
	}

	/**
	 * @param txtCZKSSJ the txtCZKSSJ to set
	 */
	public void setTxtCZKSSJ(String txtCZKSSJ) {
		this.txtCZKSSJ = txtCZKSSJ;
	}

	/**
	 * @return the txtCZJSSJ
	 */
	public String getTxtCZJSSJ() {
		return txtCZJSSJ;
	}

	/**
	 * @param txtCZJSSJ the txtCZJSSJ to set
	 */
	public void setTxtCZJSSJ(String txtCZJSSJ) {
		this.txtCZJSSJ = txtCZJSSJ;
	}

	/**
	 * @return the txtCZNOTE
	 */
	public String getTxtCZNOTE() {
		return txtCZNOTE;
	}

	/**
	 * @param txtCZNOTE the txtCZNOTE to set
	 */
	public void setTxtCZNOTE(String txtCZNOTE) {
		this.txtCZNOTE = txtCZNOTE;
	}

	/**
	 * @param txtUPDATE the txtUPDATE to set
	 */
	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
	}

	/**
	 * @return the txtUPDATE
	 */
	public String getTxtUPDATE() {
		return txtUPDATE;
	}

	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @return the txtCZRMC
	 */
	public String getTxtCZRMC() {
		return txtCZRMC;
	}

	/**
	 * @param txtCZRMC the txtCZRMC to set
	 */
	public void setTxtCZRMC(String txtCZRMC) {
		this.txtCZRMC = txtCZRMC;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
	
}
