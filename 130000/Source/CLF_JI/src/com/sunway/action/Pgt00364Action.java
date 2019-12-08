package com.sunway.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00364Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00364;
import com.sunway.vo.Pgv00052;

public class Pgt00364Action extends ActionSupport implements SessionAware {

	/**
	 * 估价值修正
	 */
	private static final long serialVersionUID = -4441810871653514410L;
	private IPgt00364Service t00364Service;
	private String ACT;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//view
	private ArrayList<Pgt00364> tabList;
	private String ddlSZQYFind;
	//edit
	private Pgt00364 t00364Bean;
	private ArrayList<Pgv00052> szqyList;
	private String txtUPDATE;
	private String ddlSZQY;
	private String txtXZXS;
	private String txtPGXZXS;
	private String txtNOTE;
	private Boolean isExists;
	private String SZQY;
	private String txtXQFind;
	private String XQDM;
	private String txtXQDM;
	
	/**
	 * 
	 */
	public String execute() throws Exception {
		try {
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String executeA() throws Exception {
		try {
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}
	
	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		Pgt00364 t00364 = new Pgt00364();
		try {
			//准备查询条件
			t00364.setCd00001Szqy(ddlSZQYFind);
			t00364.setPageIndex(pageIndex);
			t00364.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			t00364.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = t00364Service.LoadAll(t00364);
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			}else{
				pageCount = 1;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String queryA() throws Exception {
		Pgt00364 t00364 = new Pgt00364();
		try {
			//准备查询条件
			t00364.setCd00001Szqy(ddlSZQYFind);
			t00364.setCd00352Xqdm(txtXQFind);
			t00364.setPageIndex(pageIndex);
			t00364.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			t00364.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = t00364Service.LoadAllA(t00364);
			//分页设置
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				pageIndex = 1;
				rowCount = 0;
			}			
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception{
		try {
			ReadInfo();
			Pgt00364 t00364 = new Pgt00364();
			if(!Constant.MOD_CREATE.equals(ACT)){
				//取得用户选中的数据信息
				t00364.setCd00001Szqy(SZQY);
				t00364Bean = t00364Service.LoadByPrimaryKey(t00364);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
		
	}
	
	
	
	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String createA() throws Exception{
		try {
			ReadInfo();
			if(!Constant.MOD_CREATE.equals(ACT)){
				Pgt00364 t00364 = new Pgt00364();
				t00364.setCd00001Szqy(ddlSZQY);
				t00364.setCd00352Xqdm(XQDM.trim());
				//取得用户选中的数据信息
				t00364Bean = t00364Service.LoadByPrimaryKeyA(t00364);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
		
	}

	/**
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception{
		this.clearErrorsAndMessages();	
		ReadInfo();
		t00364Bean = new Pgt00364();
		t00364Bean.setCd00001Szqy(ddlSZQY);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(ACT)){
			t00364Bean = t00364Service.LoadByPrimaryKey(t00364Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t00364Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.szqy")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00364Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t00364Bean.setCd00001Szqy(ddlSZQY);
			//t00364Bean.setCd00352Xqdm(txtXQFind);
			t00364Bean.setXzxs(BigDecimal.valueOf(Common.convertToDouble(txtXZXS)));
			t00364Bean.setPgxzxs(BigDecimal.valueOf(Common.convertToDouble(txtPGXZXS)));
			t00364Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00364Bean.setNote(txtNOTE);
		}
	}
	
	
	

	
	
	
	
	
	
	
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		try {
			if(Constant.MOD_CREATE.equals(ACT)){			// Create
				if(t00364Service.GetInsertCommand(t00364Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t00364Bean.getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t00364Bean.getCd00001Szqy()}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t00364Service.GetUpdateCommand(t00364Bean)){
					t00364Bean = t00364Service.LoadByPrimaryKey(t00364Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{t00364Bean.getCd00001Szqy()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{t00364Bean.getCd00001Szqy()}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t00364Service.GetDeleteCommand(t00364Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t00364Bean.getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t00364Bean.getCd00001Szqy()}));
			}		
		} catch (Exception e) {
			LOG.error(e.getMessage());
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);
			return INPUT;
		}
		return SUCCESS;
	}	
	
	
	
	
	
	/**
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdateA() throws Exception{
		this.clearErrorsAndMessages();
		ReadInfo();
		t00364Bean = new Pgt00364();
		t00364Bean.setCd00001Szqy(ddlSZQY);
		t00364Bean.setCd00352Xqdm(txtXQDM);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(ACT)){
			t00364Bean = t00364Service.LoadByPrimaryKeyA(t00364Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t00364Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.szqy")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00364Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t00364Bean.setCd00001Szqy(ddlSZQY);
			t00364Bean.setXzxs(BigDecimal.valueOf(Common.convertToDouble(txtXZXS)));
			t00364Bean.setPgxzxs(BigDecimal.valueOf(Common.convertToDouble(txtPGXZXS)));
			t00364Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00364Bean.setNote(txtNOTE);
			t00364Bean.setCd00352Xqdm(txtXQDM);
		}
	}
	
	
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String updateA() throws Exception {
		try {
			if(Constant.MOD_CREATE.equals(ACT)){			// Create
				if(t00364Service.GetInsertCommandA(t00364Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t00364Bean.getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t00364Bean.getCd00001Szqy()}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t00364Service.GetUpdateCommandA(t00364Bean)){
					t00364Bean = t00364Service.LoadByPrimaryKeyA(t00364Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{t00364Bean.getCd00001Szqy()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{t00364Bean.getCd00001Szqy()}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t00364Service.GetDeleteCommandA(t00364Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t00364Bean.getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t00364Bean.getCd00001Szqy()}));
			}		
		} catch (Exception e) {
			LOG.error(e.getMessage());
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);
			return INPUT;
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
		
		Pgt00364 t00364 = new Pgt00364();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t00364.setCd00001Szqy(ddlSZQY);
				t00364Bean = t00364Service.LoadByPrimaryKey(t00364);
				isExists = t00364Bean.getUpddate() == null?true:false;
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

	
	
	
	/**
	 * 点击单选按钮的ajax事件，
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String createByAjaxA() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt00364 t00364 = new Pgt00364();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t00364.setCd00001Szqy(ddlSZQY);
				t00364.setCd00352Xqdm(txtXQDM);
				t00364Bean = t00364Service.LoadByPrimaryKeyA(t00364);
				isExists = t00364Bean.getUpddate() == null?true:false;
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
	
	@Override
	public void setSession(Map<String, Object> session) {
		sessionCtrl.appSession = session;
	}
	/**
	 * 读取【所在区域】
	 */
	private void ReadInfo() {
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	
	/**************** set and get *********************/
	
	/**
	 * @return the t00364Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00364Service getT00364Service() {
		return t00364Service;
	}
	/**
	 * @param t00364Service the t00364Service to set
	 */
	public void setT00364Service(IPgt00364Service t00364Service) {
		this.t00364Service = t00364Service;
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
	 * @return the sessionCtrl
	 */
	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}
	/**
	 * @param sessionCtrl the sessionCtrl to set
	 */
	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
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
	 * @return the tabList
	 */
	public ArrayList<Pgt00364> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgt00364> tabList) {
		this.tabList = tabList;
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
	 * @return the t00364Bean
	 */
	public Pgt00364 getT00364Bean() {
		return t00364Bean;
	}
	/**
	 * @param t00364Bean the t00364Bean to set
	 */
	public void setT00364Bean(Pgt00364 t00364Bean) {
		this.t00364Bean = t00364Bean;
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
	public String getTxtPGXZXS() {
		return txtPGXZXS;
	}
	public void setTxtPGXZXS(String txtPGXZXS) {
		this.txtPGXZXS = txtPGXZXS;
	}
	public String getTxtXQFind() {
		return txtXQFind;
	}




	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}

	public String getXQDM() {
		return XQDM;
	}




	public void setXQDM(String xQDM) {
		XQDM = xQDM;
	}
	public String getTxtXQDM() {
		return txtXQDM;
	}




	public void setTxtXQDM(String txtXQDM) {
		this.txtXQDM = txtXQDM;
	}




}
