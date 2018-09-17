package com.sunway.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.MDC;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.exception.GenericJDBCException;

import com.chinacreator.openid.client.util.UserCaWebservice2;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.dao.impl.BaseDAO;
import com.sunway.net.NetUtil;
import com.sunway.service.IPgt00001Service;
import com.sunway.service.IPgt00002Service;
import com.sunway.service.IPgt00009Service;
import com.sunway.service.IPgt00012Service;
import com.sunway.service.IPgt00052Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.EncryptUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.MakeUtil;
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
	private static Logger logger = LogManager.getLogger(BaseDAO.class);
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
	private String ssgxid;
	//------科创统一认证--------
	private String userKey;//单点令牌
	private String caURL;//认证的地址
	
	/**
	 * 验证统一登录平台合法性 
	 * @throws Exception 
	 */
	public String checkTokenLogin() throws Exception{
		String errNoUser = "用户在本系统不存在，请检查！";
		//************【单点页面登录】****************
		this.clearErrorsAndMessages();
		Pgt00002 user = new Pgt00002();
		
		//根据TOKEN验证用户合法性
		try{
			Map<String,String> map = UserCaWebservice2.caWebserive(caURL, userKey);
			if(null==map){
				throw new Exception(errNoUser);
			} else {
				userName = map.get("username");//返回用户名	
			}
		}catch(Exception e){
			this.addActionError(e.getMessage());
			return INPUT;
		}
		
		if (userName != null) {
			//写登录逻辑，然后登录（跳成业务系统自己的页面）
			try {
				if(!"".equals(userName)){
					user.setUserid(userName);
					user = t00002Service.LoadByPrimaryKey(user);
				}else {
					this.addActionError(errNoUser);
					return INPUT;
				}
			} catch (Exception e) {
				this.addActionError(e.getMessage());
				return INPUT;
			}
			if(null == user.getUserpwd() || "".equals(user.getUserpwd())){
				this.addActionError(errNoUser);
				return INPUT;
			}else {
				userBean = user;
			}
		} else {		
			this.addActionError(errNoUser);
			return INPUT;
		}			
		return login();
	}	
	
	/**
	 * 用户登录判定
	 */
	public void validateLogin() {
		if (logger.isDebugEnabled()) {
			logger.debug("validateLogin() ********** start **********"+MakeUtil.currentTime());
		}
		this.clearErrorsAndMessages();
		String arandom=(String)(sessionCtrl.Get(SessionCtrl.SESSION_KEY_RANDPIC));
		if(null!=arandom) {
			if(!arandom.equals(txtRand)){
				addActionError("验证码错误");
				return;
			}
		} else {
			addActionError("验证码错误");
			return;			
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		logger.info("来自{}访问请求，用户{}正在尝试登录系统...", request.getRemoteAddr(), txtUserID);
		
		Pgt00002 user = new Pgt00002();
		user.setUserid(txtUserID);
		user.setUserpwd(EncryptUtil.md5(txtUserPwd));
		user.setUserip(NetUtil.getIpAddr(request));
		user.getLoginfo().setIp(request.getRemoteAddr());
		user.getLoginfo().setUserid(txtUserID);
		try {
			//用户登陆判读
			user = t00002Service.CheckLogin(user);
			if(null!=user && user.getLoginState()==0){
				logger.info("用户{}登录验证失败，{}！", user.getUserid(), user.getLoginMessage());
				this.addActionError(user.getLoginMessage());
			} else {
				userBean = user;
				MDC.put("uIP", request.getRemoteAddr());
				MDC.put("uID", userBean.getUserid());
				logger.info("用户{}登录验证成功！", userBean.getUserid());
			}
		} catch (SQLException eJDBC) {
			logger.error("LogManageAction -- validateLogin()", eJDBC);
			this.addActionError(getText("app.msg.error.dbconn"));
		} catch (GenericJDBCException eJDBC) {
			logger.error("LogManageAction -- validateLogin()", eJDBC);
			this.addActionError(getText("app.msg.error.dbconn"));			
		} catch (Exception e) {
			logger.error("LogManageAction -- validateLogin()", e);
			this.addActionError(e.getMessage());
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("validateLogin() ********** end **********"+MakeUtil.currentTime());
		}
	}
	
	/**
	 * 用户登录
	 * @return
	 * @throws Exception
	 */
	public String login() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("login() ********** start **********"+MakeUtil.currentTime());
		}
		try {
			//获得用户session
			ssgxList = t00009Service.LoadAllSSGX(userBean.getUserid());
			//设置用户相关的SESSION
			SetUserSession(userBean);
			setSession();
		} catch (Exception e) {
			logger.error("LogManageAction -- login()", e);
			return ERROR;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("login() ********** end **********"+MakeUtil.currentTime());
		}
		return SUCCESS;
	}
	
	/**
	 * 刷新税收管辖，所在区域列表值
	 * @return
	 * @throws Exception
	 */
	
	public String flash() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("flash() ********** start **********"+MakeUtil.currentTime());
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
			logger.error("LogManageAction -- flash()", e);
			return ERROR;
		}
		
		if (logger.isDebugEnabled()) {
			logger.debug("flash() ********** end **********"+MakeUtil.currentTime());
		}
		return SUCCESS;
	}
	
	/**
	 * 设置SESSION
	 * @return
	 * @throws Exception
	 */
	public void setSession() throws Exception {
		for (int i = 0; i < ssgxList.size(); i++) {
			if (ssgxList.get(i).getIsdefault() == 1) {
				ddlSSGX = ssgxList.get(i).getCd00001Ssgx();
				sessionCtrl.Add(SessionCtrl.SESSION_KEY_SSGXNM, ssgxList.get(i).getSsgx());
			}
		}
		if (CheckUtil.chkEmpty(ddlSSGX)) {
			ddlSSGX = ssgxList.get(0).getCd00001Ssgx();
			sessionCtrl.Add(SessionCtrl.SESSION_KEY_SSGXNM, ssgxList.get(0).getSsgx());
		}
		// 保存用户权限
		userBean = new Pgt00002();
		userBean.setUserid(sessionCtrl.getUserId());
		userBean.setCd00001Ssgx(ddlSSGX);
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_USERROLE, t00002Service.LoadRightByUser(userBean));
		SetAppSession();
	}
	
	/**
	 * 设置系统相关Session信息
	 */
	private void SetAppSession() throws Exception{
		if (logger.isDebugEnabled()) {
			logger.debug("SetAppSession() ********** start **********"+MakeUtil.currentTime());
		}

		//设置税收管辖，所在区域Session
		SetSSGXandSZQYSession();
		//保存系统配置信息
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_SSGX, t00001Service.GetInfoSSGX());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_HY, t00001Service.GetInfoHY());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_JJLX, t00001Service.GetInfoJJLX());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_QDFS, t00001Service.GetInfoQDFS());
		sessionCtrl.Add(SessionCtrl.SESSION_INFO_MSSZ, t00001Service.GetInfoMSSZ());
		//sessionCtrl.Add(SessionCtrl.SESSION_INFO_XJBZ, t00001Service.GetInfoXJBZ());
