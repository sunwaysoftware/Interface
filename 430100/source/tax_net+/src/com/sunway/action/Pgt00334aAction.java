/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00334aService;
import com.sunway.vo.Pgt00334a;

/**
 * 
 * 参与评税的实例库其它修正
 * @author Andy.Gao
 *
 */
public class Pgt00334aAction extends ActionSupport {
	private static final long serialVersionUID = 1661396104833995192L;
	private IPgt00334aService t00334aService;
	private ArrayList<Pgt00334a> rows;
	private String txtFCID;
	private String txtSLID;
	private String txtPSSD;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		
		try {
			rows = t00334aService.LoadAll(new Pgt00334a(txtFCID, txtSLID, txtPSSD));
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
	
	/************************** set and get *****************************/
	
	/**
	 * @param t00334aService the t00334aService to set
	 */
	public void setT00334aService(IPgt00334aService t00334aService) {
		this.t00334aService = t00334aService;
	}
	/**
	 * @return the t00334aService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00334aService getT00334aService() {
		return t00334aService;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgt00334a> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgt00334a> rows) {
		this.rows = rows;
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
	 * @return the txtSLID
	 */
	public String getTxtSLID() {
		return txtSLID;
	}

	/**
	 * @param txtSLID the txtSLID to set
	 */
	public void setTxtSLID(String txtSLID) {
		this.txtSLID = txtSLID;
	}

	/**
	 * @param txtPSSD the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}

	/**
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}
}
