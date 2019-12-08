package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;
//import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPssd9Service;
//import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pssd;

/**
 *  取得PSSDAction
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pssd9Action extends ActionSupport {
	
	private static final long serialVersionUID = 1515719512857941542L;

	private IPssd9Service pssd9Service;
	
	private ArrayList<Pssd> pssdList;
	private String ddlPSSD;
	private String ddlSZQY;
	private String URL;
	//private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/**
	 *  根据所在区域选择PSSD
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String getPssdByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("getPssdByAjax() ********** start **********");
		}
		Pssd bean = new Pssd();
		
		try {
			////sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setSzqy(ddlSZQY);
			bean.setCurrentPssd("1");
			bean.setUrl(URL);
			pssdList = pssd9Service.LoadAllPssd(bean);
				
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("getPssdByAjax() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("getPssdByAjax() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 *  选择PSSD
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String getPssdByAjaxNoSzqy() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("getPssdByAjax() ********** start **********");
		}
		Pssd bean = new Pssd();
		
		try {
			////sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCurrentPssd("1");
			bean.setUrl(URL);
			pssdList = pssd9Service.LoadAllPssdNoSzqy(bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("getPssdByAjax() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("getPssdByAjax() ********** end **********");
		}
		return SUCCESS;
	}
	/*********************** set and get ******************************/
	

	/**
	 * @return the pssdList
	 */
	public ArrayList<Pssd> getPssdList() {
		return pssdList;
	}

	/**
	 * @param pssdList the pssdList to set
	 */
	public void setPssdList(ArrayList<Pssd> pssdList) {
		this.pssdList = pssdList;
	}

	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	/**
	 * @return the pssd9Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPssd9Service getPssd9Service() {
		return pssd9Service;
	}

	/**
	 * @param pssd9Service the pssd9Service to set
	 */
	public void setPssd9Service(IPssd9Service pssd9Service) {
		this.pssd9Service = pssd9Service;
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

}
