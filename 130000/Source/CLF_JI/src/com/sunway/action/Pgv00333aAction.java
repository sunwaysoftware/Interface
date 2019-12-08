/**
 * 
 */
package com.sunway.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgv00333aService;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgv00333a;

/**
 * @author Andy.Gao
 *
 */
public class Pgv00333aAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3571589861720542777L;
	private IPgv00333aService v00333aService;
	private String txtFCID;
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
			Pgv00333a bean = new Pgv00333a();
			bean.setCd00302Fcid(txtFCID);
			bean.setQtxzid(QTXZ);
			bean.setCd00002Czr(sessionCtrl.getUserId());
			bean.setCd00002Pssd(txtPSSD);
			bean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(v00333aService.GetExecCommand(bean))
				this.addActionMessage("其他修正添加成功");
			else
				this.addActionError("其他修正添加失败");	
		} catch (Exception e) {
			return INPUT;
		}
		
		return SUCCESS;
	}

	/**
	 * @param v00333aService the v00333aService to set
	 */
	public void setV00333aService(IPgv00333aService v00333aService) {
		this.v00333aService = v00333aService;
	}

	/**
	 * @return the v00333aService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgv00333aService getV00333aService() {
		return v00333aService;
	}

	/**
	 * @param txtFCID the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}

	/**
	 * @return the txtFCID
	 */
	public String getTxtFCID() {
		return txtFCID;
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
