package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00001Service;
import com.sunway.service.IPgt00359Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00001;
import com.sunway.vo.Pgt00359;
import com.sunway.vo.Pgv00001;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00359;

/**
 * 所在区域下的参数类型配置(Pgt00359)
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class Pgt00359Action extends ActionSupport  implements SessionAware {

	private static final long serialVersionUID = 8437296431705701562L;
	//Service
	private IPgt00359Service t00359Service;
	private IPgt00001Service t00001Service;
	
	//View

	//分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	//Bean数组
	private ArrayList<Pgv00359> tabList;
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv00001> zhxzList;

	private Pgv00359 v00359Bean;
	//primary key 主键
	private String ROOT;
	private String INFOID;
	private String SZQY;
	private String FWLX;
	
	private String ACT;
	
	//表单提交数据
	private String ddlSZQY;
	private String txtFWLXTIP;
	private String txtFWLX;
	private String chkZHXZ;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String PARENTID;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}	
		
		v00359Bean = new Pgv00359();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();			
			//readZHXZList();
			v00359Bean.setCd00001Szqy(ddlSZQY);
			v00359Bean.setCd00001Fwlx(txtFWLX);
			//得到名称
			Pgt00001 t00001Dao  = new Pgt00001();
			t00001Dao.setInfoid(txtFWLX);
			t00001Dao.setRootid(t00001Service.GetInfoFWLX_SC());
			v00359Bean.setFwlx(t00001Service.LoadNavString(t00001Dao));	
			
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

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */	
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		
		v00359Bean = new Pgv00359();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();
			readZHXZList();
			
			v00359Bean.setCd00001Szqy(ddlSZQY);
			v00359Bean.setCd00001Fwlx(txtFWLX);
//			//得到名称
//			Pgt00001 t00001Dao  = new Pgt00001();
//			t00001Dao.setInfoid(txtFWLX);
//			t00001Dao.setRootid(t00001Service.GetInfoFWLX_SC());
//			v00359Bean.setFwlx(t00001Service.LoadNavString(t00001Dao));	
			
			tabList = t00359Service.LoadAll(v00359Bean);
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
	 * 读取综合修正列表
	 * @throws Exception
	 */
	private void readZHXZList() throws Exception{
		zhxzList = t00001Service.LoadAllZHXZ();
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
		Pgt00359 t00359 = new Pgt00359();
		try {
			t00359.setInfoids(chkZHXZ);
			t00359.setCd00001Szqy(ddlSZQY);
			t00359.setCd00001Fwlx(txtFWLX);
			if(t00359Service.GetUpdateCommand(t00359)){
				this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{t00359.getCd00001Szqy()}));
			}else
				this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{t00359.getCd00001Szqy()}));
			
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
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String LoadParentIds() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("loadParentIds() ********** start **********");
		}
		Pgt00359 t00359 = new Pgt00359();
		try {
			t00359.setCd00001Szqy(SZQY);
			t00359.setCd00001Fwlx(FWLX);
			PARENTID = t00359Service.LoadParentIdsBySzqy(t00359);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("loadParentIds() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("loadParentIds() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/

	/**
	 * @return the t00359Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00359Service getT00359Service() {
		return t00359Service;
	}

	/**
	 * @param t00359Service the t00359Service to set
	 */
	public void setT00359Service(IPgt00359Service t00359Service) {
		this.t00359Service = t00359Service;
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
	 * @return the tabList
	 */
	public ArrayList<Pgv00359> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00359> tabList) {
		this.tabList = tabList;
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
	 * @return the rOOT
	 */
	public String getROOT() {
		return ROOT;
	}

	/**
	 * @param rOOT the rOOT to set
	 */
	public void setROOT(String rOOT) {
		ROOT = rOOT;
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
	 * @return the zhxzList
	 */
	public ArrayList<Pgv00001> getZhxzList() {
		return zhxzList;
	}

	/**
	 * @param zhxzList the zhxzList to set
	 */
	public void setZhxzList(ArrayList<Pgv00001> zhxzList) {
		this.zhxzList = zhxzList;
	}


	/**
	 * @return the chkZHXZ
	 */
	public String getChkZHXZ() {
		return chkZHXZ;
	}


	/**
	 * @param chkZHXZ the chkZHXZ to set
	 */
	public void setChkZHXZ(String chkZHXZ) {
		this.chkZHXZ = chkZHXZ;
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
	 * @return the t00001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00001Service getT00001Service() {
		return t00001Service;
	}
	/**
	 * @param t00001Service the t00001Service to set
	 */
	public void setT00001Service(IPgt00001Service t00001Service) {
		this.t00001Service = t00001Service;
	}
	public void setFWLX(String fWLX) {
		FWLX = fWLX;
	}
	public String getFWLX() {
		return FWLX;
	}
	
	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}
	public String getTxtFWLX() {
		return txtFWLX;
	}
	public void setV00359Bean(Pgv00359 v00359Bean) {
		this.v00359Bean = v00359Bean;
	}
	public Pgv00359 getV00359Bean() {
		return v00359Bean;
	}
	public void setTxtFWLXTIP(String txtFWLXTIP) {
		this.txtFWLXTIP = txtFWLXTIP;
	}
	public String getTxtFWLXTIP() {
		return txtFWLXTIP;
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
