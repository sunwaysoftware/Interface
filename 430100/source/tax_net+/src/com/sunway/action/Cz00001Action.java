/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ICz00001Service;
import com.sunway.vo.CZ00001;

/**
 * 
 * 操作类型
 * @author Andy.Gao
 *
 */
public class Cz00001Action extends ActionSupport {
	private static final long serialVersionUID = 6921568043463498648L;
	private ICz00001Service cz00001Service;
	private ArrayList<CZ00001> rows;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() - start");
		}

		try {
			rows = cz00001Service.LoadAll();
		} catch (Exception e) {
			LOG.error("execute()", e);

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() - end");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() - end");
		}
		return SUCCESS;
	}
	
	/************************** set and get ********************************/
	
	/**
	 * @param cz00001Service the cz00001Service to set
	 */
	public void setCz00001Service(ICz00001Service cz00001Service) {
		this.cz00001Service = cz00001Service;
	}
	
	/**
	 * @return the cz00001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ICz00001Service getCz00001Service() {
		return cz00001Service;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<CZ00001> rows) {
		this.rows = rows;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<CZ00001> getRows() {
		return rows;
	}
}
