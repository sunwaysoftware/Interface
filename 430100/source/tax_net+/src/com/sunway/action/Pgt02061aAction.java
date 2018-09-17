package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02061aService;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02061a;
import com.sunway.vo.Pgv02061a;

/**
 * 市场法标准房价格维护交易价格
 * @category 系统维护
 * @author Lee
 * @version 1.0
 *
 */
public class Pgt02061aAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4104196287539382549L;
	// Service
	private IPgt02061aService t02061aService;
	// View
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private ArrayList<Pgv02061a> rows;
	private String SLID;
	// 提交数据
	private String txtPFMJG;
	private String txtJYSJ;
	private String txtNOTET02061A;
	private String DSLID;
	private String FLAG;
	private String ACT;
	private SessionCtrl sessionCtrl=new SessionCtrl();
	private Pgt02061a t02061a;
	private String SFSC;

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
		Pgv02061a v02061a = new Pgv02061a();
		try {
			// 准备查询条件
			v02061a.setPageIndex(pageIndex);
			if(null == getPageSize()){
				v02061a.setPageSize(-1);
			}else{
				v02061a.setPageSize(getPageSize());
			}
			
			v02061a.setCd02061Slid(CheckUtil.chkTrim(SLID));
			// 执行查询
			rows = t02061aService.LoadAll(v02061a);
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = rows.get(0).getRecordCount();
				//pageCount = Common.getPageSize(total, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			 e.printStackTrace();
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
		t02061a = new Pgt02061a();
		t02061a.setCd02061Slid(SLID);
		t02061a.setSlid(CheckUtil.chkTrim(DSLID));
		t02061a.setJysj(ConvertUtil.toUtilDate(txtJYSJ));
		t02061a.setPfmjg(ConvertUtil.toDouble(txtPFMJG));
		t02061a.setNote(txtNOTET02061A);
		t02061a.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
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
				if (t02061aService.GetDeleteCommand(t02061a)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] {getText("app.xtwh.t00361.cs")}));
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] {getText("app.xtwh.t00361.cs")}));
				}
			} else { // Create
				if (t02061aService.GetInsertCommand(t02061a)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getText("app.xtwh.t00361.cs")}));
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] {getText("app.xtwh.t00361.cs")}));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	 * @return the t02061aService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt02061aService getT02061aService() {
		return t02061aService;
	}
	/**
	 * @param t02061aService the t02061aService to set
	 */
	public void setT02061aService(IPgt02061aService t02061aService) {
		this.t02061aService = t02061aService;
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
	 * @return the rows
	 */
	public ArrayList<Pgv02061a> getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv02061a> rows) {
		this.rows = rows;
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
	 * @return the txtNOTET02061A
	 */
	public String getTxtNOTET02061A() {
		return txtNOTET02061A;
	}
	/**
	 * @param txtNOTET02061A the txtNOTET02061A to set
	 */
	public void setTxtNOTET02061A(String txtNOTET02061A) {
		this.txtNOTET02061A = txtNOTET02061A;
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

	public Pgt02061a getT02061a() {
		return t02061a;
	}

	public void setT02061a(Pgt02061a t02061a) {
		this.t02061a = t02061a;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession=arg0;
	}

	public String getSFSC() {
		return SFSC;
	}

	public void setSFSC(String sFSC) {
		SFSC = sFSC;
	}
}
