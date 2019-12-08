package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00005Service;
import com.sunway.util.Common;
import com.sunway.vo.Pgv00005;

/**
 * 用户组与功能权限关系(Pgt00005)
 * @author Lee
 * @version 1.0
 */

public class Pgt00005Action extends ActionSupport {

	private static final long serialVersionUID = 6214004601495620373L;
	//Service
	private IPgt00005Service t00005Service;
	//Bean数组
	private ArrayList<Pgv00005> rightList;
	private String ROLEID;

	/**
	 * 根据用户组取得对应权限
	 * @return
	 * @throws Exception
	 */
	public String getRight()throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("getRight() ********** start **********");
		}
		Pgv00005 v00005 = new Pgv00005();
		try {
			v00005.setCd00003Roleid(Common.convertEncoding(ROLEID));
			rightList = t00005Service.LoadT000052(v00005);
		} catch (Exception e) {
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("getRight() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** set and get ******************************/

	/**
	 * @return the t00005Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00005Service getT00005Service() {
		return t00005Service;
	}
	/**
	 * @param t00005Service the t00005Service to set
	 */
	public void setT00005Service(IPgt00005Service t00005Service) {
		this.t00005Service = t00005Service;
	}
	/**
	 * @return the rightList
	 */
	public ArrayList<Pgv00005> getRightList() {
		return rightList;
	}
	/**
	 * @param rightList the rightList to set
	 */
	public void setRightList(ArrayList<Pgv00005> rightList) {
		this.rightList = rightList;
	}
	/**
	 * @return the rOLEID
	 */
	public String getROLEID() {
		return ROLEID;
	}
	/**
	 * @param rOLEID the rOLEID to set
	 */
	public void setROLEID(String rOLEID) {
		ROLEID = rOLEID;
	}
}
