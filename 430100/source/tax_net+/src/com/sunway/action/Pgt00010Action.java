package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00003Service;
import com.sunway.service.IPgt00010Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00010;
import com.sunway.vo.Pgv00003;

/**
 * 用户_用户组(Pgt00010)
 * @author zhang
 * @version 1.0
 * 
 */


public class Pgt00010Action extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -8533353935815966530L;
	
	//Service
	private IPgt00010Service t00010Service;
	private IPgt00003Service t00003Service;
	
	//view
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	//Bean数组	
	private ArrayList<Pgv00003> roleList;	
	
	//查询条件
	private String txtROLENMFind;
	
	private Boolean ISADMIN;
	
	//Edit
	
	//edit页面所需Bean
	private Pgt00010 t00010Bean;
	private Pgt00002 t00002Bean;
	private Pgt00003 t00003Bean;
	private String txtSSGXFind;
	
	
	

	//primary key 主键
	private String SSGX;
	private String ROLEID;
	private String USERID;
	//编辑操作符
	private String ACT;
	
	
	//表单提交数据
	private String txtUserID;
	private String txtROLEID;
	private String txtUPDATE;
	private String chkUSERID;
	private String txtNOTE;
	
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
			setISADMIN(ConvertUtil.toBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN)));
			if (ISADMIN) {
				if (CheckUtil.chkEmpty(txtSSGXFind))
				{
					txtSSGXFind = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
				}
			}
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
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t00010Bean = new Pgt00010();
		this.clearErrorsAndMessages();
//		t00010Bean.setCd00002Userid(txtUserID);
//		t00010Bean.setCd00003Roleid(txtROLEID);
//		//根据PK信息，为数据BEAN赋值
//		if (!Constant.MOD_DELETE.equals(getACT())){
//			t00010Bean = t00010Service.LoadByPrimaryKey(t00010Bean);				
//		}
		//判断PK是否重复
//		if(
//				(Constant.MOD_CREATE.equals(getACT()))&&
//				(!CheckUtil.chkEmpty(t00010Bean.getCd00003Roleid())))
//		  {
//			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.t00003.roleid")}));
//		}
		//判读数据是否已经被其他用户修改
