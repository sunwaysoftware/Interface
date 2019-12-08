package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12001Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv12001;

/**
 * 纳税人查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv120015Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7427943203447237682L;
	// Service
	private IPgt12001Service t12001Service;
	// 分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv12001> operList;
	private Pgv12001 v12001Bean;
	// 检索条件
	private String txtSwidFind;
	private String txtNsrmcFind;
	private String DCID;
	private Integer ddlCBZTFind;
	private Integer ddlSYZTFind;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/*
	 * (non-Javadoc)
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
		Pgv12001 v12001 = new Pgv12001();
		v12001Bean = new Pgv12001();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12001.setPageIndex(pageIndex);
			v12001.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if (Common.isNullOrEmpty(DCID)) {
				v12001.setSwid(Common.getSearchLike(Common.convertEncoding(txtSwidFind)));
				v12001.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNsrmcFind)));
				v12001.setCbzt(ddlCBZTFind);
				v12001.setSyzt(ddlSYZTFind);
			} else {
				v12001.setCd12002Dcid(Common.convertEncoding(Common.trim(DCID)));
				v12001.setCbzt(Common.convertToInteger(Constant.ZT_DEFAULT));
				v12001.setSyzt(Common.convertToInteger(Constant.ZT_DEFAULT));
			}
			// 执行查询
			v12001Bean = t12001Service.LoadPgv120015(v12001);
			operList = v12001Bean.getV12001List();
			// 分页设置
			if (null != operList && operList.size() > 0) {
				rowCount = operList.get(0).getRecordCount();
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
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
	 * 成本、收益法数据查询页面初期化
	 */
	public String init120000() throws Exception {
		return SUCCESS;
	}

	/*********************** setter and getter ******************************/

	/**
	 * @return the t12001Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt12001Service getT12001Service() {
		return t12001Service;
	}
	/**
	 * @param t12001Service the t12001Service to set
	 */
	public void setT12001Service(IPgt12001Service t12001Service) {
		this.t12001Service = t12001Service;
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
	 * @return the operList
	 */
	public ArrayList<Pgv12001> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<Pgv12001> operList) {
		this.operList = operList;
	}
	/**
	 * @return the v12001Bean
	 */
	public Pgv12001 getV12001Bean() {
		return v12001Bean;
	}
	/**
	 * @param v12001Bean the v12001Bean to set
	 */
	public void setV12001Bean(Pgv12001 v12001Bean) {
		this.v12001Bean = v12001Bean;
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
