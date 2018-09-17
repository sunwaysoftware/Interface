package com.sunway.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.exception.GenericJDBCException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00001Service;
import com.sunway.service.IPgt00002Service;
import com.sunway.service.IPgt00009Service;
import com.sunway.service.IPgt00012Service;
import com.sunway.service.IPgt00052Service;
import com.sunway.util.Common;
import com.sunway.util.MD5;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00012;
import com.sunway.vo.Pgv00009;
import com.sunway.vo.Pgv00052;

/**
 * 
 * 系统登录管理
 * @author Andy.Gao
 *
 */
public class LogManageAction extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = -3106055285904114944L;
	private IPgt00001Service t00001Service;
	private IPgt00002Service t00002Service;
	private IPgt00052Service t00052Service;
	private IPgt00009Service t00009Service;
	private IPgt00012Service t00012Service;
	private ArrayList<Pgt00002> userList;
	private Pgt00002 userBean;
	private Pgt00012 t00012Bean;
	private String userName;
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv00009> ssgxList;
	private String ddlSSGX;
	private String SSGX;
	//UI
	private String txtUserID;
	private String txtUserPwd;
	private String PSSDYMD;
	private String USER;
	private String userRole;
	private Boolean ISADMIN;
	private String txtRand;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Pgt00002 t00002Bean;
	private Integer QXID;
	
	/**
	 * 用户登录判定
	 */
	public void validateLogin() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateLogin() ********** start **********"+Common.getCurrentTime());
		}
	/*	
		String arandom=(String)(sessionCtrl.Get(SessionCtrl.SESSION_KEY_RANDPIC));
		if(!arandom.equals(txtRand)) {
			addActionError("验证码错误");
			return;
		}*/
		
		@SuppressWarnings("unused")
		HttpServletRequest request = ServletActionContext.getRequest();
		this.clearErrorsAndMessages();
		Pgt00002 user = new Pgt00002();
		user.setUserid(txtUserID);
		user.setUserpwd(MD5.MD5Encrypt(txtUserPwd));
		//user.setUserip(Common.getIpAddr(request));
		try {
			//用户登陆判读
			user = t00002Service.CheckLogin(user);
			if(null!=user && user.getLoginState()==0)
				this.addActionError(user.getLoginMessage());
			else{
				userBean = user;		
			}
		} catch (SQLException eJDBC) {
			eJDBC.printStackTrace();
			LOG.error("LogManageAction -- validateLogin()", eJDBC);
			this.addActionError(getText("app.msg.error.dbconn"));
		} catch (GenericJDBCException eJDBC) {
			eJDBC.printStackTrace();
			LOG.error("LogManageAction -- validateLogin()", eJDBC);
			this.addActionError(getText("app.msg.error.dbconn"));			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("LogManageAction -- validateLogin()", e);
			this.addActionError(e.getMessage());
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateLogin() ********** end **********"+Common.getCurrentTime());
		}
	}
	
	/**
	 * 用户登录
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("login() ********** start **********"+Common.getCurrentTime());
		}
		try {
			//设置用户相关的SESSION
			//保存登录用户信息
			SetUserSession(userBean);			
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("LogManageAction -- login()", e);
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("login() ********** end **********"+Common.getCurrentTime());
		}
		return SUCCESS;
	}
	/**
	 * 获取首页税收管辖列表
	 * @return
	 * @throws Exception
	 */
	public String getTopSSGXList() throws Exception { 
		if (LOG.isDebugEnabled()) {
			LOG.debug("getTopSSGXList() ********** start **********");
		}
		  ActionContext.getContext().getSession();
		try {
			USER = sessionCtrl.getUserName();
			Pgt00002 t00002 = new Pgt00002();
			//取得用户选中的数据信息
			t00002.setUserid(Common.convertEncoding(sessionCtrl.getUserId()));
			//获取用户的权限ID
			t00002Bean = t00002Service.LoadByPrimaryKey(t00002);		
			QXID=t00002Bean.getQxid();
		} catch (Exception e) {
			LOG.error("getTopSSGXList()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("reSetSSGX() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("getTopSSGXList() ********** end **********");
		}
	    return SUCCESS;
	}
	/**
	 * 刷新税收管辖，所在区域列表值
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String flash() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("flash() ********** start **********"+Common.getCurrentTime());
		}
		userBean = new Pgt00002();
		try {
			//刷新税收管辖与所在区域
			SetSSGXandSZQYSession();
			ssgxList = (ArrayList<Pgv00009>) sessionCtrl.GetList(SessionCtrl.SESSION_LIST_SSGX);
			SSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			//重新设置税收管辖名称
			for (Pgv00009 ssgxBean : ssgxList) {
				if (ssgxBean.getCd00001Ssgx().equals(SSGX)) {
					sessionCtrl.Add(SessionCtrl.SESSION_KEY_SSGXNM, ssgxBean.getSsgx());
				}
			}
			//封装用户Bean,
			userBean.setUserid(sessionCtrl.getUserId());
			userBean.setCd00001Ssgx(ddlSSGX);
			//刷新用户权限
			sessionCtrl.Add(SessionCtrl.SESSION_KEY_USERROLE, t00002Service.LoadRightByUser(userBean));
			//封装pssd，供top页面显示
			PSSDYMD = sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD);
			USER = sessionCtrl.getUserName();			
			readRole();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("LogManageAction -- flash()", e);
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("flash() ********** end **********"+Common.getCurrentTime());
		}
		return SUCCESS;
	}
	
	/**
	 * 设置SESSION
	 * @return
	 * @throws Exception
	 */
	public void setSession() throws Exception {
	/*	for (int i = 0; i < ssgxList.size(); i++) {
			if (ssgxList.get(i).getIsdefault() == 1) {
				ddlSSGX = ssgxList.get(i).getCd00001Ssgx();
				sessionCtrl.Add(SessionCtrl.SESSION_KEY_SSGXNM, ssgxList.get(i).getSsgx());
			}
		}
		if (Common.isNullOrEmpty(ddlSSGX)) {
			ddlSSGX = ssgxList.get(0).getCd00001Ssgx();
			sessionCtrl.Add(SessionCtrl.SESSION_KEY_SSGXNM, ssgxList.get(0).getSsgx());
		}*/
		// 保存用户权限
		userBean = new Pgt00002();
		userBean.setUserid(sessionCtrl.getUserId());
		//userBean.setCd00001Ssgx(ddlSSGX);
		//sessionCtrl.Add(SessionCtrl.SESSION_KEY_USERROLE, t00002Service.LoadRightByUser(userBean));
		SetAppSession();
	}
	
	/**
	 * 设置系统相关Session信息
	 */
	private void SetAppSession() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("SetAppSession() ********** start **********"+Common.getCurrentTime());
		}

		//设置税收管辖，所在区域Session
		//SetSSGXandSZQYSession();
		//保存系统配置信息
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_SSGX, t00001Service.GetInfoSSGX());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_HY, t00001Service.GetInfoHY());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_JJLX, t00001Service.GetInfoJJLX());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_QDFS, t00001Service.GetInfoQDFS());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_MSSZ, t00001Service.GetInfoMSSZ());
		//sessionCtrl.Add(SessionCtrl.SESSION_INFO_XJBZ, t00001Service.GetInfoXJBZ());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_SYQLX, t00001Service.GetInfoSYQLX());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_TDSYQLX, t00001Service.GetInfoTDSYQLX());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_JZJG, t00001Service.GetInfoJZJG());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_TDYT, t00001Service.GetInfoTDYT());
