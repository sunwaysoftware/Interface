/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00351Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00351;

/**
 * 
 * 相同区域测算
 * 
 * @author Andy.Gao
 * 
 */
public class Pgt00351CsSameAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -924356328897448285L;
	private IPgt00351Service t00351Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	// View
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv00351> rows;
	private String ddlSZQY;
	private String txtXQMC;
	private String txtFWLX;
	private String txtJZJG;
	private String txtJYLX;
	private String rdoYWDT;
	private String txtPSSD;
	private String[] chkSel;
	private Integer processCent;	
	private String processMsg;
	private String hidFlag;
	
	private Pgv00351 v00351;
	private String txtGPQZ;
	private String txtGPXF;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		try {
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}

	/**
	 * 数据查询用
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		Pgv00351 v00351 = new Pgv00351();
		try {
			v00351.setCd00001Szqy(ddlSZQY);
			v00351.setCd00352Xqdm(txtXQMC);
			v00351.setCd00001Fwlx(txtFWLX);
			v00351.setCd00001Jzjg(txtJZJG);
			v00351.setCd00001Jylx(txtJYLX);
			v00351.setYwdt(ConvertUtil.toInteger(rdoYWDT));
			v00351.setJysj(ConvertUtil.toUtilDate(txtPSSD+"-01"));
			v00351.setPageIndex(pageIndex);
			v00351.setPageSize(getPageSize());
			rows = t00351Service.LoadAllCsSame(v00351);
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return SUCCESS;
	}

	/**
	 * 审核前的验证
	 */
	public void validateCsBzf(){
		this.clearErrorsAndMessages();
		try {
			ReadInfo();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		v00351 = new Pgv00351();
		v00351.setCd00001Szqy(ddlSZQY);
		v00351.setCd00352Xqdm(txtXQMC);
		v00351.setCd00001Fwlx(txtFWLX);
		v00351.setCd00001Jzjg(txtJZJG);
		v00351.setCd00001Jylx(txtJYLX);
		v00351.setGpqz(ConvertUtil.toDouble(txtGPQZ));
		v00351.setGpxf(ConvertUtil.toDouble(txtGPXF));
		v00351.setYwdt(ConvertUtil.toInteger(rdoYWDT));
		v00351.setJysj(ConvertUtil.toUtilDate(txtPSSD+"-01"));
		v00351.setCd00002Czr(sessionCtrl.getUserId());
		switch (ConvertUtil.toInteger(hidFlag)) {
		case 1:// 選擇評估
			if (null==chkSel || chkSel.length<1)
				this.addActionError("请选择要参与测算的数据");
			break;
		default:
			break;
		}			
	}
	
	/**
	 * 测算标准房
	 * @return
	 * @throws Exception
	 */
	public String csBzf() throws Exception {
		Integer pgCount = 0;
		Integer pgTotal = 0;
		try {
			processMsg = "标准房数据测算";
			switch (ConvertUtil.toInteger(hidFlag)) {
			case 1:// 選擇测算
				pgTotal = chkSel.length;
				for(Integer i=0; i<chkSel.length; i++){
					try {
						v00351.setSlid(chkSel[i]);
						// 執行测算
						if(t00351Service.ExecCsSame(v00351)){
							pgCount++;
						}	
					} catch (Exception e2) {
						LOG.error("executeSH()", e2);
					}
					processCent = i*100/chkSel.length;
				}
				break;
			case 2:// 全部测算
				rows = t00351Service.LoadAllCsSameByBzfID(v00351);
				pgTotal = rows.size();
				for(Integer i=0; i<rows.size(); i++){
					try {
						v00351.setSlid(rows.get(i).getSlid());
						// 執行测算
						if(t00351Service.ExecCsSame(v00351)){
							pgCount++;
						}	
					} catch (Exception e2) {
						LOG.error("executeSH()", e2);
					}
					processCent = i*100/rows.size();
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			LOG.error("executeSH()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executeSH() ********** end **********");
			}
			
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("executeSH() ********** end **********");
		}
		this.addActionMessage("测算执行完毕[共"+ pgTotal +"条数据，"+ pgCount +"条参与测算]");
		return SUCCESS;
	}
	
	/**
	 * 取得【所在区域】下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}
	
	/************************* set and get *******************************/

	/**
	 * @param t00351Service the t00351Service to set
	 */
	public void setT00351Service(IPgt00351Service t00351Service) {
		this.t00351Service = t00351Service;
	}

	/**
	 * @return the t00351Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00351Service getT00351Service() {
		return t00351Service;
	}

	/**
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00351> rows) {
		this.rows = rows;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv00351> getRows() {
		return rows;
	}

	/**
	 * @return the txtXQMC
	 */
	public String getTxtXQMC() {
		return txtXQMC;
	}

	/**
	 * @param txtXQMC the txtXQMC to set
	 */
	public void setTxtXQMC(String txtXQMC) {
		this.txtXQMC = txtXQMC;
	}

	/**
	 * @return the txtFWLX
	 */
	public String getTxtFWLX() {
		return txtFWLX;
	}

	/**
	 * @param txtFWLX the txtFWLX to set
	 */
	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}

	/**
	 * @return the txtJZJG
	 */
	public String getTxtJZJG() {
		return txtJZJG;
	}

	/**
	 * @param txtJZJG the txtJZJG to set
	 */
	public void setTxtJZJG(String txtJZJG) {
		this.txtJZJG = txtJZJG;
	}

	/**
	 * @return the txtJYLX
	 */
	public String getTxtJYLX() {
		return txtJYLX;
	}

	/**
	 * @param txtJYLX the txtJYLX to set
	 */
	public void setTxtJYLX(String txtJYLX) {
		this.txtJYLX = txtJYLX;
	}

	/**
	 * @return the rdoYWDT
	 */
	public String getRdoYWDT() {
		return rdoYWDT;
	}

	/**
	 * @param rdoYWDT the rdoYWDT to set
	 */
	public void setRdoYWDT(String rdoYWDT) {
		this.rdoYWDT = rdoYWDT;
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
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.sessionCtrl.appSession = session;
	}

	/**
	 * @return the chkSel
	 */
	public String[] getChkSel() {
		return chkSel;
	}

	/**
	 * @param chkSel the chkSel to set
	 */
	public void setChkSel(String[] chkSel) {
		this.chkSel = chkSel;
	}

	/**
	 * @return the processCent
	 */
	public Integer getProcessCent() {
		return processCent;
	}

	/**
	 * @param processCent the processCent to set
	 */
	public void setProcessCent(Integer processCent) {
		this.processCent = processCent;
	}

	/**
	 * @return the processMsg
	 */
	public String getProcessMsg() {
		return processMsg;
	}

	/**
	 * @param processMsg the processMsg to set
	 */
	public void setProcessMsg(String processMsg) {
		this.processMsg = processMsg;
	}

	/**
	 * @return the hidFlag
	 */
	public String getHidFlag() {
		return hidFlag;
	}

	/**
	 * @param hidFlag the hidFlag to set
	 */
	public void setHidFlag(String hidFlag) {
		this.hidFlag = hidFlag;
	}

	/**
	 * @param ddlSZQY the ddlSZQY to set
	 */
	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}

	/**
	 * @return the ddlSZQY
	 */
	public String getDdlSZQY() {
		return ddlSZQY;
	}

	/**
	 * @return the txtGPQZ
	 */
	public String getTxtGPQZ() {
		return txtGPQZ;
	}

	/**
	 * @param txtGPQZ the txtGPQZ to set
	 */
	public void setTxtGPQZ(String txtGPQZ) {
		this.txtGPQZ = txtGPQZ;
	}

	/**
	 * @return the txtGPXF
	 */
	public String getTxtGPXF() {
		return txtGPXF;
	}

	/**
	 * @param txtGPXF the txtGPXF to set
	 */
	public void setTxtGPXF(String txtGPXF) {
		this.txtGPXF = txtGPXF;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

}
