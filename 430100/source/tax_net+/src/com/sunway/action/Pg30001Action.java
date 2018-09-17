/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPg30001Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00302;

/**
 * 
 * 未評估[市場法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg30001Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -4553367021722957306L;
	private IPg30001Service pg30001Service;
	private ArrayList<Pgv00302> rows;
	private ArrayList<Pgv00302> mxList;
	// VIEW
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFCSLHFind;
	private String hidFlag;
	private String[] chkSel;
	private Integer processCent;	
	private String processMsg;
	private SessionCtrl sessionCtrl = new SessionCtrl();
//	private Pgv00302 v00302Bean ;
	private Pgv00302 v00302Bean;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public void validateQuery() {
		this.clearErrorsAndMessages();
	}
	
	/**
	 * 查询处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00302 v00302 = new Pgv00302();
		try {
			//准備查詢條件
			v00302.setCd00301Swid(FormatUtil.toSearchLike(txtSWIDFind));
			v00302.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v00302.setFcslh(CheckUtil.chkTrim(txtFCSLHFind));
			v00302.setPageIndex(pageIndex);
			v00302.setPageSize(getPageSize());
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = pg30001Service.LoadPg(v00302);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = rows.get(0).getRecordCount();
				
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error("Pg30001Action -- query()", e);
			this.addActionError(e.getMessage());
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;	
	}

	
	/**
	 * 评税前的验证
	 */
	public void validateExecutePG(){
		this.clearErrorsAndMessages();
		if("1".equals(hidFlag) && (null==chkSel || chkSel.length<1))
			this.addActionError("请选择要参与评税的数据");
	}
	
	/**
	 * 選擇评税
	 * @return
	 * @throws Exception
	 */
	public String executePG() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executePG() ********** start **********");
		}
		Pgv00302 v00302 = new Pgv00302();
		v00302Bean = new Pgv00302();
		Integer pgwCount = 0;
		Integer pgCount = 0;
		Integer pgTotal = 0;
		try {
			processMsg = "数据估价";
			v00302.setPgCzr(sessionCtrl.getUserId());
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00302.setSysPssdYMD(ConvertUtil.toUtilDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			switch (ConvertUtil.toInteger(hidFlag)) {
			case 1:// 選擇评税
				chkSel = chkSel[0].split(",");
				pgTotal = chkSel.length;
				for (Integer i = 0; i < chkSel.length; i++) {
					try {
						v00302.setFcid(chkSel[i]);
						// 執行評估
						v00302Bean = pg30001Service.GetExecPG(v00302);
						if (v00302Bean.getbResult()==1){
							pgCount++;
					    }
						else
							pgwCount++;
					} catch (Exception e2) {
						LOG.error("executePG()", e2);
					}
					processCent = i * 100 / chkSel.length;
				}
				break;
			case 2:// 全部评税
				v00302.setCd00301Swid(FormatUtil.toSearchLike(txtSWIDFind));
				v00302.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
				rows = pg30001Service.LoadPgList(v00302);
				pgTotal = rows.size();
				for (Integer i = 0; i < rows.size(); i++) {
					try {
						v00302.setFcid(rows.get(i).getFcid());
						// 執行評估
						v00302Bean = pg30001Service.GetExecPG(v00302);
						if (v00302Bean.getbResult()==1)
							pgCount++;
						else
							pgwCount++;
					} catch (Exception e2) {
						LOG.error("executePG()", e2);
					}
					processCent = i * 100 / rows.size();
				}
				break;
			default:
				break;
			}
		} catch (Exception e) {
			LOG.error("Pg30001Action -- executePG()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executePG() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("executePG() ********** end **********");
		}
		this.addActionMessage("评税执行完毕[共" + pgTotal + "条数据，" + pgCount + "条参与评税，其中"+pgwCount+"条未通过]");
		return SUCCESS;
	}
	
	

	/**
	 * 通过企业ID得到审核未通过的明细列表
	 * @return
	 * @throws Exception
	 */
	public String queryNgMxList() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryNgMxList() ********** start **********");
		}

		Pgv00302 bean = new Pgv00302();
		try {
			txtSWIDFind = ConvertUtil.encoding(txtSWIDFind);
			bean.setCd00301Swid(txtSWIDFind);
			bean.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			mxList = pg30001Service.LoadPgMxNgList(bean);		
		} catch (Exception e) {
			LOG.error("Pg30001Action -- queryNgMxList()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("queryNgMxList() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryNgMxList() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** set and get ******************************/
	
	/**
	 * @param pg30001Service the pg30001Service to set
	 */
	public void setPg30001Service(IPg30001Service pg30001Service) {
		this.pg30001Service = pg30001Service;
	}
	/**
	 * @return the pg30001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPg30001Service getPg30001Service() {
		return pg30001Service;
	}

	/**
	 * @return the mxList
	 */
	public ArrayList<Pgv00302> getMxList() {
		return mxList;
	}

	/**
	 * @param mxList the mxList to set
	 */
	public void setMxList(ArrayList<Pgv00302> mxList) {
		this.mxList = mxList;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv00302> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00302> rows) {
		this.rows = rows;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	/**
	 * @return the txtFCSLHFind
	 */
	public String getTxtFCSLHFind() {
		return txtFCSLHFind;
	}

	/**
	 * @param txtFCSLHFind the txtFCSLHFind to set
	 */
	public void setTxtFCSLHFind(String txtFCSLHFind) {
		this.txtFCSLHFind = txtFCSLHFind;
	}



	public Pgv00302 getV00302Bean() {
		return v00302Bean;
	}

	public void setV00302Bean(Pgv00302 v00302Bean) {
		this.v00302Bean = v00302Bean;
	}

}
