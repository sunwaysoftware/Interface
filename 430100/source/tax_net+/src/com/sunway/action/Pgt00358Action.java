/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;

import org.apache.struts2.json.annotations.JSON;


//import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00332Service;
import com.sunway.service.IPgt00333Service;
import com.sunway.service.IPgt00334Service;
import com.sunway.service.IPgt00335Service;
import com.sunway.service.IPgt00358Service;
import com.sunway.util.Common;
import com.sunway.util.ConvertUtil;
//import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00332;
import com.sunway.vo.Pgt00333;
import com.sunway.vo.Pgt00334;
import com.sunway.vo.Pgt00335;
import com.sunway.vo.Pgv00358;

/**
 * 
 * 市場法临时的实例库
 * @author Andy.Gao
 *
 */
public class Pgt00358Action extends ActionSupport {
	private static final long serialVersionUID = 8752575363304418620L;
	private IPgt00335Service t00335Service;
	private IPgt00358Service t00358Service;
	private IPgt00332Service t00332Service;
	private IPgt00333Service t00333Service;
	private IPgt00334Service t00334Service;
	private Pgt00332 t00332Bean;
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private ArrayList<Pgv00358> rows;	
	private ArrayList<Pgt00333> xzList;
	private ArrayList<Pgt00335> slTempList;
	private ArrayList<Pgt00334> pgslList;
	private String txtFCID;
	private String txtPSSD;
	private String txtSLID;
	private String txtSWID;
	private String txtPSSDTOJYJG;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() - start");
		}

		try {
			t00332Bean = t00332Service.LoadByPrimaryKey(new Pgt00332(txtFCID, txtPSSD));
			//执行查询其他修正
			xzList = t00333Service.LoadAll(new Pgt00333(txtFCID, txtPSSD));
			// 读取临时实例库
			slTempList = t00335Service.LoadAll(new Pgt00335(txtFCID, txtPSSD));
			if(slTempList.size()<1){
				pgslList = getT00334Service().LoadAll(new Pgt00334(txtFCID, txtPSSD));
			}
		} catch (Exception e) {
			LOG.error("execute()", e);
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() - end");
		}
		return SUCCESS;
	}

	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00358 v00358 = new Pgv00358();
		try {
			//准備查詢條件
			v00358.setPssdToJyjg(ConvertUtil.toInteger(txtPSSDTOJYJG));
			v00358.setCd00302Fcid(txtFCID);
			v00358.setCd00002Pssd(txtPSSD);
			v00358.setPageIndex(pageIndex);
			v00358.setPageSize(getPageSize());
			//执行查询
			rows = t00358Service.LoadAll(v00358);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getTotal();
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error("query()", e);
			LOG.error(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/****************************** set and get ***************************************/
	
	/**
	 * @param t00358Service the t00358Service to set
	 */
	public void setT00358Service(IPgt00358Service t00358Service) {
		this.t00358Service = t00358Service;
	}

	/**
	 * @return the t00358Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00358Service getT00358Service() {
		return t00358Service;
	}

	/**
	 * @param t00335Service the t00335Service to set
	 */
	public void setT00335Service(IPgt00335Service t00335Service) {
		this.t00335Service = t00335Service;
	}

	/**
	 * @return the t00335Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00335Service getT00335Service() {
		return t00335Service;
	}
	
	/**
	 * @return the txtFCID
	 */
	public String getTxtFCID() {
		return txtFCID;
	}

	/**
	 * @param txtFCID the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}

	/**
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}

	/**
	 * @param txtPSSD the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
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
	 * @return the rows
	 */
	public ArrayList<Pgv00358> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00358> rows) {
		this.rows = rows;
	}

	/**
	 * @param txtSLID the txtSLID to set
	 */
	public void setTxtSLID(String txtSLID) {
		this.txtSLID = txtSLID;
	}

	/**
	 * @return the txtSLID
	 */
	public String getTxtSLID() {
		return txtSLID;
	}

	/**
	 * @return the txtPSSDTOJYJG
	 */
	public String getTxtPSSDTOJYJG() {
		return txtPSSDTOJYJG;
	}

	/**
	 * @param txtPSSDTOJYJG the txtPSSDTOJYJG to set
	 */
	public void setTxtPSSDTOJYJG(String txtPSSDTOJYJG) {
		this.txtPSSDTOJYJG = txtPSSDTOJYJG;
	}

	/**
	 * @return the t00332Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00332Service getT00332Service() {
		return t00332Service;
	}

	/**
	 * @param t00332Service the t00332Service to set
	 */
	public void setT00332Service(IPgt00332Service t00332Service) {
		this.t00332Service = t00332Service;
	}

	/**
	 * @return the t00332Bean
	 */
	public Pgt00332 getT00332Bean() {
		return t00332Bean;
	}

	/**
	 * @param t00332Bean the t00332Bean to set
	 */
	public void setT00332Bean(Pgt00332 t00332Bean) {
		this.t00332Bean = t00332Bean;
	}

	/**
	 * @param xzList the xzList to set
	 */
	public void setXzList(ArrayList<Pgt00333> xzList) {
		this.xzList = xzList;
	}

	/**
	 * @return the xzList
	 */
	public ArrayList<Pgt00333> getXzList() {
		return xzList;
	}

	/**
	 * @return the t00333Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00333Service getT00333Service() {
		return t00333Service;
	}

	/**
	 * @param t00333Service the t00333Service to set
	 */
	public void setT00333Service(IPgt00333Service t00333Service) {
		this.t00333Service = t00333Service;
	}

	/**
	 * @param slTempList the slTempList to set
	 */
	public void setSlTempList(ArrayList<Pgt00335> slTempList) {
		this.slTempList = slTempList;
	}

	/**
	 * @return the slTempList
	 */
	public ArrayList<Pgt00335> getSlTempList() {
		return slTempList;
	}

	/**
	 * @param txtSWID the txtSWID to set
	 */
	public void setTxtSWID(String txtSWID) {
		this.txtSWID = txtSWID;
	}

	/**
	 * @return the txtSWID
	 */
	public String getTxtSWID() {
		return txtSWID;
	}

	/**
	 * @param pgslList the pgslList to set
	 */
	public void setPgslList(ArrayList<Pgt00334> pgslList) {
		this.pgslList = pgslList;
	}

	/**
	 * @return the pgslList
	 */
	public ArrayList<Pgt00334> getPgslList() {
		return pgslList;
	}

	/**
	 * @param t00334Service the t00334Service to set
	 */
	public void setT00334Service(IPgt00334Service t00334Service) {
		this.t00334Service = t00334Service;
	}

	/**
	 * @return the t00334Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00334Service getT00334Service() {
		return t00334Service;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

}