package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02063Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02063;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02063;


/**
 * 纳税指导系数维护
 * @author LeeChuang
 *
 */
public class Pgt02063Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -3568329670065984790L;
	private IPgt02063Service t02063Service;
	private SessionCtrl sessionCtrl=new SessionCtrl();
	
	
	//页面所需的BEAN
	private Pgt02063 t02063Bean;
	private ArrayList<Pgv02063> rows;
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv02063> Pgv02063List;
	
	//表单提交数据
	private String txtSCQZB;
	private String txtSYQZB;
	private String txtUPDATE;
	private String userRole;
	private String ddlSZQY;
	private String txtFWLX;
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
	private ArrayList<Pgt02063> Pgt02063List;
	private ArrayList<Pgv02063> ebList;
	//查询条件
	private Integer pageIndex;
	private Integer pageSize;
	private ArrayList<Pgv02063> v02063List;
	private Integer total;
    private String ddlSZQYFind;
	private String ACT;
	private Boolean isExists;
	private InputStream excelStream;
	private String fileName;
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
	 * 文件上传
	 */
	public String upload() throws Exception {
		
		try{
			String fileName = sessionCtrl.getUserId() + "_SYQZB" + getUploadFileName().substring(getUploadFileName().lastIndexOf("."));
			//fileServerPath = getSavePath() + "\\" + getUploadFileName();
			fileServerPath = getSavePath() + fileName;
			//将上传文件路径装入SESSION
			Common.addUploadFiles(fileServerPath);
			FileUtil.copyFile(fileServerPath, getUpload());
			
		}catch(Exception ex){
			ex.printStackTrace();
			
			return INPUT;
		}
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
			Pgv02063List = Excel.importDataQzbSY(txtFilePath, sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkQzbdj(Pgv02063List))
				this.addActionError("非住宅评估法权重比修正数据不符合导入要求！");
			if(Pgv02063List.size()==0)
				this.addActionError("检查发现没有数据可以导入！");
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
			Pgv02063 iResult = t02063Service.ImportExcelData(Pgv02063List);
			if(iResult.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
				
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportSYQzbCommonDataSY(iResult.getOutList(),1);
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的非住宅评估法权重比修正数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	/**
	 * 分区资本化率系数修正信息导出
	 */
	public String exportT02063() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02063() ********** start **********");
		}
		
		Pgv02063 v02063 = new Pgv02063();
		try {
			//准备查询条件
			v02063.setPageIndex(1);
			v02063.setPageSize(-1);
			v02063.setCd00001Szqy(ddlSZQYFind);
			v02063.setCd00001Fwlx(txtFWLX);
			v02063.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));	
			v02063.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t02063Service.ExportQzb(v02063);		
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT02063() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT02063() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}

	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	 
	public String query()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** start **********");
		}
		
		Pgv02063 v02063 = new Pgv02063();
		
		try{
			v02063.setPageIndex(pageIndex);
			v02063.setPageSize(getPageSize());
			v02063.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02063.setCd00001Szqy(ddlSZQYFind);
			rows = t02063Service.LoadAll(v02063);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
			}else{
				total = 0;
				pageIndex = 1;
			}
		}catch(Exception e){
			 e.printStackTrace();
			this.addActionError(e.getMessage());
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
		Pgt02063 t02063 = new Pgt02063();
		
		try{
			if(!Constant.MOD_CREATE.equals(getACT())){
				t02063.setCd00001Szqy(ddlSZQY);
				t02063.setCd00001Fwlx(txtFWLX);
				t02063Bean = t02063Service.LoadByPrimaryKey(t02063);
			}
				
				ReadInfo();
		}catch(Exception e){
			e.printStackTrace();
			this.addActionError(e.getMessage());
			
			if(LOG.isDebugEnabled()){
				LOG.debug("create() ********** end **********");
			}
			
			return ERROR;
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		if(LOG.isDebugEnabled()){
			LOG.debug("create() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	
	/**
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdate()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUpdate() ********** start **********");
		}
		t02063Bean = new Pgt02063();		
		t02063Bean.setCd00001Szqy(ddlSZQY);
		t02063Bean.setCd00001Fwlx(txtFWLX);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02063Bean = t02063Service.LoadByPrimaryKey(t02063Bean);		
		}
		
		this.clearErrorsAndMessages();
		ReadInfo();

		//判断数据是否被其他人修改
		if((Constant.MOD_UPDATE.equals(getACT())) && (!t02063Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))){
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			t02063Bean.setScqzb(ConvertUtil.toDouble(txtSCQZB));
			t02063Bean.setSyqzb(ConvertUtil.toDouble(txtSYQZB));
			t02063Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02063Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		
		}

	/*	//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())&& (!t02063Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))){
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			t02063Bean.setCd00001Szqy(ConvertUtil.encoding(ddlSZQY));
			t02063Bean.setCd00001Fwlx(ConvertUtil.encoding(txtFWLX));
			t02063Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02063Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}*/
		
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUpdate() ********** end **********");
		}
		
	}
	
	
	
	
	/**
	 * 更新信息处理
	 * @return 
	 * @throws Exception
	 */
	public String update()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("update() ********** start **********");
		}
		String rtn = "success";
		try{
			if(Constant.MOD_CREATE.equals(getACT())){
				if(t02063Service.GetInsertCommand(getT02063Bean())){
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t02063.title")}));
				}else{
					this.addActionMessage(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t02063.title")}));
				}
			}else if(Constant.MOD_UPDATE.equals(getACT())){
				if(t02063Service.GetUpdateCommand(getT02063Bean())){
					t02063Bean = t02063Service.LoadByPrimaryKey(t02063Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t02063.title")}));
				}else{
					this.addActionMessage(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t02063.title")}));
				}
			}else if(Constant.MOD_DELETE.equals(getACT())){
				if(t02063Service.GetDeleteCommand(getT02063Bean())){
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getText("app.xtwh.t02063.title")}));
				}else{
					this.addActionMessage(getText(Constant.MSG_DELETE_NG, new String[]{getText("app.xtwh.t02063.title")}));
				}
				rtn = "successDEL";
			}
		}catch(Exception e){
			e.printStackTrace();
			String[] msg = e.getMessage().split("\n");
			this.addActionError(msg[0]);

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
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
		
		Pgt02063 t02063 = new Pgt02063();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02063.setCd00001Szqy(ddlSZQY);
				t02063.setCd00001Fwlx(txtFWLX);
				t02063Bean = t02063Service.LoadByPrimaryKey(t02063);
				isExists = t02063Bean.getUpddate() == null?true:false;
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
	private Boolean checkQzbdj(ArrayList<Pgv02063> Pgv02063List){
		
		return true;
	}
	/*********************** set and get ******************************/
	@JSON(deserialize=false, serialize=false)
	public IPgt02063Service getT02063Service() {
		return t02063Service;
	}

	public void setT02063Service(IPgt02063Service t02063Service) {
		this.t02063Service = t02063Service;
	}

	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	public Pgt02063 getT02063Bean() {
		return t02063Bean;
	}

	public void setT02063Bean(Pgt02063 t02063Bean) {
		this.t02063Bean = t02063Bean;
	}

	public ArrayList<Pgv02063> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Pgv02063> rows) {
		this.rows = rows;
	}

	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	public ArrayList<Pgv02063> getPgv02063List() {
		return Pgv02063List;
	}

	public void setPgv02063List(ArrayList<Pgv02063> pgv02063List) {
		Pgv02063List = pgv02063List;
	}

	public String getTxtSCQZB() {
		return txtSCQZB;
	}

	public void setTxtSCQZB(String txtSCQZB) {
		this.txtSCQZB = txtSCQZB;
	}

	public String getTxtSYQZB() {
		return txtSYQZB;
	}

	public void setTxtSYQZB(String txtSYQZB) {
		this.txtSYQZB = txtSYQZB;
	}

	public String getTxtUPDATE() {
		return txtUPDATE;
	}

	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getDdlSZQY() {
		return ddlSZQY;
	}

	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}

	public String getTxtFWLX() {
		return txtFWLX;
	}

	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getDdlImportLx() {
		return ddlImportLx;
	}

	public void setDdlImportLx(String ddlImportLx) {
		this.ddlImportLx = ddlImportLx;
	}

	public String getFileServerPath() {
		return fileServerPath;
	}

	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
	}

	public String getTxtFilePath() {
		return txtFilePath;
	}

	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}

	public ArrayList<Pgt02063> getPgt02063List() {
		return Pgt02063List;
	}

	public void setPgt02063List(ArrayList<Pgt02063> pgt02063List) {
		Pgt02063List = pgt02063List;
	}

	public ArrayList<Pgv02063> getEbList() {
		return ebList;
	}

	public void setEbList(ArrayList<Pgv02063> ebList) {
		this.ebList = ebList;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public ArrayList<Pgv02063> getV02063List() {
		return v02063List;
	}

	public void setV02063List(ArrayList<Pgv02063> v02063List) {
		this.v02063List = v02063List;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getDdlSZQYFind() {
		return ddlSZQYFind;
	}

	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
	}

	public String getACT() {
		return ACT;
	}

	public void setACT(String aCT) {
		ACT = aCT;
	}

	public Boolean getIsExists() {
		return isExists;
	}

	public void setIsExists(Boolean isExists) {
		this.isExists = isExists;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession=arg0;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	

}
