package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02056Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02056;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02056;

/**
 * 收益法星级标准修正(Pgt02056)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt02056Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 9045344711374872707L;

	//Service
	private IPgt02056Service t02056Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv02056> xjbzList;
	private ArrayList<Pgv00052> szqyList;
	//查询条件
	private String ddlSZQYFind;
	private String txtXJBZFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt02056 t02056Bean;
	//primary key 主键
	private String XJBZ;
	private String SZQY;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtXJBZ;
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
		
		Pgv02056 v02056 = new Pgv02056();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v02056.setCd00001Szqy(ddlSZQYFind);
			v02056.setCd00001Xjbz(txtXJBZFind);
			v02056.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v02056.setPageIndex(pageIndex);
			v02056.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v02056.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			xjbzList = t02056Service.LoadAll(v02056);
			
			//分页设置
			if(null!=xjbzList && xjbzList.size()>0){
				rowCount = xjbzList.get(0).getRecordCount();
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
		
		Pgt02056 t02056 = new Pgt02056();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t02056.setCd00001Xjbz(XJBZ);
				t02056.setCd00001Xjbzlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_XJBZ));
				t02056.setCd00001Szqy(SZQY);
				t02056.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t02056.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t02056Bean = t02056Service.LoadByPrimaryKey(t02056);
				if (Common.isNullOrEmpty(t02056Bean.getUpddate())) {
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
		t02056Bean = new Pgt02056();
		this.clearErrorsAndMessages();	
		t02056Bean.setCd00001Xjbz(XJBZ);
		t02056Bean.setCd00001Xjbzlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_XJBZ));
		t02056Bean.setCd00001Szqy(ddlSZQY);
		t02056Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		t02056Bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t02056Bean = t02056Service.LoadByPrimaryKey(t02056Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t02056Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.xjbz")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02056Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02056Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02056Bean.setXzxs(Common.convertToDouble(txtXZXS));
			t02056Bean.setNote(Common.convertEncoding(txtNOTE));
			t02056Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if(t02056Service.GetInsertCommand(getT02056Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT02056Bean().getCd00001Xjbz()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT02056Bean().getCd00001Xjbz()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t02056Service.GetUpdateCommand(getT02056Bean())){
					t02056Bean = t02056Service.LoadByPrimaryKey(t02056Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT02056Bean().getCd00001Xjbz()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT02056Bean().getCd00001Xjbz()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t02056Service.GetDeleteCommand(getT02056Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT02056Bean().getCd00001Xjbz()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT02056Bean().getCd00001Xjbz()}));
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
		
		Pgt02056 t02056 = new Pgt02056();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t02056.setCd00001Xjbz(XJBZ);
				t02056.setCd00001Xjbzlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_XJBZ));
				t02056.setCd00001Szqy(ddlSZQY);
				t02056.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t02056.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t02056Bean = t02056Service.LoadByPrimaryKey(t02056);
				isExists = t02056Bean.getUpddate() == null?true:false;
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
		t02056Bean = new Pgt02056();
		try {
			ReadInfo();
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t02056Bean.setSpssd(ddlPSSD);
			t02056Bean.setTpssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t02056Bean.setCd00001Szqy(ddlSZQY);
			t02056Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02056Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(t02056Service.ExecuteParamCopy(getT02056Bean()))
				this.addActionMessage(getText(Constant.MSG_COPY_OK, new String[]{getT02056Bean().getSpssd()}));
			else
				this.addActionError(getText(Constant.MSG_COPY_NG, new String[]{getT02056Bean().getSpssd()}));
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
		setACTIONNAME("EXET02056COPY");
		setHREFNAME("VIEWT02056");
		setTITLENAME(getText("app.xtwh.t02056.title"));
		setURL("020569");
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
/*********************** set and get ******************************/
	
	/**
	 * @return the t02056Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02056Service getT02056Service() {
		return t02056Service;
	}

	/**
	 * @param t02056Service the t02056Service to set
	 */
	public void setT02056Service(IPgt02056Service t02056Service) {
		this.t02056Service = t02056Service;
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
	 * @return the xjbzList
	 */
	public ArrayList<Pgv02056> getXjbzList() {
		return xjbzList;
	}

	/**
	 * @param xjbzList the xjbzList to set
	 */
	public void setXjbzList(ArrayList<Pgv02056> xjbzList) {
		this.xjbzList = xjbzList;
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
	 * @return the txtXJBZFind
	 */
	public String getTxtXJBZFind() {
		return txtXJBZFind;
	}

	/**
	 * @param txtXJBZFind the txtXJBZFind to set
	 */
	public void setTxtXJBZFind(String txtXJBZFind) {
		this.txtXJBZFind = txtXJBZFind;
	}

	/**
	 * @return the t02056Bean
	 */
	public Pgt02056 getT02056Bean() {
		return t02056Bean;
	}

	/**
	 * @param t02056Bean the t02056Bean to set
	 */
	public void setT02056Bean(Pgt02056 t02056Bean) {
		this.t02056Bean = t02056Bean;
	}

	/**
	 * @return the xJBZ
	 */
	public String getXJBZ() {
		return XJBZ;
	}

	/**
	 * @param xJBZ the xJBZ to set
	 */
	public void setXJBZ(String xJBZ) {
		XJBZ = xJBZ;
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
	 * @return the txtXJBZ
	 */
	public String getTxtXJBZ() {
		return txtXJBZ;
	}

	/**
	 * @param txtXJBZ the txtXJBZ to set
	 */
	public void setTxtXJBZ(String txtXJBZ) {
		this.txtXJBZ = txtXJBZ;
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
