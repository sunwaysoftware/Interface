/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ICL02090Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.BF00000;
import com.sunway.vo.Pgv02031;

/**
 * 
 * 【契税申报通知单】及【交税认定处理】
 * @author Andy.Gao
 *
 */
public class CL02090Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7363543579783999448L;
	private ICL02090Service cl02090Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private ArrayList<Pgv02031> rows;
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
	public String execute02091() throws Exception {
		return SUCCESS;
	}

	/**
	 * 查询打印的数据列表
	 * @return
	 * @throws Exception
	 */
	public String query02091() throws Exception {
		
		Pgv02031 v02031 = new Pgv02031();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v02031.setZjhm(FormatUtil.toSearchLike(txtSWIDFind));
			v02031.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v02031.setFcslh(txtFCSLHFind);
			v02031.setPageIndex(pageIndex);
			v02031.setPageSize(getPageSize());
			v02031.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v02031.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = cl02090Service.LoadSb(v02031);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
				
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error("CL02090Action -- query02091()", e);
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
	public String execute02092() throws Exception {
		return SUCCESS;
	}

	/**
	 * 查询待认定的数据列表
	 * @return
	 * @throws Exception
	 */
	public String query02092() throws Exception {
		
		Pgv02031 v02031 = new Pgv02031();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v02031.setZjhm(FormatUtil.toSearchLike(txtSWIDFind));
			v02031.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v02031.setCd02002Fcid(FCID);
			v02031.setPageIndex(pageIndex);
			v02031.setPageSize(getPageSize());
			v02031.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v02031.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = cl02090Service.LoadJs(v02031);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error("CL02090Action -- query02092()", e);
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
	public String exec02092RD() throws Exception {
		Pgv02031 v02031 = new Pgv02031();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v02031.setCd02002Fcid(ConvertUtil.encoding(FCID));
			v02031.setCzr(sessionCtrl.getUserId());
			v02031.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			RD = cl02090Service.execRD(v02031);
		} catch (Exception e) {
			LOG.error("CL02090Action -- exec02092RD()", e);
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
	public String exec02091TZS() throws Exception {
		BF00000 bf00000 = new BF00000();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			bf00000.setFcid(ConvertUtil.encoding(FCID));
			bf00000.setCzr(sessionCtrl.getUserId());
			bf00000.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bf00000.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGXNM));
			//执行查询
			bf00000List = cl02090Service.execTzs(bf00000);
		} catch (Exception e) {
			LOG.error("CL02090Action -- exec02091TZS()", e);
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;			
	}
	
	/******************************* set and get ***********************************/
	
	/**
	 * @param cl02090Service the cl02090Service to set
	 */
	public void setcl02090Service(ICL02090Service cl02090Service) {
		this.cl02090Service = cl02090Service;
	}

	/**
	 * @return the cl02090Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ICL02090Service getcl02090Service() {
		return cl02090Service;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv02031> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv02031> rows) {
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

	/**
	 * @return the cl02090Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ICL02090Service getCl02090Service() {
		return cl02090Service;
	}

	/**
	 * @param cl02090Service the cl02090Service to set
	 */
	public void setCl02090Service(ICL02090Service cl02090Service) {
		this.cl02090Service = cl02090Service;
	}	

}
