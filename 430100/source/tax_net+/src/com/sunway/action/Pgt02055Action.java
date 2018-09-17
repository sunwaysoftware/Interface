/**
 * 
 */
package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02055Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02055;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02055;

/**
 * 
 * 进深修正
 * @author Andy
 *
 */
public class Pgt02055Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 4339619369756654435L;
	private IPgt02055Service t02055Service;
	private String ACT;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//分页参数
	private Integer pageSize;
	private Integer pageIndex;
	private Integer total;
	//view
	private ArrayList<Pgv02055> rows;
	private String ddlSZQYFind;
	private String txtFWLXFind;
	//edit
	private String pk;
	private Pgt02055 t02055Bean;
	private ArrayList<Pgv00052> szqyList;
	private String txtUPDATE;
	private String txtID;
	private String ddlSZQY;
	private String txtXZXS;
	private String txtJSMIN;
	private String txtJSMAX;
	private String txtNOTE;
	private String txtPSSD;
	private String userRole;
	private String txtFWLX;
	private Boolean isExists;
	private String txtXQDM;
	private String txtXQFind;
	


	private InputStream excelStream;
	
	//file upload
	private File upload;
	private String fileServerPath;
	private String savePath;
	private String uploadFileName;
	
	//file import
	private String txtFilePath;
	private String fileName;
	private ArrayList<Pgv02055> Pgv02055List;
	
	private String chkDel;
	private String msgDel;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		try {
			ReadInfo();
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}

	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		Pgv02055 t02055 = new Pgv02055();
		try {
			//准备查询条件
			t02055.setCd00001Szqy(ddlSZQYFind);
			t02055.setPageIndex(pageIndex);
			t02055.setCd00001Fwlx(txtFWLX);
			t02055.setPageSize(getPageSize());
			t02055.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = t02055Service.LoadAll(t02055);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
			}else{
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public String init() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** start **********");
		}
		
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	public String initA() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** start **********");
		}
		
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception{
		try {
			ReadInfo();
			if(!Constant.MOD_CREATE.equals(ACT)){
				//取得用户选中的数据信息
				t02055Bean = t02055Service.LoadByPrimaryKey(new Pgt02055(pk));
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	/**
	 * 点击单选按钮的AJAX事件
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */

	public String createByAjax()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt02055 t02055 = new Pgt02055();
		try{
			if(!Constant.MOD_CREATE.equals(getACT())){
				t02055.setCd00001Szqy(ddlSZQY);
				t02055.setCd00001Fwlx(txtFWLX);
				t02055.setJsMin(BigDecimal.valueOf(ConvertUtil.toDouble(txtJSMIN))); 
				t02055.setJsMax(BigDecimal.valueOf(ConvertUtil.toDouble(txtJSMAX)));
				t02055Bean = t02055Service.LoadByPrimaryAddKey(t02055);
				isExists = t02055Bean.getUpddate() == null?true:false;
				
			}
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage());
			
			if(LOG.isDebugEnabled()){
				LOG.debug("createByAjax() ********** end **********");
			}
			
			return ERROR;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("createByAjax() ********** end **********");
		}
		return SUCCESS;
		
	}
	
	/**
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception{
		this.clearErrorsAndMessages();	
		ReadInfo();
		t02055Bean = new Pgt02055(txtID);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(ACT)){
			t02055Bean = t02055Service.LoadByPrimaryKey(t02055Bean);			
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(ACT))&&(!t02055Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02055Bean.setCd00001Szqy(ddlSZQY);
			t02055Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02055Bean.setXzxs(BigDecimal.valueOf(ConvertUtil.toDouble(txtXZXS)));
			t02055Bean.setJsMin(BigDecimal.valueOf(ConvertUtil.toDouble(txtJSMIN)));
			t02055Bean.setJsMax(BigDecimal.valueOf(ConvertUtil.toDouble(txtJSMAX)));
			t02055Bean.setNote(CheckUtil.chkTrim(txtNOTE));
			t02055Bean.setCd00001Fwlx(CheckUtil.chkTrim(txtFWLX));
			t02055Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
		String rtn = "success";
		try {
			if(Constant.MOD_CREATE.equals(ACT)){			// Create
				if(t02055Service.GetInsertCommand(t02055Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t02055Service.GetUpdateCommand(t02055Bean)){
					t02055Bean = t02055Service.LoadByPrimaryKey(t02055Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t02055Service.GetDeleteCommand(t02055Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				rtn = "successDEL";
			}		
		} catch (Exception e) {
			e.printStackTrace();
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return rtn;
	}	
	
	public String delSel() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt02055 t02055 = new Pgt02055();
			t02055.setChkDel(chkDel);
			t02055.setCd00002Czr(sessionCtrl.getUserId());
			t02055.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02055Service.GetSelDeleteCommand(t02055)){
				msgDel = "删除成功";
			}
		}catch(Exception e){
			e.printStackTrace();
			msgDel = "删除失败：" + e.getMessage();
			if(LOG.isDebugEnabled()){
				LOG.debug("delSel() ********** end **********");
			}
			return SUCCESS;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 信息导出
	 */
	public String exportT02055()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02055() ********** start **********");
		}
		Pgv02055 t02055 = new Pgv02055();
		try {
			//准备查询条件
			t02055.setCd00001Szqy(ddlSZQYFind);
			t02055.setPageIndex(1);
			t02055.setCd00001Fwlx(txtFWLXFind);
			t02055.setPageSize(-1);
			t02055.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02055.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02055Service.ExportT02055(t02055);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02055() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02055() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		sessionCtrl.appSession = session;
	}

	/**
	 * 读取【所在区域】
	 */
	private void ReadInfo() {
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	
	
	
	
	
	
	/**
	 * 文件上传
	 */
	public String upload() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** start **********");
		}
		try{
			String fileName = sessionCtrl.getUserId() + "_MJFWXZ" + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
//			fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + "\\" + fileName;
			//将上传文件路径装入SESSION
			Common.addUploadFiles(fileServerPath);
			FileUtil.copyFile(fileServerPath, getUpload());
			
		}catch(Exception e){
			e.printStackTrace();
			
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	/**
	 * 文件导入前的验证
	 */
	public void validateImportFile() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** start **********");
		}
		
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查");
		}
		try{
			Pgv02055List = Excel.importDataJSXZ(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkJZMJ(Pgv02055List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv02055List.size() == 0){
				this.addActionError("检查发现没有数据可以导入！");
			}
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage().replace("\n", " "));
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** end **********");
		}
		
	}
	
	private boolean checkJZMJ(ArrayList<Pgv02055> v02055List){
		return true;
	}
	
	/**
	 * 文件导入
	 */
	public String importFile()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** start **********");
		}
		
		try{
			Pgv02055 result = t02055Service.ImportExcelData(Pgv02055List);
			if(result.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataJSXZ(result.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的进深修正数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
			}
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("importFile() ********** end **********");
			}
			return INPUT;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	//新页面
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String executeA() throws Exception {
		try {
			ReadInfo();
		} catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}

	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String queryA() throws Exception {
		Pgv02055 t02055 = new Pgv02055();
		try {
			//准备查询条件
			t02055.setCd00001Szqy(ddlSZQYFind);
			t02055.setPageIndex(pageIndex);
			t02055.setCd00001Fwlx(txtFWLX);
			t02055.setCd02050Xqdm(txtXQFind);
			t02055.setPageSize(getPageSize());
			t02055.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = t02055Service.LoadAllA(t02055);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
			}else{
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String createA() throws Exception{
		try {
			ReadInfo();
			if(!Constant.MOD_CREATE.equals(ACT)){
				//取得用户选中的数据信息
				t02055Bean = t02055Service.LoadByPrimaryKeyA(new Pgt02055(pk));
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	/**
	 * 点击单选按钮的AJAX事件
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */

	public String createByAjaxA()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt02055 t02055 = new Pgt02055();
		try{
			if(!Constant.MOD_CREATE.equals(getACT())){
				t02055.setCd00001Szqy(ddlSZQY);
				t02055.setCd00001Fwlx(txtFWLX);
				t02055.setCd02050Xqdm(txtXQDM);
				t02055.setJsMin(BigDecimal.valueOf(ConvertUtil.toDouble(txtJSMIN))); 
				t02055.setJsMax(BigDecimal.valueOf(ConvertUtil.toDouble(txtJSMAX)));
				t02055Bean = t02055Service.LoadByPrimaryAddKeyA(t02055);
				isExists = t02055Bean.getUpddate() == null?true:false;
				
			}
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage());
			
			if(LOG.isDebugEnabled()){
				LOG.debug("createByAjax() ********** end **********");
			}
			
			return ERROR;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("createByAjax() ********** end **********");
		}
		return SUCCESS;
		
	}
	
	/**
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdateA() throws Exception{
		this.clearErrorsAndMessages();	
		ReadInfo();
		t02055Bean = new Pgt02055(txtID);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(ACT)){
			t02055Bean = t02055Service.LoadByPrimaryKeyA(t02055Bean);			
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(ACT))&&(!t02055Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02055Bean.setCd00001Szqy(ddlSZQY);
			t02055Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02055Bean.setXzxs(BigDecimal.valueOf(ConvertUtil.toDouble(txtXZXS)));
			t02055Bean.setJsMin(BigDecimal.valueOf(ConvertUtil.toDouble(txtJSMIN)));
			t02055Bean.setJsMax(BigDecimal.valueOf(ConvertUtil.toDouble(txtJSMAX)));
			t02055Bean.setNote(CheckUtil.chkTrim(txtNOTE));
			t02055Bean.setCd00001Fwlx(CheckUtil.chkTrim(txtFWLX));
			t02055Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02055Bean.setCd02050Xqdm(txtXQDM);
		}
	}
	
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String updateA() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		String rtn = "success";
		try {
			if(Constant.MOD_CREATE.equals(ACT)){			// Create
				if(t02055Service.GetInsertCommandA(t02055Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t02055Service.GetUpdateCommandA(t02055Bean)){
					t02055Bean = t02055Service.LoadByPrimaryKeyA(t02055Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t02055Service.GetDeleteCommandA(t02055Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				rtn = "successDEL";
			}		
		} catch (Exception e) {
			e.printStackTrace();
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return rtn;
	}	
	
	public String delSelA() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt02055 t02055 = new Pgt02055();
			t02055.setChkDel(chkDel);
			t02055.setCd00002Czr(sessionCtrl.getUserId());
			t02055.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02055Service.GetSelDeleteCommandA(t02055)){
				msgDel = "删除成功";
			}
		}catch(Exception e){
			e.printStackTrace();
			msgDel = "删除失败：" + e.getMessage();
			if(LOG.isDebugEnabled()){
				LOG.debug("delSel() ********** end **********");
			}
			return SUCCESS;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 信息导出
	 */
	public String exportT02055A()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02055() ********** start **********");
		}
		Pgv02055 t02055 = new Pgv02055();
		try {
			//准备查询条件
			t02055.setCd00001Szqy(ddlSZQYFind);
			t02055.setCd02050Xqdm(txtXQFind);
			t02055.setPageIndex(1);
			t02055.setCd00001Fwlx(txtFWLXFind);
			t02055.setPageSize(-1);
			t02055.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02055.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02055Service.ExportT02055A(t02055);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02055() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02055() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	/**
	 * 文件上传
	 */
	public String uploadA() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** start **********");
		}
		try{
			String fileName = sessionCtrl.getUserId() + "_MJFWXZ" + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
//			fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + "\\" + fileName;
			//将上传文件路径装入SESSION
			Common.addUploadFiles(fileServerPath);
			FileUtil.copyFile(fileServerPath, getUpload());
		}catch(Exception e){
			e.printStackTrace();
			
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	/**
	 * 文件导入前的验证
	 */
	public void validateImportFileA() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** start **********");
		}
		
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查");
		}
		try{
			Pgv02055List = Excel.importDataJSXZA(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkJZMJA(Pgv02055List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv02055List.size() == 0){
				this.addActionError("数据不符合导入要求");
			}
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage().replace("\n", "<br />"));
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** end **********");
		}
		
	}
	
	private boolean checkJZMJA(ArrayList<Pgv02055> v02055List){
		return true;
	}
	
	/**
	 * 文件导入
	 */
	public String importFileA()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** start **********");
		}
		
		try{
			Pgv02055 result = t02055Service.ImportExcelDataA(Pgv02055List);
			if(result.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataJSXZA(result.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的进深修正数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
			}
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("importFile() ********** end **********");
			}
			return INPUT;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	
	/**************** set and get *********************/

	/**
	 * @param t02055Service the t02055Service to set
	 */
	public void setT02055Service(IPgt02055Service t02055Service) {
		this.t02055Service = t02055Service;
	}

	/**
	 * @return the t02055Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02055Service getT02055Service() {
		return t02055Service;
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
	 * 
	 * @return the rows
	 */
	public ArrayList<Pgv02055> getRows() {
		return rows;
	}
	/**
	 * 
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv02055> rows) {
		this.rows = rows;
	}


	/**
	 * @return the pk
	 */
	public String getPk() {
		return pk;
	}

	/**
	 * @param pk the pk to set
	 */
	public void setPk(String pk) {
		this.pk = pk;
	}

	/**
	 * @return the t02055Bean
	 */
	public Pgt02055 getT02055Bean() {
		return t02055Bean;
	}

	/**
	 * @param t02055Bean the t02055Bean to set
	 */
	public void setT02055Bean(Pgt02055 t02055Bean) {
		this.t02055Bean = t02055Bean;
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
	 * @return the txtID
	 */
	public String getTxtID() {
		return txtID;
	}

	/**
	 * @param txtID the txtID to set
	 */
	public void setTxtID(String txtID) {
		this.txtID = txtID;
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
	 * @return the txtXZXS
	 */
	public String getTxtXZXS() {
		return txtXZXS;
	}

	/**
	 * @param txtXZXS the txtXZXS to set
	 */
	public void setTxtXZXS(String txtXZXS) {
		this.txtXZXS = txtXZXS;
	}

	
	/**
	 * @return the txtMKMIN
	 */
	
	public String getTxtJSMIN() {
		return txtJSMIN;
	}

	/**
	 * @param txtMKMIN the txtMKMIN to set
	 */
	public void setTxtJSMIN(String txtJSMIN) {
		this.txtJSMIN = txtJSMIN;
	}

	/**
	 * @return the txtMKMAX
	 */
	public String getTxtJSMAX() {
		return txtJSMAX;
	}

	/**
	 * @param txtMKMAX the txtMKMAX to set
	 */
	public void setTxtJSMAX(String txtJSMAX) {
		this.txtJSMAX = txtJSMAX;
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
	 * @param ddlSZQYFind the ddlSZQYFind to set
	 */
	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
	}

	/**
	 * @return the ddlSZQYFind
	 */
	public String getDdlSZQYFind() {
		return ddlSZQYFind;
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
	 * 
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * 
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	/**
	 * 
	 * @return the txtFWLX
	 */
	public String getTxtFWLX() {
		return txtFWLX;
	}
	/**
	 * 
	 * @param txtFWLX the txtFWLX to set
	 */
	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getFileServerPath() {
		return fileServerPath;
	}

	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
	}

	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getTxtFilePath() {
		return txtFilePath;
	}

	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<Pgv02055> getPgv02055List() {
		return Pgv02055List;
	}

	public void setPgv02055List(ArrayList<Pgv02055> pgv02055List) {
		Pgv02055List = pgv02055List;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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

	public String getTxtFWLXFind() {
		return txtFWLXFind;
	}

	public void setTxtFWLXFind(String txtFWLXFind) {
		this.txtFWLXFind = txtFWLXFind;
	}

	public String getChkDel() {
		return chkDel;
	}

	public void setChkDel(String chkDel) {
		this.chkDel = chkDel;
	}

	public String getMsgDel() {
		return msgDel;
	}

	public void setMsgDel(String msgDel) {
		this.msgDel = msgDel;
	}

	public String getTxtXQDM() {
		return txtXQDM;
	}

	public void setTxtXQDM(String txtXQDM) {
		this.txtXQDM = txtXQDM;
	}
	public String getTxtXQFind() {
		return txtXQFind;
	}

	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}

}
