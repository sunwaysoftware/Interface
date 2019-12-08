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
import com.sunway.service.IPgt12001Service;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12001;
import com.sunway.vo.Pgv12001;

/**
 * 
 * 成本、收益法登记信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12001Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 6391825957087170123L;
	private IPgt12001Service t12001Service;
	private String ACT;
	
	// VIEW
	private Pgv12001 v12001Bean;
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	private ArrayList<Pgv12001> tabList;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtBHFind;
	
	// EDIT
	private Pgt12001 t12001Bean;
	private String txtSWID;
	private String txtNSRMC;
	private String txtLXDH;
	private String txtZGY;
	private String txtHYId;
	private String txtJJLXId;
	private String txtZYYWSR;
	private String txtLRZE;
	private String txtFCSE;
	private String txtTDSE;
	private String txtMSSZId;
	private String txtBH;
	private String txtXZId;
	private String txtSSJCId;
	private String txtNOTE;
	private String txtUPDATE;
	// Detail
	private String SWID;
	// 跳轉地產標識
	private Boolean forward;
	// 變更日期
	private String txtBGSJ;
	private String txtSWIDOLD;
	private String ddlBGLX;
	private SessionCtrl sessionCtrl = new SessionCtrl();
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
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

		Pgv12001 v12001 = new Pgv12001();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v12001.setSwid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12001.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12001.setBh(Common.getSearchLike(Common.convertEncoding(txtBHFind)));
			v12001.setPageIndex(pageIndex);
			v12001.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12001.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12001.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			v12001Bean = t12001Service.LoadAll(v12001);
			tabList = v12001Bean.getV12001List();
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
				pageIndex = 1;
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return INPUT;
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
		Pgt12001 t12001 = new Pgt12001();
		
		try {
			if(!Constant.MOD_CREATE.equals(getACT())){
				//读取选中的数据信息
				t12001.setSwid(Common.convertEncoding(txtSWIDFind));
				t12001Bean = t12001Service.LoadByPrimaryKey(t12001);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return INPUT;
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
		
		t12001Bean = new Pgt12001();
		this.clearErrorsAndMessages();
		if(Constant.MOD_UPDATE.equals(ACT))
			t12001Bean.setSwid(txtSWIDOLD);
		else
			t12001Bean.setSwid(txtSWID);
		//根據PK取得信息，並為數據BEAN賦值
		if(!Constant.MOD_DELETE.equals(getACT())){
			t12001Bean = t12001Service.LoadByPrimaryKey(t12001Bean);
			if(null==t12001Bean) t12001Bean = new Pgt12001();
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(getACT()))&&(!Common.isNullOrEmpty(t12001Bean.getSwid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.sjcj.t12001.swid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t12001Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t12001Bean.setBh(txtBH);
			t12001Bean.setCd00001Hy(txtHYId);
			t12001Bean.setCd00001Jjlx(txtJJLXId);
			t12001Bean.setCd00001Mssz(txtMSSZId);
			t12001Bean.setCd00001Ssgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t12001Bean.setCd00001Xz(txtXZId);
			t12001Bean.setCd00002Czr(sessionCtrl.getUserId());
			t12001Bean.setFcse(BigDecimal.valueOf(Common.convertToDouble(txtFCSE)));
			t12001Bean.setLrze(Common.convertToDouble(txtLRZE));
			t12001Bean.setLxdh(txtLXDH);
			t12001Bean.setNote(txtNOTE);
			t12001Bean.setNsrmc(txtNSRMC);
			t12001Bean.setSwid(txtSWID);
			t12001Bean.setSwidOld(txtSWIDOLD);
			t12001Bean.setTdse(BigDecimal.valueOf(Common.convertToDouble(txtTDSE)));
			t12001Bean.setZgy(txtZGY);
			t12001Bean.setZyywsr(Common.convertToDouble(txtZYYWSR));
			t12001Bean.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD) );
			t12001Bean.setBgsj(Common.convertToDate(txtBGSJ));
			t12001Bean.setBglx(Common.convertToInteger(ddlBGLX));
		}
		if(this.hasErrors())
			forward = false;
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** end **********");
		}
	}
	
	/**
	 * 更新信息處理
	 * @return
	 * @throws Exception
	 */
	public String update() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** start **********");
		}

		try {
			if(Constant.MOD_CREATE.equals(ACT)){			// Create
				if(t12001Service.GetInsertCommand(t12001Bean)){
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t12001Bean.getSwid()}));
					if(Common.checkNull(forward)) SWID = t12001Bean.getSwid();
					t12001Bean = null;
				}else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t12001Bean.getSwid()}));
			} else if (Constant.MOD_UPDATE.equals(ACT)) {	// Update
				if(t12001Service.GetUpdateCommand(t12001Bean)){
					t12001Bean = t12001Service.LoadByPrimaryKey(t12001Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{t12001Bean.getSwid()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{t12001Bean.getSwid()}));
			} else if (Constant.MOD_DELETE.equals(ACT)) {	// Delete
				if(t12001Service.GetDeleteCommand(t12001Bean)){
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t12001Bean.getSwid()}));
				}else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t12001Bean.getSwid()}));
			}			
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			LOG.error("update()", e);
			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			forward = false;
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		if (Constant.MOD_DELETE.equals(ACT)){
			ACT = Constant.MOD_MODIFY;
			return "successDEL";
		}else
			return SUCCESS;
	}

	/**
	 * 成本、收益法登记详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv12001 v12001 = new Pgv12001();
		v12001Bean = new Pgv12001();
		try {
			// 准备查询条件
			v12001.setSwid(Common.convertEncoding(SWID));
			// 执行查询
			v12001Bean = t12001Service.LoadDetail(v12001);
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
		
		Pgt12001 t12001 = new Pgt12001(); 
		try {
			t12001.setSwid(Common.convertEncoding(txtSWID));
			t12001Bean = t12001Service.LoadCount(t12001);
		} catch (Exception e) {
			LOG.error("queryCount()", e);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryCount() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @param t12001Service the t12001Service to set
	 */
	public void setT12001Service(IPgt12001Service t12001Service) {
		this.t12001Service = t12001Service;
	}

	/**
	 * @return the t12001Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12001Service getT12001Service() {
		return t12001Service;
	}
	
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
	 * @return the djxxList
	 */
	public ArrayList<Pgv12001> getTabList() {
		return tabList;
	}

	/**
	 * @param djxxList the djxxList to set
	 */
	public void setTabList(ArrayList<Pgv12001> tabList) {
		this.tabList = tabList;
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
	 * @return the txtBHFind
	 */
	public String getTxtBHFind() {
		return txtBHFind;
	}

	/**
	 * @param txtBHFind the txtBHFind to set
	 */
	public void setTxtBHFind(String txtBHFind) {
		this.txtBHFind = txtBHFind;
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
	 * @return the pageCount
	 */
	public Integer getPageCount() {
		return pageCount;
	}

	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
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
	 * @param t12001Bean the t12001Bean to set
	 */
	public void setT12001Bean(Pgt12001 t12001Bean) {
		this.t12001Bean = t12001Bean;
	}

	/**
	 * @return the t12001Bean
	 */
	public Pgt12001 getT12001Bean() {
		return t12001Bean;
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
	 * @return the txtZGY
	 */
	public String getTxtZGY() {
		return txtZGY;
	}

	/**
	 * @param txtZGY the txtZGY to set
	 */
	public void setTxtZGY(String txtZGY) {
		this.txtZGY = txtZGY;
	}

	/**
	 * @return the txtHYId
	 */
	public String getTxtHYId() {
		return txtHYId;
	}

	/**
	 * @param txtHYId the txtHYId to set
	 */
	public void setTxtHYId(String txtHYId) {
		this.txtHYId = txtHYId;
	}

	/**
	 * @return the txtJJLXId
	 */
	public String getTxtJJLXId() {
		return txtJJLXId;
	}

	/**
	 * @param txtJJLXId the txtJJLXId to set
	 */
	public void setTxtJJLXId(String txtJJLXId) {
		this.txtJJLXId = txtJJLXId;
	}

	/**
	 * @return the txtZYYWSR
	 */
	public String getTxtZYYWSR() {
		return txtZYYWSR;
	}

	/**
	 * @param txtZYYWSR the txtZYYWSR to set
	 */
	public void setTxtZYYWSR(String txtZYYWSR) {
		this.txtZYYWSR = txtZYYWSR;
	}

	/**
	 * @return the txtLRZE
	 */
	public String getTxtLRZE() {
		return txtLRZE;
	}

	/**
	 * @param txtLRZE the txtLRZE to set
	 */
	public void setTxtLRZE(String txtLRZE) {
		this.txtLRZE = txtLRZE;
	}

	/**
	 * @return the txtFCSE
	 */
	public String getTxtFCSE() {
		return txtFCSE;
	}

	/**
	 * @param txtFCSE the txtFCSE to set
	 */
	public void setTxtFCSE(String txtFCSE) {
		this.txtFCSE = txtFCSE;
	}

	/**
	 * @return the txtTDSE
	 */
	public String getTxtTDSE() {
		return txtTDSE;
	}

	/**
	 * @param txtTDSE the txtTDSE to set
	 */
	public void setTxtTDSE(String txtTDSE) {
		this.txtTDSE = txtTDSE;
	}

	/**
	 * @return the txtMSSZId
	 */
	public String getTxtMSSZId() {
		return txtMSSZId;
	}

	/**
	 * @param txtMSSZId the txtMSSZId to set
	 */
	public void setTxtMSSZId(String txtMSSZId) {
		this.txtMSSZId = txtMSSZId;
	}

	/**
	 * @return the txtBH
	 */
	public String getTxtBH() {
		return txtBH;
	}

	/**
	 * @param txtBH the txtBH to set
	 */
	public void setTxtBH(String txtBH) {
		this.txtBH = txtBH;
	}

	/**
	 * @return the txtXZId
	 */
	public String getTxtXZId() {
		return txtXZId;
	}

	/**
	 * @param txtXZId the txtXZId to set
	 */
	public void setTxtXZId(String txtXZId) {
		this.txtXZId = txtXZId;
	}

	/**
	 * @return the txtSSJCId
	 */
	public String getTxtSSJCId() {
		return txtSSJCId;
	}

	/**
	 * @param txtSSJCId the txtSSJCId to set
	 */
	public void setTxtSSJCId(String txtSSJCId) {
		this.txtSSJCId = txtSSJCId;
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
	 * @param v12001Bean the v12001Bean to set
	 */
	public void setV12001Bean(Pgv12001 v12001Bean) {
		this.v12001Bean = v12001Bean;
	}

	/**
	 * @return the v12001Bean
	 */
	public Pgv12001 getV12001Bean() {
		return v12001Bean;
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
	 * @param forward the forward to set
	 */
	public void setForward(Boolean forward) {
		this.forward = forward;
	}

	/**
	 * @return the forward
	 */
	public Boolean getForward() {
		return forward;
	}

	/**
	 * @param txtBGSJ the txtBGSJ to set
	 */
	public void setTxtBGSJ(String txtBGSJ) {
		this.txtBGSJ = txtBGSJ;
	}

	/**
	 * @return the txtBGSJ
	 */
	public String getTxtBGSJ() {
		return txtBGSJ;
	}

	/**
	 * @param txtSWIDOLD the txtSWIDOLD to set
	 */
	public void setTxtSWIDOLD(String txtSWIDOLD) {
		this.txtSWIDOLD = txtSWIDOLD;
	}

	/**
	 * @return the txtSWIDOLD
	 */
	public String getTxtSWIDOLD() {
		return txtSWIDOLD;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
