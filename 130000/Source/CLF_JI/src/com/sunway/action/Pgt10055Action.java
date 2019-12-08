package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt10055Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt10055;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv10055;

/**
 * 成本法土地基准地价(Pgt10055)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt10055Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -256283290442855886L;

	//Service
	private IPgt10055Service t10055Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv10055> jzdjList;
	private ArrayList<Pgv00052> szqyList;
	//查询条件
	private String ddlSZQYFind;
	private String txtTDYTFind;
	private String txtTDDJFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt10055 t10055Bean;
	//primary key 主键
	private String TDYT;
	private String TDDJ;
	private String SZQY;
	private String ACT;
	//表单提交数据
	private String txtTDYT;
	private String txtTDDJ;
	private String ddlSZQY;
	private String txtNOTE;
	private String txtUPDATE;
	private String txtJZDJ;
	private String txtLMDJ;
	private String txtPJRJL;
	private String txtCQF;
	private String txtFWMS;
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
		
		Pgv10055 v10055 = new Pgv10055();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v10055.setCd00001Szqy(ddlSZQYFind);
			v10055.setCd00001Tdyt(txtTDYTFind);
			v10055.setCd00001Tddj(txtTDDJFind);
			v10055.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v10055.setPageIndex(pageIndex);
			v10055.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v10055.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			jzdjList = t10055Service.LoadAll(v10055);
			
			//分页设置
			if(null!=jzdjList && jzdjList.size()>0){
				rowCount = jzdjList.get(0).getRecordCount();
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
		
		Pgt10055 t10055 = new Pgt10055();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t10055.setCd00001Tdyt(TDYT);
				t10055.setCd00001Tdytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDYT));
				t10055.setCd00001Tddj(TDDJ);
				t10055.setCd00001Tddjlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDDJ));
				t10055.setCd00001Szqy(SZQY);
				t10055.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t10055.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t10055Bean = t10055Service.LoadByPrimaryKey(t10055);
				if (Common.isNullOrEmpty(t10055Bean.getUpddate())) {
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
		t10055Bean = new Pgt10055();
		this.clearErrorsAndMessages();	
		t10055Bean.setCd00001Tdyt(TDYT);
		t10055Bean.setCd00001Tdytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDYT));
		t10055Bean.setCd00001Tddj(TDDJ);
		t10055Bean.setCd00001Tddjlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDDJ));
		t10055Bean.setCd00001Szqy(ddlSZQY);
		t10055Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		t10055Bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t10055Bean = t10055Service.LoadByPrimaryKey(t10055Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t10055Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.tdyt")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t10055Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t10055Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t10055Bean.setNote(Common.convertEncoding(txtNOTE));
			t10055Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t10055Bean.setJzdj(Common.convertToDouble(txtJZDJ));
			t10055Bean.setLmdj(Common.convertToDouble(txtLMDJ));
			t10055Bean.setPjrjl(Common.convertToDouble(txtPJRJL));
			t10055Bean.setCqf(Common.convertToDouble(txtCQF));
			t10055Bean.setFwms(Common.convertEncoding(txtFWMS));
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
				if(t10055Service.GetInsertCommand(getT10055Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT10055Bean().getCd00001Tdyt()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT10055Bean().getCd00001Tdyt()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t10055Service.GetUpdateCommand(getT10055Bean())){
					t10055Bean = t10055Service.LoadByPrimaryKey(t10055Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT10055Bean().getCd00001Tdyt()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT10055Bean().getCd00001Tdyt()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t10055Service.GetDeleteCommand(getT10055Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT10055Bean().getCd00001Tdyt()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT10055Bean().getCd00001Tdyt()}));
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
		
		Pgt10055 t10055 = new Pgt10055();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t10055.setCd00001Tdyt(TDYT);
				t10055.setCd00001Tdytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDYT));
				t10055.setCd00001Tddj(TDDJ);
				t10055.setCd00001Tddjlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDDJ));
				t10055.setCd00001Szqy(ddlSZQY);
				t10055.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t10055.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t10055Bean = t10055Service.LoadByPrimaryKey(t10055);
				isExists = t10055Bean.getUpddate() == null?true:false;
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
			LOG.debug("viewCopy() ********** start **********");
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
		t10055Bean = new Pgt10055();
		try {
			ReadInfo();
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t10055Bean.setSpssd(ddlPSSD);
			t10055Bean.setTpssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t10055Bean.setCd00001Szqy(ddlSZQY);
			t10055Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t10055Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(t10055Service.ExecuteParamCopy(getT10055Bean()))
				this.addActionMessage(getText(Constant.MSG_COPY_OK, new String[]{getT10055Bean().getSpssd()}));
			else
				this.addActionError(getText(Constant.MSG_COPY_NG, new String[]{getT10055Bean().getSpssd()}));
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
		setACTIONNAME("EXET10055COPY");
		setHREFNAME("VIEWT10055");
		setTITLENAME(getText("app.xtwh.t10055.title"));
		setURL("100559");
		szqyList = sessionCtrl.ReadSzqyList();
	}
	/*********************** set and get ******************************/
	
	/**
	 * @return the t10055Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt10055Service getT10055Service() {
		return t10055Service;
	}

	/**
	 * @param t10055Service the t10055Service to set
	 */
	public void setT10055Service(IPgt10055Service t10055Service) {
		this.t10055Service = t10055Service;
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
	 * @return the jzdjList
	 */
	public ArrayList<Pgv10055> getJzdjList() {
		return jzdjList;
	}

	/**
	 * @param jzdjList the jzdjList to set
	 */
	public void setJzdjList(ArrayList<Pgv10055> jzdjList) {
		this.jzdjList = jzdjList;
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
	 * @return the txtTDYTFind
	 */
	public String getTxtTDYTFind() {
		return txtTDYTFind;
	}

	/**
	 * @param txtTDYTFind the txtTDYTFind to set
	 */
	public void setTxtTDYTFind(String txtTDYTFind) {
		this.txtTDYTFind = txtTDYTFind;
	}

	/**
	 * @return the txtTDDJFind
	 */
	public String getTxtTDDJFind() {
		return txtTDDJFind;
	}

	/**
	 * @param txtTDDJFind the txtTDDJFind to set
	 */
	public void setTxtTDDJFind(String txtTDDJFind) {
		this.txtTDDJFind = txtTDDJFind;
	}

	/**
	 * @return the t10055Bean
	 */
	public Pgt10055 getT10055Bean() {
		return t10055Bean;
	}

	/**
	 * @param t10055Bean the t10055Bean to set
	 */
	public void setT10055Bean(Pgt10055 t10055Bean) {
		this.t10055Bean = t10055Bean;
	}

	/**
	 * @return the tDYT
	 */
	public String getTDYT() {
		return TDYT;
	}

	/**
	 * @param tDYT the tDYT to set
	 */
	public void setTDYT(String tDYT) {
		TDYT = tDYT;
	}

	/**
	 * @return the tDDJ
	 */
	public String getTDDJ() {
		return TDDJ;
	}

	/**
	 * @param tDDJ the tDDJ to set
	 */
	public void setTDDJ(String tDDJ) {
		TDDJ = tDDJ;
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
	 * @return the txtTDYT
	 */
	public String getTxtTDYT() {
		return txtTDYT;
	}

	/**
	 * @param txtTDYT the txtTDYT to set
	 */
	public void setTxtTDYT(String txtTDYT) {
		this.txtTDYT = txtTDYT;
	}

	/**
	 * @return the txtTDDJ
	 */
	public String getTxtTDDJ() {
		return txtTDDJ;
	}

	/**
	 * @param txtTDDJ the txtTDDJ to set
	 */
	public void setTxtTDDJ(String txtTDDJ) {
		this.txtTDDJ = txtTDDJ;
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
	 * @return the txtJZDJ
	 */
	public String getTxtJZDJ() {
		return txtJZDJ;
	}

	/**
	 * @param txtJZDJ the txtJZDJ to set
	 */
	public void setTxtJZDJ(String txtJZDJ) {
		this.txtJZDJ = txtJZDJ;
	}

	/**
	 * @return the txtLMDJ
	 */
	public String getTxtLMDJ() {
		return txtLMDJ;
	}

	/**
	 * @param txtLMDJ the txtLMDJ to set
	 */
	public void setTxtLMDJ(String txtLMDJ) {
		this.txtLMDJ = txtLMDJ;
	}

	/**
	 * @return the txtPJRJL
	 */
	public String getTxtPJRJL() {
		return txtPJRJL;
	}

	/**
	 * @param txtPJRJL the txtPJRJL to set
	 */
	public void setTxtPJRJL(String txtPJRJL) {
		this.txtPJRJL = txtPJRJL;
	}

	/**
	 * @return the txtCQF
	 */
	public String getTxtCQF() {
		return txtCQF;
	}

	/**
	 * @param txtCQF the txtCQF to set
	 */
	public void setTxtCQF(String txtCQF) {
		this.txtCQF = txtCQF;
	}

	/**
	 * @return the txtFWMS
	 */
	public String getTxtFWMS() {
		return txtFWMS;
	}

	/**
	 * @param txtFWMS the txtFWMS to set
	 */
	public void setTxtFWMS(String txtFWMS) {
		this.txtFWMS = txtFWMS;
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
