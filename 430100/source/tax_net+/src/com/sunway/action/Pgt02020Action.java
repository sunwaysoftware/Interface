package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02020Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02020;

/**
 * 全面评估市场法国土信息
 * @author Light
 *
 */
public class Pgt02020Action extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -8890413745089540943L;

	private IPgt02020Service t02020Service;
	
	//页面所需列表
	private ArrayList<Pgv02020> rows;
	private ArrayList<Pgv00052> szqyList;
	// 自动完成
	private ArrayList<String> dataList;
	private Pgv02020 bean;
	//session
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//操作符
	private String ACT;
	//查询条件
	private String ddlSZQYFind;
	private String txtXQFind;
	private String txtJYSJFind;
	private String rdoPGJG;
	private String txtZCDZLFind;
	private String txtSSGX;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	
	//file upload
	private String fileServerPath;
	private File upload;
	private String uploadFileName;
	private String savePath;
	private InputStream excelStream;
	private String exportCountStart;
	private String exportCountEnd;
	
	//file import
	private String txtFilePath;
	private String fileName;
	
	//pg
	private String hidFlag;
	private String[] chkSel;
	private Integer processCent;	
	private String processMsg;
	private String txtPSSD;
	
	//获取估价值参数
	private String txtXQDMFind;
	private String txtZHFind;
	private String txtDYFind;
	private String txtBWJFHFind;
	private String txtFWLXFind;
	//detail
	private Pgv02020 v02020Bean;
	private String FCID;
	
	//printTZD
	private String txtFCZH;
	private String txtSWID;
	private String txtNSRMC;
	private String txtCSFSWID;
	private String txtCSFNSRMC;
	private String txtZJLX;
	private String txtCSFZJLX;
	private String txtLXDH;
	private String txtJYSJ;
	private String txtDJRQ;
	private String txtFCID;
	private String txtJYLX;
	private String txtNOTE;
	private String txtJYJG;
	private String resMsg;
	private String resSign;
	private String zcdzl;
	private String txtLH;
	private String txtDYH;
	private String txtFH;
	
	//pgCWXX
	private String txtSWIDFind;
	
	//edit
	private String SysDate;
	private String txtCLH;
	private String txtZCDZL;
	private String txtJZMJ;
	private String txtHDJG;
	private String txtXQDM;
	private String txtZLC;
	private String txtSZLC;
	private String txtJZJG;
	private String txtGHYT;
	private String txtZH;
	private String txtJCNF;
	private String txtZJHM;
	private String hidZHXZid;
	private String txtUPDATE;
	private String txtXQTIP;
	//queryZhxz
	private String txtFWLX;
	private String ddlSZQY;
	
	//delSel
	private String chkDel;
	private String msgDel;
    private boolean isExistZT; 
	//标识全面评估查询与地址重复
	private String TSIGN;
	@Override
	public String execute() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		txtSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
		ReadInfo();
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** end **********");
		}		
		return SUCCESS;
	}
	
	
	/**
	 * 查询，读取数据
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** start **********");
		}
		
		Pgv02020 v02020 = new Pgv02020();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v02020.setPageIndex(pageIndex);
			v02020.setPageSize(getPageSize());
			v02020.setCd00001Szqy(ddlSZQYFind);
			v02020.setXqnm(FormatUtil.toSearchLike(txtXQTIP));
			v02020.setJysj(ConvertUtil.toUtilDate(txtJYSJFind));
			v02020.setZcdzl(FormatUtil.toSearchLike(txtZCDZLFind));
			v02020.setZh(FormatUtil.toSearchLike(txtZHFind));
			v02020.setDyh(FormatUtil.toSearchLike(txtDYFind));
			v02020.setClh(CheckUtil.chkTrim(txtCLH));
			v02020.setBwjfh(FormatUtil.toSearchLike(txtBWJFHFind));
			v02020.setCd00001Fwlx(txtFWLXFind);
			if(null != txtSSGX && !"".equals(txtSSGX)){
				v02020.setCd00001Ssgx(txtSSGX);
			}else{
				v02020.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
			rows = t02020Service.LoadAll(v02020);
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = rows.get(0).getRecordCount();
			} else {
				pageIndex = 1;
				total = 0;
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("query() ********** end **********");
			}
			return ERROR;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 查询，读取数据
	 * @return
	 * @throws Exception
	 */
	public String query1() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** start **********");
		}
		
		Pgv02020 v02020 = new Pgv02020();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v02020.setPageIndex(pageIndex);
			v02020.setPageSize(getPageSize());
			v02020.setCd00001Szqy(ddlSZQYFind);
			v02020.setXqnm(FormatUtil.toSearchLike(txtXQTIP));
			v02020.setJysj(ConvertUtil.toUtilDate(txtJYSJFind));
			v02020.setZcdzl(CheckUtil.chkTrim(txtZCDZLFind));
			v02020.setZh(FormatUtil.toSearchLike(txtZHFind));
			v02020.setDyh(FormatUtil.toSearchLike(txtDYFind));
			v02020.setClh(CheckUtil.chkTrim(txtCLH));
			v02020.setBwjfh(FormatUtil.toSearchLike(txtBWJFHFind));
			if(null != txtSSGX && !"".equals(txtSSGX)){
				v02020.setCd00001Ssgx(txtSSGX);
			}else{
				v02020.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
			rows = t02020Service.LoadAll1(v02020);
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = rows.get(0).getRecordCount();
			} else {
				pageIndex = 1;
				total = 0;
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("query() ********** end **********");
			}
			return ERROR;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("create() ********** start **********");
		}
		
		try{
			ReadInfo();
			if(!Constant.MOD_CREATE.equals(getACT())){
				Pgv02020 v02020 = new Pgv02020();
				v02020.setFcid(FCID);
				bean = t02020Service.LoadByPrimaryKey(v02020);
				//为303赋值				
			}else{
				SysDate = MakeUtil.currentDate();
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		}finally{
			//
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("create() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 更新前验证
	 * @throws Exception
	 */
	public void validateUpdate()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUpdate() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			ReadInfo();
			bean = new Pgv02020();
			bean.setFcid(FCID);
			//根据PK为BEAN赋值
			if(Constant.MOD_UPDATE.equals(getACT())){
				bean = t02020Service.LoadByPrimaryKey(bean);
			}
			//判断数据是否已被其他用户修改
			if ((Constant.MOD_UPDATE.equals(getACT()))&& (!bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
				this.addActionError(getText("app.msg.error.pktime"));
			} else {
				bean.setFcid(FCID);
				bean.setFczh(txtFCZH);				
				bean.setZcdzl(txtZCDZL);
				bean.setJzmj(ConvertUtil.toDouble(txtJZMJ));				
				bean.setCd00001Fwlx(txtFWLX);
				bean.setCd00001Jzjg(txtJZJG);				
				bean.setZh(txtZH);
				bean.setDyh(txtDYH);				
				bean.setJcnf(txtJCNF);				
				bean.setZhxzId(hidZHXZid);
				bean.setNote(txtNOTE);				
				bean.setCd00002Czr(sessionCtrl.getUserId());
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
		}finally{
			//
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUpdate() ********** end **********");
		}
		
	}
	
	/**
	 * 更新操作
	 * @return
	 * @throws Exception
	 */
	public String update()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("update() ********** start **********");
		}
		String result = "success";
		try{
			
			if(Constant.MOD_UPDATE.equals(getACT())){
				if(t02020Service.GetUpdateCommand(bean)){
					//为303赋值					
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { bean.getFczh() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { bean.getFczh() }));
				}
			}else if(Constant.MOD_DELETE.equals(getACT())){
				if(t02020Service.GetDeleteCommand(bean)){
					this.addActionMessage(getText(Constant.MSG_DELETE_OK));
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG));
				}
				if("320".equals(TSIGN)){
					result = "successDEL320";
				}else if("3201".equals(TSIGN)){
					result = "successDEL3201";
				}
				
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
		}finally{
			//
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("update() ********** end **********");
		}
		return result;
	}
	
	
	
	/**
	 * 文件上传
	 */
	public String upload()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** start **********");
		}
		FileInputStream fis = null;
		FileOutputStream fos = null;
		Random random = new Random();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			String fileName = "QMPGLR" + String.valueOf(random.nextInt()) + sessionCtrl.getUserId() + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
