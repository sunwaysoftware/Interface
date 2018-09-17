package com.sunway.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt00301Service;
import com.sunway.util.CheckUtil;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.ConvertUtil;
import com.sunway.util.FormatUtil;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt00301;
import com.sunway.vo.Pgv00301;

/**
 * 
 * 市场法登记信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt00301Action extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 7713871382384620265L;
	private IPgt00301Service t00301Service;
	private String ACT;
	// VIEW
	private Integer pageIndex;
	private Integer pageSize;
	private Integer total;
	private ArrayList<Pgv00301> rows;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	// EDIT
	private Pgt00301 t00301Bean;
	private String txtUPDATE;
	private String txtSWID;
	private String txtNSRMC;
	private String txtZJLXId;
	private String txtZZ;
	private String txtLXDH;
	private String txtYDDH;
	private String txtSSGXId;
	private String txtNOTE;
	// Detail
	private String SWID;
	private Pgv00301 v00301Bean;
	// 自动完成
	private String ZZ;
	private ArrayList<String> dataList;
	// 跳转国土标示
	private Boolean forward;
	// 纳税人信息
	private String userId;
	private InputStream userName;
	// 变更
	private String txtBGSJ;
	private String txtSWIDOLD;
	private String ddlBGLX;
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
	 * @return
	 * @throws Exception
	 */
	public String query() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("query() ********** start **********");
		}

		Pgv00301 v00301 = new Pgv00301();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v00301.setSwid(FormatUtil.toSearchLike(txtSWIDFind));
			v00301.setNsrmc(FormatUtil.toSearchLike(txtNSRMCFind));
			v00301.setPageIndex(pageIndex);
			v00301.setPageSize(getPageSize());
			v00301.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			v00301.setPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			//执行查询
			rows = t00301Service.LoadAll(v00301);
			//分页设置
			if(null!=rows && rows.size()>0){
				total = CheckUtil.chkNull(rows.get(0).getRecordCount());
			} else {
				total = 0;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
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

		Pgt00301 t00301 = new Pgt00301();
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//读取选中的数据信息
				t00301.setSwid(txtSWIDFind);
				t00301Bean = t00301Service.LoadByPrimaryKey(t00301);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
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
	 * 更新操作前的驗證處理
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}
		//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
		t00301Bean = new Pgt00301();
		this.clearErrorsAndMessages();
		if(Constant.MOD_UPDATE.equals(ACT))
			t00301Bean.setSwid(txtSWIDOLD);
		else
			t00301Bean.setSwid(txtSWID);
		//根據PK取得信息，並為數據BEAN賦值
		if (!Constant.MOD_DELETE.equals(getACT())) {
			t00301Bean = t00301Service.LoadByPrimaryKey(t00301Bean);
		}
		// 判断PK是否重复
		if ((Constant.MOD_CREATE.equals(getACT()))
				&& (!CheckUtil.chkEmpty(t00301Bean.getSwid()))) {
			this.addActionError(getText("app.msg.error.pk", new String[] { getText("app.sjcj.t00301.swid") }));
			forward = null;
		}
		//判读数据是否已经被其他用户修改
		if ((Constant.MOD_UPDATE.equals(getACT()))
				&& (!t00301Bean.getUpddate().equals(
						ConvertUtil.toTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		} else {
			t00301Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t00301Bean.setCd00001Zjlx(txtZJLXId);
			t00301Bean.setCd00002Czr(sessionCtrl.getUserId());
			t00301Bean.setLxdh(txtLXDH);
			t00301Bean.setNote(txtNOTE);
			t00301Bean.setNsrmc(txtNSRMC);
			t00301Bean.setSwid(txtSWID);
			t00301Bean.setYddh(txtYDDH);
			t00301Bean.setZz(txtZZ);
			t00301Bean.setPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			t00301Bean.setSwidOld(txtSWIDOLD);
			
			t00301Bean.setBgsj(new Date());
			t00301Bean.setBglx(0);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 * 更新、删除状态处理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** start **********");
		}
		String rtn = SUCCESS;
		try {
			if (Constant.MOD_CREATE.equals(getACT())) { // Create
				if (t00301Service.GetInsertCommand(t00301Bean)) {
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[] { t00301Bean.getSwid() }));
					if (CheckUtil.chkNull(forward)) SWID = t00301Bean.getSwid();
					t00301Bean.clear();
				} else{
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[] { t00301Bean.getSwid() }));
				}
			} else if (Constant.MOD_UPDATE.equals(getACT())) { // Update
				if (t00301Service.GetUpdateCommand(t00301Bean)) {
					t00301Bean = t00301Service.LoadByPrimaryKey(t00301Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[] { t00301Bean.getSwid() }));
				} else {
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[] { t00301Bean.getSwid() }));
				}
			} else if (Constant.MOD_DELETE.equals(getACT())) { // Delete
				if (t00301Service.GetDeleteCommand(t00301Bean)) {
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[] { t00301Bean.getSwid() }));
					rtn = "successDEL";
					ACT = Constant.MOD_MODIFY;
				} else {
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[] { t00301Bean.getSwid() }));
				}
			}			
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		return rtn;
	}	

	/**
	 * 市场法登记详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00301 v00301 = new Pgv00301();
		v00301Bean = new Pgv00301();
		try {
			// 准备查询条件
			v00301.setSwid(ConvertUtil.encoding(SWID));
			// 执行查询
			v00301Bean = t00301Service.LoadDetail(v00301);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}

	
	/**
	 * 市场法登记详细信息
	 * @return
	 * @throws Exception
	 */
	public String detailB() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv00301 v00301 = new Pgv00301();
		v00301Bean = new Pgv00301();
		try {
			// 准备查询条件
			v00301.setSwid(ConvertUtil.encoding(SWID));
			// 执行查询
			v00301Bean = t00301Service.LoadDetail_B(v00301);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** end **********");
		}
		return SUCCESS;
	}

	
	
	/**
	 * 根据企业ID得到该企业一共有多少个土地。多少个房子。多少个明细。
	 * @return
	 * @throws Exception
	 */
	public String queryCount() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryCount() ********** start **********");
		}
		
		Pgt00301 t00301 = new Pgt00301(); 
		try {
			t00301.setSwid(ConvertUtil.encoding(txtSWID));
			t00301Bean = t00301Service.LoadCount(t00301);
		} catch (Exception e) {
			LOG.error("queryCount()", e);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryCount() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 自动完成住址
	 * @return
	 * @throws Exception
	 */
	public String queryZzdat() throws Exception {
		Pgv00301 v00301 = new Pgv00301();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			// 准备查询条件
			v00301.setZz(ConvertUtil.encoding(ZZ) + Constant.STRING_PERCENT);
			v00301.setPageIndex(ConvertUtil.toInteger(Constant.PAGE_FIRST));
			v00301.setPageSize(getPageSize());
			v00301.setSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			// 执行查询
			dataList = t00301Service.GetZz(v00301);
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 取得登记信息
	 */
	public String t00301BySwid() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("t00301BySwid() ********** start **********");
		}
		try {
			t00301Bean = t00301Service.LoadByPrimaryKey(new Pgt00301(SWID));
			if(t00301Bean.getCd00001Zjlx()==null){
				t00301Bean.setCd00001Zjlx(Constant.STRING_EMPTY);
				t00301Bean.setZjlx(Constant.STRING_EMPTY);
			}
			if(t00301Bean.getZz()==null){
				t00301Bean.setZz(Constant.STRING_EMPTY);
			}
			if(t00301Bean.getLxdh()==null){
				t00301Bean.setLxdh(Constant.STRING_EMPTY);
			}
			if(t00301Bean.getYddh()==null){
				t00301Bean.setYddh(Constant.STRING_EMPTY);
			}
			if(t00301Bean.getNote()==null){
				t00301Bean.setNote(Constant.STRING_EMPTY);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("t00301BySwid() ********** end **********");
		}
		return SUCCESS;
	}

	/******************************** set and get **************************************/
	
	/**
	 * @param aCT the aCT to set
	 */
	public void setACT(String aCT) {
		ACT = aCT;
	}

	/**
	 * @return the aCT
	 */
	public String getACT() {
		return ACT;
	}

	/**
	 * @param t00301Service the t00301Service to set
	 */
	public void setT00301Service(IPgt00301Service t00301Service) {
		this.t00301Service = t00301Service;
	}

	/**
	 * @return the t00301Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt00301Service getT00301Service() {
		return t00301Service;
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
	 * @return the rows
	 */
	public ArrayList<Pgv00301> getRows() {
		return rows;
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(ArrayList<Pgv00301> rows) {
		this.rows = rows;
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
	 * @param t00301Bean the t00301Bean to set
	 */
	public void setT00301Bean(Pgt00301 t00301Bean) {
		this.t00301Bean = t00301Bean;
	}

	/**
	 * @return the t00301Bean
	 */
	public Pgt00301 getT00301Bean() {
		return t00301Bean;
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
	 * @return the txtZJLXId
	 */
	public String getTxtZJLXId() {
		return txtZJLXId;
	}

	/**
	 * @param txtZJLXId the txtZJLXId to set
	 */
	public void setTxtZJLXId(String txtZJLXId) {
		this.txtZJLXId = txtZJLXId;
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
	 * @return the txtSSGXId
	 */
	public String getTxtSSGXId() {
		return txtSSGXId;
	}

	/**
	 * @param txtSSGXId the txtSSGXId to set
	 */
	public void setTxtSSGXId(String txtSSGXId) {
		this.txtSSGXId = txtSSGXId;
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
	 * @return the v00301Bean
	 */
	public Pgv00301 getV00301Bean() {
		return v00301Bean;
	}
	/**
	 * @param v00301Bean the v00301Bean to set
	 */
	public void setV00301Bean(Pgv00301 v00301Bean) {
		this.v00301Bean = v00301Bean;
	}
	/**
	 * @return the zZ
	 */
	public String getZZ() {
		return ZZ;
	}
	/**
	 * @param zZ the zZ to set
	 */
	public void setZZ(String zZ) {
		ZZ = zZ;
	}
	/**
	 * @return the dataList
	 */
	public ArrayList<String> getDataList() {
		return dataList;
	}
	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(ArrayList<String> dataList) {
		this.dataList = dataList;
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public InputStream getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(InputStream userName) {
		this.userName = userName;
	}

	/**
	 * @param ddlBGLX the ddlBGLX to set
	 */
	public void setDdlBGLX(String ddlBGLX) {
		this.ddlBGLX = ddlBGLX;
	}

	/**
	 * @return the ddlBGLX
	 */
	public String getDdlBGLX() {
		return ddlBGLX;
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
	 * @return the txtSWIDOLD
	 */
	public String getTxtSWIDOLD() {
		return txtSWIDOLD;
	}

	/**
	 * @param txtSWIDOLD the txtSWIDOLD to set
	 */
	public void setTxtSWIDOLD(String txtSWIDOLD) {
		this.txtSWIDOLD = txtSWIDOLD;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageSize() {
		return Common.getPageSize(pageSize);
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}
}
