/**
 * 
 */
package com.sunway.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 数据报表
 * @author Lee
 *
 */

public class ReportAction extends ActionSupport {
	
	private static final long serialVersionUID = -4833980076254207305L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		return super.execute();
	}

	/**
	 * 户数情况表
	 * @return
	 */
	public String query(){
		return SUCCESS;
	}

}
