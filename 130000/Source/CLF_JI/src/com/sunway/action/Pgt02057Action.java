package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02057Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02057;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02057;

/**
 * 收益法资本化率维护(Pgt02057)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt02057Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -1876010691133290710L;

	//Service
	private IPgt02057Service t02057Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv02057> zbhlList;
	private ArrayList<Pgv00052> szqyList;
	//查询条件
	private String ddlSZQYFind;
	private String txtFWYTFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt02057 t02057Bean;
	//primary key 主键
	private String FWYT;
	private String SZQY;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String txtFWYT;
	private String txtNOTE;
	private String txtUPDATE;
	private String txtZBHL;
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
		
		Pgv02057 v02057 = new Pgv02057();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v02057.setCd00001Szqy(ddlSZQYFind);
			v02057.setCd00001Fwyt(txtFWYTFind);
			v02057.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v02057.setPageIndex(pageIndex);
			v02057.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v02057.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			zbhlList = t02057Service.LoadAll(v02057);
			
			//分页设置
			if(null!=zbhlList && zbhlList.size()>0){
				rowCount = zbhlList.get(0).getRecordCount();
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
		
		Pgt02057 t02057 = new Pgt02057();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02057.setCd00001Fwyt(FWYT);
				t02057.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
				t02057.setCd00001Szqy(SZQY);
				t02057.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t02057.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t02057Bean = t02057Service.LoadByPrimaryKey(t02057);
				if (Common.isNullOrEmpty(t02057Bean.getUpddate())) {
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
		t02057Bean = new Pgt02057();
		this.clearErrorsAndMessages();	
		t02057Bean.setCd00001Fwyt(FWYT);
		t02057Bean.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
		t02057Bean.setCd00001Szqy(ddlSZQY);
		t02057Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		t02057Bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02057Bean = t02057Service.LoadByPrimaryKey(t02057Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t02057Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.fwyt")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02057Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02057Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02057Bean.setZbhl(Common.convertToDouble(txtZBHL));
			t02057Bean.setNote(Common.convertEncoding(txtNOTE));
			t02057Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if(t02057Service.GetInsertCommand(getT02057Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT02057Bean().getCd00001Fwyt()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT02057Bean().getCd00001Fwyt()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02057Service.GetUpdateCommand(getT02057Bean())){
					t02057Bean = t02057Service.LoadByPrimaryKey(t02057Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT02057Bean().getCd00001Fwyt()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT02057Bean().getCd00001Fwyt()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02057Service.GetDeleteCommand(getT02057Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT02057Bean().getCd00001Fwyt()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT02057Bean().getCd00001Fwyt()}));
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
		
		Pgt02057 t02057 = new Pgt02057();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t02057.setCd00001Fwyt(FWYT);
				t02057.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
				t02057.setCd00001Szqy(ddlSZQY);
				t02057.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t02057.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t02057Bean = t02057Service.LoadByPrimaryKey(t02057);
				isExists = t02057Bean.getUpddate() == null?true:false;
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
		t02057Bean = new Pgt02057();
		try {
			ReadInfo();
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t02057Bean.setSpssd(ddlPSSD);
			t02057Bean.setTpssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t02057Bean.setCd00001Szqy(ddlSZQY);
			t02057Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02057Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(t02057Service.ExecuteParamCopy(getT02057Bean()))
				this.addActionMessage(getText(Constant.MSG_COPY_OK, new String[]{getT02057Bean().getSpssd()}));
			else
				this.addActionError(getText(Constant.MSG_COPY_NG, new String[]{getT02057Bean().getSpssd()}));
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
		setACTIONNAME("EXET02057COPY");
		setHREFNAME("VIEWT02057");
		setTITLENAME(getText("app.xtwh.t02057.title"));
		setURL("020579");
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t02057Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02057Service getT02057Service() {
		return t02057Service;
	}

	/**
	 * @param t02057Service the t02057Service to set
	 */
	public void setT02057Service(IPgt02057Service t02057Service) {
		this.t02057Service = t02057Service;
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
	 * @return the zbhlList
	 */
	public ArrayList<Pgv02057> getJjfyblList() {
		return zbhlList;
	}

	/**
	 * @param zbhlList the zbhlList to set
	 */
	public void setJjfyblList(ArrayList<Pgv02057> zbhlList) {
		this.zbhlList = zbhlList;
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
	 * @return the t02057Bean
	 */
	public Pgt02057 getT02057Bean() {
		return t02057Bean;
	}

	/**
	 * @param t02057Bean the t02057Bean to set
	 */
	public void setT02057Bean(Pgt02057 t02057Bean) {
		this.t02057Bean = t02057Bean;
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
	 * @return the txtZBHL
	 */
	public String getTxtFYBL() {
		return txtZBHL;
	}

	/**
	 * @param txtZBHL the txtZBHL to set
	 */
	public void setTxtFYBL(String txtZBHL) {
		this.txtZBHL = txtZBHL;
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
	 * @return the zbhlList
	 */
	public ArrayList<Pgv02057> getZbhlList() {
		return zbhlList;
	}

	/**
	 * @param zbhlList the zbhlList to set
	 */
	public void setZbhlList(ArrayList<Pgv02057> zbhlList) {
		this.zbhlList = zbhlList;
	}

	/**
	 * @return the txtZBHL
	 */
	public String getTxtZBHL() {
		return txtZBHL;
	}

	/**
	 * @param txtZBHL the txtZBHL to set
	 */
	public void setTxtZBHL(String txtZBHL) {
		this.txtZBHL = txtZBHL;
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
