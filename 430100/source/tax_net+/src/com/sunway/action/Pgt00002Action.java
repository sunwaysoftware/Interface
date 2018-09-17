package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00002Service;
import com.sunway.service.IPgt00009Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.EncryptUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00002;
import com.sunway.vo.Pgt00003;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgt00009;
import com.sunway.vo.Pgv00002;
import com.sunway.vo.Pgv00009;

/**
 * 用户(Pgt00002)
 * @author Lee
 * @version 1.0
 */

public class Pgt00002Action extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -4320651547724136307L;
	//Service
	private IPgt00002Service t00002Service;
	private IPgt00009Service t00009Service;
	//View
	private InputStream excelStream;
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	//Bean数组
	private ArrayList<Pgv00002> rows;
	private ArrayList<Pgv00009> ssgxList;
	//查询条件
	private String txtUSERIDFind;
	private String txtUSERNMFind;
	private String txtSSGXFind;
	
	//Edit
	private InputStream changeStatus;
	
	//edit页面所需Bean
	private Pgt00002 t00002Bean;
	private Pgt00003 t00003Bean;
	private Pgt00004 t00004Bean;
	private Pgv00002 v00002Bean;
	//primary key 主键
	private String USERID;
	private String RIGHTID;
	private String ROLEID;
	private String SSGX;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String txtUSERID;
	private String txtUSERNM;
	private String txtPHONE;
	private String txtUSERIP;
	private Boolean rdoISLOCKED;
	private String chkROLEID;
	private String chkRIGHTID;
	private String txtNOTE;
	private String txtUPDATE;
	private String txtPSSD;
	private String txtLOCKEDDATE;
	private String txtPAGECOUNT;
	private String txtOLDUSERPWD;
	private String txtNEWUSERPWD;
	private Boolean rdoISADMIN;
	private String txtSSGX;
	private Boolean ISADMIN;
	private String curUSERID;
	private String defSSGX;
	private String ddlSSGX1;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String txtUSERGH;
	
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
			ISADMIN = ConvertUtil.toBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN));
			curUSERID = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID);
			
				txtSSGXFind = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			
			
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
		
		Pgv00002 v00002 = new Pgv00002();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00002.setUserid(FormatUtil.toSearchLike(txtUSERIDFind));
			v00002.setUsernm(FormatUtil.toSearchLike(txtUSERNMFind));
			v00002.setPageIndex(pageIndex);
			v00002.setPageSize(getPageSize());
			v00002.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			if (!CheckUtil.chkEmpty(txtSSGXFind)) {
				v00002.setCd00001Ssgx(txtSSGXFind);
			} else {
				v00002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
			
			//执行查询
			rows = t00002Service.LoadAll(v00002);
			ISADMIN = ConvertUtil.toBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN));
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			}else{
				total = 0;
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
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		Pgv00002 v00002 = new Pgv00002();		
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00002.setUserid(FormatUtil.toSearchLike(txtUSERIDFind));			
			v00002.setPageIndex(pageIndex);
			v00002.setPageSize(getPageSize());
			v00002.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			if (ConvertUtil.toBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN))) {
				v00002.setCd00001Ssgx(txtSSGXFind);
			} else {
				v00002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
			//执行查询
			rows = t00002Service.LoadAll(v00002);			
			
			//分页设置
			if(null!=rows && rows.size()>0){
				v00002Bean = rows.get(0);				
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
		
		Pgt00002 t00002 = new Pgt00002();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t00002.setUserid(ConvertUtil.encoding(USERID));
				t00002Bean = t00002Service.LoadByPrimaryKey(t00002);
				t00002Bean.setPssdymd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD));
			}else{
				SSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			}
			
			ISADMIN =ConvertUtil.toBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN));
			
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
		t00002Bean = new Pgt00002();
		this.clearErrorsAndMessages();	
		t00002Bean.setUserid(txtUSERID);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t00002Bean = t00002Service.LoadByPrimaryKey(t00002Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!CheckUtil.chkEmpty(t00002Bean.getUserid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.t00002.userid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00002Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t00002Bean.setUserid(txtUSERID);
			t00002Bean.setUsernm(txtUSERNM);
			t00002Bean.setNote(txtNOTE);
			t00002Bean.setUserip(txtUSERIP);
			t00002Bean.setPhone(txtPHONE);
			t00002Bean.setRoleids(chkROLEID);
			t00002Bean.setRightids(chkRIGHTID);
			if (rdoISLOCKED == null || rdoISLOCKED == false) {
				//如果按钮未被选中，则为rdoISLOCKED赋值
				rdoISLOCKED = false;
				t00002Bean.setLastlockedoutdate(null);
			}else{
				t00002Bean.setLastlockedoutdate(ConvertUtil.toTimestampHMS(txtLOCKEDDATE));
			}
			t00002Bean.setIslockedout(rdoISLOCKED);
			//设置页数，默认为20
			t00002Bean.setPageSize(ConvertUtil.toInteger("20"));
			//设置是否为管理员，默认不是
			t00002Bean.setIsadmin(CheckUtil.chkNull(rdoISADMIN));
			t00002Bean.setPssd(new Date());
			t00002Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			if (CheckUtil.chkEmpty(txtSSGX)) {
				SSGX=sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
				t00002Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				SSGX=txtSSGX;
				t00002Bean.setCd00001Ssgx(txtSSGX);
			}
			t00002Bean.setUsergh(txtUSERGH);
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
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t00002Service.GetInsertCommand(getT00002Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT00002Bean().getUserid()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT00002Bean().getUserid()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00002Service.GetUpdateCommand(getT00002Bean())){
					//如果修改的是当前用户，刷新用户权限
					if(t00002Bean.getUserid().equals(sessionCtrl.getUserId()))
						sessionCtrl.Add(SessionCtrl.SESSION_KEY_USERROLE, t00002Service.LoadRightByUser(getT00002Bean()));
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00002Bean().getUserid()}));
				}
				else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00002Bean().getUserid()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t00002Service.GetDeleteCommand(getT00002Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT00002Bean().getUserid()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT00002Bean().getUserid()}));
			}
			ISADMIN = ConvertUtil.toBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN));
			if (ISADMIN) {
				txtSSGXFind = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			}
		} catch (Exception e) {
			String[] msgs = e.getMessage().split("\n");	
			LOG.error(e.getMessage());
//			this.addActionError(e.getMessage());
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
	
//	/**
//	 * 数据导出
//	 * @return
//	 * @throws Exception
//	 */
//	public String export() throws Exception {
//		Pgv00002 v00002 = new Pgv00002();
//		StringBuffer strBuf = new StringBuffer();
//		try{
//			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
//			if(!CheckUtil.chkEmpty(txtUSERIDFind))
//				v00002.setUserid(txtUSERIDFind);
//			if(!CheckUtil.chkEmpty(txtUSERNMFind))
//				v00002.setUsernm(FormatUtil.toSearchLike(ConvertUtil.encoding(txtUSERNMFind)));
//			v00002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
//			v00002.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
//			strBuf.append(getText("app.xtwh.t00002.userid")).append(Constant.STRING_COMMA)
//			      .append(getText("app.xtwh.t00002.usernm")).append(Constant.STRING_COMMA)
//			      .append(getText("app.xtwh.t00002.userip")).append(Constant.STRING_COMMA)
//			      .append(getText("app.xtwh.t00002.phone")).append(Constant.STRING_COMMA)
//			      .append(getText("app.xtwh.t00002.lastlockedoutdate")).append(Constant.STRING_COMMA)
//			      .append(getText("app.xtwh.t00001.pssd")).append(Constant.STRING_COMMA)
//			      .append(getText("app.xtwh.info.ssgx")).append(Constant.STRING_COMMA)
//			      .append(getText("app.upddate"))
//			      .append(Constant.STRING_ENTER);
//			strBuf.append(t00002Service.ExportAll(v00002));
//			setExcelStream(Common.exportCSV(strBuf));
//		}catch (Exception e) {
//			this.addActionError(e.getMessage());
//			return INPUT;
//		}
//		return SUCCESS;
//	}
	/**
	 *查询信息导出
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		Pgv00002 v00002 = new Pgv00002();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			if(!CheckUtil.chkEmpty(txtUSERIDFind))
				v00002.setUserid(txtUSERIDFind);
			if(!CheckUtil.chkEmpty(txtUSERNMFind))
				v00002.setUsernm(FormatUtil.toSearchLike(ConvertUtil.encoding(txtUSERNMFind)));
			v00002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00002.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			
			ByteArrayOutputStream out = (ByteArrayOutputStream) t00002Service.ExportAll(v00002);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch (Exception e) {
			this.addActionError(e.getMessage());
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		
		return SUCCESS;
		
		
	}
	/**
	 * Ajax用，根据role取得用户
	 * @return
	 * @throws Exception
	 */
	public String LoadUsersByRole() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadUsersByRole() ********** start **********");
		}
		
		t00003Bean = new Pgt00003();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00003Bean.setRoleid(ROLEID);
			if (CheckUtil.chkEmpty(txtSSGXFind))
			{
				txtSSGXFind = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			}
			t00003Bean.setCd00001Ssgx(txtSSGXFind);
			rows = t00002Service.LoadUsersByRole(t00003Bean);
		} catch (Exception e) {
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadUsersByRole() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * Ajax用，根据right取得用户
	 * @return
	 * @throws Exception
	 */
	public String LoadUsersByRight() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadUsersByRight() ********** start **********");
		}
		
		t00004Bean = new Pgt00004();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00004Bean.setRightid(RIGHTID);
			t00004Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			rows = t00002Service.LoadUsersByRight(t00004Bean);
		} catch (Exception e) {
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("LoadUsersByRight() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 初始化用户密码
	 * @return 
	 * @throws Exception
	 */
	public String InitPWD() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("InitPWD() ********** start **********");
		}
		
		t00002Bean = new Pgt00002();
		try {
			t00002Bean.setUserid(USERID);
			if(t00002Service.InitPWD(t00002Bean))
				this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00002Bean().getUserid()}));
			else
				this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00002Bean().getUserid()}));
		} catch (Exception e) {
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("InitPWD() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 设置用户常规设置
	 * @return True成功；False失败
	 * @throws Exception
	 */	
	public String SettingPersonal() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("SettingPersonal() ********** start **********");
		}
		t00002Bean = new Pgt00002();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00002Bean.setUserid(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00002Bean.setPageSize(ConvertUtil.toInteger(txtPAGECOUNT));
			t00002Bean.setPssd(ConvertUtil.toUtilDate(txtPSSD));
			
			if(t00002Service.SettingPersonal(t00002Bean)){
				Pgt00009 t00009 = new Pgt00009();
				t00009.setCd00002Userid(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
				t00009.setCd00001Ssgx(ddlSSGX1);
				if (!t00009Service.GetUpdDef(t00009)) {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00002Bean().getUserid()}));
				}
				//设置成功后，刷新评税时点，每页显示信息条数
				sessionCtrl.Add(SessionCtrl.SESSION_KEY_DATASIZE, t00002Bean.getPageSize());
				sessionCtrl.Add(SessionCtrl.SESSION_KEY_PSSD, FormatUtil.toYYYY(t00002Bean.getPssd()));
				sessionCtrl.Add(SessionCtrl.SESSION_KEY_PSSD_YMD, FormatUtil.toYYYYMMDD(t00002Bean.getPssd()));
				this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00002Bean().getUserid()}));
			}
			else
				this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00002Bean().getUserid()}));
		} catch (Exception e) {
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("SettingPersonal() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 *  跳转个性设置页面
	 */
	public String viewSetting() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("viewSetting() ********** start **********");
		}
		t00002Bean = new Pgt00002();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00002Bean.setPssdymd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD));
			t00002Bean.setPageSize(ConvertUtil.toInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			t00002Bean.setUserid(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			ssgxList = t00009Service.LoadAllSSGX(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			for (int i = 0; i < ssgxList.size(); i++) {
				if (ssgxList.get(i).getIsdefault() == 1) {
					defSSGX = ssgxList.get(i).getCd00001Ssgx();
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("viewSetting() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("viewSetting() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 修改用户密码
	 * @return True成功；False失败
	 * @throws Exception
	 */
	public String ChangePWD() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("ChangePWD() ********** start **********");
		}
		t00002Bean = new Pgt00002();
		StringBuffer strBuf = new StringBuffer();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00002Bean.setUserid(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00002Bean.setOlduserpwd(EncryptUtil.md5(txtOLDUSERPWD));
			t00002Bean.setNewuserpwd(EncryptUtil.md5(txtNEWUSERPWD));
			//接收修改密码返回提示
			strBuf.append(t00002Service.ChangePWD(t00002Bean));
			changeStatus = Common.exportTEXT(strBuf);
		} catch (Exception e) {
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("ChangePWD() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 *  判断用户是否存在ByAjax
	 * 
	 */
	public String isUserExists() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("viewSetting() ********** start **********");
		}
		t00002Bean = new Pgt00002();
		try {
			t00002Bean.setUserid(USERID);
			t00002Bean = t00002Service.LoadByPrimaryKey(t00002Bean);
			t00002Bean.setPhone(CheckUtil.chkNull(t00002Bean.getPhone()));
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("viewSetting() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("viewSetting() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 验证用户是否有审核权限
	 * @return
	 * @throws Exception
	 */
	public String chkVerify() throws Exception {
		Pgt00002 user = new Pgt00002();
		user.setUserid(txtUSERID);
		user.setUserpwd(EncryptUtil.md5(txtNEWUSERPWD));
		user.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		t00002Bean = t00002Service.ChkVerify(user);
		return SUCCESS;
	}
	
	
	/*********************** setter and getter ******************************/
	
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
	 * @return the txtUSERNM
	 */
	public String getTxtUSERNM() {
		return txtUSERNM;
	}

	/**
	 * @param txtUSERNM the txtUSERNM to set
	 */
	public void setTxtUSERNM(String txtUSERNM) {
		this.txtUSERNM = txtUSERNM;
	}

	/**
	 * @return the txtPHONE
	 */
	public String getTxtPHONE() {
		return txtPHONE;
	}

	/**
	 * @param txtPHONE the txtPHONE to set
	 */
	public void setTxtPHONE(String txtPHONE) {
		this.txtPHONE = txtPHONE;
	}

	/**
	 * @return the txtUSERIP
	 */
	public String getTxtUSERIP() {
		return txtUSERIP;
	}

	/**
	 * @param txtUSERIP the txtUSERIP to set
	 */
	public void setTxtUSERIP(String txtUSERIP) {
		this.txtUSERIP = txtUSERIP;
	}

	/**
	 * @return the rdoISLOCKED
	 */
	public Boolean getRdoISLOCKED() {
		return rdoISLOCKED;
	}

	/**
	 * @param rdoISLOCKED the rdoISLOCKED to set
	 */
	public void setRdoISLOCKED(Boolean rdoISLOCKED) {
		this.rdoISLOCKED = rdoISLOCKED;
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
	 * @return the rows
	 */
	public ArrayList<Pgv00002> getRows() {
		return rows;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setRows(ArrayList<Pgv00002> rows) {
		this.rows = rows;
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
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}

	/**
	 * @param txtPSSD the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}

	/**
	 * @return the txtLOCKEDDATE
	 */
	public String getTxtLOCKEDDATE() {
		return txtLOCKEDDATE;
	}

	/**
	 * @param txtLOCKEDDATE the txtLOCKEDDATE to set
	 */
	public void setTxtLOCKEDDATE(String txtLOCKEDDATE) {
		this.txtLOCKEDDATE = txtLOCKEDDATE;
	}

	/**
	 * @return the txtPAGECOUNT
	 */
	public String getTxtPAGECOUNT() {
		return txtPAGECOUNT;
	}

	/**
	 * @param txtPAGECOUNT the txtPAGECOUNT to set
	 */
	public void setTxtPAGECOUNT(String txtPAGECOUNT) {
		this.txtPAGECOUNT = txtPAGECOUNT;
	}

	/**
	 * @return the txtOLDUSERPWD
	 */
	public String getTxtOLDUSERPWD() {
		return txtOLDUSERPWD;
	}

	/**
	 * @param txtOLDUSERPWD the txtOLDUSERPWD to set
	 */
	public void setTxtOLDUSERPWD(String txtOLDUSERPWD) {
		this.txtOLDUSERPWD = txtOLDUSERPWD;
	}

	/**
	 * @return the txtNEWUSERPWD
	 */
	public String getTxtNEWUSERPWD() {
		return txtNEWUSERPWD;
	}

	/**
	 * @param txtNEWUSERPWD the txtNEWUSERPWD to set
	 */
	public void setTxtNEWUSERPWD(String txtNEWUSERPWD) {
		this.txtNEWUSERPWD = txtNEWUSERPWD;
	}

	/**
	 * @return the changeStatus
	 */
	public InputStream getChangeStatus() {
		return changeStatus;
	}

	/**
	 * @param changeStatus the changeStatus to set
	 */
	public void setChangeStatus(InputStream changeStatus) {
		this.changeStatus = changeStatus;
	}

	/**
	 * @return the excelStream
	 */
	public InputStream getExcelStream() {
		return excelStream;
	}

	/**
	 * @param excelStream the excelStream to set
	 */
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	/**
	 * @return the rdoISADMIN
	 */
	public Boolean getRdoISADMIN() {
		return rdoISADMIN;
	}

	/**
	 * @param rdoISADMIN the rdoISADMIN to set
	 */
	public void setRdoISADMIN(Boolean rdoISADMIN) {
		this.rdoISADMIN = rdoISADMIN;
	}

	/**
	 * @return the txtSSGX
	 */
	public String getTxtSSGX() {
		return txtSSGX;
	}

	/**
	 * @param txtSSGX the txtSSGX to set
	 */
	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
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
	 * @return the defSSGX
	 */
	public String getDefSSGX() {
		return defSSGX;
	}

	/**
	 * @param defSSGX the defSSGX to set
	 */
	public void setDefSSGX(String defSSGX) {
		this.defSSGX = defSSGX;
	}

	/**
	 * @return the ddlSSGX1
	 */
	public String getDdlSSGX1() {
		return ddlSSGX1;
	}

	/**
	 * @param ddlSSGX1 the ddlSSGX1 to set
	 */
	public void setDdlSSGX1(String ddlSSGX1) {
		this.ddlSSGX1 = ddlSSGX1;
	}

	/**
	 * @return the txtUSERGH
	 */
	public String getTxtUSERGH() {
		return txtUSERGH;
	}

	/**
	 * @param txtUSERGH the txtUSERGH to set
	 */
	public void setTxtUSERGH(String txtUSERGH) {
		this.txtUSERGH = txtUSERGH;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	public void setCurUSERID(String curUSERID) {
		this.curUSERID = curUSERID;
	}

	public String getCurUSERID() {
		return curUSERID;
	}
	public void setV00002Bean(Pgv00002 v00002Bean) {
		this.v00002Bean = v00002Bean;
	}

	public Pgv00002 getV00002Bean() {
		return v00002Bean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
