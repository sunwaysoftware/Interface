package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPsjgjySCService;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00310A;

public class PsjgcxjySCAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4561534539108238568L;
	//view
	private IPsjgjySCService pgjgjySCService;
	
	private ArrayList<Pgv00310A> tabList;
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	
	private String ddlPSBZFind;
	private String ddlJZQSFind;
	private String ddlLSXSFind;
	private String ddlJGXGCFind;
	private String ddlSZQYFind;
	private String txtBLMIN;
	private String txtBLMAX;
	private String txtLCMIN;
	private String txtLCMAX;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	@Override
	public String execute() throws Exception {
		
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
			scpsjgjy.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			scpsjgjy.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			scpsjgjy.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = pgjgjySCService.LoadAll00310A(scpsjgjy);
			
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = tabList.get(0).getRecordCount();
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
	 * @return the tabList
	 */
	public ArrayList<Pgv00310A> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00310A> tabList) {
		this.tabList = tabList;
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
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
