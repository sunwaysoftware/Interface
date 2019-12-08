/**
 * 
 */
package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00360Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00360;
import com.sunway.vo.Pgv00052;

/**
 * 
 * 面积修正
 * @author Andy
 *
 */
public class Pgt00360Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 4339619369756654435L;
	private IPgt00360Service t00360Service;
	private String ACT;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	//view
	private ArrayList<Pgt00360> tabList;
	private String txtPSSDFind;
	private String ddlSZQYFind;
	//edit
	private String pk;
	private Pgt00360 t00360Bean;
	private ArrayList<Pgv00052> szqyList;
	private String txtUPDATE;
	private String txtID;
	private String ddlSZQY;
	private String txtFWLX;
	private String txtXZXS;
	private String txtJZMJMIN;
	private String txtJZMJMAX;
	private String txtNOTE;
	private String txtPSSD;
	private String ACTIONNAME;
	private String HREFNAME;
	private String TITLENAME;
	private String URL;
	private String ddlPSSD;
	
	private String chkDel;
	private String msgDel;
	private InputStream excelStream;
	
	//file upload
	private String fileServerPath;
	private File upload;
	private String uploadFileName;
	private String savePath;
	
	//file import
	private String txtFilePath;
	private String fileName;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		try {
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}

	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		Pgt00360 t00360 = new Pgt00360();
		try {
			//准备查询条件
			t00360.setCd00002Pssd(txtPSSDFind);
			t00360.setCd00001Szqy(ddlSZQYFind);
			t00360.setCd00001Fwlx(txtFWLX);
			t00360.setPageIndex(pageIndex);
			t00360.setPageSize(getPageSize());
			t00360.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = t00360Service.LoadAll(t00360);
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			}else{
				rowCount = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
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
				t00360Bean = t00360Service.LoadByPrimaryKey(new Pgt00360(pk));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return INPUT;
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
		t00360Bean = new Pgt00360(txtID);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(ACT)){
			t00360Bean = t00360Service.LoadByPrimaryKey(t00360Bean);			
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(ACT))&&(!t00360Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t00360Bean.setCd00001Szqy(ddlSZQY);
			t00360Bean.setCd00001Fwlx(txtFWLX);
			t00360Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00360Bean.setXzxs(BigDecimal.valueOf(Common.convertToDouble(txtXZXS)));
			t00360Bean.setJzmjMin(BigDecimal.valueOf(Common.convertToDouble(txtJZMJMIN)));
			t00360Bean.setJzmjMax(BigDecimal.valueOf(Common.convertToDouble(txtJZMJMAX)));
			t00360Bean.setNote(txtNOTE);
			t00360Bean.setCd00002Pssd(txtPSSD);
		}
	}
	
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		try {
			if(Constant.MOD_CREATE.equals(ACT)){			// Create
				if(t00360Service.GetInsertCommand(t00360Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t00360Bean.getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t00360Bean.getCd00001Szqy()}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t00360Service.GetUpdateCommand(t00360Bean)){
					t00360Bean = t00360Service.LoadByPrimaryKey(t00360Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{t00360Bean.getCd00001Szqy()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{t00360Bean.getCd00001Szqy()}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t00360Service.GetDeleteCommand(t00360Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t00360Bean.getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t00360Bean.getCd00001Szqy()}));
			}		
		} catch (Exception e) {
			LOG.error(e.getMessage());
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);
			return INPUT;
		}
		return SUCCESS;
	}	
	
	/**
	 * 选择删除
	 * @return
	 * @throws Exception
	 */
	public String delSel() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try{
			Pgt00360 t00360 = new Pgt00360();
			t00360.setId(chkDel);
			t00360.setCd00002Czr(sessionCtrl.getUserId());
			t00360.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t00360Service.SelDeleteCommand(t00360)){
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
	public String exportT00360() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT00360() ********** start **********");
		}
		Pgt00360 t00360 = new Pgt00360();
		try{
			t00360.setPageIndex(1);
			t00360.setCd00001Fwlx(Common.convertEncoding(Common.trim(txtFWLX)));
			t00360.setPageSize(-1);
			t00360.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t00360.setCd00001Szqy(ddlSZQYFind);
			t00360.setCd00002Czr(sessionCtrl.getUserId());
			ByteArrayOutputStream out = (ByteArrayOutputStream)t00360Service.ExportT00360(t00360);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("exportT00360() ********** end **********");
			}
			return INPUT;
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportT00360() ********** end **********");
		}
		return SUCCESS;
	}	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String viewCopy() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("viewCopy()********** start **********");
		}

		try {
		
			ReadInfoCOPY();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("viewCopy() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("viewCopy() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 参数复制功能
	 * @return
	 * @throws Exception
	 */
	public String copyParam() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("copyParam() ********** start **********");
		}
		t00360Bean = new Pgt00360();
		try {
			ReadInfoCOPY();
			t00360Bean.setSpssd(ddlPSSD);
			t00360Bean.setTpssd(txtPSSD);
			t00360Bean.setCd00001Szqy(ddlSZQY);
			t00360Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00360Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(t00360Service.ExecuteParamCopy(getT00360Bean()))
				this.addActionMessage(getText(Constant.MSG_COPY_OK, new String[]{getT00360Bean().getSpssd()}));
			else
				this.addActionError(getText(Constant.MSG_COPY_NG, new String[]{getT00360Bean().getSpssd()}));
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("copyParam() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("copyParam() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 为参数复制页面赋值
	 */
	private void ReadInfoCOPY(){
		setACTIONNAME("EXET00360COPY");
		setHREFNAME("VIEWT00360");
		setTITLENAME(getText("app.xtwh.t00360.title"));
		setURL("003609");
		szqyList = sessionCtrl.ReadSzqyList();
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
	 * @return
	 * @throws Exception
	 */
	public String upload() throws Exception {
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			fileServerPath = getSavePath() + "\\MJXZ" + sessionCtrl.getUserId() + getUploadFileName();
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
		
		if(!Common.isFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查");
		}
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			tabList = t00360Service.ImportData(txtFilePath, sessionCtrl.getUserId(), sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(tabList.size() < 1){
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
	
	/**
	 * 文件导入
	 */
	public String importFile()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("importFile() ********** start **********");
		}
		
		try{
			Pgt00360 errBean = t00360Service.GetImportCommand(tabList);
			if(errBean.getOutFlag()){
				this.addActionMessage("数据导入成功");
			}else{
				ByteArrayOutputStream out = (ByteArrayOutputStream)t00360Service.ExportT00360Error(errBean.getSelfList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName = new String("格式错误的建筑面积修正数据.xls".getBytes("GBK"),"ISO-8859-1");
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
	
	/**************** set and get *********************/

	/**
	 * @param t00360Service the t00360Service to set
	 */
	public void setT00360Service(IPgt00360Service t00360Service) {
		this.t00360Service = t00360Service;
	}

	/**
	 * @return the t00360Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00360Service getT00360Service() {
		return t00360Service;
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
	 * @return the tabList
	 */
	public ArrayList<Pgt00360> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgt00360> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the txtPSSDFind
	 */
	public String getTxtPSSDFind() {
		return txtPSSDFind;
	}

	/**
	 * @param txtPSSDFind the txtPSSDFind to set
	 */
	public void setTxtPSSDFind(String txtPSSDFind) {
		this.txtPSSDFind = txtPSSDFind;
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
	 * @return the t00360Bean
	 */
	public Pgt00360 getT00360Bean() {
		return t00360Bean;
	}

	/**
	 * @param t00360Bean the t00360Bean to set
	 */
	public void setT00360Bean(Pgt00360 t00360Bean) {
		this.t00360Bean = t00360Bean;
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
	 * @return the txtJZMJMIN
	 */
	public String getTxtJZMJMIN() {
		return txtJZMJMIN;
	}

	/**
	 * @param txtJZMJMIN the txtJZMJMIN to set
	 */
	public void setTxtJZMJMIN(String txtJZMJMIN) {
		this.txtJZMJMIN = txtJZMJMIN;
	}

	/**
	 * @return the txtJZMJMAX
	 */
	public String getTxtJZMJMAX() {
		return txtJZMJMAX;
	}

	/**
	 * @param txtJZMJMAX the txtJZMJMAX to set
	 */
	public void setTxtJZMJMAX(String txtJZMJMAX) {
		this.txtJZMJMAX = txtJZMJMAX;
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
	 * @return the sessionCtrl
	 */
	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	/**
	 * @param sessionCtrl the sessionCtrl to set
	 */
	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	/**
	 * @return the aCTIONNAME
	 */
	public String getACTIONNAME() {
		return ACTIONNAME;
	}

	/**
	 * @param actionname the aCTIONNAME to set
	 */
	public void setACTIONNAME(String actionname) {
		ACTIONNAME = actionname;
	}

	/**
	 * @return the hREFNAME
	 */
	public String getHREFNAME() {
		return HREFNAME;
	}

	/**
	 * @param hrefname the hREFNAME to set
	 */
	public void setHREFNAME(String hrefname) {
		HREFNAME = hrefname;
	}

	/**
	 * @return the tITLENAME
	 */
	public String getTITLENAME() {
		return TITLENAME;
	}

	/**
	 * @param titlename the tITLENAME to set
	 */
	public void setTITLENAME(String titlename) {
		TITLENAME = titlename;
	}

	/**
	 * @param txtPSSD the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}

	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @param url the uRL to set
	 */
	public void setURL(String url) {
		URL = url;
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

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
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
	 * @return the chkDel
	 */
	public String getChkDel() {
		return chkDel;
	}

	/**
	 * @param chkDel the chkDel to set
	 */
	public void setChkDel(String chkDel) {
		this.chkDel = chkDel;
	}

	/**
	 * @return the msgDel
	 */
	public String getMsgDel() {
		return msgDel;
	}

	/**
	 * @param msgDel the msgDel to set
	 */
	public void setMsgDel(String msgDel) {
		this.msgDel = msgDel;
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
}
