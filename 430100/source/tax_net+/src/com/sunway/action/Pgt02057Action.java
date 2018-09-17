package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;






import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02057Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02057;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02057;

import java.io.File;

import com.sunway.util.Excel;

import org.apache.struts2.ServletActionContext;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
/**
 * 收益法资本化率维护(Pgt02057)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt02057Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 8065904121651348703L;

	//Service
	private IPgt02057Service t02057Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	//Bean数组
	private ArrayList<Pgv02057> rows;
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv02057> Pgv02057List;

	//查询条件
	private String ddlSZQYFind;
	private String txtFWLXFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt02057 t02057Bean;
	//primary key 主键
	private String FWLX;
	private String fwlx;
	private String SZQY;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String txtFWLX;
	private String txtNOTE;
	private String txtUPDATE;
	private String txtZBHL;
	private String ddlSZQY;
	private Boolean isExists;
	
	private String ACTIONNAME;
	private String HREFNAME;
	private String TITLENAME;
	private String URL;
	private String ddlPSSD;
	private SessionCtrl sessionCtrl=new SessionCtrl();
	private String userRole;
	//file upload
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String ddlImportLx;
	private String fileServerPath;
	//file import
	private String txtFilePath;
	private ArrayList<Pgt02057> Pgt02057List;
	private ArrayList<Pgv02057> ebList;
	//分页
	private String processMsg;
	private Integer processCent;
	//索引条件
	private InputStream excelStream;
	private String fileName;
	
	private String chkDel;
	private String msgDel;
	private Integer rdoJSLX;

	private String XQDM;

	private String txtXQDM;

	private String txtXQFind;

	private String txtXQTIP;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
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
		
		Pgv02057 v02057 = new Pgv02057();
		try {
			//准备查询条件

			v02057.setPageIndex(pageIndex);
			v02057.setPageSize(getPageSize());
			v02057.setCd00001Szqy(ddlSZQYFind);
			v02057.setCd00001Fwlx(txtFWLXFind);
			v02057.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = t02057Service.LoadAll(v02057);
			
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
				
			}else{
				
				pageIndex = 1;total = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	public String queryA() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryA() ********** start **********");
		}
		
		Pgv02057 v02057 = new Pgv02057();
		try {
			//准备查询条件

			v02057.setPageIndex(pageIndex);
			v02057.setPageSize(getPageSize());
			v02057.setCd00001Szqy(ddlSZQYFind);
			v02057.setCd00001Fwlx(txtFWLXFind);
			v02057.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02057.setCd02050Xqdm(txtXQFind);
			//执行查询
			rows = t02057Service.LoadAllA(v02057);
			
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
				
			}else{
				
				pageIndex = 1;total = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryA() ********** end **********");
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
		
		Pgt02057 t02057 = new Pgt02057();
		try {
			//读取用户权限
			ReadUserRole();
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02057.setCd00001Fwlx(FWLX);
				t02057.setCd00001Szqy(SZQY);
				t02057Bean = t02057Service.LoadByPrimaryKey(t02057);
				if (CheckUtil.chkEmpty(t02057Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
			}
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
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
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	
	public String createA() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createA() ********** start **********");
		}
		
		Pgt02057 t02057 = new Pgt02057();
		try {
			//读取用户权限
			ReadUserRole();
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02057.setCd00001Fwlx(FWLX);
				t02057.setCd02050Xqdm(XQDM);
				t02057Bean = t02057Service.LoadByPrimaryKeyA(t02057);
				if (CheckUtil.chkEmpty(t02057Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
			}
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("createA() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("createA() ********** end **********");
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
		szqyList = sessionCtrl.ReadSzqyList();
	    t02057Bean= new Pgt02057();
		t02057Bean.setCd00001Fwlx(txtFWLX);
		t02057Bean.setCd00001Szqy(ddlSZQY);
		t02057Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		this.clearErrorsAndMessages();
		ReadInfo();	
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02057Bean = t02057Service.LoadByPrimaryKey(t02057Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!CheckUtil.chkEmpty(t02057Bean.getUpddate()))){
			t02057Bean.setCd00001Fwlx(txtFWLX);
			t02057Bean.setCd00001Szqy(ddlSZQY);
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.szqy")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02057Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			t02057Bean.setCd00001Fwlx(txtFWLX);
			t02057Bean.setCd00001Szqy(ddlSZQY);
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值

			t02057Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02057Bean.setZbhl(ConvertUtil.toDouble(txtZBHL));
			t02057Bean.setNote(CheckUtil.chkTrim(txtNOTE));
			t02057Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	/**
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdateA() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdateA() ********** start **********");
		}
		szqyList = sessionCtrl.ReadSzqyList();
	    t02057Bean= new Pgt02057();
		t02057Bean.setCd00001Fwlx(txtFWLX);
		t02057Bean.setCd02050Xqdm(txtXQDM);
		t02057Bean.setCd00001Szqy(ddlSZQY);
		t02057Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		this.clearErrorsAndMessages();
		ReadInfo();	
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02057Bean = t02057Service.LoadByPrimaryKeyA(t02057Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!CheckUtil.chkEmpty(t02057Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.szqy")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02057Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值

			t02057Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02057Bean.setZbhl(ConvertUtil.toDouble(txtZBHL));
			t02057Bean.setNote(CheckUtil.chkTrim(txtNOTE));
			t02057Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdateA() ********** end **********");
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
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t02057Service.GetInsertCommand(getT02057Bean())){
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT02057Bean().getCd00001Fwlx()}));
					t02057Bean.clear();
				}
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT02057Bean().getCd00001Fwlx()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02057Service.GetUpdateCommand(getT02057Bean())){
					t02057Bean = t02057Service.LoadByPrimaryKey(t02057Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT02057Bean().getCd00001Fwlx()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT02057Bean().getCd00001Fwlx()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02057Service.GetDeleteCommand(getT02057Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT02057Bean().getCd00001Fwlx()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT02057Bean().getCd00001Fwlx()}));
				rtn = "successDEL";
			}		
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
			String[] msg = e.getMessage().split("\n");
			this.addActionError(msg[0]);

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return rtn;
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
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t02057Service.GetInsertCommandA(getT02057Bean())){
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT02057Bean().getCd00001Fwlx()}));
					t02057Bean.clear();
				}
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT02057Bean().getCd00001Fwlx()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02057Service.GetUpdateCommandA(getT02057Bean())){
					t02057Bean = t02057Service.LoadByPrimaryKeyA(t02057Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT02057Bean().getCd00001Fwlx()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT02057Bean().getCd00001Fwlx()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02057Service.GetDeleteCommandA(getT02057Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT02057Bean().getCd00001Fwlx()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT02057Bean().getCd00001Fwlx()}));
				rtn = "successDEL";
			}		
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
			String[] msg = e.getMessage().split("\n");
			this.addActionError(msg[0]);

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return rtn;
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
		
		Pgt02057 t02057 = new Pgt02057();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02057.setCd00001Fwlx(FWLX);
				t02057.setCd00001Szqy(SZQY);
				t02057Bean = t02057Service.LoadByPrimaryKey(t02057);
				isExists = t02057Bean.getUpddate() == null?true:false;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	

	public String createByAjaxA() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt02057 t02057 = new Pgt02057();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02057.setCd00001Fwlx(FWLX);
				t02057.setCd00001Szqy(ddlSZQY);
				t02057.setCd02050Xqdm(txtXQDM);
				t02057Bean = t02057Service.LoadByPrimaryKeyA(t02057);
				isExists = t02057Bean.getUpddate() == null?true:false;
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	 * 文件上传
	 */
	public String upload()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** start **********");
		}
		
		try{
			String fileName = sessionCtrl.getUserId() + "_JYRQXZ" + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
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
	 * 文件上传
	 */
	public String uploadA()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** start **********");
		}
		
		try{
			String fileName = sessionCtrl.getUserId() + "_JYRQXZA" + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
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
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	public void validateImportFile() {
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查！");
		}
		try{
			//检验数据合法性
			Pgv02057List = Excel.importDataZbhsjSY(txtFilePath, sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkZbhdj(Pgv02057List))
				this.addActionError("资本化率系数修正数据不符合导入要求！");
			if(Pgv02057List.size()==0)
				this.addActionError("检查发现没有数据可以导入！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError("文件错误，请检查！");
		}
	}
	public void validateImportFileA() {
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查！");
		}
		try{
			//检验数据合法性
			Pgv02057List = Excel.importDataZbhsjASY(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkZbhdj(Pgv02057List))
				this.addActionError("资本化率系数修正数据不符合导入要求！");
			if(Pgv02057List.size()==0)
				this.addActionError("资本化率系数修正数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError("文件错误，请检查！");
		}
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String importFile() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** start **********");
		}
		try{
			Pgv02057 iResult = t02057Service.ImportExcelData(Pgv02057List);
			if(iResult.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
				
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportSYzbhlCommonDataSY(iResult.getOutList(),1);
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的资本化率系数修正数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	public String importFileA() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("importFileA() ********** start **********");
		}
		try{
			Pgv02057 iResult = t02057Service.ImportExcelDataA(Pgv02057List);
			if(iResult.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
				
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportSYzbhlCommonDataASY(iResult.getOutList(),1);
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的资本化率系数修正数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
				
			}
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("importFileA() ********** end **********");
			}
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("importFileA() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 对[收益法资本化率维护数据]合法性进行检验
	 * @param list
	 * @return
	 */
	private Boolean checkZbhdj(ArrayList<Pgv02057> Pgv02057List){
		
		return true;
	}
	
	public String delSel() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSelA() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt02057 t02057 = new Pgt02057();
			t02057.setChkDel(chkDel);
			t02057.setCd00002Czr(sessionCtrl.getUserId());
			t02057.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02057Service.GetSelDeleteCommand(t02057)){
				msgDel = "删除成功";
			}
		}catch(Exception e){
			e.printStackTrace();
			msgDel = "删除失败：" + e.getMessage();
			if(LOG.isDebugEnabled()){
				LOG.debug("delSelA() ********** end **********");
			}
			return SUCCESS;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("delSelA() ********** end **********");
		}
		return SUCCESS;
	}
	public String delSelA() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt02057 t02057 = new Pgt02057();
			t02057.setChkDel(chkDel);
			t02057.setCd00002Czr(sessionCtrl.getUserId());
			t02057.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02057Service.GetSelDeleteCommandA(t02057)){
				msgDel = "删除成功";
			}
		}catch(Exception e){
			e.printStackTrace();
			msgDel = "删除失败：" + e.getMessage();
			if(LOG.isDebugEnabled()){
			}
			return SUCCESS;
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("delSelA() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 分区资本化率系数修正信息导出
	 */
	public String exportT02057() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02057() ********** start **********");
		}
		
		Pgv02057 v02057 = new Pgv02057();
		try {
			//准备查询条件
			v02057.setPageIndex(1);
			v02057.setPageSize(-1);
			v02057.setCd00001Szqy(ddlSZQYFind);
			v02057.setCd00001Fwlx(txtFWLX);
			v02057.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));	
			v02057.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02057Service.ExportJYSJ(v02057);		
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02057() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02057() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	/**
	 * 小区资本化率系数修正信息导出
	 */
	public String exportT02057A() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02057A() ********** start **********");
		}
		
		Pgv02057 v02057 = new Pgv02057();
		try {
			//准备查询条件
			v02057.setCd00001Szqy(ddlSZQYFind);
			v02057.setCd02050Xqdm(txtXQFind);
			v02057.setCd00001Fwlx(txtFWLXFind);
			v02057.setPageIndex(1);
			v02057.setPageSize(-1);
			v02057.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02057.setIstrue(rdoJSLX);
			v02057.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02057Service.ExportJYSJA(v02057);		
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02057A() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02057A() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	/**
	 * 读取用户权限
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void ReadUserRole() throws Exception{
		ArrayList<String> roleList = (ArrayList<String>)sessionCtrl.GetList(SessionCtrl.SESSION_KEY_USERROLE);
		userRole = Common.converRoleListToString(roleList);
	}
	/*********************** set and get ******************************/
	
	/**
	 * @return the t02057Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02057Service getT02057Service() {
		return t02057Service;
	}

	/**
	 * @param t02057Service the t02057Service to set
	 */
	public void setT02057Service(IPgt02057Service t02057Service) {
		this.t02057Service = t02057Service;
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
	 * @return the ddlSZQYFind
	 */
	public String getDdlSZQYFind() {
		return ddlSZQYFind;
	}

	/**
	 * @param ddlSZQYFind the ddlSZQYFind to set
	 */
	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
	}

	/**
	 * @return the txtFWLXFind
	 */
	public String getTxtFWLXFind() {
		return txtFWLXFind;
	}

	/**
	 * @param txtFWLXFind the txtFWLXFind to set
	 */
	public void setTxtFWLXFind(String txtFWLXFind) {
		this.txtFWLXFind = txtFWLXFind;
	}

	/**
	 * @return the t02057Bean
	 */
	public Pgt02057 getT02057Bean() {
		return t02057Bean;
	}

	/**
	 * @param t02057Bean the t02057Bean to set
	 */
	public void setT02057Bean(Pgt02057 t02057Bean) {
		this.t02057Bean = t02057Bean;
	}

	/**
	 * @return the fWLX
	 */
	public String getFWLX() {
		return FWLX;
	}

	/**
	 * @param fWLX the fWLX to set
	 */
	public void setFWLX(String fWLX) {
		FWLX = fWLX;
	}

	/**
	 * @return the sZQY
	 */
	public String getSZQY() {
		return SZQY;
	}

	/**
	 * @param sZQY the sZQY to set
	 */
	public void setSZQY(String sZQY) {
		SZQY = sZQY;
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
	 * @return the txtFWLX
	 */
	public String getTxtFWLX() {
		return txtFWLX;
	}

	/**
	 * @param txtFWLX the txtFWLX to set
	 */
	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
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
	 * @return the txtZBHL
	 */
	public String getTxtFYBL() {
		return txtZBHL;
	}

	/**
	 * @param txtZBHL the txtZBHL to set
	 */
	public void setTxtFYBL(String txtZBHL) {
		this.txtZBHL = txtZBHL;
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
	 * @return the txtZBHL
	 */
	public String getTxtZBHL() {
		return txtZBHL;
	}

	/**
	 * @param txtZBHL the txtZBHL to set
	 */
	public void setTxtZBHL(String txtZBHL) {
		this.txtZBHL = txtZBHL;
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

	/**
	 * @return the aCTIONNAME
	 */
	public String getACTIONNAME() {
		return ACTIONNAME;
	}

	/**
	 * @param aCTIONNAME the aCTIONNAME to set
	 */
	public void setACTIONNAME(String aCTIONNAME) {
		ACTIONNAME = aCTIONNAME;
	}

	/**
	 * @return the hREFNAME
	 */
	public String getHREFNAME() {
		return HREFNAME;
	}

	/**
	 * @param hREFNAME the hREFNAME to set
	 */
	public void setHREFNAME(String hREFNAME) {
		HREFNAME = hREFNAME;
	}

	/**
	 * @return the tITLENAME
	 */
	public String getTITLENAME() {
		return TITLENAME;
	}

	/**
	 * @param tITLENAME the tITLENAME to set
	 */
	public void setTITLENAME(String tITLENAME) {
		TITLENAME = tITLENAME;
	}

	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	/**
	 * @return the ddlPSSD
	 */
	public String getDdlPSSD() {
		return ddlPSSD;
	}

	/**
	 * @param ddlPSSD the ddlPSSD to set
	 */
	public void setDdlPSSD(String ddlPSSD) {
		this.ddlPSSD = ddlPSSD;
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the upload
	 */
	public File getUpload() {
		return upload;
	}

	/**
	 * @param upload the upload to set
	 */
	public void setUpload(File upload) {
		this.upload = upload;
	}

	/**
	 * @return the uploadContentType
	 */
	public String getUploadContentType() {
		return uploadContentType;
	}

	/**
	 * @param uploadContentType the uploadContentType to set
	 */
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * @return the uploadFileName
	 */
	public String getUploadFileName() {
		return uploadFileName;
	}

	/**
	 * @param uploadFileName the uploadFileName to set
	 */
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	/**
	 * @return the savePath
	 */
	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	/**
	 * @return the ddlImportLx
	 */
	public String getDdlImportLx() {
		return ddlImportLx;
	}

	/**
	 * @param ddlImportLx the ddlImportLx to set
	 */
	public void setDdlImportLx(String ddlImportLx) {
		this.ddlImportLx = ddlImportLx;
	}

	/**
	 * @return the fileServerPath
	 */
	public String getFileServerPath() {
		return fileServerPath;
	}

	/**
	 * @param fileServerPath the fileServerPath to set
	 */
	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
	}
/**
	 * @return the txtFilePath
	 */
	public String getTxtFilePath() {
		return txtFilePath;
	}

	/**
	 * @param txtFilePath the txtFilePath to set
	 */
	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}

	/**
	 * @return the pgt02057List
	 */
	public ArrayList<Pgt02057> getPgt02057List() {
		return Pgt02057List;
	}

	/**
	 * @param pgt02057List the pgt02057List to set
	 */
	public void setPgt02057List(ArrayList<Pgt02057> pgt02057List) {
		Pgt02057List = pgt02057List;
	}

/**
	 * @return the processMsg
	 */
	public String getProcessMsg() {
		return processMsg;
	}

	/**
	 * @param processMsg the processMsg to set
	 */
	public void setProcessMsg(String processMsg) {
		this.processMsg = processMsg;
	}
/**
	 * @return the processCent
	 */
	public Integer getProcessCent() {
		return processCent;
	}

	/**
	 * @param processCent the processCent to set
	 */
	public void setProcessCent(Integer processCent) {
		this.processCent = processCent;
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

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	public void setRows(ArrayList<Pgv02057> rows) {
		this.rows = rows;
	}

	public ArrayList<Pgv02057> getRows() {
		return rows;
	}

	/**
	 * @return the ebList
	 */
	public ArrayList<Pgv02057> getEbList() {
		return ebList;
	}

	/**
	 * @param ebList the ebList to set
	 */
	public void setEbList(ArrayList<Pgv02057> ebList) {
		this.ebList = ebList;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession=arg0;
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

	public Integer getRdoJSLX() {
		return rdoJSLX;
	}

	public void setRdoJSLX(Integer rdoJSLX) {
		this.rdoJSLX = rdoJSLX;
	}
	public String getXQDM() {
		return XQDM;
	}

	public void setXQDM(String xQDM) {
		XQDM = xQDM;
	}
	public ArrayList<Pgv02057> getPgv02057List() {
		return Pgv02057List;
	}

	public void setPgv02057List(ArrayList<Pgv02057> pgv02057List) {
		Pgv02057List = pgv02057List;
	}
	/**
	 * 为参数复制页面赋值
	 */
	private void ReadInfo(){
		setACTIONNAME("EXET02057COPY");
		setHREFNAME("VIEWT02057");
		setTITLENAME(getText("app.xtwh.t02057.title"));
		setURL("020579");
		szqyList = sessionCtrl.ReadSzqyList();
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

	public String getTxtXQTIP() {
		return txtXQTIP;
	}

	public void setTxtXQTIP(String txtXQTIP) {
		this.txtXQTIP = txtXQTIP;
	}

	public String getFwlx() {
		return fwlx;
	}

	public void setFwlx(String fwlx) {
		this.fwlx = fwlx;
	}
	
	
}
