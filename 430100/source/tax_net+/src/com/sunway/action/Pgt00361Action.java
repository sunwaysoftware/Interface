package com.sunway.action;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00361Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00361;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00361;
/**
 * 建筑成新修正系统维护
 * @author HuanWei
 *
 */
public class Pgt00361Action extends ActionSupport implements SessionAware  {

	private static final long serialVersionUID = 3778095980835503276L;

	private IPgt00361Service t00361Service;
	
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	private Integer pageSize;
	private Integer pageIndex;
	private Integer total;

	
	private ArrayList<Pgv00361> rows;
	private ArrayList<Pgv00052> szqyList;
	
	//编辑操作符
	private String ACT;

	//主键
	private String id;
	//表单提交信息
	private Boolean isExists;
	private String txtLSH;
	private String txtSYNXMIN;
	private String txtSYNXMAX;
	private String txtXZXS;
	private String txtUPDATE;
	private String txtNOTE;
	private Integer txtCZLX;
	private String txtPSSD;
	private String txtFWLX;
	private String ddlSZQYFind;
	private String txtFWLXFind;
	private String ddlSZQY;
	private String txtXQDM;
	private String txtXQFind;
	


	


	//页面所需的bean
	private Pgt00361 t00361Bean;
	
	private String userRole;
	private InputStream excelStream;
	
	//file upload
	private String fileServerPath;
	private File upload;
	private String uploadFileName;
	private String savePath;
	
	//file import
	private String txtFilePath;
	private ArrayList<Pgv00361> Pgv00361List;
	private String fileName;
	
	private String chkDel;
	private String msgDel;

