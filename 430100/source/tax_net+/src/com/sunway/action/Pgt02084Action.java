/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02084Service;
import com.sunway.util.Common;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02084;

/**
 * @author Andy.Gao
 *
 */
public class Pgt02084Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1197509168773300853L;

	private IPgt02084Service t02084Service;
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv02084> rows;
	private String FCID;
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private String type;
	private String ddlSZQY;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
	/**
	 * 查询处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		
		Pgv02084 bean = new Pgv02084();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCd02002Fcid(FCID);
			bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bean.setShlx(ConvertUtil.toInteger(type));
			rows = getT02084Service().LoadAll(bean);		
			
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

	/**
	 * 转向待办原因
	 * @return
	 * @throws Exception
	 */
	public String executeYY() throws Exception {
		ReadInfo();
		return SUCCESS;
	}
	
	/**
	 * 读取待办原因
	 * @return
	 * @throws Exception
	 */
	public String loadYY() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("loadYY() ********** start **********");
		}
		
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			Pgv02084 bean = new Pgv02084();
			bean.setCd00001Szqy(ddlSZQY);
			bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			rows = getT02084Service().LoadYY(bean);			
		} catch (Exception e) {
			LOG.error("loadYY()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("loadYY() ********** end **********");
			}			
			return INPUT;
		}		

		if (LOG.isDebugEnabled()) {
			LOG.debug("loadYY() ********** end **********");
		}
		return SUCCESS;		
	}
	/**
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	
	/**
	 * 全面评估估价待办
	 * @return
	 * @throws Exception
	 */
	public String executeT02020()throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeT02020() ********** start **********");
		}
		
		Pgv02084 bean = new Pgv02084();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCd02002Fcid(FCID);
			bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bean.setShlx(ConvertUtil.toInteger(type));
			rows = getT02084Service().LoadQMPG(bean);		
			
		} catch (Exception e) {
			LOG.error("execute()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeT02020() ********** end **********");
			}			
			return INPUT;
		}		

		if (LOG.isDebugEnabled()) {
			LOG.debug("executeT02020() ********** end **********");
		}
		return SUCCESS;
	}
	/*********************** set and get ******************************/
	
	/**
	 * @param t02084Service the t02084Service to set
	 */
	public void setT02084Service(IPgt02084Service t02084Service) {
		this.t02084Service = t02084Service;
	}

	/**
	 * @return the t02084Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02084Service getT02084Service() {
		return t02084Service;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv02084> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv02084> rows) {
		this.rows = rows;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}

	public String getDdlSZQY() {
		return ddlSZQY;
	}

	/**
	 * @return the sessionCtrl
	 */
	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	/**
	 * @param sessionCtrl the sessionCtrl to set
	 */
	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getTotal() {
		return total;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

	public String getFCID() {
		return FCID;
	}

	public void setFCID(String fCID) {
		FCID = fCID;
	}
	
}
