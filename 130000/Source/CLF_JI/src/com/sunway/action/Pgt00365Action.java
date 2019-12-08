package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00365Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00365;
import com.sunway.vo.Pgv00052;

public class Pgt00365Action extends ActionSupport implements SessionAware {

	/**
	 * 估价值修正
	 */
	private static final long serialVersionUID = -4441810871653514410L;
	private IPgt00365Service t00365Service;
	private String ACT;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//view
	private ArrayList<Pgt00365> tabList;
	private String ddlSZQYFind;
	//edit
	private Pgt00365 t00365Bean;
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
	private String rdoJJF;
	
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
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		Pgt00365 t00365 = new Pgt00365();
		try {
			//准备查询条件
			t00365.setCd00001Szqy(ddlSZQYFind);
			t00365.setPageIndex(pageIndex);
			t00365.setCd00352Xqdm(txtXQFind);
			t00365.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			t00365.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			tabList = t00365Service.LoadAll(t00365);
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
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception{
		try {
			ReadInfo();
			Pgt00365 t00365 = new Pgt00365();
			if(!Constant.MOD_CREATE.equals(ACT)){
				//取得用户选中的数据信息
				t00365.setCd00352Xqdm(XQDM);
				t00365Bean = t00365Service.LoadByPrimaryKey(t00365);
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
		t00365Bean = new Pgt00365(ddlSZQY);
		//根据PK信息，为数据BEAN赋值
		t00365Bean.setCd00352Xqdm(txtXQDM);
		if (!Constant.MOD_DELETE.equals(ACT)){
			t00365Bean = t00365Service.LoadByPrimaryKey(t00365Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t00365Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.szqy")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t00365Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t00365Bean.setCd00001Szqy(ddlSZQY);
			t00365Bean.setCd00352Xqdm(txtXQDM);
			t00365Bean.setXzxs(Common.convertToInteger(rdoJJF));
			t00365Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00365Bean.setNote(txtNOTE);
		}
	}
	
	
	

	
	
	
	
	
	
	
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		String rtn = "success";
		try {
			if(Constant.MOD_CREATE.equals(ACT)){			// Create
				if(t00365Service.GetInsertCommand(t00365Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t00365Bean.getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t00365Bean.getCd00001Szqy()}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t00365Service.GetUpdateCommand(t00365Bean)){
					t00365Bean = t00365Service.LoadByPrimaryKey(t00365Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{t00365Bean.getCd00001Szqy()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{t00365Bean.getCd00001Szqy()}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t00365Service.GetDeleteCommand(t00365Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t00365Bean.getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t00365Bean.getCd00001Szqy()}));
			    	
				rtn = "successDEL";
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);
			return INPUT;
		}
		return rtn;
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
		
		Pgt00365 t00365 = new Pgt00365();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t00365.setCd00352Xqdm(txtXQDM);
				t00365Bean = t00365Service.LoadByPrimaryKey(t00365);
				isExists = t00365Bean.getUpddate() == null?true:false;
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
	 * @return the t00365Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00365Service getT00365Service() {
		return t00365Service;
	}
	/**
	 * @param t00365Service the t00365Service to set
	 */
	public void setT00365Service(IPgt00365Service t00365Service) {
		this.t00365Service = t00365Service;
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
	public ArrayList<Pgt00365> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgt00365> tabList) {
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
	public Pgt00365 getT00365Bean() {
		return t00365Bean;
	}
	/**
	 * @param t00364Bean the t00364Bean to set
	 */
	public void setT00365Bean(Pgt00365 t00365Bean) {
		this.t00365Bean = t00365Bean;
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


	public String getRdoJJF() {
		return rdoJJF;
	}


	public void setRdoJJF(String rdoJJF) {
		this.rdoJJF = rdoJJF;
	}







}
