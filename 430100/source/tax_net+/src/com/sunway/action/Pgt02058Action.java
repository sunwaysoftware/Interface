package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02058Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02058;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02058;

/**
 * 商业法分区交易日期修正系数(Pgt02058)
 * @category 系统维护
 * @author LeiJia
 * @version 1.0
 */
public class Pgt02058Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1272859005538246498L;

	//Service
	private IPgt02058Service t02058Service;
	
	//View
	
	//分页参数
	private Integer pageSize;
	private Integer pageIndex;
	private Integer total;
	//Bean数组
	private ArrayList<Pgv02058> wjzsList;
	private ArrayList<Pgv00052> szqyList;
	public String getTxtXQFind() {
		return txtXQFind;
	}

	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}

	private ArrayList<Pgv02058> rows;
	//查询条件
	private String ddlSZQYFind;
	private String txtXQFind;
	private String txtFWLX;
	
	//Edit
	
	//edit页面所需Bean
	private Pgt02058 t02058Bean;
	//primary key 主键
	private String SZQY;
	private String PSSDYM;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtXZXS;
	private String txtNOTE;
	private String txtUPDATE;
	private Boolean isExists;
	
	private String ACTIONNAME;
	private String HREFNAME;
	private String txtJZMJMIN;
	private String txtJZMJMAX;
	
	private String TITLENAME;
	private String URL;
	private String ddlPSSD;
	private SessionCtrl sessionCtrl=new SessionCtrl();
	private String userRole;
	
	private String txtFORMULA;
	private String txtPSSD;
	private String txtSZQY;
	private String txtXQDM;
	private String txtQZ1;
	private String txtQZ2;
	private String txtQZ3;
	
	private InputStream excelStream;
	private String XQDM;
	//file upload
	private File upload;
	private String fileServerPath;
	private String savePath;
	private String uploadFileName;
	
	//file import
	private String txtFilePath;
	private ArrayList<Pgv02058> Pgv02058List;
	private String fileName;
	
	private String chkDel;
	private String msgDel;
	
	private Boolean isOK;
	private String id;
	
	//find02058Ajax
	private String ddlSzqy;
	private String ddlPssd;
	private String ddlXqdm;
	private Pgv02058 ddlV02058Bean;
	private String SFSC;

	private Integer JSLX;

	private Integer ddlJslx;

	private String txtID;;
	
	public String executeA() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("executeA() ********** start **********");
		}
		
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		
		if(LOG.isDebugEnabled()){
			LOG.debug("executeA() ********** end **********");
		}
		return SUCCESS;
	}
	
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
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
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
		
		Pgv02058 v02058 = new Pgv02058();
		try {
			//准备查询条件
			v02058.setCd00001Szqy(ddlSZQYFind);
			//v02058.setPssd(ConvertUtil.toUtilDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v02058.setPageIndex(pageIndex);
			v02058.setPageSize(getPageSize());
			v02058.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02058.setIstrue(0);
			v02058.setSfsc(ConvertUtil.toInteger(SFSC));
			v02058.setCd00001Fwlx(txtFWLX);
			//执行查询
			rows = t02058Service.LoadAll(v02058);			
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
			}else{
				total = 0;
				pageIndex = 1;
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
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		Pgt02058 t02058 = new Pgt02058();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				t02058.setId(id);
				t02058Bean = t02058Service.LoadByPrimaryKey(t02058);
				SFSC = t02058Bean.getSfsc().toString();
				if (CheckUtil.chkEmpty(t02058Bean.getUpddate())) {
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
		this.clearErrorsAndMessages();
		ReadInfo();
		t02058Bean = new Pgt02058();	
		
		t02058Bean.setId(txtID);		
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02058Bean = t02058Service.LoadByPrimaryKey(t02058Bean);			
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02058Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02058Bean.setCd00001Szqy(ddlSZQY);
			t02058Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
			t02058Bean.setIstrue(0);
			if(PSSDYM != null){
				t02058Bean.setCd00002Pssd(PSSDYM);
			}else if(ddlPSSD != null){
				t02058Bean.setCd00002Pssd(ddlPSSD);
			}
			t02058Bean.setCd00001Fwlx(txtFWLX);
			t02058Bean.setSfsc(ConvertUtil.toInteger(SFSC));
			t02058Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02058Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
			t02058Bean.setNote(txtNOTE);
			t02058Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02058Bean.setCd00002Pssd(CheckUtil.chkTrim(ddlPSSD));
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	/**
	 * 读取【所在区域】
	 */
	private void ReadInfo() {
		szqyList = sessionCtrl.ReadSzqyList();
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
				if(t02058Service.GetInsertCommand(getT02058Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02058Service.GetUpdateCommand(getT02058Bean())){
					t02058Bean = t02058Service.LoadByPrimaryKey(t02058Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02058Service.GetDeleteCommand(getT02058Bean())){
				//	t02058Bean = t02058Service.LoadByPrimaryKey(t02058Bean);
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
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
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return rtn;
	}
	
	public String delSel() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt02058 t02058 = new Pgt02058();
			t02058.setChkDel(chkDel);
			t02058.setCd00002Czr(sessionCtrl.getUserId());
			t02058.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02058Service.GetSelDeleteCommand(t02058)){
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
	 * 点击单选按钮的ajax事件，
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String createByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt02058 v02058 = new Pgt02058();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				v02058.setCd00001Szqy(ddlSzqy);
				v02058.setCd00002Pssd(ddlPssd);
				v02058.setIstrue(ddlJslx);
				v02058.setCd00001Fwlx(txtFWLX);
				v02058.setSfsc(ConvertUtil.toInteger(SFSC));
				t02058Bean = t02058Service.createByAjax(v02058);
				isExists = t02058Bean.getUpddate() == null?true:false;
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

	
/*	*//**
	 * 根据评税时点测算系数[回归]
	 *//*
	public String formulaVal() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal() ********** start **********");
		}
		Pgt02058 t02058 = new Pgt02058();
		try{
			t02058.setCd00002Pssd(txtPSSD);
			t02058.setCd00001Szqy(txtSZQY);
			t02058Bean = t02058Service.FormulaVal(t02058);		
			setIsOK(true);
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("formulaVal() ********** end **********");
			}
			setIsOK(false);
			return SUCCESS;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal() ********** end **********");
		}
		return SUCCESS;
	}
	
	*//**
	 * 根据评税时点测算系数[加权]
	 *//*
	public String formulaVal_JQ() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal() ********** start **********");
		}
		Pgt02058 t02058 = new Pgt02058();
		try{
			t02058.setCd00002Pssd(txtPSSD);
			t02058.setCd00001Szqy(txtSZQY);
			t02058.setQz1(ConvertUtil.toInteger(txtQZ1));
			t02058.setQz2(ConvertUtil.toInteger(txtQZ2));
			t02058.setQz3(ConvertUtil.toInteger(txtQZ3));
			t02058Bean = t02058Service.FormulaVal_JQ(t02058);		
			setIsOK(true);
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("formulaVal() ********** end **********");
			}
			setIsOK(false);
			return SUCCESS;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal() ********** end **********");
		}
		return SUCCESS;
	}	
*/
/*	*//**
	 * 根据评税时点测算系数[加权]
	 *//*
	public String formulaVal_JQ_XQ() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal() ********** start **********");
		}
		Pgt02058 t02058 = new Pgt02058();
		try{
			t02058.setCd00002Pssd(txtPSSD);
			t02058.setCd02050Xqdm(txtXQDM);
			t02058.setQz1(ConvertUtil.toInteger(txtQZ1));
			t02058.setQz2(ConvertUtil.toInteger(txtQZ2));
			t02058.setQz3(ConvertUtil.toInteger(txtQZ3));
			t02058Bean = t02058Service.FormulaVal_JQ_XQ(t02058);		
			setIsOK(true);
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("formulaVal() ********** end **********");
			}
			setIsOK(false);
			return SUCCESS;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal() ********** end **********");
		}
		return SUCCESS;
	}	
	
	*//**
	 * 根据评税时点测算系数[测算]
	 *//*
	public String formulaVal_CS() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal_CS() ********** start **********");
		}
		Pgt02058 t02058 = new Pgt02058();
		try{
			t02058.setCd00002Pssd(txtPSSD);
			t02058.setCd00001Szqy(txtSZQY);
			t02058Bean = t02058Service.FormulaVal_CS(t02058);		
			setIsOK(true);
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("formulaVal_CS() ********** end **********");
			}
			setIsOK(false);
			return SUCCESS;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal_CS() ********** end **********");
		}
		return SUCCESS;
	}	
	
	*//**
	 * 根据评税时点测算系数[测算小区]
	 *//*
	public String formulaVal_CS_XQ() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal()_CS_XQ ********** start **********");
		}
		Pgt02058 t02058 = new Pgt02058();
		try{
			t02058.setCd00002Pssd(txtPSSD);
			t02058.setCd02050Xqdm(txtXQDM);
			t02058Bean = t02058Service.FormulaVal_CS_XQ(t02058);		
			setIsOK(true);
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("formulaVal()_CS_XQ ********** end **********");
			}
			setIsOK(false);
			return SUCCESS;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal()_CS_XQ ********** end **********");
		}
		return SUCCESS;
	}*/
	
	
	
	/**
	 * 信息导出
	 */
	public String exportT02058() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02058() ********** start **********");
		}
		
		Pgv02058 v02058 = new Pgv02058();
		try {
			//准备查询条件
			v02058.setCd00001Szqy(ddlSZQYFind);
			v02058.setPageIndex(1);
			v02058.setPageSize(-1);
			v02058.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02058.setIstrue(0);
			v02058.setCd00002Czr(sessionCtrl.getUserId());
			v02058.setCd00001Fwlx(txtFWLX);
			v02058.setSfsc(ConvertUtil.toInteger(SFSC));
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02058Service.ExportJYSJ(v02058);		
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02058() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02058() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
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
			Pgv02058List = Excel.importDataJYSJSY(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX),ConvertUtil.toInteger(SFSC));
			if(!checkJYSJ(Pgv02058List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv02058List.size() == 0){
				this.addActionError("检查发现没有数据可以导入！");
			}
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage().replace("\n", "<br />"));
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** end **********");
		}
	}
	
	private boolean checkJYSJ(ArrayList<Pgv02058> Pgv02058List)throws Exception{
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
			Pgv02058 iResult = t02058Service.ImportFileData(Pgv02058List);
			if(iResult.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
				
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataJYRQXZSY(iResult.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的交易日期数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	
	public String executeAA() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("executeA() ********** start **********");
		}
		
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		
		if(LOG.isDebugEnabled()){
			LOG.debug("executeA() ********** end **********");
		}
		return SUCCESS;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String executeA1() throws Exception {
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
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
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
	public String queryA() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		Pgv02058 v02058 = new Pgv02058();
		try {
			//准备查询条件
			v02058.setCd00001Szqy(ddlSZQYFind);
			//v02058.setPssd(ConvertUtil.toUtilDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v02058.setPageIndex(pageIndex);
			v02058.setPageSize(getPageSize());
			v02058.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02058.setIstrue(0);
			v02058.setCd02050Xqdm(txtXQFind);
			v02058.setCd00001Fwlx(txtFWLX);
			v02058.setSfsc(ConvertUtil.toInteger(SFSC));
			//执行查询
			rows = t02058Service.LoadAllA(v02058);			
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
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
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	
	public String createA() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		Pgt02058 t02058 = new Pgt02058();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02058.setId(id);
				t02058Bean = t02058Service.LoadByPrimaryKeyA(t02058);
				SFSC = t02058Bean.getSfsc().toString();
				if (CheckUtil.chkEmpty(t02058Bean.getUpddate())) {
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
	public void validateUpdateA() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		this.clearErrorsAndMessages();	
		ReadInfo();
		t02058Bean = new Pgt02058();
		t02058Bean.setId(txtID);
		
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02058Bean = t02058Service.LoadByPrimaryKeyA(t02058Bean);			
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02058Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02058Bean.setCd00001Szqy(ddlSZQY);
			t02058Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
			t02058Bean.setIstrue(0);
			if(PSSDYM != null){
				t02058Bean.setCd00002Pssd(PSSDYM);
			}else if(ddlPSSD != null){
				t02058Bean.setCd00002Pssd(ddlPSSD);
			}
			t02058Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02058Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
			t02058Bean.setCd00001Fwlx(txtFWLX);
			t02058Bean.setSfsc(ConvertUtil.toInteger(SFSC));
			t02058Bean.setNote(txtNOTE);
			t02058Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02058Bean.setCd02050Xqdm(txtXQDM);
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
	public String updateA() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		String rtn = "success";
		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t02058Service.GetInsertCommandA(getT02058Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02058Service.GetUpdateCommandA(getT02058Bean())){
					t02058Bean = t02058Service.LoadByPrimaryKeyA(t02058Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02058Service.GetDeleteCommandA(getT02058Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
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
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return rtn;
	}
	
	public String delSelA() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt02058 t02058 = new Pgt02058();
			t02058.setChkDel(chkDel);
			t02058.setCd00002Czr(sessionCtrl.getUserId());
			t02058.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02058Service.GetSelDeleteCommandA(t02058)){
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
	 * 点击单选按钮的ajax事件，
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String createByAjaxA() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt02058 v02058 = new Pgt02058();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				v02058.setCd00001Szqy(ddlSzqy);
				v02058.setCd02050Xqdm(ddlXqdm);
				v02058.setCd00002Pssd(ddlPssd);
				v02058.setIstrue(ddlJslx);
				v02058.setCd00001Fwlx(txtFWLX);
				v02058.setSfsc(ConvertUtil.toInteger(SFSC));
				t02058Bean = t02058Service.createByAjaxA(v02058);
				isExists = t02058Bean.getUpddate() == null?true:false;
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
	 * 根据评税时点测算系数
	 */
	public String formulaVal_XQ() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal() ********** start **********");
		}
		Pgt02058 t02058 = new Pgt02058();
		try{
			t02058.setCd00002Pssd(txtPSSD);
			t02058.setCd02050Xqdm(txtXQDM);
			t02058Bean = t02058Service.FormulaVal_XQ(t02058);		
			setIsOK(true);
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("formulaVal() ********** end **********");
			}
			setIsOK(false);
			return SUCCESS;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("formulaVal() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	
	/**
	 * 信息导出
	 */
	public String exportT02058A() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02058() ********** start **********");
		}
		
		Pgv02058 v02058 = new Pgv02058();
		try {
			//准备查询条件
			v02058.setCd00001Szqy(ddlSZQYFind);
			v02058.setPageIndex(1);
			v02058.setPageSize(-1);
			v02058.setCd02050Xqdm(txtXQFind);
			v02058.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02058.setIstrue(0);
			v02058.setCd00002Czr(sessionCtrl.getUserId());
			v02058.setCd00001Fwlx(txtFWLX);
			v02058.setSfsc(ConvertUtil.toInteger(SFSC));
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02058Service.ExportJYSJA(v02058);		
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02058A() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02058A() ********** end **********");
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
			Pgv02058List = Excel.importDataJYSJASY(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX),ConvertUtil.toInteger(SFSC));
			if(!checkJYSJA(Pgv02058List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv02058List.size() == 0){
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
	
	private boolean checkJYSJA(ArrayList<Pgv02058> Pgv02058List)throws Exception{
		return true;
	}
	
	/**
	 * 文件导入
	 */
	public String importFileA()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("importFileA() ********** start **********");
		}
		try{
			Pgv02058 iResult = t02058Service.ImportFileDataA(Pgv02058List);
			if(iResult.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
				
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataJYRQXZASY(iResult.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的交易日期数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	
	
/*********************** set and get ******************************/
	
	/**
	 * @return the t02058Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02058Service getT02058Service() {
		return t02058Service;
	}

	/**
	 * @param t02058Service the t02058Service to set
	 */
	public void setT02058Service(IPgt02058Service t02058Service) {
		this.t02058Service = t02058Service;
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
	 * @return the wjzsList
	 */
	public ArrayList<Pgv02058> getwjzsList() {
		return wjzsList;
	}

	/**
	 * @param wjzsList the wjzsList to set
	 */
	public void setwjzsList(ArrayList<Pgv02058> wjzsList) {
		this.wjzsList = wjzsList;
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
	 * @return the t02058Bean
	 */
	public Pgt02058 getT02058Bean() {
		return t02058Bean;
	}

	/**
	 * @param t02058Bean the t02058Bean to set
	 */
	public void setT02058Bean(Pgt02058 t02058Bean) {
		this.t02058Bean = t02058Bean;
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
	 * @return the wjzsList
	 */
	public ArrayList<Pgv02058> getWjzsList() {
		return wjzsList;
	}

	/**
	 * @param wjzsList the wjzsList to set
	 */
	public void setWjzsList(ArrayList<Pgv02058> wjzsList) {
		this.wjzsList = wjzsList;
	}

	/**
	 * @return the pSSDYM
	 */
	public String getPSSDYM() {
		return PSSDYM;
	}

	/**
	 * @param pSSDYM the pSSDYM to set
	 */
	public void setPSSDYM(String pSSDYM) {
		PSSDYM = pSSDYM;
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
	
	public String getTxtFORMULA() {
		return txtFORMULA;
	}

	public void setTxtFORMULA(String txtFORMULA) {
		this.txtFORMULA = txtFORMULA;
	}

	public String getTxtPSSD() {
		return txtPSSD;
	}

	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}

	public String getTxtSZQY() {
		return txtSZQY;
	}

	public void setTxtSZQY(String txtSZQY) {
		this.txtSZQY = txtSZQY;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
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

	public String getTxtFilePath() {
		return txtFilePath;
	}

	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}

	

	public ArrayList<Pgv02058> getPgv02058List() {
		return Pgv02058List;
	}

	public void setPgv02058List(ArrayList<Pgv02058> pgv02058List) {
		Pgv02058List = pgv02058List;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<Pgv02058> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Pgv02058> rows) {
		this.rows = rows;
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

	public Boolean getIsOK() {
		return isOK;
	}

	public void setIsOK(Boolean isOK) {
		this.isOK = isOK;
	}

	public String getTxtXQDM() {
		return txtXQDM;
	}

	public void setTxtXQDM(String txtXQDM) {
		this.txtXQDM = txtXQDM;
	}
    
	public String getXQDM() {
		return XQDM;
	}

	public void setXQDM(String xQDM) {
		XQDM = xQDM;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public String getTxtJZMJMIN() {
		return txtJZMJMIN;
	}

	public void setTxtJZMJMIN(String txtJZMJMIN) {
		this.txtJZMJMIN = txtJZMJMIN;
	}

	public String getTxtJZMJMAX() {
		return txtJZMJMAX;
	}

	public void setTxtJZMJMAX(String txtJZMJMAX) {
		this.txtJZMJMAX = txtJZMJMAX;
	}

	/**
	 * @return the txtQZ1
	 */
	public String getTxtQZ1() {
		return txtQZ1;
	}

	/**
	 * @param txtQZ1 the txtQZ1 to set
	 */
	public void setTxtQZ1(String txtQZ1) {
		this.txtQZ1 = txtQZ1;
	}

	/**
	 * @return the txtQZ2
	 */
	public String getTxtQZ2() {
		return txtQZ2;
	}

	/**
	 * @param txtQZ2 the txtQZ2 to set
	 */
	public void setTxtQZ2(String txtQZ2) {
		this.txtQZ2 = txtQZ2;
	}

	/**
	 * @return the txtQZ3
	 */
	public String getTxtQZ3() {
		return txtQZ3;
	}

	/**
	 * @param txtQZ3 the txtQZ3 to set
	 */
	public void setTxtQZ3(String txtQZ3) {
		this.txtQZ3 = txtQZ3;
	}

	public String getDdlSzqy() {
		return ddlSzqy;
	}

	public void setDdlSzqy(String ddlSzqy) {
		this.ddlSzqy = ddlSzqy;
	}

	public String getDdlPssd() {
		return ddlPssd;
	}

	public void setDdlPssd(String ddlPssd) {
		this.ddlPssd = ddlPssd;
	}


	public Pgv02058 getDdlV02058Bean() {
		return ddlV02058Bean;
	}

	public void setDdlV02058Bean(Pgv02058 ddlV02058Bean) {
		this.ddlV02058Bean = ddlV02058Bean;
	}

	public String getDdlXqdm() {
		return ddlXqdm;
	}

	public void setDdlXqdm(String ddlXqdm) {
		this.ddlXqdm = ddlXqdm;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession=arg0;
	}

	public String getSFSC() {
		return SFSC;
	}

	public void setSFSC(String sFSC) {
		SFSC = sFSC;
	}

	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	public String getTxtFWLX() {
		return txtFWLX;
	}

	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}

	public Integer getJSLX() {
		return JSLX;
	}

	public void setJSLX(Integer jSLX) {
		JSLX = jSLX;
	}

	public Integer getDdlJslx() {
		return ddlJslx;
	}

	public void setDdlJslx(Integer ddlJslx) {
		this.ddlJslx = ddlJslx;
	}

	public String getTxtID() {
		return txtID;
	}

	public void setTxtID(String txtID) {
		this.txtID = txtID;
	}
	
	
}
