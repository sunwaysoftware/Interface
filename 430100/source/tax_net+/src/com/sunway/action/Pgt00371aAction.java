package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00371aService;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00371a;

/**
 * 
 * 市场法登记信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt00371aAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 7713871382384620265L;
	private IPgt00371aService t00371aService;
	private String ACT;
	// VIEW
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private ArrayList<Pgt00371a> rows;
	private String pk;
	// EDIT
	private Pgt00371a t00371aBean;
	private String txtLX;
	private String txtFCID;
	private String txtMC;
	private String txtZJLXId;
	private String txtSFID;
	private String txtGJDMId;
	private String txtLXDH;
	// Detail
	private Pgt00371a v00371aBean;
	private Boolean bSuccess;
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
			
		} catch (Exception e) {
			this.addActionError(e.getMessage());
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

		Pgt00371a v00371a = new Pgt00371a();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00371a.setFcid(txtFCID);
			//执行查询
			rows = t00371aService.LoadAll(v00371a);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.size());
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
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
	public String query00302() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgt00371a v00371a = new Pgt00371a();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00371a.setFcid(txtFCID);
			//执行查询
			rows = t00371aService.LoadAll00302(v00371a);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.size());
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
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
	public String query00302_B() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgt00371a v00371a = new Pgt00371a();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00371a.setFcid(txtFCID);
			//执行查询
			rows = t00371aService.LoadAll00302_B(v00371a);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.size());
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
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
	public String query02002() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgt00371a v00371a = new Pgt00371a();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00371a.setFcid(txtFCID);
			//执行查询
			rows = t00371aService.LoadAll02002(v00371a);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.size());
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
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
	public String query02002_B() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgt00371a v00371a = new Pgt00371a();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00371a.setFcid(txtFCID);
			//执行查询
			rows = t00371aService.LoadAll02002_B(v00371a);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.size());
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}

		Pgt00371a t00371a = new Pgt00371a();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//读取选中的数据信息
				t00371a.setId(pk);
				t00371aBean = t00371aService.LoadByPrimaryKey(t00371a);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 更新操作前的驗證處理
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t00371aBean = new Pgt00371a();
		t00371aBean.setId(pk);
		this.clearErrorsAndMessages();
			
		//根據PK取得信息，並為數據BEAN賦值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			t00371aBean = t00371aService.LoadByPrimaryKey(t00371aBean);
		}
		
		//判读数据是否已经被其他用户修改
		if (!Constant.MOD_DELETE.equals(getACT()))
		{
			t00371aBean.setCd00001Gjdm(txtGJDMId);
			t00371aBean.setCd00001Zjlx(txtZJLXId);
			t00371aBean.setFcid(txtFCID);
			t00371aBean.setLx(ConvertUtil.toInteger(txtLX));
			t00371aBean.setMc(txtMC);
			t00371aBean.setSfid(txtSFID);		
			t00371aBean.setLxdh(txtLXDH);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 * 更新、删除状态处理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		String rtn = SUCCESS;
		bSuccess=false;
		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if (t00371aService.GetInsertCommand(t00371aBean)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] { t00371aBean.getId() }));
					bSuccess=true;
				} else{
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] { t00371aBean.getId() }));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00371aService.GetUpdateCommand(t00371aBean)) {
					//t00371aBean = t00371aService.LoadByPrimaryKey(t00371aBean);
					bSuccess=true;
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t00371aBean.getId() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { t00371aBean.getId() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t00371aService.GetDeleteCommand(t00371aBean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { t00371aBean.getId() }));
					//rtn = "successDEL";
					bSuccess=true;
					ACT = Constant.MOD_MODIFY;
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { t00371aBean.getId() }));
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
			LOG.debug("create() ********** end **********");
		}
		return rtn;
	}	


	/******************************** set and get **************************************/
	
	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @param t00371aService the t00371aService to set
	 */
	public void setT00371aService(IPgt00371aService t00371aService) {
		this.t00371aService = t00371aService;
	}

	/**
	 * @return the t00371aService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00371aService getT00371aService() {
		return t00371aService;
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
	public ArrayList<Pgt00371a> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgt00371a> rows) {
		this.rows = rows;
	}

	

	/**
	 * @param t00371aBean the t00371aBean to set
	 */
	public void setT00371aBean(Pgt00371a t00371aBean) {
		this.t00371aBean = t00371aBean;
	}

	/**
	 * @return the t00371aBean
	 */
	public Pgt00371a getT00371aBean() {
		return t00371aBean;
	}

	

	/**
	 * @return the txtZJLXId
	 */
	public String getTxtZJLXId() {
		return txtZJLXId;
	}

	/**
	 * @param txtZJLXId the txtZJLXId to set
	 */
	public void setTxtZJLXId(String txtZJLXId) {
		this.txtZJLXId = txtZJLXId;
	}

	
	/**
	 * @return the v00371aBean
	 */
	public Pgt00371a getV00371aBean() {
		return v00371aBean;
	}
	/**
	 * @param v00371aBean the v00371aBean to set
	 */
	public void setV00371aBean(Pgt00371a v00371aBean) {
		this.v00371aBean = v00371aBean;
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

	public String getTxtLX() {
		return txtLX;
	}

	public void setTxtLX(String txtLX) {
		this.txtLX = txtLX;
	}

	public String getTxtFCID() {
		return txtFCID;
	}

	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}

	public String getTxtMC() {
		return txtMC;
	}

	public void setTxtMC(String txtMC) {
		this.txtMC = txtMC;
	}

	public String getTxtSFID() {
		return txtSFID;
	}

	public void setTxtSFID(String txtSFID) {
		this.txtSFID = txtSFID;
	}

	public String getTxtGJDMId() {
		return txtGJDMId;
	}

	public void setTxtGJDMId(String txtGJDMId) {
		this.txtGJDMId = txtGJDMId;
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public Boolean getbSuccess() {
		return bSuccess;
	}

	public void setbSuccess(Boolean bSuccess) {
		this.bSuccess = bSuccess;
	}

	public String getTxtLXDH() {
		return txtLXDH;
	}

	public void setTxtLXDH(String txtLXDH) {
		this.txtLXDH = txtLXDH;
	}
}
