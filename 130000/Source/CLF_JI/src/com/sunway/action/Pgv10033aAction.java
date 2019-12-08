/**
 * 
 */
package com.sunway.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv10033aService;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv10033a;

/**
 * @author Andy.Gao
 *
 */
public class Pgv10033aAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 5702354135007641537L;
	private IPgv10033aService v10033aService;
	
	private String txtMXID;
	private String QTXZ;
	private String txtPSSD;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			txtPSSD = sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD);
			Pgv10033a bean = new Pgv10033a();
			bean.setCd12004Mxid(txtMXID);
			bean.setQtxzid(QTXZ);
			bean.setCd00002Czr(sessionCtrl.getUserId());
			bean.setCd00002Pssd(txtPSSD);
			bean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(v10033aService.GetExecCommand(bean))
				this.addActionMessage("其他修正添加成功");
			else
				this.addActionError("其他修正添加失败");	
		} catch (Exception e) {
			return INPUT;
		}
		
		return SUCCESS;
	}

	/**
	 * @param v10033aService the v10033aService to set
	 */
	public void setV10033aService(IPgv10033aService v10033aService) {
		this.v10033aService = v10033aService;
	}

	/**
	 * @return the v10033aService
	 */
	public IPgv10033aService getV10033aService() {
		return v10033aService;
	}

	/**
	 * @return the qTXZ
	 */
	public String getQTXZ() {
		return QTXZ;
	}

	/**
	 * @param qTXZ the qTXZ to set
	 */
	public void setQTXZ(String qTXZ) {
		QTXZ = qTXZ;
	}

	/**
	 * @param txtMXID the txtMXID to set
	 */
	public void setTxtMXID(String txtMXID) {
		this.txtMXID = txtMXID;
	}

	/**
	 * @return the txtMXID
	 */
	public String getTxtMXID() {
		return txtMXID;
	}

	/**
	 * @param txtPSSD the txtPSSD to set
	 */
	public void setTxtPSSD(String txtPSSD) {
		this.txtPSSD = txtPSSD;
	}

	/**
	 * @return the txtPSSD
	 */
	public String getTxtPSSD() {
		return txtPSSD;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
