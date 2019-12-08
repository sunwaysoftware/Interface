package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt10051Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt10051;
import com.sunway.vo.Pgv10051;

/**
 * 成本法残值率维护(Pgt10051)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt10051Action extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -6767919681024424733L;

	//Service
	private IPgt10051Service t10051Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv10051> czlList;
	//查询条件
	private String txtJZJGFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt10051 t10051Bean;
	//primary key 主键
	private String JZJG;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String txtJZJG;
	private String txtNOTE;
	private String txtUPDATE;
	private String txtCZL;
	private Boolean isExists;
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
		
		Pgv10051 v10051 = new Pgv10051();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v10051.setCd00001Jzjg(txtJZJGFind);
			v10051.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v10051.setPageIndex(pageIndex);
			v10051.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			//执行查询
			czlList = t10051Service.LoadAll(v10051);
			//分页设置
			if(null!=czlList && czlList.size()>0){
				rowCount = czlList.get(0).getRecordCount();
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
		
		Pgt10051 t10051 = new Pgt10051();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t10051.setCd00001Jzjg(JZJG);
				t10051.setCd00001Jzjglx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_JZJG));
				t10051.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t10051Bean = t10051Service.LoadByPrimaryKey(t10051);
				if (Common.isNullOrEmpty(t10051Bean.getUpddate())) {
					setACT(Constant.MOD_CREATE);
				}
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
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t10051Bean = new Pgt10051();
		this.clearErrorsAndMessages();	
		t10051Bean.setCd00001Jzjg(JZJG);
		t10051Bean.setCd00001Jzjglx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_JZJG));
		t10051Bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t10051Bean = t10051Service.LoadByPrimaryKey(t10051Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t10051Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.jzjg")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t10051Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t10051Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t10051Bean.setNote(Common.convertEncoding(txtNOTE));
			t10051Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t10051Bean.setCzl(Common.convertToDouble(txtCZL));
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
				if(t10051Service.GetInsertCommand(getT10051Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT10051Bean().getCd00001Jzjg()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT10051Bean().getCd00001Jzjg()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t10051Service.GetUpdateCommand(getT10051Bean())){
					t10051Bean = t10051Service.LoadByPrimaryKey(t10051Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT10051Bean().getCd00001Jzjg()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT10051Bean().getCd00001Jzjg()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t10051Service.GetDeleteCommand(getT10051Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT10051Bean().getCd00001Jzjg()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT10051Bean().getCd00001Jzjg()}));
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
		
		Pgt10051 t10051 = new Pgt10051();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t10051.setCd00001Jzjg(JZJG);
				t10051.setCd00001Jzjglx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_JZJG));
				t10051.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t10051Bean = t10051Service.LoadByPrimaryKey(t10051);
				isExists = t10051Bean.getUpddate() == null?true:false;
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
			setURL("100519");
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
		t10051Bean = new Pgt10051();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			setURL("100519");
			t10051Bean.setSpssd(ddlPSSD);
			t10051Bean.setTpssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t10051Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t10051Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(t10051Service.ExecuteParamCopy(t10051Bean))
				this.addActionMessage(getText("app.msg.copy.ok", new String[]{getT10051Bean().getSpssd()}));
			else
				this.addActionError(getText("app.msg.copy.ng", new String[]{getT10051Bean().getSpssd()}));
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
	
	/*********************** set and get ******************************/

	/**
	 * @return the t10051Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt10051Service getT10051Service() {
		return t10051Service;
	}

	/**
	 * @param t10051Service the t10051Service to set
	 */
	public void setT10051Service(IPgt10051Service t10051Service) {
		this.t10051Service = t10051Service;
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
	 * @return the czlList
	 */
	public ArrayList<Pgv10051> getCzlList() {
		return czlList;
	}

	/**
	 * @param czlList the czlList to set
	 */
	public void setCzlList(ArrayList<Pgv10051> czlList) {
		this.czlList = czlList;
	}

	/**
	 * @return the txtJZJGFind
	 */
	public String getTxtJZJGFind() {
		return txtJZJGFind;
	}

	/**
	 * @param txtJZJGFind the txtJZJGFind to set
	 */
	public void setTxtJZJGFind(String txtJZJGFind) {
		this.txtJZJGFind = txtJZJGFind;
	}

	/**
	 * @return the t10051Bean
	 */
	public Pgt10051 getT10051Bean() {
		return t10051Bean;
	}

	/**
	 * @param t10051Bean the t10051Bean to set
	 */
	public void setT10051Bean(Pgt10051 t10051Bean) {
		this.t10051Bean = t10051Bean;
	}

	/**
	 * @return the jZJG
	 */
	public String getJZJG() {
		return JZJG;
	}

	/**
	 * @param jZJG the jZJG to set
	 */
	public void setJZJG(String jZJG) {
		JZJG = jZJG;
	}

	/**
	 * @return the txtJZJG
	 */
	public String getTxtJZJG() {
		return txtJZJG;
	}

	/**
	 * @param txtJZJG the txtJZJG to set
	 */
	public void setTxtJZJG(String txtJZJG) {
		this.txtJZJG = txtJZJG;
	}

	/**
	 * @return the txtCZL
	 */
	public String getTxtCZL() {
		return txtCZL;
	}

	/**
	 * @param txtCZL the txtCZL to set
	 */
	public void setTxtCZL(String txtCZL) {
		this.txtCZL = txtCZL;
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