//			fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + "\\" + fileName;
			//将上传文件路径装入SESSION
			//Common.addUploadFiles(fileServerPath);
			fis = new FileInputStream(getUpload());
			fos = new FileOutputStream(fileServerPath);
			
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer)) > 0){
				fos.write(buffer,0,len);
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("upload() ********** end **********");
			}
			return INPUT;
		} finally {
			if(null!=fis)
				fis.close();
			if(null!=fos)
				fos.close();
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("upload() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 文件导入前的验证
	 */
	public void validateImportFile()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** start **********");
		}
		
		if(!FileUtil.checkFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查");
		}
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			ReadInfo();
			rows = Excel.importDataQMPGLRSY(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkQMPGLR(rows)){
				this.addActionError("数据不符合导入要求");
			}
			if(rows.size() == 0){
				this.addActionError("数据不符合导入要求");
			}
			
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError("数据格式不符合导入要求：" + e.getMessage());
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** end **********");
		}
	}
	
	private boolean checkQMPGLR(ArrayList<Pgv02020> v02020List)throws Exception{
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
			Pgv02020 result = t02020Service.ImportExcelData(rows);
			if(result.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataQMPGLRSY(result.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的全面评估录入数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
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
	
	
	
	/**
	 * 市场法国土详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv02020 v02020 = new Pgv02020();
		v02020Bean = new Pgv02020();
		try {
			// 准备查询条件
			v02020.setFcid(CheckUtil.chkTrim(FCID));
			// 执行查询
			v02020Bean = t02020Service.LoadByPrimaryKey(v02020);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			LOG.error(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}	
		
	/**
	 * 自动完成座落地址
	 * @return
	 * @throws Exception
	 */
	public String queryFwtdzldat() throws Exception {
		Pgv02020 v02020 = new Pgv02020();
		try {
			// 准备查询条件
			v02020.setSzqy(ddlSZQY);
			v02020.setZcdzl(FormatUtil.toSearchLike(txtZCDZL));
			v02020.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			dataList = t02020Service.GetFwtdzl(v02020);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 选择删除
	 * @return
	 * @throws Exception
	 */
	public String delSel()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		
		try{
			this.clearErrorsAndMessages();
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			Pgv02020 v02020 = new Pgv02020();
			v02020.setChkDel(chkDel);
			v02020.setCd00002Czr(sessionCtrl.getUserId());
			v02020.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t02020Service.GetSelDeleteCommand(v02020)){
				msgDel = "删除成功";
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			msgDel = "删除失败：" + e.getMessage();
			if(LOG.isDebugEnabled()){
				LOG.debug("delSel() ********** end **********");
			}
			return SUCCESS;
		}finally{
			//
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 数据导出
	 * @return
	 * @throws Exception
	 */
	public String export()throws Exception
	{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02020() ********** start **********");
		}
		this.clearErrorsAndMessages();
		Pgv02020 v02020 = new Pgv02020();
		try{
			Double dataS = ConvertUtil.toDouble(exportCountStart);
			Double dataE = ConvertUtil.toDouble(exportCountEnd);
			// 准备查询条件
			//v02002.setPageIndex(dataE/(dataE - dataS +1));
			//v02002.setPageSize(dataE - dataS + 1);
			v02020.setExportS(dataE/(dataE - dataS +1));
			v02020.setExportE(dataE - dataS + 1);
			v02020.setPageIndex(1);
			v02020.setPageSize(-1);
			v02020.setCd00001Szqy(ddlSZQYFind);
			v02020.setXqnm(FormatUtil.toSearchLike(txtXQTIP));
			v02020.setJysj(ConvertUtil.toUtilDate(txtJYSJFind));
			v02020.setZcdzl(FormatUtil.toSearchLike(txtZCDZLFind));
			v02020.setZh(FormatUtil.toSearchLike(txtZHFind));
			v02020.setDyh(FormatUtil.toSearchLike(txtDYFind));
			v02020.setClh(CheckUtil.chkTrim(txtCLH));
			v02020.setBwjfh(FormatUtil.toSearchLike(txtBWJFHFind));
			v02020.setCd00001Fwlx(txtFWLXFind);
			if(null != txtSSGX && !"".equals(txtSSGX)){
				v02020.setCd00001Ssgx(txtSSGX);
			}else{
				v02020.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
			v02020.setExpFileName("exp_t02020.xls");
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02020Service.ExportData(v02020);
			excelStream = new ByteArrayInputStream(out.toByteArray());
		}catch(Exception e){
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02020() ********** end **********");
			}
			 e.printStackTrace();
			this.addActionError(ConvertUtil.actErrMsg(e.getMessage()));
			return ERROR;
		}finally{
			//
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02020() ********** end **********");
		}
		return SUCCESS;
	}

	/***********************   set  &&  get   ***************************/
	@JSON(deserialize = false, serialize = false)
	public IPgt02020Service getT02020Service() {
		return t02020Service;
	}


	public void setT02020Service(IPgt02020Service t02020Service) {
		this.t02020Service = t02020Service;
	}


	public ArrayList<Pgv02020> getRows() {
		return rows;
	}


	public void setRows(ArrayList<Pgv02020> rows) {
		this.rows = rows;
	}


	public Integer getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public String getFileServerPath() {
		return fileServerPath;
	}


	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
	}


	public File getUpload() {
		return upload;
	}


	public void setUpload(File upload) {
		this.upload = upload;
	}


	public String getUploadFileName() {
		return uploadFileName;
	}


	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}


	public void setSavePath(String savePath) {
		this.savePath = savePath;
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


	public InputStream getExcelStream() {
		return excelStream;
	}


	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}


	public String getHidFlag() {
		return hidFlag;
	}


	public void setHidFlag(String hidFlag) {
		this.hidFlag = hidFlag;
	}


	public String[] getChkSel() {
		return chkSel;
	}


	public void setChkSel(String[] chkSel) {
		this.chkSel = chkSel;
	}


	public Integer getProcessCent() {
		return processCent;
	}


	public void setProcessCent(Integer processCent) {
		this.processCent = processCent;
	}


	public String getProcessMsg() {
		return processMsg;
	}


	public void setProcessMsg(String processMsg) {
		this.processMsg = processMsg;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}


	public String getTxtXQDMFind() {
		return txtXQDMFind;
	}


	public void setTxtXQDMFind(String txtXQDMFind) {
		this.txtXQDMFind = txtXQDMFind;
	}


	public String getTxtZHFind() {
		return txtZHFind;
	}


	public void setTxtZHFind(String txtZHFind) {
		this.txtZHFind = txtZHFind;
	}


	public String getTxtDYFind() {
		return txtDYFind;
	}


	public void setTxtDYFind(String txtDYFind) {
		this.txtDYFind = txtDYFind;
	}


	public String getTxtBWJFHFind() {
		return txtBWJFHFind;
	}


	public void setTxtBWJFHFind(String txtBWJFHFind) {
		this.txtBWJFHFind = txtBWJFHFind;
	}

	public String getDdlSZQYFind() {
		return ddlSZQYFind;
	}


	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
	}


	public String getTxtXQFind() {
		return txtXQFind;
	}


	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}


	public String getTxtSSGX() {
		return txtSSGX;
	}


	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}


	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}


	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}


	public String getTxtPSSD() {
		return txtPSSD;
	}


	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}


	public Pgv02020 getV02020Bean() {
		return v02020Bean;
	}


	public void setV02020Bean(Pgv02020 v02020Bean) {
		this.v02020Bean = v02020Bean;
	}


	public String getFCID() {
		return FCID;
	}


	public void setFCID(String fCID) {
		FCID = fCID;
	}


	public String getTxtFCZH() {
		return txtFCZH;
	}


	public void setTxtFCZH(String txtFCZH) {
		this.txtFCZH = txtFCZH;
	}


	public String getTxtSWID() {
		return txtSWID;
	}


	public void setTxtSWID(String txtSWID) {
		this.txtSWID = txtSWID;
	}


	public String getTxtNSRMC() {
		return txtNSRMC;
	}


	public void setTxtNSRMC(String txtNSRMC) {
		this.txtNSRMC = txtNSRMC;
	}


	public String getTxtCSFSWID() {
		return txtCSFSWID;
	}


	public void setTxtCSFSWID(String txtCSFSWID) {
		this.txtCSFSWID = txtCSFSWID;
	}


	public String getTxtCSFNSRMC() {
		return txtCSFNSRMC;
	}


	public void setTxtCSFNSRMC(String txtCSFNSRMC) {
		this.txtCSFNSRMC = txtCSFNSRMC;
	}


	public String getTxtZJLX() {
		return txtZJLX;
	}


	public void setTxtZJLX(String txtZJLX) {
		this.txtZJLX = txtZJLX;
	}


	public String getTxtCSFZJLX() {
		return txtCSFZJLX;
	}


	public void setTxtCSFZJLX(String txtCSFZJLX) {
		this.txtCSFZJLX = txtCSFZJLX;
	}


	public String getTxtLXDH() {
		return txtLXDH;
	}


	public void setTxtLXDH(String txtLXDH) {
		this.txtLXDH = txtLXDH;
	}


	public String getTxtJYSJ() {
		return txtJYSJ;
	}


	public void setTxtJYSJ(String txtJYSJ) {
		this.txtJYSJ = txtJYSJ;
	}


	public String getTxtDJRQ() {
		return txtDJRQ;
	}


	public void setTxtDJRQ(String txtDJRQ) {
		this.txtDJRQ = txtDJRQ;
	}


	public String getResMsg() {
		return resMsg;
	}


	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}


	public String getResSign() {
		return resSign;
	}


	public void setResSign(String resSign) {
		this.resSign = resSign;
	}


	public String getTxtFCID() {
		return txtFCID;
	}


	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}


	public String getTxtJYLX() {
		return txtJYLX;
	}


	public void setTxtJYLX(String txtJYLX) {
		this.txtJYLX = txtJYLX;
	}


	public String getTxtNOTE() {
		return txtNOTE;
	}


	public void setTxtNOTE(String txtNOTE) {
		this.txtNOTE = txtNOTE;
	}


	public String getTxtJYJG() {
		return txtJYJG;
	}


	public void setTxtJYJG(String txtJYJG) {
		this.txtJYJG = txtJYJG;
	}


	/**
	 * @return the zcdzl
	 */
	public String getZcdzl() {
		return zcdzl;
	}


	/**
	 * @param zcdzl the zcdzl to set
	 */
	public void setZcdzl(String zcdzl) {
		this.zcdzl = zcdzl;
	}


	/**
	 * @return the txtLH
	 */
	public String getTxtLH() {
		return txtLH;
	}


	/**
	 * @param txtLH the txtLH to set
	 */
	public void setTxtLH(String txtLH) {
		this.txtLH = txtLH;
	}


	/**
	 * @return the txtDYH
	 */
	public String getTxtDYH() {
		return txtDYH;
	}


	/**
	 * @param txtDYH the txtDYH to set
	 */
	public void setTxtDYH(String txtDYH) {
		this.txtDYH = txtDYH;
	}


	/**
	 * @return the txtFH
	 */
	public String getTxtFH() {
		return txtFH;
	}


	/**
	 * @param txtFH the txtFH to set
	 */
	public void setTxtFH(String txtFH) {
		this.txtFH = txtFH;
	}




	public String getTxtJYSJFind() {
		return txtJYSJFind;
	}


	public void setTxtJYSJFind(String txtJYSJFind) {
		this.txtJYSJFind = txtJYSJFind;
	}


	public String getRdoPGJG() {
		return rdoPGJG;
	}


	public void setRdoPGJG(String rdoPGJG) {
		this.rdoPGJG = rdoPGJG;
	}


	public String getTxtSWIDFind() {
		return txtSWIDFind;
	}


	public void setTxtSWIDFind(String txtSWIDFind) {
		this.txtSWIDFind = txtSWIDFind;
	}


	public String getACT() {
		return ACT;
	}


	public void setACT(String aCT) {
		ACT = aCT;
	}

	public String getSysDate() {
		return SysDate;
	}


	public void setSysDate(String sysDate) {
		SysDate = sysDate;
	}

	public String getTxtZCDZLFind() {
		return txtZCDZLFind;
	}


	public void setTxtZCDZLFind(String txtZCDZLFind) {
		this.txtZCDZLFind = txtZCDZLFind;
	}


	public String getTxtFWLX() {
		return txtFWLX;
	}


	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}


	public String getDdlSZQY() {
		return ddlSZQY;
	}


	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}


	public String getTxtCLH() {
		return txtCLH;
	}


	public void setTxtCLH(String txtCLH) {
		this.txtCLH = txtCLH;
	}


	public String getTxtZCDZL() {
		return txtZCDZL;
	}


	public void setTxtZCDZL(String txtZCDZL) {
		this.txtZCDZL = txtZCDZL;
	}


	public String getTxtJZMJ() {
		return txtJZMJ;
	}


	public void setTxtJZMJ(String txtJZMJ) {
		this.txtJZMJ = txtJZMJ;
	}


	public String getTxtHDJG() {
		return txtHDJG;
	}


	public void setTxtHDJG(String txtHDJG) {
		this.txtHDJG = txtHDJG;
	}


	public String getTxtXQDM() {
		return txtXQDM;
	}


	public void setTxtXQDM(String txtXQDM) {
		this.txtXQDM = txtXQDM;
	}


	public String getTxtZLC() {
		return txtZLC;
	}


	public void setTxtZLC(String txtZLC) {
		this.txtZLC = txtZLC;
	}


	public String getTxtSZLC() {
		return txtSZLC;
	}


	public void setTxtSZLC(String txtSZLC) {
		this.txtSZLC = txtSZLC;
	}


	public String getTxtJZJG() {
		return txtJZJG;
	}


	public void setTxtJZJG(String txtJZJG) {
		this.txtJZJG = txtJZJG;
	}


	public String getTxtGHYT() {
		return txtGHYT;
	}


	public void setTxtGHYT(String txtGHYT) {
		this.txtGHYT = txtGHYT;
	}


	public String getTxtZH() {
		return txtZH;
	}


	public void setTxtZH(String txtZH) {
		this.txtZH = txtZH;
	}


	public String getTxtJCNF() {
		return txtJCNF;
	}


	public void setTxtJCNF(String txtJCNF) {
		this.txtJCNF = txtJCNF;
	}


	public String getTxtZJHM() {
		return txtZJHM;
	}


	public void setTxtZJHM(String txtZJHM) {
		this.txtZJHM = txtZJHM;
	}


	public String getHidZHXZid() {
		return hidZHXZid;
	}


	public void setHidZHXZid(String hidZHXZid) {
		this.hidZHXZid = hidZHXZid;
	}


	public String getTxtUPDATE() {
		return txtUPDATE;
	}


	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
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


	public String getTSIGN() {
		return TSIGN;
	}


	public void setTSIGN(String tSIGN) {
		TSIGN = tSIGN;
	}


	/**
	 * @return the isExistZT
	 */
	public boolean isExistZT() {
		return isExistZT;
	}


	/**
	 * @param isExistZT the isExistZT to set
	 */
	public void setExistZT(boolean isExistZT) {
		this.isExistZT = isExistZT;
	}


	/**
	 * @return the txtXQTIP
	 */
	public String getTxtXQTIP() {
		return txtXQTIP;
	}


	/**
	 * @param txtXQTIP the txtXQTIP to set
	 */
	public void setTxtXQTIP(String txtXQTIP) {
		this.txtXQTIP = txtXQTIP;
	}


	public ArrayList<String> getDataList() {
		return dataList;
	}


	public void setDataList(ArrayList<String> dataList) {
		this.dataList = dataList;
	}


	public String getTxtFWLXFind() {
		return txtFWLXFind;
	}


	public void setTxtFWLXFind(String txtFWLXFind) {
		this.txtFWLXFind = txtFWLXFind;
	}


	public String getExportCountStart() {
		return exportCountStart;
	}


	public void setExportCountStart(String exportCountStart) {
		this.exportCountStart = exportCountStart;
	}


	public String getExportCountEnd() {
		return exportCountEnd;
	}


	public void setExportCountEnd(String exportCountEnd) {
		this.exportCountEnd = exportCountEnd;
	}


	public Pgv02020 getBean() {
		return bean;
	}


	public void setBean(Pgv02020 bean) {
		this.bean = bean;
	}



	
}
