package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00054Service;
import com.sunway.service.IPsjgjyCBService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00054;
import com.sunway.vo.Pgv100314;
import com.sunway.vo.Pgv120101;
import com.sunway.vo.Pgv12010a1;

/**
 * 评税结果检验（成本法）
 * @category 评税结果检验
 * @author Lee
 * @version 1.0
 */

public class PsjgjyCBAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 2151977166840665541L;
	//view
	private IPsjgjyCBService pgjgjyCBService;
	private IPgt00054Service t00054Service;
	
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv100314> v100314List;
	private ArrayList<Pgv120101> v120101List;
	private ArrayList<Pgv12010a1> v12010a1List;
	private ArrayList<Pgv00054> v00054List;
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	
	private String CJID;
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
		
		Pgv100314 cbpsjgjy = new Pgv100314();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			cbpsjgjy.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSwidFind)));
			cbpsjgjy.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNsrmcFind)));
			cbpsjgjy.setCd00001Tdyt(txtTDYTFind);
			cbpsjgjy.setCd00001Fwyt(txtFWYTFind);
			cbpsjgjy.setCd00001Jzjg(txtJZJGFind);
			cbpsjgjy.setJcnfbgn(txtJcnfbgnFind);
			cbpsjgjy.setJcnfend(txtJcnfendFind);
			cbpsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			cbpsjgjy.setPageIndex(pageIndex);
			cbpsjgjy.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			cbpsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			v100314List = pgjgjyCBService.LoadAll100314(cbpsjgjy);
			
			//分页设置
			if(null!=v100314List && v100314List.size()>0){
				rowCount = v100314List.get(0).getRecordCount();
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
		
		Pgv120101 cbpsjgjy = new Pgv120101();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			cbpsjgjy.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSwidFind)));
			cbpsjgjy.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNsrmcFind)));
			cbpsjgjy.setCd00001Tdyt(txtTDYTFind);
			cbpsjgjy.setCd00001Fwyt(txtFWYTFind);
			cbpsjgjy.setCd00001Jzjg(txtJZJGFind);
			cbpsjgjy.setJcnfbgn(txtJcnfbgnFind);
			cbpsjgjy.setJcnfend(txtJcnfendFind);
			cbpsjgjy.setCd00002Lrr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			cbpsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			cbpsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(pgjgjyCBService.GetInsert120101Command(cbpsjgjy)){
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
	 * 执行评税结果检验
	 * @return
	 * @throws Exception
	 */
	
	public String reCheckout() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("checkout() ********** start **********");
		}
		
		Pgv12010a1 cbpsjgjy = new Pgv12010a1();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			cbpsjgjy.setCd00002Lrr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			cbpsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			cbpsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(pgjgjyCBService.GetInsert12010A1Command(cbpsjgjy) == 1){
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
	 * ajax 取得检验标准
	 * @return
	 * @throws Exception
	 */
	/**
	 * @return
	 * @throws Exception
	 */
	public String getJybzDdl() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("getJybzDdl() ********** start **********");
		}

		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			Pgv00054 v00054 = new Pgv00054();
			v00054.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00054.setCd00001Szqy(ddlSZQYFind);
			v00054List = t00054Service.LoadAll(v00054);
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("getJybzDdl() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("getJybzDdl() ********** end **********");
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
		
		Pgv12010a1 cbpsjgjy = new Pgv12010a1();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			cbpsjgjy.setCd00001Szqy(ddlSZQYFind);
			cbpsjgjy.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSwidFind)));
			cbpsjgjy.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNsrmcFind)));
			cbpsjgjy.setCdjybz(ddlPSBZFind);
			cbpsjgjy.setBlMin(Common.convertToDouble(txtBLMIN));
			cbpsjgjy.setBlMax(Common.convertToDouble(txtBLMAX));
			cbpsjgjy.setLcMin(Common.convertToDouble(txtLCMIN));
			cbpsjgjy.setLcMax(Common.convertToDouble(txtLCMAX));
			cbpsjgjy.setPjzqs(Integer.parseInt(ddlJZQSFind));
			cbpsjgjy.setPlsxs(Integer.parseInt(ddlLSXSFind));
			cbpsjgjy.setPjgxgc(Integer.parseInt(ddlJGXGCFind));
			cbpsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			cbpsjgjy.setPageIndex(pageIndex);
			cbpsjgjy.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			cbpsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			//执行查询
			v12010a1List = pgjgjyCBService.LoadAll12010A1(cbpsjgjy);
			
			//分页设置
			if(null!=v12010a1List && v12010a1List.size()>0){
				rowCount = v12010a1List.get(0).getRecordCount();
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
	 * 通过ajax删除待检验数据
	 * @return
	 * @throws Exception
	 */
	public String deleteByAjax() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("deleteByAjax() ********** start **********");
		}

		try {
			isDel = pgjgjyCBService.GetDeleteCommand(CJID);
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
			isDel = pgjgjyCBService.DeleteAllCommand();
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
		Pgv12010a1 cbpsjgjy = new Pgv12010a1();
		
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			cbpsjgjy = pgjgjyCBService.LoadByPrimaryKey(CJID);
			//准备查询条件
			v00054.setCd00001Szqy(ddlSZQYFind);
			v00054.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00054.setJzqs(cbpsjgjy.getJzqs());
			v00054.setLsxs(cbpsjgjy.getLsxs());
			v00054.setJgxgc(cbpsjgjy.getJgxgc());
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
	 * @return the pgjgjyCBService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPsjgjyCBService getPgjgjyCBService() {
		return pgjgjyCBService;
	}

	/**
	 * @param pgjgjyCBService the pgjgjyCBService to set
	 */
	public void setPgjgjyCBService(IPsjgjyCBService pgjgjyCBService) {
		this.pgjgjyCBService = pgjgjyCBService;
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
	 * @return the v100314List
	 */
	public ArrayList<Pgv100314> getV100314List() {
		return v100314List;
	}

	/**
	 * @param v100314List the v100314List to set
	 */
	public void setV100314List(ArrayList<Pgv100314> v100314List) {
		this.v100314List = v100314List;
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
	 * @return the v120101List
	 */
	public ArrayList<Pgv120101> getV120101List() {
		return v120101List;
	}

	/**
	 * @param v120101List the v120101List to set
	 */
	public void setV120101List(ArrayList<Pgv120101> v120101List) {
		this.v120101List = v120101List;
	}

	/**
	 * @return the v12010a1List
	 */
	public ArrayList<Pgv12010a1> getV12010a1List() {
		return v12010a1List;
	}

	/**
	 * @param v12010a1List the v12010a1List to set
	 */
	public void setV12010a1List(ArrayList<Pgv12010a1> v12010a1List) {
		this.v12010a1List = v12010a1List;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
