/**
 *
 */
package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00334cService;
import com.sunway.util.ConvertUtil;
import com.sunway.vo.Pgt00334c;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00334cAction extends ActionSupport {

	private static final long serialVersionUID = -4980799008811576555L;

	private IPgt00334cService t00334cService;
	private ArrayList<Pgt00334c> rows;
	private Pgt00334c t00334cBean;
	private String FCID;
	private String SLID;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {

		t00334cBean = new Pgt00334c();
		try {
			t00334cBean.setCd00302Fcid(ConvertUtil.encoding(FCID));
			t00334cBean.setCdSlid(ConvertUtil.encoding(SLID));
			rows = t00334cService.LoadAll(t00334cBean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		}

		return SUCCESS;
	}
	
	public String execute_B() throws Exception {

		t00334cBean = new Pgt00334c();
		try {
			t00334cBean.setCd00302Fcid(ConvertUtil.encoding(FCID));
			t00334cBean.setCdSlid(ConvertUtil.encoding(SLID));
			rows = t00334cService.LoadAll_B(t00334cBean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		}

		return SUCCESS;
	}

	/**************************** set and get *********************************/

	/**
	 * @param t00334cService the t00334cService to set
	 */
	public void setT00334cService(IPgt00334cService t00334cService) {
		this.t00334cService = t00334cService;
	}

	/**
	 * @return the t00334cService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00334cService getT00334cService() {
		return t00334cService;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgt00334c> rows) {
		this.rows = rows;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgt00334c> getRows() {
		return rows;
	}

	/**
	 * @param t00334cBean the t00334cBean to set
	 */
	public void setT00334cBean(Pgt00334c t00334cBean) {
		this.t00334cBean = t00334cBean;
	}

	/**
	 * @return the t00334cBean
	 */
	public Pgt00334c getT00334cBean() {
		return t00334cBean;
	}

	/**
	 * @param fCID the fCID to set
	 */
	public void setFCID(String fCID) {
		FCID = fCID;
	}

	/**
	 * @return the fCID
	 */
	public String getFCID() {
		return FCID;
	}

	/**
	 * @param sLID the sLID to set
	 */
	public void setSLID(String sLID) {
		SLID = sLID;
	}

	/**
	 * @return the sLID
	 */
	public String getSLID() {
		return SLID;
	}

}
