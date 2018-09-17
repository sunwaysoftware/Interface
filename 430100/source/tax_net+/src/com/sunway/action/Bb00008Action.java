package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IBB00008Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.BF00008;

/**
 * 交易纳税评估分区域统计表
 * @author Light
 *
 */
public class Bb00008Action extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -354941831749020561L;
	
	private IBB00008Service bb00008Service;
	private SessionCtrl sessionCtrl;
	
	//数据查询
	private String txtSSGX;
	private String txtPSSDMIN;
	private String txtPSSDMAX;
	private ArrayList<BF00008> rows;
	//数据导出
	private InputStream excelStream;

	@Override
	public String execute() throws Exception {
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** start **********");
		}
		try{
			sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			txtSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
			setPreviousMonth();			//为查询条件设置默认上个月
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("execute() ********** end **********");
			}
			this.addActionError(e.getMessage().replace("/", "\\").replace("\n", "<br />"));
			return INPUT;
		}finally{
			//
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 为查询条件设置默认上个月
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	protected void setPreviousMonth()throws Exception{
		try{
			Date currDate = new Date();
			int year = currDate.getYear() + 1900;		//当前年
			int month = currDate.getMonth();			//上个月
			if(month == 0){								//若上个月为一月份
				year--;									//前一个月为去年十二月
				month = 12;
			}
			txtPSSDMIN = txtPSSDMAX = String.valueOf(year) + String.valueOf((month - 10 >= 0?month:"0" + month));
		}catch(Exception e){
			throw e;
		}finally{
			//
		}
	}
	
	/**
	 * 数据查询
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** start **********");
		}
		try{
			sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			BF00008 bean = new BF00008();
			
			if(null != txtSSGX && !"".equals(txtSSGX)){
				bean.setCd00001Ssgx(txtSSGX);
			}else{
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
			bean.setPssdMin(CheckUtil.chkTrim(txtPSSDMIN));
			bean.setPssdMax(CheckUtil.chkTrim(txtPSSDMAX));
			
			rows = bb00008Service.LoadAll(bean);
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("query() ********** end **********");
			}
			return ERROR;
		}finally{
			//
		}
		
		if(LOG.isDebugEnabled()){
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 数据导出
	 * @return
	 * @throws Exception
	 */
	public String exportData()throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("exportData() ********** start **********");
		}
		try{
			sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			BF00008 bean = new BF00008();
			
			if(null != txtSSGX && !"".equals(txtSSGX)){
				bean.setCd00001Ssgx(txtSSGX);
			}else{
				bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}
			bean.setPssdMin(CheckUtil.chkTrim(txtPSSDMIN));
			bean.setPssdMax(CheckUtil.chkTrim(txtPSSDMAX));
			
			ByteArrayOutputStream out = (ByteArrayOutputStream)bb00008Service.ExportData(bean, "jynspgfqytjb.xls");
			excelStream = new ByteArrayInputStream(out.toByteArray());
		}catch(Exception e){
			LOG.error(e.getMessage());
			if(LOG.isDebugEnabled()){
				LOG.debug("exportData() ********** end **********");
			}
			this.addActionError(e.getMessage().replace("\\", "/").replace("\n", "<br />"));
			return INPUT;
		}finally{
			//
		}
		if(LOG.isDebugEnabled()){
			LOG.debug("exportData() ********** end **********");
		}
		return SUCCESS;
	}
	
	/***********************   set  &&  get   ************************/
	@JSON(deserialize=false, serialize=false)
	public IBB00008Service getBb00008Service() {
		return bb00008Service;
	}

	public void setBb00008Service(IBB00008Service bb00008Service) {
		this.bb00008Service = bb00008Service;
	}

	public String getTxtSSGX() {
		return txtSSGX;
	}

	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}

	public String getTxtPSSDMIN() {
		return txtPSSDMIN;
	}

	public void setTxtPSSDMIN(String txtPSSDMIN) {
		this.txtPSSDMIN = txtPSSDMIN;
	}

	public String getTxtPSSDMAX() {
		return txtPSSDMAX;
	}

	public void setTxtPSSDMAX(String txtPSSDMAX) {
		this.txtPSSDMAX = txtPSSDMAX;
	}

	public ArrayList<BF00008> getRows() {
		return rows;
	}

	public void setRows(ArrayList<BF00008> rows) {
		this.rows = rows;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}
}
