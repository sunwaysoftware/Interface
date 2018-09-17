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
import com.sunway.service.IPgt00362Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.Excel;
import com.sunway.util.FileUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00362;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00362;


/**
 * 建筑结构修正系统维护
 * @author HuanWei
 *
 */

public class Pgt00362Action extends ActionSupport implements SessionAware  {
	
	private static final long serialVersionUID = 2432911160879003583L;
	
	private IPgt00362Service t00362Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	private ArrayList<Pgv00362> rows;
	private ArrayList<Pgv00052> szqyList;
	
	//传递来的ID
	private String id;
	
	//设置分页
	private Integer pageSize;
	private Integer pageIndex;
	private Integer total;
	
	//查询条件
	private String txtPSSDFind;
	private String txtJZJGFind;
	private String txtFWLXFind;
	private String ddlSZQYFind;
	//编辑操作符
	private String ACT;
	
	//页面所需的Bean
	private Pgt00362 t00362Bean;
	
	//表单提交数据
	private Boolean isExists;
	private String txtLSH;
	private String txtPSSD;
	private String txtJZJGT;
	private String txtXZXS;
	


	private String txtXZXSS;
	private String txtCZLX;
	
	private String txtCZR;
	private String txtNOTE;
	private String txtYWDT;
	private String txtUPDATE;
	private String txtFWLX;
	private String ddlSZQY;
	private String userRole;
	private InputStream excelStream;
	private String txtXQDM;
	private String txtXQFind;
	private Integer outFlag;
	
	//file upload
	private String fileServerPath;
	private File upload;
	private String savePath;
	private String uploadFileName;
	
	//file import
	private String txtFilePath;
	private ArrayList<Pgv00362> Pgv00362List;
	private String fileName;
	
	private String chkSel;
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
		
		Pgv00362 v00362 = new Pgv00362();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			
			v00362.setPageIndex(pageIndex);
			v00362.setPageSize(getPageSize());
			v00362.setCd_00002_pssd(ConvertUtil.encoding(CheckUtil.chkTrim(txtPSSDFind)));
			v00362.setCd_00001_jzjg(ConvertUtil.encoding(CheckUtil.chkTrim(txtJZJGFind)));
			v00362.setCd_00001_fwlx(ConvertUtil.encoding(CheckUtil.chkTrim(txtFWLX)));
			v00362.setCd_00001_szqy(ddlSZQYFind);
            v00362.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			rows = t00362Service.LoadAll(v00362);
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
		
		Pgt00362 t00362 = new Pgt00362();
		
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				t00362.setId(ConvertUtil.toInteger(id));
				t00362Bean = t00362Service.LoadByPrimaryKey(t00362);
				if(CheckUtil.chkEmpty(t00362Bean.getUpddate())){
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
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdate()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUpdate() ********** start **********");
		}
		
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t00362Bean = new Pgt00362();
		this.clearErrorsAndMessages();
		ReadInfo();
		t00362Bean.setId(ConvertUtil.toInteger(txtLSH));
		t00362Bean.setCd_00002_pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		t00362Bean.setCd_00001_jzjg(ConvertUtil.encoding(CheckUtil.chkTrim(txtJZJGT)));
		t00362Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
		t00362Bean.setCzlx(ConvertUtil.toInteger(txtCZLX));
		t00362Bean.setCd_00002_czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
		t00362Bean.setNote(txtNOTE);
		t00362Bean.setYwdt(0);
		t00362Bean.setCd_00001_fwlx(ConvertUtil.encoding(CheckUtil.chkTrim(txtFWLX)));
		t00362Bean.setCd_00001_szqy(ddlSZQY);
		
