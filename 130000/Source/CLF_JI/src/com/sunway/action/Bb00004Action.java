package com.sunway.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.chart.ChartData;
import com.sunway.service.IBB00004Service;
import com.sunway.util.Common;

import com.sunway.util.SessionCtrl;
import com.sunway.vo.BF00004;

/**
 * 
 * 交易量走势图
 * @author Andy.Gao
 *
 */
public class Bb00004Action extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -1624799067716624340L;

	private IBB00004Service bb00004Service;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private ArrayList<BF00004> bbList;
	private String txtSSGXFind;
	private String txtPSSDFind;
	private String txtJYJGMinFind;
	private String txtJYJGMaxFind;
	private String imgFileName;
	private String txtSSGX;
	private String sign;
	private String userRole;
	private ArrayList<ChartData> data;
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		txtPSSDFind=Common.getCurrentDatea();
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
		BF00004 bean = new BF00004();
		try {
			bean.setCzr(sessionCtrl.getUserId());
			if("".equals(txtSSGX) || null == txtSSGX){
				bean.setSsgxId(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			}else{
				bean.setSsgxId(txtSSGX);
			}
			if("1".equals(sign)){
				bean.setPssd(txtPSSDFind);
			}else{
				bean.setPssd("");
			}
			bean.setJyjgMin(Common.convertToDouble(txtJYJGMinFind));
			bean.setJyjgMax(Common.convertToDouble(txtJYJGMaxFind));
			bbList = bb00004Service.LoadAll(bean);	
			if(null != bbList){
				data = new ArrayList<ChartData>();
				for (BF00004 b : bbList) {
					data.add(new ChartData(b.getPssd(), BigDecimal.valueOf(b.getHs())));
				}
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
	 * @param bb00004Service the bb00004Service to set
	 */
	public void setBb00004Service(IBB00004Service bb00004Service) {
		this.bb00004Service = bb00004Service;
	}

	/**
	 * @return the bb00004Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IBB00004Service getBb00004Service() {
		return bb00004Service;
	}

	/**
	 * @return the bbList
	 */
	public ArrayList<BF00004> getBbList() {
		return bbList;
	}

	/**
	 * @param bbList the bbList to set
	 */
	public void setBbList(ArrayList<BF00004> bbList) {
		this.bbList = bbList;
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
	 * @return the txtJYJGMinFind
	 */
	public String getTxtJYJGMinFind() {
		return txtJYJGMinFind;
	}

	/**
	 * @param txtJYJGMinFind the txtJYJGMinFind to set
	 */
	public void setTxtJYJGMinFind(String txtJYJGMinFind) {
		this.txtJYJGMinFind = txtJYJGMinFind;
	}

	/**
	 * @return the txtJYJGMaxFind
	 */
	public String getTxtJYJGMaxFind() {
		return txtJYJGMaxFind;
	}

	/**
	 * @param txtJYJGMaxFind the txtJYJGMaxFind to set
	 */
	public void setTxtJYJGMaxFind(String txtJYJGMaxFind) {
		this.txtJYJGMaxFind = txtJYJGMaxFind;
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

	public String getTxtSSGX() {
		return txtSSGX;
	}

	public void setTxtSSGX(String txtSSGX) {
		this.txtSSGX = txtSSGX;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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
	 * @return the data
	 */
	public ArrayList<ChartData> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ArrayList<ChartData> data) {
		this.data = data;
	}
}
