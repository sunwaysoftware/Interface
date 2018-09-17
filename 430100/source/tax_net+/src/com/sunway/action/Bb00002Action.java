/**
 * 
 */
package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IBB00002Service;
import com.sunway.service.IPgt00001Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.BF00002;
import com.sunway.vo.BFV00002;
import com.sunway.vo.Pgv00001;

/**
 * 
 * 正常评估查询
 * @author Lee
 *
 */
public class Bb00002Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1624799067716624340L;

	private IBB00002Service bb00002Service;
	private IPgt00001Service t00001Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	private ArrayList<BF00002> beanList;
	private ArrayList<BFV00002> rows; 
	private String ddlFWLX;
	private String txtPSSDFind;
	private String txtSSGX;
	private String userRole;
	
	//数据导出
	private InputStream excelStream;
	private String fileName;

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
			txtPSSDFind=MakeUtil.currentYear();
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
		//fwlxList = t00001Service.LoadAll(v00001);
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

		BF00002 bf00002 = new BF00002();
		try {
			ReadInfo();
			// 准备查询条件
			bf00002.setFwlxids(ddlFWLX);
			/*if(null != ddlFWLX && !"".equals(ddlFWLX)){
				String[] tempFwlxList = ddlFWLX.split(",");
				ddlFwlxList = new ArrayList<String>();
				for(int i = 0;i < tempFwlxList.length;i++){
					ddlFwlxList.add(CheckUtil.chkTrim(tempFwlxList[i]));
				}
			}*/
			if(CheckUtil.chkEmpty(txtSSGX)){
				bf00002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bf00002.setCd00001Ssgx(txtSSGX);
			}
			
			bf00002.setCd00002Pssd(txtPSSDFind);
			bf00002.setCd00002Czr(sessionCtrl.getUserId());
			// 执行查询
			beanList = bb00002Service.LoadAll(bf00002);
			
			rows = converBean(beanList);
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
	 * 查询状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query02() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		BF00002 bf00002 = new BF00002();
		try {
			ReadInfo();
			// 准备查询条件
			bf00002.setFwlxids(ddlFWLX);
			/*if(null != ddlFWLX && !"".equals(ddlFWLX)){
				String[] tempFwlxList = ddlFWLX.split(",");
				ddlFwlxList = new ArrayList<String>();
				for(int i = 0;i < tempFwlxList.length;i++){
					ddlFwlxList.add(CheckUtil.chkTrim(tempFwlxList[i]));
				}
			}*/
			if(CheckUtil.chkEmpty(txtSSGX)){
				bf00002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bf00002.setCd00001Ssgx(txtSSGX);
			}
			
			bf00002.setCd00002Pssd(txtPSSDFind);
			bf00002.setCd00002Czr(sessionCtrl.getUserId());
			// 执行查询
			beanList = bb00002Service.LoadAll02(bf00002);
			
			rows = converBean(beanList);
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
	 * 数据导出未认定
	 * @return
	 * @throws Exception
	 */
	public String exportData()throws Exception{
		BF00002 bf00002 = new BF00002();
		try {
			ReadInfo();
			// 准备查询条件
			bf00002.setFwlxids(ddlFWLX);
			/*if(null != ddlFWLX && !"".equals(ddlFWLX)){
				String[] tempFwlxList = ddlFWLX.split(",");
				ddlFwlxList = new ArrayList<String>();
				for(int i = 0;i < tempFwlxList.length;i++){
					ddlFwlxList.add(CheckUtil.chkTrim(tempFwlxList[i]));
				}
			}*/
			
			if(CheckUtil.chkEmpty(txtSSGX)){
				bf00002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bf00002.setCd00001Ssgx(txtSSGX);
			}
			
			bf00002.setCd00002Pssd(txtPSSDFind);
			bf00002.setCd00002Czr(sessionCtrl.getUserId());
			bf00002.setExpFileName(Common.excelPath("exp_bb00002.xls"));
			ByteArrayOutputStream out = (ByteArrayOutputStream)bb00002Service.ExportData(bf00002);
			excelStream = new ByteArrayInputStream(out.toByteArray());
			fileName = new String("国土价格对比分析-个案.xls".getBytes("GBK"),"ISO-8859-1");
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportData() ********** end **********");
			}
			this.addActionError(e.getMessage().replace("/", "\\").replace("\n", "<br />"));
			return INPUT;
		}finally{
			//
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportData() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 数据导出未认定
	 * @return
	 * @throws Exception
	 */
	public String exportData02()throws Exception{
		BF00002 bf00002 = new BF00002();
		try {
			ReadInfo();
			// 准备查询条件
			bf00002.setFwlxids(ddlFWLX);
			/*if(null != ddlFWLX && !"".equals(ddlFWLX)){
				String[] tempFwlxList = ddlFWLX.split(",");
				ddlFwlxList = new ArrayList<String>();
				for(int i = 0;i < tempFwlxList.length;i++){
					ddlFwlxList.add(CheckUtil.chkTrim(tempFwlxList[i]));
				}
			}*/
			
			if(CheckUtil.chkEmpty(txtSSGX)){
				bf00002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bf00002.setCd00001Ssgx(txtSSGX);
			}
			
			bf00002.setCd00002Pssd(txtPSSDFind);
			bf00002.setCd00002Czr(sessionCtrl.getUserId());
			bf00002.setExpFileName(Common.excelPath("exp_bb00002.xls"));
			ByteArrayOutputStream out = (ByteArrayOutputStream)bb00002Service.ExportData02(bf00002);
			excelStream = new ByteArrayInputStream(out.toByteArray());
			fileName = new String("非住宅国土价格对比分析-个案.xls".getBytes("GBK"),"ISO-8859-1");
		}catch(Exception e){
			e.printStackTrace();
			if(LOG.isDebugEnabled()){
				LOG.debug("exportData() ********** end **********");
			}
			this.addActionError(e.getMessage().replace("/", "\\").replace("\n", "<br />"));
			return INPUT;
		}finally{
			//
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("exportData() ********** end **********");
		}
		return SUCCESS;
	}
	
	/****************************** get and set *********************************/
	
	/**
	 * @param bb00002Service the bb00002Service to set
	 */
	public void setBb00002Service(IBB00002Service bb00002Service) {
		this.bb00002Service = bb00002Service;
	}

	/**
	 * @return the bb00002Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IBB00002Service getBb00002Service() {
		return bb00002Service;
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
	public ArrayList<BFV00002> converBean(ArrayList<BF00002> tmpList ) throws Exception{
		ArrayList<BFV00002> bfvList = new ArrayList<BFV00002>();
		BFV00002 tmpBFVBean = new BFV00002();
			
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
	public BFV00002 isExistBean (BF00002 bf ,ArrayList<BFV00002> list2 ){
		BFV00002 bean = new BFV00002();
		
		for (int j = 0; j < list2.size(); j++) {
			if (list2.get(j).getCd00001Ssgx1().equals(bf.getCd00001Ssgx1())) {
				bean = list2.get(j);
			}
		}
		//如果为新产生bean，则添加至list中
		if (CheckUtil.chkEmpty(bean.getCd00001Ssgx1())) {
			list2.add(bean);
		}
		return bean;
	}
	
	/**
	 * 转换查询结果中的list为页面所需list
	 * @param bf00002
	 * @param bfv00002
	 */
	public void packBean(BF00002 bf00002, BFV00002 bfv00002){
		String month = bf00002.getCd00002Pssd().substring(4,6);
		
		//封装页面所需list
		bfv00002.setCd00001Ssgx1(bf00002.getCd00001Ssgx1());
		bfv00002.setSsgx(bf00002.getSsgx());
		switch (Integer.parseInt(month)) {
		case 1:
			bfv00002.setJanHs(bf00002.getHs());
			bfv00002.setJanSbjg(bf00002.getSbjg());
			bfv00002.setJanHdjg(bf00002.getHdjg());
			bfv00002.setJanPgjg(bf00002.getPgjg());
			break;
		case 2:
			bfv00002.setFebHs(bf00002.getHs());
			bfv00002.setFebSbjg(bf00002.getSbjg());
			bfv00002.setFebHdjg(bf00002.getHdjg());
			bfv00002.setFebPgjg(bf00002.getPgjg());				
			break;
		case 3:
			bfv00002.setMarHs(bf00002.getHs());
			bfv00002.setMarSbjg(bf00002.getSbjg());
			bfv00002.setMarHdjg(bf00002.getHdjg());
			bfv00002.setMarPgjg(bf00002.getPgjg());
			break;
		case 4:
			bfv00002.setArpHs(bf00002.getHs());
			bfv00002.setArpSbjg(bf00002.getSbjg());
			bfv00002.setArpHdjg(bf00002.getHdjg());
			bfv00002.setArpPgjg(bf00002.getPgjg());
			break;
		case 5:
			bfv00002.setMayHs(bf00002.getHs());
			bfv00002.setMaySbjg(bf00002.getSbjg());
			bfv00002.setMayHdjg(bf00002.getHdjg());
			bfv00002.setMayPgjg(bf00002.getPgjg());
			break;
		case 6:
			bfv00002.setJunHs(bf00002.getHs());
			bfv00002.setJunSbjg(bf00002.getSbjg());
			bfv00002.setJunHdjg(bf00002.getHdjg());
			bfv00002.setJunPgjg(bf00002.getPgjg());
			break;
		case 7:
			bfv00002.setJulHs(bf00002.getHs());
			bfv00002.setJulSbjg(bf00002.getSbjg());
			bfv00002.setJulHdjg(bf00002.getHdjg());
			bfv00002.setJulPgjg(bf00002.getPgjg());
			break;
		case 8:
			bfv00002.setAugHs(bf00002.getHs());
			bfv00002.setAugSbjg(bf00002.getSbjg());
			bfv00002.setAugHdjg(bf00002.getHdjg());
			bfv00002.setAugPgjg(bf00002.getPgjg());
			break;
		case 9:
			bfv00002.setSepHs(bf00002.getHs());
			bfv00002.setSepSbjg(bf00002.getSbjg());
			bfv00002.setSepHdjg(bf00002.getHdjg());
			bfv00002.setSepPgjg(bf00002.getPgjg());
			break;
		case 10:
			bfv00002.setOctHs(bf00002.getHs());
			bfv00002.setOctSbjg(bf00002.getSbjg());
			bfv00002.setOctHdjg(bf00002.getHdjg());
			bfv00002.setOctPgjg(bf00002.getPgjg());
			break;
		case 11:
			bfv00002.setNovHs(bf00002.getHs());
			bfv00002.setNovSbjg(bf00002.getSbjg());
			bfv00002.setNovHdjg(bf00002.getHdjg());
			bfv00002.setNovPgjg(bf00002.getPgjg());
			break;
		case 12:
			bfv00002.setDecHs(bf00002.getHs());
			bfv00002.setDecSbjg(bf00002.getSbjg());
			bfv00002.setDecHdjg(bf00002.getHdjg());
			bfv00002.setDecPgjg(bf00002.getPgjg());
			break;
		default:
			break;
		}
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
	public ArrayList<BF00002> getBeanList() {
		return beanList;
	}
	/**
	 * @param beanList the beanList to set
	 */
	public void setBeanList(ArrayList<BF00002> beanList) {
		this.beanList = beanList;
	}
	/**
	 * @return the rows
	 */
	public ArrayList<BFV00002> getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<BFV00002> rows) {
		this.rows = rows;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
	public InputStream getExcelStream() {
		return excelStream;
	}
	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
