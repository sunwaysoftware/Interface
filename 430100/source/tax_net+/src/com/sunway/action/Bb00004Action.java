package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IBB00004Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.BF00004;

/**
 * 
 * 交易量走势图
 * @author Andy.Gao
 *
 */
public class Bb00004Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1624799067716624340L;

	private IBB00004Service bb00004Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private ArrayList<BF00004> rows;
	private String txtSSGXFind;
	private String txtPSSDFind;
	private String txtJYJGMinFind;
	private String txtJYJGMaxFind;
	private String imgFileName;
	private String txtSSGX;
	private String sign;
	private String userRole;
	
	private String sqlData;
	private String order;
	private String sort;
	
	//数据导出
	private InputStream excelStream;
	private String fileName;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		txtPSSDFind=MakeUtil.currentYear();
		txtSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
		readRole();
		return SUCCESS;
	}

	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		BF00004 bean = new BF00004();
		try {
			bean.setCzr(sessionCtrl.getUserId());
			if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setCd00001Ssgx(txtSSGX);
			}
			
			bean.setPssd(txtPSSDFind);
			bean.setSqlData(sqlData);			
			bean.setSort(sort);;
			bean.setOrder(order); 
			rows = bb00004Service.LoadAll(bean);
			
			rows = converBean(rows);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		} finally {
			readRole();
		}
		return SUCCESS;
	}
	
	/**
	 * 数据导出未认定
	 * @return
	 * @throws Exception
	 */
	public String exportData()throws Exception{
		BF00004 bean = new BF00004();
		try {			
			if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setCd00001Ssgx(txtSSGX);
			}			
			bean.setPssd(txtPSSDFind);
			bean.setSqlData(sqlData);			
			bean.setSort(sort);;
			bean.setOrder(order); 
			bean.setExpFileName(Common.excelPath("exp_bb00004.xls"));
			ByteArrayOutputStream out = (ByteArrayOutputStream)bb00004Service.ExportData(bean);
			excelStream = new ByteArrayInputStream(out.toByteArray());
			fileName = new String("交易量统计.xls".getBytes("GBK"),"ISO-8859-1");
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
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String query02() throws Exception {
		BF00004 bean = new BF00004();
		try {
			bean.setCzr(sessionCtrl.getUserId());
			if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setCd00001Ssgx(txtSSGX);
			}
			
			bean.setPssd(txtPSSDFind);
			bean.setSqlData(sqlData);			
			bean.setSort(sort);;
			bean.setOrder(order); 
			rows = bb00004Service.LoadAll02(bean);
			
			rows = converBean(rows);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		} finally {
			readRole();
		}
		return SUCCESS;
	}
	
	/**
	 * 数据导出未认定
	 * @return
	 * @throws Exception
	 */
	public String exportData02()throws Exception{
		BF00004 bean = new BF00004();
		try {			
			if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setCd00001Ssgx(txtSSGX);
			}			
			bean.setPssd(txtPSSDFind);
			bean.setSqlData(sqlData);			
			bean.setSort(sort);;
			bean.setOrder(order); 
			bean.setExpFileName(Common.excelPath("exp_bb00004.xls"));
			ByteArrayOutputStream out = (ByteArrayOutputStream)bb00004Service.ExportData02(bean);
			excelStream = new ByteArrayInputStream(out.toByteArray());
			fileName = new String("非住宅交易量统计.xls".getBytes("GBK"),"ISO-8859-1");
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
	 * 将数据记录转换成页面需要的List
	 * @param tmpList
	 * @return
	 * @throws Exception
	 */
	public ArrayList<BF00004> converBean(ArrayList<BF00004> tmpList ) throws Exception{
		ArrayList<BF00004> bfvList = new ArrayList<BF00004>();
		BF00004 tmpBFVBean = new BF00004();
			
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
	public BF00004 isExistBean (BF00004 bf ,ArrayList<BF00004> list2 ){
		BF00004 bean = new BF00004();
		
		for (int j = 0; j < list2.size(); j++) {
			if (list2.get(j).getCd00001Ssgx().equals(bf.getCd00001Ssgx())) {
				bean = list2.get(j);
			}
		}
		//如果为新产生bean，则添加至list中
		if (CheckUtil.chkEmpty(bean.getCd00001Ssgx())) {
			list2.add(bean);
		}
		return bean;
	}
	
	/**
	 * 转换查询结果中的list为页面所需list
	 * @param bf00001
	 * @param bfv00001
	 */
	public void packBean(BF00004 BF00004, BF00004 bfv00004){
		String month = BF00004.getPssd().substring(4,6);
		
		//封装页面所需list
		bfv00004.setCd00001Ssgx(BF00004.getCd00001Ssgx());
		bfv00004.setSsgx(BF00004.getSsgx());
		switch (Integer.parseInt(month)) {
		case 1:
			bfv00004.setJanZcHs(BF00004.getZchs());
			bfv00004.setJanDsfHs(BF00004.getDsfhs());
			bfv00004.setJanHs(BF00004.getHs());
			break;
		case 2:
			bfv00004.setFebZcHs(BF00004.getZchs());
			bfv00004.setFebDsfHs(BF00004.getDsfhs());
			bfv00004.setFebHs(BF00004.getHs());		
			break;
		case 3:
			bfv00004.setMarZcHs(BF00004.getZchs());
			bfv00004.setMarDsfHs(BF00004.getDsfhs());
			bfv00004.setMarHs(BF00004.getHs());
			break;
		case 4:
			bfv00004.setArpZcHs(BF00004.getZchs());
			bfv00004.setArpDsfHs(BF00004.getDsfhs());
			bfv00004.setArpHs(BF00004.getHs());
			break;
		case 5:
			bfv00004.setMayZcHs(BF00004.getZchs());
			bfv00004.setMayDsfHs(BF00004.getDsfhs());
			bfv00004.setMayHs(BF00004.getHs());
			break;
		case 6:
			bfv00004.setJunZcHs(BF00004.getZchs());
			bfv00004.setJunDsfHs(BF00004.getDsfhs());
			bfv00004.setJunHs(BF00004.getHs());
			break;
		case 7:
			bfv00004.setJulZcHs(BF00004.getZchs());
			bfv00004.setJulDsfHs(BF00004.getDsfhs());
			bfv00004.setJulHs(BF00004.getHs());
			break;
		case 8:
			bfv00004.setAugZcHs(BF00004.getZchs());
			bfv00004.setAugDsfHs(BF00004.getDsfhs());
			bfv00004.setAugHs(BF00004.getHs());
			break;
		case 9:
			bfv00004.setSepZcHs(BF00004.getZchs());
			bfv00004.setSepDsfHs(BF00004.getDsfhs());
			bfv00004.setSepHs(BF00004.getHs());
			break;
		case 10:
			bfv00004.setOctZcHs(BF00004.getZchs());
			bfv00004.setOctDsfHs(BF00004.getDsfhs());
			bfv00004.setOctHs(BF00004.getHs());
			break;
		case 11:
			bfv00004.setNovZcHs(BF00004.getZchs());
			bfv00004.setNovDsfHs(BF00004.getDsfhs());
			bfv00004.setNovHs(BF00004.getHs());
			break;
		case 12:
			bfv00004.setDecZcHs(BF00004.getZchs());
			bfv00004.setDecDsfHs(BF00004.getDsfhs());
			bfv00004.setDecHs(BF00004.getHs());
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
	/****************************** get and set *********************************/
	
	@Override
	public void setSession(Map<String, Object> session) {
		sessionCtrl.appSession = session;
	
	}
	
	/**
	 * @param bb00004Service the bb00004Service to set
	 */
	public void setBb00004Service(IBB00004Service bb00004Service) {
		this.bb00004Service = bb00004Service;
	}

	/**
	 * @return the bb00004Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IBB00004Service getBb00004Service() {
		return bb00004Service;
	}
	

	/**
	 * @return the txtSSGXFind
	 */
	public String getTxtSSGXFind() {
		return txtSSGXFind;
	}

	/**
	 * @param txtSSGXFind the txtSSGXFind to set
	 */
	public void setTxtSSGXFind(String txtSSGXFind) {
		this.txtSSGXFind = txtSSGXFind;
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

	/**
	 * @return the txtJYJGMinFind
	 */
	public String getTxtJYJGMinFind() {
		return txtJYJGMinFind;
	}

	/**
	 * @param txtJYJGMinFind the txtJYJGMinFind to set
	 */
	public void setTxtJYJGMinFind(String txtJYJGMinFind) {
		this.txtJYJGMinFind = txtJYJGMinFind;
	}

	/**
	 * @return the txtJYJGMaxFind
	 */
	public String getTxtJYJGMaxFind() {
		return txtJYJGMaxFind;
	}

	/**
	 * @param txtJYJGMaxFind the txtJYJGMaxFind to set
	 */
	public void setTxtJYJGMaxFind(String txtJYJGMaxFind) {
		this.txtJYJGMaxFind = txtJYJGMaxFind;
	}

	/**
	 * @return the imgFileName
	 */
	public String getImgFileName() {
		return imgFileName;
	}

	/**
	 * @param imgFileName the imgFileName to set
	 */
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public String getTxtSSGX() {
		return txtSSGX;
	}

	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	public ArrayList<BF00004> getRows() {
		return rows;
	}

	public void setRows(ArrayList<BF00004> rows) {
		this.rows = rows;
	}

	public String getSqlData() {
		return sqlData;
	}

	public void setSqlData(String sqlData) {
		this.sqlData = sqlData;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
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
