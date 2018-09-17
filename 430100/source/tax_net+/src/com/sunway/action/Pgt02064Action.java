package com.sunway.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02064Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02064;
import com.sunway.vo.Pgv00052;

public class Pgt02064Action extends ActionSupport implements SessionAware {

	/**
	 * 估价值修正
	 */
	private static final long serialVersionUID = -4441810871653514410L;
	private IPgt02064Service t02064Service;
	private String ACT;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	//view
	private ArrayList<Pgt02064> rows;
	private String ddlSZQYFind;
	//edit
	private Pgt02064 t02064Bean;
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
		Pgt02064 t02064 = new Pgt02064();
		try {
			//准备查询条件
			t02064.setCd00001Szqy(ddlSZQYFind);
			t02064.setPageIndex(pageIndex);
			t02064.setPageSize(ConvertUtil.toInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			t02064.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = t02064Service.LoadAll(t02064);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
				
			}else{
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
			Pgt02064 t02064 = new Pgt02064();
			if(!Constant.MOD_CREATE.equals(ACT)){
				//取得用户选中的数据信息
				t02064.setCd00001Szqy(ddlSZQY);
				t02064Bean = t02064Service.LoadByPrimaryKey(t02064);
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
		t02064Bean = new Pgt02064();
		t02064Bean.setCd00001Szqy(ddlSZQY);
		//根据PK信息，为数据BEAN赋值
		if (!Constant.MOD_DELETE.equals(ACT)){
			t02064Bean = t02064Service.LoadByPrimaryKey(t02064Bean);			
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!CheckUtil.chkEmpty(t02064Bean.getUpddate()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.xtwh.info.szqy")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t02064Bean.getUpddate().equals(ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//为数据BEAN赋值
			t02064Bean.setCd00001Szqy(ddlSZQY);
			//t02064Bean.setCd00352Xqdm(txtXQFind);
			t02064Bean.setXzxs(BigDecimal.valueOf(ConvertUtil.toDouble(txtXZXS)));
			t02064Bean.setPgxzxs(BigDecimal.valueOf(ConvertUtil.toDouble(txtPGXZXS)));
			t02064Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t02064Bean.setNote(txtNOTE);
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
				if(t02064Service.GetInsertCommand(t02064Bean))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t02064Bean.getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t02064Bean.getCd00001Szqy()}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t02064Service.GetUpdateCommand(t02064Bean)){
					t02064Bean = t02064Service.LoadByPrimaryKey(t02064Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{t02064Bean.getCd00001Szqy()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{t02064Bean.getCd00001Szqy()}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t02064Service.GetDeleteCommand(t02064Bean))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t02064Bean.getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t02064Bean.getCd00001Szqy()}));
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
		
		Pgt02064 t02064 = new Pgt02064();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
				//取得用户选中的数据信息
				t02064.setCd00001Szqy(ddlSZQY);
				t02064Bean = t02064Service.LoadByPrimaryKey(t02064);
				isExists = t02064Bean.getUpddate() == null?true:false;
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
	 * @return the t02064Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02064Service getT02064Service() {
		return t02064Service;
	}
	/**
	 * @param t02064Service the t02064Service to set
	 */
	public void setT02064Service(IPgt02064Service t02064Service) {
		this.t02064Service = t02064Service;
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
	public Integer getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
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
	 * @return the rows
	 */
	public ArrayList<Pgt02064> getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgt02064> rows) {
		this.rows = rows;
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
	 * @return the t02064Bean
	 */
	public Pgt02064 getT02064Bean() {
		return t02064Bean;
	}
	/**
	 * @param t02064Bean the t02064Bean to set
	 */
	public void setT02064Bean(Pgt02064 t02064Bean) {
		this.t02064Bean = t02064Bean;
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
