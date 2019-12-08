package com.sunway.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00301Service;
import com.sunway.service.IPgt00302Service;
import com.sunway.service.IPgt00302eService;
import com.sunway.service.IPgt00303Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.Excel;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00301;
import com.sunway.vo.Pgt00302;
import com.sunway.vo.Pgt00303;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv00302;
import com.sunway.vo.Pgv00302e;
import com.sunway.vo.Pgv00303;
import com.sunway.vo.Pgv00357;

import net.sf.json.JSONObject;

import com.sunway.vo.Pgt00352xml;

/**
 * 市场法房地产信息（PGT00302）
 * 
 * @author Lee create
 * @author Andy.Gao fix
 * @version 1.0
 */

public class Pgt00302Action extends ActionSupport implements SessionAware {
	private static Logger logger = LogManager.getLogger(Pgt00302Action.class);
	private static final long serialVersionUID = 6531280519525243009L;
	// Service
	private IPgt00302Service t00302Service;
	private IPgt00303Service t00303Service;
	private IPgt00302eService t00302eService;
	private IPgt00301Service t00301Service;
	// View
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv00302e> qtxzList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer rowCount;
	// Bean数组
	private ArrayList<Pgv00302> tabList;
	private ArrayList<Pgt00352xml> xmlList;
	// 检索条件
	private String txtFCIDFind;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFDCDATFind;
	private String txtXQFind;
	private String txtFCSLHFind;
	private String txtFWTDZLFind;
	private String ddlSZQYFind;
	//编辑操作符
	private String ACT;
	//primary key 主键
	private String FCID;
	// detail页面所需Bean
	private Pgv00302 v00302Bean;
	private Pgt00352xml t00352Bean;
	private String SWID;
	// edit页面所需Bean
	private Pgt00302 tBean;
	private Pgt00301 t00301Bean;
	
	private Pgt00303 t00303Bean;
	// edit页面提交数据
	private String txtUPDATE;
	private String txtSWID;
	private String txtLFID;
	private String txtFWLX;
	private String txtJYLX;
	private String txtJZJGT;
	private String txtJZMJ;
	private String txtFWCX;
	private String txtCGZK;
	private String txtSZLC;
	private String txtBWJFH;
	private String txtJYJG;
	private String txtDTGJ;
	private String txtTDSYQMJ;
	private String txtRJL;
	private String txtJYSJ;
	private String txtFDCDAT;
	private String txtNOTET00302;
	private String txtJZJG;
	private String rdoYWDT;
	private String rdoYWJKC;
	private String txtZLC;
	private String txtNOTE;
	private String txtZJHM;
	private String txtHTBH;
	private String XZLX;
	private String hidQTXZ;
	private String txtXQDM;
	private String FWTDZL;
	private String hidNsrmc;
	private Boolean forward;
	private String txtBGSJ;
	private String ddlBGLX;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	private String txtNSRMC;
	private String txtZJLXId;
	private String txtZZ;
	private String txtLXDH;
	private String txtYDDH;
	private String txtNOTET00301;
	private Pgv00303 v00303Bean;
	private String txtFCZH;
	private String txtQDH;
	private String txtCB;
	private String txtGHYTT;
	private String txtHXJG;
	private String txtJCSJ;
	private String txtDJRQ;
	private String txtJTZKId;
	private String txtWYZKId;
	private String txtZXZKId;
	private String txtZCDZL;
	private String txtZCDZBM;
	private String SysDate;
	private String hidPARENTDM;
	private String hidXQZT;
	private String ddlSZQY;
	private String txtXJXQMC;
	private String txtLH;
	private String txtWSRQ;
	private String txtWSJS;
	private String txtMFGJDM;
	private String txtGMFGJDM;
	private String txtZRFSBH;
	private String txtCSFSBH;
	
	private String txtCSFZJLX;   	//承受方证件类型
	private String txtCSFNSRMC;  	//承受方姓名
	private String txtCSFZJHM;   	//承受方证件号码
	private String txtCSFLXDH;		//承受方联系电话
	
	private Boolean FROMCJ;//采集标识
	
	private String FCZH;
	private Boolean ISEXISTFCZH;
	private String txtCLH;
	private String hidZHXZid;
	
	//file upload
	private File upload;
	private String fileServerPath;
	private String uploadFileName;
	private String savePath;
	
