/**
 * 
 */
package com.sunway.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12004bService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12004b;

/**
 * @author Andy.Gao
 *
 */
public class Pgt12004bAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -2113150680067117337L;
	private IPgt12004bService t12004bService;
	private Pgt12004b t12004bBean; 
	private String ACT;
	private String txtMXID;
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
		
		Pgt12004b t12004b = new Pgt12004b();
		try {
			//读取地产承租人信息
			t12004b.setCd12004Mxid(txtMXID);
			t12004bBean = t12004bService.LoadByPrimaryKey(t12004b);
			if(null==t12004bBean) {
				t12004bBean = t12004b;
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
		t12004bBean = new Pgt12004b(); 
		
		t12004bBean.setCd12004Mxid(txtMXID);
		//根據PK取得信息，並為數據BEAN賦值
		if(!Constant.MOD_DELETE.equals(ACT)){
			t12004bBean = t12004bService.LoadByPrimaryKey(t12004bBean);
			if(null==t12004bBean) t12004bBean = new Pgt12004b();
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(ACT))&&(!Common.isNullOrEmpty(t12004bBean.getCd12004Mxid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.sjcj.t12004b.mxid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(ACT))&& (null!=t12004bBean.getUpddate()) && (!t12004bBean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t12004bBean.setCd00002Czr(sessionCtrl.getUserId());
			t12004bBean.setCd12004Mxid(txtMXID);
			t12004bBean.setCd12006Czrzjh(txtCZRZJH);
			t12004bBean.setCzjssj(Common.convertToDate(txtCZJSSJ));
			t12004bBean.setCzkssj(Common.convertToDate(txtCZKSSJ));
			t12004bBean.setNote(txtCZNOTE);
			t12004bBean.setSfnsr(Common.convertToBoolean(chkSFNSR));
			t12004bBean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t12004bBean.setCzrmc(txtCZRMC);
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
			if (Constant.MOD_UPDATE.equals(ACT)) { // Update
				if (t12004bService.GetUpdateCommand(t12004bBean)) {
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t12004bBean.getCd12004Mxid() }));
				} else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { t12004bBean.getCd12004Mxid() }));
			} else if (Constant.MOD_DELETE.equals(ACT)) { // Delete
				if (t12004bService.GetDeleteCommand(t12004bBean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { t12004bBean.getCd12004Mxid() }));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { t12004bBean.getCd12004Mxid() }));
			}
			ACT = Constant.MOD_UPDATE;
			t12004bBean = t12004bService.LoadByPrimaryKey(t12004bBean);
			if (t12004bBean == null) {
				t12004bBean = new Pgt12004b();
				t12004bBean.setCd12004Mxid(txtMXID);
			}
		} catch (Exception e) {
			LOG.error("update()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}			
			return INPUT;
		} finally {
			//t12004bBean = t12004bService.LoadByPrimaryKey(t12004bBean);
		}		

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t12004bService
	 */
	public IPgt12004bService getT12004bService() {
		return t12004bService;
	}

	/**
	 * @param t12004bService the t12004bService to set
	 */
	public void setT12004bService(IPgt12004bService t12004bService) {
		this.t12004bService = t12004bService;
	}

	/**
	 * @return the t12004bBean
	 */
	public Pgt12004b getT12004bBean() {
		return t12004bBean;
	}

	/**
	 * @param t12004bBean the t12004bBean to set
	 */
	public void setT12004bBean(Pgt12004b t12004bBean) {
		this.t12004bBean = t12004bBean;
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
	 * @return the txtMXID
	 */
	public String getTxtMXID() {
		return txtMXID;
	}

	/**
	 * @param txtMXID the txtMXID to set
	 */
	public void setTxtMXID(String txtMXID) {
		this.txtMXID = txtMXID;
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