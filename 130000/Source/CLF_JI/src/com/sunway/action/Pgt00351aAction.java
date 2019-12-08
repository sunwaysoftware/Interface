package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00351aService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00351a;
import com.sunway.vo.Pgv00351a;

/**
 * 市场法标准房价格维护交易价格
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */

public class Pgt00351aAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 6969606322294055258L;
	// Service
	private IPgt00351aService t00351aService;
	// View
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	private ArrayList<Pgv00351a> tabList;
	private String SLID;
	// 提交数据
	private String txtPFMJG;
	private String txtJYSJ;
	private String txtNOTET00351A;
	private String DSLID;
	private String FLAG;
	private String ACT;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Pgt00351a t00351a;

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
	 *
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		Pgv00351a v00351a = new Pgv00351a();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00351a.setPageIndex(pageIndex);
			v00351a.setPageSize(getPageSize());
			v00351a.setCd00351Slid(Common.trim(SLID));
			// 执行查询
			tabList = t00351aService.LoadAll(v00351a);
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
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

	public void validateUpdate() throws Exception {
		this.clearErrorsAndMessages();
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t00351a = new Pgt00351a();
		t00351a.setCd00351Slid(SLID);
		t00351a.setSlid(Common.trim(DSLID));
		t00351a.setJysj(Common.convertStringToDate(txtJYSJ));
		t00351a.setPfmjg(Common.convertToDouble(txtPFMJG));
		t00351a.setNote(txtNOTET00351A);
		t00351a.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
	}

	/**
	 * 添加、删除状态处理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		try {
			if (Constant.MOD_DELETE.equals(FLAG)) { // Delete
				if (t00351aService.GetDeleteCommand(t00351a)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] {Constant.STRING_EMPTY}));
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] {Constant.STRING_EMPTY}));
				}
			} else { // Create
				if (t00351aService.GetInsertCommand(t00351a)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] {Constant.STRING_EMPTY}));
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] {Constant.STRING_EMPTY}));
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** setter and getter ******************************/

	/**
	 * @return the t00351aService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00351aService getT00351aService() {
		return t00351aService;
	}
	/**
	 * @param t00351aService the t00351aService to set
	 */
	public void setT00351aService(IPgt00351aService t00351aService) {
		this.t00351aService = t00351aService;
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
	 * @return the tabList
	 */
	public ArrayList<Pgv00351a> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00351a> tabList) {
		this.tabList = tabList;
	}
	/**
	 * @return the sLID
	 */
	public String getSLID() {
		return SLID;
	}
	/**
	 * @param sLID the sLID to set
	 */
	public void setSLID(String sLID) {
		SLID = sLID;
	}
	/**
	 * @return the txtNOTET00351A
	 */
	public String getTxtNOTET00351A() {
		return txtNOTET00351A;
	}
	/**
	 * @param txtNOTET00351A the txtNOTET00351A to set
	 */
	public void setTxtNOTET00351A(String txtNOTET00351A) {
		this.txtNOTET00351A = txtNOTET00351A;
	}
	/**
	 * @return the dSLID
	 */
	public String getDSLID() {
		return DSLID;
	}
	/**
	 * @param dSLID the dSLID to set
	 */
	public void setDSLID(String dSLID) {
		DSLID = dSLID;
	}
	/**
	 * @return the fLAG
	 */
	public String getFLAG() {
		return FLAG;
	}
	/**
	 * @param fLAG the fLAG to set
	 */
	public void setFLAG(String fLAG) {
		FLAG = fLAG;
	}
	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}
	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the txtPFMJG
	 */
	public String getTxtPFMJG() {
		return txtPFMJG;
	}

	/**
	 * @param txtPFMJG the txtPFMJG to set
	 */
	public void setTxtPFMJG(String txtPFMJG) {
		this.txtPFMJG = txtPFMJG;
	}

	/**
	 * @return the txtJYSJ
	 */
	public String getTxtJYSJ() {
		return txtJYSJ;
	}

	/**
	 * @param txtJYSJ the txtJYSJ to set
	 */
	public void setTxtJYSJ(String txtJYSJ) {
		this.txtJYSJ = txtJYSJ;
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
