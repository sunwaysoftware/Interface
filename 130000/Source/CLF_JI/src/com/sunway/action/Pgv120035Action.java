package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12003Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12003;

/**
 * 房产信息查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv120035Action extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 7869201939654860265L;
	// Service
	private IPgt12003Service t12003Service;
	// VIEW
	private Pgv12003 v12003Bean;
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	private ArrayList<Pgv12003> tabList;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFCIDFind;
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
		Pgv12003 v12003 = new Pgv12003();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v12003.setPageIndex(pageIndex);
			v12003.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12003.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12003.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if (Common.isNullOrEmpty(DCID)) {
				v12003.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
				v12003.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
				v12003.setFcid(Common.convertEncoding(Common.trim(txtFCIDFind)));
				v12003.setCbzt(ddlCBZTFind);
				v12003.setSyzt(ddlSYZTFind);
			} else {
				v12003.setCd12002Dcid(Common.convertEncoding(Common.trim(DCID)));
				v12003.setCbzt(Common.convertToInteger(Constant.ZT_DEFAULT));
				v12003.setSyzt(Common.convertToInteger(Constant.ZT_DEFAULT));
			}
			
			//执行查询
			v12003Bean = t12003Service.LoadPgv120035(v12003);
			tabList = v12003Bean.getV12003List();
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
			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** set and get ******************************/

	/**
	 * @return the t12003Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12003Service getT12003Service() {
		return t12003Service;
	}
	/**
	 * @param t12003Service the t12003Service to set
	 */
	public void setT12003Service(IPgt12003Service t12003Service) {
		this.t12003Service = t12003Service;
	}
	/**
	 * @return the v12003Bean
	 */
	public Pgv12003 getV12003Bean() {
		return v12003Bean;
	}
	/**
	 * @param v12003Bean the v12003Bean to set
	 */
	public void setV12003Bean(Pgv12003 v12003Bean) {
		this.v12003Bean = v12003Bean;
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
	public ArrayList<Pgv12003> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12003> tabList) {
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
