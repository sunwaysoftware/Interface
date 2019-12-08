package com.sunway.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12053Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12053;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv12053;

/**
 * 成本法、收益法地段基准（PGT12053）
 * 
 * @author Lee
 * @version 1.0
 */

public class Pgt12053Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -2363206788930918762L;
	// Service
	private IPgt12053Service t12053Service;
	// View
	private ArrayList<Pgv00052> szqyList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv12053> operList;
	// 检索条件
	private String ddlSZQYFind;
	private String txtDdnmFind;
	//编辑操作符
	private String ACT;
	//primary key 主键
	private String DDID;
	// edit页面所需Bean
	private Pgt12053 t12053Bean;
	// edit页面提交数据
	private String ddlSZQY;
	private String txtDDNM;
	private Short txtVIEWORDER;
	private String txtNOTE;
	private Boolean rdoISDIR;
	private String txtUPDATE;
	private ArrayList<Pgt12053> navList;
	private ArrayList<Pgt12053> treeList;
	private String SZQY;
	private String NODDID;
	private String rdoDD;
	private String PARENTID;
	//output stream
	private InputStream ddNav;
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

		Pgv12053 v12053 = new Pgv12053();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v12053.setCd00001Szqy(ddlSZQYFind);
			v12053.setDdnm(Common.getSearchLike(Common.convertEncoding(txtDdnmFind)));
			v12053.setPageIndex(pageIndex);
			v12053.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12053.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			operList = t12053Service.LoadAll(v12053);
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
		Pgt12053 t12053 = new Pgt12053();
		t12053Bean = new Pgt12053();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t12053.setDdid(DDID);
				t12053Bean = t12053Service.LoadByPrimaryKey(t12053);
			} else {
				t12053Bean.setCd00001Szqy(ddlSZQY);
				t12053Bean.setParentid(rdoDD);
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

		t12053Bean = new Pgt12053();
		this.clearErrorsAndMessages();
		t12053Bean.setDdid(DDID);
		//根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			t12053Bean = t12053Service.LoadByPrimaryKey(t12053Bean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))&& (!t12053Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t12053Bean.setDdid(DDID);
			t12053Bean.setCd00001Szqy(ddlSZQY);
			t12053Bean.setParentid(rdoDD);
			t12053Bean.setDdnm(txtDDNM);
			t12053Bean.setVieworder(txtVIEWORDER);
			t12053Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t12053Bean.setNote(txtNOTE);
			t12053Bean.setIsdir(rdoISDIR);
			t12053Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
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
				if (t12053Service.GetInsertCommand(t12053Bean) == 1) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] { t12053Bean.getDdnm() }));
					t12053Bean.clear();
				} else {
					this.addActionError(getText(Constant.MSG_NG_ITERANCE, new String[] { t12053Bean.getDdnm() }));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t12053Service.GetUpdateCommand(t12053Bean) == 1) {
					t12053Bean = t12053Service.LoadByPrimaryKey(t12053Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t12053Bean.getDdnm() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { t12053Bean.getDdnm() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t12053Service.GetDeleteCommand(t12053Bean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { t12053Bean.getDdnm() }));
					rtn = "successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { t12053Bean.getDdnm() }));
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
		return getNavigator(SZQY, DDID, NODDID, PARENTID);
	}

	/**
	 * 读取导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	private String getNavigator(String szqy, String ddid, String noddid,
			String parentid) throws Exception {

		Pgt12053 v12053 = new Pgt12053();
		try {
			ReadInfo();
			if (!Common.isNullOrEmpty(szqy)){
				v12053.setCd00001Szqy(szqy);
			}
			if (!Common.isNullOrEmpty(ddid)) {
				v12053.setDdid(ddid);
			}
			if (!Common.isNullOrEmpty(noddid)){
				v12053.setNoddid(noddid);
			}
			navList = t12053Service.LoadNavigator(v12053);
			treeList = t12053Service.LoadTreeList(v12053);
			t12053Bean = t12053Service.LoadByPrimaryKey(v12053);
			t12053Bean.setNoddid(noddid);
			t12053Bean.setParentid(parentid);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}


	/**
	 * AJAX方法使用，取得地段导航
	 * @return
	 * @throws Exception
	 */
	public String LoadDDNav() throws Exception{
		return getNavStream(DDID);
	}

	private String getNavStream(String ddid) throws Exception {
		StringBuffer strBuf = new StringBuffer();
		try {
			if (!Common.isNullOrEmpty(ddid)) {
				strBuf.append(t12053Service.LoadNavStream(ddid));
				if (!"null".equals(strBuf.toString()))
					ddNav = Common.exportTEXT(strBuf);
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
		t12053Bean = new Pgt12053();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				t12053Bean.setCd00001Szqy(ddlSZQY);
				t12053Bean.setDdid(DDID);
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
	 * 地段点击事件
	 * @return
	 * @throws Exception
	 */
	public String t12053Bydd() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("t12053Bydd() ********** start **********");
		}
		Pgt12053 t12053 = new Pgt12053();
		t12053Bean = new Pgt12053();
		try {
			// 取得用户选中的数据信息
			t12053.setDdid(DDID);
			t12053Bean = t12053Service.LoadByPrimaryKey(t12053);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("t12053Bydd() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("t12053Bydd() ********** end **********");
		}
		return SUCCESS;
	}
	/*********************** setter and getter ******************************/

	/**
	 * @return the t12053Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt12053Service getT12053Service() {
		return t12053Service;
	}
	/**
	 * @param t12053Service the t12053Service to set
	 */
	public void setT12053Service(IPgt12053Service t12053Service) {
		this.t12053Service = t12053Service;
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
	public ArrayList<Pgv12053> getOperList() {
		return operList;
	}
	/**
	 * @param operList the operList to set
	 */
	public void setOperList(ArrayList<Pgv12053> operList) {
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
	 * @return the txtDdnmFind
	 */
	public String getTxtDdnmFind() {
		return txtDdnmFind;
	}
	/**
	 * @param txtDdnmFind the txtDdnmFind to set
	 */
	public void setTxtDdnmFind(String txtDdnmFind) {
		this.txtDdnmFind = txtDdnmFind;
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
	 * @return the dDID
	 */
	public String getDDID() {
		return DDID;
	}
	/**
	 * @param dDID the dDID to set
	 */
	public void setDDID(String dDID) {
		DDID = dDID;
	}
	/**
	 * @return the t12053Bean
	 */
	public Pgt12053 getT12053Bean() {
		return t12053Bean;
	}
	/**
	 * @param t12053Bean the t12053Bean to set
	 */
	public void setT12053Bean(Pgt12053 t12053Bean) {
		this.t12053Bean = t12053Bean;
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
	 * @return the txtDDNM
	 */
	public String getTxtDDNM() {
		return txtDDNM;
	}
	/**
	 * @param txtDDNM the txtDDNM to set
	 */
	public void setTxtDDNM(String txtDDNM) {
		this.txtDDNM = txtDDNM;
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
	public ArrayList<Pgt12053> getNavList() {
		return navList;
	}
	/**
	 * @param navList the navList to set
	 */
	public void setNavList(ArrayList<Pgt12053> navList) {
		this.navList = navList;
	}
	/**
	 * @return the treeList
	 */
	public ArrayList<Pgt12053> getTreeList() {
		return treeList;
	}
	/**
	 * @param treeList the treeList to set
	 */
	public void setTreeList(ArrayList<Pgt12053> treeList) {
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
	 * @return the nODDID
	 */
	public String getNODDID() {
		return NODDID;
	}
	/**
	 * @param nODDID the nODDID to set
	 */
	public void setNODDID(String nODDID) {
		NODDID = nODDID;
	}
	/**
	 * @return the rdoDD
	 */
	public String getRdoDD() {
		return rdoDD;
	}
	/**
	 * @param rdoDD the rdoDD to set
	 */
	public void setRdoDD(String rdoDD) {
		this.rdoDD = rdoDD;
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
	 * @return the ddNav
	 */
	public InputStream getDdNav() {
		return ddNav;
	}
	/**
	 * @param ddNav the ddNav to set
	 */
	public void setDdNav(InputStream ddNav) {
		this.ddNav = ddNav;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
