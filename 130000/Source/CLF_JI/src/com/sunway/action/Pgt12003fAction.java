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
import com.sunway.service.IPgt12003fService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.DwindlePic;
import com.sunway.util.FileUpload;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12003f;
import com.sunway.vo.Pgv12003f;

/**
 * 
 * 房產相关照片
 * @author Andy.Gao
 *
 */
public class Pgt12003fAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -5321864304955005501L;
	private IPgt12003fService t12003fService;
	private ArrayList<Pgv12003f> zplxList;
	private ArrayList<Pgv12003f> tabList;
	private Pgt12003f t12003fBean;
	private String savePath;
	private String ACT;
	private File txtFile;
	private String txtDCID;
	private String txtFCID;
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
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			//讀取"照片類型"
			ReadInfo();
		} catch (Exception e) {
			LOG.error("execute()", e);

			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
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

		Pgt12003f t12003f = new Pgt12003f();
		t12003f.setCd12003Fcid(txtFCID);
		try {
			tabList = t12003fService.LoadAll(t12003f);
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
			fileServerPath = ServletActionContext.getServletContext().getRealPath(savePath + "\\" + txtFCID)+"\\";
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
			Pgt12003f t12003f = new Pgt12003f();
			t12003f.setCd12003Fcid(txtFCID);
			t12003f.setZplx(Common.convertToInteger(txtZPLX)); 
			t12003f.setZplj(savePath + "/" + txtFCID + "/" + txtFileFileName);
			t12003f.setZpljMin(savePath + "/" + txtFCID + "/" + shortFileName);
			t12003f.setNote(txtNote);
			t12003f.setCd00002Czr(sessionCtrl.getUserId());
			if(t12003fService.GetInsertCommand(t12003f))
				this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t12003fBean.getCd12003Fcid().toString()}));
			else
				this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t12003fBean.getCd12003Fcid().toString()}));
		}catch(Exception e){
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********"+Common.getCurrentTime());
			}			
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
		Pgt12003f t12003f = new Pgt12003f();
		try {
			t12003f.setZpid(BigDecimal.valueOf(Common.convertToDouble(txtZPID)));
			t12003fBean = t12003f;
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
			if(t12003fService.GetDeleteCommand(t12003fBean))
				this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t12003fBean.getZpid().toString()}));
			else
				this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t12003fBean.getZpid().toString()}));
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
	 * 讀取"照片類型"
	 */
	private void ReadInfo() throws Exception {
		zplxList = t12003fService.LoadZplxList();
	}

	/*********************** set and get ******************************/
	
	/**
	 * @return the t12003fService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12003fService getT12003fService() {
		return t12003fService;
	}

	/**
	 * @param t12003fService the t12003fService to set
	 */
	public void setT12003fService(IPgt12003fService t12003fService) {
		this.t12003fService = t12003fService;
	}

	/**
	 * @return the zplxList
	 */
	public ArrayList<Pgv12003f> getZplxList() {
		return zplxList;
	}

	/**
	 * @param zplxList the zplxList to set
	 */
	public void setZplxList(ArrayList<Pgv12003f> zplxList) {
		this.zplxList = zplxList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv12003f> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12003f> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the t12003fBean
	 */
	public Pgt12003f getT12003fBean() {
		return t12003fBean;
	}

	/**
	 * @param t12003fBean the t12003fBean to set
	 */
	public void setT12003fBean(Pgt12003f t12003fBean) {
		this.t12003fBean = t12003fBean;
	}

	/**
	 * @return the savePath
	 */
	public String getSavePath() {
		return savePath;
	}

	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
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
	 * @return the txtFCID
	 */
	public String getTxtFCID() {
		return txtFCID;
	}

	/**
	 * @param txtFCID the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
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
	 * @return the txtZPID
	 */
	public String getTxtZPID() {
		return txtZPID;
	}

	/**
	 * @param txtZPID the txtZPID to set
	 */
	public void setTxtZPID(String txtZPID) {
		this.txtZPID = txtZPID;
	}

	/**
	 * @return the txtZPLX
	 */
	public String getTxtZPLX() {
		return txtZPLX;
	}

	/**
	 * @param txtZPLX the txtZPLX to set
	 */
	public void setTxtZPLX(String txtZPLX) {
		this.txtZPLX = txtZPLX;
	}

	/**
	 * @return the txtNote
	 */
	public String getTxtNote() {
		return txtNote;
	}

	/**
	 * @param txtNote the txtNote to set
	 */
	public void setTxtNote(String txtNote) {
		this.txtNote = txtNote;
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
