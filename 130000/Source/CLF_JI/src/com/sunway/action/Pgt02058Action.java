package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02058Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02058;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02058;

/**
 * 收益法综合修正维护(Pgt02058)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt02058Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3543247945496771099L;

	//Service
	private IPgt02058Service t02058Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv02058> zhxzList;
	private ArrayList<Pgv00052> szqyList;
	//查询条件
	private String ddlSZQYFind;
	private String txtFWYTFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt02058 t02058Bean;
	//primary key 主键
	private String FWYT;
	private String SZQY;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String txtFWYT;
	private String txtNOTE;
	private String txtUPDATE;
	private Boolean rdoCX;
	private Boolean rdoSS;
	private Boolean rdoLC;
	private Boolean rdoMJ;
	private Boolean rdoXJBZ;
	private String ddlSZQY;
	private Boolean isExists;
	
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
		
		Pgv02058 v02058 = new Pgv02058();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v02058.setCd00001Szqy(ddlSZQYFind);
			v02058.setCd00001Fwyt(txtFWYTFind);
			v02058.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v02058.setPageIndex(pageIndex);
			v02058.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v02058.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			zhxzList = t02058Service.LoadAll(v02058);
			
			//分页设置
			if(null!=zhxzList && zhxzList.size()>0){
				rowCount = zhxzList.get(0).getRecordCount();
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			}else{
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
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	
	public String create() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		
		Pgt02058 t02058 = new Pgt02058();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02058.setCd00001Fwyt(FWYT);
				t02058.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
				t02058.setCd00001Szqy(SZQY);
				t02058.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t02058.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t02058Bean = t02058Service.LoadByPrimaryKey(t02058);
				if (Common.isNullOrEmpty(t02058Bean.getUpddate())) {
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
		t02058Bean = new Pgt02058();
		this.clearErrorsAndMessages();	
		t02058Bean.setCd00001Fwyt(FWYT);
		t02058Bean.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
		t02058Bean.setCd00001Szqy(ddlSZQY);
		t02058Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		t02058Bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02058Bean = t02058Service.LoadByPrimaryKey(t02058Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t02058Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.fwyt")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02058Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02058Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02058Bean.setCx(rdoCX);
			t02058Bean.setSs(rdoSS);
			t02058Bean.setLc(rdoLC);
			t02058Bean.setXjbz(rdoXJBZ);
			t02058Bean.setMj(rdoMJ);
			t02058Bean.setNote(Common.convertEncoding(txtNOTE));
			t02058Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if(t02058Service.GetInsertCommand(getT02058Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT02058Bean().getCd00001Fwyt()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT02058Bean().getCd00001Fwyt()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02058Service.GetUpdateCommand(getT02058Bean())){
					t02058Bean = t02058Service.LoadByPrimaryKey(t02058Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT02058Bean().getCd00001Fwyt()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT02058Bean().getCd00001Fwyt()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02058Service.GetDeleteCommand(getT02058Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT02058Bean().getCd00001Fwyt()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT02058Bean().getCd00001Fwyt()}));
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
		
		Pgt02058 t02058 = new Pgt02058();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t02058.setCd00001Fwyt(FWYT);
				t02058.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
				t02058.setCd00001Szqy(ddlSZQY);
				t02058.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t02058.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t02058Bean = t02058Service.LoadByPrimaryKey(t02058);
				isExists = t02058Bean.getUpddate() == null?true:false;
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
		t02058Bean = new Pgt02058();
		try {
			ReadInfo();
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t02058Bean.setSpssd(ddlPSSD);
			t02058Bean.setTpssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t02058Bean.setCd00001Szqy(ddlSZQY);
			t02058Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02058Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(t02058Service.ExecuteParamCopy(getT02058Bean()))
				this.addActionMessage(getText(Constant.MSG_COPY_OK, new String[]{getT02058Bean().getSpssd()}));
			else
				this.addActionError(getText(Constant.MSG_COPY_NG, new String[]{getT02058Bean().getSpssd()}));
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
		setACTIONNAME("EXET02058COPY");
		setHREFNAME("VIEWT02058");
		setTITLENAME(getText("app.xtwh.t02058.title"));
		setURL("020589");
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
/*********************** set and get ******************************/
	
	/**
	 * @return the t02058Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02058Service getT02058Service() {
		return t02058Service;
	}

	/**
	 * @param t02058Service the t02058Service to set
	 */
	public void setT02058Service(IPgt02058Service t02058Service) {
		this.t02058Service = t02058Service;
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
	 * @return the zhxzList
	 */
	public ArrayList<Pgv02058> getZhxzList() {
		return zhxzList;
	}

	/**
	 * @param zhxzList the zhxzList to set
	 */
	public void setZhxzList(ArrayList<Pgv02058> zhxzList) {
		this.zhxzList = zhxzList;
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
	 * @return the txtFWYTFind
	 */
	public String getTxtFWYTFind() {
		return txtFWYTFind;
	}

	/**
	 * @param txtFWYTFind the txtFWYTFind to set
	 */
	public void setTxtFWYTFind(String txtFWYTFind) {
		this.txtFWYTFind = txtFWYTFind;
	}

	/**
	 * @return the t02058Bean
	 */
	public Pgt02058 getT02058Bean() {
		return t02058Bean;
	}

	/**
	 * @param t02058Bean the t02058Bean to set
	 */
	public void setT02058Bean(Pgt02058 t02058Bean) {
		this.t02058Bean = t02058Bean;
	}

	/**
	 * @return the fWYT
	 */
	public String getFWYT() {
		return FWYT;
	}

	/**
	 * @param fWYT the fWYT to set
	 */
	public void setFWYT(String fWYT) {
		FWYT = fWYT;
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
	 * @return the txtFWYT
	 */
	public String getTxtFWYT() {
		return txtFWYT;
	}

	/**
	 * @param txtFWYT the txtFWYT to set
	 */
	public void setTxtFWYT(String txtFWYT) {
		this.txtFWYT = txtFWYT;
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
	 * @return the rdoCX
	 */
	public Boolean getRdoCX() {
		return rdoCX;
	}

	/**
	 * @param rdoCX the rdoCX to set
	 */
	public void setRdoCX(Boolean rdoCX) {
		this.rdoCX = rdoCX;
	}

	/**
	 * @return the rdoSS
	 */
	public Boolean getRdoSS() {
		return rdoSS;
	}

	/**
	 * @param rdoSS the rdoSS to set
	 */
	public void setRdoSS(Boolean rdoSS) {
		this.rdoSS = rdoSS;
	}

	/**
	 * @return the rdoLC
	 */
	public Boolean getRdoLC() {
		return rdoLC;
	}

	/**
	 * @param rdoLC the rdoLC to set
	 */
	public void setRdoLC(Boolean rdoLC) {
		this.rdoLC = rdoLC;
	}

	/**
	 * @return the rdoMJ
	 */
	public Boolean getRdoMJ() {
		return rdoMJ;
	}

	/**
	 * @param rdoMJ the rdoMJ to set
	 */
	public void setRdoMJ(Boolean rdoMJ) {
		this.rdoMJ = rdoMJ;
	}

	/**
	 * @return the rdoXJBZ
	 */
	public Boolean getRdoXJBZ() {
		return rdoXJBZ;
	}

	/**
	 * @param rdoXJBZ the rdoXJBZ to set
	 */
	public void setRdoXJBZ(Boolean rdoXJBZ) {
		this.rdoXJBZ = rdoXJBZ;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
