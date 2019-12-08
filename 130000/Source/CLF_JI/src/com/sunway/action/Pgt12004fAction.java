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
import com.sunway.service.IPgt12004fService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.DwindlePic;
import com.sunway.util.FileUpload;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12004f;
import com.sunway.vo.Pgv12004f;

/**
 * 
 * 房產明細相关照片
 * @author Andy.Gao
 *
 */
public class Pgt12004fAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -3729904322302928439L;
	private IPgt12004fService t12004fService;
	private ArrayList<Pgv12004f> zplxList;
	private ArrayList<Pgv12004f> tabList;
	private Pgt12004f t12004fBean;
	private String savePath;
	private File txtFile;
	private String ACT;
	private String txtFCID;
	private String txtMXID;
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

		Pgt12004f t12004f = new Pgt12004f();
		t12004f.setCd12004Mxid(txtMXID);
		try {
			tabList = t12004fService.LoadAll(t12004f);
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
			fileServerPath = ServletActionContext.getServletContext().getRealPath(savePath+ "\\" + txtMXID)+"\\";
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
			Pgt12004f t12004f = new Pgt12004f();
			t12004f.setCd12004Mxid(txtMXID);
			t12004f.setZplx(Common.convertToInteger(txtZPLX)); 
			t12004f.setZplj(savePath + "/" + txtMXID + "/" + txtFileFileName);
			t12004f.setZpljMin(savePath + "/" + txtMXID + "/" + shortFileName);
			t12004f.setNote(txtNote);
			t12004f.setCd00002Czr(sessionCtrl.getUserId());
			if(t12004fService.GetInsertCommand(t12004f))
				this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t12004f.getCd12004Mxid().toString()}));
			else
				this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t12004f.getCd12004Mxid().toString()}));
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
		Pgt12004f t12004f = new Pgt12004f();
		try {
			t12004f.setZpid(BigDecimal.valueOf(Common.convertToDouble(txtZPID)));
			t12004fBean = t12004f;
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
			if(t12004fService.GetDeleteCommand(t12004fBean))
				this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t12004fBean.getZpid().toString()}));
			else
				this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t12004fBean.getZpid().toString()}));
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
		zplxList = t12004fService.LoadZplxList();
	}	
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t12004fService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12004fService getT12004fService() {
		return t12004fService;
	}

	/**
	 * @param t12004fService the t12004fService to set
	 */
	public void setT12004fService(IPgt12004fService t12004fService) {
		this.t12004fService = t12004fService;
	}

	/**
	 * @return the zplxList
	 */
	public ArrayList<Pgv12004f> getZplxList() {
		return zplxList;
	}

	/**
	 * @param zplxList the zplxList to set
	 */
	public void setZplxList(ArrayList<Pgv12004f> zplxList) {
		this.zplxList = zplxList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv12004f> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12004f> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the t12004fBean
	 */
	public Pgt12004f getT12004fBean() {
		return t12004fBean;
	}

	/**
	 * @param t12004fBean the t12004fBean to set
	 */
	public void setT12004fBean(Pgt12004f t12004fBean) {
		this.t12004fBean = t12004fBean;
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
	 * @return the txtMXID
	 */
	public String getTxtMXID() {
		return txtMXID;
	}

	/**
	 * @param txtMXID the txtMXID to set
	 */
	public void setTxtMXID(String txtMXID) {
		this.txtMXID = txtMXID;
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
	 * @param txtFCID the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}

	/**
	 * @return the txtFCID
	 */
	public String getTxtFCID() {
		return txtFCID;
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
