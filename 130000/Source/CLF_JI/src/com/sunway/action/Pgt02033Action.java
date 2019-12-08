/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02032Service;
import com.sunway.service.IPgt02033Service;
import com.sunway.service.IPgv02033aService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02032;
import com.sunway.vo.Pgt02033;
import com.sunway.vo.Pgv02033a;

/**
 * 
 * 收益法个案评税其它修正参数表
 * @author Andy.Gao
 *
 */
public class Pgt02033Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 8361217286550507747L;
	private IPgv02033aService v02033aService;
	private IPgt02033Service t02033Service;
	private IPgt02032Service t02032Service;
	private ArrayList<Pgt02033> tabList;
	private ArrayList<Pgv02033a> historyList;
	private Pgt02033 t02033Bean; 
	private Pgt02032 t02032Bean;
	private String ACT;
	private String txtMXID;
	private String txtPSSD;
	private String txtQTXZID;
	private String txtQTXZNM;
	private String txtXZLX;
	private String txtXZXS;
	private String txtNOTE;
	private String txtUPDDATE;
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
			//读取个案信息
			readInfo();
		} catch (Exception e) {
			LOG.error("query()", e);
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
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

		t02033Bean = new Pgt02033();
		this.clearErrorsAndMessages();
		t02033Bean.setQtxzid(txtQTXZID);
		t02033Bean.setCd12004Mxid(txtMXID);
		t02033Bean.setCd00002Pssd(txtPSSD);
		//根據PK取得信息，並為數據BEAN賦值
		if(!Constant.MOD_DELETE.equals(ACT)){
			t02033Bean = t02033Service.LoadByPrimaryKey(t02033Bean);
			if(null==t02033Bean) t02033Bean = new Pgt02033();
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(ACT))&&(!Common.isNullOrEmpty(t02033Bean.getQtxzid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.sjpg.t10033.qtxzid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(ACT))&&(!t02033Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t02033Bean.setCd00002Czr(sessionCtrl.getUserId());
			t02033Bean.setCd00002Pssd(txtPSSD);
			t02033Bean.setCd12004Mxid(txtMXID);
			t02033Bean.setNote(txtNOTE);
			t02033Bean.setQtxzid(txtQTXZID);
			t02033Bean.setQtxznm(txtQTXZNM);
			t02033Bean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t02033Bean.setXzlx(Common.convertToInteger(txtXZLX));
			t02033Bean.setXzxs(Common.convertToDouble(txtXZXS));
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 * 更新信息處理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		
		try {
			if(Constant.MOD_CREATE.equals(ACT)){			// Create
				if(t02033Service.GetInsertCommand(t02033Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{Constant.STRING_EMPTY}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{Constant.STRING_EMPTY}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t02033Service.GetUpdateCommand(t02033Bean)){
					t02033Bean = t02033Service.LoadByPrimaryKey(t02033Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{Constant.STRING_EMPTY}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{Constant.STRING_EMPTY}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t02033Service.GetDeleteCommand(t02033Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{Constant.STRING_EMPTY}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{Constant.STRING_EMPTY}));
			}			
		} catch (Exception e) {
			LOG.error("update()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return INPUT;
		} finally {
			readInfo();
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 读取个案信息
	 * @throws Exception
	 */
	protected void readInfo() throws Exception {
		//读取个案评税结果
		t02032Bean = t02032Service.LoadByPrimaryKey(new Pgt02032(txtMXID, txtPSSD));
		//执行查询
		tabList = t02033Service.LoadAll(new Pgt02033(txtMXID, txtPSSD));	
		// 查询历史个案信息
		historyList = v02033aService.LoadAll(new Pgv02033a(txtMXID, txtPSSD));
	}

	/*********************** set and get ******************************/
	
	/**
	 * @return the t02033Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02033Service getT02033Service() {
		return t02033Service;
	}

	/**
	 * @param t02033Service the t02033Service to set
	 */
	public void setT02033Service(IPgt02033Service t02033Service) {
		this.t02033Service = t02033Service;
	}

	/**
	 * @return the t02032Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02032Service getT02032Service() {
		return t02032Service;
	}

	/**
	 * @param t02032Service the t02032Service to set
	 */
	public void setT02032Service(IPgt02032Service t02032Service) {
		this.t02032Service = t02032Service;
	}

	/**
	 * @param v02033aService the v02033aService to set
	 */
	public void setV02033aService(IPgv02033aService v02033aService) {
		this.v02033aService = v02033aService;
	}

	/**
	 * @return the v02033aService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgv02033aService getV02033aService() {
		return v02033aService;
	}
	
	/**
	 * @return the tabList
	 */
	public ArrayList<Pgt02033> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgt02033> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the t02033Bean
	 */
	public Pgt02033 getT02033Bean() {
		return t02033Bean;
	}

	/**
	 * @param t02033Bean the t02033Bean to set
	 */
	public void setT02033Bean(Pgt02033 t02033Bean) {
		this.t02033Bean = t02033Bean;
	}

	/**
	 * @return the t02032Bean
	 */
	public Pgt02032 getT02032Bean() {
		return t02032Bean;
	}

	/**
	 * @param t02032Bean the t02032Bean to set
	 */
	public void setT02032Bean(Pgt02032 t02032Bean) {
		this.t02032Bean = t02032Bean;
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
	 * @return the txtMXID
	 */
	public String getTxtMXID() {
		return txtMXID;
	}

	/**
	 * @param txtMXID the txtMXID to set
	 */
	public void setTxtMXID(String txtMXID) {
		this.txtMXID = txtMXID;
	}

	/**
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}

	/**
	 * @param txtPSSD the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}

	/**
	 * @return the txtQTXZID
	 */
	public String getTxtQTXZID() {
		return txtQTXZID;
	}

	/**
	 * @param txtQTXZID the txtQTXZID to set
	 */
	public void setTxtQTXZID(String txtQTXZID) {
		this.txtQTXZID = txtQTXZID;
	}

	/**
	 * @return the txtQTXZNM
	 */
	public String getTxtQTXZNM() {
		return txtQTXZNM;
	}

	/**
	 * @param txtQTXZNM the txtQTXZNM to set
	 */
	public void setTxtQTXZNM(String txtQTXZNM) {
		this.txtQTXZNM = txtQTXZNM;
	}

	/**
	 * @return the txtXZLX
	 */
	public String getTxtXZLX() {
		return txtXZLX;
	}

	/**
	 * @param txtXZLX the txtXZLX to set
	 */
	public void setTxtXZLX(String txtXZLX) {
		this.txtXZLX = txtXZLX;
	}

	/**
	 * @return the txtXZXS
	 */
	public String getTxtXZXS() {
		return txtXZXS;
	}

	/**
	 * @param txtXZXS the txtXZXS to set
	 */
	public void setTxtXZXS(String txtXZXS) {
		this.txtXZXS = txtXZXS;
	}

	/**
	 * @return the txtNOTE
	 */
	public String getTxtNOTE() {
		return txtNOTE;
	}

	/**
	 * @param txtNOTE the txtNOTE to set
	 */
	public void setTxtNOTE(String txtNOTE) {
		this.txtNOTE = txtNOTE;
	}

	/**
	 * @return the txtUPDDATE
	 */
	public String getTxtUPDDATE() {
		return txtUPDDATE;
	}

	/**
	 * @param txtUPDDATE the txtUPDDATE to set
	 */
	public void setTxtUPDDATE(String txtUPDDATE) {
		this.txtUPDDATE = txtUPDDATE;
	}

	/**
	 * @param historyList the historyList to set
	 */
	public void setHistoryList(ArrayList<Pgv02033a> historyList) {
		this.historyList = historyList;
	}

	/**
	 * @return the historyList
	 */
	public ArrayList<Pgv02033a> getHistoryList() {
		return historyList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
