/**
 * 
 */
package com.sunway.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.util.FileUpload;

/**
 * @author Andy.Gao
 *
 */
public class FileUploadAction extends ActionSupport {
	private static final long serialVersionUID = 8436236294136311930L;

	//file upload
    private String title;   
    // 用File数组来封装多个上传文件域对象   
    private File upload;   
    // 用String数组来封装多个上传文件名   
    private String uploadFileName;   
    // 用String数组来封装多个上传文件类型   
    private String uploadContentType;   
    // 保存文件的目录路径(通过依赖注入)   
    private String savePath; 
    private String filePath;
    private Integer txtTABLE;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 文件上传
	 * @return
	 * @throws Exception
	 */
	public String fileUpload() throws Exception {
		FileUpload fileUpload = new FileUpload();
		//文件上傳處理
		fileUpload.setFile(upload);
		fileUpload.setFileName(uploadFileName);
		fileUpload.setFileServerPath(getSavePath());
		if (!fileUpload.upload()) {
			throw new Exception(getText("app.msg.error.fileupload"));
		};
		filePath = getSavePath() + uploadFileName;
		return SUCCESS;
	}
	
	/**
	 * 數據整理及導入
	 * @return
	 * @throws Exception
	 */
	public String importData() throws Exception {
		
		switch (txtTABLE) {
		case 1:
			
			break;
		case 303:
			
			break;
		case 0:
			
			break;			
		default:
			break;
		}
		return SUCCESS;
	}
	
	
	
	
	
	
	/**************************** get and set *********************************/

	/**
	 * @param savePath the savePath to set
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	/**
	 * @return the savePath
	 */
	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
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
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param txtTABLE the txtTABLE to set
	 */
	public void setTxtTABLE(Integer txtTABLE) {
		this.txtTABLE = txtTABLE;
	}

	/**
	 * @return the txtTABLE
	 */
	public Integer getTxtTABLE() {
		return txtTABLE;
	}

}