//		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00010Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
//			this.addActionError(getText("app.msg.error.pktime"));
//		}else{
			//为BEAN 赋值
			t00010Bean.setCd00003Roleid(txtROLEID);
			t00010Bean.setCd00002Userid(txtUserID);
			t00010Bean.setNote(txtNOTE);
			t00010Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00010Bean.setUserIds(chkUSERID);
			if (CheckUtil.chkEmpty(txtSSGXFind))
			{
				txtSSGXFind = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			}
			t00010Bean.setSsgx(txtSSGXFind);
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
	public String update()throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		String rtn = SUCCESS;
		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if (t00010Service.GetBatchInsCommand(getT00010Bean())) {
					t00010Bean = new Pgt00010();
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{Constant.STRING_EMPTY}));
				} else if 
				(!t00010Service.GetBatchInsCommand(getT00010Bean())) {
					this.addActionError(getText(Constant.MSG_NG_ITERANCE, new String[]{
							getT00010Bean().getCd00003Roleid()}));				
				} else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{Constant.STRING_EMPTY}));
			}
			else 
			if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if (t00010Service.GetBatchInsCommand(getT00010Bean())) {
					t00003Bean = new Pgt00003();
					t00003Bean.setRoleid(txtROLEID);
					t00003Bean = t00003Service.LoadByPrimaryKey(t00003Bean);
					//t00010Bean = t00010Service.LoadByPrimaryKey(t00010Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00010Bean().getCd00003Roleid()}));
				} else if (!t00010Service.GetBatchInsCommand(getT00010Bean())) {
					this.addActionError(getText(Constant.MSG_NG_ITERANCE, new String[]{getT00010Bean().getCd00003Roleid()}));
				}
				else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00010Bean().getCd00003Roleid()}));
			}
			else
			if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if (t00010Service.GetDeleteCommand(getT00010Bean())) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT00010Bean().getCd00003Roleid()}));
					rtn="successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT00010Bean().getCd00003Roleid()}));
				}
			}			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			String[] msgs=e.getMessage().split("\n");
			this.addActionError(msgs[0]);

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return rtn;
	}		
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t00010Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00010Service getT00010Service() {
		return t00010Service;
	}

	/**
	 * @param t00010Service the t00010Service to set
	 */
	public void setT00010Service(IPgt00010Service t00010Service) {
		this.t00010Service = t00010Service;
	}
	
	/**
	 * @return the t00003Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00003Service getT00003Service() {
		return t00003Service;
	}

	/**
	 * @param t00003Service the t00003Service to set
	 */
	public void setT00003Service(IPgt00003Service t00003Service) {
		this.t00003Service = t00003Service;
	}

	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}	

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the txtROLENMFind
	 */
	public String getTxtROLENMFind() {
		return txtROLENMFind;
	}

	/**
	 * @param txtROLENMFind the txtROLENMFind to set
	 */
	public void setTxtROLENMFind(String txtROLENMFind) {
		this.txtROLENMFind = txtROLENMFind;
	}

	/**
	 * @return the roleList
	 */
	public ArrayList<Pgv00003> getRoleList() {
		return roleList;
	}

	/**
	 * @param roleList the roleList to set
	 */
	public void setRoleList(ArrayList<Pgv00003> roleList) {
		this.roleList = roleList;
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
	 * @return the rOLEID
	 */
	public String getROLEID() {
		return ROLEID;
	}

	/**
	 * @param rOLEID the rOLEID to set
	 */
	public void setROLEID(String rOLEID) {
		ROLEID = rOLEID;
	}

	/**
	 * @return the txtROLEID
	 */
	public String getTxtROLEID() {
		return txtROLEID;
	}

	/**
	 * @param txtROLEID the txtROLEID to set
	 */
	public void setTxtROLEID(String txtROLEID) {
		this.txtROLEID = txtROLEID;
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
	 * @return the uSERID
	 */
	public String getUSERID() {
		return USERID;
	}

	/**
	 * @param uSERID the uSERID to set
	 */
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}

	

	/**
	 * @return the chkUSERID
	 */
	public String getChkUSERID() {
		return chkUSERID;
	}

	/**
	 * @param chkUSERID the chkUSERID to set
	 */
	public void setChkUSERID(String chkUSERID) {
		this.chkUSERID = chkUSERID;
	}

	

	/**
	 * @return the sSGX
	 */
	public String getSSGX() {
		return SSGX;
	}

	/**
	 * @param sSGX the sSGX to set
	 */
	public void setSSGX(String sSGX) {
		SSGX = sSGX;
	}



	/**
	 * @param t00010Bean the t00010Bean to set
	 */
	public void setT00010Bean(Pgt00010 t00010Bean) {
		this.t00010Bean = t00010Bean;
	}

	/**
	 * @return the t00003Bean
	 */
	public Pgt00010 getT00010Bean() {
		return t00010Bean;
	}

	/**
	 * @return the t00002Bean
	 */
	public Pgt00002 getT00002Bean() {
		return t00002Bean;
	}

	/**
	 * @param t00002Bean the t00002Bean to set
	 */
	public void setT00002Bean(Pgt00002 t00002Bean) {
		this.t00002Bean = t00002Bean;
	}
	
	public Pgt00003 getT00003Bean() {
		return t00003Bean;
	}
	public void setT00003Bean(Pgt00003 bean) {
		t00003Bean = bean;
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

	public void setISADMIN(Boolean iSADMIN) {
		ISADMIN = iSADMIN;
	}

	public Boolean getISADMIN() {
		return ISADMIN;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the txtUserID
	 */
	public String getTxtUserID() {
		return txtUserID;
	}

	/**
	 * @param txtUserID the txtUserID to set
	 */
	public void setTxtUserID(String txtUserID) {
		this.txtUserID = txtUserID;
	}

	public String getTxtSSGXFind() {
		return txtSSGXFind;
	}

	public void setTxtSSGXFind(String txtSSGXFind) {
		this.txtSSGXFind = txtSSGXFind;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}	
}
