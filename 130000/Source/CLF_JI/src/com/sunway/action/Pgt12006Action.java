package com.sunway.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12006Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
//import com.sunway.util.Excel;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12006;

/**
 * 
 * 登记人或承租人信息表(可以给登记提供自动提示功能)
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12006Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -4441367959273346389L;
	
	private IPgt12006Service t12006Service;
	
	//view
	private ArrayList<Pgt12006> autoList;
	private Pgt12006 t12006Bean;
	
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	
	private String userId;
	private String txtCZRZJHFind;
	private String txtCZRMCFind;
	private Integer processCent;
	private String processMsg;
	//eidt
	
	private ArrayList<Pgt12006> t12006List;
	
	private String ACT;
	private String CZRZJH;
	private String txtCZRZJH;
	private String txtCZRMC;
	private String txtUPDATE;
	private String txtNOTE;
	private String txtJJLXId;
	private String txtHYId;
	private String txtFCSE;
	private String txtTDSE;
	
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
	private ArrayList<Pgt12006> Pgt12006List;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String view() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		try {
			t12006Bean = t12006Service.LoadByPrimaryKey(new Pgt12006(Common.convertEncoding(userId)));
			if(null == t12006Bean.getCzrzjh()){
				t12006Bean.setCzrzjh(Constant.STRING_EMPTY);
				t12006Bean.setCzrmc(Constant.STRING_EMPTY);
				t12006Bean.setCd00001Hy(Constant.STRING_EMPTY);
				t12006Bean.setHy(Constant.STRING_EMPTY);
				t12006Bean.setCd00001Jjlx(Constant.STRING_EMPTY);
				t12006Bean.setJjlx(Constant.STRING_EMPTY);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("view() ********** start **********");
		}
		try {
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("view() ********** end **********");
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
		Pgt12006 t12006 = new Pgt12006();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			t12006.setCzrmc(Common.getSearchLike(Common.convertEncoding(txtCZRMCFind)));
			t12006.setCzrzjh(Common.getSearchLike(Common.trim(txtCZRZJHFind)));
			t12006.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t12006.setPageIndex(pageIndex);
			t12006.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			//执行查询
			autoList = t12006Service.LoadAll(t12006);
			// 分页设置
			if (null != autoList && autoList.size() > 0) {
				rowCount = autoList.get(0).getRecordCount();
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
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
	public String create() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		Pgt12006 t12006 = new Pgt12006();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t12006.setCzrzjh(CZRZJH);
				t12006Bean = t12006Service.LoadByPrimaryKey(t12006);
			}
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
		
		t12006Bean = new Pgt12006();
		this.clearErrorsAndMessages();	
		t12006Bean.setCzrzjh(txtCZRZJH);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t12006Bean = t12006Service.LoadByPrimaryKey(t12006Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t12006Bean.getCzrzjh()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.t00002.userid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t12006Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//为数据BEAN赋值
			t12006Bean.setCzrzjh(txtCZRZJH);
			t12006Bean.setCzrmc(txtCZRMC);
			t12006Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t12006Bean.setCd00001Hy(txtHYId);
			t12006Bean.setCd00001Jjlx(txtJJLXId);
			t12006Bean.setFcse(Common.convertToDouble(txtFCSE));
			t12006Bean.setTdse(Common.convertToDouble(txtTDSE));
			t12006Bean.setNote(txtNOTE);
			t12006Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t12006Bean.setCd00001Ssgxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SSGX));
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
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t12006Service.GetInsertCommand(getT12006Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT12006Bean().getCzrzjh()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT12006Bean().getCzrzjh()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t12006Service.GetUpdateCommand(getT12006Bean())){
					t12006Bean = t12006Service.LoadByPrimaryKey(t12006Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT12006Bean().getCzrzjh()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT12006Bean().getCzrzjh()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t12006Service.GetDeleteCommand(getT12006Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT12006Bean().getCzrzjh()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT12006Bean().getCzrzjh()}));
			}			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

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
	
	/**
	 * 点击单选按钮的ajax事件，
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String createByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		
		t12006List = new ArrayList<Pgt12006>();
		Pgt12006 t12006 = new Pgt12006();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t12006.setCzrzjh(txtCZRZJH);
				t12006Bean = t12006Service.LoadByPrimaryKey(t12006);
				if (t12006Bean.getCzrzjh() == null) {
					t12006Bean.setCzrzjh(txtCZRZJH);
					t12006Bean.setCzrmc("");
					t12006Bean.setNote("");
				}
				t12006List.add(t12006Bean);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
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
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String upload() throws Exception {
		try{
			fileServerPath = getSavePath() + "\\" + getUploadFileName();
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

	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	public void validateImportFile() {
		if(!Common.isFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查！");
		}
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//检验数据合法性
			//Pgt12006List = Excel.importDataZgsj(txtFilePath, sessionCtrl.getUserId());
			if(!checkZgdj(Pgt12006List))
				this.addActionError("征管数据不符合导入要求！");
			if(Pgt12006List.size()==0)
				this.addActionError("征管数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError("文件错误，请检查！"+ex.getMessage());
		}
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String importFile() throws Exception {
		processMsg = "征管数据导入";
		Integer bImport = 0;
		try{
			for (int i = 0; i < Pgt12006List.size(); i++) {
				if (!t12006Service.ImportExcelData(Pgt12006List.get(i))) {
					bImport++;
				}
				processCent = i*100/Pgt12006List.size();
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError(ex.getMessage());
			return INPUT;
		}finally{
			if(bImport==0)
				this.addActionMessage("数据导入执行完毕！");
			else if (bImport>0)
				this.addActionMessage("数据导入执行完毕，但导入过程中部分失败！");
			else 
				this.addActionError("数据导入失败！");
		}
		return SUCCESS;
	}

	/**
	 * 对[征管数据]合法性进行检验
	 * @param list
	 * @return
	 */
	private Boolean checkZgdj(ArrayList<Pgt12006> list){
		//TODO 处理保留 对[挂牌数据]合法性进行检验
		return true;
	}
	
	
	/*********************** set and get ******************************/
	
	/**
	 * @param t12006Service the t12006Service to set
	 */
	public void setT12006Service(IPgt12006Service t12006Service) {
		this.t12006Service = t12006Service;
	}
	/**
	 * @return the t12006Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12006Service getT12006Service() {
		return t12006Service;
	}

	/**
	 * @return the autoList
	 */
	public ArrayList<Pgt12006> getAutoList() {
		return autoList;
	}

	/**
	 * @param autoList the autoList to set
	 */
	public void setAutoList(ArrayList<Pgt12006> autoList) {
		this.autoList = autoList;
	}

	/**
	 * @return the t12006Bean
	 */
	public Pgt12006 getT12006Bean() {
		return t12006Bean;
	}

	/**
	 * @param t12006Bean the t12006Bean to set
	 */
	public void setT12006Bean(Pgt12006 t12006Bean) {
		this.t12006Bean = t12006Bean;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
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
	 * @return the cZRZJH
	 */
	public String getCZRZJH() {
		return CZRZJH;
	}

	/**
	 * @param cZRZJH the cZRZJH to set
	 */
	public void setCZRZJH(String cZRZJH) {
		CZRZJH = cZRZJH;
	}

	/**
	 * @return the txtCZRZJH
	 */
	public String getTxtCZRZJH() {
		return txtCZRZJH;
	}

	/**
	 * @param txtCZRZJH the txtCZRZJH to set
	 */
	public void setTxtCZRZJH(String txtCZRZJH) {
		this.txtCZRZJH = txtCZRZJH;
	}

	/**
	 * @return the txtCZRMC
	 */
	public String getTxtCZRMC() {
		return txtCZRMC;
	}

	/**
	 * @param txtCZRMC the txtCZRMC to set
	 */
	public void setTxtCZRMC(String txtCZRMC) {
		this.txtCZRMC = txtCZRMC;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the txtCZRZJHFind
	 */
	public String getTxtCZRZJHFind() {
		return txtCZRZJHFind;
	}

	/**
	 * @param txtCZRZJHFind the txtCZRZJHFind to set
	 */
	public void setTxtCZRZJHFind(String txtCZRZJHFind) {
		this.txtCZRZJHFind = txtCZRZJHFind;
	}

	/**
	 * @return the txtCZRMCFind
	 */
	public String getTxtCZRMCFind() {
		return txtCZRMCFind;
	}

	/**
	 * @param txtCZRMCFind the txtCZRMCFind to set
	 */
	public void setTxtCZRMCFind(String txtCZRMCFind) {
		this.txtCZRMCFind = txtCZRMCFind;
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
	 * @return the pageCount
	 */
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return the rowCount
	 */
	public Integer getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the t12006List
	 */
	public ArrayList<Pgt12006> getT12006List() {
		return t12006List;
	}

	/**
	 * @param t12006List the t12006List to set
	 */
	public void setT12006List(ArrayList<Pgt12006> t12006List) {
		this.t12006List = t12006List;
	}

	/**
	 * @return the txtJJLXId
	 */
	public String getTxtJJLXId() {
		return txtJJLXId;
	}

	/**
	 * @param txtJJLXId the txtJJLXId to set
	 */
	public void setTxtJJLXId(String txtJJLXId) {
		this.txtJJLXId = txtJJLXId;
	}

	/**
	 * @return the txtHYId
	 */
	public String getTxtHYId() {
		return txtHYId;
	}

	/**
	 * @param txtHYId the txtHYId to set
	 */
	public void setTxtHYId(String txtHYId) {
		this.txtHYId = txtHYId;
	}

	/**
	 * @return the txtFCSE
	 */
	public String getTxtFCSE() {
		return txtFCSE;
	}

	/**
	 * @param txtFCSE the txtFCSE to set
	 */
	public void setTxtFCSE(String txtFCSE) {
		this.txtFCSE = txtFCSE;
	}

	/**
	 * @return the txtTDSE
	 */
	public String getTxtTDSE() {
		return txtTDSE;
	}

	/**
	 * @param txtTDSE the txtTDSE to set
	 */
	public void setTxtTDSE(String txtTDSE) {
		this.txtTDSE = txtTDSE;
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
	 * @return the pgt12006List
	 */
	public ArrayList<Pgt12006> getPgt12006List() {
		return Pgt12006List;
	}

	/**
	 * @param pgt12006List the pgt12006List to set
	 */
	public void setPgt12006List(ArrayList<Pgt12006> pgt12006List) {
		Pgt12006List = pgt12006List;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}


}
