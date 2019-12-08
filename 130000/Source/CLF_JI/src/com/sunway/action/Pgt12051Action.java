package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12051Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12051;
import com.sunway.vo.Pgv12051;

/**
 * 免税比例维护(Pgt12051)
 * @author Lee
 * @version 1.0
 */

public class Pgt12051Action extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -4097101986895198520L;

	private IPgt12051Service t12051Service;
	
	//View
	private ArrayList<Pgv12051> msblList;
	
	//Edit
	
	//edit页面所需Bean
	private Pgt12051 t12051Bean;
	private ArrayList<Pgt12051> t12051List;
	//primary key 主键
	private String MSSZ;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String txtMSSZ;
	private String txtNOTE;
	private String txtUPDATE;
	private String txtBLXS;
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
		
		Pgv12051 v12051 = new Pgv12051();
		try {
			//执行查询
			msblList = t12051Service.LoadAll(v12051);
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
		
		Pgt12051 t12051 = new Pgt12051();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t12051.setCd00001Mssz(MSSZ);
				t12051.setCd00001Msszlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_MSSZ));
				t12051Bean = t12051Service.LoadByPrimaryKey(t12051);
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
		t12051Bean = new Pgt12051();
		this.clearErrorsAndMessages();	
		t12051Bean.setCd00001Mssz(MSSZ);
		t12051Bean.setCd00001Msszlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_MSSZ));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t12051Bean = t12051Service.LoadByPrimaryKey(t12051Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t12051Bean.getCd00001Mssz()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.t00002.userid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t12051Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t12051Bean.setCd00001Mssz(MSSZ);
			t12051Bean.setCd00001Msszlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_MSSZ));
			t12051Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t12051Bean.setNote(Common.convertEncoding(txtNOTE));
			t12051Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t12051Bean.setBlxs(Common.convertToDouble(txtBLXS));
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
				if(t12051Service.GetInsertCommand(getT12051Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT12051Bean().getCd00001Mssz()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT12051Bean().getCd00001Mssz()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t12051Service.GetUpdateCommand(getT12051Bean())){
					t12051Bean = t12051Service.LoadByPrimaryKey(t12051Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT12051Bean().getCd00001Mssz()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT12051Bean().getCd00001Mssz()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t12051Service.GetDeleteCommand(getT12051Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT12051Bean().getCd00001Mssz()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT12051Bean().getCd00001Mssz()}));
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
	 * 点击单选按钮的ajax事件，
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String createByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		
		t12051List = new ArrayList<Pgt12051>();
		Pgt12051 t12051 = new Pgt12051();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t12051.setCd00001Mssz(MSSZ);
				t12051.setCd00001Msszlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_MSSZ));
				t12051Bean = t12051Service.LoadByPrimaryKey(t12051);
				if (t12051Bean.getCd00001Mssz() == null) {
					t12051Bean.setBlxs(Common.convertToDouble("0"));
					t12051Bean.setNote("");
				}
				t12051List.add(t12051Bean);
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
	
	/*********************** set and get ******************************/

	/**
	 * @return the t12051Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12051Service getT12051Service() {
		return t12051Service;
	}

	/**
	 * @param t12051Service the t12051Service to set
	 */
	public void setT12051Service(IPgt12051Service t12051Service) {
		this.t12051Service = t12051Service;
	}

	/**
	 * @return the msblList
	 */
	public ArrayList<Pgv12051> getMsblList() {
		return msblList;
	}

	/**
	 * @param msblList the msblList to set
	 */
	public void setMsblList(ArrayList<Pgv12051> msblList) {
		this.msblList = msblList;
	}

	/**
	 * @return the t12051Bean
	 */
	public Pgt12051 getT12051Bean() {
		return t12051Bean;
	}

	/**
	 * @param t12051Bean the t12051Bean to set
	 */
	public void setT12051Bean(Pgt12051 t12051Bean) {
		this.t12051Bean = t12051Bean;
	}

	/**
	 * @return the t12051List
	 */
	public ArrayList<Pgt12051> getT12051List() {
		return t12051List;
	}

	/**
	 * @param t12051List the t12051List to set
	 */
	public void setT12051List(ArrayList<Pgt12051> t12051List) {
		this.t12051List = t12051List;
	}

	/**
	 * @return the mSSZ
	 */
	public String getMSSZ() {
		return MSSZ;
	}

	/**
	 * @param mSSZ the mSSZ to set
	 */
	public void setMSSZ(String mSSZ) {
		MSSZ = mSSZ;
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
	 * @return the txtMSSZ
	 */
	public String getTxtMSSZ() {
		return txtMSSZ;
	}

	/**
	 * @param txtMSSZ the txtMSSZ to set
	 */
	public void setTxtMSSZ(String txtMSSZ) {
		this.txtMSSZ = txtMSSZ;
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
	 * @return the txtBLXS
	 */
	public String getTxtBLXS() {
		return txtBLXS;
	}

	/**
	 * @param txtBLXS the txtBLXS to set
	 */
	public void setTxtBLXS(String txtBLXS) {
		this.txtBLXS = txtBLXS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

	
}
