/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt10032Service;
import com.sunway.service.IPgt10033Service;
import com.sunway.service.IPgv10033aService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt10032;
import com.sunway.vo.Pgt10033;
import com.sunway.vo.Pgv10033a;

/**
 * 
 * 成本法个案评税其它修正参数表
 * @author Andy.Gao
 *
 */
public class Pgt10033Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1980858303693421740L;
	private IPgv10033aService v10033aService;
	private IPgt10033Service t10033Service;
	private IPgt10032Service t10032Service;
	private ArrayList<Pgt10033> tabList;
	private ArrayList<Pgv10033a> historyList;
	private Pgt10033 t10033Bean; 
	private Pgt10032 t10032Bean;
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

		t10033Bean = new Pgt10033();
		this.clearErrorsAndMessages();
		t10033Bean.setQtxzid(txtQTXZID);
		t10033Bean.setCd12004Mxid(txtMXID);
		t10033Bean.setCd00002Pssd(txtPSSD);
		//根據PK取得信息，並為數據BEAN賦值
		if(!Constant.MOD_DELETE.equals(getACT())){
			t10033Bean = t10033Service.LoadByPrimaryKey(t10033Bean);
			if(null==t10033Bean) t10033Bean = new Pgt10033();
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t10033Bean.getQtxzid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.sjpg.t10033.qtxzid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t10033Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t10033Bean.setCd00002Czr(sessionCtrl.getUserId());
			t10033Bean.setCd00002Pssd(txtPSSD);
			t10033Bean.setCd12004Mxid(txtMXID);
			t10033Bean.setNote(txtNOTE);
			t10033Bean.setQtxzid(txtQTXZID);
			t10033Bean.setQtxznm(txtQTXZNM);
			t10033Bean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t10033Bean.setXzlx(Common.convertToInteger(txtXZLX));
			t10033Bean.setXzxs(Common.convertToDouble(txtXZXS));
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
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t10033Service.GetInsertCommand(t10033Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{Constant.STRING_EMPTY}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{Constant.STRING_EMPTY}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t10033Service.GetUpdateCommand(t10033Bean)){
					t10033Bean = t10033Service.LoadByPrimaryKey(t10033Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{Constant.STRING_EMPTY}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{Constant.STRING_EMPTY}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t10033Service.GetDeleteCommand(t10033Bean))
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
		t10032Bean = t10032Service.LoadByPrimaryKey(new Pgt10032(txtMXID, txtPSSD));
		//执行查询
		tabList = t10033Service.LoadAll(new Pgt10033(txtMXID, txtPSSD));
		// 查询历史个案信息
		historyList = v10033aService.LoadAll(new Pgv10033a(txtMXID, txtPSSD));
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @param t10033Service the t10033Service to set
	 */
	public void setT10033Service(IPgt10033Service t10033Service) {
		this.t10033Service = t10033Service;
	}

	/**
	 * @return the t10033Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt10033Service getT10033Service() {
		return t10033Service;
	}

	/**
	 * @return the t10032Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt10032Service getT10032Service() {
		return t10032Service;
	}

	/**
	 * @param t10032Service the t10032Service to set
	 */
	public void setT10032Service(IPgt10032Service t10032Service) {
		this.t10032Service = t10032Service;
	}

	/**
	 * @param v10033aService the v10033aService to set
	 */
	public void setV10033aService(IPgv10033aService v10033aService) {
		this.v10033aService = v10033aService;
	}

	/**
	 * @return the v10033aService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgv10033aService getV10033aService() {
		return v10033aService;
	}
	
	/**
	 * @return the t10032Bean
	 */
	public Pgt10032 getT10032Bean() {
		return t10032Bean;
	}

	/**
	 * @param t10032Bean the t10032Bean to set
	 */
	public void setT10032Bean(Pgt10032 t10032Bean) {
		this.t10032Bean = t10032Bean;
	}
	
	/**
	 * @return the tabList
	 */
	public ArrayList<Pgt10033> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgt10033> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the t10033Bean
	 */
	public Pgt10033 getT10033Bean() {
		return t10033Bean;
	}

	/**
	 * @param t10033Bean the t10033Bean to set
	 */
	public void setT10033Bean(Pgt10033 t10033Bean) {
		this.t10033Bean = t10033Bean;
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
	 * @param txtQTXZID the txtQTXZID to set
	 */
	public void setTxtQTXZID(String txtQTXZID) {
		this.txtQTXZID = txtQTXZID;
	}

	/**
	 * @return the txtQTXZID
	 */
	public String getTxtQTXZID() {
		return txtQTXZID;
	}

	/**
	 * @param historyList the historyList to set
	 */
	public void setHistoryList(ArrayList<Pgv10033a> historyList) {
		this.historyList = historyList;
	}

	/**
	 * @return the historyList
	 */
	public ArrayList<Pgv10033a> getHistoryList() {
		return historyList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
