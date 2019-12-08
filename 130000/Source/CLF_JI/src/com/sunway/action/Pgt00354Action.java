package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00354Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00354;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00354;

/**
 * 市场法房屋朝向修正系数(Pgt00354)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt00354Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7553705339052335097L;

	//Service
	private IPgt00354Service t00354Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv00354> fwcxList;
	private ArrayList<Pgv00052> szqyList;
	//查询条件
	private String ddlSZQYFind;
	private String txtFWCXFind;
	private String txtPSSDFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt00354 t00354Bean;
	//primary key 主键
	private String FWCX;
	private String SZQY;
	private String PSSD;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtFWCX;
	private String txtXZXS;
	private String txtNOTE;
	private String txtUPDATE;
	private Boolean isExists;
	private String txtPSSD;
	
	private String ACTIONNAME;
	private String HREFNAME;
	private String TITLENAME;
	private String URL;
	private String ddlPSSD;
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
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("execute() ********** end **********");
			}
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
		
		Pgv00354 v00354 = new Pgv00354();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00354.setCd00001Szqy(Common.trim(ddlSZQYFind));
			v00354.setCd00001Fwcx(Common.trim(txtFWCXFind));
			v00354.setCd00002Pssd(Common.trim(txtPSSDFind));
			v00354.setPageIndex(pageIndex);
			v00354.setPageSize(getPageSize());
			v00354.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			fwcxList = t00354Service.LoadAll(v00354);
			
			//分页设置
			if(null!=fwcxList && fwcxList.size()>0){
				rowCount = fwcxList.get(0).getRecordCount();
			}else{
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

	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		Pgt00354 t00354 = new Pgt00354();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t00354.setCd00001Fwcx(FWCX);
				t00354.setCd00001Fwcxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWCX));
				t00354.setCd00001Szqy(SZQY);
				t00354.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t00354.setCd00002Pssd(PSSD);
				t00354Bean = t00354Service.LoadByPrimaryKey(t00354);
				if (Common.isNullOrEmpty(t00354Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
			}
			szqyList = sessionCtrl.ReadSzqyList();
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
		t00354Bean = new Pgt00354();
		this.clearErrorsAndMessages();	
		t00354Bean.setCd00001Fwcx(FWCX);
		t00354Bean.setCd00001Fwcxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWCX));
		t00354Bean.setCd00001Szqy(ddlSZQY);
		t00354Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		t00354Bean.setCd00002Pssd(txtPSSD);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t00354Bean = t00354Service.LoadByPrimaryKey(t00354Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t00354Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.fwcx")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00354Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t00354Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00354Bean.setXzxs(Common.convertToDouble(txtXZXS));
			t00354Bean.setNote(txtNOTE);
			t00354Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t00354Service.GetInsertCommand(getT00354Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT00354Bean().getCd00001Fwcx()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT00354Bean().getCd00001Fwcx()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00354Service.GetUpdateCommand(getT00354Bean())){
					t00354Bean = t00354Service.LoadByPrimaryKey(t00354Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT00354Bean().getCd00001Fwcx()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT00354Bean().getCd00001Fwcx()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t00354Service.GetDeleteCommand(getT00354Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT00354Bean().getCd00001Fwcx()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT00354Bean().getCd00001Fwcx()}));
			}		
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();
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
	/**
	 * 点击单选按钮的ajax事件，
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String createByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt00354 t00354 = new Pgt00354();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t00354.setCd00001Fwcx(FWCX);
				t00354.setCd00001Fwcxlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWCX));
				t00354.setCd00001Szqy(ddlSZQY);
				t00354.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t00354.setCd00002Pssd(PSSD);
				t00354Bean = t00354Service.LoadByPrimaryKey(t00354);
				isExists = t00354Bean.getUpddate() == null?true:false;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("createByAjax() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String viewCopy() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("viewCopy()********** start **********");
		}

		try {
			
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("viewCopy() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("viewCopy() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 参数复制功能
	 * @return
	 * @throws Exception
	 */
	public String copyParam() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("copyParam() ********** start **********");
		}
		t00354Bean = new Pgt00354();
		try {
			ReadInfo();
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00354Bean.setSpssd(ddlPSSD);
			t00354Bean.setTpssd(txtPSSD);
			t00354Bean.setCd00001Szqy(ddlSZQY);
			t00354Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00354Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(t00354Service.ExecuteParamCopy(getT00354Bean()))
				this.addActionMessage(getText(Constant.MSG_COPY_OK, new String[]{getT00354Bean().getSpssd()}));
			else
				this.addActionError(getText(Constant.MSG_COPY_NG, new String[]{getT00354Bean().getSpssd()}));
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("copyParam() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("copyParam() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 为参数复制页面赋值
	 */
	private void ReadInfo(){
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		setACTIONNAME("EXET00354COPY");
		setHREFNAME("VIEWT00354");
		setTITLENAME(getText("app.xtwh.t00354.title"));
		setURL("003549");
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t00354Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00354Service getT00354Service() {
		return t00354Service;
	}

	/**
	 * @param t00354Service the t00354Service to set
	 */
	public void setT00354Service(IPgt00354Service t00354Service) {
		this.t00354Service = t00354Service;
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
	 * @return the fwcxList
	 */
	public ArrayList<Pgv00354> getFwcxList() {
		return fwcxList;
	}

	/**
	 * @param fwcxList the fwcxList to set
	 */
	public void setFwcxList(ArrayList<Pgv00354> fwcxList) {
		this.fwcxList = fwcxList;
	}

	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	/**
	 * @return the ddlSZQYFind
	 */
	public String getDdlSZQYFind() {
		return ddlSZQYFind;
	}

	/**
	 * @param ddlSZQYFind the ddlSZQYFind to set
	 */
	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
	}

	/**
	 * @return the txtFWCXFind
	 */
	public String getTxtFWCXFind() {
		return txtFWCXFind;
	}

	/**
	 * @param txtFWCXFind the txtFWCXFind to set
	 */
	public void setTxtFWCXFind(String txtFWCXFind) {
		this.txtFWCXFind = txtFWCXFind;
	}

	/**
	 * @return the txtPSSDFind
	 */
	public String getTxtPSSDFind() {
		return txtPSSDFind;
	}

	/**
	 * @param txtPSSDFind the txtPSSDFind to set
	 */
	public void setTxtPSSDFind(String txtPSSDFind) {
		this.txtPSSDFind = txtPSSDFind;
	}

	/**
	 * @return the t00354Bean
	 */
	public Pgt00354 getT00354Bean() {
		return t00354Bean;
	}

	/**
	 * @param t00354Bean the t00354Bean to set
	 */
	public void setT00354Bean(Pgt00354 t00354Bean) {
		this.t00354Bean = t00354Bean;
	}

	/**
	 * @return the fWCX
	 */
	public String getFWCX() {
		return FWCX;
	}

	/**
	 * @param fWCX the fWCX to set
	 */
	public void setFWCX(String fWCX) {
		FWCX = fWCX;
	}

	/**
	 * @return the sZQY
	 */
	public String getSZQY() {
		return SZQY;
	}

	/**
	 * @param sZQY the sZQY to set
	 */
	public void setSZQY(String sZQY) {
		SZQY = sZQY;
	}

	/**
	 * @return the pSSD
	 */
	public String getPSSD() {
		return PSSD;
	}

	/**
	 * @param pSSD the pSSD to set
	 */
	public void setPSSD(String pSSD) {
		PSSD = pSSD;
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
	 * @return the ddlSZQY
	 */
	public String getDdlSZQY() {
		return ddlSZQY;
	}

	/**
	 * @param ddlSZQY the ddlSZQY to set
	 */
	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}

	/**
	 * @return the txtFWCX
	 */
	public String getTxtFWCX() {
		return txtFWCX;
	}

	/**
	 * @param txtFWCX the txtFWCX to set
	 */
	public void setTxtFWCX(String txtFWCX) {
		this.txtFWCX = txtFWCX;
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
	 * @return the txtUPDATE
	 */
	public String getTxtUPDATE() {
		return txtUPDATE;
	}

	/**
	 * @param txtUPDATE the txtUPDATE to set
	 */
	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
	}

	/**
	 * @return the isExists
	 */
	public Boolean getIsExists() {
		return isExists;
	}

	/**
	 * @param isExists the isExists to set
	 */
	public void setIsExists(Boolean isExists) {
		this.isExists = isExists;
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
	 * @return the aCTIONNAME
	 */
	public String getACTIONNAME() {
		return ACTIONNAME;
	}

	/**
	 * @param aCTIONNAME the aCTIONNAME to set
	 */
	public void setACTIONNAME(String aCTIONNAME) {
		ACTIONNAME = aCTIONNAME;
	}

	/**
	 * @return the hREFNAME
	 */
	public String getHREFNAME() {
		return HREFNAME;
	}

	/**
	 * @param hREFNAME the hREFNAME to set
	 */
	public void setHREFNAME(String hREFNAME) {
		HREFNAME = hREFNAME;
	}

	/**
	 * @return the tITLENAME
	 */
	public String getTITLENAME() {
		return TITLENAME;
	}

	/**
	 * @param tITLENAME the tITLENAME to set
	 */
	public void setTITLENAME(String tITLENAME) {
		TITLENAME = tITLENAME;
	}

	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	/**
	 * @return the ddlPSSD
	 */
	public String getDdlPSSD() {
		return ddlPSSD;
	}

	/**
	 * @param ddlPSSD the ddlPSSD to set
	 */
	public void setDdlPSSD(String ddlPSSD) {
		this.ddlPSSD = ddlPSSD;
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
