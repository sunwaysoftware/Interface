package com.sunway.action;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.io.InputStream;
import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00004Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00004;
import com.sunway.vo.Pgv00004;
import com.sunway.vo.Pgv00052;

/**
 * 免税政策维护
 * 
 * @author LeiJia
 */

public class Pgt00004Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7635904976915043992L;
	// Service
	private IPgt00004Service t00004Service;

	// View

	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	private String processMsg;
	private Integer processCent;
	// Bean数组
	private ArrayList<Pgv00004> tabList;
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv00004> ebList;
	// 查询条件
	private String txtJSFIND;
	private String txtXSFIND;
	// Edit

	// edit页面所需Bean
	private Pgt00004 t00004Bean;
	// primary key 主键
	private String ACT;
	// 表单提交数据
	private String txtJS;
	private String txtNOTE;
	private String txtUPDATE;
	private String txtXS;
	private Boolean isExists;

	private String ACTIONNAME;
	private String HREFNAME;
	private String TITLENAME;
	private String URL;
	private SessionCtrl sessionCtrl = new SessionCtrl();	
	// file upload
	private String title;
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String savePath;
	private String ddlImportLx;
	private String fileServerPath;
	// file import
	private String txtFilePath;
	private ArrayList<Pgt00004> Pgt00004List;
	// 检索条件
	private InputStream excelStream;
	private String fileName;
	private String pk;
	private String txtID;
	private String msgDel;
	private String chkDel;

	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			
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
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00004 v00004 = new Pgv00004();
		try {
			// 准备查询条件
			v00004.setJs(txtJSFIND);
			v00004.setXs(txtXSFIND);
			v00004.setPageIndex(pageIndex);
			v00004.setPageSize(getPageSize());
			//v00004.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			tabList = t00004Service.LoadAll(v00004);

			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());

			} else {

				pageIndex = 1;
				rowCount = 0;
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
	 * 
	 * @return
	 * @throws Exception
	 */

	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t00004Bean = t00004Service.LoadByPrimaryKey(new Pgt00004(pk));
				if (Common.isNullOrEmpty(t00004Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
			}			
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
	 * 更新操作前的验证处理
	 * 
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		t00004Bean = new Pgt00004(txtID);
		this.clearErrorsAndMessages();
		// 根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())) {
			t00004Bean = t00004Service.LoadByPrimaryKey(t00004Bean);
		}
		// 判断PK是否重复
		if ((Constant.MOD_CREATE.equals(getACT()))
				&& (!Common.isNullOrEmpty(t00004Bean.getUpddate()))) {
			this.addActionError(getText("app.msg.error.pk",
					new String[] { getText("app.xtwh.info.tdyt") }));
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!t00004Bean.getUpddate().equals(
						Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			// 为数据BEAN赋值

			t00004Bean.setJs(txtJS);
			t00004Bean.setXs(txtXS);
			t00004Bean.setCd00002Czr(sessionCtrl.getUserId());
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}

	/**
	 * 更新信息处理
	 * 
	 * @return
	 * @throws Exception
	 */

	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if (t00004Service.GetInsertCommand(getT00004Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK,
							new String[] { getT00004Bean().getId() }));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG,
							new String[] { getT00004Bean().getId() }));
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00004Service.GetUpdateCommand(getT00004Bean())) {
					t00004Bean = t00004Service.LoadByPrimaryKey(t00004Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK,
							new String[] { getT00004Bean().getId() }));
				} else
					this.addActionError(getText(Constant.MSG_UPDATE_NG,
							new String[] { getT00004Bean().getId() }));
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t00004Service.GetDeleteCommand(getT00004Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK,
							new String[] { getT00004Bean().getId() }));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG,
							new String[] { getT00004Bean().getId() }));
				return "successDEL";
			}
		} catch (Exception e) {
			e.printStackTrace();
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}if (Constant.MOD_DELETE.equals(getACT()))// Delete
			return "successDEL";
		else
			return SUCCESS;
	}

	/**
	 * 点击单选按钮的ajax事件，
	 * 
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String createByAjax() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}

		Pgt00004 t00004 = new Pgt00004();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t00004.setId(txtID);
				t00004Bean = t00004Service.LoadByPrimaryKey(t00004);
				isExists = t00004Bean.getUpddate() == null ? true : false;
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
	 * 点击删除按钮的ajax事件，
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteByAjax() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}

		Pgt00004 t00004 = new Pgt00004();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t00004.setId(txtID);
				t00004Service.GetDeleteCommand(t00004);
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



	
	public String delSel() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try {
			Pgv00004 t00004 = new Pgv00004();
			t00004.setIds(chkDel);
			t00004.setCd00002Czr(sessionCtrl.getUserId());
			t00004.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if (t00004Service.GetDeleteImpCommand(t00004)) {
				msgDel = "删除成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msgDel = "删除失败：" + e.getMessage();
			if (LOG.isDebugEnabled()) {
				LOG.debug("delSel() ********** end **********");
			}
			return SUCCESS;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("delSel() ********** end **********");
		}
		return SUCCESS;
	}
	/*********************** set and get ******************************/

	/**
	 * @return the t00004Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00004Service getT00004Service() {
		return t00004Service;
	}

	/**
	 * @param t00004Service
	 *            the t00004Service to set
	 */
	public void setT00004Service(IPgt00004Service t00004Service) {
		this.t00004Service = t00004Service;
	}

	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex
	 *            the pageIndex to set
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
	 * @param rowCount
	 *            the rowCount to set
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param szqyList
	 *            the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}


	/**
	 * @return the t00004Bean
	 */
	public Pgt00004 getT00004Bean() {
		return t00004Bean;
	}

	/**
	 * @param t00004Bean
	 *            the t00004Bean to set
	 */
	public void setT00004Bean(Pgt00004 t00004Bean) {
		this.t00004Bean = t00004Bean;
	}


	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @param aCT
	 *            the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}


	/**
	 * @return the txtNOTE
	 */
	public String getTxtNOTE() {
		return txtNOTE;
	}

	/**
	 * @param txtNOTE
	 *            the txtNOTE to set
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
	 * @param txtUPDATE
	 *            the txtUPDATE to set
	 */
	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
	}

	/**
	 * @return the isExists
	 */
	public Boolean getIsExists() {
		return isExists;
	}

	/**
	 * @param isExists
	 *            the isExists to set
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
	 * @param aCTIONNAME
	 *            the aCTIONNAME to set
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
	 * @param hREFNAME
	 *            the hREFNAME to set
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
	 * @param tITLENAME
	 *            the tITLENAME to set
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
	 * @param uRL
	 *            the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
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
	 * @param upload
	 *            the upload to set
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
	 * @param uploadContentType
	 *            the uploadContentType to set
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
	 * @param uploadFileName
	 *            the uploadFileName to set
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
	 * @param savePath
	 *            the savePath to set
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
	 * @param ddlImportLx
	 *            the ddlImportLx to set
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
	 * @param fileServerPath
	 *            the fileServerPath to set
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
	 * @param txtFilePath
	 *            the txtFilePath to set
	 */
	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}

	/**
	 * @return the pgt12006List
	 */
	public ArrayList<Pgt00004> getPgt12006List() {
		return Pgt00004List;
	}

	/**
	 * @param pgt12006List
	 *            the pgt12006List to set
	 */
	public void setPgt00004List(ArrayList<Pgt00004> pgt00004List) {
		Pgt00004List = pgt00004List;
	}

	/**
	 * @return the processMsg
	 */
	public String getProcessMsg() {
		return processMsg;
	}

	/**
	 * @param processMsg
	 *            the processMsg to set
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
	 * @param processCent
	 *            the processCent to set
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
	 * @param excelStream
	 *            the excelStream to set
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

	public void setTabList(ArrayList<Pgv00004> tabList) {
		this.tabList = tabList;
	}

	public ArrayList<Pgv00004> getTabList() {
		return tabList;
	}

	/**
	 * @return the ebList
	 */
	public ArrayList<Pgv00004> getEbList() {
		return ebList;
	}

	/**
	 * @param ebList
	 *            the ebList to set
	 */
	public void setEbList(ArrayList<Pgv00004> ebList) {
		this.ebList = ebList;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}

	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArrayList<Pgt00004> getPgt00004List() {
		return Pgt00004List;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getTxtID() {
		return txtID;
	}

	public void setTxtID(String txtID) {
		this.txtID = txtID;
	}


	public String getMsgDel() {
		return msgDel;
	}

	public void setMsgDel(String msgDel) {
		this.msgDel = msgDel;
	}

	public String getChkDel() {
		return chkDel;
	}

	public void setChkDel(String chkDel) {
		this.chkDel = chkDel;
	}

	public String getTxtJSFIND() {
		return txtJSFIND;
	}

	public void setTxtJSFIND(String txtJSFIND) {
		this.txtJSFIND = txtJSFIND;
	}

	public String getTxtXSFIND() {
		return txtXSFIND;
	}

	public void setTxtXSFIND(String txtXSFIND) {
		this.txtXSFIND = txtXSFIND;
	}

	public String getTxtJS() {
		return txtJS;
	}

	public void setTxtJS(String txtJS) {
		this.txtJS = txtJS;
	}

	public String getTxtXS() {
		return txtXS;
	}

	public void setTxtXS(String txtXS) {
		this.txtXS = txtXS;
	}
	

}
