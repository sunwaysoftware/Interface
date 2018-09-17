/**
 * 
 */
package com.sunway.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IFc003Service;

/**
 * @author Amani
 * 
 */
public class Fc003Action extends ActionSupport {

	private static final long serialVersionUID = 4786355070025940957L;
	private IFc003Service fc003Service;
	private File imgFile;
	private String id;
	private InputStream inputStream;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {

		InputStream is = new FileInputStream(imgFile);

		fc003Service.insData(1, "aaaaaa", "bbbbbbb", is);

		return SUCCESS;
	}

	public String viewImage() throws Exception {
		inputStream = fc003Service.readData(Integer.parseInt(id));
		return SUCCESS;
	}

	// --------------------------- set and get ----------------------------------

	/**
	 * @return the fc003Service
	 */
	public IFc003Service getFc003Service() {
		return fc003Service;
	}

	/**
	 * @param fc003Service
	 *            the fc003Service to set
	 */
	public void setFc003Service(IFc003Service fc003Service) {
		this.fc003Service = fc003Service;
	}

	/**
	 * @return the imgFile
	 */
	public File getImgFile() {
		return imgFile;
	}

	/**
	 * @param imgFile
	 *            the imgFile to set
	 */
	public void setImgFile(File imgFile) {
		this.imgFile = imgFile;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the inputStream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream the inputStream to set
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
