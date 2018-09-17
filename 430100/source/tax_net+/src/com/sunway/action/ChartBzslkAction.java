package com.sunway.action;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.chart.ChartData;
import com.sunway.chart.ChartSeries;
import com.sunway.service.IChartBzslkService;
import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.ChartBzslk;
import com.sunway.vo.Pgv00052;

/**
 * 
 * 更新标准实例库图
 * @author Lee
 *
 */
public class ChartBzslkAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -5587089945036109900L;
	private IChartBzslkService chartBzslkService;
	private ArrayList<ChartBzslk> chartList;
	private ArrayList<ChartBzslk> rows;
	private ArrayList<Pgv00052> szqyList;
	private String imgFileName;
	private String ddlSZQYFind;
	private String txtSZQYUP;
	private String txtXQFind;	
	private String txtXQUP;	
	private String txtFWLXUP;	
	private String txtXQTIP;
	private String txtMONTHFind;
	private String txtFWLX;
	private String txtFWLXTIP;
	private String txtCZLUpd;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Double zzl;
	private String txtGPSJQZB;
	private ArrayList<ChartSeries> chartData = new ArrayList<ChartSeries>();
	private String txtNF;
	private String SysDate;
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			szqyList = sessionCtrl.ReadSzqyList();
			SysDate = MakeUtil.currentYear();
		}catch(Exception e){
			LOG.error(e.getMessage());
			
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
		
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			ChartBzslk bSlk = new ChartBzslk();
			ChartBzslk sSlk = new ChartBzslk();
			ChartBzslk gSlk = new ChartBzslk();
			ChartBzslk ySlk = new ChartBzslk();
			ChartBzslk zSlk = new ChartBzslk();
			
	        String serias1 = "标准实例库"; 
	        String serias2 = "成交案例";
	        String serias3 = "挂牌案例";
	        String serias4 = "一手房价格";
	        String serias5 = "中介价格";
	        
	        bSlk.setRowTitle(serias1);
	        sSlk.setRowTitle(serias2);
	        gSlk.setRowTitle(serias3);
	        ySlk.setRowTitle(serias4);
	        zSlk.setRowTitle(serias5);
	        //为List赋值
	        ChartBzslk chart = new ChartBzslk();
	        chart.setCd00352Xqdm(txtXQFind);
	        chart.setCd00001Szqy(ddlSZQYFind);
	        chart.setCd00001Fwlx(txtFWLX);
	        chart.setCd00002Pssd(CheckUtil.chkTrim(txtNF));
	        chart.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
	        chartList = chartBzslkService.LoadByUpdate(chart);

			for(Integer j=1; j<=12; j++){
				Double bJe = 0.0;
				Double sJe = 0.0;
				Double gJe = 0.0;
				Double yJe = 0.0;
				Double zJe = 0.0;
				String m = "";
				if(j<10)
					m = "0" + j.toString();
				else
					m = j.toString();
				//标准实例库
				for(int i=0; i<chartList.size(); i++){
					if("B".equals(chartList.get(i).getLx()) && m.equals(chartList.get(i).getJyMonth())){
						bJe = chartList.get(i).getJe();						
						break;
					}
				}	
				setMonthJe(j, bSlk, bJe);
				//成交案例
				for(int i=0; i<chartList.size(); i++){
					if("S".equals(chartList.get(i).getLx()) && m.equals(chartList.get(i).getJyMonth())){
						sJe = chartList.get(i).getJe();
						break;
					}
				}				
				setMonthJe(j, sSlk, sJe);
				//挂牌案例			
				for(int i=0; i<chartList.size(); i++){
					if("G".equals(chartList.get(i).getLx()) && m.equals(chartList.get(i).getJyMonth())){
						gJe = chartList.get(i).getJe();
						break;
					}
				}
				setMonthJe(j, gSlk, gJe);
				//一手房价格
				for(int i=0; i<chartList.size(); i++){
					if("Y".equals(chartList.get(i).getLx()) && m.equals(chartList.get(i).getJyMonth())){
						yJe = chartList.get(i).getJe();
						break;
					}
				}				
				setMonthJe(j, ySlk, yJe);
				//中介价格
				for(int i=0; i<chartList.size(); i++){
					if("Z".equals(chartList.get(i).getLx()) && m.equals(chartList.get(i).getJyMonth())){
						zJe = chartList.get(i).getJe();
						break;
					}
				}				
				setMonthJe(j, zSlk, zJe);
			}
			rows = new ArrayList<ChartBzslk>();
			rows.add(bSlk);
			rows.add(sSlk);
			rows.add(gSlk);
			rows.add(ySlk);
			rows.add(zSlk);
		}catch(Exception e){
			LOG.error(e.getMessage());
			
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
	 * 对标准实例库进行更新
	 * @return
	 */
	public String update(){
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		ChartBzslk chart = new ChartBzslk();
		
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			chart.setMonth(ConvertUtil.toUtilDate(txtMONTHFind));
			chart.setCzl(ConvertUtil.toDouble(txtCZLUpd));
			chart.setCd00002Czr(sessionCtrl.getUserId());
			chart.setCd00001Szqy(txtSZQYUP);
			chart.setCd00352Xqdm(txtXQUP);
			chart.setCd00001Fwlx(txtFWLXUP);
			if(chartBzslkService.GetUpdateSlk(chart))
				this.addActionMessage("标准实例数据更新成功！");
			else
				this.addActionError("标准实例数据更新失败！");
			szqyList = sessionCtrl.ReadSzqyList();
		}catch(Exception e){
			LOG.error(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * @return the chart
	 */
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String queryChart() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryChart() ********** start **********");
		}
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
	        
	        //为List赋值
	        ChartBzslk chart = new ChartBzslk();
	        chart.setCd00352Xqdm(txtXQFind);
	        chart.setCd00001Szqy(ddlSZQYFind);
	        chart.setCd00001Fwlx(txtFWLX);
	        chart.setCd00002Pssd(CheckUtil.chkTrim(txtNF));
	        chart.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
	        chartList = chartBzslkService.LoadByUpdate(chart);
				
			ArrayList<ChartData> dataSB = new ArrayList<ChartData>();
			ArrayList<ChartData> dataPG = new ArrayList<ChartData>();
			ArrayList<ChartData> dataHD = new ArrayList<ChartData>();
			ArrayList<ChartData> dataYS = new ArrayList<ChartData>();
			ArrayList<ChartData> dataZJ = new ArrayList<ChartData>();
	        ChartSeries seriasSB = new ChartSeries("标准实例库", dataSB); 
	        ChartSeries seriasPG = new ChartSeries("成交案例", dataPG);
	        ChartSeries seriasHD = new ChartSeries("挂牌案例", dataHD);
	        ChartSeries seriasYS = new ChartSeries("一手房价格", dataYS);
	        ChartSeries seriasZJ = new ChartSeries("中介价格", dataZJ);
	        for(Integer j=1; j<=12; j++){
	        	String m = "";		
	        	Double bJe = 0.0;
				Double sJe = 0.0;
				Double gJe = 0.0;
				Double yJe = 0.0;
				Double zJe = 0.0;
				if(j<10)
					m = "0" + j.toString();
				else
					m = j.toString();
				for (ChartBzslk b : chartList) {						
					if("B".equals(b.getLx()) && m.equals(b.getJyMonth()))
						bJe = b.getJe();						
					
					if("S".equals(b.getLx()) && m.equals(b.getJyMonth()))
						sJe = b.getJe();						
					
					if("G".equals(b.getLx()) && m.equals(b.getJyMonth()))
						gJe = b.getJe();
					
					if("Y".equals(b.getLx()) && m.equals(b.getJyMonth()))
						yJe = b.getJe();
					
					if("Z".equals(b.getLx()) && m.equals(b.getJyMonth()))
						zJe = b.getJe();
					
				}
				seriasSB.getData().add(new ChartData(m, BigDecimal.valueOf(bJe)));
				seriasPG.getData().add(new ChartData(m, BigDecimal.valueOf(sJe)));
				seriasHD.getData().add(new ChartData(m, BigDecimal.valueOf(gJe)));
				seriasYS.getData().add(new ChartData(m, BigDecimal.valueOf(yJe)));
				seriasZJ.getData().add(new ChartData(m, BigDecimal.valueOf(zJe)));
	        }
			chartData.add(seriasSB);	
			chartData.add(seriasPG);
			chartData.add(seriasHD);
			chartData.add(seriasYS);
			chartData.add(seriasZJ);
			
		}catch(Exception e){
			LOG.error(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}	

	/**
	 * 对数据进行表格格式整理
	 * @param month
	 * @param slk
	 * @param je
	 * @return
	 */
	private ChartBzslk setMonthJe(Integer month, ChartBzslk slk, Double je){
		switch(month){
		case 1:
			slk.setMonth1Je(je);
			break;
		case 2:
			slk.setMonth2Je(je);
			break;
		case 3:
			slk.setMonth3Je(je);
			break;
		case 4:
			slk.setMonth4Je(je);
			break;
		case 5:
			slk.setMonth5Je(je);
			break;
		case 6:
			slk.setMonth6Je(je);
			break;
		case 7:
			slk.setMonth7Je(je);
			break;
		case 8:
			slk.setMonth8Je(je);
			break;
		case 9:
			slk.setMonth9Je(je);
			break;
		case 10:
			slk.setMonth10Je(je);
			break;
		case 11:
			slk.setMonth11Je(je);
			break;
		case 12:
			slk.setMonth12Je(je);
			break;
		}
		return slk;
	}
	
	/**
	 * 读取【增长率】
	 * @return
	 * @throws Exception
	 */
	public String readZzl() throws Exception {
		ChartBzslk chart = new ChartBzslk();
		try{
			chart.setMonth(ConvertUtil.toUtilDate(txtMONTHFind));	
			chart.setGpqz(ConvertUtil.toInteger(txtGPSJQZB));
			chart.setCd00352Xqdm(txtXQFind);
	        chart.setCd00001Szqy(ddlSZQYFind);
			zzl = chartBzslkService.GetZzl(chart);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}
	
	/******************************** set and get *********************************/
	
	/**
	 * @param chartList the chartList to set
	 */
	public void setChartList(ArrayList<ChartBzslk> chartList) {
		this.chartList = chartList;
	}

	/**
	 * @return the chartList
	 */
	public ArrayList<ChartBzslk> getChartList() {
		return chartList;
	}

	/**
	 * @param imgFileName the imgFileName to set
	 */
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	/**
	 * @return the imgFileName
	 */
	public String getImgFileName() {
		return imgFileName;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<ChartBzslk> rows) {
		this.rows = rows;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<ChartBzslk> getRows() {
		return rows;
	}

	/**
	 * @return the txtCZLUpd
	 */
	public String getTxtCZLUpd() {
		return txtCZLUpd;
	}

	/**
	 * @param txtCZLUpd the txtCZLUpd to set
	 */
	public void setTxtCZLUpd(String txtCZLUpd) {
		this.txtCZLUpd = txtCZLUpd;
	}

	/**
	 * @return the chartBzslkService
	 */
	@JSON(deserialize=false, serialize=false)
	public IChartBzslkService getChartBzslkService() {
		return chartBzslkService;
	}

	/**
	 * @param chartBzslkService the chartBzslkService to set
	 */
	public void setChartBzslkService(IChartBzslkService chartBzslkService) {
		this.chartBzslkService = chartBzslkService;
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
	 * @return the txtMONTHFind
	 */
	public String getTxtMONTHFind() {
		return txtMONTHFind;
	}

	/**
	 * @param txtMONTHFind the txtMONTHFind to set
	 */
	public void setTxtMONTHFind(String txtMONTHFind) {
		this.txtMONTHFind = txtMONTHFind;
	}


	/**
	 * @param txtXQTIP the txtXQTIP to set
	 */
	public void setTxtXQTIP(String txtXQTIP) {
		this.txtXQTIP = txtXQTIP;
	}


	/**
	 * @return the txtXQTIP
	 */
	public String getTxtXQTIP() {
		return txtXQTIP;
	}


	/**
	 * @param zzl the zzl to set
	 */
	public void setZzl(Double zzl) {
		this.zzl = zzl;
	}


	/**
	 * @return the zzl
	 */
	public Double getZzl() {
		return zzl;
	}


	/**
	 * @return the txtGPSJQZB
	 */
	public String getTxtGPSJQZB() {
		return txtGPSJQZB;
	}


	/**
	 * @param txtGPSJQZB the txtGPSJQZB to set
	 */
	public void setTxtGPSJQZB(String txtGPSJQZB) {
		this.txtGPSJQZB = txtGPSJQZB;
	}


	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}


	public String getTxtFWLX() {
		return txtFWLX;
	}


	public void setTxtFWLXTIP(String txtFWLXTIP) {
		this.txtFWLXTIP = txtFWLXTIP;
	}


	public String getTxtFWLXTIP() {
		return txtFWLXTIP;
	}


	public String getTxtSZQYUP() {
		return txtSZQYUP;
	}


	public void setTxtSZQYUP(String txtSZQYUP) {
		this.txtSZQYUP = txtSZQYUP;
	}


	public ArrayList<ChartSeries> getChartData() {
		return chartData;
	}


	public void setChartData(ArrayList<ChartSeries> chartData) {
		this.chartData = chartData;
	}


	public String getTxtXQUP() {
		return txtXQUP;
	}


	public void setTxtXQUP(String txtXQUP) {
		this.txtXQUP = txtXQUP;
	}


	public String getTxtFWLXUP() {
		return txtFWLXUP;
	}


	public void setTxtFWLXUP(String txtFWLXUP) {
		this.txtFWLXUP = txtFWLXUP;
	}


	/**
	 * @return the txtNF
	 */
	public String getTxtNF() {
		return txtNF;
	}


	/**
	 * @param txtNF the txtNF to set
	 */
	public void setTxtNF(String txtNF) {
		this.txtNF = txtNF;
	}


	/**
	 * @return the sysDate
	 */
	public String getSysDate() {
		return SysDate;
	}


	/**
	 * @param sysDate the sysDate to set
	 */
	public void setSysDate(String sysDate) {
		SysDate = sysDate;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}	
}
