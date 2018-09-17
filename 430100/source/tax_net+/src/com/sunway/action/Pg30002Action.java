/**
 * 
 */
package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPg30002Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00331;

/**
 * 
 * 已評估[市場法]
 * @author Andy.Gao
 * @category 評估
 * @version 1.0
 *
 */
public class Pg30002Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 5879086697929539339L;
	private IPg30002Service pg30002Service;
	private ArrayList<Pgv00331> rows;
	// VIEW
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFCSLHFind;
	private String hidFlag;
	private String chkSel;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private Boolean bgFlag;
	private String FCID;
	private String userRole;
	
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

		Pgv00331 v00331 = new Pgv00331();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00331.setCd00301Swid(FormatUtil.toSearchLike(txtSWIDFind));
			v00331.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v00331.setFcslh(CheckUtil.chkTrim(txtFCSLHFind));
			v00331.setPageIndex(pageIndex);
			v00331.setPageSize(getPageSize());
			v00331.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00331.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			rows = pg30002Service.LoadPgOK(v00331);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error("query()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
			return INPUT;
		}finally{
			readRole();
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;	
	}

	/**
	 * 重新评税前的验证
	 */
	public void validateExecutePgAgain() {
		this.clearErrorsAndMessages();
		if ("1".equals(hidFlag) && CheckUtil.chkEmpty(chkSel))
			this.addActionError("请选择要参与重评税的数据");
	}

	/**
	 * 重新评税
	 * @return
	 * @throws Exception
	 */
	public String executePgAgain() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("executePgAgain() ********** start **********");
		}
		Pgv00302 v00302 = new Pgv00302();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			v00302.setPgCzr(sessionCtrl.getUserId());
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v00302.setSysPssdYMD(ConvertUtil.toUtilDate(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD_YMD)));
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			switch (ConvertUtil.toInteger(hidFlag)) {
			case 1:// 選擇重新评税
				v00302.setFcid(chkSel);
				// 執行重新评税
				if (pg30002Service.GetExecPgAgain(v00302))
					this.addActionMessage(getText(Constant.MSG_PG_EXECR_OK, new String[] { chkSel }));
				else
					this.addActionError(getText(Constant.MSG_PG_EXECR_NG));
				break;
			case 2:// 全部重新评税
				// 執行重新评税
				v00302.setCd00301Swid(FormatUtil.toSearchLike(txtSWIDFind));
				v00302.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
				if (pg30002Service.GetExecPgAgainAll(v00302))
					this.addActionMessage(getText(Constant.MSG_PG_EXECR_OK, new String[] { Constant.STRING_EMPTY }));
				else
					this.addActionError(getText(Constant.MSG_PG_EXECR_NG));
				break;
			default:
				break;
			}
		} catch (Exception e) {
			LOG.error("executePgAgain()", e);
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("executePgAgain() ********** end **********");
			}
			return INPUT;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("executePgAgain() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 估价后的数据，进行变更
	 * @return
	 * @throws Exception
	 */
	public String executeInfoBg() throws Exception {
		Pgv00302 v00302 = new Pgv00302();
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		v00302.setFcid(ConvertUtil.encoding(FCID));
		v00302.setPgCzr(sessionCtrl.getUserId());
		v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
		bgFlag = pg30002Service.ExecInfoBg(v00302);
		return SUCCESS;
	}
	
	

	/**
	 * 读取ROLE.
	 */
	
	protected void readRole() throws Exception {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		Object role = sessionCtrl.GetList(SessionCtrl.SESSION_KEY_USERROLE);
		if(null!=role){
			ArrayList<String> roleList = (ArrayList<String>) role;
			for(Integer i = 0; i < roleList.size(); i++){
				userRole = CheckUtil.chkNull(userRole) + roleList.get(i) + Constant.STRING_COMMA;
			}
		}
	}
	
	/*********************** set and get ******************************/	
	
	/**
	 * @param pg30002Service the pg30002Service to set
	 */
	public void setPg30002Service(IPg30002Service pg30002Service) {
		this.pg30002Service = pg30002Service;
	}
	/**
	 * @return the pg30002Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPg30002Service getPg30002Service() {
		return pg30002Service;
	}

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv00331> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00331> rows) {
		this.rows = rows;
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
	public String getChkSel() {
		return chkSel;
	}

	/**
	 * @param chkSel the chkSel to set
	 */
	public void setChkSel(String chkSel) {
		this.chkSel = chkSel;
	}

	/**
	 * @param bgFlag the bgFlag to set
	 */
	public void setBgFlag(Boolean bgFlag) {
		this.bgFlag = bgFlag;
	}

	/**
	 * @return the bgFlag
	 */
	public Boolean getBgFlag() {
		return bgFlag;
	}

	/**
	 * @param fCID the fCID to set
	 */
	public void setFCID(String fCID) {
		FCID = fCID;
	}

	/**
	 * @return the fCID
	 */
	public String getFCID() {
		return FCID;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}


}