	@Override
	public String execute() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** start **********");
		}
		
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		try {
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** end **********");
		}
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
		
		Pgv00361 v00361 = new Pgv00361();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			
			v00361.setPageIndex(pageIndex);
			v00361.setCd_00001_fwlx(ConvertUtil.encoding(CheckUtil.chkTrim(txtFWLX)));
			v00361.setPageSize(getPageSize());
			v00361.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00361.setCd_00001_szqy(ddlSZQYFind);
			rows = t00361Service.LoadAll(v00361);
			
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
			}else{
				total = 0;
				pageIndex = 1;
			}
			
		}catch(Exception e){
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
		Pgt00361 t00361 = new Pgt00361();
		
		try{
			
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				t00361.setId(ConvertUtil.toInteger(id));	
				t00361Bean = t00361Service.LoadByPrimaryKey(t00361);
				if(CheckUtil.chkEmpty(t00361Bean.getUpddate())){
					setACT(Constant.MOD_CREATE);
				}
			}
			ReadInfo();
		}catch(Exception e){
			LOG.error(e.getMessage());
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
	 * 点击单选按钮的AJAX事件
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */

	public String createByAjax()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt00361 t00361 = new Pgt00361();
		try{
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				t00361.setId(ConvertUtil.toInteger(id));
				t00361.setCd_00001_szqy(ddlSZQY);
				t00361.setCd_00001_fwlx(txtFWLX);
				t00361.setSynx_min(ConvertUtil.toInteger(txtSYNXMIN));
				t00361.setSynx_max(ConvertUtil.toInteger(txtSYNXMAX));
				//t00361.setXzxs(ConvertUtil.toDouble(txtXZXS));
				t00361Bean = t00361Service.LoadByPrimaryAddKey(t00361);
				isExists = t00361Bean.getUpddate() == null?true:false;
				
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
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
	public void validateUpdate()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUpdate() ********** start **********");
		}
		
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t00361Bean = new Pgt00361();
		this.clearErrorsAndMessages();
		ReadInfo();
		t00361Bean.setId(ConvertUtil.toInteger(txtLSH));
		t00361Bean.setSynx_min(ConvertUtil.toInteger(txtSYNXMIN));
		t00361Bean.setSynx_max(ConvertUtil.toInteger(txtSYNXMAX));
		t00361Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
		t00361Bean.setNote(txtNOTE);
		t00361Bean.setCd_00002_pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		t00361Bean.setCd_00001_fwlx(ConvertUtil.encoding(CheckUtil.chkTrim(txtFWLX)));
		t00361Bean.setCd_00001_szqy(ddlSZQY);
		
		//根据PK信息 为BEAN赋值
		if(!Constant.MOD_DELETE.equals(getACT())){
			t00361Bean = t00361Service.LoadByPrimaryKey(t00361Bean);
		}
		
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT())) && (!CheckUtil.chkEmpty(t00361Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk",new String[]{getText("app.xtwh.t00361.lsh")}));
		}
		
		
		
		//判断数据是否已经被其他人修改
		if((Constant.MOD_UPDATE.equals(getACT())) && (!t00361Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))){
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为BEAN赋值
			t00361Bean.setCd_00002_czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00361Bean.setId(ConvertUtil.toInteger(txtLSH));
			t00361Bean.setSynx_min(ConvertUtil.toInteger(txtSYNXMIN));
			t00361Bean.setSynx_max(ConvertUtil.toInteger(txtSYNXMAX));
			t00361Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
			t00361Bean.setNote(txtNOTE);
			t00361Bean.setCzlx(txtCZLX);
			t00361Bean.setCd_00002_pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t00361Bean.setCd_00001_fwlx(ConvertUtil.encoding(CheckUtil.chkTrim(txtFWLX)));
			t00361Bean.setCd_00001_szqy(ddlSZQY);
			t00361Bean.setCd_00001_ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 *  更新信息处理
	 *  throws Exception
	 */
	public String update()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("update() ********** start **********");
		}
		String rtn = "success";
		try{
			if(Constant.MOD_CREATE.equals(getACT())){       //create
				if(t00361Service.GetInsertCommand(getT00361Bean())){
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else{
					this.addActionMessage(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				}
			}else if(Constant.MOD_UPDATE.equals(getACT())){   //update
				if(t00361Service.GetUpdateCommand(getT00361Bean())){
					t00361Bean = t00361Service.LoadByPrimaryKey(t00361Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else{
					this.addActionMessage(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				}
			}else if(Constant.MOD_DELETE.equals(getACT())){	  //delete
				if(t00361Service.GetDeleteCommand(getT00361Bean())){
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else{
					this.addActionMessage(getText(Constant.MSG_DELETE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				}
				rtn = "successDEL";
			}
			
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			
			if(LOG.isDebugEnabled()){
				LOG.debug("update() ********** end **********");
			}
			
			return ERROR;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("update() ********** end **********");
		}
		return rtn;
	}
	
	
	public String delSel() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			Pgt00361 t00361 = new Pgt00361();
			t00361.setChkDel(chkDel);
			t00361.setCd_00002_czr(sessionCtrl.getUserId());
			t00361.setCd_00001_ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t00361Service.GetSelDeleteCommand(t00361)){
				msgDel = "删除成功";
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
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
	public String exportT00361() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT00361() ********** start **********");
		}
		Pgv00361 v00361 = new Pgv00361();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			
			v00361.setPageIndex(1);
			v00361.setCd_00001_fwlx(ConvertUtil.encoding(CheckUtil.chkTrim(txtFWLXFind)));
			v00361.setPageSize(-1);
			v00361.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00361.setCd_00001_szqy(ddlSZQYFind);
			v00361.setCd_00002_czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t00361Service.ExportT00361(v00361);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT00361() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT00361() ********** end **********");
		}
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
		return SUCCESS;
	}
	
	
	/**
	 * 文件导入
	 * @return
	 * @throws Exception
	 */
	public String upload() throws Exception {
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			fileServerPath = getSavePath() + "\\JZCX_" + sessionCtrl.getUserId() + getUploadFileName();
			//建立文件上传的输出流
			FileOutputStream fos = new FileOutputStream(fileServerPath);
			//以上传文件建立一个文件上传流
			FileInputStream fis = new FileInputStream(getUpload());
			//将上传文件的内容写入服务器
			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = fis.read(buffer))>0){
				fos.write(buffer,0,len);			
			}
			fis.close();
			fos.close();
		}catch(Exception ex){
			ex.printStackTrace();
			return INPUT;
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
			Pgv00361List = Excel.importDataJCSJ(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkJCSJ(Pgv00361List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv00361List.size() == 0){
				this.addActionError("数据不符合导入要求");
			}
		}catch(Exception e){
			LOG.error(e.getMessage());
			this.addActionError("数据不符合导入要求:"+e.getMessage());
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("validateImportFile() ********** end **********");
		}
	}
	
	private boolean checkJCSJ(ArrayList<Pgv00361> v00361List)throws Exception{
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
			Pgv00361 result = t00361Service.ImportExcelData(Pgv00361List);
			if(result.getOutFlag() == 2){
				this.addActionMessage("数据导入成功");
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)Excel.exportDataJCSJXZ(result.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的建筑成新数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	 * 读取【所在区域】
	 */
	private void ReadInfo() {
		
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	
	
	
	
	
/*********************** set and get ******************************/
	
	/**
	 * @return the t00361Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00361Service getT00361Service() {
		return t00361Service;
	}
	
	/**
	 * @param t00361Service the t00361Service to set
	 */
	public void setT00361Service(IPgt00361Service t00361Service) {
		this.t00361Service = t00361Service;
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
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * 
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	
	/**
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * 
	 * @return the szquList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * 
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	/**
	 * 
	 * @return the t00361Bean
	 */
	public Pgt00361 getT00361Bean() {
		return t00361Bean;
	}

	/**
	 * 
	 * @param t00361Bean the t00361Bean to set
	 */
	public void setT00361Bean(Pgt00361 t00361Bean) {
		this.t00361Bean = t00361Bean;
	}

	/**
	 * 
	 * @return the isExists
	 */
	public Boolean getIsExists() {
		return isExists;
	}

	/**
	 * 
	 * @param isExists the isExists to set
	 */
	public void setIsExists(Boolean isExists) {
		this.isExists = isExists;
	}

	/**
	 * 
	 * @return the txtLSH
	 */
	public String getTxtLSH() {
		return txtLSH;
	}

	/**
	 * 
	 * @param txtLSH the txtLSH to set
	 */
	public void setTxtLSH(String txtLSH) {
		this.txtLSH = txtLSH;
	}

	/**
	 * 
	 * @return the txtSYNXMIN
	 */
	public String getTxtSYNXMIN() {
		return txtSYNXMIN;
	}

	/**
	 * 
	 * @param txtSYNXMIN the txtSYNXMIN to set
	 */
	public void setTxtSYNXMIN(String txtSYNXMIN) {
		this.txtSYNXMIN = txtSYNXMIN;
	}

	/**
	 * 
	 * @return the txtSYNXMAX
	 */
	public String getTxtSYNXMAX() {
		return txtSYNXMAX;
	}

	/**
	 * 
	 * @param txtSYNXMAX the txtSYNXMAX to set
	 */
	public void setTxtSYNXMAX(String txtSYNXMAX) {
		this.txtSYNXMAX = txtSYNXMAX;
	}

	/**
	 * 
	 * @return the txtXZXS
	 */
	public String getTxtXZXS() {
		return txtXZXS;
	}

	/**
	 * 
	 * @param txtXZXS the txtXZXS to set
	 */
	public void setTxtXZXS(String txtXZXS) {
		this.txtXZXS = txtXZXS;
	}

	/**
	 * 
	 * @return the txtUPDATE
	 */
	public String getTxtUPDATE() {
		return txtUPDATE;
	}

	/**
	 * 
	 * @param txtUPDATE the txtUPDATE to set
	 */
	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
	}

	/**
	 * 
	 * @return the txtNOTE
	 */
	public String getTxtNOTE() {
		return txtNOTE;
	}

	/**
	 * 
	 * @param txtNOTE the txtNOTE to set
	 */
	public void setTxtNOTE(String txtNOTE) {
		this.txtNOTE = txtNOTE;
	}

	/**
	 * 
	 * @return the txtCZLX
	 */
	public Integer getTxtCZLX() {
		return txtCZLX;
	}

	/**
	 * 
	 * @param txtCZLX the txtCZLX to set
	 */
	public void setTxtCZLX(Integer txtCZLX) {
		this.txtCZLX = txtCZLX;
	}

	/**
	 * 
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}

	/**
	 * 
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


	public ArrayList<Pgv00361> getPgv00361List() {
		return Pgv00361List;
	}


	public void setPgv00361List(ArrayList<Pgv00361> pgv00361List) {
		Pgv00361List = pgv00361List;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * @return the rows
	 */
	public ArrayList<Pgv00361> getRows() {
		return rows;
	}


	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00361> rows) {
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


	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
	
}
