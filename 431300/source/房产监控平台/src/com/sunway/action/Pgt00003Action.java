package com.sunway.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00003Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00003;

/**
 * 评税时点
 * 
 * @category 系统维护
 * @author LeiJia
 * @version 1.0
 */

public class Pgt00003Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 9033270113031422659L;

	// Service
	private IPgt00003Service t00003Service;

	// View

	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	// edit页面所需Bean
	private Pgt00003 t00003Bean;
	// primary key 主键
	// 编辑操作符
	private String ACT;
	// 表单提交数据
	private String txtEXPIRYDAYS;
	private String txtUPDATE;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String userRole;
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			t00003Bean=t00003Service.LoadByPrimaryKey();
		} catch (Exception e) {
			e.printStackTrace();
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
	 * 更新信息处理
	 * 
	 * @return
	 * @throws Exception
	 */

	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			t00003Bean = new Pgt00003();
			t00003Bean.setExpriyDays(Common.convertToInteger(txtEXPIRYDAYS));
			t00003Bean.setCd00002Czr(sessionCtrl
					.Get(SessionCtrl.SESSION_KEY_USERID));
			t00003Bean
					.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if (t00003Service.GetUpdateCommand(t00003Bean)) {
				this.addActionMessage(getText(Constant.MSG_UPDATE_OK,
						new String[] {t00003Bean.getCd00002Czr() }));
			} else
				this.addActionError(getText(Constant.MSG_UPDATE_NG,
						new String[] { t00003Bean.getCd00002Czr() }));

		} catch (Exception e) {
			e.printStackTrace();
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** set and get ******************************/

	/**
	 * @return the t00003Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00003Service getT00003Service() {
		return t00003Service;
	}

	/**
	 * @param t00003Service
	 *            the t00003Service to set
	 */
	public void setT00003Service(IPgt00003Service t00003Service) {
		this.t00003Service = t00003Service;
	}

	/**
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex
	 *            the pageIndex to set
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return the rowCount
	 */
	public Integer getRowCount() {
		return rowCount;
	}

	/**
	 * @param rowCount
	 *            the rowCount to set
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	/**
	 * @return the t00003Bean
	 */
	public Pgt00003 getT00003Bean() {
		return t00003Bean;
	}

	/**
	 * @param t00003Bean
	 *            the t00003Bean to set
	 */
	public void setT00003Bean(Pgt00003 t00003Bean) {
		this.t00003Bean = t00003Bean;
	}

	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @param aCT
	 *            the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
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
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}

	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getTxtEXPIRYDAYS() {
		return txtEXPIRYDAYS;
	}

	public void setTxtEXPIRYDAYS(String txtEXPIRYDAYS) {
		this.txtEXPIRYDAYS = txtEXPIRYDAYS;
	}

	public String getTxtUPDATE() {
		return txtUPDATE;
	}

	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
	}

}
