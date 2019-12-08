/**
 * 
 */
package com.sunway.action;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12002fService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.DwindlePic;
import com.sunway.util.FileUpload;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12002f;
import com.sunway.vo.Pgv12002f;

/**
 * 
 * 土地相关照片
 * @author Andy.Gao
 *
 */
public class Pgt12002fAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 8436236294136311930L;
	private IPgt12002fService t12002fService;
	private String ACT;
	private ArrayList<Pgv12002f> zplxList;
	private ArrayList<Pgv12002f> tabList;
	private Pgt12002f t12002fBean;
	private String savePath;
	private File txtFile;
	private String txtSWID;
	private String txtDCID;
	private String txtFileFileName;
	private String txtZPID;
	private String txtZPLX;
	private String txtNote;
	private String PATH;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		try {
			//讀取"照片類型"
			ReadInfo();
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}

	/**
	 * 查询列表
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgt12002f t12002f = new Pgt12002f();
		t12002f.setCd12002Dcid(txtDCID);
		try {
			tabList = t12002fService.LoadAll(t12002f);
			if(tabList.size()>0)
				PATH = tabList.get(0).getZplj();
		} catch (Exception e) {
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 验证文件上传
	 */
	public void validateCreate() {
		if(this.hasErrors()){
			this.clearErrorsAndMessages();
			this.addActionError(getText("app.msg.error.fileupload"));
		}		
		//讀取"照片類型"
		try {
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}
	
	/**
	 * 保存地產圖片信息
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********"+Common.getCurrentTime());
		}
		FileUpload fileUpload = new FileUpload();
		DwindlePic mypic = new DwindlePic();
		String fileServerPath = null;
		String shortFileName = "min" + txtFileFileName;
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			fileServerPath = ServletActionContext.getServletContext().getRealPath(savePath+ "\\" +txtDCID) + "\\";
			//文件上傳處理
			fileUpload.setFile(txtFile);
			fileUpload.setFileName(txtFileFileName);
			fileUpload.setFileServerPath(fileServerPath);
			if (!fileUpload.upload()) {
				throw new Exception(getText("app.msg.error.fileupload"));
			} ;
			//生成縮略圖
			if(!mypic.s_pic(fileServerPath+txtFileFileName, fileServerPath + shortFileName, false)){
				throw new Exception(getText("app.msg.error.filezoomout"));
			}
			//文件信息入庫
			Pgt12002f t12002f = new Pgt12002f();
			t12002f.setCd12002Dcid(txtDCID);
			t12002f.setZplx(Common.convertToInteger(txtZPLX)); 
			t12002f.setZplj(savePath + "/" + txtDCID + "/" + txtFileFileName);
			t12002f.setZpljMin(savePath + "/" + txtDCID + "/" + shortFileName);
			t12002f.setNote(txtNote);
			t12002f.setCd00002Czr(sessionCtrl.getUserId());
			if(t12002fService.GetInsertCommand(t12002f))
				this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t12002f.getCd12002Dcid().toString()}));
			else
				this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t12002f.getCd12002Dcid().toString()}));
		}catch(Exception ex){
			this.addActionError(ex.getMessage());
			return INPUT;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********"+Common.getCurrentTime());
		}
		return SUCCESS;
		
	}
	
	/**
	 * 验证文件上传
	 */
	public void validateUpdate() {
		this.clearErrorsAndMessages();
		Pgt12002f t12002f = new Pgt12002f();
		try {
			t12002f.setZpid(BigDecimal.valueOf(Common.convertToDouble(txtZPID)));
			t12002fBean = t12002f;
			//讀取"照片類型"
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
		}
	}
	
	/**
	 * 刪除地產圖片信息
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		
		try {
			if(t12002fService.GetDeleteCommand(t12002fBean))
				this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t12002fBean.getZpid().toString()}));
			else
				this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t12002fBean.getZpid().toString()}));
		} catch (Exception e) {
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return INPUT;
		}		

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 讀取"照片類型"
	 */
	private void ReadInfo() throws Exception {
		zplxList = t12002fService.LoadZplxList();
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	/**
	 * @return the savePath
	 */
	public String getSavePath() {
		return savePath;
	}
	
	/**
	 * @return the txtFile
	 */
	public File getTxtFile() {
		return txtFile;
	}


	/**
	 * @param txtFile the txtFile to set
	 */
	public void setTxtFile(File txtFile) {
		this.txtFile = txtFile;
	}


	/**
	 * @return the txtFileFileName
	 */
	public String getTxtFileFileName() {
		return txtFileFileName;
	}


	/**
	 * @param txtFileFileName the txtFileFileName to set
	 */
	public void setTxtFileFileName(String txtFileFileName) {
		this.txtFileFileName = txtFileFileName;
	}

	/**
	 * @param t12002fService the t12002fService to set
	 */
	public void setT12002fService(IPgt12002fService t12002fService) {
		this.t12002fService = t12002fService;
	}

	/**
	 * @return the t12002fService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12002fService getT12002fService() {
		return t12002fService;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12002f> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv12002f> getTabList() {
		return tabList;
	}

	/**
	 * @param txtDCID the txtDCID to set
	 */
	public void setTxtDCID(String txtDCID) {
		this.txtDCID = txtDCID;
	}

	/**
	 * @return the txtDCID
	 */
	public String getTxtDCID() {
		return txtDCID;
	}

	/**
	 * @param txtZPID the txtZPID to set
	 */
	public void setTxtZPID(String txtZPID) {
		this.txtZPID = txtZPID;
	}

	/**
	 * @return the txtZPID
	 */
	public String getTxtZPID() {
		return txtZPID;
	}

	/**
	 * @param t12002fBean the t12002fBean to set
	 */
	public void setT12002fBean(Pgt12002f t12002fBean) {
		this.t12002fBean = t12002fBean;
	}

	/**
	 * @return the t12002fBean
	 */
	public Pgt12002f getT12002fBean() {
		return t12002fBean;
	}

	/**
	 * @param zplxList the zplxList to set
	 */
	public void setZplxList(ArrayList<Pgv12002f> zplxList) {
		this.zplxList = zplxList;
	}

	/**
	 * @return the zplxList
	 */
	public ArrayList<Pgv12002f> getZplxList() {
		return zplxList;
	}

	/**
	 * @param txtZPLX the txtZPLX to set
	 */
	public void setTxtZPLX(String txtZPLX) {
		this.txtZPLX = txtZPLX;
	}

	/**
	 * @return the txtZPLX
	 */
	public String getTxtZPLX() {
		return txtZPLX;
	}

	/**
	 * @param txtNote the txtNote to set
	 */
	public void setTxtNote(String txtNote) {
		this.txtNote = txtNote;
	}

	/**
	 * @return the txtNote
	 */
	public String getTxtNote() {
		return txtNote;
	}

	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @param txtSWID the txtSWID to set
	 */
	public void setTxtSWID(String txtSWID) {
		this.txtSWID = txtSWID;
	}

	/**
	 * @return the txtSWID
	 */
	public String getTxtSWID() {
		return txtSWID;
	}

	/**
	 * @param pATH the pATH to set
	 */
	public void setPATH(String pATH) {
		PATH = pATH;
	}

	/**
	 * @return the pATH
	 */
	public String getPATH() {
		return PATH;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}





}
