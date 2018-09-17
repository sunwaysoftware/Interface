package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00051Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00051;
import com.sunway.vo.Pgv00051;
import com.sunway.vo.Pgv00052;

/**
 * 税率指数维护(Pgt00051)
 * @author Lee
 * @version 1.0
 */

public class Pgt00051Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -4251536558423004586L;

	//Service
	private IPgt00051Service t00051Service;
	
	//Bean数组
	private ArrayList<Pgv00051> jsblList;
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	//检索条件
	private String ddlSZQYFind;
	//edit页面所需Bean
	private Pgt00051 t00051Bean;
	//primary key 主键
	private String PSSD;
	//编辑操作符
	private String ACT;
	//表单提交数据 
	private String txtPSSD;
	private String txtJSBL;
	private String txtSL;
	private String txtNOTE;
	private String txtUPDATE;
	private ArrayList<Pgv00052> szqyList;
	private String ddlSZQY;
	private Boolean isExists;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String txtFWLX;
	private String txtJYLX;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			// 取得下拉菜单信息
			ReadInfo();
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
		Pgv00051 v00051 = new Pgv00051();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v00051.setCd00002Pssd(ConvertUtil.toUtilDate(txtPSSD));
			v00051.setPageIndex(pageIndex);
			v00051.setPageSize(getPageSize());
			v00051.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00051.setCd00001Szqy(ddlSZQYFind);
			//执行查询
			jsblList = t00051Service.LoadAll(v00051);
			
			//分页设置
			if(null!=jsblList && jsblList.size()>0){
				total = jsblList.get(0).getRecordCount();
			}else{
				total = 0;
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
		
		Pgt00051 t00051 = new Pgt00051();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t00051.setCd00002Pssd(ConvertUtil.toUtilDate(txtPSSD));
				t00051.setCd00001Szqy(ddlSZQY);
				t00051.setCd00001Fwlx(txtFWLX);
				t00051.setCd00001Jylx(txtJYLX);
				t00051Bean = t00051Service.LoadByPrimaryKey(t00051);
				if (CheckUtil.chkEmpty(t00051Bean.getUpddate())) {
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
		this.clearErrorsAndMessages();	
		szqyList = sessionCtrl.ReadSzqyList();
		t00051Bean = new Pgt00051();
		t00051Bean.setCd00002Pssd(ConvertUtil.toUtilDate(txtPSSD));
		t00051Bean.setCd00001Szqy(ddlSZQY);
		t00051Bean.setCd00001Fwlx(txtFWLX);
		t00051Bean.setCd00001Jylx(txtJYLX);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(getACT())){
			t00051Bean = t00051Service.LoadByPrimaryKey(t00051Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!CheckUtil.chkEmpty(t00051Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.t00001.pssd")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!(ConvertUtil.toTimestamp(txtUPDATE)).equals(t00051Bean.getUpddate()))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}
		//为数据BEAN赋值
		t00051Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
		t00051Bean.setJsbl(ConvertUtil.toDouble(txtJSBL));
		t00051Bean.setSl(ConvertUtil.toDouble(txtSL));
		t00051Bean.setNote(ConvertUtil.encoding(txtNOTE));
		t00051Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if(t00051Service.GetInsertCommand(getT00051Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{txtPSSD}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{txtPSSD}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t00051Service.GetUpdateCommand(getT00051Bean())){
					t00051Bean = t00051Service.LoadByPrimaryKey(t00051Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{txtPSSD}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{txtPSSD}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t00051Service.GetDeleteCommand(getT00051Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{txtPSSD}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{txtPSSD}));
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
	 *   改变下拉列表的ajax事件，
	 * @return 如果有值填充，没有则返回NULL
	 * @throws Exception
	 */
	public String createByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("createByAjax() ********** start **********");
		}
		
		Pgt00051 t00051 = new Pgt00051();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t00051.setCd00001Szqy(ddlSZQY);
				t00051.setCd00001Fwlx(txtFWLX);
				t00051.setCd00001Jylx(txtJYLX);
				t00051.setCd00002Pssd(ConvertUtil.toUtilDate(txtPSSD));
				t00051Bean = t00051Service.LoadByPrimaryKey(t00051);
				isExists = t00051Bean.getUpddate() == null?true:false;
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
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}

	/*********************** set and get ******************************/
	
	/**
	 * @return the t00051Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00051Service getT00051Service() {
		return t00051Service;
	}

	/**
	 * @param t00051Service the t00051Service to set
	 */
	public void setT00051Service(IPgt00051Service t00051Service) {
		this.t00051Service = t00051Service;
	}

	/**
	 * @return the t00051Bean
	 */
	public Pgt00051 getT00051Bean() {
		return t00051Bean;
	}

	/**
	 * @param t00051Bean the t00051Bean to set
	 */
	public void setT00051Bean(Pgt00051 t00051Bean) {
		this.t00051Bean = t00051Bean;
	}

	/**
	 * @return the pSSD
	 */
	public String getPSSD() {
		return PSSD;
	}

	/**
	 * @param pSSD the pSSD to set
	 */
	public void setPSSD(String pSSD) {
		PSSD = pSSD;
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
	 * @return the txtJSBL
	 */
	public String getTxtJSBL() {
		return txtJSBL;
	}

	/**
	 * @param txtJSBL the txtJSBL to set
	 */
	public void setTxtJSBL(String txtJSBL) {
		this.txtJSBL = txtJSBL;
	}

	/**
	 * @return the txtSL
	 */
	public String getTxtSL() {
		return txtSL;
	}

	/**
	 * @param txtSL the txtSL to set
	 */
	public void setTxtSL(String txtSL) {
		this.txtSL = txtSL;
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
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
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
	 * @return the jsblList
	 */
	public ArrayList<Pgv00051> getJsblList() {
		return jsblList;
	}

	/**
	 * @param jsblList the jsblList to set
	 */
	public void setJsblList(ArrayList<Pgv00051> jsblList) {
		this.jsblList = jsblList;
	}

	/**
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
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
	 * @param txtPSSD the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}

	/**
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}

	/**
	 * @param txtFWLX the txtFWLX to set
	 */
	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}

	/**
	 * @return the txtFWLX
	 */
	public String getTxtFWLX() {
		return txtFWLX;
	}

	/**
	 * @param txtJYLX the txtJYLX to set
	 */
	public void setTxtJYLX(String txtJYLX) {
		this.txtJYLX = txtJYLX;
	}

	/**
	 * @return the txtJYLX
	 */
	public String getTxtJYLX() {
		return txtJYLX;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
