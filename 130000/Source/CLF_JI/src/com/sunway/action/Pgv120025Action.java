package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12002Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12002;

/**
 * 地产信息查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv120025Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 6787856090763016041L;
	// Service
	private IPgt12002Service t12002Service;
	// VIEW
	private Pgv12002 v12002Bean;
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	private ArrayList<Pgv12002> tabList;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtDCIDFind;
	private String DCID;
	private Integer ddlCBZTFind;
	private Integer ddlSYZTFind;
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

		Pgv12002 v12002 = new Pgv12002();
		try {
			//准備查詢條件
			if (Common.isNullOrEmpty(DCID)) {
				v12002.setDcid(Common.convertEncoding(Common.trim(txtDCIDFind)));
				v12002.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
				v12002.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
				v12002.setCbzt(ddlCBZTFind);
				v12002.setSyzt(ddlSYZTFind);
			} else {
				v12002.setDcid(Common.convertEncoding(Common.trim(DCID)));
				v12002.setCbzt(Common.convertToInteger(Constant.ZT_DEFAULT));
				v12002.setSyzt(Common.convertToInteger(Constant.ZT_DEFAULT));
			}
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v12002.setPageIndex(pageIndex);
			v12002.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12002.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12002.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			v12002Bean = t12002Service.LoadPgv120025(v12002);
			tabList = v12002Bean.getV12002List();
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
				pageIndex = 1;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** set and get ******************************/

	/**
	 * @return the t12002Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12002Service getT12002Service() {
		return t12002Service;
	}
	/**
	 * @param t12002Service the t12002Service to set
	 */
	public void setT12002Service(IPgt12002Service t12002Service) {
		this.t12002Service = t12002Service;
	}
	/**
	 * @return the v12002Bean
	 */
	public Pgv12002 getV12002Bean() {
		return v12002Bean;
	}
	/**
	 * @param v12002Bean the v12002Bean to set
	 */
	public void setV12002Bean(Pgv12002 v12002Bean) {
		this.v12002Bean = v12002Bean;
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
	 * @return the tabList
	 */
	public ArrayList<Pgv12002> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12002> tabList) {
		this.tabList = tabList;
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
	 * @return the txtDCIDFind
	 */
	public String getTxtDCIDFind() {
		return txtDCIDFind;
	}
	/**
	 * @param txtDCIDFind the txtDCIDFind to set
	 */
	public void setTxtDCIDFind(String txtDCIDFind) {
		this.txtDCIDFind = txtDCIDFind;
	}
	/**
	 * @return the dCID
	 */
	public String getDCID() {
		return DCID;
	}
	/**
	 * @param dCID the dCID to set
	 */
	public void setDCID(String dCID) {
		DCID = dCID;
	}
	/**
	 * @return the ddlCBZTFind
	 */
	public Integer getDdlCBZTFind() {
		return ddlCBZTFind;
	}
	/**
	 * @param ddlCBZTFind the ddlCBZTFind to set
	 */
	public void setDdlCBZTFind(Integer ddlCBZTFind) {
		this.ddlCBZTFind = ddlCBZTFind;
	}
	/**
	 * @return the ddlSYZTFind
	 */
	public Integer getDdlSYZTFind() {
		return ddlSYZTFind;
	}
	/**
	 * @param ddlSYZTFind the ddlSYZTFind to set
	 */
	public void setDdlSYZTFind(Integer ddlSYZTFind) {
		this.ddlSYZTFind = ddlSYZTFind;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
