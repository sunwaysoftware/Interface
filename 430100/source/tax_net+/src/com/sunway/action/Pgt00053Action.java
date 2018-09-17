package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00053Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00053;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00053;

/**
 * 其它修正参数（PGT00053）
 *
 * @author Lee
 * @version 1.0
 */

public class Pgt00053Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 5734020694238188343L;
	// Service
	private IPgt00053Service t00053Service;
	// View
	private ArrayList<Pgv00053> xzlxList;
	private ArrayList<Pgv00052> szqyList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	// Bean数组
	private ArrayList<Pgv00053> operList;
	// 检索条件
	private String ddlXZLXFind;
	private String txtQtxzmcFind;
	private String ddlSZQYFind;
	//编辑操作符
	private String ACT;
	//primary key 主键
	private String QTXZID;
	// edit页面所需Bean
	private Pgt00053 t00053Bean;
	// edit页面提交数据
	private String ddlXZLX;
	private String txtQTXZNM;
	private String txtXZXS;
	private Short txtVIEWORDER;
	private String txtNOTE;
	private Boolean rdoISDIR;
	private String txtUPDATE;
	private String ddlSZQY;
	private ArrayList<Pgt00053> navList;
	private ArrayList<Pgt00053> treeList;
	private String SZQY;
	private String XZLX;
	private String NOQTXZID;
	private String rdoQTXZ;
	private String PARENTID;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Integer rdoCZLX;
	private Integer rdoJGLX;

	/*
	 * (non-Javadoc)
	 *
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

		Pgv00053 v00053 = new Pgv00053();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00053.setXzlx(ConvertUtil.toShort(ddlXZLXFind));
			v00053.setQtxznm(txtQtxzmcFind);
			v00053.setQtxznm(FormatUtil.toSearchLike(ConvertUtil.encoding(txtQtxzmcFind)));
			v00053.setCd00001Szqy(ddlSZQYFind);
			v00053.setPageIndex(pageIndex);
			v00053.setPageSize(getPageSize());
			v00053.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			operList = t00053Service.LoadAll(v00053);
			// 分页设置
			if (null != operList && operList.size() > 0) {
				total = operList.get(0).getRecordCount();
			} else {
				total = 0;
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

		Pgt00053 t00053 = new Pgt00053();
		t00053Bean = new Pgt00053();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t00053.setQtxzid(QTXZID);
				t00053Bean = t00053Service.LoadByPrimaryKey(t00053);
			} else {
				t00053Bean.setXzlx(ConvertUtil.toShort(ddlXZLX));
				t00053Bean.setCd00001Szqy(ddlSZQY);
				t00053Bean.setParentid(rdoQTXZ);
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

		t00053Bean = new Pgt00053();
		this.clearErrorsAndMessages();
		t00053Bean.setQtxzid(QTXZID);
		//根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			t00053Bean = t00053Service.LoadByPrimaryKey(t00053Bean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!t00053Bean.getUpddate().equals(
						ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t00053Bean.setQtxzid(QTXZID);
			t00053Bean.setCd00001Szqy(ddlSZQY);
			t00053Bean.setParentid(rdoQTXZ);
			t00053Bean.setQtxznm(txtQTXZNM);
			t00053Bean.setXzlx(ConvertUtil.toShort(ddlXZLX));
			t00053Bean.setXzxs(ConvertUtil.toDouble(txtXZXS));
			t00053Bean.setVieworder(txtVIEWORDER);
			t00053Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			t00053Bean.setNote(txtNOTE);
			t00053Bean.setIsdir(rdoISDIR);
			t00053Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t00053Bean.setCzlx(rdoCZLX);
			t00053Bean.setJglx(rdoJGLX);
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
		String rtn = SUCCESS;
		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if (t00053Service.GetInsertCommand(t00053Bean)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] { t00053Bean.getQtxznm() }));
					ddlXZLX = t00053Bean.getXzlx().toString();
					ddlSZQY = t00053Bean.getCd00001Szqy();
					rdoQTXZ = t00053Bean.getParentid();
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] { t00053Bean.getQtxznm() }));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00053Service.GetUpdateCommand(t00053Bean)) {
					t00053Bean = t00053Service.LoadByPrimaryKey(t00053Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t00053Bean.getQtxznm() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { t00053Bean.getQtxznm() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t00053Service.GetDeleteCommand(t00053Bean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { Constant.STRING_EMPTY }));
					rtn = "successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { Constant.STRING_EMPTY }));
				}
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
		// 取得修正类型列表信息
		xzlxList = t00053Service.LoadAllXzlx();
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}

	/**
	 * 读取导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	public String loadNavigator() throws Exception{
		return getNavigator(SZQY,XZLX,QTXZID,NOQTXZID,PARENTID);
	}

	/**
	 * 读取导航条数据，AJAX方法用
	 * @return
	 * @throws Exception
	 */
	private String getNavigator(String szqy, String xzlx, String qtxzID, String noqtxzID,String parentID) throws Exception {

		Pgt00053 v00053 = new Pgt00053();
		try {
			ReadInfo();
			if (!CheckUtil.chkEmpty(szqy)){
				v00053.setCd00001Szqy(szqy);
			}
			if(!CheckUtil.chkEmpty(xzlx)){
				v00053.setXzlx(ConvertUtil.toShort(xzlx));
			}
			if (!CheckUtil.chkEmpty(qtxzID)) {
				v00053.setQtxzid(qtxzID);
			}
			if (!CheckUtil.chkEmpty(noqtxzID)){
				v00053.setNoqtxzid(noqtxzID);
			}
			navList = t00053Service.LoadNavigator(v00053);
			treeList = t00053Service.LoadTreeList(v00053);
			t00053Bean = t00053Service.LoadByPrimaryKey(v00053);
			t00053Bean.setNoqtxzid(noqtxzID);
			t00053Bean.setParentid(parentID);
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
		t00053Bean = new Pgt00053();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				t00053Bean.setCd00001Szqy(ddlSZQY);
				t00053Bean.setXzlx(ConvertUtil.toShort(ddlXZLX));
				t00053Bean.setQtxzid(QTXZID);
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
	 * 编辑页面框架
	 * @return
	 * @throws Exception
	 */
	public String t00053Byqtxz() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("t00053Byqtxz() ********** start **********");
		}
		Pgt00053 t00053 = new Pgt00053();
		t00053Bean = new Pgt00053();
		try {
			// 取得用户选中的数据信息
			t00053.setQtxzid(QTXZID);
			t00053Bean = t00053Service.LoadByPrimaryKey(t00053);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("t00053Byqtxz() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("t00053Byqtxz() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** setter and getter ******************************/

	/**
	 * @return the t00053Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00053Service getT00053Service() {
		return t00053Service;
	}

	/**
	 * @param t00053Service
	 *            the t00053Service to set
	 */
	public void setT00053Service(IPgt00053Service t00053Service) {
		this.t00053Service = t00053Service;
	}

	/**
	 * @return the xzlxList
	 */
	public ArrayList<Pgv00053> getXzlxList() {
		return xzlxList;
	}

	/**
	 * @param xzlxList
	 *            the xzlxList to set
	 */
	public void setXzlxList(ArrayList<Pgv00053> xzlxList) {
		this.xzlxList = xzlxList;
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
	 * @param pageIndex
	 *            the pageIndex to set
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
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the operList
	 */
	public ArrayList<Pgv00053> getOperList() {
		return operList;
	}

	/**
	 * @param operList
	 *            the operList to set
	 */
	public void setOperList(ArrayList<Pgv00053> operList) {
		this.operList = operList;
	}

	/**
	 * @return the ddlXZLXFind
	 */
	public String getDdlXZLXFind() {
		return ddlXZLXFind;
	}

	/**
	 * @param ddlXZLXFind
	 *            the ddlXZLXFind to set
	 */
	public void setDdlXZLXFind(String ddlXZLXFind) {
		this.ddlXZLXFind = ddlXZLXFind;
	}

	/**
	 * @return the txtQtxzmcFind
	 */
	public String getTxtQtxzmcFind() {
		return txtQtxzmcFind;
	}

	/**
	 * @param txtQtxzmcFind
	 *            the txtQtxzmcFind to set
	 */
	public void setTxtQtxzmcFind(String txtQtxzmcFind) {
		this.txtQtxzmcFind = txtQtxzmcFind;
	}

	/**
	 * @return the ddlSZQYFind
	 */
	public String getDdlSZQYFind() {
		return ddlSZQYFind;
	}

	/**
	 * @param ddlSZQYFind
	 *            the ddlSZQYFind to set
	 */
	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
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
	 * @return the qTXZID
	 */
	public String getQTXZID() {
		return QTXZID;
	}

	/**
	 * @param qTXZID the qTXZID to set
	 */
	public void setQTXZID(String qTXZID) {
		QTXZID = qTXZID;
	}

	/**
	 * @return the t00053Bean
	 */
	public Pgt00053 getT00053Bean() {
		return t00053Bean;
	}

	/**
	 * @param t00053Bean the t00053Bean to set
	 */
	public void setT00053Bean(Pgt00053 t00053Bean) {
		this.t00053Bean = t00053Bean;
	}

	/**
	 * @return the ddlXZLX
	 */
	public String getDdlXZLX() {
		return ddlXZLX;
	}

	/**
	 * @param ddlXZLX the ddlXZLX to set
	 */
	public void setDdlXZLX(String ddlXZLX) {
		this.ddlXZLX = ddlXZLX;
	}

	/**
	 * @return the txtQTXZNM
	 */
	public String getTxtQTXZNM() {
		return txtQTXZNM;
	}

	/**
	 * @param txtQTXZNM the txtQTXZNM to set
	 */
	public void setTxtQTXZNM(String txtQTXZNM) {
		this.txtQTXZNM = txtQTXZNM;
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
	}	/**
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
	 * @return the navList
	 */
	public ArrayList<Pgt00053> getNavList() {
		return navList;
	}

	/**
	 * @param navList the navList to set
	 */
	public void setNavList(ArrayList<Pgt00053> navList) {
		this.navList = navList;
	}

	/**
	 * @return the treeList
	 */
	public ArrayList<Pgt00053> getTreeList() {
		return treeList;
	}

	/**
	 * @param treeList the treeList to set
	 */
	public void setTreeList(ArrayList<Pgt00053> treeList) {
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
	 * @return the xZLX
	 */
	public String getXZLX() {
		return XZLX;
	}

	/**
	 * @param xZLX the xZLX to set
	 */
	public void setXZLX(String xZLX) {
		XZLX = xZLX;
	}

	/**
	 * @return the nOQTXZID
	 */
	public String getNOQTXZID() {
		return NOQTXZID;
	}

	/**
	 * @param nOQTXZID the nOQTXZID to set
	 */
	public void setNOQTXZID(String nOQTXZID) {
		NOQTXZID = nOQTXZID;
	}

	/**
	 * @return the rdoQTXZ
	 */
	public String getRdoQTXZ() {
		return rdoQTXZ;
	}

	/**
	 * @param rdoQTXZ the rdoQTXZ to set
	 */
	public void setRdoQTXZ(String rdoQTXZ) {
		this.rdoQTXZ = rdoQTXZ;
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
	 * @return the rdoCZLX
	 */
	public Integer getRdoCZLX() {
		return rdoCZLX;
	}

	/**
	 * @param rdoCZLX the rdoCZLX to set
	 */
	public void setRdoCZLX(Integer rdoCZLX) {
		this.rdoCZLX = rdoCZLX;
	}

	/**
	 * @return the rdoJGLX
	 */
	public Integer getRdoJGLX() {
		return rdoJGLX;
	}

	/**
	 * @param rdoJGLX the rdoJGLX to set
	 */
	public void setRdoJGLX(Integer rdoJGLX) {
		this.rdoJGLX = rdoJGLX;
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