//		SessionCtrl.Add(SessionCtrl.SESSION_INFO_TDDJ, t00001Service.GetInfoTDDJ());
//		sessionCtrl.Add(SessionCtrl.SESSION_INFO_FWCX, t00001Service.GetInfoFWCX());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_FWSS, t00001Service.GetInfoFWSS());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_SZQY, t00001Service.GetInfoSzqy());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_XZ, t00001Service.GetInfoXZ());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_FWYT, t00001Service.GetInfoFWYT());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_FWLX_SC, t00001Service.GetInfoFWLX_SC());
//		sessionCtrl.Add(SessionCtrl.SESSION_INFO_CGZK_SC, t00001Service.GetInfoCGZK_SC());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_JYLX_SC, t00001Service.GetInfoJYLX_SC());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_ZJLX, t00001Service.GetInfoZJLX());
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("SetAppSession() ********** end **********"+Common.getCurrentTime());
		}
	}
	
	/**
	 * 设置用户相关Session信息
	 */
	private void SetUserSession(Pgt00002 userBean) throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("SetAppSession() ********** start **********"+Common.getCurrentTime());
		}
		//保存登录用户信息
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_USERID, userBean.getUserid());
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_USERNAME , userBean.getUsernm());
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_ISADMIN, userBean.getIsadmin());
		//sessionCtrl.Add(SessionCtrl.SESSION_KEY_PSSD, Common.formatToYYYY(userBean.getPssd()));
		//sessionCtrl.Add(SessionCtrl.SESSION_KEY_PSSD_YMD, userBean.getPssd());
		//sessionCtrl.Add(SessionCtrl.SESSION_KEY_DATASIZE, userBean.getPagecount());
		//保存用户权限
		//SessionCtrl.Add(SessionCtrl.SESSION_KEY_USERROLE,t00002Service.LoadRightByUser(userBean));
		//保持用户税收管辖
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_SSGX, userBean.getCd00001Ssgx());
		if (LOG.isDebugEnabled()) {
			LOG.debug("SetAppSession() ********** end **********"+Common.getCurrentTime());
		}
	}
	
	/**
	 * 设置税收管辖，所在区域的Session信息
	 */
	private void SetSSGXandSZQYSession() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("SetSSGXandSZQYSession() ********** start **********"+Common.getCurrentTime());
		}
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_SSGX, ddlSSGX);
		sessionCtrl.Add(SessionCtrl.SESSION_LIST_SZQY, t00052Service.LoadSzqyBySsgx(ddlSSGX));
		if (LOG.isDebugEnabled()) {
			LOG.debug("SetSSGXandSZQYSession() ********** end **********"+Common.getCurrentTime());
		}
	}

	/**
	 * 重新設置[稅收管轄]
	 * @return
	 */
	public String reSetSSGX() throws Exception { 
		if (LOG.isDebugEnabled()) {
			LOG.debug("reSetSSGX() ********** start **********");
		}

		try {
			ssgxList = t00009Service.LoadAllSSGX(sessionCtrl.getUserId());
		} catch (Exception e) {
			LOG.error("reSetSSGX()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("reSetSSGX() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("reSetSSGX() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 读取ROLE.
	 */
	protected void readRole() throws Exception {
		/*Object role = sessionCtrl.GetList(SessionCtrl.SESSION_KEY_USERROLE);
		userRole = "";
		if(null!=role){
			ArrayList<String> roleList = (ArrayList<String>) role;
			for(Integer i = 0; i < roleList.size(); i++){
				userRole = userRole + roleList.get(i) + Constant.STRING_COMMA;
			}
		}*/
		setISADMIN(Common.convertToBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN)));
	}
	
	/**
	 * 退出系统
	 * @return
	 */
	public String logout() {
		try {
			sessionCtrl.RemoveAll();
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("LogManageAction -- logout()", e);
		}
		return SUCCESS;
	}
	
	/*********************************** set and get **************************************/
	
	/**
	 * @param userList the userList to set
	 */
	public void setUserList(ArrayList<Pgt00002> userList) {
		this.userList = userList;
	}

	/**
	 * @return the userList
	 */
	public ArrayList<Pgt00002> getUserList() {
		return userList;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userBean the userBean to set
	 */
	public void setUserBean(Pgt00002 userBean) {
		this.userBean = userBean;
	}

	/**
	 * @return the userBean
	 */
	public Pgt00002 getUserBean() {
		return userBean;
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

	/**
	 * @return the txtUserPwd
	 */
	public String getTxtUserPwd() {
		return txtUserPwd;
	}

	/**
	 * @param txtUserPwd the txtUserPwd to set
	 */
	public void setTxtUserPwd(String txtUserPwd) {
		this.txtUserPwd = txtUserPwd;
	}


	/**
	 * @return the t00002Service
	 */
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
	 * @param t00001Service the t00001Service to set
	 */
	public void setT00001Service(IPgt00001Service t00001Service) {
		this.t00001Service = t00001Service;
	}

	/**
	 * @return the t00001Service
	 */
	public IPgt00001Service getT00001Service() {
		return t00001Service;
	}

	/**
	 * @return the t00052Service
	 */
	public IPgt00052Service getT00052Service() {
		return t00052Service;
	}

	/**
	 * @param t00052Service the t00052Service to set
	 */
	public void setT00052Service(IPgt00052Service t00052Service) {
		this.t00052Service = t00052Service;
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
	 * @return the t00009Service
	 */
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
	 * @return the ddlSSGX
	 */
	public String getDdlSSGX() {
		return ddlSSGX;
	}

	/**
	 * @param ddlSSGX the ddlSSGX to set
	 */
	public void setDdlSSGX(String ddlSSGX) {
		this.ddlSSGX = ddlSSGX;
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
	 * @return the pSSDYMD
	 */
	public String getPSSDYMD() {
		return PSSDYMD;
	}

	/**
	 * @param pSSDYMD the pSSDYMD to set
	 */
	public void setPSSDYMD(String pSSDYMD) {
		PSSDYMD = pSSDYMD;
	}

	/**
	 * @param uSER the uSER to set
	 */
	public void setUSER(String uSER) {
		USER = uSER;
	}

	/**
	 * @return the uSER
	 */
	public String getUSER() {
		return USER;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public void setISADMIN(Boolean iSADMIN) {
		ISADMIN = iSADMIN;
	}

	public Boolean getISADMIN() {
		return ISADMIN;
	}

	/**
	 * @return the txtRand
	 */
	public String getTxtRand() {
		return txtRand;
	}

	/**
	 * @param txtRand the txtRand to set
	 */
	public void setTxtRand(String txtRand) {
		this.txtRand = txtRand;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}


	/**
	 * @param t00012Service the t00012Service to set
	 */
	public void setT00012Service(IPgt00012Service t00012Service) {
		this.t00012Service = t00012Service;
	}

	/**
	 * @return the t00012Bean
	 */
	public Pgt00012 getT00012Bean() {
		return t00012Bean;
	}

	/**
	 * @param t00012Bean the t00012Bean to set
	 */
	public void setT00012Bean(Pgt00012 t00012Bean) {
		this.t00012Bean = t00012Bean;
	}

	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	public IPgt00012Service getT00012Service() {
		return t00012Service;
	}

	public Pgt00002 getT00002Bean() {
		return t00002Bean;
	}

	public void setT00002Bean(Pgt00002 t00002Bean) {
		this.t00002Bean = t00002Bean;
	}

	public Integer getQXID() {
		return QXID;
	}

	public void setQXID(Integer qXID) {
		QXID = qXID;
	}


}
