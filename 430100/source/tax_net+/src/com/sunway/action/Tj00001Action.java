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
import com.sunway.service.ITj00001Service;
import com.sunway.util.Common;
import com.sunway.util.ConvertUtil;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.BFV00006;

/**
 * 
 * 统计：征收单位
 * @author Amani
 *
 */
public class Tj00001Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 5342944235439232837L;
	private ITj00001Service tj00001Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private ArrayList<BFV00006> rows;
	private String txtRdsjBgn;
	private String txtRdsjEnd;
	//数据导出
	private InputStream excelStream;
	private String fileName;
	
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionCtrl.appSession = session;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		txtRdsjBgn = MakeUtil.currentDate();
		txtRdsjEnd = txtRdsjBgn;
		return SUCCESS;
	}

	/**
	 * 查询统计
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		BFV00006 bean = new BFV00006();
		bean.setRdsjBgn(ConvertUtil.toUtilDate(txtRdsjBgn));
		bean.setRdsjEnd(ConvertUtil.toUtilDate(txtRdsjEnd));
		bean.setCd00002Czr(sessionCtrl.getUserId());
		bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		try {
			rows = tj00001Service.LoadAll(bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 查询统计
	 * @return
	 * @throws Exception
	 */
	public String query02() throws Exception {
		BFV00006 bean = new BFV00006();
		bean.setRdsjBgn(ConvertUtil.toUtilDate(txtRdsjBgn));
		bean.setRdsjEnd(ConvertUtil.toUtilDate(txtRdsjEnd));
		bean.setCd00002Czr(sessionCtrl.getUserId());
		bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		try {
			rows = tj00001Service.LoadAll02(bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}
	
	/**
	 * 导出数据
	 * @return
	 * @throws Exception
	 */
	public String ExportData() throws Exception {
		BFV00006 bean = new BFV00006();		
		
		try {			
			bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bean.setCd00002Czr(sessionCtrl.getUserId());
			bean.setExpFileName(Common.excelPath("exp_Tj00001.xls"));
			ByteArrayOutputStream out = (ByteArrayOutputStream)tj00001Service.ExportData(bean);
			excelStream = new ByteArrayInputStream(out.toByteArray());
			fileName = new String("住宅征收单位统计.xls".getBytes("GBK"),"ISO-8859-1");
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
	 * 导出数据
	 * @return
	 * @throws Exception
	 */
	public String ExportData02() throws Exception {
		BFV00006 bean = new BFV00006();			
		
		try {			
			bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bean.setCd00002Czr(sessionCtrl.getUserId());
			bean.setExpFileName(Common.excelPath("exp_Tj00001.xls"));
			ByteArrayOutputStream out = (ByteArrayOutputStream)tj00001Service.ExportData02(bean);
			excelStream = new ByteArrayInputStream(out.toByteArray());
			fileName = new String("非住宅征收单位统计.xls".getBytes("GBK"),"ISO-8859-1");
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
	
	//----------------------- set and get --------------------------------------
	
	/**
	 * @return the tj00001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public ITj00001Service getTj00001Service() {
		return tj00001Service;
	}

	/**
	 * @param tj00001Service the tj00001Service to set
	 */
	public void setTj00001Service(ITj00001Service tj00001Service) {
		this.tj00001Service = tj00001Service;
	}

	/**
	 * @return the txtRdsjBgn
	 */
	public String getTxtRdsjBgn() {
		return txtRdsjBgn;
	}

	/**
	 * @param txtRdsjBgn the txtRdsjBgn to set
	 */
	public void setTxtRdsjBgn(String txtRdsjBgn) {
		this.txtRdsjBgn = txtRdsjBgn;
	}

	/**
	 * @return the txtRdsjEnd
	 */
	public String getTxtRdsjEnd() {
		return txtRdsjEnd;
	}

	/**
	 * @param txtRdsjEnd the txtRdsjEnd to set
	 */
	public void setTxtRdsjEnd(String txtRdsjEnd) {
		this.txtRdsjEnd = txtRdsjEnd;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<BFV00006> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<BFV00006> rows) {
		this.rows = rows;
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
