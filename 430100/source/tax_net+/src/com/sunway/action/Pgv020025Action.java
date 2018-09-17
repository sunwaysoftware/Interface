package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;







import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02002Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02002;

/**
 * 住宅国土信息查询
 * @category 数据查询
 * @author Lee
 * @version 1.0
 */

public class Pgv020025Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -6242292450427703795L;
	// Service
	private IPgt02002Service t02002Service;
	// View
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv02002> rows;
	private Pgv02002 v02002Bean;
	private InputStream excelStream;
	// 检索条件
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String txtFCIDFind;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFDCDATFind;
	private String txtXQFind;
	private String txtFWTDZLFind;
	private String ddlSZQYFind;
	private Integer ddlSCZTFind;
	private String txtZCDZLFind;
	private String txtSZQYFind;
	private String txtJZMJMINFind;
	private String txtJZMJMAXFind;
	private String txtJYJGMINFind;
	private String txtJYJGMAXFind;
	private String txtJYSJMINFind;
	private String txtJYSJMAXFind;
	private String txtSZLCFind;
	private String txtZCDZBMFind;
	private String txtLHFind;
	private String txtFCZHFind;
	private String txtDJRQFind;
	private String txtJZJGFind;
	private String txtJYLXFind;
	private String txtFWLXFind;
	private String txtSSGX;
	private String txtCZRFind;
	private String txtUPDDATES;
	private String txtUPDDATEE;
	private String txtUPDDATRD;
	private String txtUPDDATEERD;
	private String ddlIS20Find;
	private String txtFCSLHFind;
	private String sqlData;
	private String order;
	private String sort;
	 
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		try {
			ReadInfo();
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

	
	public String execute_B() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		try {
			ReadInfo();
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
	 * 查询状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv02002 v02002 = new Pgv02002();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v02002.setFcid(CheckUtil.chkTrim(txtFCIDFind));
			v02002.setZjhm(FormatUtil.toSearchLike(txtSWIDFind));
			v02002.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v02002.setZcdzl(FormatUtil.toSearchLike(txtZCDZLFind));
			v02002.setCd00001Szqy(ddlSZQYFind);
			v02002.setXqnm(FormatUtil.toSearchLike(txtXQFind));
			
			v02002.setJzmj_min(ConvertUtil.toDouble(txtJZMJMINFind));
			v02002.setJzmj_max(ConvertUtil.toDouble(txtJZMJMAXFind));
			v02002.setJyjg_min(ConvertUtil.toDouble(txtJYJGMINFind));
			v02002.setJyjg_max(ConvertUtil.toDouble(txtJYJGMAXFind));
			v02002.setJysj_min(ConvertUtil.toUtilDate(txtJYSJMINFind));
			v02002.setJysj_max(ConvertUtil.toUtilDate(txtJYSJMAXFind));
			v02002.setCd00001Jzjg(txtJZJGFind);
			v02002.setCd00001Jylx(txtJYLXFind);
			v02002.setCd00001Fwlx(txtFWLXFind);
			v02002.setSyzt(ddlSCZTFind);
			v02002.setPageIndex(pageIndex);
			v02002.setPageSize(getPageSize());
//			v02002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(CheckUtil.chkEmpty(txtSSGX))
				v02002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			else
				v02002.setCd00001Ssgx(txtSSGX);
			v02002.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v02002.setZcdzbm(txtZCDZBMFind);
			v02002.setLh(txtLHFind);
			v02002.setFczh(txtFCZHFind);
			v02002.setSzlc(txtSZLCFind);
			v02002.setDjrq(ConvertUtil.toUtilDate(txtDJRQFind));
			v02002.setCd00002Czr(txtCZRFind);
			v02002.setUpddateS(ConvertUtil.toUtilDate(txtUPDDATES));
			v02002.setUpddateE(ConvertUtil.toUtilDate(txtUPDDATEE));
			v02002.setFcslh(txtFCSLHFind);
			// 执行查询
			v02002Bean = t02002Service.LoadPgv020025(v02002);
			rows = v02002Bean.getV02002List();
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				total = 0;
				pageIndex = 1;
			}
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	public String query_B() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv02002 v02002 = new Pgv02002();
		try {
			// 准备查询条件
			v02002.setFcid(CheckUtil.chkTrim(txtFCIDFind));
			v02002.setZjhm(FormatUtil.toSearchLike(txtSWIDFind));
			v02002.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v02002.setZcdzl(FormatUtil.toSearchLike(txtZCDZLFind));
			v02002.setCd00001Szqy(ddlSZQYFind);
			v02002.setSyzt(CheckUtil.chkNull(ddlSCZTFind));
			v02002.setXqnm(FormatUtil.toSearchLike(txtXQFind));
			v02002.setCd00001Fwlx(txtFWLXFind);
			v02002.setCd00001Jzjg(txtJZJGFind);
			v02002.setCd00001Jylx(txtJYLXFind);
			v02002.setJzmj_min(ConvertUtil.toDouble(txtJZMJMINFind));
			v02002.setJzmj_max(ConvertUtil.toDouble(txtJZMJMAXFind));
			v02002.setJyjg_min(ConvertUtil.toDouble(txtJYJGMINFind));
			v02002.setJyjg_max(ConvertUtil.toDouble(txtJYJGMAXFind));
			v02002.setJysj_min(ConvertUtil.toUtilDate(txtJYSJMINFind));
			v02002.setJysj_max(ConvertUtil.toUtilDate(txtJYSJMAXFind));
			v02002.setDjrq(ConvertUtil.toUtilDate(txtDJRQFind));
			v02002.setSzlc(txtSZLCFind);
			v02002.setFczh(txtFCZHFind);
			if(CheckUtil.chkEmpty(txtSSGX))
				v02002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			else
				v02002.setCd00001Ssgx(txtSSGX);
			v02002.setCd00002Czr(txtCZRFind);
			v02002.setFcslh(txtFCSLHFind);
			v02002.setUpddateS(ConvertUtil.toUtilDate(txtUPDDATES));
			v02002.setUpddateE(ConvertUtil.toUtilDate(txtUPDDATEE));
			v02002.setUpddateSRD(ConvertUtil.toUtilDate(txtUPDDATRD));
			v02002.setUpddateERD(ConvertUtil.toUtilDate(txtUPDDATEERD));			
			v02002.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v02002.setZcdzbm(txtZCDZBMFind);
			v02002.setLh(txtLHFind);
			v02002.setPageIndex(pageIndex);
			v02002.setPageSize(pageSize);
			// 执行查询
			v02002Bean = t02002Service.LoadPgv020025_B(v02002);
			rows = v02002Bean.getV02002List();
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				total = 0;
				pageIndex = 1;
			}
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	public String query_B1() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv02002 b = new Pgv02002();
		try {
			b.setPageIndex(pageIndex);
			b.setPageSize(pageSize);
			b.setSqlData(sqlData);
			b.setSort(sort);;
			b.setOrder(order); 
			b.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			rows  = t02002Service.LoadPgv020025_B1(b);			
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				total = 0;
				pageIndex = 1;
			}
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 *查询信息导出
	 * @return
	 * @throws Exception
	 */
	public String export() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("export() ********** start **********");
		}
		
		Pgv02002 v02002 = new Pgv02002();
		try{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v02002.setPageIndex(1);
			v02002.setPageSize(-1);
			v02002.setFcid(CheckUtil.chkTrim(txtFCIDFind));
			v02002.setZjhm(FormatUtil.toSearchLike(txtSWIDFind));
			v02002.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v02002.setZcdzl(FormatUtil.toSearchLike(txtZCDZLFind));
			v02002.setCd00001Szqy(ddlSZQYFind);
			v02002.setXqnm(FormatUtil.toSearchLike(txtXQFind));
			v02002.setJzmj_min(ConvertUtil.toDouble(txtJZMJMINFind));
			v02002.setJzmj_max(ConvertUtil.toDouble(txtJZMJMAXFind));
			v02002.setJyjg_min(ConvertUtil.toDouble(txtJYJGMINFind));
			v02002.setJyjg_max(ConvertUtil.toDouble(txtJYJGMAXFind));
			v02002.setJysj_min(ConvertUtil.toUtilDate(txtJYSJMINFind));
			v02002.setJysj_max(ConvertUtil.toUtilDate(txtJYSJMAXFind));
			v02002.setCd00001Jzjg(txtJZJGFind);
			v02002.setCd00001Jylx(txtJYLXFind);
			v02002.setCd00001Fwlx(txtFWLXFind);
			v02002.setSyzt(ddlSCZTFind);
			if(CheckUtil.chkEmpty(txtSSGX))
				v02002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			else
				v02002.setCd00001Ssgx(txtSSGX);
			v02002.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v02002.setZcdzbm(txtZCDZBMFind);
			v02002.setFczh(txtFCZHFind);
			v02002.setSzlc(txtSZLCFind);
			v02002.setDjrq(ConvertUtil.toUtilDate(txtDJRQFind));
			v02002.setCd00002Czr(txtCZRFind);
			v02002.setUpddateS(ConvertUtil.toUtilDate(txtUPDDATES));
			v02002.setUpddateE(ConvertUtil.toUtilDate(txtUPDDATEE));
			v02002.setFcslh(txtFCSLHFind);
			ByteArrayOutputStream out = (ByteArrayOutputStream) t02002Service.ExportCXSjcx(v02002);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		
		return SUCCESS;
		
		
	}
	public String export_B() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("export() ********** start **********");
		}
		
		Pgv02002 v02002 = new Pgv02002();
		try{
			// 准备查询条件
			v02002.setFcid(CheckUtil.chkTrim(txtFCIDFind));
			v02002.setZjhm(FormatUtil.toSearchLike(txtSWIDFind));
			v02002.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v02002.setZcdzl(FormatUtil.toSearchLike(txtZCDZLFind));
			v02002.setCd00001Szqy(ddlSZQYFind);
			v02002.setSyzt(-1);
			v02002.setXqnm(FormatUtil.toSearchLike(txtXQFind));
			v02002.setCd00001Fwlx(txtFWLXFind);
			v02002.setCd00001Jzjg(txtJZJGFind);
			v02002.setCd00001Jylx(txtJYLXFind);
			v02002.setJzmj_min(ConvertUtil.toDouble(txtJZMJMINFind));
			v02002.setJzmj_max(ConvertUtil.toDouble(txtJZMJMAXFind));
			v02002.setJyjg_min(ConvertUtil.toDouble(txtJYJGMINFind));
			v02002.setJyjg_max(ConvertUtil.toDouble(txtJYJGMAXFind));
			v02002.setJysj_min(ConvertUtil.toUtilDate(txtJYSJMINFind));
			v02002.setJysj_max(ConvertUtil.toUtilDate(txtJYSJMAXFind));
			v02002.setDjrq(ConvertUtil.toUtilDate(txtDJRQFind));
			v02002.setSzlc(txtSZLCFind);
			v02002.setFczh(txtFCZHFind);
			if(CheckUtil.chkEmpty(txtSSGX))
				v02002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			else
				v02002.setCd00001Ssgx(txtSSGX);
			v02002.setCd00002Czr(txtCZRFind);
			v02002.setFcslh(txtFCSLHFind);
			v02002.setUpddateS(ConvertUtil.toUtilDate(txtUPDDATES));
			v02002.setUpddateE(ConvertUtil.toUtilDate(txtUPDDATEE));
			v02002.setUpddateSRD(ConvertUtil.toUtilDate(txtUPDDATRD));
			v02002.setUpddateERD(ConvertUtil.toUtilDate(txtUPDDATEERD));			
			v02002.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v02002.setZcdzbm(txtZCDZBMFind);
			v02002.setLh(txtLHFind);
			v02002.setPageIndex(1);
			v02002.setPageSize(-1);
			ByteArrayOutputStream out = (ByteArrayOutputStream) t02002Service.ExportCXSjcx_B(v02002);
			setExcelStream(new ByteArrayInputStream(out.toByteArray()));
		}catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		
		return SUCCESS;
		
		
	}
	/**
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	
	private void ReadInfo() throws Exception {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
		txtSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
	}
	

	/******************************** set and get **************************************/

	/**
	 * @return the t02002Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt02002Service getT02002Service() {
		return t02002Service;
	}
	/**
	 * @param t02002Service the t02002Service to set
	 */
	public void setT02002Service(IPgt02002Service t02002Service) {
		this.t02002Service = t02002Service;
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
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
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
	 * @return the rows
	 */
	public ArrayList<Pgv02002> getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv02002> rows) {
		this.rows = rows;
	}
	/**
	 * @return the v02002Bean
	 */
	public Pgv02002 getV02002Bean() {
		return v02002Bean;
	}
	/**
	 * @param v02002Bean the v02002Bean to set
	 */
	public void setV02002Bean(Pgv02002 v02002Bean) {
		this.v02002Bean = v02002Bean;
	}
	/**
	 * @return the txtFCIDFind
	 */
	public String getTxtFCIDFind() {
		return txtFCIDFind;
	}
	/**
	 * @param txtFCIDFind the txtFCIDFind to set
	 */
	public void setTxtFCIDFind(String txtFCIDFind) {
		this.txtFCIDFind = txtFCIDFind;
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
	 * @return the txtFDCDATFind
	 */
	public String getTxtFDCDATFind() {
		return txtFDCDATFind;
	}
	/**
	 * @param txtFDCDATFind the txtFDCDATFind to set
	 */
	public void setTxtFDCDATFind(String txtFDCDATFind) {
		this.txtFDCDATFind = txtFDCDATFind;
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
	 * @return the txtFWTDZLFind
	 */
	public String getTxtFWTDZLFind() {
		return txtFWTDZLFind;
	}
	/**
	 * @param txtFWTDZLFind the txtFWTDZLFind to set
	 */
	public void setTxtFWTDZLFind(String txtFWTDZLFind) {
		this.txtFWTDZLFind = txtFWTDZLFind;
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
	 * @return the ddlSCZTFind
	 */
	public Integer getDdlSCZTFind() {
		return ddlSCZTFind;
	}
	/**
	 * @param ddlSCZTFind the ddlSCZTFind to set
	 */
	public void setDdlSCZTFind(Integer ddlSCZTFind) {
		this.ddlSCZTFind = ddlSCZTFind;
	}

	/**
	 * @return the txtSZQYFind
	 */
	public String getTxtSZQYFind() {
		return txtSZQYFind;
	}

	/**
	 * @param txtSZQYFind the txtSZQYFind to set
	 */
	public void setTxtSZQYFind(String txtSZQYFind) {
		this.txtSZQYFind = txtSZQYFind;
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
	 * @return the txtJYSJMINFind
	 */
	public String getTxtJYSJMINFind() {
		return txtJYSJMINFind;
	}

	/**
	 * @param txtJYSJMINFind the txtJYSJMINFind to set
	 */
	public void setTxtJYSJMINFind(String txtJYSJMINFind) {
		this.txtJYSJMINFind = txtJYSJMINFind;
	}

	/**
	 * @return the txtJYSJMAXFind
	 */
	public String getTxtJYSJMAXFind() {
		return txtJYSJMAXFind;
	}

	/**
	 * @param txtJYSJMAXFind the txtJYSJMAXFind to set
	 */
	public void setTxtJYSJMAXFind(String txtJYSJMAXFind) {
		this.txtJYSJMAXFind = txtJYSJMAXFind;
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
	 * @return the txtLHFind
	 */
	public String getTxtLHFind() {
		return txtLHFind;
	}

	/**
	 * @param txtLHFind the txtLHFind to set
	 */
	public void setTxtLHFind(String txtLHFind) {
		this.txtLHFind = txtLHFind;
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

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public InputStream getExcelStream() {
		return excelStream;
	}

	/**
	 * @return the txtSSGX
	 */
	public String getTxtSSGX() {
		return txtSSGX;
	}

	/**
	 * @param txtSSGX the txtSSGX to set
	 */
	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	public String getTxtCZRFind() {
		return txtCZRFind;
	}

	public void setTxtCZRFind(String txtCZRFind) {
		this.txtCZRFind = txtCZRFind;
	}


	public String getTxtUPDDATES() {
		return txtUPDDATES;
	}

	public void setTxtUPDDATES(String txtUPDDATES) {
		this.txtUPDDATES = txtUPDDATES;
	}

	public String getTxtUPDDATEE() {
		return txtUPDDATEE;
	}

	public void setTxtUPDDATEE(String txtUPDDATEE) {
		this.txtUPDDATEE = txtUPDDATEE;
	}

	public String getTxtFCSLHFind() {
		return txtFCSLHFind;
	}

	public void setTxtFCSLHFind(String txtFCSLHFind) {
		this.txtFCSLHFind = txtFCSLHFind;
	}


	public String getTxtUPDDATRD() {
		return txtUPDDATRD;
	}


	public void setTxtUPDDATRD(String txtUPDDATRD) {
		this.txtUPDDATRD = txtUPDDATRD;
	}


	public String getTxtUPDDATEERD() {
		return txtUPDDATEERD;
	}


	public void setTxtUPDDATEERD(String txtUPDDATEERD) {
		this.txtUPDDATEERD = txtUPDDATEERD;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}


	public String getDdlIS20Find() {
		return ddlIS20Find;
	}


	public void setDdlIS20Find(String ddlIS20Find) {
		this.ddlIS20Find = ddlIS20Find;
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

}
