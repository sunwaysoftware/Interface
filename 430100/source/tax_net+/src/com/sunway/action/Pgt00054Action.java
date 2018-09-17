package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.impl.Pgt00054Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00054;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00054;

/**
 * 评税结果检验维护(Pgt00054)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt00054Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 7911566137509753746L;

	//Service
	private Pgt00054Service t00054Service;
	
	//View
	private String ddlSZQYFind;
	//Bean数组
	private ArrayList<Pgv00054> jybzjList;
	private ArrayList<Pgv00052> szqyList;
	//Edit
	
	//edit页面所需Bean
	private Pgt00054 t00054Bean;
	private String ACT;
	private String BZBM;
	private String SZQY;
	//表单提交数据
	private String txtBZBM;
	private String txtBZMC;
	private String txtJZQSMIN;
	private String txtJZQSMAX;
	private String txtLSXSMIN;
	private String txtLSXSMAX;
	private String txtJGXGCMIN;
	private String txtJGXGCMAX;
	private String txtNOTE;
	private String txtUPDATE;
	private String ddlSZQY;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();
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
		
		Pgv00054 v00054 = new Pgv00054();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00054.setCd00001Szqy(ddlSZQYFind);
			v00054.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			//执行查询
			jybzjList = t00054Service.LoadAll(v00054);
			
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
		
		Pgt00054 t00054 = new Pgt00054();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t00054.setBzbm(BZBM);
				t00054.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t00054.setCd00001Szqy(SZQY);
				t00054Bean = t00054Service.LoadByPrimaryKey(t00054);
			}
			szqyList = sessionCtrl.ReadSzqyList();
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
		t00054Bean = new Pgt00054();
		this.clearErrorsAndMessages();	
		
		szqyList = sessionCtrl.ReadSzqyList();
		
		t00054Bean.setBzbm(txtBZBM);
		t00054Bean.setCd00001Szqy(ddlSZQY);
		t00054Bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t00054Bean = t00054Service.LoadByPrimaryKey(t00054Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!CheckUtil.chkEmpty(t00054Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.t00054.bzbm")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00054Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t00054Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00054Bean.setNote(txtNOTE);
			t00054Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t00054Bean.setBzbm(txtBZBM);
			t00054Bean.setBzmc(txtBZMC);
			t00054Bean.setJzqsMin(ConvertUtil.toDouble(txtJZQSMIN));
			t00054Bean.setJzqsMax(ConvertUtil.toDouble(txtJZQSMAX));
			t00054Bean.setLsxsMin(ConvertUtil.toDouble(txtLSXSMIN));
			t00054Bean.setLsxsMax(ConvertUtil.toDouble(txtLSXSMAX));
			t00054Bean.setJgxgcMin(ConvertUtil.toDouble(txtJGXGCMIN));
			t00054Bean.setJgxgcMax(ConvertUtil.toDouble(txtJGXGCMAX));
			
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
				if(t00054Service.GetInsertCommand(getT00054Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT00054Bean().getBzbm()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT00054Bean().getBzbm()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00054Service.GetUpdateCommand(getT00054Bean())){
					t00054Bean = t00054Service.LoadByPrimaryKey(t00054Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00054Bean().getBzbm()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00054Bean().getBzbm()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t00054Service.GetDeleteCommand(getT00054Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT00054Bean().getBzbm()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT00054Bean().getBzbm()}));
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
	
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t00054Service
	 */
	@JSON(deserialize=false, serialize=false)
	public Pgt00054Service getT00054Service() {
		return t00054Service;
	}

	/**
	 * @param t00054Service the t00054Service to set
	 */
	public void setT00054Service(Pgt00054Service t00054Service) {
		this.t00054Service = t00054Service;
	}

	/**
	 * @return the jybzjList
	 */
	public ArrayList<Pgv00054> getJybzjList() {
		return jybzjList;
	}

	/**
	 * @param jybzjList the jybzjList to set
	 */
	public void setJybzjList(ArrayList<Pgv00054> jybzjList) {
		this.jybzjList = jybzjList;
	}

	/**
	 * @return the t00054Bean
	 */
	public Pgt00054 getT00054Bean() {
		return t00054Bean;
	}

	/**
	 * @param t00054Bean the t00054Bean to set
	 */
	public void setT00054Bean(Pgt00054 t00054Bean) {
		this.t00054Bean = t00054Bean;
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
	 * @return the bZBM
	 */
	public String getBZBM() {
		return BZBM;
	}

	/**
	 * @param bZBM the bZBM to set
	 */
	public void setBZBM(String bZBM) {
		BZBM = bZBM;
	}

	/**
	 * @return the txtJZQSMIN
	 */
	public String getTxtJZQSMIN() {
		return txtJZQSMIN;
	}

	/**
	 * @param txtJZQSMIN the txtJZQSMIN to set
	 */
	public void setTxtJZQSMIN(String txtJZQSMIN) {
		this.txtJZQSMIN = txtJZQSMIN;
	}

	/**
	 * @return the txtJZQSMAX
	 */
	public String getTxtJZQSMAX() {
		return txtJZQSMAX;
	}

	/**
	 * @param txtJZQSMAX the txtJZQSMAX to set
	 */
	public void setTxtJZQSMAX(String txtJZQSMAX) {
		this.txtJZQSMAX = txtJZQSMAX;
	}

	/**
	 * @return the txtLSXSMIN
	 */
	public String getTxtLSXSMIN() {
		return txtLSXSMIN;
	}

	/**
	 * @param txtLSXSMIN the txtLSXSMIN to set
	 */
	public void setTxtLSXSMIN(String txtLSXSMIN) {
		this.txtLSXSMIN = txtLSXSMIN;
	}

	/**
	 * @return the txtLSXSMAX
	 */
	public String getTxtLSXSMAX() {
		return txtLSXSMAX;
	}

	/**
	 * @param txtLSXSMAX the txtLSXSMAX to set
	 */
	public void setTxtLSXSMAX(String txtLSXSMAX) {
		this.txtLSXSMAX = txtLSXSMAX;
	}

	/**
	 * @return the txtJGXGCMIN
	 */
	public String getTxtJGXGCMIN() {
		return txtJGXGCMIN;
	}

	/**
	 * @param txtJGXGCMIN the txtJGXGCMIN to set
	 */
	public void setTxtJGXGCMIN(String txtJGXGCMIN) {
		this.txtJGXGCMIN = txtJGXGCMIN;
	}

	/**
	 * @return the txtJGXGCMAX
	 */
	public String getTxtJGXGCMAX() {
		return txtJGXGCMAX;
	}

	/**
	 * @param txtJGXGCMAX the txtJGXGCMAX to set
	 */
	public void setTxtJGXGCMAX(String txtJGXGCMAX) {
		this.txtJGXGCMAX = txtJGXGCMAX;
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
	 * @return the txtBZBM
	 */
	public String getTxtBZBM() {
		return txtBZBM;
	}

	/**
	 * @param txtBZBM the txtBZBM to set
	 */
	public void setTxtBZBM(String txtBZBM) {
		this.txtBZBM = txtBZBM;
	}

	/**
	 * @return the txtBZMC
	 */
	public String getTxtBZMC() {
		return txtBZMC;
	}

	/**
	 * @param txtBZMC the txtBZMC to set
	 */
	public void setTxtBZMC(String txtBZMC) {
		this.txtBZMC = txtBZMC;
	}

	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	/**
	 * @return the ddlSZQYFind
	 */
	public String getDdlSZQYFind() {
		return ddlSZQYFind;
	}

	/**
	 * @param ddlSZQYFind the ddlSZQYFind to set
	 */
	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
	}

	/**
	 * @return the sZQY
	 */
	public String getSZQY() {
		return SZQY;
	}

	/**
	 * @param sZQY the sZQY to set
	 */
	public void setSZQY(String sZQY) {
		SZQY = sZQY;
	}

	/**
	 * @return the ddlSZQY
	 */
	public String getDdlSZQY() {
		return ddlSZQY;
	}

	/**
	 * @param ddlSZQY the ddlSZQY to set
	 */
	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}


}
