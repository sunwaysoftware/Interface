package com.sunway.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.util.Common;
import com.sunway.util.SessionCtrl;

/**
 * 首页跳转action
 * @category 系统维护
 * @author Lee
 * @version 1.0
 */

public class MainFrameAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 8171960690761568028L;
	private String pageLx;
	private String userRole;
	private String urlPath;
	private Boolean ISADMIN;
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
	 * 跳轉到主頁
	 * @return
	 * @throws Exception
	 */
	public String home() throws Exception {
		try {
			
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#fdcpg()
	 */
	public String fdcpg() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("fdcpg() ********** start **********");
		}

		try {
			if (Common.isNullOrEmpty(pageLx))
			{
				setUrlPath("../main/FDCPGMAIN.action");
			}
			else if ("0".equals(getPageLx()))
			{
				setUrlPath("../PG10000/PG10001.jsp");
			}
			else if ("1".equals(getPageLx()))
			{
				setUrlPath("../PG20000/PG20001.jsp");
			}
			else if ("2".equals(getPageLx()))
			{
				setUrlPath("../PG30000/PG30001.jsp");
			}
			else if ("3".equals(getPageLx()))
			{
				setUrlPath("../pg/VIEWPG10001G.action");
			}
			else if ("4".equals(getPageLx()))
			{
				setUrlPath("../pg/VIEWPG20001G.action");
			}
			else if ("5".equals(getPageLx()))
			{
				setUrlPath("../pg/VIEWPG30001G.action");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("fdcpg() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("fdcpg() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#psjgcl()
	 */
	public String psjgcl() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("psjgcl() ********** start **********");
		}

		try {
			if (Common.isNullOrEmpty(pageLx))
			{
				setUrlPath("../main/PSJGCLMAIN.action");
			}else if ("3".equals(getPageLx()))
			{
				setUrlPath("../psjgcl/VIEWNSSC.action");
			}
			else if ("6".equals(getPageLx()))
			{
				setUrlPath("../SS30000/SS30000.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("psjgcl() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("psjgcl() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#psjgjy()
	 */
	public String psjgjy() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("psjgjy() ********** start **********");
		}

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("psjgjy() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("psjgjy() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#sjcx()
	 */
	public String sjcx() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("sjcx() ********** start **********");
		}

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("sjcx() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("sjcx() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#sjdbfx()
	 */
	public String sjdbfx() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("sjdbfx() ********** start **********");
		}

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("sjdbfx() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("sjdbfx() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#sjgl()
	 */
	public String sjgl() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("sjgl() ********** start **********");
		}

		try {
			if (Common.isNullOrEmpty(pageLx))
			{
				setUrlPath("../main/SJGLMAIN.action");
			}
			else if ("0".equals(getPageLx()))
			{
				setUrlPath("../T12001/VIEWT12000.jsp");
			}
			else if ("1".equals(getPageLx()))
			{
				setUrlPath("../sjcj/ADDT00302.action?ACT=C");
			}
			else if ("2".equals(getPageLx()))
			{
				setUrlPath("../SH10000/SH10001.jsp");
			}
			else if ("3".equals(getPageLx()))
			{
				setUrlPath("../SH20000/SH20001.jsp");
			}
			else if ("4".equals(getPageLx()))
			{
				setUrlPath("../SH30000/SH30001.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("sjgl() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("sjgl() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#tjbb()
	 */
	public String tjbb() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("tjbb() ********** start **********");
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("tjbb() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("tjbb() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#xtwh()
	 */
	public String xtwh() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("xtwh() ********** start **********");
		}

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("xtwh() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("xtwh() ********** end **********");
		}
		return SUCCESS;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#xtwh()
	 */
	public String dtdh() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("dtdh() ********** start **********");
		}

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("dtdh() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("dtdh() ********** end **********");
		}
		return SUCCESS;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#xtwh()
	 */
	public String zhtj() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("zhtj() ********** start **********");
		}

		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("zhtj() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("zhtj() ********** end **********");
		}
		return SUCCESS;
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#fdcpg()
	 */
	public String fdcpgLeft() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("fdcpgLeft() ********** start **********");
		}

		try {
			readRole();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("fdcpgLeft() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("fdcpgLeft() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#psjgcl()
	 */
	public String psjgclLeft() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("psjgclLeft() ********** start **********");
		}

		try {
			readRole();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("psjgclLeft() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("psjgclLeft() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#psjgjy()
	 */
	public String psjgjyLeft() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("psjgjyLeft() ********** start **********");
		}

		try {
			readRole();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("psjgjyLeft() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("psjgjyLeft() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#sjcx()
	 */
	public String sjcxLeft() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("sjcxLeft() ********** start **********");
		}

		try {
			readRole();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("sjcxLeft() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("sjcxLeft() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#sjdbfx()
	 */
	public String sjdbfxLeft() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("sjdbfxLeft() ********** start **********");
		}

		try {
			readRole();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("sjdbfxLeft() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("sjdbfxLeft() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#sjgl()
	 */
	public String sjglLeft() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("sjglLeft() ********** start **********");
		}

		try {
			readRole();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("sjglLeft() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("sjglLeft() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#tjbbLeft()
	 */
	public String tjbbLeft() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("tjbbLeft() ********** start **********");
		}

		try {
			readRole();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("tjbbLeft() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("tjbbLeft() ********** end **********");
		}
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#xtwh()
	 */
	public String xtwhLeft() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("xtwhLeft() ********** start **********");
		}

		try {
			readRole();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("xtwhLeft() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("xtwhLeft() ********** end **********");
		}
		return SUCCESS;
	}

	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#xtwh()
	 */
	public String dtdhLeft() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("dtdhLeft() ********** start **********");
		}

		try {
			readRole();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("dtdhLeft() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("dtdhLeft() ********** end **********");
		}
		return SUCCESS;
	}
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#xtwh()
	 */
	public String zhtjLeft() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("zhtjLeft() ********** start **********");
		}

		try {
			readRole();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("zhtjLeft() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("zhtjLeft() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 读取ROLE.
	 */
	protected void readRole() throws Exception {
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		/*Object role = sessionCtrl.GetList(SessionCtrl.SESSION_KEY_USERROLE);
		if(null!=role){
			ArrayList<String> roleList = (ArrayList<String>) role;
			for(Integer i = 0; i < roleList.size(); i++){
				userRole = userRole + roleList.get(i) + Constant.STRING_COMMA;
			}
		}*/
		setISADMIN(Common.convertToBoolean(sessionCtrl.Get(SessionCtrl.SESSION_KEY_ISADMIN)));
	}
	
	/**
	 * 跳轉到主頁
	 * @return
	 * @throws Exception
	 */
	public String homeMain() throws Exception {
		try {
			readRole();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/**
	 * 数据管理main页面
	 * @return
	 * @throws Exception
	 */
	public String sjglMain() throws Exception {
		try {
			readRole();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String fdcpgMain() throws Exception {
		try {
			readRole();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}	
	
	public String psjgclMain() throws Exception {
		try {
			readRole();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}		
	
	public String psjgjyMain() throws Exception {
		try {
			readRole();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}		
	
	public String sjcxMain() throws Exception {
		try {
			readRole();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}		
	
	public String sjdbfxMain() throws Exception {
		try {
			readRole();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}		
	
	public String tjbbMain() throws Exception {
		try {
			readRole();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}		
	
	public String xtwhMain() throws Exception {
		try {
			readRole();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}	
	
	public String dtdhMain() throws Exception {
		try {
			readRole();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String zhtjMain() throws Exception {
		try {
			readRole();
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
	public void setPageLx(String pageLx) {
		this.pageLx = pageLx;
	}


	public String getPageLx() {
		return pageLx;
	}


	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}


	public String getUrlPath() {
		return urlPath;
	}


	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}


	/**
	 * @param iSADMIN the iSADMIN to set
	 */
	public void setISADMIN(Boolean iSADMIN) {
		ISADMIN = iSADMIN;
	}


	/**
	 * @return the iSADMIN
	 */
	public Boolean getISADMIN() {
		return ISADMIN;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession = arg0;
	}
	
}
