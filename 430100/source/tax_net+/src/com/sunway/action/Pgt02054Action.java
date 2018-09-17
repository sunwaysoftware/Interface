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
import com.sunway.service.IPgt02054Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02054;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02054;

/**
 * 
 * 面宽修正
 * @author Andy
 *
 */
public class Pgt02054Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 4339619369756654435L;
	private IPgt02054Service t02054Service;
	private String ACT;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//分页参数
	private Integer pageSize;
	private Integer pageIndex;
	private Integer total;
	//view
	private ArrayList<Pgv02054> rows;
	private String ddlSZQYFind;
	private String txtFWLXFind;
	//edit
	private String pk;
	private Pgt02054 t02054Bean;
	private ArrayList<Pgv00052> szqyList;
	private String txtUPDATE;
	private String txtID;
	private String ddlSZQY;
	private String txtXZXS;
	private String txtMKMIN;
	private String txtMKMAX;
	private String txtNOTE;
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
	private ArrayList<Pgv02054> Pgv02054List;
	
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
		Pgv02054 t02054 = new Pgv02054();
		try {
			//准备查询条件
			t02054.setCd00001Szqy(ddlSZQYFind);
			t02054.setPageIndex(pageIndex);
			t02054.setCd00001Fwlx(txtFWLX);
			t02054.setPageSize(getPageSize());
			t02054.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = t02054Service.LoadAll(t02054);
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
				t02054Bean = t02054Service.LoadByPrimaryKey(new Pgt02054(pk));
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
		
		Pgt02054 t02054 = new Pgt02054();
		try{
			if(!Constant.MOD_CREATE.equals(getACT())){
				
				t02054.setCd00001Szqy(ddlSZQY);
				t02054.setCd00001Fwlx(txtFWLX);
				t02054.setMkMin(BigDecimal.valueOf(ConvertUtil.toDouble(txtMKMIN))); 
				t02054.setMkMax(BigDecimal.valueOf(ConvertUtil.toDouble(txtMKMAX)));
				t02054Bean = t02054Service.LoadByPrimaryAddKey(t02054);
				isExists = t02054Bean.getUpddate() == null?true:false;
				
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
		t02054Bean = new Pgt02054(txtID);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(ACT)){
			t02054Bean = t02054Service.LoadByPrimaryKey(t02054Bean);			
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(ACT))&&(!t02054Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02054Bean.setCd00001Szqy(ddlSZQY);
			t02054Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02054Bean.setXzxs(BigDecimal.valueOf(ConvertUtil.toDouble(txtXZXS)));
			t02054Bean.setMkMin(BigDecimal.valueOf(ConvertUtil.toDouble(txtMKMIN)));
			t02054Bean.setMkMax(BigDecimal.valueOf(ConvertUtil.toDouble(txtMKMAX)));
			t02054Bean.setNote(CheckUtil.chkTrim(txtNOTE));
			t02054Bean.setCd00001Fwlx(CheckUtil.chkTrim(txtFWLX));
			t02054Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if(t02054Service.GetInsertCommand(t02054Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t02054Service.GetUpdateCommand(t02054Bean)){
					t02054Bean = t02054Service.LoadByPrimaryKey(t02054Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t02054Service.GetDeleteCommand(t02054Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				rtn = "successDEL";
			}		
			szqyList = sessionCtrl.ReadSzqyList();
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
			Pgt02054 t02054 = new Pgt02054();
			t02054.setChkDel(chkDel);
			t02054.setCd00002Czr(sessionCtrl.getUserId());
			t02054.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02054Service.GetSelDeleteCommand(t02054)){
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
	public String exportT02054()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02054() ********** start **********");
		}
		Pgv02054 t02054 = new Pgv02054();
		try {
			//准备查询条件
			t02054.setCd00001Szqy(ddlSZQYFind);
			t02054.setPageIndex(1);
			t02054.setCd00001Fwlx(txtFWLXFind);
			t02054.setPageSize(-1);
			t02054.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02054.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02054Service.ExportT02054(t02054);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02054() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02054() ********** end **********");
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
			Pgv02054List = Excel.importDataMKXZ(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkJZMJ(Pgv02054List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv02054List.size() == 0){
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
	
	private boolean checkJZMJ(ArrayList<Pgv02054> v02054List){
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
			Pgv02054 result = t02054Service.ImportExcelData(Pgv02054List);
			if(result.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataMKXZ(result.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的面宽修正数据.xls".getBytes("GBK"),"ISO-8859-1");
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
		Pgv02054 t02054 = new Pgv02054();
		try {
			//准备查询条件
			t02054.setCd00001Szqy(ddlSZQYFind);
			t02054.setPageIndex(pageIndex);
			t02054.setCd00001Fwlx(txtFWLX);
			t02054.setCd02050Xqdm(txtXQFind);
			t02054.setPageSize(getPageSize());
			t02054.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = t02054Service.LoadAllA(t02054);
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
				t02054Bean = t02054Service.LoadByPrimaryKeyA(new Pgt02054(pk));
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
		
		Pgt02054 t02054 = new Pgt02054();
		try{
			if(!Constant.MOD_CREATE.equals(getACT())){
				t02054.setCd00001Szqy(ddlSZQY);
				t02054.setCd00001Fwlx(txtFWLX);
				t02054.setCd02050Xqdm(txtXQDM);
				t02054.setMkMin(BigDecimal.valueOf(ConvertUtil.toDouble(txtMKMIN))); 
				t02054.setMkMax(BigDecimal.valueOf(ConvertUtil.toDouble(txtMKMAX)));
				t02054Bean = t02054Service.LoadByPrimaryAddKeyA(t02054);
				isExists = t02054Bean.getUpddate() == null?true:false;
				
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
		t02054Bean = new Pgt02054(txtID);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(ACT)){
			t02054Bean = t02054Service.LoadByPrimaryKeyA(t02054Bean);			
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(ACT))&&(!t02054Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02054Bean.setCd00001Szqy(ddlSZQY);
			t02054Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02054Bean.setXzxs(BigDecimal.valueOf(ConvertUtil.toDouble(txtXZXS)));
			t02054Bean.setMkMin(BigDecimal.valueOf(ConvertUtil.toDouble(txtMKMIN)));
			t02054Bean.setMkMax(BigDecimal.valueOf(ConvertUtil.toDouble(txtMKMAX)));
			t02054Bean.setNote(CheckUtil.chkTrim(txtNOTE));
			t02054Bean.setCd00001Fwlx(CheckUtil.chkTrim(txtFWLX));
			t02054Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02054Bean.setCd02050Xqdm(txtXQDM);
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
				if(t02054Service.GetInsertCommandA(t02054Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t02054Service.GetUpdateCommandA(t02054Bean)){
					t02054Bean = t02054Service.LoadByPrimaryKeyA(t02054Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t02054Service.GetDeleteCommandA(t02054Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				rtn = "successDEL";
			}		
			szqyList = sessionCtrl.ReadSzqyList();
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
			Pgt02054 t02054 = new Pgt02054();
			t02054.setChkDel(chkDel);
			t02054.setCd00002Czr(sessionCtrl.getUserId());
			t02054.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02054Service.GetSelDeleteCommandA(t02054)){
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
	public String exportT02054A()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02054() ********** start **********");
		}
		Pgv02054 t02054 = new Pgv02054();
		try {
			//准备查询条件
			t02054.setCd00001Szqy(ddlSZQYFind);
			t02054.setCd02050Xqdm(txtXQFind);
			t02054.setPageIndex(1);
			t02054.setCd00001Fwlx(txtFWLXFind);
			t02054.setPageSize(-1);
			t02054.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02054.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02054Service.ExportT02054A(t02054);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02054() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02054() ********** end **********");
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
			Pgv02054List = Excel.importDataMKXZA(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkJZMJA(Pgv02054List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv02054List.size() == 0){
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
	
	private boolean checkJZMJA(ArrayList<Pgv02054> v02054List){
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
			Pgv02054 result = t02054Service.ImportExcelDataA(Pgv02054List);
			if(result.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataMKXZA(result.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的面宽修正数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	 * @param t02054Service the t02054Service to set
	 */
	public void setT02054Service(IPgt02054Service t02054Service) {
		this.t02054Service = t02054Service;
	}

	/**
	 * @return the t02054Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02054Service getT02054Service() {
		return t02054Service;
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
	public ArrayList<Pgv02054> getRows() {
		return rows;
	}
	/**
	 * 
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv02054> rows) {
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
	 * @return the t02054Bean
	 */
	public Pgt02054 getT02054Bean() {
		return t02054Bean;
	}

	/**
	 * @param t02054Bean the t02054Bean to set
	 */
	public void setT02054Bean(Pgt02054 t02054Bean) {
		this.t02054Bean = t02054Bean;
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
	
	public String getTxtMKMIN() {
		return txtMKMIN;
	}

	/**
	 * @param txtMKMIN the txtMKMIN to set
	 */
	public void setTxtMKMIN(String txtMKMIN) {
		this.txtMKMIN = txtMKMIN;
	}

	/**
	 * @return the txtMKMAX
	 */
	public String getTxtMKMAX() {
		return txtMKMAX;
	}

	/**
	 * @param txtMKMAX the txtMKMAX to set
	 */
	public void setTxtMKMAX(String txtMKMAX) {
		this.txtMKMAX = txtMKMAX;
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

	public ArrayList<Pgv02054> getPgv02054List() {
		return Pgv02054List;
	}

	public void setPgv02054List(ArrayList<Pgv02054> pgv02054List) {
		Pgv02054List = pgv02054List;
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
