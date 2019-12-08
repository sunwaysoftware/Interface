package com.sunway.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12085Service;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12085;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv12085;
import com.sunway.vo.PgvCz00002;

/**
 * 各地区审核类型设置表(Pgt12085)
 * @author Lee
 * @version 1.0
 */

public class Pgt12085Action extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = -2059325142273746939L;

	private IPgt12085Service t12085Service;
	
	//View
	private ArrayList<Pgv12085> shlxList;
	private ArrayList<Pgv00052> szqyList;
	
	//Edit
	
	//edit页面所需Bean
	private Pgt12085 t12085Bean;
	private PgvCz00002 v00002Bean;
	private ArrayList<Pgt12085> t12085List;
	//primary key 主键
	private String SZQY;
	private String SHLX;
	//编辑操作符
	private String ACT;
	//表单提交数据
	private String ddlSZQY;
	private String txtSHLX;
	private String chkSFSH;
	private String txtUPDATE;
	private String txtNOTE;
	private String chkSHLXMC;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		Pgv12085 v12085 = new Pgv12085();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			ACT=Constant.MOD_CREATE;
			szqyList = sessionCtrl.ReadSzqyList();
			shlxList = t12085Service.LoadAll(v12085);
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
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		Pgv12085 v12085 = new Pgv12085();
		t12085Bean = new Pgt12085();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			ACT=Constant.MOD_UPDATE;
			//准备查询条件
			v12085.setCd00001Szqy(ddlSZQY);
			t12085Bean.setCd00001Szqy(ddlSZQY);
			//执行查询
			shlxList = t12085Service.LoadAll(v12085);
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t12085Bean = new Pgt12085();
		this.clearErrorsAndMessages();
		ACT=Constant.MOD_UPDATE;
		t12085Bean.setCd00001Szqy(ddlSZQY);
		t12085Bean.setShlxs(chkSHLXMC);
		t12085Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
		t12085Bean.setNote("");
		t12085Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
	}
	
	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	
	public String update() {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				if(t12085Service.GetInsertCommand(getT12085Bean()))
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{getT12085Bean().getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{getT12085Bean().getCd00001Szqy()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t12085Service.GetUpdateCommand(getT12085Bean())){
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{getT12085Bean().getCd00001Szqy()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{getT12085Bean().getCd00001Szqy()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t12085Service.GetDeleteCommand(getT12085Bean()))
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{getT12085Bean().getCd00001Szqy()}));
				else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{getT12085Bean().getCd00001Szqy()}));
			}
			query();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}finally{
			szqyList = sessionCtrl.ReadSzqyList();
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return SUCCESS;
	}
	
/*********************** setter and getter ******************************/
	
	/**
	 * @return the t12085Service
	 */
	public IPgt12085Service getT12085Service() {
		return t12085Service;
	}

	/**
	 * @param t12085Service the t12085Service to set
	 */
	public void setT12085Service(IPgt12085Service t12085Service) {
		this.t12085Service = t12085Service;
	}

	/**
	 * @return the shlxList
	 */
	public ArrayList<Pgv12085> getShlxList() {
		return shlxList;
	}

	/**
	 * @param shlxList the shlxList to set
	 */
	public void setShlxList(ArrayList<Pgv12085> shlxList) {
		this.shlxList = shlxList;
	}

	/**
	 * @return the szqyList
	 */
	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	/**
	 * @param szqyList the szqyList to set
	 */
	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	/**
	 * @return the t12085Bean
	 */
	public Pgt12085 getT12085Bean() {
		return t12085Bean;
	}

	/**
	 * @param t12085Bean the t12085Bean to set
	 */
	public void setT12085Bean(Pgt12085 t12085Bean) {
		this.t12085Bean = t12085Bean;
	}

	/**
	 * @return the v00002Bean
	 */
	public PgvCz00002 getV00002Bean() {
		return v00002Bean;
	}

	/**
	 * @param v00002Bean the v00002Bean to set
	 */
	public void setV00002Bean(PgvCz00002 v00002Bean) {
		this.v00002Bean = v00002Bean;
	}

	/**
	 * @return the t12085List
	 */
	public ArrayList<Pgt12085> getT12085List() {
		return t12085List;
	}

	/**
	 * @param t12085List the t12085List to set
	 */
	public void setT12085List(ArrayList<Pgt12085> t12085List) {
		this.t12085List = t12085List;
	}

	/**
	 * @return the sZQY
	 */
	public String getSZQY() {
		return SZQY;
	}

	/**
	 * @param sZQY the sZQY to set
	 */
	public void setSZQY(String sZQY) {
		SZQY = sZQY;
	}

	/**
	 * @return the sHLX
	 */
	public String getSHLX() {
		return SHLX;
	}

	/**
	 * @param sHLX the sHLX to set
	 */
	public void setSHLX(String sHLX) {
		SHLX = sHLX;
	}

	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the ddlSZQY
	 */
	public String getDdlSZQY() {
		return ddlSZQY;
	}

	/**
	 * @param ddlSZQY the ddlSZQY to set
	 */
	public void setDdlSZQY(String ddlSZQY) {
		this.ddlSZQY = ddlSZQY;
	}

	/**
	 * @return the txtSHLX
	 */
	public String getTxtSHLX() {
		return txtSHLX;
	}

	/**
	 * @param txtSHLX the txtSHLX to set
	 */
	public void setTxtSHLX(String txtSHLX) {
		this.txtSHLX = txtSHLX;
	}

	/**
	 * @return the chkSFSH
	 */
	public String getChkSFSH() {
		return chkSFSH;
	}

	/**
	 * @param chkSFSH the chkSFSH to set
	 */
	public void setChkSFSH(String chkSFSH) {
		this.chkSFSH = chkSFSH;
	}

	/**
	 * @return the txtUPDATE
	 */
	public String getTxtUPDATE() {
		return txtUPDATE;
	}

	/**
	 * @param txtUPDATE the txtUPDATE to set
	 */
	public void setTxtUPDATE(String txtUPDATE) {
		this.txtUPDATE = txtUPDATE;
	}

	/**
	 * @return the txtNOTE
	 */
	public String getTxtNOTE() {
		return txtNOTE;
	}

	/**
	 * @param txtNOTE the txtNOTE to set
	 */
	public void setTxtNOTE(String txtNOTE) {
		this.txtNOTE = txtNOTE;
	}

	/**
	 * @return the chkSHLXMC
	 */
	public String getChkSHLXMC() {
		return chkSHLXMC;
	}

	/**
	 * @param chkSHLXMC the chkSHLXMC to set
	 */
	public void setChkSHLXMC(String chkSHLXMC) {
		this.chkSHLXMC = chkSHLXMC;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
