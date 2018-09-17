/**
 * 
 */
package com.sunway.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.chart.ChartData;
import com.sunway.service.IBB00005Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.ConvertUtil;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.BF00005;

/**
 * 
 * 正常个案对比分析
 * @author:Lee
 * 
 * @author Andy 2011.10 update
 * @version 2.0
 */
public class Bb00005Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1624799067716624340L;

	private IBB00005Service bb00005Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private BF00005 bf00005Bean;
	private String txtSSGXFind;
	private String txtPSSDFind;
	private String txtJYSJMinFind;
	private String txtJYSJMaxFind;
	private String imgFileName;
	private String txtSSGX;
	private String userRole;
	private ArrayList<ChartData> data;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		txtJYSJMinFind=MakeUtil.monthFirstDay();
		txtJYSJMaxFind=MakeUtil.currentDate();
		txtSSGX = sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX);
		readRole();
		return SUCCESS;
	}

	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		BF00005 bean = new BF00005();
		try {
			if(!CheckUtil.chkEmpty(txtSSGX)){
				bean.setSsgxId(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setSsgxId(txtSSGX);
			}
			bean.setJysjMin(ConvertUtil.toUtilDate(txtJYSJMinFind));
			bean.setJysjMax(ConvertUtil.toUtilDate(txtJYSJMaxFind));
			bf00005Bean = bb00005Service.LoadAll(bean);	
			if(null != bf00005Bean){
				data = new ArrayList<ChartData>();
				data.add(new ChartData("正常评估", BigDecimal.valueOf(bf00005Bean.getPgzh())));
				data.add(new ChartData("第三方评估", BigDecimal.valueOf(bf00005Bean.getGpgzh())));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		} finally {
			readRole();
		}
		return SUCCESS;
	}
	
	/**
	 * 查询
	 * @return
	 * @throws Exception
	 */
	public String query02() throws Exception {
		BF00005 bean = new BF00005();
		try {
			if(!CheckUtil.chkEmpty(txtSSGX)){
				bean.setSsgxId(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setSsgxId(txtSSGX);
			}
			bean.setJysjMin(ConvertUtil.toUtilDate(txtJYSJMinFind));
			bean.setJysjMax(ConvertUtil.toUtilDate(txtJYSJMaxFind));
			bf00005Bean = bb00005Service.LoadAll02(bean);	
			if(null != bf00005Bean){
				data = new ArrayList<ChartData>();
				data.add(new ChartData("正常评估", BigDecimal.valueOf(bf00005Bean.getPgzh())));
				data.add(new ChartData("第三方评估", BigDecimal.valueOf(bf00005Bean.getGpgzh())));
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
		} finally {
			readRole();
		}
		return SUCCESS;
	}
	
	/**
	 * 读取ROLE.
	 */	
	protected void readRole() throws Exception {
		userRole = sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERROLE);
	}		
	
	/****************************** get and set *********************************/
	
	@Override
	public void setSession(Map<String, Object> session) {
		sessionCtrl.appSession = session;
	}
	
	/**
	 * @param bb00005Service the bb00005Service to set
	 */
	public void setBb00005Service(IBB00005Service bb00005Service) {
		this.bb00005Service = bb00005Service;
	}

	/**
	 * @return the bb00005Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IBB00005Service getBb00005Service() {
		return bb00005Service;
	}

	/**
	 * @return the txtSSGXFind
	 */
	public String getTxtSSGXFind() {
		return txtSSGXFind;
	}

	/**
	 * @param txtSSGXFind the txtSSGXFind to set
	 */
	public void setTxtSSGXFind(String txtSSGXFind) {
		this.txtSSGXFind = txtSSGXFind;
	}

	/**
	 * @return the txtPSSDFind
	 */
	public String getTxtPSSDFind() {
		return txtPSSDFind;
	}

	/**
	 * @param txtPSSDFind the txtPSSDFind to set
	 */
	public void setTxtPSSDFind(String txtPSSDFind) {
		this.txtPSSDFind = txtPSSDFind;
	}

	/**
	 * @return the txtJYSJMinFind
	 */
	public String getTxtJYSJMinFind() {
		return txtJYSJMinFind;
	}

	/**
	 * @param txtJYSJMinFind the txtJYSJMinFind to set
	 */
	public void setTxtJYSJMinFind(String txtJYSJMinFind) {
		this.txtJYSJMinFind = txtJYSJMinFind;
	}

	/**
	 * @return the txtJYSJMaxFind
	 */
	public String getTxtJYSJMaxFind() {
		return txtJYSJMaxFind;
	}

	/**
	 * @param txtJYSJMaxFind the txtJYSJMaxFind to set
	 */
	public void setTxtJYSJMaxFind(String txtJYSJMaxFind) {
		this.txtJYSJMaxFind = txtJYSJMaxFind;
	}
	
	/**
	 * @return the imgFileName
	 */
	public String getImgFileName() {
		return imgFileName;
	}

	/**
	 * @param imgFileName the imgFileName to set
	 */
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	/**
	 * @return the bf00005Bean
	 */
	public BF00005 getBf00005Bean() {
		return bf00005Bean;
	}

	/**
	 * @param bf00005Bean the bf00005Bean to set
	 */
	public void setBf00005Bean(BF00005 bf00005Bean) {
		this.bf00005Bean = bf00005Bean;
	}

	public String getTxtSSGX() {
		return txtSSGX;
	}

	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
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

	/**
	 * @param data the data to set
	 */
	public void setData(ArrayList<ChartData> data) {
		this.data = data;
	}

	/**
	 * @return the data
	 */
	public ArrayList<ChartData> getData() {
		return data;
	}

}
