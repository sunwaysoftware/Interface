package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00054Service;
import com.sunway.service.IPsjgjySYService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00054;
import com.sunway.vo.Pgv020314;
import com.sunway.vo.Pgv120102;
import com.sunway.vo.Pgv12010a2;

/**
 * 评税结果检验（成本法）
 * @category 评税结果检验
 * @author Lee
 * @version 1.0
 */

public class PsjgjySYAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 1085649569170409382L;
	//view
	private IPsjgjySYService pgjgjySYService;
	private IPgt00054Service t00054Service;
	
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv020314> v020314List;
	private ArrayList<Pgv120102> v120102List;
	private ArrayList<Pgv12010a2> v12010a2List;
	private ArrayList<Pgv00054> v00054List;
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	
	private String txtSwidFind;
	private String txtNsrmcFind;
	private String ddlPSSDFind;
	private String txtTDYTFind;
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
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		Pgv020314 sypsjgjy = new Pgv020314();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			sypsjgjy.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSwidFind)));
			sypsjgjy.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNsrmcFind)));
			sypsjgjy.setCd00001Tdyt(txtTDYTFind);
			sypsjgjy.setCd00001Fwyt(txtFWYTFind);
			sypsjgjy.setCd00001Jzjg(txtJZJGFind);
			sypsjgjy.setJcnfbgn(txtJcnfbgnFind);
			sypsjgjy.setJcnfend(txtJcnfendFind);
			sypsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			sypsjgjy.setPageIndex(pageIndex);
			sypsjgjy.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			sypsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			v020314List = pgjgjySYService.LoadAll020314(sypsjgjy);
			
			//分页设置
			if(null!=v020314List && v020314List.size()>0){
				rowCount = v020314List.get(0).getRecordCount();
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			}else{
				pageCount = 1;
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
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String checkout() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("choise() ********** start **********");
		}
		
		Pgv120102 sypsjgjy = new Pgv120102();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			sypsjgjy.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSwidFind)));
			sypsjgjy.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNsrmcFind)));
			sypsjgjy.setCd00001Tdyt(txtTDYTFind);
			sypsjgjy.setCd00001Fwyt(txtFWYTFind);
			sypsjgjy.setCd00001Jzjg(txtJZJGFind);
			sypsjgjy.setJcnfbgn(txtJcnfbgnFind);
			sypsjgjy.setJcnfend(txtJcnfendFind);
			sypsjgjy.setCd00002Lrr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			sypsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			sypsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(pgjgjySYService.GetInsert120102Command(sypsjgjy)){
				this.addActionMessage(getText(Constant.MSG_CHECKOUT_OK));
			}else{
				this.addActionError(getText(Constant.MSG_CHECKOUT_NG));
			}
			
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}finally{
			szqyList = sessionCtrl.ReadSzqyList();
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
		
		Pgv120102 sypsjgjy = new Pgv120102();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			sypsjgjy.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSwidFind)));
			sypsjgjy.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNsrmcFind)));
			sypsjgjy.setCd00001Tdyt(txtTDYTFind);
			sypsjgjy.setCd00001Fwyt(txtFWYTFind);
			sypsjgjy.setCd00001Jzjg(txtJZJGFind);
			sypsjgjy.setJcnfbgn(txtJcnfbgnFind);
			sypsjgjy.setJcnfend(txtJcnfendFind);
			sypsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			sypsjgjy.setPageIndex(pageIndex);
			sypsjgjy.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			sypsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			v120102List = pgjgjySYService.LoadAll120102(sypsjgjy);
			
			//分页设置
			if(null!=v120102List && v120102List.size()>0){
				rowCount = v120102List.get(0).getRecordCount();
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			}else{
				pageCount = 1;
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
		
		Pgv12010a2 sypsjgjy = new Pgv12010a2();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			sypsjgjy.setCd00002Lrr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			sypsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			sypsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(pgjgjySYService.GetInsert12010A2Command(sypsjgjy) == 1){
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
		
		Pgv12010a2 sypsjgjy = new Pgv12010a2();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			sypsjgjy.setCd00001Szqy(ddlSZQYFind);
			sypsjgjy.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSwidFind)));
			sypsjgjy.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNsrmcFind)));
			sypsjgjy.setCdjybz(ddlPSBZFind);
			sypsjgjy.setBlMin(Common.convertToDouble(txtBLMIN));
			sypsjgjy.setBlMax(Common.convertToDouble(txtBLMAX));
			sypsjgjy.setLcMin(Common.convertToDouble(txtLCMIN));
			sypsjgjy.setLcMax(Common.convertToDouble(txtLCMAX));
			sypsjgjy.setPjzqs(Integer.parseInt(ddlJZQSFind));
			sypsjgjy.setPlsxs(Integer.parseInt(ddlLSXSFind));
			sypsjgjy.setPjgxgc(Integer.parseInt(ddlJGXGCFind));
			sypsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			sypsjgjy.setPageIndex(pageIndex);
			sypsjgjy.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			sypsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			v12010a2List = pgjgjySYService.LoadAll12010A2(sypsjgjy);
			
			//分页设置
			if(null!=v12010a2List && v12010a2List.size()>0){
				rowCount = v12010a2List.get(0).getRecordCount();
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			}else{
				pageCount = 1;
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
	 * 通过ajax清空数据
	 * @return
	 * @throws Exception
	 */
	public String clearByAjax() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("clearByAjax() ********** start **********");
		}

		try {
			isDel = pgjgjySYService.DeleteAllCommand();
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
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the pgjgjySYService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPsjgjySYService getPgjgjySYService() {
		return pgjgjySYService;
	}

	/**
	 * @param pgjgjySYService the pgjgjySYService to set
	 */
	public void setPgjgjySYService(IPsjgjySYService pgjgjySYService) {
		this.pgjgjySYService = pgjgjySYService;
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
	 * @return the pageCount
	 */
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
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
	 * @return the v020314List
	 */
	public ArrayList<Pgv020314> getV020314List() {
		return v020314List;
	}

	/**
	 * @param v020314List the v020314List to set
	 */
	public void setV020314List(ArrayList<Pgv020314> v020314List) {
		this.v020314List = v020314List;
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
	 * @return the txtTDYTFind
	 */
	public String getTxtTDYTFind() {
		return txtTDYTFind;
	}

	/**
	 * @param txtTDYTFind the txtTDYTFind to set
	 */
	public void setTxtTDYTFind(String txtTDYTFind) {
		this.txtTDYTFind = txtTDYTFind;
	}

	/**
	 * @return the txtFWYTFind
	 */
	public String getTxtFWYTFind() {
		return txtFWYTFind;
	}

	/**
	 * @param txtFWYTFind the txtFWYTFind to set
	 */
	public void setTxtFWYTFind(String txtFWYTFind) {
		this.txtFWYTFind = txtFWYTFind;
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
	 * @return the v120102List
	 */
	public ArrayList<Pgv120102> getV120102List() {
		return v120102List;
	}

	/**
	 * @param v120102List the v120102List to set
	 */
	public void setV120102List(ArrayList<Pgv120102> v120102List) {
		this.v120102List = v120102List;
	}

	/**
	 * @return the v12010a2List
	 */
	public ArrayList<Pgv12010a2> getV12010a2List() {
		return v12010a2List;
	}

	/**
	 * @param v12010a2List the v12010a2List to set
	 */
	public void setV12010a2List(ArrayList<Pgv12010a2> v12010a2List) {
		this.v12010a2List = v12010a2List;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