//		sessionCtrl.Add(SessionCtrl.SESSION_INFO_SYQLX, t00001Service.GetInfoSYQLX());
//		sessionCtrl.Add(SessionCtrl.SESSION_INFO_TDSYQLX, t00001Service.GetInfoTDSYQLX());
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
		setSessionJK();//设置接口相关信息到session中
		if (logger.isDebugEnabled()) {
			logger.debug("SetAppSession() ********** end **********"+MakeUtil.currentTime());
		}
	}
	
	/**
	 * 设置用户相关Session信息
	 */
	private void SetUserSession(Pgt00002 userBean) throws Exception{
		if (logger.isDebugEnabled()) {
			logger.debug("SetAppSession() ********** start **********"+MakeUtil.currentTime());
		}
		//保存登录用户信息
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_USERID, userBean.getUserid());
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_USERNAME , userBean.getUsernm());
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_PSSD, FormatUtil.toYYYY(userBean.getPssd()));
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_PSSD_YMD, userBean.getPssd());
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_DATASIZE, userBean.getPageSize());
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_ISADMIN, userBean.getIsadmin());
		//保存用户权限
		//SessionCtrl.Add(SessionCtrl.SESSION_KEY_USERROLE,t00002Service.LoadRightByUser(userBean));
		//保持用户税收管辖
		sessionCtrl.Add(SessionCtrl.SESSION_LIST_SSGX, ssgxList);
		if (logger.isDebugEnabled()) {
			logger.debug("SetAppSession() ********** end **********"+MakeUtil.currentTime());
		}
	}
	
	/**
	 * 设置税收管辖，所在区域的Session信息
	 */
	private void SetSSGXandSZQYSession() throws Exception{
		if (logger.isDebugEnabled()) {
			logger.debug("SetSSGXandSZQYSession() ********** start **********"+MakeUtil.currentTime());
		}
		sessionCtrl.Add(SessionCtrl.SESSION_KEY_SSGX, ddlSSGX);
		sessionCtrl.Add(SessionCtrl.SESSION_LIST_SZQY, t00052Service.LoadSzqyBySsgx(ddlSSGX));
		if (logger.isDebugEnabled()) {
			logger.debug("SetSSGXandSZQYSession() ********** end **********"+MakeUtil.currentTime());
		}
	}

	/**
	 * 重新設置[稅收管轄]
	 * @return
	 */
	public String reSetSSGX() throws Exception { 
		if (logger.isDebugEnabled()) {
			logger.debug("reSetSSGX() ********** start **********");
		}

		try {
			ssgxList = t00009Service.LoadAllSSGX(sessionCtrl.getUserId());
		} catch (Exception e) {
			logger.error("reSetSSGX()", e);
			this.addActionError(e.getMessage());
			if (logger.isDebugEnabled()) {
				logger.debug("reSetSSGX() ********** end **********");
			}
			return INPUT;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("reSetSSGX() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 获取首页税收管辖列表
	 * @return
	 * @throws Exception
	 */
	
	public String getTopSSGXList() throws Exception { 
		if (logger.isDebugEnabled()) {
			logger.debug("getTopSSGXList() ********** start **********");
		}
		  ActionContext.getContext().getSession();
		try {
			USER = sessionCtrl.getUserName();
			ssgxList = (ArrayList<Pgv00009>) sessionCtrl.GetList(SessionCtrl.SESSION_LIST_SSGX);
			SSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			PSSDYMD = sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD);
			readRole();			
			if (CheckUtil.chkEmpty(SSGX)) {
				return INPUT;
			}
		} catch (Exception e) {
			logger.error("getTopSSGXList()", e);
			this.addActionError(e.getMessage());
			if (logger.isDebugEnabled()) {
				logger.debug("reSetSSGX() ********** end **********");
			}
			return INPUT;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("getTopSSGXList() ********** end **********");
		}
	    return SUCCESS;
	}
	/**
	 * 读取ROLE.
	 */
	
	protected void readRole() throws Exception {
		Object role = sessionCtrl.GetList(SessionCtrl.SESSION_KEY_USERROLE);
		userRole = "";
		if(null!=role){
			ArrayList<String> roleList = (ArrayList<String>) role;
			for(Integer i = 0; i < roleList.size(); i++){
				userRole = userRole + roleList.get(i) + Constant.STRING_COMMA;
			}
		}
		setISADMIN(ConvertUtil.toBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN)));
		setSsgxid(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
	}
	
	/**
	 * 退出系统
	 * @return
	 */
	public String logout() {
		try {
			sessionCtrl.RemoveAll();
		} catch (Exception e) {
			logger.error("LogManageAction -- logout()", e);
		}
		return SUCCESS;
	}
	/**
	 * 设置对接接口信息到Session中
	 */
	public void setSessionJK(){
		t00012Bean = new Pgt00012();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00012Bean.setCd00001Ssgxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SSGX));
			t00012Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t00012Bean = t00012Service.LoadByPrimaryKey(t00012Bean);
			sessionCtrl.Add(SessionCtrl.FCBMBM, t00012Bean.getFcbmbm());
			sessionCtrl.Add(SessionCtrl.FCJKDZ, t00012Bean.getFcjkdz());
			sessionCtrl.Add(SessionCtrl.CHANNEL_PWD, t00012Bean.getChannel_Pwd());
			sessionCtrl.Add(SessionCtrl.CHANNEL_ACC, t00012Bean.getChannel_Acc());
			sessionCtrl.Add(SessionCtrl.CHANNEL_CODE, t00012Bean.getChannel_Code());
			sessionCtrl.Add(SessionCtrl.WBMBM, t00012Bean.getWbmbm());
		}catch(Exception e){
			logger.error("LogManageAction -- setSessionJK()", e);
		}
		
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
	
	public IPgt00012Service getT00012Service() {
		return t00012Service;
	}

	public void setT00012Service(IPgt00012Service t00012Service) {
		this.t00012Service = t00012Service;
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

	public String getSsgxid() {
		return ssgxid;
	}

	public void setSsgxid(String ssgxid) {
		this.ssgxid = ssgxid;
	}

	/**
	 * @return the userKey
	 */
	public String getUserKey() {
		return userKey;
	}

	/**
	 * @param userKey the userKey to set
	 */
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

	/**
	 * @return the caURL
	 */
	public String getCaURL() {
		return caURL;
	}

	/**
	 * @param caURL the caURL to set
	 */
	public void setCaURL(String caURL) {
		this.caURL = caURL;
	}

	


}
