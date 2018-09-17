package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ICz00001Service;
import com.sunway.service.IPgt00013Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.CZ00001;
import com.sunway.vo.Pgt00013;
import com.sunway.vo.Pgv00013;

/**
 * 用户操作概要记录(Pgt00013)
 * @author Lee
 * @version 1.0
 */

public class Pgt00013Action extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1010186523592784675L;
	
	private IPgt00013Service t00013Service;
	private ICz00001Service cz00001Service;
	private ArrayList<CZ00001> czList;
	//view
	
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private ArrayList<Pgv00013> rows;
	private String txtLOGTYPEFind;
	private String txtTABLENAMEFind;
	private String txtCZRFind;
	
	//edit
	
	private Pgt00013 t00013Bean;
	private String LOGID;
	private String txtLOGID;
	private String ACT;
	
	private String txtSTARTDATE;
	private String txtENDDATE;
	private String txtLOGTYPE;
	private String txtTABLENAME;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String txtSSGX;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			ReadInfo();
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			LOG.error("execute()", e);
			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return ERROR;
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		txtSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
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
		
		Pgv00013 v00013 = new Pgv00013();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00013.setLogtype(ConvertUtil.toInteger(txtLOGTYPEFind));
			v00013.setTablename(FormatUtil.toSearchLike(txtTABLENAMEFind));
			v00013.setCd00002Czr(FormatUtil.toSearchLike(txtCZRFind));
			v00013.setPageIndex(pageIndex);
			v00013.setPageSize(getPageSize());
			if(CheckUtil.chkEmpty(txtSSGX)){
				v00013.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				v00013.setCd00001Ssgx(txtSSGX);
			}
			//执行查询
			rows = t00013Service.LoadAll(v00013);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();				
			}else{
				total = 1;
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
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		try {
			if(!Constant.MOD_CREATE.equals(getACT())) {

			}
			ReadInfo();
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
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		ReadInfo();
		t00013Bean = new Pgt00013();
		this.clearErrorsAndMessages();
		t00013Bean.setStartdate(ConvertUtil.toTimestamp(txtSTARTDATE));
		t00013Bean.setEnddate(ConvertUtil.toTimestamp(txtENDDATE));
		t00013Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
		t00013Bean.setLogtype(ConvertUtil.toInteger(txtLOGTYPE));
		t00013Bean.setTablename(txtTABLENAME);
		t00013Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
	}

	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String update()throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			if(t00013Service.GetDeleteCommand(getT00013Bean()))
				this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT00013Bean().getTablename()}));
			else
				this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT00013Bean().getTablename()}));
		} catch (Exception e) {
			LOG.error(e.getMessage());
			String[] msgs=e.getMessage().split("\n");
			this.addActionError(msgs[0]);

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

	/**
	 * 读取【日志操作类型】
	 * @throws Exception
	 */
	protected void ReadInfo() throws Exception {
		czList = cz00001Service.LoadAll();
	}

	/*********************** set and get ******************************/
	
	/**
	 * @return the t00013Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00013Service getT00013Service() {
		return t00013Service;
	}

	/**
	 * @param t00013Service the t00013Service to set
	 */
	public void setT00013Service(IPgt00013Service t00013Service) {
		this.t00013Service = t00013Service;
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
	 * @return the txtLOGTYPEFind
	 */
	public String getTxtLOGTYPEFind() {
		return txtLOGTYPEFind;
	}

	/**
	 * @param txtLOGTYPEFind the txtLOGTYPEFind to set
	 */
	public void setTxtLOGTYPEFind(String txtLOGTYPEFind) {
		this.txtLOGTYPEFind = txtLOGTYPEFind;
	}

	/**
	 * @return the txtTABLENAMEFind
	 */
	public String getTxtTABLENAMEFind() {
		return txtTABLENAMEFind;
	}

	/**
	 * @param txtTABLENAMEFind the txtTABLENAMEFind to set
	 */
	public void setTxtTABLENAMEFind(String txtTABLENAMEFind) {
		this.txtTABLENAMEFind = txtTABLENAMEFind;
	}

	/**
	 * @return the txtCZRFind
	 */
	public String getTxtCZRFind() {
		return txtCZRFind;
	}

	/**
	 * @param txtCZRFind the txtCZRFind to set
	 */
	public void setTxtCZRFind(String txtCZRFind) {
		this.txtCZRFind = txtCZRFind;
	}

	/**
	 * @return the lOGID
	 */
	public String getLOGID() {
		return LOGID;
	}

	/**
	 * @param lOGID the lOGID to set
	 */
	public void setLOGID(String lOGID) {
		LOGID = lOGID;
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
	 * @return the txtLOGID
	 */
	public String getTxtLOGID() {
		return txtLOGID;
	}

	/**
	 * @param txtLOGID the txtLOGID to set
	 */
	public void setTxtLOGID(String txtLOGID) {
		this.txtLOGID = txtLOGID;
	}

	/**
	 * @return the t00013Bean
	 */
	public Pgt00013 getT00013Bean() {
		return t00013Bean;
	}

	/**
	 * @param t00013Bean the t00013Bean to set
	 */
	public void setT00013Bean(Pgt00013 t00013Bean) {
		this.t00013Bean = t00013Bean;
	}


	/**
	 * @return the txtSTARTDATE
	 */
	public String getTxtSTARTDATE() {
		return txtSTARTDATE;
	}


	/**
	 * @param txtSTARTDATE the txtSTARTDATE to set
	 */
	public void setTxtSTARTDATE(String txtSTARTDATE) {
		this.txtSTARTDATE = txtSTARTDATE;
	}


	/**
	 * @return the txtENDDATE
	 */
	public String getTxtENDDATE() {
		return txtENDDATE;
	}


	/**
	 * @param txtENDDATE the txtENDDATE to set
	 */
	public void setTxtENDDATE(String txtENDDATE) {
		this.txtENDDATE = txtENDDATE;
	}


	/**
	 * @return the txtLOGTYPE
	 */
	public String getTxtLOGTYPE() {
		return txtLOGTYPE;
	}


	/**
	 * @param txtLOGTYPE the txtLOGTYPE to set
	 */
	public void setTxtLOGTYPE(String txtLOGTYPE) {
		this.txtLOGTYPE = txtLOGTYPE;
	}


	/**
	 * @return the txtTABLENAME
	 */
	public String getTxtTABLENAME() {
		return txtTABLENAME;
	}


	/**
	 * @param txtTABLENAME the txtTABLENAME to set
	 */
	public void setTxtTABLENAME(String txtTABLENAME) {
		this.txtTABLENAME = txtTABLENAME;
	}


	/**
	 * @param cz00001Service the cz00001Service to set
	 */
	public void setCz00001Service(ICz00001Service cz00001Service) {
		this.cz00001Service = cz00001Service;
	}


	/**
	 * @return the cz00001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ICz00001Service getCz00001Service() {
		return cz00001Service;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv00013> getRows() {
		return rows;
	}


	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00013> rows) {
		this.rows = rows;
	}


	/**
	 * @return the czList
	 */
	public ArrayList<CZ00001> getCzList() {
		return czList;
	}


	/**
	 * @param czList the czList to set
	 */
	public void setCzList(ArrayList<CZ00001> czList) {
		this.czList = czList;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}


	public String getTxtSSGX() {
		return txtSSGX;
	}


	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
