package com.sunway.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12054Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12054;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv12054;

/**
 * 成本法、收益法土地等级（PGT12054）
 * @author Lee
 * @version 1.0
 */

public class Pgt12054Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -7549585391120509599L;
	// Service
	private IPgt12054Service t12054Service;
	// View
	private ArrayList<Pgv00052> szqyList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv12054> operList;
	// 检索条件
	private String ddlSZQYFind;
	private String txtTddjnmFind;
	//编辑操作符
	private String ACT;
	//primary key 主键
	private String TDDJID;
	// edit页面所需Bean
	private Pgt12054 t12054Bean;
	// edit页面提交数据
	private String ddlSZQY;
	private String txtTDDJNM;
	private Short txtVIEWORDER;
	private String txtNOTE;
	private Boolean rdoISDIR;
	private String txtUPDATE;
	private ArrayList<Pgt12054> navList;
	private ArrayList<Pgt12054> treeList;
	private String SZQY;
	private String NOTDDJID;
	private String rdoTDDJ;
	private String PARENTID;
	//output stream
	private InputStream tddjNav;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/*
	 * (non-Javadoc)
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
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv12054 v12054 = new Pgv12054();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12054.setCd00001Szqy(ddlSZQYFind);
			v12054.setTddjnm(Common.getSearchLike(Common.convertEncoding(txtTddjnmFind)));
			v12054.setPageIndex(pageIndex);
			v12054.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12054.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			operList = t12054Service.LoadAll(v12054);
			// 分页设置
			if (null != operList && operList.size() > 0) {
				rowCount = operList.get(0).getRecordCount();
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
				pageIndex = 1;
			}
			// 取得修正类型列表
			ReadInfo();
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
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		Pgt12054 t12054 = new Pgt12054();
		t12054Bean = new Pgt12054();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t12054.setTddjid(TDDJID);
				t12054Bean = t12054Service.LoadByPrimaryKey(t12054);
			} else {
				t12054Bean.setCd00001Szqy(ddlSZQY);
				t12054Bean.setParentid(rdoTDDJ);
			}
			// 取得下拉菜单信息
			ReadInfo();
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
	 * 
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}

		t12054Bean = new Pgt12054();
		this.clearErrorsAndMessages();
		t12054Bean.setTddjid(TDDJID);
		//根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			t12054Bean = t12054Service.LoadByPrimaryKey(t12054Bean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!t12054Bean.getUpddate().equals(
						Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t12054Bean.setTddjid(TDDJID);
			t12054Bean.setCd00001Szqy(ddlSZQY);
			t12054Bean.setParentid(rdoTDDJ);
			t12054Bean.setTddjnm(txtTDDJNM);
			t12054Bean.setVieworder(txtVIEWORDER);
			t12054Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t12054Bean.setNote(txtNOTE);
			t12054Bean.setIsdir(rdoISDIR);
			t12054Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}

	/**
	 * 更新、删除状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		String rtn = "success";
		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if (t12054Service.GetInsertCommand(t12054Bean) == 1) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] { t12054Bean.getTddjnm() }));
					t12054Bean.clear();
				} else {
					this.addActionError(getText(Constant.MSG_NG_ITERANCE, new String[] { t12054Bean.getTddjnm() }));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t12054Service.GetUpdateCommand(t12054Bean) == 1) {
					t12054Bean = t12054Service.LoadByPrimaryKey(t12054Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t12054Bean.getTddjnm() }));
				} else {
					this.addActionError(getText(Constant.MSG_NG_ITERANCE, new String[] { t12054Bean.getTddjnm() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t12054Service.GetDeleteCommand(t12054Bean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { t12054Bean.getTddjnm() }));
					rtn = "successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { t12054Bean.getTddjnm() }));
				}
			}
			// 取得下拉菜单信息
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		return rtn;
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

	/**
	 * 读取导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadNavigator() throws Exception {
		return getNavigator(SZQY, TDDJID, NOTDDJID, PARENTID);
	}

	/**
	 * 读取导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	private String getNavigator(String szqy, String tddjid, String notddjid,
			String parentid) throws Exception {

		Pgt12054 v12054 = new Pgt12054();
		try {
			ReadInfo();
			if (!Common.isNullOrEmpty(szqy)){
				v12054.setCd00001Szqy(szqy);
			}
			if (!Common.isNullOrEmpty(tddjid)) {
				v12054.setTddjid(tddjid);
			}
			if (!Common.isNullOrEmpty(notddjid)){
				v12054.setNotddjid(notddjid);
			}
			navList = t12054Service.LoadNavigator(v12054);
			treeList = t12054Service.LoadTreeList(v12054);
			t12054Bean = t12054Service.LoadByPrimaryKey(v12054);
			t12054Bean.setNotddjid(notddjid);
			t12054Bean.setParentid(parentid);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}


	/**
	 * AJAX方法使用，取得土地等级导航
	 * @return
	 * @throws Exception
	 */
	public String LoadTDDJNav() throws Exception{
		return getNavStream(TDDJID);
	}

	private String getNavStream(String tddjid) throws Exception {
		StringBuffer navStr = new StringBuffer();
		try {
			if (!Common.isNullOrEmpty(tddjid)) {
				navStr.append(t12054Service.LoadNavStream(tddjid));
				if ("null".equals(navStr.toString())) {
					navStr=null;
				}
				tddjNav = Common.exportTEXT(navStr);
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 地段嵌套处理
	 * @return
	 * @throws Exception
	 */
	public String frame() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("frame() ********** start **********");
		}
		t12054Bean = new Pgt12054();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				t12054Bean.setCd00001Szqy(ddlSZQY);
				t12054Bean.setTddjid(TDDJID);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("frame() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("frame() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 土地等级点击事件
	 * @return
	 * @throws Exception
	 */
	public String t12054Bytddj() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("t12054Bytddj() ********** start **********");
		}
		Pgt12054 t12054 = new Pgt12054();
		t12054Bean = new Pgt12054();
		try {
			// 取得用户选中的数据信息
			t12054.setTddjid(TDDJID);
			t12054Bean = t12054Service.LoadByPrimaryKey(t12054);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("t12054Bytddj() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("t12054Bytddj() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** setter and getter ******************************/

	/**
	 * @return the t12054Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt12054Service getT12054Service() {
		return t12054Service;
	}
	/**
	 * @param t12054Service the t12054Service to set
	 */
	public void setT12054Service(IPgt12054Service t12054Service) {
		this.t12054Service = t12054Service;
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
	 * @return the operList
	 */
	public ArrayList<Pgv12054> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<Pgv12054> operList) {
		this.operList = operList;
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
	 * @return the txtTddjnmFind
	 */
	public String getTxtTddjnmFind() {
		return txtTddjnmFind;
	}
	/**
	 * @param txtTddjnmFind the txtTddjnmFind to set
	 */
	public void setTxtTddjnmFind(String txtTddjnmFind) {
		this.txtTddjnmFind = txtTddjnmFind;
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
	 * @return the tDDJID
	 */
	public String getTDDJID() {
		return TDDJID;
	}
	/**
	 * @param tDDJID the tDDJID to set
	 */
	public void setTDDJID(String tDDJID) {
		TDDJID = tDDJID;
	}
	/**
	 * @return the t12054Bean
	 */
	public Pgt12054 getT12054Bean() {
		return t12054Bean;
	}
	/**
	 * @param t12054Bean the t12054Bean to set
	 */
	public void setT12054Bean(Pgt12054 t12054Bean) {
		this.t12054Bean = t12054Bean;
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
	 * @return the txtTDDJNM
	 */
	public String getTxtTDDJNM() {
		return txtTDDJNM;
	}
	/**
	 * @param txtTDDJNM the txtTDDJNM to set
	 */
	public void setTxtTDDJNM(String txtTDDJNM) {
		this.txtTDDJNM = txtTDDJNM;
	}
	/**
	 * @return the txtVIEWORDER
	 */
	public Short getTxtVIEWORDER() {
		return txtVIEWORDER;
	}
	/**
	 * @param txtVIEWORDER the txtVIEWORDER to set
	 */
	public void setTxtVIEWORDER(Short txtVIEWORDER) {
		this.txtVIEWORDER = txtVIEWORDER;
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
	 * @return the rdoISDIR
	 */
	public Boolean getRdoISDIR() {
		return rdoISDIR;
	}
	/**
	 * @param rdoISDIR the rdoISDIR to set
	 */
	public void setRdoISDIR(Boolean rdoISDIR) {
		this.rdoISDIR = rdoISDIR;
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
	 * @return the navList
	 */
	public ArrayList<Pgt12054> getNavList() {
		return navList;
	}
	/**
	 * @param navList the navList to set
	 */
	public void setNavList(ArrayList<Pgt12054> navList) {
		this.navList = navList;
	}
	/**
	 * @return the treeList
	 */
	public ArrayList<Pgt12054> getTreeList() {
		return treeList;
	}
	/**
	 * @param treeList the treeList to set
	 */
	public void setTreeList(ArrayList<Pgt12054> treeList) {
		this.treeList = treeList;
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
	 * @return the nOTDDJID
	 */
	public String getNOTDDJID() {
		return NOTDDJID;
	}
	/**
	 * @param nOTDDJID the nOTDDJID to set
	 */
	public void setNOTDDJID(String nOTDDJID) {
		NOTDDJID = nOTDDJID;
	}
	/**
	 * @return the rdoTDDJ
	 */
	public String getRdoTDDJ() {
		return rdoTDDJ;
	}
	/**
	 * @param rdoTDDJ the rdoTDDJ to set
	 */
	public void setRdoTDDJ(String rdoTDDJ) {
		this.rdoTDDJ = rdoTDDJ;
	}
	/**
	 * @return the pARENTID
	 */
	public String getPARENTID() {
		return PARENTID;
	}
	/**
	 * @param pARENTID the pARENTID to set
	 */
	public void setPARENTID(String pARENTID) {
		PARENTID = pARENTID;
	}
	/**
	 * @return the tddjNav
	 */
	public InputStream getTddjNav() {
		return tddjNav;
	}
	/**
	 * @param tddjNav the tddjNav to set
	 */
	public void setTddjNav(InputStream tddjNav) {
		this.tddjNav = tddjNav;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
