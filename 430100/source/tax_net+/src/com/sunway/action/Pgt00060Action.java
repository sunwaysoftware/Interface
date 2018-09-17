package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00060Service;
import com.sunway.util.CheckUtil;
import com.sunway.vo.Pgt00060;

/**
 * 通用选择控件
 * @author Light
 *
 */
public class Pgt00060Action extends ActionSupport{
	
	private IPgt00060Service t00060Service;
	private ArrayList<Pgt00060> rows;
	private String txtTableName;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3203884734495630555L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** start **********");
		}
		try{
			
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("execute() ********** end **********");
			}
			return INPUT;
		}finally{
			//
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 数据查询
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** start **********");
		}
		try{			
			rows = t00060Service.LoadAll(new Pgt00060(CheckUtil.chkTrim(txtTableName)));
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("query() ********** end **********");
			}
			return INPUT;
		}finally{
			//
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	
	
	/*******************************   set & get   *******************************/
	/**
	 * @return the t00060Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00060Service getT00060Service() {
		return t00060Service;
	}

	/**
	 * @param t00060Service the t00060Service to set
	 */
	public void setT00060Service(IPgt00060Service t00060Service) {
		this.t00060Service = t00060Service;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgt00060> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgt00060> rows) {
		this.rows = rows;
	}

	/**
	 * @return the txtTableName
	 */
	public String getTxtTableName() {
		return txtTableName;
	}

	/**
	 * @param txtTableName the txtTableName to set
	 */
	public void setTxtTableName(String txtTableName) {
		this.txtTableName = txtTableName;
	}

}
