package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00002Service;
import com.sunway.service.IPgt00009Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00009;
import com.sunway.vo.Pgv00009;

/**
 * 用户所在税收管辖区域(Pgt00009)
 * @author Lee
 * @version 1.0
 */

public class Pgt00009Action extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 3653451816212603303L;
	
	//Service
	private IPgt00009Service t00009Service;
	private IPgt00002Service t00002Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv00009> ssgxList;
	//查询条件
	private String txtUSERIDFind;
	private String txtUSERNMFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt00009 t00009Bean;
	private ArrayList<Pgt00009> t00009List;
	//primary key 主键
	private String SSGX;
	private String USERID;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String txtNOTE;
	private String txtUPDATE;
	private String txtUSERID;
	private String chkROLEID;
	private String chkRIGHTID;
	private Boolean ISADMIN;
	private String hidSSGX;
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
		
		Pgv00009 v00009 = new Pgv00009();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00009.setCd00002Userid(Common.getSearchLike(Common.convertEncoding(txtUSERIDFind)));
			v00009.setUsernm(Common.getSearchLike(Common.convertEncoding(txtUSERNMFind)));
			v00009.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00009.setPageIndex(pageIndex);
			v00009.setPageSize(getPageSize());
			//执行查询
			ssgxList = t00009Service.LoadAll(v00009);
			//分页设置
			if(null!=ssgxList && ssgxList.size()>0){
				rowCount = ssgxList.get(0).getRecordCount();
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
		Pgt00009 t00009 = new Pgt00009();
		
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				t00009.setCd00001Ssgx(SSGX);
				t00009.setCd00001Ssgxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SSGX));
				t00009.setCd00002Userid(USERID);
				t00009Bean = t00009Service.LoadByPrimaryKey(t00009);
			}else{
				SSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			}
			loadIsAdmin();
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
		this.clearErrorsAndMessages();
		t00009Bean = new Pgt00009();
		
		loadIsAdmin();
		
		t00009Bean.setCd00002Userid(txtUSERID);
		if (Common.isNullOrEmpty(hidSSGX)) {
			t00009Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}else{
			t00009Bean.setCd00001Ssgx(hidSSGX);
		}
		t00009Bean.setCd00001Ssgxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SSGX));
		t00009Bean = t00009Service.LoadByPrimaryKey(t00009Bean);
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t00009Bean.getUpddate()))){
			//如果重复数据，则将操作符号修改为更新
			//setACT(Constant.MOD_UPDATE);
			setTxtUPDATE(t00009Bean.getUpddate().toString());
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00009Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			t00009Bean.setCd00002Userid(txtUSERID);
			t00009Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00009Bean.setNote(Common.convertEncoding(txtNOTE));
			t00009Bean.setRightids(chkRIGHTID);
			t00009Bean.setRoleids(chkROLEID);
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
				if(t00009Service.GetInsertCommand(getT00009Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT00009Bean().getCd00002Userid()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT00009Bean().getCd00002Userid()}));
			}else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00009Service.GetUpdateCommand(getT00009Bean())){
					t00009Bean = t00009Service.LoadByPrimaryKey(t00009Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00009Bean().getCd00002Userid()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00009Bean().getCd00002Userid()}));
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
	 * 点击删除按钮的ajax事件，
	 * @return 
	 * @throws Exception
	 */
	public String deleteByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("deleteByAjax() ********** start **********");
		}
		
		Pgt00009 t00009 = new Pgt00009();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t00009.setCd00001Ssgx(SSGX);
				t00009.setCd00001Ssgxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SSGX));
				t00009.setCd00002Userid(USERID);
				t00009.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
				
				t00009Service.GetDeleteCommand(t00009);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("deleteByAjax() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("deleteByAjax() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String createByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		Pgt00009 t00009 = new Pgt00009();
		
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00009.setCd00001Ssgx(SSGX);
			t00009.setCd00001Ssgxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SSGX));
			t00009.setCd00002Userid(USERID);
			t00009Bean = t00009Service.LoadByPrimaryKey(t00009);
			isExists = t00009Bean.getUpddate() == null?true:false;
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
	
	/**
	 * 读取当前登陆用户是否为管理员 
	 * @throws Exception
	 */
	private void loadIsAdmin() throws Exception{
		Pgt00002 t00002 = new Pgt00002();
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t00002.setUserid(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
		t00002 =  t00002Service.LoadByPrimaryKey(t00002);
		ISADMIN = t00002.getIsadmin();
	}
	/*********************** set and get ******************************/

	/**
	 * @return the t00009Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00009Service getT00009Service() {
		return t00009Service;
	}

	/**
	 * @param t00009Service the t00009Service to set
	 */
	public void setT00009Service(IPgt00009Service t00009Service) {
		this.t00009Service = t00009Service;
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
	 * @return the ssgxList
	 */
	public ArrayList<Pgv00009> getSsgxList() {
		return ssgxList;
	}

	/**
	 * @param ssgxList the ssgxList to set
	 */
	public void setSsgxList(ArrayList<Pgv00009> ssgxList) {
		this.ssgxList = ssgxList;
	}

	/**
	 * @return the txtUSERIDFind
	 */
	public String getTxtUSERIDFind() {
		return txtUSERIDFind;
	}

	/**
	 * @param txtUSERIDFind the txtUSERIDFind to set
	 */
	public void setTxtUSERIDFind(String txtUSERIDFind) {
		this.txtUSERIDFind = txtUSERIDFind;
	}

	/**
	 * @return the txtUSERNMFind
	 */
	public String getTxtUSERNMFind() {
		return txtUSERNMFind;
	}

	/**
	 * @param txtUSERNMFind the txtUSERNMFind to set
	 */
	public void setTxtUSERNMFind(String txtUSERNMFind) {
		this.txtUSERNMFind = txtUSERNMFind;
	}

	/**
	 * @return the t00009Bean
	 */
	public Pgt00009 getT00009Bean() {
		return t00009Bean;
	}

	/**
	 * @param t00009Bean the t00009Bean to set
	 */
	public void setT00009Bean(Pgt00009 t00009Bean) {
		this.t00009Bean = t00009Bean;
	}

	/**
	 * @return the t00009List
	 */
	public ArrayList<Pgt00009> getT00009List() {
		return t00009List;
	}

	/**
	 * @param t00009List the t00009List to set
	 */
	public void setT00009List(ArrayList<Pgt00009> t00009List) {
		this.t00009List = t00009List;
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
	 * @return the txtUSERID
	 */
	public String getTxtUSERID() {
		return txtUSERID;
	}

	/**
	 * @param txtUSERID the txtUSERID to set
	 */
	public void setTxtUSERID(String txtUSERID) {
		this.txtUSERID = txtUSERID;
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
	 * @return the t00002Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00002Service getT00002Service() {
		return t00002Service;
	}

	/**
	 * @param t00002Service the t00002Service to set
	 */
	public void setT00002Service(IPgt00002Service t00002Service) {
		this.t00002Service = t00002Service;
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
	 * @return the hidSSGX
	 */
	public String getHidSSGX() {
		return hidSSGX;
	}

	/**
	 * @param hidSSGX the hidSSGX to set
	 */
	public void setHidSSGX(String hidSSGX) {
		this.hidSSGX = hidSSGX;
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
