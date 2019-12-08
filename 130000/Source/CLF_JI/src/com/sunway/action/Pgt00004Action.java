package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00004Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00004;

/**
 * 功能权限(Pgt00004)
 * @author Lee
 * @version 1.0
 */

public class Pgt00004Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -8897901747914937506L;

	//Service
	private IPgt00004Service t00004Service;
	
	//view
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv00004> tabList;
	//查询条件
	private String txtRIGHTNMFind;
	
	//Edit
	
	//edit页面所需Bean
	private Pgt00004 t00004Bean;
	private Pgt00003 t00003Bean;
	private Pgt00002 t00002Bean;
	//primary key 主键
	private String ROLEID;
	private String USERID;
	private String RIGHTID;
	//编辑操作符
	private String ACT;
	private String SSGX;
	//表单提交数据
	private String txtRIGHTID;
	private String txtRIGHTNM;
	private String txtNOTE;
	private String chkUSERID;
	private String chkROLEID;
	private String txtUPDATE;
	private Boolean isAdmin;
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
		
		Pgv00004 v00004 = new Pgv00004();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00004.setRightnm(Common.getSearchLike(txtRIGHTNMFind));
			v00004.setPageIndex(pageIndex);
			v00004.setPageSize(getPageSize());
			//执行查询
			tabList = t00004Service.LoadAll(v00004);
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = tabList.get(0).getRecordCount();
			}else{
				rowCount = 0;
				pageIndex = 1;
			}
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
		
		Pgt00004 t00004 = new Pgt00004();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				//取得用户选中的数据信息
				t00004.setRightid(RIGHTID);
				t00004Bean = t00004Service.LoadByPrimaryKey(t00004);
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
		t00004Bean = new Pgt00004();
		this.clearErrorsAndMessages();
		t00004Bean.setRightid(txtRIGHTID);
		//根据PK信息，为数据BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())){
			t00004Bean = t00004Service.LoadByPrimaryKey(t00004Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t00004Bean.getRightid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.t00002.userid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00004Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
		//为BEAN 赋值
			t00004Bean.setRightid(txtRIGHTID);
			t00004Bean.setRightnm(txtRIGHTNM);
			t00004Bean.setNote(txtNOTE);
			t00004Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00004Bean.setUserids(chkUSERID);
			t00004Bean.setRoleids(chkROLEID);
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
	public String update()throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		
		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t00004Service.GetInsertCommand(getT00004Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT00004Bean().getRightid()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT00004Bean().getRightid()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00004Service.GetUpdateCommand(getT00004Bean()))
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00004Bean().getRightid()}));
				else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00004Bean().getRightid()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t00004Service.GetDeleteCommand(getT00004Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT00004Bean().getRightid()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT00004Bean().getRightid()}));
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
		return SUCCESS;
	}
	/**
	 * Ajax用 根据用户组取得带状态的权限
	 * @return
	 */
	public String LoadRightsByRole ()throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadRightsByRole() ********** start **********");
		}
		
		t00003Bean = new Pgt00003();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00003Bean.setRoleid(ROLEID);
			tabList = t00004Service.LoadRightByRoleID(t00003Bean);
			isAdmin = Common.convertToBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN));
		} catch (Exception e) {
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadRightsByRole() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * ajax根据用户取得带状态的权限
	 * @return
	 * @throws Exception
	 */
	public String LoadRightsByUser()throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadRightsByRole() ********** start **********");
		}
		
		t00002Bean = new Pgt00002();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00002Bean.setUserid(USERID);
			t00002Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			tabList = t00004Service.LoadRightByUserID(t00002Bean);
			isAdmin = Common.convertToBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN));
		} catch (Exception e) {
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadRightsByRole() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * ajax根据用户取得带状态的权限
	 * @return
	 * @throws Exception
	 */
	public String flashRightsByUser()throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("FlashRightsByUser() ********** start **********");
		}
		
		t00002Bean = new Pgt00002();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00002Bean.setUserid(USERID);
			t00002Bean.setCd00001Ssgx(SSGX);
			tabList = t00004Service.LoadRightByUserID(t00002Bean);
			isAdmin = Common.convertToBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN));
		} catch (Exception e) {
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("FlashRightsByUser() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t00004Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00004Service getT00004Service() {
		return t00004Service;
	}

	/**
	 * @param t00004Service the t00004Service to set
	 */
	public void setT00004Service(IPgt00004Service t00004Service) {
		this.t00004Service = t00004Service;
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
	 * @return the rowCount
	 */
	public Integer getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the txtRIGHTNMFind
	 */
	public String getTxtRIGHTNMFind() {
		return txtRIGHTNMFind;
	}

	/**
	 * @param txtRIGHTNMFind the txtRIGHTNMFind to set
	 */
	public void setTxtRIGHTNMFind(String txtRIGHTNMFind) {
		this.txtRIGHTNMFind = txtRIGHTNMFind;
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
	 * @return the rIGHTID
	 */
	public String getRIGHTID() {
		return RIGHTID;
	}

	/**
	 * @param rIGHTID the rIGHTID to set
	 */
	public void setRIGHTID(String rIGHTID) {
		RIGHTID = rIGHTID;
	}

	/**
	 * @return the txtRIGHTID
	 */
	public String getTxtRIGHTID() {
		return txtRIGHTID;
	}

	/**
	 * @param txtRIGHTID the txtRIGHTID to set
	 */
	public void setTxtRIGHTID(String txtRIGHTID) {
		this.txtRIGHTID = txtRIGHTID;
	}

	/**
	 * @return the txtRIGHTNM
	 */
	public String getTxtRIGHTNM() {
		return txtRIGHTNM;
	}

	/**
	 * @param txtRIGHTNM the txtRIGHTNM to set
	 */
	public void setTxtRIGHTNM(String txtRIGHTNM) {
		this.txtRIGHTNM = txtRIGHTNM;
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
	 * @return the chkROLEID
	 */
	public String getChkROLEID() {
		return chkROLEID;
	}

	/**
	 * @param chkROLEID the chkROLEID to set
	 */
	public void setChkROLEID(String chkROLEID) {
		this.chkROLEID = chkROLEID;
	}

	/**
	 * @return the t00004Bean
	 */
	public Pgt00004 getT00004Bean() {
		return t00004Bean;
	}

	/**
	 * @param t00004Bean the t00004Bean to set
	 */
	public void setT00004Bean(Pgt00004 t00004Bean) {
		this.t00004Bean = t00004Bean;
	}

	/**
	 * @return the t00003Bean
	 */
	public Pgt00003 getT00003Bean() {
		return t00003Bean;
	}

	/**
	 * @param t00003Bean the t00003Bean to set
	 */
	public void setT00003Bean(Pgt00003 t00003Bean) {
		this.t00003Bean = t00003Bean;
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
	 * @param isAdmin the isAdmin to set
	 */
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	/**
	 * @return the isAdmin
	 */
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv00004> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00004> tabList) {
		this.tabList = tabList;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}


}
