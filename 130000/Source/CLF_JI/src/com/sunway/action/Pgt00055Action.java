package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.impl.Pgt00055Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00055;

/**
 * 证件类型有效位数验证(Pgt00055)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt00055Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 4077550580539064200L;

	//Service
	private Pgt00055Service t00055Service;
	
	private ArrayList<Pgt00055> tabList;
	//Edit
	
	//edit页面所需Bean
	private Pgt00055 t00055Bean;
	private String ACT;
	private String ZJLXLX;
	private String ZJLX;
	//表单提交数据
	private String txtZJLXId;
	private String txtYXWS;
	private String txtNOTE;
	private String txtUPDATE;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Boolean isYXWS;
	 
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
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

	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		try {
			//执行查询
			tabList = t00055Service.LoadAll();
			
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		Pgt00055 t00055 = new Pgt00055();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t00055.setCd00001Zjlx(ZJLX);
				t00055.setCd00001Zjlxlx(ZJLXLX);
				t00055Bean = t00055Service.LoadByPrimaryKey(t00055);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
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
		t00055Bean = new Pgt00055();
		this.clearErrorsAndMessages();	
		
		t00055Bean.setCd00001Zjlx(txtZJLXId);
		t00055Bean.setCd00001Zjlxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_ZJLX));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t00055Bean = t00055Service.LoadByPrimaryKey(t00055Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t00055Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.t00055.zjlx")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00055Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t00055Bean.setCd00001Zjlx(txtZJLXId);
			t00055Bean.setCd00001Zjlxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_ZJLX));
			t00055Bean.setYxws(Common.convertToByte(txtYXWS));
			t00055Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00055Bean.setNote(txtNOTE);
			t00055Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t00055Service.GetInsertCommand(getT00055Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT00055Bean().getCd00001Zjlx()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT00055Bean().getCd00001Zjlx()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00055Service.GetUpdateCommand(getT00055Bean())){
					t00055Bean = t00055Service.LoadByPrimaryKey(t00055Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00055Bean().getCd00001Zjlx()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00055Bean().getCd00001Zjlx()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t00055Service.GetDeleteCommand(getT00055Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT00055Bean().getCd00001Zjlx()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT00055Bean().getCd00001Zjlx()}));
			}			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据证件类型判断位数是否有效
	 * @return
	 * @throws Exception
	 */
	public String isYxws() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("isYxws() ********** start **********");
		}
		Pgt00055 t00055 = new Pgt00055();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00055.setCd00001Zjlx(txtZJLXId);
			t00055.setCd00001Zjlxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_ZJLX));
			t00055.setYxws(Common.convertToByte(txtYXWS));
			
			isYXWS = t00055Service.validateZjlx(t00055);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("isYxws() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("isYxws() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t00055Service
	 */
	@JSON(deserialize=false, serialize=false)
	public Pgt00055Service getT00055Service() {
		return t00055Service;
	}

	/**
	 * @param t00055Service the t00055Service to set
	 */
	public void setT00055Service(Pgt00055Service t00055Service) {
		this.t00055Service = t00055Service;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgt00055> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgt00055> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the t00055Bean
	 */
	public Pgt00055 getT00055Bean() {
		return t00055Bean;
	}

	/**
	 * @param t00055Bean the t00055Bean to set
	 */
	public void setT00055Bean(Pgt00055 t00055Bean) {
		this.t00055Bean = t00055Bean;
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
	 * @return the zJLXLX
	 */
	public String getZJLXLX() {
		return ZJLXLX;
	}

	/**
	 * @param zJLXLX the zJLXLX to set
	 */
	public void setZJLXLX(String zJLXLX) {
		ZJLXLX = zJLXLX;
	}

	/**
	 * @return the zJLX
	 */
	public String getZJLX() {
		return ZJLX;
	}

	/**
	 * @param zJLX the zJLX to set
	 */
	public void setZJLX(String zJLX) {
		ZJLX = zJLX;
	}

	/**
	 * @return the txtYXWS
	 */
	public String getTxtYXWS() {
		return txtYXWS;
	}

	/**
	 * @param txtYXWS the txtYXWS to set
	 */
	public void setTxtYXWS(String txtYXWS) {
		this.txtYXWS = txtYXWS;
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
	 * @return the txtZJLXId
	 */
	public String getTxtZJLXId() {
		return txtZJLXId;
	}

	/**
	 * @param txtZJLXId the txtZJLXId to set
	 */
	public void setTxtZJLXId(String txtZJLXId) {
		this.txtZJLXId = txtZJLXId;
	}

	/**
	 * @return the isYXWS
	 */
	public Boolean getIsYXWS() {
		return isYXWS;
	}

	/**
	 * @param isYXWS the isYXWS to set
	 */
	public void setIsYXWS(Boolean isYXWS) {
		this.isYXWS = isYXWS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}


}
