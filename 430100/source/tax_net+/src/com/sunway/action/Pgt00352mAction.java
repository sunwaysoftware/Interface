package com.sunway.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00052Service;
import com.sunway.service.IPgt00352m1Service;
import com.sunway.service.IPgt00352mService;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00352m;
import com.sunway.vo.Pgt00352m1;
import com.sunway.vo.Pgv00052;


/**
 * 
 * 小区坐标
 * @author LeiJia
 *
 */
public class Pgt00352mAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 6075462578304640309L;

	//Service
	private IPgt00352mService t00352mService;
	private IPgt00352m1Service t00352m1Service;
	
	private IPgt00052Service t00052Service;
	private String ACT;
	private ArrayList<Pgv00052> szqyList;
	private String SZQY;
	private ArrayList<Pgt00352m> rows;
	private ArrayList<Pgt00352m1> rows1;
	private ArrayList<Pgt00352m> rows2;
	private Pgt00352m bean;
	private String XQDMHM;
	private String XYS;
	private String WKID;
	
	
	private SessionCtrl sessionCtrl=new SessionCtrl();
	private String resSign;
	private String resMsg;

	private Pgt00352m1 bean1;

	private String XMIN;

	private String YMIN;

	private String XMAX;

	private String YMAX;
	

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}

		try {
			szqyList = sessionCtrl.ReadSzqyList();
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
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		Pgt00352m t00352m = new Pgt00352m();
		t00352m.setCd00001Szqy(SZQY);
		t00352m.setCd00352Xqdmhm(XQDMHM);
		try{
			rows=t00352mService.LoadAll(t00352m);
			rows2=t00352mService.LoadAll0(t00352m);
	
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	public String query0() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query0() ********** start **********");
		}
		
		Pgt00352m t00352m = new Pgt00352m();
		t00352m.setCd00001Szqy(SZQY);
		t00352m.setCd00352Xqdmhm(XQDMHM);
		try{
			rows=t00352mService.LoadAll0(t00352m);
	
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("query0() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 查询状态处理
	 * @return
	 * @throws Exception
	 */
	public String query1() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		Pgt00352m1 t00352m1 = new Pgt00352m1();
		t00352m1.setCd00001Szqy(SZQY);
		try{
			rows1=t00352m1Service.LoadAll(t00352m1);
	
		}catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
			return ERROR;
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		try{
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
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
		
		this.clearErrorsAndMessages();	
		bean = new Pgt00352m();
		try {
			if (Constant.MOD_CREATE.equals(getACT())) {
				bean.setCd00001Szqy(SZQY);
				bean.setCd00352Xqdmhm(XQDMHM);
				bean.setXys(XYS);
				bean.setWkid(WKID);
				bean.setCd00002Czr(sessionCtrl.getUserId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}

	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if (t00352mService.GetInsertCommand(bean)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK,
							new String[] { getText("app.t00352m.title") }));
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG,
							new String[] { getText("app.t00352m.title") }));
				}
			} 
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
		}if (Constant.MOD_DELETE.equals(getACT()))// Delete
			return "successDEL";
		else
			return SUCCESS;
	}	
	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create1() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		try{
			szqyList = sessionCtrl.ReadSzqyList();
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 更新操作前的验证处理
	 * @throws Exception
	 */
	public void validateUpdate1() throws Exception{
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		
		this.clearErrorsAndMessages();	
		bean1 = new Pgt00352m1();
		try {
			if (Constant.MOD_CREATE.equals(getACT())) {
				bean1.setCd00001Szqy(SZQY);
				bean1.setxMin(ConvertUtil.toDouble(XMIN));
				bean1.setyMin(ConvertUtil.toDouble(YMIN));
				bean1.setxMax(ConvertUtil.toDouble(XMAX));
				bean1.setyMax(ConvertUtil.toDouble(YMAX));
				bean1.setWkid(WKID);
				bean1.setCd00002Czr(sessionCtrl.getUserId());
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.addActionError(e.getMessage());
		}
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}

	/**
	 * 更新信息处理
	 * @return
	 * @throws Exception
	 */
	public String update1() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update1() ********** start **********");
		}

		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if (t00352m1Service.GetInsertCommand(bean1)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK,
							new String[] { getText("app.t00352m1.title") }));
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG,
							new String[] { getText("app.t00352m1.title") }));
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
			String[] msgs = e.getMessage().split("\n");
			this.addActionError(msgs[0]);

			if (LOG.isDebugEnabled()) {
				LOG.debug("update1() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update1() ********** end **********");
		}if (Constant.MOD_DELETE.equals(getACT()))// Delete
			return "successDEL";
		else
			return SUCCESS;
	}	
	/**
	 * 选择删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String delAll() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try {
			Pgt00352m t00352m = new Pgt00352m();
			t00352m.setCd00001Szqy(SZQY);
			t00352m.setCd00352Xqdmhm(XQDMHM);
			if (t00352mService.GetDeleteAllCommand(t00352m)) {
				resSign = "1";
				resMsg = "删除成功";
			}else{
				throw new Exception("未知错误，请与管理员联系");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resSign = "2";
			resMsg = "删除异常"+e.getMessage();
			
			if (LOG.isDebugEnabled()) {
				LOG.debug("delSel() ********** end **********");
			}
			return SUCCESS;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("delSel() ********** end **********");
		}
		return SUCCESS;
	}
	public String delAll1() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("delSel() ********** start **********");
		}
		this.clearErrorsAndMessages();
		try {
			Pgt00352m1 t00352m1 = new Pgt00352m1();
			t00352m1.setCd00001Szqy(SZQY);
			if (t00352m1Service.GetDeleteAllCommand(t00352m1)) {
				resSign = "1";
				resMsg = "删除成功";
			}else{
				throw new Exception("未知错误，请与管理员联系");
			}

		} catch (Exception e) {
			e.printStackTrace();
			resSign = "2";
			resMsg = "删除异常"+e.getMessage();
			
			if (LOG.isDebugEnabled()) {
				LOG.debug("delSel() ********** end **********");
			}
			return SUCCESS;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("delSel() ********** end **********");
		}
		return SUCCESS;
	}
	/*********************** set and get ******************************/


	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	@JSON(deserialize=false, serialize=false)
	public IPgt00352mService getT00352mService() {
		return t00352mService;
	}

	public void setT00352mService(IPgt00352mService t00352mService) {
		this.t00352mService = t00352mService;
	}

	@JSON(deserialize=false, serialize=false)
	public IPgt00352m1Service getT00352m1Service() {
		return t00352m1Service;
	}

	public void setT00352m1Service(IPgt00352m1Service t00352m1Service) {
		this.t00352m1Service = t00352m1Service;
	}

	@JSON(deserialize=false, serialize=false)
	public IPgt00052Service getT00052Service() {
		return t00052Service;
	}

	public void setT00052Service(IPgt00052Service t00052Service) {
		this.t00052Service = t00052Service;
	}

	public String getSZQY() {
		return SZQY;
	}

	public void setSZQY(String sZQY) {
		SZQY = sZQY;
	}

	public ArrayList<Pgt00352m> getRows() {
		return rows;
	}

	public void setRows(ArrayList<Pgt00352m> rows) {
		this.rows = rows;
	}	

	public String getXQDMHM() {
		return XQDMHM;
	}

	public void setXQDMHM(String xQDMHM) {
		XQDMHM = xQDMHM;
	}

	public String getXYS() {
		return XYS;
	}

	public void setXYS(String xYS) {
		XYS = xYS;
	}

	public String getWKID() {
		return WKID;
	}

	public void setWKID(String wKID) {
		WKID = wKID;
	}

	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionCtrl.appSession=arg0;
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

	public ArrayList<Pgv00052> getSzqyList() {
		return szqyList;
	}

	public void setSzqyList(ArrayList<Pgv00052> szqyList) {
		this.szqyList = szqyList;
	}

	public String getResSign() {
		return resSign;
	}

	public void setResSign(String resSign) {
		this.resSign = resSign;
	}

	public String getResMsg() {
		return resMsg;
	}

	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}	

	public ArrayList<Pgt00352m1> getRows1() {
		return rows1;
	}

	public void setRows1(ArrayList<Pgt00352m1> rows1) {
		this.rows1 = rows1;
	}

	public String getXMIN() {
		return XMIN;
	}

	public void setXMIN(String xMIN) {
		XMIN = xMIN;
	}

	public String getYMIN() {
		return YMIN;
	}

	public void setYMIN(String yMIN) {
		YMIN = yMIN;
	}

	public String getXMAX() {
		return XMAX;
	}

	public void setXMAX(String xMAX) {
		XMAX = xMAX;
	}

	public String getYMAX() {
		return YMAX;
	}

	public void setYMAX(String yMAX) {
		YMAX = yMAX;
	}

	public ArrayList<Pgt00352m> getRows2() {
		return rows2;
	}

	public void setRows2(ArrayList<Pgt00352m> rows2) {
		this.rows2 = rows2;
	}

	public Pgt00352m getBean() {
		return bean;
	}

	public void setBean(Pgt00352m bean) {
		this.bean = bean;
	}

	public Pgt00352m1 getBean1() {
		return bean1;
	}

	public void setBean1(Pgt00352m1 bean1) {
		this.bean1 = bean1;
	}

	
	
	
}
