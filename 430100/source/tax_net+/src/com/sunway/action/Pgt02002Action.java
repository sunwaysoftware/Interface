package com.sunway.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt02002Service;
import com.sunway.service.IPgt02002cService;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.MakeUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt02002;
import com.sunway.vo.Pgt02052xml;
import com.sunway.vo.Pgv00052;
import com.sunway.vo.Pgv02002;
import com.sunway.vo.Pgv02002c;

/**
 * 非住宅房地产信息（PGT00202）
 * 
 * @author Andy.Gao
 * @version 1.0
 */

public class Pgt02002Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 6531280519525243009L;
	// Service
	private IPgt02002Service t02002Service;
	private IPgt02002cService t02002cService;
	// View
	private ArrayList<Pgv00052> szqyList;
	private ArrayList<Pgv02002c> qtxzList;
	// 分页参数
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	// Bean数组
	private ArrayList<Pgv02002> rows;
	private ArrayList<Pgt02052xml> xmlList;
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
	private Pgv02002 v02002Bean;
	private Pgt02052xml t02052Bean;
	private String SWID;
	// edit页面所需Bean
	private Pgt02002 bean;

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
	private String txtNOTET02002;
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
	private String txtMK;
	private String txtJS;
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
	private String txtFCID_A;
	
	private Boolean FROMCJ;//采集标识
	
	private String FCZH;
	private Boolean ISEXISTFCZH;
	private String txtCLH;
	private String hidZHXZid;
	
	//file import
	private String txtFilePath;
	private InputStream excelStream;
	private String fileName;
	private String txtFCSLH;   //国土受理号    
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
	private String SZQYDM;
	private String rdoZRFNSRLX;
	private String rdoCSFNSRLX;
	private String txtHTQDSJ;
	private String FCID20;
	
	/*
	 * (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** start **********");
		}
		try {
			ReadInfo();
			if (Constant.MOD_DELETE.equals(ACT)) { // Delete
				ACT = Constant.MOD_MODIFY;
			}
		} catch (Exception e) {
			LOG.error("Pgt02002Action -- execute()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("execute() ********** end **********");
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
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		Pgv02002 v02002 = new Pgv02002();
		try {
			// 准备查询条件
			v02002.setFcid(FormatUtil.toSearchLike(CheckUtil.chkTrim(txtFCIDFind)));
			v02002.setZjhm(FormatUtil.toSearchLike(CheckUtil.chkTrim(txtSWIDFind)));
			v02002.setNsrmc(FormatUtil.toSearchLike(CheckUtil.chkTrim(txtNSRMCFind)));
			v02002.setCd00001Szqy(ddlSZQYFind);
			v02002.setCd02050Xqdm(CheckUtil.chkTrim(txtXQFind));
			v02002.setFcslh(CheckUtil.chkTrim(txtFCSLHFind));
			v02002.setFwtdzl(FormatUtil.toSearchLike(CheckUtil.chkTrim(txtFWTDZLFind)));
			v02002.setPageIndex(pageIndex);
			v02002.setPageSize(getPageSize());
			v02002.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v02002.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			// 执行查询
			v02002Bean = t02002Service.LoadAll(v02002);
			rows = v02002Bean.getV02002List();
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				pageIndex = 1;total = 0;
			}
			ReadInfo();
		} catch (Exception e) {
			LOG.error("Pgt02002Action -- query()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 查询状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryE() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		Pgv02002 v02002 = new Pgv02002();
		try {
			// 准备查询条件
			v02002.setFcid(CheckUtil.chkTrim(FCID));			
			// 执行查询
			rows = t02002Service.LoadAllE(v02002);
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				pageIndex = 1;total = 0;
			}
		} catch (Exception e) {
			LOG.error("Pgt02002Action -- query()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 查询状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryE_B() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		Pgv02002 v02002 = new Pgv02002();
		try {
			// 准备查询条件
			v02002.setFcid(CheckUtil.chkTrim(FCID));			
			// 执行查询
			rows = t02002Service.LoadAllE_B(v02002);
			// 分页设置
			if (null != rows && rows.size() > 0) {
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				pageIndex = 1;total = 0;
			}
		} catch (Exception e) {
			LOG.error("Pgt02002Action -- query()", e);
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
	public String create() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		String rtn = "successADD";		
		v02002Bean = new Pgv02002();
		try {
			if (!Constant.MOD_CREATE.equals(getACT())) {
				Pgt02002 t02002 = new Pgt02002();
				bean = new Pgt02002();
				// 取得用户选中的数据信息
				t02002.setFcid(FCID);
				bean = t02002Service.LoadByPrimaryKey(t02002);
				//添加多纳税人到临时表
				t02002Service.GetInsertCommandBySFZ(t02002);
				bean.setId(FCID);
				rtn = "success";
			} else {		
				//isPIC=0;
				SysDate = MakeUtil.currentDate();
				v02002Bean.setId(MakeUtil.UUID());
			}
		
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt02002Action -- create()", e);
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return ERROR;
		}finally{
			FROMCJ = true;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		return rtn;
	} 

	/**
	 * 更新操作前的验证处理
	 * 
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}

		bean = new Pgt02002();
		this.clearErrorsAndMessages();
		if(isExistQmpg==null){
			isExistQmpg=0;
		}		
		
		bean.setFcid(FCID);
	
		//根据PK取得信息，并为BEAN赋值
		if (Constant.MOD_UPDATE.equals(getACT())) {
			bean = t02002Service.LoadByPrimaryKey(bean);
		}
		// 判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!bean.getUpddate().equals(
						ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			bean.setFcid(FCID);
			bean.setCd00001Fwlx(txtFWLX);
			bean.setCd00001Jylx(txtJYLX);
			bean.setCd00001Jzjg(txtJZJGT);
			bean.setJzmj(ConvertUtil.toBigDecimal(txtJZMJ));
			bean.setSzlc(CheckUtil.chkTrim(txtSZLC));
			bean.setBwjfh(CheckUtil.chkTrim(txtBWJFH));
			bean.setJyjg(ConvertUtil.toBigDecimal(txtJYJG));
			bean.setDtgj(ConvertUtil.toDouble(txtDTGJ));
			bean.setTdsyqmj(ConvertUtil.toDouble(txtTDSYQMJ));
			bean.setRjl(ConvertUtil.toDouble(txtRJL));
			bean.setJysj(ConvertUtil.toTimestamp(txtJYSJ));
			bean.setFdcdat(txtFDCDAT);
			bean.setCd00002Czr(sessionCtrl.Get(SessionCtrl.SESSION_KEY_USERID));
			bean.setCd02050Xqdm(txtXQDM);
			bean.setCd00001Jzjg1(txtJZJG);
			bean.setYwdt(ConvertUtil.toBoolean(rdoYWDT));
			//bean.setYwjkc(ConvertUtil.toBoolean(rdoYWJKC));
			bean.setZlc(ConvertUtil.toShort(txtZLC));
			bean.setFwtdzl(CheckUtil.chkTrim(FWTDZL));
			bean.setNote1(txtNOTE);
			bean.setZhxz(hidZHXZid);
			bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			bean.setCd00002Pssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			bean.setNsrmc(txtNSRMC);
			bean.setCd00001Zjlx(txtZJLXId);
			bean.setZz(txtZZ);
			bean.setLxdh(txtLXDH);
			bean.setNote2(txtNOTET00301);
			bean.setFczh(txtFCZH);
			bean.setQdh(txtQDH);
			bean.setCb(txtCB);
			bean.setGhyt(txtGHYTT);
			bean.setHxjg(txtHXJG);
			bean.setHtqdsj(ConvertUtil.toUtilDate(txtHTQDSJ));
			bean.setDjrq(ConvertUtil.toUtilDate(txtDJRQ));
			bean.setCd00001Jtzk(txtJTZKId);
			bean.setCd00001Wyzk(txtWYZKId);
			bean.setCd00001Zxzk(txtZXZKId);
			bean.setZcdzl(txtZCDZL);
			bean.setZcdzbm(txtZCDZL);	
			bean.setMk(ConvertUtil.toDouble(txtMK));
			bean.setJs(ConvertUtil.toDouble(txtJS));
			bean.setCd02050Xqzt(CheckUtil.chkEmpty(hidXQZT)?ConvertUtil.toByte("1"):ConvertUtil.toByte(hidXQZT));			
			bean.setCd00001Szqy(ddlSZQY);
			bean.setCd02050Parentdm(hidPARENTDM);
			bean.setClh(txtCLH);
			bean.setNote(txtNOTE);
		    bean.setCsfzjlx(txtCSFZJLX);  
		    bean.setCsfnsrmc(txtCSFNSRMC);
		    bean.setCsfzjhm(txtCSFZJHM);
		    bean.setCsflxdh(txtCSFLXDH);
		    bean.setFcslh(txtFCSLH);
		    bean.setOinsid(ConvertUtil.toInteger(txtOINSID));
		    bean.setYjg(ConvertUtil.toDouble(txtYJG));
		    bean.setSbpgjg(ConvertUtil.toDouble(txtSBPGJG));
		    bean.setRoomid(txtROOMID);
		    bean.setSfsyfc(ConvertUtil.toInteger(rdoSFSYFC));
		    bean.setOwnRoomid(txtOwnRoomid);
			bean.setHtbh(txtHTBH);
		    
			//让变更默认
			bean.setBgsj(new Date());
			bean.setBglx(ConvertUtil.toInteger(ddlBGLX));
			
			bean.setLh(txtLH);
			bean.setDyh(txtDyh);
			bean.setJcsj(txtJCSJ);
			bean.setWsjs(ConvertUtil.toDouble(txtWSJS));
			bean.setWsrq(ConvertUtil.toUtilDate(txtWSRQ));
			bean.setCd00001Mfgjdm(txtMFGJDM);
			bean.setCd00001Gmfgjdm(txtGMFGJDM);
			bean.setSbh_zr(txtZRFSBH);
			bean.setSbh_cs(txtCSFSBH);
			bean.setNsrLx_cs(ConvertUtil.toInteger(rdoCSFNSRLX));
			bean.setNsrLx_zr(ConvertUtil.toInteger(rdoZRFNSRLX));
			bean.setId(txtFCID_A);
			bean.setCd02020Fcid(FCID20);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	
	/**
	 * 查询状态处理
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryZhxz() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		try {
			Pgv02002c v02002c = new Pgv02002c();
			v02002c.setCd02002Fcid(FCID);
			v02002c.setCd00001Szqy(ddlSZQY);
			v02002c.setCd00001Fwlx(txtFWLX);
			qtxzList = t02002cService.LoadAll(v02002c);
		} catch (Exception e) {
			LOG.error("Pgt02002Action -- queryZhxz()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
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
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}
		
		try {
			Pgv02002c v02002c = new Pgv02002c();
			v02002c.setCd02002Fcid(FCID);
			v02002c.setCd00001Szqy(ddlSZQY);
			v02002c.setCd00001Fwlx(txtFWLX);
			qtxzList = t02002cService.LoadAllQM(v02002c);
		} catch (Exception e) {
			LOG.error("Pgt02002Action -- queryZhxzQmpg()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** end **********");
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
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}
		String rtn = SUCCESS;
		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if(ISEXISTFCZH){
					this.addActionError("国土证号已经存在，请不要录入重复数据！");
					return "failADD";
				}
				bean.setZjhm(txtZJHM);
				if (t02002Service.GetInsertCommand(bean)) {
					SWID = ConvertUtil.encoding(bean.getZjhm());
					FCIDD = ConvertUtil.encoding(bean.getFcid());
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] {bean.getFczh()}));
					bean = new Pgt02002();
				} else {
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] {bean.getFczh()}));
				}
				v02002Bean = new Pgv02002();
				v02002Bean.setId(MakeUtil.UUID());
				rtn = "successADD";
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t02002Service.GetUpdateCommand(bean)) {
					bean = t02002Service.LoadByPrimaryKey(bean);
					//添加多纳税人到临时表
					t02002Service.GetInsertCommandBySFZ(bean);
					bean.setId(bean.getFcid());
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { bean.getFczh() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { bean.getFczh() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t02002Service.GetDeleteCommand(bean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK));
					ACT = Constant.MOD_MODIFY;
					rtn = "successDEL";
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG));
				}
			}
			ReadInfo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt02002Action -- update()", e);
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}finally{
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		return rtn;
	}

	/**
	 * 市场法国土详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv02002 v02002 = new Pgv02002();
		v02002Bean = new Pgv02002();
		try {
			// 准备查询条件
			v02002.setFcid(CheckUtil.chkTrim(FCID));
			// 执行查询
			v02002Bean = t02002Service.LoadDetail(v02002);
		} catch (Exception e) {
			LOG.error("Pgt02002Action -- detail()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 市场法国土详细信息
	 * @return
	 * @throws Exception
	 */
	public String detailB() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv02002 v02002 = new Pgv02002();
		v02002Bean = new Pgv02002();
		try {
			// 准备查询条件
			v02002.setFcid(CheckUtil.chkTrim(FCID));
			// 执行查询
			v02002Bean = t02002Service.LoadDetail_B(v02002);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt02002Action -- detailB()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 市场法国土详细信息（框架）
	 * @return
	 * @throws Exception
	 */
	public String detailFrame() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detailFrame() ********** start **********");
		}
		v02002Bean = new Pgv02002();
		try {
			v02002Bean.setFcid(CheckUtil.chkTrim(FCID));
			v02002Bean.setZjhm(CheckUtil.chkTrim(SWID));
		} catch (Exception e) {
			LOG.error("Pgt02002Action -- detailFrame()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detailFrame() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 判断房地产档案图是否已经存在
	 * @return
	 * @throws Exception
	 */
	public String queryFDCDAT() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryFDCDAT() ********** start **********");
		}
		Pgt02002 t02002 = new Pgt02002();
		try {
			t02002.setFcid(ConvertUtil.encoding(FCID));
			t02002.setFdcdat(ConvertUtil.encoding(txtFDCDAT));
			forward = t02002Service.GetFdcdatByFcid(t02002);
		} catch (Exception e) {
			LOG.error("Pgt02002Action -- queryFDCDAT()", e);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryFDCDAT() ********** end **********");
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
		if (LOG.isDebugEnabled()) {
			LOG.debug("isExistFczh() ********** start **********");
		}
		try {
			Pgt02002 t02002 = new Pgt02002();
			t02002.setFczh(ConvertUtil.encoding(FCZH));
//			t02002.setFczh(FCZH);
			v02002Bean = t02002Service.LoadByFczh(t02002);
			ISEXISTFCZH = CheckUtil.chkEmpty(v02002Bean.getFcid())?false:true;
			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			LOG.error("Pgt02002Action -- isExistFczh()", e);
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("isExistFczh() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** webservice数据操作******************************/

	/*********************** 采集数据导入 ******************************/
	public String executeImport() throws Exception{
		if(LOG.isDebugEnabled()){
			LOG.debug("executeImport() ********** start **********");
		}
		
		
		if(LOG.isDebugEnabled()){
			LOG.debug("executeImport() ********** end **********");
		}
		return SUCCESS;
	}

	/*********************** setter and getter ******************************/

	/**
	 * @return the t02002Service
	 */
	@JSON(deserialize = false, serialize = false)
	public IPgt02002Service getT02002Service() {
		return t02002Service;
	}
	/**
	 * @param t02002Service the t02002Service to set
	 */
	public void setT02002Service(IPgt02002Service t02002Service) {
		this.t02002Service = t02002Service;
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
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
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
	 * @return the v02002Bean
	 */
	public Pgv02002 getV02002Bean() {
		return v02002Bean;
	}

	/**
	 * @param v02002Bean the v02002Bean to set
	 */
	public void setV02002Bean(Pgv02002 v02002Bean) {
		this.v02002Bean = v02002Bean;
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
	 * @return the txtNOTET02002
	 */
	public String getTxtNOTET02002() {
		return txtNOTET02002;
	}

	/**
	 * @param txtNOTET02002 the txtNOTET02002 to set
	 */
	public void setTxtNOTET02002(String txtNOTET02002) {
		this.txtNOTET02002 = txtNOTET02002;
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

	/**
	 * @return the rows
	 */
	public ArrayList<Pgv02002> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv02002> rows) {
		this.rows = rows;
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
	 * @return the txtHTQDSJ
	 */
	public String getTxtHTQDSJ() {
		return txtHTQDSJ;
	}

	/**
	 * @param txtHTQDSJ the txtHTQDSJ to set
	 */
	public void setTxtHTQDSJ(String txtHTQDSJ) {
		this.txtHTQDSJ = txtHTQDSJ;
	}	

	/**
	 * @return the t02002cService
	 */
	@JSON(serialize=false, deserialize=false)
	public IPgt02002cService getT02002cService() {
		return t02002cService;
	}

	/**
	 * @param t02002cService the t02002cService to set
	 */
	public void setT02002cService(IPgt02002cService t02002cService) {
		this.t02002cService = t02002cService;
	}

	/**
	 * @return the qtxzList
	 */
	public ArrayList<Pgv02002c> getQtxzList() {
		return qtxzList;
	}

	/**
	 * @param qtxzList the qtxzList to set
	 */
	public void setQtxzList(ArrayList<Pgv02002c> qtxzList) {
		this.qtxzList = qtxzList;
	}

	/**
	 * @return the xmlList
	 */
	public ArrayList<Pgt02052xml> getXmlList() {
		return xmlList;
	}

	/**
	 * @param xmlList the xmlList to set
	 */
	public void setXmlList(ArrayList<Pgt02052xml> xmlList) {
		this.xmlList = xmlList;
	}

	/**
	 * @return the t02052Bean
	 */
	public Pgt02052xml getT02052Bean() {
		return t02052Bean;
	}

	/**
	 * @param t02052Bean the t02052Bean to set
	 */
	public void setT02052Bean(Pgt02052xml t02052Bean) {
		this.t02052Bean = t02052Bean;
	}
	

	public String getTxtMK() {
		return txtMK;
	}

	public void setTxtMK(String txtMK) {
		this.txtMK = txtMK;
	}

	public String getTxtJS() {
		return txtJS;
	}

	public void setTxtJS(String txtJS) {
		this.txtJS = txtJS;
	}

	public String getTxtFCID_A() {
		return txtFCID_A;
	}

	public void setTxtFCID_A(String txtFCID_A) {
		this.txtFCID_A = txtFCID_A;
	}

	public String getFCID20() {
		return FCID20;
	}

	public void setFCID20(String fCID20) {
		FCID20 = fCID20;
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

	public Pgt02002 getBean() {
		return bean;
	}

	public void setBean(Pgt02002 bean) {
		this.bean = bean;
	}

	

}
