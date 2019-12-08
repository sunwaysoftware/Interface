package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00003Service;
import com.sunway.service.IPgt00004Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00003;
import com.sunway.vo.Pgv00004;

/**
 * 用户组(Pgt00003)（角色）
 * @author Lee
 * @version 1.0
 * 
 */

public class Pgt00003Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -9110263325579538166L;
	//Service
	private IPgt00003Service t00003Service;
	private IPgt00004Service t00004Service;
	//view
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv00003> tabList;
	//查询条件
	private String txtROLENMFind;
	private String txtSSGXFind;
	private Boolean ISADMIN;
	//Edit
	
	//edit页面所需Bean
	private Pgt00004 t00004Bean;
	private Pgt00003 t00003Bean;
	private Pgt00002 t00002Bean;
	//primary key 主键
	private String SSGX;
	private String ROLEID;
	private String USERID;
	private String RIGHTID;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String txtROLEID;
	private String txtROLENM;
	private String txtNOTE;
	private String chkUSERID;
	private String chkRIGHTID;
	private String txtUPDATE;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private ArrayList<Pgv00004> rightList;
	private String rights;
	private String userRole;
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
			setISADMIN(Common.convertToBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN)));
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
		
		Pgv00003 v00003 = new Pgv00003();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			setISADMIN(Common.convertToBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN)));
			//准备查询条件
			v00003.setRolenm(Common.getSearchLike(txtROLENMFind));
			v00003.setPageIndex(pageIndex);
			v00003.setPageSize(getPageSize());
			v00003.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = t00003Service.LoadAll(v00003);
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
		
		Pgt00003 t00003 = new Pgt00003();
		t00003Bean = new Pgt00003();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if (!Constant.MOD_CREATE.equals(getACT())) {
				//取得用户选中的数据信息
				t00003.setRoleid(ROLEID);
				t00003Bean = t00003Service.LoadByPrimaryKey(t00003);
				rightList = t00004Service.LoadRightByRoleID(t00003Bean);
				rights="";
				for	(int i=0;i<=rightList.size()-1;i++)
					if (rightList.get(i).getIsright())
						rights=rights + rightList.get(i).getRightid() +',';
				
				
			}
			ISADMIN = Common.convertToBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN));
			if (Common.isNullOrEmpty(txtSSGXFind))
			{
				txtSSGXFind = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
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
		t00003Bean = new Pgt00003();
		this.clearErrorsAndMessages();
		t00003Bean.setRoleid(txtROLEID);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t00003Bean = t00003Service.LoadByPrimaryKey(t00003Bean);				
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t00003Bean.getRoleid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.t00003.roleid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00003Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为BEAN 赋值
			t00003Bean.setRoleid(txtROLEID);
			t00003Bean.setRolenm(txtROLENM);
			t00003Bean.setNote(txtNOTE);
			t00003Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00003Bean.setUserids(chkUSERID);
			t00003Bean.setRightids(chkRIGHTID);
			t00003Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
		String rtn = SUCCESS;
		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if (t00003Service.GetInsertCommand(getT00003Bean())==1) {
					t00003Bean = new Pgt00003();
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{Constant.STRING_EMPTY}));
				} else if (t00003Service.GetInsertCommand(getT00003Bean()) == 0) {
					this.addActionError(getText(Constant.MSG_NG_ITERANCE, new String[]{getT00003Bean().getRolenm()}));
				}
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{Constant.STRING_EMPTY}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if (t00003Service.GetUpdateCommand(getT00003Bean()) == 1) {
					t00003Bean = t00003Service.LoadByPrimaryKey(t00003Bean);
					rightList = t00004Service.LoadRightByRoleID(t00003Bean);
					rights="";
					for	(int i=0;i<=rightList.size()-1;i++)
						if (rightList.get(i).getIsright())
							rights=rights + rightList.get(i).getRightid() +',';
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00003Bean().getRolenm()}));
				} else if (t00003Service.GetUpdateCommand(getT00003Bean()) == 0) {
					this.addActionError(getText(Constant.MSG_NG_ITERANCE, new String[]{getT00003Bean().getRolenm()}));
				}
				else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00003Bean().getRolenm()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if (t00003Service.GetDeleteCommand(getT00003Bean())) {
					setISADMIN(Common.convertToBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN)));
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT00003Bean().getRolenm()}));
					rtn="successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT00003Bean().getRolenm()}));
				}
			}			
		} catch (Exception e) {
			String[] msgs=e.getMessage().split("\n");
			LOG.error(e.getMessage());
			this.addActionError(msgs[0]);

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return rtn;
	}

	/**
	 * 根据用户取得用户组信息
	 * @return
	 * @throws Exception
	 */
	public String LoadRolesByUser() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadRolesByUser() ********** start **********");
		}
		
		t00002Bean = new Pgt00002();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00002Bean.setUserid(USERID);
			t00002Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			tabList = t00003Service.LoadRoleByUserID(t00002Bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("LoadRolesByUser() ********** end **********");
			}
			return ERROR;
			
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadRolesByUser() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据用户取得用户组信息
	 * @return
	 * @throws Exception
	 */
	public String LoadRolesByUserNotAdmin() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadRolesByUserNotAdmin() ********** start **********");
		}
		
		t00002Bean = new Pgt00002();
		//Pgv00003 v00003 = new Pgv00003();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00002Bean.setUserid(USERID);
			t00002Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			tabList = t00003Service.LoadRoleByUserID(t00002Bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			
			if (LOG.isDebugEnabled()) {
				LOG.debug("LoadRolesByUserNotAdmin() ********** end **********");
			}
			return ERROR;
			
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadRolesByUserNotAdmin() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据用户取得用户组信息
	 * @return
	 * @throws Exception
	 */
	public String flushRolesByUser() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("flushRolesByUser()() ********** start **********");
		}
		
		t00002Bean = new Pgt00002();
		try {
			t00002Bean.setUserid(USERID);
			t00002Bean.setCd00001Ssgx(SSGX);
			tabList = t00003Service.LoadRoleByUserID(t00002Bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("flushRolesByUser()() ********** end **********");
			}
			return ERROR;
			
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("flushRolesByUser()() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据权限读取带状态的用户组
	 * @return
	 * @throws Exception
	 */
	public String LoadRolesByRight() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadRolesByRight() ********** start **********");
		}
		
		t00004Bean = new Pgt00004();
		try {
			t00004Bean.setRightid(RIGHTID);
			tabList = t00003Service.LoadRoleByRightID(t00004Bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("LoadRolesByRight() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadRolesByRight() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
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
	 * @return the txtROLENM
	 */
	public String getTxtROLENM() {
		return txtROLENM;
	}

	/**
	 * @param txtROLENM the txtROLENM to set
	 */
	public void setTxtROLENM(String txtROLENM) {
		this.txtROLENM = txtROLENM;
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
	 * @return the chkRIGHTID
	 */
	public String getChkRIGHTID() {
		return chkRIGHTID;
	}

	/**
	 * @param chkRIGHTID the chkRIGHTID to set
	 */
	public void setChkRIGHTID(String chkRIGHTID) {
		this.chkRIGHTID = chkRIGHTID;
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
	 * @return the iSADMIN
	 */
	public Boolean getISADMIN() {
		return ISADMIN;
	}

	/**
	 * @param iSADMIN the iSADMIN to set
	 */
	public void setISADMIN(Boolean iSADMIN) {
		ISADMIN = iSADMIN;
	}

	/**
	 * @return the rightList
	 */
	public ArrayList<Pgv00004> getRightList() {
		return rightList;
	}

	/**
	 * @param rightList the rightList to set
	 */
	public void setRightList(ArrayList<Pgv00004> rightList) {
		this.rightList = rightList;
	}

	/**
	 * @return the rights
	 */
	public String getRights() {
		return rights;
	}

	/**
	 * @param rights the rights to set
	 */
	public void setRights(String rights) {
		this.rights = rights;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

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
	 * @return the tabList
	 */
	public ArrayList<Pgv00003> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00003> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the txtSSGXFind
	 */
	public String getTxtSSGXFind() {
		return txtSSGXFind;
	}

	/**
	 * @param txtSSGXFind the txtSSGXFind to set
	 */
	public void setTxtSSGXFind(String txtSSGXFind) {
		this.txtSSGXFind = txtSSGXFind;
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
