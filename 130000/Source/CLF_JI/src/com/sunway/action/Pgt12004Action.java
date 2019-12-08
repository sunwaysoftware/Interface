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
import com.sunway.service.IPgt12003Service;
import com.sunway.service.IPgt12004Service;
import com.sunway.service.IPgt12004bService;
import com.sunway.service.IPgt12004dService;
import com.sunway.service.IPgt12004eService;
import com.sunway.util.Common;
import com.sunway.util.Constant;
import com.sunway.util.SessionCtrl;
import com.sunway.vo.Pgt12003;
import com.sunway.vo.Pgt12004;
import com.sunway.vo.Pgt12004b;
import com.sunway.vo.Pgv12004;
import com.sunway.vo.Pgv12004d;
import com.sunway.vo.Pgv12004e;

/**
 * 
 * 成本法、收益法房产明细信息
 * @category 数据采集
 * @author Andy.Gao
 * @version 1.0
 *
 */
public class Pgt12004Action extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 3713458774136917929L;
	private IPgt12003Service t12003Service;
	private IPgt12004Service t12004Service;
	private IPgt12004dService t12004dService;
	private IPgt12004eService t12004eService;
	private IPgt12004bService t12004bService;
	private String ACT;
	
	// VIEW
	private Pgv12004 v12004Bean;
	private Integer pageIndex;
	private Integer pageCount;
	private Integer rowCount;
	private ArrayList<Pgv12004> tabList;
	private String txtSWIDFind;
	private String txtNSRMCFind;
	private String txtMXIDFind;
	
	// EDIT
	private Pgt12004 t12004Bean;	
	private ArrayList<Pgv12004e> qtxzCbList;
	private ArrayList<Pgv12004e> qtxzSyList;
	private ArrayList<Pgv12004d> fwssList;
	private String hidQTXZ;
	private String PIC;
	private String XZLXCB;
	private String XZLXSY;
	private String txtMXID;
	private String txtUPDATE;
	private String hidXZLXCB;
	private String hidXZLXSY;
	private String txtFCID;
	private String txtDCID;
	private String txtSWID;
	private String txtNSRMC;
	private String txtFDCMC;
	private String txtSZCC;
	private String txtBWJFH;
	private String txtJZJGId;
	private String txtFWYTId;
	private String txtYTJZMJ;
	private String txtFCYZ;
	private String txtXJBZId;
	private String txtFWCXId;
	private String txtGYTZJ;
	private String txtDDIDId;
	private String txtNOTE;
	private String txtCZRZJH;
	private String txtCZRMC;
	private String chkSFNSR;
	private String txtCZKSSJ;
	private String txtCZJSSJ;
	private String txtCZNOTE;	
	private String hidQTXZCB;
	private String hidQTXZSY;
	private String hidFWSS;
	private String txtSZQY;
	private String txtFWZLDZ;
	private String txtMSSZId;
	// Detail
	private String MXID;
	private String SWID;
	private Integer txtCOUNT;
	private String txtBGSJ;
	private String ddlBGLX;
	private Pgt12004b t12004bBean; 
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

		Pgv12004 v12004 = new Pgv12004();
		try {
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			//准備查詢條件
			v12004.setCd12001Swid(Common.getSearchLike(Common.convertEncoding(txtSWIDFind)));
			v12004.setNsrmc(Common.getSearchLike(Common.convertEncoding(txtNSRMCFind)));
			v12004.setMxid(Common.convertEncoding(txtMXIDFind));
			v12004.setPageIndex(pageIndex);
			v12004.setPageSize(Common.convertToInteger(sessionCtrl.Get(SessionCtrl.SESSION_KEY_DATASIZE)));
			v12004.setSysPssd(sessionCtrl.Get(SessionCtrl.SESSION_KEY_PSSD));
			v12004.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			//执行查询
			v12004Bean = t12004Service.LoadAll(v12004);
			tabList = v12004Bean.getV12004List();
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
		
		Pgt12004 t12004 = new Pgt12004();
		try {
			if(!Constant.MOD_CREATE.equals(ACT)){
				//读取选中的数据信息
				t12004.setMxid(txtMXIDFind);
				t12004Bean = t12004Service.LoadByPrimaryKey(t12004);
				Pgv12004e v12004e = new Pgv12004e();
				v12004e.setCd12004Mxid(t12004Bean.getMxid());
				v12004e.setXzlx(Common.convertToInteger(XZLXCB));
				qtxzCbList = t12004eService.LoadAll(v12004e);
				v12004e.setXzlx(Common.convertToInteger(XZLXSY));
				qtxzSyList = t12004eService.LoadAll(v12004e);
				Pgv12004d v12004d = new Pgv12004d();
				v12004d.setCd12004Mxid(txtMXIDFind);
				fwssList = t12004dService.LoadAll(v12004d);
				txtSZQY = t12004Bean.getCd00001Szqy();
				txtFWZLDZ = t12004Bean.getFwzldz();
			}else{
				if(!Common.isNullOrEmpty(txtFCID)){
					txtFCID = Common.convertEncoding(txtFCID);
					Pgt12003 t12003 = t12003Service.LoadByPrimaryKey(new Pgt12003(txtFCID));
					if(null != t12003){
						txtSWID = t12003.getCd12001Swid();
						txtDCID = t12003.getCd12002Dcid();
						txtNSRMC = t12003.getNsrmc();
						txtSZQY = t12003.getCd00001Szqy();
						txtFWZLDZ = t12003.getFwzldz();
						txtCOUNT = t12003.getCountMX();
					}
				}
			}
		} catch (Exception e) {
			this.addActionError(e.getMessage());
			if (LOG.isDebugEnabled()) {
				LOG.debug("create() ********** end **********");
			}			
			return ERROR;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("create() ********** end **********");
		}
		if (Common.isNullOrEmpty(t12004.getMxid()))
			return "successAdd";
		else
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
		
		this.clearErrorsAndMessages();
		t12004Bean = new Pgt12004();
		t12004Bean.setMxid(txtMXID);
		//根據PK取得信息，並為數據BEAN賦值
		if(!Constant.MOD_DELETE.equals(ACT)){
			t12004Bean = t12004Service.LoadByPrimaryKey(t12004Bean);
			if(null==t12004Bean) t12004Bean = new Pgt12004();
		}
		//判断PK是否重复
		if((Constant.MOD_CREATE.equals(ACT))&&(!Common.isNullOrEmpty(t12004Bean.getMxid()))){
			this.addActionError(getText("app.msg.error.pk", new String[]{getText("app.sjcj.t12004.mxid")}));
		}
		//判读数据是否已经被其他用户修改
		if((Constant.MOD_UPDATE.equals(getACT()))&&(!t12004Bean.getUpddate().equals(Common.convertStringToTimestamp(txtUPDATE)))) {
			this.addActionError(getText("app.msg.error.pktime"));
		}else{
			//sessionCtrl = new SessionCtrl(ActionContext.getContext().getSession());
			t12004Bean.setCd00002Czr(sessionCtrl.getUserId());
			t12004Bean.setSysSsgx(sessionCtrl.Get(SessionCtrl.SESSION_KEY_SSGX));
			t12004Bean.setBwjfh(txtBWJFH);
			t12004Bean.setCd00001Fwcx(txtFWCXId);
			t12004Bean.setCd00001Fwss(hidFWSS);
			t12004Bean.setCd00001Fwyt(txtFWYTId);
			t12004Bean.setCd00001Jzjg(txtJZJGId);
			t12004Bean.setCd00001Xjbz(txtXJBZId);
			t12004Bean.setCd12001Swid(txtSWID);
			t12004Bean.setCd12002Dcid(txtDCID);
			t12004Bean.setCd12003Fcid(txtFCID);
			t12004Bean.setCd12006Czrzjh(txtCZRZJH);
			t12004Bean.setCd12053Ddid(txtDDIDId);
			t12004Bean.setCzjssj(Common.convertToDate(txtCZJSSJ));
			t12004Bean.setCzkssj(Common.convertToDate(txtCZKSSJ));
			t12004Bean.setCzNote(txtCZNOTE);
			t12004Bean.setCzrmc(txtCZRMC);
			t12004Bean.setFcyz(BigDecimal.valueOf(Common.convertToDouble(txtFCYZ)));
			t12004Bean.setFdcmc(txtFDCMC);
			t12004Bean.setGytzj(BigDecimal.valueOf(Common.convertToDouble(txtGYTZJ)));
			t12004Bean.setMxid(txtMXID);
			t12004Bean.setNote(txtNOTE);
			t12004Bean.setQtxzCb(hidQTXZCB);
			t12004Bean.setQtxzSy(hidQTXZSY);
			t12004Bean.setSfnsr(Common.convertToBoolean(chkSFNSR));
			t12004Bean.setSzcc(txtSZCC);
			t12004Bean.setYtjzmj(Common.convertToDouble(txtYTJZMJ));
			t12004Bean.setBgsj(Common.convertToDate(txtBGSJ));
			t12004Bean.setBglx(Common.convertToInteger(ddlBGLX));
			//t12004Bean.setSfms(Common.convertToInteger(txtSFMS));
			t12004Bean.setCd00001Mssz(txtMSSZId);
		}
		
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
				txtMXID = t12004Service.LoadMaxMxId();
				t12004Bean.setMxid(txtMXID);			
				if(t12004Service.GetInsertCommand(t12004Bean)){
					this.addActionMessage(getText(Constant.MSG_CREATE_OK, new String[]{t12004Bean.getMxid()}));
					t12004Bean.clear();
				}else
					this.addActionError(getText(Constant.MSG_CREATE_NG, new String[]{t12004Bean.getMxid()}));
			} else if (Constant.MOD_UPDATE.equals(getACT())) {	// Update
				if(t12004Service.GetUpdateCommand(t12004Bean)){
					t12004Bean = t12004Service.LoadByPrimaryKey(t12004Bean);
					this.addActionMessage(getText(Constant.MSG_UPDATE_OK, new String[]{t12004Bean.getMxid()}));
				}else
					this.addActionError(getText(Constant.MSG_UPDATE_NG, new String[]{t12004Bean.getMxid()}));
			} else if (Constant.MOD_DELETE.equals(getACT())) {	// Delete
				if(t12004Service.GetDeleteCommand(t12004Bean)){
					this.addActionMessage(getText(Constant.MSG_DELETE_OK, new String[]{t12004Bean.getMxid()}));
				}else
					this.addActionError(getText(Constant.MSG_DELETE_NG, new String[]{t12004Bean.getMxid()}));
			}			
		} catch (Exception e) {
			this.addActionError(e.getMessage());

			if (LOG.isDebugEnabled()) {
				LOG.debug("update() ********** end **********");
			}
			return ERROR;
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
	 * 成本法、收益法房产明细详细信息
	 * @return
	 * @throws Exception
	 */
	public String detail() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detail() ********** start **********");
		}

		Pgv12004 v12004 = new Pgv12004();
		v12004Bean = new Pgv12004();
		Pgt12004b t12004b = new Pgt12004b();
		t12004bBean = new Pgt12004b();
		Pgv12004e v12004e = new Pgv12004e();
		qtxzCbList = new ArrayList<Pgv12004e>();
		qtxzSyList = new ArrayList<Pgv12004e>();
		Pgv12004d v12004d = new Pgv12004d();
		fwssList = new ArrayList<Pgv12004d>();
		try {
			// 准备查询条件
			v12004.setMxid(Common.convertEncoding(Common.trim(MXID)));
			t12004b.setCd12004Mxid(Common.convertEncoding(Common.trim(MXID)));
			// 执行查询
			v12004Bean = t12004Service.LoadDetail(v12004);
			t12004bBean = t12004bService.LoadByPrimaryKey(t12004b);
			v12004e.setCd12004Mxid(Common.convertEncoding(Common.trim(MXID)));
			v12004e.setXzlx(Common.convertToInteger(XZLXCB));
			qtxzCbList = t12004eService.LoadAll(v12004e);
			v12004e.setXzlx(Common.convertToInteger(XZLXSY));
			qtxzSyList = t12004eService.LoadAll(v12004e);
			v12004d.setCd12004Mxid(Common.convertEncoding(Common.trim(MXID)));
			fwssList = t12004dService.LoadAll(v12004d);
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
	 * 成本法、收益法房产明细详细信息（框架）
	 * @return
	 * @throws Exception
	 */
	public String detailFrame() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("detailFrame() ********** start **********");
		}
		v12004Bean = new Pgv12004();
		try {
			v12004Bean.setMxid(Common.trim(MXID));
			v12004Bean.setCd12001Swid(Common.trim(SWID));
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
	 * 獲得地段等级
	 * @return
	 * @throws Exception
	 */
	public String queryDD() throws Exception {
		if (LOG.isDebugEnabled()) {
			LOG.debug("queryDD() ********** start **********");
		}
		
		Pgv12004 v12004 = new Pgv12004(); 
		try {
			v12004.setCd00001Fwyt(Common.convertEncoding(txtFWYTId));
			v12004.setFwzldz(Common.convertEncoding(txtFWZLDZ));
			v12004.setCd00001Szqy(Common.convertEncoding(txtSZQY));
			v12004Bean = t12004Service.LoadDD(v12004);
		} catch (Exception e) {
			LOG.error("queryDD()", e);
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("queryDD() ********** end **********");
		}
		return SUCCESS;
	}
	
	/*********************** set and get ******************************/
	
	/**
	 * @return the t12004Service
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12004Service getT12004Service() {
		return t12004Service;
	}

	/**
	 * @param t12004Service the t12004Service to set
	 */
	public void setT12004Service(IPgt12004Service t12004Service) {
		this.t12004Service = t12004Service;
	}

	/**
	 * @param t12004dService the t12004dService to set
	 */
	public void setT12004dService(IPgt12004dService t12004dService) {
		this.t12004dService = t12004dService;
	}

	/**
	 * @return the t12004dService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12004dService getT12004dService() {
		return t12004dService;
	}	
	
	/**
	 * @return the t12004eService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12004eService getT12004eService() {
		return t12004eService;
	}

	/**
	 * @param t12004eService the t12004eService to set
	 */
	public void setT12004eService(IPgt12004eService t12004eService) {
		this.t12004eService = t12004eService;
	}

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
	 * @return the t12004bService
	 */
	@JSON(deserialize=false, serialize=false)
	public IPgt12004bService getT12004bService() {
		return t12004bService;
	}

	/**
	 * @param t12004bService the t12004bService to set
	 */
	public void setT12004bService(IPgt12004bService t12004bService) {
		this.t12004bService = t12004bService;
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
	 * @return the v12004Bean
	 */
	public Pgv12004 getV12004Bean() {
		return v12004Bean;
	}

	/**
	 * @param v12004Bean the v12004Bean to set
	 */
	public void setV12004Bean(Pgv12004 v12004Bean) {
		this.v12004Bean = v12004Bean;
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
	public ArrayList<Pgv12004> getTabList() {
		return tabList;
	}

	/**
	 * @param tabList the tabList to set
	 */
	public void setTabList(ArrayList<Pgv12004> tabList) {
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
	 * @return the txtMXIDFind
	 */
	public String getTxtMXIDFind() {
		return txtMXIDFind;
	}

	/**
	 * @param txtMXIDFind the txtMXIDFind to set
	 */
	public void setTxtMXIDFind(String txtMXIDFind) {
		this.txtMXIDFind = txtMXIDFind;
	}

	/**
	 * @return the t12004Bean
	 */
	public Pgt12004 getT12004Bean() {
		return t12004Bean;
	}

	/**
	 * @param t12004Bean the t12004Bean to set
	 */
	public void setT12004Bean(Pgt12004 t12004Bean) {
		this.t12004Bean = t12004Bean;
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
	 * @return the pIC
	 */
	public String getPIC() {
		return PIC;
	}

	/**
	 * @param pIC the pIC to set
	 */
	public void setPIC(String pIC) {
		PIC = pIC;
	}

	/**
	 * @return the xZLXCB
	 */
	public String getXZLXCB() {
		return XZLXCB;
	}

	/**
	 * @param xZLXCB the xZLXCB to set
	 */
	public void setXZLXCB(String xZLXCB) {
		XZLXCB = xZLXCB;
	}

	/**
	 * @return the xZLXSY
	 */
	public String getXZLXSY() {
		return XZLXSY;
	}

	/**
	 * @param xZLXSY the xZLXSY to set
	 */
	public void setXZLXSY(String xZLXSY) {
		XZLXSY = xZLXSY;
	}

	/**
	 * @return the qtxzCbList
	 */
	public ArrayList<Pgv12004e> getQtxzCbList() {
		return qtxzCbList;
	}

	/**
	 * @param qtxzCbList the qtxzCbList to set
	 */
	public void setQtxzCbList(ArrayList<Pgv12004e> qtxzCbList) {
		this.qtxzCbList = qtxzCbList;
	}

	/**
	 * @return the qtxzSyList
	 */
	public ArrayList<Pgv12004e> getQtxzSyList() {
		return qtxzSyList;
	}

	/**
	 * @param qtxzSyList the qtxzSyList to set
	 */
	public void setQtxzSyList(ArrayList<Pgv12004e> qtxzSyList) {
		this.qtxzSyList = qtxzSyList;
	}

	/**
	 * @return the fwssList
	 */
	public ArrayList<Pgv12004d> getFwssList() {
		return fwssList;
	}

	/**
	 * @param fwssList the fwssList to set
	 */
	public void setFwssList(ArrayList<Pgv12004d> fwssList) {
		this.fwssList = fwssList;
	}

	/**
	 * @return the txtMXID
	 */
	public String getTxtMXID() {
		return txtMXID;
	}

	/**
	 * @param txtMXID the txtMXID to set
	 */
	public void setTxtMXID(String txtMXID) {
		this.txtMXID = txtMXID;
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
	 * @return the hidXZLXCB
	 */
	public String getHidXZLXCB() {
		return hidXZLXCB;
	}

	/**
	 * @param hidXZLXCB the hidXZLXCB to set
	 */
	public void setHidXZLXCB(String hidXZLXCB) {
		this.hidXZLXCB = hidXZLXCB;
	}

	/**
	 * @return the hidXZLXSY
	 */
	public String getHidXZLXSY() {
		return hidXZLXSY;
	}

	/**
	 * @param hidXZLXSY the hidXZLXSY to set
	 */
	public void setHidXZLXSY(String hidXZLXSY) {
		this.hidXZLXSY = hidXZLXSY;
	}

	/**
	 * @return the txtFCID
	 */
	public String getTxtFCID() {
		return txtFCID;
	}

	/**
	 * @param txtFCID the txtFCID to set
	 */
	public void setTxtFCID(String txtFCID) {
		this.txtFCID = txtFCID;
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
	 * @return the txtSZCC
	 */
	public String getTxtSZCC() {
		return txtSZCC;
	}

	/**
	 * @param txtSZCC the txtSZCC to set
	 */
	public void setTxtSZCC(String txtSZCC) {
		this.txtSZCC = txtSZCC;
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
	 * @return the txtJZJGId
	 */
	public String getTxtJZJGId() {
		return txtJZJGId;
	}

	/**
	 * @param txtJZJGId the txtJZJGId to set
	 */
	public void setTxtJZJGId(String txtJZJGId) {
		this.txtJZJGId = txtJZJGId;
	}

	/**
	 * @return the txtFWYTId
	 */
	public String getTxtFWYTId() {
		return txtFWYTId;
	}

	/**
	 * @param txtFWYTId the txtFWYTId to set
	 */
	public void setTxtFWYTId(String txtFWYTId) {
		this.txtFWYTId = txtFWYTId;
	}

	/**
	 * @return the txtYTJZMJ
	 */
	public String getTxtYTJZMJ() {
		return txtYTJZMJ;
	}

	/**
	 * @param txtYTJZMJ the txtYTJZMJ to set
	 */
	public void setTxtYTJZMJ(String txtYTJZMJ) {
		this.txtYTJZMJ = txtYTJZMJ;
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
	 * @return the txtXJBZId
	 */
	public String getTxtXJBZId() {
		return txtXJBZId;
	}

	/**
	 * @param txtXJBZId the txtXJBZId to set
	 */
	public void setTxtXJBZId(String txtXJBZId) {
		this.txtXJBZId = txtXJBZId;
	}

	/**
	 * @return the txtFWCXId
	 */
	public String getTxtFWCXId() {
		return txtFWCXId;
	}

	/**
	 * @param txtFWCXId the txtFWCXId to set
	 */
	public void setTxtFWCXId(String txtFWCXId) {
		this.txtFWCXId = txtFWCXId;
	}

	/**
	 * @return the txtGYTZJ
	 */
	public String getTxtGYTZJ() {
		return txtGYTZJ;
	}

	/**
	 * @param txtGYTZJ the txtGYTZJ to set
	 */
	public void setTxtGYTZJ(String txtGYTZJ) {
		this.txtGYTZJ = txtGYTZJ;
	}

	/**
	 * @return the txtDDIDId
	 */
	public String getTxtDDIDId() {
		return txtDDIDId;
	}

	/**
	 * @param txtDDIDId the txtDDIDId to set
	 */
	public void setTxtDDIDId(String txtDDIDId) {
		this.txtDDIDId = txtDDIDId;
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
	 * @return the hidQTXZCB
	 */
	public String getHidQTXZCB() {
		return hidQTXZCB;
	}

	/**
	 * @param hidQTXZCB the hidQTXZCB to set
	 */
	public void setHidQTXZCB(String hidQTXZCB) {
		this.hidQTXZCB = hidQTXZCB;
	}

	/**
	 * @return the hidQTXZSY
	 */
	public String getHidQTXZSY() {
		return hidQTXZSY;
	}

	/**
	 * @param hidQTXZSY the hidQTXZSY to set
	 */
	public void setHidQTXZSY(String hidQTXZSY) {
		this.hidQTXZSY = hidQTXZSY;
	}

	/**
	 * @return the hidFWSS
	 */
	public String getHidFWSS() {
		return hidFWSS;
	}

	/**
	 * @param hidFWSS the hidFWSS to set
	 */
	public void setHidFWSS(String hidFWSS) {
		this.hidFWSS = hidFWSS;
	}

	/**
	 * @return the mXID
	 */
	public String getMXID() {
		return MXID;
	}

	/**
	 * @param mXID the mXID to set
	 */
	public void setMXID(String mXID) {
		MXID = mXID;
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
	 * @param txtNSRMC the txtNSRMC to set
	 */
	public void setTxtNSRMC(String txtNSRMC) {
		this.txtNSRMC = txtNSRMC;
	}

	/**
	 * @return the txtNSRMC
	 */
	public String getTxtNSRMC() {
		return txtNSRMC;
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
	 * @param txtFWZLDZ the txtFWZLDZ to set
	 */
	public void setTxtFWZLDZ(String txtFWZLDZ) {
		this.txtFWZLDZ = txtFWZLDZ;
	}

	/**
	 * @return the txtFWZLDZ
	 */
	public String getTxtFWZLDZ() {
		return txtFWZLDZ;
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

	/**
	 * @param txtMSSZId the txtMSSZId to set
	 */
	public void setTxtMSSZId(String txtMSSZId) {
		this.txtMSSZId = txtMSSZId;
	}

	/**
	 * @return the txtMSSZId
	 */
	public String getTxtMSSZId() {
		return txtMSSZId;
	}

	/**
	 * @return the t12004bBean
	 */
	public Pgt12004b getT12004bBean() {
		return t12004bBean;
	}

	/**
	 * @param t12004bBean the t12004bBean to set
	 */
	public void setT12004bBean(Pgt12004b t12004bBean) {
		this.t12004bBean = t12004bBean;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionCtrl.appSession = arg0;
	}

}
