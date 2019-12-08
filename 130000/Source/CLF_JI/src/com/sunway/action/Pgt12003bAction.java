/**
 * 
 */
package com.sunway.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12003bService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12003b;

/**
 * 
 * 房产当前承租人表
 * @author Andy.Gao
 *
 */
public class Pgt12003bAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3062999752697480668L;
	private IPgt12003bService t12003bService;
	private Pgt12003b t12003bBean; 
	private String ACT;
	private String txtFCID;
	private String txtCZRZJH;
	private Boolean chkSFNSR;
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
		
		Pgt12003b t12003b = new Pgt12003b();
		try {
			//读取地产承租人信息
			t12003b.setCd12003Fcid(txtFCID);
			t12003bBean = t12003bService.LoadByPrimaryKey(t12003b);
			if(null==t12003bBean){
				t12003bBean = t12003b;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}			
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
		t12003bBean = new Pgt12003b(); 
		t12003bBean.setCd12003Fcid(txtFCID);

		//根據PK取得信息，並為數據BEAN賦值
		if(!Constant.MOD_DELETE.equals(ACT)){
			t12003bBean = t12003bService.LoadByPrimaryKey(t12003bBean);
			if(null==t12003bBean) t12003bBean = new Pgt12003b();
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(ACT))&&(!Common.isNullOrEmpty(t12003bBean.getCd12003Fcid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.sjcj.t12003b.fcid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(ACT))&&(null!=t12003bBean.getUpddate())&&(!t12003bBean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t12003bBean.setCzrmc(txtCZRMC);
			t12003bBean.setCd00002Czr(sessionCtrl.getUserId());
			t12003bBean.setCd12003Fcid(txtFCID);
			t12003bBean.setCd12006Czrzjh(txtCZRZJH);
			t12003bBean.setCzjssj(Common.convertToDate(txtCZJSSJ));
			t12003bBean.setCzkssj(Common.convertToDate(txtCZKSSJ));
			t12003bBean.setNote(txtCZNOTE);
			t12003bBean.setSfnsr(Common.checkNull(chkSFNSR));
			t12003bBean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
			if (Constant.MOD_UPDATE.equals(ACT)) {
				if (t12003bService.GetUpdateCommand(t12003bBean)) {
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t12003bBean.getCd12003Fcid() }));
				} else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { t12003bBean.getCd12003Fcid() }));
			} else if (Constant.MOD_DELETE.equals(ACT)) {
				if(t12003bService.GetDeleteCommand(t12003bBean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t12003bBean.getCd12003Fcid()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t12003bBean.getCd12003Fcid()}));
			}
			ACT = Constant.MOD_UPDATE;
			t12003bBean = t12003bService.LoadByPrimaryKey(t12003bBean);
			if (t12003bBean == null) {
				t12003bBean = new Pgt12003b();
				t12003bBean.setCd12003Fcid(txtFCID);
			}
		} catch (Exception e) {
			LOG.error("update()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}			
			return INPUT;
		} finally {
			//t12003bBean = t12003bService.LoadByPrimaryKey(t12003bBean);
		}	

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** set and get ******************************/
	
	/**
	 * @param t12003bService the t12003bService to set
	 */
	public void setT12003bService(IPgt12003bService t12003bService) {
		this.t12003bService = t12003bService;
	}

	/**
	 * @return the t12003bService
	 */
	public IPgt12003bService getT12003bService() {
		return t12003bService;
	}

	/**
	 * @return the t12003bBean
	 */
	public Pgt12003b getT12003bBean() {
		return t12003bBean;
	}

	/**
	 * @param t12003bBean the t12003bBean to set
	 */
	public void setT12003bBean(Pgt12003b t12003bBean) {
		this.t12003bBean = t12003bBean;
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
	 * @return the txtDCID
	 */
	public String getTxtFCID() {
		return txtFCID;
	}

	/**
	 * @param txtFCID the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
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
	public Boolean getChkSFNSR() {
		return chkSFNSR;
	}

	/**
	 * @param chkSFNSR the chkSFNSR to set
	 */
	public void setChkSFNSR(Boolean chkSFNSR) {
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
	 * @param txtCZRMC the txtCZRMC to set
	 */
	public void setTxtCZRMC(String txtCZRMC) {
		this.txtCZRMC = txtCZRMC;
	}

	/**
	 * @return the txtCZRMC
	 */
	public String getTxtCZRMC() {
		return txtCZRMC;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
