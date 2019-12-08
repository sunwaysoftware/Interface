/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IBB00001Service;
import com.sunway.service.IPgt00001Service;
import com.sunway.util.Common;

import com.sunway.util.SessionCtrl;
import com.sunway.vo.BF00001;
import com.sunway.vo.BFV00001;
import com.sunway.vo.Pgv00001;

/**
 * 
 * 正常评估查询
 * @author Lee
 *
 */
public class Bb00001Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1624799067716624340L;

	private IBB00001Service bb00001Service;
	private IPgt00001Service t00001Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	private ArrayList<BF00001> beanList;
	private ArrayList<Pgv00001> fwlxList;
	private ArrayList<BFV00001> tabList; 
	private String ddlFWLX;
	private String txtPSSDFind;
	private String txtSSGX;
	private String userRole;
	private ArrayList<String> ddlFwlxList;
	

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		try {
			ReadInfo();
			txtPSSDFind=Common.getCurrentDatea();
			txtSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
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
	 * 
	 */
	private void ReadInfo() throws Exception{
		
		Pgv00001 v00001 = new Pgv00001();
		v00001.setPageIndex(1);
		v00001.setPageSize(-1);
		v00001.setRootid(sessionCtrl.Get(SessionCtrl.SESSION_INFO_FWLX_SC));
		
		fwlxList = t00001Service.LoadAll(v00001);
		
		readRole();
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
		
		BF00001 bf00001 = new BF00001();
		try {
			ReadInfo();
			// 准备查询条件
			bf00001.setFwlxids(ddlFWLX);
			if(null != ddlFWLX && !"".equals(ddlFWLX)){
				String[] tempFwlxList = ddlFWLX.split(",");
				ddlFwlxList = new ArrayList<String>();
				for(int i = 0;i < tempFwlxList.length;i++){
					ddlFwlxList.add(Common.trim(tempFwlxList[i]));
				}
			}
			
			if(Common.isNullOrEmpty(txtSSGX)){
				bf00001.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bf00001.setCd00001Ssgx(txtSSGX);
			}
			
			bf00001.setCd00002Pssd(txtPSSDFind);
			bf00001.setCd00002Czr(sessionCtrl.getUserId());
			// 执行查询
			beanList = bb00001Service.LoadAll(bf00001);
			
			tabList = converBean(beanList);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/****************************** get and set *********************************/
	
	/**
	 * @param bb00001Service the bb00001Service to set
	 */
	public void setBb00001Service(IBB00001Service bb00001Service) {
		this.bb00001Service = bb00001Service;
	}

	/**
	 * @return the bb00001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IBB00001Service getBb00001Service() {
		return bb00001Service;
	}

	/**
	 * @return the ddlFWLX
	 */
	public String getDdlFWLX() {
		return ddlFWLX;
	}

	/**
	 * @param ddlFWLX the ddlFWLX to set
	 */
	public void setDdlFWLX(String ddlFWLX) {
		this.ddlFWLX = ddlFWLX;
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
	 * @return the fwlxList
	 */
	public ArrayList<Pgv00001> getFwlxList() {
		return fwlxList;
	}


	/**
	 * @param fwlxList the fwlxList to set
	 */
	public void setFwlxList(ArrayList<Pgv00001> fwlxList) {
		this.fwlxList = fwlxList;
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
	/**
	 * @return the txtPSSDFind
	 */
	public String getTxtPSSDFind() {
		return txtPSSDFind;
	}
	/**
	 * @param txtPSSDFind the txtPSSDFind to set
	 */
	public void setTxtPSSDFind(String txtPSSDFind) {
		this.txtPSSDFind = txtPSSDFind;
	}
	
	public String getTxtSSGX() {
		return txtSSGX;
	}
	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}
	
	/**
	 * 将数据记录转换成页面需要的List
	 * @param tmpList
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BFV00001> converBean(ArrayList<BF00001> tmpList ) throws Exception{
		ArrayList<BFV00001> bfvList = new ArrayList<BFV00001>();
		BFV00001 tmpBFVBean = new BFV00001();
			
			for (int i = 0; i < tmpList.size(); i++) {
				//获得页面bean
				tmpBFVBean = isExistBean(tmpList.get(i),bfvList);
				//封装页面bean
				packBean(tmpList.get(i),tmpBFVBean);
			}
		return bfvList;
	}
	
	/**
	 * 判断list中是否已经存在bean
	 * @param bf
	 * @param list2
	 * @return
	 */
	public BFV00001 isExistBean (BF00001 bf ,ArrayList<BFV00001> list2 ){
		BFV00001 bean = new BFV00001();
		
		for (int j = 0; j < list2.size(); j++) {
			if (list2.get(j).getCd00001Ssgx1().equals(bf.getCd00001Ssgx1())) {
				bean = list2.get(j);
			}
		}
		//如果为新产生bean，则添加至list中
		if (Common.isNullOrEmpty(bean.getCd00001Ssgx1())) {
			list2.add(bean);
		}
		return bean;
	}
	
	/**
	 * 转换查询结果中的list为页面所需list
	 * @param bf00001
	 * @param bfv00001
	 */
	public void packBean(BF00001 bf00001, BFV00001 bfv00001){
		String month = bf00001.getCd00002Pssd().substring(4,6);
		
		//封装页面所需list
		bfv00001.setCd00001Ssgx1(bf00001.getCd00001Ssgx1());
		bfv00001.setSsgx(bf00001.getSsgx());
		switch (Integer.parseInt(month)) {
		case 1:
			bfv00001.setJanHs(bf00001.getHs());
			bfv00001.setJanSbjg(bf00001.getSbjg());
			bfv00001.setJanHdjg(bf00001.getHdjg());
			bfv00001.setJanPgjg(bf00001.getPgjg());
			break;
		case 2:
			bfv00001.setFebHs(bf00001.getHs());
			bfv00001.setFebSbjg(bf00001.getSbjg());
			bfv00001.setFebHdjg(bf00001.getHdjg());
			bfv00001.setFebPgjg(bf00001.getPgjg());				
			break;
		case 3:
			bfv00001.setMarHs(bf00001.getHs());
			bfv00001.setMarSbjg(bf00001.getSbjg());
			bfv00001.setMarHdjg(bf00001.getHdjg());
			bfv00001.setMarPgjg(bf00001.getPgjg());
			break;
		case 4:
			bfv00001.setArpHs(bf00001.getHs());
			bfv00001.setArpSbjg(bf00001.getSbjg());
			bfv00001.setArpHdjg(bf00001.getHdjg());
			bfv00001.setArpPgjg(bf00001.getPgjg());
			break;
		case 5:
			bfv00001.setMayHs(bf00001.getHs());
			bfv00001.setMaySbjg(bf00001.getSbjg());
			bfv00001.setMayHdjg(bf00001.getHdjg());
			bfv00001.setMayPgjg(bf00001.getPgjg());
			break;
		case 6:
			bfv00001.setJunHs(bf00001.getHs());
			bfv00001.setJunSbjg(bf00001.getSbjg());
			bfv00001.setJunHdjg(bf00001.getHdjg());
			bfv00001.setJunPgjg(bf00001.getPgjg());
			break;
		case 7:
			bfv00001.setJulHs(bf00001.getHs());
			bfv00001.setJulSbjg(bf00001.getSbjg());
			bfv00001.setJulHdjg(bf00001.getHdjg());
			bfv00001.setJulPgjg(bf00001.getPgjg());
			break;
		case 8:
			bfv00001.setAugHs(bf00001.getHs());
			bfv00001.setAugSbjg(bf00001.getSbjg());
			bfv00001.setAugHdjg(bf00001.getHdjg());
			bfv00001.setAugPgjg(bf00001.getPgjg());
			break;
		case 9:
			bfv00001.setSepHs(bf00001.getHs());
			bfv00001.setSepSbjg(bf00001.getSbjg());
			bfv00001.setSepHdjg(bf00001.getHdjg());
			bfv00001.setSepPgjg(bf00001.getPgjg());
			break;
		case 10:
			bfv00001.setOctHs(bf00001.getHs());
			bfv00001.setOctSbjg(bf00001.getSbjg());
			bfv00001.setOctHdjg(bf00001.getHdjg());
			bfv00001.setOctPgjg(bf00001.getPgjg());
			break;
		case 11:
			bfv00001.setNovHs(bf00001.getHs());
			bfv00001.setNovSbjg(bf00001.getSbjg());
			bfv00001.setNovHdjg(bf00001.getHdjg());
			bfv00001.setNovPgjg(bf00001.getPgjg());
			break;
		case 12:
			bfv00001.setDecHs(bf00001.getHs());
			bfv00001.setDecSbjg(bf00001.getSbjg());
			bfv00001.setDecHdjg(bf00001.getHdjg());
			bfv00001.setDecPgjg(bf00001.getPgjg());
			break;
		default:
			break;
		}
	}
	public ArrayList<String> getDdlFwlxList() {
		return ddlFwlxList;
	}
	public void setDdlFwlxList(ArrayList<String> ddlFwlxList) {
		this.ddlFwlxList = ddlFwlxList;
	}
	/**
	 * 读取ROLE.
	 */	
	protected void readRole() throws Exception {
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
	}
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	/**
	 * @return the beanList
	 */
	public ArrayList<BF00001> getBeanList() {
		return beanList;
	}
	/**
	 * @param beanList the beanList to set
	 */
	public void setBeanList(ArrayList<BF00001> beanList) {
		this.beanList = beanList;
	}
	/**
	 * @return the tabList
	 */
	public ArrayList<BFV00001> getTabList() {
		return tabList;
	}
	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<BFV00001> tabList) {
		this.tabList = tabList;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
