/**
 * 
 */
package com.sunway.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.json.annotations.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.sunway.service.IPgt12002Service;
import com.sunway.service.IPgt12003Service;
import com.sunway.service.IPgt12003bService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12002;
import com.sunway.vo.Pgt12003;
import com.sunway.vo.Pgt12003b;
import com.sunway.vo.Pgv12003;

/**
 * 
 * 成本法、收益法房地产信息
 * @author Andy.Gao
 *
 */
public class Pgt12003Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -5329988900627669469L;
	private IPgt12002Service t12002Service;
	private IPgt12003Service t12003Service;
	private IPgt12003bService t12003bService;
	private String ACT;
	
	// VIEW
	private Pgv12003 v12003Bean;
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	private ArrayList<Pgv12003> tabList;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtFCIDFind;
	
	// EDIT
	private Pgt12003 t12003Bean;
	private String PIC;
	private String txtFCID;
	private String txtUPDATE;
	private String txtDCID;
	private String txtSWID;
	private String txtNSRMC;
	private String txtFDCMC;
	private String txtFWZLDZ;
	private String txtQDFSId;
	private String txtJCNF;
	private String txtFWZCS;
	private String txtDS;
	private String txtDX;
	private String txtZJZMJ;
	private String txtFCYZ;
	private String txtFWZJJE;
	private String txtFCZH;
	private String txtYSFCYZ;
	private String txtMSFCYZ;
	private String txtQDSJ;
	private String txtNOTE;
	private String txtCZRZJH;
	private String txtCZRMC;
	private String chkSFNSR;
	private String txtCZKSSJ;
	private String txtCZJSSJ;
	private String txtCZNOTE;
	// Detail
	private String FCID;
	private String SWID;
	private Pgt12003b t12003bBean; 
	// 跳轉地產標識
	private Boolean forward;
	private ArrayList<String> dataList;
	private String txtSZQY;
	private Integer txtCOUNT;
	private String txtBGSJ;
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

		Pgv12003 v12003 = new Pgv12003();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v12003.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12003.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12003.setFcid(Common.convertEncoding(txtFCIDFind));
			v12003.setPageIndex(pageIndex);
			v12003.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12003.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12003.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			v12003Bean = t12003Service.LoadAll(v12003);
			tabList = v12003Bean.getV12003List();
			//分页设置
			if(null!=tabList && tabList.size()>0){
				rowCount = Common.checkNull(tabList.get(0).getRecordCount());
				pageCount = Common.getPageCount(rowCount, sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE));
			} else {
				pageCount = 1;
				pageIndex = 1;
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("query() ********** end **********");
			}
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
		
		Pgt12003 t12003 = new Pgt12003();
		try {
			if(!Constant.MOD_CREATE.equals(ACT)){
				//读取选中的数据信息
				t12003.setFcid(txtFCIDFind);
				t12003Bean = t12003Service.LoadByPrimaryKey(t12003);
				txtSZQY = t12003Bean.getCd00001Szqy();
			}else{
				if(!Common.isNullOrEmpty(txtDCID)){
					txtDCID = Common.convertEncoding(txtDCID);
					Pgt12002 t12002 = t12002Service.LoadByPrimaryKey(new Pgt12002(txtDCID));
					if(null!=t12002){
						txtSWID =  t12002.getCd12001Swid();
					 	txtNSRMC = t12002.getNsrmc();
					 	txtSZQY = t12002.getCd00001Szqy();
					 	txtCOUNT = t12002.getCountFC();
					 	txtFWZLDZ = t12002.getTdzl();
					}
				}
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		if (Common.isNullOrEmpty(t12003.getFcid()))
			return "successAdd";
		else
			return SUCCESS;
	}
	
	/**
	 * 更新操作前的驗證處理
	 * @throws Exception
	 */
	/**
	 * @throws Exception
	 */
	public void validateUpdate() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("validateUpdate() ********** start **********");
		}

		this.clearErrorsAndMessages();
		t12003Bean = new Pgt12003();
		t12003Bean.setFcid(txtFCID);
		//根據PK取得信息，並為數據BEAN賦值
		if(!Constant.MOD_DELETE.equals(ACT)){
			Pgt12003 t12003 = t12003Service.LoadByPrimaryKey(t12003Bean); 
			if(null!=t12003) t12003Bean = t12003;
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(ACT))&&(!Common.isNullOrEmpty(t12003Bean.getFcid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.sjcj.t12003.fcid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t12003Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t12003Bean.setCd00001Qdfs(txtQDFSId);
			t12003Bean.setCd00002Czr(sessionCtrl.getUserId());
			t12003Bean.setCd12001Swid(txtSWID);
			t12003Bean.setCd12002Dcid(txtDCID);
			t12003Bean.setCd12006Czrzjh(txtCZRZJH);
			t12003Bean.setCzjssj(Common.convertToDate(txtCZJSSJ));
			t12003Bean.setCzkssj(Common.convertToDate(txtCZKSSJ));
			t12003Bean.setCzNote(txtCZNOTE);
			t12003Bean.setCzrmc(txtCZRMC);
			t12003Bean.setDs(Common.convertToShort(txtDS));
			t12003Bean.setDx(Common.convertToShort(txtDX));
			t12003Bean.setFcid(txtFCID);
			t12003Bean.setFcyz(BigDecimal.valueOf(Common.convertToDouble(txtFCYZ)));
			t12003Bean.setFczh(txtFCZH);
			t12003Bean.setFdcmc(txtFDCMC);
			t12003Bean.setFwzcs(Common.convertToShort(txtFWZCS));
			t12003Bean.setFwzjje(Common.convertToDouble(txtFWZJJE));
			t12003Bean.setFwzldz(txtFWZLDZ);
			t12003Bean.setJcnf(txtJCNF);
			t12003Bean.setMsfcyz(BigDecimal.valueOf(Common.convertToDouble(txtMSFCYZ)));
			t12003Bean.setNote(txtNOTE);
			t12003Bean.setQdsj(Common.convertToDate(txtQDSJ));
			t12003Bean.setSfnsr(Common.convertToBoolean(chkSFNSR));
			t12003Bean.setYsfcyz(BigDecimal.valueOf(Common.convertToDouble(txtYSFCYZ)));
			t12003Bean.setZjzmj(Common.convertToDouble(txtZJZMJ));
			t12003Bean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t12003Bean.setBgsj(Common.convertToDate(txtBGSJ));
			t12003Bean.setBglx(Common.convertToInteger(ddlBGLX));
		}
		if(hasErrors())
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
			if(Constant.MOD_CREATE.equals(getACT())){			// Create
				txtFCID = t12003Service.LoadMaxFcId();
				t12003Bean.setFcid(txtFCID);			
				if(t12003Service.GetInsertCommand(t12003Bean)){
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t12003Bean.getFcid()}));
					if(Common.checkNull(forward)) FCID = t12003Bean.getFcid();
					t12003Bean.clear();
				}else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t12003Bean.getFcid()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t12003Service.GetUpdateCommand(t12003Bean)){
					t12003Bean = t12003Service.LoadByPrimaryKey(t12003Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{t12003Bean.getFcid()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{t12003Bean.getFcid()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t12003Service.GetDeleteCommand(t12003Bean)){
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t12003Bean.getFcid()}));
				}else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t12003Bean.getFcid()}));
			}			
		} catch (Exception e) {
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			forward = false;
			return INPUT;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("update() ********** end **********");
		}
		
		if(Common.isNullOrEmpty(PIC))
			if (Constant.MOD_DELETE.equals(ACT)){
				ACT = Constant.MOD_MODIFY;
				return "successDEL";
			}else if(Constant.MOD_CREATE.equals(ACT))
				return "successADD";
			else
				return SUCCESS;
		else
			return "successPic";
	}	

	/**
	 * 成本法、收益法房地产详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}
		Pgv12003 v12003 = new Pgv12003();
		v12003Bean = new Pgv12003();
		Pgt12003b t12003b = new Pgt12003b();
		t12003bBean = new Pgt12003b();
		try {
			// 准备查询条件
			v12003.setFcid(Common.convertEncoding(Common.trim(FCID)));
			t12003b.setCd12003Fcid(Common.convertEncoding(Common.trim(FCID)));
			// 执行查询
			v12003Bean = t12003Service.LoadDetail(v12003);
			t12003bBean = t12003bService.LoadByPrimaryKey(t12003b);
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
	 * 成本法、收益法房地产详细信息（框架）
	 * @return
	 * @throws Exception
	 */
	public String detailFrame() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detailFrame() ********** start **********");
		}
		v12003Bean = new Pgv12003();
		try {
			v12003Bean.setFcid(Common.trim(FCID));
			v12003Bean.setCd12001Swid(Common.trim(SWID));
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			return ERROR;
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("detailFrame() ********** end **********");
		}
		return SUCCESS;
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryFWZLDZ() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryFWZLDZ() ********** start **********");
		}

		Pgv12003 v12003 = new Pgv12003();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			HttpServletRequest request = ServletActionContext.getRequest();
			txtFWZLDZ = Common.convertEncoding(request.getParameter("q"));
			if(!Common.isNullOrEmpty(txtSZQY)){
				v12003.setPageIndex(1);
				v12003.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
				v12003.setCd00001Szqy(txtSZQY);
				v12003.setFwzldz(Common.getSearchLike(txtFWZLDZ));
				dataList = t12003Service.LoadFWZLDZ(v12003);
			}
		} catch (Exception e) {
			LOG.error("queryFWZLDZ()", e);
		}	
		
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryFWZLDZ() ********** end **********");
		}
		return SUCCESS;
	}
	
	/**
	 * 判断房產证书号是否已经存在
	 * @return
	 * @throws Exception
	 */
	public String queryFCZH() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryFCZH() ********** start **********");
		}

		try {
			forward = t12003Service.GetFczhByFcid(new Pgt12003(Common.convertEncoding(txtFCID),Common.convertEncoding(txtFCZH)));
		} catch (Exception e) {
			LOG.error("queryFCZH()", e);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryFCZH() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/

	/**
	 * @param t12003Service the t12003Service to set
	 */
	public void setT12003Service(IPgt12003Service t12003Service) {
		this.t12003Service = t12003Service;
	}

	/**
	 * @return the t12003Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12003Service getT12003Service() {
		return t12003Service;
	}

	/**
	 * @param t12002Service the t12002Service to set
	 */
	public void setT12002Service(IPgt12002Service t12002Service) {
		this.t12002Service = t12002Service;
	}

	/**
	 * @return the t12002Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12002Service getT12002Service() {
		return t12002Service;
	}

	/**
	 * @return the t12003bService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12003bService getT12003bService() {
		return t12003bService;
	}

	/**
	 * @param t12003bService the t12003bService to set
	 */
	public void setT12003bService(IPgt12003bService t12003bService) {
		this.t12003bService = t12003bService;
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
	 * @return the v12003Bean
	 */
	public Pgv12003 getV12003Bean() {
		return v12003Bean;
	}

	/**
	 * @param v12003Bean the v12003Bean to set
	 */
	public void setV12003Bean(Pgv12003 v12003Bean) {
		this.v12003Bean = v12003Bean;
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
	 * @return the tabList
	 */
	public ArrayList<Pgv12003> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12003> tabList) {
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
	 * @param t12003Bean the t12003Bean to set
	 */
	public void setT12003Bean(Pgt12003 t12003Bean) {
		this.t12003Bean = t12003Bean;
	}

	/**
	 * @return the t12003Bean
	 */
	public Pgt12003 getT12003Bean() {
		return t12003Bean;
	}

	/**
	 * @param pIC the pIC to set
	 */
	public void setPIC(String pIC) {
		PIC = pIC;
	}

	/**
	 * @return the pIC
	 */
	public String getPIC() {
		return PIC;
	}

	/**
	 * @param txtFCID the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
	}

	/**
	 * @return the txtFCID
	 */
	public String getTxtFCID() {
		return txtFCID;
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
	 * @return the txtDCID
	 */
	public String getTxtDCID() {
		return txtDCID;
	}

	/**
	 * @param txtDCID the txtDCID to set
	 */
	public void setTxtDCID(String txtDCID) {
		this.txtDCID = txtDCID;
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
	 * @return the txtFDCMC
	 */
	public String getTxtFDCMC() {
		return txtFDCMC;
	}

	/**
	 * @param txtFDCMC the txtFDCMC to set
	 */
	public void setTxtFDCMC(String txtFDCMC) {
		this.txtFDCMC = txtFDCMC;
	}

	/**
	 * @return the txtFWZLDZ
	 */
	public String getTxtFWZLDZ() {
		return txtFWZLDZ;
	}

	/**
	 * @param txtFWZLDZ the txtFWZLDZ to set
	 */
	public void setTxtFWZLDZ(String txtFWZLDZ) {
		this.txtFWZLDZ = txtFWZLDZ;
	}

	/**
	 * @return the txtQDFSId
	 */
	public String getTxtQDFSId() {
		return txtQDFSId;
	}

	/**
	 * @param txtQDFSId the txtQDFSId to set
	 */
	public void setTxtQDFSId(String txtQDFSId) {
		this.txtQDFSId = txtQDFSId;
	}

	/**
	 * @return the txtJCNF
	 */
	public String getTxtJCNF() {
		return txtJCNF;
	}

	/**
	 * @param txtJCNF the txtJCNF to set
	 */
	public void setTxtJCNF(String txtJCNF) {
		this.txtJCNF = txtJCNF;
	}

	/**
	 * @return the txtFWZCS
	 */
	public String getTxtFWZCS() {
		return txtFWZCS;
	}

	/**
	 * @param txtFWZCS the txtFWZCS to set
	 */
	public void setTxtFWZCS(String txtFWZCS) {
		this.txtFWZCS = txtFWZCS;
	}

	/**
	 * @return the txtDS
	 */
	public String getTxtDS() {
		return txtDS;
	}

	/**
	 * @param txtDS the txtDS to set
	 */
	public void setTxtDS(String txtDS) {
		this.txtDS = txtDS;
	}

	/**
	 * @return the txtDX
	 */
	public String getTxtDX() {
		return txtDX;
	}

	/**
	 * @param txtDX the txtDX to set
	 */
	public void setTxtDX(String txtDX) {
		this.txtDX = txtDX;
	}

	/**
	 * @return the txtZJZMJ
	 */
	public String getTxtZJZMJ() {
		return txtZJZMJ;
	}

	/**
	 * @param txtZJZMJ the txtZJZMJ to set
	 */
	public void setTxtZJZMJ(String txtZJZMJ) {
		this.txtZJZMJ = txtZJZMJ;
	}

	/**
	 * @return the txtFCYZ
	 */
	public String getTxtFCYZ() {
		return txtFCYZ;
	}

	/**
	 * @param txtFCYZ the txtFCYZ to set
	 */
	public void setTxtFCYZ(String txtFCYZ) {
		this.txtFCYZ = txtFCYZ;
	}

	/**
	 * @return the txtFWZJJE
	 */
	public String getTxtFWZJJE() {
		return txtFWZJJE;
	}

	/**
	 * @param txtFWZJJE the txtFWZJJE to set
	 */
	public void setTxtFWZJJE(String txtFWZJJE) {
		this.txtFWZJJE = txtFWZJJE;
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
	 * @return the txtYSFCYZ
	 */
	public String getTxtYSFCYZ() {
		return txtYSFCYZ;
	}

	/**
	 * @param txtYSFCYZ the txtYSFCYZ to set
	 */
	public void setTxtYSFCYZ(String txtYSFCYZ) {
		this.txtYSFCYZ = txtYSFCYZ;
	}

	/**
	 * @return the txtMSFCYZ
	 */
	public String getTxtMSFCYZ() {
		return txtMSFCYZ;
	}

	/**
	 * @param txtMSFCYZ the txtMSFCYZ to set
	 */
	public void setTxtMSFCYZ(String txtMSFCYZ) {
		this.txtMSFCYZ = txtMSFCYZ;
	}

	/**
	 * @return the txtQDSJ
	 */
	public String getTxtQDSJ() {
		return txtQDSJ;
	}

	/**
	 * @param txtQDSJ the txtQDSJ to set
	 */
	public void setTxtQDSJ(String txtQDSJ) {
		this.txtQDSJ = txtQDSJ;
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
	 * @return the txtCZRZJH
	 */
	public String getTxtCZRZJH() {
		return txtCZRZJH;
	}

	/**
	 * @param txtCZRZJH the txtCZRZJH to set
	 */
	public void setTxtCZRZJH(String txtCZRZJH) {
		this.txtCZRZJH = txtCZRZJH;
	}

	/**
	 * @return the txtCZRMC
	 */
	public String getTxtCZRMC() {
		return txtCZRMC;
	}

	/**
	 * @param txtCZRMC the txtCZRMC to set
	 */
	public void setTxtCZRMC(String txtCZRMC) {
		this.txtCZRMC = txtCZRMC;
	}

	/**
	 * @return the chkSFNSR
	 */
	public String getChkSFNSR() {
		return chkSFNSR;
	}

	/**
	 * @param chkSFNSR the chkSFNSR to set
	 */
	public void setChkSFNSR(String chkSFNSR) {
		this.chkSFNSR = chkSFNSR;
	}

	/**
	 * @return the txtCZKSSJ
	 */
	public String getTxtCZKSSJ() {
		return txtCZKSSJ;
	}

	/**
	 * @param txtCZKSSJ the txtCZKSSJ to set
	 */
	public void setTxtCZKSSJ(String txtCZKSSJ) {
		this.txtCZKSSJ = txtCZKSSJ;
	}

	/**
	 * @return the txtCZJSSJ
	 */
	public String getTxtCZJSSJ() {
		return txtCZJSSJ;
	}

	/**
	 * @param txtCZJSSJ the txtCZJSSJ to set
	 */
	public void setTxtCZJSSJ(String txtCZJSSJ) {
		this.txtCZJSSJ = txtCZJSSJ;
	}

	/**
	 * @return the txtCZNOTE
	 */
	public String getTxtCZNOTE() {
		return txtCZNOTE;
	}

	/**
	 * @param txtCZNOTE the txtCZNOTE to set
	 */
	public void setTxtCZNOTE(String txtCZNOTE) {
		this.txtCZNOTE = txtCZNOTE;
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
	 * @return the t12003bBean
	 */
	public Pgt12003b getT12003bBean() {
		return t12003bBean;
	}

	/**
	 * @param t12003bBean the t12003bBean to set
	 */
	public void setT12003bBean(Pgt12003b t12003bBean) {
		this.t12003bBean = t12003bBean;
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
	 * @param dataList the dataList to set
	 */
	public void setDataList(ArrayList<String> dataList) {
		this.dataList = dataList;
	}

	/**
	 * @return the dataList
	 */
	public ArrayList<String> getDataList() {
		return dataList;
	}

	/**
	 * @param txtSZQY the txtSZQY to set
	 */
	public void setTxtSZQY(String txtSZQY) {
		this.txtSZQY = txtSZQY;
	}

	/**
	 * @return the txtSZQY
	 */
	public String getTxtSZQY() {
		return txtSZQY;
	}

	/**
	 * @param txtCOUNT the txtCOUNT to set
	 */
	public void setTxtCOUNT(Integer txtCOUNT) {
		this.txtCOUNT = txtCOUNT;
	}

	/**
	 * @return the txtCOUNT
	 */
	public Integer getTxtCOUNT() {
		return txtCOUNT;
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
