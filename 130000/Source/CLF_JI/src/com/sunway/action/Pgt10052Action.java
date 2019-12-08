package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt10052Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt10052;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv10052;

/**
 * 成本法建安造价标准(Pgt10052)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt10052Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 6311584082348364751L;

	//Service
	private IPgt10052Service t10052Service;
	
	//View
	
	
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv10052> jazjList;
	private ArrayList<Pgv00052> szqyList;
	
	//查询条件
	private String ddlSZQYFind;
	private String txtFWYTFind;
	private String txtROOTIDFind;
	private String txtINFOIDFind;
	//Edit
	
	//edit页面所需Bean
	private Pgt10052 t10052Bean;
	//primary key 主键
	private String FWYT;
	private String INFOID;
	private String ROOTID;
	private String SZQY;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String txtJZJG;
	private String txtXJBZ;
	private String txtSZQY;
	private String txtNOTE;
	private String txtUPDATE;
	private String txtBZSZ;
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
		
		Pgv10052 v10052 = new Pgv10052();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v10052.setCd00001Szqy(ddlSZQYFind);
			v10052.setCd00001Fwyt(txtFWYTFind);
			v10052.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v10052.setCd00001Rootid(txtROOTIDFind);
			v10052.setCd00001Infoid(txtINFOIDFind);
			v10052.setPageIndex(pageIndex);
			v10052.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v10052.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			//执行查询
			jazjList = t10052Service.LoadAll(v10052);
			
			//分页设置
			if(null!=jazjList && jazjList.size()>0){
				rowCount = jazjList.get(0).getRecordCount();
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
		
		Pgt10052 t10052 = new Pgt10052();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t10052.setCd00001Fwyt(FWYT);
				t10052.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
				t10052.setCd00001Infoid(INFOID);
				t10052.setCd00001Rootid(ROOTID);
				t10052.setCd00001Szqy(SZQY);
				t10052.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t10052.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t10052Bean = t10052Service.LoadByPrimaryKey(t10052);
				if (Common.isNullOrEmpty(t10052Bean.getUpddate())) {
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
		t10052Bean = new Pgt10052();
		this.clearErrorsAndMessages();	
		t10052Bean.setCd00001Fwyt(FWYT);
		t10052Bean.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
		t10052Bean.setCd00001Rootid(ROOTID);
		t10052Bean.setCd00001Infoid(INFOID);
		t10052Bean.setCd00001Szqy(ddlSZQY);
		t10052Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		t10052Bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t10052Bean = t10052Service.LoadByPrimaryKey(t10052Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t10052Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.fwyt")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t10052Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t10052Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t10052Bean.setBzsz(Common.convertToDouble(txtBZSZ));
			t10052Bean.setNote(Common.convertEncoding(txtNOTE));
			t10052Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if(t10052Service.GetInsertCommand(getT10052Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT10052Bean().getCd00001Fwyt()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT10052Bean().getCd00001Fwyt()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t10052Service.GetUpdateCommand(getT10052Bean())){
					t10052Bean = t10052Service.LoadByPrimaryKey(t10052Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT10052Bean().getCd00001Fwyt()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT10052Bean().getCd00001Fwyt()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t10052Service.GetDeleteCommand(getT10052Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT10052Bean().getCd00001Fwyt()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT10052Bean().getCd00001Fwyt()}));
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
		
		Pgt10052 t10052 = new Pgt10052();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t10052.setCd00001Fwyt(FWYT);
				t10052.setCd00001Fwytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWYT));
				t10052.setCd00001Infoid(INFOID);
				t10052.setCd00001Rootid(ROOTID);
				t10052.setCd00001Szqy(ddlSZQY);
				t10052.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t10052.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
				t10052Bean = t10052Service.LoadByPrimaryKey(t10052);
				isExists = t10052Bean.getUpddate() == null?true:false;
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
		t10052Bean = new Pgt10052();
		
		try {
			ReadInfo();
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t10052Bean.setSpssd(ddlPSSD);
			t10052Bean.setTpssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t10052Bean.setCd00001Szqy(ddlSZQY);
			t10052Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t10052Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			if(t10052Service.ExecuteParamCopy(getT10052Bean()))
				this.addActionMessage(getText(Constant.MSG_COPY_OK, new String[]{getT10052Bean().getSpssd()}));
			else
				this.addActionError(getText(Constant.MSG_COPY_NG, new String[]{getT10052Bean().getSpssd()}));
		
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
		setACTIONNAME("EXET10052COPY");
		setHREFNAME("VIEWT10052");
		setTITLENAME(getText("app.xtwh.t10052.title"));
		setURL("100529");
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t10052Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt10052Service getT10052Service() {
		return t10052Service;
	}

	/**
	 * @param t10052Service the t10052Service to set
	 */
	public void setT10052Service(IPgt10052Service t10052Service) {
		this.t10052Service = t10052Service;
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
	 * @return the jazjList
	 */
	public ArrayList<Pgv10052> getJazjList() {
		return jazjList;
	}

	/**
	 * @param jazjList the jazjList to set
	 */
	public void setJazjList(ArrayList<Pgv10052> jazjList) {
		this.jazjList = jazjList;
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
	 * @return the txtROOTIDFind
	 */
	public String getTxtROOTIDFind() {
		return txtROOTIDFind;
	}

	/**
	 * @param txtROOTIDFind the txtROOTIDFind to set
	 */
	public void setTxtROOTIDFind(String txtROOTIDFind) {
		this.txtROOTIDFind = txtROOTIDFind;
	}

	/**
	 * @return the txtINFOIDFind
	 */
	public String getTxtINFOIDFind() {
		return txtINFOIDFind;
	}

	/**
	 * @param txtINFOIDFind the txtINFOIDFind to set
	 */
	public void setTxtINFOIDFind(String txtINFOIDFind) {
		this.txtINFOIDFind = txtINFOIDFind;
	}

	/**
	 * @return the t10052Bean
	 */
	public Pgt10052 getT10052Bean() {
		return t10052Bean;
	}

	/**
	 * @param t10052Bean the t10052Bean to set
	 */
	public void setT10052Bean(Pgt10052 t10052Bean) {
		this.t10052Bean = t10052Bean;
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
	 * @return the iNFOID
	 */
	public String getINFOID() {
		return INFOID;
	}

	/**
	 * @param iNFOID the iNFOID to set
	 */
	public void setINFOID(String iNFOID) {
		INFOID = iNFOID;
	}

	/**
	 * @return the rOOTID
	 */
	public String getROOTID() {
		return ROOTID;
	}

	/**
	 * @param rOOTID the rOOTID to set
	 */
	public void setROOTID(String rOOTID) {
		ROOTID = rOOTID;
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
	 * @return the txtSZQY
	 */
	public String getTxtSZQY() {
		return txtSZQY;
	}

	/**
	 * @param txtSZQY the txtSZQY to set
	 */
	public void setTxtSZQY(String txtSZQY) {
		this.txtSZQY = txtSZQY;
	}

	/**
	 * @return the txtBZSZ
	 */
	public String getTxtBZSZ() {
		return txtBZSZ;
	}

	/**
	 * @param txtBZSZ the txtBZSZ to set
	 */
	public void setTxtBZSZ(String txtBZSZ) {
		this.txtBZSZ = txtBZSZ;
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
