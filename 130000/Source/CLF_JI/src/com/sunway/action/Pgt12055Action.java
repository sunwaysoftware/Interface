package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12055Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12055;
import com.sunway.vo.Pgv12055;

/**
 * 成本法、收益法评税分类(Pgt12055)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt12055Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 8816518711042274150L;

	//Service
	private IPgt12055Service t12055Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv12055> pglxList;
	//查询条件
	private String txtFWYTFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt12055 t12055Bean;
	//primary key 主键
	private String FWYT;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String txtNOTE;
	private String txtUPDATE;
	private String rdoSFCBPG;
	private String rdoSFSYPG;
	private Boolean isExists;
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
		
		Pgv12055 v12055 = new Pgv12055();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v12055.setCd00001Fwyt(txtFWYTFind);
			v12055.setPageIndex(pageIndex);
			v12055.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			//执行查询
			pglxList = t12055Service.LoadAll(v12055);
			
			//分页设置
			if(null!=pglxList && pglxList.size()>0){
				rowCount = pglxList.get(0).getRecordCount();
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
		
		Pgt12055 t12055 = new Pgt12055();
		t12055Bean = new Pgt12055();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t12055.setCd00001Fwyt(FWYT);
				t12055.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
				t12055Bean = t12055Service.LoadByPrimaryKey(t12055);
				if (Common.isNullOrEmpty(t12055Bean.getUpddate())) {
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
		t12055Bean = new Pgt12055();
		this.clearErrorsAndMessages();	
		t12055Bean.setCd00001Fwyt(FWYT);
		t12055Bean.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t12055Bean = t12055Service.LoadByPrimaryKey(t12055Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t12055Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.fwyt")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t12055Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t12055Bean.setSfcbpg(Common.convertToBoolean(rdoSFCBPG));
			t12055Bean.setSfsypg(Common.convertToBoolean(rdoSFSYPG));
			t12055Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t12055Bean.setNote(Common.convertEncoding(txtNOTE));
			t12055Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if(t12055Service.GetInsertCommand(getT12055Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT12055Bean().getCd00001Fwyt()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT12055Bean().getCd00001Fwyt()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t12055Service.GetUpdateCommand(getT12055Bean())){
					t12055Bean = t12055Service.LoadByPrimaryKey(t12055Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT12055Bean().getCd00001Fwyt()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT12055Bean().getCd00001Fwyt()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t12055Service.GetDeleteCommand(getT12055Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT12055Bean().getCd00001Fwyt()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT12055Bean().getCd00001Fwyt()}));
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
		
		Pgt12055 t12055 = new Pgt12055();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t12055.setCd00001Fwyt(FWYT);
				t12055.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
				t12055Bean = t12055Service.LoadByPrimaryKey(t12055);
				isExists = t12055Bean.getUpddate() == null?true:false;
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
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t12055Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12055Service getT12055Service() {
		return t12055Service;
	}

	/**
	 * @param t12055Service the t12055Service to set
	 */
	public void setT12055Service(IPgt12055Service t12055Service) {
		this.t12055Service = t12055Service;
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
	 * @return the pglxList
	 */
	public ArrayList<Pgv12055> getJazjList() {
		return pglxList;
	}

	/**
	 * @param pglxList the pglxList to set
	 */
	public void setJazjList(ArrayList<Pgv12055> pglxList) {
		this.pglxList = pglxList;
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
	 * @return the pglxList
	 */
	public ArrayList<Pgv12055> getPglxList() {
		return pglxList;
	}

	/**
	 * @param pglxList the pglxList to set
	 */
	public void setPglxList(ArrayList<Pgv12055> pglxList) {
		this.pglxList = pglxList;
	}

	/**
	 * @return the t12055Bean
	 */
	public Pgt12055 getT12055Bean() {
		return t12055Bean;
	}

	/**
	 * @param t12055Bean the t12055Bean to set
	 */
	public void setT12055Bean(Pgt12055 t12055Bean) {
		this.t12055Bean = t12055Bean;
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
	 * @return the rdoSFCBPG
	 */
	public String getRdoSFCBPG() {
		return rdoSFCBPG;
	}

	/**
	 * @param rdoSFCBPG the rdoSFCBPG to set
	 */
	public void setRdoSFCBPG(String rdoSFCBPG) {
		this.rdoSFCBPG = rdoSFCBPG;
	}

	/**
	 * @return the rdoSFSYPG
	 */
	public String getRdoSFSYPG() {
		return rdoSFSYPG;
	}

	/**
	 * @param rdoSFSYPG the rdoSFSYPG to set
	 */
	public void setRdoSFSYPG(String rdoSFSYPG) {
		this.rdoSFSYPG = rdoSFSYPG;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}


}
