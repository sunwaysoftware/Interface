/**
 * 
 */
package com.sunway.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv02033aService;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv02033a;

/**
 * @author Andy.Gao
 *
 */
public class Pgv02033aAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3567542351494708655L;
	private IPgv02033aService v02033aService;
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
			Pgv02033a bean = new Pgv02033a();
			bean.setCd12004Mxid(txtMXID);
			bean.setQtxzid(QTXZ);
			bean.setCd00002Czr(sessionCtrl.getUserId());
			bean.setCd00002Pssd(txtPSSD);
			bean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(v02033aService.GetExecCommand(bean))
				this.addActionMessage("其他修正添加成功");
			else
				this.addActionError("其他修正添加失败");	
		} catch (Exception e) {
			return INPUT;
		}
		
		return SUCCESS;
	}

	/**
	 * @return the v02033aService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgv02033aService getV02033aService() {
		return v02033aService;
	}

	/**
	 * @param v02033aService the v02033aService to set
	 */
	public void setV02033aService(IPgv02033aService v02033aService) {
		this.v02033aService = v02033aService;
	}

	/**
	 * @return the txtMXID
	 */
	public String getTxtMXID() {
		return txtMXID;
	}

	/**
	 * @param txtMXID the txtMXID to set
	 */
	public void setTxtMXID(String txtMXID) {
		this.txtMXID = txtMXID;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
	
}
