/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ICL00390Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.BF00000;
import com.sunway.vo.Pgv00331;

/**
 * 
 * 【契税申报通知单】及【交税认定处理】
 * @author Andy.Gao
 *
 */
public class CL00390Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -9160010120501363861L;
	private ICL00390Service cl00390Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private ArrayList<Pgv00331> rows;
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFCSLHFind;
	private Boolean RD;
	private String FCID;
	private ArrayList<BF00000> bf00000List;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#validate()
	 */
	@Override
	public void validate() {
		super.validate();
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	/**
	 * 转向[契税申报通知单]
	 * @return
	 * @throws Exception
	 */
	public String execute00391() throws Exception {
		return SUCCESS;
	}

	/**
	 * 查询打印的数据列表
	 * @return
	 * @throws Exception
	 */
	public String query00391() throws Exception {
		
		Pgv00331 v00331 = new Pgv00331();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00331.setCd00301Swid(FormatUtil.toSearchLike(txtSWIDFind));
			v00331.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v00331.setFcslh(txtFCSLHFind);
			v00331.setPageIndex(pageIndex);
			v00331.setPageSize(getPageSize());
			v00331.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00331.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = cl00390Service.LoadSb(v00331);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
				
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error("CL00390Action -- query00391()", e);
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;			
	}
	
	/**
	 * 转向[交税认定处理]
	 * @return
	 * @throws Exception
	 */
	public String execute00392() throws Exception {
		return SUCCESS;
	}

	/**
	 * 查询待认定的数据列表
	 * @return
	 * @throws Exception
	 */
	public String query00392() throws Exception {
		
		Pgv00331 v00331 = new Pgv00331();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00331.setCd00301Swid(FormatUtil.toSearchLike(txtSWIDFind));
			v00331.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v00331.setCd00302Fcid(FCID);
			v00331.setPageIndex(pageIndex);
			v00331.setPageSize(getPageSize());
			v00331.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00331.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = cl00390Service.LoadJs(v00331);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error("CL00390Action -- query00392()", e);
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;			
	}
	
	/**
	 * 查询待认定的数据列表
	 * @return
	 * @throws Exception
	 */
	public String exec00392RD() throws Exception {
		Pgv00331 v00331 = new Pgv00331();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00331.setCd00302Fcid(ConvertUtil.encoding(FCID));
			v00331.setCzr(sessionCtrl.getUserId());
			v00331.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			RD = cl00390Service.execRD(v00331);
		} catch (Exception e) {
			LOG.error("CL00390Action -- exec00392RD()", e);
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;			
	}
	
	/**
	 * 打印通知书
	 * @return
	 * @throws Exception
	 */
	public String exec00391TZS() throws Exception {
		BF00000 bf00000 = new BF00000();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			bf00000.setFcid(ConvertUtil.encoding(FCID));
			bf00000.setCzr(sessionCtrl.getUserId());
			bf00000.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bf00000.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGXNM));
			//执行查询
			bf00000List = cl00390Service.execTzs(bf00000);
		} catch (Exception e) {
			LOG.error("CL00390Action -- exec00391TZS()", e);
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;			
	}
	
	/******************************* set and get ***********************************/
	
	/**
	 * @param cl00390Service the cl00390Service to set
	 */
	public void setCl00390Service(ICL00390Service cl00390Service) {
		this.cl00390Service = cl00390Service;
	}

	/**
	 * @return the cl00390Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ICL00390Service getCl00390Service() {
		return cl00390Service;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv00331> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00331> rows) {
		this.rows = rows;
	}

	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}	

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the txtSWIDFind
	 */
	public String getTxtSWIDFind() {
		return txtSWIDFind;
	}

	/**
	 * @param txtSWIDFind the txtSWIDFind to set
	 */
	public void setTxtSWIDFind(String txtSWIDFind) {
		this.txtSWIDFind = txtSWIDFind;
	}

	/**
	 * @return the txtNSRMCFind
	 */
	public String getTxtNSRMCFind() {
		return txtNSRMCFind;
	}

	/**
	 * @param txtNSRMCFind the txtNSRMCFind to set
	 */
	public void setTxtNSRMCFind(String txtNSRMCFind) {
		this.txtNSRMCFind = txtNSRMCFind;
	}

	/**
	 * @return the rD
	 */
	public Boolean getRD() {
		return RD;
	}

	/**
	 * @param rD the rD to set
	 */
	public void setRD(Boolean rD) {
		RD = rD;
	}

	/**
	 * @return the fCID
	 */
	public String getFCID() {
		return FCID;
	}

	/**
	 * @param fCID the fCID to set
	 */
	public void setFCID(String fCID) {
		FCID = fCID;
	}

	/**
	 * @param bf00000List the bf00000List to set
	 */
	public void setBf00000List(ArrayList<BF00000> bf00000List) {
		this.bf00000List = bf00000List;
	}

	/**
	 * @return the bf00000List
	 */
	public ArrayList<BF00000> getBf00000List() {
		return bf00000List;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	public String getTxtFCSLHFind() {
		return txtFCSLHFind;
	}

	public void setTxtFCSLHFind(String txtFCSLHFind) {
		this.txtFCSLHFind = txtFCSLHFind;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}	

}
