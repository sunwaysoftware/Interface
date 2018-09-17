/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sunway.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ITj00002Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.TJ00002;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

/**
 *
 * @author Amani
 */
@SuppressWarnings("serial")
public class Tj00002Action extends ActionSupport implements SessionAware {

    private ITj00002Service tj00002Service;
    private SessionCtrl sessionCtrl = new SessionCtrl();
    private ArrayList<TJ00002> rows;
    private String txtRDSJMinFind;
    private String txtRDSJMaxFind;
    private String txtPSSDFind;
    private String txtSSGX;
    
    private String sqlData;
	private String order;
	private String sort;
	
	//数据导出
	private InputStream excelStream;
	private String fileName;

    @Override
    public String execute() throws Exception {
        txtRDSJMinFind = MakeUtil.monthFirstDay();
        txtRDSJMaxFind = MakeUtil.currentDate();
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        sessionCtrl.appSession = map;
    }

    /**
     * 查询
     *
     * @return
     * @throws Exception
     */
    public String query() throws Exception {
        TJ00002 bean = new TJ00002();
        try {
        	
        	if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setSsgx(txtSSGX);
			}
            bean.setCd00002Pssd(txtPSSDFind);
            rows = tj00002Service.Load(bean);
           
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return INPUT;
        } finally {

        }
        return SUCCESS;
    }
    
    /**
	 * 数据导出未认定
	 * @return
	 * @throws Exception
	 */
	public String exportData()throws Exception{
		TJ00002 bean = new TJ00002();
		try {			
			if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setSsgx(txtSSGX);
			}			
			bean.setCd00002Pssd(txtPSSDFind);
			bean.setExpFileName(Common.excelPath("exp_Tj00002.xls"));
			ByteArrayOutputStream out = (ByteArrayOutputStream)tj00002Service.ExportData(bean);
			excelStream = new ByteArrayInputStream(out.toByteArray());
			fileName = new String("分税种统计.xls".getBytes("GBK"),"ISO-8859-1");
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
     *
     * @return
     * @throws Exception
     */
    public String query02() throws Exception {
        TJ00002 bean = new TJ00002();
        try {
        	
        	if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setSsgx(txtSSGX);
			}
            bean.setCd00002Pssd(txtPSSDFind);
            rows = tj00002Service.Load02(bean);
           
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return INPUT;
        } finally {

        }
        return SUCCESS;
    }
    
    /**
	 * 数据导出未认定
	 * @return
	 * @throws Exception
	 */
	public String exportData02()throws Exception{
		TJ00002 bean = new TJ00002();
		try {			
			if(CheckUtil.chkEmpty(txtSSGX)){
				bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setSsgx(txtSSGX);
			}			
			bean.setCd00002Pssd(txtPSSDFind);
			bean.setExpFileName(Common.excelPath("exp_Tj00002.xls"));
			ByteArrayOutputStream out = (ByteArrayOutputStream)tj00002Service.ExportData02(bean);
			excelStream = new ByteArrayInputStream(out.toByteArray());
			fileName = new String("非住宅分税种统计.xls".getBytes("GBK"),"ISO-8859-1");
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
	
    @JSON(deserialize=false, serialize=false)
    public ITj00002Service getTj00002Service() {
        return tj00002Service;
    }

    public void setTj00002Service(ITj00002Service tj00002Service) {
        this.tj00002Service = tj00002Service;
    }

    public String getTxtRDSJMinFind() {
        return txtRDSJMinFind;
    }

    public void setTxtRDSJMinFind(String txtRDSJMinFind) {
        this.txtRDSJMinFind = txtRDSJMinFind;
    }

    public String getTxtRDSJMaxFind() {
        return txtRDSJMaxFind;
    }

    public void setTxtRDSJMaxFind(String txtRDSJMaxFind) {
        this.txtRDSJMaxFind = txtRDSJMaxFind;
    }
    

	public ArrayList<TJ00002> getRows() {
		return rows;
	}

	public void setRows(ArrayList<TJ00002> rows) {
		this.rows = rows;
	}

	public String getTxtPSSDFind() {
		return txtPSSDFind;
	}

	public void setTxtPSSDFind(String txtPSSDFind) {
		this.txtPSSDFind = txtPSSDFind;
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

	public String getTxtSSGX() {
		return txtSSGX;
	}

	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}

}
