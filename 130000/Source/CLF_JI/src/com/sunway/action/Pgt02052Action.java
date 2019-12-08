package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02052Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02052;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02052;

/**
 * 收益法楼层修正(Pgt02052)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt02052Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 4234932338157449875L;

	//Service
	private IPgt02052Service t02052Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv02052> lcList;
	private ArrayList<Pgv00052> szqyList;
	//查询条件
	private String ddlSZQYFind;
	private String txtLCFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt02052 t02052Bean;
	//primary key 主键
	private String LC;
	private String SZQY;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtLC;
	private String txtXZXS;
	private String txtNOTE;
	private String txtUPDATE;
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
		
		Pgv02052 v02052 = new Pgv02052();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v02052.setCd00001Szqy(ddlSZQYFind);
			v02052.setLc(Common.getSearchLike(Common.convertEncoding(txtLCFind)));
			v02052.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v02052.setPageIndex(pageIndex);
			v02052.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v02052.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			lcList = t02052Service.LoadAll(v02052);
			
			//分页设置
			if(null!=lcList && lcList.size()>0){
				rowCount = lcList.get(0).getRecordCount();
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
		
		Pgt02052 t02052 = new Pgt02052();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02052.setLc(Common.convertEncoding(LC));
				t02052.setCd00001Szqy(SZQY);
				t02052.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t02052.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t02052Bean = t02052Service.LoadByPrimaryKey(t02052);
				if (Common.isNullOrEmpty(t02052Bean.getUpddate())) {
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
		t02052Bean = new Pgt02052();
		this.clearErrorsAndMessages();	
		t02052Bean.setLc(txtLC);
		t02052Bean.setCd00001Szqy(ddlSZQY);
		t02052Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		t02052Bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02052Bean = t02052Service.LoadByPrimaryKey(t02052Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t02052Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.t02052.lc")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02052Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02052Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02052Bean.setXzxs(Common.convertToDouble(txtXZXS));
			t02052Bean.setNote(Common.convertEncoding(txtNOTE));
			t02052Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if(t02052Service.GetInsertCommand(getT02052Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT02052Bean().getLc()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT02052Bean().getLc()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02052Service.GetUpdateCommand(getT02052Bean())){
					t02052Bean = t02052Service.LoadByPrimaryKey(t02052Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT02052Bean().getLc()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT02052Bean().getLc()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02052Service.GetDeleteCommand(getT02052Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT02052Bean().getLc()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT02052Bean().getLc()}));
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
		
		Pgt02052 t02052 = new Pgt02052();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t02052.setLc(LC);
				t02052.setCd00001Szqy(ddlSZQY);
				t02052.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t02052.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t02052Bean = t02052Service.LoadByPrimaryKey(t02052);
				isExists = t02052Bean.getUpddate() == null?true:false;
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
		t02052Bean = new Pgt02052();
		try {
			ReadInfo();
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t02052Bean.setSpssd(ddlPSSD);
			t02052Bean.setTpssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t02052Bean.setCd00001Szqy(ddlSZQY);
			t02052Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02052Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(t02052Service.ExecuteParamCopy(getT02052Bean()))
				this.addActionMessage(getText(Constant.MSG_COPY_OK, new String[]{getT02052Bean().getSpssd()}));
			else
				this.addActionError(getText(Constant.MSG_COPY_NG, new String[]{getT02052Bean().getSpssd()}));
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
		setACTIONNAME("EXET02052COPY");
		setHREFNAME("VIEWT02052");
		setTITLENAME(getText("app.xtwh.t02052.title"));
		setURL("020529");
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t02052Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02052Service getT02052Service() {
		return t02052Service;
	}

	/**
	 * @param t02052Service the t02052Service to set
	 */
	public void setT02052Service(IPgt02052Service t02052Service) {
		this.t02052Service = t02052Service;
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
	 * @return the lcList
	 */
	public ArrayList<Pgv02052> getLcList() {
		return lcList;
	}

	/**
	 * @param lcList the lcList to set
	 */
	public void setLcList(ArrayList<Pgv02052> lcList) {
		this.lcList = lcList;
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
	 * @return the txtLCFind
	 */
	public String getTxtLCFind() {
		return txtLCFind;
	}

	/**
	 * @param txtLCFind the txtLCFind to set
	 */
	public void setTxtLCFind(String txtLCFind) {
		this.txtLCFind = txtLCFind;
	}

	/**
	 * @return the t02052Bean
	 */
	public Pgt02052 getT02052Bean() {
		return t02052Bean;
	}

	/**
	 * @param t02052Bean the t02052Bean to set
	 */
	public void setT02052Bean(Pgt02052 t02052Bean) {
		this.t02052Bean = t02052Bean;
	}

	/**
	 * @return the lC
	 */
	public String getLC() {
		return LC;
	}

	/**
	 * @param lC the lC to set
	 */
	public void setLC(String lC) {
		LC = lC;
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
	 * @return the txtLC
	 */
	public String getTxtLC() {
		return txtLC;
	}

	/**
	 * @param txtLC the txtLC to set
	 */
	public void setTxtLC(String txtLC) {
		this.txtLC = txtLC;
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
