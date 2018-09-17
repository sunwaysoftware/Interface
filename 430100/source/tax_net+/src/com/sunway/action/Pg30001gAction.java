/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPg30001gService;
import com.sunway.service.IPgt00331Service;
import com.sunway.service.IPgt00332Service;
import com.sunway.service.IPgt00384Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00331;
import com.sunway.vo.Pgt00332;
import com.sunway.vo.Pgv00331;
import com.sunway.vo.Pgv00384;

/**
 * 
 * 个案评税[市場法]
 * @author Andy.Gao
 * @category 个案评税
 *
 */
public class Pg30001gAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -4510149035671426914L;
	private IPg30001gService g30001Service;
	private IPgt00332Service t00332Service;
	private IPgt00384Service t00384Service;
	private IPgt00331Service t00331Service;
	private ArrayList<Pgv00384> ngMxList;
	private ArrayList<Pgv00331> rows;
	private Pgt00332 t00332Bean;
	private Pgt00331 t00331Bean;
	// VIEW
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFCIDFind;
	private String txtFCID;
	private String txtSLID;
	private String txtSWID;
	private SessionCtrl sessionCtrl = new SessionCtrl();

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00331 v00331 = new Pgv00331();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00331.setCd00301Swid(FormatUtil.toSearchLike(txtSWIDFind));
			v00331.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v00331.setCd00302Fcid(CheckUtil.chkTrim(txtFCIDFind));
			v00331.setPageIndex(pageIndex);
			v00331.setPageSize(getPageSize());
			v00331.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00331.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = g30001Service.LoadPgMx(v00331);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error("Pg30001gAction -- query()", e);
			this.addActionError(e.getMessage());
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 市場法個案評估
	 * @return
	 * @throws Exception
	 */
	/**
	 * 市場法個案評估
	 * @return
	 * @throws Exception
	 */
	public String execPG() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execPG() ********** start **********");
		}
		
		//Pgv00331 v00331 = new Pgv00331();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			/*v00331.setCd00002Pssd(ConvertUtil.toUtilDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v00331.setCd00302Fcid(txtFCID);
			v00331.setSlid(txtSLID);
			v00331.setPgCzr(sessionCtrl.getUserId());
			if(!g30001Service.GetPgCommand(v00331)){
				Pgv00384 e = new Pgv00384();
				e.setCd00302Fcid(txtFCID);
				e.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				ngMxList = t00384Service.LoadAll(e);							
				throw new RuntimeErrorException(null, "<a href=\"javascript:showWin(\'"+txtSWID+"\')\" onmouseover=\"TagToTip('errInfo')\" onmouseout=\"UnTip()\" >评税失败</a>");
			}*/
			Pgt00331 t00331 = new Pgt00331();
			t00331.setCd00302Fcid(ConvertUtil.encoding(txtFCID));
			t00331Bean = t00331Service.LoadByPrimaryKey(t00331);
//			t00332Bean = t00332Service.LoadByPrimaryKey(new Pgt00332(txtFCID, sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD)));
		}catch (Exception e) {
			LOG.error("Pg30001gAction -- execPG()", e);
			this.addActionError(e.getMessage());		
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("execPG() ********** end **********");
		}
		return SUCCESS;
	}
	
	/******************************* set and get *************************************/
	
	/**
	 * @return the g30001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPg30001gService getG30001Service() {
		return g30001Service;
	}

	/**
	 * @param g30001Service the g30001Service to set
	 */
	public void setG30001Service(IPg30001gService g30001Service) {
		this.g30001Service = g30001Service;
	}

	/**
	 * @param t00332Service the t00332Service to set
	 */
	public void setT00332Service(IPgt00332Service t00332Service) {
		this.t00332Service = t00332Service;
	}

	/**
	 * @return the t00332Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00332Service getT00332Service() {
		return t00332Service;
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
	 * @return the txtFCIDFind
	 */
	public String getTxtFCIDFind() {
		return txtFCIDFind;
	}

	/**
	 * @param txtFCIDFind the txtFCIDFind to set
	 */
	public void setTxtFCIDFind(String txtFCIDFind) {
		this.txtFCIDFind = txtFCIDFind;
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
	 * @param t00332Bean the t00332Bean to set
	 */
	public void setT00332Bean(Pgt00332 t00332Bean) {
		this.t00332Bean = t00332Bean;
	}

	/**
	 * @return the t00332Bean
	 */
	public Pgt00332 getT00332Bean() {
		return t00332Bean;
	}

	/**
	 * @return the t00384Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00384Service getT00384Service() {
		return t00384Service;
	}

	/**
	 * @param t00384Service the t00384Service to set
	 */
	public void setT00384Service(IPgt00384Service t00384Service) {
		this.t00384Service = t00384Service;
	}

	/**
	 * @return the ngMxList
	 */
	public ArrayList<Pgv00384> getNgMxList() {
		return ngMxList;
	}

	/**
	 * @param ngMxList the ngMxList to set
	 */
	public void setNgMxList(ArrayList<Pgv00384> ngMxList) {
		this.ngMxList = ngMxList;
	}

	/**
	 * @param txtSWID the txtSWID to set
	 */
	public void setTxtSWID(String txtSWID) {
		this.txtSWID = txtSWID;
	}

	/**
	 * @return the txtSWID
	 */
	public String getTxtSWID() {
		return txtSWID;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	/**
	 * @return the t00331Bean
	 */
	public Pgt00331 getT00331Bean() {
		return t00331Bean;
	}

	/**
	 * @param t00331Bean the t00331Bean to set
	 */
	public void setT00331Bean(Pgt00331 t00331Bean) {
		this.t00331Bean = t00331Bean;
	}

	/**
	 * @return the t00331Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00331Service getT00331Service() {
		return t00331Service;
	}

	/**
	 * @param t00331Service the t00331Service to set
	 */
	public void setT00331Service(IPgt00331Service t00331Service) {
		this.t00331Service = t00331Service;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
