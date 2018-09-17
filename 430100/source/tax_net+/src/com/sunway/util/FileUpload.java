/**
 * 
 */
package com.sunway.util;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.io.FileUtils;

/**
 * 
 * 文件上傳
 * @author Andy.Gao
 *
 */
public class FileUpload implements Serializable {
	private static final long serialVersionUID = -4609740354699966503L;
	private String fileServerPath;
	private String fileName;
	private File file;
	
	//構造
	public FileUpload (){
		fileServerPath = "";
		fileName = "";
		file = null;
	}
	
	/**
	 * 執行上傳文件
	 * @return T.成功; F.失敗
	 */
	public Boolean upload(){
		Boolean resultValue = false;
		
		//文件上傳處理
		File saveFile = new File(new File(fileServerPath), fileName);
			
		try {
			//建立文件路徑
			if(!saveFile.getParentFile().exists())
				saveFile.getParentFile().mkdirs();
			//復制文件
			FileUtils.copyFile(file, saveFile);
			resultValue = true;
		} catch (IOException e) {
			resultValue = false;
		} 
		return resultValue;
	}

	/*********************** set and get ******************************/

	/**
	 * @param fileServerPath the fileServerPath to set
	 */
	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
	}


	/**
	 * @return the fileServerPath
	 */
	public String getFileServerPath() {
		return fileServerPath;
	}


	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}


	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}


	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}
	
}
