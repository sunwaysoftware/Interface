/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgvCz00006Service;
import com.sunway.vo.PgvCz00006;

/**
 * 
 * 变更类型
 * @author Andy.Gao
 *
 */
public class PgvCz00006Action extends ActionSupport {
	private static final long serialVersionUID = -7045491109003747243L;
	private IPgvCz00006Service cz00006Service;
	private ArrayList<PgvCz00006> tabList;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 读取[变更类型]修改
	 * @return
	 * @throws Exception
	 */
	public String queryByUpdate() throws Exception {
		tabList = cz00006Service.LoadByUpdate();
		return SUCCESS;	
	}
	
	/**
	 * 读取[变更类型]删除
	 * @return
	 * @throws Exception
	 */
	public String queryByDelete() throws Exception {
		tabList = cz00006Service.LoadByDelete();
		return SUCCESS;	
	}
	
	/*********************** set and get ***************************/
	
	/**
	 * @param cz00006Service the cz00006Service to set
	 */
	public void setCz00006Service(IPgvCz00006Service cz00006Service) {
		this.cz00006Service = cz00006Service;
	}
	
	/**
	 * @return the cz00006Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgvCz00006Service getCz00006Service() {
		return cz00006Service;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<PgvCz00006> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<PgvCz00006> getTabList() {
		return tabList;
	}
}