	//file import
	private String txtFilePath;
	private ArrayList<Pgv00357> Pgv00357List;
	private InputStream excelStream;
	private String fileName;
	private String txtFCSLH;   //房产受理号    
	private String txtOINSID;
	private String txtYJG;
	private String txtSBPGJG;
	private String txtROOMID;
	private String txtOwnRoomid;
	private String txtSFSYFC;
	private String rdoSFSYFC;
	private String txtDyh;
//	private Integer isPIC;
	private String FCIDD;
	private String hidFlag;
	private boolean FormA;
	private String SZQY;
	private String XQDM; 
	private Integer isExistQmpg;
	private boolean  isExistZT;
//	private String tFCID;
	private Integer isClocktZT;
	private String SZQYDM;
	private String rdoZRFNSRLX;
	private String rdoCSFNSRLX;
	
	
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("execute() ********** start **********");
		}
		try {
			ReadInfo();
			if (Constant.MOD_DELETE.equals(ACT)) { // Delete
				ACT = Constant.MOD_MODIFY;
			}
		} catch (Exception e) {
			logger.error("Pgt00302Action -- execute()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("execute() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 查询状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("query() ********** start **********");
		}
		Pgv00302 v00302 = new Pgv00302();
		try {
			// 准备查询条件
			v00302.setFcid(Common.getSearchLike(Common.trim(txtFCIDFind)));
			v00302.setCd00301Swid(Common.getSearchLike(Common.trim(txtSWIDFind)));
			v00302.setNsrmc(Common.getSearchLike(Common.trim(txtNSRMCFind)));
			v00302.setCd00001Szqy(ddlSZQYFind);
			v00302.setCd00352Xqdm(Common.trim(txtXQFind));
			v00302.setFcslh(Common.trim(txtFCSLHFind));
			v00302.setFwtdzl(Common.getSearchLike(Common.trim(txtFWTDZLFind)));
			v00302.setPageIndex(pageIndex);
			v00302.setPageSize(getPageSize());
			v00302.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00302.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			// 执行查询
			v00302Bean = t00302Service.LoadAll(v00302);
			tabList = v00302Bean.getV00302List();
			// 分页设置
			if (null != tabList && tabList.size() > 0) {
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
			} else {
				pageIndex = 1;rowCount = 0;
			}
			ReadInfo();
		} catch (Exception e) {
			logger.error("Pgt00302Action -- query()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("query() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	public String create() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("create() ********** start **********");
		}
		String rtn = "successADD";		
		t00301Bean = new Pgt00301();
		v00303Bean = new Pgv00303();
		v00302Bean = new Pgv00302();
//		isClocktZT=1;
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				logger.info("正在转向【房产变更信息】界面...");
				Pgt00302 t00302 = new Pgt00302();
				tBean = new Pgt00302();
				// 取得用户选中的数据信息
				t00302.setFcid(FCID);
				tBean = t00302Service.LoadByPrimaryKey(t00302);				
				v00303Bean.setLfid(tBean.getCd00303Lfid());
				v00303Bean.setPageIndex(1);
				v00303Bean.setPageSize(getPageSize());
				v00303Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
				ArrayList<Pgv00303> v00303List = t00303Service.LoadAll(v00303Bean);
				t00301Bean.setSwid(tBean.getCd00301Swid());
				t00301Bean = t00301Service.LoadByPrimaryKey(t00301Bean);
				if (null != v00303List && v00303List.size() > 0) {
					v00303Bean = v00303List.get(0);
				}				
				
				rtn = "success";
			} else {		
				logger.info("正在转向【住宅房产信息采集】界面...");
				SysDate = Common.readCurrentDate();
			}
		
			ReadInfo();
		} catch (Exception e) {
			logger.error("Pgt00302Action -- create()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}finally{
			FROMCJ = true;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("create() ********** end **********");
		}
		return rtn;
	} 
	/**
	 * 通过选择照片返回所在区域和小区信息
	 */
	public void GetXqxxByPic(){
		if (logger.isDebugEnabled()) {
			logger.debug("create() ********** start **********");
		}
		v00303Bean = new Pgv00303();
		try {
			if(FormA)
			{
				v00303Bean.setCd00001Szqy(SZQY);
				//v00303Bean.setXqnm(Common.convertEncoding(XQNM));
				v00303Bean.setCd00352Xqdm(XQDM);
				SysDate = Common.readCurrentDate();
			}
			ReadInfo();
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("Pgt00302Action -- GetXqxxByPic()", e);
			this.addActionError(e.getMessage());
		}
		if (logger.isDebugEnabled()) {
			logger.debug("create() ********** end **********");
		}
	}
	/**
	 * 新增状态处理
	 * @return
	 * @throws Exception
	 */
	/*public String create() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("create() ********** start **********");
		}
		String rtn = "successADD";
		Pgt00302 t00302 = new Pgt00302();
		tBean = new Pgt00302();
		t00301Bean = new Pgt00301();
		t00303Bean = new Pgt00303();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				// 取得用户选中的数据信息
				t00302.setFcid(FCID);
				tBean = t00302Service.LoadByPrimaryKey(t00302);
				Pgt00303 t00303 = new Pgt00303();
				t00303.setLfid(tBean.getCd00303Lfid());
				t00303Bean = t00303Service.LoadByPrimaryKey(t00303);
				Pgv00302e v00302e = new Pgv00302e();
				v00302e.setCd00302Fcid(tBean.getFcid());
				qtxzList = t00302eService.LoadAll(v00302e);
				SysDate = Common.readCurrentDateHMS();
				rtn = "success";
			} else {
				v00303Bean = new Pgv00303();
				
				SysDate = Common.readCurrentDate();
			}
			ReadInfo();
		} catch (Exception e) {
			logger.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (logger.isDebugEnabled()) {
				logger.debug("create() ********** end **********");
			}
			return ERROR;
		}finally{
			FROMCJ = true;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("create() ********** end **********");
		}
		return rtn;
	}*/

	

	/**
	 * 更新操作前的验证处理
	 * 
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("validateUpdate() ********** start **********");
		}

		tBean = new Pgt00302();
		t00301Bean = new Pgt00301();
		this.clearErrorsAndMessages();
		if(isExistQmpg==null)
		{
			isExistQmpg=0;
		}
		if(isClocktZT==null)
		{
			isClocktZT=0;
		}
		
		tBean.setFcid(FCID);
	
		t00301Bean.setSwid(txtSWID);
		//根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			tBean = t00302Service.LoadByPrimaryKey(tBean);
			t00301Bean = t00301Service.LoadByPrimaryKey(t00301Bean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!tBean.getUpddate().equals(
						Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
		
			tBean.setFcid(FCID);
			tBean.setHtbh(txtHTBH);
			tBean.setCd00301Swid(txtSWID);			
			t00301Bean.setCd00001Zjlx(txtZJLXId);
			t00301Bean.setNsrmc(txtNSRMC);
			t00301Bean.setLxdh(txtLXDH);
			t00301Bean.setZjhm(txtZJHM);
			t00301Bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			//让变更默认
			t00301Bean.setBgsj(new Date());
			t00301Bean.setBglx(Common.convertToInteger(ddlBGLX));
			
			tBean.setCd00303Lfid(txtLFID);
			tBean.setCd00001Fwlx(txtFWLX);
			tBean.setCd00001Jylx(txtJYLX);
			tBean.setCd00001Jzjg(txtJZJGT);
			tBean.setJzmj(Common.convertToBigDecimal(txtJZMJ));
			tBean.setSzlc(Common.convertToShort(txtSZLC));
			tBean.setBwjfh(txtBWJFH);
			tBean.setJyjg(Common.convertToBigDecimal(txtJYJG));
			tBean.setDtgj(Common.convertToDouble(txtDTGJ));
			tBean.setTdsyqmj(Common.convertToDouble(txtTDSYQMJ));
			tBean.setRjl(Common.convertToDouble(txtRJL));
//			tBean.setJysj(Common.convertToDate(txtJYSJ));
			tBean.setJysj(Common.convertStringToTimestamp(txtJYSJ));
			tBean.setFdcdat(txtFDCDAT);
			tBean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			tBean.setCd00352Xqdm(txtXQDM);
			tBean.setCd00001Jzjg1(txtJZJG);
			tBean.setYwdt(Common.convertToBoolean(rdoYWDT));
			tBean.setYwjkc(Common.convertToBoolean(rdoYWJKC));
			tBean.setZlc(Common.convertToShort(txtZLC));
			tBean.setFwtdzl(FWTDZL);
			tBean.setNote1(txtNOTE);
			//tBean.setCd00053Qtxzid(hidQTXZ);
			tBean.setZhxz(hidZHXZid);
			tBean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			tBean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			tBean.setNsrmc(txtNSRMC);
			tBean.setCd00001Zjlx(txtZJLXId);
			tBean.setZz(txtZZ);
			tBean.setLxdh(txtLXDH);
			tBean.setNote2(txtNOTET00301);
			tBean.setFczh(txtFCZH);
			tBean.setQdh(txtQDH);
			tBean.setCb(txtCB);
			tBean.setGhyt(txtGHYTT);
			tBean.setHxjg(txtHXJG);
		
			tBean.setDjrq(Common.convertToDate(txtDJRQ));
			tBean.setCd00001Jtzk(txtJTZKId);
			tBean.setCd00001Wyzk(txtWYZKId);
			tBean.setCd00001Zxzk(txtZXZKId);
			tBean.setZcdzl(txtZCDZL);
			tBean.setZcdzbm(txtZCDZL);	

			tBean.setCd00352Xqzt(Common.isNullOrEmpty(hidXQZT)?Common.convertToByte("1"):Common.convertToByte(hidXQZT));
			if(isClocktZT==1){
			tBean.setCd00001Szqy(SZQYDM);
			}else{
			tBean.setCd00001Szqy(ddlSZQY);
			}
			tBean.setCd00352Parentdm(hidPARENTDM);
			tBean.setCd00352Xqnm(txtXJXQMC);
			tBean.setClh(txtCLH);
			tBean.setNote(txtNOTET00302);
			
		    tBean.setTxtCSFZJLX(txtCSFZJLX);  
		    tBean.setTxtCSFNSRMC(txtCSFNSRMC);
		    tBean.setTxtCSFZJHM(txtCSFZJHM);
		    tBean.setCsflxdh(txtCSFLXDH);
		    tBean.setTxtFCSLH(txtFCSLH);
		    tBean.setOinsid(Common.convertToInteger(txtOINSID));
		    tBean.setYjg(Common.convertToDouble(txtYJG));
		    tBean.setSbpgjg(Common.convertToDouble(txtSBPGJG));
		    tBean.setRoomid(txtROOMID);
		    tBean.setSfsyfc(Common.convertToInteger(rdoSFSYFC));
		    tBean.setOwnRoomid(txtOwnRoomid);
				
			//让变更默认
			tBean.setBgsj(new Date());
			tBean.setBglx(Common.convertToInteger(ddlBGLX));
			
			tBean.setLh(txtLH);
			tBean.setDyh(txtDyh);
			tBean.setJcsj(txtJCSJ);
			tBean.setWsjs(Common.convertToDouble(txtWSJS));
			tBean.setWsrq(Common.convertToDate(txtWSRQ));
			tBean.setCd00001Mfgjdm(txtMFGJDM);
			tBean.setCd00001Gmfgjdm(txtGMFGJDM);
			tBean.setSbh_zr(txtZRFSBH);
			tBean.setSbh_cs(txtCSFSBH);
			tBean.setNsrLx_cs(Common.convertToInteger(rdoCSFNSRLX));
			tBean.setNsrLx_zr(Common.convertToInteger(rdoZRFNSRLX));
			
			tBean.setIsExistQmpg(isExistQmpg);
		}
		logger.info("不动产数据操作{}：{}", ACT,  JSONObject.fromObject(tBean));
	}
	
	/**
	 * 查询状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryZhxz() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("query() ********** start **********");
		}
		
		try {
			Pgv00302e v00302e = new Pgv00302e();
			v00302e.setCd00302Fcid(FCID);
			v00302e.setCd00001Szqy(ddlSZQY);
			v00302e.setCd00001Fwlx(txtFWLX);
			setQtxzList(t00302eService.LoadAll(v00302e));
		} catch (Exception e) {
			logger.error("Pgt00302Action -- queryZhxz()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 查询状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryZhxzQmpg() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("query() ********** start **********");
		}
		
		try {
			Pgv00302e v00302e = new Pgv00302e();
			v00302e.setCd00302Fcid(FCID);
			v00302e.setCd00001Szqy(ddlSZQY);
			v00302e.setCd00001Fwlx(txtFWLX);
			setQtxzList(t00302eService.LoadAllQM(v00302e));
		} catch (Exception e) {
			logger.error("Pgt00302Action -- queryZhxzQmpg()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	/**
	 * 更新、删除状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		String rtn = SUCCESS;
		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if(ISEXISTFCZH){
					this.addActionError("房产证号已经存在，请不要录入重复数据！");
					return "failADD";
				}
				//如果是新增数据，将交易时间设置成系统当前时间
				//tBean.setJysj(Common.convertStringToTimestampHMS(Common.formatToYMDHMS(new Date())));
				tBean.setCd00301Swid(txtZJHM);
				if (t00302Service.GetInsertCommand(tBean)) {
					SWID = Common.convertEncoding(tBean.getCd00301Swid());
					FCIDD = Common.convertEncoding(tBean.getFcid());
					t00301Bean = t00301Service.LoadByPrimaryKey(new Pgt00301(SWID));
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] {tBean.getFczh()}));
					tBean = new Pgt00302();
					t00303Bean = new Pgt00303();
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] {tBean.getFczh()}));
				}
				rtn = "successADD";
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00301Service.GetUpdateCommand(t00301Bean)) {
					t00301Bean = t00301Service.LoadByPrimaryKey(t00301Bean);
				}
				
				if (t00302Service.GetUpdateCommand(tBean)) {
					tBean = t00302Service.LoadByPrimaryKey(tBean);
					SWID = Common.convertEncoding(tBean.getCd00301Swid());	
					//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
					v00303Bean = new Pgv00303();
					v00303Bean.setLfid(tBean.getCd00303Lfid());
					v00303Bean.setPageIndex(1);
					v00303Bean.setPageSize(getPageSize());
					v00303Bean.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
					ArrayList<Pgv00303> v00303List = t00303Service.LoadAll(v00303Bean);
					if (null != v00303List && v00303List.size() > 0) {
						v00303Bean = v00303List.get(0);
					}	
					
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { tBean.getFczh() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { tBean.getFczh() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t00302Service.GetDeleteCommand(tBean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK));
					ACT = Constant.MOD_MODIFY;
					rtn = "successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG));
				}
			}
			ReadInfo();
			logger.info("不动产数据操作成功（{}）！", ACT);
		} catch (Exception e) {
			logger.error("Pgt00302Action -- update()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}finally{
			//SysDate = Common.readCurrentDateHMS();
		}
		return rtn;
	}

	/**
	 * 市场法房产详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("detail() ********** start **********");
		}
		Pgv00302 v00302 = new Pgv00302();
		v00302Bean = new Pgv00302();
		try {
			logger.info("显示不动产基础信息{}", FCID);
			// 准备查询条件
			v00302.setFcid(Common.trim(FCID));
			// 执行查询
			v00302Bean = t00302Service.LoadDetail(v00302);
		} catch (Exception e) {
			logger.error("Pgt00302Action -- detail()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 市场法房产详细信息
	 * @return
	 * @throws Exception
	 */
	public String detailB() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("detail() ********** start **********");
		}
		Pgv00302 v00302 = new Pgv00302();
		v00302Bean = new Pgv00302();
		try {
			// 准备查询条件
			v00302.setFcid(Common.trim(FCID));
			// 执行查询
			v00302Bean = t00302Service.LoadDetail_B(v00302);
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("Pgt00302Action -- detailB()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 市场法房产详细信息（框架）
	 * @return
	 * @throws Exception
	 */
	public String detailFrame() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("detailFrame() ********** start **********");
		}
		v00302Bean = new Pgv00302();
		try {
			v00302Bean.setFcid(Common.trim(FCID));
			v00302Bean.setCd00301Swid(Common.trim(SWID));
		} catch (Exception e) {
			logger.error("Pgt00302Action -- detailFrame()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (logger.isDebugEnabled()) {
			logger.debug("detailFrame() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 判断房地产档案图是否已经存在
	 * @return
	 * @throws Exception
	 */
	public String queryFDCDAT() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("queryFDCDAT() ********** start **********");
		}
		Pgt00302 t00302 = new Pgt00302();
		try {
			t00302.setFcid(Common.convertEncoding(FCID));
			t00302.setFdcdat(Common.convertEncoding(txtFDCDAT));
			forward = t00302Service.GetFdcdatByFcid(t00302);
		} catch (Exception e) {
			logger.error("Pgt00302Action -- queryFDCDAT()", e);
		}

		if (logger.isDebugEnabled()) {
			logger.debug("queryFDCDAT() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 取得下拉菜单信息
	 * @throws Exception
	 */
	private void ReadInfo() throws Exception {
		// 取得所在区域列表信息
		szqyList = sessionCtrl.ReadSzqyList();
	}

	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String isExistFczh() throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("isExistFczh() ********** start **********");
		}
		try {
			Pgt00302 t00302 = new Pgt00302();
			t00302.setFczh(Common.convertEncoding(FCZH));
//			t00302.setFczh(FCZH);
			v00302Bean = t00302Service.LoadByFczh(t00302);
			ISEXISTFCZH = Common.isNullOrEmpty(v00302Bean.getFcid())?false:true;
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("Pgt00302Action -- isExistFczh()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (logger.isDebugEnabled()) {
			logger.debug("isExistFczh() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** webservice数据操作******************************/

	/*********************** 采集数据导入 ******************************/
	public String executeImport() throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("executeImport() ********** start **********");
		}
		
		
		if(logger.isDebugEnabled()){
			logger.debug("executeImport() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	
	public String upload() throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("upload() ********** start **********");
		}
		try{
			fileServerPath = getSavePath() + "\\" + getUploadFileName();
			FileOutputStream fos = new FileOutputStream(fileServerPath);
			FileInputStream fis = new FileInputStream(getUpload());
			
			int len = 0;
			byte[] buffer = new byte[1024];
			while((len = fis.read(buffer)) > 0){
				fos.write(buffer, 0, len);
			}
			fis.close();
			fos.close();
		}catch(Exception e){
			logger.error(e.getMessage());
			logger.error("Pgt00302Action -- upload()", e);
			return INPUT;
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("upload() ********** end **********");
		}
		return SUCCESS;
	}
	
	public void validateImportFile()throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("validateImportFile() ********** start **********");
		}
		
		if(!Common.isFileExist(txtFilePath)){
			this.addActionError("文件错误，请检查！");
		}
		try{
			//检验数据合法性
			Pgv00357List = Excel.importDataSjcj(txtFilePath, sessionCtrl.getUserId(),sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			if(!checkKbslk(Pgv00357List))
				this.addActionError("采集数据不符合导入要求！");
			if(Pgv00357List.size()==0)
				this.addActionError("采集数据不符合导入要求！");
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError("文件错误，请检查！"+ex.getMessage());
		}
		
		if(logger.isDebugEnabled()){
			logger.debug("validateImportFile() ********** end **********");
		}
	}
	
	/**
	 * 对[挂牌数据]合法性进行检验
	 * @param list
	 * @return
	 */
	private Boolean checkKbslk(ArrayList<Pgv00357> list){
		//TODO 处理保留 对[挂牌数据]合法性进行检验
		return true;
	}
	
	public String importFile() throws Exception{
		if(logger.isDebugEnabled()){
			logger.debug("importFile() ********** start **********");
		}
		
		Pgv00357 tmpV00357 = new Pgv00357();
		try{
			tmpV00357 = t00302Service.ImportExcelData(Pgv00357List);
		}catch(Exception ex){
			ex.printStackTrace();
			logger.error("Pgt00302Action -- importFile()", ex);
			this.addActionError(ex.getMessage());
			return INPUT;
		}finally{
			if(tmpV00357.getOutFlag()==3)
				this.addActionError("数据导入失败，请重新选择模版导入！");
			else if(tmpV00357.getOutFlag()==2)
				this.addActionMessage("数据导入执行完毕！");
			else{
				ByteArrayOutputStream out = (ByteArrayOutputStream) Excel.exportDataSjcj(tmpV00357.getOutList());
				excelStream = new ByteArrayInputStream(out.toByteArray());
				fileName=new String("格式错误的采集数据.xls".getBytes("GBK"),"ISO-8859-1");
				return "failexport";
			}
			/*
			else if (tmpV00304.getOutFlag()==1)
				this.addActionMessage("数据导入执行完毕，但导入过程中部分失败！");
			else 
				this.addActionError("数据导入失败！");
			*/
		}
	
		
		if(logger.isDebugEnabled()){
			logger.debug("importFile() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	/**
	 * WebService
	 * @return
	 * @throws Exception
	 */
	public String executeWS()throws Exception {
		if(logger.isDebugEnabled()){
			logger.debug("executeWS() ********** start **********");
		}
//		queryxml();
		if(logger.isDebugEnabled()){
			logger.debug("executeWS() ********** end **********");
		}
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	/*********************** setter and getter ******************************/
	/**
	 * @return the t00302eService
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00302eService getT00302eService() {
		return t00302eService;
	}
	/**
	 * @param t00302eService the t00302eService to set
	 */
	public void setT00302eService(IPgt00302eService t00302eService) {
		this.t00302eService = t00302eService;
	}
	/**
	 * @return the t00302Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00302Service getT00302Service() {
		return t00302Service;
	}
	/**
	 * @param t00302Service the t00302Service to set
	 */
	public void setT00302Service(IPgt00302Service t00302Service) {
		this.t00302Service = t00302Service;
	}
	/**
	 * @return the t00303Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00303Service getT00303Service() {
		return t00303Service;
	}
	/**
	 * @param t00303Service the t00303Service to set
	 */
	public void setT00303Service(IPgt00303Service t00303Service) {
		this.t00303Service = t00303Service;
	}
	
	/**
	 * @return the t00301Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt00301Service getT00301Service() {
		return t00301Service;
	}
	/**
	 * @param t00301Service the t00301Service to set
	 */
	public void setT00301Service(IPgt00301Service t00301Service) {
		this.t00301Service = t00301Service;
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
	 * @return the pageIndex
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * @param pageIndex the pageIndex to set
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
	 * @param rowCount the rowCount to set
	 */
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}



	/**
	 * @return the txtFCIDFind
	 */
	public String getTxtFCIDFind() {
		return txtFCIDFind;
	}

	/**
	 * @param txtFCIDFind the txtFCIDFind to set
	 */
	public void setTxtFCIDFind(String txtFCIDFind) {
		this.txtFCIDFind = txtFCIDFind;
	}

	/**
	 * @return the txtSWIDFind
	 */
	public String getTxtSWIDFind() {
		return txtSWIDFind;
	}

	/**
	 * @param txtSWIDFind the txtSWIDFind to set
	 */
	public void setTxtSWIDFind(String txtSWIDFind) {
		this.txtSWIDFind = txtSWIDFind;
	}

	/**
	 * @return the txtNSRMCFind
	 */
	public String getTxtNSRMCFind() {
		return txtNSRMCFind;
	}

	/**
	 * @param txtNSRMCFind the txtNSRMCFind to set
	 */
	public void setTxtNSRMCFind(String txtNSRMCFind) {
		this.txtNSRMCFind = txtNSRMCFind;
	}

	/**
	 * @return the txtFDCDATFind
	 */
	public String getTxtFDCDATFind() {
		return txtFDCDATFind;
	}

	/**
	 * @param txtFDCDATFind the txtFDCDATFind to set
	 */
	public void setTxtFDCDATFind(String txtFDCDATFind) {
		this.txtFDCDATFind = txtFDCDATFind;
	}

	/**
	 * @return the txtXQFind
	 */
	public String getTxtXQFind() {
		return txtXQFind;
	}

	/**
	 * @param txtXQFind the txtXQFind to set
	 */
	public void setTxtXQFind(String txtXQFind) {
		this.txtXQFind = txtXQFind;
	}

	/**
	 * @return the txtFWTDZLFind
	 */
	public String getTxtFWTDZLFind() {
		return txtFWTDZLFind;
	}

	/**
	 * @param txtFWTDZLFind the txtFWTDZLFind to set
	 */
	public void setTxtFWTDZLFind(String txtFWTDZLFind) {
		this.txtFWTDZLFind = txtFWTDZLFind;
	}

	/**
	 * @return the ddlSZQYFind
	 */
	public String getDdlSZQYFind() {
		return ddlSZQYFind;
	}

	/**
	 * @param ddlSZQYFind the ddlSZQYFind to set
	 */
	public void setDdlSZQYFind(String ddlSZQYFind) {
		this.ddlSZQYFind = ddlSZQYFind;
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
	 * @return the v00302Bean
	 */
	public Pgv00302 getV00302Bean() {
		return v00302Bean;
	}

	/**
	 * @param v00302Bean the v00302Bean to set
	 */
	public void setV00302Bean(Pgv00302 v00302Bean) {
		this.v00302Bean = v00302Bean;
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
	 * @return the tBean
	 */
	public Pgt00302 gettBean() {
		return tBean;
	}

	/**
	 * @param tBean the tBean to set
	 */
	public void settBean(Pgt00302 tBean) {
		this.tBean = tBean;
	}

	/**
	 * @return the t00301Bean
	 */
	public Pgt00301 getT00301Bean() {
		return t00301Bean;
	}

	/**
	 * @param t00301Bean the t00301Bean to set
	 */
	public void setT00301Bean(Pgt00301 t00301Bean) {
		this.t00301Bean = t00301Bean;
	}

	/**
	 * @return the t00303Bean
	 */
	public Pgt00303 getT00303Bean() {
		return t00303Bean;
	}

	/**
	 * @param t00303Bean the t00303Bean to set
	 */
	public void setT00303Bean(Pgt00303 t00303Bean) {
		this.t00303Bean = t00303Bean;
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
	 * @return the txtSWID
	 */
	public String getTxtSWID() {
		return txtSWID;
	}

	/**
	 * @param txtSWID the txtSWID to set
	 */
	public void setTxtSWID(String txtSWID) {
		this.txtSWID = txtSWID;
	}

	/**
	 * @return the txtLFID
	 */
	public String getTxtLFID() {
		return txtLFID;
	}

	/**
	 * @param txtLFID the txtLFID to set
	 */
	public void setTxtLFID(String txtLFID) {
		this.txtLFID = txtLFID;
	}

	/**
	 * @return the txtFWLX
	 */
	public String getTxtFWLX() {
		return txtFWLX;
	}

	/**
	 * @param txtFWLX the txtFWLX to set
	 */
	public void setTxtFWLX(String txtFWLX) {
		this.txtFWLX = txtFWLX;
	}

	/**
	 * @return the txtJYLX
	 */
	public String getTxtJYLX() {
		return txtJYLX;
	}

	/**
	 * @param txtJYLX the txtJYLX to set
	 */
	public void setTxtJYLX(String txtJYLX) {
		this.txtJYLX = txtJYLX;
	}

	/**
	 * @return the txtJZJGT
	 */
	public String getTxtJZJGT() {
		return txtJZJGT;
	}

	/**
	 * @param txtJZJGT the txtJZJGT to set
	 */
	public void setTxtJZJGT(String txtJZJGT) {
		this.txtJZJGT = txtJZJGT;
	}

	/**
	 * @return the txtFWCX
	 */
	public String getTxtFWCX() {
		return txtFWCX;
	}

	/**
	 * @param txtFWCX the txtFWCX to set
	 */
	public void setTxtFWCX(String txtFWCX) {
		this.txtFWCX = txtFWCX;
	}

	/**
	 * @return the txtCGZK
	 */
	public String getTxtCGZK() {
		return txtCGZK;
	}

	/**
	 * @param txtCGZK the txtCGZK to set
	 */
	public void setTxtCGZK(String txtCGZK) {
		this.txtCGZK = txtCGZK;
	}

	/**
	 * @return the txtBWJFH
	 */
	public String getTxtBWJFH() {
		return txtBWJFH;
	}

	/**
	 * @param txtBWJFH the txtBWJFH to set
	 */
	public void setTxtBWJFH(String txtBWJFH) {
		this.txtBWJFH = txtBWJFH;
	}

	/**
	 * @return the txtJYSJ
	 */
	public String getTxtJYSJ() {
		return txtJYSJ;
	}

	/**
	 * @param txtJYSJ the txtJYSJ to set
	 */
	public void setTxtJYSJ(String txtJYSJ) {
		this.txtJYSJ = txtJYSJ;
	}

	/**
	 * @return the txtFDCDAT
	 */
	public String getTxtFDCDAT() {
		return txtFDCDAT;
	}

	/**
	 * @param txtFDCDAT the txtFDCDAT to set
	 */
	public void setTxtFDCDAT(String txtFDCDAT) {
		this.txtFDCDAT = txtFDCDAT;
	}

	/**
	 * @return the txtNOTET00302
	 */
	public String getTxtNOTET00302() {
		return txtNOTET00302;
	}

	/**
	 * @param txtNOTET00302 the txtNOTET00302 to set
	 */
	public void setTxtNOTET00302(String txtNOTET00302) {
		this.txtNOTET00302 = txtNOTET00302;
	}

	/**
	 * @return the txtJZJG
	 */
	public String getTxtJZJG() {
		return txtJZJG;
	}

	/**
	 * @param txtJZJG the txtJZJG to set
	 */
	public void setTxtJZJG(String txtJZJG) {
		this.txtJZJG = txtJZJG;
	}

	/**
	 * @return the rdoYWDT
	 */
	public String getRdoYWDT() {
		return rdoYWDT;
	}

	/**
	 * @param rdoYWDT the rdoYWDT to set
	 */
	public void setRdoYWDT(String rdoYWDT) {
		this.rdoYWDT = rdoYWDT;
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
	 * @return the qtxzList
	 */
	public ArrayList<Pgv00302e> getQtxzList() {
		return qtxzList;
	}

	/**
	 * @param qtxzList the qtxzList to set
	 */
	public void setQtxzList(ArrayList<Pgv00302e> qtxzList) {
		this.qtxzList = qtxzList;
	}

	/**
	 * @return the xZLX
	 */
	public String getXZLX() {
		return XZLX;
	}

	/**
	 * @param xZLX the xZLX to set
	 */
	public void setXZLX(String xZLX) {
		XZLX = xZLX;
	}

	/**
	 * @return the hidQTXZ
	 */
	public String getHidQTXZ() {
		return hidQTXZ;
	}

	/**
	 * @param hidQTXZ the hidQTXZ to set
	 */
	public void setHidQTXZ(String hidQTXZ) {
		this.hidQTXZ = hidQTXZ;
	}

	/**
	 * @return the txtXQDM
	 */
	public String getTxtXQDM() {
		return txtXQDM;
	}

	/**
	 * @param txtXQDM the txtXQDM to set
	 */
	public void setTxtXQDM(String txtXQDM) {
		this.txtXQDM = txtXQDM;
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

	/**
	 * @return the hidNsrmc
	 */
	public String getHidNsrmc() {
		return hidNsrmc;
	}

	/**
	 * @param hidNsrmc the hidNsrmc to set
	 */
	public void setHidNsrmc(String hidNsrmc) {
		this.hidNsrmc = hidNsrmc;
	}

	/**
	 * @return the forward
	 */
	public Boolean getForward() {
		return forward;
	}

	/**
	 * @param forward the forward to set
	 */
	public void setForward(Boolean forward) {
		this.forward = forward;
	}

	/**
	 * @return the txtBGSJ
	 */
	public String getTxtBGSJ() {
		return txtBGSJ;
	}

	/**
	 * @param txtBGSJ the txtBGSJ to set
	 */
	public void setTxtBGSJ(String txtBGSJ) {
		this.txtBGSJ = txtBGSJ;
	}

	/**
	 * @return the ddlBGLX
	 */
	public String getDdlBGLX() {
		return ddlBGLX;
	}

	/**
	 * @param ddlBGLX the ddlBGLX to set
	 */
	public void setDdlBGLX(String ddlBGLX) {
		this.ddlBGLX = ddlBGLX;
	}

	/**
	 * @return the sessionCtrl
	 */
	public SessionCtrl getSessionCtrl() {
		return sessionCtrl;
	}

	/**
	 * @param sessionCtrl the sessionCtrl to set
	 */
	public void setSessionCtrl(SessionCtrl sessionCtrl) {
		this.sessionCtrl = sessionCtrl;
	}

	/**
	 * @return the txtNSRMC
	 */
	public String getTxtNSRMC() {
		return txtNSRMC;
	}

	/**
	 * @param txtNSRMC the txtNSRMC to set
	 */
	public void setTxtNSRMC(String txtNSRMC) {
		this.txtNSRMC = txtNSRMC;
	}	

	/**
	 * @return the txtZZ
	 */
	public String getTxtZZ() {
		return txtZZ;
	}

	/**
	 * @param txtZZ the txtZZ to set
	 */
	public void setTxtZZ(String txtZZ) {
		this.txtZZ = txtZZ;
	}

	/**
	 * @return the txtLXDH
	 */
	public String getTxtLXDH() {
		return txtLXDH;
	}

	/**
	 * @param txtLXDH the txtLXDH to set
	 */
	public void setTxtLXDH(String txtLXDH) {
		this.txtLXDH = txtLXDH;
	}

	/**
	 * @return the txtYDDH
	 */
	public String getTxtYDDH() {
		return txtYDDH;
	}

	/**
	 * @param txtYDDH the txtYDDH to set
	 */
	public void setTxtYDDH(String txtYDDH) {
		this.txtYDDH = txtYDDH;
	}

	/**
	 * @return the txtNOTET00301
	 */
	public String getTxtNOTET00301() {
		return txtNOTET00301;
	}

	/**
	 * @param txtNOTET00301 the txtNOTET00301 to set
	 */
	public void setTxtNOTET00301(String txtNOTET00301) {
		this.txtNOTET00301 = txtNOTET00301;
	}

	/**
	 * @return the v00303Bean
	 */
	public Pgv00303 getV00303Bean() {
		return v00303Bean;
	}

	/**
	 * @param v00303Bean the v00303Bean to set
	 */
	public void setV00303Bean(Pgv00303 v00303Bean) {
		this.v00303Bean = v00303Bean;
	}

	/**
	 * @return the txtFCZH
	 */
	public String getTxtFCZH() {
		return txtFCZH;
	}

	/**
	 * @param txtFCZH the txtFCZH to set
	 */
	public void setTxtFCZH(String txtFCZH) {
		this.txtFCZH = txtFCZH;
	}

	/**
	 * @return the txtQDH
	 */
	public String getTxtQDH() {
		return txtQDH;
	}

	/**
	 * @param txtQDH the txtQDH to set
	 */
	public void setTxtQDH(String txtQDH) {
		this.txtQDH = txtQDH;
	}

	/**
	 * @return the txtCB
	 */
	public String getTxtCB() {
		return txtCB;
	}

	/**
	 * @param txtCB the txtCB to set
	 */
	public void setTxtCB(String txtCB) {
		this.txtCB = txtCB;
	}



	public String getTxtGHYTT() {
		return txtGHYTT;
	}

	public void setTxtGHYTT(String txtGHYTT) {
		this.txtGHYTT = txtGHYTT;
	}

	/**
	 * @return the txtHXJG
	 */
	public String getTxtHXJG() {
		return txtHXJG;
	}

	/**
	 * @param txtHXJG the txtHXJG to set
	 */
	public void setTxtHXJG(String txtHXJG) {
		this.txtHXJG = txtHXJG;
	}

	/**
	 * @return the txtJCSJ
	 */
	public String getTxtJCSJ() {
		return txtJCSJ;
	}

	/**
	 * @param txtJCSJ the txtJCSJ to set
	 */
	public void setTxtJCSJ(String txtJCSJ) {
		this.txtJCSJ = txtJCSJ;
	}

	/**
	 * @return the txtDJRQ
	 */
	public String getTxtDJRQ() {
		return txtDJRQ;
	}

	/**
	 * @param txtDJRQ the txtDJRQ to set
	 */
	public void setTxtDJRQ(String txtDJRQ) {
		this.txtDJRQ = txtDJRQ;
	}

	/**
	 * @return the txtJTZKId
	 */
	public String getTxtJTZKId() {
		return txtJTZKId;
	}

	/**
	 * @param txtJTZKId the txtJTZKId to set
	 */
	public void setTxtJTZKId(String txtJTZKId) {
		this.txtJTZKId = txtJTZKId;
	}

	/**
	 * @return the txtWYZKId
	 */
	public String getTxtWYZKId() {
		return txtWYZKId;
	}

	/**
	 * @param txtWYZKId the txtWYZKId to set
	 */
	public void setTxtWYZKId(String txtWYZKId) {
		this.txtWYZKId = txtWYZKId;
	}

	/**
	 * @return the txtZXZKId
	 */
	public String getTxtZXZKId() {
		return txtZXZKId;
	}

	/**
	 * @param txtZXZKId the txtZXZKId to set
	 */
	public void setTxtZXZKId(String txtZXZKId) {
		this.txtZXZKId = txtZXZKId;
	}

	/**
	 * @return the txtZCDZL
	 */
	public String getTxtZCDZL() {
		return txtZCDZL;
	}

	/**
	 * @param txtZCDZL the txtZCDZL to set
	 */
	public void setTxtZCDZL(String txtZCDZL) {
		this.txtZCDZL = txtZCDZL;
	}

	/**
	 * @return the txtZCDZBM
	 */
	public String getTxtZCDZBM() {
		return txtZCDZBM;
	}

	/**
	 * @param txtZCDZBM the txtZCDZBM to set
	 */
	public void setTxtZCDZBM(String txtZCDZBM) {
		this.txtZCDZBM = txtZCDZBM;
	}
	
	/**
	 * @return the txtJZMJ
	 */
	public String getTxtJZMJ() {
		return txtJZMJ;
	}

	/**
	 * @param txtJZMJ the txtJZMJ to set
	 */
	public void setTxtJZMJ(String txtJZMJ) {
		this.txtJZMJ = txtJZMJ;
	}

	/**
	 * @return the txtSZLC
	 */
	public String getTxtSZLC() {
		return txtSZLC;
	}

	/**
	 * @param txtSZLC the txtSZLC to set
	 */
	public void setTxtSZLC(String txtSZLC) {
		this.txtSZLC = txtSZLC;
	}

	/**
	 * @return the txtJYJG
	 */
	public String getTxtJYJG() {
		return txtJYJG;
	}

	/**
	 * @param txtJYJG the txtJYJG to set
	 */
	public void setTxtJYJG(String txtJYJG) {
		this.txtJYJG = txtJYJG;
	}

	/**
	 * @return the txtDTGJ
	 */
	public String getTxtDTGJ() {
		return txtDTGJ;
	}

	/**
	 * @param txtDTGJ the txtDTGJ to set
	 */
	public void setTxtDTGJ(String txtDTGJ) {
		this.txtDTGJ = txtDTGJ;
	}

	/**
	 * @return the txtTDSYQMJ
	 */
	public String getTxtTDSYQMJ() {
		return txtTDSYQMJ;
	}

	/**
	 * @param txtTDSYQMJ the txtTDSYQMJ to set
	 */
	public void setTxtTDSYQMJ(String txtTDSYQMJ) {
		this.txtTDSYQMJ = txtTDSYQMJ;
	}

	/**
	 * @return the txtRJL
	 */
	public String getTxtRJL() {
		return txtRJL;
	}

	/**
	 * @param txtRJL the txtRJL to set
	 */
	public void setTxtRJL(String txtRJL) {
		this.txtRJL = txtRJL;
	}

	/**
	 * @return the txtZLC
	 */
	public String getTxtZLC() {
		return txtZLC;
	}

	/**
	 * @param txtZLC the txtZLC to set
	 */
	public void setTxtZLC(String txtZLC) {
		this.txtZLC = txtZLC;
	}

	/**
	 * @return the sysDate
	 */
	public String getSysDate() {
		return SysDate;
	}

	/**
	 * @param sysDate the sysDate to set
	 */
	public void setSysDate(String sysDate) {
		SysDate = sysDate;
	}

	/**
	 * @return the hidPARENTDM
	 */
	public String getHidPARENTDM() {
		return hidPARENTDM;
	}

	/**
	 * @param hidPARENTDM the hidPARENTDM to set
	 */
	public void setHidPARENTDM(String hidPARENTDM) {
		this.hidPARENTDM = hidPARENTDM;
	}

	/**
	 * @return the hidXQZT
	 */
	public String getHidXQZT() {
		return hidXQZT;
	}

	/**
	 * @param hidXQZT the hidXQZT to set
	 */
	public void setHidXQZT(String hidXQZT) {
		this.hidXQZT = hidXQZT;
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
	 * @return the txtXJXQMC
	 */
	public String getTxtXJXQMC() {
		return txtXJXQMC;
	}

	/**
	 * @param txtXJXQMC the txtXJXQMC to set
	 */
	public void setTxtXJXQMC(String txtXJXQMC) {
		this.txtXJXQMC = txtXJXQMC;
	}

	/**
	 * @return the fROMCJ
	 */
	public Boolean getFROMCJ() {
		return FROMCJ;
	}

	/**
	 * @param fROMCJ the fROMCJ to set
	 */
	public void setFROMCJ(Boolean fROMCJ) {
		FROMCJ = fROMCJ;
	}

	/**
	 * @return the txtLH
	 */
	public String getTxtLH() {
		return txtLH;
	}

	/**
	 * @param txtLH the txtLH to set
	 */
	public void setTxtLH(String txtLH) {
		this.txtLH = txtLH;
	}

	/**
	 * @return the iSEXISTFCZH
	 */
	public Boolean getISEXISTFCZH() {
		return ISEXISTFCZH;
	}

	/**
	 * @param iSEXISTFCZH the iSEXISTFCZH to set
	 */
	public void setISEXISTFCZH(Boolean iSEXISTFCZH) {
		ISEXISTFCZH = iSEXISTFCZH;
	}

	/**
	 * @return the fCZH
	 */
	public String getFCZH() {
		return FCZH;
	}

	/**
	 * @param fCZH the fCZH to set
	 */
	public void setFCZH(String fCZH) {
		FCZH = fCZH;
	}

	/**
	 * @return the txtCLH
	 */
	public String getTxtCLH() {
		return txtCLH;
	}

	/**
	 * @param txtCLH the txtCLH to set
	 */
	public void setTxtCLH(String txtCLH) {
		this.txtCLH = txtCLH;
	}

	public String getRdoYWJKC() {
		return rdoYWJKC;
	}

	public void setRdoYWJKC(String rdoYWJKC) {
		this.rdoYWJKC = rdoYWJKC;
	}

	public void setHidZHXZid(String hidZHXZid) {
		this.hidZHXZid = hidZHXZid;
	}

	public String getHidZHXZid() {
		return hidZHXZid;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getFileServerPath() {
		return fileServerPath;
	}

	public void setFileServerPath(String fileServerPath) {
		this.fileServerPath = fileServerPath;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	@SuppressWarnings("deprecation")
	public String getSavePath() {
		return ServletActionContext.getRequest().getRealPath(savePath);
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getTxtFilePath() {
		return txtFilePath;
	}

	public void setTxtFilePath(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}



	public InputStream getExcelStream() {
		return excelStream;
	}

	public void setExcelStream(InputStream excelStream) {
		this.excelStream = excelStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ArrayList<Pgv00357> getPgv00357List() {
		return Pgv00357List;
	}

	public void setPgv00357List(ArrayList<Pgv00357> pgv00357List) {
		Pgv00357List = pgv00357List;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	/**
	 * @return the txtFCSLH
	 */
	public String getTxtFCSLH() {
		return txtFCSLH;
	}

	/**
	 * @param txtFCSLH the txtFCSLH to set
	 */
	public void setTxtFCSLH(String txtFCSLH) {
		this.txtFCSLH = txtFCSLH;
	}

	public void setXmlList(ArrayList<Pgt00352xml> xmlList) {
		this.xmlList = xmlList;
	}

	public ArrayList<Pgt00352xml> getXmlList() {
		return xmlList;
	}


	/**
	 * @return the t00352Bean
	 */
	public Pgt00352xml getT00352Bean() {
		return t00352Bean;
	}

	/**
	 * @param t00352Bean the t00352Bean to set
	 */
	public void setT00352Bean(Pgt00352xml t00352Bean) {
		this.t00352Bean = t00352Bean;
	}

	/**
	 * @return the tabList
	 */
	public ArrayList<Pgv00302> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv00302> tabList) {
		this.tabList = tabList;
	}

	/**
	 * @return the txtCSFZJLX
	 */
	public String getTxtCSFZJLX() {
		return txtCSFZJLX;
	}

	/**
	 * @param txtCSFZJLX the txtCSFZJLX to set
	 */
	public void setTxtCSFZJLX(String txtCSFZJLX) {
		this.txtCSFZJLX = txtCSFZJLX;
	}

	/**
	 * @return the txtCSFNSRMC
	 */
	public String getTxtCSFNSRMC() {
		return txtCSFNSRMC;
	}

	/**
	 * @param txtCSFNSRMC the txtCSFNSRMC to set
	 */
	public void setTxtCSFNSRMC(String txtCSFNSRMC) {
		this.txtCSFNSRMC = txtCSFNSRMC;
	}

	/**
	 * @return the txtCSFZJHM
	 */
	public String getTxtCSFZJHM() {
		return txtCSFZJHM;
	}

	/**
	 * @param txtCSFZJHM the txtCSFZJHM to set
	 */
	public void setTxtCSFZJHM(String txtCSFZJHM) {
		this.txtCSFZJHM = txtCSFZJHM;
	}

	public void setTxtZJHM(String txtZJHM) {
		this.txtZJHM = txtZJHM;
	}

	public String getTxtZJHM() {
		return txtZJHM;
	}

	public void setTxtZJLXId(String txtZJLXId) {
		this.txtZJLXId = txtZJLXId;
	}

	public String getTxtZJLXId() {
		return txtZJLXId;
	}

	public String getTxtOINSID() {
		return txtOINSID;
	}

	public void setTxtOINSID(String txtOINSID) {
		this.txtOINSID = txtOINSID;
	}

	public String getTxtYJG() {
		return txtYJG;
	}

	public void setTxtYJG(String txtYJG) {
		this.txtYJG = txtYJG;
	}

	public String getTxtSBPGJG() {
		return txtSBPGJG;
	}

	public void setTxtSBPGJG(String txtSBPGJG) {
		this.txtSBPGJG = txtSBPGJG;
	}

	public String getTxtROOMID() {
		return txtROOMID;
	}

	public void setTxtROOMID(String txtROOMID) {
		this.txtROOMID = txtROOMID;
	}

	/**
	 * @return the txtFCSLHFind
	 */
	public String getTxtFCSLHFind() {
		return txtFCSLHFind;
	}

	/**
	 * @param txtFCSLHFind the txtFCSLHFind to set
	 */
	public void setTxtFCSLHFind(String txtFCSLHFind) {
		this.txtFCSLHFind = txtFCSLHFind;
	}

	public String getTxtSFSYFC() {
		return txtSFSYFC;
	}

	public void setTxtSFSYFC(String txtSFSYFC) {
		this.txtSFSYFC = txtSFSYFC;
	}

	public String getRdoSFSYFC() {
		return rdoSFSYFC;
	}

	public void setRdoSFSYFC(String rdoSFSYFC) {
		this.rdoSFSYFC = rdoSFSYFC;
	}

	public String getTxtOwnRoomid() {
		return txtOwnRoomid;
	}

	public void setTxtOwnRoomid(String txtOwnRoomid) {
		this.txtOwnRoomid = txtOwnRoomid;
	}

	/**
	 * @return the txtDyh
	 */
	public String getTxtDyh() {
		return txtDyh;
	}

	/**
	 * @param txtDyh the txtDyh to set
	 */
	public void setTxtDyh(String txtDyh) {
		this.txtDyh = txtDyh;
	}

	/**
	 * @return the isPIC
	 */
//	public Integer getIsPIC() {
//		return isPIC;
//	}
//
//	/**
//	 * @param isPIC the isPIC to set
//	 */
//	public void setIsPIC(Integer isPIC) {
//		this.isPIC = isPIC;
//	}

	public String getFCIDD() {
		return FCIDD;
	}

	public void setFCIDD(String fCIDD) {
		FCIDD = fCIDD;
	}

	public String getHidFlag() {
		return hidFlag;
	}

	public void setHidFlag(String hidFlag) {
		this.hidFlag = hidFlag;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		sessionCtrl = new SessionCtrl(session);
	}








	/**
	 * @return the formA
	 */
	public boolean isFormA() {
		return FormA;
	}








	/**
	 * @param formA the formA to set
	 */
	public void setFormA(boolean formA) {
		FormA = formA;
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
	 * @return the isExistQmpg
	 */
	public Integer getIsExistQmpg() {
		return isExistQmpg;
	}








	/**
	 * @param isExistQmpg the isExistQmpg to set
	 */
	public void setIsExistQmpg(Integer isExistQmpg) {
		this.isExistQmpg = isExistQmpg;
	}

	/**
	 * @return the isExistZT
	 */
	public boolean isExistZT() {
		return isExistZT;
	}


	/**
	 * @param isExistZT the isExistZT to set
	 */
	public void setExistZT(boolean isExistZT) {
		this.isExistZT = isExistZT;
	}


	/**
	 * @return the isClocktZT
	 */
	public Integer getIsClocktZT() {
		return isClocktZT;
	}

	/**
	 * @param isClocktZT the isClocktZT to set
	 */
	public void setIsClocktZT(Integer isClocktZT) {
		this.isClocktZT = isClocktZT;
	}

	/**
	 * @return the sZQYDM
	 */
	public String getSZQYDM() {
		return SZQYDM;
	}








	/**
	 * @param sZQYDM the sZQYDM to set
	 */
	public void setSZQYDM(String sZQYDM) {
		SZQYDM = sZQYDM;
	}








	/**
	 * @return the txtCSFLXDH
	 */
	public String getTxtCSFLXDH() {
		return txtCSFLXDH;
	}








	/**
	 * @param txtCSFLXDH the txtCSFLXDH to set
	 */
	public void setTxtCSFLXDH(String txtCSFLXDH) {
		this.txtCSFLXDH = txtCSFLXDH;
	}

	/**
	 * @return the txtWSRQ
	 */
	public String getTxtWSRQ() {
		return txtWSRQ;
	}

	/**
	 * @param txtWSRQ the txtWSRQ to set
	 */
	public void setTxtWSRQ(String txtWSRQ) {
		this.txtWSRQ = txtWSRQ;
	}

	/**
	 * @return the txtWSJS
	 */
	public String getTxtWSJS() {
		return txtWSJS;
	}

	/**
	 * @param txtWSJS the txtWSJS to set
	 */
	public void setTxtWSJS(String txtWSJS) {
		this.txtWSJS = txtWSJS;
	}

	public String getTxtMFGJDM() {
		return txtMFGJDM;
	}

	public void setTxtMFGJDM(String txtMFGJDM) {
		this.txtMFGJDM = txtMFGJDM;
	}

	public String getTxtGMFGJDM() {
		return txtGMFGJDM;
	}

	public void setTxtGMFGJDM(String txtGMFGJDM) {
		this.txtGMFGJDM = txtGMFGJDM;
	}

	/**
	 * @return the txtZRFSBH
	 */
	public String getTxtZRFSBH() {
		return txtZRFSBH;
	}

	/**
	 * @param txtZRFSBH the txtZRFSBH to set
	 */
	public void setTxtZRFSBH(String txtZRFSBH) {
		this.txtZRFSBH = txtZRFSBH;
	}

	/**
	 * @return the txtCSFSBH
	 */
	public String getTxtCSFSBH() {
		return txtCSFSBH;
	}

	/**
	 * @param txtCSFSBH the txtCSFSBH to set
	 */
	public void setTxtCSFSBH(String txtCSFSBH) {
		this.txtCSFSBH = txtCSFSBH;
	}

	/**
	 * @return the rdoZRFNSRLX
	 */
	public String getRdoZRFNSRLX() {
		return rdoZRFNSRLX;
	}

	/**
	 * @param rdoZRFNSRLX the rdoZRFNSRLX to set
	 */
	public void setRdoZRFNSRLX(String rdoZRFNSRLX) {
		this.rdoZRFNSRLX = rdoZRFNSRLX;
	}

	/**
	 * @return the rdoCSFNSRLX
	 */
	public String getRdoCSFNSRLX() {
		return rdoCSFNSRLX;
	}

	/**
	 * @param rdoCSFNSRLX the rdoCSFNSRLX to set
	 */
	public void setRdoCSFNSRLX(String rdoCSFNSRLX) {
		this.rdoCSFNSRLX = rdoCSFNSRLX;
	}

	/**
	 * @return the txtHTBH
	 */
	public String getTxtHTBH() {
		return txtHTBH;
	}

	/**
	 * @param txtHTBH the txtHTBH to set
	 */
	public void setTxtHTBH(String txtHTBH) {
		this.txtHTBH = txtHTBH;
	}









}
