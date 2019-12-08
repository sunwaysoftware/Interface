package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.chart.ChartData;
import com.sunway.chart.ChartSeries;
import com.sunway.service.IBB00003Service;
import com.sunway.util.Common;

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
	private ArrayList<BF00003> bbList;
	private ArrayList<BF00003> tabList;
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
	private ArrayList<ChartSeries> chartData = new ArrayList<ChartSeries>();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		ReadInfo();
		txtPSSDFind=Common.getCurrentDatea();
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
			PSSD = sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD);
			bean.setCd00001Szqy(ddlSZQYFind);
			if(Common.isNullOrEmpty(txtSSGX)){
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setCd00001Ssgx(txtSSGX);
			}
			bean.setCd00002Pssd(txtPSSDFind);
			bean.setCd00002Czr(sessionCtrl.getUserId());
			bean.setCd00301Swid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			bean.setCd00001Zjlx(txtZJLXFind);
			bean.setNsrmc(Common.getSearchLike(txtNSRMCFind));
//			bean.setLxdh(Common.convertEncoding(txtLXDHFind));
			bean.setZcdzl(Common.getSearchLike(txtZCDZLFind));
			bean.setZcdzbm(Common.convertEncoding(txtZCDZBMFind));
			bean.setCd00352Xqdm(Common.trim(txtXQFind));
			bean.setFczh(txtFCZHFind);
			bean.setCd00001Jzjg(txtJZJGFind);
			bean.setSzlc(Common.convertToShort(txtSZLCFind));
			bean.setCd00001Jylx(txtJYLXFind);
			bean.setJzmj_min(Common.convertToDouble(txtJZMJMINFind));
			bean.setJzmj_max(Common.convertToDouble(txtJZMJMAXFind));
			bean.setCd00001Fwlx(txtFWLXFind);
			bean.setJyjg_min(Common.convertToDouble(txtJYJGMINFind));
			bean.setJyjg_max(Common.convertToDouble(txtJYJGMAXFind));
//			bean.setJysj(Common.convertStringToDate(txtJYSJFind));
			bean.setDjrq(Common.convertStringToDate(txtDJRQFind));
			if(!"".equals(txtPSSDFind) && null != txtPSSDFind){
				bbList = bb00003Service.LoadAll(bean);
			}
			
			if(bbList.size()>0) {
				ArrayList<ChartData> dataSB = new ArrayList<ChartData>();
				ArrayList<ChartData> dataPG = new ArrayList<ChartData>();
				ArrayList<ChartData> dataHD = new ArrayList<ChartData>();
		        ChartSeries seriasSB = new ChartSeries("申报", dataSB); 
		        ChartSeries seriasPG = new ChartSeries("评估", dataPG);
		        ChartSeries seriasHD = new ChartSeries("核定", dataHD);
				for (BF00003 b : bbList) {
					seriasSB.getData().add(new ChartData(b.getCd00002Pssd(), b.getSbjg()));
					seriasPG.getData().add(new ChartData(b.getCd00002Pssd(), b.getPgjg()));
					seriasHD.getData().add(new ChartData(b.getCd00002Pssd(), b.getHdjg()));
				}
				chartData.add(seriasSB);	
				chartData.add(seriasPG);
				chartData.add(seriasHD);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		} finally {
			ReadInfo();
		}
		return SUCCESS;
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
	 * @return the bbList
	 */
	public ArrayList<BF00003> getBbList() {
		return bbList;
	}

	/**
	 * @param bbList the bbList to set
	 */
	public void setBbList(ArrayList<BF00003> bbList) {
		this.bbList = bbList;
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
	 * @return the tabList
	 */
	public ArrayList<BF00003> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<BF00003> tabList) {
		this.tabList = tabList;
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

	/**
	 * @return the chartData
	 */
	public ArrayList<ChartSeries> getChartData() {
		return chartData;
	}

	/**
	 * @param chartData the chartData to set
	 */
	public void setChartData(ArrayList<ChartSeries> chartData) {
		this.chartData = chartData;
	}

}
