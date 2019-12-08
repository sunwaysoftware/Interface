/**
 * 
 */
package com.sunway.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.util.Common;

/**
 * @author Andy.Gao
 * 
 */
public class DbBackupAction extends ActionSupport {
	private static final long serialVersionUID = 4205330767290582192L;

	private String expCMD;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	@Override
	public void validate() {
		if (Common.isNullOrEmpty(expCMD))
			this.addActionError("系统备份参数未设置");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 進行數據備份
	 * 
	 * @return
	 * @throws Exception
	 */
	public String execBackup() throws Exception {
		Runtime rt = Runtime.getRuntime();
		Process processexp = null;
		try {
			Date dtSys = new Date();
			File checkFile=new File("c:\\DbBackup");
			if(!checkFile.exists())
				checkFile.mkdir();
			String dt = String.format("%tF ", dtSys) + String.format("%tT", dtSys);
			processexp = rt.exec(expCMD + " file=c:\\DbBackup\\DB" + dt + ".dmp");
			String line = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(processexp.getErrorStream()));
			// 读取信息很关键，这个解决了挂起的问题。
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br = new BufferedReader(new InputStreamReader(processexp
					.getInputStream()));
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

			if (processexp.waitFor() != 0) {
				System.err.println("exit value = " + processexp.exitValue());
			}
			processexp.destroy();
			this.addActionMessage("数据备份成功");
		} catch (IOException e) {
			this.addActionError("系统未提供备份命令接口，备份失败");
			return INPUT;
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}

	/** --------------------------- get and set -------------------------------- **/

	/**
	 * @param expCMD
	 *            the expCMD to set
	 */
	public void setExpCMD(String expCMD) {
		this.expCMD = expCMD;
	}

	/**
	 * @return the expCMD
	 */
	public String getExpCMD() {
		return expCMD;
	}

}
