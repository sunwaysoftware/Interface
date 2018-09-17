/**
 *
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00331Service;
import com.sunway.service.IPgt00332Service;
import com.sunway.service.IPgt00333Service;
import com.sunway.service.IPgv00333aService;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00331;
import com.sunway.vo.Pgt00332;
import com.sunway.vo.Pgt00333;
import com.sunway.vo.Pgv00333a;

/**
 * @author Andy.Gao
 *
 */
public class Pgt00333Action extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = 3412907928125750252L;
	private IPgv00333aService v00333aService;
	private IPgt00333Service t00333Service;
	private IPgt00332Service t00332Service;
	private IPgt00331Service t00331Service;
	private ArrayList<Pgt00333> rows;
	private ArrayList<Pgv00333a> historyList;
	private Pgt00333 t00333Bean;
	private Pgt00332 t00332Bean;
	private String ACT;
	private String txtFCID;
	private String txtPSSD;
	private String txtQTXZID;
	private String txtQTXZNM;
	private String txtXZLX;
	private String txtXZXS;
	private String txtNOTE;
	private String txtUPDDATE;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Integer rdoCZLX;
	private Pgt00331 t00331Bean;
	private String txtGAJG;

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

		t00333Bean = new Pgt00333();
		this.clearErrorsAndMessages();
		t00333Bean.setQtxzid(txtQTXZID);
		t00333Bean.setCd00302Fcid(txtFCID);
		t00333Bean.setCd00002Pssd(txtPSSD);
		//根據PK取得信息，並為數據BEAN賦值
		if(!Constant.MOD_DELETE.equals(ACT)){
			t00333Bean = t00333Service.LoadByPrimaryKey(t00333Bean);
			if(null==t00333Bean) t00333Bean = new Pgt00333();
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(ACT))&&(!CheckUtil.chkEmpty(t00333Bean.getQtxzid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.sjpg.t10033.qtxzid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(ACT))&&(!t00333Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00333Bean.setCd00002Czr(sessionCtrl.getUserId());
			t00333Bean.setCd00002Pssd(txtPSSD);
			t00333Bean.setCd00302Fcid(txtFCID);
			t00333Bean.setNote(txtNOTE);
			t00333Bean.setQtxzid(txtQTXZID);
			t00333Bean.setQtxznm(txtQTXZNM);
			t00333Bean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t00333Bean.setXzlx(ConvertUtil.toInteger(txtXZLX));
			t00333Bean.setXzxs(ConvertUtil.toBigDecimal(txtXZXS));
			t00333Bean.setCzlx(rdoCZLX);
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
				if(t00333Service.GetInsertCommand(t00333Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{Constant.STRING_EMPTY}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{Constant.STRING_EMPTY}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t00333Service.GetUpdateCommand(t00333Bean)){
					t00333Bean = t00333Service.LoadByPrimaryKey(t00333Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{Constant.STRING_EMPTY}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{Constant.STRING_EMPTY}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t00333Service.GetDeleteCommand(t00333Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{Constant.STRING_EMPTY}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{Constant.STRING_EMPTY}));
			}
			
			Pgt00331 t00331 = new Pgt00331();
			t00331.setCd00302Fcid(ConvertUtil.encoding(txtFCID));
			t00331Bean = t00331Service.LoadByPrimaryKey(t00331);
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
		t00332Bean = t00332Service.LoadByPrimaryKey(new Pgt00332(txtFCID, txtPSSD));
		//执行查询
		rows = t00333Service.LoadAll(new Pgt00333(txtFCID, txtPSSD));
		// 查询历史个案信息
		historyList = v00333aService.LoadAll(new Pgv00333a(txtFCID, txtPSSD));
	}

	
	/**
	 * 修改个案估价结果
	 * @return
	 * @throws Exception
	 */
	public String modify() throws Exception {
		Pgt00333 t00333 = new Pgt00333();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00333.setCd00002Czr(sessionCtrl.getUserId());
			t00333.setCd00302Fcid(txtFCID);
			t00333.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t00333.setXzxs(ConvertUtil.toBigDecimal(txtGAJG));
			t00333.setNote(CheckUtil.chkTrim(txtNOTE));
			//执行更新个案操作
			if(t00333Service.GetModifyCommand(t00333)){
				this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{txtFCID}));
			}else
				this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{txtFCID}));			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return INPUT;
		}finally {
			readInfo();
		}
		
		return SUCCESS;
	}
	
	/****************************** set and get ************************************/

	/**
	 * @return the t00333Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00333Service getT00333Service() {
		return t00333Service;
	}

	/**
	 * @param t00333Service the t00333Service to set
	 */
	public void setT00333Service(IPgt00333Service t00333Service) {
		this.t00333Service = t00333Service;
	}

	/**
	 * @return the t00332Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00332Service getT00332Service() {
		return t00332Service;
	}

	/**
	 * @param t00332Service the t00332Service to set
	 */
	public void setT00332Service(IPgt00332Service t00332Service) {
		this.t00332Service = t00332Service;
	}

	/**
	 * @param v00333aService the v00333aService to set
	 */
	public void setV00333aService(IPgv00333aService v00333aService) {
		this.v00333aService = v00333aService;
	}

	/**
	 * @return the v00333aService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgv00333aService getV00333aService() {
		return v00333aService;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgt00333> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgt00333> rows) {
		this.rows = rows;
	}

	/**
	 * @return the t00333Bean
	 */
	public Pgt00333 getT00333Bean() {
		return t00333Bean;
	}

	/**
	 * @param t00333Bean the t00333Bean to set
	 */
	public void setT00333Bean(Pgt00333 t00333Bean) {
		this.t00333Bean = t00333Bean;
	}

	/**
	 * @return the t00332Bean
	 */
	public Pgt00332 getT00332Bean() {
		return t00332Bean;
	}

	/**
	 * @param t00332Bean the t00332Bean to set
	 */
	public void setT00332Bean(Pgt00332 t00332Bean) {
		this.t00332Bean = t00332Bean;
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
	 * @return the txtFCID
	 */
	public String getTxtFCID() {
		return txtFCID;
	}

	/**
	 * @param txtFCID the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
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
	public void setHistoryList(ArrayList<Pgv00333a> historyList) {
		this.historyList = historyList;
	}

	/**
	 * @return the historyList
	 */
	public ArrayList<Pgv00333a> getHistoryList() {
		return historyList;
	}

	/**
	 * @param rdoCZLX the rdoCZLX to set
	 */
	public void setRdoCZLX(Integer rdoCZLX) {
		this.rdoCZLX = rdoCZLX;
	}

	/**
	 * @return the rdoCZLX
	 */
	public Integer getRdoCZLX() {
		return rdoCZLX;
	}

	public Pgt00331 getT00331Bean() {
		return t00331Bean;
	}

	public void setT00331Bean(Pgt00331 t00331Bean) {
		this.t00331Bean = t00331Bean;
	}

	@JSON(deserialize=false, serialize=false)
	public IPgt00331Service getT00331Service() {
		return t00331Service;
	}

	public void setT00331Service(IPgt00331Service t00331Service) {
		this.t00331Service = t00331Service;
	}

	public String getTxtGAJG() {
		return txtGAJG;
	}

	public void setTxtGAJG(String txtGAJG) {
		this.txtGAJG = txtGAJG;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
