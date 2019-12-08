package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12083Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12083;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv12083;

/**
 * 审核土地面积(Pgt12083)
 * @author Lee
 * @version 1.0
 */

public class Pgt12083Action extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -5355336716484308775L;

	private IPgt12083Service t12083Service;
	
	//View
	
	//Bean数组
	private ArrayList<Pgv12083> tdmjList;
	private ArrayList<Pgv00052> szqyList;
	private String ddlSZQYFind;
	
	//Edit
	
	private Pgt12083 t12083Bean;
	//primary key 主键
	private String SZQY;
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtMINVALUE;
	private String txtMAXVALUE;
	private String txtUPDATE;
	private String txtNOTE;
	private Boolean isExists;
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
		
		Pgv12083 v12083 = new Pgv12083();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v12083.setCd00001Szqy(ddlSZQYFind);
			v12083.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tdmjList = t12083Service.LoadAll(v12083);
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
		
		Pgt12083 t12083 = new Pgt12083();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())) {
				//取得用户选中的数据信息
				t12083.setCd00001Szqy(SZQY);
				t12083.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t12083Bean = t12083Service.LoadByPrimaryKey(t12083);
				if (t12083Bean.getUpddate() == null) {
					t12083Bean.setCd00001Szqy(SZQY);
					t12083Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
					t12083Bean.setMinvalue(Common.convertToDouble("0"));		
					t12083Bean.setMaxvalue(Common.convertToDouble("0"));
					t12083Bean.setNote("");
					setACT(Constant.MOD_CREATE);
				}
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
		t12083Bean = new Pgt12083();
		this.clearErrorsAndMessages();
		//为PK赋值
		t12083Bean.setCd00001Szqy(ddlSZQY);
		t12083Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		//根据PK取得信息，并为BEAN赋值
		if(!Constant.MOD_DELETE.equals(getACT()))
			t12083Bean = t12083Service.LoadByPrimaryKey(t12083Bean);
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t12083Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN 赋值
			t12083Bean.setCd00001Szqy(ddlSZQY);
			t12083Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
			t12083Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t12083Bean.setMinvalue(Common.convertToDouble(txtMINVALUE));		
			t12083Bean.setMaxvalue(Common.convertToDouble(txtMAXVALUE));
			t12083Bean.setNote(Common.convertEncoding(txtNOTE));
			t12083Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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

		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t12083Service.GetInsertCommand(getT12083Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT12083Bean().getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT12083Bean().getCd00001Szqy()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t12083Service.GetUpdateCommand(getT12083Bean())){
					t12083Bean = t12083Service.LoadByPrimaryKey(t12083Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT12083Bean().getCd00001Szqy()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT12083Bean().getCd00001Szqy()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t12083Service.GetDeleteCommand(getT12083Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT12083Bean().getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT12083Bean().getCd00001Szqy()}));
			}	
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();
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
	 * 点击单选按钮的ajax事件，
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String createByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt12083 t12083 = new Pgt12083();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t12083.setCd00001Szqy(ddlSZQY);
				t12083.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t12083Bean = t12083Service.LoadByPrimaryKey(t12083);
				isExists = t12083Bean.getUpddate() == null?true:false;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("createByAjax() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** setter and getter ******************************/
	
	/**
	 * @return the t12083Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12083Service getT12083Service() {
		return t12083Service;
	}

	/**
	 * @param t12083Service the t12083Service to set
	 */
	public void setT12083Service(IPgt12083Service t12083Service) {
		this.t12083Service = t12083Service;
	}

	/**
	 * @return the tdmjList
	 */
	public ArrayList<Pgv12083> getTdmjList() {
		return tdmjList;
	}

	/**
	 * @param tdmjList the tdmjList to set
	 */
	public void setTdmjList(ArrayList<Pgv12083> tdmjList) {
		this.tdmjList = tdmjList;
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
	 * @return the t12083Bean
	 */
	public Pgt12083 getT12083Bean() {
		return t12083Bean;
	}

	/**
	 * @param t12083Bean the t12083Bean to set
	 */
	public void setT12083Bean(Pgt12083 t12083Bean) {
		this.t12083Bean = t12083Bean;
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

	/**
	 * @return the txtMINVALUE
	 */
	public String getTxtMINVALUE() {
		return txtMINVALUE;
	}

	/**
	 * @param txtMINVALUE the txtMINVALUE to set
	 */
	public void setTxtMINVALUE(String txtMINVALUE) {
		this.txtMINVALUE = txtMINVALUE;
	}

	/**
	 * @return the txtMAXVALUE
	 */
	public String getTxtMAXVALUE() {
		return txtMAXVALUE;
	}

	/**
	 * @param txtMAXVALUE the txtMAXVALUE to set
	 */
	public void setTxtMAXVALUE(String txtMAXVALUE) {
		this.txtMAXVALUE = txtMAXVALUE;
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
	 * @return the isExists
	 */
	public Boolean getIsExists() {
		return isExists;
	}

	/**
	 * @param isExists the isExists to set
	 */
	public void setIsExists(Boolean isExists) {
		this.isExists = isExists;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

	
}