		//根据PK信息，为BEAN赋值
		if(!Constant.MOD_DELETE.equals(getACT())){
			t00362Bean = t00362Service.LoadByPrimaryKey(t00362Bean);
		}
		
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT())) && (!CheckUtil.chkEmpty(t00362Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk",new String[]{getText("app.xtwh.t00361.lsh")}));
		}
		
		System.out.println(t00362Bean.getUpddate());
		//判断数据是否已经被他人修改
		if((Constant.MOD_UPDATE.equals(getACT())) && (!t00362Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为BEAN赋值
			t00362Bean.setId(ConvertUtil.toInteger(txtLSH));
			t00362Bean.setCd_00002_pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t00362Bean.setCd_00001_jzjg(ConvertUtil.encoding(CheckUtil.chkTrim(txtJZJGT)));
			t00362Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
			t00362Bean.setCzlx(ConvertUtil.toInteger(txtCZLX));
			t00362Bean.setCd_00002_czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00362Bean.setNote(txtNOTE);
			t00362Bean.setYwdt(0);
			t00362Bean.setCd_00001_fwlx(ConvertUtil.encoding(CheckUtil.chkTrim(txtFWLX)));
			t00362Bean.setCd_00001_szqy(ddlSZQY);
			t00362Bean.setCd_00001_ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 * 更新信息处理
	 * @throws Exception
	 */
	public String update()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("update() ********** start **********");
		}
		String rtn = "success";
		try{
			if(Constant.MOD_CREATE.equals(getACT())){      //create
				if(t00362Service.GetInsertCommand(getT00362Bean())){
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else{
					this.addActionMessage(getText(Constant.MSG_CREATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				}
			}else if(Constant.MOD_UPDATE.equals(getACT())){
				if(t00362Service.GetUpdateCommand(getT00362Bean())){
					t00362Bean = t00362Service.LoadByPrimaryKey(t00362Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				}else{
					this.addActionMessage(getText(Constant.MSG_UPDATE_NG, new String[]{getText("app.xtwh.t00361.cs")}));
				}
			}else if(Constant.MOD_DELETE.equals(getACT())){
				if(t00362Service.GetDeleteCommand(getT00362Bean())){
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
			Pgt00362 t00362 = new Pgt00362();
			t00362.setChkDel(chkSel);
			t00362.setCd_00002_czr(sessionCtrl.getUserId());
			t00362.setCd_00001_ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t00362Service.GetSelDeleteCommand(t00362)){
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
	public String exportT00362()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT00362() ********** start **********");
		}
		
		Pgv00362 v00362 = new Pgv00362();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			
			v00362.setPageIndex(1);
			v00362.setPageSize(-1);
			v00362.setCd_00002_pssd(ConvertUtil.encoding(CheckUtil.chkTrim(txtPSSDFind)));
			v00362.setCd_00001_jzjg(ConvertUtil.encoding(CheckUtil.chkTrim(txtJZJGFind)));
			v00362.setCd_00001_fwlx(ConvertUtil.encoding(CheckUtil.chkTrim(txtFWLXFind)));
			v00362.setCd_00001_szqy(ddlSZQYFind);
            v00362.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00362.setCd_00002_czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t00362Service.ExportJZJG(v00362);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT00362() ********** end **********");
			}
			userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
			return INPUT;
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT00362() ********** end **********");
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
			fileServerPath = getSavePath() + "\\JZJG_" + sessionCtrl.getUserId() + getUploadFileName();
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
			Pgv00362List = Excel.importDataJZJG(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkJCSJ(Pgv00362List)){
				this.addActionError("数据不符合导入要求");
			}
			if(Pgv00362List.size() == 0){
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
	
	private boolean checkJCSJ(ArrayList<Pgv00362> v00362List)throws Exception{
		return true;
	}
	
	
	
	/**
	 * 文件导入
	 */
	public String importFile() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** start **********");
		}
		
			Pgv00362 tmpV00362 = new Pgv00362();
			try{
				tmpV00362 = t00362Service.ImportExcelData(Pgv00362List);
			}catch(Exception ex){
				ex.printStackTrace();
				this.addActionError(ex.getMessage());
				return INPUT;
			}finally{
				if(tmpV00362.getOutFlag()==2)
					this.addActionMessage("数据导入成功！");
				else{
					ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportDataJzjg(tmpV00362.getOutList());
					excelStream = new ByteArrayInputStream(out.toByteArray());
					fileName=new String("格式错误的建筑结构数据.xls".getBytes("GBK"),"ISO-8859-1");
					return "failexport";
				}
				/*
				else if (tmpV00304.getOutFlag()==1)
					this.addActionMessage("数据导入执行完毕，但导入过程中部分失败！");
				else 
					this.addActionError("数据导入失败！");
				*/
		}
		return SUCCESS;
	}
	
	/**
	 * 读取【所在区域】
	 */
	private void ReadInfo() {
		szqyList = sessionCtrl.ReadSzqyList();
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
		
		Pgt00362 t00362 = new Pgt00362();
		try{
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				t00362.setId(ConvertUtil.toInteger(id));
				t00362.setCd_00001_szqy(ddlSZQY);
				t00362.setCd_00001_fwlx(txtFWLX);
				t00362.setCd_00001_jzjg(txtJZJGT);
		
				t00362Bean = t00362Service.LoadByPrimaryAddKey(t00362);
				isExists = t00362Bean.getUpddate() == null?true:false;
				
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
	
	
	
	
	
	
	
/*********************** set and get ******************************/
	
	
	/**
	 * @return the t00362Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00362Service getT00362Service() {
		return t00362Service;
	}
	
	/**
	 * 
	 * @param t00362Service the t00362Service to set
	 */
	public void setT00362Service(IPgt00362Service t00362Service) {
		this.t00362Service = t00362Service;
	}

	/**
	 * 
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * 
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}



	/**
	 * 
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * 
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	/**
	 * 
	 * @return the txtPSSDFind
	 */
	public String getTxtPSSDFind() {
		return txtPSSDFind;
	}

	/**
	 * 
	 * @param txtPSSDFind the txtPSSDFind to set
	 */
	public void setTxtPSSDFind(String txtPSSDFind) {
		this.txtPSSDFind = txtPSSDFind;
	}

	/**
	 * 
	 * @return the txtJZJGFind
	 */
	public String getTxtJZJGFind() {
		return txtJZJGFind;
	}

	/**
	 * 
	 * @param txtJZJGFind the txtJZJGFind to set
	 */
	public void setTxtJZJGFind(String txtJZJGFind) {
		this.txtJZJGFind = txtJZJGFind;
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
	 * @param aCT the aCt to set
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
	 * @return the t00362Bean
	 */
	public Pgt00362 getT00362Bean() {
		return t00362Bean;
	}

	/**
	 * 
	 * @param t00362Bean the t00362Bean to set
	 */
	public void setT00362Bean(Pgt00362 t00362Bean) {
		this.t00362Bean = t00362Bean;
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
	 * @return the txtXZXS
	 */
	public String getTxtXZXS() {
		return txtXZXS;
	}

	public String getTxtJZJGT() {
		return txtJZJGT;
	}

	public void setTxtJZJGT(String txtJZJGT) {
		this.txtJZJGT = txtJZJGT;
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
	 * @return the txtCZLX;
	 */
	public String getTxtCZLX() {
		return txtCZLX;
	}

	/**
	 * 
	 * @param txtCZLX the CZLX to set
	 */
	public void setTxtCZLX(String txtCZLX) {
		this.txtCZLX = txtCZLX;
	}

	/**
	 * 
	 * @return the txtCZR
	 */
	public String getTxtCZR() {
		return txtCZR;
	}

	/**
	 * 
	 * @param txtCZR the txtCZR to set
	 */
	public void setTxtCZR(String txtCZR) {
		this.txtCZR = txtCZR;
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
	 * @return the txtYWDT
	 */
	public String getTxtYWDT() {
		return txtYWDT;
	}

	/**
	 * 
	 * @param txtYWDT the txtYWDT to set
	 */
	public void setTxtYWDT(String txtYWDT) {
		this.txtYWDT = txtYWDT;
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

	/**
	 * 
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * 
	 * @param userRole the userRolen to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
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


	public String getSavePath() {
		return savePath;
	}


	@SuppressWarnings("deprecation")
	public void setSavePath(String savePath) {
		this.savePath = ServletActionContext.getRequest().getRealPath(savePath);
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


	public ArrayList<Pgv00362> getPgv00362List() {
		return Pgv00362List;
	}


	public void setPgv00362List(ArrayList<Pgv00362> pgv00362List) {
		Pgv00362List = pgv00362List;
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
	public ArrayList<Pgv00362> getRows() {
		return rows;
	}


	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00362> rows) {
		this.rows = rows;
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
	 * @return the txtXZXSS
	 */
	public String getTxtXZXSS() {
		return txtXZXSS;
	}


	/**
	 * @param txtXZXSS the txtXZXSS to set
	 */
	public void setTxtXZXSS(String txtXZXSS) {
		this.txtXZXSS = txtXZXSS;
	}
	/**
	 * @return the outFlag
	 */
	public Integer getOutFlag() {
		return outFlag;
	}

	/**
	 * @param outFlag the outFlag to set
	 */
	public void setOutFlag(Integer outFlag) {
		this.outFlag = outFlag;
	}




	public String getChkSel() {
		return chkSel;
	}

	public void setChkSel(String chkSel) {
		this.chkSel = chkSel;
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
