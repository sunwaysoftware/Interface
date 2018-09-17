package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.ICzArcgisService;
import com.sunway.util.CheckUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.CzArcgis;

/**
 * @author Lee
 *
 */
public class CzArcgisAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -3035919071377880518L;
	private static final String FAIL = "fail";
	private ICzArcgisService arcgisService;
	
	private ArrayList<CzArcgis> arcgisList;
	private CzArcgis arcgisBean;
	private String SWID;
	private String FCID;
	private String MXID;
	private String DCID;
	private Double X;
	private Double Y;
	
	private String XQDM;
	private String FWTDZL;
	
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			
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
	 * 根据id取得xy坐标
	 */
	public String getXandYbyID() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("getXandYbyID() ********** start **********");
		}
		CzArcgis bean = new CzArcgis();
		
		try {
			if (!CheckUtil.chkEmpty(SWID)) {
				bean.setId(SWID);
				bean.setType(1);
			}else if (!CheckUtil.chkEmpty(DCID)) {
				bean.setId(DCID);
				bean.setType(2);
			}else if (!CheckUtil.chkEmpty(FCID)) {
				bean.setId(FCID);
				bean.setType(3);
			}else if (!CheckUtil.chkEmpty(MXID)) {
				bean.setId(MXID);
				bean.setType(4);
			}
			
			arcgisBean = arcgisService.ExecCommandCZ00062(bean);
			
			if (arcgisBean.getX() !=0 && arcgisBean.getY()!=0) {
				setX(arcgisBean.getX());
				setY(arcgisBean.getY());
			}else{
				return FAIL;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("getXandYbyID() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("getXandYbyID() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 得到小区名称价格范围
	 * @return
	 * @throws Exception
	 */
	public String getPriceByXqmc() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("getPriceByXqmc() ********** start **********");
		}
		CzArcgis bean = new CzArcgis();
		
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCd00352Xqdm(XQDM);
			bean.setFwtdzl(FWTDZL);
			bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			
			arcgisBean = arcgisService.ExecCommandCZ00063(bean);
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("getPriceByXqmc() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("getPriceByXqmc() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 地产统计
	 * @return
	 * @throws Exception
	 */
	public String getDcxxTotal() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("getDcxxTotal() ********** start **********");
		}
		CzArcgis bean = new CzArcgis();
		
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bean.setDcid(DCID);
			arcgisList = arcgisService.ExecCommandCZ00061(bean);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("getDcxxTotal() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("getDcxxTotal() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 得到地产位置信息
	 * @return
	 * @throws Exception
	 */
	public String getDcxxPos() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("getDcxxPos() ********** start **********");
		}
		CzArcgis bean = new CzArcgis();
		
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			
			arcgisList = arcgisService.ExecCommandCZ00064(bean);
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("getDcxxPos() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("getDcxxPos() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** setter and getter ******************************/
	
	/**
	 * @return the arcgisService
	 */
	public ICzArcgisService getArcgisService() {
		return arcgisService;
	}

	/**
	 * @param arcgisService the arcgisService to set
	 */
	public void setArcgisService(ICzArcgisService arcgisService) {
		this.arcgisService = arcgisService;
	}


	/**
	 * @return the arcgisBean
	 */
	public CzArcgis getArcgisBean() {
		return arcgisBean;
	}


	/**
	 * @param arcgisBean the arcgisBean to set
	 */
	public void setArcgisBean(CzArcgis arcgisBean) {
		this.arcgisBean = arcgisBean;
	}


	/**
	 * @return the sWID
	 */
	public String getSWID() {
		return SWID;
	}


	/**
	 * @param sWID the sWID to set
	 */
	public void setSWID(String sWID) {
		SWID = sWID;
	}


	/**
	 * @return the fCID
	 */
	public String getFCID() {
		return FCID;
	}


	/**
	 * @param fCID the fCID to set
	 */
	public void setFCID(String fCID) {
		FCID = fCID;
	}


	/**
	 * @return the mXID
	 */
	public String getMXID() {
		return MXID;
	}


	/**
	 * @param mXID the mXID to set
	 */
	public void setMXID(String mXID) {
		MXID = mXID;
	}


	/**
	 * @return the dCID
	 */
	public String getDCID() {
		return DCID;
	}


	/**
	 * @param dCID the dCID to set
	 */
	public void setDCID(String dCID) {
		DCID = dCID;
	}


	/**
	 * @return the x
	 */
	public Double getX() {
		return X;
	}


	/**
	 * @param x the x to set
	 */
	public void setX(Double x) {
		X = x;
	}


	/**
	 * @return the y
	 */
	public Double getY() {
		return Y;
	}


	/**
	 * @param y the y to set
	 */
	public void setY(Double y) {
		Y = y;
	}


	/**
	 * @return the arcgisList
	 */
	public ArrayList<CzArcgis> getArcgisList() {
		return arcgisList;
	}


	/**
	 * @param arcgisList the arcgisList to set
	 */
	public void setArcgisList(ArrayList<CzArcgis> arcgisList) {
		this.arcgisList = arcgisList;
	}


	/**
	 * @return the xQDM
	 */
	public String getXQDM() {
		return XQDM;
	}


	/**
	 * @param xQDM the xQDM to set
	 */
	public void setXQDM(String xQDM) {
		XQDM = xQDM;
	}


	/**
	 * @return the fWTDZL
	 */
	public String getFWTDZL() {
		return FWTDZL;
	}


	/**
	 * @param fWTDZL the fWTDZL to set
	 */
	public void setFWTDZL(String fWTDZL) {
		FWTDZL = fWTDZL;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}
	
}
