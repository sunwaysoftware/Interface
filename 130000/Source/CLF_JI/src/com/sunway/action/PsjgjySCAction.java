package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00054Service;
import com.sunway.service.IPsjgjySCService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00054;
import com.sunway.vo.Pgv003314;
import com.sunway.vo.Pgv00310;
import com.sunway.vo.Pgv00310A;

/**
 * 评税结果检验（市场法）
 * @category 评税结果检验
 * @author Lee
 * @version 1.0
 */

public class PsjgjySCAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -3001032736552406690L;
	//view
	private IPsjgjySCService pgjgjySCService;
	private IPgt00054Service t00054Service;
	
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv003314> tabList;
	private ArrayList<Pgv00310> v00310List;
	private ArrayList<Pgv00310A> v00310AList;
	private ArrayList<Pgv00054> v00054List;
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	
	private String CJID;
	private String txtSwidFind;
	private String txtNsrmcFind;
	private String ddlPSSDFind;
	private String txtXQDMFind;
	private String txtFWLXFind;
	private String txtFWYTFind;
	private String txtJZJGFind;
	private String txtJcnfbgnFind;
	private String txtJcnfendFind;
	private String ddlPSBZFind;
	private String ddlJZQSFind;
	private String ddlLSXSFind;
	private String ddlJGXGCFind;
	private String txtTDDJFind;
	private String ddlSZQYFind;
	private Boolean isDel;
	private String txtBLMIN;
	private String txtBLMAX;
	private String txtLCMIN;
	private String txtLCMAX;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String txtJZMJMINFind;
	private String txtJZMJMAXFind;

	
	//验证操作
	private String txtSWIDFind;
	private String txtXQFind;
	private String txtNSRMCFind;
	private String txtJYSJMINFind;
	private String txtJYSJMAXFind;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	
	public String viewCheckout() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
		}
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
		
		Pgv003314 scpsjgjy = new Pgv003314();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			scpsjgjy.setCd00301Swid(txtSwidFind);
			scpsjgjy.setNsrmc(Common.getSearchLike(txtNsrmcFind));
			scpsjgjy.setSzqy(ddlSZQYFind);
			scpsjgjy.setCd00352Xqdm(txtXQDMFind);
			scpsjgjy.setCd00001Fwlx(txtFWLXFind);
			scpsjgjy.setCd00001Jzjg(txtJZJGFind);
			scpsjgjy.setJcnfbgn(txtJcnfbgnFind);
			scpsjgjy.setJcnfend(txtJcnfendFind);
			scpsjgjy.setJzmjMin(Common.convertToDouble(txtJZMJMINFind));
			scpsjgjy.setJzmjMax(Common.convertToDouble(txtJZMJMAXFind));
			scpsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			scpsjgjy.setPageIndex(pageIndex);
			scpsjgjy.setPageSize(getPageSize());
			scpsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = pgjgjySCService.LoadAll003314(scpsjgjy);
			
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = tabList.get(0).getRecordCount();
			}else{
				rowCount = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 跳转到查询选择页面
	 */
	public String viewChoise() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("viewChoise() ********** start **********");
		}

		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("viewChoise() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("viewChoise() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	
	public String checkout() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("choise() ********** start **********");
		}
		
		Pgv00310 scpsjgjy = new Pgv00310();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			scpsjgjy.setCd00301Swid(txtSWIDFind);
			scpsjgjy.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			scpsjgjy.setCd00352Xqdm(txtXQFind);
			scpsjgjy.setCd00001Fwlx(txtFWLXFind);
			scpsjgjy.setCd00001Jzjg(txtJZJGFind);
			scpsjgjy.setJcnfbgn(Common.convertToDate(txtJYSJMINFind));
			scpsjgjy.setJcnfend(Common.convertToDate(txtJYSJMAXFind));
			scpsjgjy.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			scpsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			scpsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			scpsjgjy.setJzmjMin(Common.convertToDouble(txtJZMJMINFind));
			scpsjgjy.setJzmjMax(Common.convertToDouble(txtJZMJMAXFind));
			scpsjgjy.setCd00001Szqy(ddlSZQYFind);
			if(pgjgjySCService.GetInsert003101Command(scpsjgjy)){
				this.addActionMessage(getText(Constant.MSG_CHECKOUT_OK));
			}else{
				this.addActionError(getText(Constant.MSG_CHECKOUT_OK));
			}
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("choise() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String queryChoise() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryChoise() ********** start **********");
		}
		
		Pgv00310 scpsjgjy = new Pgv00310();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			scpsjgjy.setCd00301Swid(txtSwidFind);
			scpsjgjy.setNsrmc(txtNsrmcFind);
			scpsjgjy.setCd00352Xqdm(txtXQDMFind);
			scpsjgjy.setCd00001Fwlx(txtFWLXFind);
			scpsjgjy.setCd00001Fwyt(txtFWYTFind);
			scpsjgjy.setCd00001Jzjg(txtJZJGFind);
			scpsjgjy.setJcnfbgn(Common.convertToDate(txtJcnfbgnFind));
			scpsjgjy.setJcnfend(Common.convertToDate(txtJcnfendFind));
			scpsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			scpsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			scpsjgjy.setPageIndex(pageIndex);
			scpsjgjy.setPageSize(getPageSize());
			//执行查询
			v00310List = pgjgjySCService.LoadAll00310(scpsjgjy);
			
			//分页设置
			if(null!=v00310List && v00310List.size()>0){
				rowCount = v00310List.get(0).getRecordCount();
			}else{
				rowCount = 0;
				pageIndex = 1;
			}
			
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryChoise() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 执行评税结果检验
	 * @return
	 * @throws Exception
	 */
	
	public String reCheckout() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("checkout() ********** start **********");
		}
		
		Pgv00310A scpsjgjy = new Pgv00310A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			scpsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			scpsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			scpsjgjy.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			
			if(pgjgjySCService.GetInsert00310A1Command(scpsjgjy) == 1){
				this.addActionMessage(getText(Constant.MSG_CHECKOUT_OK));
			}else{
				this.addActionError(getText(Constant.MSG_CHECKOUT_NG));
			}
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("checkout() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 查询评税结果检验结果
	 * @return
	 * @throws Exception
	 */
	public String queryCheckout() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryCheckout() ********** start **********");
		}
		
		Pgv00310A scpsjgjy = new Pgv00310A();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			scpsjgjy.setCd00001Szqy(ddlSZQYFind);
			scpsjgjy.setBlMin(Common.convertToDouble(txtBLMIN));
			scpsjgjy.setBlMax(Common.convertToDouble(txtBLMAX));
			scpsjgjy.setLcMin(Common.convertToDouble(txtLCMIN));
			scpsjgjy.setLcMax(Common.convertToDouble(txtLCMAX));
			scpsjgjy.setCdjybz(ddlPSBZFind);
			scpsjgjy.setPjzqs(Integer.parseInt(ddlJZQSFind));
			scpsjgjy.setPlsxs(Integer.parseInt(ddlLSXSFind));
			scpsjgjy.setPjgxgc(Integer.parseInt(ddlJGXGCFind));
			scpsjgjy.setPageIndex(pageIndex);
			scpsjgjy.setPageSize(getPageSize());
			scpsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			scpsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			v00310AList = pgjgjySCService.LoadAll00310A(scpsjgjy);
			
			//分页设置
			if(null!=v00310AList && v00310AList.size()>0){
				rowCount = v00310AList.get(0).getRecordCount();
			}else{
				rowCount = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryCheckout() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过ajax删除待检验数据
	 * @return
	 * @throws Exception
	 */
	public String deleteByAjax() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("deleteByAjax() ********** start **********");
		}

		try {
			isDel = pgjgjySCService.GetDeleteCommand(CJID);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("deleteByAjax() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("deleteByAjax() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 通过ajax清空数据
	 * @return
	 * @throws Exception
	 */
	public String clearByAjax() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("clearByAjax() ********** start **********");
		}

		try {
			isDel = pgjgjySCService.DeleteAllCommand();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("clearByAjax() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("clearByAjax() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 根据采集ID查看检验标准通过情况
	 * @return
	 * @throws Exception
	 */
	public String viewJYJG() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("viewJYJG() ********** start **********");
		}
		
		Pgv00054 v00054 = new Pgv00054();
		Pgv00310A scpsjgjy = new Pgv00310A();
		
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			scpsjgjy = pgjgjySCService.LoadByPrimaryKey(CJID);
			//准备查询条件
			v00054.setCd00001Szqy(ddlSZQYFind);
			v00054.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00054.setJzqs(scpsjgjy.getJzqs());
			v00054.setLsxs(scpsjgjy.getLsxs());
			v00054.setJgxgc(scpsjgjy.getJgxgc());
			//执行查询
			v00054List = t00054Service.LoadAll000541(v00054);
			
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("viewJYJG() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the pgjgjySCService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPsjgjySCService getPgjgjySCService() {
		return pgjgjySCService;
	}

	/**
	 * @param pgjgjySCService the pgjgjySCService to set
	 */
	public void setPgjgjySCService(IPsjgjySCService pgjgjySCService) {
		this.pgjgjySCService = pgjgjySCService;
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
	 * @return the rowCount
	 */
	public Integer getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	/**
	 * @return the txtSwidFind
	 */
	public String getTxtSwidFind() {
		return txtSwidFind;
	}

	/**
	 * @param txtSwidFind the txtSwidFind to set
	 */
	public void setTxtSwidFind(String txtSwidFind) {
		this.txtSwidFind = txtSwidFind;
	}

	/**
	 * @return the txtNsrmcFind
	 */
	public String getTxtNsrmcFind() {
		return txtNsrmcFind;
	}

	/**
	 * @param txtNsrmcFind the txtNsrmcFind to set
	 */
	public void setTxtNsrmcFind(String txtNsrmcFind) {
		this.txtNsrmcFind = txtNsrmcFind;
	}

	/**
	 * @return the ddlPSSDFind
	 */
	public String getDdlPSSDFind() {
		return ddlPSSDFind;
	}

	/**
	 * @param ddlPSSDFind the ddlPSSDFind to set
	 */
	public void setDdlPSSDFind(String ddlPSSDFind) {
		this.ddlPSSDFind = ddlPSSDFind;
	}

	/**
	 * @return the txtJcnfbgnFind
	 */
	public String getTxtJcnfbgnFind() {
		return txtJcnfbgnFind;
	}

	/**
	 * @param txtJcnfbgnFind the txtJcnfbgnFind to set
	 */
	public void setTxtJcnfbgnFind(String txtJcnfbgnFind) {
		this.txtJcnfbgnFind = txtJcnfbgnFind;
	}

	/**
	 * @return the txtJcnfendFind
	 */
	public String getTxtJcnfendFind() {
		return txtJcnfendFind;
	}

	/**
	 * @param txtJcnfendFind the txtJcnfendFind to set
	 */
	public void setTxtJcnfendFind(String txtJcnfendFind) {
		this.txtJcnfendFind = txtJcnfendFind;
	}

	/**
	 * @return the txtXQDMFind
	 */
	public String getTxtTDYTFind() {
		return txtXQDMFind;
	}

	/**
	 * @param txtXQDMFind the txtXQDMFind to set
	 */
	public void setTxtTDYTFind(String txtXQDMFind) {
		this.txtXQDMFind = txtXQDMFind;
	}

	/**
	 * @return the txtFWLXFind
	 */
	public String getTxtFWYTFind() {
		return txtFWLXFind;
	}

	/**
	 * @param txtFWLXFind the txtFWLXFind to set
	 */
	public void setTxtFWYTFind(String txtFWLXFind) {
		this.txtFWLXFind = txtFWLXFind;
	}

	/**
	 * @return the txtJZJGFind
	 */
	public String getTxtJZJGFind() {
		return txtJZJGFind;
	}

	/**
	 * @param txtJZJGFind the txtJZJGFind to set
	 */
	public void setTxtJZJGFind(String txtJZJGFind) {
		this.txtJZJGFind = txtJZJGFind;
	}

	/**
	 * @return the v00310List
	 */
	public ArrayList<Pgv00310> getV00310List() {
		return v00310List;
	}

	/**
	 * @param v00310List the v00310List to set
	 */
	public void setV00310List(ArrayList<Pgv00310> v00310List) {
		this.v00310List = v00310List;
	}

	/**
	 * @return the v00310AList
	 */
	public ArrayList<Pgv00310A> getV00310AList() {
		return v00310AList;
	}

	/**
	 * @param v00310AList the v00310AList to set
	 */
	public void setV00310AList(ArrayList<Pgv00310A> v00310AList) {
		this.v00310AList = v00310AList;
	}
	/**
	 * @return the ddlPSBZFind
	 */
	public String getDdlPSBZFind() {
		return ddlPSBZFind;
	}
	/**
	 * @param ddlPSBZFind the ddlPSBZFind to set
	 */
	public void setDdlPSBZFind(String ddlPSBZFind) {
		this.ddlPSBZFind = ddlPSBZFind;
	}
	/**
	 * @return the ddlJZQSFind
	 */
	public String getDdlJZQSFind() {
		return ddlJZQSFind;
	}
	/**
	 * @param ddlJZQSFind the ddlJZQSFind to set
	 */
	public void setDdlJZQSFind(String ddlJZQSFind) {
		this.ddlJZQSFind = ddlJZQSFind;
	}
	/**
	 * @return the ddlLSXSFind
	 */
	public String getDdlLSXSFind() {
		return ddlLSXSFind;
	}
	/**
	 * @param ddlLSXSFind the ddlLSXSFind to set
	 */
	public void setDdlLSXSFind(String ddlLSXSFind) {
		this.ddlLSXSFind = ddlLSXSFind;
	}
	/**
	 * @return the ddlJGXGCFind
	 */
	public String getDdlJGXGCFind() {
		return ddlJGXGCFind;
	}
	/**
	 * @param ddlJGXGCFind the ddlJGXGCFind to set
	 */
	public void setDdlJGXGCFind(String ddlJGXGCFind) {
		this.ddlJGXGCFind = ddlJGXGCFind;
	}
	/**
	 * @return the txtTDDJFind
	 */
	public String getTxtTDDJFind() {
		return txtTDDJFind;
	}
	/**
	 * @param txtTDDJFind the txtTDDJFind to set
	 */
	public void setTxtTDDJFind(String txtTDDJFind) {
		this.txtTDDJFind = txtTDDJFind;
	}
	/**
	 * @return the t00054Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00054Service getT00054Service() {
		return t00054Service;
	}
	/**
	 * @param t00054Service the t00054Service to set
	 */
	public void setT00054Service(IPgt00054Service t00054Service) {
		this.t00054Service = t00054Service;
	}
	/**
	 * @return the v00054List
	 */
	public ArrayList<Pgv00054> getV00054List() {
		return v00054List;
	}
	/**
	 * @param v00054List the v00054List to set
	 */
	public void setV00054List(ArrayList<Pgv00054> v00054List) {
		this.v00054List = v00054List;
	}
	/**
	 * @return the txtXQDMFind
	 */
	public String getTxtXQDMFind() {
		return txtXQDMFind;
	}
	/**
	 * @param txtXQDMFind the txtXQDMFind to set
	 */
	public void setTxtXQDMFind(String txtXQDMFind) {
		this.txtXQDMFind = txtXQDMFind;
	}
	/**
	 * @return the txtFWLXFind
	 */
	public String getTxtFWLXFind() {
		return txtFWLXFind;
	}
	/**
	 * @param txtFWLXFind the txtFWLXFind to set
	 */
	public void setTxtFWLXFind(String txtFWLXFind) {
		this.txtFWLXFind = txtFWLXFind;
	}
	/**
	 * @return the ddlSZQYFind
	 */
	public String getDdlSZQYFind() {
		return ddlSZQYFind;
	}
	/**
	 * @param ddlSZQYFind the ddlSZQYFind to set
	 */
	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
	}
	/**
	 * @return the isDel
	 */
	public Boolean getIsDel() {
		return isDel;
	}
	/**
	 * @param isDel the isDel to set
	 */
	public void setIsDel(Boolean isDel) {
		this.isDel = isDel;
	}
	/**
	 * @return the cJID
	 */
	public String getCJID() {
		return CJID;
	}
	/**
	 * @param cJID the cJID to set
	 */
	public void setCJID(String cJID) {
		CJID = cJID;
	}
	/**
	 * @return the txtBLMIN
	 */
	public String getTxtBLMIN() {
		return txtBLMIN;
	}
	/**
	 * @param txtBLMIN the txtBLMIN to set
	 */
	public void setTxtBLMIN(String txtBLMIN) {
		this.txtBLMIN = txtBLMIN;
	}
	/**
	 * @return the txtBLMAX
	 */
	public String getTxtBLMAX() {
		return txtBLMAX;
	}
	/**
	 * @param txtBLMAX the txtBLMAX to set
	 */
	public void setTxtBLMAX(String txtBLMAX) {
		this.txtBLMAX = txtBLMAX;
	}
	/**
	 * @return the txtLCMIN
	 */
	public String getTxtLCMIN() {
		return txtLCMIN;
	}
	/**
	 * @param txtLCMIN the txtLCMIN to set
	 */
	public void setTxtLCMIN(String txtLCMIN) {
		this.txtLCMIN = txtLCMIN;
	}
	/**
	 * @return the txtLCMAX
	 */
	public String getTxtLCMAX() {
		return txtLCMAX;
	}
	/**
	 * @param txtLCMAX the txtLCMAX to set
	 */
	public void setTxtLCMAX(String txtLCMAX) {
		this.txtLCMAX = txtLCMAX;
	}
	public String getTxtSWIDFind() {
		return txtSWIDFind;
	}
	public void setTxtSWIDFind(String txtSWIDFind) {
		this.txtSWIDFind = txtSWIDFind;
	}
	public String getTxtXQFind() {
		return txtXQFind;
	}
	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}
	public String getTxtNSRMCFind() {
		return txtNSRMCFind;
	}
	public void setTxtNSRMCFind(String txtNSRMCFind) {
		this.txtNSRMCFind = txtNSRMCFind;
	}
	public String getTxtJYSJMINFind() {
		return txtJYSJMINFind;
	}
	public void setTxtJYSJMINFind(String txtJYSJMINFind) {
		this.txtJYSJMINFind = txtJYSJMINFind;
	}
	public String getTxtJYSJMAXFind() {
		return txtJYSJMAXFind;
	}
	public void setTxtJYSJMAXFind(String txtJYSJMAXFind) {
		this.txtJYSJMAXFind = txtJYSJMAXFind;
	}
	public String getTxtJZMJMINFind() {
		return txtJZMJMINFind;
	}
	public void setTxtJZMJMINFind(String txtJZMJMINFind) {
		this.txtJZMJMINFind = txtJZMJMINFind;
	}
	public String getTxtJZMJMAXFind() {
		return txtJZMJMAXFind;
	}
	public void setTxtJZMJMAXFind(String txtJZMJMAXFind) {
		this.txtJZMJMAXFind = txtJZMJMAXFind;
	}
	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv003314> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv003314> tabList) {
		this.tabList = tabList;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
