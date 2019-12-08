package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12081Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12081;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv12081;

/**
 * 审核平方米单价(Pgt12081)
 * @author Lee
 * @version 1.0
 */

public class Pgt12081Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -1818043692252386754L;

	private IPgt12081Service t12081Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv12081> jzjgList;
	private ArrayList<Pgv00052> szqyList;
	//查询条件
	private String txtJZJGFind;
	private String ddlSZQYFind;
	
	//Edit
	
	//edit页面所需Bean
	private Pgt12081 t12081Bean;
	//primary key 主键
	private String JZJG;
	private String SZQY;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtJZJG;
	private String txtMINVALUE;
	private String txtMAXVALUE;
	private String txtUPDATE;
	private String txtNOTE;
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
		
		Pgv12081 v12081 = new Pgv12081();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v12081.setCd00001Jzjg(txtJZJGFind);
			v12081.setCd00001Szqy(ddlSZQYFind);
			v12081.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12081.setPageIndex(pageIndex);
			v12081.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			//执行查询
			jzjgList = t12081Service.LoadAll(v12081);
			//分页设置
			if(null!=jzjgList && jzjgList.size()>0){
				rowCount = jzjgList.get(0).getRecordCount();
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
		
		Pgt12081 t12081 = new Pgt12081();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())) {
				//取得用户选中的数据信息
				t12081.setCd00001Jzjg(JZJG);
				t12081.setCd00001Jzjglx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_JZJG));
				t12081.setCd00001Szqy(SZQY);
				t12081.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t12081Bean = t12081Service.LoadByPrimaryKey(t12081);
				if (t12081Bean.getUpddate() == null) {
					t12081Bean.setCd00001Jzjg(JZJG);
					t12081Bean.setCd00001Jzjglx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_JZJG));
					t12081Bean.setCd00001Szqy(SZQY);
					t12081Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
					t12081Bean.setMinvalue(Common.convertToDouble("0"));		
					t12081Bean.setMaxvalue(Common.convertToDouble("0"));
					t12081Bean.setNote("");
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
		t12081Bean = new Pgt12081();
		this.clearErrorsAndMessages();
		//为PK赋值
		t12081Bean.setCd00001Jzjg(txtJZJG);
		t12081Bean.setCd00001Jzjglx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_JZJG));
		t12081Bean.setCd00001Szqy(ddlSZQY);
		t12081Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		//根据PK取得信息，并为BEAN赋值
		if(!Constant.MOD_DELETE.equals(getACT()))
			t12081Bean = t12081Service.LoadByPrimaryKey(t12081Bean);
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t12081Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN 赋值
			t12081Bean.setCd00001Jzjg(txtJZJG);
			t12081Bean.setCd00001Jzjglx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_JZJG));
			t12081Bean.setCd00001Szqy(ddlSZQY);
			t12081Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
			t12081Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t12081Bean.setMinvalue(Common.convertToDouble(txtMINVALUE));		
			t12081Bean.setMaxvalue(Common.convertToDouble(txtMAXVALUE));
			t12081Bean.setNote(Common.convertEncoding(txtNOTE));
			t12081Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}
	}
	
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	
	public String update() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t12081Service.GetInsertCommand(getT12081Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT12081Bean().getCd00001Jzjg()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT12081Bean().getCd00001Jzjg()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t12081Service.GetUpdateCommand(getT12081Bean())){
					t12081Bean = t12081Service.LoadByPrimaryKey(t12081Bean); 
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT12081Bean().getCd00001Jzjg()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT12081Bean().getCd00001Jzjg()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t12081Service.GetDeleteCommand(getT12081Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT12081Bean().getCd00001Jzjg()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT12081Bean().getCd00001Jzjg()}));
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
		
		Pgt12081 t12081 = new Pgt12081();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t12081.setCd00001Jzjg(JZJG);
				t12081.setCd00001Jzjglx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_JZJG));
				t12081.setCd00001Szqy(ddlSZQY);
				t12081.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t12081Bean = t12081Service.LoadByPrimaryKey(t12081);
				isExists = t12081Bean.getUpddate() == null?true:false;
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
	
	/*********************** setter and getter ******************************/
	
	/**
	 * @return the t12081Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12081Service getT12081Service() {
		return t12081Service;
	}

	/**
	 * @param t12081Service the t12081Service to set
	 */
	public void setT12081Service(IPgt12081Service t12081Service) {
		this.t12081Service = t12081Service;
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
	 * @return the jzjgList
	 */
	public ArrayList<Pgv12081> getJzjgList() {
		return jzjgList;
	}

	/**
	 * @param jzjgList the jzjgList to set
	 */
	public void setJzjgList(ArrayList<Pgv12081> jzjgList) {
		this.jzjgList = jzjgList;
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
	 * @return the txtMINVALUE
	 */
	public String getTxtMINVALUE() {
		return txtMINVALUE;
	}

	/**
	 * @param txtMINVALUE the txtMINVALUE to set
	 */
	public void setTxtMINVALUE(String txtMINVALUE) {
		this.txtMINVALUE = txtMINVALUE;
	}

	/**
	 * @return the txtMAXVALUE
	 */
	public String getTxtMAXVALUE() {
		return txtMAXVALUE;
	}

	/**
	 * @param txtMAXVALUE the txtMAXVALUE to set
	 */
	public void setTxtMAXVALUE(String txtMAXVALUE) {
		this.txtMAXVALUE = txtMAXVALUE;
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
	 * @return the t12081Bean
	 */
	public Pgt12081 getT12081Bean() {
		return t12081Bean;
	}

	/**
	 * @param t12081Bean the t12081Bean to set
	 */
	public void setT12081Bean(Pgt12081 t12081Bean) {
		this.t12081Bean = t12081Bean;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
	
}
