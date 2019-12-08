/**
 * 
 */
package com.sunway.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00351Service;
import com.sunway.service.IPgt00352Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00351;
import com.sunway.vo.Pgt00352;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00351;

/**
 * 
 * 不同区域测算
 * @author Andy.Gao
 *
 */
public class Pgt00351CsDiffAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 4229863517117985025L;
	private IPgt00351Service t00351Service;
	private IPgt00352Service t00352Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	// 小区树用
	private ArrayList<Pgt00352> navList;
	private ArrayList<Pgt00352> treeList;
	private String SZQY;
	private String PSSD;
	private String XQDM;
	private String NOXQDM;
	private String rdoXQ;
	private String PARENTDM;
	private Pgt00352 t00352Bean;
	//output stream
	private InputStream xqNav;
	
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	
	// View
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv00351> tabwList;
	private ArrayList<Pgv00351> tabyList;
	private String txtXQMC;
	private String txtPSSD;
	private String ddlSZQY;
	private Map<String, String> xqWList;
	private Map<String, String> xqYList;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
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
	 * 数据查询用(无价格)
	 * @return
	 * @throws Exception
	 */
	public String queryW() throws Exception {
		Pgv00351 v00351 = new Pgv00351();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00351.setCd00352Xqdm(txtXQMC);
			if (!Common.isNullOrEmpty(txtPSSD))
				v00351.setJysj(Common.convertToDate(txtPSSD+"-01"));
			v00351.setPageIndex(pageIndex);
			v00351.setPageSize(getPageSize());
			tabwList = t00351Service.LoadAllCsDiffW(v00351);
			// 分页设置
			if (null != tabwList && tabwList.size() > 0) {
				rowCount = tabwList.get(0).getRecordCount();
			} else {
				rowCount = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 数据查询用(有价格)
	 * @return
	 * @throws Exception
	 */
	public String queryY() throws Exception {
		Pgv00351 v00351 = new Pgv00351();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00351.setCd00352Xqdm(txtXQMC);
			if (!Common.isNullOrEmpty(txtPSSD))
				v00351.setJysj(Common.convertToDate(txtPSSD+"-01"));
			v00351.setPageIndex(pageIndex);
			v00351.setPageSize(getPageSize());
			tabyList = t00351Service.LoadAllCsDiffY(v00351);
			// 分页设置
			if (null != tabyList && tabyList.size() > 0) {
				rowCount = tabyList.get(0).getRecordCount();
			} else {
				rowCount = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}
	
	
	/**
	 * 取得【所在区域】下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	/**
	 * 读取导航条数据，AJAX方法用【无价格】
	 * @return
	 * @throws Exception
	 */
	public String loadNavigatorW() throws Exception{		
		return getNavigatorW(SZQY, PSSD, XQDM, NOXQDM, PARENTDM);
	}
	private String getNavigatorW(String szqy, String pssd, String xqdm, String noxqdm, String parentdm) throws Exception {
		Pgt00352 v00352 = new Pgt00352();
		try {
			// 取得【导航条】
			if (!Common.isNullOrEmpty(xqdm))
				v00352.setXqdm(xqdm);
			navList = t00352Service.LoadNavigator(v00352);
			// 取得【小区名称】
			Pgt00351 bean = new Pgt00351();
			bean.setCd00001Szqy(szqy);
			bean.setCd00352Xqdm(xqdm);
			if(!Common.isNullOrEmpty(pssd))
				bean.setJysj(Common.convertToDate(pssd+"-01"));
			//读取有价格小区名称
			treeList = t00351Service.LoadXqW(bean);		
			t00352Bean = t00352Service.LoadByPrimaryKey(v00352);
			t00352Bean.setNoxqdm(noxqdm);
			t00352Bean.setParentdm(parentdm);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * AJAX方法使用，取得小区导航【无价格】
	 * @return
	 * @throws Exception
	 */
	public String LoadXQNavW() throws Exception{
		return getNavStreamW(XQDM);
	}
	private String getNavStreamW(String xqdm) throws Exception {
		StringBuffer strBuf = new StringBuffer();
		try {
			if (!Common.isNullOrEmpty(xqdm)) {
				String xqnm = t00352Service.LoadNavStream(xqdm);
				if (!Common.isNullOrEmpty(xqnm))
					strBuf.append(xqnm);
				else
					strBuf.append(Constant.STRING_EMPTY);	
			}
			setXqNav(Common.exportTEXT(strBuf));
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 读取导航条数据，AJAX方法用【无价格】
	 * @return
	 * @throws Exception
	 */
	public String loadNavigatorY() throws Exception{		
		return getNavigatorY(SZQY, PSSD, XQDM, NOXQDM, PARENTDM);
	}
	private String getNavigatorY(String szqy, String pssd, String xqdm, String noxqdm, String parentdm) throws Exception {
		Pgt00352 v00352 = new Pgt00352();
		try {
			// 取得【导航条】
			if (!Common.isNullOrEmpty(xqdm))
				v00352.setXqdm(xqdm);
			navList = t00352Service.LoadNavigator(v00352);
			// 取得【小区名称】
			Pgt00351 bean = new Pgt00351();
			bean.setCd00001Szqy(szqy);
			bean.setCd00352Xqdm(xqdm);
			if(!Common.isNullOrEmpty(pssd))
				bean.setJysj(Common.convertToDate(pssd+"-01"));
			//读取有价格小区名称
			treeList = t00351Service.LoadXqY(bean);		
			t00352Bean = t00352Service.LoadByPrimaryKey(v00352);
			t00352Bean.setNoxqdm(noxqdm);
			t00352Bean.setParentdm(parentdm);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * AJAX方法使用，取得小区导航【无价格】
	 * @return
	 * @throws Exception
	 */
	public String LoadXQNavY() throws Exception{
		return getNavStreamY(XQDM);
	}
	private String getNavStreamY(String xqdm) throws Exception {
		StringBuffer strBuf = new StringBuffer();
		try {
			if (!Common.isNullOrEmpty(xqdm)) {
				String xqnm = t00352Service.LoadNavStream(xqdm);
				if (!Common.isNullOrEmpty(xqnm))
					strBuf.append(xqnm);
				else
					strBuf.append(Constant.STRING_EMPTY);	
			}
			setXqNav(Common.exportTEXT(strBuf));
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}
	
	/*************************** set and get **********************************/
	
	/**
	 * @param t00351Service the t00351Service to set
	 */
	public void setT00351Service(IPgt00351Service t00351Service) {
		this.t00351Service = t00351Service;
	}

	/**
	 * @return the t00351Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00351Service getT00351Service() {
		return t00351Service;
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
	 * @return the txtXQMC
	 */
	public String getTxtXQMC() {
		return txtXQMC;
	}

	/**
	 * @param txtXQMC the txtXQMC to set
	 */
	public void setTxtXQMC(String txtXQMC) {
		this.txtXQMC = txtXQMC;
	}

	/**
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}

	/**
	 * @param txtPSSD the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}

	/**
	 * @return the tabwList
	 */
	public ArrayList<Pgv00351> getTabwList() {
		return tabwList;
	}

	/**
	 * @param tabwList the tabwList to set
	 */
	public void setTabwList(ArrayList<Pgv00351> tabwList) {
		this.tabwList = tabwList;
	}

	/**
	 * @return the tabyList
	 */
	public ArrayList<Pgv00351> getTabyList() {
		return tabyList;
	}

	/**
	 * @param tabyList the tabyList to set
	 */
	public void setTabyList(ArrayList<Pgv00351> tabyList) {
		this.tabyList = tabyList;
	}

	/**
	 * @return the xqWList
	 */
	public Map<String, String> getXqWList() {
		return xqWList;
	}

	/**
	 * @param xqWList the xqWList to set
	 */
	public void setXqWList(Map<String, String> xqWList) {
		this.xqWList = xqWList;
	}

	/**
	 * @return the xqYList
	 */
	public Map<String, String> getXqYList() {
		return xqYList;
	}

	/**
	 * @param xqYList the xqYList to set
	 */
	public void setXqYList(Map<String, String> xqYList) {
		this.xqYList = xqYList;
	}

	/**
	 * @return the navList
	 */
	public ArrayList<Pgt00352> getNavList() {
		return navList;
	}

	/**
	 * @param navList the navList to set
	 */
	public void setNavList(ArrayList<Pgt00352> navList) {
		this.navList = navList;
	}

	/**
	 * @return the treeList
	 */
	public ArrayList<Pgt00352> getTreeList() {
		return treeList;
	}

	/**
	 * @param treeList the treeList to set
	 */
	public void setTreeList(ArrayList<Pgt00352> treeList) {
		this.treeList = treeList;
	}

	/**
	 * @return the t00352Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00352Service getT00352Service() {
		return t00352Service;
	}

	/**
	 * @param t00352Service the t00352Service to set
	 */
	public void setT00352Service(IPgt00352Service t00352Service) {
		this.t00352Service = t00352Service;
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
	 * @return the nOXQDM
	 */
	public String getNOXQDM() {
		return NOXQDM;
	}

	/**
	 * @param nOXQDM the nOXQDM to set
	 */
	public void setNOXQDM(String nOXQDM) {
		NOXQDM = nOXQDM;
	}

	/**
	 * @return the rdoXQ
	 */
	public String getRdoXQ() {
		return rdoXQ;
	}

	/**
	 * @param rdoXQ the rdoXQ to set
	 */
	public void setRdoXQ(String rdoXQ) {
		this.rdoXQ = rdoXQ;
	}

	/**
	 * @return the pARENTDM
	 */
	public String getPARENTDM() {
		return PARENTDM;
	}

	/**
	 * @param pARENTDM the pARENTDM to set
	 */
	public void setPARENTDM(String pARENTDM) {
		PARENTDM = pARENTDM;
	}

	/**
	 * @param xQDM the xQDM to set
	 */
	public void setXQDM(String xQDM) {
		XQDM = xQDM;
	}

	/**
	 * @return the xQDM
	 */
	public String getXQDM() {
		return XQDM;
	}

	/**
	 * @param t00352Bean the t00352Bean to set
	 */
	public void setT00352Bean(Pgt00352 t00352Bean) {
		this.t00352Bean = t00352Bean;
	}

	/**
	 * @return the t00352Bean
	 */
	public Pgt00352 getT00352Bean() {
		return t00352Bean;
	}

	/**
	 * @param xqNav the xqNav to set
	 */
	public void setXqNav(InputStream xqNav) {
		this.xqNav = xqNav;
	}

	/**
	 * @return the xqNav
	 */
	public InputStream getXqNav() {
		return xqNav;
	}

	/**
	 * @param ddlSZQY the ddlSZQY to set
	 */
	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}

	/**
	 * @return the ddlSZQY
	 */
	public String getDdlSZQY() {
		return ddlSZQY;
	}

	/**
	 * @param pSSD the pSSD to set
	 */
	public void setPSSD(String pSSD) {
		PSSD = pSSD;
	}

	/**
	 * @return the pSSD
	 */
	public String getPSSD() {
		return PSSD;
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
