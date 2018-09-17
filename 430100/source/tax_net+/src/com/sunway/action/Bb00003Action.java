package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IBB00003Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.BF00003;
import com.sunway.vo.Pgv00052;

/**
 * 
 * 价格走势分析图
 * @author Andy.Gao
 *
 */
public class Bb00003Action extends ActionSupport implements SessionAware{
	private static final long serialVersionUID = -1624799067716624340L;

	private ArrayList<Pgv00052> szqyList;
	private IBB00003Service bb00003Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private ArrayList<BF00003> rows;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtXQFind;
	private String txtZCDZLFind;
	private String txtJZMJMINFind;
	private String txtJZMJMAXFind;
	private String txtJYJGMINFind;
	private String txtJYJGMAXFind;
	private String txtJYSJFind;
	private String txtSZLCFind;
	private String txtZCDZBMFind;
	private String txtLXDHFind;
	private String txtFCZHFind;
	private String txtDJRQFind;
	private String txtJZJGFind;
	private String txtJYLXFind;
	private String txtFWLXFind;
	private String txtZJLXFind;
	private String txtPSSDFind;
	private String imgFileName;
	private String PSSD;
	private String ddlSZQYFind;
	private String txtSSGX;
	private String userRole;
	private String sign;
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
		ReadInfo();
		txtPSSDFind=MakeUtil.currentYear();
		txtSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);		
		return SUCCESS;
	}

	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		BF00003 bean = new BF00003();
		try {
			
			if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setCd00001Ssgx(txtSSGX);
			}			
			bean.setCd00002Pssd(txtPSSDFind);
			bean.setCd00002Czr(sessionCtrl.getUserId());
			bean.setSqlData(sqlData);			
			bean.setSort(sort);;
			bean.setOrder(order); 
			rows = bb00003Service.LoadAll(bean);			
			
			rows = converBean(rows);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		} finally {
			ReadInfo();
		}
		return SUCCESS;
	}
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String query02() throws Exception {
		BF00003 bean = new BF00003();
		try {
			
			if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setCd00001Ssgx(txtSSGX);
			}			
			bean.setCd00002Pssd(txtPSSDFind);
			bean.setCd00002Czr(sessionCtrl.getUserId());
			bean.setSqlData(sqlData);			
			bean.setSort(sort);;
			bean.setOrder(order); 
			rows = bb00003Service.LoadAll02(bean);			
			
			rows = converBean(rows);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		} finally {
			ReadInfo();
		}
		return SUCCESS;
	}
	
	/**
	 * 数据导出未认定
	 * @return
	 * @throws Exception
	 */
	public String exportData()throws Exception{
		BF00003 bean = new BF00003();
		try {			
			if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setCd00001Ssgx(txtSSGX);
			}			
			bean.setCd00002Pssd(txtPSSDFind);
			bean.setCd00002Czr(sessionCtrl.getUserId());
			bean.setSqlData(sqlData);			
			bean.setSort(sort);;
			bean.setOrder(order); 
			bean.setExpFileName(Common.excelPath("exp_bb00003.xls"));
			ByteArrayOutputStream out = (ByteArrayOutputStream)bb00003Service.ExportData(bean);
			excelStream = new ByteArrayInputStream(out.toByteArray());
			fileName = new String("价格走势分析图.xls".getBytes("GBK"),"ISO-8859-1");
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
		BF00003 bean = new BF00003();
		try {			
			if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setCd00001Ssgx(txtSSGX);
			}			
			bean.setCd00002Pssd(txtPSSDFind);
			bean.setCd00002Czr(sessionCtrl.getUserId());
			bean.setSqlData(sqlData);			
			bean.setSort(sort);;
			bean.setOrder(order); 
			bean.setExpFileName(Common.excelPath("exp_bb00003.xls"));
			ByteArrayOutputStream out = (ByteArrayOutputStream)bb00003Service.ExportData02(bean);
			excelStream = new ByteArrayInputStream(out.toByteArray());
			fileName = new String("非住宅价格走势分析图.xls".getBytes("GBK"),"ISO-8859-1");
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
	public ArrayList<BF00003> converBean(ArrayList<BF00003> tmpList ) throws Exception{
		ArrayList<BF00003> bfvList = new ArrayList<BF00003>();
		BF00003 tmpBFVBean = new BF00003();
			
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
	public BF00003 isExistBean (BF00003 bf ,ArrayList<BF00003> list2 ){
		BF00003 bean = new BF00003();
		
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
	public void packBean(BF00003 bf00003, BF00003 bfv00003){
		String month = bf00003.getCd00002Pssd().substring(4,6);
		
		//封装页面所需list
		bfv00003.setCd00001Ssgx(bf00003.getCd00001Ssgx());
		bfv00003.setSsgx(bf00003.getSsgx());
		switch (Integer.parseInt(month)) {
		case 1:
			bfv00003.setJanSbjg(bf00003.getSbjg());
			bfv00003.setJanHdjg(bf00003.getHdjg());
			bfv00003.setJanPgjg(bf00003.getPgjg());
			break;
		case 2:
			bfv00003.setFebSbjg(bf00003.getSbjg());
			bfv00003.setFebHdjg(bf00003.getHdjg());
			bfv00003.setFebPgjg(bf00003.getPgjg());				
			break;
		case 3:
			bfv00003.setMarSbjg(bf00003.getSbjg());
			bfv00003.setMarHdjg(bf00003.getHdjg());
			bfv00003.setMarPgjg(bf00003.getPgjg());
			break;
		case 4:
			bfv00003.setArpSbjg(bf00003.getSbjg());
			bfv00003.setArpHdjg(bf00003.getHdjg());
			bfv00003.setArpPgjg(bf00003.getPgjg());
			break;
		case 5:
			bfv00003.setMaySbjg(bf00003.getSbjg());
			bfv00003.setMayHdjg(bf00003.getHdjg());
			bfv00003.setMayPgjg(bf00003.getPgjg());
			break;
		case 6:
			bfv00003.setJunSbjg(bf00003.getSbjg());
			bfv00003.setJunHdjg(bf00003.getHdjg());
			bfv00003.setJunPgjg(bf00003.getPgjg());
			break;
		case 7:
			bfv00003.setJulSbjg(bf00003.getSbjg());
			bfv00003.setJulHdjg(bf00003.getHdjg());
			bfv00003.setJulPgjg(bf00003.getPgjg());
			break;
		case 8:
			bfv00003.setAugSbjg(bf00003.getSbjg());
			bfv00003.setAugHdjg(bf00003.getHdjg());
			bfv00003.setAugPgjg(bf00003.getPgjg());
			break;
		case 9:
			bfv00003.setSepSbjg(bf00003.getSbjg());
			bfv00003.setSepHdjg(bf00003.getHdjg());
			bfv00003.setSepPgjg(bf00003.getPgjg());
			break;
		case 10:
			bfv00003.setOctSbjg(bf00003.getSbjg());
			bfv00003.setOctHdjg(bf00003.getHdjg());
			bfv00003.setOctPgjg(bf00003.getPgjg());
			break;
		case 11:
			bfv00003.setNovSbjg(bf00003.getSbjg());
			bfv00003.setNovHdjg(bf00003.getHdjg());
			bfv00003.setNovPgjg(bf00003.getPgjg());
			break;
		case 12:
			bfv00003.setDecSbjg(bf00003.getSbjg());
			bfv00003.setDecHdjg(bf00003.getHdjg());
			bfv00003.setDecPgjg(bf00003.getPgjg());
			break;
		default:
			break;
		}
	}

	/**
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
	}
	
	/****************************** get and set *********************************/
	
	@Override
	public void setSession(Map<String, Object> session) {
		sessionCtrl.appSession = session;
		
	}
	
	/**
	 * @param bb00003Service the bb00003Service to set
	 */
	public void setBb00003Service(IBB00003Service bb00003Service) {
		this.bb00003Service = bb00003Service;
	}

	/**
	 * @return the bb00003Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IBB00003Service getBb00003Service() {
		return bb00003Service;
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

	/**
	 * @return the txtSWIDFind
	 */
	public String getTxtSWIDFind() {
		return txtSWIDFind;
	}

	/**
	 * @param txtSWIDFind the txtSWIDFind to set
	 */
	public void setTxtSWIDFind(String txtSWIDFind) {
		this.txtSWIDFind = txtSWIDFind;
	}

	/**
	 * @return the txtNSRMCFind
	 */
	public String getTxtNSRMCFind() {
		return txtNSRMCFind;
	}

	/**
	 * @param txtNSRMCFind the txtNSRMCFind to set
	 */
	public void setTxtNSRMCFind(String txtNSRMCFind) {
		this.txtNSRMCFind = txtNSRMCFind;
	}

	/**
	 * @return the txtXQFind
	 */
	public String getTxtXQFind() {
		return txtXQFind;
	}

	/**
	 * @param txtXQFind the txtXQFind to set
	 */
	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}

	/**
	 * @return the txtZCDZLFind
	 */
	public String getTxtZCDZLFind() {
		return txtZCDZLFind;
	}

	/**
	 * @param txtZCDZLFind the txtZCDZLFind to set
	 */
	public void setTxtZCDZLFind(String txtZCDZLFind) {
		this.txtZCDZLFind = txtZCDZLFind;
	}

	/**
	 * @return the txtJZMJMINFind
	 */
	public String getTxtJZMJMINFind() {
		return txtJZMJMINFind;
	}

	/**
	 * @param txtJZMJMINFind the txtJZMJMINFind to set
	 */
	public void setTxtJZMJMINFind(String txtJZMJMINFind) {
		this.txtJZMJMINFind = txtJZMJMINFind;
	}

	/**
	 * @return the txtJZMJMAXFind
	 */
	public String getTxtJZMJMAXFind() {
		return txtJZMJMAXFind;
	}

	/**
	 * @param txtJZMJMAXFind the txtJZMJMAXFind to set
	 */
	public void setTxtJZMJMAXFind(String txtJZMJMAXFind) {
		this.txtJZMJMAXFind = txtJZMJMAXFind;
	}

	/**
	 * @return the txtJYJGMINFind
	 */
	public String getTxtJYJGMINFind() {
		return txtJYJGMINFind;
	}

	/**
	 * @param txtJYJGMINFind the txtJYJGMINFind to set
	 */
	public void setTxtJYJGMINFind(String txtJYJGMINFind) {
		this.txtJYJGMINFind = txtJYJGMINFind;
	}

	/**
	 * @return the txtJYJGMAXFind
	 */
	public String getTxtJYJGMAXFind() {
		return txtJYJGMAXFind;
	}

	/**
	 * @param txtJYJGMAXFind the txtJYJGMAXFind to set
	 */
	public void setTxtJYJGMAXFind(String txtJYJGMAXFind) {
		this.txtJYJGMAXFind = txtJYJGMAXFind;
	}

	/**
	 * @return the txtJYSJFind
	 */
	public String getTxtJYSJFind() {
		return txtJYSJFind;
	}

	/**
	 * @param txtJYSJFind the txtJYSJFind to set
	 */
	public void setTxtJYSJFind(String txtJYSJFind) {
		this.txtJYSJFind = txtJYSJFind;
	}

	/**
	 * @return the txtSZLCFind
	 */
	public String getTxtSZLCFind() {
		return txtSZLCFind;
	}

	/**
	 * @param txtSZLCFind the txtSZLCFind to set
	 */
	public void setTxtSZLCFind(String txtSZLCFind) {
		this.txtSZLCFind = txtSZLCFind;
	}

	/**
	 * @return the txtZCDZBMFind
	 */
	public String getTxtZCDZBMFind() {
		return txtZCDZBMFind;
	}

	/**
	 * @param txtZCDZBMFind the txtZCDZBMFind to set
	 */
	public void setTxtZCDZBMFind(String txtZCDZBMFind) {
		this.txtZCDZBMFind = txtZCDZBMFind;
	}

	/**
	 * @return the txtLXDHFind
	 */
	public String getTxtLXDHFind() {
		return txtLXDHFind;
	}

	/**
	 * @param txtLXDHFind the txtLXDHFind to set
	 */
	public void setTxtLXDHFind(String txtLXDHFind) {
		this.txtLXDHFind = txtLXDHFind;
	}

	/**
	 * @return the txtFCZHFind
	 */
	public String getTxtFCZHFind() {
		return txtFCZHFind;
	}

	/**
	 * @param txtFCZHFind the txtFCZHFind to set
	 */
	public void setTxtFCZHFind(String txtFCZHFind) {
		this.txtFCZHFind = txtFCZHFind;
	}

	/**
	 * @return the txtDJRQFind
	 */
	public String getTxtDJRQFind() {
		return txtDJRQFind;
	}

	/**
	 * @param txtDJRQFind the txtDJRQFind to set
	 */
	public void setTxtDJRQFind(String txtDJRQFind) {
		this.txtDJRQFind = txtDJRQFind;
	}

	/**
	 * @return the txtJZJGFind
	 */
	public String getTxtJZJGFind() {
		return txtJZJGFind;
	}

	/**
	 * @param txtJZJGFind the txtJZJGFind to set
	 */
	public void setTxtJZJGFind(String txtJZJGFind) {
		this.txtJZJGFind = txtJZJGFind;
	}

	/**
	 * @return the txtJYLXFind
	 */
	public String getTxtJYLXFind() {
		return txtJYLXFind;
	}

	/**
	 * @param txtJYLXFind the txtJYLXFind to set
	 */
	public void setTxtJYLXFind(String txtJYLXFind) {
		this.txtJYLXFind = txtJYLXFind;
	}

	/**
	 * @return the txtFWLXFind
	 */
	public String getTxtFWLXFind() {
		return txtFWLXFind;
	}

	/**
	 * @param txtFWLXFind the txtFWLXFind to set
	 */
	public void setTxtFWLXFind(String txtFWLXFind) {
		this.txtFWLXFind = txtFWLXFind;
	}

	/**
	 * @return the txtZJLXFind
	 */
	public String getTxtZJLXFind() {
		return txtZJLXFind;
	}

	/**
	 * @param txtZJLXFind the txtZJLXFind to set
	 */
	public void setTxtZJLXFind(String txtZJLXFind) {
		this.txtZJLXFind = txtZJLXFind;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<BF00003> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<BF00003> rows) {
		this.rows = rows;
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
	 * @return the pSSD
	 */
	public String getPSSD() {
		return PSSD;
	}

	/**
	 * @param pSSD the pSSD to set
	 */
	public void setPSSD(String pSSD) {
		PSSD = pSSD;
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
