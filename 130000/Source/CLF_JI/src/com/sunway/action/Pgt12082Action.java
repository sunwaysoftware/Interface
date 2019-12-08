package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12082Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12082;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv12082;

/**
 * 审核容积率(Pgt12082)
 * @author Lee
 * @version 1.0
 */

public class Pgt12082Action extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -7108571441123664499L;

	private IPgt12082Service t12082Service;
	
	//View
	
	//分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv12082> rjlList;
	private ArrayList<Pgv00052> szqyList;
	//查询条件
	private String txtTDYTFind;
	private String ddlSZQYFind;
	
	//Edit
	
	//edit页面所需Bean
	private Pgt12082 t12082Bean;
	private ArrayList<Pgt12082> t12082List;
	//primary key 主键
	private String TDYT;
	private String SZQY;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtTDYT;
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
		
		Pgv12082 v12082 = new Pgv12082();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准备查询条件
			v12082.setCd00001Tdyt(txtTDYTFind);
			v12082.setCd00001Szqy(ddlSZQYFind);
			v12082.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v12082.setPageIndex(pageIndex);
			v12082.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			//执行查询
			rjlList = t12082Service.LoadAll(v12082);
			//分页设置
			if(null!=rjlList && rjlList.size()>0){
				rowCount = rjlList.get(0).getRecordCount();
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
		
		Pgt12082 t12082 = new Pgt12082();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())) {
				//取得用户选中的数据信息
				t12082.setCd00001Tdyt(TDYT);
				t12082.setCd00001Tdytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDYT));
				t12082.setCd00001Szqy(SZQY);
				t12082.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t12082Bean = t12082Service.LoadByPrimaryKey(t12082);
				if (t12082Bean.getUpddate() == null) {
					t12082Bean.setCd00001Tdyt(TDYT);
					t12082Bean.setCd00001Tdytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDYT));
					t12082Bean.setCd00001Szqy(SZQY);
					t12082Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
					t12082Bean.setMinvalue(Common.convertToDouble("0"));		
					t12082Bean.setMaxvalue(Common.convertToDouble("0"));
					t12082Bean.setNote("");
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
		t12082Bean = new Pgt12082();
		this.clearErrorsAndMessages();
		//为PK赋值
		t12082Bean.setCd00001Tdyt(txtTDYT);
		t12082Bean.setCd00001Tdytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDYT));
		t12082Bean.setCd00001Szqy(ddlSZQY);
		t12082Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
		//根据PK取得信息，并为BEAN赋值
		if(!Constant.MOD_DELETE.equals(getACT()))
			t12082Bean = t12082Service.LoadByPrimaryKey(t12082Bean);
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t12082Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN 赋值
			t12082Bean.setCd00001Tdyt(txtTDYT);
			t12082Bean.setCd00001Tdytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDYT));
			t12082Bean.setCd00001Szqy(ddlSZQY);
			t12082Bean.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
			t12082Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t12082Bean.setMinvalue(Common.convertToDouble(txtMINVALUE));		
			t12082Bean.setMaxvalue(Common.convertToDouble(txtMAXVALUE));
			t12082Bean.setNote(Common.convertEncoding(txtNOTE));
			t12082Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if(t12082Service.GetInsertCommand(getT12082Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT12082Bean().getCd00001Tdyt()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT12082Bean().getCd00001Tdyt()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t12082Service.GetUpdateCommand(getT12082Bean())){
					t12082Bean = t12082Service.LoadByPrimaryKey(t12082Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT12082Bean().getCd00001Tdyt()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT12082Bean().getCd00001Tdyt()}));
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
		
		t12082List = new ArrayList<Pgt12082>();
		Pgt12082 t12082 = new Pgt12082();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t12082.setCd00001Tdyt(TDYT);
				t12082.setCd00001Tdytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDYT));
				t12082.setCd00001Szqy(ddlSZQY);
				t12082.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t12082Bean = t12082Service.LoadByPrimaryKey(t12082);
				isExists = t12082Bean.getUpddate() == null?true:false;
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
	 * 点击删除按钮的ajax事件，
	 * @return 
	 * @throws Exception
	 */
	
	public String deleteByAjax() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("deleteByAjax() ********** start **********");
		}
		
		Pgt12082 t12082 = new Pgt12082();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(!Constant.MOD_CREATE.equals(getACT())){
				//取得用户选中的数据信息
				t12082.setCd00001Tdyt(TDYT);
				t12082.setCd00001Tdytlx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_TDYT));
				t12082.setCd00001Szqy(ddlSZQY);
				t12082.setCd00001Szqylx(sessionCtrl.Get(SessionCtrl.SESSION_INFO_SZQY));
				t12082.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
				t12082.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
				
				t12082Service.GetDeleteCommand(t12082);
			}
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("deleteByAjax() ********** end **********");
			}
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("deleteByAjax() ********** end **********");
		}
		return SUCCESS;
	}

	
	/*********************** setter and getter ******************************/
	
	/**
	 * @return the t12082Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12082Service getT12082Service() {
		return t12082Service;
	}

	/**
	 * @param t12082Service the t12082Service to set
	 */
	public void setT12082Service(IPgt12082Service t12082Service) {
		this.t12082Service = t12082Service;
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
	 * @return the txtTDYTFind
	 */
	public String getTxtTDYTFind() {
		return txtTDYTFind;
	}

	/**
	 * @param txtTDYTFind the txtTDYTFind to set
	 */
	public void setTxtTDYTFind(String txtTDYTFind) {
		this.txtTDYTFind = txtTDYTFind;
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
	public String getTDYT() {
		return TDYT;
	}

	/**
	 * @param jZJG the jZJG to set
	 */
	public void setTDYT(String jZJG) {
		TDYT = jZJG;
	}

	/**
	 * @return the txtTDYT
	 */
	public String getTxtTDYT() {
		return txtTDYT;
	}

	/**
	 * @param txtTDYT the txtTDYT to set
	 */
	public void setTxtTDYT(String txtTDYT) {
		this.txtTDYT = txtTDYT;
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
	 * @return the t12082Bean
	 */
	public Pgt12082 getT12082Bean() {
		return t12082Bean;
	}

	/**
	 * @param t12082Bean the t12082Bean to set
	 */
	public void setT12082Bean(Pgt12082 t12082Bean) {
		this.t12082Bean = t12082Bean;
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
	 * @return the t12082List
	 */
	public ArrayList<Pgt12082> getT12082List() {
		return t12082List;
	}

	/**
	 * @param t12082List the t12082List to set
	 */
	public void setT12082List(ArrayList<Pgt12082> t12082List) {
		this.t12082List = t12082List;
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
	 * @return the rjlList
	 */
	public ArrayList<Pgv12082> getRjlList() {
		return rjlList;
	}

	/**
	 * @param rjlList the rjlList to set
	 */
	public void setRjlList(ArrayList<Pgv12082> rjlList) {
		this.rjlList = rjlList;
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
